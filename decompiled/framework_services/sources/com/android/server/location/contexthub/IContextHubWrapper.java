package com.android.server.location.contexthub;

import android.hardware.contexthub.ContextHubMessage;
import android.hardware.contexthub.EndpointInfo;
import android.hardware.contexthub.HostEndpointInfo;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.IContextHub;
import android.hardware.contexthub.IContextHubCallback;
import android.hardware.contexthub.IEndpointCallback;
import android.hardware.contexthub.IEndpointCommunication;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.hardware.contexthub.NanSessionRequest;
import android.hardware.contexthub.NanoappBinary;
import android.hardware.contexthub.NanoappInfo;
import android.hardware.contexthub.V1_0.ContextHub;
import android.hardware.contexthub.V1_0.ContextHubMsg;
import android.hardware.contexthub.V1_0.HubAppInfo;
import android.hardware.contexthub.V1_0.IContexthub;
import android.hardware.contexthub.V1_2.IContexthubCallback;
import android.hardware.location.ContextHubInfo;
import android.hardware.location.HubInfo;
import android.hardware.location.NanoAppBinary;
import android.hardware.location.NanoAppMessage;
import android.hardware.location.NanoAppState;
import android.hardware.location.VendorHubInfo;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IContextHubWrapper {
    private static final boolean DEBUG = false;
    private static final String TAG = "IContextHubWrapper";

    private static class ContextHubWrapperAidl extends IContextHubWrapper implements IBinder.DeathRecipient {
        private final Map<Integer, ContextHubAidlCallback> mAidlCallbackMap;
        private Runnable mHandleServiceRestartCallback;
        private Handler mHandler;
        private final HandlerThread mHandlerThread;
        private IContextHub mHub;
        private final AtomicBoolean mIsTestModeEnabled;
        private final ContextHubTestModeManager mTestModeManager;

        private class ContextHubAidlCallback extends IContextHubCallback.Stub {
            private static final String NAME = "ContextHubService";
            private static final byte[] UUID = null;
            private final ICallback mCallback;
            private final int mContextHubId;
            final /* synthetic */ ContextHubWrapperAidl this$0;

            public static /* synthetic */ void $r8$lambda$73t3WS8YfVk6BW0zU3MPErwk2sU(ContextHubAidlCallback r0, ContextHubMessage r1, String[] r2) {
                r0.lambda$handleContextHubMessage$1(r1, r2);
            }

            public static /* synthetic */ void $r8$lambda$NvAqqMQbA5xzmq91teuPL1jmJfA(ContextHubAidlCallback r0, MessageDeliveryStatus r1) {
                r0.lambda$handleMessageDeliveryStatus$4(r1);
            }

            /* JADX INFO: renamed from: $r8$lambda$f9eTrARptjIBdcEUkMdhZ-iDB9U, reason: not valid java name */
            public static /* synthetic */ void m5207$r8$lambda$f9eTrARptjIBdcEUkMdhZiDB9U(ContextHubAidlCallback r0, int r1, boolean r2) {
                r0.lambda$handleTransactionResult$3(r1, r2);
            }

            public static /* synthetic */ void $r8$lambda$hrYSC_xKcGsK1WsvqlKFNelyQUI(ContextHubAidlCallback r0, List r1) {
                r0.lambda$handleNanoappInfo$0(r1);
            }

            public static /* synthetic */ void $r8$lambda$z2BZDuisaXWLrWzsCAjY65E1FjQ(ContextHubAidlCallback r0, int r1) {
                r0.lambda$handleContextHubAsyncEvent$2(r1);
            }

            static {
                UUID = new byte[]{-102, ParameterName.COLOR_TEMPERATURE, 0, -115, 107, -15, ParameterName.COLOR_TUNER_SATURATION_CYAN, ParameterName.DOLBY_AUDIO_PROCESSING, -112, ParameterName.DE_CONTOUR, 109, 33, -67, -104, ParameterName.DOLBY_DIALOGUE_ENHANCER, 108};
            }

            ContextHubAidlCallback(ContextHubWrapperAidl r1, int contextHubId, ICallback callback) {
                this.this$0 = r1;
                this.mContextHubId = contextHubId;
                this.mCallback = callback;
            }

            public void handleNanoappInfo(NanoappInfo[] appInfo) {
                final List<NanoAppState> nanoAppStateList = ContextHubServiceUtil.createNanoAppStateList(appInfo);
                ContextHubWrapperAidl.m5206$$Nest$fgetmHandler(this.this$0).post(new IContextHubWrapper$ContextHubWrapperAidl$ContextHubAidlCallback$$ExternalSyntheticLambda0(this, nanoAppStateList));
            }

            private /* synthetic */ void lambda$handleNanoappInfo$0(List nanoAppStateList) {
                this.mCallback.handleNanoappInfo(nanoAppStateList);
            }

            public void handleContextHubMessage(final ContextHubMessage msg, final String[] msgContentPerms) {
                ContextHubWrapperAidl.m5206$$Nest$fgetmHandler(this.this$0).post(new IContextHubWrapper$ContextHubWrapperAidl$ContextHubAidlCallback$$ExternalSyntheticLambda3(this, msg, msgContentPerms));
            }

            private /* synthetic */ void lambda$handleContextHubMessage$1(ContextHubMessage msg, String[] msgContentPerms) {
                this.mCallback.handleNanoappMessage((short) msg.hostEndPoint, ContextHubServiceUtil.createNanoAppMessage(msg), new ArrayList(Arrays.asList(msg.permissions)), new ArrayList(Arrays.asList(msgContentPerms)));
            }

            public void handleContextHubAsyncEvent(final int evt) {
                ContextHubWrapperAidl.m5206$$Nest$fgetmHandler(this.this$0).post(new IContextHubWrapper$ContextHubWrapperAidl$ContextHubAidlCallback$$ExternalSyntheticLambda1(this, evt));
            }

            private /* synthetic */ void lambda$handleContextHubAsyncEvent$2(int evt) {
                this.mCallback.handleContextHubEvent(ContextHubServiceUtil.toContextHubEventFromAidl(evt));
            }

            public void handleTransactionResult(final int transactionId, final boolean success) {
                ContextHubWrapperAidl.m5206$$Nest$fgetmHandler(this.this$0).post(new IContextHubWrapper$ContextHubWrapperAidl$ContextHubAidlCallback$$ExternalSyntheticLambda2(this, transactionId, success));
            }

            private /* synthetic */ void lambda$handleTransactionResult$3(int transactionId, boolean success) {
                this.mCallback.handleTransactionResult(transactionId, success);
            }

            public void handleNanSessionRequest(NanSessionRequest request) {
            }

            public void handleMessageDeliveryStatus(char hostEndpointId, final MessageDeliveryStatus messageDeliveryStatus) {
                ContextHubWrapperAidl.m5206$$Nest$fgetmHandler(this.this$0).post(new IContextHubWrapper$ContextHubWrapperAidl$ContextHubAidlCallback$$ExternalSyntheticLambda4(this, messageDeliveryStatus));
            }

            private /* synthetic */ void lambda$handleMessageDeliveryStatus$4(MessageDeliveryStatus messageDeliveryStatus) {
                this.mCallback.handleMessageDeliveryStatus(messageDeliveryStatus);
            }

            public byte[] getUuid() {
                return UUID;
            }

            public String getName() {
                return NAME;
            }

            public String getInterfaceHash() {
                return "df80fdbb6f95a8a2988bc72b7f08f891847b80eb";
            }

            public int getInterfaceVersion() {
                return 4;
            }
        }

        public static /* synthetic */ Integer $r8$lambda$h6pTAwG0BsRGY9ERgLU9iNq6cc4(short r0, NanoAppMessage r1, IContextHub r2, int r3) {
            return lambda$sendMessageToContextHub$0(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ Handler m5206$$Nest$fgetmHandler(ContextHubWrapperAidl r0) {
            return r0.mHandler;
        }

        ContextHubWrapperAidl(IContextHub hub) {
            this.mAidlCallbackMap = new HashMap();
            this.mHandleServiceRestartCallback = null;
            this.mHandlerThread = new HandlerThread("Context Hub AIDL callback", 10);
            this.mIsTestModeEnabled = new AtomicBoolean(false);
            this.mTestModeManager = new ContextHubTestModeManager();
            setHub(hub);
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
            linkWrapperToHubDeath();
        }

        private synchronized IContextHub getHub() {
            monitor-enter(this);
            IContextHub r0 = this.mHub;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized void setHub(IContextHub hub) {
            monitor-enter(this);
            this.mHub = hub;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.i(IContextHubWrapper.TAG, "Context Hub AIDL HAL died");
            setHub(IContextHubWrapper.maybeConnectToAidlGetProxy());
            if (getHub() != null) goto L6;
            Log.e(IContextHubWrapper.TAG, "Could not reconnect to Context Hub AIDL HAL");
            return;
        L6:
            linkWrapperToHubDeath();
            if (this.mHandleServiceRestartCallback == null) goto L9;
            this.mHandleServiceRestartCallback.run();
        L10:
            this.mIsTestModeEnabled.set(false);
            return;
        L9:
            Log.e(IContextHubWrapper.TAG, "mHandleServiceRestartCallback is not set");
            goto L10
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public Pair<List<ContextHubInfo>, List<String>> getContextHubs() throws RemoteException {
            IContextHub hub = getHub();
            if (hub == null) goto L5;
            Set<String> supportedPermissions = new HashSet();
            ArrayList<ContextHubInfo> hubInfoList = new ArrayList();
            Iterator r3 = hub.getContextHubs().iterator();
        L8:
            if (r3.hasNext() == false) goto L15;
            android.hardware.contexthub.ContextHubInfo hubInfo = (android.hardware.contexthub.ContextHubInfo) r3.next();
            hubInfoList.add(new ContextHubInfo(hubInfo));
            String[] r5 = hubInfo.supportedPermissions;
            int r6 = r5.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L8;
            String permission = r5[r7];
            supportedPermissions.add(permission);
            r7 = r7 + 1;
            goto L11
        L15:
            return new Pair(hubInfoList, new ArrayList(supportedPermissions));
        L5:
            return new Pair(new ArrayList(), new ArrayList());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public List<HubInfo> getHubs() throws RemoteException {
            IContextHub hub = getHub();
            if (hub == null) goto L5;
            List<HubInfo> retVal = new ArrayList();
            List<android.hardware.contexthub.HubInfo> halHubs = hub.getHubs();
            Iterator<android.hardware.contexthub.HubInfo> r3 = halHubs.iterator();
        L8:
            if (r3.hasNext() == false) goto L15;
            android.hardware.contexthub.HubInfo halHub = r3.next();
            switch(halHub.hubDetails.getTag()) {
                case 0: goto L13;
                case 1: goto L12;
                default: goto L11;
            };
        L12:
            VendorHubInfo vendorHubInfo = new VendorHubInfo(halHub.hubDetails.getVendorHubInfo());
            HubInfo hubInfo = new HubInfo(halHub.hubId, vendorHubInfo);
        L14:
            retVal.add(hubInfo);
            goto L8
        L13:
            ContextHubInfo contextHubInfo = new ContextHubInfo(halHub.hubDetails.getContextHubInfo());
            hubInfo = new HubInfo(halHub.hubId, contextHubInfo);
            goto L14
        L11:
            Log.w(IContextHubWrapper.TAG, "getHubs: invalid hub: " + halHub);
            goto L8
        L15:
            return retVal;
        L5:
            return Collections.emptyList();
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public List<HubEndpointInfo> getEndpoints() throws RemoteException {
            IContextHub hub = getHub();
            if (hub == null) goto L5;
            List<HubEndpointInfo> retVal = new ArrayList();
            List<EndpointInfo> halEndpointInfos = hub.getEndpoints();
            Iterator<EndpointInfo> r3 = halEndpointInfos.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            EndpointInfo halEndpointInfo = r3.next();
            HubEndpointInfo endpointInfo = new HubEndpointInfo(halEndpointInfo);
            retVal.add(endpointInfo);
            goto L8
        L10:
            return retVal;
        L5:
            return Collections.emptyList();
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public IEndpointCommunication registerEndpointHub(IEndpointCallback cb, android.hardware.contexthub.HubInfo hubInfo) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L7;
            return null;
        L7:
            return hub.registerEndpointHub(cb, hubInfo);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsLocationSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsWifiSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsAirplaneModeSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsMicrophoneSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsBtSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onLocationSettingChanged(boolean enabled) {
            onSettingChanged((byte) 1, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onAirplaneModeSettingChanged(boolean enabled) {
            onSettingChanged((byte) 4, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onMicrophoneSettingChanged(boolean enabled) {
            onSettingChanged((byte) 5, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiMainSettingChanged(boolean enabled) {
            onSettingChanged((byte) 2, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiScanningSettingChanged(boolean enabled) {
            onSettingChanged((byte) 3, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onBtMainSettingChanged(boolean enabled) {
            onSettingChanged((byte) 6, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onBtScanningSettingChanged(boolean enabled) {
            onSettingChanged((byte) 7, enabled);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onHostEndpointConnected(HostEndpointInfo info) {
            IContextHub hub = getHub();
            if (hub != null) goto L10;
            return;
        L10:
            hub.onHostEndpointConnected(info);     // Catch: Throwable -> L7
            return;
        L7:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Exception in onHostEndpointConnected" + e.getMessage());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onHostEndpointDisconnected(short hostEndpointId) {
            IContextHub hub = getHub();
            if (hub != null) goto L11;
            return;
        L11:
            hub.onHostEndpointDisconnected((char) hostEndpointId);     // Catch: Throwable -> L8
            return;
        L8:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Exception in onHostEndpointDisconnected" + e.getMessage());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int sendMessageToContextHub(final short hostEndpointId, final int contextHubId, final NanoAppMessage message) {
            final IContextHub hub = getHub();
            if (hub != null) goto L6;
            return 2;
        L6:
            Callable<Integer> sendMessage = new IContextHubWrapper$ContextHubWrapperAidl$$ExternalSyntheticLambda0(hostEndpointId, message, hub, contextHubId);
            if (0 != 0) goto L9;
        L17:
            return sendMessage.call().intValue();
        L15:
            return 1;
        L9:
            if (this.mTestModeManager.sendMessageToContextHub(sendMessage, message) == false) goto L17;
            return 0;
        }

        private static /* synthetic */ Integer lambda$sendMessageToContextHub$0(short hostEndpointId, NanoAppMessage message, IContextHub hub, int contextHubId) throws Exception {
            ContextHubMessage msg = ContextHubServiceUtil.createAidlContextHubMessage(hostEndpointId, message);     // Catch: IllegalArgumentException -> L4 Throwable -> L6
            hub.sendMessageToHub(contextHubId, msg);     // Catch: IllegalArgumentException -> L4 Throwable -> L6
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int sendMessageDeliveryStatusToContextHub(int contextHubId, MessageDeliveryStatus status) {
            IContextHub hub = getHub();
            if (hub != null) goto L13;
            return 2;
        L13:
            hub.sendMessageDeliveryStatusToHub(contextHubId, status);     // Catch: IllegalArgumentException -> L8 Throwable -> L10
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int loadNanoapp(int contextHubId, NanoAppBinary binary, int transactionId) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L5;
            return 2;
        L5:
            NanoappBinary aidlNanoAppBinary = ContextHubServiceUtil.createAidlNanoAppBinary(binary);
            hub.loadNanoapp(contextHubId, aidlNanoAppBinary, transactionId);     // Catch: IllegalArgumentException -> L9 Throwable -> L11
            return 0;
        L12:
            return 1;
        L10:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int unloadNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L13;
            return 2;
        L13:
            hub.unloadNanoapp(contextHubId, nanoappId, transactionId);     // Catch: IllegalArgumentException -> L8 Throwable -> L10
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int enableNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L13;
            return 2;
        L13:
            hub.enableNanoapp(contextHubId, nanoappId, transactionId);     // Catch: IllegalArgumentException -> L8 Throwable -> L10
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int disableNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L13;
            return 2;
        L13:
            hub.disableNanoapp(contextHubId, nanoappId, transactionId);     // Catch: IllegalArgumentException -> L8 Throwable -> L10
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int queryNanoapps(int contextHubId) throws RemoteException {
            IContextHub hub = getHub();
            if (hub != null) goto L13;
            return 2;
        L13:
            hub.queryNanoapps(contextHubId);     // Catch: IllegalArgumentException -> L8 Throwable -> L10
            return 0;
        L11:
            return 1;
        L9:
            return 2;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public long[] getPreloadedNanoappIds(int contextHubId) {
            IContextHub hub = getHub();
            if (hub != null) goto L10;
            return null;
        L10:
            return hub.getPreloadedNanoappIds(contextHubId);
        L7:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Exception while getting preloaded nanoapp IDs: " + e.getMessage());
            return null;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void registerExistingCallback(int contextHubId) {
            IContextHub hub = getHub();
            if (hub != null) goto L5;
            return;
        L5:
            ContextHubAidlCallback callback = this.mAidlCallbackMap.get(Integer.valueOf(contextHubId));
            if (callback != null) goto L14;
            Log.e(IContextHubWrapper.TAG, "Could not find existing callback to register for context hub ID = " + contextHubId);
            return;
        L14:
            hub.registerCallback(contextHubId, callback);     // Catch: Throwable -> L11
            return;
        L11:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Exception while registering callback: " + e.getMessage());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void registerCallback(int contextHubId, final ICallback callback) {
            IContextHub hub = getHub();
            if (hub != null) goto L5;
            return;
        L5:
            callback.getClass();
            this.mHandleServiceRestartCallback = new IContextHubWrapper$ContextHubWrapperAidl$$ExternalSyntheticLambda1(callback);
            this.mAidlCallbackMap.put(Integer.valueOf(contextHubId), new ContextHubAidlCallback(this, contextHubId, callback));
            registerExistingCallback(contextHubId);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean setTestMode(boolean enable) {
            IContextHub hub = getHub();
            if (hub != null) goto L5;
            return false;
        L5:
            this.mIsTestModeEnabled.set(enable);
            hub.setTestMode(enable);     // Catch: Throwable -> L9
            return true;
        L9:
            e = move-exception;
            StringBuilder r3 = new StringBuilder();
            r3.append("Exception while setting test mode (enable: ");
            if (enable == false) goto L13;
            String r4 = "true";
        L14:
            r3.append(r4);
            r3.append("): ");
            r3.append(e.getMessage());
            Log.e(IContextHubWrapper.TAG, r3.toString());
            return false;
        L13:
            r4 = "false";
            goto L14
        }

        private void onSettingChanged(byte setting, boolean enabled) {
            IContextHub hub = getHub();
            if (hub != null) goto L10;
            return;
        L10:
            hub.onSettingChanged(setting, enabled);     // Catch: Throwable -> L7
            return;
        L7:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Exception while sending setting update: " + e.getMessage());
        }

        private void linkWrapperToHubDeath() {
            IContextHub hub = getHub();
            if (hub != null) goto L10;
            return;
        L10:
            hub.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L7
            return;
        L8:
            Log.e(IContextHubWrapper.TAG, "Context Hub AIDL service death receipt could not be linked");
        }
    }

    private static abstract class ContextHubWrapperHidl extends IContextHubWrapper {
        protected ICallback mCallback;
        protected final Map<Integer, ContextHubWrapperHidlCallback> mHidlCallbackMap;
        private IContexthub mHub;

        protected class ContextHubWrapperHidlCallback extends IContexthubCallback.Stub {
            private final ICallback mCallback;
            private final int mContextHubId;

            ContextHubWrapperHidlCallback(ContextHubWrapperHidl this$0, int contextHubId, ICallback callback) {
                this.mContextHubId = contextHubId;
                this.mCallback = callback;
            }

            public void handleClientMsg(ContextHubMsg message) {
                this.mCallback.handleNanoappMessage(message.hostEndPoint, ContextHubServiceUtil.createNanoAppMessage(message), Collections.emptyList(), Collections.emptyList());
            }

            public void handleTxnResult(int transactionId, int result) {
                ICallback r0 = this.mCallback;
                if (result != 0) goto L5;
                boolean r1 = true;
            L6:
                r0.handleTransactionResult(transactionId, r1);
                return;
            L5:
                r1 = false;
                goto L6
            }

            public void handleHubEvent(int eventType) {
                this.mCallback.handleContextHubEvent(ContextHubServiceUtil.toContextHubEvent(eventType));
            }

            public void handleAppAbort(long nanoAppId, int abortCode) {
                this.mCallback.handleNanoappAbort(nanoAppId, abortCode);
            }

            public void handleAppsInfo(ArrayList<HubAppInfo> nanoAppInfoList) {
                handleAppsInfo_1_2(ContextHubServiceUtil.toHubAppInfo_1_2(nanoAppInfoList));
            }

            public void handleClientMsg_1_2(android.hardware.contexthub.V1_2.ContextHubMsg message, ArrayList<String> messagePermissions) {
                this.mCallback.handleNanoappMessage(message.msg_1_0.hostEndPoint, ContextHubServiceUtil.createNanoAppMessage(message.msg_1_0), message.permissions, messagePermissions);
            }

            public void handleAppsInfo_1_2(ArrayList<android.hardware.contexthub.V1_2.HubAppInfo> nanoAppInfoList) {
                List<NanoAppState> nanoAppStateList = ContextHubServiceUtil.createNanoAppStateList(nanoAppInfoList);
                this.mCallback.handleNanoappInfo(nanoAppStateList);
            }
        }

        ContextHubWrapperHidl(IContexthub hub) {
            this.mCallback = null;
            this.mHidlCallbackMap = new HashMap();
            this.mHub = hub;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int sendMessageToContextHub(short hostEndpointId, int contextHubId, NanoAppMessage message) throws RemoteException {
            if (message.isReliable() == false) goto L6;
            Log.e(IContextHubWrapper.TAG, "Reliable messages are only supported with the AIDL HAL");
            return 2;
        L6:
            ContextHubMsg messageToNanoApp = ContextHubServiceUtil.createHidlContextHubMessage(hostEndpointId, message);
            return ContextHubServiceUtil.toTransactionResult(this.mHub.sendMessageToHub(contextHubId, messageToNanoApp));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int sendMessageDeliveryStatusToContextHub(int contextHubId, MessageDeliveryStatus status) {
            return 9;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int loadNanoapp(int contextHubId, NanoAppBinary binary, int transactionId) throws RemoteException {
            android.hardware.contexthub.V1_0.NanoAppBinary hidlNanoAppBinary = ContextHubServiceUtil.createHidlNanoAppBinary(binary);
            return ContextHubServiceUtil.toTransactionResult(this.mHub.loadNanoApp(contextHubId, hidlNanoAppBinary, transactionId));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int unloadNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            return ContextHubServiceUtil.toTransactionResult(this.mHub.unloadNanoApp(contextHubId, nanoappId, transactionId));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int enableNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            return ContextHubServiceUtil.toTransactionResult(this.mHub.enableNanoApp(contextHubId, nanoappId, transactionId));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int disableNanoapp(int contextHubId, long nanoappId, int transactionId) throws RemoteException {
            return ContextHubServiceUtil.toTransactionResult(this.mHub.disableNanoApp(contextHubId, nanoappId, transactionId));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public int queryNanoapps(int contextHubId) throws RemoteException {
            return ContextHubServiceUtil.toTransactionResult(this.mHub.queryApps(contextHubId));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public long[] getPreloadedNanoappIds(int contextHubId) {
            return new long[0];
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void registerCallback(int contextHubId, ICallback callback) throws RemoteException {
            this.mHidlCallbackMap.put(Integer.valueOf(contextHubId), new ContextHubWrapperHidlCallback(this, contextHubId, callback));
            this.mHub.registerCallback(contextHubId, this.mHidlCallbackMap.get(Integer.valueOf(contextHubId)));
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void registerExistingCallback(int contextHubId) throws RemoteException {
            ContextHubWrapperHidlCallback callback = this.mHidlCallbackMap.get(Integer.valueOf(contextHubId));
            if (callback != null) goto L6;
            Log.e(IContextHubWrapper.TAG, "Could not find existing callback for context hub with ID = " + contextHubId);
            return;
        L6:
            this.mHub.registerCallback(contextHubId, callback);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean setTestMode(boolean enable) {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsBtSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiMainSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiScanningSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onBtMainSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onBtScanningSettingChanged(boolean enabled) {
        }
    }

    private static class ContextHubWrapperV1_0 extends ContextHubWrapperHidl {
        private IContexthub mHub;

        ContextHubWrapperV1_0(IContexthub hub) {
            super(hub);
            this.mHub = hub;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public Pair<List<ContextHubInfo>, List<String>> getContextHubs() throws RemoteException {
            ArrayList<ContextHubInfo> hubInfoList = new ArrayList();
            Iterator r1 = this.mHub.getHubs().iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            ContextHub hub = (ContextHub) r1.next();
            hubInfoList.add(new ContextHubInfo(hub));
            goto L4
        L7:
            return new Pair(hubInfoList, new ArrayList());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsLocationSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsWifiSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsAirplaneModeSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsMicrophoneSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onLocationSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onAirplaneModeSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onMicrophoneSettingChanged(boolean enabled) {
        }
    }

    private static class ContextHubWrapperV1_1 extends ContextHubWrapperHidl {
        private android.hardware.contexthub.V1_1.IContexthub mHub;

        ContextHubWrapperV1_1(android.hardware.contexthub.V1_1.IContexthub hub) {
            super(hub);
            this.mHub = hub;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public Pair<List<ContextHubInfo>, List<String>> getContextHubs() throws RemoteException {
            ArrayList<ContextHubInfo> hubInfoList = new ArrayList();
            Iterator r1 = this.mHub.getHubs().iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            ContextHub hub = (ContextHub) r1.next();
            hubInfoList.add(new ContextHubInfo(hub));
            goto L4
        L7:
            return new Pair(hubInfoList, new ArrayList());
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsLocationSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsWifiSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsAirplaneModeSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsMicrophoneSettingNotifications() {
            return false;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onLocationSettingChanged(boolean enabled) {
            android.hardware.contexthub.V1_1.IContexthub r0 = this.mHub;     // Catch: RemoteException -> L8
            if (enabled == false) goto L5;
            byte r2 = 1;
        L6:
            r0.onSettingChanged((byte) 0, r2);     // Catch: RemoteException -> L8
            return;
        L5:
            r2 = 0;
        L8:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Failed to send setting change to Contexthub", e);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onAirplaneModeSettingChanged(boolean enabled) {
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onMicrophoneSettingChanged(boolean enabled) {
        }
    }

    private static class ContextHubWrapperV1_2 extends ContextHubWrapperHidl implements android.hardware.contexthub.V1_2.IContexthub.getHubs_1_2Callback {
        private final android.hardware.contexthub.V1_2.IContexthub mHub;
        private Pair<List<ContextHubInfo>, List<String>> mHubInfo;

        ContextHubWrapperV1_2(android.hardware.contexthub.V1_2.IContexthub hub) {
            super(hub);
            this.mHubInfo = new Pair(Collections.emptyList(), Collections.emptyList());
            this.mHub = hub;
        }

        public void onValues(ArrayList<ContextHub> hubs, ArrayList<String> supportedPermissions) {
            ArrayList<ContextHubInfo> hubInfoList = new ArrayList();
            Iterator<ContextHub> r1 = hubs.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ContextHub hub = r1.next();
            hubInfoList.add(new ContextHubInfo(hub));
            goto L4
        L6:
            this.mHubInfo = new Pair(hubInfoList, supportedPermissions);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public Pair<List<ContextHubInfo>, List<String>> getContextHubs() throws RemoteException {
            this.mHub.getHubs_1_2(this);
            return this.mHubInfo;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsLocationSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsWifiSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsAirplaneModeSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public boolean supportsMicrophoneSettingNotifications() {
            return true;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onLocationSettingChanged(boolean r2) {
            sendSettingChanged((byte) 0, r2 ? 1 : 0);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onWifiSettingChanged(boolean r2) {
            sendSettingChanged((byte) 1, r2 ? 1 : 0);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onAirplaneModeSettingChanged(boolean r2) {
            sendSettingChanged((byte) 2, r2 ? 1 : 0);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper
        public void onMicrophoneSettingChanged(boolean r2) {
            sendSettingChanged((byte) 3, r2 ? 1 : 0);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ContextHubWrapperHidl, com.android.server.location.contexthub.IContextHubWrapper
        public void registerCallback(int contextHubId, ICallback callback) throws RemoteException {
            this.mHidlCallbackMap.put(Integer.valueOf(contextHubId), new ContextHubWrapperHidl.ContextHubWrapperHidlCallback(this, contextHubId, callback));
            this.mHub.registerCallback_1_2(contextHubId, this.mHidlCallbackMap.get(Integer.valueOf(contextHubId)));
        }

        private void sendSettingChanged(byte setting, byte newValue) {
            this.mHub.onSettingChanged_1_2(setting, newValue);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(IContextHubWrapper.TAG, "Failed to send setting change to Contexthub", e);
        }
    }

    public interface ICallback {
        void handleContextHubEvent(int r1);

        void handleMessageDeliveryStatus(MessageDeliveryStatus r1);

        void handleNanoappAbort(long r1, int r3);

        void handleNanoappInfo(List<NanoAppState> r1);

        void handleNanoappMessage(short r1, NanoAppMessage r2, List<String> r3, List<String> r4);

        void handleServiceRestart();

        void handleTransactionResult(int r1, boolean r2);
    }

    public abstract int disableNanoapp(int r1, long r2, int r4) throws RemoteException;

    public abstract int enableNanoapp(int r1, long r2, int r4) throws RemoteException;

    public abstract Pair<List<ContextHubInfo>, List<String>> getContextHubs() throws RemoteException;

    public abstract long[] getPreloadedNanoappIds(int r1);

    public abstract int loadNanoapp(int r1, NanoAppBinary r2, int r3) throws RemoteException;

    public abstract void onAirplaneModeSettingChanged(boolean r1);

    public abstract void onBtMainSettingChanged(boolean r1);

    public abstract void onBtScanningSettingChanged(boolean r1);

    public abstract void onLocationSettingChanged(boolean r1);

    public abstract void onMicrophoneSettingChanged(boolean r1);

    public abstract void onWifiMainSettingChanged(boolean r1);

    public abstract void onWifiScanningSettingChanged(boolean r1);

    public abstract void onWifiSettingChanged(boolean r1);

    public abstract int queryNanoapps(int r1) throws RemoteException;

    public abstract void registerCallback(int r1, ICallback r2) throws RemoteException;

    public abstract void registerExistingCallback(int r1) throws RemoteException;

    public abstract int sendMessageDeliveryStatusToContextHub(int r1, MessageDeliveryStatus r2);

    public abstract int sendMessageToContextHub(short r1, int r2, NanoAppMessage r3) throws RemoteException;

    public abstract boolean setTestMode(boolean r1);

    public abstract boolean supportsAirplaneModeSettingNotifications();

    public abstract boolean supportsBtSettingNotifications();

    public abstract boolean supportsLocationSettingNotifications();

    public abstract boolean supportsMicrophoneSettingNotifications();

    public abstract boolean supportsWifiSettingNotifications();

    public abstract int unloadNanoapp(int r1, long r2, int r4) throws RemoteException;

    public IContextHubWrapper() {
    }

    public static IContextHubWrapper getContextHubWrapper() {
        IContextHubWrapper wrapper = maybeConnectToAidl();
        if (wrapper != null) goto L5;
        wrapper = maybeConnectTo1_2();
    L5:
        if (wrapper != null) goto L7;
        wrapper = maybeConnectTo1_1();
    L7:
        if (wrapper == null) goto L9;
        return wrapper;
    L9:
        return maybeConnectTo1_0();
    }

    public static IContextHubWrapper maybeConnectTo1_0() {
        IContexthub proxy = null;
        proxy = IContexthub.getService(true);     // Catch: NoSuchElementException -> L6 RemoteException -> L8
    L10:
        if (proxy != null) goto L13;
        return null;
    L13:
        return new ContextHubWrapperV1_0(proxy);
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while attaching to Context Hub HAL proxy", e);
    L7:
        Log.i(TAG, "Context Hub HAL service not found");
        goto L10
    }

    public static IContextHubWrapper maybeConnectTo1_1() {
        android.hardware.contexthub.V1_1.IContexthub proxy = null;
        proxy = android.hardware.contexthub.V1_1.IContexthub.getService(true);     // Catch: NoSuchElementException -> L6 RemoteException -> L8
    L10:
        if (proxy != null) goto L13;
        return null;
    L13:
        return new ContextHubWrapperV1_1(proxy);
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while attaching to Context Hub HAL proxy", e);
    L7:
        Log.i(TAG, "Context Hub HAL service not found");
        goto L10
    }

    public static IContextHubWrapper maybeConnectTo1_2() {
        android.hardware.contexthub.V1_2.IContexthub proxy = null;
        proxy = android.hardware.contexthub.V1_2.IContexthub.getService(true);     // Catch: NoSuchElementException -> L6 RemoteException -> L8
    L10:
        if (proxy != null) goto L13;
        return null;
    L13:
        return new ContextHubWrapperV1_2(proxy);
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while attaching to Context Hub HAL proxy", e);
    L7:
        Log.i(TAG, "Context Hub HAL service not found");
        goto L10
    }

    public static IContextHub maybeConnectToAidlGetProxy() {
        IContextHub proxy = null;
        String aidlServiceName = IContextHub.class.getCanonicalName() + "/default";
        if (ServiceManager.isDeclared(aidlServiceName) == false) goto L7;
        proxy = IContextHub.Stub.asInterface(ServiceManager.waitForService(aidlServiceName));
        if (proxy != null) goto L8;
        Log.e(TAG, "Context Hub AIDL service was declared but was not found");
    L8:
        return proxy;
    L7:
        Log.d(TAG, "Context Hub AIDL service is not declared");
        goto L8
    }

    public static IContextHubWrapper maybeConnectToAidl() {
        IContextHub proxy = maybeConnectToAidlGetProxy();
        if (proxy != null) goto L6;
        return null;
    L6:
        return new ContextHubWrapperAidl(proxy);
    }

    public List<HubInfo> getHubs() throws RemoteException {
        return Collections.emptyList();
    }

    public List<HubEndpointInfo> getEndpoints() throws RemoteException {
        return Collections.emptyList();
    }

    public IEndpointCommunication registerEndpointHub(IEndpointCallback cb, android.hardware.contexthub.HubInfo hubInfo) throws RemoteException {
        throw new UnsupportedOperationException();
    }

    public void onHostEndpointConnected(HostEndpointInfo info) {
    }

    public void onHostEndpointDisconnected(short hostEndpointId) {
    }
}
