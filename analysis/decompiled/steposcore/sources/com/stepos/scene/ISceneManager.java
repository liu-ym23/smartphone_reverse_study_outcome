package com.stepos.scene;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.scene.ISceneCallback;
import com.stepos.scene.entity.SceneState;

/* loaded from: classes.dex */
public interface ISceneManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.scene.ISceneManager";

    void closeSceneDonor(IBinder iBinder) throws RemoteException;

    boolean donateScene(IBinder iBinder, int i, SceneState sceneState) throws RemoteException;

    void donateTimedScene(int i, SceneState sceneState, long j) throws RemoteException;

    SceneState getSceneState(int i) throws RemoteException;

    boolean openSceneDonor(IBinder iBinder) throws RemoteException;

    boolean registerSceneListener(int i, ISceneCallback iSceneCallback) throws RemoteException;

    boolean registerSceneState(int i, SceneState sceneState) throws RemoteException;

    int removeSceneListeners(int i) throws RemoteException;

    boolean unregisterSceneListener(int i, ISceneCallback iSceneCallback) throws RemoteException;

    public static class Default implements ISceneManager {
        @Override // com.stepos.scene.ISceneManager
        public boolean registerSceneListener(int sceneId, ISceneCallback callback) throws RemoteException {
            return false;
        }

        @Override // com.stepos.scene.ISceneManager
        public boolean unregisterSceneListener(int sceneId, ISceneCallback callback) throws RemoteException {
            return false;
        }

        @Override // com.stepos.scene.ISceneManager
        public int removeSceneListeners(int sceneId) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.scene.ISceneManager
        public SceneState getSceneState(int sceneId) throws RemoteException {
            return null;
        }

        @Override // com.stepos.scene.ISceneManager
        public boolean registerSceneState(int sceneId, SceneState state) throws RemoteException {
            return false;
        }

        @Override // com.stepos.scene.ISceneManager
        public void donateTimedScene(int sceneId, SceneState state, long timeoutMs) throws RemoteException {
        }

        @Override // com.stepos.scene.ISceneManager
        public boolean openSceneDonor(IBinder clientToken) throws RemoteException {
            return false;
        }

        @Override // com.stepos.scene.ISceneManager
        public boolean donateScene(IBinder clientToken, int sceneId, SceneState state) throws RemoteException {
            return false;
        }

        @Override // com.stepos.scene.ISceneManager
        public void closeSceneDonor(IBinder clientToken) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISceneManager {
        static final int TRANSACTION_closeSceneDonor = 9;
        static final int TRANSACTION_donateScene = 8;
        static final int TRANSACTION_donateTimedScene = 6;
        static final int TRANSACTION_getSceneState = 4;
        static final int TRANSACTION_openSceneDonor = 7;
        static final int TRANSACTION_registerSceneListener = 1;
        static final int TRANSACTION_registerSceneState = 5;
        static final int TRANSACTION_removeSceneListeners = 3;
        static final int TRANSACTION_unregisterSceneListener = 2;

        public Stub() {
            attachInterface(this, ISceneManager.DESCRIPTOR);
        }

        public static ISceneManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISceneManager.DESCRIPTOR);
            if (iin != null && (iin instanceof ISceneManager)) {
                return (ISceneManager) iin;
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
                    return "registerSceneListener";
                case 2:
                    return "unregisterSceneListener";
                case 3:
                    return "removeSceneListeners";
                case 4:
                    return "getSceneState";
                case 5:
                    return "registerSceneState";
                case 6:
                    return "donateTimedScene";
                case 7:
                    return "openSceneDonor";
                case 8:
                    return "donateScene";
                case 9:
                    return "closeSceneDonor";
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
                data.enforceInterface(ISceneManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISceneManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    ISceneCallback _arg1 = ISceneCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result = registerSceneListener(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    ISceneCallback _arg12 = ISceneCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result2 = unregisterSceneListener(_arg02, _arg12);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _result3 = removeSceneListeners(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    SceneState _result4 = getSceneState(_arg04);
                    reply.writeNoException();
                    reply.writeTypedObject(_result4, 1);
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    SceneState _arg13 = (SceneState) data.readTypedObject(SceneState.CREATOR);
                    boolean _result5 = registerSceneState(_arg05, _arg13);
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    SceneState _arg14 = (SceneState) data.readTypedObject(SceneState.CREATOR);
                    long _arg2 = data.readLong();
                    donateTimedScene(_arg06, _arg14, _arg2);
                    reply.writeNoException();
                    return true;
                case 7:
                    IBinder _arg07 = data.readStrongBinder();
                    boolean _result6 = openSceneDonor(_arg07);
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 8:
                    IBinder _arg08 = data.readStrongBinder();
                    int _arg15 = data.readInt();
                    SceneState _arg22 = (SceneState) data.readTypedObject(SceneState.CREATOR);
                    boolean _result7 = donateScene(_arg08, _arg15, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result7);
                    return true;
                case 9:
                    IBinder _arg09 = data.readStrongBinder();
                    closeSceneDonor(_arg09);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISceneManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISceneManager.DESCRIPTOR;
            }

            @Override // com.stepos.scene.ISceneManager
            public boolean registerSceneListener(int sceneId, ISceneCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public boolean unregisterSceneListener(int sceneId, ISceneCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public int removeSceneListeners(int sceneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public SceneState getSceneState(int sceneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    SceneState _result = (SceneState) _reply.readTypedObject(SceneState.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public boolean registerSceneState(int sceneId, SceneState state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    _data.writeTypedObject(state, 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public void donateTimedScene(int sceneId, SceneState state, long timeoutMs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeInt(sceneId);
                    _data.writeTypedObject(state, 0);
                    _data.writeLong(timeoutMs);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public boolean openSceneDonor(IBinder clientToken) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeStrongBinder(clientToken);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public boolean donateScene(IBinder clientToken, int sceneId, SceneState state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeStrongBinder(clientToken);
                    _data.writeInt(sceneId);
                    _data.writeTypedObject(state, 0);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.scene.ISceneManager
            public void closeSceneDonor(IBinder clientToken) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneManager.DESCRIPTOR);
                    _data.writeStrongBinder(clientToken);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 8;
        }
    }
}
