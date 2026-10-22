package com.obric.cae.libs.softap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeSoftApManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.softap.ICaeSoftApManager";

    public static class Default implements ICaeSoftApManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public long getSoftApCapabilityBits() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int getSoftApInterfaceVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public CaeSoftApStatus getStatus() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void registerCallback(ICaeSoftApCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int startSoftAp(CaeSoftApConfig r1, ICaeSoftApCallback r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int stopSoftAp() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void unregisterCallback(ICaeSoftApCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSoftApManager {
        static final int TRANSACTION_getSoftApCapabilityBits = 7;
        static final int TRANSACTION_getSoftApInterfaceVersion = 6;
        static final int TRANSACTION_getStatus = 3;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_startSoftAp = 1;
        static final int TRANSACTION_stopSoftAp = 2;
        static final int TRANSACTION_unregisterCallback = 5;

        public static class Proxy implements ICaeSoftApManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeSoftApManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public long getSoftApCapabilityBits() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int getSoftApInterfaceVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public CaeSoftApStatus getStatus() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<CaeSoftApStatus> r2 = CaeSoftApStatus.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                CaeSoftApStatus r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                CaeSoftApStatus r4 = r3;     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void registerCallback(ICaeSoftApCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int startSoftAp(CaeSoftApConfig r4, ICaeSoftApCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r4, 0);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r6 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int stopSoftAp() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void unregisterCallback(ICaeSoftApCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSoftApManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeSoftApManager.DESCRIPTOR);
        }

        public static ICaeSoftApManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeSoftApManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeSoftApManager) == false) goto L12;
            return (ICaeSoftApManager) r0;
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
            r5.enforceInterface(ICaeSoftApManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            switch(r4) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            long r8 = getSoftApCapabilityBits();
            r6.writeNoException();
            r6.writeLong(r8);
        L19:
            return true;
        L13:
            int r9 = getSoftApInterfaceVersion();
            r6.writeNoException();
            r6.writeInt(r9);
            goto L19
        L14:
            unregisterCallback(ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L19
        L15:
            registerCallback(ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L19
        L16:
            CaeSoftApStatus r10 = getStatus();
            r6.writeNoException();
            _Parcel.a(r6, r10, 1);
            goto L19
        L17:
            int r11 = stopSoftAp();
            r6.writeNoException();
            r6.writeInt(r11);
            goto L19
        L18:
            int r12 = startSoftAp((CaeSoftApConfig) _Parcel.a(r5, CaeSoftApConfig.CREATOR), ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r12);
            goto L19
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ICaeSoftApManager.DESCRIPTOR);
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

    long getSoftApCapabilityBits() throws RemoteException;

    int getSoftApInterfaceVersion() throws RemoteException;

    CaeSoftApStatus getStatus() throws RemoteException;

    void registerCallback(ICaeSoftApCallback r1) throws RemoteException;

    int startSoftAp(CaeSoftApConfig r1, ICaeSoftApCallback r2) throws RemoteException;

    int stopSoftAp() throws RemoteException;

    void unregisterCallback(ICaeSoftApCallback r1) throws RemoteException;
}
