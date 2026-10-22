package stepos.net;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSNetdManager {
    public static final String SERVICE_NAME = "stepos_netd";
    private static final String TAG = "StepOSNetdManager";
    private final Context mContext;
    private final IStepOSNetd mService;

    public StepOSNetdManager(Context context, IStepOSNetd service) {
        this.mContext = context;
        this.mService = service;
    }

    public boolean isAlive() {
        try {
            if (this.mService != null) {
                return this.mService.isAlive();
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "isAlive failed", e);
            return false;
        }
    }

    public void registerStepOSUnsolicitedEventListener(IStepOSNetdUnsolicitedEventListener listener) {
        try {
            this.mService.registerStepOSUnsolicitedEventListener(listener);
        } catch (RemoteException e) {
            Log.e(TAG, "registerStepOSUnsolicitedEventListener failed", e);
        }
    }

    public String[] getHostNames() {
        try {
            String[] names = this.mService.getHostNames();
            return names != null ? names : new String[0];
        } catch (RemoteException e) {
            Log.e(TAG, "getHostNames failed", e);
            return new String[0];
        }
    }

    public boolean addHostNames(String ipAddr, String hostName) {
        try {
            return this.mService.addHostNames(ipAddr, hostName);
        } catch (RemoteException e) {
            Log.e(TAG, "addHostNames failed", e);
            return false;
        }
    }

    public void resetHosts() {
        try {
            this.mService.resetHosts();
        } catch (RemoteException e) {
            Log.e(TAG, "resetHosts failed", e);
        }
    }

    public boolean enableQuickAppRulse(boolean enable, String port) {
        try {
            return this.mService.enableQuickAppRulse(enable, port);
        } catch (RemoteException e) {
            Log.e(TAG, "enableQuickAppRulse failed", e);
            return false;
        }
    }

    public String[] getIptableRules(String table, String chain) {
        try {
            String[] rules = this.mService.getIptableRules(table, chain);
            return rules != null ? rules : new String[0];
        } catch (RemoteException e) {
            Log.e(TAG, "getIptableRules failed", e);
            return new String[0];
        }
    }

    public String[] executeShellToSetIptables(String table, String cmd) {
        try {
            String[] ret = this.mService.executeShellToSetIptables(table, cmd);
            return ret != null ? ret : new String[0];
        } catch (RemoteException e) {
            Log.e(TAG, "executeShellToSetIptables failed", e);
            return new String[0];
        }
    }

    public String[] runIpCounterCommand(String[] arguments) {
        try {
            String[] ret = this.mService.runIpCounterCommand(arguments);
            return ret != null ? ret : new String[0];
        } catch (RemoteException e) {
            Log.e(TAG, "runIpCounterCommand failed", e);
            return new String[0];
        }
    }

    public boolean ipfwdAddVpnInterfaceForward(String fromIface, String toIface) {
        try {
            return this.mService.ipfwdAddVpnInterfaceForward(fromIface, toIface);
        } catch (RemoteException e) {
            Log.e(TAG, "ipfwdAddVpnInterfaceForward failed", e);
            return false;
        }
    }

    public boolean ipfwdRemoveVpnInterfaceForward(String fromIface, String toIface) {
        try {
            return this.mService.ipfwdRemoveVpnInterfaceForward(fromIface, toIface);
        } catch (RemoteException e) {
            Log.e(TAG, "ipfwdRemoveVpnInterfaceForward failed", e);
            return false;
        }
    }

    public boolean setVpnNetworkForApp(int uid, int netId, boolean enable) {
        try {
            return this.mService.setVpnNetworkForApp(uid, netId, enable);
        } catch (RemoteException e) {
            Log.e(TAG, "setVpnNetworkForApp failed", e);
            return false;
        }
    }

    public boolean setMobileNetworkForApp(int uid, int netId, boolean enable) {
        try {
            return this.mService.setMobileNetworkForApp(uid, netId, enable);
        } catch (RemoteException e) {
            Log.e(TAG, "setMobileNetworkForApp failed", e);
            return false;
        }
    }

    public void setFirewallUidChainRule(int uid, String chain, String rule) {
        try {
            this.mService.setFirewallUidChainRule(uid, chain, rule);
        } catch (RemoteException e) {
            Log.e(TAG, "setFirewallUidChainRule failed", e);
        }
    }

    public void onFreezeUidPktState(int uid, int pktState) {
        try {
            this.mService.onFreezeUidPktState(uid, pktState);
        } catch (RemoteException e) {
            Log.e(TAG, "onFreezeUidPktState failed", e);
        }
    }
}
