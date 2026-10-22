package com.obric.cae.libs.location.poi;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarAoiBoardCallback extends IInterface {
    public static final int AOI_BOARD_EVENT_ENTER = 1;
    public static final int AOI_BOARD_EVENT_EXIT = 2;
    public static final int AOI_BOARD_EVENT_UNKNOWN = 0;
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardCallback";

    public static class Default implements IStarAoiBoardCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
        public void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardCallback {
        static final int TRANSACTION_onAoiBoardBreachReport = 1;

        public static class Proxy implements IStarAoiBoardCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStarAoiBoardCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
            public void onAoiBoardBreachReport(AoiBoard r4, Location r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                if (r5 == null) goto L11;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L12:
                r0.writeInt(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
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
            attachInterface(this, IStarAoiBoardCallback.DESCRIPTOR);
        }

        public static IStarAoiBoardCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarAoiBoardCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarAoiBoardCallback) == false) goto L12;
            return (IStarAoiBoardCallback) r0;
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
            r5.enforceInterface(IStarAoiBoardCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onAoiBoardBreachReport((AoiBoard) _Parcel.a(r5, AoiBoard.CREATOR), (Location) _Parcel.a(r5, Location.CREATOR), r5.readInt());
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IStarAoiBoardCallback.DESCRIPTOR);
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

    void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3) throws RemoteException;
}
