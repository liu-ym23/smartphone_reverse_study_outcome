package com.android.server.wm;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.window.InputTransferToken;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.input.InputManagerService;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class EmbeddedWindowController {
    private static final String TAG = "WindowManager";
    private final ActivityTaskManagerService mAtmService;
    private final Object mGlobalLock;
    private final InputManagerService mInputManagerService;
    private ArrayMap<IBinder, EmbeddedWindow> mWindows;
    private ArrayMap<InputTransferToken, EmbeddedWindow> mWindowsByInputTransferToken;
    private ArrayMap<IBinder, EmbeddedWindow> mWindowsByWindowToken;

    static class EmbeddedWindow implements InputTarget {
        final IBinder mClient;
        final int mDisplayId;
        boolean mGestureToEmbedded;
        final ActivityRecord mHostActivityRecord;
        final WindowState mHostWindowState;
        InputChannel mInputChannel;
        private final InputTransferToken mInputTransferToken;
        private boolean mIsFocusable;
        final String mName;
        final int mOwnerPid;
        final int mOwnerUid;
        private int mRequestedVisibleTypes;
        public Session mSession;
        final int mWindowType;
        final WindowManagerService mWmService;

        EmbeddedWindow(Session session, WindowManagerService service, IBinder clientToken, WindowState hostWindowState, int ownerUid, int ownerPid, int windowType, int displayId, InputTransferToken inputTransferToken, String inputHandleName, boolean isFocusable) {
            this.mRequestedVisibleTypes = 0;
            this.mGestureToEmbedded = false;
            this.mSession = session;
            this.mWmService = service;
            this.mClient = clientToken;
            this.mHostWindowState = hostWindowState;
            if (this.mHostWindowState == null) goto L5;
            ActivityRecord r0 = this.mHostWindowState.mActivityRecord;
        L6:
            this.mHostActivityRecord = r0;
            this.mOwnerUid = ownerUid;
            this.mOwnerPid = ownerPid;
            this.mWindowType = windowType;
            this.mDisplayId = displayId;
            this.mInputTransferToken = inputTransferToken;
            if (this.mHostWindowState == null) goto L9;
            String hostWindowName = "-" + this.mHostWindowState.getWindowTag().toString();
        L10:
            this.mIsFocusable = isFocusable;
            this.mName = "Embedded{" + inputHandleName + hostWindowName + "}";
            return;
        L9:
            hostWindowName = "";
            goto L10
        L5:
            r0 = null;
            goto L6
        }

        public String toString() {
            return this.mName;
        }

        InputApplicationHandle getApplicationHandle() {
            if (this.mHostWindowState != null) goto L5;
            return null;
        L5:
            if (this.mHostWindowState.mInputWindowHandle.getInputApplicationHandle() != null) goto L8;
            return null;
        L8:
            return new InputApplicationHandle(this.mHostWindowState.mInputWindowHandle.getInputApplicationHandle());
        }

        void openInputChannel(InputChannel outInputChannel) {
            String name = toString();
            this.mInputChannel = this.mWmService.mInputManager.createInputChannel(name);
            this.mInputChannel.copyTo(outInputChannel);
        }

        void onRemoved() {
            if (this.mInputChannel == null) goto L6;
            this.mWmService.mInputManager.removeInputChannel(this.mInputChannel.getToken());
            this.mInputChannel.dispose();
            this.mInputChannel = null;
        L6:
            if (this.mHostActivityRecord == null) goto L11;
            WindowProcessController wpc = this.mWmService.mAtmService.getProcessController(this.mOwnerPid, this.mOwnerUid);
            if (wpc == null) goto L12;
            wpc.removeHostActivity(this.mHostActivityRecord);
            return;
        L12:
            return;
        }

        @Override // com.android.server.wm.InputTarget
        public WindowState getWindowState() {
            return this.mHostWindowState;
        }

        @Override // com.android.server.wm.InputTarget
        public int getDisplayId() {
            return this.mDisplayId;
        }

        @Override // com.android.server.wm.InputTarget
        public DisplayContent getDisplayContent() {
            return this.mWmService.mRoot.getDisplayContent(getDisplayId());
        }

        @Override // com.android.server.wm.InsetsTarget
        public IBinder getWindowToken() {
            return this.mClient;
        }

        @Override // com.android.server.wm.InsetsTarget
        public boolean isRequestedVisible(int types) {
            if ((this.mRequestedVisibleTypes & types) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.wm.InsetsTarget
        public int getRequestedVisibleTypes() {
            return this.mRequestedVisibleTypes;
        }

        int setRequestedVisibleTypes(int requestedVisibleTypes) {
            if (this.mRequestedVisibleTypes == requestedVisibleTypes) goto L6;
            int changedTypes = this.mRequestedVisibleTypes ^ requestedVisibleTypes;
            this.mRequestedVisibleTypes = requestedVisibleTypes;
            return changedTypes;
        L6:
            return 0;
        }

        @Override // com.android.server.wm.InputTarget
        public int getPid() {
            return this.mOwnerPid;
        }

        @Override // com.android.server.wm.InputTarget
        public int getUid() {
            return this.mOwnerUid;
        }

        InputTransferToken getInputTransferToken() {
            return this.mInputTransferToken;
        }

        IBinder getInputChannelToken() {
            if (this.mInputChannel != null) goto L5;
            return null;
        L5:
            return this.mInputChannel.getToken();
        }

        void setIsFocusable(boolean isFocusable) {
            this.mIsFocusable = isFocusable;
        }

        @Override // com.android.server.wm.InputTarget
        public boolean receiveFocusFromTapOutside() {
            return this.mIsFocusable;
        }

        private void handleTap(boolean grantFocus) {
            if (this.mInputChannel != null) goto L5;
            return;
        L5:
            if (this.mHostWindowState == null) goto L9;
            this.mWmService.grantEmbeddedWindowFocus(null, this.mHostWindowState.mClient, this.mInputTransferToken, grantFocus);
            if (grantFocus == false) goto L12;
            this.mHostWindowState.handleTapOutsideFocusInsideSelf();
            return;
        L12:
            return;
        L9:
            this.mWmService.grantEmbeddedWindowFocus(this.mSession, this.mInputTransferToken, grantFocus);
        }

        @Override // com.android.server.wm.InputTarget
        public void handleTapOutsideFocusOutsideSelf() {
            handleTap(false);
        }

        @Override // com.android.server.wm.InputTarget
        public void handleTapOutsideFocusInsideSelf() {
            handleTap(true);
        }

        @Override // com.android.server.wm.InputTarget
        public boolean shouldControlIme() {
            return false;
        }

        @Override // com.android.server.wm.InputTarget
        public boolean canScreenshotIme() {
            return true;
        }

        @Override // com.android.server.wm.InputTarget
        public InsetsControlTarget getImeControlTarget() {
            if (this.mHostWindowState == null) goto L7;
            return this.mHostWindowState.getImeControlTarget();
        L7:
            return this.mWmService.getDefaultDisplayContentLocked().mRemoteInsetsControlTarget;
        }

        @Override // com.android.server.wm.InputTarget
        public boolean isInputMethodClientFocus(int uid, int pid) {
            if (uid == this.mOwnerUid) goto L5;
        L7:
            return false;
        L5:
            if (pid != this.mOwnerPid) goto L7;
            return true;
        }

        @Override // com.android.server.wm.InputTarget
        public ActivityRecord getActivityRecord() {
            return this.mHostActivityRecord;
        }

        @Override // com.android.server.wm.InputTarget
        public void dumpProto(ProtoOutputStream proto, long fieldId, int logLevel) {
            long token = proto.start(fieldId);
            long token2 = proto.start(1146756268034L);
            proto.write(1120986464257L, System.identityHashCode(this));
            proto.write(1138166333443L, "EmbeddedWindow");
            proto.end(token2);
            proto.end(token);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$BS8sNYvr200yoQQ-WxXf5a9znDs, reason: not valid java name */
    public static /* synthetic */ void m9988$r8$lambda$BS8sNYvr200yoQQWxXf5a9znDs(EmbeddedWindowController r0, IBinder r1, InputTransferToken r2, IBinder r3) {
        r0.lambda$add$0(r1, r2, r3);
    }

    EmbeddedWindowController(ActivityTaskManagerService atmService, InputManagerService inputManagerService) {
        this.mWindows = new ArrayMap();
        this.mWindowsByInputTransferToken = new ArrayMap();
        this.mWindowsByWindowToken = new ArrayMap();
        this.mAtmService = atmService;
        this.mGlobalLock = atmService.getGlobalLock();
        this.mInputManagerService = inputManagerService;
    }

    void add(final IBinder inputToken, EmbeddedWindow window) {
        this.mWindows.put(inputToken, window);     // Catch: RemoteException -> L4
        final InputTransferToken inputTransferToken = window.getInputTransferToken();     // Catch: RemoteException -> L4
        this.mWindowsByInputTransferToken.put(inputTransferToken, window);     // Catch: RemoteException -> L4
        final IBinder windowToken = window.getWindowToken();     // Catch: RemoteException -> L4
        this.mWindowsByWindowToken.put(windowToken, window);     // Catch: RemoteException -> L4
        updateProcessController(window);     // Catch: RemoteException -> L4
        window.mClient.linkToDeath(new EmbeddedWindowController$$ExternalSyntheticLambda0(this, inputToken, inputTransferToken, windowToken), 0);     // Catch: RemoteException -> L4
        return;
    L5:
        this.mWindows.remove(inputToken);
    }

    private /* synthetic */ void lambda$add$0(IBinder inputToken, InputTransferToken inputTransferToken, IBinder windowToken) {
        Object r0 = this.mGlobalLock;
        monitor-enter(r0);
        this.mWindows.remove(inputToken);     // Catch: Throwable -> L7
        this.mWindowsByInputTransferToken.remove(inputTransferToken);     // Catch: Throwable -> L7
        this.mWindowsByWindowToken.remove(windowToken);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateProcessController(EmbeddedWindow window) {
        if (window.mHostActivityRecord != null) goto L5;
        return;
    L5:
        WindowProcessController processController = this.mAtmService.getProcessController(window.mOwnerPid, window.mOwnerUid);
        if (processController != null) goto L8;
        Slog.w(TAG, "Could not find the embedding process.");
        return;
    L8:
        processController.addHostActivity(window.mHostActivityRecord);
    }

    void remove(IBinder client) {
        int i = this.mWindows.size() - 1;
    L3:
        if (i < 0) goto L10;
        EmbeddedWindow ew = this.mWindows.valueAt(i);
        if (ew.mClient == client) goto L6;
        i = i - 1;
        goto L3
    L6:
        this.mWindows.removeAt(i).onRemoved();
        this.mWindowsByInputTransferToken.remove(ew.getInputTransferToken());
        this.mWindowsByWindowToken.remove(ew.getWindowToken());
        return;
    }

    void onWindowRemoved(WindowState host) {
        int i = this.mWindows.size() - 1;
    L3:
        if (i < 0) goto L9;
        EmbeddedWindow ew = this.mWindows.valueAt(i);
        if (ew.mHostWindowState != host) goto L7;
        this.mWindows.removeAt(i).onRemoved();
        this.mWindowsByInputTransferToken.remove(ew.getInputTransferToken());
        this.mWindowsByWindowToken.remove(ew.getWindowToken());
    L7:
        i = i - 1;
        goto L3
    }

    EmbeddedWindow get(IBinder inputToken) {
        return this.mWindows.get(inputToken);
    }

    EmbeddedWindow getByInputTransferToken(InputTransferToken inputTransferToken) {
        return this.mWindowsByInputTransferToken.get(inputTransferToken);
    }

    EmbeddedWindow getByWindowToken(IBinder windowToken) {
        return this.mWindowsByWindowToken.get(windowToken);
    }

    ArrayList<EmbeddedWindow> getByHostWindow(WindowState host) {
        ArrayList<EmbeddedWindow> windows = null;
        int i = this.mWindows.size() - 1;
    L3:
        if (i < 0) goto L11;
        EmbeddedWindow ew = this.mWindows.valueAt(i);
        if (ew.mHostWindowState != host) goto L9;
        if (windows != null) goto L8;
        windows = new ArrayList();
    L8:
        windows.add(ew);
    L9:
        i = i - 1;
        goto L3
    L11:
        return windows;
    }

    private boolean isValidTouchGestureParams(WindowState hostWindowState, EmbeddedWindow embeddedWindow) {
        if (embeddedWindow == null) goto L5;
        WindowState wsAssociatedWithEmbedded = embeddedWindow.getWindowState();
        if (wsAssociatedWithEmbedded != null) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] == false) goto L13;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, 929964979835124721L, 0, null);
    L13:
        return false;
    L15:
        if (wsAssociatedWithEmbedded.mClient.asBinder() == hostWindowState.mClient.asBinder()) goto L21;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] == false) goto L19;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, 676191989331669410L, 0, null);
    L19:
        return false;
    L21:
        if (embeddedWindow.getInputChannelToken() != null) goto L27;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] == false) goto L25;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, 553249487221306249L, 0, null);
    L25:
        return false;
    L27:
        if (hostWindowState.mInputChannelToken == null) goto L29;
        return true;
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] == false) goto L31;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, -8678904073078032058L, 0, null);
    L31:
        return false;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] == false) goto L7;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, -1797662102094201628L, 0, null);
    L7:
        return false;
    }

    boolean transferToHost(int callingUid, InputTransferToken embeddedWindowToken, WindowState transferToHostWindowState) {
        EmbeddedWindow ew = getByInputTransferToken(embeddedWindowToken);
        if (isValidTouchGestureParams(transferToHostWindowState, ew) == true) goto L6;
        return false;
    L6:
        if (callingUid != ew.mOwnerUid) goto L12;
        boolean didTransfer = this.mInputManagerService.transferTouchGesture(ew.getInputChannelToken(), transferToHostWindowState.mInputChannelToken, true);
        if (didTransfer == false) goto L10;
        ew.mGestureToEmbedded = false;
    L10:
        return didTransfer;
    L12:
        throw new SecurityException("Transfer request must originate from owner of transferFromToken");
    }

    boolean transferToEmbedded(int callingUid, WindowState hostWindowState, InputTransferToken transferToToken) {
        EmbeddedWindow ew = getByInputTransferToken(transferToToken);
        if (isValidTouchGestureParams(hostWindowState, ew) == true) goto L7;
        return false;
    L7:
        if (callingUid != hostWindowState.mOwnerUid) goto L13;
        boolean didTransfer = this.mInputManagerService.transferTouchGesture(hostWindowState.mInputChannelToken, ew.getInputChannelToken(), true);
        if (didTransfer == false) goto L11;
        ew.mGestureToEmbedded = true;
        this.mAtmService.mBackNavigationController.onEmbeddedWindowGestureTransferred(hostWindowState);
    L11:
        return didTransfer;
    L13:
        throw new SecurityException("Transfer request must originate from owner of transferFromToken");
    }
}
