package com.obric.cae.libs.location.geofence;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarGeofenceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceCallback";
    public static final int GEOFENCE_GEN_ALERT_GNSS_AVAILABLE = 2;
    public static final int GEOFENCE_GEN_ALERT_GNSS_UNAVAILABLE = 1;
    public static final int GEOFENCE_GEN_ALERT_OOS = 3;
    public static final int GEOFENCE_GEN_ALERT_TIME_INVALID = 4;

    public static class Default implements IStarGeofenceCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onBreachReport(String r1, Location r2, int r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onGeofenceStatusReport(int r1, Location r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceCallback {
        static final int TRANSACTION_onBreachReport = 1;
        static final int TRANSACTION_onGeofenceStatusReport = 2;

        public static class Proxy implements IStarGeofenceCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStarGeofenceCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onBreachReport(String r3, Location r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onGeofenceStatusReport(int r4, Location r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IStarGeofenceCallback.DESCRIPTOR);
        }

        public static IStarGeofenceCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarGeofenceCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarGeofenceCallback) == false) goto L12;
            return (IStarGeofenceCallback) r0;
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
            r5.enforceInterface(IStarGeofenceCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            onBreachReport(r5.readString(), (Location) _Parcel.a(r5, Location.CREATOR), r5.readInt());
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onGeofenceStatusReport(r5.readInt(), (Location) _Parcel.a(r5, Location.CREATOR));
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(IStarGeofenceCallback.DESCRIPTOR);
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

    void onBreachReport(String r1, Location r2, int r3) throws RemoteException;

    void onGeofenceStatusReport(int r1, Location r2) throws RemoteException;
}
