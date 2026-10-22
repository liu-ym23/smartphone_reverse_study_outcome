package android.security.keystore;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IKeyAttestationApplicationIdProvider extends IInterface {
    public static final String DESCRIPTOR = "android.security.keystore.IKeyAttestationApplicationIdProvider";
    public static final int ERROR_GET_ATTESTATION_APPLICATION_ID_FAILED = 1;

    public static class Default implements IKeyAttestationApplicationIdProvider {
        public Default() {
        }

        @Override // android.security.keystore.IKeyAttestationApplicationIdProvider
        public KeyAttestationApplicationId getKeyAttestationApplicationId(int uid) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IKeyAttestationApplicationIdProvider {
        static final int TRANSACTION_getKeyAttestationApplicationId = 1;

        private static class Proxy implements IKeyAttestationApplicationIdProvider {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IKeyAttestationApplicationIdProvider.DESCRIPTOR;
            }

            @Override // android.security.keystore.IKeyAttestationApplicationIdProvider
            public KeyAttestationApplicationId getKeyAttestationApplicationId(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IKeyAttestationApplicationIdProvider.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                KeyAttestationApplicationId _result = (KeyAttestationApplicationId) _reply.readTypedObject(KeyAttestationApplicationId.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IKeyAttestationApplicationIdProvider.DESCRIPTOR);
        }

        public static IKeyAttestationApplicationIdProvider asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IKeyAttestationApplicationIdProvider.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IKeyAttestationApplicationIdProvider) == false) goto L12;
            return (IKeyAttestationApplicationIdProvider) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IKeyAttestationApplicationIdProvider.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IKeyAttestationApplicationIdProvider.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L14;
                default: goto L13;
            };
        L14:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            KeyAttestationApplicationId _result = getKeyAttestationApplicationId(_arg0);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    KeyAttestationApplicationId getKeyAttestationApplicationId(int r1) throws RemoteException;
}
