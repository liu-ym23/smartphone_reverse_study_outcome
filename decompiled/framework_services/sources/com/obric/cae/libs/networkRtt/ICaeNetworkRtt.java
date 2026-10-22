package com.obric.cae.libs.networkRtt;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNetworkRtt extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.networkRtt.ICaeNetworkRtt";

    public static class Default implements ICaeNetworkRtt {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
        public int getGameRttbyUid(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
        public int getRttByUid(int r1) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkRtt {
        static final int TRANSACTION_getGameRttbyUid = 2;
        static final int TRANSACTION_getRttByUid = 1;

        public static class Proxy implements ICaeNetworkRtt {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
            public int getGameRttbyUid(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkRtt.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            public String getInterfaceDescriptor() {
                return ICaeNetworkRtt.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
            public int getRttByUid(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkRtt.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, ICaeNetworkRtt.DESCRIPTOR);
        }

        public static ICaeNetworkRtt asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNetworkRtt.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNetworkRtt) == false) goto L12;
            return (ICaeNetworkRtt) r0;
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
            r5.enforceInterface(ICaeNetworkRtt.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            int r8 = getRttByUid(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8);
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            int r9 = getGameRttbyUid(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r9);
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICaeNetworkRtt.DESCRIPTOR);
            return true;
        }
    }

    int getGameRttbyUid(int r1) throws RemoteException;

    int getRttByUid(int r1) throws RemoteException;
}
