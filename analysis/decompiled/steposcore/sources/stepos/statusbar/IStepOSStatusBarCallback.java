package stepos.statusbar;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSStatusBarCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.statusbar.IStepOSStatusBarCallback";

    void hideAlwaysPermission(Bundle bundle) throws RemoteException;

    void hideAlwaysTextAndIcon(String str) throws RemoteException;

    void showAlwaysTextAndIcon(Bundle bundle) throws RemoteException;

    public static class Default implements IStepOSStatusBarCallback {
        @Override // stepos.statusbar.IStepOSStatusBarCallback
        public void showAlwaysTextAndIcon(Bundle info) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarCallback
        public void hideAlwaysTextAndIcon(String packageName) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarCallback
        public void hideAlwaysPermission(Bundle info) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSStatusBarCallback {
        static final int TRANSACTION_hideAlwaysPermission = 3;
        static final int TRANSACTION_hideAlwaysTextAndIcon = 2;
        static final int TRANSACTION_showAlwaysTextAndIcon = 1;

        public Stub() {
            attachInterface(this, IStepOSStatusBarCallback.DESCRIPTOR);
        }

        public static IStepOSStatusBarCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSStatusBarCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSStatusBarCallback)) {
                return (IStepOSStatusBarCallback) iin;
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
                    return "showAlwaysTextAndIcon";
                case 2:
                    return "hideAlwaysTextAndIcon";
                case 3:
                    return "hideAlwaysPermission";
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
                data.enforceInterface(IStepOSStatusBarCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSStatusBarCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    Bundle _arg0 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    showAlwaysTextAndIcon(_arg0);
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    hideAlwaysTextAndIcon(_arg02);
                    return true;
                case 3:
                    Bundle _arg03 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    hideAlwaysPermission(_arg03);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSStatusBarCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSStatusBarCallback.DESCRIPTOR;
            }

            @Override // stepos.statusbar.IStepOSStatusBarCallback
            public void showAlwaysTextAndIcon(Bundle info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarCallback.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarCallback
            public void hideAlwaysTextAndIcon(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarCallback.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarCallback
            public void hideAlwaysPermission(Bundle info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarCallback.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
