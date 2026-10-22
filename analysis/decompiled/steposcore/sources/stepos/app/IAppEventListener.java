package stepos.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAppEventListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IAppEventListener";

    void onEvent(int i, Bundle bundle) throws RemoteException;

    public static class Default implements IAppEventListener {
        @Override // stepos.app.IAppEventListener
        public void onEvent(int flag, Bundle data) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAppEventListener {
        static final int TRANSACTION_onEvent = 1;

        public Stub() {
            attachInterface(this, IAppEventListener.DESCRIPTOR);
        }

        public static IAppEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAppEventListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IAppEventListener)) {
                return (IAppEventListener) iin;
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
                    return "onEvent";
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
                data.enforceInterface(IAppEventListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IAppEventListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    Bundle _arg1 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    onEvent(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IAppEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppEventListener.DESCRIPTOR;
            }

            @Override // stepos.app.IAppEventListener
            public void onEvent(int flag, Bundle data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAppEventListener.DESCRIPTOR);
                    _data.writeInt(flag);
                    _data.writeTypedObject(data, 0);
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
