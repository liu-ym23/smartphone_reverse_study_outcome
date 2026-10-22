package com.android.server.inputmethod;

import android.R;
import android.app.ActivityManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.Region;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.input.InputManager;
import android.media.AudioManagerInternal;
import android.net.Uri;
import android.os.Binder;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserHandleSmtEx;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Utils;
import android.util.proto.ProtoOutputStream;
import android.view.InputChannel;
import android.view.InputDevice;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.window.ImeOnBackInvokedDispatcher;
import com.android.internal.content.PackageMonitor;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IBooleanListener;
import com.android.internal.inputmethod.IConnectionlessHandwritingCallback;
import com.android.internal.inputmethod.IImeTracker;
import com.android.internal.inputmethod.IInputContentUriToken;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IInputMethodPrivilegedOperations;
import com.android.internal.inputmethod.IInputMethodSession;
import com.android.internal.inputmethod.IInputMethodSessionCallback;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.ImeTracing;
import com.android.internal.inputmethod.InlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.inputmethod.InputMethodInfoSafeList;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import com.android.internal.inputmethod.InputMethodSubtypeSafeList;
import com.android.internal.os.TransferPipe;
import com.android.internal.protolog.ProtoLog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.view.IInputMethodManagerExt;
import com.android.internal.view.IObricInputMethodManager;
import com.android.server.AccessibilityManagerInternal;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.devicepolicy.DevicePolicyManagerService$$ExternalSyntheticLambda214;
import com.android.server.input.InputManagerInternal;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.UserManagerInternal;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.utils.PriorityDump;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class InputMethodManagerService implements IInputMethodManagerImpl.Callback, ZeroJankProxy.Callback, Handler.Callback {
    static final boolean DEBUG = false;
    static final int FALLBACK_DISPLAY_ID = 0;
    private static final String HANDLER_THREAD_NAME = "android.imms";
    private static final List<String> IME_ACCESSIBILITY_MATTER_WINDOWS = null;
    private static final int MSG_DISPATCH_ON_INPUT_METHOD_LIST_UPDATED = 5010;
    private static final int MSG_FINISH_HANDWRITING = 1110;
    private static final int MSG_HARD_KEYBOARD_SWITCH_CHANGED = 4000;
    private static final int MSG_HIDE_INPUT_METHOD = 1035;
    private static final int MSG_NOTIFY_IME_UID_TO_AUDIO_SERVICE = 7000;
    private static final int MSG_PREPARE_HANDWRITING_DELEGATION = 1130;
    private static final int MSG_REMOVE_HANDWRITING_WINDOW = 1120;
    private static final int MSG_REMOVE_IME_SURFACE = 1060;
    private static final int MSG_REMOVE_IME_SURFACE_FROM_WINDOW = 1061;
    private static final int MSG_RESET_HANDWRITING = 1090;
    private static final int MSG_SET_INTERACTIVE = 3030;
    private static final int MSG_START_HANDWRITING = 1100;
    private static final String OBRIC_INPUT_METHOD_PACKAGE_NAME = "com.bytedance.android.doubaoime";
    private static final String PACKAGE_MONITOR_THREAD_NAME = "android.imms2";
    public static final String PROTO_ARG = "--proto";
    private static final long SYSTEM_READY_USER_INIT_TIMEOUT = 3000;
    static final String TAG = "InputMethodManagerService";
    private static final String TAG_TRY_SUPPRESSING_IME_SWITCHER = "TrySuppressingImeSwitcher";
    private static final Integer VIRTUAL_STYLUS_ID_FOR_TEST = null;
    private final ActivityManagerInternal mActivityManagerInternal;
    private AudioManagerInternal mAudioManagerInternal;
    private final ClientController mClientController;
    private final boolean mConcurrentMultiUserModeEnabled;
    final Context mContext;
    public int mCurrentImeUserId;
    private DisplayManagerInternal mDisplayManagerInternal;
    private final ImeTracing.ServiceDumper mDumper;
    private IExtInputMethodManagerService mExt;
    final WeakHashMap<IBinder, Boolean> mFocusedWindowPerceptible;
    private final Handler mHandler;
    private final HandwritingModeController mHwController;
    final ImePlatformCompatUtils mImePlatformCompatUtils;
    private final WeakHashMap<IBinder, IBinder> mImeTargetWindowMap;
    private final ImeTrackerService mImeTrackerService;
    final InputManagerInternal mInputManagerInternal;
    final InputMethodDeviceConfigs mInputMethodDeviceConfigs;
    private final CopyOnWriteArrayList<InputMethodManagerInternal.InputMethodListListener> mInputMethodListListeners;
    private final InputMethodManagerInternal mInputMethodManagerInternal;
    private final Handler mIoHandler;
    boolean mIsInteractive;
    private final InputMethodMenuController mMenuController;
    private final InputMethodMenuControllerNew mMenuControllerNew;
    private final MyPackageMonitor mMyPackageMonitor;
    private final String[] mNonPreemptibleInputMethods;
    private IObricInputMethodManagerService mObricExt;
    final PackageManagerInternal mPackageManagerInternal;
    private final boolean mPreventImeStartupUnlessTextEditor;
    private final PriorityDump.PriorityDumper mPriorityDumper;
    private boolean mRequestShowAiPanel;
    final Resources mRes;
    private boolean mShowOngoingImeSwitcherForPhones;
    private final String mSlotIme;
    private final SoftInputShowHideHistory mSoftInputShowHideHistory;
    private final StartInputHistory mStartInputHistory;
    private StatusBarManagerInternal mStatusBarManagerInternal;
    private IntArray mStylusIds;
    boolean mSystemReady;
    private final UserDataRepository mUserDataRepository;
    private final UserManagerInternal mUserManagerInternal;
    private UserSwitchHandlerTask mUserSwitchHandlerTask;
    private VirtualDeviceManagerInternal mVdmInternal;
    private final SparseArray<String> mVirtualDeviceMethodMap;
    private final DefaultImeVisibilityApplier mVisibilityApplier;
    final WindowManagerInternal mWindowManagerInternal;

    static class AccessibilitySessionState {
        final ClientState mClient;
        final int mId;
        IAccessibilityInputMethodSession mSession;

        public String toString() {
            return "AccessibilitySessionState{uid=" + this.mClient.mUid + " pid=" + this.mClient.mPid + " id=" + Integer.toHexString(this.mId) + " session=" + Integer.toHexString(System.identityHashCode(this.mSession)) + "}";
        }

        AccessibilitySessionState(ClientState client, int id, IAccessibilityInputMethodSession session) {
            this.mClient = client;
            this.mId = id;
            this.mSession = session;
        }
    }

    private static final class HandwritingRequest extends Record {
        private final int pid;
        private final int requestId;
        private final UserData userData;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof HandwritingRequest) == false) goto L12;
            HandwritingRequest r4 = (HandwritingRequest) r3;
            if (this.requestId == r4.requestId) goto L7;
            return false;
        L7:
            if (this.pid == r4.pid) goto L9;
            return false;
        L9:
            if (Objects.equals(this.userData, r4.userData) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Integer.valueOf(this.requestId), Integer.valueOf(this.pid), this.userData};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4768$$Nest$fgetpid(HandwritingRequest r0) {
            return r0.pid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetrequestId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4769$$Nest$fgetrequestId(HandwritingRequest r0) {
            return r0.requestId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserData, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserData m4770$$Nest$fgetuserData(HandwritingRequest r0) {
            return r0.userData;
        }

        /* synthetic */ HandwritingRequest(int r1, int r2, UserData r3, InputMethodManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private HandwritingRequest(int requestId, int pid, UserData userData) {
            this.requestId = requestId;
            this.pid = pid;
            this.userData = userData;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return InputMethodManagerService$HandwritingRequest$$ExternalSyntheticRecord0.m(this.requestId, this.pid, this.userData);
        }

        public int pid() {
            return this.pid;
        }

        public int requestId() {
            return this.requestId;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), HandwritingRequest.class, "requestId;pid;userData");
        }

        public UserData userData() {
            return this.userData;
        }
    }

    @FunctionalInterface
    interface ImeDisplayValidator {
        int getDisplayImePolicy(int r1);
    }

    private final class ImmsBroadcastReceiverForAllUsers extends BroadcastReceiver {
        final /* synthetic */ InputMethodManagerService this$0;

        /* synthetic */ ImmsBroadcastReceiverForAllUsers(InputMethodManagerService r1, InputMethodManagerServiceIA r2) {
            this(r1);
        }

        private ImmsBroadcastReceiverForAllUsers(InputMethodManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) == false) goto L22;
            BroadcastReceiver.PendingResult pendingResult = getPendingResult();
            if (pendingResult != null) goto L7;
            return;
        L7:
            int senderUserId = pendingResult.getSendingUserId();
            monitor-enter(ImfLock.class);
            if (senderUserId != (-1)) goto L24;
        L17:
            int userId = this.this$0.mCurrentImeUserId;     // Catch: Throwable -> L15
            InputMethodManagerService.m4716$$Nest$fgetmMenuController(this.this$0).hideInputMethodMenuLocked(userId);     // Catch: Throwable -> L15
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L15
            return;
        L24:
        L15:
            th = move-exception;
            throw th;
        L12:
            if (senderUserId == this.this$0.mCurrentImeUserId) goto L17;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L15
            return;
        L22:
            Slog.w(InputMethodManagerService.TAG, "Unexpected intent " + intent);
        }
    }

    private final class InkWindowInitializer implements Runnable {
        final /* synthetic */ InputMethodManagerService this$0;

        /* synthetic */ InkWindowInitializer(InputMethodManagerService r1, InputMethodManagerServiceIA r2) {
            this(r1);
        }

        private InkWindowInitializer(InputMethodManagerService r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            monitor-enter(ImfLock.class);
            IInputMethodInvoker curMethod = this.this$0.getCurMethodLocked();     // Catch: Throwable -> L7
            if (curMethod == null) goto L9;
            curMethod.initInkWindow();     // Catch: Throwable -> L7
        L9:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class InputMethodPrivilegedOperationsImpl extends IInputMethodPrivilegedOperations.Stub {
        private final InputMethodManagerService mImms;
        private final IBinder mToken;
        private final UserData mUserData;

        InputMethodPrivilegedOperationsImpl(InputMethodManagerService imms, IBinder token, UserData userData) {
            this.mImms = imms;
            this.mToken = token;
            this.mUserData = userData;
        }

        public void setImeWindowStatusAsync(int vis, int backDisposition) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4753$$Nest$msetImeWindowStatusLocked(this.mImms, vis, backDisposition, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void reportStartInputAsync(IBinder startInputToken) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4748$$Nest$mreportStartInputLocked(this.mImms, startInputToken, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void setHandwritingSurfaceNotTouchable(boolean notTouchable) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4713$$Nest$fgetmHwController(this.mImms).setNotTouchable(notTouchable);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void setHandwritingTouchableRegion(Region region) {
            monitor-enter(ImfLock.class);
            InputMethodManagerService.m4713$$Nest$fgetmHwController(this.mImms).setHandwritingTouchableRegion(region);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void createInputContentUriToken(Uri contentUri, String packageName, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            future.complete(InputMethodManagerService.m4728$$Nest$mcreateInputContentUriTokenLocked(this.mImms, contentUri, packageName, this.mUserData).asBinder());     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void reportFullscreenModeAsync(boolean fullscreen) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4747$$Nest$mreportFullscreenModeLocked(this.mImms, fullscreen, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void setInputMethod(String id, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            InputMethodManagerService.m4754$$Nest$msetInputMethodAndSubtypeLocked(this.mImms, id, null, this.mUserData);     // Catch: Throwable -> L10
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void setInputMethodAndSubtype(String id, InputMethodSubtype subtype, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            InputMethodManagerService.m4754$$Nest$msetInputMethodAndSubtypeLocked(this.mImms, id, subtype, this.mUserData);     // Catch: Throwable -> L10
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void hideMySoftInput(ImeTracker.Token statsToken, int flags, int reason, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L22
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            ImeTracker.forLogging().onFailed(statsToken, 47);     // Catch: Throwable -> L10
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            ImeTracker.forLogging().onProgress(statsToken, 47);     // Catch: Throwable -> L10
            Trace.traceBegin(32, "IMMS.hideMySoftInput");     // Catch: Throwable -> L10
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
            InputMethodManagerService.m4740$$Nest$mhideMySoftInputLocked(this.mImms, statsToken, flags, reason, this.mUserData);     // Catch: Throwable -> L17
            future.complete(null);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
            Trace.traceEnd(32);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
            Trace.traceEnd(32);     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L22:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void showMySoftInput(ImeTracker.Token statsToken, int flags, int reason, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L22
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            ImeTracker.forLogging().onFailed(statsToken, 47);     // Catch: Throwable -> L10
            future.complete(null);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            ImeTracker.forLogging().onProgress(statsToken, 47);     // Catch: Throwable -> L10
            Trace.traceBegin(32, "IMMS.showMySoftInput");     // Catch: Throwable -> L10
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
            InputMethodManagerService.m4757$$Nest$mshowMySoftInputLocked(this.mImms, statsToken, flags, reason, this.mUserData);     // Catch: Throwable -> L17
            future.complete(null);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
            Trace.traceEnd(32);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
            Trace.traceEnd(32);     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L22:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void updateStatusIconAsync(String packageName, int iconId) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            InputMethodManagerService.m4764$$Nest$mupdateStatusIconLocked(this.mImms, packageName, iconId, this.mUserData);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void switchToPreviousInputMethod(AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(false);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            future.complete(Boolean.valueOf(InputMethodManagerService.m4761$$Nest$mswitchToPreviousInputMethodLocked(this.mImms, this.mUserData)));     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void switchToNextInputMethod(boolean onlyCurrentIme, AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(false);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            future.complete(Boolean.valueOf(InputMethodManagerService.m4760$$Nest$mswitchToNextInputMethodLocked(this.mImms, onlyCurrentIme, this.mUserData)));     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void shouldOfferSwitchingToNextInputMethod(AndroidFuture future) {
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L17
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L6:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L12;
            future.complete(false);     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L12:
            future.complete(Boolean.valueOf(InputMethodManagerService.m4756$$Nest$mshouldOfferSwitchingToNextInputMethodLocked(this.mImms, this.mUserData)));     // Catch: Throwable -> L10
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
            return;
        L17:
            e = move-exception;
            future.completeExceptionally(e);
        }

        public void onImeSwitchButtonClickFromClient(int displayId) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4742$$Nest$monImeSwitchButtonClickLocked(this.mImms, displayId, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void notifyUserActionAsync() {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4741$$Nest$mnotifyUserActionLocked(this.mImms, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void applyImeVisibilityAsync(IBinder windowToken, boolean setVisible, ImeTracker.Token statsToken) {
            monitor-enter(ImfLock.class);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L11;
            ImeTracker.forLogging().onFailed(statsToken, 47);     // Catch: Throwable -> L9
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            return;
        L11:
            ImeTracker.forLogging().onProgress(statsToken, 47);     // Catch: Throwable -> L9
            InputMethodManagerService.m4724$$Nest$mapplyImeVisibilityLocked(this.mImms, windowToken, setVisible, statsToken, this.mUserData);     // Catch: Throwable -> L9
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        }

        public void onStylusHandwritingReady(int requestId, int pid) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4743$$Nest$monStylusHandwritingReadyLocked(this.mImms, requestId, pid, this.mUserData);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void resetStylusHandwriting(int requestId) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4750$$Nest$mresetStylusHandwritingLocked(this.mImms, requestId);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        public void switchKeyboardLayoutAsync(int direction) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (calledWithValidTokenLocked(this.mToken, this.mUserData) == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            InputMethodManagerService.m4758$$Nest$mswitchKeyboardLayoutLocked(this.mImms, direction, this.mUserData);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        private static boolean calledWithValidTokenLocked(IBinder token, UserData userData) {
            token.getClass();
            InputMethodBindingController bindingController = userData.mBindingController;
            if (token == bindingController.getCurToken()) goto L6;
            Slog.e(InputMethodManagerService.TAG, "Ignoring " + Debug.getCaller() + " due to an invalid token. uid:" + Binder.getCallingUid() + " token:" + token);
            return false;
        L6:
            return true;
        }
    }

    public static final class Lifecycle extends SystemService implements UserManagerInternal.UserLifecycleListener {
        private final InputMethodManagerService mService;

        public static /* synthetic */ void $r8$lambda$4H27nG5sHAQqHYzMQZqi4tBbCII(Lifecycle r0, int r1) {
            r0.lambda$onUserStarting$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$6T1tYl_GMGu03574D1VibaMubYk(InputMethodManagerService r0, int r1) {
            InputMethodManagerService.m4744$$Nest$monUpdateResourceOverlay(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$NcHwasQrHcDWPnzfNFrrqshyKdA(Lifecycle r0, int r1) {
            r0.lambda$onUserUnlocking$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$ykQTvnJIzX0sVvuWI6n1db_k78U(Lifecycle r0, int[] r1) {
            r0.lambda$initializeUsersAsync$2(r1);
        }

        public Lifecycle(Context context) {
            this(context, createServiceForProduction(context));
            InputMethodManagerService.m4719$$Nest$fgetmUserManagerInternal(this.mService).addUserLifecycleListener(this);
            Handler r0 = InputMethodManagerService.m4715$$Nest$fgetmIoHandler(this.mService);
            final InputMethodManagerService r1 = this.mService;
            r1.getClass();
            InputMethodDrawsNavBarResourceMonitor.registerCallback(context, r0, new InputMethodManagerService$Lifecycle$$ExternalSyntheticLambda0(r1));
            initializeUsersAsync(InputMethodManagerService.m4719$$Nest$fgetmUserManagerInternal(this.mService).getUserIds());
        }

        Lifecycle(Context context, InputMethodManagerService inputMethodManagerService) {
            super(context);
            this.mService = inputMethodManagerService;
        }

        private static InputMethodManagerService createServiceForProduction(Context context) {
            ServiceThread thread = new ServiceThread(InputMethodManagerService.HANDLER_THREAD_NAME, -2, false);
            thread.start();
            ServiceThread ioThread = new ServiceThread(InputMethodManagerService.PACKAGE_MONITOR_THREAD_NAME, -2, true);
            ioThread.start();
            SecureSettingsWrapper.setContentResolver(context.getContentResolver());
            return new InputMethodManagerService(context, InputMethodManagerService.shouldEnableConcurrentMultiUserMode(context), thread.getLooper(), Handler.createAsync(ioThread.getLooper()), null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            InputMethodManagerService.m4745$$Nest$mpublishLocalService(this.mService);
            Handler r1 = InputMethodManagerService.m4712$$Nest$fgetmHandler(this.mService);
            r1.getClass();
            IInputMethodManagerImpl.Callback service = new ZeroJankProxy(new DevicePolicyManagerService$$ExternalSyntheticLambda214(r1), this.mService);
            publishBinderService("input_method", IInputMethodManagerImpl.create(service), false, 21);
            this.mService.registerImeRequestedChangedListener();
            SysOptBridge.getFactory().getIMMSOpt().init(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (InputMethodManagerService.m4710$$Nest$fgetmConcurrentMultiUserModeEnabled(this.mService) == false) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            this.mService.scheduleSwitchUserTaskLocked(to.getUserIdentifier(), null);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            this.mService.systemRunning();
            return;
        }

        @Override // com.android.server.pm.UserManagerInternal.UserLifecycleListener
        public void onUserCreated(UserInfo user, Object token) {
            int userId = user.id;
            AdditionalSubtypeMapRepository.onUserCreated(userId);
            initializeUsersAsync(new int[]{userId});
        }

        @Override // com.android.server.pm.UserManagerInternal.UserLifecycleListener
        public void onUserRemoved(UserInfo user) {
            int userId = user.id;
            SecureSettingsWrapper.onUserRemoved(userId);
            AdditionalSubtypeMapRepository.remove(userId);
            InputMethodSettingsRepository.remove(userId);
            InputMethodManagerService.m4718$$Nest$fgetmUserDataRepository(this.mService).remove(userId);
            monitor-enter(ImfLock.class);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (InputMethodManagerService.m4720$$Nest$fgetmUserSwitchHandlerTask(this.mService) == null) goto L9;
            int nextOrCurrentUser = InputMethodManagerService.m4720$$Nest$fgetmUserSwitchHandlerTask(this.mService).mToUserId;     // Catch: Throwable -> L7
        L11:
            if (InputMethodManagerService.m4710$$Nest$fgetmConcurrentMultiUserModeEnabled(this.mService) == true) goto L14;
            if (userId != nextOrCurrentUser) goto L14;
            int currentUserId = InputMethodManagerService.m4708$$Nest$fgetmActivityManagerInternal(this.mService).getCurrentUserId();     // Catch: Throwable -> L7
            this.mService.scheduleSwitchUserTaskLocked(currentUserId, null);     // Catch: Throwable -> L7
        L14:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L9:
            nextOrCurrentUser = this.mService.mCurrentImeUserId;     // Catch: Throwable -> L7
            goto L11
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            final int userId = user.getUserIdentifier();
            UserData userData = this.mService.getUserData(userId);
            userData.mIsUnlockingOrUnlocked.set(true);
            SecureSettingsWrapper.onUserUnlocking(userId);
            InputMethodMap methodMap = userData.mRawInputMethodMap.get().toInputMethodMap(AdditionalSubtypeMapRepository.get(userId), 0, true);
            InputMethodSettings newSettings = InputMethodSettings.create(methodMap, userId);
            InputMethodSettingsRepository.put(userId, newSettings);
            InputMethodManagerService.m4715$$Nest$fgetmIoHandler(this.mService).postDelayed(new InputMethodManagerService$Lifecycle$$ExternalSyntheticLambda2(this, userId), 1000);
        }

        private /* synthetic */ void lambda$onUserUnlocking$0(int userId) {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mService.mSystemReady == true) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            this.mService.postInputMethodSettingUpdatedLocked(false, userId);     // Catch: Throwable -> L8
            this.mService.updateInputMethodsFromSettingsLocked(true, userId);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            final int userId = user.getUserIdentifier();
            SecureSettingsWrapper.onUserStarting(userId);
            InputMethodManagerService.m4715$$Nest$fgetmIoHandler(this.mService).post(new InputMethodManagerService$Lifecycle$$ExternalSyntheticLambda1(this, userId));
        }

        private /* synthetic */ void lambda$onUserStarting$1(int userId) {
            monitor-enter(ImfLock.class);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mService.mSystemReady == false) goto L9;
            this.mService.onUserReadyLocked(userId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        }

        private void initializeUsersAsync(final int[] userIds) {
            Slog.d(InputMethodManagerService.TAG, "Schedule initialization for users=" + Arrays.toString(userIds));
            InputMethodManagerService.m4715$$Nest$fgetmIoHandler(this.mService).post(new InputMethodManagerService$Lifecycle$$ExternalSyntheticLambda3(this, userIds));
        }

        private /* synthetic */ void lambda$initializeUsersAsync$2(int[] userIds) {
            Lifecycle r0 = this;
            int[] r1 = userIds;
            InputMethodManagerService service = r0.mService;
            Context context = service.mContext;
            UserManagerInternal userManagerInternal = InputMethodManagerService.m4719$$Nest$fgetmUserManagerInternal(service);
            int r5 = r1.length;
            int r6 = 0;
            int r7 = 0;
        L3:
            if (r7 >= r5) goto L5;
            int userId = r1[r7];
            Slog.d(InputMethodManagerService.TAG, "Start initialization for user=" + userId);
            UserData userData = r0.mService.getUserData(userId);
            AdditionalSubtypeMapRepository.initializeIfNecessary(userId);
            AdditionalSubtypeMap additionalSubtypeMap = AdditionalSubtypeMapRepository.get(userId);
            RawInputMethodMap rawMethodMap = InputMethodManagerService.queryRawInputMethodServiceMap(context, userId);
            userData.mRawInputMethodMap.set(rawMethodMap);
            boolean unlocked = userManagerInternal.isUserUnlockingOrUnlocked(userId);
            userData.mIsUnlockingOrUnlocked.set(unlocked);
            InputMethodMap methodMap = rawMethodMap.toInputMethodMap(additionalSubtypeMap, r6, unlocked);
            InputMethodSettings settings = InputMethodSettings.create(methodMap, userId);
            InputMethodSettingsRepository.put(userId, settings);
            int profileParentId = userManagerInternal.getProfileParentId(userId);
            boolean value = InputMethodDrawsNavBarResourceMonitor.evaluate(context, profileParentId);
            userData.mImeDrawsNavBar.set(value);
            userData.mBackgroundLoadLatch.countDown();
            Slog.d(InputMethodManagerService.TAG, "Complete initialization for user=" + userId);
            r7 = r7 + 1;
            r6 = 0;
            r0 = this;
            r1 = userIds;
            goto L3
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            int userId = user.getUserIdentifier();
            SecureSettingsWrapper.onUserStopped(userId);
            UserData userData = this.mService.getUserData(userId);
            AdditionalSubtypeMap additionalSubtypeMap = AdditionalSubtypeMapRepository.get(userId);
            RawInputMethodMap rawMethodMap = userData.mRawInputMethodMap.get();
            userData.mIsUnlockingOrUnlocked.set(false);
            InputMethodMap methodMap = rawMethodMap.toInputMethodMap(additionalSubtypeMap, 0, false);
            InputMethodSettingsRepository.put(userId, InputMethodSettings.create(methodMap, userId));
        }
    }

    private final class LocalServiceImpl extends InputMethodManagerInternal {
        final /* synthetic */ InputMethodManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$A6hG-PqGewzDamMc6Fe8Pp7JFkM, reason: not valid java name */
        public static /* synthetic */ void m4771$r8$lambda$A6hGPqGewzDamMc6Fe8Pp7JFkM(LocalServiceImpl r0, int r1, ClientState r2) {
            r0.lambda$unbindAccessibilityFromCurrentClient$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$L1FlzdMUD1qflDuU6HOLHBJce0w(LocalServiceImpl r0, boolean r1, int r2) {
            r0.lambda$updateImeWindowStatus$0(r1, r2);
        }

        /* synthetic */ LocalServiceImpl(InputMethodManagerService r1, InputMethodManagerServiceIA r2) {
            this(r1);
        }

        private LocalServiceImpl(InputMethodManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void setInteractive(boolean r4) {
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).obtainMessage(InputMethodManagerService.MSG_SET_INTERACTIVE, r4 ? 1 : 0, 0).sendToTarget();
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void hideInputMethod(int reason, int originatingDisplayId) {
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).removeMessages(InputMethodManagerService.MSG_HIDE_INPUT_METHOD);
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).obtainMessage(InputMethodManagerService.MSG_HIDE_INPUT_METHOD, reason, originatingDisplayId).sendToTarget();
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public List<InputMethodInfo> getInputMethodListAsUser(int userId) {
            int callingUid = Binder.getCallingUid();
            String callingPackage = this.this$0.mContext.getPackageManager().getPackagesForUid(callingUid)[0];
            if (Utils.isXtsPkg(callingPackage) == false) goto L7;
            return InputMethodManagerService.m4734$$Nest$mgetInputMethodListInternal(this.this$0, userId, 0, Binder.getCallingUid());
        L7:
            return InputMethodManagerService.m4734$$Nest$mgetInputMethodListInternal(this.this$0, userId, 0, 1000);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public List<InputMethodInfo> getEnabledInputMethodListAsUser(int userId) {
            return InputMethodManagerService.m4732$$Nest$mgetEnabledInputMethodListInternal(this.this$0, userId, 1000);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public List<InputMethodSubtype> getEnabledInputMethodSubtypeListAsUser(String imiId, boolean allowsImplicitlyEnabledSubtypes, int userId) {
            return InputMethodManagerService.m4733$$Nest$mgetEnabledInputMethodSubtypeListInternal(this.this$0, imiId, allowsImplicitlyEnabledSubtypes, userId, 1000);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void onCreateInlineSuggestionsRequest(int userId, InlineSuggestionsRequestInfo requestInfo, InlineSuggestionsRequestCallback cb) {
            boolean touchExplorationEnabled = AccessibilityManagerInternal.get().isTouchExplorationEnabled(userId);
            monitor-enter(ImfLock.class);
            this.this$0.getInputMethodBindingController(userId).onCreateInlineSuggestionsRequest(requestInfo, cb, touchExplorationEnabled);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public boolean switchToInputMethod(String imeId, int subtypeIndex, int userId) {
            monitor-enter(ImfLock.class);
            boolean r1 = InputMethodManagerService.m4759$$Nest$mswitchToInputMethodLocked(this.this$0, imeId, subtypeIndex, userId);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public boolean setInputMethodEnabled(String imeId, boolean enabled, int userId) {
            monitor-enter(ImfLock.class);
            InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L9
            if (settings.getMethodMap().containsKey(imeId) == true) goto L11;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            return false;
        L11:
            InputMethodManagerService.m4755$$Nest$msetInputMethodEnabledLocked(this.this$0, imeId, enabled, userId);     // Catch: Throwable -> L9
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void setVirtualDeviceInputMethodForAllUsers(int deviceId, String imeId) {
            if (deviceId == 0) goto L4;
            boolean r0 = true;
        L5:
            Preconditions.checkArgument(r0, TextUtils.formatSimple("DeviceId %d is not a virtual device id.", new Object[]{Integer.valueOf(deviceId)}));
            monitor-enter(ImfLock.class);
            if (imeId != null) goto L12;
            InputMethodManagerService.m4721$$Nest$fgetmVirtualDeviceMethodMap(this.this$0).remove(deviceId);     // Catch: Throwable -> L9
        L14:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            return;
        L12:
            if (InputMethodManagerService.m4721$$Nest$fgetmVirtualDeviceMethodMap(this.this$0).contains(deviceId) == true) goto L17;
            InputMethodManagerService.m4721$$Nest$fgetmVirtualDeviceMethodMap(this.this$0).put(deviceId, imeId);     // Catch: Throwable -> L9
            goto L14
        L17:
            throw new IllegalArgumentException("Virtual device " + deviceId + " already has a custom input method component");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L4:
            r0 = false;
            goto L5
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void registerInputMethodListListener(InputMethodManagerInternal.InputMethodListListener listener) {
            InputMethodManagerService.m4714$$Nest$fgetmInputMethodListListeners(this.this$0).addIfAbsent(listener);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public boolean transferTouchFocusToImeWindow(IBinder sourceInputToken, int displayId, int userId) {
            monitor-enter(ImfLock.class);
            InputMethodBindingController bindingController = this.this$0.getInputMethodBindingController(userId);     // Catch: Throwable -> L8
            if (displayId == bindingController.getCurTokenDisplayId()) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return false;
        L10:
            IBinder curHostInputToken = bindingController.getCurHostInputToken();     // Catch: Throwable -> L8
            if (curHostInputToken != null) goto L15;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return false;
        L15:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return this.this$0.mInputManagerInternal.transferTouchGesture(sourceInputToken, curHostInputToken, false);
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void reportImeControl(IBinder windowToken) {
            monitor-enter(ImfLock.class);
            int userId = InputMethodManagerService.m4752$$Nest$mresolveImeUserIdFromWindowLocked(this.this$0, windowToken);     // Catch: Throwable -> L7
            UserData userData = this.this$0.getUserData(userId);     // Catch: Throwable -> L7
            if (userData.mImeBindingState.mFocusedWindow == windowToken) goto L9;
            this.this$0.mFocusedWindowPerceptible.put(windowToken, true);     // Catch: Throwable -> L7
        L9:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void onImeParentChanged(int displayId) {
            monitor-enter(ImfLock.class);
            int userId = InputMethodManagerService.m4751$$Nest$mresolveImeUserIdFromDisplayIdLocked(this.this$0, displayId);     // Catch: Throwable -> L7
            UserData userData = this.this$0.getUserData(userId);     // Catch: Throwable -> L7
            ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L7
            if (visibilityStateComputer.getLastImeTargetWindow() == userData.mImeBindingState.mFocusedWindow) goto L9;
            InputMethodManagerService.m4716$$Nest$fgetmMenuController(this.this$0).hideInputMethodMenuLocked(userId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void removeImeSurface(int displayId) {
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).obtainMessage(InputMethodManagerService.MSG_REMOVE_IME_SURFACE).sendToTarget();
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void setHasVisibleImeLayeringOverlay(boolean hasVisibleOverlay, int displayId) {
            monitor-enter(ImfLock.class);
            int userId = InputMethodManagerService.m4751$$Nest$mresolveImeUserIdFromDisplayIdLocked(this.this$0, displayId);     // Catch: Throwable -> L7
            this.this$0.getUserData(userId).mVisibilityStateComputer.setHasVisibleImeLayeringOverlay(hasVisibleOverlay);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void onImeInputTargetVisibilityChanged(IBinder imeInputTarget, boolean visibleAndNotRemoved, int displayId) {
            monitor-enter(ImfLock.class);
            int userId = InputMethodManagerService.m4751$$Nest$mresolveImeUserIdFromDisplayIdLocked(this.this$0, displayId);     // Catch: Throwable -> L7
            this.this$0.getUserData(userId).mVisibilityStateComputer.onImeInputTargetVisibilityChanged(imeInputTarget, visibleAndNotRemoved);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void updateImeWindowStatus(final boolean disableImeIcon, final int displayId) {
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).post(new InputMethodManagerService$LocalServiceImpl$$ExternalSyntheticLambda0(this, disableImeIcon, displayId));
        }

        private /* synthetic */ void lambda$updateImeWindowStatus$0(boolean disableImeIcon, int displayId) {
            monitor-enter(ImfLock.class);
            InputMethodManagerService.m4763$$Nest$mupdateImeWindowStatusLocked(this.this$0, disableImeIcon, displayId);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void updateShouldShowImeSwitcher(int displayId, int userId) {
            monitor-enter(ImfLock.class);
            this.this$0.updateSystemUiLocked(userId);     // Catch: Throwable -> L7
            UserData userData = this.this$0.getUserData(userId);     // Catch: Throwable -> L7
            this.this$0.sendOnNavButtonFlagsChangedLocked(userData);     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void onSessionForAccessibilityCreated(int accessibilityConnectionId, IAccessibilityInputMethodSession session, int userId) {
            monitor-enter(ImfLock.class);
            UserData userData = this.this$0.getUserData(userId);     // Catch: Throwable -> L15
            InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L15
            if (userData.mCurClient == null) goto L18;
            this.this$0.clearClientSessionForAccessibilityLocked(userData.mCurClient, accessibilityConnectionId);     // Catch: Throwable -> L15
            SparseArray<AccessibilitySessionState> r6 = userData.mCurClient.mAccessibilitySessions;     // Catch: Throwable -> L15
            r6.put(accessibilityConnectionId, new AccessibilitySessionState(userData.mCurClient, accessibilityConnectionId, session));     // Catch: Throwable -> L13
            InputMethodManagerService.m4725$$Nest$mattachNewAccessibilityLocked(this.this$0, 11, true, userId);     // Catch: Throwable -> L13
            SessionState sessionState = userData.mCurClient.mCurSession;     // Catch: Throwable -> L13
            if (sessionState != null) goto L11;
            IInputMethodSession r7 = null;
        L12:
            IInputMethodSession imeSession = r7;
            SparseArray<IAccessibilityInputMethodSession> accessibilityInputMethodSessions = InputMethodManagerService.m4727$$Nest$mcreateAccessibilityInputMethodSessions(this.this$0, userData.mCurClient.mAccessibilitySessions);     // Catch: Throwable -> L13
            InputBindResult res = new InputBindResult(16, imeSession, accessibilityInputMethodSessions, null, bindingController.getCurId(), bindingController.getSequenceNumber(), false);     // Catch: Throwable -> L13
            userData.mCurClient.mClient.onBindAccessibilityService(res, accessibilityConnectionId);     // Catch: Throwable -> L13
            goto L18
        L11:
            r7 = sessionState.mSession;     // Catch: Throwable -> L13
        L18:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L13
            return;
        L13:
            th = th;
        L20:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L13
            throw th;
        L15:
            th = th;
            goto L20
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void unbindAccessibilityFromCurrentClient(final int accessibilityConnectionId, int userId) {
            monitor-enter(ImfLock.class);
            UserData userData = this.this$0.getUserData(userId);     // Catch: Throwable -> L7
            InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L7
            if (userData.mCurClient == null) goto L10;
            ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "unbindAccessibilityFromCurrentClientLocked: client=%s", new Object[]{userData.mCurClient.mClient.asBinder()});     // Catch: Throwable -> L7
            userData.mCurClient.mClient.onUnbindAccessibilityService(bindingController.getSequenceNumber(), accessibilityConnectionId);     // Catch: Throwable -> L7
        L10:
            if (bindingController.getCurMethod() == null) goto L14;
            Consumer<ClientState> clearClientSession = new InputMethodManagerService$LocalServiceImpl$$ExternalSyntheticLambda1(this, accessibilityConnectionId);     // Catch: Throwable -> L7
            InputMethodManagerService.m4709$$Nest$fgetmClientController(this.this$0).forAllClients(clearClientSession);     // Catch: Throwable -> L7
            AccessibilitySessionState session = userData.mEnabledAccessibilitySessions.get(accessibilityConnectionId);     // Catch: Throwable -> L7
            if (session == null) goto L14;
            InputMethodManagerService.m4731$$Nest$mfinishSessionForAccessibilityLocked(this.this$0, session);     // Catch: Throwable -> L7
            userData.mEnabledAccessibilitySessions.remove(accessibilityConnectionId);     // Catch: Throwable -> L7
        L14:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$unbindAccessibilityFromCurrentClient$1(int accessibilityConnectionId, ClientState c) {
            this.this$0.clearClientSessionForAccessibilityLocked(c, accessibilityConnectionId);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void maybeFinishStylusHandwriting() {
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).removeMessages(InputMethodManagerService.MSG_FINISH_HANDWRITING);
            InputMethodManagerService.m4712$$Nest$fgetmHandler(this.this$0).obtainMessage(InputMethodManagerService.MSG_FINISH_HANDWRITING).sendToTarget();
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public void onSwitchKeyboardLayoutShortcut(int direction, int displayId, IBinder targetWindowToken) {
            monitor-enter(ImfLock.class);
            int userId = InputMethodManagerService.m4751$$Nest$mresolveImeUserIdFromDisplayIdLocked(this.this$0, displayId);     // Catch: Throwable -> L7
            InputMethodManagerService.m4758$$Nest$mswitchKeyboardLayoutLocked(this.this$0, direction, this.this$0.getUserData(userId));     // Catch: Throwable -> L7
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public boolean isAiPanelShow() {
            return InputMethodManagerService.m4717$$Nest$fgetmRequestShowAiPanel(this.this$0);
        }

        @Override // com.android.server.inputmethod.InputMethodManagerInternal
        public IExtInputMethodManagerService getExt() {
            return InputMethodManagerService.m4711$$Nest$fgetmExt(this.this$0);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    private @interface MultiUserUnawareField {
    }

    final class MyPackageMonitor extends PackageMonitor {
        private ArrayList<String> mDataClearedPackages;
        final /* synthetic */ InputMethodManagerService this$0;

        /* synthetic */ MyPackageMonitor(InputMethodManagerService r1, InputMethodManagerServiceIA r2) {
            this(r1);
        }

        private MyPackageMonitor(InputMethodManagerService this$0) {
            this.this$0 = this$0;
            super(true);
            this.mDataClearedPackages = new ArrayList();
        }

        public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
            monitor-enter(ImfLock.class);
            int userId = getChangingUserId();     // Catch: Throwable -> L18
            InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L18
            String curInputMethodId = settings.getSelectedInputMethod();     // Catch: Throwable -> L18
            List<InputMethodInfo> methodList = settings.getMethodList();     // Catch: Throwable -> L18
            int numImes = methodList.size();     // Catch: Throwable -> L18
            if (curInputMethodId == null) goto L27;
            int i = 0;
        L7:
            if (i >= numImes) goto L27;
            InputMethodInfo imi = methodList.get(i);     // Catch: Throwable -> L18
            if (imi.getId().equals(curInputMethodId) == false) goto L26;
            int r11 = packages.length;     // Catch: Throwable -> L18
            int r12 = 0;
        L11:
            if (r12 >= r11) goto L26;
            String pkg = packages[r12];     // Catch: Throwable -> L18
            if (imi.getPackageName().equals(pkg) == false) goto L25;
            if (doit == false) goto L16;
            if (Utils.isXtsPkg(pkg) == false) goto L25;
            Slog.i(InputMethodManagerService.TAG, "onHandleForceStop " + imi);     // Catch: Throwable -> L18
            InputMethodManagerService.m4749$$Nest$mresetSelectedInputMethodAndSubtypeLocked(this.this$0, "", userId);     // Catch: Throwable -> L18
            InputMethodManagerService.m4726$$Nest$mchooseNewDefaultIMELocked(this.this$0, userId);     // Catch: Throwable -> L18
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L18
            return true;
        L16:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L18
            return true;
        L25:
            r12 = r12 + 1;     // Catch: Throwable -> L18
        L26:
            i = i + 1;     // Catch: Throwable -> L18
        L27:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L18
            return false;
        L18:
            th = move-exception;
            throw th;
        }

        public void onBeginPackageChanges() {
            clearPackageChangeState();
        }

        public void onPackageDataCleared(String packageName, int uid) {
            this.mDataClearedPackages.add(packageName);
        }

        public void onFinishPackageChanges() {
            onFinishPackageChangesInternal();
            clearPackageChangeState();
        }

        private void clearPackageChangeState() {
            this.mDataClearedPackages.clear();
        }

        private void onFinishPackageChangesInternal() {
            int userId = getChangingUserId();
            UserData userData = this.this$0.getUserData(userId);
            userData.mRawInputMethodMap.set(InputMethodManagerService.queryRawInputMethodServiceMap(this.this$0.mContext, userId));
            InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
            String curInputMethodId = settings.getSelectedInputMethod();
            List<InputMethodInfo> methodList = settings.getMethodList();
            ArrayList<String> imesToClearAdditionalSubtypes = new ArrayList();
            ArrayList<String> imesToBeDisabled = new ArrayList();
            int numImes = methodList.size();
            InputMethodInfo curIm = null;
            int i = 0;
        L4:
            if (i >= numImes) goto L18;
            InputMethodInfo imi = methodList.get(i);
            String imiId = imi.getId();
            if (imiId.equals(curInputMethodId) == false) goto L9;
            curIm = imi;
        L9:
            if (this.mDataClearedPackages.contains(imi.getPackageName()) == false) goto L11;
            imesToClearAdditionalSubtypes.add(imiId);
        L11:
            int change = isPackageDisappearing(imi.getPackageName());
            if (change != 3) goto L14;
            StringBuilder r15 = new StringBuilder();
            int i2 = i;
            r15.append("Input method uninstalled, disabling: ");
            r15.append(imi.getComponent());
            Slog.i(InputMethodManagerService.TAG, r15.toString());
            imesToBeDisabled.add(imi.getId());
        L17:
            i = i2 + 1;
            goto L4
        L14:
            i2 = i;
            if (change != 1) goto L17;
            Slog.i(InputMethodManagerService.TAG, "Input method reinstalling, clearing additional subtypes: " + imi.getComponent());
            imesToClearAdditionalSubtypes.add(imiId);
            goto L17
        L18:
            int i3 = 1;
            AdditionalSubtypeMap additionalSubtypeMap = AdditionalSubtypeMapRepository.get(userId);
            AdditionalSubtypeMap newAdditionalSubtypeMap = additionalSubtypeMap.cloneWithRemoveOrSelf(imesToClearAdditionalSubtypes);
            if (newAdditionalSubtypeMap != additionalSubtypeMap) goto L23;
            i3 = 0;
        L23:
            if (i3 == 0) goto L25;
            AdditionalSubtypeMapRepository.putAndSave(userId, newAdditionalSubtypeMap, settings.getMethodMap());
        L25:
            InputMethodMap newMethodMap = userData.mRawInputMethodMap.get().toInputMethodMap(newAdditionalSubtypeMap, 0, userData.mIsUnlockingOrUnlocked.get());
            boolean noUpdate = InputMethodMap.areSame(settings.getMethodMap(), newMethodMap);
            if (noUpdate == false) goto L31;
            if (imesToBeDisabled.isEmpty() == false) goto L31;
            return;
        L31:
            monitor-enter(ImfLock.class);
            int numImesToBeDisabled = imesToBeDisabled.size();     // Catch: Throwable -> L94
            int i4 = 0;
        L34:
            int numImesToBeDisabled2 = numImesToBeDisabled;
            if (i4 >= numImesToBeDisabled2) goto L45;
            UserData userData2 = userData;
            int i5 = i4;
            InputMethodSettings settings2 = settings;
            InputMethodManagerService.m4755$$Nest$msetInputMethodEnabledLocked(this.this$0, imesToBeDisabled.get(i4), false, userId);     // Catch: Throwable -> L40
            i4 = i5 + 1;     // Catch: Throwable -> L40
            userData = userData2;
            settings = settings2;
            numImesToBeDisabled = numImesToBeDisabled2;
        L40:
            th = th;
        L96:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L77
            throw th;
        L42:
            th = th;
            goto L96
        L45:
            if (noUpdate == false) goto L100;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L40
            return;
        L100:
            InputMethodSettingsRepository.put(userId, InputMethodSettings.create(newMethodMap, userId));     // Catch: Throwable -> L79
            this.this$0.postInputMethodSettingUpdatedLocked(false, userId);     // Catch: Throwable -> L79
            if (curIm == null) goto L82;
            int change2 = isPackageDisappearing(curIm.getPackageName());     // Catch: Throwable -> L79
            if (change2 == 2) goto L57;
            if (change2 == 3) goto L57;
            boolean changed = false;
        L83:
            boolean changed2 = changed;
        L84:
            if (curIm != null) goto L86;
            changed2 = InputMethodManagerService.m4726$$Nest$mchooseNewDefaultIMELocked(this.this$0, userId);     // Catch: Throwable -> L77
        L90:
            if (changed2 == false) goto L92;
            this.this$0.updateFromSettingsLocked(false, userId);     // Catch: Throwable -> L77
        L92:
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L77
            return;
        L86:
            if (changed2 == true) goto L90;
            if (isPackageModified(curIm.getPackageName()) == false) goto L90;
            changed2 = true;
        L57:
            PackageManager userAwarePackageManager = InputMethodManagerService.m4766$$Nest$smgetPackageManagerForUser(this.this$0.mContext, userId);     // Catch: Throwable -> L79
            ServiceInfo si = null;
            changed = false;
            PackageManager userAwarePackageManager2 = userAwarePackageManager;
            si = userAwarePackageManager2.getServiceInfo(curIm.getComponent(), PackageManager.ComponentInfoFlags.of(0));     // Catch: Throwable -> L40 PackageManager.NameNotFoundException -> L65
        L71:
            if (si != null) goto L83;
            Slog.i(InputMethodManagerService.TAG, "Current input method removed: " + curInputMethodId);     // Catch: Throwable -> L79
            InputMethodBindingController bindingController = this.this$0.getInputMethodBindingController(userId);     // Catch: Throwable -> L79
            InputMethodManagerService.m4765$$Nest$mupdateSystemUiLocked(this.this$0, 0, bindingController.getBackDisposition(), userId);     // Catch: Throwable -> L77
            if (InputMethodManagerService.m4726$$Nest$mchooseNewDefaultIMELocked(this.this$0, userId) == true) goto L83;
            changed2 = true;
            curIm = null;
            Slog.i(InputMethodManagerService.TAG, "Unsetting current input method");     // Catch: Throwable -> L77
            InputMethodManagerService.m4749$$Nest$mresetSelectedInputMethodAndSubtypeLocked(this.this$0, "", userId);     // Catch: Throwable -> L77
        L68:
            userAwarePackageManager2 = userAwarePackageManager;
        L70:
            changed = false;
            userAwarePackageManager2 = userAwarePackageManager;
            goto L71
        L82:
            changed = false;
        L79:
            th = th;
        L94:
            th = th;
        L77:
            th = th;
            goto L96
        }
    }

    static class SessionState {
        InputChannel mChannel;
        final ClientState mClient;
        final IInputMethodInvoker mMethod;
        IInputMethodSession mSession;
        final int mUserId;

        public String toString() {
            return "SessionState{uid=" + this.mClient.mUid + " pid=" + this.mClient.mPid + " method=" + Integer.toHexString(IInputMethodInvoker.getBinderIdentityHashCode(this.mMethod)) + " session=" + Integer.toHexString(System.identityHashCode(this.mSession)) + " channel=" + this.mChannel + " userId=" + this.mUserId + "}";
        }

        SessionState(ClientState client, IInputMethodInvoker method, IInputMethodSession session, InputChannel channel, int userId) {
            this.mClient = client;
            this.mMethod = method;
            this.mSession = session;
            this.mChannel = channel;
            this.mUserId = userId;
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    private @interface SharedByAllUsersField {
    }

    private static final class ShellCommandImpl extends ShellCommand {
        final InputMethodManagerService mService;

        ShellCommandImpl(InputMethodManagerService service) {
            this.mService = service;
        }

        public int onCommand(String cmd) {
            long identity = Binder.clearCallingIdentity();
            int r2 = onCommandWithSystemIdentity(cmd);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private int onCommandWithSystemIdentity(String cmd) {
            String r0 = TextUtils.emptyIfNull(cmd);
            switch(r0.hashCode()) {
                case -1067396926: goto L9;
                case 104385: goto L6;
                default: goto L11;
            };
        L11:
            byte r1 = -1;
        L12:
            switch(r1) {
                case 0: goto L64;
                case 1: goto L15;
                default: goto L14;
            };
        L15:
            String imeCommand = TextUtils.emptyIfNull(getNextArg());
            switch(imeCommand.hashCode()) {
                case -1298848381: goto L43;
                case -1067396926: goto L40;
                case 0: goto L37;
                case 1499: goto L34;
                case 113762: goto L31;
                case 3198785: goto L28;
                case 3322014: goto L25;
                case 108404047: goto L22;
                case 1671308008: goto L19;
                default: goto L45;
            };
        L45:
            byte r2 = -1;
        L46:
            switch(r2) {
                case 0: goto L62;
                case 1: goto L62;
                case 2: goto L62;
                case 3: goto L60;
                case 4: goto L58;
                case 5: goto L56;
                case 6: goto L54;
                case 7: goto L52;
                case 8: goto L50;
                default: goto L47;
            };
        L47:
            getOutPrintWriter().println("Unknown command: " + imeCommand);
            return -1;
        L50:
            return InputMethodManagerService.m4739$$Nest$mhandleShellCommandTraceInputMethod(this.mService, this);
        L52:
            return InputMethodManagerService.m4737$$Nest$mhandleShellCommandResetInputMethod(this.mService, this);
        L54:
            return InputMethodManagerService.m4738$$Nest$mhandleShellCommandSetInputMethod(this.mService, this);
        L56:
            return InputMethodManagerService.m4735$$Nest$mhandleShellCommandEnableDisableInputMethod(this.mService, this, false);
        L58:
            return InputMethodManagerService.m4735$$Nest$mhandleShellCommandEnableDisableInputMethod(this.mService, this, true);
        L60:
            return InputMethodManagerService.m4736$$Nest$mhandleShellCommandListInputMethods(this.mService, this);
        L62:
            return onImeCommandHelp();
        L19:
            if (imeCommand.equals("disable") == false) goto L65;
            r2 = 5;
            goto L46
        L65:
            r2 = -1;
            goto L46
        L22:
            if (imeCommand.equals("reset") == false) goto L66;
            r2 = 7;
            goto L46
        L66:
            r2 = -1;
            goto L46
        L25:
            if (imeCommand.equals("list") == false) goto L67;
            r2 = 3;
            goto L46
        L67:
            r2 = -1;
            goto L46
        L28:
            if (imeCommand.equals("help") == false) goto L68;
            r2 = 2;
            goto L46
        L68:
            r2 = -1;
            goto L46
        L31:
            if (imeCommand.equals("set") == false) goto L69;
            r2 = 6;
            goto L46
        L69:
            r2 = -1;
            goto L46
        L34:
            if (imeCommand.equals("-h") == false) goto L70;
            r2 = 1;
            goto L46
        L70:
            r2 = -1;
            goto L46
        L37:
            if (imeCommand.equals("") == false) goto L71;
            r2 = 0;
            goto L46
        L71:
            r2 = -1;
            goto L46
        L40:
            if (imeCommand.equals("tracing") == false) goto L72;
            r2 = 8;
            goto L46
        L72:
            r2 = -1;
            goto L46
        L43:
            if (imeCommand.equals("enable") == false) goto L73;
            r2 = 4;
            goto L46
        L73:
            r2 = -1;
            goto L46
        L14:
            return handleDefaultCommands(cmd);
        L64:
            return InputMethodManagerService.m4739$$Nest$mhandleShellCommandTraceInputMethod(this.mService, this);
        L6:
            if (r0.equals("ime") == false) goto L74;
            r1 = 1;
            goto L12
        L74:
            r1 = -1;
            goto L12
        L9:
            if (r0.equals("tracing") == false) goto L75;
            r1 = 0;
            goto L12
        L75:
            r1 = -1;
            goto L12
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("InputMethodManagerService commands:");     // Catch: Throwable -> L6
            pw.println("  help");     // Catch: Throwable -> L6
            pw.println("    Prints this help text.");     // Catch: Throwable -> L6
            pw.println("  dump [options]");     // Catch: Throwable -> L6
            pw.println("    Synonym of dumpsys.");     // Catch: Throwable -> L6
            pw.println("  ime <command> [options]");     // Catch: Throwable -> L6
            pw.println("    Manipulate IMEs.  Run \"ime help\" for details.");     // Catch: Throwable -> L6
            pw.println("  tracing <command>");     // Catch: Throwable -> L6
            pw.println("    start: Start tracing.");     // Catch: Throwable -> L6
            pw.println("    stop : Stop tracing.");     // Catch: Throwable -> L6
            pw.println("    help : Show help.");     // Catch: Throwable -> L6
            pw.close();
            return;
        L6:
            th = move-exception;
            if (pw != null) goto L13;
        L12:
            throw th;
        L13:
            pw.close();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            th.addSuppressed(th);
            goto L12
        }

        private int onImeCommandHelp() {
            IndentingPrintWriter pw = new IndentingPrintWriter(getOutPrintWriter(), "  ", 100);
            pw.println("ime <command>:");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("list [-a] [-s]");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("prints all enabled input methods.");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("-a: see all input methods");     // Catch: Throwable -> L6
            pw.println("-s: only a single summary line of each");     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.println("enable [--user <USER_ID>] <ID>");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("allows the given input method ID to be used.");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.print("--user <USER_ID>: Specify which user to enable.");     // Catch: Throwable -> L6
            pw.println(" Assumes the current user if not specified.");     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.println("disable [--user <USER_ID>] <ID>");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("disallows the given input method ID to be used.");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.print("--user <USER_ID>: Specify which user to disable.");     // Catch: Throwable -> L6
            pw.println(" Assumes the current user if not specified.");     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.println("set [--user <USER_ID>] <ID>");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("switches to the given input method ID.");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.print("--user <USER_ID>: Specify which user to enable.");     // Catch: Throwable -> L6
            pw.println(" Assumes the current user if not specified.");     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.println("reset [--user <USER_ID>]");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.println("reset currently selected/enabled IMEs to the default ones as if the device is initially booted with the current locale.");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            pw.print("--user <USER_ID>: Specify which user to reset.");     // Catch: Throwable -> L6
            pw.println(" Assumes the current user if not specified.");     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.close();
            return 0;
        L6:
            th = move-exception;
            pw.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ShellCommandResult {
        public static final int FAILURE = -1;
        public static final int SUCCESS = 0;
    }

    private static final class UserSwitchHandlerTask implements Runnable {
        IInputMethodClientInvoker mClientToBeReset;
        final InputMethodManagerService mService;
        final int mToUserId;

        UserSwitchHandlerTask(InputMethodManagerService service, int toUserId, IInputMethodClientInvoker clientToBeReset) {
            this.mService = service;
            this.mToUserId = toUserId;
            this.mClientToBeReset = clientToBeReset;
        }

        @Override // java.lang.Runnable
        public void run() {
            monitor-enter(ImfLock.class);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (InputMethodManagerService.m4720$$Nest$fgetmUserSwitchHandlerTask(this.mService) == this) goto L10;
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
            return;
        L10:
            InputMethodManagerService.m4762$$Nest$mswitchUserOnHandlerLocked(this.mService, InputMethodManagerService.m4720$$Nest$fgetmUserSwitchHandlerTask(this.mService).mToUserId, this.mClientToBeReset);     // Catch: Throwable -> L8
            InputMethodManagerService.m4722$$Nest$fputmUserSwitchHandlerTask(this.mService, null);     // Catch: Throwable -> L8
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        }
    }

    public static /* synthetic */ Integer $r8$lambda$1TqIrI9XJE4lxfBne2GydQhihes(InputMethodManagerService r0, int r1, int r2, IInputMethodClient r3) {
        return r0.lambda$getInputMethodWindowVisibleHeight$14(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$2yaYCGdi-FTFk0U0SqmQylExNO8, reason: not valid java name */
    public static /* synthetic */ InputMethodBindingController m4696$r8$lambda$2yaYCGdiFTFk0U0SqmQylExNO8(InputMethodManagerService r0, int r1) {
        return r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$983-c7NwhEF0jLAeuQHyp1MN8ns, reason: not valid java name */
    public static /* synthetic */ void m4697$r8$lambda$983c7NwhEF0jLAeuQHyp1MN8ns(PrintWriter r0, InputMethodInfo r1) {
        lambda$handleShellCommandResetInputMethod$23(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ajy1LD49oef-aSSPQjitblYi7ZI, reason: not valid java name */
    public static /* synthetic */ ImeVisibilityStateComputer m4698$r8$lambda$Ajy1LD49oefaSSPQjitblYi7ZI(InputMethodManagerService r0, int r1) {
        return r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BEz7B_GfpYorp3byjexNG-cuYqw, reason: not valid java name */
    public static /* synthetic */ boolean m4699$r8$lambda$BEz7B_GfpYorp3byjexNGcuYqw(String r0, InputMethodInfo r1) {
        return lambda$switchToInputMethodLocked$19(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KrFDfFLY4gr7ocZ24OnQ68i_eoY(InputMethodManagerService r0, boolean r1) {
        r0.lambda$systemRunning$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ql7KM-KMloBIXWj7EANZ9i7Cguk, reason: not valid java name */
    public static /* synthetic */ void m4700$r8$lambda$Ql7KMKMloBIXWj7EANZ9i7Cguk(InputMethodManagerService r0, int r1, int r2) {
        r0.lambda$showInputMethodPickerFromSystem$13(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$RS303u830fPb0-h1ENayK8Q3YOw, reason: not valid java name */
    public static /* synthetic */ void m4701$r8$lambda$RS303u830fPb0h1ENayK8Q3YOw(InputMethodManagerService r0, IBinder r1, boolean r2) {
        r0.lambda$reportPerceptibleAsync$11(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$RXRc-iFyhS9it8Ka156p1npK7sM, reason: not valid java name */
    public static /* synthetic */ boolean m4702$r8$lambda$RXRciFyhS9it8Ka156p1npK7sM(InputMethodManagerService r0, int r1, int r2, InputMethodSettings r3, InputMethodInfo r4) {
        return r0.lambda$getInputMethodListInternal$7(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$UbvZWBJ9FowzhVdSuWcXtKNAZQI(InputMethodManagerService r0, ClientState r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$YEceZF6bY0rI6AFbpWd7gUm8Nlk(InputMethodManagerService r0, IBinder r1, boolean r2, ImeTracker.Token r3) {
        r0.lambda$registerImeRequestedChangedListener$6(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZYCHd6BDARvPknQOP_ZKhBudPAc(InputMethodManagerService r0, ClientState r1, UserData r2) {
        r0.lambda$onClientRemoved$9(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$bCEyGYt3-EDhYtpurxMdhAGGV74, reason: not valid java name */
    public static /* synthetic */ void m4703$r8$lambda$bCEyGYt3EDhYtpurxMdhAGGV74(ClientState r0) {
        lambda$stopImeTrace$16(r0);
    }

    public static /* synthetic */ void $r8$lambda$c0KojPg373V8KtUN5zFx9FFQqgE(InputMethodManagerService r0) {
        r0.lambda$new$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$cCwLRaPWPX20-PL5OitHL2Oa0Ok, reason: not valid java name */
    public static /* synthetic */ void m4704$r8$lambda$cCwLRaPWPX20PL5OitHL2Oa0Ok(ClientState r0) {
        lambda$startImeTrace$15(r0);
    }

    public static /* synthetic */ void $r8$lambda$eaQwAKUurUC2LiayrMIP9Pm8bIg(InputMethodManagerService r0, String r1, int r2, int r3) {
        r0.lambda$systemRunning$5(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$eaRt77TJt2ZlBAijIwXdLdc8i9E(InputMethodManagerService r0, int r1, int r2, InputMethodSettings r3, InputMethodInfo r4) {
        return r0.lambda$getEnabledInputMethodListInternal$8(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$gc2B2e-iZDkF-fiY0ixQiu1CSIo, reason: not valid java name */
    public static /* synthetic */ boolean m4705$r8$lambda$gc2B2eiZDkFfiY0ixQiu1CSIo(String r0, InputMethodInfo r1) {
        return lambda$setInputMethodWithSubtypeIndexLocked$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lV4X0NWkmvwKMJD9qmfCJr7nTdI(InputMethodManagerService r0, int r1, ClientState r2) {
        r0.lambda$clearClientSessionsLocked$10(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$lYOQNX7TBpWmwEqMlATXd5Qayic(Printer r0, ClientState r1) {
        lambda$dumpClientController$21(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$m8aMtKnmJed5P-c7nAfFCT_Y8xs, reason: not valid java name */
    public static /* synthetic */ void m4706$r8$lambda$m8aMtKnmJed5Pc7nAfFCT_Y8xs(Printer r0, UserData r1) {
        lambda$dumpUserRepository$22(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$q4DisDUdgDij-anD9rB61YeXSHI, reason: not valid java name */
    public static /* synthetic */ void m4707$r8$lambda$q4DisDUdgDijanD9rB61YeXSHI(InputMethodManagerService r0, FileDescriptor r1, PrintWriter r2, String[] r3, boolean r4, UserData r5) {
        r0.lambda$dumpAsStringNoCheck$20(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$sPn4z2XMgE9CUUJb_hyzqDQmWhk(List r0, int r1, InputMethodManagerInternal.InputMethodListListener r2) {
        lambda$handleMessage$18(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tD4AJAoKEevBz8mIP80L1ekxO28(InputMethodManagerService r0, int r1, int r2, int r3) {
        r0.lambda$showInputMethodPickerFromClient$12(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m4708$$Nest$fgetmActivityManagerInternal(InputMethodManagerService r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientController, reason: not valid java name */
    static /* bridge */ /* synthetic */ ClientController m4709$$Nest$fgetmClientController(InputMethodManagerService r0) {
        return r0.mClientController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConcurrentMultiUserModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4710$$Nest$fgetmConcurrentMultiUserModeEnabled(InputMethodManagerService r0) {
        return r0.mConcurrentMultiUserModeEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtInputMethodManagerService m4711$$Nest$fgetmExt(InputMethodManagerService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4712$$Nest$fgetmHandler(InputMethodManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHwController, reason: not valid java name */
    static /* bridge */ /* synthetic */ HandwritingModeController m4713$$Nest$fgetmHwController(InputMethodManagerService r0) {
        return r0.mHwController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputMethodListListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m4714$$Nest$fgetmInputMethodListListeners(InputMethodManagerService r0) {
        return r0.mInputMethodListListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIoHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4715$$Nest$fgetmIoHandler(InputMethodManagerService r0) {
        return r0.mIoHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMenuController, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputMethodMenuController m4716$$Nest$fgetmMenuController(InputMethodManagerService r0) {
        return r0.mMenuController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequestShowAiPanel, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4717$$Nest$fgetmRequestShowAiPanel(InputMethodManagerService r0) {
        return r0.mRequestShowAiPanel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserDataRepository, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserDataRepository m4718$$Nest$fgetmUserDataRepository(InputMethodManagerService r0) {
        return r0.mUserDataRepository;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManagerInternal m4719$$Nest$fgetmUserManagerInternal(InputMethodManagerService r0) {
        return r0.mUserManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserSwitchHandlerTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserSwitchHandlerTask m4720$$Nest$fgetmUserSwitchHandlerTask(InputMethodManagerService r0) {
        return r0.mUserSwitchHandlerTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceMethodMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4721$$Nest$fgetmVirtualDeviceMethodMap(InputMethodManagerService r0) {
        return r0.mVirtualDeviceMethodMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserSwitchHandlerTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4722$$Nest$fputmUserSwitchHandlerTask(InputMethodManagerService r0, UserSwitchHandlerTask r1) {
        r0.mUserSwitchHandlerTask = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddStylusDeviceIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4723$$Nest$maddStylusDeviceIdLocked(InputMethodManagerService r0, int r1) {
        r0.addStylusDeviceIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyImeVisibilityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4724$$Nest$mapplyImeVisibilityLocked(InputMethodManagerService r0, IBinder r1, boolean r2, ImeTracker.Token r3, UserData r4) {
        r0.applyImeVisibilityLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mattachNewAccessibilityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4725$$Nest$mattachNewAccessibilityLocked(InputMethodManagerService r0, int r1, boolean r2, int r3) {
        r0.attachNewAccessibilityLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mchooseNewDefaultIMELocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4726$$Nest$mchooseNewDefaultIMELocked(InputMethodManagerService r0, int r1) {
        return r0.chooseNewDefaultIMELocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateAccessibilityInputMethodSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4727$$Nest$mcreateAccessibilityInputMethodSessions(InputMethodManagerService r0, SparseArray r1) {
        return r0.createAccessibilityInputMethodSessions(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateInputContentUriTokenLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ IInputContentUriToken m4728$$Nest$mcreateInputContentUriTokenLocked(InputMethodManagerService r0, Uri r1, String r2, UserData r3) {
        return r0.createInputContentUriTokenLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpAsStringNoCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4729$$Nest$mdumpAsStringNoCheck(InputMethodManagerService r0, FileDescriptor r1, PrintWriter r2, String[] r3, boolean r4) {
        r0.dumpAsStringNoCheck(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpDebug, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4730$$Nest$mdumpDebug(InputMethodManagerService r0, ProtoOutputStream r1, long r2) {
        r0.dumpDebug(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishSessionForAccessibilityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4731$$Nest$mfinishSessionForAccessibilityLocked(InputMethodManagerService r0, AccessibilitySessionState r1) {
        r0.finishSessionForAccessibilityLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetEnabledInputMethodListInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4732$$Nest$mgetEnabledInputMethodListInternal(InputMethodManagerService r0, int r1, int r2) {
        return r0.getEnabledInputMethodListInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetEnabledInputMethodSubtypeListInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4733$$Nest$mgetEnabledInputMethodSubtypeListInternal(InputMethodManagerService r0, String r1, boolean r2, int r3, int r4) {
        return r0.getEnabledInputMethodSubtypeListInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetInputMethodListInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4734$$Nest$mgetInputMethodListInternal(InputMethodManagerService r0, int r1, int r2, int r3) {
        return r0.getInputMethodListInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShellCommandEnableDisableInputMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4735$$Nest$mhandleShellCommandEnableDisableInputMethod(InputMethodManagerService r0, ShellCommand r1, boolean r2) {
        return r0.handleShellCommandEnableDisableInputMethod(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShellCommandListInputMethods, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4736$$Nest$mhandleShellCommandListInputMethods(InputMethodManagerService r0, ShellCommand r1) {
        return r0.handleShellCommandListInputMethods(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShellCommandResetInputMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4737$$Nest$mhandleShellCommandResetInputMethod(InputMethodManagerService r0, ShellCommand r1) {
        return r0.handleShellCommandResetInputMethod(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShellCommandSetInputMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4738$$Nest$mhandleShellCommandSetInputMethod(InputMethodManagerService r0, ShellCommand r1) {
        return r0.handleShellCommandSetInputMethod(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShellCommandTraceInputMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4739$$Nest$mhandleShellCommandTraceInputMethod(InputMethodManagerService r0, ShellCommand r1) {
        return r0.handleShellCommandTraceInputMethod(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideMySoftInputLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4740$$Nest$mhideMySoftInputLocked(InputMethodManagerService r0, ImeTracker.Token r1, int r2, int r3, UserData r4) {
        r0.hideMySoftInputLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyUserActionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4741$$Nest$mnotifyUserActionLocked(InputMethodManagerService r0, UserData r1) {
        r0.notifyUserActionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monImeSwitchButtonClickLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4742$$Nest$monImeSwitchButtonClickLocked(InputMethodManagerService r0, int r1, UserData r2) {
        r0.onImeSwitchButtonClickLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monStylusHandwritingReadyLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4743$$Nest$monStylusHandwritingReadyLocked(InputMethodManagerService r0, int r1, int r2, UserData r3) {
        r0.onStylusHandwritingReadyLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateResourceOverlay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4744$$Nest$monUpdateResourceOverlay(InputMethodManagerService r0, int r1) {
        r0.onUpdateResourceOverlay(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpublishLocalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4745$$Nest$mpublishLocalService(InputMethodManagerService r0) {
        r0.publishLocalService();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveStylusDeviceIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4746$$Nest$mremoveStylusDeviceIdLocked(InputMethodManagerService r0, int r1) {
        r0.removeStylusDeviceIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportFullscreenModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4747$$Nest$mreportFullscreenModeLocked(InputMethodManagerService r0, boolean r1, UserData r2) {
        r0.reportFullscreenModeLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportStartInputLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4748$$Nest$mreportStartInputLocked(InputMethodManagerService r0, IBinder r1, UserData r2) {
        r0.reportStartInputLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetSelectedInputMethodAndSubtypeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4749$$Nest$mresetSelectedInputMethodAndSubtypeLocked(InputMethodManagerService r0, String r1, int r2) {
        r0.resetSelectedInputMethodAndSubtypeLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetStylusHandwritingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4750$$Nest$mresetStylusHandwritingLocked(InputMethodManagerService r0, int r1) {
        r0.resetStylusHandwritingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveImeUserIdFromDisplayIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4751$$Nest$mresolveImeUserIdFromDisplayIdLocked(InputMethodManagerService r0, int r1) {
        return r0.resolveImeUserIdFromDisplayIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveImeUserIdFromWindowLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4752$$Nest$mresolveImeUserIdFromWindowLocked(InputMethodManagerService r0, IBinder r1) {
        return r0.resolveImeUserIdFromWindowLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetImeWindowStatusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4753$$Nest$msetImeWindowStatusLocked(InputMethodManagerService r0, int r1, int r2, UserData r3) {
        r0.setImeWindowStatusLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetInputMethodAndSubtypeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4754$$Nest$msetInputMethodAndSubtypeLocked(InputMethodManagerService r0, String r1, InputMethodSubtype r2, UserData r3) {
        r0.setInputMethodAndSubtypeLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetInputMethodEnabledLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4755$$Nest$msetInputMethodEnabledLocked(InputMethodManagerService r0, String r1, boolean r2, int r3) {
        return r0.setInputMethodEnabledLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldOfferSwitchingToNextInputMethodLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4756$$Nest$mshouldOfferSwitchingToNextInputMethodLocked(InputMethodManagerService r0, UserData r1) {
        return r0.shouldOfferSwitchingToNextInputMethodLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowMySoftInputLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4757$$Nest$mshowMySoftInputLocked(InputMethodManagerService r0, ImeTracker.Token r1, int r2, int r3, UserData r4) {
        r0.showMySoftInputLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchKeyboardLayoutLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4758$$Nest$mswitchKeyboardLayoutLocked(InputMethodManagerService r0, int r1, UserData r2) {
        r0.switchKeyboardLayoutLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchToInputMethodLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4759$$Nest$mswitchToInputMethodLocked(InputMethodManagerService r0, String r1, int r2, int r3) {
        return r0.switchToInputMethodLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchToNextInputMethodLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4760$$Nest$mswitchToNextInputMethodLocked(InputMethodManagerService r0, boolean r1, UserData r2) {
        return r0.switchToNextInputMethodLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchToPreviousInputMethodLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4761$$Nest$mswitchToPreviousInputMethodLocked(InputMethodManagerService r0, UserData r1) {
        return r0.switchToPreviousInputMethodLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchUserOnHandlerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4762$$Nest$mswitchUserOnHandlerLocked(InputMethodManagerService r0, int r1, IInputMethodClientInvoker r2) {
        r0.switchUserOnHandlerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateImeWindowStatusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4763$$Nest$mupdateImeWindowStatusLocked(InputMethodManagerService r0, boolean r1, int r2) {
        r0.updateImeWindowStatusLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateStatusIconLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4764$$Nest$mupdateStatusIconLocked(InputMethodManagerService r0, String r1, int r2, UserData r3) {
        r0.updateStatusIconLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSystemUiLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4765$$Nest$mupdateSystemUiLocked(InputMethodManagerService r0, int r1, int r2, int r3) {
        r0.updateSystemUiLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetPackageManagerForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m4766$$Nest$smgetPackageManagerForUser(Context r0, int r1) {
        return getPackageManagerForUser(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisStylusDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4767$$Nest$smisStylusDevice(InputDevice r0) {
        return isStylusDevice(r0);
    }

    static {
        VIRTUAL_STYLUS_ID_FOR_TEST = 999999;
        IME_ACCESSIBILITY_MATTER_WINDOWS = Arrays.asList(new String[]{"com.tencent.mm/com.tencent.mm.ui.LauncherUI", "com.tencent.mm/com.tencent.mm.ui.chatting.ChattingUI", "com.ss.android.lark/com.ss.android.lark.chatwindow.ChatWindowActivity", "com.tencent.mobileqq/com.tencent.mobileqq.activity.SplashActivity", "com.tencent.mobileqq/com.tencent.mobileqq.activity.ChatActivity", "com.tencent.mm/com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.androidqqmail/com.tencent.qqmail.activity.compose.ComposeMailActivity", "com.netease.mail/com.netease.mobimail.module.mailcompose.MailComposeActivity", "com.netease.mail/com.netease.mobimail.module.conversation.ConversationActivity", "com.google.android.gm/com.google.android.gm.ComposeActivityGmail", "com.microsoft.office.outlook/com.microsoft.office.outlook.compose.ComposeActivityWithFragment", "com.xingin.xhs/com.xingin.capa.v2.feature.post.lcb.activity.CapaLCBPostNoteActivity", "com.xingin.xhs/com.xingin.capa.v2.feature.entrance.view.activity.edittab.Capa2TabEditActivity", "com.taobao.taobao/com.taobao.ugc.framework.UGCContainerActivity", "com.dianping.v1/com.dianping.ugc.content.GenericAddContentActivity", "com.jingdong.app.mall/com.jd.lib.evaluatecenter.floor.view.CommentFloorActivity", "com.xunmeng.pinduoduo/com.xunmeng.pinduoduo.activity.NewPageActivity", "com.android.email/com.android.mail.compose.ComposeActivity", "com.netease.mobimail/com.netease.mobimail.module.mailcompose.MailComposeActivity"});
    }

    static boolean shouldEnableConcurrentMultiUserMode(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == true) goto L5;
    L9:
        return false;
    L5:
        if (UserManager.isVisibleBackgroundUsersEnabled() == false) goto L9;
        if (context.getResources().getBoolean(R.bool.config_perDisplayFocusEnabled) == false) goto L9;
        return true;
    }

    private int resolveImeUserIdLocked(int callingProcessUserId) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L6;
        return callingProcessUserId;
    L6:
        return this.mCurrentImeUserId;
    }

    private int resolveImeUserIdLocked(int callingProcessUserId, IInputMethodClient client) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L9;
        if (callingProcessUserId != 0) goto L7;
        ClientState clientState = this.mClientController.getClient(client.asBinder());
        return this.mUserManagerInternal.getUserAssignedToDisplay(clientState.mSelfReportedDisplayId);
    L7:
        return callingProcessUserId;
    L9:
        return this.mCurrentImeUserId;
    }

    private int resolveImeUserIdFromDisplayIdLocked(int displayId) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L6;
        return this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
    L6:
        return this.mCurrentImeUserId;
    }

    private int resolveImeUserIdFromWindowLocked(IBinder windowToken) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L6;
        int displayId = this.mWindowManagerInternal.getDisplayIdForWindow(windowToken);
        return this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
    L6:
        int displayId2 = this.mCurrentImeUserId;
        return displayId2;
    }

    UserData getUserData(int userId) {
        return this.mUserDataRepository.getOrCreate(userId);
    }

    InputMethodBindingController getInputMethodBindingController(int userId) {
        return getUserData(userId).mBindingController;
    }

    IInputMethodInvoker getCurMethodLocked() {
        return getInputMethodBindingController(this.mCurrentImeUserId).getCurMethod();
    }

    private void onSecureSettingsChangedLocked(String key, int userId) {
        switch(key.hashCode()) {
            case -1828155998: goto L21;
            case -1777368012: goto L18;
            case 363545143: goto L15;
            case 1194058837: goto L12;
            case 1750618562: goto L9;
            case 2126247871: goto L6;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L26;
            case 5: goto L26;
            default: goto L47;
        };
    L26:
        boolean enabledChanged = false;
        String newEnabled = InputMethodSettingsRepository.get(userId).getEnabledInputMethodsStr();
        UserData userData = getUserData(userId);
        if (userData.mLastEnabledInputMethodsStr.equals(newEnabled) == true) goto L29;
        userData.mLastEnabledInputMethodsStr = newEnabled;
        enabledChanged = true;
    L29:
        updateInputMethodsFromSettingsLocked(enabledChanged, userId);
        return;
    L30:
        InputMethodManager.invalidateLocalStylusHandwritingAvailabilityCaches();
        InputMethodManager.invalidateLocalConnectionlessStylusHandwritingAvailabilityCaches();
        return;
    L31:
        int accessibilitySoftKeyboardSetting = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_soft_keyboard_mode", 0, userId);
        UserData userData2 = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData2.mVisibilityStateComputer;
        visibilityStateComputer.getImePolicy().setA11yRequestNoSoftKeyboard(accessibilitySoftKeyboardSetting);
        if (visibilityStateComputer.getImePolicy().isA11yRequestNoSoftKeyboard() == false) goto L35;
        ImeTracker.Token statsToken = createStatsTokenForFocusedClient(false, 16, userId);
        setImeVisibilityOnFocusedWindowClient(false, userData2, statsToken);
        return;
    L35:
        if (isShowRequestedForCurrentWindow(userId) == false) goto L44;
        ImeTracker.Token statsToken2 = createStatsTokenForFocusedClient(true, 9, userId);
        setImeVisibilityOnFocusedWindowClient(true, userData2, statsToken2);
        return;
    L44:
        return;
    L47:
        return;
    L38:
        if (userId != this.mCurrentImeUserId) goto L46;
        this.mMenuController.updateKeyboardFromSettingsLocked(userId);
        return;
    L46:
        return;
    L6:
        if (key.equals("enabled_input_methods") == false) goto L23;
        r0 = 4;
        goto L24
    L9:
        if (key.equals("show_ime_with_hard_keyboard") == false) goto L23;
        r0 = 0;
        goto L24
    L12:
        if (key.equals("selected_input_method_subtype") == false) goto L23;
        r0 = 5;
        goto L24
    L15:
        if (key.equals("accessibility_soft_keyboard_mode") == false) goto L23;
        r0 = 1;
        goto L24
    L18:
        if (key.equals("default_input_method") == false) goto L23;
        r0 = 3;
        goto L24
    L21:
        if (key.equals("stylus_handwriting_enabled") == false) goto L23;
        r0 = 2;
        goto L24
    }

    void onActionLocaleChanged(LocaleList prevLocales, LocaleList newLocales) {
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "onActionLocaleChanged prev=%s new=%s", new Object[]{prevLocales, newLocales});
        monitor-enter(ImfLock.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSystemReady == true) goto L10;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        return;
    L10:
        int[] r1 = this.mUserManagerInternal.getUserIds();     // Catch: Throwable -> L8
        int r2 = r1.length;     // Catch: Throwable -> L8
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L13;
        int userId = r1[r4];     // Catch: Throwable -> L8
        UserData userData = getUserData(userId);     // Catch: Throwable -> L8
        AdditionalSubtypeMap additionalSubtypeMap = AdditionalSubtypeMapRepository.get(userId);     // Catch: Throwable -> L8
        RawInputMethodMap rawMethodMap = queryRawInputMethodServiceMap(this.mContext, userId);     // Catch: Throwable -> L8
        userData.mRawInputMethodMap.set(rawMethodMap);     // Catch: Throwable -> L8
        InputMethodMap methodMap = rawMethodMap.toInputMethodMap(additionalSubtypeMap, 0, userData.mIsUnlockingOrUnlocked.get());     // Catch: Throwable -> L8
        InputMethodSettings settings = InputMethodSettings.create(methodMap, userId);     // Catch: Throwable -> L8
        InputMethodSettingsRepository.put(userId, settings);     // Catch: Throwable -> L8
        r4 = r4 + 1;     // Catch: Throwable -> L8
        goto L11
    L13:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
    }

    void scheduleSwitchUserTaskLocked(int userId, IInputMethodClientInvoker clientToBeReset) {
        if (this.mUserSwitchHandlerTask != null) goto L5;
    L9:
        UserData userData = getUserData(userId);
        ImeTracker.Token statsToken = createStatsTokenForFocusedClient(false, 10, userId);
        setImeVisibilityOnFocusedWindowClient(false, userData, statsToken);
        UserSwitchHandlerTask task = new UserSwitchHandlerTask(this, userId, clientToBeReset);
        this.mUserSwitchHandlerTask = task;
        this.mIoHandler.post(task);
        return;
    L5:
        if (this.mUserSwitchHandlerTask.mToUserId != userId) goto L8;
        this.mUserSwitchHandlerTask.mClientToBeReset = clientToBeReset;
        return;
    L8:
        this.mIoHandler.removeCallbacks(this.mUserSwitchHandlerTask);
        goto L9
    }

    InputMethodManagerService(Context context, boolean concurrentMultiUserModeEnabled, Looper uiLooper, Handler ioHandler, IntFunction<InputMethodBindingController> bindingControllerForTesting) {
        this.mObricExt = (IObricInputMethodManagerService) ObricImplFactory.getImpl(IObricInputMethodManagerService.class, new Object[]{this});
        InputMethodManagerServiceIA r0 = null;
        this.mAudioManagerInternal = null;
        this.mVdmInternal = null;
        this.mDisplayManagerInternal = null;
        this.mVirtualDeviceMethodMap = new SparseArray();
        this.mDumper = new AnonymousClass1(this);
        this.mFocusedWindowPerceptible = new WeakHashMap();
        this.mIsInteractive = true;
        this.mMyPackageMonitor = new MyPackageMonitor(this, r0);
        this.mInputMethodListListeners = new CopyOnWriteArrayList();
        this.mImeTargetWindowMap = new WeakHashMap();
        this.mStartInputHistory = new StartInputHistory();
        this.mSoftInputShowHideHistory = new SoftInputShowHideHistory();
        this.mPriorityDumper = new AnonymousClass5(this);
        this.mExt = (IExtInputMethodManagerService) ExtImplFactory.getImpl(IExtInputMethodManagerService.class, new Object[]{this});
        monitor-enter(ImfLock.class);
        this.mConcurrentMultiUserModeEnabled = concurrentMultiUserModeEnabled;     // Catch: Throwable -> L11
        this.mContext = context;     // Catch: Throwable -> L11
        this.mRes = context.getResources();     // Catch: Throwable -> L11
        this.mHandler = Handler.createAsync(uiLooper, this);     // Catch: Throwable -> L11
        this.mIoHandler = ioHandler;     // Catch: Throwable -> L11
        SystemLocaleWrapper.onStart(context, new InputMethodManagerService$$ExternalSyntheticLambda10(this), this.mIoHandler);     // Catch: Throwable -> L11
        this.mImeTrackerService = new ImeTrackerService(this.mHandler);     // Catch: Throwable -> L11
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Throwable -> L11
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L11
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L11
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);     // Catch: Throwable -> L11
        this.mImePlatformCompatUtils = new ImePlatformCompatUtils();     // Catch: Throwable -> L11
        this.mInputMethodDeviceConfigs = new InputMethodDeviceConfigs();     // Catch: Throwable -> L11
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);     // Catch: Throwable -> L11
        this.mSlotIme = this.mContext.getString(R.string.zen_mode_default_every_night_name);     // Catch: Throwable -> L11
        this.mShowOngoingImeSwitcherForPhones = false;     // Catch: Throwable -> L11
        ProtoLog.init(ImeProtoLogGroup.values());     // Catch: Throwable -> L11
        this.mCurrentImeUserId = this.mActivityManagerInternal.getCurrentUserId();     // Catch: Throwable -> L11
        IntFunction<InputMethodBindingController> bindingControllerFactory = new InputMethodManagerService$$ExternalSyntheticLambda11(this);     // Catch: Throwable -> L11
        IntFunction<ImeVisibilityStateComputer> visibilityStateComputerFactory = new InputMethodManagerService$$ExternalSyntheticLambda12(this);     // Catch: Throwable -> L11
        if (bindingControllerForTesting == null) goto L7;
        IntFunction<InputMethodBindingController> r5 = bindingControllerForTesting;
    L8:
        this.mUserDataRepository = new UserDataRepository(r5, visibilityStateComputerFactory);     // Catch: Throwable -> L11
        this.mMenuController = new InputMethodMenuController(this);     // Catch: Throwable -> L11
        this.mMenuControllerNew = null;     // Catch: Throwable -> L11
        this.mVisibilityApplier = new DefaultImeVisibilityApplier(this);     // Catch: Throwable -> L11
        this.mClientController = new ClientController(this.mPackageManagerInternal);     // Catch: Throwable -> L11
        this.mClientController.addClientControllerCallback(new InputMethodManagerService$$ExternalSyntheticLambda13(this));     // Catch: Throwable -> L11
        this.mPreventImeStartupUnlessTextEditor = this.mRes.getBoolean(R.bool.config_preventImeStartupUnlessTextEditor);     // Catch: Throwable -> L11
        this.mNonPreemptibleInputMethods = this.mRes.getStringArray(R.array.config_restrictedImagesServices);     // Catch: Throwable -> L11
        Runnable discardDelegationTextRunnable = new InputMethodManagerService$$ExternalSyntheticLambda14(this);     // Catch: Throwable -> L11
        this.mHwController = new HandwritingModeController(this.mContext, uiLooper, new InkWindowInitializer(this, r0), discardDelegationTextRunnable);     // Catch: Throwable -> L11
        registerDeviceListenerAndCheckStylusSupport();     // Catch: Throwable -> L11
        this.mInputMethodManagerInternal = new LocalServiceImpl(this, r0);     // Catch: Throwable -> L11
        getExt().init(this.mHandler.getLooper());     // Catch: Throwable -> L11
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return;
    L7:
        r5 = bindingControllerFactory;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ InputMethodBindingController lambda$new$0(int userId) {
        return new InputMethodBindingController(userId, this);
    }

    private /* synthetic */ ImeVisibilityStateComputer lambda$new$1(int userId) {
        return new ImeVisibilityStateComputer(this, userId);
    }

    private /* synthetic */ void lambda$new$2(ClientState c) {
        onClientRemoved(c);
    }

    private /* synthetic */ void lambda$new$3() {
        discardHandwritingDelegationText();
    }

    private void onUpdateEditorToolTypeLocked(int toolType, int userId) {
        IInputMethodInvoker curMethod = getInputMethodBindingController(userId).getCurMethod();
        if (curMethod == null) goto L6;
        curMethod.updateEditorToolType(toolType);
        return;
    }

    private void discardHandwritingDelegationText() {
        monitor-enter(ImfLock.class);
        IInputMethodInvoker curMethod = getCurMethodLocked();     // Catch: Throwable -> L7
        if (curMethod == null) goto L9;
        curMethod.discardHandwritingDelegationText();     // Catch: Throwable -> L7
    L9:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void resetDefaultImeLocked(Context context, int userId) {
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        String selectedMethodId = bindingController.getSelectedMethodId();
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodInfo selectedImi = settings.getMethodMap().get(selectedMethodId);
        if (selectedImi != null) goto L5;
    L7:
        List<InputMethodInfo> suitableImes = InputMethodInfoUtils.getDefaultEnabledImes(context, settings.getEnabledInputMethodList());
        if (suitableImes.isEmpty() == false) goto L11;
        Slog.i(TAG, "No default found");
        return;
    L11:
        InputMethodInfo defIm = suitableImes.get(0);
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Default found, using %s", new Object[]{defIm.getId()});
        setSelectedInputMethodAndSubtypeLocked(defIm, -1, false, userId);
        return;
    L5:
        if (selectedImi.isSystem() == true) goto L7;
    }

    private static PackageManager getPackageManagerForUser(Context context, int userId) {
        if (context.getUserId() != userId) goto L6;
        return context.getPackageManager();
    L6:
        return context.createContextAsUser(UserHandle.of(userId), 0).getPackageManager();
    }

    private void switchUserOnHandlerLocked(int newUserId, IInputMethodClientInvoker clientToBeReset) {
        int prevUserId = this.mCurrentImeUserId;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Switching user stage 1/3. newUserId=%s prevUserId=%s", new Object[]{Integer.valueOf(newUserId), Integer.valueOf(prevUserId)});
        onUnbindCurrentMethodByReset(prevUserId);
        InputMethodBindingController bindingController = getInputMethodBindingController(prevUserId);
        bindingController.unbindCurrentMethod();
        unbindCurrentClientLocked(6, prevUserId);
        UserData newUserData = getUserData(newUserId);
        newUserData.mLastEnabledInputMethodsStr = "";
        this.mCurrentImeUserId = newUserId;
        String defaultImiId = SecureSettingsWrapper.getString("default_input_method", null, newUserId);
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Switching user stage 2/3. newUserId=%s defaultImiId=%s", new Object[]{Integer.valueOf(newUserId), defaultImiId});
        boolean initialUserSwitch = TextUtils.isEmpty(defaultImiId);
        InputMethodSettings newSettings = InputMethodSettingsRepository.get(newUserId);
        postInputMethodSettingUpdatedLocked(initialUserSwitch, newUserId);
        if (TextUtils.isEmpty(newSettings.getSelectedInputMethod()) == false) goto L5;
        resetDefaultImeLocked(this.mContext, newUserId);
    L5:
        updateFromSettingsLocked(true, newUserId);
        if (newUserData.mSubtypeForKeyboardLayoutMapping == null) goto L8;
        Pair<InputMethodSubtypeHandle, InputMethodSubtype> subtypeHandleAndSubtype = newUserData.mSubtypeForKeyboardLayoutMapping;
        this.mInputManagerInternal.onInputMethodSubtypeChangedForKeyboardLayoutMapping(newUserId, (InputMethodSubtypeHandle) subtypeHandleAndSubtype.first, (InputMethodSubtype) subtypeHandleAndSubtype.second);
    L8:
        if (initialUserSwitch == false) goto L10;
        InputMethodUtils.setNonSelectedSystemImesDisabledUntilUsed(getPackageManagerForUser(this.mContext, newUserId), newSettings.getEnabledInputMethodList());
    L10:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Switching user stage 3/3. newUserId=%s selectedIme=%s", new Object[]{Integer.valueOf(newUserId), newSettings.getSelectedInputMethod()});
        if (this.mIsInteractive == false) goto L18;
        if (clientToBeReset == null) goto L19;
        ClientState cs = this.mClientController.getClient(clientToBeReset.asBinder());
        if (cs != null) goto L16;
        return;
    L16:
        cs.mClient.scheduleStartInputIfNecessary(newUserData.mInFullscreenMode);
        return;
    L19:
        return;
    }

    private void waitForUserInitialization() {
        int[] userIds = this.mUserManagerInternal.getUserIds();
        long deadlineNanos = SystemClock.elapsedRealtimeNanos() + TimeUnit.MILLISECONDS.toNanos(3000);
        boolean interrupted = false;
        int r4 = userIds.length;     // Catch: Throwable -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L16;
        int userId = userIds[r5];     // Catch: Throwable -> L11
        CountDownLatch latch = getUserData(userId).mBackgroundLoadLatch;     // Catch: Throwable -> L11
    L24:
        long remainingNanos = Math.max(deadlineNanos - SystemClock.elapsedRealtimeNanos(), 0);     // Catch: Throwable -> L11 InterruptedException -> L14
        boolean awaitResult = latch.await(remainingNanos, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L11 InterruptedException -> L14
        if (awaitResult == true) goto L13;
        Slog.w(TAG, "Timed out for user#" + userId + " to be initialized");     // Catch: Throwable -> L11
    L13:
        r5 = r5 + 1;
    L15:
        interrupted = true;
        goto L24
    L16:
        if (interrupted == false) goto L30;
        Thread.currentThread().interrupt();
        return;
    L30:
        return;
    L11:
        th = move-exception;
        if (interrupted == false) goto L21;
        Thread.currentThread().interrupt();
    L21:
        throw th;
    }

    public void systemRunning() {
        waitForUserInitialization();
        monitor-enter(ImfLock.class);
        int r3 = 0;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "--- systemReady", new Object[0]);     // Catch: Throwable -> L9
        if (this.mSystemReady == true) goto L15;
        this.mSystemReady = true;     // Catch: Throwable -> L9
        int currentImeUserId = this.mCurrentImeUserId;     // Catch: Throwable -> L9
        this.mStatusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L9
        hideStatusBarIconLocked(currentImeUserId);     // Catch: Throwable -> L9
        InputMethodBindingController bindingController = getInputMethodBindingController(currentImeUserId);     // Catch: Throwable -> L9
        updateSystemUiLocked(bindingController.getImeWindowVis(), bindingController.getBackDisposition(), currentImeUserId);     // Catch: Throwable -> L9
        this.mShowOngoingImeSwitcherForPhones = this.mRes.getBoolean(17892058);     // Catch: Throwable -> L9
        if (this.mShowOngoingImeSwitcherForPhones == false) goto L11;
        this.mWindowManagerInternal.setOnHardKeyboardStatusChangeListener(new InputMethodManagerService$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L9
    L11:
        this.mMyPackageMonitor.register(this.mContext, UserHandle.ALL, this.mIoHandler);     // Catch: Throwable -> L9
        SecureSettingsChangeCallback.register(this.mHandler, this.mContext.getContentResolver(), new String[]{"accessibility_soft_keyboard_mode", "default_input_method", "enabled_input_methods", "selected_input_method_subtype", "show_ime_with_hard_keyboard", "stylus_handwriting_enabled"}, new InputMethodManagerService$$ExternalSyntheticLambda4(this));     // Catch: Throwable -> L9
        IntentFilter broadcastFilterForAllUsers = new IntentFilter();     // Catch: Throwable -> L9
        broadcastFilterForAllUsers.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");     // Catch: Throwable -> L9
        this.mContext.registerReceiverAsUser(new ImmsBroadcastReceiverForAllUsers(this, null), UserHandle.ALL, broadcastFilterForAllUsers, null, null, 2);     // Catch: Throwable -> L9
        AdditionalSubtypeMapRepository.startWriterThread();     // Catch: Throwable -> L9
        int[] r4 = this.mUserManagerInternal.getUserIds();     // Catch: Throwable -> L9
        int r5 = r4.length;     // Catch: Throwable -> L9
    L12:
        if (r3 >= r5) goto L14;
        int userId = r4[r3];     // Catch: Throwable -> L9
        onUserReadyLocked(userId);     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L12
    L14:
        getExt().systemRunning();     // Catch: Throwable -> L9
    L15:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$systemRunning$4(boolean r4) {
        this.mHandler.obtainMessage(MSG_HARD_KEYBOARD_SWITCH_CHANGED, r4 ? 1 : 0, 0).sendToTarget();
    }

    private /* synthetic */ void lambda$systemRunning$5(String key, int flags, int userId) {
        monitor-enter(ImfLock.class);
        onSecureSettingsChangedLocked(key, userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onUserReadyLocked(int userId) {
        if (this.mUserManagerInternal.isUserRunning(userId) == true) goto L5;
        return;
    L5:
        String defaultImiId = SecureSettingsWrapper.getString("default_input_method", null, userId);
        boolean imeSelectedOnBoot = !TextUtils.isEmpty(defaultImiId);
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (imeSelectedOnBoot == true) goto L8;
        boolean r4 = true;
    L9:
        postInputMethodSettingUpdatedLocked(r4, userId);
        updateFromSettingsLocked(true, userId);
        InputMethodUtils.setNonSelectedSystemImesDisabledUntilUsed(getPackageManagerForUser(this.mContext, userId), settings.getEnabledInputMethodList());
        return;
    L8:
        r4 = false;
        goto L9
    }

    void registerImeRequestedChangedListener() {
        this.mWindowManagerInternal.setOnImeRequestedChangedListener(new InputMethodManagerService$$ExternalSyntheticLambda8(this));
    }

    private /* synthetic */ void lambda$registerImeRequestedChangedListener$6(IBinder windowToken, boolean imeVisible, ImeTracker.Token statsToken) {
        if (imeVisible == false) goto L4;
        showCurrentInputInternal(windowToken, statsToken);
        return;
    L4:
        hideCurrentInputInternal(windowToken, statsToken);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfo getCurrentInputMethodInfoAsUser(int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L5:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        String selectedImeId = settings.getSelectedInputMethod();
        return settings.getMethodMap().get(selectedImeId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfoSafeList getInputMethodList(int userId, int directBootAwareness) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        if (this.mUserManagerInternal.exists(userId) == false) goto L8;
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        InputMethodInfoSafeList r3 = InputMethodInfoSafeList.create(getInputMethodListInternal(userId, directBootAwareness, callingUid));     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return r3;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        return InputMethodInfoSafeList.create(null);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfoSafeList getEnabledInputMethodList(int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        if (this.mUserManagerInternal.exists(userId) == false) goto L8;
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        InputMethodInfoSafeList r3 = InputMethodInfoSafeList.create(getEnabledInputMethodListInternal(userId, callingUid));     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return r3;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        return InputMethodInfoSafeList.create(null);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public List<InputMethodInfo> getInputMethodListLegacy(int userId, int directBootAwareness) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        if (this.mUserManagerInternal.exists(userId) == false) goto L8;
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        List<InputMethodInfo> r3 = getInputMethodListInternal(userId, directBootAwareness, callingUid);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return r3;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        return Collections.emptyList();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public List<InputMethodInfo> getEnabledInputMethodListLegacy(int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        if (this.mUserManagerInternal.exists(userId) == false) goto L8;
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        List<InputMethodInfo> r3 = getEnabledInputMethodListInternal(userId, callingUid);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return r3;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        return Collections.emptyList();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isStylusHandwritingAvailableAsUser(int userId, boolean connectionless) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        monitor-enter(ImfLock.class);
        boolean r2 = false;
        if (isStylusHandwritingEnabled(this.mContext, userId) == true) goto L14;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return false;
    L14:
        if (userId != this.mCurrentImeUserId) goto L24;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L11
        if (bindingController.supportsStylusHandwriting() == false) goto L22;
        if (connectionless == true) goto L19;
    L20:
        r2 = true;
        goto L22
    L19:
        if (bindingController.supportsConnectionlessStylusHandwriting() == true) goto L20;
    L22:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return r2;
    L24:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L11
        InputMethodInfo imi = settings.getMethodMap().get(settings.getSelectedInputMethod());     // Catch: Throwable -> L11
        if (imi != null) goto L27;
    L33:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return r2;
    L27:
        if (imi.supportsStylusHandwriting() == false) goto L33;
        if (connectionless == true) goto L30;
    L31:
        r2 = true;
        goto L33
    L30:
        if (imi.supportsConnectionlessStylusHandwriting() == false) goto L33;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isStylusHandwritingEnabled(Context context, int userId) {
        int profileParentUserId = this.mUserManagerInternal.getProfileParentId(userId);
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "stylus_handwriting_enabled", 1, profileParentUserId) != 0) goto L6;
        return false;
    L6:
        return true;
    }

    private List<InputMethodInfo> getInputMethodListInternal(final int userId, int directBootAwareness, final int callingUid) {
        UserData userData = getUserData(userId);
        InputMethodMap methodMap = userData.mRawInputMethodMap.get().toInputMethodMap(AdditionalSubtypeMapRepository.get(userId), directBootAwareness, userData.mIsUnlockingOrUnlocked.get());
        final InputMethodSettings settings = InputMethodSettings.create(methodMap, userId);
        ArrayList<InputMethodInfo> methodList = new ArrayList(settings.getMethodList());
        methodList.removeIf(new InputMethodManagerService$$ExternalSyntheticLambda17(this, callingUid, userId, settings));
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(callingUid);
        if (Utils.isXtsPkg(packages[0]) == true) goto L5;
        getExt().getInputMethodListLocked(methodList);
    L5:
        return methodList;
    }

    private /* synthetic */ boolean lambda$getInputMethodListInternal$7(int callingUid, int userId, InputMethodSettings settings, InputMethodInfo imi) {
        return !canCallerAccessInputMethod(imi.getPackageName(), callingUid, userId, settings);
    }

    private List<InputMethodInfo> getEnabledInputMethodListInternal(final int userId, final int callingUid) {
        final InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        ArrayList<InputMethodInfo> methodList = settings.getEnabledInputMethodList();
        methodList.removeIf(new InputMethodManagerService$$ExternalSyntheticLambda24(this, callingUid, userId, settings));
        return methodList;
    }

    private /* synthetic */ boolean lambda$getEnabledInputMethodListInternal$8(int callingUid, int userId, InputMethodSettings settings, InputMethodInfo imi) {
        return !canCallerAccessInputMethod(imi.getPackageName(), callingUid, userId, settings);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtypeSafeList getEnabledInputMethodSubtypeList(String imiId, boolean allowsImplicitlyEnabledSubtypes, int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L5:
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        InputMethodSubtypeSafeList r3 = InputMethodSubtypeSafeList.create(getEnabledInputMethodSubtypeListInternal(imiId, allowsImplicitlyEnabledSubtypes, userId, callingUid));     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private List<InputMethodSubtype> getEnabledInputMethodSubtypeListInternal(String imiId, boolean allowsImplicitlyEnabledSubtypes, int userId, int callingUid) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodInfo imi = settings.getMethodMap().get(imiId);
        if (imi != null) goto L7;
        return Collections.emptyList();
    L7:
        if (canCallerAccessInputMethod(imi.getPackageName(), callingUid, userId, settings) == true) goto L11;
        return Collections.emptyList();
    L11:
        return settings.getEnabledInputMethodSubtypeList(imi, allowsImplicitlyEnabledSubtypes);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void addClient(IInputMethodClient client, IRemoteInputConnection fallbackInputConnection, int selfReportedDisplayId) {
        client.getClass();
        fallbackInputConnection.getClass();
        int callerUid = Binder.getCallingUid();
        int callerPid = Binder.getCallingPid();
        IInputMethodClientInvoker clientInvoker = IInputMethodClientInvoker.create(client, this.mHandler);
        monitor-enter(ImfLock.class);
        this.mClientController.addClient(clientInvoker, fallbackInputConnection, selfReportedDisplayId, callerUid, callerPid);     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    private void onClientRemoved(final ClientState client) {
        clearClientSessionLocked(client);
        clearClientSessionForAccessibilityLocked(client);
        Consumer<UserData> clientRemovedForUser = new InputMethodManagerService$$ExternalSyntheticLambda15(this, client);
        this.mUserDataRepository.forAllUserData(clientRemovedForUser);
    }

    private /* synthetic */ void lambda$onClientRemoved$9(ClientState client, UserData userData) {
        onClientRemovedInternalLocked(client, userData);
    }

    private void onClientRemovedInternalLocked(ClientState client, UserData userData) {
        int userId = userData.mUserId;
        if (userData.mCurClient != client) goto L13;
        hideCurrentInputLocked(userData.mImeBindingState.mFocusedWindow, 0, 22, userId);
        if (userData.mBoundToMethod == false) goto L9;
        userData.mBoundToMethod = false;
        InputMethodBindingController userBindingController = userData.mBindingController;
        IInputMethodInvoker curMethod = userBindingController.getCurMethod();
        if (curMethod == null) goto L9;
        curMethod.unbindInput();
        AccessibilityManagerInternal.get().unbindInput();
    L9:
        userData.mBoundToAccessibility = false;
        userData.mCurClient = null;
        SysOptBridge.getFactory().getIMMSOpt().updateInputMethodClientUid(-1);
        if (userData.mImeBindingState.mFocusedWindowClient != client) goto L14;
        userData.mImeBindingState = ImeBindingState.newEmptyState();
        return;
    L14:
        return;
    }

    @Override // com.android.server.inputmethod.ZeroJankProxy.Callback
    public ClientState getClientStateLocked(IInputMethodClient client) {
        return this.mClientController.getClient(client.asBinder());
    }

    void unbindCurrentClientLocked(int unbindClientReason, int userId) {
        UserData userData = getUserData(userId);
        if (userData.mCurClient == null) goto L11;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "unbindCurrentInputLocked: client=%s", new Object[]{userData.mCurClient.mClient.asBinder()});
        InputMethodBindingController bindingController = userData.mBindingController;
        if (userData.mBoundToMethod == false) goto L9;
        userData.mBoundToMethod = false;
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod == null) goto L9;
        curMethod.unbindInput();
    L9:
        userData.mBoundToAccessibility = false;
        userData.mCurClient.mClient.setActive(false, false);
        userData.mCurClient.mClient.onUnbindMethod(bindingController.getSequenceNumber(), unbindClientReason);
        userData.mCurClient.mSessionRequested = false;
        userData.mCurClient.mSessionRequestedForAccessibility = false;
        userData.mCurClient = null;
        SysOptBridge.getFactory().getIMMSOpt().updateInputMethodClientUid(-1);
        ImeTracker.forLogging().onFailed(userData.mCurStatsToken, 8);
        userData.mCurStatsToken = null;
        this.mMenuController.hideInputMethodMenuLocked(userId);
        return;
    }

    void onUnbindCurrentMethodByReset(int userId) {
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        ImeVisibilityStateComputer.ImeTargetWindowState winState = visibilityStateComputer.getWindowStateOrNull(userData.mImeBindingState.mFocusedWindow);
        if (winState == null) goto L11;
        if (winState.isRequestedImeVisible() == true) goto L11;
        if (visibilityStateComputer.isInputShown() == true) goto L13;
        ImeTracker.Token statsToken = createStatsTokenForFocusedClient(false, 50, userId);
        this.mVisibilityApplier.applyImeVisibility(userData.mImeBindingState.mFocusedWindow, statsToken, 0, 0, userId);
        return;
    L13:
        return;
    }

    private boolean isShowRequestedForCurrentWindow(int userId) {
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        ImeVisibilityStateComputer.ImeTargetWindowState state = visibilityStateComputer.getWindowStateOrNull(userData.mImeBindingState.mFocusedWindow);
        if (state != null) goto L5;
    L7:
        return false;
    L5:
        if (state.isRequestedImeVisible() == false) goto L7;
        return true;
    }

    InputBindResult attachNewInputLocked(int startInputReason, boolean initial, int userId) {
        UserData userData = getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        if (userData.mBoundToMethod == true) goto L5;
        bindingController.getCurMethod().bindInput(userData.mCurClient.mBinding);
        userData.mBoundToMethod = true;
    L5:
        boolean restarting = !initial;
        Binder startInputToken = new Binder();
        StartInputInfo info = new StartInputInfo(userId, bindingController.getCurToken(), bindingController.getCurTokenDisplayId(), bindingController.getCurId(), startInputReason, restarting, UserHandle.getUserId(userData.mCurClient.mUid), userData.mCurClient.mSelfReportedDisplayId, userData.mImeBindingState.mFocusedWindow, userData.mCurEditorInfo, userData.mImeBindingState.mFocusedWindowSoftInputMode, bindingController.getSequenceNumber());
        this.mImeTargetWindowMap.put(startInputToken, userData.mImeBindingState.mFocusedWindow);
        this.mStartInputHistory.addEntry(info);
        if (userId != UserHandle.getUserId(userData.mCurClient.mUid)) goto L8;
        this.mPackageManagerInternal.grantImplicitAccess(userId, null, UserHandle.getAppId(bindingController.getCurMethodUid()), userData.mCurClient.mUid, true);
    L8:
        int navButtonFlags = getInputMethodNavButtonFlagsLocked(userData);
        SessionState session = userData.mCurClient.mCurSession;
        setEnabledSessionLocked(session, userData);
        if (userData.mCurEditorInfo != null) goto L11;
    L13:
        session.mMethod.startInput(startInputToken, userData.mCurInputConnection, userData.mCurEditorInfo, restarting, navButtonFlags, userData.mCurImeDispatcher);
        InputChannel r5 = null;
        if (isShowRequestedForCurrentWindow(userId) == true) goto L16;
    L22:
        boolean r6 = true;
    L23:
        String curId = bindingController.getCurId();
        InputMethodInfo curInputMethodInfo = InputMethodSettingsRepository.get(userId).getMethodMap().get(curId);
        if (curInputMethodInfo != null) goto L26;
    L28:
        boolean suppressesSpellChecker = false;
    L29:
        SparseArray<IAccessibilityInputMethodSession> accessibilityInputMethodSessions = createAccessibilityInputMethodSessions(userData.mCurClient.mAccessibilitySessions);
        if (bindingController.supportsStylusHandwriting() == true) goto L32;
    L34:
        IInputMethodSession r4 = session.mSession;
        if (session.mChannel == null) goto L37;
        r5 = session.mChannel.dup();
    L37:
        InputBindResult res = new InputBindResult(0, r4, accessibilityInputMethodSessions, r5, curId, bindingController.getSequenceNumber(), suppressesSpellChecker);
        res.mSelectId = bindingController.getSelectedMethodId();
        return res;
    L32:
        if (hasSupportedStylusLocked() == false) goto L34;
        this.mHwController.setInkWindowInitializer(new InkWindowInitializer(this, r5));
        goto L34
    L26:
        if (curInputMethodInfo.suppressesSpellChecker() == false) goto L28;
        suppressesSpellChecker = r6;
        goto L29
    L16:
        if (userData.mImeBindingState.mFocusedWindow == null) goto L22;
        if (userData.mCurStatsToken == null) goto L20;
        ImeTracker.Token statsToken = userData.mCurStatsToken;
        r6 = true;
    L21:
        userData.mCurStatsToken = null;
        showCurrentInputInternal(userData.mImeBindingState.mFocusedWindow, statsToken);
        goto L23
    L20:
        r6 = true;
        statsToken = createStatsTokenForFocusedClient(true, 2, userId);
        goto L21
    L11:
        if (userData.mCurEditorInfo.extras == null) goto L13;
        this.mRequestShowAiPanel = userData.mCurEditorInfo.extras.getBoolean("requestShowAiPanel", false);
        goto L13
    }

    private void attachNewAccessibilityLocked(int startInputReason, boolean initial, int userId) {
        UserData userData = getUserData(userId);
        if (userData.mBoundToAccessibility == true) goto L6;
        AccessibilityManagerInternal.get().bindInput();
        userData.mBoundToAccessibility = true;
    L6:
        if (startInputReason == 11) goto L9;
        setEnabledSessionForAccessibilityLocked(userData.mCurClient.mAccessibilitySessions, userData);
        AccessibilityManagerInternal.get().startInput(userData.mCurRemoteAccessibilityInputConnection, userData.mCurEditorInfo, !initial);
        return;
    }

    private SparseArray<IAccessibilityInputMethodSession> createAccessibilityInputMethodSessions(SparseArray<AccessibilitySessionState> accessibilitySessions) {
        SparseArray<IAccessibilityInputMethodSession> accessibilityInputMethodSessions = new SparseArray();
        int i = 0;
    L4:
        if (i >= accessibilitySessions.size()) goto L7;
        accessibilityInputMethodSessions.append(accessibilitySessions.keyAt(i), accessibilitySessions.valueAt(i).mSession);
        i = i + 1;
        goto L4
    L7:
        return accessibilityInputMethodSessions;
    }

    InputBindResult startInputUncheckedLocked(ClientState cs, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, EditorInfo editorInfo, int startInputFlags, int startInputReason, int unverifiedTargetSdkVersion, ImeOnBackInvokedDispatcher imeDispatcher, InputMethodBindingController bindingController) {
        int userId = bindingController.getUserId();
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        ImeVisibilityStateComputer.ImeTargetWindowState winState = visibilityStateComputer.getWindowStateOrNull(userData.mImeBindingState.mFocusedWindow);
        if (winState == null) goto L5;
        int csDisplayId = cs.mSelfReportedDisplayId;
        bindingController.setDisplayIdToShowIme(visibilityStateComputer.computeImeDisplayId(winState, csDisplayId));
        String selectedMethodId = getExt().getSuitableMethod(bindingController);
        String deviceMethodId = computeCurrentDeviceMethodIdLocked(bindingController.getUserId(), selectedMethodId);
        if (deviceMethodId != null) goto L10;
        visibilityStateComputer.getImePolicy().setImeHiddenByDisplayPolicy(true);
    L13:
        if (visibilityStateComputer.getImePolicy().isImeHiddenByDisplayPolicy() == false) goto L16;
        hideCurrentInputLocked(userData.mImeBindingState.mFocusedWindow, 0, 27, userId);
        return InputBindResult.NO_IME;
    L16:
        if (selectedMethodId != null) goto L20;
        return InputBindResult.NO_IME;
    L20:
        if (userData.mCurClient == cs) goto L23;
        prepareClientSwitchLocked(cs, userId);
    L23:
        if (userData.mCurInputConnection == null) goto L25;
        boolean connectionWasActive = true;
    L26:
        bindingController.advanceSequenceNumber();
        userData.mCurClient = cs;
        SysOptBridge.getFactory().getIMMSOpt().updateInputMethodClientUid(cs.mUid);
        userData.mCurInputConnection = inputConnection;
        userData.mCurRemoteAccessibilityInputConnection = remoteAccessibilityInputConnection;
        userData.mCurImeDispatcher = imeDispatcher;
        if (this.mVdmInternal != null) goto L30;
        this.mVdmInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    L30:
        if (this.mVdmInternal == null) goto L37;
        if (editorInfo.hintLocales != null) goto L37;
        LocaleList hintsFromVirtualDevice = this.mVdmInternal.getPreferredLocaleListForUid(cs.mUid);
        if (hintsFromVirtualDevice == null) goto L37;
        editorInfo.hintLocales = hintsFromVirtualDevice;
    L37:
        userData.mCurEditorInfo = editorInfo;
        getExt().onAttributeChange(editorInfo, userData.mCurClient, userData);
        if (userData.mCurInputConnection == null) goto L40;
        boolean connectionIsActive = true;
    L41:
        if (connectionIsActive == connectionWasActive) goto L44;
        this.mInputManagerInternal.notifyInputMethodConnectionActive(connectionIsActive);
    L44:
        if (shouldPreventImeStartupLocked(selectedMethodId, startInputFlags, unverifiedTargetSdkVersion, userId) == false) goto L47;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Avoiding IME startup and unbinding current input method.", new Object[0]);
        bindingController.invalidateAutofillSession();
        bindingController.unbindCurrentMethod();
        return InputBindResult.NO_EDITOR;
    L47:
        String r2 = bindingController.getCurId();
        int displayIdToShowIme = bindingController.getDisplayIdToShowIme();
        if (getExt().isSuitableMethodBoundLocked(bindingController, bindingController.getCurTokenDisplayId(), displayIdToShowIme) == true) goto L50;
    L64:
        bindingController.unbindCurrentMethod();
        return getExt().bindMethod(bindingController);
    L50:
        if (cs.mCurSession == null) goto L60;
        boolean r7 = false;
        cs.mSessionRequestedForAccessibility = false;
        requestClientSessionForAccessibilityLocked(cs);
        if ((startInputFlags & 4) == 0) goto L54;
        boolean r3 = true;
    L55:
        attachNewAccessibilityLocked(startInputReason, r3, userId);
        if ((startInputFlags & 4) == 0) goto L59;
        r7 = true;
    L59:
        return attachNewInputLocked(startInputReason, r7, userId);
    L54:
        r3 = false;
        goto L55
    L60:
        InputBindResult bindResult = tryReuseConnectionLocked(bindingController, cs, userId);
        if (bindResult == null) goto L64;
        bindResult.mSelectId = bindingController.getSelectedMethodId();
        return bindResult;
    L40:
        connectionIsActive = false;
        goto L41
    L25:
        connectionWasActive = false;
        goto L26
    L10:
        if (Objects.equals(deviceMethodId, selectedMethodId) == true) goto L13;
        setInputMethodLocked(deviceMethodId, -1, bindingController.getDeviceIdToShowIme(), userId);
        selectedMethodId = deviceMethodId;
        goto L13
    L5:
        return InputBindResult.NOT_IME_TARGET_WINDOW;
    }

    private String computeCurrentDeviceMethodIdLocked(int userId, String currentMethodId) {
        if (this.mVdmInternal != null) goto L6;
        this.mVdmInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    L6:
        if (this.mVdmInternal != null) goto L8;
        return currentMethodId;
    L8:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        int oldDeviceId = bindingController.getDeviceIdToShowIme();
        int displayIdToShowIme = bindingController.getDisplayIdToShowIme();
        int newDeviceId = this.mVdmInternal.getDeviceIdForDisplayId(displayIdToShowIme);
        if (newDeviceId != 0) goto L11;
    L16:
        bindingController.setDeviceIdToShowIme(newDeviceId);
        if (newDeviceId != 0) goto L22;
        if (oldDeviceId != 0) goto L20;
        return currentMethodId;
    L20:
        String defaultDeviceMethodId = settings.getSelectedDefaultDeviceInputMethod();
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Restoring default device input method: %s", new Object[]{defaultDeviceMethodId});
        settings.putSelectedDefaultDeviceInputMethod(null);
        return defaultDeviceMethodId;
    L22:
        String deviceMethodId = this.mVirtualDeviceMethodMap.get(newDeviceId, currentMethodId);
        if (Objects.equals(deviceMethodId, currentMethodId) == false) goto L26;
        return currentMethodId;
    L26:
        if (settings.getMethodMap().containsKey(deviceMethodId) == true) goto L29;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Disabling IME on virtual device with id %s because its custom input method is not available: %s", new Object[]{Integer.valueOf(newDeviceId), deviceMethodId});
        return null;
    L29:
        if (oldDeviceId != 0) goto L31;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Storing default device input method %s", new Object[]{currentMethodId});
        settings.putSelectedDefaultDeviceInputMethod(currentMethodId);
    L31:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Switching current input method from %s to device-specific one %s because the current display %s belongs to device with id %s", new Object[]{currentMethodId, deviceMethodId, Integer.valueOf(displayIdToShowIme), Integer.valueOf(newDeviceId)});
        return deviceMethodId;
    L11:
        if (this.mDisplayManagerInternal != null) goto L13;
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
    L13:
        int displayFlags = this.mDisplayManagerInternal.getDisplayInfo(displayIdToShowIme).flags;
        if ((displayFlags & 128) == 128) goto L16;
        newDeviceId = 0;
        goto L16
    }

    private boolean shouldPreventImeStartupLocked(String selectedMethodId, int startInputFlags, int unverifiedTargetSdkVersion, int userId) {
        if (this.mPreventImeStartupUnlessTextEditor == true) goto L6;
        return false;
    L6:
        if (isShowRequestedForCurrentWindow(userId) == false) goto L9;
        return false;
    L9:
        if (InputMethodUtils.isSoftInputModeStateVisibleAllowed(unverifiedTargetSdkVersion, startInputFlags) == false) goto L11;
        return false;
    L11:
        InputMethodInfo imi = InputMethodSettingsRepository.get(userId).getMethodMap().get(selectedMethodId);
        if (imi != null) goto L15;
        return false;
    L15:
        if (ArrayUtils.contains(this.mNonPreemptibleInputMethods, imi.getPackageName()) == false) goto L17;
        return false;
    L17:
        return true;
    }

    private void prepareClientSwitchLocked(ClientState cs, int userId) {
        unbindCurrentClientLocked(1, userId);
        if (this.mIsInteractive == false) goto L6;
        cs.mClient.setActive(true, false);
        return;
    }

    private InputBindResult tryReuseConnectionLocked(InputMethodBindingController bindingController, ClientState cs, int userId) {
        if (bindingController.hasMainConnection() == true) goto L5;
        return null;
    L5:
        if (bindingController.getCurMethod() != null) goto L7;
        long lastBindTime = bindingController.getLastBindTime();
        long bindingDuration = SystemClock.uptimeMillis() - lastBindTime;
        if (bindingDuration < 3000) goto L11;
        EventLog.writeEvent(EventLogTags.IMF_FORCE_RECONNECT_IME, new Object[]{bindingController.getSelectedMethodId(), Long.valueOf(bindingDuration), 0});
        return null;
    L11:
        return new InputBindResult(2, null, null, null, bindingController.getCurId(), bindingController.getSequenceNumber(), false);
    L7:
        return new InputBindResult(1, null, null, null, bindingController.getCurId(), bindingController.getSequenceNumber(), false);
    }

    static int computeImeDisplayIdForTarget(int displayId, ImeDisplayValidator checker) {
        return computeImeDisplayIdForTargetInner(displayId, checker, 0);
    }

    int computeImeDisplayIdForVisibleBackgroundUserOnAutomotive(int displayId, int userId, ImeDisplayValidator checker) {
        int mainDisplayId = this.mUserManagerInternal.getMainDisplayAssignedToUser(userId);
        return computeImeDisplayIdForTargetInner(displayId, checker, mainDisplayId);
    }

    private static int computeImeDisplayIdForTargetInner(int displayId, ImeDisplayValidator checker, int fallbackDisplayId) {
        if (displayId != fallbackDisplayId) goto L4;
    L13:
        return fallbackDisplayId;
    L4:
        if (displayId == (-1)) goto L13;
        int result = checker.getDisplayImePolicy(displayId);
        if (result != 0) goto L10;
        return displayId;
    L10:
        if (result != 2) goto L12;
        return -1;
    L12:
        return fallbackDisplayId;
    }

    void initializeImeLocked(IInputMethodInvoker inputMethod, IBinder token, InputMethodBindingController bindingController) {
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Sending attach of token: %s for display: %s", new Object[]{token, Integer.valueOf(bindingController.getCurTokenDisplayId())});
        int userId = bindingController.getUserId();
        UserData userData = getUserData(userId);
        inputMethod.initializeInternal(token, new InputMethodPrivilegedOperationsImpl(this, token, userData), getInputMethodNavButtonFlagsLocked(userData));
    }

    void scheduleResetStylusHandwriting() {
        this.mHandler.obtainMessage(MSG_RESET_HANDWRITING).sendToTarget();
    }

    void schedulePrepareStylusHandwritingDelegation(int userId, String delegatePackageName, String delegatorPackageName) {
        this.mHandler.obtainMessage(MSG_PREPARE_HANDWRITING_DELEGATION, userId, 0, new Pair(delegatePackageName, delegatorPackageName)).sendToTarget();
    }

    void scheduleRemoveStylusHandwritingWindow() {
        this.mHandler.obtainMessage(MSG_REMOVE_HANDWRITING_WINDOW).sendToTarget();
    }

    void scheduleNotifyImeUidToAudioService(int uid) {
        this.mHandler.removeMessages(MSG_NOTIFY_IME_UID_TO_AUDIO_SERVICE);
        this.mHandler.obtainMessage(MSG_NOTIFY_IME_UID_TO_AUDIO_SERVICE, uid, 0).sendToTarget();
    }

    void onSessionCreated(IInputMethodInvoker method, IInputMethodSession session, InputChannel channel, int userId) {
        Trace.traceBegin(32, "IMMS.onSessionCreated");
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L30
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L6:
        if (this.mUserSwitchHandlerTask == null) goto L13;
        channel.dispose();     // Catch: Throwable -> L11
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        Trace.traceEnd(32);
        return;
    L13:
        UserData userData = getUserData(userId);     // Catch: Throwable -> L11
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L11
        IInputMethodInvoker curMethod = bindingController.getCurMethod();     // Catch: Throwable -> L11
        if (curMethod == null) goto L26;
        if (method == null) goto L26;
        if (curMethod.asBinder() != method.asBinder()) goto L26;
        if (userData.mCurClient == null) goto L26;
        clearClientSessionLocked(userData.mCurClient);     // Catch: Throwable -> L11
        ClientState r12 = userData.mCurClient;     // Catch: Throwable -> L11
        r12.mCurSession = new SessionState(userData.mCurClient, method, session, channel, userId);     // Catch: Throwable -> L11
        InputBindResult res = attachNewInputLocked(10, true, userId);     // Catch: Throwable -> L11
        attachNewAccessibilityLocked(10, true, userId);     // Catch: Throwable -> L11
        if (res.method == null) goto L23;
        userData.mCurClient.mClient.onBindMethod(res);     // Catch: Throwable -> L11
    L23:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        Trace.traceEnd(32);
        return;
    L26:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        channel.dispose();     // Catch: Throwable -> L30
        Trace.traceEnd(32);
        return;
    L30:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    void resetSystemUiLocked(InputMethodBindingController bindingController) {
        bindingController.setImeWindowVis(0);
        bindingController.setBackDisposition(0);
        updateSystemUiLocked(0, 0, bindingController.getUserId());
    }

    void resetCurrentMethodAndClientLocked(int unbindClientReason, int userId) {
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        bindingController.setSelectedMethodId(null);
        onUnbindCurrentMethodByReset(userId);
        bindingController.unbindCurrentMethod();
        unbindCurrentClientLocked(unbindClientReason, userId);
    }

    void reRequestCurrentClientSessionLocked(int userId) {
        UserData userData = getUserData(userId);
        if (userData.mCurClient == null) goto L6;
        clearClientSessionLocked(userData.mCurClient);
        clearClientSessionForAccessibilityLocked(userData.mCurClient);
        requestClientSessionLocked(userData.mCurClient, userId);
        requestClientSessionForAccessibilityLocked(userData.mCurClient);
        return;
    }

    void requestClientSessionLocked(ClientState cs, final int userId) {
        if (cs.mSessionRequested == true) goto L12;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Creating new session for client %s", new Object[]{cs});
        InputChannel[] channels = InputChannel.openInputChannelPair(cs.toString());
        final InputChannel serverChannel = channels[0];
        InputChannel clientChannel = channels[1];
        cs.mSessionRequested = true;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        final IInputMethodInvoker curMethod = bindingController.getCurMethod();
        IInputMethodSessionCallback.Stub callback = new AnonymousClass2(this, curMethod, serverChannel, userId);
        curMethod.createSession(clientChannel, callback);     // Catch: Throwable -> L8
        if (clientChannel == null) goto L15;
        clientChannel.dispose();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (clientChannel == null) goto L11;
        clientChannel.dispose();
    L11:
        throw th;
    }

    void requestClientSessionForAccessibilityLocked(ClientState cs) {
        if (cs.mSessionRequestedForAccessibility == true) goto L11;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Creating new accessibility sessions for client %s", new Object[]{cs});
        cs.mSessionRequestedForAccessibility = true;
        ArraySet<Integer> ignoreSet = new ArraySet();
        int i = 0;
    L6:
        if (i >= cs.mAccessibilitySessions.size()) goto L8;
        ignoreSet.add(Integer.valueOf(cs.mAccessibilitySessions.keyAt(i)));
        i = i + 1;
        goto L6
    L8:
        AccessibilityManagerInternal.get().createImeSession(ignoreSet);
        return;
    }

    void clearClientSessionLocked(ClientState cs) {
        finishSessionLocked(cs.mCurSession);
        cs.mCurSession = null;
        cs.mSessionRequested = false;
    }

    void clearClientSessionForAccessibilityLocked(ClientState cs) {
        int i = 0;
    L4:
        if (i >= cs.mAccessibilitySessions.size()) goto L6;
        finishSessionForAccessibilityLocked(cs.mAccessibilitySessions.valueAt(i));
        i = i + 1;
        goto L4
    L6:
        cs.mAccessibilitySessions.clear();
        cs.mSessionRequestedForAccessibility = false;
    }

    void clearClientSessionForAccessibilityLocked(ClientState cs, int id) {
        AccessibilitySessionState session = cs.mAccessibilitySessions.get(id);
        if (session == null) goto L6;
        finishSessionForAccessibilityLocked(session);
        cs.mAccessibilitySessions.remove(id);
        return;
    }

    private void finishSessionLocked(SessionState sessionState) {
        if (sessionState != null) goto L4;
        return;
    L4:
        if (sessionState.mSession == null) goto L11;
        sessionState.mSession.finishSession();     // Catch: RemoteException -> L7
    L9:
        sessionState.mSession = null;
    L7:
        e = move-exception;
        Slog.w(TAG, "Session failed to close due to remote exception", e);
        int userId = sessionState.mUserId;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        updateSystemUiLocked(0, bindingController.getBackDisposition(), userId);
    L11:
        if (sessionState.mChannel == null) goto L17;
        sessionState.mChannel.dispose();
        sessionState.mChannel = null;
        return;
    }

    private void finishSessionForAccessibilityLocked(AccessibilitySessionState sessionState) {
        if (sessionState != null) goto L4;
        return;
    L4:
        if (sessionState.mSession == null) goto L14;
        sessionState.mSession.finishSession();     // Catch: RemoteException -> L7
    L9:
        sessionState.mSession = null;
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Session failed to close due to remote exception", e);
        goto L9
    }

    void clearClientSessionsLocked(InputMethodBindingController bindingController) {
        final int userId = bindingController.getUserId();
        UserData userData = getUserData(userId);
        if (bindingController.getCurMethod() == null) goto L9;
        Consumer<ClientState> clearClientSession = new InputMethodManagerService$$ExternalSyntheticLambda20(this, userId);
        this.mClientController.forAllClients(clearClientSession);
        finishSessionLocked(userData.mEnabledSession);
        int i = 0;
    L6:
        if (i >= userData.mEnabledAccessibilitySessions.size()) goto L8;
        finishSessionForAccessibilityLocked(userData.mEnabledAccessibilitySessions.valueAt(i));
        i = i + 1;
        goto L6
    L8:
        userData.mEnabledSession = null;
        userData.mEnabledAccessibilitySessions.clear();
        scheduleNotifyImeUidToAudioService(-1);
    L9:
        hideStatusBarIconLocked(userId);
        getUserData(userId).mInFullscreenMode = false;
        this.mWindowManagerInternal.setDismissImeOnBackKeyPressed(false);
        scheduleResetStylusHandwriting();
    }

    private /* synthetic */ void lambda$clearClientSessionsLocked$10(int userId, ClientState c) {
        if (this.mConcurrentMultiUserModeEnabled == true) goto L5;
    L8:
        boolean shouldClearClientSession = true;
    L10:
        if (shouldClearClientSession == false) goto L13;
        clearClientSessionLocked(c);
        clearClientSessionForAccessibilityLocked(c);
        return;
    L13:
        return;
    L5:
        if (UserHandle.getUserId(c.mUid) == userId) goto L8;
        shouldClearClientSession = false;
        goto L10
    }

    private void updateStatusIconLocked(String packageName, int iconId, UserData userData) {
        int userId = userData.mUserId;
        if (this.mConcurrentMultiUserModeEnabled == true) goto L8;
        if (userId == this.mCurrentImeUserId) goto L8;
        return;
    L8:
        if (iconId != 0) goto L10;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "hide the small icon for the input method", new Object[0]);
        hideStatusBarIconLocked(userId);
        return;
    L10:
        if (packageName == null) goto L29;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "show a small icon for the input method", new Object[0]);
        PackageManager userAwarePackageManager = getPackageManagerForUser(this.mContext, userId);
        ApplicationInfo applicationInfo = null;
        applicationInfo = userAwarePackageManager.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L14
    L15:
        String r0 = null;
        if (applicationInfo == null) goto L18;
        CharSequence contentDescription = userAwarePackageManager.getApplicationLabel(applicationInfo);
    L20:
        if (this.mStatusBarManagerInternal == null) goto L34;
        StatusBarManagerInternal r6 = this.mStatusBarManagerInternal;
        String r7 = this.mSlotIme;
        if (contentDescription == null) goto L26;
        r0 = contentDescription.toString();
    L26:
        r6.setIcon(r7, packageName, iconId, 0, r0);
        this.mStatusBarManagerInternal.setIconVisibility(this.mSlotIme, true);
        return;
    L34:
        return;
    L18:
        contentDescription = null;
        goto L20
    }

    private void hideStatusBarIconLocked(int userId) {
        if (this.mConcurrentMultiUserModeEnabled == true) goto L8;
        if (userId == this.mCurrentImeUserId) goto L8;
        return;
    L8:
        if (this.mStatusBarManagerInternal == null) goto L11;
        this.mStatusBarManagerInternal.setIconVisibility(this.mSlotIme, false);
        return;
    }

    private int getInputMethodNavButtonFlagsLocked(UserData userData) {
        int r0 = userData.mUserId;
        InputMethodBindingController r1 = userData.mBindingController;
        return getExt().getInputMethodNavButtonFlagsLocked(userData, userData.mCurEditorInfo, this.mCurrentImeUserId);
    }

    boolean shouldShowImeSwitcherLocked(int visibility, int userId) {
        UserData userData = getUserData(userId);
        if (getExt().shouldShowImeSwitcher(userData.mCurEditorInfo) == true) goto L6;
        return false;
    L6:
        if (this.mShowOngoingImeSwitcherForPhones == true) goto L9;
        return false;
    L9:
        if (this.mMenuController.getSwitchingDialogLocked() == null) goto L11;
        boolean switcherMenuShowing = true;
    L12:
        if (switcherMenuShowing == false) goto L14;
        return false;
    L14:
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        if (Objects.equals(bindingController.getCurId(), bindingController.getSelectedMethodId()) == true) goto L18;
        return false;
    L18:
        if (this.mWindowManagerInternal.isKeyguardShowingAndNotOccluded() == false) goto L23;
        if (this.mWindowManagerInternal.isKeyguardSecure(userId) == false) goto L23;
        return false;
    L23:
        if ((visibility & 1) != 0) goto L26;
        return false;
    L26:
        if (this.mWindowManagerInternal.isHardKeyboardAvailable() == false) goto L29;
        return true;
    L29:
        if ((visibility & 2) != 0) goto L32;
        return false;
    L32:
        return hasMultipleSubtypesForSwitcher(false, userId);
    L11:
        switcherMenuShowing = false;
        goto L12
    }

    private static boolean hasMultipleSubtypesForSwitcher(boolean nonAuxOnly, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        List<InputMethodInfo> imes = settings.getEnabledInputMethodListWithFilter(new InputMethodManagerService$$ExternalSyntheticLambda18());
        int numImes = imes.size();
        if (numImes <= 2) goto L6;
        return true;
    L6:
        if (numImes >= 1) goto L8;
        return false;
    L8:
        int nonAuxCount = 0;
        int auxCount = 0;
        InputMethodSubtype nonAuxSubtype = null;
        InputMethodSubtype auxSubtype = null;
        int i = 0;
    L9:
        if (i >= numImes) goto L22;
        InputMethodInfo imi = imes.get(i);
        List<InputMethodSubtype> subtypes = settings.getEnabledInputMethodSubtypeList(imi, true);
        int subtypeCount = subtypes.size();
        if (subtypeCount != 0) goto L13;
        nonAuxCount = nonAuxCount + 1;
    L20:
        i = i + 1;
        goto L9
    L13:
        int j = 0;
    L14:
        if (j >= subtypeCount) goto L20;
        InputMethodSubtype subtype = subtypes.get(j);
        if (subtype.isAuxiliary() == true) goto L18;
        nonAuxCount = nonAuxCount + 1;
        nonAuxSubtype = subtype;
    L19:
        j = j + 1;
        goto L14
    L18:
        auxCount = auxCount + 1;
        auxSubtype = subtype;
        goto L19
    L22:
        if (nonAuxCount > 1) goto L41;
        if (auxCount > 1) goto L41;
        if (nonAuxCount != 1) goto L40;
        if (auxCount != 1) goto L40;
        if (nonAuxSubtype == null) goto L39;
        if (auxSubtype == null) goto L39;
        if (nonAuxSubtype.getLocale().equals(auxSubtype.getLocale()) == true) goto L37;
        if (auxSubtype.overridesImplicitlyEnabledSubtype() == true) goto L37;
        if (nonAuxSubtype.overridesImplicitlyEnabledSubtype() == false) goto L39;
    L37:
        if (nonAuxSubtype.containsExtraValueKey(TAG_TRY_SUPPRESSING_IME_SWITCHER) == false) goto L39;
        return false;
    L39:
        return true;
    L40:
        return false;
    L41:
        return true;
    }

    private void setImeWindowStatusLocked(int vis, int backDisposition, UserData userData) {
        int topFocusedDisplayId = this.mWindowManagerInternal.getTopFocusedDisplayId();
        int userId = userData.mUserId;
        InputMethodBindingController bindingController = userData.mBindingController;
        int tokenDisplayId = bindingController.getCurTokenDisplayId();
        if (tokenDisplayId == topFocusedDisplayId) goto L6;
        if (tokenDisplayId == 0) goto L6;
        return;
    L6:
        bindingController.setImeWindowVis(vis);
        getExt().onImeWindowStatusChanged(vis);
        bindingController.setBackDisposition(backDisposition);
        updateSystemUiLocked(vis, backDisposition, userId);
        switch(backDisposition) {
            case 1: goto L14;
            case 2: goto L13;
            default: goto L9;
        };
    L13:
        boolean dismissImeOnBackKeyPressed = true;
    L15:
        this.mWindowManagerInternal.setDismissImeOnBackKeyPressed(dismissImeOnBackKeyPressed);
        return;
    L14:
        dismissImeOnBackKeyPressed = false;
        goto L15
    L9:
        if ((vis & 2) == 0) goto L11;
        dismissImeOnBackKeyPressed = true;
        goto L15
    L11:
        dismissImeOnBackKeyPressed = false;
        goto L15
    }

    private void reportStartInputLocked(IBinder startInputToken, UserData userData) {
        IBinder targetWindow = this.mImeTargetWindowMap.get(startInputToken);
        if (targetWindow == null) goto L5;
        this.mWindowManagerInternal.updateInputMethodTargetWindow(targetWindow);
    L5:
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        visibilityStateComputer.setLastImeTargetWindow(targetWindow);
    }

    private void updateImeWindowStatusLocked(boolean disableImeIcon, int displayId) {
        int userId = resolveImeUserIdFromDisplayIdLocked(displayId);
        if (disableImeIcon == false) goto L5;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        updateSystemUiLocked(0, bindingController.getBackDisposition(), userId);
        return;
    L5:
        updateSystemUiLocked(userId);
    }

    void updateSystemUiLocked(int userId) {
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        updateSystemUiLocked(bindingController.getImeWindowVis(), bindingController.getBackDisposition(), userId);
    }

    private void updateSystemUiLocked(int vis, int backDisposition, int userId) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L5;
    L7:
        UserData userData = getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        IBinder curToken = bindingController.getCurToken();
        if (curToken != null) goto L10;
        return;
    L10:
        int curTokenDisplayId = bindingController.getCurTokenDisplayId();
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "IME window vis: %s active: %s visible: %s displayId: %s", new Object[]{Integer.valueOf(vis), Integer.valueOf(vis & 1), Integer.valueOf(vis & 2), Integer.valueOf(curTokenDisplayId)});
        IBinder focusedWindowToken = userData.mImeBindingState.mFocusedWindow;
        if (focusedWindowToken == null) goto L13;
        Boolean windowPerceptible = this.mFocusedWindowPerceptible.get(focusedWindowToken);
    L14:
        long ident = Binder.clearCallingIdentity();
        if (windowPerceptible != null) goto L36;
    L21:
        String curId = bindingController.getCurId();     // Catch: Throwable -> L19
        if (this.mMenuController.getSwitchingDialogLocked() == null) goto L24;
        boolean switcherMenuShowing = true;
    L25:
        if (switcherMenuShowing == false) goto L27;
    L28:
        backDisposition = 3;
    L29:
        boolean needsToShowImeSwitcher = shouldShowImeSwitcherLocked(vis, userId);     // Catch: Throwable -> L19
        if (this.mStatusBarManagerInternal == null) goto L32;
        this.mStatusBarManagerInternal.setImeWindowStatus(curTokenDisplayId, vis, backDisposition, needsToShowImeSwitcher);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L32:
        Binder.restoreCallingIdentity(ident);
        return;
    L27:
        if (Objects.equals(curId, bindingController.getSelectedMethodId()) == true) goto L29;
    L24:
        switcherMenuShowing = false;
        goto L25
    L36:
        if (windowPerceptible.booleanValue() == true) goto L21;
        vis = vis & (-3);     // Catch: Throwable -> L19
        goto L21
    L13:
        windowPerceptible = null;
        goto L14
    L5:
        if (userId == this.mCurrentImeUserId) goto L7;
    }

    void updateFromSettingsLocked(boolean enabledMayChange, int userId) {
        updateInputMethodsFromSettingsLocked(enabledMayChange, userId);
        this.mMenuController.updateKeyboardFromSettingsLocked(userId);
    }

    void updateInputMethodsFromSettingsLocked(boolean enabledMayChange, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (enabledMayChange == false) goto L16;
        PackageManager userAwarePackageManager = getPackageManagerForUser(this.mContext, userId);
        List<InputMethodInfo> enabled = settings.getEnabledInputMethodList();
        int i = 0;
    L6:
        if (i >= enabled.size()) goto L16;
        InputMethodInfo imm = enabled.get(i);
        ApplicationInfo ai = null;
        ai = userAwarePackageManager.getApplicationInfo(imm.getPackageName(), PackageManager.ApplicationInfoFlags.of(32768));     // Catch: PackageManager.NameNotFoundException -> L10
    L11:
        if (ai == null) goto L15;
        if (ai.enabledSetting != 4) goto L15;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Update state(%s): DISABLED_UNTIL_USED -> DEFAULT", new Object[]{imm.getId()});
        userAwarePackageManager.setApplicationEnabledSetting(imm.getPackageName(), 0, 1);
    L15:
        i = i + 1;
    L16:
        UserData userData = getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        if (bindingController.getDeviceIdToShowIme() != 0) goto L23;
        String ime = SecureSettingsWrapper.getString("default_input_method", null, userId);
        String defaultDeviceIme = SecureSettingsWrapper.getString("default_device_input_method", null, userId);
        if (defaultDeviceIme == null) goto L23;
        if (Objects.equals(ime, defaultDeviceIme) == true) goto L23;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Current input method %s differs from the stored default device input method for user %s - restoring %s", new Object[]{ime, Integer.valueOf(userId), defaultDeviceIme});
        SecureSettingsWrapper.putString("default_input_method", defaultDeviceIme, userId);
        SecureSettingsWrapper.putString("default_device_input_method", null, userId);
    L23:
        String id = settings.getSelectedInputMethod();
        if (TextUtils.isEmpty(id) == false) goto L29;
        if (chooseNewDefaultIMELocked(userId) == false) goto L29;
        id = settings.getSelectedInputMethod();
    L29:
        if (TextUtils.isEmpty(id) == false) goto L37;
        resetCurrentMethodAndClientLocked(4, userId);
    L35:
        userData.mSwitchingController.resetCircularListLocked(this.mContext, settings);
        userData.mHardwareKeyboardShortcutController.update(settings);
        sendOnNavButtonFlagsChangedLocked(userData);
        return;
    L37:
        setInputMethodLocked(id, settings.getSelectedInputMethodSubtypeIndex(id), userId);     // Catch: IllegalArgumentException -> L32
    L32:
        e = move-exception;
        Slog.w(TAG, "Unknown input method from prefs: " + id, e);
        resetCurrentMethodAndClientLocked(5, userId);
        goto L35
    }

    private void notifyInputMethodSubtypeChangedLocked(int userId, InputMethodInfo imi, InputMethodSubtype subtype) {
        InputMethodSubtypeHandle newSubtypeHandle = null;
        if (subtype != null) goto L5;
    L7:
        InputMethodSubtype normalizedSubtype = null;
    L9:
        if (normalizedSubtype == null) goto L12;
        newSubtypeHandle = InputMethodSubtypeHandle.of(imi, normalizedSubtype);
    L12:
        UserData userData = getUserData(userId);
        userData.mSubtypeForKeyboardLayoutMapping = Pair.create(newSubtypeHandle, normalizedSubtype);
        if (userId == this.mCurrentImeUserId) goto L15;
        return;
    L15:
        this.mInputManagerInternal.onInputMethodSubtypeChangedForKeyboardLayoutMapping(userId, newSubtypeHandle, normalizedSubtype);
        return;
    L5:
        if (subtype.isSuitableForPhysicalKeyboardLayoutMapping() == false) goto L7;
        normalizedSubtype = subtype;
        goto L9
    }

    void setInputMethodLocked(String id, int subtypeIndex, int userId) {
        setInputMethodLocked(id, subtypeIndex, 0, userId);
    }

    void setInputMethodLocked(String id, int subtypeIndex, int deviceId, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodInfo info = settings.getMethodMap().get(id);
        if (info == null) goto L55;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        if (id.equals(bindingController.getSelectedMethodId()) == false) goto L36;
        int subtypeCount = info.getSubtypeCount();
        if (subtypeCount > 0) goto L10;
        notifyInputMethodSubtypeChangedLocked(userId, info, null);
        return;
    L10:
        InputMethodSubtype oldSubtype = bindingController.getCurrentSubtype();
        if (subtypeIndex < 0) goto L14;
        if (subtypeIndex >= subtypeCount) goto L14;
        InputMethodSubtype newSubtype = info.getSubtypeAt(subtypeIndex);
    L23:
        if (Objects.equals(newSubtype, oldSubtype) == true) goto L60;
        StringBuilder r6 = new StringBuilder();
        r6.append("Subtype changed oldSubtype NameResId: ");
        Object r7 = "null";
        if (oldSubtype == null) goto L27;
        Object r8 = Integer.valueOf(oldSubtype.getNameResId());
    L28:
        r6.append(r8);
        r6.append(" old inputmethod: ");
        r6.append(bindingController.getCurId());
        r6.append(" newSubtype NameResId: ");
        if (newSubtype == null) goto L31;
        r7 = Integer.valueOf(newSubtype.getNameResId());
    L31:
        r6.append(r7);
        r6.append(" subtypeCount: ");
        r6.append(subtypeCount);
        r6.append(" new method: ");
        r6.append(id);
        Slog.d(TAG, r6.toString());
        setSelectedInputMethodAndSubtypeLocked(info, subtypeIndex, true, userId);
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod == null) goto L61;
        updateSystemUiLocked(bindingController.getImeWindowVis(), bindingController.getBackDisposition(), userId);
        curMethod.changeInputMethodSubtype(newSubtype);
        return;
    L61:
        return;
    L27:
        r8 = "null";
        goto L28
    L60:
        return;
    L14:
        subtypeIndex = -1;
        newSubtype = bindingController.getCurrentInputMethodSubtype();
        if (newSubtype == null) goto L23;
        int i = 0;
    L17:
        if (i >= subtypeCount) goto L23;
        if (Objects.equals(newSubtype, info.getSubtypeAt(i)) == true) goto L20;
        i = i + 1;
        goto L17
    L20:
        subtypeIndex = i;
        goto L23
    L36:
        if (bindingController.getDeviceIdToShowIme() == 0) goto L40;
        if (deviceId != 0) goto L40;
        settings.putSelectedDefaultDeviceInputMethod(id);
        return;
    L40:
        IInputMethodInvoker curMethod2 = bindingController.getCurMethod();
        if (curMethod2 == null) goto L43;
        curMethod2.removeStylusHandwritingWindow();
    L43:
        long ident = Binder.clearCallingIdentity();
        setSelectedInputMethodAndSubtypeLocked(info, subtypeIndex, false, userId);     // Catch: Throwable -> L47
        bindingController.setSelectedMethodId(id);     // Catch: Throwable -> L47
        SysOptBridge.getFactory().getSmartScenes().updateInputMethod(info.getPackageName());     // Catch: Throwable -> L47
        if (this.mActivityManagerInternal.isSystemReady() == false) goto L49;
        Intent intent = new Intent("android.intent.action.INPUT_METHOD_CHANGED");     // Catch: Throwable -> L47
        intent.addFlags(536870912);     // Catch: Throwable -> L47
        intent.putExtra("input_method_id", id);     // Catch: Throwable -> L47
        this.mContext.sendBroadcastAsUser(intent, UserHandle.CURRENT);     // Catch: Throwable -> L47
    L49:
        bindingController.unbindCurrentMethod();     // Catch: Throwable -> L47
        unbindCurrentClientLocked(2, userId);     // Catch: Throwable -> L47
        Binder.restoreCallingIdentity(ident);
        return;
    L47:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L55:
        throw getExceptionForUnknownImeId(id);
    }

    private void sendResultReceiverFailureLocked(ResultReceiver resultReceiver, int userId) {
        if (resultReceiver != null) goto L4;
        return;
    L4:
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        boolean isInputShown = visibilityStateComputer.isInputShown();
        if (isInputShown == false) goto L7;
        int r3 = 0;
    L8:
        resultReceiver.send(r3, null);
        return;
    L7:
        r3 = 1;
        goto L8
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean showSoftInput(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, boolean async) {
        Trace.traceBegin(32, "IMMS.showSoftInput");
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#showSoftInput", this.mDumper);
        monitor-enter(ImfLock.class);
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L14
        int callingUserId = UserHandle.getUserId(uid);     // Catch: Throwable -> L14
        int userId = resolveImeUserIdLocked(callingUserId, client);     // Catch: Throwable -> L14
        boolean result = showSoftInputLocked(client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, uid, userId);     // Catch: Throwable -> L9
        if (result == true) goto L12;
        sendResultReceiverFailureLocked(resultReceiver, userId);     // Catch: Throwable -> L9
    L12:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return result;
    L14:
        th = th;
    L16:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        throw th;
    L9:
        th = th;
        goto L16
    }

    private boolean showSoftInputLocked(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, int uid, int userId) {
        int r4 = 0;
        if (canInteractWithImeLocked(uid, client, "showSoftInput", statsToken, userId) == true) goto L14;
        ImeTracker.forLogging().onFailed(statsToken, 3);
        Trace.traceEnd(32);
        ClientState cs = this.mClientController.getClient(client.asBinder());
        if (cs != null) goto L9;
        Slog.e(TAG, "hideSoftInput: client not found");
        return false;
    L9:
        if (cs.mSelfReportedDisplayId == 0) goto L13;
        return this.mWindowManagerInternal.getObricWindowManagerInternal().showImeInAuto(windowToken, cs.mSelfReportedDisplayId);
    L13:
        return false;
    L14:
        UserData userData = getUserData(userId);
        long ident = Binder.clearCallingIdentity();
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Client requesting input be shown", new Object[0]);     // Catch: Throwable -> L23
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L23
        boolean wasVisible = visibilityStateComputer.isInputShown();     // Catch: Throwable -> L23
        if (setImeVisibilityOnFocusedWindowClient(false, userData, statsToken) == false) goto L27;
        if (resultReceiver == null) goto L25;
        if (wasVisible == true) goto L21;
        r4 = 2;
    L21:
        resultReceiver.send(r4, null);     // Catch: Throwable -> L23
    L25:
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        return true;
    L27:
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        return false;
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        throw th;
    }

    boolean showCurrentInputInternal(IBinder windowToken, ImeTracker.Token statsToken) {
        Trace.traceBegin(32, "IMMS.showCurrentInputInternal");
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#showSoftInput", this.mDumper);
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdFromWindowLocked(windowToken);     // Catch: Throwable -> L10
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Client requesting input be shown", new Object[0]);     // Catch: Throwable -> L12
        boolean r0 = showCurrentInputLocked(windowToken, statsToken, 0, 0, null, 1, userId);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        Trace.traceEnd(32);     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return r0;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        Trace.traceEnd(32);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    boolean hideCurrentInputInternal(IBinder windowToken, ImeTracker.Token statsToken) {
        Trace.traceBegin(32, "IMMS.hideCurrentInputInternal");
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#hideSoftInput", this.mDumper);
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdFromWindowLocked(windowToken);     // Catch: Throwable -> L20
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L20
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Client requesting input be hidden", new Object[0]);     // Catch: Throwable -> L16
        boolean r14 = hideCurrentInputLocked(windowToken, statsToken, 0, null, 4, userId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        Trace.traceEnd(32);     // Catch: Throwable -> L12
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L12
        return r14;
    L14:
        th = move-exception;
        Throwable r15 = th;
    L18:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        Trace.traceEnd(32);     // Catch: Throwable -> L12
        throw r15;     // Catch: Throwable -> L12
    L16:
        th = move-exception;
        r15 = th;
    L12:
        th = move-exception;
        Throwable r16 = th;
    L22:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L12
        throw r16;
    L20:
        th = move-exception;
        r16 = th;
        goto L22
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startStylusHandwriting(IInputMethodClient client) {
        startStylusHandwriting(client, false);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startConnectionlessStylusHandwriting(IInputMethodClient client, final int userId, CursorAnchorInfo cursorAnchorInfo, final String delegatePackageName, final String delegatorPackageName, final IConnectionlessHandwritingCallback callback) {
        monitor-enter(ImfLock.class);
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L9
        boolean isForDelegation = true;
        if (bindingController.supportsConnectionlessStylusHandwriting() == true) goto L16;
        Slog.w(TAG, "Connectionless stylus handwriting mode unsupported by IME.");     // Catch: Throwable -> L9
        callback.onError(1);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to report CONNECTIONLESS_HANDWRITING_ERROR_UNSUPPORTED", e);     // Catch: Throwable -> L9
        e.rethrowAsRuntimeException();     // Catch: Throwable -> L9
        goto L13
    L16:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        if (delegatePackageName == null) goto L21;
        if (delegatorPackageName == null) goto L21;
    L23:
        if (isForDelegation == true) goto L25;
        IConnectionlessHandwritingCallback immsCallback = callback;
    L46:
        if (startStylusHandwriting(client, false, immsCallback, cursorAnchorInfo, isForDelegation) == true) goto L68;
        callback.onError(2);     // Catch: RemoteException -> L49
        return;
    L49:
        e = move-exception;
        Slog.e(TAG, "Failed to report CONNECTIONLESS_HANDWRITING_ERROR_OTHER", e);
        e.rethrowAsRuntimeException();
        return;
    L68:
        return;
    L25:
        monitor-enter(ImfLock.class);
    L36:
        th = th;
    L42:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L36
        throw th;
    L30:
        th = th;
        goto L42
    L27:
        if (this.mClientController.verifyClientAndPackageMatch(client, delegatorPackageName) == false) goto L33;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L30
        IConnectionlessHandwritingCallback immsCallback2 = new AnonymousClass3(this, userId, delegatePackageName, delegatorPackageName, callback);
        immsCallback = immsCallback2;
        goto L46
    L33:
        Slog.w(TAG, "startConnectionlessStylusHandwriting() fail");     // Catch: Throwable -> L36
        callback.onError(2);     // Catch: Throwable -> L36 RemoteException -> L38
    L41:
        throw new IllegalArgumentException("Delegator doesn't match UID");     // Catch: Throwable -> L36
    L38:
        e = move-exception;
        Slog.e(TAG, "Failed to report CONNECTIONLESS_HANDWRITING_ERROR_OTHER", e);     // Catch: Throwable -> L36
        e.rethrowAsRuntimeException();     // Catch: Throwable -> L36
    L21:
        isForDelegation = false;
    L9:
        th = th;
    L60:
        throw th;
    L54:
        th = th;
        goto L60
    }

    private void startStylusHandwriting(IInputMethodClient client, boolean acceptingDelegation) {
        startStylusHandwriting(client, acceptingDelegation, null, null, false);
    }

    private boolean startStylusHandwriting(IInputMethodClient client, boolean acceptingDelegation, IConnectionlessHandwritingCallback connectionlessCallback, CursorAnchorInfo cursorAnchorInfo, boolean isConnectionlessForDelegation) {
        Trace.traceBegin(32, "IMMS.startStylusHandwriting");
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#startStylusHandwriting", this.mDumper);     // Catch: Throwable -> L76
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L76
        int callingUserId = UserHandle.getUserId(uid);     // Catch: Throwable -> L76
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L76
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L8
        if (acceptingDelegation == true) goto L11;
        this.mHwController.clearPendingHandwritingDelegation();     // Catch: Throwable -> L8
    L11:
        if (canInteractWithImeLocked(uid, client, "startStylusHandwriting", null, userId) == true) goto L16;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L16:
        if (hasSupportedStylusLocked() == true) goto L21;
        Slog.w(TAG, "No supported Stylus hardware found on device. Ignoring startStylusHandwriting()");     // Catch: Throwable -> L8
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L21:
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L29
        if (bindingController.supportsStylusHandwriting() == true) goto L31;
        Slog.w(TAG, "Stylus HW unsupported by IME. Ignoring startStylusHandwriting()");     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L31:
        OptionalInt requestId = this.mHwController.getCurrentRequestId();     // Catch: Throwable -> L29
        if (requestId.isPresent() == true) goto L39;
        Slog.e(TAG, "Stylus handwriting was not initialized.");     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L39:
        if (this.mHwController.isStylusGestureOngoing() == true) goto L46;
        Slog.e(TAG, "There is no ongoing stylus gesture to start stylus handwriting.");     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L46:
        if (this.mHwController.hasOngoingStylusHandwritingSession() == false) goto L52;
        Slog.e(TAG, "Stylus handwriting session is already ongoing. Ignoring startStylusHandwriting().");     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L8
        Trace.traceEnd(32);
        return false;
    L52:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Client requesting Stylus Handwriting to be started", new Object[0]);     // Catch: Throwable -> L29
        IInputMethodInvoker curMethod = bindingController.getCurMethod();     // Catch: Throwable -> L29
        if (curMethod == null) goto L66;
        curMethod.canStartStylusHandwriting(requestId.getAsInt(), connectionlessCallback, cursorAnchorInfo, isConnectionlessForDelegation);     // Catch: Throwable -> L63
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L61
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L61
        Trace.traceEnd(32);
        return true;
    L63:
        th = th;
    L70:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L66:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L61
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L61
        Trace.traceEnd(32);
        return false;
    L29:
        th = th;
    L8:
        th = th;
    L72:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L74
    L74:
        th = th;
    L78:
        Trace.traceEnd(32);
        throw th;
    L61:
        th = th;
    L76:
        th = th;
        goto L78
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void prepareStylusHandwritingDelegation(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName) {
        if (isStylusHandwritingEnabled(this.mContext, userId) == true) goto L7;
        Slog.w(TAG, "Can not prepare stylus handwriting delegation. Stylus handwriting pref is disabled for user: " + userId);
        return;
    L7:
        monitor-enter(ImfLock.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mClientController.verifyClientAndPackageMatch(client, delegatorPackageName) == false) goto L15;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L13
        schedulePrepareStylusHandwritingDelegation(userId, delegatePackageName, delegatorPackageName);
        return;
    L15:
        Slog.w(TAG, "prepareStylusHandwritingDelegation() fail");     // Catch: Throwable -> L13
        throw new IllegalArgumentException("Delegator doesn't match Uid");     // Catch: Throwable -> L13
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void acceptStylusHandwritingDelegationAsync(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags, IBooleanListener callback) {
        boolean result = acceptStylusHandwritingDelegation(client, userId, delegatePackageName, delegatorPackageName, flags);
        callback.onResult(result);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to report result=" + result, e);
        e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean acceptStylusHandwritingDelegation(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags) {
        if (isStylusHandwritingEnabled(this.mContext, userId) == true) goto L7;
        Slog.w(TAG, "Can not accept stylus handwriting delegation. Stylus handwriting pref is disabled for user: " + userId);
        return false;
    L7:
        if (verifyDelegator(client, delegatePackageName, delegatorPackageName, flags) == true) goto L10;
        return false;
    L10:
        monitor-enter(ImfLock.class);
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L17
        if (this.mHwController.isDelegationUsingConnectionlessFlow() == false) goto L20;
        IInputMethodInvoker curMethod = bindingController.getCurMethod();     // Catch: Throwable -> L17
        if (curMethod != null) goto L19;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L17
        return false;
    L19:
        curMethod.commitHandwritingDelegationTextIfAvailable();     // Catch: Throwable -> L17
        this.mHwController.clearPendingHandwritingDelegation();     // Catch: Throwable -> L17
    L21:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L17
        return true;
    L20:
        startStylusHandwriting(client, true);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private boolean verifyDelegator(IInputMethodClient client, String delegatePackageName, String delegatorPackageName, int flags) {
        monitor-enter(ImfLock.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mClientController.verifyClientAndPackageMatch(client, delegatePackageName) == true) goto L12;
        Slog.w(TAG, "Delegate package does not belong to the same user. Ignoring startStylusHandwriting");     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return false;
    L12:
        if ((flags & 1) == 0) goto L14;
        boolean homeDelegatorAllowed = true;
    L16:
        if (delegatorPackageName.equals(this.mHwController.getDelegatorPackageName()) == true) goto L24;
        if (homeDelegatorAllowed == true) goto L19;
    L20:
        Slog.w(TAG, "Delegator package does not match. Ignoring startStylusHandwriting");     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return false;
    L19:
        if (this.mHwController.isDelegatorFromDefaultHomePackage() == false) goto L20;
    L24:
        if (delegatePackageName.equals(this.mHwController.getDelegatePackageName()) == true) goto L29;
        Slog.w(TAG, "Delegate package does not match. Ignoring startStylusHandwriting");     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return false;
    L29:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return true;
    L14:
        homeDelegatorAllowed = false;
        goto L16
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void reportPerceptibleAsync(final IBinder windowToken, final boolean perceptible) {
        Binder.withCleanCallingIdentity(new InputMethodManagerService$$ExternalSyntheticLambda23(this, windowToken, perceptible));
    }

    private /* synthetic */ void lambda$reportPerceptibleAsync$11(IBinder windowToken, boolean perceptible) throws Exception {
        windowToken.getClass();
        monitor-enter(ImfLock.class);
        Boolean windowPerceptible = this.mFocusedWindowPerceptible.get(windowToken);     // Catch: Throwable -> L10
        int userId = resolveImeUserIdFromWindowLocked(windowToken);     // Catch: Throwable -> L10
        UserData userData = getUserData(userId);     // Catch: Throwable -> L10
        if (userData.mImeBindingState.mFocusedWindow != windowToken) goto L15;
        if (windowPerceptible != null) goto L8;
    L12:
        this.mFocusedWindowPerceptible.put(windowToken, Boolean.valueOf(perceptible));     // Catch: Throwable -> L10
        updateSystemUiLocked(userId);     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L8:
        if (windowPerceptible.booleanValue() != perceptible) goto L12;
    L15:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean showCurrentInputLocked(IBinder windowToken, int flags, int reason, int userId) {
        ImeTracker.Token statsToken = createStatsTokenForFocusedClient(true, reason, userId);
        return showCurrentInputLocked(windowToken, statsToken, flags, 0, null, reason, userId);
    }

    boolean showCurrentInputLocked(IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, int userId) {
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        if (visibilityStateComputer.onImeShowFlags(statsToken, flags) == true) goto L5;
        return false;
    L5:
        getExt().showCurrentInputLocked(getCurMethodLocked(), userData.mCurEditorInfo, resultReceiver, flags);
        if (this.mSystemReady == true) goto L9;
        ImeTracker.forLogging().onFailed(statsToken, 5);
        return false;
    L9:
        ImeTracker.forLogging().onProgress(statsToken, 5);
        if (getExt().shouldIgnoreShowSoftInput(reason) == false) goto L13;
        visibilityStateComputer.clearImeShowFlags();
        setImeVisibilityOnFocusedWindowClient(false, userData, statsToken);
        ImeTracker.forLogging().onFailed(statsToken, 5);
        sendResultReceiverFailureLocked(resultReceiver, userId);
        return false;
    L13:
        visibilityStateComputer.requestImeVisibility(windowToken, true);
        InputMethodBindingController bindingController = userData.mBindingController;
        bindingController.setCurrentMethodVisible();
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        ImeTracker.forLogging().onCancelled(userData.mCurStatsToken, 8);
        if (curMethod != null) goto L16;
    L20:
        boolean r4 = false;
    L21:
        boolean readyToDispatchToIme = r4;
        if (readyToDispatchToIme == false) goto L25;
        ImeTracker.forLogging().onProgress(statsToken, 9);
        userData.mCurStatsToken = null;
        maybeReportToolType(userId);
        this.mVisibilityApplier.performShowIme(windowToken, statsToken, visibilityStateComputer.getShowFlagsForInputMethodServiceOnly(), resultReceiver, reason, userId);
        visibilityStateComputer.setInputShown(true);
        return true;
    L25:
        ImeTracker.forLogging().onProgress(statsToken, 8);
        userData.mCurStatsToken = statsToken;
        return false;
    L16:
        if (userData.mCurClient == null) goto L20;
        if (userData.mCurClient.mCurSession == null) goto L20;
        r4 = true;
        goto L21
    }

    private void maybeReportToolType(int userId) {
        int lastDeviceId = this.mInputManagerInternal.getLastUsedInputDeviceId();
        InputManager im = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (im != null) goto L5;
        return;
    L5:
        InputDevice device = im.getInputDevice(lastDeviceId);
        if (device != null) goto L9;
        return;
    L9:
        if (isStylusDevice(device) == false) goto L12;
        int toolType = 2;
    L15:
        onUpdateEditorToolTypeLocked(toolType, userId);
        return;
    L12:
        if (isFingerDevice(device) == false) goto L14;
        toolType = 1;
        goto L15
    L14:
        toolType = 0;
        goto L15
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean hideSoftInput(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, boolean async) {
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#hideSoftInput", this.mDumper);
        monitor-enter(ImfLock.class);
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L14
        int callingUserId = UserHandle.getUserId(uid);     // Catch: Throwable -> L14
        int userId = resolveImeUserIdLocked(callingUserId, client);     // Catch: Throwable -> L14
        boolean result = hideSoftInputLocked(client, windowToken, statsToken, flags, resultReceiver, reason, uid, userId);     // Catch: Throwable -> L9
        if (result == true) goto L12;
        sendResultReceiverFailureLocked(resultReceiver, userId);     // Catch: Throwable -> L9
    L12:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return result;
    L9:
        th = th;
    L16:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        throw th;
    L14:
        th = th;
        goto L16
    }

    private boolean hideSoftInputLocked(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, int uid, int userId) {
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        int r2 = 3;
        if (canInteractWithImeLocked(uid, client, "hideSoftInput", statsToken, userId) == false) goto L5;
        long ident = Binder.clearCallingIdentity();
        Trace.traceBegin(32, "IMMS.hideSoftInput");     // Catch: Throwable -> L28
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Client requesting input be hidden", new Object[0]);     // Catch: Throwable -> L28
        boolean wasVisible = visibilityStateComputer.isInputShown();     // Catch: Throwable -> L28
        if (setImeVisibilityOnFocusedWindowClient(false, userData, statsToken) == true) goto L22;
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        return false;
    L22:
        if (resultReceiver == null) goto L30;
        if (wasVisible == true) goto L26;
        r2 = 1;
    L26:
        resultReceiver.send(r2, null);     // Catch: Throwable -> L28
    L30:
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        return true;
    L28:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        Trace.traceEnd(32);
        throw th;
    L5:
        if (visibilityStateComputer.isInputShown() == false) goto L7;
        ImeTracker.forLogging().onFailed(statsToken, 3);
    L8:
        ClientState cs = this.mClientController.getClient(client.asBinder());
        if (cs != null) goto L13;
        Slog.e(TAG, "hideSoftInput: client not found");
        return false;
    L13:
        if (cs.mSelfReportedDisplayId == 0) goto L17;
        return this.mWindowManagerInternal.getObricWindowManagerInternal().hideImeInAuto(windowToken, cs.mSelfReportedDisplayId);
    L17:
        return false;
    L7:
        ImeTracker.forLogging().onCancelled(statsToken, 3);
        goto L8
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void hideSoftInputFromServerForTest() {
        int callingUserId = UserHandle.getCallingUserId();
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L7
        UserData userData = getUserData(userId);     // Catch: Throwable -> L7
        hideCurrentInputLocked(userData.mImeBindingState.mFocusedWindow, 0, 4, userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean hideCurrentInputLocked(IBinder windowToken, int flags, int reason, int userId) {
        ImeTracker.Token statsToken = createStatsTokenForFocusedClient(false, reason, userId);
        return hideCurrentInputLocked(windowToken, statsToken, flags, null, reason, userId);
    }

    boolean hideCurrentInputLocked(IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, int userId) {
        UserData userData = getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        if (visibilityStateComputer.canHideIme(statsToken, flags) == true) goto L5;
        return false;
    L5:
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod == null) goto L12;
        boolean r2 = true;
        if (visibilityStateComputer.isInputShown() == false) goto L10;
    L13:
        boolean shouldHideSoftInput = r2;
        visibilityStateComputer.requestImeVisibility(windowToken, false);
        if (shouldHideSoftInput == false) goto L16;
        ImeTracker.forLogging().onProgress(statsToken, 10);
        this.mVisibilityApplier.performHideIme(windowToken, statsToken, resultReceiver, reason, userId);
    L17:
        getExt().hideCurrentInputLocked();
        bindingController.setCurrentMethodNotVisible();
        visibilityStateComputer.clearImeShowFlags();
        ImeTracker.forLogging().onCancelled(userData.mCurStatsToken, 8);
        userData.mCurStatsToken = null;
        return shouldHideSoftInput;
    L16:
        ImeTracker.forLogging().onCancelled(statsToken, 10);
        goto L17
    L10:
        if ((bindingController.getImeWindowVis() & 1) != 0) goto L13;
    L12:
        r2 = false;
        goto L13
    }

    private boolean isImeClientFocused(IBinder windowToken, ClientState cs) {
        int imeClientFocus = this.mWindowManagerInternal.hasInputMethodClientFocus(windowToken, cs.mUid, cs.mPid, cs.mSelfReportedDisplayId);
        if (imeClientFocus != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startInputOrWindowGainedFocusAsync(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible, int startInputSeq, boolean useAsyncShowHideMethod) {
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputBindResult startInputOrWindowGainedFocus(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible) {
        if (UserHandle.getCallingUserId() == userId) goto L14;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
        if (editorInfo == null) goto L12;
        if (editorInfo.targetInputMethodUser == null) goto L12;
        if (editorInfo.targetInputMethodUser.getIdentifier() == userId) goto L14;
    L12:
        throw new InvalidParameterException("EditorInfo#targetInputMethodUser must also be specified for cross-user startInputOrWindowGainedFocus()");
    L14:
        if (UserHandleSmtEx.isUserDoppelganger(userId) == false) goto L16;
        int userId2 = 0;
    L17:
        if (windowToken != null) goto L21;
        Slog.e(TAG, "windowToken cannot be null.");
        return InputBindResult.NULL;
    L21:
        if (this.mUserManagerInternal.isUserRunning(userId2) == true) goto L24;
        Slog.w(TAG, "User #" + userId2 + " is not running.");
        return InputBindResult.INVALID_USER;
    L24:
        UserData userData = getUserData(userId2);
        Trace.traceBegin(32, "IMMS.startInputOrWindowGainedFocus");     // Catch: Throwable -> L165
        ImeTracing.getInstance().triggerManagerServiceDump("InputMethodManagerService#startInputOrWindowGainedFocus", this.mDumper);     // Catch: Throwable -> L165
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L165
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L159
        if (this.mSystemReady == true) goto L35;
        InputBindResult r17 = new InputBindResult(8, null, null, null, bindingController.getSelectedMethodId(), bindingController.getSequenceNumber(), false);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r17;
    L35:
        ClientState cs = this.mClientController.getClient(client.asBinder());     // Catch: Throwable -> L159
        if (cs == null) goto L162;
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L159
    L129:
        th = th;
    L157:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        throw th;     // Catch: Throwable -> L125
    L40:
        int r8 = 0;
        if (this.mConcurrentMultiUserModeEnabled == false) goto L180;
    L68:
        int imeClientFocus = this.mWindowManagerInternal.hasInputMethodClientFocus(windowToken, cs.mUid, cs.mPid, cs.mSelfReportedDisplayId);     // Catch: Throwable -> L129
        switch(imeClientFocus) {
            case -4: goto L152;
            case -3: goto L146;
            case -2: goto L140;
            case -1: goto L132;
            default: goto L70;
        };     // Catch: Throwable -> L129
    L70:
        getExt().setRealInputConnection(inputConnection);     // Catch: Throwable -> L129
        if (userData.mCurClient == null) goto L74;
        int currentClientPid = userData.mCurClient.mPid;     // Catch: Throwable -> L51
    L76:
        if (this.mImePlatformCompatUtils.shouldClearShowForcedFlag(cs.mUid) == false) goto L78;
    L81:
        boolean r10 = true;
    L82:
        boolean shouldClearFlag = r10;
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L129
        boolean showForced = visibilityStateComputer.mShowForced;     // Catch: Throwable -> L129
        if (userData.mImeBindingState.mFocusedWindow == windowToken) goto L88;
        if (showForced == false) goto L88;
        if (shouldClearFlag == false) goto L88;
        visibilityStateComputer.mShowForced = false;     // Catch: Throwable -> L51
    L88:
        if (this.mConcurrentMultiUserModeEnabled == false) goto L91;
    L104:
        if (editorInfo == null) goto L170;
        if (InputMethodUtils.checkIfPackageBelongsToUid(this.mPackageManagerInternal, cs.mUid, editorInfo.packageName) == true) goto L170;
        Slog.e(TAG, "Rejecting this client as it reported an invalid package name. uid=" + cs.mUid + " package=" + editorInfo.packageName);     // Catch: Throwable -> L51
        InputBindResult r9 = InputBindResult.INVALID_PACKAGE_NAME;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r9;
    L170:
        InputBindResult result = startInputOrWindowGainedFocusInternalLocked(startInputReason, client, windowToken, startInputFlags, softInputMode, windowFlags, editorInfo, inputConnection, remoteAccessibilityInputConnection, unverifiedTargetSdkVersion, bindingController, imeDispatcher, cs, imeRequestedVisible);     // Catch: Throwable -> L127
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        if (result != null) goto L123;
        Slog.wtf(TAG, "InputBindResult is @NonNull. startInputReason=" + InputMethodDebug.startInputReasonToString(startInputReason) + " windowFlags=#" + Integer.toHexString(windowFlags) + " editorInfo=" + editorInfo);     // Catch: Throwable -> L121
        InputBindResult r0 = InputBindResult.NULL;     // Catch: Throwable -> L121
        Trace.traceEnd(32);
        return r0;
    L123:
        Trace.traceEnd(32);
        return result;
    L127:
        th = th;
        goto L157
    L91:
        if (userId2 == this.mCurrentImeUserId) goto L104;
        if (ArrayUtils.contains(this.mUserManagerInternal.getProfileIds(this.mCurrentImeUserId, false), userId2) == false) goto L99;
        scheduleSwitchUserTaskLocked(userId2, cs.mClient);     // Catch: Throwable -> L51
        InputBindResult r11 = InputBindResult.USER_SWITCHING;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r11;
    L99:
        Slog.w(TAG, "A background user is requesting window. Hiding IME.");     // Catch: Throwable -> L51
        Slog.w(TAG, "If you need to impersonate a foreground user/profile from a background user, use EditorInfo.targetInputMethodUser with INTERACT_ACROSS_USERS_FULL permission.");     // Catch: Throwable -> L51
        hideCurrentInputLocked(userData.mImeBindingState.mFocusedWindow, 0, 11, userId2);     // Catch: Throwable -> L51
        InputBindResult r12 = InputBindResult.INVALID_USER;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r12;
    L78:
        if (cs.mPid != currentClientPid) goto L81;
        r10 = false;
        goto L82
    L74:
        currentClientPid = -1;
        goto L76
    L132:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Focus gain on non-focused client %s (uid=%s pid=%s)", new Object[]{cs.mClient, Integer.valueOf(cs.mUid), Integer.valueOf(cs.mPid)});     // Catch: Throwable -> L137
        InputBindResult r1 = InputBindResult.NOT_IME_TARGET_WINDOW;     // Catch: Throwable -> L137
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        Trace.traceEnd(32);
        return r1;
    L140:
        Slog.e(TAG, "startInputOrWindowGainedFocusInternal: display ID mismatch.");     // Catch: Throwable -> L137
        InputBindResult r2 = InputBindResult.DISPLAY_ID_MISMATCH;     // Catch: Throwable -> L137
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        Trace.traceEnd(32);
        return r2;
    L146:
        InputBindResult r3 = InputBindResult.INVALID_DISPLAY_ID;     // Catch: Throwable -> L137
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        Trace.traceEnd(32);
        return r3;
    L152:
        InputBindResult r4 = getObricExt().getInputBindResult(windowToken, startInputFlags, editorInfo, inputConnection, cs);     // Catch: Throwable -> L137
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L125
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        Trace.traceEnd(32);
        return r4;
    L137:
        th = th;
        goto L157
    L180:
    L51:
        th = th;
        goto L157
    L43:
        if (this.mUserSwitchHandlerTask == null) goto L68;
        int nextUserId = this.mUserSwitchHandlerTask.mToUserId;     // Catch: Throwable -> L51
        if (userId2 != nextUserId) goto L53;
        scheduleSwitchUserTaskLocked(userId2, cs.mClient);     // Catch: Throwable -> L51
        InputBindResult r13 = InputBindResult.USER_SWITCHING;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r13;
    L53:
        int[] profileIdsWithDisabled = this.mUserManagerInternal.getProfileIds(this.mCurrentImeUserId, false);     // Catch: Throwable -> L51
        int r14 = profileIdsWithDisabled.length;     // Catch: Throwable -> L51
    L54:
        if (r8 >= r14) goto L63;
        int profileId = profileIdsWithDisabled[r8];     // Catch: Throwable -> L51
        if (profileId == userId2) goto L57;
        r8 = r8 + 1;
        goto L54
    L57:
        scheduleSwitchUserTaskLocked(userId2, cs.mClient);     // Catch: Throwable -> L51
        InputBindResult r15 = InputBindResult.USER_SWITCHING;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r15;
    L63:
        InputBindResult r16 = InputBindResult.INVALID_USER;     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L33
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L33
        Trace.traceEnd(32);
        return r16;
    L162:
        throw new IllegalArgumentException("Unknown client " + client.asBinder());     // Catch: Throwable -> L125
    L33:
        th = th;
    L163:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L125
        throw th;     // Catch: Throwable -> L121
    L159:
        th = th;
    L125:
        th = th;
    L121:
        th = th;
    L167:
        Trace.traceEnd(32);
        throw th;
    L165:
        th = th;
        goto L167
    L16:
        userId2 = userId;
        goto L17
    }

    private InputBindResult startInputOrWindowGainedFocusInternalLocked(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputContext, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, InputMethodBindingController bindingController, ImeOnBackInvokedDispatcher imeDispatcher, ClientState cs, boolean imeRequestedVisible) {
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "startInputOrWindowGainedFocusInternalLocked: reason=%s client=%s inputContext=%s editorInfo=%s startInputFlags=%s softInputMode=%s windowFlags=#%s unverifiedTargetSdkVersion=%s bindingController=%s imeDispatcher=%s cs=%s imeRequestedVisible=%s", new Object[]{InputMethodDebug.startInputReasonToString(startInputReason), client.asBinder(), inputContext, editorInfo, InputMethodDebug.startInputFlagsToString(startInputFlags), InputMethodDebug.softInputModeToString(softInputMode), Integer.toHexString(windowFlags), Integer.valueOf(unverifiedTargetSdkVersion), bindingController, imeDispatcher, cs, Boolean.valueOf(imeRequestedVisible)});
        int userId = bindingController.getUserId();
        UserData userData = getUserData(userId);
        if (userData.mImeBindingState.mFocusedWindow != windowToken) goto L5;
        boolean r1 = true;
    L6:
        boolean sameWindowFocused = r1;
        if ((startInputFlags & 2) == 0) goto L9;
        boolean r2 = true;
    L10:
        boolean isTextEditor = r2;
        if ((startInputFlags & 8) == 0) goto L13;
        boolean startInputByWinGainedFocus = true;
    L14:
        if (editorInfo == null) goto L16;
        int toolType = editorInfo.getInitialToolType();
    L18:
        if (sameWindowFocused == true) goto L20;
        boolean r7 = true;
    L21:
        ImeVisibilityStateComputer.ImeTargetWindowState windowState = new ImeVisibilityStateComputer.ImeTargetWindowState(softInputMode, windowFlags, r7, isTextEditor, startInputByWinGainedFocus, toolType);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        visibilityStateComputer.setWindowState(windowToken, windowState);
        InputBindResult result = getExt().startInput(windowToken, cs, inputContext, remoteAccessibilityInputConnection, editorInfo, startInputFlags, startInputReason, unverifiedTargetSdkVersion, imeDispatcher, bindingController, softInputMode, userData);
        if (result == null) goto L24;
        return result;
    L24:
        if (sameWindowFocused == false) goto L32;
        if (isTextEditor == false) goto L32;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Window already focused, ignoring focus gain of: %s editorInfo=%s, token=%s, startInputReason=%s", new Object[]{client, editorInfo, windowToken, InputMethodDebug.startInputReasonToString(startInputReason)});
        if (editorInfo == null) goto L31;
        return startInputUncheckedLocked(cs, inputContext, remoteAccessibilityInputConnection, editorInfo, startInputFlags, startInputReason, unverifiedTargetSdkVersion, imeDispatcher, bindingController);
    L31:
        return new InputBindResult(4, null, null, null, null, -1, false);
    L32:
        userData.mImeBindingState = new ImeBindingState(bindingController.getUserId(), windowToken, softInputMode, cs, editorInfo);
        this.mFocusedWindowPerceptible.put(windowToken, true);
        boolean didStart = false;
        InputBindResult res = null;
        ImeVisibilityStateComputer.ImeVisibilityResult imeVisRes = visibilityStateComputer.computeState(windowState, InputMethodUtils.isSoftInputModeStateVisibleAllowed(unverifiedTargetSdkVersion, startInputFlags), imeRequestedVisible);
        if (imeVisRes != null) goto L35;
        ClientState r3 = cs;
        InputMethodManagerService r0 = this;
    L49:
        if (didStart == true) goto L54;
        if (editorInfo == null) goto L53;
        return r0.startInputUncheckedLocked(r3, inputContext, remoteAccessibilityInputConnection, editorInfo, startInputFlags, startInputReason, unverifiedTargetSdkVersion, imeDispatcher, bindingController);
    L53:
        return InputBindResult.NULL_EDITOR_INFO;
    L54:
        return res;
    L35:
        switch(imeVisRes.getReason()) {
            case 6: goto L38;
            case 7: goto L38;
            case 8: goto L38;
            case 23: goto L38;
            default: goto L36;
        };
    L36:
        boolean isShow = false;
        r0 = this;
        boolean didStart2 = false;
    L41:
        ImeTracker.Token statsToken = r0.createStatsTokenForFocusedClient(isShow, imeVisRes.getReason(), userId);
        r0.mVisibilityApplier.applyImeVisibility(userData.mImeBindingState.mFocusedWindow, statsToken, imeVisRes.getState(), imeVisRes.getReason(), userId);
        if (imeVisRes.getReason() != 12) goto L46;
        r3 = cs;
        if (r3.mSelfReportedDisplayId == bindingController.getCurTokenDisplayId()) goto L47;
        bindingController.unbindCurrentMethod();
    L47:
        didStart = didStart2;
        goto L49
    L46:
        r3 = cs;
        goto L47
    L38:
        if (editorInfo == null) goto L40;
        r0 = this;
        res = r0.startInputUncheckedLocked(cs, inputContext, remoteAccessibilityInputConnection, editorInfo, startInputFlags, startInputReason, unverifiedTargetSdkVersion, imeDispatcher, bindingController);
        didStart2 = true;
        isShow = true;
        goto L41
    L40:
        r0 = this;
        didStart2 = false;
        isShow = true;
        goto L41
    L20:
        r7 = false;
        goto L21
    L16:
        toolType = 0;
        goto L18
    L13:
        startInputByWinGainedFocus = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private boolean canInteractWithImeLocked(int uid, IInputMethodClient client, String methodName, ImeTracker.Token statsToken, int userId) {
        UserData userData = getUserData(userId);
        if (userData.mCurClient == null) goto L7;
        if (client == null) goto L7;
        if (userData.mCurClient.mClient.asBinder() != client.asBinder()) goto L7;
    L13:
        ImeTracker.forLogging().onProgress(statsToken, 3);
        return true;
    L7:
        ClientState cs = this.mClientController.getClient(client.asBinder());
        if (cs == null) goto L15;
        ImeTracker.forLogging().onProgress(statsToken, 2);
        if (isImeClientFocused(userData.mImeBindingState.mFocusedWindow, cs) == true) goto L13;
        Slog.w(TAG, String.format("Ignoring %s of uid %d : %s", new Object[]{methodName, Integer.valueOf(uid), client}));
        return false;
    L15:
        ImeTracker.forLogging().onFailed(statsToken, 2);
        throw new IllegalArgumentException("unknown client " + client.asBinder());
    }

    private boolean canShowInputMethodPickerLocked(IInputMethodClient client, int userId) {
        int uid = Binder.getCallingUid();
        UserData userData = getUserData(userId);
        if (userData.mImeBindingState.mFocusedWindowClient == null) goto L9;
        if (client == null) goto L9;
        if (userData.mImeBindingState.mFocusedWindowClient.mClient.asBinder() != client.asBinder()) goto L9;
        return true;
    L9:
        if (userId == UserHandle.getUserId(uid)) goto L11;
        return false;
    L11:
        Intent curIntent = getInputMethodBindingController(userId).getCurIntent();
        if (curIntent == null) goto L17;
        if (InputMethodUtils.checkIfPackageBelongsToUid(this.mPackageManagerInternal, uid, curIntent.getComponent().getPackageName()) == false) goto L17;
        return true;
    L17:
        if (getObricExt().canShowAutoInputMethodPicker(client) == false) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void showInputMethodPickerFromClient(IInputMethodClient client, final int auxiliarySubtypeMode) {
        if (this.mConcurrentMultiUserModeEnabled == false) goto L6;
        Slog.w(TAG, "showInputMethodPickerFromClient is not enabled on automotive");
        return;
    L6:
        int callingUserId = UserHandle.getCallingUserId();
        monitor-enter(ImfLock.class);
        final int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L13
        if (canShowInputMethodPickerLocked(client, userId) == true) goto L15;
        Slog.w(TAG, "Ignoring showInputMethodPickerFromClient of uid " + Binder.getCallingUid() + ": " + client);     // Catch: Throwable -> L13
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L13
        return;
    L15:
        UserData userData = getUserData(userId);     // Catch: Throwable -> L13
        if (userData.mCurClient == null) goto L18;
        int fallbackDisplayId = userData.mCurClient.mSelfReportedDisplayId;     // Catch: Throwable -> L13
    L19:
        final int displayId = getObricExt().getAutoInputMethodPickerDisplayId(client, fallbackDisplayId);     // Catch: Throwable -> L13
        this.mHandler.post(new InputMethodManagerService$$ExternalSyntheticLambda7(this, auxiliarySubtypeMode, displayId, userId));     // Catch: Throwable -> L13
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L13
        return;
    L18:
        fallbackDisplayId = 0;
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$showInputMethodPickerFromClient$12(int auxiliarySubtypeMode, int displayId, int userId) {
        monitor-enter(ImfLock.class);
        showInputMethodPickerLocked(auxiliarySubtypeMode, displayId, userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void showInputMethodPickerFromSystem(final int auxiliarySubtypeMode, final int displayId) {
        this.mHandler.post(new InputMethodManagerService$$ExternalSyntheticLambda0(this, displayId, auxiliarySubtypeMode));
    }

    private /* synthetic */ void lambda$showInputMethodPickerFromSystem$13(int displayId, int auxiliarySubtypeMode) {
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdFromDisplayIdLocked(displayId);     // Catch: Throwable -> L7
        showInputMethodPickerLocked(auxiliarySubtypeMode, displayId, userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isInputMethodPickerShownForTest() {
        monitor-enter(ImfLock.class);
        boolean r1 = this.mMenuController.isisInputMethodPickerShownForTestLocked();     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void onImeSwitchButtonClickFromSystem(int displayId) {
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdFromDisplayIdLocked(displayId);     // Catch: Throwable -> L7
        UserData userData = getUserData(userId);     // Catch: Throwable -> L7
        onImeSwitchButtonClickLocked(displayId, userData);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onImeSwitchButtonClickLocked(int displayId, UserData userData) {
        int userId = userData.mUserId;
        if (hasMultipleSubtypesForSwitcher(true, userId) == false) goto L5;
        switchToNextInputMethodLocked(false, userData);
        return;
    L5:
        showInputMethodPickerFromSystem(1, displayId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean shouldShowImeSwitcherButtonForTest() {
        int callingUserId = UserHandle.getCallingUserId();
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L7
        boolean r3 = shouldShowImeSwitcherLocked(3, userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private static IllegalArgumentException getExceptionForUnknownImeId(String imeId) {
        return new IllegalArgumentException("Unknown id: " + imeId);
    }

    private void setInputMethodAndSubtypeLocked(String id, InputMethodSubtype subtype, UserData userData) {
        int callingUid = Binder.getCallingUid();
        int userId = userData.mUserId;
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodInfo imi = settings.getMethodMap().get(id);
        if (imi == null) goto L12;
        if (canCallerAccessInputMethod(imi.getPackageName(), callingUid, userId, settings) == false) goto L12;
        if (subtype == null) goto L8;
        int subtypeIndex = SubtypeUtils.getSubtypeIndexFromHashCode(imi, subtype.hashCode());
    L9:
        setInputMethodWithSubtypeIndexLocked(id, subtypeIndex, userId);
        return;
    L8:
        subtypeIndex = -1;
    L12:
        throw getExceptionForUnknownImeId(id);
    }

    private boolean switchToPreviousInputMethodLocked(UserData userData) {
        int userId = userData.mUserId;
        InputMethodBindingController bindingController = userData.mBindingController;
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        Pair<String, String> lastIme = settings.getLastInputMethodAndSubtype();
        if (lastIme == null) goto L5;
        InputMethodInfo lastImi = settings.getMethodMap().get((String) lastIme.first);
    L6:
        InputMethodSubtype currentSubtype = bindingController.getCurrentSubtype();
        String targetLastImiId = null;
        int subtypeIndex = -1;
        if (lastIme == null) goto L17;
        if (lastImi == null) goto L17;
        boolean imiIdIsSame = lastImi.getId().equals(bindingController.getSelectedMethodId());
        int lastSubtypeHash = Integer.parseInt((String) lastIme.second);
        if (currentSubtype != null) goto L12;
        int currentSubtypeHash = -1;
    L14:
        if (imiIdIsSame == false) goto L16;
        if (lastSubtypeHash == currentSubtypeHash) goto L17;
    L16:
        targetLastImiId = (String) lastIme.first;
        subtypeIndex = SubtypeUtils.getSubtypeIndexFromHashCode(lastImi, lastSubtypeHash);
        goto L17
    L12:
        currentSubtypeHash = currentSubtype.hashCode();
    L17:
        boolean imiIdIsSame2 = TextUtils.isEmpty(targetLastImiId);
        boolean r10 = false;
        if (imiIdIsSame2 == true) goto L20;
        boolean r16 = false;
    L44:
        if (TextUtils.isEmpty(targetLastImiId) == true) goto L48;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Switch to: %s, %s, from: %s, %s", new Object[]{lastImi.getId(), lastIme.second, bindingController.getSelectedMethodId(), Integer.valueOf(subtypeIndex)});
        setInputMethodWithSubtypeIndexLocked(targetLastImiId, subtypeIndex, userId);
        return true;
    L48:
        return r16;
    L20:
        if (InputMethodUtils.canAddToLastInputMethod(currentSubtype) == true) goto L41;
        List<InputMethodInfo> enabled = settings.getEnabledInputMethodList();
        int enabledCount = enabled.size();
        if (currentSubtype != null) goto L24;
    L26:
        String locale = SystemLocaleWrapper.get(userId).get(0).toString();
    L27:
        int i = 0;
    L28:
        if (i >= enabledCount) goto L40;
        InputMethodInfo imi = enabled.get(i);
        if (imi.getSubtypeCount() > 0) goto L32;
    L38:
        r16 = r10;
    L39:
        i = i + 1;
        r10 = r16;
        goto L28
    L32:
        if (imi.isSystem() == false) goto L38;
        r16 = r10;
        InputMethodSubtype keyboardSubtype = SubtypeUtils.findLastResortApplicableSubtype(SubtypeUtils.getSubtypes(imi), "keyboard", locale, true);
        if (keyboardSubtype == null) goto L39;
        targetLastImiId = imi.getId();
        subtypeIndex = SubtypeUtils.getSubtypeIndexFromHashCode(imi, keyboardSubtype.hashCode());
        if (keyboardSubtype.getLocale().equals(locale) == false) goto L39;
    L40:
        r16 = r10;
        goto L44
    L24:
        if (TextUtils.isEmpty(currentSubtype.getLocale()) == true) goto L26;
        locale = currentSubtype.getLocale();
        goto L27
    L41:
        r16 = false;
        goto L44
    L5:
        lastImi = null;
        goto L6
    }

    private boolean switchToNextInputMethodLocked(boolean onlyCurrentIme, UserData userData) {
        InputMethodBindingController bindingController = userData.mBindingController;
        InputMethodInfo currentImi = bindingController.getSelectedMethod();
        if (currentImi != null) goto L5;
        return false;
    L5:
        InputMethodSubtypeSwitchingController.ImeSubtypeListItem nextSubtype = userData.mSwitchingController.getNextInputMethodLocked(onlyCurrentIme, currentImi, bindingController.getCurrentSubtype(), 2, true);
        if (nextSubtype != null) goto L8;
        return false;
    L8:
        setInputMethodWithSubtypeIndexLocked(nextSubtype.mImi.getId(), nextSubtype.mSubtypeIndex, userData.mUserId);
        return true;
    }

    private boolean shouldOfferSwitchingToNextInputMethodLocked(UserData userData) {
        InputMethodBindingController bindingController = userData.mBindingController;
        InputMethodInfo currentImi = bindingController.getSelectedMethod();
        if (currentImi != null) goto L5;
        return false;
    L5:
        InputMethodSubtypeSwitchingController.ImeSubtypeListItem nextSubtype = userData.mSwitchingController.getNextInputMethodLocked(false, currentImi, bindingController.getCurrentSubtype(), 2, true);
        if (nextSubtype == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtype getLastInputMethodSubtype(int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        monitor-enter(ImfLock.class);
        InputMethodSubtype r1 = InputMethodSettingsRepository.get(userId).getLastInputMethodSubtype();     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes, int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L5:
        int callingUid = Binder.getCallingUid();
        if (TextUtils.isEmpty(imiId) == true) goto L36;
        if (subtypes == null) goto L43;
        ArrayList<InputMethodSubtype> toBeAdded = new ArrayList();
        int r0 = subtypes.length;
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L16;
        InputMethodSubtype subtype = subtypes[r5];
        if (toBeAdded.contains(subtype) == true) goto L14;
        toBeAdded.add(subtype);
    L15:
        r5 = r5 + 1;
        goto L10
    L14:
        Slog.w(TAG, "Duplicated subtype definition found: " + subtype.getLocale() + ", " + subtype.getMode());
        goto L15
    L16:
        UserData userData = getUserData(userId);
        monitor-enter(ImfLock.class);
    L22:
        th = move-exception;
        throw th;
    L19:
        if (this.mSystemReady == true) goto L24;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L22
        return;
    L24:
        AdditionalSubtypeMap additionalSubtypeMap = AdditionalSubtypeMapRepository.get(userId);     // Catch: Throwable -> L22
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L22
        AdditionalSubtypeMap newAdditionalSubtypeMap = settings.getNewAdditionalSubtypeMap(imiId, toBeAdded, additionalSubtypeMap, this.mPackageManagerInternal, callingUid);     // Catch: Throwable -> L22
        if (additionalSubtypeMap == newAdditionalSubtypeMap) goto L32;
        AdditionalSubtypeMapRepository.putAndSave(userId, newAdditionalSubtypeMap, settings.getMethodMap());     // Catch: Throwable -> L22
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L22
        InputMethodMap methodMap = userData.mRawInputMethodMap.get().toInputMethodMap(AdditionalSubtypeMapRepository.get(userId), 0, userData.mIsUnlockingOrUnlocked.get());     // Catch: Throwable -> L29
        InputMethodSettings newSettings = InputMethodSettings.create(methodMap, userId);     // Catch: Throwable -> L29
        InputMethodSettingsRepository.put(userId, newSettings);     // Catch: Throwable -> L29
        postInputMethodSettingUpdatedLocked(false, userId);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L22
        goto L32
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L32:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L22
        return;
    L43:
        return;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setExplicitlyEnabledInputMethodSubtypes(String imeId, int[] subtypeHashCodes, int userId) {
        ComponentName imeComponentName = null;
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L5:
        int callingUid = Binder.getCallingUid();
        if (imeId == null) goto L8;
        imeComponentName = ComponentName.unflattenFromString(imeId);
    L8:
        if (imeComponentName == null) goto L31;
        if (InputMethodUtils.checkIfPackageBelongsToUid(this.mPackageManagerInternal, callingUid, imeComponentName.getPackageName()) == false) goto L31;
        subtypeHashCodes.getClass();
        long ident = Binder.clearCallingIdentity();
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L27
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L19
        if (settings.setEnabledInputMethodSubtypes(imeId, subtypeHashCodes) == true) goto L21;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);
        return;
    L21:
        UserData userData = getUserData(userId);     // Catch: Throwable -> L19
        userData.mLastEnabledInputMethodsStr = settings.getEnabledInputMethodsStr();     // Catch: Throwable -> L19
        updateInputMethodsFromSettingsLocked(false, userId);     // Catch: Throwable -> L19
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L31:
        throw new SecurityException("Calling UID=" + callingUid + " does not belong to imeId=" + imeId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    @Deprecated
    public int getInputMethodWindowVisibleHeight(final IInputMethodClient client) {
        final int callingUid = Binder.getCallingUid();
        final int callingUserId = UserHandle.getCallingUserId();
        return ((Integer) Binder.withCleanCallingIdentity(new InputMethodManagerService$$ExternalSyntheticLambda22(this, callingUserId, callingUid, client))).intValue();
    }

    private /* synthetic */ Integer lambda$getInputMethodWindowVisibleHeight$14(int callingUserId, int callingUid, IInputMethodClient client) throws Exception {
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L17
        if (canInteractWithImeLocked(callingUid, client, "getInputMethodWindowVisibleHeight", null, userId) == false) goto L9;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L11
        int curTokenDisplayId = bindingController.getCurTokenDisplayId();     // Catch: Throwable -> L11
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return Integer.valueOf(this.mWindowManagerInternal.getInputMethodWindowVisibleHeight(curTokenDisplayId));
    L9:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        return 0;
    L17:
        th = move-exception;
        Throwable r10 = th;
    L19:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L11
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L19
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void removeImeSurface(int displayId) {
        this.mHandler.obtainMessage(MSG_REMOVE_IME_SURFACE).sendToTarget();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void removeImeSurfaceFromWindowAsync(IBinder windowToken) {
        this.mHandler.obtainMessage(MSG_REMOVE_IME_SURFACE_FROM_WINDOW, windowToken).sendToTarget();
    }

    private void registerDeviceListenerAndCheckStylusSupport() {
        final InputManager im = (InputManager) this.mContext.getSystemService(InputManager.class);
        IntArray stylusIds = getStylusInputDeviceIds(im);
        if (stylusIds.size() > 0) goto L5;
    L12:
        im.registerInputDeviceListener(new AnonymousClass4(this, im), this.mHandler);
        return;
    L5:
        monitor-enter(ImfLock.class);
        this.mStylusIds = new IntArray();     // Catch: Throwable -> L9
        this.mStylusIds.addAll(stylusIds);     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void addStylusDeviceIdLocked(int deviceId) {
        if (this.mStylusIds != null) goto L6;
        this.mStylusIds = new IntArray();
    L8:
        Slog.d(TAG, "New Stylus deviceId" + deviceId + " added.");
        this.mStylusIds.add(deviceId);
        InputMethodBindingController bindingController = getInputMethodBindingController(this.mCurrentImeUserId);
        if (this.mHwController.getCurrentRequestId().isPresent() == false) goto L11;
        return;
    L11:
        if (bindingController.supportsStylusHandwriting() == false) goto L15;
        scheduleResetStylusHandwriting();
        return;
    L15:
        return;
    L6:
        if (this.mStylusIds.indexOf(deviceId) == (-1)) goto L8;
    }

    private void removeStylusDeviceIdLocked(int deviceId) {
        if (this.mStylusIds != null) goto L5;
        return;
    L5:
        if (this.mStylusIds.size() == 0) goto L16;
        int index = this.mStylusIds.indexOf(deviceId);
        if (index == (-1)) goto L11;
        this.mStylusIds.remove(index);
        Slog.d(TAG, "Stylus deviceId: " + deviceId + " removed.");
    L11:
        if (this.mStylusIds.size() != 0) goto L15;
        this.mHwController.reset();
        scheduleRemoveStylusHandwritingWindow();
        return;
    L15:
        return;
    }

    private static boolean isStylusDevice(InputDevice inputDevice) {
        if (inputDevice.supportsSource(16386) == false) goto L5;
    L8:
        return true;
    L5:
        if (inputDevice.supportsSource(49154) == true) goto L8;
        return false;
    }

    private static boolean isFingerDevice(InputDevice inputDevice) {
        return inputDevice.supportsSource(UsbACInterface.FORMAT_II_AC3);
    }

    private boolean hasSupportedStylusLocked() {
        if (this.mStylusIds != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mStylusIds.size() == 0) goto L7;
        return true;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void addVirtualStylusIdForTestSession(IInputMethodClient client) {
        int uid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(uid);
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L20
    L10:
        th = move-exception;
        Throwable r11 = th;
    L22:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        throw r11;
    L7:
        if (canInteractWithImeLocked(uid, client, "addVirtualStylusIdForTestSession", null, userId) == true) goto L12;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L12:
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Adding virtual stylus id for session", new Object[0]);     // Catch: Throwable -> L17
        addStylusDeviceIdLocked(VIRTUAL_STYLUS_ID_FOR_TEST.intValue());     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L20:
        th = move-exception;
        r11 = th;
        goto L22
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setStylusWindowIdleTimeoutForTest(IInputMethodClient client, long timeout) {
        int uid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(uid);
        monitor-enter(ImfLock.class);
        int userId = resolveImeUserIdLocked(callingUserId);     // Catch: Throwable -> L21
    L10:
        th = move-exception;
        Throwable r10 = th;
    L23:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        throw r10;
    L7:
        if (canInteractWithImeLocked(uid, client, "setStylusWindowIdleTimeoutForTest", null, userId) == true) goto L12;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L12:
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Setting stylus window idle timeout", new Object[0]);     // Catch: Throwable -> L18
        getCurMethodLocked().setStylusWindowIdleTimeoutForTest(timeout);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L21:
        th = move-exception;
        r10 = th;
        goto L23
    }

    private void removeVirtualStylusIdForTestSessionLocked() {
        removeStylusDeviceIdLocked(VIRTUAL_STYLUS_ID_FOR_TEST.intValue());
    }

    private static IntArray getStylusInputDeviceIds(InputManager im) {
        IntArray stylusIds = new IntArray();
        int[] r1 = im.getInputDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        int id = r1[r3];
        InputDevice device = im.getInputDevice(id);
        if (device == null) goto L11;
        if (device.isEnabled() == false) goto L11;
        if (isStylusDevice(device) == false) goto L11;
        stylusIds.add(id);
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return stylusIds;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startProtoDump(byte[] protoDump, int source, String where) {
        if (protoDump == null) goto L4;
    L6:
        ImeTracing tracingInstance = ImeTracing.getInstance();
        if (tracingInstance.isAvailable() == true) goto L9;
        return;
    L9:
        if (tracingInstance.isEnabled() == false) goto L20;
        ProtoOutputStream proto = new ProtoOutputStream();
        switch(source) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            default: goto L13;
        };
    L13:
        return;
    L14:
        long managerservice_token = proto.start(2246267895810L);
        proto.write(1125281431553L, SystemClock.elapsedRealtimeNanos());
        proto.write(1138166333442L, where);
        dumpDebug(proto, 1146756268035L);
        proto.end(managerservice_token);
    L17:
        tracingInstance.addToBuffer(proto, source);
        return;
    L15:
        long service_token = proto.start(2246267895810L);
        proto.write(1125281431553L, SystemClock.elapsedRealtimeNanos());
        proto.write(1138166333442L, where);
        proto.write(1146756268035L, protoDump);
        proto.end(service_token);
        goto L17
    L16:
        long client_token = proto.start(2246267895810L);
        proto.write(1125281431553L, SystemClock.elapsedRealtimeNanos());
        proto.write(1138166333442L, where);
        proto.write(1146756268035L, protoDump);
        proto.end(client_token);
        goto L17
    L20:
        return;
    L4:
        if (source == 2) goto L6;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isImeTraceEnabled() {
        return ImeTracing.getInstance().isEnabled();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startImeTrace() {
        ImeTracing.getInstance().startTrace(null);
        monitor-enter(ImfLock.class);
        this.mClientController.forAllClients(new InputMethodManagerService$$ExternalSyntheticLambda19());     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$startImeTrace$15(ClientState c) {
        c.mClient.setImeTraceEnabled(true);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void stopImeTrace() {
        ImeTracing.getInstance().stopTrace(null);
        monitor-enter(ImfLock.class);
        this.mClientController.forAllClients(new InputMethodManagerService$$ExternalSyntheticLambda2());     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$stopImeTrace$16(ClientState c) {
        c.mClient.setImeTraceEnabled(false);
    }

    private void dumpDebug(ProtoOutputStream proto, long fieldId) {
        monitor-enter(ImfLock.class);
        int userId = this.mCurrentImeUserId;     // Catch: Throwable -> L7
        UserData userData = getUserData(userId);     // Catch: Throwable -> L7
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L7
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L7
        long token = proto.start(fieldId);     // Catch: Throwable -> L7
        proto.write(1138166333441L, bindingController.getSelectedMethodId());     // Catch: Throwable -> L7
        proto.write(1120986464258L, bindingController.getSequenceNumber());     // Catch: Throwable -> L7
        proto.write(1138166333443L, Objects.toString(userData.mCurClient));     // Catch: Throwable -> L7
        userData.mImeBindingState.dumpDebug(proto, this.mWindowManagerInternal);     // Catch: Throwable -> L7
        proto.write(1138166333445L, this.mWindowManagerInternal.getWindowName(visibilityStateComputer.getLastImeTargetWindow()));     // Catch: Throwable -> L7
        proto.write(1138166333446L, InputMethodDebug.softInputModeToString(userData.mImeBindingState.mFocusedWindowSoftInputMode));     // Catch: Throwable -> L7
        if (userData.mCurEditorInfo == null) goto L9;
        userData.mCurEditorInfo.dumpDebug(proto, 1146756268039L);     // Catch: Throwable -> L7
    L9:
        proto.write(1138166333448L, bindingController.getCurId());     // Catch: Throwable -> L7
        visibilityStateComputer.dumpDebug(proto, fieldId);     // Catch: Throwable -> L7
        proto.write(1133871366157L, userData.mInFullscreenMode);     // Catch: Throwable -> L7
        proto.write(1138166333454L, Objects.toString(bindingController.getCurToken()));     // Catch: Throwable -> L7
        proto.write(1120986464271L, bindingController.getCurTokenDisplayId());     // Catch: Throwable -> L7
        proto.write(1133871366160L, this.mSystemReady);     // Catch: Throwable -> L7
        proto.write(1133871366162L, bindingController.hasMainConnection());     // Catch: Throwable -> L7
        proto.write(1133871366163L, userData.mBoundToMethod);     // Catch: Throwable -> L7
        proto.write(1133871366164L, this.mIsInteractive);     // Catch: Throwable -> L7
        proto.write(1120986464277L, bindingController.getBackDisposition());     // Catch: Throwable -> L7
        proto.write(1120986464278L, bindingController.getImeWindowVis());     // Catch: Throwable -> L7
        proto.write(1133871366167L, this.mMenuController.getShowImeWithHardKeyboard());     // Catch: Throwable -> L7
        proto.write(1133871366169L, this.mConcurrentMultiUserModeEnabled);     // Catch: Throwable -> L7
        proto.end(token);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyUserActionLocked(UserData userData) {
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Got the notification of a user action.", new Object[0]);
        InputMethodBindingController bindingController = userData.mBindingController;
        InputMethodInfo imi = bindingController.getSelectedMethod();
        if (imi == null) goto L6;
        userData.mSwitchingController.onUserActionLocked(imi, bindingController.getCurrentSubtype());
        return;
    }

    private void applyImeVisibilityLocked(IBinder windowToken, boolean setVisible, ImeTracker.Token statsToken, UserData userData) {
        Trace.traceBegin(32, "IMMS.applyImeVisibilityLocked");     // Catch: Throwable -> L14
        int userId = userData.mUserId;     // Catch: Throwable -> L14
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L14
        IBinder requestToken = visibilityStateComputer.getWindowTokenFrom(windowToken, userId);     // Catch: Throwable -> L14
        DefaultImeVisibilityApplier r3 = this.mVisibilityApplier;     // Catch: Throwable -> L14
        if (setVisible == false) goto L7;
        int r5 = 1;
    L18:
        r3.applyImeVisibility(requestToken, statsToken, r5, 0, userId);     // Catch: Throwable -> L12
        Trace.traceEnd(32);
        return;
    L12:
        th = move-exception;
        Throwable r12 = th;
    L16:
        Trace.traceEnd(32);
        throw r12;
    L7:
        r5 = 0;
    L14:
        th = move-exception;
        r12 = th;
        goto L16
    }

    private void resetStylusHandwritingLocked(int requestId) {
        OptionalInt curRequest = this.mHwController.getCurrentRequestId();
        if (curRequest.isPresent() == true) goto L5;
    L6:
        Slog.w(TAG, "IME requested to finish handwriting with a mismatched requestId: " + requestId);
    L7:
        removeVirtualStylusIdForTestSessionLocked();
        scheduleResetStylusHandwriting();
        return;
    L5:
        if (curRequest.getAsInt() == requestId) goto L7;
        goto L6
    }

    private void setInputMethodWithSubtypeIndexLocked(final String id, int subtypeIndex, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (settings.getMethodMap().get(id) != null) goto L5;
    L9:
        long ident = Binder.clearCallingIdentity();
        setInputMethodLocked(id, subtypeIndex, userId);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L5:
        if (settings.getEnabledInputMethodListWithFilter(new InputMethodManagerService$$ExternalSyntheticLambda26(id)).isEmpty() == false) goto L9;
        throw new IllegalStateException("Requested IME is not enabled: " + id);
    }

    private static /* synthetic */ boolean lambda$setInputMethodWithSubtypeIndexLocked$17(String id, InputMethodInfo info) {
        return info.getId().equals(id);
    }

    void onShowHideSoftInputRequested(boolean show, IBinder requestImeToken, int reason, ImeTracker.Token statsToken, int userId) {
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        IBinder requestToken = visibilityStateComputer.getWindowTokenFrom(requestImeToken, userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        WindowManagerInternal.ImeTargetInfo info = this.mWindowManagerInternal.onToggleImeRequested(show, userData.mImeBindingState.mFocusedWindow, requestToken, bindingController.getCurTokenDisplayId());
        this.mSoftInputShowHideHistory.addEntry(new SoftInputShowHideHistory.Entry(userData.mImeBindingState.mFocusedWindowClient, userData.mImeBindingState.mFocusedWindowEditorInfo, info.focusedWindowName, userData.mImeBindingState.mFocusedWindowSoftInputMode, reason, userData.mInFullscreenMode, info.requestWindowName, info.imeControlTargetName, info.imeLayerTargetName, info.imeSurfaceParentName, userId));
        if (statsToken == null) goto L6;
        this.mImeTrackerService.onImmsUpdate(statsToken, info.requestWindowName);
        return;
    }

    private void hideMySoftInputLocked(ImeTracker.Token statsToken, int flags, int reason, UserData userData) {
        int r0 = userData.mUserId;
        userData.mCurClient.mClient.setImeVisibility(false, statsToken);
        setImeVisibilityOnFocusedWindowClient(false, userData, statsToken);
    }

    private void showMySoftInputLocked(ImeTracker.Token statsToken, int flags, int reason, UserData userData) {
        int r0 = userData.mUserId;
        userData.mCurClient.mClient.setImeVisibility(true, statsToken);
        setImeVisibilityOnFocusedWindowClient(true, userData, statsToken);
    }

    DefaultImeVisibilityApplier getVisibilityApplierLocked() {
        return this.mVisibilityApplier;
    }

    void onApplyImeVisibilityFromComputerLocked(IBinder windowToken, ImeTracker.Token statsToken, ImeVisibilityStateComputer.ImeVisibilityResult result, int userId) {
        this.mVisibilityApplier.applyImeVisibility(windowToken, statsToken, result.getState(), result.getReason(), userId);
    }

    void setEnabledSessionLocked(SessionState session, UserData userData) {
        if (userData.mEnabledSession != session) goto L5;
        return;
    L5:
        if (userData.mEnabledSession != null) goto L7;
    L9:
        userData.mEnabledSession = session;
        if (userData.mEnabledSession != null) goto L12;
        return;
    L12:
        if (userData.mEnabledSession.mSession == null) goto L17;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Enabling: " + userData.mEnabledSession, new Object[0]);
        userData.mEnabledSession.mMethod.setSessionEnabled(userData.mEnabledSession.mSession, true);
        return;
    L17:
        return;
    L7:
        if (userData.mEnabledSession.mSession == null) goto L9;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Disabling: " + userData.mEnabledSession, new Object[0]);
        userData.mEnabledSession.mMethod.setSessionEnabled(userData.mEnabledSession.mSession, false);
        goto L9
    }

    void setEnabledSessionForAccessibilityLocked(SparseArray<AccessibilitySessionState> accessibilitySessions, UserData userData) {
        SparseArray<IAccessibilityInputMethodSession> disabledSessions = new SparseArray();
        int i = 0;
    L4:
        if (i >= userData.mEnabledAccessibilitySessions.size()) goto L11;
        if (accessibilitySessions.contains(userData.mEnabledAccessibilitySessions.keyAt(i)) == true) goto L10;
        AccessibilitySessionState sessionState = userData.mEnabledAccessibilitySessions.valueAt(i);
        if (sessionState == null) goto L10;
        disabledSessions.append(userData.mEnabledAccessibilitySessions.keyAt(i), sessionState.mSession);
    L10:
        i = i + 1;
        goto L4
    L11:
        int i2 = disabledSessions.size();
        if (i2 <= 0) goto L14;
        AccessibilityManagerInternal.get().setImeSessionEnabled(disabledSessions, false);
    L14:
        SparseArray<IAccessibilityInputMethodSession> enabledSessions = new SparseArray();
        int i3 = 0;
    L16:
        if (i3 >= accessibilitySessions.size()) goto L23;
        if (userData.mEnabledAccessibilitySessions.contains(accessibilitySessions.keyAt(i3)) == true) goto L22;
        AccessibilitySessionState sessionState2 = accessibilitySessions.valueAt(i3);
        if (sessionState2 == null) goto L22;
        enabledSessions.append(accessibilitySessions.keyAt(i3), sessionState2.mSession);
    L22:
        i3 = i3 + 1;
        goto L16
    L23:
        int i4 = enabledSessions.size();
        if (i4 <= 0) goto L26;
        AccessibilityManagerInternal.get().setImeSessionEnabled(enabledSessions, true);
    L26:
        userData.mEnabledAccessibilitySessions = accessibilitySessions;
    }

    private void showInputMethodPickerLocked(int auxiliarySubtypeMode, int displayId, int userId) {
        switch(auxiliarySubtypeMode) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Unknown subtype picker mode=" + auxiliarySubtypeMode);
        return;
    L6:
        boolean showAuxSubtypes = false;
    L9:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (this.mWindowManagerInternal.isKeyguardLocked() == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        boolean isScreenLocked = r2;
        String lastInputMethodId = settings.getSelectedInputMethod();
        int lastInputMethodSubtypeIndex = settings.getSelectedInputMethodSubtypeIndex(lastInputMethodId);
        List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> imList = InputMethodSubtypeSwitchingController.getSortedInputMethodAndSubtypeList(showAuxSubtypes, isScreenLocked, true, this.mContext, settings);
        if (imList.isEmpty() == false) goto L19;
        Slog.w(TAG, "Show switching menu failed, imList is empty, showAuxSubtypes: " + showAuxSubtypes + " isScreenLocked: " + isScreenLocked + " userId: " + userId);
        return;
    L19:
        this.mMenuController.showInputMethodMenuLocked(showAuxSubtypes, displayId, lastInputMethodId, lastInputMethodSubtypeIndex, imList, userId);
        return;
    L12:
        if (this.mWindowManagerInternal.isKeyguardSecure(userId) == false) goto L14;
        r2 = true;
        goto L15
    L7:
        showAuxSubtypes = true;
        goto L9
    L8:
        UserData userData = getUserData(userId);
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;
        boolean showAuxSubtypes2 = visibilityStateComputer.isInputShown();
        showAuxSubtypes = showAuxSubtypes2;
        goto L9
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        boolean r1 = false;
        switch(msg.what) {
            case 1035: goto L141;
            case 1060: goto L122;
            case 1061: goto L101;
            case 1090: goto L86;
            case 1100: goto L62;
            case 1110: goto L50;
            case 1120: goto L39;
            case 1130: goto L31;
            case 3030: goto L26;
            case 4000: goto L14;
            case 5010: goto L12;
            case 7000: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L12:
        final int userId = msg.arg1;
        final List<InputMethodInfo> imes = (List) msg.obj;
        this.mInputMethodListListeners.forEach(new InputMethodManagerService$$ExternalSyntheticLambda5(imes, userId));
        return true;
    L14:
        InputMethodMenuController r0 = this.mMenuController;
        if (msg.arg1 != 1) goto L17;
        r1 = true;
    L17:
        r0.handleHardKeyboardStatusChange(r1);
        monitor-enter(ImfLock.class);
        sendOnNavButtonFlagsChangedToAllImesLocked();     // Catch: Throwable -> L22
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L22
        return true;
    L22:
        th = move-exception;
        throw th;
    L62:
        HandwritingRequest handwritingRequest = (HandwritingRequest) msg.obj;
        monitor-enter(ImfLock.class);
        UserData userData = HandwritingRequest.m4770$$Nest$fgetuserData(handwritingRequest);     // Catch: Throwable -> L74
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L74
        IInputMethodInvoker curMethod = bindingController.getCurMethod();     // Catch: Throwable -> L74
        if (curMethod == null) goto L81;
        if (userData.mImeBindingState.mFocusedWindow == null) goto L81;
        HandwritingModeController.HandwritingSession session = this.mHwController.startHandwritingSession(HandwritingRequest.m4769$$Nest$fgetrequestId(handwritingRequest), HandwritingRequest.m4768$$Nest$fgetpid(handwritingRequest), bindingController.getCurMethodUid(), userData.mImeBindingState.mFocusedWindow);     // Catch: Throwable -> L74
        if (session != null) goto L77;
        Slog.e(TAG, "Failed to start handwriting session for requestId: " + msg.arg1);     // Catch: Throwable -> L74
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L74
        return true;
    L77:
        if (curMethod.startStylusHandwriting(session.getRequestId(), session.getHandwritingChannel(), session.getRecordedEvents()) == true) goto L79;
        Slog.w(TAG, "Resetting handwriting mode.");     // Catch: Throwable -> L74
        scheduleResetStylusHandwriting();     // Catch: Throwable -> L74
    L79:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L74
        return true;
    L81:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L74
        return true;
    L74:
        th = move-exception;
        throw th;
    L101:
        IBinder windowToken = (IBinder) msg.obj;
        monitor-enter(ImfLock.class);
        UserData userData2 = getUserData(resolveImeUserIdFromWindowLocked(windowToken));     // Catch: Throwable -> L112
        if (windowToken != userData2.mImeBindingState.mFocusedWindow) goto L117;
        if (userData2.mEnabledSession == null) goto L117;
        if (userData2.mEnabledSession.mSession == null) goto L117;
        userData2.mEnabledSession.mSession.removeImeSurface();     // Catch: Throwable -> L112 RemoteException -> L114
    L117:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L112
        return true;
    L112:
        th = move-exception;
        throw th;
    L141:
        int r2 = msg.arg1;
        int originatingDisplayId = msg.arg2;
        monitor-enter(ImfLock.class);
        setImeVisibilityOnFocusedWindowClient(false, getUserData(resolveImeUserIdFromDisplayIdLocked(originatingDisplayId)), null);     // Catch: Throwable -> L146
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L146
        return true;
    L146:
        th = move-exception;
        throw th;
    L6:
        if (this.mAudioManagerInternal != null) goto L9;
        this.mAudioManagerInternal = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);
    L9:
        if (this.mAudioManagerInternal == null) goto L11;
        this.mAudioManagerInternal.setInputMethodServiceUid(msg.arg1);
    L11:
        return true;
    L26:
        if (msg.arg1 == 0) goto L28;
        r1 = true;
    L28:
        handleSetInteractive(r1);
        return true;
    L31:
        monitor-enter(ImfLock.class);
        int userId2 = msg.arg1;     // Catch: Throwable -> L35
        String delegate = (String) ((Pair) msg.obj).first;     // Catch: Throwable -> L35
        String delegator = (String) ((Pair) msg.obj).second;     // Catch: Throwable -> L35
        this.mHwController.prepareStylusHandwritingDelegation(userId2, delegate, delegator, false);     // Catch: Throwable -> L35
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L35
        return true;
    L35:
        th = move-exception;
        throw th;
    L39:
        monitor-enter(ImfLock.class);
        IInputMethodInvoker curMethod2 = getCurMethodLocked();     // Catch: Throwable -> L43
        if (curMethod2 == null) goto L45;
        curMethod2.removeStylusHandwritingWindow();     // Catch: Throwable -> L43
    L45:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L43
        return true;
    L43:
        th = move-exception;
        throw th;
    L50:
        monitor-enter(ImfLock.class);
        IInputMethodInvoker curMethod3 = getCurMethodLocked();     // Catch: Throwable -> L56
        if (curMethod3 != null) goto L54;
    L58:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L56
        return true;
    L54:
        if (this.mHwController.getCurrentRequestId().isPresent() == false) goto L58;
        curMethod3.finishStylusHandwriting();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    L86:
        monitor-enter(ImfLock.class);
        InputMethodBindingController bindingController2 = getInputMethodBindingController(this.mCurrentImeUserId);     // Catch: Throwable -> L94
        if (bindingController2.supportsStylusHandwriting() == true) goto L90;
    L96:
        this.mHwController.reset();     // Catch: Throwable -> L94
    L97:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L94
        return true;
    L90:
        if (bindingController2.getCurMethod() == null) goto L96;
        if (hasSupportedStylusLocked() == false) goto L96;
        Slog.d(TAG, "Initializing Handwriting Spy");     // Catch: Throwable -> L94
        this.mHwController.initializeHandwritingSpy(bindingController2.getCurTokenDisplayId());     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        throw th;
    L122:
        monitor-enter(ImfLock.class);
        int userId3 = this.mCurrentImeUserId;     // Catch: Throwable -> L132
        UserData userData3 = getUserData(userId3);     // Catch: Throwable -> L132
        if (userData3.mEnabledSession == null) goto L137;
        if (userData3.mEnabledSession.mSession == null) goto L137;
        if (isShowRequestedForCurrentWindow(userId3) == true) goto L137;
        userData3.mEnabledSession.mSession.removeImeSurface();     // Catch: Throwable -> L132 RemoteException -> L134
    L137:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L132
        return true;
    L132:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$handleMessage$18(List imes, int userId, InputMethodManagerInternal.InputMethodListListener listener) {
        listener.onInputMethodListUpdated(imes, userId);
    }

    private void onStylusHandwritingReadyLocked(int requestId, int pid, UserData userData) {
        this.mHandler.obtainMessage(MSG_START_HANDWRITING, new HandwritingRequest(requestId, pid, userData, null)).sendToTarget();
    }

    private void handleSetInteractive(boolean interactive) {
        monitor-enter(ImfLock.class);
        int userId = this.mCurrentImeUserId;     // Catch: Throwable -> L7
        UserData userData = getUserData(userId);     // Catch: Throwable -> L7
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L7
        this.mIsInteractive = interactive;     // Catch: Throwable -> L7
        if (interactive == false) goto L9;
        int r2 = bindingController.getImeWindowVis();     // Catch: Throwable -> L7
    L10:
        updateSystemUiLocked(r2, bindingController.getBackDisposition(), userId);     // Catch: Throwable -> L7
        if (userData.mCurClient != null) goto L15;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L15:
        if (this.mImePlatformCompatUtils.shouldUseSetInteractiveProtocol(bindingController.getCurMethodUid()) == false) goto L20;
        ImeVisibilityStateComputer visibilityStateComputer = userData.mVisibilityStateComputer;     // Catch: Throwable -> L7
        ImeVisibilityStateComputer.ImeVisibilityResult imeVisRes = visibilityStateComputer.onInteractiveChanged(userData.mImeBindingState.mFocusedWindow, interactive);     // Catch: Throwable -> L7
        if (imeVisRes == null) goto L19;
        this.mVisibilityApplier.applyImeVisibility(userData.mImeBindingState.mFocusedWindow, null, imeVisRes.getState(), imeVisRes.getReason(), userId);     // Catch: Throwable -> L7
    L19:
        userData.mCurClient.mClient.setInteractive(this.mIsInteractive, userData.mInFullscreenMode);     // Catch: Throwable -> L7
    L21:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L20:
        userData.mCurClient.mClient.setActive(this.mIsInteractive, userData.mInFullscreenMode);     // Catch: Throwable -> L7
        goto L21
    L9:
        r2 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean chooseNewDefaultIMELocked(int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodInfo imi = InputMethodInfoUtils.getMostApplicableDefaultIME(settings.getEnabledInputMethodList());
        if (imi == null) goto L6;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "New default IME was selected: %s", new Object[]{imi.getId()});
        resetSelectedInputMethodAndSubtypeLocked(imi.getId(), userId);
        return true;
    L6:
        return false;
    }

    static RawInputMethodMap queryRawInputMethodServiceMap(Context context, int userId) {
        if (context.getUserId() != userId) goto L5;
        Context userAwareContext = context;
    L6:
        List<ResolveInfo> services = userAwareContext.getPackageManager().queryIntentServices(new Intent("android.view.InputMethod"), PackageManager.ResolveInfoFlags.of(819328));
        List<String> enabledInputMethodList = InputMethodUtils.getEnabledInputMethodIdsForFiltering(context, userId);
        return filterInputMethodServices(enabledInputMethodList, userAwareContext, services);
    L5:
        userAwareContext = context.createContextAsUser(UserHandle.of(userId), 0);
        goto L6
    }

    static RawInputMethodMap filterInputMethodServices(List<String> enabledInputMethodList, Context userAwareContext, List<ResolveInfo> services) {
        ArrayMap<String, Integer> imiPackageCount = new ArrayMap();
        ArrayMap<String, InputMethodInfo> methodMap = new ArrayMap(services.size());
        int i = 0;
    L4:
        if (i >= services.size()) goto L27;
        ResolveInfo ri = services.get(i);
        ServiceInfo si = ri.serviceInfo;
        String imeId = InputMethodInfo.computeId(ri);
        if ("android.permission.BIND_INPUT_METHOD".equals(si.permission) == true) goto L8;
        Slog.w(TAG, "Skipping input method " + imeId + ": it does not require the permission android.permission.BIND_INPUT_METHOD");
    L25:
        i = i + 1;
        goto L4
    L8:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Checking %s", new Object[]{imeId});
        InputMethodInfo imi = new InputMethodInfo(userAwareContext, ri, Collections.emptyList());     // Catch: Exception -> L20
        if (imi.isVrOnly() == true) goto L25;
        String packageName = si.packageName;     // Catch: Exception -> L20
        if (si.applicationInfo.isSystemApp() == false) goto L15;
    L22:
        imiPackageCount.put(packageName, Integer.valueOf(imiPackageCount.getOrDefault(packageName, 0).intValue() + 1));     // Catch: Exception -> L20
        methodMap.put(imi.getId(), imi);     // Catch: Exception -> L20
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Found an input method %s", new Object[]{imi});     // Catch: Exception -> L20
        goto L25
    L15:
        if (enabledInputMethodList.contains(imi.getId()) == true) goto L22;
        if (imiPackageCount.getOrDefault(packageName, 0).intValue() < 20) goto L22;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Found an input method, but ignored due threshold: %s", new Object[]{imi});     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Slog.wtf(TAG, "Unable to load input method " + imeId, e);
        goto L25
    L27:
        return RawInputMethodMap.of(methodMap);
    }

    void postInputMethodSettingUpdatedLocked(boolean resetDefaultEnabledIme, int userId) {
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "--- re-buildInputMethodList reset = %s \n ------ caller=%s", new Object[]{Boolean.valueOf(resetDefaultEnabledIme), Debug.getCallers(10)});
        if (this.mSystemReady == true) goto L6;
        Slog.e(TAG, "buildInputMethodListLocked is not allowed until system is ready");
        return;
    L6:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        getExt().buildInputMethodListLocked(settings.getMethodMap());
        boolean reenableMinimumNonAuxSystemImes = false;
        if (resetDefaultEnabledIme == true) goto L21;
        boolean enabledImeFound = false;
        boolean enabledNonAuxImeFound = false;
        List<InputMethodInfo> enabledImes = settings.getEnabledInputMethodList();
        int numImes = enabledImes.size();
        int i = 0;
    L9:
        if (i >= numImes) goto L16;
        InputMethodInfo imi = enabledImes.get(i);
        if (settings.getMethodMap().containsKey(imi.getId()) == false) goto L15;
        enabledImeFound = true;
        if (imi.isAuxiliaryIme() == true) goto L15;
        enabledNonAuxImeFound = true;
    L15:
        i = i + 1;
    L16:
        if (enabledImeFound == true) goto L18;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "All the enabled IMEs are gone. Reset default enabled IMEs.", new Object[0]);
        resetDefaultEnabledIme = true;
        resetSelectedInputMethodAndSubtypeLocked("", userId);
        goto L21
    L18:
        if (enabledNonAuxImeFound == true) goto L21;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "All the enabled non-Aux IMEs are gone. Do partial reset.", new Object[0]);
        reenableMinimumNonAuxSystemImes = true;
    L21:
        if (resetDefaultEnabledIme == true) goto L23;
        if (reenableMinimumNonAuxSystemImes == true) goto L23;
    L26:
        String defaultImiId = settings.getSelectedInputMethod();
        if (TextUtils.isEmpty(defaultImiId) == false) goto L29;
    L34:
        updateDefaultVoiceImeIfNeededLocked(userId);
        UserData userData = getUserData(userId);
        userData.mSwitchingController.resetCircularListLocked(this.mContext, settings);
        userData.mHardwareKeyboardShortcutController.update(settings);
        sendOnNavButtonFlagsChangedLocked(userData);
        List<InputMethodInfo> inputMethodList = settings.getMethodList();
        this.mHandler.obtainMessage(MSG_DISPATCH_ON_INPUT_METHOD_LIST_UPDATED, userId, 0, inputMethodList).sendToTarget();
        return;
    L29:
        if (settings.getMethodMap().containsKey(defaultImiId) == true) goto L33;
        Slog.w(TAG, "Default IME is uninstalled. Choose new default IME.");
        if (chooseNewDefaultIMELocked(userId) == false) goto L34;
        updateInputMethodsFromSettingsLocked(true, userId);
        goto L34
    L33:
        setInputMethodEnabledLocked(defaultImiId, true, userId);
    L23:
        ArrayList<InputMethodInfo> defaultEnabledIme = InputMethodInfoUtils.getDefaultEnabledImes(this.mContext, settings.getMethodList(), reenableMinimumNonAuxSystemImes);
        int numImes2 = defaultEnabledIme.size();
        int i2 = 0;
    L24:
        if (i2 >= numImes2) goto L26;
        InputMethodInfo imi2 = defaultEnabledIme.get(i2);
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "--- enable ime = %s", new Object[]{imi2});
        setInputMethodEnabledLocked(imi2.getId(), true, userId);
        i2 = i2 + 1;
        goto L24
    }

    void sendOnNavButtonFlagsChangedToAllImesLocked() {
        int[] r0 = this.mUserManagerInternal.getUserIds();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int userId = r0[r2];
        sendOnNavButtonFlagsChangedLocked(getUserData(userId));
        r2 = r2 + 1;
        goto L3
    }

    void sendOnNavButtonFlagsChangedLocked(UserData userData) {
        InputMethodBindingController bindingController = userData.mBindingController;
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod != null) goto L5;
        return;
    L5:
        curMethod.onNavButtonFlagsChanged(getInputMethodNavButtonFlagsLocked(userData));
    }

    private void onUpdateResourceOverlay(int userId) {
        int profileParentId = this.mUserManagerInternal.getProfileParentId(userId);
        boolean value = InputMethodDrawsNavBarResourceMonitor.evaluate(this.mContext, profileParentId);
        int r3 = 0;
        int[] profileUserIds = this.mUserManagerInternal.getProfileIds(profileParentId, false);
        ArrayList<UserData> updatedUsers = new ArrayList();
        int r5 = profileUserIds.length;
    L3:
        if (r3 >= r5) goto L6;
        int profileUserId = profileUserIds[r3];
        UserData userData = getUserData(profileUserId);
        userData.mImeDrawsNavBar.set(value);
        updatedUsers.add(userData);
        r3 = r3 + 1;
        goto L3
    L6:
        monitor-enter(ImfLock.class);
        updatedUsers.forEach(new InputMethodManagerService$$ExternalSyntheticLambda25(this));     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateDefaultVoiceImeIfNeededLocked(int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        String systemSpeechRecognizer = this.mContext.getString(R.string.config_systemSpeechRecognizer);
        String currentDefaultVoiceImeId = settings.getDefaultVoiceInputMethod();
        InputMethodInfo newSystemVoiceIme = InputMethodInfoUtils.chooseSystemVoiceIme(settings.getMethodMap(), systemSpeechRecognizer, currentDefaultVoiceImeId);
        if (newSystemVoiceIme != null) goto L9;
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Found no valid default Voice IME. If the user is still locked, this may be expected.", new Object[0]);
        if (TextUtils.isEmpty(currentDefaultVoiceImeId) == true) goto L13;
        settings.putDefaultVoiceInputMethod("");
        return;
    L13:
        return;
    L9:
        if (TextUtils.equals(currentDefaultVoiceImeId, newSystemVoiceIme.getId()) == false) goto L11;
        return;
    L11:
        ProtoLog.v(ImeProtoLogGroup.IMMS_DEBUG, "Enabling the default Voice IME: %s userId: %s", new Object[]{newSystemVoiceIme, Integer.valueOf(userId)});
        setInputMethodEnabledLocked(newSystemVoiceIme.getId(), true, userId);
        settings.putDefaultVoiceInputMethod(newSystemVoiceIme.getId());
    }

    private boolean setInputMethodEnabledLocked(String id, boolean enabled, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (enabled == false) goto L9;
        String enabledImeIdsStr = settings.getEnabledInputMethodsStr();
        String newEnabledImeIdsStr = InputMethodUtils.concatEnabledImeIds(enabledImeIdsStr, new String[]{id});
        if (TextUtils.equals(enabledImeIdsStr, newEnabledImeIdsStr) == false) goto L7;
        return true;
    L7:
        settings.putEnabledInputMethodsStr(newEnabledImeIdsStr);
        return false;
    L9:
        List<Pair<String, ArrayList<String>>> enabledInputMethodsList = settings.getEnabledInputMethodsAndSubtypeList();
        StringBuilder builder = new StringBuilder();
        if (settings.buildAndPutEnabledInputMethodsStrRemovingId(builder, enabledInputMethodsList, id) == false) goto L27;
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        if (bindingController.getDeviceIdToShowIme() != 0) goto L20;
        String selId = settings.getSelectedInputMethod();
        if (id.equals(selId) == true) goto L16;
    L26:
        return true;
    L16:
        if (chooseNewDefaultIMELocked(userId) == true) goto L26;
        Slog.i(TAG, "Can't find new IME, unsetting the current input method.");
        resetSelectedInputMethodAndSubtypeLocked("", userId);
        goto L26
    L20:
        if (id.equals(settings.getSelectedDefaultDeviceInputMethod()) == false) goto L26;
        InputMethodInfo newDefaultIme = InputMethodInfoUtils.getMostApplicableDefaultIME(settings.getEnabledInputMethodList());
        if (newDefaultIme != null) goto L24;
        String r6 = null;
    L25:
        settings.putSelectedDefaultDeviceInputMethod(r6);
        goto L26
    L24:
        r6 = newDefaultIme.getId();
        goto L25
    L27:
        return false;
    }

    private void setSelectedInputMethodAndSubtypeLocked(InputMethodInfo imi, int subtypeIndex, boolean setSubtypeOnly, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        settings.saveCurrentInputMethodAndSubtypeToHistory(bindingController.getSelectedMethodId(), bindingController.getCurrentSubtype());
        if (imi == null) goto L10;
        if (subtypeIndex < 0) goto L10;
        if (subtypeIndex >= imi.getSubtypeCount()) goto L9;
        InputMethodSubtype subtype = imi.getSubtypeAt(subtypeIndex);
        int newSubtypeHashcode = subtype.hashCode();
    L11:
        settings.putSelectedSubtype(newSubtypeHashcode);
        bindingController.setCurrentSubtype(subtype);
        notifyInputMethodSubtypeChangedLocked(settings.getUserId(), imi, subtype);
        if (setSubtypeOnly == true) goto L19;
        if (imi == null) goto L15;
        String r4 = imi.getId();
    L16:
        settings.putSelectedInputMethod(r4);
        return;
    L15:
        r4 = "";
        goto L16
    L19:
        return;
    L9:
        newSubtypeHashcode = -1;
        subtype = bindingController.getCurrentInputMethodSubtype();
    L10:
        newSubtypeHashcode = -1;
        subtype = null;
        goto L11
    }

    private void resetSelectedInputMethodAndSubtypeLocked(String newDefaultIme, int userId) {
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);
        bindingController.setDisplayIdToShowIme(-1);
        bindingController.setDeviceIdToShowIme(0);
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        settings.putSelectedDefaultDeviceInputMethod(null);
        InputMethodInfo imi = settings.getMethodMap().get(newDefaultIme);
        int lastSubtypeIndex = -1;
        if (imi != null) goto L5;
    L12:
        setSelectedInputMethodAndSubtypeLocked(imi, lastSubtypeIndex, false, userId);
        return;
    L5:
        if (TextUtils.isEmpty(newDefaultIme) == true) goto L12;
        String subtypeHashCode = settings.getLastSubtypeForInputMethod(newDefaultIme);
        if (subtypeHashCode == null) goto L12;
        lastSubtypeIndex = SubtypeUtils.getSubtypeIndexFromHashCode(imi, Integer.parseInt(subtypeHashCode));     // Catch: NumberFormatException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "HashCode for subtype looks broken: " + subtypeHashCode, e);
        goto L12
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtype getCurrentInputMethodSubtype(int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
    L6:
        monitor-enter(ImfLock.class);
        InputMethodBindingController bindingController = getInputMethodBindingController(userId);     // Catch: Throwable -> L10
        InputMethodSubtype r2 = bindingController.getCurrentInputMethodSubtype();     // Catch: Throwable -> L10
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean switchToInputMethodLocked(final String imeId, int subtypeIndex, int userId) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        ArrayList<InputMethodInfo> enabledImes = settings.getEnabledInputMethodList();
        if (CollectionUtils.any(enabledImes, new InputMethodManagerService$$ExternalSyntheticLambda27(imeId)) == true) goto L6;
        return false;
    L6:
        setInputMethodLocked(imeId, subtypeIndex, userId);
        return true;
    }

    private static /* synthetic */ boolean lambda$switchToInputMethodLocked$19(String imeId, InputMethodInfo imi) {
        return imi.getId().equals(imeId);
    }

    private boolean canCallerAccessInputMethod(String targetPkgName, int callingUid, int userId, InputMethodSettings settings) {
        String methodId = settings.getSelectedInputMethod();
        if (methodId == null) goto L5;
        ComponentName selectedInputMethod = InputMethodUtils.convertIdToComponentName(methodId);
    L7:
        if (selectedInputMethod != null) goto L9;
    L11:
        boolean canAccess = true ^ this.mPackageManagerInternal.filterAppAccess(targetPkgName, callingUid, userId);
        return canAccess;
    L9:
        if (selectedInputMethod.getPackageName().equals(targetPkgName) == false) goto L11;
        return true;
    L5:
        selectedInputMethod = null;
        goto L7
    }

    private void switchKeyboardLayoutLocked(int direction, UserData userData) {
        int userId = userData.mUserId;
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        InputMethodInfo currentImi = settings.getMethodMap().get(bindingController.getSelectedMethodId());
        if (currentImi != null) goto L5;
        return;
    L5:
        InputMethodSubtype currentSubtype = bindingController.getCurrentSubtype();
        InputMethodSubtypeHandle currentSubtypeHandle = InputMethodSubtypeHandle.of(currentImi, currentSubtype);
        HardwareKeyboardShortcutController r6 = userData.mHardwareKeyboardShortcutController;
        if (direction <= 0) goto L8;
        boolean r7 = true;
    L9:
        InputMethodSubtypeHandle nextSubtypeHandle = r6.onSubtypeSwitch(currentSubtypeHandle, r7);
        if (nextSubtypeHandle != null) goto L12;
        return;
    L12:
        InputMethodInfo nextImi = settings.getMethodMap().get(nextSubtypeHandle.getImeId());
        if (nextImi != null) goto L15;
        return;
    L15:
        int subtypeCount = nextImi.getSubtypeCount();
        if (subtypeCount == 0) goto L18;
        int i = 0;
    L22:
        if (i >= subtypeCount) goto L29;
        if (nextSubtypeHandle.equals(InputMethodSubtypeHandle.of(nextImi, nextImi.getSubtypeAt(i))) == true) goto L25;
        i = i + 1;
        goto L22
    L25:
        setInputMethodLocked(nextImi.getId(), i, userId);
        return;
    L29:
        return;
    L18:
        if (nextSubtypeHandle.equals(InputMethodSubtypeHandle.of(nextImi, null)) == false) goto L32;
        setInputMethodLocked(nextImi.getId(), -1, userId);
        return;
    L32:
        return;
    L8:
        r7 = false;
        goto L9
    }

    private void publishLocalService() {
        LocalServices.addService(InputMethodManagerInternal.class, this.mInputMethodManagerInternal);
    }

    private IInputContentUriToken createInputContentUriTokenLocked(Uri contentUri, String packageName, UserData userData) {
        packageName.getClass();
        contentUri.getClass();
        String contentUriScheme = contentUri.getScheme();
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(contentUriScheme) == false) goto L18;
        int uid = Binder.getCallingUid();
        InputMethodBindingController bindingController = userData.mBindingController;
        if (bindingController.getSelectedMethodId() != null) goto L8;
        return null;
    L8:
        if (userData.mCurEditorInfo == null) goto L10;
        String r2 = userData.mCurEditorInfo.packageName;
    L11:
        String curPackageName = r2;
        if (TextUtils.equals(curPackageName, packageName) == true) goto L15;
        Slog.e(TAG, "Ignoring createInputContentUriTokenLocked mCurEditorInfo.packageName=" + curPackageName + " packageName=" + packageName);
        return null;
    L15:
        int appUserId = UserHandle.getUserId(userData.mCurClient.mUid);
        int contentUriOwnerUserId = ContentProvider.getUserIdFromUri(contentUri, userData.mUserId);
        Uri contentUriWithoutUserId = ContentProvider.getUriWithoutUserId(contentUri);
        return new InputContentUriTokenHandler(contentUriWithoutUserId, uid, packageName, contentUriOwnerUserId, appUserId);
    L10:
        r2 = null;
        goto L11
    L18:
        throw new InvalidParameterException("contentUri must have content scheme");
    }

    private void reportFullscreenModeLocked(boolean fullscreen, UserData userData) {
        if (userData.mCurClient == null) goto L6;
        userData.mInFullscreenMode = fullscreen;
        userData.mCurClient.mClient.reportFullscreenMode(fullscreen);
        return;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        PriorityDump.dump(this.mPriorityDumper, fd, pw, args);
    }

    private void dumpAsStringNoCheck(final FileDescriptor fd, final PrintWriter pw, final String[] args, final boolean isCritical) {
        int argUserId = parseUserIdFromDumpArgs(args);
        Printer p = new PrintWriterPrinter(pw);
        p.println("Input Method Manager Service state:");
        p.println("  mSystemReady=" + this.mSystemReady);
        p.println("  mInteractive=" + this.mIsInteractive);
        p.println("  mConcurrentMultiUserModeEnabled=" + this.mConcurrentMultiUserModeEnabled);
        monitor-enter(ImfLock.class);
        int currentImeUserId = this.mCurrentImeUserId;     // Catch: Throwable -> L7
        p.println("  mCurrentImeUserId=" + currentImeUserId);     // Catch: Throwable -> L7
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L7
        r0.append("  mStylusIds=");     // Catch: Throwable -> L7
        if (this.mStylusIds == null) goto L9;
        String r4 = Arrays.toString(this.mStylusIds.toArray());     // Catch: Throwable -> L7
    L10:
        r0.append(r4);     // Catch: Throwable -> L7
        p.println(r0.toString());     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        p.println("  mMenuController:");
        this.mMenuController.dump(p, "    ");
        dumpClientController(p);
        dumpUserRepository(p);
        monitor-enter(ImfLock.class);
        p.println("  mStartInputHistory:");     // Catch: Throwable -> L25
        this.mStartInputHistory.dump(pw, "    ");     // Catch: Throwable -> L25
        p.println("  mSoftInputShowHideHistory:");     // Catch: Throwable -> L25
        this.mSoftInputShowHideHistory.dump(pw, "    ");     // Catch: Throwable -> L25
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L25
        p.println("  mImeTrackerService#History:");
        this.mImeTrackerService.dump(pw, "    ");
        if (this.mConcurrentMultiUserModeEnabled == false) goto L20;
        if (argUserId != (-10000)) goto L20;
        this.mUserDataRepository.forAllUserData(new InputMethodManagerService$$ExternalSyntheticLambda21(this, fd, pw, args, isCritical));
        return;
    L20:
        if (argUserId == (-10000)) goto L22;
        int userId = argUserId;
    L23:
        UserData userData = getUserData(userId);
        dumpAsStringNoCheckForUser(userData, fd, pw, args, isCritical);
        return;
    L22:
        userId = currentImeUserId;
    L25:
        th = move-exception;
        throw th;
    L9:
        r4 = "";
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$dumpAsStringNoCheck$20(FileDescriptor fd, PrintWriter pw, String[] args, boolean isCritical, UserData u) {
        dumpAsStringNoCheckForUser(u, fd, pw, args, isCritical);
    }

    private static int parseUserIdFromDumpArgs(String[] args) {
        int userIdx = Arrays.binarySearch(args, "--user");
        if (userIdx != (-1)) goto L5;
        return ProcessList.INVALID_ADJ;
    L5:
        if (userIdx != (args.length - 1)) goto L8;
        return ProcessList.INVALID_ADJ;
    L8:
        return Integer.parseInt(args[userIdx + 1]);
    }

    private void dumpAsStringNoCheckForUser(UserData userData, FileDescriptor fd, PrintWriter pw, String[] args, boolean isCritical) {
        Printer p = new PrintWriterPrinter(pw);
        p.println("  UserId=" + userData.mUserId);
        monitor-enter(ImfLock.class);
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L47
        ClientState client = userData.mCurClient;     // Catch: Throwable -> L47
        IInputMethodInvoker method = bindingController.getCurMethod();     // Catch: Throwable -> L47
        p.println("    mBindingController:");     // Catch: Throwable -> L47
        bindingController.dump(pw, "      ");     // Catch: Throwable -> L47
        p.println("    mCurClient=" + client);     // Catch: Throwable -> L47
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L47
        r9.append("    mFocusedWindowPerceptible=");     // Catch: Throwable -> L47
        r9.append(this.mFocusedWindowPerceptible);     // Catch: Throwable -> L9
        p.println(r9.toString());     // Catch: Throwable -> L9
        p.println("    mImeBindingState:");     // Catch: Throwable -> L9
        userData.mImeBindingState.dump(p, "      ");     // Catch: Throwable -> L9
        p.println("    mBoundToMethod=" + userData.mBoundToMethod);     // Catch: Throwable -> L9
        p.println("    mEnabledSession=" + userData.mEnabledSession);     // Catch: Throwable -> L9
        p.println("    mVisibilityStateComputer:");     // Catch: Throwable -> L9
        userData.mVisibilityStateComputer.dump(pw, "      ");     // Catch: Throwable -> L9
        p.println("    mInFullscreenMode=" + userData.mInFullscreenMode);     // Catch: Throwable -> L9
        InputMethodSettings settings = InputMethodSettingsRepository.get(userData.mUserId);     // Catch: Throwable -> L9
        List<InputMethodInfo> methodList = settings.getMethodList();     // Catch: Throwable -> L9
        int numImes = methodList.size();     // Catch: Throwable -> L9
        p.println("    Input Methods:");     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= numImes) goto L12;
        InputMethodInfo info = methodList.get(i);     // Catch: Throwable -> L9
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L9
        r15.append("      InputMethod #");     // Catch: Throwable -> L9
        r15.append(i);     // Catch: Throwable -> L9
        r15.append(":");     // Catch: Throwable -> L9
        p.println(r15.toString());     // Catch: Throwable -> L9
        info.dump(p, "        ");     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        bindingController = bindingController;
        goto L7
    L12:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        if (isCritical == false) goto L15;
        return;
    L15:
        p.println("");
        if (client == null) goto L22;
        pw.flush();
        TransferPipe.dumpAsync(client.mClient.asBinder(), fd, args);     // Catch: Throwable -> L20
    L24:
        monitor-enter(ImfLock.class);
        ClientState focusedWindowClient = userData.mImeBindingState.mFocusedWindowClient;     // Catch: Throwable -> L31
        if (focusedWindowClient == null) goto L35;
        if (client == focusedWindowClient) goto L35;
        p.println("");     // Catch: Throwable -> L31
        p.println("Warning: Current input method client doesn't match the last focused window.");     // Catch: Throwable -> L31
        p.println("Dumping input method client in the last focused window just in case.");     // Catch: Throwable -> L31
        p.println("");     // Catch: Throwable -> L31
        pw.flush();     // Catch: Throwable -> L31
        TransferPipe.dumpAsync(focusedWindowClient.mClient.asBinder(), fd, args);     // Catch: Throwable -> L31 Throwable -> L33
    L33:
        e = move-exception;
        p.println("Failed to dump input method client in focused window: " + e);     // Catch: Throwable -> L31
    L35:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L31
        p.println("");
        if (method == null) goto L43;
        pw.flush();
        TransferPipe.dumpAsync(method.asBinder(), fd, args);     // Catch: Throwable -> L41
        return;
    L41:
        e = move-exception;
        p.println("Failed to dump input method service: " + e);
        return;
    L43:
        p.println("No input method service.");
        return;
    L31:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        p.println("Failed to dump input method client: " + e);
        goto L24
    L22:
        p.println("No input method client.");
    L9:
        th = th;
    L49:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        throw th;
    L47:
        th = th;
        goto L49
    }

    private void dumpClientController(final Printer p) {
        p.println("  mClientController:");
        Consumer<ClientState> clientControllerDump = new InputMethodManagerService$$ExternalSyntheticLambda9(p);
        monitor-enter(ImfLock.class);
        this.mClientController.forAllClients(clientControllerDump);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dumpClientController$21(Printer p, ClientState c) {
        p.println("    " + c + ":");
        StringBuilder r0 = new StringBuilder();
        r0.append("      client=");
        r0.append(c.mClient);
        p.println(r0.toString());
        p.println("      fallbackInputConnection=" + c.mFallbackInputConnection);
        p.println("      sessionRequested=" + c.mSessionRequested);
        p.println("      sessionRequestedForAccessibility=" + c.mSessionRequestedForAccessibility);
        p.println("      curSession=" + c.mCurSession);
        p.println("      selfReportedDisplayId=" + c.mSelfReportedDisplayId);
        p.println("      uid=" + c.mUid);
        p.println("      pid=" + c.mPid);
    }

    private void dumpUserRepository(final Printer p) {
        p.println("  mUserDataRepository:");
        Consumer<UserData> userDataDump = new InputMethodManagerService$$ExternalSyntheticLambda1(p);
        monitor-enter(ImfLock.class);
        this.mUserDataRepository.forAllUserData(userDataDump);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dumpUserRepository$22(Printer p, UserData u) {
        p.println("    userId=" + u.mUserId);
        p.println("      unlocked=" + u.mIsUnlockingOrUnlocked.get());
        p.println("      hasMainConnection=" + u.mBindingController.hasMainConnection());
        p.println("      isVisibleBound=" + u.mBindingController.isVisibleBound());
        p.println("      boundToMethod=" + u.mBoundToMethod);
        p.println("      curClient=" + u.mCurClient);
        if (u.mCurEditorInfo == null) goto L5;
        p.println("      curEditorInfo:");
        u.mCurEditorInfo.dump(p, "        ", false);
    L6:
        p.println("      imeBindingState:");
        u.mImeBindingState.dump(p, "        ");
        p.println("      enabledSession=" + u.mEnabledSession);
        p.println("      inFullscreenMode=" + u.mInFullscreenMode);
        p.println("      imeDrawsNavBar=" + u.mImeDrawsNavBar.get());
        p.println("      switchingController:");
        u.mSwitchingController.dump(p, "        ");
        p.println("      mLastEnabledInputMethodsStr=" + u.mLastEnabledInputMethodsStr);
        return;
    L5:
        p.println("      curEditorInfo: null");
        goto L6
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver, Binder self) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L14:
        new ShellCommandImpl(this).exec(self, in, out, err, args, callback, resultReceiver);
        return;
    L5:
        if (callingUid == 2000) goto L14;
        if (resultReceiver == null) goto L8;
        resultReceiver.send(-1, null);
    L8:
        String errorMsg = "InputMethodManagerService does not support shell commands from non-shell users. callingUid=" + callingUid + " args=" + Arrays.toString(args);
        if (Process.isCoreUid(callingUid) == false) goto L13;
        Slog.e(TAG, errorMsg);
        return;
    L13:
        throw new SecurityException(errorMsg);
    }

    private int handleShellCommandListInputMethods(ShellCommand shellCommand) {
        int userIdToBeResolved = -2;
        boolean brief = false;
        boolean brief2 = false;
    L3:
        String nextOption = shellCommand.getNextOption();
        byte r5 = 1;
        if (nextOption == null) goto L6;
        switch(nextOption.hashCode()) {
            case 1492: goto L55;
            case 1510: goto L52;
            case 1512: goto L49;
            case 1333469547: goto L46;
            default: goto L57;
        };
    L57:
        r5 = -1;
    L58:
        switch(r5) {
            case 0: goto L62;
            case 1: goto L61;
            case 2: goto L60;
            case 3: goto L60;
            default: goto L3;
        };
    L60:
        userIdToBeResolved = UserHandle.parseUserArg(shellCommand.getNextArgRequired());
        goto L3
    L61:
        brief = true;
        goto L3
    L62:
        brief2 = true;
        goto L3
    L46:
        if (nextOption.equals("--user") == false) goto L57;
        r5 = 3;
        goto L58
    L49:
        if (nextOption.equals("-u") == false) goto L57;
        r5 = 2;
        goto L58
    L52:
        if (nextOption.equals("-s") == false) goto L57;
    L55:
        if (nextOption.equals("-a") == false) goto L57;
        r5 = 0;
        goto L58
    L6:
        monitor-enter(ImfLock.class);
        int[] userIds = InputMethodUtils.resolveUserId(userIdToBeResolved, this.mCurrentImeUserId, shellCommand.getErrPrintWriter());     // Catch: Throwable -> L39
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L39
        final PrintWriter pr = shellCommand.getOutPrintWriter();
        int r0 = userIds.length;     // Catch: Throwable -> L15
        int r9 = 0;
    L11:
        if (r9 >= r0) goto L30;
        int userId = userIds[r9];     // Catch: Throwable -> L15
        if (brief2 == false) goto L17;
        List<InputMethodInfo> methods = getInputMethodListInternal(userId, 0, 2000);     // Catch: Throwable -> L15
    L19:
        if (userIds.length <= 1) goto L21;
        pr.print("User #");     // Catch: Throwable -> L15
        pr.print(userId);     // Catch: Throwable -> L15
        pr.println(":");     // Catch: Throwable -> L15
    L21:
        Iterator<InputMethodInfo> r12 = methods.iterator();     // Catch: Throwable -> L15
    L23:
        if (r12.hasNext() == false) goto L29;
        InputMethodInfo info = r12.next();     // Catch: Throwable -> L15
        if (brief == true) goto L26;
        pr.print(info.getId());     // Catch: Throwable -> L15
        pr.println(":");     // Catch: Throwable -> L15
        pr.getClass();     // Catch: Throwable -> L15
        info.dump(new InputMethodManagerService$$ExternalSyntheticLambda16(pr), "  ");     // Catch: Throwable -> L15
        goto L23
    L26:
        pr.println(info.getId());     // Catch: Throwable -> L15
        goto L23
    L29:
        r9 = r9 + 1;
        goto L11
    L17:
        methods = getEnabledInputMethodListInternal(userId, 2000);     // Catch: Throwable -> L15
        goto L19
    L30:
        if (pr == null) goto L32;
        pr.close();
    L32:
        return 0;
    L15:
        th = move-exception;
        if (pr == null) goto L86;
        pr.close();     // Catch: Throwable -> L36
        throw th;
    L36:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L86:
        throw th;
    L39:
        th = move-exception;
        throw th;
    }

    private int handleShellCommandEnableDisableInputMethod(ShellCommand shellCommand, boolean enabled) {
        int userIdToBeResolved = handleOptionsForCommandsThatOnlyHaveUserOption(shellCommand);
        String imeId = shellCommand.getNextArgRequired();
        PrintWriter out = shellCommand.getOutPrintWriter();
        PrintWriter error = shellCommand.getErrPrintWriter();     // Catch: Throwable -> L49
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L39
        int[] userIds = InputMethodUtils.resolveUserId(userIdToBeResolved, this.mCurrentImeUserId, shellCommand.getErrPrintWriter());     // Catch: Throwable -> L31
        int r9 = userIds.length;     // Catch: Throwable -> L31
        boolean hasFailed = false;
        int r12 = 0;
    L8:
        if (r12 >= r9) goto L20;
        int userId = userIds[r12];     // Catch: Throwable -> L17
        if (userHasDebugPriv(userId, shellCommand) == true) goto L12;
        boolean enabled2 = enabled;
    L71:
        r12 = r12 + 1;     // Catch: Throwable -> L15
        enabled = enabled2;
    L15:
        th = move-exception;
        Throwable r15 = th;
    L61:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L37
        throw r15;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Throwable r16 = th;
    L63:
        if (error != null) goto L75;
        throw r16;     // Catch: Throwable -> L46
    L75:
        error.close();     // Catch: Throwable -> L44
    L83:
        throw r16;     // Catch: Throwable -> L46
    L44:
        th = move-exception;
        r16.addSuppressed(th);     // Catch: Throwable -> L46
        throw r16;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Throwable r17 = th;
    L51:
        if (out == null) goto L84;
        out.close();     // Catch: Throwable -> L54
        throw r17;
    L54:
        th = move-exception;
        r17.addSuppressed(th);
        throw r17;
    L84:
        throw r17;
    L37:
        th = move-exception;
        r15 = th;
        goto L61
    L12:
        enabled2 = enabled;
        hasFailed = (!handleShellCommandEnableDisableInputMethodInternalLocked(userId, imeId, enabled2, out, error)) | hasFailed;     // Catch: Throwable -> L15
    L17:
        th = move-exception;
        r15 = th;
        goto L61
    L20:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L15
        if (error != null) goto L73;
    L26:
        if (out == null) goto L28;
        out.close();
    L28:
        if (hasFailed == false) goto L81;
        return -1;
    L81:
        return 0;
    L73:
        error.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r17 = th;
    L31:
        th = move-exception;
        r15 = th;
    L39:
        th = move-exception;
        r16 = th;
    L49:
        th = move-exception;
        r17 = th;
        goto L51
    }

    private static int handleOptionsForCommandsThatOnlyHaveUserOption(ShellCommand shellCommand) {
    L2:
        String nextOption = shellCommand.getNextOption();
        if (nextOption == null) goto L4;
        switch(nextOption.hashCode()) {
            case 1512: goto L13;
            case 1333469547: goto L10;
            default: goto L15;
        };
    L15:
        byte r1 = -1;
    L16:
        switch(r1) {
            case 0: goto L19;
            case 1: goto L19;
            default: goto L2;
        };
    L19:
        return UserHandle.parseUserArg(shellCommand.getNextArgRequired());
    L10:
        if (nextOption.equals("--user") == false) goto L15;
        r1 = 1;
        goto L16
    L13:
        if (nextOption.equals("-u") == false) goto L15;
        r1 = 0;
        goto L16
    L4:
        return -2;
    }

    private boolean handleShellCommandEnableDisableInputMethodInternalLocked(int userId, String imeId, boolean enabled, PrintWriter out, PrintWriter error) {
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);
        if (enabled == true) goto L5;
    L8:
        boolean previouslyEnabled = setInputMethodEnabledLocked(imeId, enabled, userId);
        out.print("Input method ");
        out.print(imeId);
        out.print(": ");
        if (enabled != previouslyEnabled) goto L11;
        String r2 = "already ";
    L12:
        out.print(r2);
        if (enabled == false) goto L15;
        String r3 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L16:
        out.print(r3);
        out.print(" for user #");
        out.println(userId);
        return true;
    L15:
        r3 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L16
    L11:
        r2 = "now ";
        goto L12
    L5:
        if (settings.getMethodMap().containsKey(imeId) == true) goto L8;
        error.print("Unknown input method ");
        error.print(imeId);
        error.println(" cannot be enabled for user #" + userId);
        Slog.e(TAG, "\"ime enable " + imeId + "\" for user #" + userId + " failed due to its unrecognized IME ID.");
        return false;
    }

    private int handleShellCommandSetInputMethod(ShellCommand shellCommand) {
        InputMethodManagerService r1 = this;
        int userIdToBeResolved = handleOptionsForCommandsThatOnlyHaveUserOption(shellCommand);
        String imeId = shellCommand.getNextArgRequired();
        boolean hasFailed = false;
        PrintWriter out = shellCommand.getOutPrintWriter();
        PrintWriter error = shellCommand.getErrPrintWriter();     // Catch: Throwable -> L80
        monitor-enter(ImfLock.class);     // Catch: Throwable -> L70
        int[] userIds = InputMethodUtils.resolveUserId(userIdToBeResolved, r1.mCurrentImeUserId, shellCommand.getErrPrintWriter());     // Catch: Throwable -> L62
        int r8 = userIds.length;     // Catch: Throwable -> L62
        int r10 = 0;
    L10:
        if (r10 >= r8) goto L49;
        int userId = userIds[r10];     // Catch: Throwable -> L47
        if (r1.userHasDebugPriv(userId, shellCommand) == true) goto L17;
        userIds = userIds;
        int userIdToBeResolved2 = userIdToBeResolved;
    L88:
        r10 = r10 + 1;     // Catch: Throwable -> L37
        r1 = this;
        userIdToBeResolved = userIdToBeResolved2;
        userIds = userIds;
    L37:
        th = th;
    L104:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Throwable r2 = th;
    L90:
        if (error != null) goto L114;
        throw r2;     // Catch: Throwable -> L77
    L114:
        error.close();     // Catch: Throwable -> L75
    L120:
        throw r2;     // Catch: Throwable -> L77
    L75:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: Throwable -> L77
        throw r2;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        Throwable r3 = th;
    L82:
        if (out == null) goto L121;
        out.close();     // Catch: Throwable -> L85
        throw r3;
    L85:
        th = move-exception;
        r3.addSuppressed(th);
        throw r3;
    L121:
        throw r3;
    L68:
        th = th;
        goto L104
    L17:
        boolean failedToSelectUnknownIme = !r1.switchToInputMethodLocked(imeId, -1, userId);
        if (failedToSelectUnknownIme == true) goto L112;
        out.print("Input method ");     // Catch: Throwable -> L42
        out.print(imeId);     // Catch: Throwable -> L42
        out.print(" selected for user #");     // Catch: Throwable -> L42
        out.println(userId);     // Catch: Throwable -> L42
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L42
        InputMethodBindingController bindingController = r1.getInputMethodBindingController(userId);     // Catch: Throwable -> L42
        int deviceId = bindingController.getDeviceIdToShowIme();     // Catch: Throwable -> L42
        if (deviceId == 0) goto L26;
        String settingsValue = settings.getSelectedDefaultDeviceInputMethod();     // Catch: Throwable -> L42
        String settingsValue2 = settingsValue;
    L29:
        if (TextUtils.equals(settingsValue2, imeId) == false) goto L31;
        userIdToBeResolved2 = userIdToBeResolved;
        boolean hasFailed2 = hasFailed;
    L45:
        hasFailed = hasFailed2 | failedToSelectUnknownIme;     // Catch: Throwable -> L37
        goto L88
    L31:
        userIdToBeResolved2 = userIdToBeResolved;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L40
        hasFailed2 = hasFailed;
        r4.append("DEFAULT_INPUT_METHOD=");     // Catch: Throwable -> L37
        r4.append(settingsValue2);     // Catch: Throwable -> L37
        r4.append(" is not updated. Fixing it up to ");     // Catch: Throwable -> L37
        r4.append(imeId);     // Catch: Throwable -> L37
        r4.append(" See b/354782333.");     // Catch: Throwable -> L37
        Slog.w(TAG, r4.toString());     // Catch: Throwable -> L37
        if (deviceId != 0) goto L39;
        settings.putSelectedInputMethod(imeId);     // Catch: Throwable -> L37
        goto L45
    L39:
        settings.putSelectedDefaultDeviceInputMethod(imeId);     // Catch: Throwable -> L37
    L40:
        th = th;
        goto L104
    L26:
        settingsValue2 = settings.getSelectedInputMethod();     // Catch: Throwable -> L21
        goto L29
    L112:
        error.print("Unknown input method ");     // Catch: Throwable -> L21
        error.print(imeId);     // Catch: Throwable -> L21
        error.print(" cannot be selected for user #");     // Catch: Throwable -> L21
        error.println(userId);     // Catch: Throwable -> L21
        Slog.e(TAG, "\"ime set " + imeId + "\" for user #" + userId + " failed due to its unrecognized IME ID.");     // Catch: Throwable -> L21
        userIds = userIds;
        userIdToBeResolved2 = userIdToBeResolved;
        hasFailed2 = hasFailed;
    L21:
        th = th;
    L42:
        th = th;
    L47:
        th = th;
        goto L104
    L49:
        hasFailed2 = hasFailed;
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L37
        if (error != null) goto L110;
    L56:
        if (out == null) goto L58;
        out.close();
    L58:
        if (hasFailed2 == true) goto L118;
        return 0;
    L118:
        return -1;
    L110:
        error.close();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r3 = th;
    L62:
        th = th;
    L70:
        th = move-exception;
        r2 = th;
    L80:
        th = move-exception;
        r3 = th;
        goto L82
    }

    private int handleShellCommandResetInputMethod(ShellCommand shellCommand) {
        InputMethodManagerService r1 = this;
        int userIdToBeResolved = handleOptionsForCommandsThatOnlyHaveUserOption(shellCommand);
        monitor-enter(ImfLock.class);
        final PrintWriter out = shellCommand.getOutPrintWriter();     // Catch: Throwable -> L56
        int[] userIds = InputMethodUtils.resolveUserId(userIdToBeResolved, r1.mCurrentImeUserId, shellCommand.getErrPrintWriter());     // Catch: Throwable -> L39
        int r5 = userIds.length;     // Catch: Throwable -> L39
        boolean r6 = false;
        int r7 = 0;
    L7:
        if (r7 >= r5) goto L42;
        int userId = userIds[r7];     // Catch: Throwable -> L39
    L28:
        th = th;
    L29:
        Throwable r2 = th;
    L49:
        if (out == null) goto L79;
        out.close();     // Catch: Throwable -> L52
    L80:
        throw r2;     // Catch: Throwable -> L44
    L52:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: Throwable -> L44
        throw r2;     // Catch: Throwable -> L44
    L79:
        throw r2;     // Catch: Throwable -> L44
    L11:
        if (r1.userHasDebugPriv(userId, shellCommand) == true) goto L13;
        int[] userIds2 = userIds;
        int userIdToBeResolved2 = userIdToBeResolved;
    L38:
        r7 = r7 + 1;
        r6 = false;
        r1 = this;
        userIds = userIds2;
        userIdToBeResolved = userIdToBeResolved2;
        goto L7
    L13:
        UserInfo userInfo = r1.mUserManagerInternal.getUserInfo(userId);     // Catch: Throwable -> L28
        if (userInfo != null) goto L62;
    L20:
        InputMethodSettings settings = InputMethodSettingsRepository.get(userId);     // Catch: Throwable -> L28
        UserData userData = r1.getUserData(userId);     // Catch: Throwable -> L28
        r1.setImeVisibilityOnFocusedWindowClient(r6, userData, null);     // Catch: Throwable -> L28
        InputMethodBindingController bindingController = userData.mBindingController;     // Catch: Throwable -> L28
        bindingController.unbindCurrentMethod();     // Catch: Throwable -> L28
        ArrayList<InputMethodInfo> toDisable = settings.getEnabledInputMethodList();     // Catch: Throwable -> L28
        ArrayList<InputMethodInfo> defaultEnabled = InputMethodInfoUtils.getDefaultEnabledImes(r1.mContext, settings.getMethodList());     // Catch: Throwable -> L28
        toDisable.removeAll(defaultEnabled);     // Catch: Throwable -> L28
        Iterator<InputMethodInfo> r13 = toDisable.iterator();     // Catch: Throwable -> L28
    L22:
        if (r13.hasNext() == false) goto L30;
        InputMethodInfo info = r13.next();     // Catch: Throwable -> L28
        int[] userIds3 = userIds;
        int userIdToBeResolved3 = userIdToBeResolved;
        r1.setInputMethodEnabledLocked(info.getId(), false, userId);     // Catch: Throwable -> L26
        userIds = userIds3;
        userIdToBeResolved = userIdToBeResolved3;
    L26:
        th = move-exception;
        r2 = th;
        goto L49
    L30:
        userIds2 = userIds;
        userIdToBeResolved2 = userIdToBeResolved;
        Iterator<InputMethodInfo> r0 = defaultEnabled.iterator();     // Catch: Throwable -> L26
    L32:
        if (r0.hasNext() == false) goto L35;
        InputMethodInfo info2 = r0.next();     // Catch: Throwable -> L26
        r1.setInputMethodEnabledLocked(info2.getId(), true, userId);     // Catch: Throwable -> L26
        r0 = r0;
        goto L32
    L35:
        if (r1.chooseNewDefaultIMELocked(userId) == true) goto L37;
        r1.resetSelectedInputMethodAndSubtypeLocked(null, userId);     // Catch: Throwable -> L26
    L37:
        r1.updateInputMethodsFromSettingsLocked(true, userId);     // Catch: Throwable -> L26
        InputMethodUtils.setNonSelectedSystemImesDisabledUntilUsed(getPackageManagerForUser(r1.mContext, settings.getUserId()), settings.getEnabledInputMethodList());     // Catch: Throwable -> L26
        String nextIme = settings.getSelectedInputMethod();     // Catch: Throwable -> L26
        List<InputMethodInfo> nextEnabledImes = settings.getEnabledInputMethodList();     // Catch: Throwable -> L26
        out.println("Reset current and enabled IMEs for user #" + userId);     // Catch: Throwable -> L26
        out.println("  Selected: " + nextIme);     // Catch: Throwable -> L26
        nextEnabledImes.forEach(new InputMethodManagerService$$ExternalSyntheticLambda6(out));     // Catch: Throwable -> L26
        goto L38
    L62:
        if ("android.os.usertype.system.HEADLESS".equals(userInfo.userType) == false) goto L20;
        userIds2 = userIds;
        userIdToBeResolved2 = userIdToBeResolved;
    L18:
        th = move-exception;
        r2 = th;
        goto L49
    L42:
        if (out == null) goto L46;
        out.close();     // Catch: Throwable -> L44
    L46:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L44
        return 0;
    L39:
        th = th;
    L44:
        th = th;
    L58:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L44
        throw th;
    L56:
        th = th;
        goto L58
    }

    private static /* synthetic */ void lambda$handleShellCommandResetInputMethod$23(PrintWriter out, InputMethodInfo ime) {
        out.println("   Enabled: " + ime.getId());
    }

    boolean setImeVisibilityOnFocusedWindowClient(boolean visible, UserData userData, ImeTracker.Token statsToken) {
        if (userData.mImeBindingState.mFocusedWindowClient == null) goto L6;
        userData.mImeBindingState.mFocusedWindowClient.mClient.setImeVisibility(visible, statsToken);
        return true;
    L6:
        ImeTracker.forLogging().onFailed(statsToken, 57);
        return false;
    }

    private int handleShellCommandTraceInputMethod(ShellCommand shellCommand) {
        String cmd = shellCommand.getNextArgRequired();
        PrintWriter pw = shellCommand.getOutPrintWriter();
    L9:
        th = move-exception;
        if (pw != null) goto L44;
    L43:
        throw th;
    L44:
        pw.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.addSuppressed(th);
        goto L43
    L4:
        switch(cmd.hashCode()) {
            case -390772652: goto L15;
            case 3540994: goto L12;
            case 109757538: goto L7;
            default: goto L17;
        };     // Catch: Throwable -> L9
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L22;
            default: goto L19;
        };     // Catch: Throwable -> L9
    L19:
        pw.println("Unknown command: " + cmd);     // Catch: Throwable -> L9
        pw.println("Input method trace options:");     // Catch: Throwable -> L9
        pw.println("  start: Start tracing");     // Catch: Throwable -> L9
        pw.println("  stop: Stop tracing");     // Catch: Throwable -> L9
        pw.close();
        return -1;
    L22:
        ImeTracing.getInstance().saveForBugreport(pw);     // Catch: Throwable -> L9
        if (pw == null) goto L25;
        pw.close();
    L25:
        return 0;
    L26:
        ImeTracing.getInstance().stopTrace(pw);     // Catch: Throwable -> L9
    L28:
        if (pw == null) goto L30;
        pw.close();
    L30:
        final boolean isImeTraceEnabled = ImeTracing.getInstance().isEnabled();
        monitor-enter(ImfLock.class);
        this.mClientController.forAllClients(new AnonymousClass6(this, isImeTraceEnabled));     // Catch: Throwable -> L35
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L35
        return 0;
    L35:
        th = move-exception;
        throw th;
    L27:
        ImeTracing.getInstance().startTrace(pw);     // Catch: Throwable -> L9
        goto L28
    L7:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L17;
        r2 = 0;
        goto L18
    L12:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L17;
        r2 = 1;
        goto L18
    L15:
        if (cmd.equals("save-for-bugreport") == false) goto L17;
        r2 = 2;
        goto L18
    }

    private boolean userHasDebugPriv(int userId, ShellCommand shellCommand) {
        if (this.mUserManagerInternal.hasUserRestriction("no_debugging_features", userId) == false) goto L6;
        shellCommand.getErrPrintWriter().println("User #" + userId + " is restricted with DISALLOW_DEBUGGING_FEATURES.");
        return false;
    L6:
        return true;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IImeTracker getImeTrackerService() {
        return this.mImeTrackerService;
    }

    ImeTracker.Token createStatsTokenForFocusedClient(boolean show, int reason, int userId) {
        UserData userData = getUserData(userId);
        if (userData.mImeBindingState.mFocusedWindowClient == null) goto L5;
        int r1 = userData.mImeBindingState.mFocusedWindowClient.mUid;
    L6:
        int uid = r1;
        if (userData.mImeBindingState.mFocusedWindowEditorInfo == null) goto L9;
        String packageName = userData.mImeBindingState.mFocusedWindowEditorInfo.packageName;
    L10:
        ImeTracker r2 = ImeTracker.forLogging();
        if (show == false) goto L14;
        int r3 = 1;
    L16:
        return r2.onStart(packageName, uid, r3, 6, reason, false);
    L14:
        r3 = 2;
        goto L16
    L9:
        packageName = "uid(" + uid + ")";
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IInputMethodManagerExt getIExt() {
        return getExt().getIExt();
    }

    public IExtInputMethodManagerService getExt() {
        return this.mExt;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IObricInputMethodManager getIObricExt() {
        return this.mObricExt.getIObricExt();
    }

    public IObricInputMethodManagerService getObricExt() {
        return this.mObricExt;
    }
}
