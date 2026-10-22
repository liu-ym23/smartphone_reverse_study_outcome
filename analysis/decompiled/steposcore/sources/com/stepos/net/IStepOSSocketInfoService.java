package com.stepos.net;

import android.net.Network;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSSocketInfoService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.net.IStepOSSocketInfoService";

    List<StepOSSocketInfo> getTcpSocketInfos(Network network) throws RemoteException;

    public static class Default implements IStepOSSocketInfoService {
        @Override // com.stepos.net.IStepOSSocketInfoService
        public List<StepOSSocketInfo> getTcpSocketInfos(Network network) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSSocketInfoService {
        static final int TRANSACTION_getTcpSocketInfos = 1;

        public Stub() {
            attachInterface(this, IStepOSSocketInfoService.DESCRIPTOR);
        }

        public static IStepOSSocketInfoService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSSocketInfoService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSSocketInfoService)) {
                return (IStepOSSocketInfoService) iin;
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
                    return "getTcpSocketInfos";
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
                data.enforceInterface(IStepOSSocketInfoService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSSocketInfoService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    Network _arg0 = (Network) data.readTypedObject(Network.CREATOR);
                    List<StepOSSocketInfo> _result = getTcpSocketInfos(_arg0);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result, 1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSSocketInfoService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSSocketInfoService.DESCRIPTOR;
            }

            @Override // com.stepos.net.IStepOSSocketInfoService
            public List<StepOSSocketInfo> getTcpSocketInfos(Network network) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSocketInfoService.DESCRIPTOR);
                    _data.writeTypedObject(network, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSSocketInfo> _result = _reply.createTypedArrayList(StepOSSocketInfo.CREATOR);
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
