package com.stepos.alphame;

import B0.g;
import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.engine.AppClient;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.engine.ExecuteItem;
import com.stepos.alphame.engine.ReceiverList;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.reflect.Reflector;
import com.stepos.alphame.reflect.UserHandle;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.ServerDumper;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.AlphaMeNative;
import com.stepos.common.alphame.Args;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class AlphaMeServer extends AlphaMeNative {
    private static final String DUMP_PERMISSION = "android.permission.DUMP";
    private static final int PER_USER_RANGE = 100000;
    private static final int PRI_TRANSACT_GET_MY_USER_ID = 101;
    private static final int PRI_TRANSACT_GET_USER_BINDER = 102;
    private static final int PRI_TRANSACT_LINK_USER_BINDER = 103;
    private static final int PRI_TRANSACT_NOTIFY_USER_BACKGROUND = 104;
    private static final int SYSTEM_UID = 1000;
    private static final String TAG = "AlphaMe";
    private static AlphaMeServer sAlphaMeServer;
    private int mMyUserId;

    @SuppressLint({"UseSparseArrays"})
    private final HashMap<Integer, IBinder> mUserBinder;
    private boolean mUserForeground;

    @SuppressLint({"UseSparseArrays"})
    private final ConcurrentHashMap<IBinder, AppClient> mAppClientMap = new ConcurrentHashMap<>();

    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Boolean> mPermissionCache = new HashMap<>();

    @SuppressLint({"UseSparseArrays"})
    private HashMap<String, String> mAppNameCache = new HashMap<>();

    public final class AppDeathRecipient implements IBinder.DeathRecipient {
        IBinder mClient;

        public AppDeathRecipient(IBinder iBinder) {
            this.mClient = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            AppClient appClientRemoveClientLock = AlphaMeServer.this.removeClientLock(this.mClient);
            if (appClientRemoveClientLock != null) {
                ActionManager.getInstance().broadcast(LocalConsts.ACTION_APP_DIED, Integer.valueOf(appClientRemoveClientLock.pid));
            }
        }
    }

    private AlphaMeServer() {
        HashMap<Integer, IBinder> map = new HashMap<>();
        this.mUserBinder = map;
        int iMyUserId = UserHandle.myUserId();
        this.mMyUserId = iMyUserId;
        map.put(Integer.valueOf(iMyUserId), this);
    }

    private void addClientLock(IBinder iBinder, int i4) throws RemoteException {
        if (iBinder == null) {
            return;
        }
        AppClient appClient = this.mAppClientMap.get(iBinder);
        if (appClient != null && appClient.client.asBinder() == iBinder) {
            Log.e(TAG, "client is already added");
            return;
        }
        AppClient appClient2 = new AppClient(iBinder, i4);
        appClient2.linkToDeath(new AppDeathRecipient(iBinder));
        this.mAppClientMap.put(iBinder, appClient2);
    }

    private boolean checkPermission(int i4, int i5, String str, boolean z4) {
        boolean zBooleanValue;
        int userId = UserHandle.getUserId(i4);
        int i6 = this.mMyUserId;
        int i7 = 0;
        if (userId != i6 && i4 != 2000) {
            Log.w(TAG, "checkPermission user denied. callingUserId=" + userId + ", myUserId=" + i6);
            return false;
        }
        ApplicationImpl application = ApplicationImpl.getApplication();
        if (z4 || UserHandle.isCore(i4)) {
            zBooleanValue = true;
        } else {
            Boolean boolValueOf = this.mPermissionCache.get(Integer.valueOf(i4));
            if (boolValueOf == null) {
                boolean z5 = AppUtils.hasSameSignature(application.getPackageManager(), i4) || application.checkPermission("stepos.alphame.USER_BEHAVIOR", i5, i4) == 0;
                boolValueOf = Boolean.valueOf(z5);
                this.mPermissionCache.put(Integer.valueOf(i4), Boolean.valueOf(z5));
            }
            zBooleanValue = boolValueOf.booleanValue();
        }
        if (Utils.isCollectAuthority()) {
            if (z4) {
                i7 = 2;
            } else if (zBooleanValue) {
                i7 = 1;
            }
            saveLog(Binder.getCallingUid(), i5, str, i7);
        }
        return zBooleanValue;
    }

    private void enforcePrivateTransactCaller(int i4) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == Process.myUid() || callingUid % 100000 == Process.myUid() % 100000) {
            return;
        }
        StringBuilder sb = new StringBuilder("private transact ");
        sb.append(i4 - 1);
        sb.append(" denied, uid=");
        sb.append(callingUid);
        sb.append(", pid=");
        sb.append(Binder.getCallingPid());
        String string = sb.toString();
        Log.e(TAG, string);
        throw new SecurityException(string);
    }

    private String getAppName(int i4, int i5) {
        String str = i4 + "," + i5;
        if (!this.mAppNameCache.containsKey(str)) {
            this.mAppNameCache.put(str, AppUtils.getAppName(ApplicationImpl.getApplication(), i5));
        }
        return this.mAppNameCache.get(str);
    }

    public static AlphaMeServer getInstance() {
        if (sAlphaMeServer == null) {
            sAlphaMeServer = new AlphaMeServer();
        }
        return sAlphaMeServer;
    }

    public static IBinder getUserBinder(IBinder iBinder, int i4) {
        if (iBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInt(i4);
            iBinder.transact(102, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readStrongBinder();
        } catch (Exception e4) {
            AlphaMeLogger.eLog("getUserBinder err: " + e4);
            return null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public static void linkUserBinder(IBinder iBinder, int i4, IBinder iBinder2) {
        if (iBinder == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInt(i4);
                parcelObtain.writeStrongBinder(iBinder2);
                iBinder.transact(103, parcelObtain, parcelObtain2, 0);
            } catch (Exception e4) {
                AlphaMeLogger.eLog("linkUserBinder err: " + e4);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public static void notifyUserBackground(IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                iBinder.transact(104, parcelObtain, parcelObtain2, 0);
            } catch (Exception e4) {
                AlphaMeLogger.eLog("onUserBackground err: " + e4);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    private void onUserBackground() {
        AlphaMeLogger.iLog("AlphaMeServer onUserBackground: " + this.mMyUserId);
    }

    private void onUserForeground() {
        AlphaMeLogger.iLog("AlphaMeServer onUserForeground: " + this.mMyUserId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppClient removeClientLock(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        AppClient appClientRemove = this.mAppClientMap.remove(iBinder);
        if (appClientRemove != null) {
            synchronized (appClientRemove.receivers) {
                appClientRemove.receivers.clear();
            }
            appClientRemove.active = false;
            appClientRemove.unlinkDeathRecipient();
        }
        return appClientRemove;
    }

    private void saveLog(int i4, int i5, String str, int i6) {
        String appName = getAppName(i4, i5);
        StringBuilder sbU = g.u("saveLog uid = ", i4, ", pid = ", i5, " pkg = ");
        AbstractC0351g.C(sbU, appName, ", desc = ", str, ", state = ");
        sbU.append(i6);
        AlphaMeLogger.debugLog(sbU.toString());
        AwarenessDataSource.getInstance().newPermissionRecord(appName + "(uid=" + i4 + ",pid=" + i5 + ")", i6, str);
    }

    public static Integer userIdOfBinder(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            iBinder.transact(101, parcelObtain, parcelObtain2, 0);
            return Integer.valueOf(parcelObtain2.readInt());
        } catch (Exception e4) {
            AlphaMeLogger.eLog("userIdOfBinder err: " + e4);
            return null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void addClient(IBinder iBinder) throws RemoteException {
        addClientLock(iBinder, Binder.getCallingPid());
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void collect(String str, Args args) {
        DataItem dataItemPop;
        try {
            DataSource dataSource = DataSourceManager.getInstance().getDataSource(str);
            if (dataSource == null) {
                Locale locale = Locale.US;
                Log.e(TAG, "Can't find source " + str + " from pid " + Binder.getCallingPid());
                return;
            }
            if (Args.g(dataSource.getFillArgsType(), args.f11221b)) {
                dataItemPop = dataSource.instanceDataItem(args);
            } else {
                byte[] moreFillArgsType = dataSource.getMoreFillArgsType(args.f11221b);
                if (moreFillArgsType == null) {
                    Log.e(TAG, "Can't find " + Args.j(args.f11221b));
                    return;
                }
                dataItemPop = dataSource.itemCache().pop();
                Reflector.invokeMethod(dataItemPop, args.f11220a, "fill", (Class<?>[]) Args.c(moreFillArgsType));
            }
            AlphaMeLogger.debugLog("Collect tag=" + str + " arg=" + args.toString());
            if (dataItemPop != null) {
                dataSource.process(dataItemPop);
            }
        } catch (Exception e4) {
            AbstractC0351g.B("collect item e = ", e4, TAG);
        }
    }

    public ArrayList<ReceiverList> collectReceivers(String str) {
        ArrayList<ReceiverList> arrayList = new ArrayList<>();
        for (AppClient appClient : this.mAppClientMap.values()) {
            synchronized (appClient.receivers) {
                try {
                    Iterator<ReceiverList> it = appClient.receivers.iterator();
                    while (it.hasNext()) {
                        ReceiverList next = it.next();
                        ArrayList<String> arrayList2 = next.actions;
                        if (arrayList2 != null && arrayList2.contains(str)) {
                            arrayList.add(next);
                        }
                    }
                } finally {
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Binder
    public void dump(@NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
        if (ApplicationImpl.getApplication().checkCallingOrSelfPermission(DUMP_PERMISSION) == 0 || ApplicationImpl.getApplication().checkCallingOrSelfPermission(LocalConsts.PERMISSION_DUMP) == 0) {
            ServerDumper.dump(fileDescriptor, printWriter, strArr);
            return;
        }
        printWriter.println("Permission Denial: can't dump AlphaMe Info from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void exec(IBinder iBinder, String str, Args args, int i4, int i5) throws InterruptedException {
        if ("getMyUserId".equals(str)) {
            AppClient clientLock = getClientLock(iBinder);
            if (clientLock == null || !clientLock.active) {
                return;
            }
            try {
                clientLock.client.onResult(new Args(Integer.valueOf(getMyUserId()), Integer.valueOf(i5)));
                return;
            } catch (RemoteException e4) {
                Log.e(TAG, "onResult error: " + e4);
                return;
            }
        }
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        EngineFunc func = EngineBase.getFunc(str, args);
        boolean z4 = (func == null || checkPermission(callingUid, callingPid, g.m("exec ", str), func.isPublic)) ? false : true;
        ApplicationImpl.getApplication().waitInitializedDone(callingPid);
        AppClient clientLock2 = getClientLock(iBinder);
        AlphaMeLogger.debugLog("exec " + str + " from " + callingPid);
        if (clientLock2 == null) {
            Locale locale = Locale.US;
            Log.e(TAG, callingPid + " is not added client");
            return;
        }
        if (func == null) {
            Locale locale2 = Locale.US;
            Log.e(TAG, "Can't find " + str + Args.j(args.f11221b) + " from pid " + callingPid);
            EngineBase.returnErrorResult(clientLock2, i5);
            return;
        }
        if (!z4) {
            ExecuteItem executeItem = new ExecuteItem();
            executeItem.func = func;
            executeItem.args = args;
            executeItem.receiver = i5;
            executeItem.sync = i4 != 0;
            executeItem.appClient = clientLock2;
            EngineBase.exec(executeItem);
            return;
        }
        Locale locale3 = Locale.US;
        Log.e(TAG, "Can't access " + str + Args.j(args.f11221b) + " from pid " + callingPid);
        EngineBase.returnErrorResult(clientLock2, i5);
    }

    public AppClient getClientLock(IBinder iBinder) {
        return this.mAppClientMap.get(iBinder);
    }

    public int getMyUserId() {
        return this.mMyUserId;
    }

    @Override // com.stepos.common.alphame.AlphaMeNative, android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 101) {
            enforcePrivateTransactCaller(i4);
            parcel2.writeInt(getMyUserId());
            return true;
        }
        if (i4 == 102) {
            enforcePrivateTransactCaller(i4);
            int i6 = parcel.readInt();
            synchronized (this.mUserBinder) {
                parcel2.writeStrongBinder(this.mUserBinder.get(Integer.valueOf(i6)));
            }
            return true;
        }
        if (i4 != 103) {
            if (i4 == 104) {
                enforcePrivateTransactCaller(i4);
                boolean z4 = this.mUserForeground;
                this.mUserForeground = false;
                if (z4) {
                    onUserBackground();
                }
            }
            return super.onTransact(i4, parcel, parcel2, i5);
        }
        enforcePrivateTransactCaller(i4);
        parcel.readInt();
        final int userId = UserHandle.getUserId(Binder.getCallingUid());
        IBinder strongBinder = parcel.readStrongBinder();
        synchronized (this.mUserBinder) {
            this.mUserBinder.put(Integer.valueOf(userId), strongBinder);
        }
        if (strongBinder != null) {
            strongBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.stepos.alphame.AlphaMeServer.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    synchronized (AlphaMeServer.this.mUserBinder) {
                        AlphaMeServer.this.mUserBinder.remove(Integer.valueOf(userId));
                    }
                }
            }, 0);
        }
        return true;
    }

    public void publish() {
        boolean z4 = this.mUserForeground;
        this.mUserForeground = true;
        Log.d(TAG, "addService alphame_server via AppPlatform published=" + PerfBinderHelper.publishAlphaMeService("alphame_server", getInstance()));
        if (z4) {
            return;
        }
        onUserForeground();
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void registerActionReceiver(IBinder iBinder, ArrayList<String> arrayList, int i4) {
        AppClient clientLock;
        if (!checkPermission(Binder.getCallingUid(), Binder.getCallingPid(), "registerActionReceiver ".concat(String.valueOf(arrayList)), false) || iBinder == null || i4 <= 0 || (clientLock = getClientLock(iBinder)) == null || !clientLock.active || clientLock.client.asBinder() != iBinder) {
            return;
        }
        synchronized (clientLock.receivers) {
            if (arrayList != null) {
                try {
                    if (!arrayList.isEmpty()) {
                        Iterator<ReceiverList> it = clientLock.receivers.iterator();
                        while (it.hasNext()) {
                            if (it.next().receiver == i4) {
                                return;
                            }
                        }
                        Iterator<String> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String next = it2.next();
                            if (!ActionManager.getInstance().isValid(next)) {
                                it2.remove();
                                Log.e(TAG, "Invalid action = " + next);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            clientLock.receivers.add(new ReceiverList(iBinder, arrayList, i4));
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void removeClient(IBinder iBinder) {
        removeClientLock(iBinder);
    }

    public void setClientFlag(int i4, int i5, boolean z4) {
        for (AppClient appClient : this.mAppClientMap.values()) {
            if (appClient != null && appClient.pid == i4) {
                if (z4) {
                    appClient.flag |= i5;
                    return;
                } else {
                    appClient.flag &= ~i5;
                    return;
                }
            }
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void unregisterActionReceiver(IBinder iBinder, int i4) {
        AppClient clientLock;
        ReceiverList receiverList;
        int i5 = 0;
        if (!checkPermission(Binder.getCallingUid(), Binder.getCallingPid(), "unregisterActionReceiver", false) || iBinder == null || i4 <= 0 || (clientLock = getClientLock(iBinder)) == null || !clientLock.active || clientLock.client.asBinder() != iBinder) {
            return;
        }
        synchronized (clientLock.receivers) {
            while (true) {
                try {
                    if (i5 >= clientLock.receivers.size()) {
                        receiverList = null;
                        break;
                    } else {
                        if (clientLock.receivers.get(i5).receiver == i4) {
                            receiverList = clientLock.receivers.get(i5);
                            break;
                        }
                        i5++;
                    }
                } finally {
                }
            }
            if (receiverList != null) {
                clientLock.receivers.remove(i5);
            }
        }
    }
}
