package android.media.alwayson;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAlwaysOnVoiceService extends IInterface {
    public static final String DESCRIPTOR = "android.media.alwayson.IAlwaysOnVoiceService";

    void disableVadListening(String str) throws RemoteException;

    void enableVadListening(AlwaysOnVadListenRequest alwaysOnVadListenRequest) throws RemoteException;

    boolean isCapturing() throws RemoteException;

    boolean isVadListeningActive() throws RemoteException;

    boolean isVadListeningEnabled(String str) throws RemoteException;

    public static class Default implements IAlwaysOnVoiceService {
        @Override // android.media.alwayson.IAlwaysOnVoiceService
        public void enableVadListening(AlwaysOnVadListenRequest request) throws RemoteException {
        }

        @Override // android.media.alwayson.IAlwaysOnVoiceService
        public void disableVadListening(String callerTag) throws RemoteException {
        }

        @Override // android.media.alwayson.IAlwaysOnVoiceService
        public boolean isCapturing() throws RemoteException {
            return false;
        }

        @Override // android.media.alwayson.IAlwaysOnVoiceService
        public boolean isVadListeningEnabled(String callerTag) throws RemoteException {
            return false;
        }

        @Override // android.media.alwayson.IAlwaysOnVoiceService
        public boolean isVadListeningActive() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAlwaysOnVoiceService {
        static final int TRANSACTION_disableVadListening = 2;
        static final int TRANSACTION_enableVadListening = 1;
        static final int TRANSACTION_isCapturing = 3;
        static final int TRANSACTION_isVadListeningActive = 5;
        static final int TRANSACTION_isVadListeningEnabled = 4;

        public Stub() {
            attachInterface(this, IAlwaysOnVoiceService.DESCRIPTOR);
        }

        public static IAlwaysOnVoiceService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAlwaysOnVoiceService.DESCRIPTOR);
            if (iin != null && (iin instanceof IAlwaysOnVoiceService)) {
                return (IAlwaysOnVoiceService) iin;
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
                    return "enableVadListening";
                case 2:
                    return "disableVadListening";
                case 3:
                    return "isCapturing";
                case 4:
                    return "isVadListeningEnabled";
                case 5:
                    return "isVadListeningActive";
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
                data.enforceInterface(IAlwaysOnVoiceService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IAlwaysOnVoiceService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    AlwaysOnVadListenRequest _arg0 = (AlwaysOnVadListenRequest) data.readTypedObject(AlwaysOnVadListenRequest.CREATOR);
                    enableVadListening(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    disableVadListening(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    boolean _result = isCapturing();
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 4:
                    String _arg03 = data.readString();
                    boolean _result2 = isVadListeningEnabled(_arg03);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 5:
                    boolean _result3 = isVadListeningActive();
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IAlwaysOnVoiceService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAlwaysOnVoiceService.DESCRIPTOR;
            }

            @Override // android.media.alwayson.IAlwaysOnVoiceService
            public void enableVadListening(AlwaysOnVadListenRequest request) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceService.DESCRIPTOR);
                    _data.writeTypedObject(request, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.IAlwaysOnVoiceService
            public void disableVadListening(String callerTag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceService.DESCRIPTOR);
                    _data.writeString(callerTag);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.IAlwaysOnVoiceService
            public boolean isCapturing() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceService.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.IAlwaysOnVoiceService
            public boolean isVadListeningEnabled(String callerTag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceService.DESCRIPTOR);
                    _data.writeString(callerTag);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.IAlwaysOnVoiceService
            public boolean isVadListeningActive() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceService.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
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
            return 4;
        }
    }
}
