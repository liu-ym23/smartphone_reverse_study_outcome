package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowIDL extends IInterface {

    public static class Default implements IFlowIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppIntentIDL getAppIntentIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppLogIDL getAppLogIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppStateIDL getAppStateIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAssistantStateIDL getAssistantStateIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowCocreationReviewIDL getCocreationReviewIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFileIDL getFileIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowFeedbackIDL getFlowFeedbackIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowNetworkIDL getFlowNetworkIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowPermissionIDL getFlowPermissionIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowFrontierIDL getFrontierIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowMessageIDL getMessageIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowSettingsIDL getSettingsIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowUiIDL getUiIDL() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowVoiceInteractionIDL getVoiceInteractionIDL() {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowIDL";
        static final int TRANSACTION_getAppIntentIDL = 7;
        static final int TRANSACTION_getAppLogIDL = 2;
        static final int TRANSACTION_getAppStateIDL = 4;
        static final int TRANSACTION_getAssistantStateIDL = 10;
        static final int TRANSACTION_getCocreationReviewIDL = 14;
        static final int TRANSACTION_getFileIDL = 1;
        static final int TRANSACTION_getFlowFeedbackIDL = 13;
        static final int TRANSACTION_getFlowNetworkIDL = 11;
        static final int TRANSACTION_getFlowPermissionIDL = 12;
        static final int TRANSACTION_getFrontierIDL = 3;
        static final int TRANSACTION_getMessageIDL = 9;
        static final int TRANSACTION_getSettingsIDL = 5;
        static final int TRANSACTION_getUiIDL = 6;
        static final int TRANSACTION_getVoiceInteractionIDL = 8;

        private static class Proxy implements IFlowIDL {
            public static IFlowIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFileIDL getFileIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppLogIDL getAppLogIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowAppLogIDL r4 = IFlowAppLogIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppLogIDL r5 = Stub.getDefaultImpl().getAppLogIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowFrontierIDL getFrontierIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowFrontierIDL r4 = IFlowFrontierIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowFrontierIDL r5 = Stub.getDefaultImpl().getFrontierIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppStateIDL getAppStateIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowAppStateIDL r4 = IFlowAppStateIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppStateIDL r5 = Stub.getDefaultImpl().getAppStateIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowSettingsIDL getSettingsIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowSettingsIDL r4 = IFlowSettingsIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowSettingsIDL r5 = Stub.getDefaultImpl().getSettingsIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowUiIDL getUiIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowUiIDL r4 = IFlowUiIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowUiIDL r5 = Stub.getDefaultImpl().getUiIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppIntentIDL getAppIntentIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowAppIntentIDL r4 = IFlowAppIntentIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppIntentIDL r5 = Stub.getDefaultImpl().getAppIntentIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowVoiceInteractionIDL getVoiceInteractionIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowVoiceInteractionIDL r4 = IFlowVoiceInteractionIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowVoiceInteractionIDL r5 = Stub.getDefaultImpl().getVoiceInteractionIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowMessageIDL getMessageIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowMessageIDL r4 = IFlowMessageIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowMessageIDL r5 = Stub.getDefaultImpl().getMessageIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAssistantStateIDL getAssistantStateIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowAssistantStateIDL r4 = IFlowAssistantStateIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAssistantStateIDL r5 = Stub.getDefaultImpl().getAssistantStateIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowNetworkIDL getFlowNetworkIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowNetworkIDL r4 = IFlowNetworkIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowNetworkIDL r5 = Stub.getDefaultImpl().getFlowNetworkIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowPermissionIDL getFlowPermissionIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowPermissionIDL r4 = IFlowPermissionIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowPermissionIDL r5 = Stub.getDefaultImpl().getFlowPermissionIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowFeedbackIDL getFlowFeedbackIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowFeedbackIDL r4 = IFlowFeedbackIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowFeedbackIDL r5 = Stub.getDefaultImpl().getFlowFeedbackIDL();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowCocreationReviewIDL getCocreationReviewIDL() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IFlowCocreationReviewIDL r4 = IFlowCocreationReviewIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowCocreationReviewIDL r5 = Stub.getDefaultImpl().getCocreationReviewIDL();     // Catch: Throwable -> L13
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

        public static IFlowIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowIDL.class) == false) goto L13;
            return (IFlowIDL) ZeusTransformUtils.preCheckCast(r0, IFlowIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L78;
            IBinder r0 = null;
            switch(r4) {
                case 1: goto L73;
                case 2: goto L68;
                case 3: goto L63;
                case 4: goto L58;
                case 5: goto L53;
                case 6: goto L48;
                case 7: goto L43;
                case 8: goto L38;
                case 9: goto L33;
                case 10: goto L28;
                case 11: goto L23;
                case 12: goto L18;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            IFlowCocreationReviewIDL r3 = getCocreationReviewIDL();
            r6.writeNoException();
            if (r3 == null) goto L11;
            r0 = r3.asBinder();
        L11:
            r6.writeStrongBinder(r0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            IFlowFeedbackIDL r8 = getFlowFeedbackIDL();
            r6.writeNoException();
            if (r8 == null) goto L16;
            r0 = r8.asBinder();
        L16:
            r6.writeStrongBinder(r0);
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            IFlowPermissionIDL r9 = getFlowPermissionIDL();
            r6.writeNoException();
            if (r9 == null) goto L21;
            r0 = r9.asBinder();
        L21:
            r6.writeStrongBinder(r0);
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            IFlowNetworkIDL r10 = getFlowNetworkIDL();
            r6.writeNoException();
            if (r10 == null) goto L26;
            r0 = r10.asBinder();
        L26:
            r6.writeStrongBinder(r0);
            return true;
        L28:
            r5.enforceInterface(DESCRIPTOR);
            IFlowAssistantStateIDL r11 = getAssistantStateIDL();
            r6.writeNoException();
            if (r11 == null) goto L31;
            r0 = r11.asBinder();
        L31:
            r6.writeStrongBinder(r0);
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            IFlowMessageIDL r12 = getMessageIDL();
            r6.writeNoException();
            if (r12 == null) goto L36;
            r0 = r12.asBinder();
        L36:
            r6.writeStrongBinder(r0);
            return true;
        L38:
            r5.enforceInterface(DESCRIPTOR);
            IFlowVoiceInteractionIDL r13 = getVoiceInteractionIDL();
            r6.writeNoException();
            if (r13 == null) goto L41;
            r0 = r13.asBinder();
        L41:
            r6.writeStrongBinder(r0);
            return true;
        L43:
            r5.enforceInterface(DESCRIPTOR);
            IFlowAppIntentIDL r14 = getAppIntentIDL();
            r6.writeNoException();
            if (r14 == null) goto L46;
            r0 = r14.asBinder();
        L46:
            r6.writeStrongBinder(r0);
            return true;
        L48:
            r5.enforceInterface(DESCRIPTOR);
            IFlowUiIDL r15 = getUiIDL();
            r6.writeNoException();
            if (r15 == null) goto L51;
            r0 = r15.asBinder();
        L51:
            r6.writeStrongBinder(r0);
            return true;
        L53:
            r5.enforceInterface(DESCRIPTOR);
            IFlowSettingsIDL r16 = getSettingsIDL();
            r6.writeNoException();
            if (r16 == null) goto L56;
            r0 = r16.asBinder();
        L56:
            r6.writeStrongBinder(r0);
            return true;
        L58:
            r5.enforceInterface(DESCRIPTOR);
            IFlowAppStateIDL r17 = getAppStateIDL();
            r6.writeNoException();
            if (r17 == null) goto L61;
            r0 = r17.asBinder();
        L61:
            r6.writeStrongBinder(r0);
            return true;
        L63:
            r5.enforceInterface(DESCRIPTOR);
            IFlowFrontierIDL r18 = getFrontierIDL();
            r6.writeNoException();
            if (r18 == null) goto L66;
            r0 = r18.asBinder();
        L66:
            r6.writeStrongBinder(r0);
            return true;
        L68:
            r5.enforceInterface(DESCRIPTOR);
            IFlowAppLogIDL r19 = getAppLogIDL();
            r6.writeNoException();
            if (r19 == null) goto L71;
            r0 = r19.asBinder();
        L71:
            r6.writeStrongBinder(r0);
            return true;
        L73:
            r5.enforceInterface(DESCRIPTOR);
            IFileIDL r20 = getFileIDL();
            r6.writeNoException();
            if (r20 == null) goto L76;
            r0 = r20.asBinder();
        L76:
            r6.writeStrongBinder(r0);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L78:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowIDL r2) {
            IFlowIDL r3 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    IFlowAppIntentIDL getAppIntentIDL();

    IFlowAppLogIDL getAppLogIDL();

    IFlowAppStateIDL getAppStateIDL();

    IFlowAssistantStateIDL getAssistantStateIDL();

    IFlowCocreationReviewIDL getCocreationReviewIDL();

    IFileIDL getFileIDL();

    IFlowFeedbackIDL getFlowFeedbackIDL();

    IFlowNetworkIDL getFlowNetworkIDL();

    IFlowPermissionIDL getFlowPermissionIDL();

    IFlowFrontierIDL getFrontierIDL();

    IFlowMessageIDL getMessageIDL();

    IFlowSettingsIDL getSettingsIDL();

    IFlowUiIDL getUiIDL();

    IFlowVoiceInteractionIDL getVoiceInteractionIDL();
}
