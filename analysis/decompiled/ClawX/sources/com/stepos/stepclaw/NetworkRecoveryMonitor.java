package com.stepos.stepclaw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001c\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/NetworkRecoveryMonitor;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lb5/a0;", "onNetworkRecovered", "<init>", "(Landroid/content/Context;Lp5/a;)V", "start", "()V", "stop", "Lp5/a;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "Landroid/net/ConnectivityManager;", "cm", "Landroid/net/ConnectivityManager;", "Landroid/net/ConnectivityManager$NetworkCallback;", "callback", "Landroid/net/ConnectivityManager$NetworkCallback;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkRecoveryMonitor {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "NetworkRecoveryMonitor";
    private final Context appContext;
    private ConnectivityManager.NetworkCallback callback;
    private final ConnectivityManager cm;
    private final p5.a onNetworkRecovered;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/stepclaw/NetworkRecoveryMonitor$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public NetworkRecoveryMonitor(Context context, p5.a onNetworkRecovered) {
        p.e(context, "context");
        p.e(onNetworkRecovered, "onNetworkRecovered");
        this.onNetworkRecovered = onNetworkRecovered;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        Object systemService = applicationContext.getSystemService("connectivity");
        this.cm = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
    }

    public final void start() {
        if (this.cm == null) {
            Log.w(TAG, "ConnectivityManager unavailable; network recovery monitor disabled");
            return;
        }
        if (this.callback != null) {
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addCapability(16).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.stepclaw.NetworkRecoveryMonitor$start$cb$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                p.e(network, "network");
                Log.i("NetworkRecoveryMonitor", "network recovered (validated internet available) — kicking reconnect + OTA self-heal");
                try {
                    this.this$0.onNetworkRecovered.invoke();
                } catch (Throwable th) {
                    Log.w("NetworkRecoveryMonitor", "onNetworkRecovered callback failed: " + th.getMessage(), th);
                }
            }
        };
        this.callback = networkCallback;
        try {
            this.cm.registerNetworkCallback(networkRequestBuild, networkCallback);
        } catch (Throwable th) {
            Log.w(TAG, "registerNetworkCallback failed: " + th.getMessage(), th);
            this.callback = null;
        }
    }

    public final void stop() {
        ConnectivityManager.NetworkCallback networkCallback = this.callback;
        if (networkCallback == null) {
            return;
        }
        this.callback = null;
        try {
            ConnectivityManager connectivityManager = this.cm;
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
        } catch (Throwable th) {
            Log.w(TAG, "unregisterNetworkCallback failed: " + th.getMessage(), th);
        }
    }
}
