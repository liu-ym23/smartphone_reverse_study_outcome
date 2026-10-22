package com.stepos.ability;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.AbilityQueryParamsParcelable;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.bean.WhitelistCheckResult;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IAgentServiceManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IAgentServiceManager";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, List list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                c(parcel, (Parcelable) list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void c(Parcel parcel, T t8, int i10) {
            if (t8 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t8.writeToParcel(parcel, i10);
            }
        }
    }

    void cancelFullScreenGui(String str);

    void cancelPackageConflict(String str, int i10);

    void cancelUserInput(String str, String str2);

    WhitelistCheckResult checkAppWhitelistV1(String str);

    void confirmPackageConflict(String str, int i10);

    void dismissFullScreenOverlay(String str);

    void dismissVoiceInput(String str);

    void fullScreenGui(String str);

    String getForegroundTaskId();

    String getForegroundTaskSessionId();

    String getLastActiveTaskSessionId();

    MainDisplayTopAppHistory getMainDisplayTopAppHistory();

    AppOccupationResult isAppOccupiedV1(String str);

    List<TaskSnapshot> listActiveTasks();

    void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback);

    void registerTaskListener(ITaskListener iTaskListener, String str);

    void resumeFullScreenOverlay(String str);

    void showFullScreenGuiV2(String str, Bundle bundle);

    String submitTask(TaskConfig taskConfig);

    void submitToolCallEvent(ToolCallEvent toolCallEvent);

    void submitUserInput(String str, String str2, String str3);

    void toolUpdateTask(Task task);

    void unRegisterTaskListener(String str);

    void updateTask(String str, Bundle bundle);

    void updateTaskStatusAndControl(String str, int i10);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements IAgentServiceManager {
        static final int TRANSACTION_cancelFullScreenGui = 8;
        static final int TRANSACTION_cancelPackageConflict = 23;
        static final int TRANSACTION_cancelUserInput = 15;
        static final int TRANSACTION_checkAppWhitelistV1 = 17;
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

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            public void cancelFullScreenGui(String str) {
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
            public void cancelPackageConflict(String str, int i10) {
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
            public void cancelUserInput(String str, String str2) {
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
            public WhitelistCheckResult checkAppWhitelistV1(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (WhitelistCheckResult) a.a(parcelObtain2, WhitelistCheckResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void confirmPackageConflict(String str, int i10) {
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
            public void dismissFullScreenOverlay(String str) {
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
            public void dismissVoiceInput(String str) {
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
            public void fullScreenGui(String str) {
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
            public String getForegroundTaskId() {
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
            public String getForegroundTaskSessionId() {
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
            public String getLastActiveTaskSessionId() {
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
            public MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (MainDisplayTopAppHistory) a.a(parcelObtain2, MainDisplayTopAppHistory.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public AppOccupationResult isAppOccupiedV1(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AppOccupationResult) a.a(parcelObtain2, AppOccupationResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public List<TaskSnapshot> listActiveTasks() {
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
            public void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.b(parcelObtain, list, 0);
                    parcelObtain.writeStrongInterface(iAbilityQueryCallback);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void registerTaskListener(ITaskListener iTaskListener, String str) {
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
            public void resumeFullScreenOverlay(String str) {
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
            public void showFullScreenGuiV2(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.c(parcelObtain, bundle, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String submitTask(TaskConfig taskConfig) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.c(parcelObtain, taskConfig, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitToolCallEvent(ToolCallEvent toolCallEvent) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.c(parcelObtain, toolCallEvent, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitUserInput(String str, String str2, String str3) {
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
            public void toolUpdateTask(Task task) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    a.c(parcelObtain, task, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void unRegisterTaskListener(String str) {
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
            public void updateTask(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentServiceManager.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.c(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void updateTaskStatusAndControl(String str, int i10) {
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

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAgentServiceManager.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAgentServiceManager.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    String strSubmitTask = submitTask((TaskConfig) a.a(parcel, TaskConfig.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strSubmitTask);
                    return true;
                case 2:
                    toolUpdateTask((Task) a.a(parcel, Task.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    updateTaskStatusAndControl(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    updateTask(parcel.readString(), (Bundle) a.a(parcel, Bundle.CREATOR));
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
                    submitToolCallEvent((ToolCallEvent) a.a(parcel, ToolCallEvent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    queryAbilities(parcel.readString(), parcel.createTypedArrayList(AbilityQueryParamsParcelable.CREATOR), IAbilityQueryCallback.Stub.asInterface(parcel.readStrongBinder()));
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
                    a.b(parcel2, listListActiveTasks, 1);
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
                    showFullScreenGuiV2(parcel.readString(), (Bundle) a.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    WhitelistCheckResult whitelistCheckResultCheckAppWhitelistV1 = checkAppWhitelistV1(parcel.readString());
                    parcel2.writeNoException();
                    a.c(parcel2, whitelistCheckResultCheckAppWhitelistV1, 1);
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
                    a.c(parcel2, mainDisplayTopAppHistory, 1);
                    return true;
                case 21:
                    AppOccupationResult appOccupationResultIsAppOccupiedV1 = isAppOccupiedV1(parcel.readString());
                    parcel2.writeNoException();
                    a.c(parcel2, appOccupationResultIsAppOccupiedV1, 1);
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
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IAgentServiceManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public WhitelistCheckResult checkAppWhitelistV1(String str) {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getForegroundTaskId() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getForegroundTaskSessionId() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String getLastActiveTaskSessionId() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public AppOccupationResult isAppOccupiedV1(String str) {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public List<TaskSnapshot> listActiveTasks() {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public String submitTask(TaskConfig taskConfig) {
            return null;
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelFullScreenGui(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void dismissFullScreenOverlay(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void dismissVoiceInput(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void fullScreenGui(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void resumeFullScreenOverlay(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void submitToolCallEvent(ToolCallEvent toolCallEvent) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void toolUpdateTask(Task task) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void unRegisterTaskListener(String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelPackageConflict(String str, int i10) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void cancelUserInput(String str, String str2) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void confirmPackageConflict(String str, int i10) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void registerTaskListener(ITaskListener iTaskListener, String str) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void showFullScreenGuiV2(String str, Bundle bundle) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void updateTask(String str, Bundle bundle) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void updateTaskStatusAndControl(String str, int i10) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void queryAbilities(String str, List<AbilityQueryParamsParcelable> list, IAbilityQueryCallback iAbilityQueryCallback) {
        }

        @Override // com.stepos.ability.IAgentServiceManager
        public void submitUserInput(String str, String str2, String str3) {
        }
    }
}
