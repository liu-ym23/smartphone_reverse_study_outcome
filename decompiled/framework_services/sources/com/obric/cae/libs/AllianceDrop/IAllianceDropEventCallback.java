package com.obric.cae.libs.AllianceDrop;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IAllianceDropEventCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback";

    public static class Default implements IAllianceDropEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onDeviceFound(List<AllianceDropDevice> r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onHandshake(AllianceDropEvent r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onProgressUpdate(int r1, int r2, int r3, List<AllianceDropShareItem> r4) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onTransferComplete(int r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onTransferError(int r1, int r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
        public void onTransferIncoming(AllianceDropEvent r1, AllianceDropTransferInfo r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAllianceDropEventCallback {
        static final int TRANSACTION_onDeviceFound = 1;
        static final int TRANSACTION_onHandshake = 2;
        static final int TRANSACTION_onProgressUpdate = 4;
        static final int TRANSACTION_onTransferComplete = 5;
        static final int TRANSACTION_onTransferError = 6;
        static final int TRANSACTION_onTransferIncoming = 3;

        public static class Proxy implements IAllianceDropEventCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAllianceDropEventCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onDeviceFound(List<AllianceDropDevice> r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onHandshake(AllianceDropEvent r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onProgressUpdate(int r3, int r4, int r5, List<AllianceDropShareItem> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeTypedList(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onTransferComplete(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onTransferError(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.AllianceDrop.IAllianceDropEventCallback
            public void onTransferIncoming(AllianceDropEvent r4, AllianceDropTransferInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAllianceDropEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                if (r5 == null) goto L11;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IAllianceDropEventCallback.DESCRIPTOR);
        }

        public static IAllianceDropEventCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAllianceDropEventCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAllianceDropEventCallback) == false) goto L12;
            return (IAllianceDropEventCallback) r0;
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
            r5.enforceInterface(IAllianceDropEventCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            onTransferError(r5.readInt(), r5.readInt());
        L18:
            return true;
        L13:
            onTransferComplete(r5.readInt(), r5.readString());
            goto L18
        L14:
            onProgressUpdate(r5.readInt(), r5.readInt(), r5.readInt(), r5.createTypedArrayList(AllianceDropShareItem.CREATOR));
            goto L18
        L15:
            onTransferIncoming((AllianceDropEvent) _Parcel.a(r5, AllianceDropEvent.CREATOR), (AllianceDropTransferInfo) _Parcel.a(r5, AllianceDropTransferInfo.CREATOR));
            goto L18
        L16:
            onHandshake((AllianceDropEvent) _Parcel.a(r5, AllianceDropEvent.CREATOR));
            goto L18
        L17:
            onDeviceFound(r5.createTypedArrayList(AllianceDropDevice.CREATOR));
            goto L18
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString(IAllianceDropEventCallback.DESCRIPTOR);
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

    void onDeviceFound(List<AllianceDropDevice> r1) throws RemoteException;

    void onHandshake(AllianceDropEvent r1) throws RemoteException;

    void onProgressUpdate(int r1, int r2, int r3, List<AllianceDropShareItem> r4) throws RemoteException;

    void onTransferComplete(int r1, String r2) throws RemoteException;

    void onTransferError(int r1, int r2) throws RemoteException;

    void onTransferIncoming(AllianceDropEvent r1, AllianceDropTransferInfo r2) throws RemoteException;
}
