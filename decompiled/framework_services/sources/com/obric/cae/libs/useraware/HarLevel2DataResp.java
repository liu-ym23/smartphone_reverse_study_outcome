package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface HarLevel2DataResp extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.useraware.HarLevel2DataResp";

    public static class Default implements HarLevel2DataResp {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onCollectStats(boolean r1, ParcelFileDescriptor r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
        public void onDataReady(int r1, int r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements HarLevel2DataResp {
        static final int TRANSACTION_onCollectStats = 1;
        static final int TRANSACTION_onDataReady = 2;

        public static class Proxy implements HarLevel2DataResp {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return HarLevel2DataResp.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onCollectStats(boolean r3, ParcelFileDescriptor r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(HarLevel2DataResp.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3 ? 1 : 0);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.HarLevel2DataResp
            public void onDataReady(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(HarLevel2DataResp.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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
            attachInterface(this, HarLevel2DataResp.DESCRIPTOR);
        }

        public static HarLevel2DataResp asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(HarLevel2DataResp.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof HarLevel2DataResp) == false) goto L12;
            return (HarLevel2DataResp) r0;
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
            r5.enforceInterface(HarLevel2DataResp.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 == 1) goto L16;
            if (r4 != 2) goto L13;
            onDataReady(r5.readInt(), r5.readInt());
        L20:
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L16:
            if (r5.readInt() == 0) goto L18;
            boolean r8 = true;
        L19:
            onCollectStats(r8, (ParcelFileDescriptor) _Parcel.a(r5, ParcelFileDescriptor.CREATOR));
            goto L20
        L18:
            r8 = false;
            goto L19
        L21:
            r6.writeString(HarLevel2DataResp.DESCRIPTOR);
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

    void onCollectStats(boolean r1, ParcelFileDescriptor r2) throws RemoteException;

    void onDataReady(int r1, int r2) throws RemoteException;
}
