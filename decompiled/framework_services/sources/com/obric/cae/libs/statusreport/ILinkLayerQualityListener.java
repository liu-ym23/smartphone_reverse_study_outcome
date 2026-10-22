package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ILinkLayerQualityListener extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ILinkLayerQualityListener";

    public static class Default implements ILinkLayerQualityListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILinkLayerQualityListener {
        static final int TRANSACTION_onAverLinkLayerLevelChanged = 3;
        static final int TRANSACTION_onLinkLayerLevelChanged = 2;
        static final int TRANSACTION_onLinkLayerQualityChanged = 1;

        public static class Proxy implements ILinkLayerQualityListener {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILinkLayerQualityListener.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onAverLinkLayerLevelChanged(LinkLayerQuality r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ILinkLayerQualityListener.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerLevelChanged(LinkLayerQuality r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ILinkLayerQualityListener.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerQualityChanged(LinkLayerQuality r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ILinkLayerQualityListener.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ILinkLayerQualityListener.DESCRIPTOR);
        }

        public static ILinkLayerQualityListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ILinkLayerQualityListener.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ILinkLayerQualityListener) == false) goto L12;
            return (ILinkLayerQualityListener) r0;
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
            r5.enforceInterface(ILinkLayerQualityListener.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            onLinkLayerQualityChanged((LinkLayerQuality) _Parcel.a(r5, LinkLayerQuality.CREATOR));
            r6.writeNoException();
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onLinkLayerLevelChanged((LinkLayerQuality) _Parcel.a(r5, LinkLayerQuality.CREATOR));
            r6.writeNoException();
            goto L19
        L13:
            if (r4 != 3) goto L15;
            onAverLinkLayerLevelChanged((LinkLayerQuality) _Parcel.a(r5, LinkLayerQuality.CREATOR));
            r6.writeNoException();
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ILinkLayerQualityListener.DESCRIPTOR);
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

    void onAverLinkLayerLevelChanged(LinkLayerQuality r1) throws RemoteException;

    void onLinkLayerLevelChanged(LinkLayerQuality r1) throws RemoteException;

    void onLinkLayerQualityChanged(LinkLayerQuality r1) throws RemoteException;
}
