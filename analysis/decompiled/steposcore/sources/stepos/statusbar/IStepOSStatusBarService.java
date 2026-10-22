package stepos.statusbar;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import stepos.statusbar.IStepOSStatusBarCallback;

/* loaded from: classes.dex */
public interface IStepOSStatusBarService extends IInterface {
    public static final String DESCRIPTOR = "stepos.statusbar.IStepOSStatusBarService";

    void hideAlwaysPermission(Bundle bundle) throws RemoteException;

    void hideAlwaysTextAndIcon(String str) throws RemoteException;

    void registerStatusBar(IStepOSStatusBarCallback iStepOSStatusBarCallback) throws RemoteException;

    void setHomeChipEnable(boolean z) throws RemoteException;

    void setNavigationBarMode(boolean z, boolean z2) throws RemoteException;

    void showAlwaysTextAndIcon(Bundle bundle) throws RemoteException;

    public static class Default implements IStepOSStatusBarService {
        @Override // stepos.statusbar.IStepOSStatusBarService
        public void setHomeChipEnable(boolean enable) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarService
        public void setNavigationBarMode(boolean show, boolean mback) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarService
        public void showAlwaysTextAndIcon(Bundle info) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarService
        public void hideAlwaysTextAndIcon(String packageName) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarService
        public void hideAlwaysPermission(Bundle info) throws RemoteException {
        }

        @Override // stepos.statusbar.IStepOSStatusBarService
        public void registerStatusBar(IStepOSStatusBarCallback bar) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSStatusBarService {
        static final int TRANSACTION_hideAlwaysPermission = 5;
        static final int TRANSACTION_hideAlwaysTextAndIcon = 4;
        static final int TRANSACTION_registerStatusBar = 6;
        static final int TRANSACTION_setHomeChipEnable = 1;
        static final int TRANSACTION_setNavigationBarMode = 2;
        static final int TRANSACTION_showAlwaysTextAndIcon = 3;

        public Stub() {
            attachInterface(this, IStepOSStatusBarService.DESCRIPTOR);
        }

        public static IStepOSStatusBarService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSStatusBarService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSStatusBarService)) {
                return (IStepOSStatusBarService) iin;
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
                    return "setHomeChipEnable";
                case 2:
                    return "setNavigationBarMode";
                case 3:
                    return "showAlwaysTextAndIcon";
                case 4:
                    return "hideAlwaysTextAndIcon";
                case 5:
                    return "hideAlwaysPermission";
                case 6:
                    return "registerStatusBar";
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
                data.enforceInterface(IStepOSStatusBarService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSStatusBarService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _arg0 = data.readBoolean();
                    setHomeChipEnable(_arg0);
                    return true;
                case 2:
                    boolean _arg02 = data.readBoolean();
                    boolean _arg1 = data.readBoolean();
                    setNavigationBarMode(_arg02, _arg1);
                    return true;
                case 3:
                    Bundle _arg03 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    showAlwaysTextAndIcon(_arg03);
                    return true;
                case 4:
                    String _arg04 = data.readString();
                    hideAlwaysTextAndIcon(_arg04);
                    return true;
                case 5:
                    Bundle _arg05 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    hideAlwaysPermission(_arg05);
                    return true;
                case 6:
                    IStepOSStatusBarCallback _arg06 = IStepOSStatusBarCallback.Stub.asInterface(data.readStrongBinder());
                    registerStatusBar(_arg06);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSStatusBarService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSStatusBarService.DESCRIPTOR;
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void setHomeChipEnable(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeBoolean(enable);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void setNavigationBarMode(boolean show, boolean mback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeBoolean(show);
                    _data.writeBoolean(mback);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void showAlwaysTextAndIcon(Bundle info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void hideAlwaysTextAndIcon(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void hideAlwaysPermission(Bundle info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.statusbar.IStepOSStatusBarService
            public void registerStatusBar(IStepOSStatusBarCallback bar) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSStatusBarService.DESCRIPTOR);
                    _data.writeStrongInterface(bar);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 5;
        }
    }
}
