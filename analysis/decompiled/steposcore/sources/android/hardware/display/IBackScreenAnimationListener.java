package android.hardware.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IBackScreenAnimationListener extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.display.IBackScreenAnimationListener";

    void onBackScreenAnimationResult(BackScreenAnimationInfo backScreenAnimationInfo, boolean z) throws RemoteException;

    public static class Default implements IBackScreenAnimationListener {
        @Override // android.hardware.display.IBackScreenAnimationListener
        public void onBackScreenAnimationResult(BackScreenAnimationInfo info, boolean success) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IBackScreenAnimationListener {
        static final int TRANSACTION_onBackScreenAnimationResult = 1;

        public Stub() {
            attachInterface(this, IBackScreenAnimationListener.DESCRIPTOR);
        }

        public static IBackScreenAnimationListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IBackScreenAnimationListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IBackScreenAnimationListener)) {
                return (IBackScreenAnimationListener) iin;
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
                    return "onBackScreenAnimationResult";
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
                data.enforceInterface(IBackScreenAnimationListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IBackScreenAnimationListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    BackScreenAnimationInfo _arg0 = (BackScreenAnimationInfo) data.readTypedObject(BackScreenAnimationInfo.CREATOR);
                    boolean _arg1 = data.readBoolean();
                    onBackScreenAnimationResult(_arg0, _arg1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IBackScreenAnimationListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBackScreenAnimationListener.DESCRIPTOR;
            }

            @Override // android.hardware.display.IBackScreenAnimationListener
            public void onBackScreenAnimationResult(BackScreenAnimationInfo info, boolean success) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenAnimationListener.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    _data.writeBoolean(success);
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
