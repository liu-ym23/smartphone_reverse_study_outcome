package stepos.view;

import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IWindowModeCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.view.IWindowModeCallback";

    void onBoundChanged(int i, Rect rect, Rect rect2, int i2) throws RemoteException;

    void onCaptionMenuDismiss(int i) throws RemoteException;

    void onImeVisibilityChanged(int i, boolean z, int i2) throws RemoteException;

    void onPreferredWindowModeChanged(int i, int i2, int i3) throws RemoteException;

    void onShellTransitionFinished(int i, int i2) throws RemoteException;

    void onShellTransitionReady(int i, int i2) throws RemoteException;

    void onStackChanged(int i, boolean z, boolean z2, Bundle bundle) throws RemoteException;

    void onStateChanged(int i, int i2) throws RemoteException;

    void onTopActivityChanged(int i, String str, String str2, int i2, int i3, boolean z) throws RemoteException;

    void onWindowModeChangeAnimationFinished(int i) throws RemoteException;

    void onWindowModeListsChanged() throws RemoteException;

    public static class Default implements IWindowModeCallback {
        @Override // stepos.view.IWindowModeCallback
        public void onStackChanged(int taskId, boolean isWindowMode, boolean topStack, Bundle data) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onTopActivityChanged(int taskId, String packageName, String className, int uid, int pid, boolean topStack) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onBoundChanged(int taskId, Rect fromBound, Rect toBound, int rotation) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onStateChanged(int taskId, int windowModeState) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onImeVisibilityChanged(int taskId, boolean imeVisible, int imeHeight) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onShellTransitionReady(int animationType, int syncId) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onShellTransitionFinished(int animationType, int syncId) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onWindowModeChangeAnimationFinished(int taskId) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onPreferredWindowModeChanged(int taskId, int currentWindowMode, int preferredWindowMode) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onCaptionMenuDismiss(int taskId) throws RemoteException {
        }

        @Override // stepos.view.IWindowModeCallback
        public void onWindowModeListsChanged() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWindowModeCallback {
        static final int TRANSACTION_onBoundChanged = 3;
        static final int TRANSACTION_onCaptionMenuDismiss = 10;
        static final int TRANSACTION_onImeVisibilityChanged = 5;
        static final int TRANSACTION_onPreferredWindowModeChanged = 9;
        static final int TRANSACTION_onShellTransitionFinished = 7;
        static final int TRANSACTION_onShellTransitionReady = 6;
        static final int TRANSACTION_onStackChanged = 1;
        static final int TRANSACTION_onStateChanged = 4;
        static final int TRANSACTION_onTopActivityChanged = 2;
        static final int TRANSACTION_onWindowModeChangeAnimationFinished = 8;
        static final int TRANSACTION_onWindowModeListsChanged = 11;

        public Stub() {
            attachInterface(this, IWindowModeCallback.DESCRIPTOR);
        }

        public static IWindowModeCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IWindowModeCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IWindowModeCallback)) {
                return (IWindowModeCallback) iin;
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
                    return "onStackChanged";
                case 2:
                    return "onTopActivityChanged";
                case 3:
                    return "onBoundChanged";
                case 4:
                    return "onStateChanged";
                case 5:
                    return "onImeVisibilityChanged";
                case 6:
                    return "onShellTransitionReady";
                case 7:
                    return "onShellTransitionFinished";
                case 8:
                    return "onWindowModeChangeAnimationFinished";
                case 9:
                    return "onPreferredWindowModeChanged";
                case 10:
                    return "onCaptionMenuDismiss";
                case 11:
                    return "onWindowModeListsChanged";
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
                data.enforceInterface(IWindowModeCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IWindowModeCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    boolean _arg1 = data.readBoolean();
                    boolean _arg2 = data.readBoolean();
                    Bundle _arg3 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    onStackChanged(_arg0, _arg1, _arg2, _arg3);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    String _arg12 = data.readString();
                    String _arg22 = data.readString();
                    int _arg32 = data.readInt();
                    int _arg4 = data.readInt();
                    boolean _arg5 = data.readBoolean();
                    onTopActivityChanged(_arg02, _arg12, _arg22, _arg32, _arg4, _arg5);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    Rect _arg13 = (Rect) data.readTypedObject(Rect.CREATOR);
                    Rect _arg23 = (Rect) data.readTypedObject(Rect.CREATOR);
                    int _arg33 = data.readInt();
                    onBoundChanged(_arg03, _arg13, _arg23, _arg33);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    int _arg14 = data.readInt();
                    onStateChanged(_arg04, _arg14);
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    boolean _arg15 = data.readBoolean();
                    int _arg24 = data.readInt();
                    onImeVisibilityChanged(_arg05, _arg15, _arg24);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    int _arg16 = data.readInt();
                    onShellTransitionReady(_arg06, _arg16);
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    int _arg17 = data.readInt();
                    onShellTransitionFinished(_arg07, _arg17);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    onWindowModeChangeAnimationFinished(_arg08);
                    return true;
                case 9:
                    int _arg09 = data.readInt();
                    int _arg18 = data.readInt();
                    int _arg25 = data.readInt();
                    onPreferredWindowModeChanged(_arg09, _arg18, _arg25);
                    return true;
                case 10:
                    int _arg010 = data.readInt();
                    onCaptionMenuDismiss(_arg010);
                    return true;
                case 11:
                    onWindowModeListsChanged();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IWindowModeCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWindowModeCallback.DESCRIPTOR;
            }

            @Override // stepos.view.IWindowModeCallback
            public void onStackChanged(int taskId, boolean isWindowMode, boolean topStack, Bundle data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeBoolean(isWindowMode);
                    _data.writeBoolean(topStack);
                    _data.writeTypedObject(data, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onTopActivityChanged(int taskId, String packageName, String className, int uid, int pid, boolean topStack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeString(packageName);
                    _data.writeString(className);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    _data.writeBoolean(topStack);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onBoundChanged(int taskId, Rect fromBound, Rect toBound, int rotation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeTypedObject(fromBound, 0);
                    _data.writeTypedObject(toBound, 0);
                    _data.writeInt(rotation);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onStateChanged(int taskId, int windowModeState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(windowModeState);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onImeVisibilityChanged(int taskId, boolean imeVisible, int imeHeight) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeBoolean(imeVisible);
                    _data.writeInt(imeHeight);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onShellTransitionReady(int animationType, int syncId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(animationType);
                    _data.writeInt(syncId);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onShellTransitionFinished(int animationType, int syncId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(animationType);
                    _data.writeInt(syncId);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onWindowModeChangeAnimationFinished(int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onPreferredWindowModeChanged(int taskId, int currentWindowMode, int preferredWindowMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(currentWindowMode);
                    _data.writeInt(preferredWindowMode);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onCaptionMenuDismiss(int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    _data.writeInt(taskId);
                    this.mRemote.transact(10, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IWindowModeCallback
            public void onWindowModeListsChanged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IWindowModeCallback.DESCRIPTOR);
                    this.mRemote.transact(11, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 10;
        }
    }
}
