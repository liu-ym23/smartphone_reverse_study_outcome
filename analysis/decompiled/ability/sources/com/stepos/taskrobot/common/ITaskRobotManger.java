package com.stepos.taskrobot.common;

import D7.N;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.bean.AppOccupationResult;
import com.stepos.taskrobot.common.bean.MainDisplayTopAppHistory;
import com.stepos.taskrobot.common.bean.TaskSnapshot;
import com.stepos.taskrobot.common.bean.WhitelistCheckResult;
import java.util.List;

/* loaded from: classes3.dex */
public interface ITaskRobotManger extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.taskrobot.common.ITaskRobotManger";

    public static class Default implements ITaskRobotManger {
        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void addModel(String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void cancelPackageConflict(String str, int i) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public boolean cancelTaskById(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void cancelUserInput(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void confirmPackageConflict(String str, int i) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public boolean deleteCustomModelById(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void dismissFullScreenOverlay(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void dismissVoiceInput(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public String getCurrentModelId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public String getForegroundTaskId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public String getForegroundTaskSessionId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public String getLastActiveTaskSessionId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public List<String> getModelOptions() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void hideFullScreenActivity(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public AppOccupationResult isAppOccupiedV1(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public boolean isCustomModel(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public List<TaskSnapshot> listActiveTasks() throws RemoteException {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void pauseTask(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void recoverFromTakeover(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void registerProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public int removeAllCustomModels() throws RemoteException {
            return 0;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void resumeFullScreenOverlay(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void resumeTask(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void setChatSessionId(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void setOutputSurface(String str, Surface surface) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void showFullScreenActivity(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void showFullScreenActivityV2(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public int startCozeTask(int i, String str, String str2, Surface surface, int i6, int i10, int i11, String str3, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void startTask(String str, String str2, String str3, Surface surface, int i, int i6, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void startTaskV1(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void startTaskV1WithSession(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, String str4, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void stopTask(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void submitUserInput(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void switchToMainDisplay(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void switchToVirtualDisplay(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void takeoverTask(String str) throws RemoteException {
        }

        @Override // com.stepos.taskrobot.common.ITaskRobotManger
        public void unregisterProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskRobotManger {
        static final int TRANSACTION_addModel = 12;
        static final int TRANSACTION_cancelPackageConflict = 37;
        static final int TRANSACTION_cancelTaskById = 16;
        static final int TRANSACTION_cancelUserInput = 28;
        static final int TRANSACTION_checkAppWhitelistV1 = 30;
        static final int TRANSACTION_confirmPackageConflict = 36;
        static final int TRANSACTION_deleteCustomModelById = 14;
        static final int TRANSACTION_dismissFullScreenOverlay = 38;
        static final int TRANSACTION_dismissVoiceInput = 26;
        static final int TRANSACTION_getCurrentModelId = 11;
        static final int TRANSACTION_getForegroundTaskId = 24;
        static final int TRANSACTION_getForegroundTaskSessionId = 32;
        static final int TRANSACTION_getLastActiveTaskSessionId = 33;
        static final int TRANSACTION_getMainDisplayTopAppHistory = 34;
        static final int TRANSACTION_getModelOptions = 10;
        static final int TRANSACTION_hideFullScreenActivity = 23;
        static final int TRANSACTION_isAppOccupiedV1 = 35;
        static final int TRANSACTION_isCustomModel = 15;
        static final int TRANSACTION_listActiveTasks = 25;
        static final int TRANSACTION_pauseTask = 5;
        static final int TRANSACTION_recoverFromTakeover = 17;
        static final int TRANSACTION_registerProgressCallback = 8;
        static final int TRANSACTION_removeAllCustomModels = 13;
        static final int TRANSACTION_resumeFullScreenOverlay = 39;
        static final int TRANSACTION_resumeTask = 6;
        static final int TRANSACTION_setChatSessionId = 21;
        static final int TRANSACTION_setOutputSurface = 20;
        static final int TRANSACTION_showFullScreenActivity = 22;
        static final int TRANSACTION_showFullScreenActivityV2 = 29;
        static final int TRANSACTION_startCozeTask = 1;
        static final int TRANSACTION_startTask = 2;
        static final int TRANSACTION_startTaskV1 = 3;
        static final int TRANSACTION_startTaskV1WithSession = 31;
        static final int TRANSACTION_stopTask = 4;
        static final int TRANSACTION_submitUserInput = 27;
        static final int TRANSACTION_switchToMainDisplay = 18;
        static final int TRANSACTION_switchToVirtualDisplay = 19;
        static final int TRANSACTION_takeoverTask = 7;
        static final int TRANSACTION_unregisterProgressCallback = 9;

        public static class Proxy implements ITaskRobotManger {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void addModel(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void cancelPackageConflict(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public boolean cancelTaskById(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void cancelUserInput(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (WhitelistCheckResult) N.a(parcelObtain2, WhitelistCheckResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void confirmPackageConflict(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public boolean deleteCustomModelById(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void dismissFullScreenOverlay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void dismissVoiceInput(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public String getCurrentModelId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public String getForegroundTaskId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public String getForegroundTaskSessionId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITaskRobotManger.DESCRIPTOR;
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public String getLastActiveTaskSessionId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (MainDisplayTopAppHistory) N.a(parcelObtain2, MainDisplayTopAppHistory.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public List<String> getModelOptions() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void hideFullScreenActivity(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public AppOccupationResult isAppOccupiedV1(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AppOccupationResult) N.a(parcelObtain2, AppOccupationResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public boolean isCustomModel(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public List<TaskSnapshot> listActiveTasks() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(TaskSnapshot.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void pauseTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void recoverFromTakeover(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void registerProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public int removeAllCustomModels() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void resumeFullScreenOverlay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void resumeTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void setChatSessionId(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void setOutputSurface(String str, Surface surface) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    N.S(parcelObtain, surface, 0);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void showFullScreenActivity(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void showFullScreenActivityV2(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    N.S(parcelObtain, bundle, 0);
                    this.mRemote.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public int startCozeTask(int i, String str, String str2, Surface surface, int i6, int i10, int i11, String str3, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    N.S(parcelObtain, surface, 0);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void startTask(String str, String str2, String str3, Surface surface, int i, int i6, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    N.S(parcelObtain, surface, 0);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void startTaskV1(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str3);
                    N.S(parcelObtain, surface, 0);
                    parcelObtain.writeInt(i6);
                    N.S(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void startTaskV1WithSession(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, String str4, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str3);
                    N.S(parcelObtain, surface, 0);
                    parcelObtain.writeInt(i6);
                    N.S(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void stopTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void submitUserInput(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void switchToMainDisplay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void switchToVirtualDisplay(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void takeoverTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.taskrobot.common.ITaskRobotManger
            public void unregisterProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskRobotManger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iTaskProgressCallback);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskRobotManger.DESCRIPTOR);
        }

        public static ITaskRobotManger asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskRobotManger.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskRobotManger)) ? new Proxy(iBinder) : (ITaskRobotManger) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskRobotManger.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskRobotManger.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int iStartCozeTask = startCozeTask(parcel.readInt(), parcel.readString(), parcel.readString(), (Surface) N.a(parcel, Surface.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartCozeTask);
                    return true;
                case 2:
                    startTask(parcel.readString(), parcel.readString(), parcel.readString(), (Surface) N.a(parcel, Surface.CREATOR), parcel.readInt(), parcel.readInt(), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    startTaskV1(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), (Surface) N.a(parcel, Surface.CREATOR), parcel.readInt(), (Bundle) N.a(parcel, Bundle.CREATOR), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    stopTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    pauseTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    resumeTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    takeoverTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    registerProgressCallback(parcel.readString(), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    unregisterProgressCallback(parcel.readString(), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    List<String> modelOptions = getModelOptions();
                    parcel2.writeNoException();
                    parcel2.writeStringList(modelOptions);
                    return true;
                case 11:
                    String currentModelId = getCurrentModelId();
                    parcel2.writeNoException();
                    parcel2.writeString(currentModelId);
                    return true;
                case 12:
                    addModel(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    int iRemoveAllCustomModels = removeAllCustomModels();
                    parcel2.writeNoException();
                    parcel2.writeInt(iRemoveAllCustomModels);
                    return true;
                case 14:
                    boolean zDeleteCustomModelById = deleteCustomModelById(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDeleteCustomModelById ? 1 : 0);
                    return true;
                case 15:
                    boolean zIsCustomModel = isCustomModel(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsCustomModel ? 1 : 0);
                    return true;
                case 16:
                    boolean zCancelTaskById = cancelTaskById(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelTaskById ? 1 : 0);
                    return true;
                case 17:
                    recoverFromTakeover(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    switchToMainDisplay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    switchToVirtualDisplay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    setOutputSurface(parcel.readString(), (Surface) N.a(parcel, Surface.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    setChatSessionId(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    showFullScreenActivity(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    hideFullScreenActivity(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    String foregroundTaskId = getForegroundTaskId();
                    parcel2.writeNoException();
                    parcel2.writeString(foregroundTaskId);
                    return true;
                case 25:
                    List<TaskSnapshot> listListActiveTasks = listActiveTasks();
                    parcel2.writeNoException();
                    if (listListActiveTasks == null) {
                        parcel2.writeInt(-1);
                    } else {
                        int size = listListActiveTasks.size();
                        parcel2.writeInt(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            N.S(parcel2, listListActiveTasks.get(i10), 1);
                        }
                    }
                    return true;
                case 26:
                    dismissVoiceInput(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    submitUserInput(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    cancelUserInput(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    showFullScreenActivityV2(parcel.readString(), (Bundle) N.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    WhitelistCheckResult whitelistCheckResultCheckAppWhitelistV1 = checkAppWhitelistV1(parcel.readString());
                    parcel2.writeNoException();
                    N.S(parcel2, whitelistCheckResultCheckAppWhitelistV1, 1);
                    return true;
                case 31:
                    startTaskV1WithSession(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), (Surface) N.a(parcel, Surface.CREATOR), parcel.readInt(), (Bundle) N.a(parcel, Bundle.CREATOR), parcel.readString(), ITaskProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    String foregroundTaskSessionId = getForegroundTaskSessionId();
                    parcel2.writeNoException();
                    parcel2.writeString(foregroundTaskSessionId);
                    return true;
                case 33:
                    String lastActiveTaskSessionId = getLastActiveTaskSessionId();
                    parcel2.writeNoException();
                    parcel2.writeString(lastActiveTaskSessionId);
                    return true;
                case 34:
                    MainDisplayTopAppHistory mainDisplayTopAppHistory = getMainDisplayTopAppHistory();
                    parcel2.writeNoException();
                    N.S(parcel2, mainDisplayTopAppHistory, 1);
                    return true;
                case 35:
                    AppOccupationResult appOccupationResultIsAppOccupiedV1 = isAppOccupiedV1(parcel.readString());
                    parcel2.writeNoException();
                    N.S(parcel2, appOccupationResultIsAppOccupiedV1, 1);
                    return true;
                case 36:
                    confirmPackageConflict(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    cancelPackageConflict(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    dismissFullScreenOverlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    resumeFullScreenOverlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    void addModel(String str) throws RemoteException;

    void cancelPackageConflict(String str, int i) throws RemoteException;

    boolean cancelTaskById(String str, String str2) throws RemoteException;

    void cancelUserInput(String str, String str2) throws RemoteException;

    WhitelistCheckResult checkAppWhitelistV1(String str) throws RemoteException;

    void confirmPackageConflict(String str, int i) throws RemoteException;

    boolean deleteCustomModelById(String str) throws RemoteException;

    void dismissFullScreenOverlay(String str) throws RemoteException;

    void dismissVoiceInput(String str) throws RemoteException;

    String getCurrentModelId() throws RemoteException;

    String getForegroundTaskId() throws RemoteException;

    String getForegroundTaskSessionId() throws RemoteException;

    String getLastActiveTaskSessionId() throws RemoteException;

    MainDisplayTopAppHistory getMainDisplayTopAppHistory() throws RemoteException;

    List<String> getModelOptions() throws RemoteException;

    void hideFullScreenActivity(String str) throws RemoteException;

    AppOccupationResult isAppOccupiedV1(String str) throws RemoteException;

    boolean isCustomModel(String str) throws RemoteException;

    List<TaskSnapshot> listActiveTasks() throws RemoteException;

    void pauseTask(String str) throws RemoteException;

    void recoverFromTakeover(String str) throws RemoteException;

    void registerProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;

    int removeAllCustomModels() throws RemoteException;

    void resumeFullScreenOverlay(String str) throws RemoteException;

    void resumeTask(String str) throws RemoteException;

    void setChatSessionId(String str, String str2) throws RemoteException;

    void setOutputSurface(String str, Surface surface) throws RemoteException;

    void showFullScreenActivity(String str) throws RemoteException;

    void showFullScreenActivityV2(String str, Bundle bundle) throws RemoteException;

    int startCozeTask(int i, String str, String str2, Surface surface, int i6, int i10, int i11, String str3, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;

    void startTask(String str, String str2, String str3, Surface surface, int i, int i6, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;

    void startTaskV1(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;

    void startTaskV1WithSession(String str, String str2, int i, String str3, Surface surface, int i6, Bundle bundle, String str4, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;

    void stopTask(String str) throws RemoteException;

    void submitUserInput(String str, String str2, String str3) throws RemoteException;

    void switchToMainDisplay(String str) throws RemoteException;

    void switchToVirtualDisplay(String str) throws RemoteException;

    void takeoverTask(String str) throws RemoteException;

    void unregisterProgressCallback(String str, ITaskProgressCallback iTaskProgressCallback) throws RemoteException;
}
