package com.stepos.taskrobot.common;

import M0.i;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.taskrobot.common.bean.ActionInfo;
import com.stepos.taskrobot.common.bean.ExplainSnapshot;
import com.stepos.taskrobot.common.bean.TaskInfo;

/* loaded from: classes3.dex */
public interface ITaskProgressCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.taskrobot.common.ITaskProgressCallback";

    public static class Default implements ITaskProgressCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onAction(TaskInfo taskInfo, ActionInfo actionInfo) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onInfoDismissed(String str, String str2, String str3, String str4) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onInfoRequested(String str, String str2, String str3, String str4, String str5, String str6, long j5, String str7) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onPackageConflict(int i, String str, String str2, String str3, String str4, String str5) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onRequestRelaunch(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onTaskAction(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onTaskActionPair(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskProgressCallback
        public void onTaskStatusChange(TaskInfo taskInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskProgressCallback {
        static final int TRANSACTION_onAction = 4;
        static final int TRANSACTION_onExplainUpdated = 7;
        static final int TRANSACTION_onInfoDismissed = 6;
        static final int TRANSACTION_onInfoRequested = 5;
        static final int TRANSACTION_onPackageConflict = 8;
        static final int TRANSACTION_onRequestRelaunch = 9;
        static final int TRANSACTION_onTaskAction = 1;
        static final int TRANSACTION_onTaskActionPair = 2;
        static final int TRANSACTION_onTaskStatusChange = 3;

        public static class Proxy implements ITaskProgressCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskProgressCallback.DESCRIPTOR;
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onAction(TaskInfo taskInfo, ActionInfo actionInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    i.b(parcelObtain, taskInfo);
                    i.b(parcelObtain, actionInfo);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    i.b(parcelObtain, explainSnapshot);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onInfoDismissed(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onInfoRequested(String str, String str2, String str3, String str4, String str5, String str6, long j5, String str7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeString(str7);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onPackageConflict(int i, String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onRequestRelaunch(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskAction(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    i.b(parcelObtain, bitmap);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskActionPair(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    i.b(parcelObtain, bitmap);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskStatusChange(TaskInfo taskInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskProgressCallback.DESCRIPTOR);
                    i.b(parcelObtain, taskInfo);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskProgressCallback.DESCRIPTOR);
        }

        public static ITaskProgressCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskProgressCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskProgressCallback)) ? new Proxy(iBinder) : (ITaskProgressCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskProgressCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskProgressCallback.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    onTaskAction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Bitmap) i.a(parcel, Bitmap.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    onTaskActionPair(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Bitmap) i.a(parcel, Bitmap.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    onTaskStatusChange((TaskInfo) i.a(parcel, TaskInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    onAction((TaskInfo) i.a(parcel, TaskInfo.CREATOR), (ActionInfo) i.a(parcel, ActionInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onInfoRequested(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onInfoDismissed(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    onExplainUpdated(parcel.readString(), (ExplainSnapshot) i.a(parcel, ExplainSnapshot.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    onPackageConflict(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    onRequestRelaunch(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    void onAction(TaskInfo taskInfo, ActionInfo actionInfo) throws RemoteException;

    void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) throws RemoteException;

    void onInfoDismissed(String str, String str2, String str3, String str4) throws RemoteException;

    void onInfoRequested(String str, String str2, String str3, String str4, String str5, String str6, long j5, String str7) throws RemoteException;

    void onPackageConflict(int i, String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void onRequestRelaunch(String str, String str2, String str3) throws RemoteException;

    void onTaskAction(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException;

    void onTaskActionPair(String str, String str2, String str3, String str4, Bitmap bitmap, String str5) throws RemoteException;

    void onTaskStatusChange(TaskInfo taskInfo) throws RemoteException;
}
