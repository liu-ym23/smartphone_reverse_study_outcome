package com.zyql.intenttaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.intenttaskmanager.bean.Task;

/* loaded from: classes4.dex */
public interface ITaskListener extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.intenttaskmanager.ITaskListener";

    public static class Default implements ITaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.ITaskListener
        public void onTaskEvent(Task task) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskListener {
        static final int TRANSACTION_onTaskEvent = 1;

        public static class Proxy implements ITaskListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskListener.DESCRIPTOR;
            }

            @Override // com.zyql.intenttaskmanager.ITaskListener
            public void onTaskEvent(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    a.d(parcelObtain, task, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskListener.DESCRIPTOR);
        }

        public static ITaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskListener)) ? new Proxy(iBinder) : (ITaskListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ITaskListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ITaskListener.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onTaskEvent((Task) a.c(parcel, Task.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void onTaskEvent(Task task) throws RemoteException;
}
