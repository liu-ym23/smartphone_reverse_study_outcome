package com.android.server.policy.keyguard;

import android.R;
import android.app.ActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.dreams.DreamManagerInternal;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.WindowManagerPolicyConstants;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IKeyguardDrawnCallback;
import com.android.internal.policy.IKeyguardExitCallback;
import com.android.internal.policy.IKeyguardService;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.UiThread;
import com.android.server.am.ProcessList;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.wm.EventLogTags;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class KeyguardServiceDelegate {
    private static final boolean DEBUG = false;
    private static final int INTERACTIVE_STATE_AWAKE = 2;
    private static final int INTERACTIVE_STATE_GOING_TO_SLEEP = 3;
    private static final int INTERACTIVE_STATE_SLEEP = 0;
    private static final int INTERACTIVE_STATE_WAKING = 1;
    private static final int SCREEN_STATE_OFF = 0;
    private static final int SCREEN_STATE_ON = 2;
    private static final int SCREEN_STATE_TURNING_OFF = 3;
    private static final int SCREEN_STATE_TURNING_ON = 1;
    private static final String TAG = "KeyguardServiceDelegate";
    private final KeyguardStateMonitor.StateCallback mCallback;
    private final Context mContext;
    private DrawnListener mDrawnListenerWhenConnect;
    private final DreamManagerInternal.DreamManagerStateListener mDreamManagerStateListener;
    private final Handler mHandler;
    private final ServiceConnection mKeyguardConnection;
    protected KeyguardServiceWrapper mKeyguardService;
    private final KeyguardState mKeyguardState;
    private IObricKeyguardServiceDelegate mObricExt;

    /* JADX INFO: renamed from: com.android.server.policy.keyguard.KeyguardServiceDelegate$2, reason: invalid class name */
    class AnonymousClass2 implements ServiceConnection {
        final /* synthetic */ KeyguardServiceDelegate this$0;

        public static /* synthetic */ void $r8$lambda$h7EYra9ZqcgDbMLyIT41NbkG7wI() {
            lambda$onServiceDisconnected$0();
        }

        AnonymousClass2(KeyguardServiceDelegate this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            KeyguardServiceDelegate r0 = this.this$0;
            r0.mKeyguardService = new KeyguardServiceWrapper(KeyguardServiceDelegate.m7301$$Nest$fgetmContext(this.this$0), IKeyguardService.Stub.asInterface(service), KeyguardServiceDelegate.m7300$$Nest$fgetmCallback(this.this$0));
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).systemIsReady == false) goto L25;
            this.this$0.mKeyguardService.onSystemReady();
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).currentUser == (-10000)) goto L8;
            this.this$0.mKeyguardService.setCurrentUser(KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).currentUser);
        L8:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).interactiveState != 2) goto L10;
        L11:
            this.this$0.mKeyguardService.onStartedWakingUp(0, false);
        L13:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).interactiveState != 2) goto L16;
            this.this$0.mKeyguardService.onFinishedWakingUp();
        L16:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).screenState != 2) goto L18;
        L19:
            this.this$0.mKeyguardService.onScreenTurningOn(new KeyguardShowDelegate(this.this$0, KeyguardServiceDelegate.m7302$$Nest$fgetmDrawnListenerWhenConnect(this.this$0)));
        L21:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).screenState != 2) goto L23;
            this.this$0.mKeyguardService.onScreenTurnedOn();
        L23:
            KeyguardServiceDelegate.m7305$$Nest$fputmDrawnListenerWhenConnect(this.this$0, null);
            goto L25
        L18:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).screenState != 1) goto L21;
        L10:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).interactiveState != 1) goto L13;
        L25:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).bootCompleted == false) goto L28;
            this.this$0.mKeyguardService.onBootCompleted();
        L28:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).occluded == false) goto L31;
            this.this$0.mKeyguardService.setOccluded(KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).occluded, false);
        L31:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).enabled == true) goto L34;
            this.this$0.mKeyguardService.setKeyguardEnabled(KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).enabled);
        L34:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).dreaming == false) goto L37;
            this.this$0.mKeyguardService.onDreamingStarted();
        L37:
            if (KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).doKeyguardTimeoutRequested == false) goto L39;
            this.this$0.mKeyguardService.doKeyguardTimeout(KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).doKeyguardTimeoutRequestedOptions);
            KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).doKeyguardTimeoutRequested = false;
            KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).doKeyguardTimeoutRequestedOptions = null;
        L39:
            SysOptBridge.getFactory().getSmartScenes().updateKeyguardPackage(name.getPackageName());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            this.this$0.mKeyguardService = null;
            boolean wasEnabled = KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).enabled;
            KeyguardState.m7306$$Nest$mreset(KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0));
            KeyguardServiceDelegate.m7304$$Nest$fgetmKeyguardState(this.this$0).enabled = wasEnabled;
            KeyguardServiceDelegate.m7303$$Nest$fgetmHandler(this.this$0).post(new KeyguardServiceDelegate$2$$ExternalSyntheticLambda0());
            SysOptBridge.getFactory().getSmartScenes().updateKeyguardPackage(null);
        }

        private static /* synthetic */ void lambda$onServiceDisconnected$0() {
            ActivityTaskManager.getService().setLockScreenShown(true, false);     // Catch: RemoteException -> L4
            return;
        }
    }

    public interface DrawnListener {
        void onDrawn();
    }

    private final class KeyguardExitDelegate extends IKeyguardExitCallback.Stub {
        private WindowManagerPolicy.OnKeyguardExitResult mOnKeyguardExitResult;

        KeyguardExitDelegate(KeyguardServiceDelegate r1, WindowManagerPolicy.OnKeyguardExitResult onKeyguardExitResult) {
            this.mOnKeyguardExitResult = onKeyguardExitResult;
        }

        public void onKeyguardExitResult(boolean success) throws RemoteException {
            if (this.mOnKeyguardExitResult == null) goto L6;
            this.mOnKeyguardExitResult.onKeyguardExitResult(success);
            return;
        }
    }

    private final class KeyguardShowDelegate extends IKeyguardDrawnCallback.Stub {
        private DrawnListener mDrawnListener;

        KeyguardShowDelegate(KeyguardServiceDelegate r1, DrawnListener drawnListener) {
            this.mDrawnListener = drawnListener;
        }

        public void onDrawn() throws RemoteException {
            if (this.mDrawnListener == null) goto L6;
            this.mDrawnListener.onDrawn();
            return;
        }
    }

    protected static final class KeyguardState {
        public boolean bootCompleted;
        public int currentUser;
        boolean deviceHasKeyguard;
        boolean doKeyguardTimeoutRequested;
        Bundle doKeyguardTimeoutRequestedOptions;
        boolean dreaming;
        public boolean enabled;
        boolean inputRestricted;
        public int interactiveState;
        volatile boolean occluded;
        public int offReason;
        public int screenState;
        boolean secure;
        boolean showing;
        boolean systemIsReady;

        /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7306$$Nest$mreset(KeyguardState r0) {
            r0.reset();
        }

        KeyguardState() {
            reset();
        }

        private void reset() {
            this.showing = true;
            this.occluded = false;
            this.secure = true;
            this.deviceHasKeyguard = true;
            this.enabled = true;
            this.currentUser = ProcessList.INVALID_ADJ;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardStateMonitor.StateCallback m7300$$Nest$fgetmCallback(KeyguardServiceDelegate r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7301$$Nest$fgetmContext(KeyguardServiceDelegate r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDrawnListenerWhenConnect, reason: not valid java name */
    static /* bridge */ /* synthetic */ DrawnListener m7302$$Nest$fgetmDrawnListenerWhenConnect(KeyguardServiceDelegate r0) {
        return r0.mDrawnListenerWhenConnect;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7303$$Nest$fgetmHandler(KeyguardServiceDelegate r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardState, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardState m7304$$Nest$fgetmKeyguardState(KeyguardServiceDelegate r0) {
        return r0.mKeyguardState;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDrawnListenerWhenConnect, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7305$$Nest$fputmDrawnListenerWhenConnect(KeyguardServiceDelegate r0, DrawnListener r1) {
        r0.mDrawnListenerWhenConnect = r1;
    }

    public IObricKeyguardServiceDelegate getObricExt() {
        return this.mObricExt;
    }

    public KeyguardServiceDelegate(Context context, KeyguardStateMonitor.StateCallback callback) {
        this.mKeyguardState = new KeyguardState();
        this.mObricExt = (IObricKeyguardServiceDelegate) ObricImplFactory.getImpl(IObricKeyguardServiceDelegate.class, new Object[]{this});
        this.mDreamManagerStateListener = new AnonymousClass1(this);
        this.mKeyguardConnection = new AnonymousClass2(this);
        this.mContext = context;
        this.mHandler = UiThread.getHandler();
        this.mCallback = callback;
    }

    public void bindService(Context context) {
        Intent intent = new Intent();
        Resources resources = context.getApplicationContext().getResources();
        ComponentName keyguardComponent = ComponentName.unflattenFromString(resources.getString(R.string.config_satellite_gateway_service_package));
        intent.addFlags(256);
        intent.setComponent(keyguardComponent);
        if (context.bindServiceAsUser(intent, this.mKeyguardConnection, 1, this.mHandler, UserHandle.SYSTEM) == true) goto L12;
        Log.v(TAG, "*** Keyguard: can't bind to " + keyguardComponent);
        this.mKeyguardState.showing = false;
        this.mKeyguardState.secure = false;
        KeyguardState r10 = this.mKeyguardState;
        monitor-enter(r10);
        this.mKeyguardState.deviceHasKeyguard = false;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        DreamManagerInternal dreamManager = (DreamManagerInternal) LocalServices.getService(DreamManagerInternal.class);
        if (dreamManager == null) goto L18;
        dreamManager.registerDreamManagerStateListener(this.mDreamManagerStateListener);
        return;
    }

    public boolean isShowing() {
        if (this.mKeyguardService == null) goto L6;
        KeyguardState r0 = this.mKeyguardState;
        r0.showing = this.mKeyguardService.isShowing();
    L6:
        return this.mKeyguardState.showing;
    }

    public boolean isTrusted() {
        if (this.mKeyguardService != null) goto L5;
        return false;
    L5:
        return this.mKeyguardService.isTrusted();
    }

    public boolean hasKeyguard() {
        return this.mKeyguardState.deviceHasKeyguard;
    }

    public boolean isInputRestricted() {
        if (this.mKeyguardService == null) goto L6;
        KeyguardState r0 = this.mKeyguardState;
        r0.inputRestricted = this.mKeyguardService.isInputRestricted();
    L6:
        return this.mKeyguardState.inputRestricted;
    }

    public void verifyUnlock(WindowManagerPolicy.OnKeyguardExitResult onKeyguardExitResult) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.verifyUnlock(new KeyguardExitDelegate(this, onKeyguardExitResult));
        return;
    }

    public void setOccluded(boolean r3, boolean r4) {
        if (this.mKeyguardService == null) goto L6;
        if (r4 == false) goto L6;
        EventLogTags.writeWmSetKeyguardOccluded(r3 ? 1 : 0, 0, 0, "setOccluded");
        this.mKeyguardService.setOccluded(r3, false);
    L6:
        this.mKeyguardState.occluded = r3;
    }

    public boolean isOccluded() {
        return this.mKeyguardState.occluded;
    }

    public void dismiss(IKeyguardDismissCallback callback, CharSequence message) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.dismiss(callback, message);
        return;
    }

    public boolean isSecure(int userId) {
        if (this.mKeyguardService == null) goto L6;
        KeyguardState r0 = this.mKeyguardState;
        r0.secure = this.mKeyguardService.isSecure(userId);
    L6:
        return this.mKeyguardState.secure;
    }

    public void onDreamingStarted() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onDreamingStarted();
    L5:
        this.mKeyguardState.dreaming = true;
    }

    public void onDreamingStopped() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onDreamingStopped();
    L5:
        this.mKeyguardState.dreaming = false;
    }

    public void onStartedWakingUp(int pmWakeReason, boolean powerButtonLaunchGestureTriggered) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onStartedWakingUp(pmWakeReason, powerButtonLaunchGestureTriggered);
    L5:
        this.mKeyguardState.interactiveState = 1;
    }

    public void onFinishedWakingUp() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onFinishedWakingUp();
    L5:
        this.mKeyguardState.interactiveState = 2;
    }

    public void onScreenTurningOff() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onScreenTurningOff();
    L5:
        this.mKeyguardState.screenState = 3;
    }

    public void onScreenTurnedOff() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onScreenTurnedOff();
    L5:
        this.mKeyguardState.screenState = 0;
    }

    public void onScreenTurningOn(DrawnListener drawnListener) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onScreenTurningOn(new KeyguardShowDelegate(this, drawnListener));
    L6:
        this.mKeyguardState.screenState = 1;
        return;
    L5:
        Slog.w(TAG, "onScreenTurningOn(): no keyguard service!");
        this.mDrawnListenerWhenConnect = drawnListener;
        goto L6
    }

    public void onScreenTurnedOn() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onScreenTurnedOn();
    L5:
        this.mKeyguardState.screenState = 2;
    }

    public void onStartedGoingToSleep(int pmSleepReason) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onStartedGoingToSleep(pmSleepReason);
    L5:
        KeyguardState r0 = this.mKeyguardState;
        r0.offReason = WindowManagerPolicyConstants.translateSleepReasonToOffReason(pmSleepReason);
        this.mKeyguardState.interactiveState = 3;
    }

    public void onFinishedGoingToSleep(int pmSleepReason, boolean powerButtonLaunchGestureTriggered) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onFinishedGoingToSleep(pmSleepReason, powerButtonLaunchGestureTriggered);
    L5:
        this.mKeyguardState.interactiveState = 0;
    }

    public void setKeyguardEnabled(boolean enabled) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.setKeyguardEnabled(enabled);
    L5:
        this.mKeyguardState.enabled = enabled;
    }

    public void onSystemReady() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onSystemReady();
        return;
    L5:
        this.mKeyguardState.systemIsReady = true;
    }

    public void doKeyguardTimeout(Bundle options) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.doKeyguardTimeout(options);
        return;
    L5:
        this.mKeyguardState.doKeyguardTimeoutRequested = true;
        if (options == null) goto L10;
        this.mKeyguardState.doKeyguardTimeoutRequestedOptions = options;
        return;
    }

    public void showDismissibleKeyguard() {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.showDismissibleKeyguard();
        return;
    }

    public void setCurrentUser(int newUserId) {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.setCurrentUser(newUserId);
    L5:
        this.mKeyguardState.currentUser = newUserId;
    }

    public void setSwitchingUser(boolean switching) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.setSwitchingUser(switching);
        return;
    }

    public void startKeyguardExitAnimation(long startTime) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.startKeyguardExitAnimation(startTime, 0);
        return;
    }

    public void onBootCompleted() {
        if (this.mKeyguardService == null) goto L5;
        this.mKeyguardService.onBootCompleted();
    L5:
        this.mKeyguardState.bootCompleted = true;
    }

    public void onShortPowerPressedGoHome() {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.onShortPowerPressedGoHome();
        return;
    }

    public void dismissKeyguardToLaunch(Intent intentToLaunch) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.dismissKeyguardToLaunch(intentToLaunch);
        return;
    }

    public void onSystemKeyPressed(int keycode) {
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.onSystemKeyPressed(keycode);
        return;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1133871366145L, this.mKeyguardState.showing);
        proto.write(1133871366146L, this.mKeyguardState.occluded);
        proto.write(1133871366147L, this.mKeyguardState.secure);
        proto.write(1159641169924L, this.mKeyguardState.screenState);
        proto.write(1159641169925L, this.mKeyguardState.interactiveState);
        proto.end(token);
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + TAG);
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "showing=" + this.mKeyguardState.showing);
        pw.println(prefix2 + "inputRestricted=" + this.mKeyguardState.inputRestricted);
        pw.println(prefix2 + "occluded=" + this.mKeyguardState.occluded);
        pw.println(prefix2 + "secure=" + this.mKeyguardState.secure);
        pw.println(prefix2 + "dreaming=" + this.mKeyguardState.dreaming);
        pw.println(prefix2 + "systemIsReady=" + this.mKeyguardState.systemIsReady);
        pw.println(prefix2 + "deviceHasKeyguard=" + this.mKeyguardState.deviceHasKeyguard);
        pw.println(prefix2 + "enabled=" + this.mKeyguardState.enabled);
        pw.println(prefix2 + "offReason=" + WindowManagerPolicyConstants.offReasonToString(this.mKeyguardState.offReason));
        pw.println(prefix2 + "currentUser=" + this.mKeyguardState.currentUser);
        pw.println(prefix2 + "bootCompleted=" + this.mKeyguardState.bootCompleted);
        pw.println(prefix2 + "screenState=" + screenStateToString(this.mKeyguardState.screenState));
        pw.println(prefix2 + "interactiveState=" + interactiveStateToString(this.mKeyguardState.interactiveState));
        if (this.mKeyguardService == null) goto L6;
        this.mKeyguardService.dump(prefix2, pw);
        return;
    }

    private static String screenStateToString(int screen) {
        switch(screen) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "SCREEN_STATE_TURNING_OFF";
    L7:
        return "SCREEN_STATE_ON";
    L9:
        return "SCREEN_STATE_TURNING_ON";
    L11:
        return "SCREEN_STATE_OFF";
    L4:
        return Integer.toString(screen);
    }

    private static String interactiveStateToString(int interactive) {
        switch(interactive) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "INTERACTIVE_STATE_GOING_TO_SLEEP";
    L7:
        return "INTERACTIVE_STATE_AWAKE";
    L9:
        return "INTERACTIVE_STATE_WAKING";
    L11:
        return "INTERACTIVE_STATE_SLEEP";
    L4:
        return Integer.toString(interactive);
    }
}
