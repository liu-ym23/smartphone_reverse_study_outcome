package android.os;

import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public interface IVoldMountCallback extends IInterface {
    public static final String DESCRIPTOR = "android.os.IVoldMountCallback";

    public static class Default implements IVoldMountCallback {
        public Default() {
        }

        @Override // android.os.IVoldMountCallback
        public boolean onVolumeChecking(FileDescriptor fuseFd, String path, String internalPath) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoldMountCallback {
        static final int TRANSACTION_onVolumeChecking = 1;

        private static class Proxy implements IVoldMountCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoldMountCallback.DESCRIPTOR;
            }

            @Override // android.os.IVoldMountCallback
            public boolean onVolumeChecking(FileDescriptor fuseFd, String path, String internalPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IVoldMountCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeRawFileDescriptor(fuseFd);     // Catch: Throwable -> L6
                _data.writeString(path);     // Catch: Throwable -> L6
                _data.writeString(internalPath);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IVoldMountCallback.DESCRIPTOR);
        }

        public static IVoldMountCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IVoldMountCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVoldMountCallback) == false) goto L12;
            return (IVoldMountCallback) iin;
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
            data.enforceInterface(IVoldMountCallback.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IVoldMountCallback.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L14;
                default: goto L13;
            };
        L14:
            FileDescriptor _arg0 = data.readRawFileDescriptor();
            String _arg1 = data.readString();
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            boolean _result = onVolumeChecking(_arg0, _arg1, _arg2);
            reply.writeNoException();
            reply.writeBoolean(_result);
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    boolean onVolumeChecking(FileDescriptor r1, String r2, String r3) throws RemoteException;
}
