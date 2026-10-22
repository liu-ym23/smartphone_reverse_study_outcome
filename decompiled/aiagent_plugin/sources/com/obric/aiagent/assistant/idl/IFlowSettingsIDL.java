package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowSettingsIDL extends IInterface {
    public static final String AUTHENTICATION_TYPE_SCENE_AUTO_GUI_EXECUTE = "AutoGuiExecute";
    public static final String AUTHENTICATION_TYPE_SCENE_CHAT_AND_ONLINE_QA = "ChatAndOnlineQA";
    public static final String AUTHENTICATION_TYPE_SCENE_CHAT_HISTORY_ACCESS = "ChatHistoryAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_GLOBAL_MEMORY_ACCESS = "GlobalMemoryAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS = "LocalAppDataAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE = "SimpleCommandExecute";

    public static class Default implements IFlowSettingsIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getAuthenticationTypeOnLockScreen(String r1) {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public Map getAutoExecuteAuthorizationStatusMap() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getAutoGuiEnabledScene() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getAutoGuiFastModeUseSettings() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getAutoImageUploadEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public FeatureConfigMap getFeatureConfigMap() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getIntentAuthStatus(String r1) {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getIntentUploadStrategyForDebug() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getOAutoUseClipboardEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getOUseMemoryEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getObricCloudConfig(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public OComplexTaskConfig getObricComplexTaskConfig() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getObricFlowSettingsJson(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public OModelConfig getObricModelConfig() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getObricPowerLockTimeoutInSeconds() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getPersonalContextEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getSemanticeScreenShotEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isLarkKnowledgeAuthorizationEnable() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isLarkSendConfirmEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isTtsPlayBackgroundEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setAutoGuiEnabledScene(int r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setAutoImageUploadEnabled(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setLarkKnowledgeAuthorizationEnabled(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setOUseMemoryEnabled(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setSemanticScreenShotEnabled(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowSettingsIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowSettingsIDL";
        static final int TRANSACTION_getAuthenticationTypeOnLockScreen = 26;
        static final int TRANSACTION_getAutoExecuteAuthorizationStatusMap = 27;
        static final int TRANSACTION_getAutoGuiEnabledScene = 1;
        static final int TRANSACTION_getAutoGuiFastModeUseSettings = 28;
        static final int TRANSACTION_getAutoImageUploadEnabled = 20;
        static final int TRANSACTION_getFeatureConfigMap = 12;
        static final int TRANSACTION_getIntentAuthStatus = 6;
        static final int TRANSACTION_getIntentUploadStrategyForDebug = 7;
        static final int TRANSACTION_getOAutoUseClipboardEnabled = 25;
        static final int TRANSACTION_getOUseMemoryEnabled = 17;
        static final int TRANSACTION_getObricCloudConfig = 15;
        static final int TRANSACTION_getObricComplexTaskConfig = 9;
        static final int TRANSACTION_getObricFlowSettingsJson = 14;
        static final int TRANSACTION_getObricMemoryDataCollectConfig = 13;
        static final int TRANSACTION_getObricModelConfig = 10;
        static final int TRANSACTION_getObricPowerLockTimeoutInSeconds = 8;
        static final int TRANSACTION_getPersonalContextEnabled = 5;
        static final int TRANSACTION_getSemanticeScreenShotEnabled = 3;
        static final int TRANSACTION_isLarkKnowledgeAuthorizationEnable = 18;
        static final int TRANSACTION_isLarkSendConfirmEnabled = 22;
        static final int TRANSACTION_isTtsPlayBackgroundEnabled = 11;
        static final int TRANSACTION_isVoicePrintAuthenticateAutoGuiEnabled = 24;
        static final int TRANSACTION_setAutoGuiEnabledScene = 2;
        static final int TRANSACTION_setAutoImageUploadEnabled = 21;
        static final int TRANSACTION_setLarkKnowledgeAuthorizationEnabled = 19;
        static final int TRANSACTION_setOUseMemoryEnabled = 16;
        static final int TRANSACTION_setSemanticScreenShotEnabled = 4;
        static final int TRANSACTION_setVoicePrintAuthenticateAutoGuiEnabled = 23;

        private static class Proxy implements IFlowSettingsIDL {
            public static IFlowSettingsIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getAutoGuiEnabledScene() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getAutoGuiEnabledScene();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setAutoGuiEnabledScene(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setAutoGuiEnabledScene(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getSemanticeScreenShotEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().getSemanticeScreenShotEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setSemanticScreenShotEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setSemanticScreenShotEnabled(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getPersonalContextEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().getPersonalContextEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getIntentAuthStatus(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getIntentAuthStatus(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getIntentUploadStrategyForDebug() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getIntentUploadStrategyForDebug();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getObricPowerLockTimeoutInSeconds() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getObricPowerLockTimeoutInSeconds();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public OComplexTaskConfig getObricComplexTaskConfig() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                OComplexTaskConfig r4 = (OComplexTaskConfig) ZeusTransformUtils.preCheckCast(OComplexTaskConfig.CREATOR.createFromParcel(r1), OComplexTaskConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OComplexTaskConfig r5 = Stub.getDefaultImpl().getObricComplexTaskConfig();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public OModelConfig getObricModelConfig() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                OModelConfig r4 = (OModelConfig) ZeusTransformUtils.preCheckCast(OModelConfig.CREATOR.createFromParcel(r1), OModelConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OModelConfig r5 = Stub.getDefaultImpl().getObricModelConfig();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isTtsPlayBackgroundEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isTtsPlayBackgroundEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public FeatureConfigMap getFeatureConfigMap() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                FeatureConfigMap r4 = (FeatureConfigMap) ZeusTransformUtils.preCheckCast(FeatureConfigMap.CREATOR.createFromParcel(r1), FeatureConfigMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                FeatureConfigMap r5 = Stub.getDefaultImpl().getFeatureConfigMap();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ObricMemoryDataCollectConfig r4 = (ObricMemoryDataCollectConfig) ZeusTransformUtils.preCheckCast(ObricMemoryDataCollectConfig.CREATOR.createFromParcel(r1), ObricMemoryDataCollectConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ObricMemoryDataCollectConfig r5 = Stub.getDefaultImpl().getObricMemoryDataCollectConfig();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getObricFlowSettingsJson(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r6 = Stub.getDefaultImpl().getObricFlowSettingsJson(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getObricCloudConfig(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r6 = Stub.getDefaultImpl().getObricCloudConfig(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setOUseMemoryEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(16, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setOUseMemoryEnabled(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getOUseMemoryEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().getOUseMemoryEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isLarkKnowledgeAuthorizationEnable() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isLarkKnowledgeAuthorizationEnable();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setLarkKnowledgeAuthorizationEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(19, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setLarkKnowledgeAuthorizationEnabled(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getAutoImageUploadEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().getAutoImageUploadEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setAutoImageUploadEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(21, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAutoImageUploadEnabled(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isLarkSendConfirmEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isLarkSendConfirmEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(23, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setVoicePrintAuthenticateAutoGuiEnabled(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(24, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isVoicePrintAuthenticateAutoGuiEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getOAutoUseClipboardEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(25, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().getOAutoUseClipboardEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getAuthenticationTypeOnLockScreen(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(26, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getAuthenticationTypeOnLockScreen(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public Map getAutoExecuteAuthorizationStatusMap() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(27, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r6 = Stub.getDefaultImpl().getAutoExecuteAuthorizationStatusMap();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getAutoGuiFastModeUseSettings() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(28, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getAutoGuiFastModeUseSettings();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowSettingsIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowSettingsIDL.class) == false) goto L13;
            return (IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L91;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L89;
                case 2: goto L87;
                case 3: goto L85;
                case 4: goto L80;
                case 5: goto L78;
                case 6: goto L76;
                case 7: goto L74;
                case 8: goto L72;
                case 9: goto L67;
                case 10: goto L62;
                case 11: goto L60;
                case 12: goto L55;
                case 13: goto L50;
                case 14: goto L48;
                case 15: goto L46;
                case 16: goto L41;
                case 17: goto L39;
                case 18: goto L37;
                case 19: goto L32;
                case 20: goto L30;
                case 21: goto L25;
                case 22: goto L23;
                case 23: goto L18;
                case 24: goto L16;
                case 25: goto L14;
                case 26: goto L12;
                case 27: goto L10;
                case 28: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            String r3 = getAutoGuiFastModeUseSettings();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            Map r8 = getAutoExecuteAuthorizationStatusMap();
            r6.writeNoException();
            r6.writeMap(r8);
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            int r9 = getAuthenticationTypeOnLockScreen(r5.readString());
            r6.writeNoException();
            r6.writeInt(r9);
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            boolean r10 = getOAutoUseClipboardEnabled();
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            return true;
        L16:
            r5.enforceInterface(DESCRIPTOR);
            boolean r11 = isVoicePrintAuthenticateAutoGuiEnabled();
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L21;
            r0 = true;
        L21:
            setVoicePrintAuthenticateAutoGuiEnabled(r0);
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            boolean r12 = isLarkSendConfirmEnabled();
            r6.writeNoException();
            r6.writeInt(r12 ? 1 : 0);
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L28;
            r0 = true;
        L28:
            setAutoImageUploadEnabled(r0);
            return true;
        L30:
            r5.enforceInterface(DESCRIPTOR);
            boolean r13 = getAutoImageUploadEnabled();
            r6.writeNoException();
            r6.writeInt(r13 ? 1 : 0);
            return true;
        L32:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L35;
            r0 = true;
        L35:
            setLarkKnowledgeAuthorizationEnabled(r0);
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            boolean r14 = isLarkKnowledgeAuthorizationEnable();
            r6.writeNoException();
            r6.writeInt(r14 ? 1 : 0);
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            boolean r15 = getOUseMemoryEnabled();
            r6.writeNoException();
            r6.writeInt(r15 ? 1 : 0);
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L44;
            r0 = true;
        L44:
            setOUseMemoryEnabled(r0);
            return true;
        L46:
            r5.enforceInterface(DESCRIPTOR);
            String r16 = getObricCloudConfig(r5.readString());
            r6.writeNoException();
            r6.writeString(r16);
            return true;
        L48:
            r5.enforceInterface(DESCRIPTOR);
            String r17 = getObricFlowSettingsJson(r5.readString());
            r6.writeNoException();
            r6.writeString(r17);
            return true;
        L50:
            r5.enforceInterface(DESCRIPTOR);
            ObricMemoryDataCollectConfig r18 = getObricMemoryDataCollectConfig();
            r6.writeNoException();
            if (r18 == null) goto L53;
            r6.writeInt(1);
            r18.writeToParcel(r6, 1);
        L54:
            return true;
        L53:
            r6.writeInt(0);
            goto L54
        L55:
            r5.enforceInterface(DESCRIPTOR);
            FeatureConfigMap r19 = getFeatureConfigMap();
            r6.writeNoException();
            if (r19 == null) goto L58;
            r6.writeInt(1);
            r19.writeToParcel(r6, 1);
        L59:
            return true;
        L58:
            r6.writeInt(0);
            goto L59
        L60:
            r5.enforceInterface(DESCRIPTOR);
            boolean r20 = isTtsPlayBackgroundEnabled();
            r6.writeNoException();
            r6.writeInt(r20 ? 1 : 0);
            return true;
        L62:
            r5.enforceInterface(DESCRIPTOR);
            OModelConfig r21 = getObricModelConfig();
            r6.writeNoException();
            if (r21 == null) goto L65;
            r6.writeInt(1);
            r21.writeToParcel(r6, 1);
        L66:
            return true;
        L65:
            r6.writeInt(0);
            goto L66
        L67:
            r5.enforceInterface(DESCRIPTOR);
            OComplexTaskConfig r22 = getObricComplexTaskConfig();
            r6.writeNoException();
            if (r22 == null) goto L70;
            r6.writeInt(1);
            r22.writeToParcel(r6, 1);
        L71:
            return true;
        L70:
            r6.writeInt(0);
            goto L71
        L72:
            r5.enforceInterface(DESCRIPTOR);
            int r23 = getObricPowerLockTimeoutInSeconds();
            r6.writeNoException();
            r6.writeInt(r23);
            return true;
        L74:
            r5.enforceInterface(DESCRIPTOR);
            int r24 = getIntentUploadStrategyForDebug();
            r6.writeNoException();
            r6.writeInt(r24);
            return true;
        L76:
            r5.enforceInterface(DESCRIPTOR);
            int r25 = getIntentAuthStatus(r5.readString());
            r6.writeNoException();
            r6.writeInt(r25);
            return true;
        L78:
            r5.enforceInterface(DESCRIPTOR);
            boolean r26 = getPersonalContextEnabled();
            r6.writeNoException();
            r6.writeInt(r26 ? 1 : 0);
            return true;
        L80:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L83;
            r0 = true;
        L83:
            setSemanticScreenShotEnabled(r0);
            return true;
        L85:
            r5.enforceInterface(DESCRIPTOR);
            boolean r27 = getSemanticeScreenShotEnabled();
            r6.writeNoException();
            r6.writeInt(r27 ? 1 : 0);
            return true;
        L87:
            r5.enforceInterface(DESCRIPTOR);
            setAutoGuiEnabledScene(r5.readInt());
            return true;
        L89:
            r5.enforceInterface(DESCRIPTOR);
            int r28 = getAutoGuiEnabledScene();
            r6.writeNoException();
            r6.writeInt(r28);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L91:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowSettingsIDL r2) {
            IFlowSettingsIDL r3 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowSettingsIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int getAuthenticationTypeOnLockScreen(String r1);

    Map getAutoExecuteAuthorizationStatusMap();

    int getAutoGuiEnabledScene();

    String getAutoGuiFastModeUseSettings();

    boolean getAutoImageUploadEnabled();

    FeatureConfigMap getFeatureConfigMap();

    int getIntentAuthStatus(String r1);

    int getIntentUploadStrategyForDebug();

    boolean getOAutoUseClipboardEnabled();

    boolean getOUseMemoryEnabled();

    String getObricCloudConfig(String r1);

    OComplexTaskConfig getObricComplexTaskConfig();

    String getObricFlowSettingsJson(String r1);

    ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig();

    OModelConfig getObricModelConfig();

    int getObricPowerLockTimeoutInSeconds();

    boolean getPersonalContextEnabled();

    boolean getSemanticeScreenShotEnabled();

    boolean isLarkKnowledgeAuthorizationEnable();

    boolean isLarkSendConfirmEnabled();

    boolean isTtsPlayBackgroundEnabled();

    boolean isVoicePrintAuthenticateAutoGuiEnabled();

    void setAutoGuiEnabledScene(int r1);

    void setAutoImageUploadEnabled(boolean r1);

    void setLarkKnowledgeAuthorizationEnabled(boolean r1);

    void setOUseMemoryEnabled(boolean r1);

    void setSemanticScreenShotEnabled(boolean r1);

    void setVoicePrintAuthenticateAutoGuiEnabled(boolean r1);
}
