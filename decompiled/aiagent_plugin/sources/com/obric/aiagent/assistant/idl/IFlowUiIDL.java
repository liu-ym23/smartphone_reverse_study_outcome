package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowUiIDL extends IInterface {

    public static class Default implements IFlowUiIDL {
        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void addCustomBarAction(String r1, String r2, String r3, long r4) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void closeAssistantInputPanel(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void dismissKeyguard() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void finishChatPage() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public String getCurrentDisplayModel() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public String getTaskSkillModelJson() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public int getWindowState() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void handleObricAction(String r1, String r2, IObricActionResultCallbackIDL r3) {
            IObricActionResultCallbackIDL r0 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAssistantRequestFromAIKey() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAudioMessage(String r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAuthenticationPass() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAuthenticationPassV2(String r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public Authentication isAuthenticationPassV3(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isWindowMode() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isWindowShowing() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyAssistantState(String r1, boolean r2, StateInfo r3) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyMessageInAutoGui(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyOAutoDied() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openAssistantInputPanel(String r1, StateInfo r2, boolean r3) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openChatActivity(int r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openRealtimeCall(int r1, IOpenRealTimeCallCallbackIDL r2) {
            IOpenRealTimeCallCallbackIDL r0 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void popWindow() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void processRequiresAuthentication() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r1, boolean r2, Bundle r3) {
            IRequestAuthenticationCallbackIDL r0 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2) {
            IRequestAuthenticationCallbackIDL r0 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2) {
            IRequestAuthenticationCallbackIDL r0 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void setAssistantInteractionListener(String r1, IAssistantInteractionListenerIDL r2) {
            IAssistantInteractionListenerIDL r0 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void setAutoIncreaseWindow(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void shouldDowngradeAuthForDora(int r1, IDowngradeAuthForDoraCallbackIDL r2) {
            IDowngradeAuthForDoraCallbackIDL r0 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void showToast(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void showWindow() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void suspendDismissKeyguard(String r1, String[] r2, IDismissKeyguardCallbackIDL r3, boolean r4, Bundle r5) {
            IDismissKeyguardCallbackIDL r0 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowUiIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowUiIDL";
        static final int TRANSACTION_addCustomBarAction = 1;
        static final int TRANSACTION_closeAssistantInputPanel = 12;
        static final int TRANSACTION_dismissKeyguard = 4;
        static final int TRANSACTION_finishChatPage = 9;
        static final int TRANSACTION_getCurrentDisplayModel = 32;
        static final int TRANSACTION_getTaskSkillModelJson = 31;
        static final int TRANSACTION_getWindowState = 5;
        static final int TRANSACTION_handleObricAction = 2;
        static final int TRANSACTION_isAssistantRequestFromAIKey = 23;
        static final int TRANSACTION_isAudioMessage = 24;
        static final int TRANSACTION_isAuthenticationPass = 15;
        static final int TRANSACTION_isAuthenticationPassV2 = 20;
        static final int TRANSACTION_isAuthenticationPassV3 = 22;
        static final int TRANSACTION_isWindowMode = 28;
        static final int TRANSACTION_isWindowShowing = 30;
        static final int TRANSACTION_notifyAssistantState = 13;
        static final int TRANSACTION_notifyMessageInAutoGui = 7;
        static final int TRANSACTION_notifyOAutoDied = 21;
        static final int TRANSACTION_openAssistantInputPanel = 11;
        static final int TRANSACTION_openChatActivity = 19;
        static final int TRANSACTION_openRealtimeCall = 8;
        static final int TRANSACTION_popWindow = 29;
        static final int TRANSACTION_processRequiresAuthentication = 26;
        static final int TRANSACTION_requestBiometricAuthentication = 17;
        static final int TRANSACTION_requestDeviceCredentialAuthentication = 18;
        static final int TRANSACTION_requestVoicePrintAuthentication = 16;
        static final int TRANSACTION_setAssistantInteractionListener = 14;
        static final int TRANSACTION_setAutoIncreaseWindow = 10;
        static final int TRANSACTION_shouldDowngradeAuthForDora = 25;
        static final int TRANSACTION_showToast = 6;
        static final int TRANSACTION_showWindow = 27;
        static final int TRANSACTION_suspendDismissKeyguard = 3;

        private static class Proxy implements IFlowUiIDL {
            public static IFlowUiIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void addCustomBarAction(String r8, String r9, String r10, long r11) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r8);     // Catch: Throwable -> L12
                r0.writeString(r9);     // Catch: Throwable -> L12
                r0.writeString(r10);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addCustomBarAction(r8, r9, r10, r11);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void handleObricAction(String r5, String r6, IObricActionResultCallbackIDL r7) {
                IObricActionResultCallbackIDL r8 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleObricAction(r5, r6, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void suspendDismissKeyguard(String r7, String[] r8, IDismissKeyguardCallbackIDL r9, boolean r10, Bundle r11) {
                IDismissKeyguardCallbackIDL r3 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r9, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r12.writeString(r7);     // Catch: Throwable -> L24
                r12.writeStringArray(r8);     // Catch: Throwable -> L24
                if (r3 == null) goto L6;
                IBinder r1 = r3.asBinder();     // Catch: Throwable -> L24
            L7:
                r12.writeStrongBinder(r1);     // Catch: Throwable -> L24
                if (r10 == false) goto L10;
                int r4 = 1;
            L11:
                r12.writeInt(r4);     // Catch: Throwable -> L24
                if (r11 == null) goto L14;
                r12.writeInt(1);     // Catch: Throwable -> L24
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L24
            L16:
                if (this.mRemote.transact(3, r12, null, 1) == false) goto L18;
            L22:
                r12.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().suspendDismissKeyguard(r7, r8, r3, r10, r11);     // Catch: Throwable -> L24
                r12.recycle();
                return;
            L14:
                r12.writeInt(0);     // Catch: Throwable -> L24
                goto L16
            L10:
                r4 = 0;
                goto L11
            L6:
                r1 = null;
            L24:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void dismissKeyguard() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dismissKeyguard();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public int getWindowState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getWindowState();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void showToast(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showToast(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyMessageInAutoGui(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyMessageInAutoGui(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openRealtimeCall(int r5, IOpenRealTimeCallCallbackIDL r6) {
                IOpenRealTimeCallCallbackIDL r7 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().openRealtimeCall(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void finishChatPage() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().finishChatPage();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void setAutoIncreaseWindow(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAutoIncreaseWindow(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openAssistantInputPanel(String r5, StateInfo r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L18
                r0.writeString(r5);     // Catch: Throwable -> L18
                int r2 = 0;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L18
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L18
            L7:
                if (r7 == false) goto L9;
                r2 = 1;
            L9:
                r0.writeInt(r2);     // Catch: Throwable -> L18
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L12;
            L16:
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().openAssistantInputPanel(r5, r6, r7);     // Catch: Throwable -> L18
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void closeAssistantInputPanel(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().closeAssistantInputPanel(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyAssistantState(String r5, boolean r6, StateInfo r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r5);     // Catch: Throwable -> L20
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L20
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L12:
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().notifyAssistantState(r5, r6, r7);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r3 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void setAssistantInteractionListener(String r5, IAssistantInteractionListenerIDL r6) {
                IAssistantInteractionListenerIDL r7 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r6, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAssistantInteractionListener(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAuthenticationPass() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isAuthenticationPass();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r5, Bundle r6) {
                IRequestAuthenticationCallbackIDL r7 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L20
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L20
                if (r6 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L12:
                if (this.mRemote.transact(16, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestVoicePrintAuthentication(r7, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r2 = null;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r6, boolean r7, Bundle r8) {
                IRequestAuthenticationCallbackIDL r9 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L24
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L24
                if (r7 == false) goto L10;
                int r4 = 1;
            L11:
                r0.writeInt(r4);     // Catch: Throwable -> L24
                if (r8 == null) goto L14;
                r0.writeInt(1);     // Catch: Throwable -> L24
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L24
            L16:
                if (this.mRemote.transact(17, r0, null, 1) == false) goto L18;
            L22:
                r0.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().requestBiometricAuthentication(r9, r7, r8);     // Catch: Throwable -> L24
                r0.recycle();
                return;
            L14:
                r0.writeInt(0);     // Catch: Throwable -> L24
                goto L16
            L10:
                r4 = 0;
                goto L11
            L6:
                r2 = null;
            L24:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r5, Bundle r6) {
                IRequestAuthenticationCallbackIDL r7 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L20
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L20
                if (r6 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L12:
                if (this.mRemote.transact(18, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestDeviceCredentialAuthentication(r7, r6);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r2 = null;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openChatActivity(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(19, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().openChatActivity(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAuthenticationPassV2(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isAuthenticationPassV2(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyOAutoDied() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(21, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyOAutoDied();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public Authentication isAuthenticationPassV3(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Authentication r4 = (Authentication) ZeusTransformUtils.preCheckCast(Authentication.CREATOR.createFromParcel(r1), Authentication.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Authentication r6 = Stub.getDefaultImpl().isAuthenticationPassV3(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAssistantRequestFromAIKey() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isAssistantRequestFromAIKey();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAudioMessage(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isAudioMessage(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void shouldDowngradeAuthForDora(int r5, IDowngradeAuthForDoraCallbackIDL r6) {
                IDowngradeAuthForDoraCallbackIDL r7 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(25, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().shouldDowngradeAuthForDora(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void processRequiresAuthentication() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(26, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().processRequiresAuthentication();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void showWindow() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(27, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showWindow();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isWindowMode() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(28, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isWindowMode();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void popWindow() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(29, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().popWindow();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isWindowShowing() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(30, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isWindowShowing();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public String getTaskSkillModelJson() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getTaskSkillModelJson();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public String getCurrentDisplayModel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(32, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getCurrentDisplayModel();     // Catch: Throwable -> L13
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

        public static IFlowUiIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowUiIDL.class) == false) goto L13;
            return (IFlowUiIDL) ZeusTransformUtils.preCheckCast(r0, IFlowUiIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 == 1598968902) goto L109;
            Bundle r3 = null;
            Bundle r4 = null;
            Bundle r5 = null;
            Bundle r6 = null;
            StateInfo r7 = null;
            StateInfo r8 = null;
            boolean r13 = false;
            switch(r9) {
                case 1: goto L107;
                case 2: goto L105;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L79;
                case 11: goto L71;
                case 12: goto L69;
                case 13: goto L61;
                case 14: goto L59;
                case 15: goto L57;
                case 16: goto L52;
                case 17: goto L44;
                case 18: goto L39;
                case 19: goto L37;
                case 20: goto L35;
                case 21: goto L33;
                case 22: goto L28;
                case 23: goto L26;
                case 24: goto L24;
                case 25: goto L22;
                case 26: goto L20;
                case 27: goto L18;
                case 28: goto L16;
                case 29: goto L14;
                case 30: goto L12;
                case 31: goto L10;
                case 32: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            String r14 = getCurrentDisplayModel();
            r11.writeNoException();
            r11.writeString(r14);
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            String r15 = getTaskSkillModelJson();
            r11.writeNoException();
            r11.writeString(r15);
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            boolean r16 = isWindowShowing();
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L14:
            r10.enforceInterface(DESCRIPTOR);
            popWindow();
            return true;
        L16:
            r10.enforceInterface(DESCRIPTOR);
            boolean r17 = isWindowMode();
            r11.writeNoException();
            r11.writeInt(r17 ? 1 : 0);
            return true;
        L18:
            r10.enforceInterface(DESCRIPTOR);
            showWindow();
            return true;
        L20:
            r10.enforceInterface(DESCRIPTOR);
            processRequiresAuthentication();
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            shouldDowngradeAuthForDora(r10.readInt(), IDowngradeAuthForDoraCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L24:
            r10.enforceInterface(DESCRIPTOR);
            boolean r18 = isAudioMessage(r10.readString());
            r11.writeNoException();
            r11.writeInt(r18 ? 1 : 0);
            return true;
        L26:
            r10.enforceInterface(DESCRIPTOR);
            boolean r19 = isAssistantRequestFromAIKey();
            r11.writeNoException();
            r11.writeInt(r19 ? 1 : 0);
            return true;
        L28:
            r10.enforceInterface(DESCRIPTOR);
            Authentication r20 = isAuthenticationPassV3(r10.readString());
            r11.writeNoException();
            if (r20 == null) goto L31;
            r11.writeInt(1);
            r20.writeToParcel(r11, 1);
        L32:
            return true;
        L31:
            r11.writeInt(0);
            goto L32
        L33:
            r10.enforceInterface(DESCRIPTOR);
            notifyOAutoDied();
            return true;
        L35:
            r10.enforceInterface(DESCRIPTOR);
            boolean r21 = isAuthenticationPassV2(r10.readString());
            r11.writeNoException();
            r11.writeInt(r21 ? 1 : 0);
            return true;
        L37:
            r10.enforceInterface(DESCRIPTOR);
            openChatActivity(r10.readInt());
            return true;
        L39:
            r10.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r22 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r10.readStrongBinder());
            if (r10.readInt() == 0) goto L42;
            r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r10), Bundle.class, "com.obric.aiagent.plugin");
        L42:
            requestDeviceCredentialAuthentication(r22, r4);
            return true;
        L44:
            r10.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r23 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r10.readStrongBinder());
            if (r10.readInt() == 0) goto L48;
            r13 = true;
        L48:
            if (r10.readInt() == 0) goto L50;
            r5 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r10), Bundle.class, "com.obric.aiagent.plugin");
        L50:
            requestBiometricAuthentication(r23, r13, r5);
            return true;
        L52:
            r10.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r24 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r10.readStrongBinder());
            if (r10.readInt() == 0) goto L55;
            r6 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r10), Bundle.class, "com.obric.aiagent.plugin");
        L55:
            requestVoicePrintAuthentication(r24, r6);
            return true;
        L57:
            r10.enforceInterface(DESCRIPTOR);
            boolean r25 = isAuthenticationPass();
            r11.writeNoException();
            r11.writeInt(r25 ? 1 : 0);
            return true;
        L59:
            r10.enforceInterface(DESCRIPTOR);
            setAssistantInteractionListener(r10.readString(), IAssistantInteractionListenerIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L61:
            r10.enforceInterface(DESCRIPTOR);
            String r26 = r10.readString();
            if (r10.readInt() == 0) goto L65;
            r13 = true;
        L65:
            if (r10.readInt() == 0) goto L67;
            r7 = StateInfo.CREATOR.createFromParcel(r10);
        L67:
            notifyAssistantState(r26, r13, r7);
            return true;
        L69:
            r10.enforceInterface(DESCRIPTOR);
            closeAssistantInputPanel(r10.readString());
            return true;
        L71:
            r10.enforceInterface(DESCRIPTOR);
            String r27 = r10.readString();
            if (r10.readInt() == 0) goto L75;
            r8 = StateInfo.CREATOR.createFromParcel(r10);
        L75:
            if (r10.readInt() == 0) goto L77;
            r13 = true;
        L77:
            openAssistantInputPanel(r27, r8, r13);
            return true;
        L79:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L82;
            r13 = true;
        L82:
            setAutoIncreaseWindow(r13);
            return true;
        L84:
            r10.enforceInterface(DESCRIPTOR);
            finishChatPage();
            return true;
        L86:
            r10.enforceInterface(DESCRIPTOR);
            openRealtimeCall(r10.readInt(), IOpenRealTimeCallCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L88:
            r10.enforceInterface(DESCRIPTOR);
            notifyMessageInAutoGui(r10.readString());
            return true;
        L90:
            r10.enforceInterface(DESCRIPTOR);
            showToast(r10.readString());
            return true;
        L92:
            r10.enforceInterface(DESCRIPTOR);
            int r28 = getWindowState();
            r11.writeNoException();
            r11.writeInt(r28);
            return true;
        L94:
            r10.enforceInterface(DESCRIPTOR);
            dismissKeyguard();
            return true;
        L96:
            r10.enforceInterface(DESCRIPTOR);
            String r29 = r10.readString();
            String[] r110 = r10.createStringArray();
            IDismissKeyguardCallbackIDL r30 = IDismissKeyguardCallbackIDL.Stub.asInterface(r10.readStrongBinder());
            if (r10.readInt() == 0) goto L99;
            boolean r31 = true;
        L101:
            if (r10.readInt() == 0) goto L103;
            r3 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r10), Bundle.class, "com.obric.aiagent.plugin");
        L103:
            suspendDismissKeyguard(r29, r110, r30, r31, r3);
            return true;
        L99:
            r31 = false;
            goto L101
        L105:
            r10.enforceInterface(DESCRIPTOR);
            handleObricAction(r10.readString(), r10.readString(), IObricActionResultCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L107:
            r10.enforceInterface(DESCRIPTOR);
            addCustomBarAction(r10.readString(), r10.readString(), r10.readString(), r10.readLong());
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L109:
            r11.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowUiIDL r2) {
            IFlowUiIDL r3 = (IFlowUiIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowUiIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowUiIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addCustomBarAction(String r1, String r2, String r3, long r4);

    void closeAssistantInputPanel(String r1);

    void dismissKeyguard();

    void finishChatPage();

    String getCurrentDisplayModel();

    String getTaskSkillModelJson();

    int getWindowState();

    void handleObricAction(String r1, String r2, IObricActionResultCallbackIDL r3);

    boolean isAssistantRequestFromAIKey();

    boolean isAudioMessage(String r1);

    boolean isAuthenticationPass();

    boolean isAuthenticationPassV2(String r1);

    Authentication isAuthenticationPassV3(String r1);

    boolean isWindowMode();

    boolean isWindowShowing();

    void notifyAssistantState(String r1, boolean r2, StateInfo r3);

    void notifyMessageInAutoGui(String r1);

    void notifyOAutoDied();

    void openAssistantInputPanel(String r1, StateInfo r2, boolean r3);

    void openChatActivity(int r1);

    void openRealtimeCall(int r1, IOpenRealTimeCallCallbackIDL r2);

    void popWindow();

    void processRequiresAuthentication();

    void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r1, boolean r2, Bundle r3);

    void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2);

    void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r1, Bundle r2);

    void setAssistantInteractionListener(String r1, IAssistantInteractionListenerIDL r2);

    void setAutoIncreaseWindow(boolean r1);

    void shouldDowngradeAuthForDora(int r1, IDowngradeAuthForDoraCallbackIDL r2);

    void showToast(String r1);

    void showWindow();

    void suspendDismissKeyguard(String r1, String[] r2, IDismissKeyguardCallbackIDL r3, boolean r4, Bundle r5);
}
