package com.stepos.taskrobot.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ITaskRobotCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.taskrobot.common.ITaskRobotCallback";

    public static class Default implements ITaskRobotCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotCallback
        public void onTaskAction(String str, String str2, int i, String str3, long j5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskRobotCallback {
        static final int TRANSACTION_onTaskAction = 1;

        public static class Proxy implements ITaskRobotCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskRobotCallback.DESCRIPTOR;
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotCallback
            public void onTaskAction(String str, String str2, int i, String str3, long j5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskRobotCallback.DESCRIPTOR);
        }

        public static ITaskRobotCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskRobotCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskRobotCallback)) ? new Proxy(iBinder) : (ITaskRobotCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskRobotCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskRobotCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onTaskAction(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void onTaskAction(String str, String str2, int i, String str3, long j5) throws RemoteException;
}
