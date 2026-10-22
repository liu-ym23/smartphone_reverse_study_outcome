package stepos.uicontroller;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import stepos.uicontroller.IUIControllerCallback;
import stepos.uicontroller.IUIControllerEventListener;

/* loaded from: classes.dex */
public interface IUIController extends IInterface {
    public static final String DESCRIPTOR = "stepos.uicontroller.IUIController";

    void addUIEventListener(IUIControllerEventListener iUIControllerEventListener) throws RemoteException;

    void addUIEventListenerForNodeId(int i, IUIControllerEventListener iUIControllerEventListener) throws RemoteException;

    void findNodes(Bundle bundle, IUIControllerCallback iUIControllerCallback) throws RemoteException;

    void findScrollableAncestor(int i, boolean z, IUIControllerCallback iUIControllerCallback) throws RemoteException;

    void findViewByClassHierarchy(String str, IUIControllerCallback iUIControllerCallback) throws RemoteException;

    boolean isMonitoringUINode(int i) throws RemoteException;

    void performAction(int i, int i2, Bundle bundle, IUIControllerCallback iUIControllerCallback) throws RemoteException;

    void printString(String str) throws RemoteException;

    void removeAllListenersForNodeId(int i) throws RemoteException;

    void removeUIEventListener(IUIControllerEventListener iUIControllerEventListener) throws RemoteException;

    void removeUIEventListenerForNodeId(int i, IUIControllerEventListener iUIControllerEventListener) throws RemoteException;

    public static class Default implements IUIController {
        @Override // stepos.uicontroller.IUIController
        public void findNodes(Bundle arguments, IUIControllerCallback callback) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void performAction(int nodeId, int action, Bundle arguments, IUIControllerCallback callback) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void addUIEventListener(IUIControllerEventListener listener) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void removeUIEventListener(IUIControllerEventListener listener) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void printString(String text) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void findScrollableAncestor(int nodeId, boolean horizontal, IUIControllerCallback callback) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void findViewByClassHierarchy(String classHierarchy, IUIControllerCallback callback) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void addUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void removeUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public void removeAllListenersForNodeId(int nodeId) throws RemoteException {
        }

        @Override // stepos.uicontroller.IUIController
        public boolean isMonitoringUINode(int nodeId) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUIController {
        static final int TRANSACTION_addUIEventListener = 3;
        static final int TRANSACTION_addUIEventListenerForNodeId = 8;
        static final int TRANSACTION_findNodes = 1;
        static final int TRANSACTION_findScrollableAncestor = 6;
        static final int TRANSACTION_findViewByClassHierarchy = 7;
        static final int TRANSACTION_isMonitoringUINode = 11;
        static final int TRANSACTION_performAction = 2;
        static final int TRANSACTION_printString = 5;
        static final int TRANSACTION_removeAllListenersForNodeId = 10;
        static final int TRANSACTION_removeUIEventListener = 4;
        static final int TRANSACTION_removeUIEventListenerForNodeId = 9;

        public Stub() {
            attachInterface(this, IUIController.DESCRIPTOR);
        }

        public static IUIController asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IUIController.DESCRIPTOR);
            if (iin != null && (iin instanceof IUIController)) {
                return (IUIController) iin;
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
                    return "findNodes";
                case 2:
                    return "performAction";
                case 3:
                    return "addUIEventListener";
                case 4:
                    return "removeUIEventListener";
                case 5:
                    return "printString";
                case 6:
                    return "findScrollableAncestor";
                case 7:
                    return "findViewByClassHierarchy";
                case 8:
                    return "addUIEventListenerForNodeId";
                case 9:
                    return "removeUIEventListenerForNodeId";
                case 10:
                    return "removeAllListenersForNodeId";
                case 11:
                    return "isMonitoringUINode";
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
                data.enforceInterface(IUIController.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IUIController.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    Bundle _arg0 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    IUIControllerCallback _arg1 = IUIControllerCallback.Stub.asInterface(data.readStrongBinder());
                    findNodes(_arg0, _arg1);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    int _arg12 = data.readInt();
                    Bundle _arg2 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    IUIControllerCallback _arg3 = IUIControllerCallback.Stub.asInterface(data.readStrongBinder());
                    performAction(_arg02, _arg12, _arg2, _arg3);
                    return true;
                case 3:
                    IUIControllerEventListener _arg03 = IUIControllerEventListener.Stub.asInterface(data.readStrongBinder());
                    addUIEventListener(_arg03);
                    return true;
                case 4:
                    IUIControllerEventListener _arg04 = IUIControllerEventListener.Stub.asInterface(data.readStrongBinder());
                    removeUIEventListener(_arg04);
                    return true;
                case 5:
                    String _arg05 = data.readString();
                    printString(_arg05);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    boolean _arg13 = data.readBoolean();
                    IUIControllerCallback _arg22 = IUIControllerCallback.Stub.asInterface(data.readStrongBinder());
                    findScrollableAncestor(_arg06, _arg13, _arg22);
                    return true;
                case 7:
                    String _arg07 = data.readString();
                    IUIControllerCallback _arg14 = IUIControllerCallback.Stub.asInterface(data.readStrongBinder());
                    findViewByClassHierarchy(_arg07, _arg14);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    IUIControllerEventListener _arg15 = IUIControllerEventListener.Stub.asInterface(data.readStrongBinder());
                    addUIEventListenerForNodeId(_arg08, _arg15);
                    return true;
                case 9:
                    int _arg09 = data.readInt();
                    IUIControllerEventListener _arg16 = IUIControllerEventListener.Stub.asInterface(data.readStrongBinder());
                    removeUIEventListenerForNodeId(_arg09, _arg16);
                    return true;
                case 10:
                    int _arg010 = data.readInt();
                    removeAllListenersForNodeId(_arg010);
                    return true;
                case 11:
                    int _arg011 = data.readInt();
                    boolean _result = isMonitoringUINode(_arg011);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IUIController {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUIController.DESCRIPTOR;
            }

            @Override // stepos.uicontroller.IUIController
            public void findNodes(Bundle arguments, IUIControllerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeTypedObject(arguments, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void performAction(int nodeId, int action, Bundle arguments, IUIControllerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    _data.writeInt(action);
                    _data.writeTypedObject(arguments, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void addUIEventListener(IUIControllerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void removeUIEventListener(IUIControllerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void printString(String text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeString(text);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void findScrollableAncestor(int nodeId, boolean horizontal, IUIControllerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    _data.writeBoolean(horizontal);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void findViewByClassHierarchy(String classHierarchy, IUIControllerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeString(classHierarchy);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void addUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void removeUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public void removeAllListenersForNodeId(int nodeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    this.mRemote.transact(10, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.uicontroller.IUIController
            public boolean isMonitoringUINode(int nodeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIController.DESCRIPTOR);
                    _data.writeInt(nodeId);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 10;
        }
    }
}
