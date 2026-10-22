package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSDataSubscriptionCallback extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.IStepOSDataSubscriptionCallback";

    void onSubscriptionData(int i, CollectEventParcel[] collectEventParcelArr) throws RemoteException;

    public static class Default implements IStepOSDataSubscriptionCallback {
        @Override // android.os.collector.IStepOSDataSubscriptionCallback
        public void onSubscriptionData(int reason, CollectEventParcel[] output) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSDataSubscriptionCallback {
        static final int TRANSACTION_onSubscriptionData = 1;

        public Stub() {
            attachInterface(this, IStepOSDataSubscriptionCallback.DESCRIPTOR);
        }

        public static IStepOSDataSubscriptionCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSDataSubscriptionCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSDataSubscriptionCallback)) {
                return (IStepOSDataSubscriptionCallback) iin;
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
                    return "onSubscriptionData";
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
                data.enforceInterface(IStepOSDataSubscriptionCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSDataSubscriptionCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    CollectEventParcel[] _arg1 = (CollectEventParcel[]) data.createTypedArray(CollectEventParcel.CREATOR);
                    onSubscriptionData(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSDataSubscriptionCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSDataSubscriptionCallback.DESCRIPTOR;
            }

            @Override // android.os.collector.IStepOSDataSubscriptionCallback
            public void onSubscriptionData(int reason, CollectEventParcel[] output) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataSubscriptionCallback.DESCRIPTOR);
                    _data.writeInt(reason);
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
