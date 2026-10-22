package com.zyql.intenttaskmanager;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.intenttaskmanager.ITaskListener;
import com.zyql.intenttaskmanager.ITaskStatusListener;
import com.zyql.intenttaskmanager.bean.Task;
import com.zyql.intenttaskmanager.bean.TaskConfig;
import com.zyql.intenttaskmanager.bean.TaskEvent;
import java.util.List;

/* loaded from: classes4.dex */
public interface IIntentTaskManager extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.intenttaskmanager.IIntentTaskManager";

    public static class Default implements IIntentTaskManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void cancelFullScreenGui(String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void fullScreenGui(String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void publishTaskEvent(TaskEvent taskEvent) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public List<Task> queryAllTasks() throws RemoteException {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public Task queryTask(String str) throws RemoteException {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void registerTaskStatusListener(String str, ITaskStatusListener iTaskStatusListener) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void removeTask(String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public String submitTask(TaskConfig taskConfig, ITaskStatusListener iTaskStatusListener) throws RemoteException {
            return null;
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void toolUpdateTask(Task task) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void unRegisterTaskListener(String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void unRegisterTaskStatusListener(String str) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void updateTask(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.zyql.intenttaskmanager.IIntentTaskManager
        public void updateTaskStatusAndControl(String str, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IIntentTaskManager {
        static final int TRANSACTION_cancelFullScreenGui = 14;
        static final int TRANSACTION_fullScreenGui = 13;
        static final int TRANSACTION_publishTaskEvent = 5;
        static final int TRANSACTION_queryAllTasks = 11;
        static final int TRANSACTION_queryTask = 10;
        static final int TRANSACTION_registerTaskListener = 6;
        static final int TRANSACTION_registerTaskStatusListener = 8;
        static final int TRANSACTION_removeTask = 12;
        static final int TRANSACTION_submitTask = 1;
        static final int TRANSACTION_toolUpdateTask = 2;
        static final int TRANSACTION_unRegisterTaskListener = 7;
        static final int TRANSACTION_unRegisterTaskStatusListener = 9;
        static final int TRANSACTION_updateTask = 4;
        static final int TRANSACTION_updateTaskStatusAndControl = 3;

        public static class Proxy implements IIntentTaskManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void cancelFullScreenGui(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void fullScreenGui(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IIntentTaskManager.DESCRIPTOR;
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void publishTaskEvent(TaskEvent taskEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    a.f(parcelObtain, taskEvent, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public List<Task> queryAllTasks() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Task.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public Task queryTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Task) a.d(parcelObtain2, Task.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTaskListener);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void registerTaskStatusListener(String str, ITaskStatusListener iTaskStatusListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iTaskStatusListener);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void removeTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public String submitTask(TaskConfig taskConfig, ITaskStatusListener iTaskStatusListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    a.f(parcelObtain, taskConfig, 0);
                    parcelObtain.writeStrongInterface(iTaskStatusListener);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void toolUpdateTask(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    a.f(parcelObtain, task, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void unRegisterTaskListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void unRegisterTaskStatusListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void updateTask(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.intenttaskmanager.IIntentTaskManager
            public void updateTaskStatusAndControl(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IIntentTaskManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IIntentTaskManager.DESCRIPTOR);
        }

        public static IIntentTaskManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IIntentTaskManager.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IIntentTaskManager)) ? new Proxy(iBinder) : (IIntentTaskManager) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IIntentTaskManager.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IIntentTaskManager.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    String strSubmitTask = submitTask((TaskConfig) a.d(parcel, TaskConfig.CREATOR), ITaskStatusListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(strSubmitTask);
                    return true;
                case 2:
                    toolUpdateTask((Task) a.d(parcel, Task.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    updateTaskStatusAndControl(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    updateTask(parcel.readString(), (Bundle) a.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    publishTaskEvent((TaskEvent) a.d(parcel, TaskEvent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    registerTaskListener(ITaskListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    unRegisterTaskListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    registerTaskStatusListener(parcel.readString(), ITaskStatusListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    unRegisterTaskStatusListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    Task taskQueryTask = queryTask(parcel.readString());
                    parcel2.writeNoException();
                    a.f(parcel2, taskQueryTask, 1);
                    return true;
                case 11:
                    List<Task> listQueryAllTasks = queryAllTasks();
                    parcel2.writeNoException();
                    a.e(parcel2, listQueryAllTasks, 1);
                    return true;
                case 12:
                    removeTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    fullScreenGui(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    cancelFullScreenGui(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class a {
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                f(parcel, list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void f(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void cancelFullScreenGui(String str) throws RemoteException;

    void fullScreenGui(String str) throws RemoteException;

    void publishTaskEvent(TaskEvent taskEvent) throws RemoteException;

    List<Task> queryAllTasks() throws RemoteException;

    Task queryTask(String str) throws RemoteException;

    void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException;

    void registerTaskStatusListener(String str, ITaskStatusListener iTaskStatusListener) throws RemoteException;

    void removeTask(String str) throws RemoteException;

    String submitTask(TaskConfig taskConfig, ITaskStatusListener iTaskStatusListener) throws RemoteException;

    void toolUpdateTask(Task task) throws RemoteException;

    void unRegisterTaskListener(String str) throws RemoteException;

    void unRegisterTaskStatusListener(String str) throws RemoteException;

    void updateTask(String str, Bundle bundle) throws RemoteException;

    void updateTaskStatusAndControl(String str, int i10) throws RemoteException;
}
