package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAssistantInteractionListenerIDL extends IInterface {

    public static class Default implements IAssistantInteractionListenerIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onAssistantDied() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onAssistantTakeOver() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelCancel() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelHeightChanged(int r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelShow(int r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onReply(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void requestToShowInputPanel() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void requestToShowInputPanelWithMeta(String r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantInteractionListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL";
        static final int TRANSACTION_onAssistantDied = 7;
        static final int TRANSACTION_onAssistantTakeOver = 1;
        static final int TRANSACTION_onPanelCancel = 3;
        static final int TRANSACTION_onPanelHeightChanged = 5;
        static final int TRANSACTION_onPanelShow = 4;
        static final int TRANSACTION_onReply = 2;
        static final int TRANSACTION_requestToShowInputPanel = 6;
        static final int TRANSACTION_requestToShowInputPanelWithMeta = 8;

        private static class Proxy implements IAssistantInteractionListenerIDL {
            public static IAssistantInteractionListenerIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onAssistantTakeOver() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantTakeOver();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onReply(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onReply(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelCancel() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelCancel();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelShow(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelShow(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelHeightChanged(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelHeightChanged(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void requestToShowInputPanel() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanel();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onAssistantDied() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantDied();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void requestToShowInputPanelWithMeta(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanelWithMeta(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
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

        public static IAssistantInteractionListenerIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAssistantInteractionListenerIDL.class) == false) goto L13;
            return (IAssistantInteractionListenerIDL) ZeusTransformUtils.preCheckCast(r0, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L23;
            switch(r4) {
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            requestToShowInputPanelWithMeta(r5.readString());
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            onAssistantDied();
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            requestToShowInputPanel();
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            onPanelHeightChanged(r5.readInt());
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            onPanelShow(r5.readInt());
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            onPanelCancel();
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            onReply(r5.readString());
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            onAssistantTakeOver();
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L23:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAssistantInteractionListenerIDL r2) {
            IAssistantInteractionListenerIDL r3 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAssistantInteractionListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onAssistantDied();

    void onAssistantTakeOver();

    void onPanelCancel();

    void onPanelHeightChanged(int r1);

    void onPanelShow(int r1);

    void onReply(String r1);

    void requestToShowInputPanel();

    void requestToShowInputPanelWithMeta(String r1);
}
