package com.bytedance.server.security;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.server.SystemService;
import com.bytedance.security.IBDSecurityService;
import com.bytedance.server.security.behaviorrecord.BDAppBehaviorRecordPlugin;
import com.bytedance.server.security.broadcast.BDSecurityBroadcast;
import com.bytedance.server.security.utils.GlobalContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BDSecurityServiceProxy {
    private static final int BEHAVIOR_RECORD_PLUGIN_CODE = 3;
    private static final int BROADCAST_PLUGIN_CODE = 1;
    private static final int KEY_MANAGER_PLUGIN_CODE = 2;
    private static final Object LOCK = null;
    private static final int SECURITY_GUARD_PLUGIN_CODE = 4;
    private static final String TAG = "BDSecurityServiceProxy";
    private static volatile BDSecurityServiceProxy sInstance;
    private static Map<Integer, PluginInfo> sPluginMap;
    private final Context mContext;

    public class BDSecurityService extends IBDSecurityService.Stub {
        final /* synthetic */ BDSecurityServiceProxy this$0;

        public BDSecurityService(BDSecurityServiceProxy this$0) {
            this.this$0 = this$0;
        }

        public IBinder querySecurityPlugin(int pluginCode) throws RemoteException {
            Map r0 = BDSecurityServiceProxy.m10543$$Nest$sfgetsPluginMap();
            monitor-enter(r0);
            PluginInfo pluginInfo = (PluginInfo) BDSecurityServiceProxy.m10543$$Nest$sfgetsPluginMap().getOrDefault(Integer.valueOf(pluginCode), null);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            if (pluginInfo == null) goto L15;
            IBDSecurityPlugin plugin = pluginInfo.plugin;
            String permission = pluginInfo.creator.getPermission();
            if (TextUtils.isEmpty(permission) == true) goto L11;
            BDSecurityServiceProxy.m10542$$Nest$fgetmContext(this.this$0).enforceCallingPermission(permission, "need request " + permission);
        L11:
            if (BDSecurityServiceProxy.m10542$$Nest$fgetmContext(this.this$0).getPackageManager().checkSignatures(1000, Binder.getCallingUid()) != 0) goto L15;
            if (plugin == null) goto L15;
            return plugin.asBinder();
        L15:
            Log.e(BDSecurityServiceProxy.TAG, "plugin code miss plugin, or lack of platform sign.");
            return null;
        L17:
            th = move-exception;
            throw th;
        }
    }

    private static class PluginInfo {
        private final Set<Integer> VALID_START_FLAGS;
        private final Set<Integer> VALID_START_TIME;
        IBDSecurityPlugin.Creator creator;
        IBDSecurityPlugin plugin;
        int pluginCode;
        int startFlag;
        int startSequence;
        int startTime;

        static class PluginComparator implements Comparator<PluginInfo> {
            PluginComparator() {
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(PluginInfo r1, PluginInfo r2) {
                return compare2(r1, r2);
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(PluginInfo o1, PluginInfo o2) {
                return o1.startSequence - o2.startSequence;
            }
        }

        PluginInfo(int startFlag, int startSequence, int startTime, IBDSecurityPlugin.Creator creator) {
            int r1 = 0;
            this.VALID_START_FLAGS = new HashSet(Arrays.asList(new Integer[]{0, 1}));
            int r2 = 500;
            this.VALID_START_TIME = new HashSet(Arrays.asList(new Integer[]{100, 200, Integer.valueOf(SystemService.PHASE_LOCK_SETTINGS_READY), 500, Integer.valueOf(SystemService.PHASE_DEVICE_SPECIFIC_SERVICES_READY), 550, 600, 1000}));
            if (this.VALID_START_FLAGS.contains(Integer.valueOf(startFlag)) == false) goto L5;
            r1 = startFlag;
        L5:
            this.startFlag = r1;
            this.startSequence = startSequence;
            if (this.VALID_START_TIME.contains(Integer.valueOf(startTime)) == false) goto L8;
            r2 = startTime;
        L8:
            this.startTime = r2;
            this.creator = creator;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m10542$$Nest$fgetmContext(BDSecurityServiceProxy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPluginMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m10543$$Nest$sfgetsPluginMap() {
        return sPluginMap;
    }

    static {
        LOCK = new Object();
        sPluginMap = new HashMap();
    }

    private BDSecurityServiceProxy(Context context) {
        this.mContext = context;
        GlobalContext.setContext(context);
    }

    public static BDSecurityServiceProxy getInstance(Context context) {
        if (sInstance != null) goto L16;
        Object r0 = LOCK;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new BDSecurityServiceProxy(context);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void onStart() {
        ServiceManager.addService("BDSecurityService", new BDSecurityService(this));
        registerPlugin();
        Log.i(TAG, "register security service.");
    }

    public void onBootPhase(int phase) {
        Log.i(TAG, "security service onBootPhase: " + phase);
        startServicePlugin(phase);
    }

    private void registerPlugin() {
        Map<Integer, PluginInfo> r1 = sPluginMap;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L6:
        if (BDSecurityBroadcast.CREATOR.isEnable() == false) goto L11;
        sPluginMap.put(1, new PluginInfo(0, 1, 200, BDSecurityBroadcast.CREATOR));     // Catch: Throwable -> L8
    L11:
        if (BDAppBehaviorRecordPlugin.CREATOR.isEnable() == false) goto L13;
        sPluginMap.put(3, new PluginInfo(0, 1, 500, BDAppBehaviorRecordPlugin.CREATOR));     // Catch: Throwable -> L8
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L17:
        e = move-exception;
        Log.e(TAG, "registerPlugin failed, id: -1");
        Log.e(TAG, "registerPlugin occur exception.", e);
    }

    private void startServicePlugin(int phase) {
        List<PluginInfo> pluginInfoList = new ArrayList();
        Map<Integer, PluginInfo> r1 = sPluginMap;
        monitor-enter(r1);
        Iterator<Integer> r2 = sPluginMap.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r2.hasNext() == false) goto L17;
        int num = r2.next().intValue();     // Catch: Throwable -> L14
        PluginInfo pluginInfo = sPluginMap.get(Integer.valueOf(num));     // Catch: Throwable -> L14
        if (pluginInfo == null) goto L6;
        if (pluginInfo.startFlag != 0) goto L6;
        if (pluginInfo.startTime != phase) goto L6;
        pluginInfo.pluginCode = num;     // Catch: Throwable -> L14
        pluginInfoList.add(pluginInfo);     // Catch: Throwable -> L14
        goto L6
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L14
        pluginInfoList.sort(new PluginInfo.PluginComparator());
        Iterator<PluginInfo> r3 = pluginInfoList.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        PluginInfo pluginInfo2 = r3.next();
        IBDSecurityPlugin plugin = pluginInfo2.creator.createPlugin(this.mContext);
        plugin.onStart();
        pluginInfo2.plugin = plugin;
        goto L20
    L22:
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
