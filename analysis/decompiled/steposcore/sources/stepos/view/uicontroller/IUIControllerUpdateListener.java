package stepos.view.uicontroller;

import android.app.ActivityManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUIControllerUpdateListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.view.uicontroller.IUIControllerUpdateListener";

    void onTopWindowUIControllerChanged(int i, IBinder iBinder, ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException;

    public static class Default implements IUIControllerUpdateListener {
        @Override // stepos.view.uicontroller.IUIControllerUpdateListener
        public void onTopWindowUIControllerChanged(int displayId, IBinder binder, ActivityManager.RunningTaskInfo taskinfo) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUIControllerUpdateListener {
        static final int TRANSACTION_onTopWindowUIControllerChanged = 1;

        public Stub() {
            attachInterface(this, IUIControllerUpdateListener.DESCRIPTOR);
        }

        public static IUIControllerUpdateListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IUIControllerUpdateListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IUIControllerUpdateListener)) {
                return (IUIControllerUpdateListener) iin;
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
                    return "onTopWindowUIControllerChanged";
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
                data.enforceInterface(IUIControllerUpdateListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IUIControllerUpdateListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    IBinder _arg1 = data.readStrongBinder();
                    ActivityManager.RunningTaskInfo _arg2 = (ActivityManager.RunningTaskInfo) data.readTypedObject(ActivityManager.RunningTaskInfo.CREATOR);
                    onTopWindowUIControllerChanged(_arg0, _arg1, _arg2);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IUIControllerUpdateListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUIControllerUpdateListener.DESCRIPTOR;
            }

            @Override // stepos.view.uicontroller.IUIControllerUpdateListener
            public void onTopWindowUIControllerChanged(int displayId, IBinder binder, ActivityManager.RunningTaskInfo taskinfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IUIControllerUpdateListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongBinder(binder);
                    _data.writeTypedObject(taskinfo, 0);
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
