package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.collector.ICollectPullAtomResultReceiver;

/* loaded from: classes.dex */
public interface ICollectPullCallback extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.ICollectPullCallback";

    void onPullAtom(int i, ICollectPullAtomResultReceiver iCollectPullAtomResultReceiver) throws RemoteException;

    public static class Default implements ICollectPullCallback {
        @Override // android.os.collector.ICollectPullCallback
        public void onPullAtom(int atomTag, ICollectPullAtomResultReceiver resultReceiver) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICollectPullCallback {
        static final int TRANSACTION_onPullAtom = 1;

        public Stub() {
            attachInterface(this, ICollectPullCallback.DESCRIPTOR);
        }

        public static ICollectPullCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ICollectPullCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof ICollectPullCallback)) {
                return (ICollectPullCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "onPullAtom";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(ICollectPullCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ICollectPullCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    ICollectPullAtomResultReceiver _arg1 = ICollectPullAtomResultReceiver.Stub.asInterface(data.readStrongBinder());
                    onPullAtom(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICollectPullCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICollectPullCallback.DESCRIPTOR;
            }

            @Override // android.os.collector.ICollectPullCallback
            public void onPullAtom(int atomTag, ICollectPullAtomResultReceiver resultReceiver) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectPullCallback.DESCRIPTOR);
                    _data.writeInt(atomTag);
                    _data.writeStrongInterface(resultReceiver);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
