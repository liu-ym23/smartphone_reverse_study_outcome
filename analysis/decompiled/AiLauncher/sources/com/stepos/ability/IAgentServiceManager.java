package com.stepos.ability;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.AbilityQueryParamsParcelable;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.SlaPermissionResult;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.bean.WhitelistCheckResult;
import java.util.List;

/* loaded from: classes2.dex */
public interface IAgentServiceManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IAgentServiceManager";

    public static class Default implements IAgentServiceManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelFullScreenGui(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelPackageConflict(String str, int i10) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelUserInput(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public SlaPermissionResult checkSlaPermissionV1(List<String> list) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void confirmPackageConflict(String str, int i10) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void dismissFullScreenOverlay(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void dismissVoiceInput(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void fullScreenGui(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getForegroundTaskId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getForegroundTaskSessionId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getLastActiveTaskSessionId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public AppOccupationResult isAppOccupiedV1(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public List<TaskSnapshot> listActiveTasks() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void resumeFullScreenOverlay(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void showFullScreenGuiV2(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String submitTask(TaskConfig taskConfig) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void submitToolCallEvent(ToolCallEvent toolCallEvent) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void submitUserInput(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void toolUpdateTask(Task task) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void unRegisterTaskListener(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void updateTask(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void updateTaskStatusAndControl(String str, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentServiceManager {
        static final int TRANSACTION_cancelFullScreenGui = 8;
        static final int TRANSACTION_cancelPackageConflict = 23;
        static final int TRANSACTION_cancelUserInput = 15;
        static final int TRANSACTION_checkAppWhitelistV1 = 17;
        static final int TRANSACTION_checkSlaPermissionV1 = 26;
        static final int TRANSACTION_confirmPackageConflict = 22;
        static final int TRANSACTION_dismissFullScreenOverlay = 24;
        static final int TRANSACTION_dismissVoiceInput = 13;
        static final int TRANSACTION_fullScreenGui = 7;
        static final int TRANSACTION_getForegroundTaskId = 11;
        static final int TRANSACTION_getForegroundTaskSessionId = 18;
        static final int TRANSACTION_getLastActiveTaskSessionId = 19;
        static final int TRANSACTION_getMainDisplayTopAppHistory = 20;
        static final int TRANSACTION_isAppOccupiedV1 = 21;
        static final int TRANSACTION_listActiveTasks = 12;
        static final int TRANSACTION_queryAbilities = 10;
        static final int TRANSACTION_registerTaskListener = 5;
        static final int TRANSACTION_resumeFullScreenOverlay = 25;
        static final int TRANSACTION_showFullScreenGuiV2 = 16;
        static final int TRANSACTION_submitTask = 1;
        static final int TRANSACTION_submitToolCallEvent = 9;
        static final int TRANSACTION_submitUserInput = 14;
        static final int TRANSACTION_toolUpdateTask = 2;
        static final int TRANSACTION_unRegisterTaskListener = 6;
        static final int TRANSACTION_updateTask = 4;
        static final int TRANSACTION_updateTaskStatusAndControl = 3;

        public static class Proxy implements IAgentServiceManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelFullScreenGui(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelPackageConflict(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelUserInput(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (WhitelistCheckResult) a.d(parcelObtain2, WhitelistCheckResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public SlaPermissionResult checkSlaPermissionV1(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SlaPermissionResult) a.d(parcelObtain2, SlaPermissionResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void confirmPackageConflict(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void dismissFullScreenOverlay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void dismissVoiceInput(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void fullScreenGui(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getForegroundTaskId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getForegroundTaskSessionId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAgentServiceManager.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getLastActiveTaskSessionId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (MainDisplayTopAppHistory) a.d(parcelObtain2, MainDisplayTopAppHistory.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public AppOccupationResult isAppOccupiedV1(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AppOccupationResult) a.d(parcelObtain2, AppOccupationResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public List<TaskSnapshot> listActiveTasks() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(TaskSnapshot.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.e(parcelObtain, list, 0);
                    parcelObtain.writeStrongInterface(iAbilityQueryCallback);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iTaskListener);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void resumeFullScreenOverlay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void showFullScreenGuiV2(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, bundle, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String submitTask(TaskConfig taskConfig) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.f(parcelObtain, taskConfig, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitToolCallEvent(ToolCallEvent toolCallEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.f(parcelObtain, toolCallEvent, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitUserInput(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void toolUpdateTask(Task task) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.f(parcelObtain, task, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void unRegisterTaskListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void updateTask(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void updateTaskStatusAndControl(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
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
            attachInterface(this, IAgentServiceManager.DESCRIPTOR);
        }

        public static IAgentServiceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAgentServiceManager.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAgentServiceManager)) ? new Proxy(iBinder) : (IAgentServiceManager) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAgentServiceManager.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAgentServiceManager.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    String strSubmitTask = submitTask((TaskConfig) a.d(parcel, TaskConfig.CREATOR));
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
                    registerTaskListener(ITaskListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    unRegisterTaskListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    fullScreenGui(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    cancelFullScreenGui(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    submitToolCallEvent((ToolCallEvent) a.d(parcel, ToolCallEvent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    queryAbilities(parcel.readString(), parcel.createTypedArrayList(AbilityQueryParamsParcelable.INSTANCE), IAbilityQueryCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    String foregroundTaskId = getForegroundTaskId();
                    parcel2.writeNoException();
                    parcel2.writeString(foregroundTaskId);
                    return true;
                case 12:
                    List<TaskSnapshot> listListActiveTasks = listActiveTasks();
                    parcel2.writeNoException();
                    a.e(parcel2, listListActiveTasks, 1);
                    return true;
                case 13:
                    dismissVoiceInput(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    submitUserInput(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    cancelUserInput(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    showFullScreenGuiV2(parcel.readString(), (Bundle) a.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    WhitelistCheckResult whitelistCheckResultCheckAppWhitelistV1 = checkAppWhitelistV1(parcel.readString());
                    parcel2.writeNoException();
                    a.f(parcel2, whitelistCheckResultCheckAppWhitelistV1, 1);
                    return true;
                case 18:
                    String foregroundTaskSessionId = getForegroundTaskSessionId();
                    parcel2.writeNoException();
                    parcel2.writeString(foregroundTaskSessionId);
                    return true;
                case 19:
                    String lastActiveTaskSessionId = getLastActiveTaskSessionId();
                    parcel2.writeNoException();
                    parcel2.writeString(lastActiveTaskSessionId);
                    return true;
                case 20:
                    MainDisplayTopAppHistory mainDisplayTopAppHistory = getMainDisplayTopAppHistory();
                    parcel2.writeNoException();
                    a.f(parcel2, mainDisplayTopAppHistory, 1);
                    return true;
                case 21:
                    AppOccupationResult appOccupationResultIsAppOccupiedV1 = isAppOccupiedV1(parcel.readString());
                    parcel2.writeNoException();
                    a.f(parcel2, appOccupationResultIsAppOccupiedV1, 1);
                    return true;
                case 22:
                    confirmPackageConflict(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    cancelPackageConflict(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    dismissFullScreenOverlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    resumeFullScreenOverlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    SlaPermissionResult slaPermissionResultCheckSlaPermissionV1 = checkSlaPermissionV1(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    a.f(parcel2, slaPermissionResultCheckSlaPermissionV1, 1);
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

    void cancelPackageConflict(String str, int i10) throws RemoteException;

    void cancelUserInput(String str, String str2) throws RemoteException;

    WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException;

    SlaPermissionResult checkSlaPermissionV1(List<String> list) throws RemoteException;

    void confirmPackageConflict(String str, int i10) throws RemoteException;

    void dismissFullScreenOverlay(String str) throws RemoteException;

    void dismissVoiceInput(String str) throws RemoteException;

    void fullScreenGui(String str) throws RemoteException;

    String getForegroundTaskId() throws RemoteException;

    String getForegroundTaskSessionId() throws RemoteException;

    String getLastActiveTaskSessionId() throws RemoteException;

    MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException;

    AppOccupationResult isAppOccupiedV1(String str) throws RemoteException;

    List<TaskSnapshot> listActiveTasks() throws RemoteException;

    void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException;

    void registerTaskListener(ITaskListener iTaskListener, String str) throws RemoteException;

    void resumeFullScreenOverlay(String str) throws RemoteException;

    void showFullScreenGuiV2(String str, Bundle bundle) throws RemoteException;

    String submitTask(TaskConfig taskConfig) throws RemoteException;

    void submitToolCallEvent(ToolCallEvent toolCallEvent) throws RemoteException;

    void submitUserInput(String str, String str2, String str3) throws RemoteException;

    void toolUpdateTask(Task task) throws RemoteException;

    void unRegisterTaskListener(String str) throws RemoteException;

    void updateTask(String str, Bundle bundle) throws RemoteException;

    void updateTaskStatusAndControl(String str, int i10) throws RemoteException;
}
