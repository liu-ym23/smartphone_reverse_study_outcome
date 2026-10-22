package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    static final String TAG = null;
    private NetworkStateBroadcastReceiver mBroadcastReceiver;
    private final ConnectivityManager mConnectivityManager;
    private NetworkStateCallback mNetworkCallback;

    /* JADX INFO: loaded from: classes17.dex */
    public class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkStateTracker this$0;

        public NetworkStateBroadcastReceiver(NetworkStateTracker r100) {
            this.this$0 = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (r101.getAction() != null) goto L7;
            return;
        L7:
            if (r101.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L11;
            Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
            NetworkStateTracker r102 = this.this$0;
            r102.setState(r102.getActiveNetworkState());
            return;
        }
    }

    public class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkStateTracker this$0;

        public NetworkStateCallback(NetworkStateTracker r100) {
            this.this$0 = r100;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r100) {
            Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
            NetworkStateTracker r101 = this.this$0;
            r101.setState(r101.getActiveNetworkState());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", new Object[]{r101}), new Throwable[0]);
            NetworkStateTracker r102 = this.this$0;
            r102.setState(r102.getActiveNetworkState());
        }
    }

    static {
        TAG = Logger.tagWithPrefix("NetworkStateTracker");
    }

    private static boolean isNetworkCallbackSupported() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    public NetworkState getActiveNetworkState() {
        NetworkInfo r100 = this.mConnectivityManager.getActiveNetworkInfo();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = isActiveNetworkValidated();
        boolean r104 = ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager);
        if (r100 != null) goto L11;
    L13:
        r101 = false;
    L15:
        return new NetworkState(r102, r103, r104, r101);
    L11:
        if (r100.isRoaming() == true) goto L13;
    L5:
        if (r100.isConnected() == false) goto L7;
        r102 = true;
        goto L8
    }

    public boolean isActiveNetworkValidated() {
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        return false;
    L15:
        NetworkCapabilities r100 = this.mConnectivityManager.getNetworkCapabilities(this.mConnectivityManager.getActiveNetwork());     // Catch: SecurityException -> L12
        if (r100 == null) goto L17;
        if (r100.hasCapability(16) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        Logger.get().error(TAG, "Unable to validate active network", new Throwable[]{e});
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return getActiveNetworkState();
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        if (isNetworkCallbackSupported() == true) goto L12;
        Logger.get().debug(TAG, "Registering broadcast receiver", new Throwable[0]);
        INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_NetworkStateTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mAppContext, this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return;
    L12:
        Logger.get().debug(TAG, "Registering network callback", new Throwable[0]);     // Catch: SecurityException -> L6 Throwable -> L8
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);     // Catch: SecurityException -> L6 Throwable -> L8
        return;
    L8:
        e = move-exception;
        Logger.get().error(TAG, "Received exception while registering network callback", new Throwable[]{e});
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        if (isNetworkCallbackSupported() == true) goto L12;
        Logger.get().debug(TAG, "Unregistering broadcast receiver", new Throwable[0]);
        INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_NetworkStateTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mAppContext, this.mBroadcastReceiver);
        return;
    L12:
        Logger.get().debug(TAG, "Unregistering network callback", new Throwable[0]);     // Catch: SecurityException -> L6 Throwable -> L8
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: SecurityException -> L6 Throwable -> L8
        return;
    L8:
        e = move-exception;
        Logger.get().error(TAG, "Received exception while unregistering network callback", new Throwable[]{e});
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ NetworkState getInitialState() {
        return getInitialState();
    }

    public NetworkStateTracker(Context r100, TaskExecutor r101) {
        super(r100, r101);
        this.mConnectivityManager = (ConnectivityManager) this.mAppContext.getSystemService("connectivity");
        if (isNetworkCallbackSupported() == false) goto L5;
        this.mNetworkCallback = new NetworkStateCallback(this);
        return;
    L5:
        this.mBroadcastReceiver = new NetworkStateBroadcastReceiver(this);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_NetworkStateTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_NetworkStateTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
