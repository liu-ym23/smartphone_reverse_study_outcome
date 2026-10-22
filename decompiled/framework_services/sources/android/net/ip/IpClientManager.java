package android.net.ip;

import android.net.DhcpResultsParcelable;
import android.net.NattKeepalivePacketData;
import android.net.ProxyInfo;
import android.net.TcpKeepalivePacketData;
import android.net.TcpKeepalivePacketDataParcelable;
import android.net.apf.ApfCapabilities;
import android.net.shared.Layer2Information;
import android.net.shared.ProvisioningConfiguration;
import android.net.util.KeepalivePacketDataUtil;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class IpClientManager {
    private final IIpClient mIpClient;
    private final String mTag;

    public IpClientManager(IIpClient ipClient, String tag) {
        this.mIpClient = ipClient;
        this.mTag = tag;
    }

    public IpClientManager(IIpClient ipClient) {
        this(ipClient, IpClientManager.class.getSimpleName());
    }

    private void log(String s, Throwable e) {
        Log.e(this.mTag, s, e);
    }

    public boolean completedPreDhcpAction() {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.completedPreDhcpAction();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error completing PreDhcpAction", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean confirmConfiguration() {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.confirmConfiguration();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error confirming IpClient configuration", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean readPacketFilterComplete(byte[] data) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.readPacketFilterComplete(data);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error notifying IpClient of packet filter read", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean shutdown() {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.shutdown();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error shutting down IpClient", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean startProvisioning(ProvisioningConfiguration prov) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.startProvisioning(prov.toStableParcelable());     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L8:
        e = move-exception;
        log("Error starting IpClient provisioning", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    }

    public boolean stop() {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.stop();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error stopping IpClient", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setTcpBufferSizes(String tcpBufferSizes) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.setTcpBufferSizes(tcpBufferSizes);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error setting IpClient TCP buffer sizes", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setHttpProxy(ProxyInfo proxyInfo) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.setHttpProxy(proxyInfo);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error setting IpClient proxy", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setMulticastFilter(boolean enabled) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.setMulticastFilter(enabled);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error setting multicast filter", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean addKeepalivePacketFilter(int slot, TcpKeepalivePacketData pkt) {
        return addKeepalivePacketFilter(slot, KeepalivePacketDataUtil.toStableParcelable(pkt));
    }

    @Deprecated
    public boolean addKeepalivePacketFilter(int slot, TcpKeepalivePacketDataParcelable pkt) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.addKeepalivePacketFilter(slot, pkt);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error adding Keepalive Packet Filter ", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean addKeepalivePacketFilter(int slot, NattKeepalivePacketData pkt) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.addNattKeepalivePacketFilter(slot, KeepalivePacketDataUtil.toStableParcelable(pkt));     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L8:
        e = move-exception;
        log("Error adding NAT-T Keepalive Packet Filter ", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    }

    public boolean removeKeepalivePacketFilter(int slot) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.removeKeepalivePacketFilter(slot);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error removing Keepalive Packet Filter ", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setL2KeyAndGroupHint(String l2Key, String groupHint) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.setL2KeyAndGroupHint(l2Key, groupHint);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Failed setL2KeyAndGroupHint", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean notifyPreconnectionComplete(boolean success) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.notifyPreconnectionComplete(success);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error notifying IpClient Preconnection completed", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean updateLayer2Information(Layer2Information info) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.updateLayer2Information(info.toStableParcelable());     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L8:
        e = move-exception;
        log("Error updating layer2 information", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    }

    public boolean updateApfCapabilities(ApfCapabilities apfCapabilities) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.updateApfCapabilities(apfCapabilities);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error updating APF capabilities", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean applyDhcpOfferForSelfCure(DhcpResultsParcelable offer) {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.applyDhcpOfferForSelfCure(offer);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error applying DHCP offer for self-cure", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean restoreInitialDhcpLeaseSilently() {
        long token = Binder.clearCallingIdentity();
        this.mIpClient.restoreInitialDhcpLeaseSilently();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        e = move-exception;
        log("Error restoring initial DHCP lease", e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
