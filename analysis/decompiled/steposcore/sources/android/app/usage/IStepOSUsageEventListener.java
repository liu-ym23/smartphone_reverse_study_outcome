package android.app.usage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSUsageEventListener extends IInterface {
    public static final String DESCRIPTOR = "android.app.usage.IStepOSUsageEventListener";

    void onEvent(UsageEvents usageEvents, int i) throws RemoteException;

    public static class Default implements IStepOSUsageEventListener {
        @Override // android.app.usage.IStepOSUsageEventListener
        public void onEvent(UsageEvents usageEvents, int eventType) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSUsageEventListener {
        static final int TRANSACTION_onEvent = 1;

        public Stub() {
            attachInterface(this, IStepOSUsageEventListener.DESCRIPTOR);
        }

        public static IStepOSUsageEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSUsageEventListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSUsageEventListener)) {
                return (IStepOSUsageEventListener) iin;
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
                    return "onEvent";
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
                data.enforceInterface(IStepOSUsageEventListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSUsageEventListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    UsageEvents _arg0 = (UsageEvents) data.readTypedObject(UsageEvents.CREATOR);
                    int _arg1 = data.readInt();
                    onEvent(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSUsageEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSUsageEventListener.DESCRIPTOR;
            }

            @Override // android.app.usage.IStepOSUsageEventListener
            public void onEvent(UsageEvents usageEvents, int eventType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSUsageEventListener.DESCRIPTOR);
                    _data.writeTypedObject(usageEvents, 0);
                    _data.writeInt(eventType);
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
