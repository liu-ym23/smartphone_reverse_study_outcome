package com.stepos.scene;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.scene.entity.SceneState;

/* loaded from: classes.dex */
public interface ISceneCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.scene.ISceneCallback";

    void onSceneStateUpdate(SceneState sceneState) throws RemoteException;

    public static class Default implements ISceneCallback {
        @Override // com.stepos.scene.ISceneCallback
        public void onSceneStateUpdate(SceneState state) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISceneCallback {
        static final int TRANSACTION_onSceneStateUpdate = 1;

        public Stub() {
            attachInterface(this, ISceneCallback.DESCRIPTOR);
        }

        public static ISceneCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISceneCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof ISceneCallback)) {
                return (ISceneCallback) iin;
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
                    return "onSceneStateUpdate";
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
                data.enforceInterface(ISceneCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISceneCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    SceneState _arg0 = (SceneState) data.readTypedObject(SceneState.CREATOR);
                    onSceneStateUpdate(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISceneCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISceneCallback.DESCRIPTOR;
            }

            @Override // com.stepos.scene.ISceneCallback
            public void onSceneStateUpdate(SceneState state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISceneCallback.DESCRIPTOR);
                    _data.writeTypedObject(state, 0);
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
