package android.os;

/* JADX INFO: loaded from: classes.dex */
public interface IStoraged extends IInterface {

    public static class Default implements IStoraged {
        public Default() {
        }

        @Override // android.os.IStoraged
        public void onUserStarted(int userId) throws RemoteException {
        }

        @Override // android.os.IStoraged
        public void onUserStopped(int userId) throws RemoteException {
        }

        @Override // android.os.IStoraged
        public int getRecentPerf() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStoraged {
        public static final String DESCRIPTOR = "android.os.IStoraged";
        static final int TRANSACTION_getRecentPerf = 3;
        static final int TRANSACTION_onUserStarted = 1;
        static final int TRANSACTION_onUserStopped = 2;

        private static class Proxy implements IStoraged {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IStoraged
            public void onUserStarted(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IStoraged
            public void onUserStopped(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IStoraged
            public int getRecentPerf() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStoraged asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IStoraged) == false) goto L12;
            return (IStoraged) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                default: goto L13;
            };
        L14:
            int _result = getRecentPerf();
            reply.writeNoException();
            reply.writeInt(_result);
        L17:
            return true;
        L15:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            onUserStopped(_arg0);
            reply.writeNoException();
            goto L17
        L16:
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            onUserStarted(_arg1);
            reply.writeNoException();
            goto L17
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    int getRecentPerf() throws RemoteException;

    void onUserStarted(int r1) throws RemoteException;

    void onUserStopped(int r1) throws RemoteException;
}
