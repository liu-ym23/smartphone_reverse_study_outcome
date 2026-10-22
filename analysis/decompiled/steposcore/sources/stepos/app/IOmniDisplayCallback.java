package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOmniDisplayCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IOmniDisplayCallback";

    void handleAppDied(int i, String str, int i2, boolean z) throws RemoteException;

    public static class Default implements IOmniDisplayCallback {
        @Override // stepos.app.IOmniDisplayCallback
        public void handleAppDied(int uid, String packageName, int displayId, boolean restarting) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOmniDisplayCallback {
        static final int TRANSACTION_handleAppDied = 1;

        public Stub() {
            attachInterface(this, IOmniDisplayCallback.DESCRIPTOR);
        }

        public static IOmniDisplayCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOmniDisplayCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IOmniDisplayCallback)) {
                return (IOmniDisplayCallback) iin;
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
                    return "handleAppDied";
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
                data.enforceInterface(IOmniDisplayCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IOmniDisplayCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    boolean _arg3 = data.readBoolean();
                    handleAppDied(_arg0, _arg1, _arg2, _arg3);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IOmniDisplayCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOmniDisplayCallback.DESCRIPTOR;
            }

            @Override // stepos.app.IOmniDisplayCallback
            public void handleAppDied(int uid, String packageName, int displayId, boolean restarting) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOmniDisplayCallback.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeString(packageName);
                    _data.writeInt(displayId);
                    _data.writeBoolean(restarting);
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
