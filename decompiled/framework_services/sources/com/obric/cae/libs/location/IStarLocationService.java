package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import com.obric.cae.libs.location.poi.IStarPoiManager;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarLocationService extends IInterface {
    public static final int CITY_LISTEN_LEVEL1 = 1;
    public static final int CITY_LISTEN_LEVEL2 = 2;
    public static final int CITY_LISTEN_LEVEL3 = 3;
    public static final int CITY_LISTEN_LEVEL4 = 4;
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
    public static final int DIRECTION_TYPE_DRIVING = 2;
    public static final int DIRECTION_TYPE_RIDING = 4;
    public static final int DIRECTION_TYPE_TRANSIT = 1;
    public static final int DIRECTION_TYPE_WALKING = 3;

    public static class Default implements IStarLocationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getCommSenseAARVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Address getCurCityInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLastKnownLocationFromZpp(int r1, String r2) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarPoiManager getStarPoiManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        static final int TRANSACTION_getCommSenseAARVersion = 14;
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLastKnownLocationFromZpp = 13;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarPoiManager = 15;
        static final int TRANSACTION_getStarVersion = 1;
        static final int TRANSACTION_registerCityCallback = 7;
        static final int TRANSACTION_runIndoorCheck = 6;
        static final int TRANSACTION_searchDirectionFromBmap = 9;
        static final int TRANSACTION_searchDirectionFromBmapByAddress = 10;
        static final int TRANSACTION_searchPoiTextFromBd = 5;
        static final int TRANSACTION_unregisterCityCallback = 8;

        public static class Proxy implements IStarLocationService {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getCommSenseAARVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r2 = Address.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Address r4 = (Address) r3;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                r3 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IStarLocationService.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLastKnownLocationFromZpp(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r6 = Location.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Location r8 = (Location) r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r2 = Location.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Location r4 = (Location) r3;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                r3 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r2 = Location.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Location r4 = (Location) r3;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                r3 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                IStarAoiBoardManager r2 = IStarAoiBoardManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                IStarGeofenceManager r2 = IStarGeofenceManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarPoiManager getStarPoiManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                IStarPoiManager r2 = IStarPoiManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r4, IStarLocationCityCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r4, double r6, double r8, double r10, byte r12, byte r13, Map r14, int r15) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeDouble(r4);     // Catch: Throwable -> L6
                r0.writeDouble(r6);     // Catch: Throwable -> L6
                r0.writeDouble(r8);     // Catch: Throwable -> L6
                r0.writeDouble(r10);     // Catch: Throwable -> L6
                r0.writeByte(r12);     // Catch: Throwable -> L6
                r0.writeByte(r13);     // Catch: Throwable -> L6
                r0.writeMap(r14);     // Catch: Throwable -> L6
                r0.writeInt(r15);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r5 = Bundle.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r7 = r5.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Bundle r9 = (Bundle) r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r9;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r4, double r6, String r8, byte r9, byte r10, Map r11, int r12) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeDouble(r4);     // Catch: Throwable -> L6
                r0.writeDouble(r6);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                r0.writeByte(r9);     // Catch: Throwable -> L6
                r0.writeByte(r10);     // Catch: Throwable -> L6
                r0.writeMap(r11);     // Catch: Throwable -> L6
                r0.writeInt(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r5 = Bundle.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r7 = r5.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Bundle r13 = (Bundle) r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r13;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r4, int r5, int r6, String r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r9 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IStarLocationService.DESCRIPTOR);
        }

        public static IStarLocationService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarLocationService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarLocationService) == false) goto L12;
            return (IStarLocationService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r18, Parcel r19, Parcel r20, int r21) throws RemoteException {
            if (r18 < 1) goto L8;
            if (r18 > 16777215) goto L8;
            r19.enforceInterface(IStarLocationService.DESCRIPTOR);
        L8:
            if (r18 == 1598968902) goto L28;
            switch(r18) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                default: goto L11;
            };
        L12:
            IStarPoiManager r0 = getStarPoiManager();
            r20.writeNoException();
            r20.writeStrongInterface(r0);
        L27:
            return true;
        L13:
            String r1 = getCommSenseAARVersion();
            r20.writeNoException();
            r20.writeString(r1);
            goto L27
        L14:
            Location r2 = getLastKnownLocationFromZpp(r19.readInt(), r19.readString());
            r20.writeNoException();
            _Parcel.a(r20, r2);
            goto L27
        L15:
            Address r3 = getCurCityInfo();
            r20.writeNoException();
            _Parcel.a(r20, r3);
            goto L27
        L16:
            IStarAoiBoardManager r4 = getStarAoiBoardManager();
            r20.writeNoException();
            r20.writeStrongInterface(r4);
            goto L27
        L17:
            Bundle r5 = searchDirectionFromBmapByAddress(r19.readDouble(), r19.readDouble(), r19.readString(), r19.readByte(), r19.readByte(), r19.readHashMap(getClass().getClassLoader()), r19.readInt());
            r20.writeNoException();
            _Parcel.a(r20, r5);
            goto L27
        L18:
            Bundle r6 = searchDirectionFromBmap(r19.readDouble(), r19.readDouble(), r19.readDouble(), r19.readDouble(), r19.readByte(), r19.readByte(), r19.readHashMap(getClass().getClassLoader()), r19.readInt());
            r20.writeNoException();
            _Parcel.a(r20, r6);
            goto L27
        L19:
            unregisterCityCallback();
            r20.writeNoException();
            goto L27
        L20:
            registerCityCallback(r19.readInt(), IStarLocationCityCallback.Stub.asInterface(r19.readStrongBinder()));
            r20.writeNoException();
            goto L27
        L21:
            runIndoorCheck(r19.readLong());
            r20.writeNoException();
            goto L27
        L22:
            String r7 = searchPoiTextFromBd(r19.readString(), r19.readInt(), r19.readInt(), r19.readString(), r19.readString());
            r20.writeNoException();
            r20.writeString(r7);
            goto L27
        L23:
            Location r8 = getLocationFromBdGeo();
            r20.writeNoException();
            _Parcel.a(r20, r8);
            goto L27
        L24:
            Location r9 = getLocationFromZpp();
            r20.writeNoException();
            _Parcel.a(r20, r9);
            goto L27
        L25:
            IStarGeofenceManager r10 = getStarGeofenceManager();
            r20.writeNoException();
            r20.writeStrongInterface(r10);
            goto L27
        L26:
            String r11 = getStarVersion();
            r20.writeNoException();
            r20.writeString(r11);
            goto L27
        L11:
            return super.onTransact(r18, r19, r20, r21);
        L28:
            r20.writeString(IStarLocationService.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static void a(Parcel r1, Parcelable r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    String getCommSenseAARVersion() throws RemoteException;

    Address getCurCityInfo() throws RemoteException;

    Location getLastKnownLocationFromZpp(int r1, String r2) throws RemoteException;

    Location getLocationFromBdGeo() throws RemoteException;

    Location getLocationFromZpp() throws RemoteException;

    IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException;

    IStarGeofenceManager getStarGeofenceManager() throws RemoteException;

    IStarPoiManager getStarPoiManager() throws RemoteException;

    String getStarVersion() throws RemoteException;

    void registerCityCallback(int r1, IStarLocationCityCallback r2) throws RemoteException;

    void runIndoorCheck(long r1) throws RemoteException;

    Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) throws RemoteException;

    Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) throws RemoteException;

    String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) throws RemoteException;

    void unregisterCityCallback() throws RemoteException;
}
