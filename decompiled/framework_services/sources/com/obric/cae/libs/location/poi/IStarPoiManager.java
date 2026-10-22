package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarPoiManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarPoiManager";

    public static class Default implements IStarPoiManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getLastNearPoiExtras() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getPoiDetectInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public int getPoiDetectState() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void registerNearPoiCallback(IStarPoiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setDebugBypassNearPoiCheck(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setPoiDetectStateDebug(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setStationaryDelaySeconds(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void triggerNearPoiLocation() throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void unregisterNearPoiCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarPoiManager {
        static final int TRANSACTION_getLastNearPoiExtras = 3;
        static final int TRANSACTION_getPoiDetectInfo = 5;
        static final int TRANSACTION_getPoiDetectState = 4;
        static final int TRANSACTION_registerNearPoiCallback = 1;
        static final int TRANSACTION_setDebugBypassNearPoiCheck = 8;
        static final int TRANSACTION_setPoiDetectStateDebug = 6;
        static final int TRANSACTION_setStationaryDelaySeconds = 9;
        static final int TRANSACTION_triggerNearPoiLocation = 7;
        static final int TRANSACTION_unregisterNearPoiCallback = 2;

        public static class Proxy implements IStarPoiManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStarPoiManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public Bundle getLastNearPoiExtras() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r2 = Bundle.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Bundle r4 = (Bundle) r3;     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public Bundle getPoiDetectInfo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator r2 = Bundle.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                Object r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                Bundle r4 = (Bundle) r3;     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public int getPoiDetectState() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void registerNearPoiCallback(IStarPoiCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setDebugBypassNearPoiCheck(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setPoiDetectStateDebug(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void setStationaryDelaySeconds(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void triggerNearPoiLocation() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiManager
            public void unregisterNearPoiCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarPoiManager.DESCRIPTOR);     // Catch: Throwable -> L6
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
            attachInterface(this, IStarPoiManager.DESCRIPTOR);
        }

        public static IStarPoiManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarPoiManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarPoiManager) == false) goto L12;
            return (IStarPoiManager) r0;
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
            r5.enforceInterface(IStarPoiManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L26;
            switch(r4) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L14;
                case 9: goto L12;
                default: goto L11;
            };
        L12:
            setStationaryDelaySeconds(r5.readInt());
        L25:
            return true;
        L18:
            triggerNearPoiLocation();
            goto L25
        L19:
            setPoiDetectStateDebug(r5.readInt());
            goto L25
        L20:
            Bundle r8 = getPoiDetectInfo();
            r6.writeNoException();
            _Parcel.a(r6, r8);
            goto L25
        L21:
            int r9 = getPoiDetectState();
            r6.writeNoException();
            r6.writeInt(r9);
            goto L25
        L22:
            Bundle r10 = getLastNearPoiExtras();
            r6.writeNoException();
            _Parcel.a(r6, r10);
            goto L25
        L23:
            unregisterNearPoiCallback();
            goto L25
        L24:
            registerNearPoiCallback(IStarPoiCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L25
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            if (r5.readInt() == 0) goto L16;
            boolean r11 = true;
        L17:
            setDebugBypassNearPoiCheck(r11);
            goto L25
        L16:
            r11 = false;
            goto L17
        L26:
            r6.writeString(IStarPoiManager.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static void a(Parcel r1, Bundle r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    Bundle getLastNearPoiExtras() throws RemoteException;

    Bundle getPoiDetectInfo() throws RemoteException;

    int getPoiDetectState() throws RemoteException;

    void registerNearPoiCallback(IStarPoiCallback r1) throws RemoteException;

    void setDebugBypassNearPoiCheck(boolean r1) throws RemoteException;

    void setPoiDetectStateDebug(int r1) throws RemoteException;

    void setStationaryDelaySeconds(int r1) throws RemoteException;

    void triggerNearPoiLocation() throws RemoteException;

    void unregisterNearPoiCallback() throws RemoteException;
}
