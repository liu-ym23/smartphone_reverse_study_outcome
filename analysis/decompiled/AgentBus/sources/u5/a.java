package u5;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import com.stepos.agentbus.platform.AgentBusApp;
import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;
import ia.d0;

/* loaded from: classes.dex */
public final class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10105a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10106b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f10105a = i2;
        this.f10106b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.f10105a) {
            case 0:
                q7.k.e(network, "network");
                StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk = StepOSCloudSecureDataSdk.INSTANCE;
                Log.i("AgentBusApp", "network onAvailable: " + network + ", sdkReady=" + stepOSCloudSecureDataSdk.hasActiveSession());
                if (!stepOSCloudSecureDataSdk.hasActiveSession()) {
                    Log.i("AgentBusApp", "SecureData SDK not ready — kick re-init");
                    d0.s(((AgentBusApp) this.f10106b).f2680f, null, null, new b.j(2, null, 3), 3);
                    break;
                }
                break;
            default:
                q7.k.e(network, "network");
                Log.i("NetworkRecoveryMonitor", "network recovered (validated internet available) — kicking reconnect");
                try {
                    ((v4.a) ((h) this.f10106b).f10129a).c();
                    break;
                } catch (Throwable th) {
                    Log.w("NetworkRecoveryMonitor", "onNetworkRecovered callback failed: " + th.getMessage(), th);
                }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.f10105a) {
            case 0:
                q7.k.e(network, "network");
                q7.k.e(networkCapabilities, "caps");
                if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16) && !StepOSCloudSecureDataSdk.INSTANCE.hasActiveSession()) {
                    Log.i("AgentBusApp", "network capabilities VALIDATED — kick re-init");
                    d0.s(((AgentBusApp) this.f10106b).f2680f, null, null, new b.j(2, null, 4), 3);
                    break;
                }
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }
}
