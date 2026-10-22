package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarGeofenceManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceByPoiId(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r1) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_findGeofenceByPoiId = 15;
        static final int TRANSACTION_getComponent = 3;
        static final int TRANSACTION_getVendorVersion = 1;
        static final int TRANSACTION_isStarGeofencesRecovered = 14;
        static final int TRANSACTION_listGeofences = 9;
        static final int TRANSACTION_registerComponent = 2;
        static final int TRANSACTION_registerGeofenceCallback = 12;
        static final int TRANSACTION_sendDebugEvent = 11;
        static final int TRANSACTION_unregisterComponent = 4;
        static final int TRANSACTION_unregisterGeofenceCallback = 13;
        static final int TRANSACTION_updateGeofence = 8;

        public static class Proxy implements IStarGeofenceManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r6 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofence(StarGeofence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r6 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r6 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<StarGeofence> r6 = StarGeofence.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                StarGeofence r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                StarGeofence r8 = r7;     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceByPoiId(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<StarGeofence> r6 = StarGeofence.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                StarGeofence r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                StarGeofence r8 = r7;     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r6 = ComponentName.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                ComponentName r8 = (ComponentName) r7;     // Catch: Throwable -> L6
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

            public String getInterfaceDescriptor() {
                return IStarGeofenceManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r6 = r1.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r6 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r4, IStarGeofenceCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r4, int r5, StarGeofence r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L7
                _Parcel.a(r0, r4, 0);     // Catch: Throwable -> L7
                r0.writeInt(r5);     // Catch: Throwable -> L7
                _Parcel.a(r0, r6, 0);     // Catch: Throwable -> L7
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L7
                r1.readException();     // Catch: Throwable -> L7
                if (r1.readInt() == 0) goto L9;
                r6.readFromParcel(r1);     // Catch: Throwable -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte r6 = r1.readByte();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r4, IStarGeofenceCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarGeofenceManager.DESCRIPTOR);     // Catch: Throwable -> L7
                _Parcel.a(r0, r6, 0);     // Catch: Throwable -> L7
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L7
                r1.readException();     // Catch: Throwable -> L7
                byte r2 = r1.readByte();     // Catch: Throwable -> L7
                if (r1.readInt() == 0) goto L9;
                r6.readFromParcel(r1);     // Catch: Throwable -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IStarGeofenceManager.DESCRIPTOR);
        }

        public static IStarGeofenceManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarGeofenceManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarGeofenceManager) == false) goto L12;
            return (IStarGeofenceManager) r0;
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
            r5.enforceInterface(IStarGeofenceManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L28;
            switch(r4) {
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
            StarGeofence r8 = findGeofenceByPoiId(r5.readString());
            r6.writeNoException();
            _Parcel.a(r6, r8, 1);
        L27:
            return true;
        L13:
            boolean r9 = isStarGeofencesRecovered();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            goto L27
        L14:
            unregisterGeofenceCallback(r5.readString(), IStarGeofenceCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L27
        L15:
            registerGeofenceCallback(r5.readString(), IStarGeofenceCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L27
        L16:
            Location r10 = (Location) _Parcel.a(r5, Location.CREATOR);
            int r11 = r5.readInt();
            StarGeofence r12 = (StarGeofence) _Parcel.a(r5, StarGeofence.CREATOR);
            sendDebugEvent(r10, r11, r12);
            r6.writeNoException();
            _Parcel.a(r6, r12, 1);
            goto L27
        L17:
            StarGeofence r13 = findGeofenceById(r5.readString());
            r6.writeNoException();
            _Parcel.a(r6, r13, 1);
            goto L27
        L18:
            List<StarGeofence> r14 = listGeofences(r5.readString());
            r6.writeNoException();
            r6.writeTypedList(r14);
            goto L27
        L19:
            StarGeofence r15 = (StarGeofence) _Parcel.a(r5, StarGeofence.CREATOR);
            byte r16 = updateGeofence(r15);
            r6.writeNoException();
            r6.writeByte(r16);
            _Parcel.a(r6, r15, 1);
            goto L27
        L20:
            byte r17 = deleteGeofenceById(r5.readString(), r5.readString());
            r6.writeNoException();
            r6.writeByte(r17);
            goto L27
        L21:
            byte r18 = deleteGeofence((StarGeofence) _Parcel.a(r5, StarGeofence.CREATOR));
            r6.writeNoException();
            r6.writeByte(r18);
            goto L27
        L22:
            byte r19 = addGeofence((StarGeofence) _Parcel.a(r5, StarGeofence.CREATOR));
            r6.writeNoException();
            r6.writeByte(r19);
            goto L27
        L23:
            byte r20 = unregisterComponent((ComponentName) _Parcel.a(r5, ComponentName.CREATOR));
            r6.writeNoException();
            r6.writeByte(r20);
            goto L27
        L24:
            ComponentName r21 = getComponent(r5.readString());
            r6.writeNoException();
            _Parcel.a(r6, r21, 1);
            goto L27
        L25:
            byte r22 = registerComponent((ComponentName) _Parcel.a(r5, ComponentName.CREATOR));
            r6.writeNoException();
            r6.writeByte(r22);
            goto L27
        L26:
            String r23 = getVendorVersion();
            r6.writeNoException();
            r6.writeString(r23);
            goto L27
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L28:
            r6.writeString(IStarGeofenceManager.DESCRIPTOR);
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

        public static void a(Parcel r1, Parcelable r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    byte addGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofence(StarGeofence r1) throws RemoteException;

    byte deleteGeofenceById(String r1, String r2) throws RemoteException;

    StarGeofence findGeofenceById(String r1) throws RemoteException;

    StarGeofence findGeofenceByPoiId(String r1) throws RemoteException;

    ComponentName getComponent(String r1) throws RemoteException;

    String getVendorVersion() throws RemoteException;

    boolean isStarGeofencesRecovered() throws RemoteException;

    List<StarGeofence> listGeofences(String r1) throws RemoteException;

    byte registerComponent(ComponentName r1) throws RemoteException;

    void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    void sendDebugEvent(Location r1, int r2, StarGeofence r3) throws RemoteException;

    byte unregisterComponent(ComponentName r1) throws RemoteException;

    void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) throws RemoteException;

    byte updateGeofence(StarGeofence r1) throws RemoteException;
}
