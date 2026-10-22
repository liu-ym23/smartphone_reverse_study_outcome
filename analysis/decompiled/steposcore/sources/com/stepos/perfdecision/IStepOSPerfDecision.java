package com.stepos.perfdecision;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSPerfDecision extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.perfdecision.IStepOSPerfDecision";

    int acquireThermalConstraint(String str, Bundle bundle) throws RemoteException;

    int releaseThermalConstraint() throws RemoteException;

    public static class Default implements IStepOSPerfDecision {
        @Override // com.stepos.perfdecision.IStepOSPerfDecision
        public int acquireThermalConstraint(String temp, Bundle params) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.perfdecision.IStepOSPerfDecision
        public int releaseThermalConstraint() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSPerfDecision {
        static final int TRANSACTION_acquireThermalConstraint = 1;
        static final int TRANSACTION_releaseThermalConstraint = 2;

        public Stub() {
            attachInterface(this, IStepOSPerfDecision.DESCRIPTOR);
        }

        public static IStepOSPerfDecision asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSPerfDecision.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSPerfDecision)) {
                return (IStepOSPerfDecision) iin;
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
                    return "acquireThermalConstraint";
                case 2:
                    return "releaseThermalConstraint";
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
                data.enforceInterface(IStepOSPerfDecision.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSPerfDecision.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    Bundle _arg1 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    int _result = acquireThermalConstraint(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    int _result2 = releaseThermalConstraint();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSPerfDecision {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSPerfDecision.DESCRIPTOR;
            }

            @Override // com.stepos.perfdecision.IStepOSPerfDecision
            public int acquireThermalConstraint(String temp, Bundle params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPerfDecision.DESCRIPTOR);
                    _data.writeString(temp);
                    _data.writeTypedObject(params, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.perfdecision.IStepOSPerfDecision
            public int releaseThermalConstraint() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPerfDecision.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
