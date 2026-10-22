package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarPoiCallback extends IInterface {
    public static final String AOI_CONFIDENCE = "aoi_confidence";
    public static final String AOI_ID = "aoi_id";
    public static final String AOI_NAME = "aoi_name";
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarPoiCallback";
    public static final String IS_ACC_QUALIFIED_POI = "is_acc_qualified_poi";
    public static final String NEAR_THE_AOI = "near_the_aoi";
    public static final String NEAR_THE_POI = "near_the_poi";
    public static final String NEW_TYPE_CODE_L1 = "new_type_code_l1";
    public static final String NEW_TYPE_CODE_L2 = "new_type_code_l2";
    public static final String NEW_TYPE_CODE_L3 = "new_type_code_l3";
    public static final String NEW_TYPE_NAME_L1 = "new_type_name_l1";
    public static final String NEW_TYPE_NAME_L2 = "new_type_name_l2";
    public static final String NEW_TYPE_NAME_L3 = "new_type_name_l3";
    public static final String POI_CONFIDENCE = "poi_confidence";
    public static final String POI_ID = "poi_id";
    public static final String POI_NAME = "poi_name";
    public static final String SCENE_LOGID = "scene_logid";
    public static final String SDK_LOGID = "sdk_logid";
    public static final String TIMESTAMP = "timestamp";

    public static class Default implements IStarPoiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiCallback
        public void onNearPoiReport(Bundle r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarPoiCallback {
        static final int TRANSACTION_onNearPoiReport = 1;

        public static class Proxy implements IStarPoiCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStarPoiCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiCallback
            public void onNearPoiReport(Bundle r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiCallback.DESCRIPTOR);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IStarPoiCallback.DESCRIPTOR);
        }

        public static IStarPoiCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarPoiCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarPoiCallback) == false) goto L12;
            return (IStarPoiCallback) r0;
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
            r5.enforceInterface(IStarPoiCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onNearPoiReport((Bundle) _Parcel.a(r5, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IStarPoiCallback.DESCRIPTOR);
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

    void onNearPoiReport(Bundle r1) throws RemoteException;
}
