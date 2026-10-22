package android.net;

import android.net.networkstack.aidl.NetworkMonitorParameters;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NetworkMonitorManager {
    private final INetworkMonitor mNetworkMonitor;
    private final String mTag;

    public NetworkMonitorManager(INetworkMonitor networkMonitorManager, String tag) {
        this.mNetworkMonitor = networkMonitorManager;
        this.mTag = tag;
    }

    public NetworkMonitorManager(INetworkMonitor networkMonitorManager) {
        this(networkMonitorManager, NetworkMonitorManager.class.getSimpleName());
    }

    private void log(String s, Throwable e) {
        Log.e(this.mTag, s, e);
    }

    public boolean start() {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.start();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in start", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean launchCaptivePortalApp() {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.launchCaptivePortalApp();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in launchCaptivePortalApp", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyCaptivePortalAppFinished(int response) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyCaptivePortalAppFinished(response);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyCaptivePortalAppFinished", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setAcceptPartialConnectivity() {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.setAcceptPartialConnectivity();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in setAcceptPartialConnectivity", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean forceReevaluation(int uid) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.forceReevaluation(uid);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in forceReevaluation", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyPrivateDnsChanged(PrivateDnsConfigParcel config) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyPrivateDnsChanged(config);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyPrivateDnsChanged", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyDnsResponse(int returnCode) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyDnsResponse(returnCode);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyDnsResponse", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    @Deprecated
    public boolean notifyNetworkConnected(LinkProperties lp, NetworkCapabilities nc) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyNetworkConnected(lp, nc);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyNetworkConnected", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyNetworkConnected(NetworkMonitorParameters params) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyNetworkConnectedParcel(params);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyNetworkConnected", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyNetworkDisconnected() {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyNetworkDisconnected();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyNetworkDisconnected", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyLinkPropertiesChanged(LinkProperties lp) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyLinkPropertiesChanged(lp);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyLinkPropertiesChanged", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyNetworkCapabilitiesChanged(NetworkCapabilities nc) {
        long token = Binder.clearCallingIdentity();
        this.mNetworkMonitor.notifyNetworkCapabilitiesChanged(nc);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error in notifyNetworkCapabilitiesChanged", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
