package stepos.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IQsActionListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.IQsActionListener";

    void onItemActionChange(QsActionItem qsActionItem, int i) throws RemoteException;

    public static class Default implements IQsActionListener {
        @Override // stepos.inputmethod.IQsActionListener
        public void onItemActionChange(QsActionItem action, int position) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQsActionListener {
        static final int TRANSACTION_onItemActionChange = 1;

        public Stub() {
            attachInterface(this, IQsActionListener.DESCRIPTOR);
        }

        public static IQsActionListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IQsActionListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IQsActionListener)) {
                return (IQsActionListener) iin;
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
                    return "onItemActionChange";
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
                data.enforceInterface(IQsActionListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IQsActionListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    QsActionItem _arg0 = (QsActionItem) data.readTypedObject(QsActionItem.CREATOR);
                    int _arg1 = data.readInt();
                    onItemActionChange(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IQsActionListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQsActionListener.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.IQsActionListener
            public void onItemActionChange(QsActionItem action, int position) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionListener.DESCRIPTOR);
                    _data.writeTypedObject(action, 0);
                    _data.writeInt(position);
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
