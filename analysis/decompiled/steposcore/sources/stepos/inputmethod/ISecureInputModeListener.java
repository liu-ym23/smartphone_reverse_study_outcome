package stepos.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISecureInputModeListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.ISecureInputModeListener";

    void onSecureModeChanged(boolean z) throws RemoteException;

    public static class Default implements ISecureInputModeListener {
        @Override // stepos.inputmethod.ISecureInputModeListener
        public void onSecureModeChanged(boolean active) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISecureInputModeListener {
        static final int TRANSACTION_onSecureModeChanged = 1;

        public Stub() {
            attachInterface(this, ISecureInputModeListener.DESCRIPTOR);
        }

        public static ISecureInputModeListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISecureInputModeListener.DESCRIPTOR);
            if (iin != null && (iin instanceof ISecureInputModeListener)) {
                return (ISecureInputModeListener) iin;
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
                    return "onSecureModeChanged";
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
                data.enforceInterface(ISecureInputModeListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISecureInputModeListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _arg0 = data.readBoolean();
                    onSecureModeChanged(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISecureInputModeListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISecureInputModeListener.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.ISecureInputModeListener
            public void onSecureModeChanged(boolean active) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISecureInputModeListener.DESCRIPTOR);
                    _data.writeBoolean(active);
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
