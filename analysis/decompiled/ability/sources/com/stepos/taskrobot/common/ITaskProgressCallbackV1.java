package com.stepos.taskrobot.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.taskrobot.common.bean.ExtraParameters;

/* loaded from: classes3.dex */
public interface ITaskProgressCallbackV1 extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.taskrobot.common.ITaskProgressCallbackV1";

    public static class Default implements ITaskProgressCallbackV1 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallbackV1
        public void onTaskAction(String str, String str2, ExtraParameters extraParameters) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskProgressCallbackV1 {
        static final int TRANSACTION_onTaskAction = 1;

        public static class Proxy implements ITaskProgressCallbackV1 {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskProgressCallbackV1.DESCRIPTOR;
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallbackV1
            public void onTaskAction(String str, String str2, ExtraParameters extraParameters) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallbackV1.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (extraParameters != null) {
                        parcelObtain.writeInt(1);
                        extraParameters.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskProgressCallbackV1.DESCRIPTOR);
        }

        public static ITaskProgressCallbackV1 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskProgressCallbackV1.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskProgressCallbackV1)) ? new Proxy(iBinder) : (ITaskProgressCallbackV1) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskProgressCallbackV1.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskProgressCallbackV1.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onTaskAction(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ExtraParameters.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onTaskAction(String str, String str2, ExtraParameters extraParameters) throws RemoteException;
}
