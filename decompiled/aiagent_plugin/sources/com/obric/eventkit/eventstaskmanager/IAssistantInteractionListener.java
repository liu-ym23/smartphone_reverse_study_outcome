package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IAssistantInteractionListener extends IInterface {

    public static class Default implements IAssistantInteractionListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onAssistantDied() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onAssistantTakeOver() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelCancel() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelHeightChanged(int r1) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelShow(int r1) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onReply(String r1) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void requestToShowInputPanel() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void requestToShowInputPanelWithMeta(String r1) {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantInteractionListener {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener";
        public static final int TRANSACTION_onAssistantDied = 7;
        public static final int TRANSACTION_onAssistantTakeOver = 1;
        public static final int TRANSACTION_onPanelCancel = 3;
        public static final int TRANSACTION_onPanelHeightChanged = 5;
        public static final int TRANSACTION_onPanelShow = 4;
        public static final int TRANSACTION_onReply = 2;
        public static final int TRANSACTION_requestToShowInputPanel = 6;
        public static final int TRANSACTION_requestToShowInputPanelWithMeta = 8;

        public static class Proxy implements IAssistantInteractionListener {
            public static IAssistantInteractionListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onAssistantDied() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantDied();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onAssistantTakeOver() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantTakeOver();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelCancel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelCancel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelHeightChanged(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelHeightChanged(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelShow(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelShow(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onReply(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onReply(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void requestToShowInputPanel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void requestToShowInputPanelWithMeta(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanelWithMeta(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAssistantInteractionListener asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAssistantInteractionListener.class) == false) goto L13;
            return (IAssistantInteractionListener) ZeusTransformUtils.preCheckCast(r0, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IAssistantInteractionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAssistantInteractionListener r2) {
            IAssistantInteractionListener r3 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            requestToShowInputPanelWithMeta(r5.readString());
        L8:
            r6.writeNoException();
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            onAssistantDied();
            goto L8
        L11:
            r5.enforceInterface(DESCRIPTOR);
            requestToShowInputPanel();
            goto L8
        L12:
            r5.enforceInterface(DESCRIPTOR);
            onPanelHeightChanged(r5.readInt());
            goto L8
        L13:
            r5.enforceInterface(DESCRIPTOR);
            onPanelShow(r5.readInt());
            goto L8
        L14:
            r5.enforceInterface(DESCRIPTOR);
            onPanelCancel();
            goto L8
        L15:
            r5.enforceInterface(DESCRIPTOR);
            onReply(r5.readString());
            goto L8
        L16:
            r5.enforceInterface(DESCRIPTOR);
            onAssistantTakeOver();
            goto L8
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(DESCRIPTOR);
            return true;
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
