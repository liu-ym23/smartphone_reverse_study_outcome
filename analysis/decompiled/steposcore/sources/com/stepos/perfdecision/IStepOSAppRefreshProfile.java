package com.stepos.perfdecision;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSAppRefreshProfile extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.perfdecision.IStepOSAppRefreshProfile";

    int[] getMaxBatch(String[] strArr) throws RemoteException;

    public static class Default implements IStepOSAppRefreshProfile {
        @Override // com.stepos.perfdecision.IStepOSAppRefreshProfile
        public int[] getMaxBatch(String[] pkgs) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAppRefreshProfile {
        static final int TRANSACTION_getMaxBatch = 1;

        public Stub() {
            attachInterface(this, IStepOSAppRefreshProfile.DESCRIPTOR);
        }

        public static IStepOSAppRefreshProfile asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAppRefreshProfile.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAppRefreshProfile)) {
                return (IStepOSAppRefreshProfile) iin;
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
                    return "getMaxBatch";
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
                data.enforceInterface(IStepOSAppRefreshProfile.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAppRefreshProfile.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String[] _arg0 = data.createStringArray();
                    int[] _result = getMaxBatch(_arg0);
                    reply.writeNoException();
                    reply.writeIntArray(_result);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAppRefreshProfile {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAppRefreshProfile.DESCRIPTOR;
            }

            @Override // com.stepos.perfdecision.IStepOSAppRefreshProfile
            public int[] getMaxBatch(String[] pkgs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAppRefreshProfile.DESCRIPTOR);
                    _data.writeStringArray(pkgs);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
