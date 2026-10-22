package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentIDL extends IInterface {
    public static final String ACTION_BIND_IPC = "com.obric.aiagent.action.BIND_ASSISTANT_IPC";
    public static final String EXTRA_CLIENT_NAME = "client_name";
    public static final String EXTRA_CLIENT_PKG = "client_pkg";
    public static final String META_PRODUCT = "app.product";
    public static final String META_UPDATEVERSION = "app.updateversioncode";

    public static class Default implements IAgentIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentNetworkIDL getAgentNetworkIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentAppIntentIDL getAppIntentIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentAssistantStateIDL getAssistantStateIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IFileIDL getFileIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentMessageIDL getMessageIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IPlatformApiIDL getPlatformApiIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentPrivacyIDL getPrivacyIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentSettingsIDL getSettingsIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentSkillManagerIDL getSkillManagerIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentTaskAppIDL getTaskAppIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public void registerFlowIDL(IFlowIDL r2) {
            IFlowIDL r1 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentIDL";
        static final int TRANSACTION_getAgentDMStateManagerIDL = 10;
        static final int TRANSACTION_getAgentNetworkIDL = 8;
        static final int TRANSACTION_getAppIntentIDL = 3;
        static final int TRANSACTION_getAssistantStateIDL = 7;
        static final int TRANSACTION_getFileIDL = 2;
        static final int TRANSACTION_getMessageIDL = 6;
        static final int TRANSACTION_getPlatformApiIDL = 9;
        static final int TRANSACTION_getPrivacyIDL = 11;
        static final int TRANSACTION_getSettingsIDL = 5;
        static final int TRANSACTION_getSkillManagerIDL = 13;
        static final int TRANSACTION_getTaskAppIDL = 12;
        static final int TRANSACTION_getVoiceInteractionIDL = 4;
        static final int TRANSACTION_registerFlowIDL = 1;

        private static class Proxy implements IAgentIDL {
            public static IAgentIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public void registerFlowIDL(IFlowIDL r4) {
                IFlowIDL r5 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerFlowIDL(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IFileIDL getFileIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFileIDL r4 = IFileIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFileIDL r5 = Stub.getDefaultImpl().getFileIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentAppIntentIDL getAppIntentIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentAppIntentIDL r4 = IAgentAppIntentIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentAppIntentIDL r5 = Stub.getDefaultImpl().getAppIntentIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentVoiceInteractionIDL r4 = IAgentVoiceInteractionIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentVoiceInteractionIDL r5 = Stub.getDefaultImpl().getVoiceInteractionIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentSettingsIDL getSettingsIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentSettingsIDL r4 = IAgentSettingsIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentSettingsIDL r5 = Stub.getDefaultImpl().getSettingsIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentMessageIDL getMessageIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentMessageIDL r4 = IAgentMessageIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentMessageIDL r5 = Stub.getDefaultImpl().getMessageIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentAssistantStateIDL getAssistantStateIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentAssistantStateIDL r4 = IAgentAssistantStateIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentAssistantStateIDL r5 = Stub.getDefaultImpl().getAssistantStateIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentNetworkIDL getAgentNetworkIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentNetworkIDL r4 = IAgentNetworkIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentNetworkIDL r5 = Stub.getDefaultImpl().getAgentNetworkIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IPlatformApiIDL getPlatformApiIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IPlatformApiIDL r4 = IPlatformApiIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IPlatformApiIDL r5 = Stub.getDefaultImpl().getPlatformApiIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentDMStateManagerIDL r4 = IAgentDMStateManagerIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentDMStateManagerIDL r5 = Stub.getDefaultImpl().getAgentDMStateManagerIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentPrivacyIDL getPrivacyIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentPrivacyIDL r4 = IAgentPrivacyIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentPrivacyIDL r5 = Stub.getDefaultImpl().getPrivacyIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentTaskAppIDL getTaskAppIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentTaskAppIDL r4 = IAgentTaskAppIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentTaskAppIDL r5 = Stub.getDefaultImpl().getTaskAppIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentSkillManagerIDL getSkillManagerIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IAgentSkillManagerIDL r4 = IAgentSkillManagerIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentSkillManagerIDL r5 = Stub.getDefaultImpl().getSkillManagerIDL();     // Catch: Throwable -> L13
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

        public static IAgentIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentIDL.class) == false) goto L13;
            return (IAgentIDL) ZeusTransformUtils.preCheckCast(r0, IAgentIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L70;
            IBinder r0 = null;
            switch(r4) {
                case 1: goto L68;
                case 2: goto L63;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L48;
                case 6: goto L43;
                case 7: goto L38;
                case 8: goto L33;
                case 9: goto L28;
                case 10: goto L23;
                case 11: goto L18;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            IAgentSkillManagerIDL r3 = getSkillManagerIDL();
            r6.writeNoException();
            if (r3 == null) goto L11;
            r0 = r3.asBinder();
        L11:
            r6.writeStrongBinder(r0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            IAgentTaskAppIDL r8 = getTaskAppIDL();
            r6.writeNoException();
            if (r8 == null) goto L16;
            r0 = r8.asBinder();
        L16:
            r6.writeStrongBinder(r0);
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            IAgentPrivacyIDL r9 = getPrivacyIDL();
            r6.writeNoException();
            if (r9 == null) goto L21;
            r0 = r9.asBinder();
        L21:
            r6.writeStrongBinder(r0);
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            IAgentDMStateManagerIDL r10 = getAgentDMStateManagerIDL();
            r6.writeNoException();
            if (r10 == null) goto L26;
            r0 = r10.asBinder();
        L26:
            r6.writeStrongBinder(r0);
            return true;
        L28:
            r5.enforceInterface(DESCRIPTOR);
            IPlatformApiIDL r11 = getPlatformApiIDL();
            r6.writeNoException();
            if (r11 == null) goto L31;
            r0 = r11.asBinder();
        L31:
            r6.writeStrongBinder(r0);
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            IAgentNetworkIDL r12 = getAgentNetworkIDL();
            r6.writeNoException();
            if (r12 == null) goto L36;
            r0 = r12.asBinder();
        L36:
            r6.writeStrongBinder(r0);
            return true;
        L38:
            r5.enforceInterface(DESCRIPTOR);
            IAgentAssistantStateIDL r13 = getAssistantStateIDL();
            r6.writeNoException();
            if (r13 == null) goto L41;
            r0 = r13.asBinder();
        L41:
            r6.writeStrongBinder(r0);
            return true;
        L43:
            r5.enforceInterface(DESCRIPTOR);
            IAgentMessageIDL r14 = getMessageIDL();
            r6.writeNoException();
            if (r14 == null) goto L46;
            r0 = r14.asBinder();
        L46:
            r6.writeStrongBinder(r0);
            return true;
        L48:
            r5.enforceInterface(DESCRIPTOR);
            IAgentSettingsIDL r15 = getSettingsIDL();
            r6.writeNoException();
            if (r15 == null) goto L51;
            r0 = r15.asBinder();
        L51:
            r6.writeStrongBinder(r0);
            return true;
        L53:
            r5.enforceInterface(DESCRIPTOR);
            IAgentVoiceInteractionIDL r16 = getVoiceInteractionIDL();
            r6.writeNoException();
            if (r16 == null) goto L56;
            r0 = r16.asBinder();
        L56:
            r6.writeStrongBinder(r0);
            return true;
        L58:
            r5.enforceInterface(DESCRIPTOR);
            IAgentAppIntentIDL r17 = getAppIntentIDL();
            r6.writeNoException();
            if (r17 == null) goto L61;
            r0 = r17.asBinder();
        L61:
            r6.writeStrongBinder(r0);
            return true;
        L63:
            r5.enforceInterface(DESCRIPTOR);
            IFileIDL r18 = getFileIDL();
            r6.writeNoException();
            if (r18 == null) goto L66;
            r0 = r18.asBinder();
        L66:
            r6.writeStrongBinder(r0);
            return true;
        L68:
            r5.enforceInterface(DESCRIPTOR);
            registerFlowIDL(IFlowIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L70:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAgentIDL r2) {
            IAgentIDL r3 = (IAgentIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    IAgentDMStateManagerIDL getAgentDMStateManagerIDL();

    IAgentNetworkIDL getAgentNetworkIDL();

    IAgentAppIntentIDL getAppIntentIDL();

    IAgentAssistantStateIDL getAssistantStateIDL();

    IFileIDL getFileIDL();

    IAgentMessageIDL getMessageIDL();

    IPlatformApiIDL getPlatformApiIDL();

    IAgentPrivacyIDL getPrivacyIDL();

    IAgentSettingsIDL getSettingsIDL();

    IAgentSkillManagerIDL getSkillManagerIDL();

    IAgentTaskAppIDL getTaskAppIDL();

    IAgentVoiceInteractionIDL getVoiceInteractionIDL();

    void registerFlowIDL(IFlowIDL r1);
}
