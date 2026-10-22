package android.media;

import android.media.IAlwaysOnSceneDispatcher;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSAudioService extends IInterface {
    public static final String DESCRIPTOR = "android.media.IStepOSAudioService";

    String getParameters(String str) throws RemoteException;

    void registerAlwaysOnSceneCallback(int i, IAlwaysOnSceneDispatcher iAlwaysOnSceneDispatcher) throws RemoteException;

    int requestAudioTrackList(IBinder iBinder) throws RemoteException;

    void setParameters(String str) throws RemoteException;

    void unregisterAlwaysOnSceneCallback(int i, IAlwaysOnSceneDispatcher iAlwaysOnSceneDispatcher) throws RemoteException;

    public static class Default implements IStepOSAudioService {
        @Override // android.media.IStepOSAudioService
        public void setParameters(String keyValuePairs) throws RemoteException {
        }

        @Override // android.media.IStepOSAudioService
        public String getParameters(String keys) throws RemoteException {
            return null;
        }

        @Override // android.media.IStepOSAudioService
        public int requestAudioTrackList(IBinder callback) throws RemoteException {
            return 0;
        }

        @Override // android.media.IStepOSAudioService
        public void registerAlwaysOnSceneCallback(int audioSessionId, IAlwaysOnSceneDispatcher dispatcher) throws RemoteException {
        }

        @Override // android.media.IStepOSAudioService
        public void unregisterAlwaysOnSceneCallback(int audioSessionId, IAlwaysOnSceneDispatcher dispatcher) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAudioService {
        static final int TRANSACTION_getParameters = 2;
        static final int TRANSACTION_registerAlwaysOnSceneCallback = 4;
        static final int TRANSACTION_requestAudioTrackList = 3;
        static final int TRANSACTION_setParameters = 1;
        static final int TRANSACTION_unregisterAlwaysOnSceneCallback = 5;

        public Stub() {
            attachInterface(this, IStepOSAudioService.DESCRIPTOR);
        }

        public static IStepOSAudioService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAudioService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAudioService)) {
                return (IStepOSAudioService) iin;
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
                    return "setParameters";
                case 2:
                    return "getParameters";
                case 3:
                    return "requestAudioTrackList";
                case 4:
                    return "registerAlwaysOnSceneCallback";
                case 5:
                    return "unregisterAlwaysOnSceneCallback";
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
                data.enforceInterface(IStepOSAudioService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAudioService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    setParameters(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    String _result = getParameters(_arg02);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 3:
                    IBinder _arg03 = data.readStrongBinder();
                    int _result2 = requestAudioTrackList(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    IAlwaysOnSceneDispatcher _arg1 = IAlwaysOnSceneDispatcher.Stub.asInterface(data.readStrongBinder());
                    registerAlwaysOnSceneCallback(_arg04, _arg1);
                    reply.writeNoException();
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    IAlwaysOnSceneDispatcher _arg12 = IAlwaysOnSceneDispatcher.Stub.asInterface(data.readStrongBinder());
                    unregisterAlwaysOnSceneCallback(_arg05, _arg12);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAudioService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAudioService.DESCRIPTOR;
            }

            @Override // android.media.IStepOSAudioService
            public void setParameters(String keyValuePairs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAudioService.DESCRIPTOR);
                    _data.writeString(keyValuePairs);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.IStepOSAudioService
            public String getParameters(String keys) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAudioService.DESCRIPTOR);
                    _data.writeString(keys);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.IStepOSAudioService
            public int requestAudioTrackList(IBinder callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAudioService.DESCRIPTOR);
                    _data.writeStrongBinder(callback);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.IStepOSAudioService
            public void registerAlwaysOnSceneCallback(int audioSessionId, IAlwaysOnSceneDispatcher dispatcher) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAudioService.DESCRIPTOR);
                    _data.writeInt(audioSessionId);
                    _data.writeStrongInterface(dispatcher);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.IStepOSAudioService
            public void unregisterAlwaysOnSceneCallback(int audioSessionId, IAlwaysOnSceneDispatcher dispatcher) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAudioService.DESCRIPTOR);
                    _data.writeInt(audioSessionId);
                    _data.writeStrongInterface(dispatcher);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 4;
        }
    }
}
