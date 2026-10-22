package stepos.uicontroller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUIControllerEventListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.uicontroller.IUIControllerEventListener";

    void onUIEvent(UINodeInfo uINodeInfo, int i) throws RemoteException;

    public static class Default implements IUIControllerEventListener {
        @Override // stepos.uicontroller.IUIControllerEventListener
        public void onUIEvent(UINodeInfo info, int action) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUIControllerEventListener {
        static final int TRANSACTION_onUIEvent = 1;

        public Stub() {
            attachInterface(this, IUIControllerEventListener.DESCRIPTOR);
        }

        public static IUIControllerEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IUIControllerEventListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IUIControllerEventListener)) {
                return (IUIControllerEventListener) iin;
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
                    return "onUIEvent";
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
                data.enforceInterface(IUIControllerEventListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IUIControllerEventListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    UINodeInfo _arg0 = (UINodeInfo) data.readTypedObject(UINodeInfo.CREATOR);
                    int _arg1 = data.readInt();
                    onUIEvent(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IUIControllerEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUIControllerEventListener.DESCRIPTOR;
            }

            @Override // stepos.uicontroller.IUIControllerEventListener
            public void onUIEvent(UINodeInfo info, int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIControllerEventListener.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    _data.writeInt(action);
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
