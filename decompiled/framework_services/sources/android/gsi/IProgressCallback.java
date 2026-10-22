package android.gsi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IProgressCallback extends IInterface {
    public static final String DESCRIPTOR = "android.gsi.IProgressCallback";

    public static class Default implements IProgressCallback {
        public Default() {
        }

        @Override // android.gsi.IProgressCallback
        public void onProgress(long current, long total) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IProgressCallback {
        static final int TRANSACTION_onProgress = 1;

        private static class Proxy implements IProgressCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IProgressCallback.DESCRIPTOR;
            }

            @Override // android.gsi.IProgressCallback
            public void onProgress(long current, long total) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProgressCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeLong(current);     // Catch: Throwable -> L6
                _data.writeLong(total);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IProgressCallback.DESCRIPTOR);
        }

        public static IProgressCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IProgressCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IProgressCallback) == false) goto L12;
            return (IProgressCallback) iin;
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
            data.enforceInterface(IProgressCallback.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IProgressCallback.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L14;
                default: goto L13;
            };
        L14:
            long _arg0 = data.readLong();
            long _arg1 = data.readLong();
            data.enforceNoDataAvail();
            onProgress(_arg0, _arg1);
            reply.writeNoException();
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onProgress(long r1, long r3) throws RemoteException;
}
