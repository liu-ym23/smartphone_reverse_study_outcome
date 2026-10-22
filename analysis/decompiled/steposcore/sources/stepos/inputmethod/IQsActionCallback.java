package stepos.inputmethod;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IQsActionCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.IQsActionCallback";

    void onItemActionCall(int i, int i2, int i3, Bundle bundle) throws RemoteException;

    void onItemActionEnable(int i, boolean z) throws RemoteException;

    void onItemDataChange(QsActionItem qsActionItem) throws RemoteException;

    void onSystemUiVisibilityChange(int i, boolean z) throws RemoteException;

    public static class Default implements IQsActionCallback {
        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemDataChange(QsActionItem itemData) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemActionEnable(int displayId, boolean enable) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemActionCall(int action, int displayId, int userId, Bundle data) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onSystemUiVisibilityChange(int displayId, boolean removeWindow) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQsActionCallback {
        static final int TRANSACTION_onItemActionCall = 3;
        static final int TRANSACTION_onItemActionEnable = 2;
        static final int TRANSACTION_onItemDataChange = 1;
        static final int TRANSACTION_onSystemUiVisibilityChange = 4;

        public Stub() {
            attachInterface(this, IQsActionCallback.DESCRIPTOR);
        }

        public static IQsActionCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IQsActionCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IQsActionCallback)) {
                return (IQsActionCallback) iin;
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
                    return "onItemDataChange";
                case 2:
                    return "onItemActionEnable";
                case 3:
                    return "onItemActionCall";
                case 4:
                    return "onSystemUiVisibilityChange";
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
                data.enforceInterface(IQsActionCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IQsActionCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    QsActionItem _arg0 = (QsActionItem) data.readTypedObject(QsActionItem.CREATOR);
                    onItemDataChange(_arg0);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    boolean _arg1 = data.readBoolean();
                    onItemActionEnable(_arg02, _arg1);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg12 = data.readInt();
                    int _arg2 = data.readInt();
                    Bundle _arg3 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    onItemActionCall(_arg03, _arg12, _arg2, _arg3);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    boolean _arg13 = data.readBoolean();
                    onSystemUiVisibilityChange(_arg04, _arg13);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IQsActionCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQsActionCallback.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.IQsActionCallback
            public void onItemDataChange(QsActionItem itemData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionCallback.DESCRIPTOR);
                    _data.writeTypedObject(itemData, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionCallback
            public void onItemActionEnable(int displayId, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionCallback.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(enable);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionCallback
            public void onItemActionCall(int action, int displayId, int userId, Bundle data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionCallback.DESCRIPTOR);
                    _data.writeInt(action);
                    _data.writeInt(displayId);
                    _data.writeInt(userId);
                    _data.writeTypedObject(data, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionCallback
            public void onSystemUiVisibilityChange(int displayId, boolean removeWindow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionCallback.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(removeWindow);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
