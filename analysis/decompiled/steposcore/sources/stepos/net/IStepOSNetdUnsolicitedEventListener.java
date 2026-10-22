package stepos.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSNetdUnsolicitedEventListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.net.IStepOSNetdUnsolicitedEventListener";

    void onFreezeUidPktState(int i, int i2) throws RemoteException;

    void onRegistered() throws RemoteException;

    public static class Default implements IStepOSNetdUnsolicitedEventListener {
        @Override // stepos.net.IStepOSNetdUnsolicitedEventListener
        public void onRegistered() throws RemoteException {
        }

        @Override // stepos.net.IStepOSNetdUnsolicitedEventListener
        public void onFreezeUidPktState(int uid, int pkt_state) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSNetdUnsolicitedEventListener {
        static final int TRANSACTION_onFreezeUidPktState = 2;
        static final int TRANSACTION_onRegistered = 1;

        public Stub() {
            attachInterface(this, IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
        }

        public static IStepOSNetdUnsolicitedEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSNetdUnsolicitedEventListener)) {
                return (IStepOSNetdUnsolicitedEventListener) iin;
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
                    return "onRegistered";
                case 2:
                    return "onFreezeUidPktState";
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
                data.enforceInterface(IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    onRegistered();
                    return true;
                case 2:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    onFreezeUidPktState(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSNetdUnsolicitedEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSNetdUnsolicitedEventListener.DESCRIPTOR;
            }

            @Override // stepos.net.IStepOSNetdUnsolicitedEventListener
            public void onRegistered() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetdUnsolicitedEventListener
            public void onFreezeUidPktState(int uid, int pkt_state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetdUnsolicitedEventListener.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pkt_state);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
