package com.obric.cae.libs.accel;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeAccel extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.accel.ICaeAccel";

    public static class Default implements ICaeAccel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAccelEnable(String r1, boolean r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAutoDualWlanMode(String r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageFlowSched(String r1, boolean r2) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeAccel {
        static final int TRANSACTION_setPackageAccelEnable = 1;
        static final int TRANSACTION_setPackageAutoDualWlanMode = 3;
        static final int TRANSACTION_setPackageFlowSched = 2;

        public static class Proxy implements ICaeAccel {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeAccel.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAccelEnable(String r4, boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeAccel.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAutoDualWlanMode(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeAccel.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageFlowSched(String r4, boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeAccel.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, ICaeAccel.DESCRIPTOR);
        }

        public static ICaeAccel asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeAccel.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeAccel) == false) goto L12;
            return (ICaeAccel) r0;
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
            r5.enforceInterface(ICaeAccel.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L27;
            boolean r0 = false;
            if (r4 != 1) goto L12;
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L25;
            r0 = true;
        L25:
            int r9 = setPackageAccelEnable(r8, r0);
            r6.writeNoException();
            r6.writeInt(r9);
        L26:
            return true;
        L12:
            if (r4 != 2) goto L14;
            String r10 = r5.readString();
            if (r5.readInt() == 0) goto L21;
            r0 = true;
        L21:
            int r11 = setPackageFlowSched(r10, r0);
            r6.writeNoException();
            r6.writeInt(r11);
            goto L26
        L14:
            if (r4 != 3) goto L16;
            int r12 = setPackageAutoDualWlanMode(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r12);
            goto L26
        L16:
            return super.onTransact(r4, r5, r6, r7);
        L27:
            r6.writeString(ICaeAccel.DESCRIPTOR);
            return true;
        }
    }

    int setPackageAccelEnable(String r1, boolean r2) throws RemoteException;

    int setPackageAutoDualWlanMode(String r1, int r2) throws RemoteException;

    int setPackageFlowSched(String r1, boolean r2) throws RemoteException;
}
