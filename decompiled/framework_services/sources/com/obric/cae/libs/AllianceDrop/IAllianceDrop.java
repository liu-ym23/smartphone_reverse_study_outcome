package com.obric.cae.libs.AllianceDrop;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IAllianceDrop extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.AllianceDrop.IAllianceDrop";

    public static class Default implements IAllianceDrop {
        public Default() {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void approve(String r1) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void cancelTransfer(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void connect(AllianceDropDevice r1, AllianceDropTransferInfo r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void disconnect(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void registerCallback(IAllianceDropEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void reject(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void startAdvertising() throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void startDiscovery() throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void startShare(AllianceDropTransferInfo r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void stopAdvertising() throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void stopDiscovery() throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
        public void unregisterCallback(IAllianceDropEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAllianceDrop {
        static final int TRANSACTION_approve = 10;
        static final int TRANSACTION_cancelTransfer = 12;
        static final int TRANSACTION_connect = 8;
        static final int TRANSACTION_disconnect = 9;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_reject = 11;
        static final int TRANSACTION_startAdvertising = 5;
        static final int TRANSACTION_startDiscovery = 3;
        static final int TRANSACTION_startShare = 7;
        static final int TRANSACTION_stopAdvertising = 6;
        static final int TRANSACTION_stopDiscovery = 4;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements IAllianceDrop {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void approve(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void cancelTransfer(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void connect(AllianceDropDevice r4, AllianceDropTransferInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                if (r5 == null) goto L11;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L11:
                r0.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void disconnect(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IAllianceDrop.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void registerCallback(IAllianceDropEventCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void reject(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void startAdvertising() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void startDiscovery() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void startShare(AllianceDropTransferInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void stopAdvertising() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void stopDiscovery() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDrop
            public void unregisterCallback(IAllianceDropEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDrop.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IAllianceDrop.DESCRIPTOR);
        }

        public static IAllianceDrop asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAllianceDrop.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAllianceDrop) == false) goto L12;
            return (IAllianceDrop) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAllianceDrop.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L25;
            switch(r4) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                default: goto L11;
            };
        L12:
            cancelTransfer(r5.readString());
        L24:
            return true;
        L13:
            reject(r5.readString());
            goto L24
        L14:
            approve(r5.readString());
            goto L24
        L15:
            disconnect(r5.readString());
            goto L24
        L16:
            connect((AllianceDropDevice) _Parcel.a(r5, AllianceDropDevice.CREATOR), (AllianceDropTransferInfo) _Parcel.a(r5, AllianceDropTransferInfo.CREATOR));
            goto L24
        L17:
            startShare((AllianceDropTransferInfo) _Parcel.a(r5, AllianceDropTransferInfo.CREATOR));
            goto L24
        L18:
            stopAdvertising();
            goto L24
        L19:
            startAdvertising();
            goto L24
        L20:
            stopDiscovery();
            goto L24
        L21:
            startDiscovery();
            goto L24
        L22:
            unregisterCallback(IAllianceDropEventCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L24
        L23:
            registerCallback(IAllianceDropEventCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L24
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L25:
            r6.writeString(IAllianceDrop.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    void approve(String r1) throws RemoteException;

    void cancelTransfer(String r1) throws RemoteException;

    void connect(AllianceDropDevice r1, AllianceDropTransferInfo r2) throws RemoteException;

    void disconnect(String r1) throws RemoteException;

    void registerCallback(IAllianceDropEventCallback r1) throws RemoteException;

    void reject(String r1) throws RemoteException;

    void startAdvertising() throws RemoteException;

    void startDiscovery() throws RemoteException;

    void startShare(AllianceDropTransferInfo r1) throws RemoteException;

    void stopAdvertising() throws RemoteException;

    void stopDiscovery() throws RemoteException;

    void unregisterCallback(IAllianceDropEventCallback r1) throws RemoteException;
}
