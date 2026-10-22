package android.hardware.input;

import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSInputManager extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.input.IStepOSInputManager";

    void updateInputMonitorTouchRegionWithCrop(IBinder iBinder, Rect rect) throws RemoteException;

    public static class Default implements IStepOSInputManager {
        @Override // android.hardware.input.IStepOSInputManager
        public void updateInputMonitorTouchRegionWithCrop(IBinder inputChannelToken, Rect region) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSInputManager {
        static final int TRANSACTION_updateInputMonitorTouchRegionWithCrop = 1;

        public Stub() {
            attachInterface(this, IStepOSInputManager.DESCRIPTOR);
        }

        public static IStepOSInputManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSInputManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSInputManager)) {
                return (IStepOSInputManager) iin;
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
                    return "updateInputMonitorTouchRegionWithCrop";
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
                data.enforceInterface(IStepOSInputManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSInputManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    IBinder _arg0 = data.readStrongBinder();
                    Rect _arg1 = (Rect) data.readTypedObject(Rect.CREATOR);
                    updateInputMonitorTouchRegionWithCrop(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSInputManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSInputManager.DESCRIPTOR;
            }

            @Override // android.hardware.input.IStepOSInputManager
            public void updateInputMonitorTouchRegionWithCrop(IBinder inputChannelToken, Rect region) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInputManager.DESCRIPTOR);
                    _data.writeStrongBinder(inputChannelToken);
                    _data.writeTypedObject(region, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
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
