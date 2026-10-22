package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarGeofenceManager extends IInterface {

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r1) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r1) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r1, String r2) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r1) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r1) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r1) {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r1) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r1, IStarGeofenceCallback r2) {
            IStarGeofenceCallback r0 = (IStarGeofenceCallback) ZeusTransformUtils.wrapperContextForParams(r2, IStarGeofenceCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r1, int r2, StarGeofence r3) {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r1) {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2) {
            IStarGeofenceCallback r0 = (IStarGeofenceCallback) ZeusTransformUtils.wrapperContextForParams(r2, IStarGeofenceCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r1) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
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
            public static IStarGeofenceManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().addGeofence(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
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
            public byte deleteGeofence(StarGeofence r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().deleteGeofence(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                byte r4 = r1.readByte();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                byte r7 = Stub.getDefaultImpl().deleteGeofenceById(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                StarGeofence r4 = (StarGeofence) ZeusTransformUtils.preCheckCast(StarGeofence.CREATOR.createFromParcel(r1), StarGeofence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                StarGeofence r6 = Stub.getDefaultImpl().findGeofenceById(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ComponentName r4 = (ComponentName) ZeusTransformUtils.preCheckCast(ComponentName.CREATOR.createFromParcel(r1), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ComponentName r6 = Stub.getDefaultImpl().getComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() {
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
                String r5 = Stub.getDefaultImpl().getVendorVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isStarGeofencesRecovered();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<StarGeofence> r6 = Stub.getDefaultImpl().listGeofences(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().registerComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r5, IStarGeofenceCallback r6) {
                IStarGeofenceCallback r7 = (IStarGeofenceCallback) ZeusTransformUtils.wrapperContextForParams(r6, IStarGeofenceCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerGeofenceCallback(r5, r7);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r5, int r6, StarGeofence r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L23
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L12:
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() == 0) goto L21;
                r7.readFromParcel(r1);     // Catch: Throwable -> L23
            L21:
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendDebugEvent(r5, r6, r7);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                byte r4 = r1.readByte();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().unregisterComponent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r5, IStarGeofenceCallback r6) {
                IStarGeofenceCallback r7 = (IStarGeofenceCallback) ZeusTransformUtils.wrapperContextForParams(r6, IStarGeofenceCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterGeofenceCallback(r5, r7);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                byte r4 = r1.readByte();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r5.readFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r6 = Stub.getDefaultImpl().updateGeofence(r5);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarGeofenceManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IStarGeofenceManager.class) == false) goto L13;
            return (IStarGeofenceManager) ZeusTransformUtils.preCheckCast(r0, IStarGeofenceManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IStarGeofenceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarGeofenceManager r2) {
            IStarGeofenceManager r3 = (IStarGeofenceManager) ZeusTransformUtils.wrapperContextForParams(r2, IStarGeofenceManager.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            if (r6 == 1598968902) goto L70;
            ComponentName r4 = null;
            StarGeofence r5 = null;
            StarGeofence r10 = null;
            StarGeofence r11 = null;
            StarGeofence r12 = null;
            ComponentName r13 = null;
            switch(r6) {
                case 1: goto L68;
                case 2: goto L63;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L48;
                case 6: goto L43;
                case 7: goto L41;
                case 8: goto L33;
                case 9: goto L31;
                case 10: goto L26;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L10;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r7.enforceInterface(DESCRIPTOR);
            boolean r14 = isStarGeofencesRecovered();
            r8.writeNoException();
            r8.writeInt(r14 ? 1 : 0);
            return true;
        L10:
            r7.enforceInterface(DESCRIPTOR);
            unregisterGeofenceCallback(r7.readString(), IStarGeofenceCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L12:
            r7.enforceInterface(DESCRIPTOR);
            registerGeofenceCallback(r7.readString(), IStarGeofenceCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L14:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L17;
            Location r15 = (Location) ZeusTransformUtils.preCheckCast(Location.CREATOR.createFromParcel(r7), Location.class, "com.obric.aiagent.plugin");
        L18:
            int r16 = r7.readInt();
            if (r7.readInt() == 0) goto L21;
            r5 = (StarGeofence) ZeusTransformUtils.preCheckCast(StarGeofence.CREATOR.createFromParcel(r7), StarGeofence.class, "com.obric.aiagent.plugin");
        L21:
            sendDebugEvent(r15, r16, r5);
            r8.writeNoException();
            if (r5 == null) goto L24;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L25:
            return true;
        L24:
            r8.writeInt(0);
            goto L25
        L17:
            r15 = null;
            goto L18
        L26:
            r7.enforceInterface(DESCRIPTOR);
            StarGeofence r17 = findGeofenceById(r7.readString());
            r8.writeNoException();
            if (r17 == null) goto L29;
            r8.writeInt(1);
            r17.writeToParcel(r8, 1);
        L30:
            return true;
        L29:
            r8.writeInt(0);
            goto L30
        L31:
            r7.enforceInterface(DESCRIPTOR);
            List<StarGeofence> r18 = listGeofences(r7.readString());
            r8.writeNoException();
            r8.writeTypedList(r18);
            return true;
        L33:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L36;
            r10 = (StarGeofence) ZeusTransformUtils.preCheckCast(StarGeofence.CREATOR.createFromParcel(r7), StarGeofence.class, "com.obric.aiagent.plugin");
        L36:
            byte r19 = updateGeofence(r10);
            r8.writeNoException();
            r8.writeByte(r19);
            if (r10 == null) goto L39;
            r8.writeInt(1);
            r10.writeToParcel(r8, 1);
        L40:
            return true;
        L39:
            r8.writeInt(0);
            goto L40
        L41:
            r7.enforceInterface(DESCRIPTOR);
            byte r20 = deleteGeofenceById(r7.readString(), r7.readString());
            r8.writeNoException();
            r8.writeByte(r20);
            return true;
        L43:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L46;
            r11 = (StarGeofence) ZeusTransformUtils.preCheckCast(StarGeofence.CREATOR.createFromParcel(r7), StarGeofence.class, "com.obric.aiagent.plugin");
        L46:
            byte r21 = deleteGeofence(r11);
            r8.writeNoException();
            r8.writeByte(r21);
            return true;
        L48:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L51;
            r12 = (StarGeofence) ZeusTransformUtils.preCheckCast(StarGeofence.CREATOR.createFromParcel(r7), StarGeofence.class, "com.obric.aiagent.plugin");
        L51:
            byte r22 = addGeofence(r12);
            r8.writeNoException();
            r8.writeByte(r22);
            return true;
        L53:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L56;
            r13 = (ComponentName) ZeusTransformUtils.preCheckCast(ComponentName.CREATOR.createFromParcel(r7), ComponentName.class, "com.obric.aiagent.plugin");
        L56:
            byte r23 = unregisterComponent(r13);
            r8.writeNoException();
            r8.writeByte(r23);
            return true;
        L58:
            r7.enforceInterface(DESCRIPTOR);
            ComponentName r24 = getComponent(r7.readString());
            r8.writeNoException();
            if (r24 == null) goto L61;
            r8.writeInt(1);
            r24.writeToParcel(r8, 1);
        L62:
            return true;
        L61:
            r8.writeInt(0);
            goto L62
        L63:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L66;
            r4 = (ComponentName) ZeusTransformUtils.preCheckCast(ComponentName.CREATOR.createFromParcel(r7), ComponentName.class, "com.obric.aiagent.plugin");
        L66:
            byte r25 = registerComponent(r4);
            r8.writeNoException();
            r8.writeByte(r25);
            return true;
        L68:
            r7.enforceInterface(DESCRIPTOR);
            String r26 = getVendorVersion();
            r8.writeNoException();
            r8.writeString(r26);
            return true;
        L7:
            return super.onTransact(r6, r7, r8, r9);
        L70:
            r8.writeString(DESCRIPTOR);
            return true;
        }
    }

    byte addGeofence(StarGeofence r1);

    byte deleteGeofence(StarGeofence r1);

    byte deleteGeofenceById(String r1, String r2);

    StarGeofence findGeofenceById(String r1);

    ComponentName getComponent(String r1);

    String getVendorVersion();

    boolean isStarGeofencesRecovered();

    List<StarGeofence> listGeofences(String r1);

    byte registerComponent(ComponentName r1);

    void registerGeofenceCallback(String r1, IStarGeofenceCallback r2);

    void sendDebugEvent(Location r1, int r2, StarGeofence r3);

    byte unregisterComponent(ComponentName r1);

    void unregisterGeofenceCallback(String r1, IStarGeofenceCallback r2);

    byte updateGeofence(StarGeofence r1);
}
