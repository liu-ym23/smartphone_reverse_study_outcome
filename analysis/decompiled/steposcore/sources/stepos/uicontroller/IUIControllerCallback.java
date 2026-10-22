package stepos.uicontroller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IUIControllerCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.uicontroller.IUIControllerCallback";

    void onFindNodesResult(List<UINodeInfo> list) throws RemoteException;

    void onPerformActionResult(boolean z) throws RemoteException;

    public static class Default implements IUIControllerCallback {
        @Override // stepos.uicontroller.IUIControllerCallback
        public void onFindNodesResult(List<UINodeInfo> nodes) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIControllerCallback
        public void onPerformActionResult(boolean success) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUIControllerCallback {
        static final int TRANSACTION_onFindNodesResult = 1;
        static final int TRANSACTION_onPerformActionResult = 2;

        public Stub() {
            attachInterface(this, IUIControllerCallback.DESCRIPTOR);
        }

        public static IUIControllerCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IUIControllerCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IUIControllerCallback)) {
                return (IUIControllerCallback) iin;
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
                    return "onFindNodesResult";
                case 2:
                    return "onPerformActionResult";
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
                data.enforceInterface(IUIControllerCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IUIControllerCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    List<UINodeInfo> _arg0 = data.createTypedArrayList(UINodeInfo.CREATOR);
                    onFindNodesResult(_arg0);
                    return true;
                case 2:
                    boolean _arg02 = data.readBoolean();
                    onPerformActionResult(_arg02);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IUIControllerCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUIControllerCallback.DESCRIPTOR;
            }

            @Override // stepos.uicontroller.IUIControllerCallback
            public void onFindNodesResult(List<UINodeInfo> nodes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIControllerCallback.DESCRIPTOR);
                    _Parcel.writeTypedList(_data, nodes, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIControllerCallback
            public void onPerformActionResult(boolean success) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIControllerCallback.DESCRIPTOR);
                    _data.writeBoolean(success);
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

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                parcel.writeTypedObject(value.get(i), parcelableFlags);
            }
        }
    }
}
