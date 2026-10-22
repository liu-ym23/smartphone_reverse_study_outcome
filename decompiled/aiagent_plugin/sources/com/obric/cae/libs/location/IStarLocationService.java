package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarLocationService extends IInterface {
    public static final int CITY_LISTEN_LEVEL1 = 1;
    public static final int CITY_LISTEN_LEVEL2 = 2;
    public static final int CITY_LISTEN_LEVEL3 = 3;
    public static final int CITY_LISTEN_LEVEL4 = 4;
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
        public Address getCurCityInfo() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r1, IStarLocationCityCallback r2) {
            IStarLocationCityCallback r0 = (IStarLocationCityCallback) ZeusTransformUtils.wrapperContextForParams(r2, IStarLocationCityCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r1) {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5) {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarVersion = 1;
        static final int TRANSACTION_registerCityCallback = 7;
        static final int TRANSACTION_runIndoorCheck = 6;
        static final int TRANSACTION_searchDirectionFromBmap = 9;
        static final int TRANSACTION_searchDirectionFromBmapByAddress = 10;
        static final int TRANSACTION_searchPoiTextFromBd = 5;
        static final int TRANSACTION_unregisterCityCallback = 8;

        public static class Proxy implements IStarLocationService {
            public static IStarLocationService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Address r4 = (Address) ZeusTransformUtils.preCheckCast(Address.CREATOR.createFromParcel(r1), Address.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Address r5 = Stub.getDefaultImpl().getCurCityInfo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r4 = (Location) ZeusTransformUtils.preCheckCast(Location.CREATOR.createFromParcel(r1), Location.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r5 = Stub.getDefaultImpl().getLocationFromBdGeo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Location r4 = (Location) ZeusTransformUtils.preCheckCast(Location.CREATOR.createFromParcel(r1), Location.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r5 = Stub.getDefaultImpl().getLocationFromZpp();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarAoiBoardManager r4 = IStarAoiBoardManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarAoiBoardManager r5 = Stub.getDefaultImpl().getStarAoiBoardManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IStarGeofenceManager r4 = IStarGeofenceManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarGeofenceManager r5 = Stub.getDefaultImpl().getStarGeofenceManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getStarVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r5, IStarLocationCityCallback r6) {
                IStarLocationCityCallback r7 = (IStarLocationCityCallback) ZeusTransformUtils.wrapperContextForParams(r6, IStarLocationCityCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCityCallback(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runIndoorCheck(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r17, double r19, double r21, double r23, byte r25, byte r26, Map r27, int r28) {
                Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
                Parcel r15 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r15.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r15.writeDouble(r17);     // Catch: Throwable -> L24
                r15.writeDouble(r19);     // Catch: Throwable -> L24
                r15.writeDouble(r21);     // Catch: Throwable -> L24
                r15.writeDouble(r23);     // Catch: Throwable -> L24
                r15.writeByte(r25);     // Catch: Throwable -> L24
                r15.writeByte(r26);     // Catch: Throwable -> L24
                r15.writeMap(r13);     // Catch: Throwable -> L24
                r15.writeInt(r28);     // Catch: Throwable -> L24
                if (this.mRemote.transact(9, r15, r14, 0) == false) goto L6;
            L14:
                Parcel r2 = r14;
                r2.readException();     // Catch: Throwable -> L22
                if (r2.readInt() == 0) goto L19;
                Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r2), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            L20:
                r2.recycle();
                r15.recycle();
                return r0;
            L19:
                r0 = null;
            L22:
                th = th;
            L26:
                r2.recycle();
                r15.recycle();
                throw th;
            L6:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r1 = Stub.getDefaultImpl().searchDirectionFromBmap(r17, r19, r21, r23, r25, r26, r13, r28);     // Catch: Throwable -> L12
                r14.recycle();
                r15.recycle();
                return r1;
            L12:
                th = th;
                r2 = r14;
            L24:
                th = th;
                r2 = r14;
                goto L26
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r16, double r18, String r20, byte r21, byte r22, Map r23, int r24) {
                Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r12.writeDouble(r16);     // Catch: Throwable -> L17
                r12.writeDouble(r18);     // Catch: Throwable -> L17
                r12.writeString(r20);     // Catch: Throwable -> L17
                r12.writeByte(r21);     // Catch: Throwable -> L17
                r12.writeByte(r22);     // Catch: Throwable -> L17
                r12.writeMap(r10);     // Catch: Throwable -> L17
                r12.writeInt(r24);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L17
                if (r13.readInt() == 0) goto L14;
                Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r13), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r13.recycle();
                r12.recycle();
                return r0;
            L14:
                r0 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r1 = Stub.getDefaultImpl().searchDirectionFromBmapByAddress(r16, r18, r20, r21, r22, r10, r24);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return r1;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r9, int r10, int r11, String r12, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeString(r12);     // Catch: Throwable -> L13
                r0.writeString(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r8 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r14 = Stub.getDefaultImpl().searchPoiTextFromBd(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r14;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterCityCallback();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarLocationService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IStarLocationService.class) == false) goto L13;
            return (IStarLocationService) ZeusTransformUtils.preCheckCast(r0, IStarLocationService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IStarLocationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarLocationService r2) {
            IStarLocationService r3 = (IStarLocationService) ZeusTransformUtils.wrapperContextForParams(r2, IStarLocationService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r19, Parcel r20, Parcel r21, int r22) {
            if (r19 == 1598968902) goto L53;
            IBinder r4 = null;
            switch(r19) {
                case 1: goto L51;
                case 2: goto L46;
                case 3: goto L41;
                case 4: goto L36;
                case 5: goto L34;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L23;
                case 10: goto L18;
                case 11: goto L13;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r20.enforceInterface(DESCRIPTOR);
            Address r0 = getCurCityInfo();
            r21.writeNoException();
            if (r0 == null) goto L11;
            r21.writeInt(1);
            r0.writeToParcel(r21, 1);
        L12:
            return true;
        L11:
            r21.writeInt(0);
            goto L12
        L13:
            r20.enforceInterface(DESCRIPTOR);
            IStarAoiBoardManager r1 = getStarAoiBoardManager();
            r21.writeNoException();
            if (r1 == null) goto L16;
            r4 = r1.asBinder();
        L16:
            r21.writeStrongBinder(r4);
            return true;
        L18:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r2 = searchDirectionFromBmapByAddress(r20.readDouble(), r20.readDouble(), r20.readString(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r2 == null) goto L21;
            r21.writeInt(1);
            r2.writeToParcel(r21, 1);
        L22:
            return true;
        L21:
            r21.writeInt(0);
            goto L22
        L23:
            r20.enforceInterface(DESCRIPTOR);
            Bundle r3 = searchDirectionFromBmap(r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readDouble(), r20.readByte(), r20.readByte(), r20.readHashMap(getClass().getClassLoader()), r20.readInt());
            r21.writeNoException();
            if (r3 == null) goto L26;
            r21.writeInt(1);
            r3.writeToParcel(r21, 1);
        L27:
            return true;
        L26:
            r21.writeInt(0);
            goto L27
        L28:
            r20.enforceInterface(DESCRIPTOR);
            unregisterCityCallback();
            r21.writeNoException();
            return true;
        L30:
            r20.enforceInterface(DESCRIPTOR);
            registerCityCallback(r20.readInt(), IStarLocationCityCallback.Stub.asInterface(r20.readStrongBinder()));
            r21.writeNoException();
            return true;
        L32:
            r20.enforceInterface(DESCRIPTOR);
            runIndoorCheck(r20.readLong());
            r21.writeNoException();
            return true;
        L34:
            r20.enforceInterface(DESCRIPTOR);
            String r5 = searchPoiTextFromBd(r20.readString(), r20.readInt(), r20.readInt(), r20.readString(), r20.readString());
            r21.writeNoException();
            r21.writeString(r5);
            return true;
        L36:
            r20.enforceInterface(DESCRIPTOR);
            Location r6 = getLocationFromBdGeo();
            r21.writeNoException();
            if (r6 == null) goto L39;
            r21.writeInt(1);
            r6.writeToParcel(r21, 1);
        L40:
            return true;
        L39:
            r21.writeInt(0);
            goto L40
        L41:
            r20.enforceInterface(DESCRIPTOR);
            Location r7 = getLocationFromZpp();
            r21.writeNoException();
            if (r7 == null) goto L44;
            r21.writeInt(1);
            r7.writeToParcel(r21, 1);
        L45:
            return true;
        L44:
            r21.writeInt(0);
            goto L45
        L46:
            r20.enforceInterface(DESCRIPTOR);
            IStarGeofenceManager r8 = getStarGeofenceManager();
            r21.writeNoException();
            if (r8 == null) goto L49;
            r4 = r8.asBinder();
        L49:
            r21.writeStrongBinder(r4);
            return true;
        L51:
            r20.enforceInterface(DESCRIPTOR);
            String r9 = getStarVersion();
            r21.writeNoException();
            r21.writeString(r9);
            return true;
        L7:
            return super.onTransact(r19, r20, r21, r22);
        L53:
            r21.writeString(DESCRIPTOR);
            return true;
        }
    }

    Address getCurCityInfo();

    Location getLocationFromBdGeo();

    Location getLocationFromZpp();

    IStarAoiBoardManager getStarAoiBoardManager();

    IStarGeofenceManager getStarGeofenceManager();

    String getStarVersion();

    void registerCityCallback(int r1, IStarLocationCityCallback r2);

    void runIndoorCheck(long r1);

    Bundle searchDirectionFromBmap(double r1, double r3, double r5, double r7, byte r9, byte r10, Map r11, int r12);

    Bundle searchDirectionFromBmapByAddress(double r1, double r3, String r5, byte r6, byte r7, Map r8, int r9);

    String searchPoiTextFromBd(String r1, int r2, int r3, String r4, String r5);

    void unregisterCityCallback();
}
