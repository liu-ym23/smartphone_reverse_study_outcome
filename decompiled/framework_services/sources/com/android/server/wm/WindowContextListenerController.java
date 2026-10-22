package com.android.server.wm;

import android.app.servertransaction.WindowContextInfoChangeItem;
import android.app.servertransaction.WindowContextWindowRemovalItem;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.view.Display;
import android.window.WindowProviderService;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
class WindowContextListenerController {
    final ArrayMap<IBinder, WindowContextListenerImpl> mListeners;

    class WindowContextListenerImpl implements WindowContainerListener {
        private final IBinder mClientToken;
        private WindowContainer<?> mContainer;
        private DeathRecipient mDeathRecipient;
        private boolean mHasPendingConfiguration;
        private Configuration mLastReportedConfig;
        private int mLastReportedDisplay;
        private final Bundle mOptions;
        private final int mType;
        private final WindowProcessController mWpc;
        final /* synthetic */ WindowContextListenerController this$0;

        private class DeathRecipient implements IBinder.DeathRecipient {
            final /* synthetic */ WindowContextListenerImpl this$1;

            /* synthetic */ DeathRecipient(WindowContextListenerImpl r1, WindowContextListenerControllerIA r2) {
                this(r1);
            }

            private DeathRecipient(WindowContextListenerImpl r1) {
                this.this$1 = r1;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                WindowManagerGlobalLock r0 = WindowContextListenerImpl.m10395$$Nest$fgetmContainer(this.this$1).mWmService.mGlobalLock;
                WindowManagerService.boostPriorityForLockedSection();
                monitor-enter(r0);
                WindowContextListenerImpl.m10400$$Nest$fputmDeathRecipient(this.this$1, null);     // Catch: Throwable -> L8
                WindowContextListenerImpl.m10403$$Nest$munregister(this.this$1);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                WindowManagerService.resetPriorityAfterLockedSection();
                return;
            L8:
                th = move-exception;
                WindowManagerService.resetPriorityAfterLockedSection();
                throw th;
            }

            void linkToDeath() throws RemoteException {
                WindowContextListenerImpl.m10394$$Nest$fgetmClientToken(this.this$1).linkToDeath(this, 0);
            }

            void unlinkToDeath() {
                WindowContextListenerImpl.m10394$$Nest$fgetmClientToken(this.this$1).unlinkToDeath(this, 0);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClientToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m10394$$Nest$fgetmClientToken(WindowContextListenerImpl r0) {
            return r0.mClientToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmContainer, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowContainer m10395$$Nest$fgetmContainer(WindowContextListenerImpl r0) {
            return r0.mContainer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
        static /* bridge */ /* synthetic */ DeathRecipient m10396$$Nest$fgetmDeathRecipient(WindowContextListenerImpl r0) {
            return r0.mDeathRecipient;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHasPendingConfiguration, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10397$$Nest$fgetmHasPendingConfiguration(WindowContextListenerImpl r0) {
            return r0.mHasPendingConfiguration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOptions, reason: not valid java name */
        static /* bridge */ /* synthetic */ Bundle m10398$$Nest$fgetmOptions(WindowContextListenerImpl r0) {
            return r0.mOptions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10399$$Nest$fgetmType(WindowContextListenerImpl r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDeathRecipient, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10400$$Nest$fputmDeathRecipient(WindowContextListenerImpl r0, DeathRecipient r1) {
            r0.mDeathRecipient = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdispatchWindowContextInfoChange, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10401$$Nest$mdispatchWindowContextInfoChange(WindowContextListenerImpl r0) {
            r0.dispatchWindowContextInfoChange();
        }

        /* JADX INFO: renamed from: -$$Nest$mregister, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10402$$Nest$mregister(WindowContextListenerImpl r0, boolean r1) {
            r0.register(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$munregister, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10403$$Nest$munregister(WindowContextListenerImpl r0) {
            r0.unregister();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateContainer, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10404$$Nest$mupdateContainer(WindowContextListenerImpl r0, WindowContainer r1) {
            r0.updateContainer(r1);
        }

        /* synthetic */ WindowContextListenerImpl(WindowContextListenerController r1, WindowProcessController r2, IBinder r3, WindowContainer r4, int r5, Bundle r6, WindowContextListenerControllerIA r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private WindowContextListenerImpl(WindowContextListenerController this$0, WindowProcessController wpc, IBinder clientToken, WindowContainer<?> container, int type, Bundle options) {
            this.this$0 = this$0;
            this.mLastReportedDisplay = -1;
            wpc.getClass();
            this.mWpc = wpc;
            this.mClientToken = clientToken;
            container.getClass();
            this.mContainer = container;
            this.mType = type;
            this.mOptions = options;
            DeathRecipient deathRecipient = new DeathRecipient(this, null);
            deathRecipient.linkToDeath();     // Catch: RemoteException -> L5
            this.mDeathRecipient = deathRecipient;     // Catch: RemoteException -> L5
            return;
        L7:
            if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L12;
            String protoLogParam0 = String.valueOf(clientToken);
            String protoLogParam1 = String.valueOf(this.mContainer);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 6139364662459841509L, 0, new Object[]{protoLogParam0, protoLogParam1});
            return;
        }

        WindowContainer<?> getWindowContainer() {
            return this.mContainer;
        }

        int getUid() {
            return this.mWpc.mUid;
        }

        private void updateContainer(WindowContainer<?> newContainer) {
            newContainer.getClass();
            if (this.mContainer.equals(newContainer) == false) goto L5;
            return;
        L5:
            this.mContainer.unregisterWindowContainerListener(this);
            this.mContainer = newContainer;
            clear();
            register();
        }

        private void register() {
            register(true);
        }

        private void register(boolean shouldDispatchConfig) {
            IBinder token = this.mClientToken;
            if (this.mDeathRecipient == null) goto L7;
            this.this$0.mListeners.putIfAbsent(token, this);
            this.mContainer.registerWindowContainerListener(this, shouldDispatchConfig);
            return;
        L7:
            throw new IllegalStateException("Invalid client token: " + token);
        }

        private void unregister() {
            this.mContainer.unregisterWindowContainerListener(this);
            this.this$0.mListeners.remove(this.mClientToken);
        }

        private void clear() {
            this.mLastReportedConfig = null;
            this.mLastReportedDisplay = -1;
        }

        @Override // com.android.server.wm.ConfigurationContainerListener
        public void onMergedOverrideConfigurationChanged(Configuration mergedOverrideConfig) {
            dispatchWindowContextInfoChange();
        }

        @Override // com.android.server.wm.WindowContainerListener
        public void onDisplayChanged(DisplayContent dc) {
            dispatchWindowContextInfoChange();
        }

        private void dispatchWindowContextInfoChange() {
            if (this.mDeathRecipient == null) goto L24;
            DisplayContent dc = this.mContainer.getDisplayContent();
            if (dc.isReady() == true) goto L8;
            return;
        L8:
            if (WindowProviderService.isWindowProviderService(this.mOptions) == false) goto L10;
        L13:
            Configuration config = this.mContainer.getConfiguration();
            int displayId = dc.getDisplayId();
            if (this.mLastReportedConfig != null) goto L17;
            this.mLastReportedConfig = new Configuration();
        L17:
            if (config.equals(this.mLastReportedConfig) == true) goto L19;
        L21:
            this.mLastReportedConfig.setTo(config);
            this.mLastReportedDisplay = displayId;
            this.mWpc.scheduleClientTransactionItem(new WindowContextInfoChangeItem(this.mClientToken, config, displayId));
            this.mHasPendingConfiguration = false;
            return;
        L19:
            if (displayId != this.mLastReportedDisplay) goto L21;
            return;
        L10:
            if (Display.isSuspendedState(dc.getDisplayInfo().state) == false) goto L13;
            this.mHasPendingConfiguration = true;
            return;
        L24:
            throw new IllegalStateException("Invalid client token: " + this.mClientToken);
        }

        @Override // com.android.server.wm.WindowContainerListener
        public void onRemoved() {
            if (this.mDeathRecipient == null) goto L15;
            WindowToken windowToken = this.mContainer.asWindowToken();
            if (windowToken != null) goto L7;
        L12:
            this.mDeathRecipient.unlinkToDeath();
            this.mWpc.scheduleClientTransactionItem(new WindowContextWindowRemovalItem(this.mClientToken));
            unregister();
            return;
        L7:
            if (windowToken.isFromClient() == false) goto L12;
            DisplayContent dc = windowToken.mWmService.mRoot.getDisplayContent(this.mLastReportedDisplay);
            if (dc == null) goto L12;
            DisplayArea<?> da = dc.findAreaForToken(windowToken);
            updateContainer(da);
            return;
        L15:
            throw new IllegalStateException("Invalid client token: " + this.mClientToken);
        }

        public String toString() {
            return "WindowContextListenerImpl{clientToken=" + this.mClientToken + ", container=" + this.mContainer + "}";
        }
    }

    WindowContextListenerController() {
        this.mListeners = new ArrayMap();
    }

    void registerWindowContainerListener(WindowProcessController wpc, IBinder clientToken, WindowContainer<?> container, int type, Bundle options) {
        registerWindowContainerListener(wpc, clientToken, container, type, options, true);
    }

    void registerWindowContainerListener(WindowProcessController wpc, IBinder clientToken, WindowContainer<?> container, int type, Bundle options, boolean shouldDispatchConfigWhenRegistering) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L5;
        WindowContextListenerImpl listener2 = new WindowContextListenerImpl(this, wpc, clientToken, container, type, options, null);
        WindowContextListenerImpl.m10402$$Nest$mregister(listener2, shouldDispatchConfigWhenRegistering);
        return;
    L5:
        updateContainerForWindowContextListener(clientToken, container);
    }

    void updateContainerForWindowContextListener(IBinder clientToken, WindowContainer<?> container) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener == null) goto L7;
        WindowContextListenerImpl.m10404$$Nest$mupdateContainer(listener, container);
        return;
    L7:
        throw new IllegalArgumentException("Can't find listener for " + clientToken);
    }

    void unregisterWindowContainerListener(IBinder clientToken) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L5;
        return;
    L5:
        WindowContextListenerImpl.m10403$$Nest$munregister(listener);
        if (WindowContextListenerImpl.m10396$$Nest$fgetmDeathRecipient(listener) == null) goto L9;
        WindowContextListenerImpl.m10396$$Nest$fgetmDeathRecipient(listener).unlinkToDeath();
        return;
    }

    void dispatchPendingConfigurationIfNeeded(int displayId) {
        int i = this.mListeners.size() - 1;
    L3:
        if (i < 0) goto L11;
        WindowContextListenerImpl listener = this.mListeners.valueAt(i);
        if (listener.getWindowContainer().getDisplayContent().getDisplayId() != displayId) goto L9;
        if (WindowContextListenerImpl.m10397$$Nest$fgetmHasPendingConfiguration(listener) == false) goto L9;
        WindowContextListenerImpl.m10401$$Nest$mdispatchWindowContextInfoChange(listener);
    L9:
        i = i - 1;
        goto L3
    }

    boolean assertCallerCanModifyListener(IBinder clientToken, boolean callerCanManageAppTokens, int callingUid) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L7;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 2163930285157267092L, 0, null);
    L7:
        return false;
    L9:
        if (callerCanManageAppTokens == false) goto L12;
        return true;
    L12:
        if (callingUid != listener.getUid()) goto L15;
        return true;
    L15:
        throw new UnsupportedOperationException("Uid mismatch. Caller uid is " + callingUid + ", while the listener's owner is from " + listener.getUid());
    }

    boolean assertCallerCanReparentListener(IBinder clientToken, boolean callerCanManageAppTokens, int callingUid, int displayId) {
        if (assertCallerCanModifyListener(clientToken, callerCanManageAppTokens, callingUid) == true) goto L5;
        return false;
    L5:
        WindowContainer<?> container = getContainer(clientToken);
        if (container != null) goto L8;
        return true;
    L8:
        if (container.getDisplayContent() != null) goto L10;
        return true;
    L10:
        if (container.getDisplayContent().mDisplayId == displayId) goto L12;
        return true;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L14;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 3507911435099713868L, 0, null);
    L14:
        return false;
    }

    boolean hasListener(IBinder clientToken) {
        return this.mListeners.containsKey(clientToken);
    }

    int getWindowType(IBinder clientToken) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L7;
        return -1;
    L7:
        return WindowContextListenerImpl.m10399$$Nest$fgetmType(listener);
    }

    Bundle getOptions(IBinder clientToken) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L7;
        return null;
    L7:
        return WindowContextListenerImpl.m10398$$Nest$fgetmOptions(listener);
    }

    WindowContainer<?> getContainer(IBinder clientToken) {
        WindowContextListenerImpl listener = this.mListeners.get(clientToken);
        if (listener != null) goto L7;
        return null;
    L7:
        return WindowContextListenerImpl.m10395$$Nest$fgetmContainer(listener);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("WindowContextListenerController{");
        builder.append("mListeners=[");
        int size = this.mListeners.values().size();
        int i = 0;
    L3:
        if (i >= size) goto L8;
        builder.append(this.mListeners.valueAt(i));
        if (i == (size - 1)) goto L7;
        builder.append(", ");
    L7:
        i = i + 1;
        goto L3
    L8:
        builder.append("]}");
        return builder.toString();
    }
}
