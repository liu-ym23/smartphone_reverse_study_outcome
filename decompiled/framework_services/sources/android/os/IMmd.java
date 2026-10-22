package android.os;

/* JADX INFO: loaded from: classes.dex */
public interface IMmd extends IInterface {
    public static final String DESCRIPTOR = "android.os.IMmd";

    public static class Default implements IMmd {
        public Default() {
        }

        @Override // android.os.IMmd
        public void doZramMaintenanceAsync() throws RemoteException {
        }

        @Override // android.os.IMmd
        public boolean isZramMaintenanceSupported() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IMmd {
        static final int TRANSACTION_doZramMaintenanceAsync = 1;
        static final int TRANSACTION_isZramMaintenanceSupported = 2;

        private static class Proxy implements IMmd {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMmd.DESCRIPTOR;
            }

            @Override // android.os.IMmd
            public void doZramMaintenanceAsync() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IMmd.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IMmd
            public boolean isZramMaintenanceSupported() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMmd.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
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
            attachInterface(this, IMmd.DESCRIPTOR);
        }

        public static IMmd asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IMmd.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IMmd) == false) goto L12;
            return (IMmd) iin;
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
            data.enforceInterface(IMmd.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IMmd.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L14:
            boolean _result = isZramMaintenanceSupported();
            reply.writeNoException();
            reply.writeBoolean(_result);
        L16:
            return true;
        L15:
            doZramMaintenanceAsync();
            goto L16
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void doZramMaintenanceAsync() throws RemoteException;

    boolean isZramMaintenanceSupported() throws RemoteException;
}
