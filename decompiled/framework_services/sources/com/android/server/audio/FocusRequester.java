package com.android.server.audio;

import android.content.pm.UserProperties;
import android.media.AudioAttributes;
import android.media.AudioFocusInfo;
import android.media.IAudioFocusDispatcher;
import android.media.MediaMetrics;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.IApplicationFreezer;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class FocusRequester {
    private static final boolean DEBUG = false;
    private static final String TAG = "FocusRequester";
    private static final String mMetricsId = "audio.focus";
    private final AudioAttributes mAttributes;
    private final int mCallingUid;
    private final String mClientId;
    private MediaFocusControl.AudioFocusDeathHandler mDeathHandler;
    private final EventLogger mEventLogger;
    private final IFocusRequesterExt mExt;
    private final MediaFocusControl mFocusController;
    private IAudioFocusDispatcher mFocusDispatcher;
    private final int mFocusGainRequest;
    boolean mFocusLossFadeLimbo;
    private int mFocusLossReceived;
    private boolean mFocusLossWasNotified;
    private final int mGrantFlags;
    private final String mPackageName;
    private final int mSdkTarget;
    private final IBinder mSourceRef;

    static class FocusRequestEvent extends EventLogger.Event {
        private final String mClientId;
        private final int mCode;
        private final String mDescription;
        private final String mPackageName;
        private final int mUid;

        public FocusRequestEvent(FocusRequester fr, String description) {
            this(fr, -1, description);
        }

        public FocusRequestEvent(FocusRequester fr, int code, String description) {
            this.mClientId = fr.getClientId();
            this.mUid = fr.getClientUid();
            this.mPackageName = fr.getPackageName();
            this.mCode = code;
            if (description == null) goto L5;
            String r0 = description;
        L6:
            this.mDescription = r0;
            return;
        L5:
            r0 = "";
            goto L6
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("focus owner: ");
            r0.append(this.mClientId);
            r0.append(" in uid: ");
            r0.append(this.mUid);
            r0.append(" pack: ");
            r0.append(this.mPackageName);
            if (this.mCode == (-1)) goto L5;
            String r1 = " code: " + this.mCode;
        L6:
            r0.append(r1);
            r0.append(" event: ");
            r0.append(this.mDescription);
            return r0.toString();
        L5:
            r1 = "";
            goto L6
        }
    }

    FocusRequester(AudioAttributes aa, int focusRequest, int grantFlags, IAudioFocusDispatcher afl, IBinder source, String id, MediaFocusControl.AudioFocusDeathHandler hdlr, String pn, int uid, MediaFocusControl ctlr, int sdk, EventLogger eventLogger) {
        this.mExt = IFocusRequesterExt.get(this);
        this.mAttributes = aa;
        this.mFocusDispatcher = afl;
        this.mSourceRef = source;
        this.mClientId = id;
        this.mDeathHandler = hdlr;
        this.mPackageName = pn;
        this.mCallingUid = uid;
        this.mFocusGainRequest = focusRequest;
        this.mGrantFlags = grantFlags;
        this.mFocusLossReceived = 0;
        this.mFocusLossWasNotified = true;
        this.mFocusLossFadeLimbo = false;
        this.mFocusController = ctlr;
        this.mSdkTarget = sdk;
        this.mEventLogger = eventLogger;
    }

    FocusRequester(AudioFocusInfo afi, IAudioFocusDispatcher afl, IBinder source, MediaFocusControl.AudioFocusDeathHandler hdlr, MediaFocusControl ctlr, EventLogger eventLogger) {
        this.mExt = IFocusRequesterExt.get(this);
        this.mAttributes = afi.getAttributes();
        this.mClientId = afi.getClientId();
        this.mPackageName = afi.getPackageName();
        this.mCallingUid = afi.getClientUid();
        this.mFocusGainRequest = afi.getGainRequest();
        this.mFocusLossReceived = 0;
        this.mFocusLossWasNotified = true;
        this.mFocusLossFadeLimbo = false;
        this.mGrantFlags = afi.getFlags();
        this.mSdkTarget = afi.getSdkTarget();
        this.mFocusDispatcher = afl;
        this.mSourceRef = source;
        this.mDeathHandler = hdlr;
        this.mFocusController = ctlr;
        this.mEventLogger = eventLogger;
    }

    boolean hasSameClient(String otherClient) {
        if (this.mClientId.compareTo(otherClient) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLockedFocusOwner() {
        if ((this.mGrantFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isInFocusLossLimbo() {
        return this.mFocusLossFadeLimbo;
    }

    boolean hasSameBinder(IBinder ib) {
        if (this.mSourceRef != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mSourceRef.equals(ib) == false) goto L7;
        return true;
    }

    boolean hasSameDispatcher(IAudioFocusDispatcher fd) {
        if (this.mFocusDispatcher != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFocusDispatcher.equals(fd) == false) goto L7;
        return true;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    boolean hasSamePackage(String pack) {
        if (this.mPackageName.compareTo(pack) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasSameUid(int uid) {
        if (this.mCallingUid != uid) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isAlwaysVisibleUser() {
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserProperties properties = umi.getUserProperties(UserHandle.getUserId(this.mCallingUid));
        if (properties != null) goto L5;
    L7:
        return false;
    L5:
        if (properties.getAlwaysVisible() == false) goto L7;
        return true;
    }

    int getClientUid() {
        return this.mCallingUid;
    }

    String getClientId() {
        return this.mClientId;
    }

    int getGainRequest() {
        return this.mFocusGainRequest;
    }

    int getGrantFlags() {
        return this.mGrantFlags;
    }

    AudioAttributes getAudioAttributes() {
        return this.mAttributes;
    }

    int getSdkTarget() {
        return this.mSdkTarget;
    }

    private static String focusChangeToString(int focus) {
        switch(focus) {
            case -3: goto L19;
            case -2: goto L17;
            case -1: goto L15;
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "GAIN_TRANSIENT_EXCLUSIVE";
    L7:
        return "GAIN_TRANSIENT_MAY_DUCK";
    L9:
        return "GAIN_TRANSIENT";
    L11:
        return "GAIN";
    L13:
        return "none";
    L15:
        return "LOSS";
    L17:
        return "LOSS_TRANSIENT";
    L19:
        return "LOSS_TRANSIENT_CAN_DUCK";
    L4:
        return "[invalid focus change" + focus + "]";
    }

    private String focusGainToString() {
        return focusChangeToString(this.mFocusGainRequest);
    }

    private String focusLossToString() {
        return focusChangeToString(this.mFocusLossReceived);
    }

    private static String flagsToString(int flags) {
        String msg = new String();
        if ((flags & 1) == 0) goto L6;
        msg = msg + "DELAY_OK";
    L6:
        if ((flags & 4) == 0) goto L12;
        if (msg.isEmpty() == true) goto L10;
        msg = msg + "|";
    L10:
        msg = msg + "LOCK";
    L12:
        if ((flags & 2) != 0) goto L14;
        return msg;
    L14:
        if (msg.isEmpty() == true) goto L17;
        msg = msg + "|";
    L17:
        return msg + "PAUSES_ON_DUCKABLE_LOSS";
    }

    void dump(PrintWriter pw) {
        pw.println("  source:" + this.mSourceRef + " -- pack: " + this.mPackageName + " -- client: " + this.mClientId + " -- gain: " + focusGainToString() + " -- flags: " + flagsToString(this.mGrantFlags) + " -- loss: " + focusLossToString() + " -- notified: " + this.mFocusLossWasNotified + " -- limbo" + this.mFocusLossFadeLimbo + " -- uid: " + this.mCallingUid + " -- attr: " + this.mAttributes + " -- sdk:" + this.mSdkTarget);
    }

    void maybeRelease() {
        if (this.mFocusLossFadeLimbo == true) goto L6;
        release();
        return;
    }

    void release() {
        IBinder srcRef = this.mSourceRef;
        MediaFocusControl.AudioFocusDeathHandler deathHdlr = this.mDeathHandler;
        if (srcRef == null) goto L9;
        if (deathHdlr == null) goto L9;
        srcRef.unlinkToDeath(deathHdlr, 0);     // Catch: NoSuchElementException -> L8
    L9:
        this.mDeathHandler = null;
        this.mFocusDispatcher = null;
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }

    private int focusLossForGainRequest(int gainRequest) {
        switch(gainRequest) {
            case 1: goto L6;
            case 2: goto L8;
            case 3: goto L10;
            case 4: goto L8;
            default: goto L11;
        };
    L11:
        Log.e(TAG, "focusLossForGainRequest() for invalid focus request " + gainRequest);
        return 0;
    L6:
        switch(this.mFocusLossReceived) {
            case -3: goto L19;
            case -2: goto L19;
            case -1: goto L19;
            case 0: goto L19;
            default: goto L8;
        };
    L19:
        return -1;
    L8:
        switch(this.mFocusLossReceived) {
            case -3: goto L18;
            case -2: goto L18;
            case -1: goto L17;
            case 0: goto L18;
            default: goto L10;
        };
    L17:
        return -1;
    L18:
        return -2;
    L10:
        switch(this.mFocusLossReceived) {
            case -3: goto L15;
            case -2: goto L14;
            case -1: goto L13;
            case 0: goto L15;
            default: goto L11;
        };
    L13:
        return -1;
    L14:
        return -2;
    L15:
        return -3;
    }

    boolean handleFocusLossFromGain(int focusGain, FocusRequester frWinner, boolean forceDuck) {
        new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackageName).set(MediaMetrics.Property.CLIENT_NAME, this.mClientId).set(MediaMetrics.Property.EVENT, "focusLossFromGain").record();
        int focusLoss = this.mExt.transformFocusLossFromGain(focusGain, frWinner, focusLossForGainRequest(focusGain));
        IApplicationFreezer r2 = SysOptBridge.getFactory().getApplicationFreezer();
        String r3 = this.mPackageName;
        int r4 = this.mCallingUid;
        if (frWinner == null) goto L6;
        String r0 = frWinner.getPackageName();
    L5:
        String r6 = r0;
        if (frWinner == null) goto L10;
        int r7 = frWinner.getClientUid();
    L11:
        r2.notifyAudioFocusLoss(r3, r4, focusLoss, r6, r7);
        handleFocusLoss(focusLoss, frWinner, forceDuck);
        if (focusLoss != (-1)) goto L14;
        return true;
    L14:
        return false;
    L10:
        r7 = -1;
        goto L11
    L6:
        r0 = null;
        goto L5
    }

    void handleFocusGain(int focusGain) {
        new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackageName).set(MediaMetrics.Property.CLIENT_NAME, this.mClientId).set(MediaMetrics.Property.EVENT, "focusGain").record();
        this.mFocusLossReceived = 0;     // Catch: RemoteException -> L8
        this.mFocusLossFadeLimbo = false;     // Catch: RemoteException -> L8
        this.mFocusController.notifyExtPolicyFocusGrant_syncAf(toAudioFocusInfo(), 1);     // Catch: RemoteException -> L8
        SysOptBridge.getFactory().getApplicationFreezer().notifyAudioFocusGain(this.mPackageName, this.mCallingUid, true);     // Catch: RemoteException -> L8
        IAudioFocusDispatcher fd = this.mFocusDispatcher;     // Catch: RemoteException -> L8
        if (fd == null) goto L11;
        if (this.mFocusLossWasNotified == false) goto L11;
        SysOptBridge.getFactory().getApplicationFreezer().unfreezePackage(this.mPackageName, IApplicationFreezer.UnfreezeReason.NEED_AUDIO_FOCUSED_RETURN);     // Catch: RemoteException -> L8
        fd.dispatchAudioFocusChange(focusGain, this.mClientId);     // Catch: RemoteException -> L8
        this.mEventLogger.enqueue(new FocusRequestEvent(this, focusGain, "handleGain"));     // Catch: RemoteException -> L8
    L13:
        this.mFocusController.restoreVShapedPlayers(this);     // Catch: RemoteException -> L8
        return;
    L11:
        if (this.mFocusLossWasNotified == false) goto L13;
        this.mEventLogger.enqueue(new FocusRequestEvent(this, focusGain, "handleGain no listener").printSlog(2, TAG));     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        this.mEventLogger.enqueue(new FocusRequestEvent(this, focusGain, "handleGain exc: " + e).printSlog(1, TAG));
    }

    void handleFocusGainFromRequest(int focusRequestResult) {
        new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackageName).set(MediaMetrics.Property.CLIENT_NAME, this.mClientId).set(MediaMetrics.Property.EVENT, "focusGainFromRequest").record();
        if (focusRequestResult != 1) goto L6;
        this.mFocusController.restoreVShapedPlayers(this);
        return;
    }

    void handleFocusLoss(int focusLoss, FocusRequester frWinner, boolean forceDuck) {
        new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackageName).set(MediaMetrics.Property.CLIENT_NAME, this.mClientId).set(MediaMetrics.Property.EVENT, "focusLoss").record();
        if (focusLoss == this.mFocusLossReceived) goto L29;
        this.mFocusLossReceived = focusLoss;
        this.mFocusLossWasNotified = false;
        if (this.mFocusController.mustNotifyFocusOwnerOnDuck() == false) goto L7;
    L12:
        boolean handled = false;
        if (frWinner == null) goto L15;
        handled = frameworkHandleFocusLoss(focusLoss, frWinner, forceDuck);
    L15:
        if (handled == false) goto L18;
        this.mFocusController.notifyExtPolicyFocusLoss_syncAf(toAudioFocusInfo(), false);
        return;
    L18:
        IAudioFocusDispatcher fd = this.mFocusDispatcher;
        if (fd == null) goto L25;
        this.mFocusController.notifyExtPolicyFocusLoss_syncAf(toAudioFocusInfo(), true);
        this.mFocusLossWasNotified = true;
        fd.dispatchAudioFocusChange(this.mFocusLossReceived, this.mClientId);     // Catch: RemoteException -> L23
        this.mEventLogger.enqueue(new FocusRequestEvent(this, this.mFocusLossReceived, "handleLoss"));     // Catch: RemoteException -> L23
        return;
    L23:
        e = move-exception;
        this.mEventLogger.enqueue(new FocusRequestEvent(this, this.mFocusLossReceived, "handleLoss failed exc: " + e).printSlog(1, TAG));
        return;
    L25:
        this.mEventLogger.enqueue(new FocusRequestEvent(this, this.mFocusLossReceived, "handleLoss failed no listener").printSlog(1, TAG));
        return;
    L7:
        if (this.mFocusLossReceived != (-3)) goto L12;
        if ((this.mGrantFlags & 2) != 0) goto L12;
        this.mFocusController.notifyExtPolicyFocusLoss_syncAf(toAudioFocusInfo(), false);
        return;
    }

    private boolean frameworkHandleFocusLoss(int focusLoss, FocusRequester frWinner, boolean forceDuck) {
        if (frWinner.mCallingUid != this.mCallingUid) goto L6;
        return false;
    L6:
        if (focusLoss != (-3)) goto L23;
        if (forceDuck == false) goto L10;
    L15:
        if (forceDuck == true) goto L21;
        if (getSdkTarget() > 25) goto L21;
        Log.v(TAG, "not ducking uid " + this.mCallingUid + " - old SDK");
        return false;
    L21:
        return this.mFocusController.duckPlayers(frWinner, this, forceDuck);
    L10:
        if ((this.mGrantFlags & 2) == 0) goto L15;
        if (this.mExt.frameworkHandleFocusLoss_onFlagPauseOnDuckableLoss(frWinner, forceDuck) == true) goto L15;
        Log.v(TAG, "not ducking uid " + this.mCallingUid + " - flags");
        return false;
    L23:
        if (focusLoss != (-1)) goto L28;
        boolean playersAreFaded = this.mFocusController.fadeOutPlayers(frWinner, this);
        if (playersAreFaded == false) goto L28;
        this.mFocusLossFadeLimbo = true;
        this.mFocusController.postDelayedLossAfterFade(this, this.mFocusController.getFadeOutDurationOnFocusLossMillis(getAudioAttributes()));
        return true;
    L28:
        return false;
    }

    int dispatchFocusChange(int focusChange, String reason) {
        IAudioFocusDispatcher fd = this.mFocusDispatcher;
        if (fd != null) goto L5;
        return 0;
    L5:
        if (focusChange != 0) goto L8;
        return 0;
    L8:
        if (focusChange == 3) goto L15;
        if (focusChange == 4) goto L15;
        if (focusChange == 2) goto L15;
        if (focusChange == 1) goto L15;
    L18:
        if (focusChange != (-3)) goto L20;
    L23:
        this.mFocusLossReceived = focusChange;
    L29:
        fd.dispatchAudioFocusChange(focusChange, this.mClientId);     // Catch: RemoteException -> L26
        this.mEventLogger.enqueue(new FocusRequestEvent(this, focusChange, "dispatch: " + reason));     // Catch: RemoteException -> L26
        return 1;
    L26:
        e = move-exception;
        this.mEventLogger.enqueue(new FocusRequestEvent(this, focusChange, "dispatch failed: " + e).printSlog(1, TAG));
        return 0;
    L20:
        if (focusChange == (-2)) goto L23;
        if (focusChange != (-1)) goto L29;
    L15:
        if (this.mFocusGainRequest == focusChange) goto L18;
        Log.w(TAG, "focus gain was requested with " + this.mFocusGainRequest + ", dispatching " + focusChange);
        goto L29
    }

    int dispatchFocusChangeWithFadeLocked(int focusChange, List<FocusRequester> otherActiveFrs) {
        if (focusChange != 3) goto L5;
    L23:
        this.mFocusLossFadeLimbo = false;
        this.mFocusController.restoreVShapedPlayers(this);
    L25:
        return dispatchFocusChange(focusChange, "focus with fade");
    L5:
        if (focusChange == 4) goto L23;
        if (focusChange == 2) goto L23;
        if (focusChange == 1) goto L23;
        if (focusChange != (-1)) goto L25;
        if (this.mFocusController.shouldEnforceFade() == false) goto L25;
        int index = 0;
    L17:
        if (index >= otherActiveFrs.size()) goto L25;
        if (this.mFocusController.fadeOutPlayers(otherActiveFrs.get(index), this) == true) goto L20;
        index = index + 1;
        goto L17
    L20:
        this.mFocusLossFadeLimbo = true;
        this.mFocusController.postDelayedLossAfterFade(this, this.mFocusController.getFadeOutDurationOnFocusLossMillis(getAudioAttributes()));
        return 2;
    }

    void dispatchFocusResultFromExtPolicy(int requestResult) {
        IAudioFocusDispatcher fd = this.mFocusDispatcher;
        if (fd != null) goto L10;
        return;
    L10:
        fd.dispatchFocusResultFromExtPolicy(requestResult, this.mClientId);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "dispatchFocusResultFromExtPolicy: error talking to focus listener" + this.mClientId, e);
    }

    AudioFocusInfo toAudioFocusInfo() {
        return new AudioFocusInfo(this.mAttributes, this.mCallingUid, this.mClientId, this.mPackageName, this.mFocusGainRequest, this.mFocusLossReceived, this.mGrantFlags, this.mSdkTarget);
    }
}
