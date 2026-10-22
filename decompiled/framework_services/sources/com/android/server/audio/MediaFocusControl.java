package com.android.server.audio;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusInfo;
import android.media.AudioManager;
import android.media.IAudioFocusDispatcher;
import android.media.MediaMetrics;
import android.media.audiopolicy.IAudioPolicyCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import com.android.server.SysOptBridge;
import com.android.server.am.IApplicationFreezer;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class MediaFocusControl implements PlayerFocusEnforcer {
    static final boolean DEBUG = false;
    static final int DUCKING_IN_APP_SDK_LEVEL = 25;
    static final boolean ENFORCE_DUCKING = true;
    static final boolean ENFORCE_DUCKING_FOR_NEW = true;
    static final boolean ENFORCE_FADEOUT_FOR_FOCUS_LOSS = true;
    static final boolean ENFORCE_MUTING_FOR_RING_OR_CALL = true;
    private static final int MAX_STACK_SIZE = 100;
    private static final int MSG_L_FOCUS_LOSS_AFTER_FADE = 1;
    private static final int MSL_L_FORGET_UID = 2;
    private static final int RING_CALL_MUTING_ENFORCEMENT_DELAY_MS = 100;
    private static final String TAG = "MediaFocusControl";
    private static final int[] USAGES_TO_MUTE_IN_RING_OR_CALL = null;
    private static final Object mAudioFocusLock = null;
    private static final EventLogger mEventLogger = null;
    private static final String mMetricsId = "audio.focus";
    private final AppOpsManager mAppOps;
    private final Context mContext;
    private long mExtFocusChangeCounter;
    private final Object mExtFocusChangeLock;
    private MediaFocusControlExt mFocusControlExt;
    private final PlayerFocusEnforcer mFocusEnforcer;
    private ArrayList<IAudioPolicyCallback> mFocusFollowers;
    private int[] mFocusFreezeExemptUids;
    private IBinder.DeathRecipient mFocusFreezerDeathHandler;
    private IBinder mFocusFreezerForTest;
    private Handler mFocusHandler;
    private HashMap<String, FocusRequester> mFocusOwnersForFocusPolicy;
    private IAudioPolicyCallback mFocusPolicy;
    private final Stack<FocusRequester> mFocusStack;
    private HandlerThread mFocusThread;
    private boolean mMultiAudioFocusEnabled;
    ArrayList<FocusRequester> mMultiAudioFocusList;
    private boolean mNotifyFocusOwnerOnDuck;
    private IAudioPolicyCallback mPreviousFocusPolicy;
    private boolean mRingOrCallActive;

    protected class AudioFocusDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        final /* synthetic */ MediaFocusControl this$0;

        AudioFocusDeathHandler(MediaFocusControl this$0, IBinder cb) {
            this.this$0 = this$0;
            this.mCb = cb;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = MediaFocusControl.m2158$$Nest$sfgetmAudioFocusLock();
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (MediaFocusControl.m2149$$Nest$fgetmFocusPolicy(this.this$0) == null) goto L9;
            MediaFocusControl.m2155$$Nest$mremoveFocusEntryForExtPolicyOnDeath(this.this$0, this.mCb);     // Catch: Throwable -> L7
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            MediaFocusControl.m2156$$Nest$mremoveFocusStackEntryOnDeath(this.this$0, this.mCb);     // Catch: Throwable -> L7
            if (MediaFocusControl.m2151$$Nest$fgetmMultiAudioFocusEnabled(this.this$0) == false) goto L20;
            if (this.this$0.mMultiAudioFocusList.isEmpty() == true) goto L20;
            Iterator<FocusRequester> listIterator = this.this$0.mMultiAudioFocusList.iterator();     // Catch: Throwable -> L7
        L15:
            if (listIterator.hasNext() == false) goto L20;
            FocusRequester fr = listIterator.next();     // Catch: Throwable -> L7
            if (fr.hasSameBinder(this.mCb) == false) goto L15;
            listIterator.remove();     // Catch: Throwable -> L7
            fr.release();     // Catch: Throwable -> L7
            goto L15
        }
    }

    private static final class ForgetFadeUidInfo {
        private final int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2159$$Nest$fgetmUid(ForgetFadeUidInfo r0) {
            return r0.mUid;
        }

        ForgetFadeUidInfo(int uid) {
            this.mUid = uid;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L14:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L14;
            ForgetFadeUidInfo f = (ForgetFadeUidInfo) o;
            if (f.mUid == this.mUid) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.mUid;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFocusControlExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaFocusControlExt m2147$$Nest$fgetmFocusControlExt(MediaFocusControl r0) {
        return r0.mFocusControlExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFocusEnforcer, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlayerFocusEnforcer m2148$$Nest$fgetmFocusEnforcer(MediaFocusControl r0) {
        return r0.mFocusEnforcer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFocusPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAudioPolicyCallback m2149$$Nest$fgetmFocusPolicy(MediaFocusControl r0) {
        return r0.mFocusPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFocusStack, reason: not valid java name */
    static /* bridge */ /* synthetic */ Stack m2150$$Nest$fgetmFocusStack(MediaFocusControl r0) {
        return r0.mFocusStack;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMultiAudioFocusEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2151$$Nest$fgetmMultiAudioFocusEnabled(MediaFocusControl r0) {
        return r0.mMultiAudioFocusEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRingOrCallActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2152$$Nest$fgetmRingOrCallActive(MediaFocusControl r0) {
        return r0.mRingOrCallActive;
    }

    /* JADX INFO: renamed from: -$$Nest$mpostForgetUidLater, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2153$$Nest$mpostForgetUidLater(MediaFocusControl r0, FocusRequester r1) {
        r0.postForgetUidLater(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseFocusFreeze, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2154$$Nest$mreleaseFocusFreeze(MediaFocusControl r0) {
        r0.releaseFocusFreeze();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveFocusEntryForExtPolicyOnDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2155$$Nest$mremoveFocusEntryForExtPolicyOnDeath(MediaFocusControl r0, IBinder r1) {
        r0.removeFocusEntryForExtPolicyOnDeath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveFocusStackEntryOnDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2156$$Nest$mremoveFocusStackEntryOnDeath(MediaFocusControl r0, IBinder r1) {
        r0.removeFocusStackEntryOnDeath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetUSAGES_TO_MUTE_IN_RING_OR_CALL, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m2157$$Nest$sfgetUSAGES_TO_MUTE_IN_RING_OR_CALL() {
        return USAGES_TO_MUTE_IN_RING_OR_CALL;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmAudioFocusLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2158$$Nest$sfgetmAudioFocusLock() {
        return mAudioFocusLock;
    }

    protected MediaFocusControl(Context cntxt, PlayerFocusEnforcer pfe) {
        boolean r0 = false;
        this.mMultiAudioFocusEnabled = false;
        this.mRingOrCallActive = false;
        this.mExtFocusChangeLock = new Object();
        this.mFocusStack = new Stack();
        this.mMultiAudioFocusList = new ArrayList();
        this.mNotifyFocusOwnerOnDuck = true;
        this.mFocusFollowers = new ArrayList();
        this.mFocusPolicy = null;
        this.mPreviousFocusPolicy = null;
        this.mFocusOwnersForFocusPolicy = new HashMap();
        this.mFocusFreezerForTest = null;
        this.mFocusFreezerDeathHandler = null;
        this.mFocusFreezeExemptUids = null;
        this.mContext = cntxt;
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService("appops");
        this.mFocusEnforcer = pfe;
        ContentResolver cr = this.mContext.getContentResolver();
        if (Settings.System.getIntForUser(cr, "multi_audio_focus_enabled", 0, cr.getUserId()) == 0) goto L5;
        r0 = true;
    L5:
        this.mMultiAudioFocusEnabled = r0;
        initFocusThreading();
        this.mFocusControlExt = MediaFocusControlExt.get(this);
        this.mFocusControlExt.init_onEnd(this.mContext, this.mFocusStack, mAudioFocusLock, this.mFocusHandler);
    }

    protected void dump(PrintWriter pw) {
        pw.println("\nMediaFocusControl dump time: " + DateFormat.getTimeInstance().format(new Date()));
        dumpFocusStack(pw);
        pw.println("\n");
        mEventLogger.dump(pw);
        dumpMultiAudioFocus(pw);
    }

    public long getFocusFadeOutDurationForTest() {
        return getFadeOutDurationMillis(new AudioAttributes.Builder().setUsage(1).build());
    }

    public long getFocusUnmuteDelayAfterFadeOutForTest() {
        return getFadeInDelayForOffendersMillis(new AudioAttributes.Builder().setUsage(1).build());
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean duckPlayers(FocusRequester winner, FocusRequester loser, boolean forceDuck) {
        return this.mFocusEnforcer.duckPlayers(winner, loser, forceDuck);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void restoreVShapedPlayers(FocusRequester winner) {
        this.mFocusEnforcer.restoreVShapedPlayers(winner);
        this.mFocusHandler.removeEqualMessages(2, new ForgetFadeUidInfo(winner.getClientUid()));
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void mutePlayersForCall(int[] usagesToMute) {
        this.mFocusEnforcer.mutePlayersForCall(usagesToMute);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void unmutePlayersForCall() {
        this.mFocusEnforcer.unmutePlayersForCall();
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean fadeOutPlayers(FocusRequester winner, FocusRequester loser) {
        return this.mFocusEnforcer.fadeOutPlayers(winner, loser);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void forgetUid(int uid) {
        this.mFocusEnforcer.forgetUid(uid);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public long getFadeOutDurationMillis(AudioAttributes aa) {
        if (aa != null) goto L6;
        return 0;
    L6:
        return this.mFocusEnforcer.getFadeOutDurationMillis(aa);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public long getFadeInDelayForOffendersMillis(AudioAttributes aa) {
        if (aa != null) goto L6;
        return 0;
    L6:
        return this.mFocusEnforcer.getFadeInDelayForOffendersMillis(aa);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean shouldEnforceFade() {
        return this.mFocusEnforcer.shouldEnforceFade();
    }

    static {
        mAudioFocusLock = new Object();
        mEventLogger = new EventLogger(50, "focus commands as seen by MediaFocusControl");
        USAGES_TO_MUTE_IN_RING_OR_CALL = new int[]{1, 14};
    }

    void noFocusForSuspendedApp(String packageName, int uid) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        Iterator<FocusRequester> stackIterator = this.mFocusStack.iterator();     // Catch: Throwable -> L12
        List<String> clientsToRemove = new ArrayList();     // Catch: Throwable -> L12
    L6:
        if (stackIterator.hasNext() == false) goto L15;
        FocusRequester focusOwner = stackIterator.next();     // Catch: Throwable -> L12
        if (focusOwner.hasSameUid(uid) == false) goto L6;
        if (focusOwner.hasSamePackage(packageName) == false) goto L6;
        clientsToRemove.add(focusOwner.getClientId());     // Catch: Throwable -> L12
        focusOwner.dispatchFocusChange(-1, "app suspension");     // Catch: Throwable -> L12
        goto L6
    L15:
        Iterator<String> r3 = clientsToRemove.iterator();     // Catch: Throwable -> L12
    L17:
        if (r3.hasNext() == false) goto L19;
        String clientToRemove = r3.next();     // Catch: Throwable -> L12
        removeFocusStackEntry(clientToRemove, false, true);     // Catch: Throwable -> L12
        goto L17
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    boolean hasAudioFocusUsers() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusStack.empty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    protected boolean maybeDiscardAudioFocusOwner() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusStack.empty() == true) goto L15;
        FocusRequester exFocusOwner = this.mFocusStack.peek();     // Catch: Throwable -> L11
        if (exFocusOwner.isAlwaysVisibleUser() == true) goto L13;
        this.mFocusStack.pop();     // Catch: Throwable -> L11
        exFocusOwner.handleFocusLoss(-1, null, false);     // Catch: Throwable -> L11
        exFocusOwner.release();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    }

    protected void sendFocusLossAndUpdate(AudioFocusInfo focusInfo) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusStack.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        FocusRequester currentFocusOwner = this.mFocusStack.peek();     // Catch: Throwable -> L8
        if (currentFocusOwner.toAudioFocusInfo().equals(focusInfo) == false) goto L15;
        currentFocusOwner.handleFocusLoss(-1, null, false);     // Catch: Throwable -> L8
        currentFocusOwner.release();     // Catch: Throwable -> L8
        this.mFocusStack.pop();     // Catch: Throwable -> L8
        if (this.mFocusStack.isEmpty() == true) goto L16;
        this.mFocusStack.peek().handleFocusGain(1);     // Catch: Throwable -> L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        sendFocusLoss(focusInfo);     // Catch: Throwable -> L8
        goto L16
    }

    List<AudioFocusInfo> getFocusStack() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        ArrayList<AudioFocusInfo> stack = new ArrayList(this.mFocusStack.size());     // Catch: Throwable -> L8
        Iterator<FocusRequester> r2 = this.mFocusStack.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        FocusRequester fr = r2.next();     // Catch: Throwable -> L8
        stack.add(fr.toAudioFocusInfo());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return stack;
    L8:
        th = move-exception;
        throw th;
    }

    protected int getExclusiveFocusOwnerUid() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusStack.empty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L10:
        FocusRequester owner = this.mFocusStack.peek();     // Catch: Throwable -> L8
        if (owner.getGainRequest() == 4) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L14:
        int r2 = owner.getClientUid();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    }

    boolean sendFocusLoss(AudioFocusInfo focusLoser) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        FocusRequester loserToRemove = null;
        Iterator<FocusRequester> r2 = this.mFocusStack.iterator();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L14;
        FocusRequester fr = r2.next();     // Catch: Throwable -> L11
        if (fr.getClientId().equals(focusLoser.getClientId()) == false) goto L7;
        fr.handleFocusLoss(-1, null, false);     // Catch: Throwable -> L11
        loserToRemove = fr;
    L14:
        if (loserToRemove == null) goto L20;
        this.mFocusStack.remove(loserToRemove);     // Catch: Throwable -> L11
        loserToRemove.release();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private void notifyTopOfAudioFocusStack() {
        if (this.mFocusStack.empty() == true) goto L8;
        if (canReassignAudioFocus() == false) goto L8;
        this.mFocusStack.peek().handleFocusGain(1);
    L8:
        if (this.mMultiAudioFocusEnabled == true) goto L10;
        return;
    L10:
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L24;
        Iterator<FocusRequester> r0 = this.mMultiAudioFocusList.iterator();
    L13:
        if (r0.hasNext() == false) goto L25;
        FocusRequester multifr = r0.next();
        if (isLockedFocusOwner(multifr) == false) goto L13;
        multifr.handleFocusGain(1);
        goto L13
    L25:
        return;
    }

    private void propagateFocusLossFromGain_syncAf(int focusGain, FocusRequester fr, boolean forceDuck) {
        List<String> clientsToRemove = new LinkedList();
        if (this.mFocusStack.empty() == true) goto L12;
        Iterator<FocusRequester> r1 = this.mFocusStack.iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        FocusRequester focusLoser = r1.next();
        boolean isDefinitiveLoss = focusLoser.handleFocusLossFromGain(focusGain, fr, forceDuck);
        if (isDefinitiveLoss == false) goto L6;
        clientsToRemove.add(focusLoser.getClientId());
    L12:
        if (this.mMultiAudioFocusEnabled == true) goto L14;
    L22:
        Iterator<String> r2 = clientsToRemove.iterator();
    L24:
        if (r2.hasNext() == false) goto L26;
        String clientToRemove = r2.next();
        removeFocusStackEntry(clientToRemove, false, true);
        goto L24
    L26:
        return;
    L14:
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L22;
        Iterator<FocusRequester> r3 = this.mMultiAudioFocusList.iterator();
    L17:
        if (r3.hasNext() == false) goto L22;
        FocusRequester multifocusLoser = r3.next();
        boolean isDefinitiveLoss2 = multifocusLoser.handleFocusLossFromGain(focusGain, fr, forceDuck);
        if (isDefinitiveLoss2 == false) goto L17;
        clientsToRemove.add(multifocusLoser.getClientId());
        goto L17
    }

    private void dumpFocusStack(PrintWriter pw) {
        pw.println("\nAudio Focus stack entries (last is top of stack):");
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        Iterator<FocusRequester> stackIterator = this.mFocusStack.iterator();     // Catch: Throwable -> L8
    L6:
        if (stackIterator.hasNext() == false) goto L10;
        stackIterator.next().dump(pw);     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println("\n");     // Catch: Throwable -> L8
        if (this.mFocusPolicy != null) goto L13;
        pw.println("No external focus policy\n");     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        pw.println("\n");
        pw.println(" Notify on duck:  " + this.mNotifyFocusOwnerOnDuck + "\n");
        pw.println(" In ring or call: " + this.mRingOrCallActive + "\n");
        return;
    L13:
        pw.println("External focus policy: " + this.mFocusPolicy + ", focus owners:\n");     // Catch: Throwable -> L8
        dumpExtFocusPolicyFocusOwners(pw);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void removeFocusStackEntry(String clientToRemove, boolean signal, boolean notifyFocusFollowers) {
        AudioFocusInfo abandonSource = null;
        if (this.mFocusStack.empty() == false) goto L5;
    L12:
        Iterator<FocusRequester> stackIterator = this.mFocusStack.iterator();
    L14:
        if (stackIterator.hasNext() == false) goto L22;
        FocusRequester fr = stackIterator.next();
        if (fr.hasSameClient(clientToRemove) == false) goto L14;
        Log.i(TAG, "AudioFocus  removeFocusStackEntry(): removing entry for " + clientToRemove);
        stackIterator.remove();
        if (notifyFocusFollowers == false) goto L20;
        abandonSource = fr.toAudioFocusInfo();
    L20:
        fr.maybeRelease();
    L22:
        if (abandonSource == null) goto L25;
        abandonSource.clearLossReceived();
        notifyExtPolicyFocusLoss_syncAf(abandonSource, false);
    L25:
        if (this.mMultiAudioFocusEnabled == true) goto L27;
        return;
    L27:
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L49;
        Iterator<FocusRequester> listIterator = this.mMultiAudioFocusList.iterator();
    L30:
        if (listIterator.hasNext() == false) goto L35;
        FocusRequester fr2 = listIterator.next();
        if (fr2.hasSameClient(clientToRemove) == false) goto L30;
        listIterator.remove();
        fr2.release();
        goto L30
    L35:
        if (signal == false) goto L50;
        notifyTopOfAudioFocusStack();
        return;
    L50:
        return;
    L49:
        return;
    L5:
        if (this.mFocusStack.peek().hasSameClient(clientToRemove) == false) goto L12;
        FocusRequester fr3 = this.mFocusStack.pop();
        fr3.maybeRelease();
        if (notifyFocusFollowers == false) goto L9;
        abandonSource = fr3.toAudioFocusInfo();
    L9:
        if (signal == false) goto L22;
        notifyTopOfAudioFocusStack();
        goto L22
    }

    private void removeFocusStackEntryOnDeath(IBinder cb) {
        if (this.mFocusStack.isEmpty() == false) goto L5;
    L7:
        boolean isTopOfStackForClientToRemove = false;
    L8:
        Iterator<FocusRequester> stackIterator = this.mFocusStack.iterator();
    L10:
        if (stackIterator.hasNext() == false) goto L15;
        FocusRequester fr = stackIterator.next();
        if (fr.hasSameBinder(cb) == false) goto L10;
        Log.i(TAG, "AudioFocus  removeFocusStackEntryOnDeath(): removing entry for " + cb);
        mEventLogger.enqueue(new FocusRequester.FocusRequestEvent(fr, " died"));
        notifyExtPolicyFocusLoss_syncAf(fr.toAudioFocusInfo(), false);
        stackIterator.remove();
        fr.release();
        goto L10
    L15:
        if (isTopOfStackForClientToRemove == false) goto L23;
        notifyTopOfAudioFocusStack();
        return;
    L23:
        return;
    L5:
        if (this.mFocusStack.peek().hasSameBinder(cb) == false) goto L7;
        isTopOfStackForClientToRemove = true;
        goto L8
    }

    private void removeFocusEntryForExtPolicyOnDeath(IBinder cb) {
        if (this.mFocusOwnersForFocusPolicy.isEmpty() == false) goto L5;
        return;
    L5:
        Set<Map.Entry<String, FocusRequester>> owners = this.mFocusOwnersForFocusPolicy.entrySet();
        Iterator<Map.Entry<String, FocusRequester>> ownerIterator = owners.iterator();
    L7:
        if (ownerIterator.hasNext() == false) goto L16;
        Map.Entry<String, FocusRequester> owner = ownerIterator.next();
        FocusRequester fr = owner.getValue();
        if (fr.hasSameBinder(cb) == false) goto L7;
        ownerIterator.remove();
        mEventLogger.enqueue(new FocusRequester.FocusRequestEvent(fr, "died"));
        fr.release();
        notifyExtFocusPolicyFocusAbandon_syncAf(fr.toAudioFocusInfo());
        return;
    }

    private boolean canReassignAudioFocus() {
        if (this.mFocusStack.isEmpty() == false) goto L5;
        return true;
    L5:
        if (isLockedFocusOwner(this.mFocusStack.peek()) == false) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isLockedFocusOwner(FocusRequester fr) {
        if (fr.hasSameClient("AudioFocus_For_Phone_Ring_And_Calls") == false) goto L5;
    L8:
        return true;
    L5:
        if (fr.isLockedFocusOwner() == true) goto L8;
        return false;
    }

    private int pushBelowLockedFocusOwnersAndPropagate(FocusRequester nfr) {
        int lastLockedFocusOwnerIndex = this.mFocusStack.size();
        int index = this.mFocusStack.size() - 1;
    L3:
        if (index < 0) goto L9;
        if (isLockedFocusOwner(this.mFocusStack.elementAt(index)) == false) goto L7;
        lastLockedFocusOwnerIndex = index;
    L7:
        index = index - 1;
        goto L3
    L9:
        if (lastLockedFocusOwnerIndex != this.mFocusStack.size()) goto L12;
        Log.e(TAG, "No exclusive focus owner found in propagateFocusLossFromGain_syncAf()", new Exception());
        propagateFocusLossFromGain_syncAf(nfr.getGainRequest(), nfr, false);
        this.mFocusStack.push(nfr);
        return 1;
    L12:
        this.mFocusStack.insertElementAt(nfr, lastLockedFocusOwnerIndex);
        List<String> clientsToRemove = new LinkedList();
        int index2 = lastLockedFocusOwnerIndex - 1;
    L13:
        if (index2 < 0) goto L18;
        boolean isDefinitiveLoss = this.mFocusStack.elementAt(index2).handleFocusLossFromGain(nfr.getGainRequest(), nfr, false);
        if (isDefinitiveLoss == false) goto L17;
        clientsToRemove.add(this.mFocusStack.elementAt(index2).getClientId());
    L17:
        index2 = index2 - 1;
        goto L13
    L18:
        Iterator<String> r4 = clientsToRemove.iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        String clientToRemove = r4.next();
        removeFocusStackEntry(clientToRemove, false, true);
        goto L20
    L22:
        return 2;
    }

    protected void setDuckingInExtPolicyAvailable(boolean available) {
        this.mNotifyFocusOwnerOnDuck = !available;
    }

    boolean mustNotifyFocusOwnerOnDuck() {
        return this.mNotifyFocusOwnerOnDuck;
    }

    void addFocusFollower(IAudioPolicyCallback ff) {
        if (ff != null) goto L4;
        return;
    L4:
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        boolean found = false;
        Iterator<IAudioPolicyCallback> r2 = this.mFocusFollowers.iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L16;
        IAudioPolicyCallback pcb = r2.next();     // Catch: Throwable -> L14
        if (pcb.asBinder().equals(ff.asBinder()) == false) goto L9;
        found = true;
    L16:
        if (found == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L19:
        this.mFocusFollowers.add(ff);     // Catch: Throwable -> L14
        notifyExtPolicyCurrentFocusAsync(ff);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void removeFocusFollower(IAudioPolicyCallback ff) {
        if (ff != null) goto L4;
        return;
    L4:
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        Iterator<IAudioPolicyCallback> r1 = this.mFocusFollowers.iterator();     // Catch: Throwable -> L12
    L8:
        if (r1.hasNext() == false) goto L15;
        IAudioPolicyCallback pcb = r1.next();     // Catch: Throwable -> L12
        if (pcb.asBinder().equals(ff.asBinder()) == false) goto L8;
        this.mFocusFollowers.remove(pcb);     // Catch: Throwable -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void setFocusPolicy(IAudioPolicyCallback policy, boolean isTestFocusPolicy) {
        if (policy != null) goto L4;
        return;
    L4:
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        if (isTestFocusPolicy == true) goto L15;
    L10:
        this.mFocusPolicy = policy;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L15:
        this.mPreviousFocusPolicy = this.mFocusPolicy;     // Catch: Throwable -> L8
        goto L10
    }

    void unsetFocusPolicy(IAudioPolicyCallback policy, boolean isTestFocusPolicy) {
        if (policy != null) goto L4;
        return;
    L4:
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mFocusPolicy != policy) goto L13;
        if (isTestFocusPolicy == false) goto L12;
        this.mFocusPolicy = this.mPreviousFocusPolicy;     // Catch: Throwable -> L10
        goto L13
    L12:
        this.mFocusPolicy = null;     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void notifyExtPolicyCurrentFocusAsync(final IAudioPolicyCallback pcb) {
        Thread thread = new AnonymousClass1(this, pcb);
        thread.start();
    }

    void notifyExtPolicyFocusGrant_syncAf(AudioFocusInfo afi, int requestResult) {
        Iterator<IAudioPolicyCallback> r0 = this.mFocusFollowers.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IAudioPolicyCallback pcb = r0.next();
        pcb.notifyAudioFocusGrant(afi, requestResult);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "Can't call notifyAudioFocusGrant() on IAudioPolicyCallback " + pcb.asBinder(), e);
        goto L4
    }

    void notifyExtPolicyFocusLoss_syncAf(AudioFocusInfo afi, boolean wasDispatched) {
        Iterator<IAudioPolicyCallback> r0 = this.mFocusFollowers.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IAudioPolicyCallback pcb = r0.next();
        pcb.notifyAudioFocusLoss(afi, wasDispatched);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "Can't call notifyAudioFocusLoss() on IAudioPolicyCallback " + pcb.asBinder(), e);
        goto L4
    }

    boolean notifyExtFocusPolicyFocusRequest_syncAf(AudioFocusInfo afi, IAudioFocusDispatcher fd, IBinder cb) {
        Object r1 = this.mExtFocusChangeLock;
        monitor-enter(r1);
        long r2 = this.mExtFocusChangeCounter;     // Catch: Throwable -> L27
        this.mExtFocusChangeCounter = 1 + r2;     // Catch: Throwable -> L27
        afi.setGen(r2);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        FocusRequester existingFr = this.mFocusOwnersForFocusPolicy.get(afi.getClientId());
        if (existingFr != null) goto L9;
        boolean keepTrack = true;
    L14:
        if (keepTrack == false) goto L21;
        AudioFocusDeathHandler hdlr = new AudioFocusDeathHandler(this, cb);
        cb.linkToDeath(hdlr, 0);     // Catch: RemoteException -> L18
        MediaFocusControl r9 = this;
        AudioFocusInfo afi2 = afi;
        this.mFocusOwnersForFocusPolicy.put(afi.getClientId(), new FocusRequester(afi2, fd, cb, hdlr, r9, mEventLogger));
    L37:
        r9.mFocusPolicy.notifyAudioFocusRequest(afi2, 1);     // Catch: RemoteException -> L24
        return true;
    L24:
        e = move-exception;
        Log.e(TAG, "Can't call notifyAudioFocusRequest() on IAudioPolicyCallback " + r9.mFocusPolicy.asBinder(), e);
        return false;
    L20:
        return false;
    L21:
        r9 = this;
        afi2 = afi;
        goto L37
    L9:
        if (existingFr.hasSameDispatcher(fd) == true) goto L11;
        existingFr.release();
        keepTrack = true;
        goto L14
    L11:
        keepTrack = false;
    L27:
        th = th;
    L39:
        throw th;
    L31:
        th = th;
        goto L39
    }

    void setFocusRequestResultFromExtPolicy(AudioFocusInfo afi, int requestResult) {
        Object r0 = this.mExtFocusChangeLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (afi.getGen() <= this.mExtFocusChangeCounter) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Object r1 = mAudioFocusLock;
        monitor-enter(r1);
        String r2 = afi.getClientId();     // Catch: Throwable -> L20
        if (requestResult != 0) goto L16;
        boolean r3 = true;
    L17:
        FocusRequester fr = getFocusRequesterLocked(r2, r3);     // Catch: Throwable -> L20
        if (fr == null) goto L22;
        fr.dispatchFocusResultFromExtPolicy(requestResult);     // Catch: Throwable -> L20
        fr.handleFocusGainFromRequest(requestResult);     // Catch: Throwable -> L20
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L16:
        r3 = false;
    L20:
        th = move-exception;
        throw th;
    }

    boolean notifyExtFocusPolicyFocusAbandon_syncAf(AudioFocusInfo afi) {
        if (this.mFocusPolicy != null) goto L6;
        return false;
    L6:
        FocusRequester fr = this.mFocusOwnersForFocusPolicy.remove(afi.getClientId());
        if (fr == null) goto L15;
        fr.release();
    L15:
        this.mFocusPolicy.notifyAudioFocusAbandon(afi);     // Catch: RemoteException -> L11
        return true;
    L11:
        e = move-exception;
        Log.e(TAG, "Can't call notifyAudioFocusAbandon() on IAudioPolicyCallback " + this.mFocusPolicy.asBinder(), e);
        return true;
    }

    int dispatchFocusChange(AudioFocusInfo afi, int focusChange) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        String r1 = afi.getClientId();     // Catch: Throwable -> L12
        if (focusChange != (-1)) goto L7;
        boolean r2 = true;
    L8:
        FocusRequester fr = getFocusRequesterLocked(r1, r2);     // Catch: Throwable -> L12
        if (fr != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0;
    L14:
        int r3 = fr.dispatchFocusChange(focusChange, "audiomanager");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L7:
        r2 = false;
    L12:
        th = move-exception;
        throw th;
    }

    int dispatchFocusChangeWithFade(AudioFocusInfo afi, int focusChange, List<AudioFocusInfo> otherActiveAfis) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        String clientId = afi.getClientId();     // Catch: Throwable -> L8
        FocusRequester fr = getFocusRequesterLocked(clientId, false);     // Catch: Throwable -> L8
        if (fr != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L10:
        ArrayList<FocusRequester> otherActiveFrs = new ArrayList();     // Catch: Throwable -> L8
        int index = 0;
    L12:
        if (index >= otherActiveAfis.size()) goto L18;
        FocusRequester otherFr = getFocusRequesterLocked(otherActiveAfis.get(index).getClientId(), false);     // Catch: Throwable -> L8
        if (otherFr == null) goto L17;
        otherActiveFrs.add(otherFr);     // Catch: Throwable -> L8
    L17:
        index = index + 1;     // Catch: Throwable -> L8
        goto L12
    L18:
        int status = fr.dispatchFocusChangeWithFadeLocked(focusChange, otherActiveFrs);     // Catch: Throwable -> L8
        if (status != 2) goto L21;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return status;
    L21:
        if (focusChange != (-1)) goto L23;
        this.mFocusOwnersForFocusPolicy.remove(clientId);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private FocusRequester getFocusRequesterLocked(String clientId, boolean shouldRemove) {
        if (this.mFocusPolicy != null) goto L6;
        return null;
    L6:
        if (shouldRemove == false) goto L8;
        FocusRequester fr = this.mFocusOwnersForFocusPolicy.remove(clientId);
        return fr;
    L8:
        FocusRequester fr2 = this.mFocusOwnersForFocusPolicy.get(clientId);
        return fr2;
    }

    private void dumpExtFocusPolicyFocusOwners(PrintWriter pw) {
        Set<Map.Entry<String, FocusRequester>> owners = this.mFocusOwnersForFocusPolicy.entrySet();
        Iterator<Map.Entry<String, FocusRequester>> ownerIterator = owners.iterator();
    L4:
        if (ownerIterator.hasNext() == false) goto L6;
        Map.Entry<String, FocusRequester> owner = ownerIterator.next();
        FocusRequester fr = owner.getValue();
        fr.dump(pw);
        goto L4
    }

    protected int getCurrentAudioFocus() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusStack.empty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        int r1 = this.mFocusStack.peek().getGainRequest();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    protected static int getFocusRampTimeMs(int focusGain, AudioAttributes attr) {
        switch(attr.getUsage()) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L8;
            case 14: goto L10;
            case 16: goto L6;
            case 1002: goto L8;
            case 1003: goto L6;
            case 1004: goto L10;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 700;
    L8:
        return 500;
    L10:
        return 1000;
    }

    /* JADX WARN: Failed to calculate best type for var: r23v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  ??, new type: com.android.server.audio.MediaFocusControl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r23v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  ??, new type: com.android.server.audio.MediaFocusControl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  com.android.server.audio.MediaFocusControl, new type: com.android.server.audio.MediaFocusControl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    protected int requestAudioFocus(AudioAttributes aa, int focusChangeHint, IBinder cb, IAudioFocusDispatcher fd, String clientId, String callingPackageName, int flags, int sdk, boolean forceDuck, int testUid, boolean permissionOverridesCheck) {
        String r6 = clientId;
        new MediaMetrics.Item(mMetricsId).setUid(Binder.getCallingUid()).set(MediaMetrics.Property.CALLING_PACKAGE, callingPackageName).set(MediaMetrics.Property.CLIENT_NAME, r6).set(MediaMetrics.Property.EVENT, "requestAudioFocus").set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags)).set(MediaMetrics.Property.FOCUS_CHANGE_HINT, AudioManager.audioFocusToString(focusChangeHint)).record();
        this.mFocusControlExt.requestAudioFocus_onBegin(aa, focusChangeHint, cb, fd, r6, callingPackageName, flags, sdk, forceDuck, testUid, permissionOverridesCheck);
        if (flags != 8) goto L5;
        int uid = testUid;
    L6:
        mEventLogger.enqueue(new EventLogger.StringEvent("requestAudioFocus() from uid/pid " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid() + " AA=" + aa.usageToString() + SliceClientPermissions.SliceAuthority.DELIMITER + aa.contentTypeToString() + " clientId=" + r6 + " callingPack=" + callingPackageName + " req=" + focusChangeHint + " flags=0x" + Integer.toHexString(flags) + " sdk=" + sdk).printLog(TAG));
        if (AudioAttributes.toLegacyStreamType(aa) != 3) goto L10;
        SysOptBridge.getFactory().getApplicationFreezer().notifyAudioFocusGain(callingPackageName, uid, false);
        SysOptBridge.getFactory().getApplicationFreezer().unfreezePackage(callingPackageName, IApplicationFreezer.UnfreezeReason.NEED_AUDIO_FOCUSED);
    L10:
        if (cb.pingBinder() == true) goto L13;
        Log.e(TAG, " AudioFocus DOA client for requestAudioFocus(), aborting.");
        return 0;
    L13:
        Object r15 = mAudioFocusLock;
        monitor-enter(r15);
    L107:
        e = th;
    L141:
        monitor-exit(r15);     // Catch: Throwable -> L107
        throw e;
    L54:
        e = th;
        goto L141
    L16:
        if (isFocusFrozenForTest() == false) goto L31;
        if ((flags & 8) != 8) goto L145;
        int focusRequesterUid = testUid;
    L22:
        if (isFocusFrozenForTestForUid(focusRequesterUid) == false) goto L28;
        Log.i(TAG, "requestAudioFocus: focus frozen for test for uid:" + focusRequesterUid);     // Catch: Throwable -> L26
        monitor-exit(r15);     // Catch: Throwable -> L26
        return 0;
    L28:
        Log.i(TAG, "requestAudioFocus: focus frozen for test but uid:" + focusRequesterUid + " is exempt");     // Catch: Throwable -> L26
        goto L31
    L145:
        focusRequesterUid = Binder.getCallingUid();     // Catch: Throwable -> L26
    L26:
        e = th;
    L31:
        if (this.mFocusStack.size() <= 100) goto L36;
        Log.e(TAG, "Max AudioFocus stack size reached, failing requestAudioFocus()");     // Catch: Throwable -> L26
        monitor-exit(r15);     // Catch: Throwable -> L26
        return 0;
    L36:
        if (this.mRingOrCallActive == true) goto L38;
        boolean r0 = true;
    L40:
        if ("AudioFocus_For_Phone_Ring_And_Calls".compareTo(r6) != 0) goto L42;
        boolean r2 = true;
    L43:
        boolean enteringRingOrCall = r0 & r2;
        if (enteringRingOrCall == false) goto L47;
        this.mRingOrCallActive = true;     // Catch: Throwable -> L26
    L47:
        if (this.mFocusPolicy == null) goto L57;
        int uid2 = uid;
        r6 = clientId;
        AudioFocusInfo afiForExtPolicy = new AudioFocusInfo(aa, uid2, clientId, callingPackageName, focusChangeHint, 0, flags, sdk);     // Catch: Throwable -> L52
    L152:
    L65:
        e = th;
        goto L141
    L60:
        if (canReassignAudioFocus() == false) goto L62;
        boolean focusGrantDelayed = false;
    L70:
        if (this.mFocusPolicy != null) goto L72;
        AudioFocusDeathHandler afdh = new AudioFocusDeathHandler(this, cb);     // Catch: Throwable -> L65
        cb.linkToDeath(afdh, 0);     // Catch: Throwable -> L65 RemoteException -> L137
        goto L138
    L81:
        if (this.mFocusStack.empty() == false) goto L83;
    L93:
        removeFocusStackEntry(r6, false, false);     // Catch: Throwable -> L65
        FocusRequester nfr = new FocusRequester(aa, focusChangeHint, flags, fd, cb, r6, afdh, callingPackageName, uid2, this, sdk, mEventLogger);     // Catch: Throwable -> L135
        if (this.mMultiAudioFocusEnabled == false) goto L124;
        if (focusChangeHint != 1) goto L124;
        if (enteringRingOrCall == true) goto L102;
        boolean needAdd = true;
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L119;
        Iterator<FocusRequester> r4 = this.mMultiAudioFocusList.iterator();     // Catch: Throwable -> L107
    L114:
        if (r4.hasNext() == false) goto L119;
        FocusRequester multifr = r4.next();     // Catch: Throwable -> L107
        if (multifr.getClientUid() != Binder.getCallingUid()) goto L114;
        needAdd = false;
    L119:
        if (needAdd == false) goto L121;
        this.mMultiAudioFocusList.add(nfr);     // Catch: Throwable -> L107
    L121:
        nfr.handleFocusGainFromRequest(1);     // Catch: Throwable -> L107
        notifyExtPolicyFocusGrant_syncAf(nfr.toAudioFocusInfo(), 1);     // Catch: Throwable -> L107
        monitor-exit(r15);     // Catch: Throwable -> L107
        return 1;
    L102:
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L124;
        Iterator<FocusRequester> r3 = this.mMultiAudioFocusList.iterator();     // Catch: Throwable -> L107
    L105:
        if (r3.hasNext() == false) goto L124;
        FocusRequester multifr2 = r3.next();     // Catch: Throwable -> L107
        multifr2.handleFocusLossFromGain(focusChangeHint, nfr, forceDuck);     // Catch: Throwable -> L107
    L124:
        if (focusGrantDelayed == false) goto L130;
        int requestResult = pushBelowLockedFocusOwnersAndPropagate(nfr);     // Catch: Throwable -> L107
        if (requestResult == 0) goto L128;
        notifyExtPolicyFocusGrant_syncAf(nfr.toAudioFocusInfo(), requestResult);     // Catch: Throwable -> L107
    L128:
        monitor-exit(r15);     // Catch: Throwable -> L107
        return requestResult;
    L130:
        propagateFocusLossFromGain_syncAf(focusChangeHint, nfr, forceDuck);     // Catch: Throwable -> L107
        this.mFocusStack.push(nfr);     // Catch: Throwable -> L107
        nfr.handleFocusGainFromRequest(1);     // Catch: Throwable -> L107
        notifyExtPolicyFocusGrant_syncAf(nfr.toAudioFocusInfo(), 1);     // Catch: Throwable -> L107
        if ((enteringRingOrCall & true) == false) goto L133;
        runAudioCheckerForRingOrCallAsync(true);     // Catch: Throwable -> L107
    L133:
        monitor-exit(r15);     // Catch: Throwable -> L107
        return 1;
    L135:
        e = th;
        goto L141
    L83:
        if (this.mFocusStack.peek().hasSameClient(r6) == false) goto L93;
        FocusRequester fr = this.mFocusStack.peek();     // Catch: Throwable -> L65
        if (fr.getGainRequest() == focusChangeHint) goto L87;
    L91:
        if (focusGrantDelayed == true) goto L93;
        this.mFocusStack.pop();     // Catch: Throwable -> L65
        fr.release();     // Catch: Throwable -> L65
        goto L93
    L87:
        if (fr.getGrantFlags() != flags) goto L91;
        cb.unlinkToDeath(afdh, 0);     // Catch: Throwable -> L65
        notifyExtPolicyFocusGrant_syncAf(fr.toAudioFocusInfo(), r1);     // Catch: Throwable -> L65
        monitor-exit(r15);     // Catch: Throwable -> L65
        return r1;
    L138:
        Log.w(TAG, "AudioFocus  requestAudioFocus() could not link to " + cb + " binder death");     // Catch: Throwable -> L107
        return 0;
    L72:
        if (notifyExtFocusPolicyFocusRequest_syncAf(afiForExtPolicy, fd, cb) == false) goto L75;
        monitor-exit(r15);     // Catch: Throwable -> L65
        return 100;
    L75:
        monitor-exit(r15);     // Catch: Throwable -> L65
        return 0;
    L62:
        if ((flags & 1) != 0) goto L67;
        monitor-exit(r15);     // Catch: Throwable -> L65
        return 0;
    L67:
        focusGrantDelayed = true;
    L52:
        e = th;
        goto L141
    L57:
        uid2 = uid;
        afiForExtPolicy = null;
        goto L152
    L42:
        r2 = false;
        goto L43
    L38:
        r0 = false;
        goto L40
    L5:
        uid = Binder.getCallingUid();
        goto L6
    }

    protected int abandonAudioFocus(IAudioFocusDispatcher fl, String clientId, AudioAttributes aa, String callingPackageName) {
        if (this.mFocusControlExt.abandonAudioFocus_onBegin(fl, clientId, aa, callingPackageName) == false) goto L5;
        return 1;
    L5:
        new MediaMetrics.Item(mMetricsId).setUid(Binder.getCallingUid()).set(MediaMetrics.Property.CALLING_PACKAGE, callingPackageName).set(MediaMetrics.Property.CLIENT_NAME, clientId).set(MediaMetrics.Property.EVENT, "abandonAudioFocus").record();
        mEventLogger.enqueue(new EventLogger.StringEvent("abandonAudioFocus() from uid/pid " + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid() + " clientId=" + clientId + " callingPack=" + callingPackageName).printLog(TAG));
        Object r10 = mAudioFocusLock;     // Catch: ConcurrentModificationException -> L30
        monitor-enter(r10);     // Catch: ConcurrentModificationException -> L30
    L14:
        th = move-exception;
        throw th;     // Catch: ConcurrentModificationException -> L30
    L9:
        if (this.mFocusPolicy == null) goto L16;
        AudioFocusInfo afi = new AudioFocusInfo(aa, Binder.getCallingUid(), clientId, callingPackageName, 0, 0, 0, 0);     // Catch: Throwable -> L14
        if (notifyExtFocusPolicyFocusAbandon_syncAf(afi) == false) goto L16;
        monitor-exit(r10);     // Catch: Throwable -> L14
        return 1;
    L16:
        boolean r0 = this.mRingOrCallActive;     // Catch: Throwable -> L14
        if ("AudioFocus_For_Phone_Ring_And_Calls".compareTo(clientId) != 0) goto L19;
        boolean r1 = true;
    L20:
        boolean exitingRingOrCall = r0 & r1;     // Catch: Throwable -> L14
        if (exitingRingOrCall == false) goto L23;
        this.mRingOrCallActive = false;     // Catch: Throwable -> L14
    L23:
        removeFocusStackEntry(clientId, true, true);     // Catch: Throwable -> L14
        if ((exitingRingOrCall & true) == false) goto L26;
        runAudioCheckerForRingOrCallAsync(false);     // Catch: Throwable -> L14
    L26:
        monitor-exit(r10);     // Catch: Throwable -> L14
    L32:
        return 1;
    L19:
        r1 = false;
    L30:
        cme = move-exception;
        Log.e(TAG, "FATAL EXCEPTION AudioFocus  abandonAudioFocus() caused " + cme);
        cme.printStackTrace();
        goto L32
    }

    private boolean isFocusFrozenForTest() {
        if (this.mFocusFreezerForTest == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFocusFrozenForTestForUid(int uidToCheck) {
        if (isFocusFrozenForTest() == false) goto L5;
        return false;
    L5:
        int[] r0 = this.mFocusFreezeExemptUids;
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        int uid = r0[r3];
        if (uid == uidToCheck) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    protected boolean enterAudioFocusFreezeForTest(IBinder cb, int[] exemptedUids) {
        Log.i(TAG, "enterAudioFocusFreezeForTest UIDs exempt:" + Arrays.toString(exemptedUids));
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusFreezerForTest == null) goto L22;
        Log.e(TAG, "Error enterAudioFocusFreezeForTest: focus already frozen");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L22:
        this.mFocusFreezerDeathHandler = new AnonymousClass2(this);     // Catch: Throwable -> L9 RemoteException -> L15
        cb.linkToDeath(this.mFocusFreezerDeathHandler, 0);     // Catch: Throwable -> L9 RemoteException -> L15
        this.mFocusFreezerForTest = cb;     // Catch: Throwable -> L9 RemoteException -> L15
        this.mFocusFreezeExemptUids = (int[]) exemptedUids.clone();     // Catch: Throwable -> L9 RemoteException -> L15
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L16:
        this.mFocusFreezerForTest = null;     // Catch: Throwable -> L9
        this.mFocusFreezeExemptUids = null;     // Catch: Throwable -> L9
        return false;
    }

    protected boolean exitAudioFocusFreezeForTest(IBinder cb) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusFreezerForTest == cb) goto L15;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L9
        r3.append("Error exitAudioFocusFreezeForTest: ");     // Catch: Throwable -> L9
        if (this.mFocusFreezerForTest != null) goto L11;
        String r4 = "call to exit while not frozen";
    L12:
        r3.append(r4);     // Catch: Throwable -> L9
        Log.e(TAG, r3.toString());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        r4 = "call to exit not coming from freeze owner";
        goto L12
    L15:
        this.mFocusFreezerForTest.unlinkToDeath(this.mFocusFreezerDeathHandler, 0);     // Catch: Throwable -> L9
        releaseFocusFreeze();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    }

    private void releaseFocusFreeze() {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        this.mFocusFreezerDeathHandler = null;     // Catch: Throwable -> L8
        this.mFocusFreezeExemptUids = null;     // Catch: Throwable -> L8
        this.mFocusFreezerForTest = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected void unregisterAudioFocusClient(String clientId) {
        Object r0 = mAudioFocusLock;
        monitor-enter(r0);
        removeFocusStackEntry(clientId, false, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void runAudioCheckerForRingOrCallAsync(final boolean enteringRingOrCall) {
        new AnonymousClass3(this, enteringRingOrCall).start();
    }

    public void updateMultiAudioFocus(boolean r7) {
        Log.d(TAG, "updateMultiAudioFocus( " + r7 + " )");
        this.mMultiAudioFocusEnabled = r7;
        ContentResolver r0 = this.mContext.getContentResolver();
        Settings.System.putIntForUser(r0, "multi_audio_focus_enabled", r7 ? 1 : 0, r0.getUserId());
        if (this.mFocusStack.isEmpty() == true) goto L5;
        this.mFocusStack.peek().handleFocusLoss(-1, null, false);
    L5:
        if (r7 == false) goto L7;
        return;
    L7:
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L16;
        Iterator<FocusRequester> r1 = this.mMultiAudioFocusList.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().handleFocusLoss(-1, null, false);
        goto L10
    L12:
        this.mMultiAudioFocusList.clear();
        return;
    }

    public boolean getMultiAudioFocusEnabled() {
        return this.mMultiAudioFocusEnabled;
    }

    long getFadeOutDurationOnFocusLossMillis(AudioAttributes aa) {
        return getFadeOutDurationMillis(aa);
    }

    private void dumpMultiAudioFocus(PrintWriter pw) {
        pw.println("Multi Audio Focus enabled :" + this.mMultiAudioFocusEnabled);
        if (this.mMultiAudioFocusList.isEmpty() == true) goto L11;
        pw.println("Multi Audio Focus List:");
        pw.println("------------------------------");
        Iterator<FocusRequester> r1 = this.mMultiAudioFocusList.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        FocusRequester multifr = r1.next();
        multifr.dump(pw);
        goto L6
    L8:
        pw.println("------------------------------");
        return;
    }

    void postDelayedLossAfterFade(FocusRequester focusLoser, long delayMs) {
        this.mFocusHandler.sendMessageDelayed(this.mFocusHandler.obtainMessage(1, focusLoser), delayMs);
    }

    private void postForgetUidLater(FocusRequester focusRequester) {
        this.mFocusHandler.sendMessageDelayed(this.mFocusHandler.obtainMessage(2, new ForgetFadeUidInfo(focusRequester.getClientUid())), getFadeInDelayForOffendersMillis(focusRequester.getAudioAttributes()));
    }

    private void initFocusThreading() {
        this.mFocusThread = new HandlerThread(TAG);
        this.mFocusThread.start();
        final Looper r1 = this.mFocusThread.getLooper();
        this.mFocusHandler = new AnonymousClass4(this, r1);
    }
}
