package android.os;

/* JADX INFO: loaded from: classes.dex */
public interface IVoldTaskListener extends IInterface {

    public static class Default implements IVoldTaskListener {
        public Default() {
        }

        @Override // android.os.IVoldTaskListener
        public void onStatus(int status, PersistableBundle extras) throws RemoteException {
        }

        @Override // android.os.IVoldTaskListener
        public void onFinished(int status, PersistableBundle extras) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoldTaskListener {
        public static final String DESCRIPTOR = "android.os.IVoldTaskListener";
        static final int TRANSACTION_onFinished = 2;
        static final int TRANSACTION_onStatus = 1;

        private static class Proxy implements IVoldTaskListener {
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

            @Override // android.os.IVoldTaskListener
            public void onStatus(int status, PersistableBundle extras) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(status);     // Catch: Throwable -> L6
                _data.writeTypedObject(extras, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldTaskListener
            public void onFinished(int status, PersistableBundle extras) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(status);     // Catch: Throwable -> L6
                _data.writeTypedObject(extras, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVoldTaskListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVoldTaskListener) == false) goto L12;
            return (IVoldTaskListener) iin;
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
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L14:
            int _arg0 = data.readInt();
            PersistableBundle _arg1 = (PersistableBundle) data.readTypedObject(PersistableBundle.CREATOR);
            data.enforceNoDataAvail();
            onFinished(_arg0, _arg1);
        L16:
            return true;
        L15:
            int _arg2 = data.readInt();
            PersistableBundle _arg3 = (PersistableBundle) data.readTypedObject(PersistableBundle.CREATOR);
            data.enforceNoDataAvail();
            onStatus(_arg2, _arg3);
            goto L16
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onFinished(int r1, PersistableBundle r2) throws RemoteException;

    void onStatus(int r1, PersistableBundle r2) throws RemoteException;
}
