package com.zyql.intenttaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.intenttaskmanager.bean.Task;

/* loaded from: classes4.dex */
public interface IAsyncTaskRunner extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.intenttaskmanager.IAsyncTaskRunner";

    public static class Default implements IAsyncTaskRunner {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
        public void doCancel(Task task) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
        public void doPause(Task task) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
        public void doResume(Task task) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
        public void doStart(Task task) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAsyncTaskRunner {
        static final int TRANSACTION_doCancel = 4;
        static final int TRANSACTION_doPause = 2;
        static final int TRANSACTION_doResume = 3;
        static final int TRANSACTION_doStart = 1;

        public static class Proxy implements IAsyncTaskRunner {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
            public void doCancel(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAsyncTaskRunner.DESCRIPTOR);
                    a.d(parcelObtain, task, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
            public void doPause(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAsyncTaskRunner.DESCRIPTOR);
                    a.d(parcelObtain, task, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
            public void doResume(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAsyncTaskRunner.DESCRIPTOR);
                    a.d(parcelObtain, task, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IAsyncTaskRunner
            public void doStart(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAsyncTaskRunner.DESCRIPTOR);
                    a.d(parcelObtain, task, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAsyncTaskRunner.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IAsyncTaskRunner.DESCRIPTOR);
        }

        public static IAsyncTaskRunner asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAsyncTaskRunner.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAsyncTaskRunner)) ? new Proxy(iBinder) : (IAsyncTaskRunner) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAsyncTaskRunner.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAsyncTaskRunner.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                doStart((Task) a.c(parcel, Task.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 2) {
                doPause((Task) a.c(parcel, Task.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 3) {
                doResume((Task) a.c(parcel, Task.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i10 != 4) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                doCancel((Task) a.c(parcel, Task.CREATOR));
                parcel2.writeNoException();
            }
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

    void doCancel(Task task) throws RemoteException;

    void doPause(Task task) throws RemoteException;

    void doResume(Task task) throws RemoteException;

    void doStart(Task task) throws RemoteException;
}
