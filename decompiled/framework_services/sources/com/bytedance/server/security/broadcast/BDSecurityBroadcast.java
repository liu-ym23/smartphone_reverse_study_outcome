package com.bytedance.server.security.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import com.android.server.pm.Settings;
import com.bytedance.server.security.IBDSecurityPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BDSecurityBroadcast implements IBDSecurityPlugin {
    public static final IBDSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "BDSecurityBroadcast";
    private static final Map<String, List<ISecurityBroadcastPlugin>> sPlugins = null;
    private final Context mContext;

    private static class SecurityBroadcastReceiver extends BroadcastReceiver {
        /* synthetic */ SecurityBroadcastReceiver(BDSecurityBroadcastIA r1) {
            this();
        }

        private SecurityBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i(BDSecurityBroadcast.TAG, "intent: " + intent.getAction());
            List<ISecurityBroadcastPlugin> plugins = (List) BDSecurityBroadcast.m10561$$Nest$sfgetsPlugins().getOrDefault(intent.getAction(), new ArrayList());
            Iterator<ISecurityBroadcastPlugin> r1 = plugins.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ISecurityBroadcastPlugin plugin = r1.next();
            plugin.onReceive(context, intent);
            goto L4
        }
    }

    public static /* synthetic */ List $r8$lambda$6rdV7tD9an7jdkp7gO2oOymTCxI(String r0) {
        return lambda$registerPlugin$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPlugins, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m10561$$Nest$sfgetsPlugins() {
        return sPlugins;
    }

    static {
        CREATOR = new AnonymousClass1();
        sPlugins = new HashMap();
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public void onStart() {
        registerBroadcast();
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public void onStop() {
    }

    public BDSecurityBroadcast(Context context) {
        this.mContext = context;
    }

    public static boolean registerPlugin(String pluginName, List<String> broadcastActions, ISecurityBroadcastPlugin plugin) {
        Iterator<String> r1 = broadcastActions.iterator();     // Catch: Throwable -> L8
    L5:
        if (r1.hasNext() == false) goto L10;
        String action = r1.next();     // Catch: Throwable -> L8
        sPlugins.computeIfAbsent(action, new BDSecurityBroadcast$$ExternalSyntheticLambda0()).add(plugin);     // Catch: Throwable -> L8
        goto L5
    L10:
        Log.i(TAG, "register plugin " + pluginName);
        Log.i(TAG, "splugin: " + sPlugins);
        return true;
    L8:
        e = move-exception;
        Log.e(TAG, pluginName + " registerPlugin failed, " + e.getMessage());
        return false;
    }

    private static /* synthetic */ List lambda$registerPlugin$0(String k) {
        return new ArrayList();
    }

    private void registerBroadcast() {
        IntentFilter packageFilter = new IntentFilter();     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");     // Catch: Exception -> L4
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);     // Catch: Exception -> L4
        IntentFilter systemFilter = new IntentFilter();     // Catch: Exception -> L4
        systemFilter.addAction("android.intent.action.ACTION_SHUTDOWN");     // Catch: Exception -> L4
        SecurityBroadcastReceiver receiver = new SecurityBroadcastReceiver(null);     // Catch: Exception -> L4
        this.mContext.registerReceiver(receiver, packageFilter);     // Catch: Exception -> L4
        this.mContext.registerReceiver(receiver, systemFilter);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "registerBroadcast occur exception, " + e.getMessage());
    }
}
