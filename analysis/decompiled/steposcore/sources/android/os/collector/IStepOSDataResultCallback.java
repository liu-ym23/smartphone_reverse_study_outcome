package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSDataResultCallback extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.IStepOSDataResultCallback";

    void onResult(int i, boolean z, CollectEventParcel[] collectEventParcelArr) throws RemoteException;

    public static class Default implements IStepOSDataResultCallback {
        @Override // android.os.collector.IStepOSDataResultCallback
        public void onResult(int atomTag, boolean isFinished, CollectEventParcel[] output) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSDataResultCallback {
        static final int TRANSACTION_onResult = 1;

        public Stub() {
            attachInterface(this, IStepOSDataResultCallback.DESCRIPTOR);
        }

        public static IStepOSDataResultCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSDataResultCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSDataResultCallback)) {
                return (IStepOSDataResultCallback) iin;
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
                    return "onResult";
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
                data.enforceInterface(IStepOSDataResultCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSDataResultCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    boolean _arg1 = data.readBoolean();
                    CollectEventParcel[] _arg2 = (CollectEventParcel[]) data.createTypedArray(CollectEventParcel.CREATOR);
                    onResult(_arg0, _arg1, _arg2);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSDataResultCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSDataResultCallback.DESCRIPTOR;
            }

            @Override // android.os.collector.IStepOSDataResultCallback
            public void onResult(int atomTag, boolean isFinished, CollectEventParcel[] output) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataResultCallback.DESCRIPTOR);
                    _data.writeInt(atomTag);
                    _data.writeBoolean(isFinished);
                    _data.writeTypedArray(output, 0);
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
