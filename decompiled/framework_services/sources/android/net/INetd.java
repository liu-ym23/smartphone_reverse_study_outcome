package android.net;

import android.net.netd.aidl.NativeUidRangeConfig;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INetd extends IInterface {
    public static final int CLAT_MARK = -559038041;
    public static final int CONF = 1;
    public static final int DUMMY_NET_ID = 51;
    public static final int FIREWALL_ALLOWLIST = 0;

    @Deprecated
    public static final int FIREWALL_BLACKLIST = 1;
    public static final int FIREWALL_CHAIN_DOZABLE = 1;
    public static final int FIREWALL_CHAIN_NONE = 0;
    public static final int FIREWALL_CHAIN_POWERSAVE = 3;
    public static final int FIREWALL_CHAIN_RESTRICTED = 4;
    public static final int FIREWALL_CHAIN_STANDBY = 2;
    public static final int FIREWALL_DENYLIST = 1;
    public static final int FIREWALL_RULE_ALLOW = 1;
    public static final int FIREWALL_RULE_DENY = 2;

    @Deprecated
    public static final int FIREWALL_WHITELIST = 0;
    public static final String HASH = "a786da2fe41bda627a8c1e63b99264a415e769c8";
    public static final String IF_FLAG_BROADCAST = "broadcast";
    public static final String IF_FLAG_LOOPBACK = "loopback";
    public static final String IF_FLAG_MULTICAST = "multicast";
    public static final String IF_FLAG_POINTOPOINT = "point-to-point";
    public static final String IF_FLAG_RUNNING = "running";
    public static final String IF_STATE_DOWN = "down";
    public static final String IF_STATE_UP = "up";
    public static final int IPSEC_DIRECTION_IN = 0;
    public static final int IPSEC_DIRECTION_OUT = 1;
    public static final String IPSEC_INTERFACE_PREFIX = "ipsec";
    public static final int IPV4 = 4;
    public static final int IPV6 = 6;
    public static final int IPV6_ADDR_GEN_MODE_DEFAULT = 0;
    public static final int IPV6_ADDR_GEN_MODE_EUI64 = 0;
    public static final int IPV6_ADDR_GEN_MODE_NONE = 1;
    public static final int IPV6_ADDR_GEN_MODE_RANDOM = 3;
    public static final int IPV6_ADDR_GEN_MODE_STABLE_PRIVACY = 2;
    public static final int LOCAL_NET_ID = 99;
    public static final int NEIGH = 2;
    public static final String NEXTHOP_NONE = "";
    public static final String NEXTHOP_THROW = "throw";
    public static final String NEXTHOP_UNREACHABLE = "unreachable";

    @Deprecated
    public static final int NO_PERMISSIONS = 0;
    public static final int PENALTY_POLICY_ACCEPT = 1;
    public static final int PENALTY_POLICY_LOG = 2;
    public static final int PENALTY_POLICY_REJECT = 3;

    @Deprecated
    public static final int PERMISSION_INTERNET = 4;
    public static final int PERMISSION_NETWORK = 1;
    public static final int PERMISSION_NONE = 0;
    public static final int PERMISSION_SYSTEM = 2;

    @Deprecated
    public static final int PERMISSION_UNINSTALLED = -1;

    @Deprecated
    public static final int PERMISSION_UPDATE_DEVICE_STATS = 8;
    public static final int UNREACHABLE_NET_ID = 52;
    public static final int VERSION = 17;

    public static class Default implements INetd {
        public Default() {
        }

        @Override // android.net.INetd
        public boolean isAlive() throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public boolean firewallReplaceUidChain(String chainName, boolean isAllowlist, int[] uids) throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public boolean bandwidthEnableDataSaver(boolean enable) throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public void networkCreatePhysical(int netId, int permission) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkCreateVpn(int netId, boolean secure) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkDestroy(int netId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkAddInterface(int netId, String iface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveInterface(int netId, String iface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkAddUidRanges(int netId, UidRangeParcel[] uidRanges) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveUidRanges(int netId, UidRangeParcel[] uidRanges) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRejectNonSecureVpn(boolean add, UidRangeParcel[] uidRanges) throws RemoteException {
        }

        @Override // android.net.INetd
        public void socketDestroy(UidRangeParcel[] uidRanges, int[] exemptUids) throws RemoteException {
        }

        @Override // android.net.INetd
        public boolean tetherApplyDnsInterfaces() throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public TetherStatsParcel[] tetherGetStats() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void interfaceAddAddress(String ifName, String addrString, int prefixLength) throws RemoteException {
        }

        @Override // android.net.INetd
        public void interfaceDelAddress(String ifName, String addrString, int prefixLength) throws RemoteException {
        }

        @Override // android.net.INetd
        public String getProcSysNet(int ipversion, int which, String ifname, String parameter) throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void setProcSysNet(int ipversion, int which, String ifname, String parameter, String value) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecSetEncapSocketOwner(ParcelFileDescriptor socket, int newUid) throws RemoteException {
        }

        @Override // android.net.INetd
        public int ipSecAllocateSpi(int transformId, String sourceAddress, String destinationAddress, int spi) throws RemoteException {
            return 0;
        }

        @Override // android.net.INetd
        public void ipSecAddSecurityAssociation(int transformId, int mode, String sourceAddress, String destinationAddress, int underlyingNetId, int spi, int markValue, int markMask, String authAlgo, byte[] authKey, int authTruncBits, String cryptAlgo, byte[] cryptKey, int cryptTruncBits, String aeadAlgo, byte[] aeadKey, int aeadIcvBits, int encapType, int encapLocalPort, int encapRemotePort, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecDeleteSecurityAssociation(int transformId, String sourceAddress, String destinationAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecApplyTransportModeTransform(ParcelFileDescriptor socket, int transformId, int direction, String sourceAddress, String destinationAddress, int spi) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecRemoveTransportModeTransform(ParcelFileDescriptor socket) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecAddSecurityPolicy(int transformId, int selAddrFamily, int direction, String tmplSrcAddress, String tmplDstAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecUpdateSecurityPolicy(int transformId, int selAddrFamily, int direction, String tmplSrcAddress, String tmplDstAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecDeleteSecurityPolicy(int transformId, int selAddrFamily, int direction, int markValue, int markMask, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecAddTunnelInterface(String deviceName, String localAddress, String remoteAddress, int iKey, int oKey, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecUpdateTunnelInterface(String deviceName, String localAddress, String remoteAddress, int iKey, int oKey, int interfaceId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecRemoveTunnelInterface(String deviceName) throws RemoteException {
        }

        @Override // android.net.INetd
        public void wakeupAddInterface(String ifName, String prefix, int mark, int mask) throws RemoteException {
        }

        @Override // android.net.INetd
        public void wakeupDelInterface(String ifName, String prefix, int mark, int mask) throws RemoteException {
        }

        @Override // android.net.INetd
        public void setIPv6AddrGenMode(String ifName, int mode) throws RemoteException {
        }

        @Override // android.net.INetd
        public void idletimerAddInterface(String ifName, int timeout, String classLabel) throws RemoteException {
        }

        @Override // android.net.INetd
        public void idletimerRemoveInterface(String ifName, int timeout, String classLabel) throws RemoteException {
        }

        @Override // android.net.INetd
        public void strictUidCleartextPenalty(int uid, int policyPenalty) throws RemoteException {
        }

        @Override // android.net.INetd
        public String clatdStart(String ifName, String nat64Prefix) throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void clatdStop(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public boolean ipfwdEnabled() throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public String[] ipfwdGetRequesterList() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void ipfwdEnableForwarding(String requester) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipfwdDisableForwarding(String requester) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipfwdAddInterfaceForward(String fromIface, String toIface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipfwdRemoveInterfaceForward(String fromIface, String toIface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthSetInterfaceQuota(String ifName, long bytes) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthRemoveInterfaceQuota(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthSetInterfaceAlert(String ifName, long bytes) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthRemoveInterfaceAlert(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthSetGlobalAlert(long bytes) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthAddNaughtyApp(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthRemoveNaughtyApp(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthAddNiceApp(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void bandwidthRemoveNiceApp(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherStart(String[] dhcpRanges) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherStop() throws RemoteException {
        }

        @Override // android.net.INetd
        public boolean tetherIsEnabled() throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public void tetherInterfaceAdd(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherInterfaceRemove(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public String[] tetherInterfaceList() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void tetherDnsSet(int netId, String[] dnsAddrs) throws RemoteException {
        }

        @Override // android.net.INetd
        public String[] tetherDnsList() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void networkAddRoute(int netId, String ifName, String destination, String nextHop) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveRoute(int netId, String ifName, String destination, String nextHop) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkAddLegacyRoute(int netId, String ifName, String destination, String nextHop, int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveLegacyRoute(int netId, String ifName, String destination, String nextHop, int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public int networkGetDefault() throws RemoteException {
            return 0;
        }

        @Override // android.net.INetd
        public void networkSetDefault(int netId) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkClearDefault() throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkSetPermissionForNetwork(int netId, int permission) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkSetPermissionForUser(int permission, int[] uids) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkClearPermissionForUser(int[] uids) throws RemoteException {
        }

        @Override // android.net.INetd
        public void trafficSetNetPermForUids(int permission, int[] uids) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkSetProtectAllow(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkSetProtectDeny(int uid) throws RemoteException {
        }

        @Override // android.net.INetd
        public boolean networkCanProtect(int uid) throws RemoteException {
            return false;
        }

        @Override // android.net.INetd
        public void firewallSetFirewallType(int firewalltype) throws RemoteException {
        }

        @Override // android.net.INetd
        public void firewallSetInterfaceRule(String ifName, int firewallRule) throws RemoteException {
        }

        @Override // android.net.INetd
        public void firewallSetUidRule(int childChain, int uid, int firewallRule) throws RemoteException {
        }

        @Override // android.net.INetd
        public void firewallEnableChildChain(int childChain, boolean enable) throws RemoteException {
        }

        @Override // android.net.INetd
        public String[] interfaceGetList() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public InterfaceConfigurationParcel interfaceGetCfg(String ifName) throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void interfaceSetCfg(InterfaceConfigurationParcel cfg) throws RemoteException {
        }

        @Override // android.net.INetd
        public void interfaceSetIPv6PrivacyExtensions(String ifName, boolean enable) throws RemoteException {
        }

        @Override // android.net.INetd
        public void interfaceClearAddrs(String ifName) throws RemoteException {
        }

        @Override // android.net.INetd
        public void interfaceSetEnableIPv6(String ifName, boolean enable) throws RemoteException {
        }

        @Override // android.net.INetd
        public void interfaceSetMtu(String ifName, int mtu) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherAddForward(String intIface, String extIface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherRemoveForward(String intIface, String extIface) throws RemoteException {
        }

        @Override // android.net.INetd
        public void setTcpRWmemorySize(String rmemValues, String wmemValues) throws RemoteException {
        }

        @Override // android.net.INetd
        public void registerUnsolicitedEventListener(INetdUnsolicitedEventListener listener) throws RemoteException {
        }

        @Override // android.net.INetd
        public void firewallAddUidInterfaceRules(String ifName, int[] uids) throws RemoteException {
        }

        @Override // android.net.INetd
        public void firewallRemoveUidInterfaceRules(int[] uids) throws RemoteException {
        }

        @Override // android.net.INetd
        public void trafficSwapActiveStatsMap() throws RemoteException {
        }

        @Override // android.net.INetd
        public IBinder getOemNetd() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void tetherStartWithConfiguration(TetherConfigParcel config) throws RemoteException {
        }

        @Override // android.net.INetd
        public MarkMaskParcel getFwmarkForNetwork(int netId) throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void networkAddRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkUpdateRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherOffloadRuleAdd(TetherOffloadRuleParcel rule) throws RemoteException {
        }

        @Override // android.net.INetd
        public void tetherOffloadRuleRemove(TetherOffloadRuleParcel rule) throws RemoteException {
        }

        @Override // android.net.INetd
        public TetherStatsParcel[] tetherOffloadGetStats() throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void tetherOffloadSetInterfaceQuota(int ifIndex, long quotaBytes) throws RemoteException {
        }

        @Override // android.net.INetd
        public TetherStatsParcel tetherOffloadGetAndClearStats(int ifIndex) throws RemoteException {
            return null;
        }

        @Override // android.net.INetd
        public void networkCreate(NativeNetworkConfig config) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkAddUidRangesParcel(NativeUidRangeConfig uidRangesConfig) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkRemoveUidRangesParcel(NativeUidRangeConfig uidRangesConfig) throws RemoteException {
        }

        @Override // android.net.INetd
        public void ipSecMigrate(IpSecMigrateInfoParcel migrateInfo) throws RemoteException {
        }

        @Override // android.net.INetd
        public void setNetworkAllowlist(NativeUidRangeConfig[] allowedNetworks) throws RemoteException {
        }

        @Override // android.net.INetd
        public void networkAllowBypassVpnOnNetwork(boolean allow, int uid, int netId) throws RemoteException {
        }

        @Override // android.net.INetd
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.INetd
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INetd {
        public static final String DESCRIPTOR = null;
        static final int TRANSACTION_bandwidthAddNaughtyApp = 50;
        static final int TRANSACTION_bandwidthAddNiceApp = 52;
        static final int TRANSACTION_bandwidthEnableDataSaver = 3;
        static final int TRANSACTION_bandwidthRemoveInterfaceAlert = 48;
        static final int TRANSACTION_bandwidthRemoveInterfaceQuota = 46;
        static final int TRANSACTION_bandwidthRemoveNaughtyApp = 51;
        static final int TRANSACTION_bandwidthRemoveNiceApp = 53;
        static final int TRANSACTION_bandwidthSetGlobalAlert = 49;
        static final int TRANSACTION_bandwidthSetInterfaceAlert = 47;
        static final int TRANSACTION_bandwidthSetInterfaceQuota = 45;
        static final int TRANSACTION_clatdStart = 37;
        static final int TRANSACTION_clatdStop = 38;
        static final int TRANSACTION_firewallAddUidInterfaceRules = 91;
        static final int TRANSACTION_firewallEnableChildChain = 79;
        static final int TRANSACTION_firewallRemoveUidInterfaceRules = 92;
        static final int TRANSACTION_firewallReplaceUidChain = 2;
        static final int TRANSACTION_firewallSetFirewallType = 76;
        static final int TRANSACTION_firewallSetInterfaceRule = 77;
        static final int TRANSACTION_firewallSetUidRule = 78;
        static final int TRANSACTION_getFwmarkForNetwork = 96;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getOemNetd = 94;
        static final int TRANSACTION_getProcSysNet = 17;
        static final int TRANSACTION_idletimerAddInterface = 34;
        static final int TRANSACTION_idletimerRemoveInterface = 35;
        static final int TRANSACTION_interfaceAddAddress = 15;
        static final int TRANSACTION_interfaceClearAddrs = 84;
        static final int TRANSACTION_interfaceDelAddress = 16;
        static final int TRANSACTION_interfaceGetCfg = 81;
        static final int TRANSACTION_interfaceGetList = 80;
        static final int TRANSACTION_interfaceSetCfg = 82;
        static final int TRANSACTION_interfaceSetEnableIPv6 = 85;
        static final int TRANSACTION_interfaceSetIPv6PrivacyExtensions = 83;
        static final int TRANSACTION_interfaceSetMtu = 86;
        static final int TRANSACTION_ipSecAddSecurityAssociation = 21;
        static final int TRANSACTION_ipSecAddSecurityPolicy = 25;
        static final int TRANSACTION_ipSecAddTunnelInterface = 28;
        static final int TRANSACTION_ipSecAllocateSpi = 20;
        static final int TRANSACTION_ipSecApplyTransportModeTransform = 23;
        static final int TRANSACTION_ipSecDeleteSecurityAssociation = 22;
        static final int TRANSACTION_ipSecDeleteSecurityPolicy = 27;
        static final int TRANSACTION_ipSecMigrate = 108;
        static final int TRANSACTION_ipSecRemoveTransportModeTransform = 24;
        static final int TRANSACTION_ipSecRemoveTunnelInterface = 30;
        static final int TRANSACTION_ipSecSetEncapSocketOwner = 19;
        static final int TRANSACTION_ipSecUpdateSecurityPolicy = 26;
        static final int TRANSACTION_ipSecUpdateTunnelInterface = 29;
        static final int TRANSACTION_ipfwdAddInterfaceForward = 43;
        static final int TRANSACTION_ipfwdDisableForwarding = 42;
        static final int TRANSACTION_ipfwdEnableForwarding = 41;
        static final int TRANSACTION_ipfwdEnabled = 39;
        static final int TRANSACTION_ipfwdGetRequesterList = 40;
        static final int TRANSACTION_ipfwdRemoveInterfaceForward = 44;
        static final int TRANSACTION_isAlive = 1;
        static final int TRANSACTION_networkAddInterface = 7;
        static final int TRANSACTION_networkAddLegacyRoute = 64;
        static final int TRANSACTION_networkAddRoute = 62;
        static final int TRANSACTION_networkAddRouteParcel = 97;
        static final int TRANSACTION_networkAddUidRanges = 9;
        static final int TRANSACTION_networkAddUidRangesParcel = 106;
        static final int TRANSACTION_networkAllowBypassVpnOnNetwork = 110;
        static final int TRANSACTION_networkCanProtect = 75;
        static final int TRANSACTION_networkClearDefault = 68;
        static final int TRANSACTION_networkClearPermissionForUser = 71;
        static final int TRANSACTION_networkCreate = 105;
        static final int TRANSACTION_networkCreatePhysical = 4;
        static final int TRANSACTION_networkCreateVpn = 5;
        static final int TRANSACTION_networkDestroy = 6;
        static final int TRANSACTION_networkGetDefault = 66;
        static final int TRANSACTION_networkRejectNonSecureVpn = 11;
        static final int TRANSACTION_networkRemoveInterface = 8;
        static final int TRANSACTION_networkRemoveLegacyRoute = 65;
        static final int TRANSACTION_networkRemoveRoute = 63;
        static final int TRANSACTION_networkRemoveRouteParcel = 99;
        static final int TRANSACTION_networkRemoveUidRanges = 10;
        static final int TRANSACTION_networkRemoveUidRangesParcel = 107;
        static final int TRANSACTION_networkSetDefault = 67;
        static final int TRANSACTION_networkSetPermissionForNetwork = 69;
        static final int TRANSACTION_networkSetPermissionForUser = 70;
        static final int TRANSACTION_networkSetProtectAllow = 73;
        static final int TRANSACTION_networkSetProtectDeny = 74;
        static final int TRANSACTION_networkUpdateRouteParcel = 98;
        static final int TRANSACTION_registerUnsolicitedEventListener = 90;
        static final int TRANSACTION_setIPv6AddrGenMode = 33;
        static final int TRANSACTION_setNetworkAllowlist = 109;
        static final int TRANSACTION_setProcSysNet = 18;
        static final int TRANSACTION_setTcpRWmemorySize = 89;
        static final int TRANSACTION_socketDestroy = 12;
        static final int TRANSACTION_strictUidCleartextPenalty = 36;
        static final int TRANSACTION_tetherAddForward = 87;
        static final int TRANSACTION_tetherApplyDnsInterfaces = 13;
        static final int TRANSACTION_tetherDnsList = 61;
        static final int TRANSACTION_tetherDnsSet = 60;
        static final int TRANSACTION_tetherGetStats = 14;
        static final int TRANSACTION_tetherInterfaceAdd = 57;
        static final int TRANSACTION_tetherInterfaceList = 59;
        static final int TRANSACTION_tetherInterfaceRemove = 58;
        static final int TRANSACTION_tetherIsEnabled = 56;
        static final int TRANSACTION_tetherOffloadGetAndClearStats = 104;
        static final int TRANSACTION_tetherOffloadGetStats = 102;
        static final int TRANSACTION_tetherOffloadRuleAdd = 100;
        static final int TRANSACTION_tetherOffloadRuleRemove = 101;
        static final int TRANSACTION_tetherOffloadSetInterfaceQuota = 103;
        static final int TRANSACTION_tetherRemoveForward = 88;
        static final int TRANSACTION_tetherStart = 54;
        static final int TRANSACTION_tetherStartWithConfiguration = 95;
        static final int TRANSACTION_tetherStop = 55;
        static final int TRANSACTION_trafficSetNetPermForUids = 72;
        static final int TRANSACTION_trafficSwapActiveStatsMap = 93;
        static final int TRANSACTION_wakeupAddInterface = 31;
        static final int TRANSACTION_wakeupDelInterface = 32;

        private static class Proxy implements INetd {
            private String mCachedHash;
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mCachedVersion = -1;
                this.mCachedHash = "-1";
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.net.INetd
            public boolean isAlive() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isAlive is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean firewallReplaceUidChain(String chainName, boolean isAllowlist, int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(chainName);     // Catch: Throwable -> L8
                _data.writeBoolean(isAllowlist);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method firewallReplaceUidChain is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean bandwidthEnableDataSaver(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method bandwidthEnableDataSaver is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkCreatePhysical(int netId, int permission) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeInt(permission);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkCreatePhysical is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkCreateVpn(int netId, boolean secure) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeBoolean(secure);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkCreateVpn is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkDestroy(int netId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkDestroy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddInterface(int netId, String iface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(iface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveInterface(int netId, String iface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(iface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddUidRanges(int netId, UidRangeParcel[] uidRanges) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeTypedArray(uidRanges, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddUidRanges is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveUidRanges(int netId, UidRangeParcel[] uidRanges) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeTypedArray(uidRanges, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveUidRanges is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRejectNonSecureVpn(boolean add, UidRangeParcel[] uidRanges) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(add);     // Catch: Throwable -> L8
                _data.writeTypedArray(uidRanges, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRejectNonSecureVpn is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void socketDestroy(UidRangeParcel[] uidRanges, int[] exemptUids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(uidRanges, 0);     // Catch: Throwable -> L8
                _data.writeIntArray(exemptUids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method socketDestroy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean tetherApplyDnsInterfaces() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherApplyDnsInterfaces is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public TetherStatsParcel[] tetherGetStats() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                TetherStatsParcel[] _result = (TetherStatsParcel[]) _reply.createTypedArray(TetherStatsParcel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherGetStats is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceAddAddress(String ifName, String addrString, int prefixLength) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(addrString);     // Catch: Throwable -> L8
                _data.writeInt(prefixLength);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceAddAddress is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceDelAddress(String ifName, String addrString, int prefixLength) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(addrString);     // Catch: Throwable -> L8
                _data.writeInt(prefixLength);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceDelAddress is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String getProcSysNet(int ipversion, int which, String ifname, String parameter) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(ipversion);     // Catch: Throwable -> L8
                _data.writeInt(which);     // Catch: Throwable -> L8
                _data.writeString(ifname);     // Catch: Throwable -> L8
                _data.writeString(parameter);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(17, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String _result = _reply.readString();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getProcSysNet is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void setProcSysNet(int ipversion, int which, String ifname, String parameter, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(ipversion);     // Catch: Throwable -> L8
                _data.writeInt(which);     // Catch: Throwable -> L8
                _data.writeString(ifname);     // Catch: Throwable -> L8
                _data.writeString(parameter);     // Catch: Throwable -> L8
                _data.writeString(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(18, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setProcSysNet is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecSetEncapSocketOwner(ParcelFileDescriptor socket, int newUid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(socket, 0);     // Catch: Throwable -> L8
                _data.writeInt(newUid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(19, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecSetEncapSocketOwner is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public int ipSecAllocateSpi(int transformId, String sourceAddress, String destinationAddress, int spi) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeString(sourceAddress);     // Catch: Throwable -> L8
                _data.writeString(destinationAddress);     // Catch: Throwable -> L8
                _data.writeInt(spi);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(20, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method ipSecAllocateSpi is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecAddSecurityAssociation(int transformId, int mode, String sourceAddress, String destinationAddress, int underlyingNetId, int spi, int markValue, int markMask, String authAlgo, byte[] authKey, int authTruncBits, String cryptAlgo, byte[] cryptKey, int cryptTruncBits, String aeadAlgo, byte[] aeadKey, int aeadIcvBits, int encapType, int encapLocalPort, int encapRemotePort, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L54
                _data.writeInt(transformId);     // Catch: Throwable -> L54
                _data.writeInt(mode);     // Catch: Throwable -> L54
                _data.writeString(sourceAddress);     // Catch: Throwable -> L52
                _data.writeString(destinationAddress);     // Catch: Throwable -> L50
                _data.writeInt(underlyingNetId);     // Catch: Throwable -> L48
                _data.writeInt(spi);     // Catch: Throwable -> L46
                _data.writeInt(markValue);     // Catch: Throwable -> L44
                _data.writeInt(markMask);     // Catch: Throwable -> L42
                _data.writeString(authAlgo);     // Catch: Throwable -> L40
                _data.writeByteArray(authKey);     // Catch: Throwable -> L38
                _data.writeInt(authTruncBits);     // Catch: Throwable -> L36
                _data.writeString(cryptAlgo);     // Catch: Throwable -> L34
                _data.writeByteArray(cryptKey);     // Catch: Throwable -> L30
                _data.writeInt(cryptTruncBits);     // Catch: Throwable -> L30
                _data.writeString(aeadAlgo);     // Catch: Throwable -> L30
                _data.writeByteArray(aeadKey);     // Catch: Throwable -> L30
                _data.writeInt(aeadIcvBits);     // Catch: Throwable -> L30
                _data.writeInt(encapType);     // Catch: Throwable -> L30
                _data.writeInt(encapLocalPort);     // Catch: Throwable -> L30
                _data.writeInt(encapRemotePort);     // Catch: Throwable -> L30
                _data.writeInt(interfaceId);     // Catch: Throwable -> L30
                boolean _status = this.mRemote.transact(21, _data, _reply, 0);     // Catch: Throwable -> L30
                if (_status == false) goto L33;
                _reply.readException();     // Catch: Throwable -> L30
                _reply.recycle();
                _data.recycle();
                return;
            L33:
                throw new RemoteException("Method ipSecAddSecurityAssociation is unimplemented.");     // Catch: Throwable -> L30
            L30:
                th = th;
            L56:
                _reply.recycle();
                _data.recycle();
                throw th;
            L34:
                th = th;
            L36:
                th = th;
            L38:
                th = th;
            L40:
                th = th;
            L42:
                th = th;
            L44:
                th = th;
            L46:
                th = th;
            L48:
                th = th;
            L50:
                th = th;
            L52:
                th = th;
            L54:
                th = th;
                goto L56
            }

            @Override // android.net.INetd
            public void ipSecDeleteSecurityAssociation(int transformId, String sourceAddress, String destinationAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeString(sourceAddress);     // Catch: Throwable -> L8
                _data.writeString(destinationAddress);     // Catch: Throwable -> L8
                _data.writeInt(spi);     // Catch: Throwable -> L8
                _data.writeInt(markValue);     // Catch: Throwable -> L8
                _data.writeInt(markMask);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(22, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecDeleteSecurityAssociation is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecApplyTransportModeTransform(ParcelFileDescriptor socket, int transformId, int direction, String sourceAddress, String destinationAddress, int spi) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(socket, 0);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeInt(direction);     // Catch: Throwable -> L8
                _data.writeString(sourceAddress);     // Catch: Throwable -> L8
                _data.writeString(destinationAddress);     // Catch: Throwable -> L8
                _data.writeInt(spi);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(23, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecApplyTransportModeTransform is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecRemoveTransportModeTransform(ParcelFileDescriptor socket) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(socket, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(24, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecRemoveTransportModeTransform is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecAddSecurityPolicy(int transformId, int selAddrFamily, int direction, String tmplSrcAddress, String tmplDstAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeInt(selAddrFamily);     // Catch: Throwable -> L8
                _data.writeInt(direction);     // Catch: Throwable -> L8
                _data.writeString(tmplSrcAddress);     // Catch: Throwable -> L8
                _data.writeString(tmplDstAddress);     // Catch: Throwable -> L8
                _data.writeInt(spi);     // Catch: Throwable -> L8
                _data.writeInt(markValue);     // Catch: Throwable -> L8
                _data.writeInt(markMask);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(25, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecAddSecurityPolicy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecUpdateSecurityPolicy(int transformId, int selAddrFamily, int direction, String tmplSrcAddress, String tmplDstAddress, int spi, int markValue, int markMask, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeInt(selAddrFamily);     // Catch: Throwable -> L8
                _data.writeInt(direction);     // Catch: Throwable -> L8
                _data.writeString(tmplSrcAddress);     // Catch: Throwable -> L8
                _data.writeString(tmplDstAddress);     // Catch: Throwable -> L8
                _data.writeInt(spi);     // Catch: Throwable -> L8
                _data.writeInt(markValue);     // Catch: Throwable -> L8
                _data.writeInt(markMask);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(26, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecUpdateSecurityPolicy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecDeleteSecurityPolicy(int transformId, int selAddrFamily, int direction, int markValue, int markMask, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(transformId);     // Catch: Throwable -> L8
                _data.writeInt(selAddrFamily);     // Catch: Throwable -> L8
                _data.writeInt(direction);     // Catch: Throwable -> L8
                _data.writeInt(markValue);     // Catch: Throwable -> L8
                _data.writeInt(markMask);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(27, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecDeleteSecurityPolicy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecAddTunnelInterface(String deviceName, String localAddress, String remoteAddress, int iKey, int oKey, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(deviceName);     // Catch: Throwable -> L8
                _data.writeString(localAddress);     // Catch: Throwable -> L8
                _data.writeString(remoteAddress);     // Catch: Throwable -> L8
                _data.writeInt(iKey);     // Catch: Throwable -> L8
                _data.writeInt(oKey);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(28, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecAddTunnelInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecUpdateTunnelInterface(String deviceName, String localAddress, String remoteAddress, int iKey, int oKey, int interfaceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(deviceName);     // Catch: Throwable -> L8
                _data.writeString(localAddress);     // Catch: Throwable -> L8
                _data.writeString(remoteAddress);     // Catch: Throwable -> L8
                _data.writeInt(iKey);     // Catch: Throwable -> L8
                _data.writeInt(oKey);     // Catch: Throwable -> L8
                _data.writeInt(interfaceId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(29, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecUpdateTunnelInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecRemoveTunnelInterface(String deviceName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(deviceName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(30, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecRemoveTunnelInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void wakeupAddInterface(String ifName, String prefix, int mark, int mask) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(prefix);     // Catch: Throwable -> L8
                _data.writeInt(mark);     // Catch: Throwable -> L8
                _data.writeInt(mask);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(31, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method wakeupAddInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void wakeupDelInterface(String ifName, String prefix, int mark, int mask) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(prefix);     // Catch: Throwable -> L8
                _data.writeInt(mark);     // Catch: Throwable -> L8
                _data.writeInt(mask);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(32, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method wakeupDelInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void setIPv6AddrGenMode(String ifName, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeInt(mode);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(33, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setIPv6AddrGenMode is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void idletimerAddInterface(String ifName, int timeout, String classLabel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeInt(timeout);     // Catch: Throwable -> L8
                _data.writeString(classLabel);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(34, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method idletimerAddInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void idletimerRemoveInterface(String ifName, int timeout, String classLabel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeInt(timeout);     // Catch: Throwable -> L8
                _data.writeString(classLabel);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(35, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method idletimerRemoveInterface is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void strictUidCleartextPenalty(int uid, int policyPenalty) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                _data.writeInt(policyPenalty);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(36, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method strictUidCleartextPenalty is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String clatdStart(String ifName, String nat64Prefix) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(nat64Prefix);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(37, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String _result = _reply.readString();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method clatdStart is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void clatdStop(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(38, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method clatdStop is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean ipfwdEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(39, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method ipfwdEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String[] ipfwdGetRequesterList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(40, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String[] _result = _reply.createStringArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method ipfwdGetRequesterList is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipfwdEnableForwarding(String requester) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(requester);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(41, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipfwdEnableForwarding is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipfwdDisableForwarding(String requester) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(requester);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(42, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipfwdDisableForwarding is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipfwdAddInterfaceForward(String fromIface, String toIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(fromIface);     // Catch: Throwable -> L8
                _data.writeString(toIface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(43, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipfwdAddInterfaceForward is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipfwdRemoveInterfaceForward(String fromIface, String toIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(fromIface);     // Catch: Throwable -> L8
                _data.writeString(toIface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(44, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipfwdRemoveInterfaceForward is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthSetInterfaceQuota(String ifName, long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeLong(bytes);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(45, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthSetInterfaceQuota is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthRemoveInterfaceQuota(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(46, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthRemoveInterfaceQuota is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthSetInterfaceAlert(String ifName, long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeLong(bytes);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(47, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthSetInterfaceAlert is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthRemoveInterfaceAlert(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(48, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthRemoveInterfaceAlert is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthSetGlobalAlert(long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeLong(bytes);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(49, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthSetGlobalAlert is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthAddNaughtyApp(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(50, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthAddNaughtyApp is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthRemoveNaughtyApp(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(51, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthRemoveNaughtyApp is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthAddNiceApp(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(52, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthAddNiceApp is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void bandwidthRemoveNiceApp(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(53, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method bandwidthRemoveNiceApp is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherStart(String[] dhcpRanges) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStringArray(dhcpRanges);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(54, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherStart is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherStop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(55, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherStop is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean tetherIsEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(56, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherIsEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherInterfaceAdd(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(57, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherInterfaceAdd is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherInterfaceRemove(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(58, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherInterfaceRemove is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String[] tetherInterfaceList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(59, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String[] _result = _reply.createStringArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherInterfaceList is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherDnsSet(int netId, String[] dnsAddrs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeStringArray(dnsAddrs);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(60, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherDnsSet is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String[] tetherDnsList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(61, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String[] _result = _reply.createStringArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherDnsList is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddRoute(int netId, String ifName, String destination, String nextHop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(destination);     // Catch: Throwable -> L8
                _data.writeString(nextHop);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(62, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddRoute is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveRoute(int netId, String ifName, String destination, String nextHop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(destination);     // Catch: Throwable -> L8
                _data.writeString(nextHop);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(63, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveRoute is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddLegacyRoute(int netId, String ifName, String destination, String nextHop, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(destination);     // Catch: Throwable -> L8
                _data.writeString(nextHop);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(64, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddLegacyRoute is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveLegacyRoute(int netId, String ifName, String destination, String nextHop, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeString(destination);     // Catch: Throwable -> L8
                _data.writeString(nextHop);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(65, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveLegacyRoute is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public int networkGetDefault() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(66, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method networkGetDefault is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkSetDefault(int netId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(67, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkSetDefault is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkClearDefault() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(68, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkClearDefault is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkSetPermissionForNetwork(int netId, int permission) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeInt(permission);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(69, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkSetPermissionForNetwork is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkSetPermissionForUser(int permission, int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(permission);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(70, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkSetPermissionForUser is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkClearPermissionForUser(int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(71, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkClearPermissionForUser is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void trafficSetNetPermForUids(int permission, int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(permission);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(72, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method trafficSetNetPermForUids is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkSetProtectAllow(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(73, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkSetProtectAllow is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkSetProtectDeny(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(74, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkSetProtectDeny is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public boolean networkCanProtect(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(75, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method networkCanProtect is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallSetFirewallType(int firewalltype) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(firewalltype);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(76, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallSetFirewallType is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallSetInterfaceRule(String ifName, int firewallRule) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeInt(firewallRule);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(77, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallSetInterfaceRule is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallSetUidRule(int childChain, int uid, int firewallRule) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(childChain);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                _data.writeInt(firewallRule);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(78, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallSetUidRule is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallEnableChildChain(int childChain, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(childChain);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(79, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallEnableChildChain is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public String[] interfaceGetList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(80, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String[] _result = _reply.createStringArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method interfaceGetList is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public InterfaceConfigurationParcel interfaceGetCfg(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(81, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                InterfaceConfigurationParcel _result = (InterfaceConfigurationParcel) _reply.readTypedObject(InterfaceConfigurationParcel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method interfaceGetCfg is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceSetCfg(InterfaceConfigurationParcel cfg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(cfg, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(82, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceSetCfg is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceSetIPv6PrivacyExtensions(String ifName, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(83, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceSetIPv6PrivacyExtensions is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceClearAddrs(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(84, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceClearAddrs is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceSetEnableIPv6(String ifName, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(85, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceSetEnableIPv6 is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void interfaceSetMtu(String ifName, int mtu) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeInt(mtu);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(86, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method interfaceSetMtu is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherAddForward(String intIface, String extIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(intIface);     // Catch: Throwable -> L8
                _data.writeString(extIface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(87, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherAddForward is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherRemoveForward(String intIface, String extIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(intIface);     // Catch: Throwable -> L8
                _data.writeString(extIface);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(88, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherRemoveForward is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void setTcpRWmemorySize(String rmemValues, String wmemValues) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(rmemValues);     // Catch: Throwable -> L8
                _data.writeString(wmemValues);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(89, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTcpRWmemorySize is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void registerUnsolicitedEventListener(INetdUnsolicitedEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(90, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method registerUnsolicitedEventListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallAddUidInterfaceRules(String ifName, int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(ifName);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(91, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallAddUidInterfaceRules is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void firewallRemoveUidInterfaceRules(int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeIntArray(uids);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(92, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method firewallRemoveUidInterfaceRules is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void trafficSwapActiveStatsMap() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(93, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method trafficSwapActiveStatsMap is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public IBinder getOemNetd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(94, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IBinder _result = _reply.readStrongBinder();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getOemNetd is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherStartWithConfiguration(TetherConfigParcel config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(config, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(95, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherStartWithConfiguration is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public MarkMaskParcel getFwmarkForNetwork(int netId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(96, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                MarkMaskParcel _result = (MarkMaskParcel) _reply.readTypedObject(MarkMaskParcel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getFwmarkForNetwork is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeTypedObject(routeInfo, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(97, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddRouteParcel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkUpdateRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeTypedObject(routeInfo, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(98, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkUpdateRouteParcel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveRouteParcel(int netId, RouteInfoParcel routeInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                _data.writeTypedObject(routeInfo, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(99, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveRouteParcel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherOffloadRuleAdd(TetherOffloadRuleParcel rule) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(rule, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(100, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherOffloadRuleAdd is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherOffloadRuleRemove(TetherOffloadRuleParcel rule) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(rule, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(101, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherOffloadRuleRemove is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public TetherStatsParcel[] tetherOffloadGetStats() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(102, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                TetherStatsParcel[] _result = (TetherStatsParcel[]) _reply.createTypedArray(TetherStatsParcel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherOffloadGetStats is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void tetherOffloadSetInterfaceQuota(int ifIndex, long quotaBytes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(ifIndex);     // Catch: Throwable -> L8
                _data.writeLong(quotaBytes);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(103, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tetherOffloadSetInterfaceQuota is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public TetherStatsParcel tetherOffloadGetAndClearStats(int ifIndex) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(ifIndex);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(104, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                TetherStatsParcel _result = (TetherStatsParcel) _reply.readTypedObject(TetherStatsParcel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method tetherOffloadGetAndClearStats is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkCreate(NativeNetworkConfig config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(config, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(105, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkCreate is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAddUidRangesParcel(NativeUidRangeConfig uidRangesConfig) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(uidRangesConfig, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(106, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAddUidRangesParcel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkRemoveUidRangesParcel(NativeUidRangeConfig uidRangesConfig) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(uidRangesConfig, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(107, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkRemoveUidRangesParcel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void ipSecMigrate(IpSecMigrateInfoParcel migrateInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(migrateInfo, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(108, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method ipSecMigrate is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void setNetworkAllowlist(NativeUidRangeConfig[] allowedNetworks) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(allowedNetworks, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(109, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setNetworkAllowlist is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public void networkAllowBypassVpnOnNetwork(boolean allow, int uid, int netId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(allow);     // Catch: Throwable -> L8
                _data.writeInt(uid);     // Catch: Throwable -> L8
                _data.writeInt(netId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(110, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method networkAllowBypassVpnOnNetwork is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetd
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(16777215, data, reply, 0);     // Catch: Throwable -> L7
                reply.readException();     // Catch: Throwable -> L7
                this.mCachedVersion = reply.readInt();     // Catch: Throwable -> L7
                reply.recycle();
                data.recycle();
            L7:
                th = move-exception;
                reply.recycle();
                data.recycle();
                throw th;
            L11:
                return this.mCachedVersion;
            }

            @Override // android.net.INetd
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);     // Catch: Throwable -> L10
                reply.readException();     // Catch: Throwable -> L10
                this.mCachedHash = reply.readString();     // Catch: Throwable -> L10
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                goto L13
            L10:
                th = move-exception;
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                throw th;     // Catch: Throwable -> L8
            L13:
                String r0 = this.mCachedHash;     // Catch: Throwable -> L8
                monitor-exit(this);
                return r0;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INetd asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof INetd) == false) goto L12;
            return (INetd) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            if (code < 1) goto L7;
            if (code > 16777215) goto L7;
            data.enforceInterface(descriptor);
        L7:
            if (code != 1598968902) goto L10;
            reply.writeString(descriptor);
            return true;
        L10:
            if (code != 16777215) goto L14;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (code != TRANSACTION_getInterfaceHash) goto L17;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L17:
            switch(code) {
                case 1: goto L129;
                case 2: goto L128;
                case 3: goto L127;
                case 4: goto L126;
                case 5: goto L125;
                case 6: goto L124;
                case 7: goto L123;
                case 8: goto L122;
                case 9: goto L121;
                case 10: goto L120;
                case 11: goto L119;
                case 12: goto L118;
                case 13: goto L117;
                case 14: goto L116;
                case 15: goto L115;
                case 16: goto L114;
                case 17: goto L113;
                case 18: goto L112;
                case 19: goto L111;
                case 20: goto L110;
                case 21: goto L109;
                case 22: goto L108;
                case 23: goto L107;
                case 24: goto L106;
                case 25: goto L105;
                case 26: goto L104;
                case 27: goto L103;
                case 28: goto L102;
                case 29: goto L101;
                case 30: goto L100;
                case 31: goto L99;
                case 32: goto L98;
                case 33: goto L97;
                case 34: goto L96;
                case 35: goto L95;
                case 36: goto L94;
                case 37: goto L93;
                case 38: goto L92;
                case 39: goto L91;
                case 40: goto L90;
                case 41: goto L89;
                case 42: goto L88;
                case 43: goto L87;
                case 44: goto L86;
                case 45: goto L85;
                case 46: goto L84;
                case 47: goto L83;
                case 48: goto L82;
                case 49: goto L81;
                case 50: goto L80;
                case 51: goto L79;
                case 52: goto L78;
                case 53: goto L77;
                case 54: goto L76;
                case 55: goto L75;
                case 56: goto L74;
                case 57: goto L73;
                case 58: goto L72;
                case 59: goto L71;
                case 60: goto L70;
                case 61: goto L69;
                case 62: goto L68;
                case 63: goto L67;
                case 64: goto L66;
                case 65: goto L65;
                case 66: goto L64;
                case 67: goto L63;
                case 68: goto L62;
                case 69: goto L61;
                case 70: goto L60;
                case 71: goto L59;
                case 72: goto L58;
                case 73: goto L57;
                case 74: goto L56;
                case 75: goto L55;
                case 76: goto L54;
                case 77: goto L53;
                case 78: goto L52;
                case 79: goto L51;
                case 80: goto L50;
                case 81: goto L49;
                case 82: goto L48;
                case 83: goto L47;
                case 84: goto L46;
                case 85: goto L45;
                case 86: goto L44;
                case 87: goto L43;
                case 88: goto L42;
                case 89: goto L41;
                case 90: goto L40;
                case 91: goto L39;
                case 92: goto L38;
                case 93: goto L37;
                case 94: goto L36;
                case 95: goto L35;
                case 96: goto L34;
                case 97: goto L33;
                case 98: goto L32;
                case 99: goto L31;
                case 100: goto L30;
                case 101: goto L29;
                case 102: goto L28;
                case 103: goto L27;
                case 104: goto L26;
                case 105: goto L25;
                case 106: goto L24;
                case 107: goto L23;
                case 108: goto L22;
                case 109: goto L21;
                case 110: goto L20;
                default: goto L19;
            };
        L20:
            boolean _arg0 = data.readBoolean();
            int _arg1 = data.readInt();
            int _arg2 = data.readInt();
            networkAllowBypassVpnOnNetwork(_arg0, _arg1, _arg2);
            reply.writeNoException();
            return true;
        L21:
            NativeUidRangeConfig[] _arg3 = (NativeUidRangeConfig[]) data.createTypedArray(NativeUidRangeConfig.CREATOR);
            setNetworkAllowlist(_arg3);
            reply.writeNoException();
            return true;
        L22:
            IpSecMigrateInfoParcel _arg4 = (IpSecMigrateInfoParcel) data.readTypedObject(IpSecMigrateInfoParcel.CREATOR);
            ipSecMigrate(_arg4);
            reply.writeNoException();
            return true;
        L23:
            NativeUidRangeConfig _arg5 = (NativeUidRangeConfig) data.readTypedObject(NativeUidRangeConfig.CREATOR);
            networkRemoveUidRangesParcel(_arg5);
            reply.writeNoException();
            return true;
        L24:
            NativeUidRangeConfig _arg6 = (NativeUidRangeConfig) data.readTypedObject(NativeUidRangeConfig.CREATOR);
            networkAddUidRangesParcel(_arg6);
            reply.writeNoException();
            return true;
        L25:
            NativeNetworkConfig _arg7 = (NativeNetworkConfig) data.readTypedObject(NativeNetworkConfig.CREATOR);
            networkCreate(_arg7);
            reply.writeNoException();
            return true;
        L26:
            int _arg8 = data.readInt();
            TetherStatsParcel _result = tetherOffloadGetAndClearStats(_arg8);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
            return true;
        L27:
            int _arg9 = data.readInt();
            long _arg10 = data.readLong();
            tetherOffloadSetInterfaceQuota(_arg9, _arg10);
            reply.writeNoException();
            return true;
        L28:
            TetherStatsParcel[] _result2 = tetherOffloadGetStats();
            reply.writeNoException();
            reply.writeTypedArray(_result2, 1);
            return true;
        L29:
            TetherOffloadRuleParcel _arg11 = (TetherOffloadRuleParcel) data.readTypedObject(TetherOffloadRuleParcel.CREATOR);
            tetherOffloadRuleRemove(_arg11);
            reply.writeNoException();
            return true;
        L30:
            TetherOffloadRuleParcel _arg12 = (TetherOffloadRuleParcel) data.readTypedObject(TetherOffloadRuleParcel.CREATOR);
            tetherOffloadRuleAdd(_arg12);
            reply.writeNoException();
            return true;
        L31:
            int _arg13 = data.readInt();
            RouteInfoParcel _arg14 = (RouteInfoParcel) data.readTypedObject(RouteInfoParcel.CREATOR);
            networkRemoveRouteParcel(_arg13, _arg14);
            reply.writeNoException();
            return true;
        L32:
            int _arg15 = data.readInt();
            RouteInfoParcel _arg16 = (RouteInfoParcel) data.readTypedObject(RouteInfoParcel.CREATOR);
            networkUpdateRouteParcel(_arg15, _arg16);
            reply.writeNoException();
            return true;
        L33:
            int _arg17 = data.readInt();
            RouteInfoParcel _arg18 = (RouteInfoParcel) data.readTypedObject(RouteInfoParcel.CREATOR);
            networkAddRouteParcel(_arg17, _arg18);
            reply.writeNoException();
            return true;
        L34:
            int _arg19 = data.readInt();
            MarkMaskParcel _result3 = getFwmarkForNetwork(_arg19);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            return true;
        L35:
            TetherConfigParcel _arg20 = (TetherConfigParcel) data.readTypedObject(TetherConfigParcel.CREATOR);
            tetherStartWithConfiguration(_arg20);
            reply.writeNoException();
            return true;
        L36:
            IBinder _result4 = getOemNetd();
            reply.writeNoException();
            reply.writeStrongBinder(_result4);
            return true;
        L37:
            trafficSwapActiveStatsMap();
            reply.writeNoException();
            return true;
        L38:
            int[] _arg21 = data.createIntArray();
            firewallRemoveUidInterfaceRules(_arg21);
            reply.writeNoException();
            return true;
        L39:
            String _arg22 = data.readString();
            int[] _arg23 = data.createIntArray();
            firewallAddUidInterfaceRules(_arg22, _arg23);
            reply.writeNoException();
            return true;
        L40:
            INetdUnsolicitedEventListener _arg24 = INetdUnsolicitedEventListener.Stub.asInterface(data.readStrongBinder());
            registerUnsolicitedEventListener(_arg24);
            reply.writeNoException();
            return true;
        L41:
            String _arg25 = data.readString();
            String _arg26 = data.readString();
            setTcpRWmemorySize(_arg25, _arg26);
            reply.writeNoException();
            return true;
        L42:
            String _arg27 = data.readString();
            String _arg28 = data.readString();
            tetherRemoveForward(_arg27, _arg28);
            reply.writeNoException();
            return true;
        L43:
            String _arg29 = data.readString();
            String _arg30 = data.readString();
            tetherAddForward(_arg29, _arg30);
            reply.writeNoException();
            return true;
        L44:
            String _arg31 = data.readString();
            int _arg32 = data.readInt();
            interfaceSetMtu(_arg31, _arg32);
            reply.writeNoException();
            return true;
        L45:
            String _arg33 = data.readString();
            boolean _arg34 = data.readBoolean();
            interfaceSetEnableIPv6(_arg33, _arg34);
            reply.writeNoException();
            return true;
        L46:
            String _arg35 = data.readString();
            interfaceClearAddrs(_arg35);
            reply.writeNoException();
            return true;
        L47:
            String _arg36 = data.readString();
            boolean _arg37 = data.readBoolean();
            interfaceSetIPv6PrivacyExtensions(_arg36, _arg37);
            reply.writeNoException();
            return true;
        L48:
            InterfaceConfigurationParcel _arg38 = (InterfaceConfigurationParcel) data.readTypedObject(InterfaceConfigurationParcel.CREATOR);
            interfaceSetCfg(_arg38);
            reply.writeNoException();
            return true;
        L49:
            String _arg39 = data.readString();
            InterfaceConfigurationParcel _result5 = interfaceGetCfg(_arg39);
            reply.writeNoException();
            reply.writeTypedObject(_result5, 1);
            return true;
        L50:
            String[] _result6 = interfaceGetList();
            reply.writeNoException();
            reply.writeStringArray(_result6);
            return true;
        L51:
            int _arg40 = data.readInt();
            boolean _arg41 = data.readBoolean();
            firewallEnableChildChain(_arg40, _arg41);
            reply.writeNoException();
            return true;
        L52:
            int _arg42 = data.readInt();
            int _arg43 = data.readInt();
            int _arg44 = data.readInt();
            firewallSetUidRule(_arg42, _arg43, _arg44);
            reply.writeNoException();
            return true;
        L53:
            String _arg45 = data.readString();
            int _arg46 = data.readInt();
            firewallSetInterfaceRule(_arg45, _arg46);
            reply.writeNoException();
            return true;
        L54:
            int _arg47 = data.readInt();
            firewallSetFirewallType(_arg47);
            reply.writeNoException();
            return true;
        L55:
            int _arg48 = data.readInt();
            boolean _result7 = networkCanProtect(_arg48);
            reply.writeNoException();
            reply.writeBoolean(_result7);
            return true;
        L56:
            int _arg49 = data.readInt();
            networkSetProtectDeny(_arg49);
            reply.writeNoException();
            return true;
        L57:
            int _arg50 = data.readInt();
            networkSetProtectAllow(_arg50);
            reply.writeNoException();
            return true;
        L58:
            int _arg51 = data.readInt();
            int[] _arg52 = data.createIntArray();
            trafficSetNetPermForUids(_arg51, _arg52);
            reply.writeNoException();
            return true;
        L59:
            int[] _arg53 = data.createIntArray();
            networkClearPermissionForUser(_arg53);
            reply.writeNoException();
            return true;
        L60:
            int _arg54 = data.readInt();
            int[] _arg55 = data.createIntArray();
            networkSetPermissionForUser(_arg54, _arg55);
            reply.writeNoException();
            return true;
        L61:
            int _arg56 = data.readInt();
            int _arg57 = data.readInt();
            networkSetPermissionForNetwork(_arg56, _arg57);
            reply.writeNoException();
            return true;
        L62:
            networkClearDefault();
            reply.writeNoException();
            return true;
        L63:
            int _arg58 = data.readInt();
            networkSetDefault(_arg58);
            reply.writeNoException();
            return true;
        L64:
            int _result8 = networkGetDefault();
            reply.writeNoException();
            reply.writeInt(_result8);
            return true;
        L65:
            int _arg59 = data.readInt();
            String _arg60 = data.readString();
            String _arg61 = data.readString();
            String _arg62 = data.readString();
            int _arg63 = data.readInt();
            networkRemoveLegacyRoute(_arg59, _arg60, _arg61, _arg62, _arg63);
            reply.writeNoException();
            return true;
        L66:
            int _arg64 = data.readInt();
            String _arg65 = data.readString();
            String _arg66 = data.readString();
            String _arg67 = data.readString();
            int _arg68 = data.readInt();
            networkAddLegacyRoute(_arg64, _arg65, _arg66, _arg67, _arg68);
            reply.writeNoException();
            return true;
        L67:
            int _arg69 = data.readInt();
            String _arg70 = data.readString();
            String _arg71 = data.readString();
            String _arg72 = data.readString();
            networkRemoveRoute(_arg69, _arg70, _arg71, _arg72);
            reply.writeNoException();
            return true;
        L68:
            int _arg73 = data.readInt();
            String _arg74 = data.readString();
            String _arg75 = data.readString();
            String _arg76 = data.readString();
            networkAddRoute(_arg73, _arg74, _arg75, _arg76);
            reply.writeNoException();
            return true;
        L69:
            String[] _result9 = tetherDnsList();
            reply.writeNoException();
            reply.writeStringArray(_result9);
            return true;
        L70:
            int _arg77 = data.readInt();
            String[] _arg78 = data.createStringArray();
            tetherDnsSet(_arg77, _arg78);
            reply.writeNoException();
            return true;
        L71:
            String[] _result10 = tetherInterfaceList();
            reply.writeNoException();
            reply.writeStringArray(_result10);
            return true;
        L72:
            String _arg79 = data.readString();
            tetherInterfaceRemove(_arg79);
            reply.writeNoException();
            return true;
        L73:
            String _arg80 = data.readString();
            tetherInterfaceAdd(_arg80);
            reply.writeNoException();
            return true;
        L74:
            boolean _result11 = tetherIsEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result11);
            return true;
        L75:
            tetherStop();
            reply.writeNoException();
            return true;
        L76:
            String[] _arg81 = data.createStringArray();
            tetherStart(_arg81);
            reply.writeNoException();
            return true;
        L77:
            int _arg82 = data.readInt();
            bandwidthRemoveNiceApp(_arg82);
            reply.writeNoException();
            return true;
        L78:
            int _arg83 = data.readInt();
            bandwidthAddNiceApp(_arg83);
            reply.writeNoException();
            return true;
        L79:
            int _arg84 = data.readInt();
            bandwidthRemoveNaughtyApp(_arg84);
            reply.writeNoException();
            return true;
        L80:
            int _arg85 = data.readInt();
            bandwidthAddNaughtyApp(_arg85);
            reply.writeNoException();
            return true;
        L81:
            long _arg86 = data.readLong();
            bandwidthSetGlobalAlert(_arg86);
            reply.writeNoException();
            return true;
        L82:
            String _arg87 = data.readString();
            bandwidthRemoveInterfaceAlert(_arg87);
            reply.writeNoException();
            return true;
        L83:
            String _arg88 = data.readString();
            long _arg89 = data.readLong();
            bandwidthSetInterfaceAlert(_arg88, _arg89);
            reply.writeNoException();
            return true;
        L84:
            String _arg90 = data.readString();
            bandwidthRemoveInterfaceQuota(_arg90);
            reply.writeNoException();
            return true;
        L85:
            String _arg91 = data.readString();
            long _arg92 = data.readLong();
            bandwidthSetInterfaceQuota(_arg91, _arg92);
            reply.writeNoException();
            return true;
        L86:
            String _arg93 = data.readString();
            String _arg94 = data.readString();
            ipfwdRemoveInterfaceForward(_arg93, _arg94);
            reply.writeNoException();
            return true;
        L87:
            String _arg95 = data.readString();
            String _arg96 = data.readString();
            ipfwdAddInterfaceForward(_arg95, _arg96);
            reply.writeNoException();
            return true;
        L88:
            String _arg97 = data.readString();
            ipfwdDisableForwarding(_arg97);
            reply.writeNoException();
            return true;
        L89:
            String _arg98 = data.readString();
            ipfwdEnableForwarding(_arg98);
            reply.writeNoException();
            return true;
        L90:
            String[] _result12 = ipfwdGetRequesterList();
            reply.writeNoException();
            reply.writeStringArray(_result12);
            return true;
        L91:
            boolean _result13 = ipfwdEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result13);
            return true;
        L92:
            String _arg99 = data.readString();
            clatdStop(_arg99);
            reply.writeNoException();
            return true;
        L93:
            String _arg100 = data.readString();
            String _arg101 = data.readString();
            String _result14 = clatdStart(_arg100, _arg101);
            reply.writeNoException();
            reply.writeString(_result14);
            return true;
        L94:
            int _arg102 = data.readInt();
            int _arg103 = data.readInt();
            strictUidCleartextPenalty(_arg102, _arg103);
            reply.writeNoException();
            return true;
        L95:
            String _arg104 = data.readString();
            int _arg105 = data.readInt();
            String _arg106 = data.readString();
            idletimerRemoveInterface(_arg104, _arg105, _arg106);
            reply.writeNoException();
            return true;
        L96:
            String _arg107 = data.readString();
            int _arg108 = data.readInt();
            String _arg109 = data.readString();
            idletimerAddInterface(_arg107, _arg108, _arg109);
            reply.writeNoException();
            return true;
        L97:
            String _arg110 = data.readString();
            int _arg111 = data.readInt();
            setIPv6AddrGenMode(_arg110, _arg111);
            reply.writeNoException();
            return true;
        L98:
            String _arg112 = data.readString();
            String _arg113 = data.readString();
            int _arg114 = data.readInt();
            int _arg115 = data.readInt();
            wakeupDelInterface(_arg112, _arg113, _arg114, _arg115);
            reply.writeNoException();
            return true;
        L99:
            String _arg116 = data.readString();
            String _arg117 = data.readString();
            int _arg118 = data.readInt();
            int _arg119 = data.readInt();
            wakeupAddInterface(_arg116, _arg117, _arg118, _arg119);
            reply.writeNoException();
            return true;
        L100:
            String _arg120 = data.readString();
            ipSecRemoveTunnelInterface(_arg120);
            reply.writeNoException();
            return true;
        L101:
            String _arg121 = data.readString();
            String _arg122 = data.readString();
            String _arg123 = data.readString();
            int _arg124 = data.readInt();
            int _arg125 = data.readInt();
            int _arg126 = data.readInt();
            ipSecUpdateTunnelInterface(_arg121, _arg122, _arg123, _arg124, _arg125, _arg126);
            reply.writeNoException();
            return true;
        L102:
            String _arg127 = data.readString();
            String _arg128 = data.readString();
            String _arg129 = data.readString();
            int _arg130 = data.readInt();
            int _arg131 = data.readInt();
            int _arg132 = data.readInt();
            ipSecAddTunnelInterface(_arg127, _arg128, _arg129, _arg130, _arg131, _arg132);
            reply.writeNoException();
            return true;
        L103:
            int _arg133 = data.readInt();
            int _arg134 = data.readInt();
            int _arg135 = data.readInt();
            int _arg136 = data.readInt();
            int _arg137 = data.readInt();
            int _arg138 = data.readInt();
            ipSecDeleteSecurityPolicy(_arg133, _arg134, _arg135, _arg136, _arg137, _arg138);
            reply.writeNoException();
            return true;
        L104:
            int _arg139 = data.readInt();
            int _arg140 = data.readInt();
            int _arg141 = data.readInt();
            String _arg142 = data.readString();
            String _arg143 = data.readString();
            int _arg144 = data.readInt();
            int _arg145 = data.readInt();
            int _arg146 = data.readInt();
            int _arg147 = data.readInt();
            ipSecUpdateSecurityPolicy(_arg139, _arg140, _arg141, _arg142, _arg143, _arg144, _arg145, _arg146, _arg147);
            reply.writeNoException();
            return true;
        L105:
            int _arg148 = data.readInt();
            int _arg149 = data.readInt();
            int _arg150 = data.readInt();
            String _arg151 = data.readString();
            String _arg152 = data.readString();
            int _arg153 = data.readInt();
            int _arg154 = data.readInt();
            int _arg155 = data.readInt();
            int _arg156 = data.readInt();
            ipSecAddSecurityPolicy(_arg148, _arg149, _arg150, _arg151, _arg152, _arg153, _arg154, _arg155, _arg156);
            reply.writeNoException();
            return true;
        L106:
            ParcelFileDescriptor _arg157 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            ipSecRemoveTransportModeTransform(_arg157);
            reply.writeNoException();
            return true;
        L107:
            ParcelFileDescriptor _arg158 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            int _arg159 = data.readInt();
            int _arg160 = data.readInt();
            String _arg161 = data.readString();
            String _arg162 = data.readString();
            int _arg163 = data.readInt();
            ipSecApplyTransportModeTransform(_arg158, _arg159, _arg160, _arg161, _arg162, _arg163);
            reply.writeNoException();
            return true;
        L108:
            int _arg164 = data.readInt();
            String _arg165 = data.readString();
            String _arg166 = data.readString();
            int _arg167 = data.readInt();
            int _arg168 = data.readInt();
            int _arg169 = data.readInt();
            int _arg170 = data.readInt();
            ipSecDeleteSecurityAssociation(_arg164, _arg165, _arg166, _arg167, _arg168, _arg169, _arg170);
            reply.writeNoException();
            return true;
        L109:
            int _arg171 = data.readInt();
            int _arg172 = data.readInt();
            String _arg173 = data.readString();
            String _arg174 = data.readString();
            int _arg175 = data.readInt();
            int _arg176 = data.readInt();
            int _arg177 = data.readInt();
            int _arg178 = data.readInt();
            String _arg179 = data.readString();
            byte[] _arg180 = data.createByteArray();
            int _arg181 = data.readInt();
            String _arg182 = data.readString();
            byte[] _arg183 = data.createByteArray();
            int _arg184 = data.readInt();
            String _arg185 = data.readString();
            byte[] _arg186 = data.createByteArray();
            int _arg187 = data.readInt();
            int _arg188 = data.readInt();
            int _arg189 = data.readInt();
            int _arg190 = data.readInt();
            int _arg210 = data.readInt();
            ipSecAddSecurityAssociation(_arg171, _arg172, _arg173, _arg174, _arg175, _arg176, _arg177, _arg178, _arg179, _arg180, _arg181, _arg182, _arg183, _arg184, _arg185, _arg186, _arg187, _arg188, _arg189, _arg190, _arg210);
            reply.writeNoException();
            return true;
        L110:
            int _arg191 = data.readInt();
            String _arg192 = data.readString();
            String _arg193 = data.readString();
            int _arg194 = data.readInt();
            int _result15 = ipSecAllocateSpi(_arg191, _arg192, _arg193, _arg194);
            reply.writeNoException();
            reply.writeInt(_result15);
            return true;
        L111:
            ParcelFileDescriptor _arg195 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            int _arg196 = data.readInt();
            ipSecSetEncapSocketOwner(_arg195, _arg196);
            reply.writeNoException();
            return true;
        L112:
            int _arg197 = data.readInt();
            int _arg198 = data.readInt();
            String _arg199 = data.readString();
            String _arg200 = data.readString();
            String _arg201 = data.readString();
            setProcSysNet(_arg197, _arg198, _arg199, _arg200, _arg201);
            reply.writeNoException();
            return true;
        L113:
            int _arg202 = data.readInt();
            int _arg203 = data.readInt();
            String _arg204 = data.readString();
            String _arg205 = data.readString();
            String _result16 = getProcSysNet(_arg202, _arg203, _arg204, _arg205);
            reply.writeNoException();
            reply.writeString(_result16);
            return true;
        L114:
            String _arg206 = data.readString();
            String _arg207 = data.readString();
            int _arg208 = data.readInt();
            interfaceDelAddress(_arg206, _arg207, _arg208);
            reply.writeNoException();
            return true;
        L115:
            String _arg209 = data.readString();
            String _arg211 = data.readString();
            int _arg212 = data.readInt();
            interfaceAddAddress(_arg209, _arg211, _arg212);
            reply.writeNoException();
            return true;
        L116:
            TetherStatsParcel[] _result17 = tetherGetStats();
            reply.writeNoException();
            reply.writeTypedArray(_result17, 1);
            return true;
        L117:
            boolean _result18 = tetherApplyDnsInterfaces();
            reply.writeNoException();
            reply.writeBoolean(_result18);
            return true;
        L118:
            UidRangeParcel[] _arg213 = (UidRangeParcel[]) data.createTypedArray(UidRangeParcel.CREATOR);
            int[] _arg214 = data.createIntArray();
            socketDestroy(_arg213, _arg214);
            reply.writeNoException();
            return true;
        L119:
            boolean _arg215 = data.readBoolean();
            UidRangeParcel[] _arg216 = (UidRangeParcel[]) data.createTypedArray(UidRangeParcel.CREATOR);
            networkRejectNonSecureVpn(_arg215, _arg216);
            reply.writeNoException();
            return true;
        L120:
            int _arg217 = data.readInt();
            UidRangeParcel[] _arg218 = (UidRangeParcel[]) data.createTypedArray(UidRangeParcel.CREATOR);
            networkRemoveUidRanges(_arg217, _arg218);
            reply.writeNoException();
            return true;
        L121:
            int _arg219 = data.readInt();
            UidRangeParcel[] _arg220 = (UidRangeParcel[]) data.createTypedArray(UidRangeParcel.CREATOR);
            networkAddUidRanges(_arg219, _arg220);
            reply.writeNoException();
            return true;
        L122:
            int _arg221 = data.readInt();
            String _arg222 = data.readString();
            networkRemoveInterface(_arg221, _arg222);
            reply.writeNoException();
            return true;
        L123:
            int _arg223 = data.readInt();
            String _arg224 = data.readString();
            networkAddInterface(_arg223, _arg224);
            reply.writeNoException();
            return true;
        L124:
            int _arg225 = data.readInt();
            networkDestroy(_arg225);
            reply.writeNoException();
            return true;
        L125:
            int _arg226 = data.readInt();
            boolean _arg227 = data.readBoolean();
            networkCreateVpn(_arg226, _arg227);
            reply.writeNoException();
            return true;
        L126:
            int _arg228 = data.readInt();
            int _arg229 = data.readInt();
            networkCreatePhysical(_arg228, _arg229);
            reply.writeNoException();
            return true;
        L127:
            boolean _arg230 = data.readBoolean();
            boolean _result19 = bandwidthEnableDataSaver(_arg230);
            reply.writeNoException();
            reply.writeBoolean(_result19);
            return true;
        L128:
            String _arg231 = data.readString();
            boolean _arg232 = data.readBoolean();
            int[] _arg233 = data.createIntArray();
            boolean _result20 = firewallReplaceUidChain(_arg231, _arg232, _arg233);
            reply.writeNoException();
            reply.writeBoolean(_result20);
            return true;
        L129:
            boolean _result21 = isAlive();
            reply.writeNoException();
            reply.writeBoolean(_result21);
            return true;
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        static {
            DESCRIPTOR = "android$net$INetd".replace('$', '.');
        }
    }

    @Deprecated
    void bandwidthAddNaughtyApp(int r1) throws RemoteException;

    @Deprecated
    void bandwidthAddNiceApp(int r1) throws RemoteException;

    boolean bandwidthEnableDataSaver(boolean r1) throws RemoteException;

    void bandwidthRemoveInterfaceAlert(String r1) throws RemoteException;

    void bandwidthRemoveInterfaceQuota(String r1) throws RemoteException;

    @Deprecated
    void bandwidthRemoveNaughtyApp(int r1) throws RemoteException;

    @Deprecated
    void bandwidthRemoveNiceApp(int r1) throws RemoteException;

    void bandwidthSetGlobalAlert(long r1) throws RemoteException;

    void bandwidthSetInterfaceAlert(String r1, long r2) throws RemoteException;

    void bandwidthSetInterfaceQuota(String r1, long r2) throws RemoteException;

    @Deprecated
    String clatdStart(String r1, String r2) throws RemoteException;

    @Deprecated
    void clatdStop(String r1) throws RemoteException;

    @Deprecated
    void firewallAddUidInterfaceRules(String r1, int[] r2) throws RemoteException;

    @Deprecated
    void firewallEnableChildChain(int r1, boolean r2) throws RemoteException;

    @Deprecated
    void firewallRemoveUidInterfaceRules(int[] r1) throws RemoteException;

    @Deprecated
    boolean firewallReplaceUidChain(String r1, boolean r2, int[] r3) throws RemoteException;

    void firewallSetFirewallType(int r1) throws RemoteException;

    void firewallSetInterfaceRule(String r1, int r2) throws RemoteException;

    @Deprecated
    void firewallSetUidRule(int r1, int r2, int r3) throws RemoteException;

    MarkMaskParcel getFwmarkForNetwork(int r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    IBinder getOemNetd() throws RemoteException;

    String getProcSysNet(int r1, int r2, String r3, String r4) throws RemoteException;

    void idletimerAddInterface(String r1, int r2, String r3) throws RemoteException;

    void idletimerRemoveInterface(String r1, int r2, String r3) throws RemoteException;

    void interfaceAddAddress(String r1, String r2, int r3) throws RemoteException;

    void interfaceClearAddrs(String r1) throws RemoteException;

    void interfaceDelAddress(String r1, String r2, int r3) throws RemoteException;

    InterfaceConfigurationParcel interfaceGetCfg(String r1) throws RemoteException;

    String[] interfaceGetList() throws RemoteException;

    void interfaceSetCfg(InterfaceConfigurationParcel r1) throws RemoteException;

    void interfaceSetEnableIPv6(String r1, boolean r2) throws RemoteException;

    void interfaceSetIPv6PrivacyExtensions(String r1, boolean r2) throws RemoteException;

    void interfaceSetMtu(String r1, int r2) throws RemoteException;

    void ipSecAddSecurityAssociation(int r1, int r2, String r3, String r4, int r5, int r6, int r7, int r8, String r9, byte[] r10, int r11, String r12, byte[] r13, int r14, String r15, byte[] r16, int r17, int r18, int r19, int r20, int r21) throws RemoteException;

    void ipSecAddSecurityPolicy(int r1, int r2, int r3, String r4, String r5, int r6, int r7, int r8, int r9) throws RemoteException;

    void ipSecAddTunnelInterface(String r1, String r2, String r3, int r4, int r5, int r6) throws RemoteException;

    int ipSecAllocateSpi(int r1, String r2, String r3, int r4) throws RemoteException;

    void ipSecApplyTransportModeTransform(ParcelFileDescriptor r1, int r2, int r3, String r4, String r5, int r6) throws RemoteException;

    void ipSecDeleteSecurityAssociation(int r1, String r2, String r3, int r4, int r5, int r6, int r7) throws RemoteException;

    void ipSecDeleteSecurityPolicy(int r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException;

    void ipSecMigrate(IpSecMigrateInfoParcel r1) throws RemoteException;

    void ipSecRemoveTransportModeTransform(ParcelFileDescriptor r1) throws RemoteException;

    void ipSecRemoveTunnelInterface(String r1) throws RemoteException;

    void ipSecSetEncapSocketOwner(ParcelFileDescriptor r1, int r2) throws RemoteException;

    void ipSecUpdateSecurityPolicy(int r1, int r2, int r3, String r4, String r5, int r6, int r7, int r8, int r9) throws RemoteException;

    void ipSecUpdateTunnelInterface(String r1, String r2, String r3, int r4, int r5, int r6) throws RemoteException;

    void ipfwdAddInterfaceForward(String r1, String r2) throws RemoteException;

    void ipfwdDisableForwarding(String r1) throws RemoteException;

    void ipfwdEnableForwarding(String r1) throws RemoteException;

    boolean ipfwdEnabled() throws RemoteException;

    String[] ipfwdGetRequesterList() throws RemoteException;

    void ipfwdRemoveInterfaceForward(String r1, String r2) throws RemoteException;

    boolean isAlive() throws RemoteException;

    void networkAddInterface(int r1, String r2) throws RemoteException;

    void networkAddLegacyRoute(int r1, String r2, String r3, String r4, int r5) throws RemoteException;

    void networkAddRoute(int r1, String r2, String r3, String r4) throws RemoteException;

    void networkAddRouteParcel(int r1, RouteInfoParcel r2) throws RemoteException;

    void networkAddUidRanges(int r1, UidRangeParcel[] r2) throws RemoteException;

    void networkAddUidRangesParcel(NativeUidRangeConfig r1) throws RemoteException;

    void networkAllowBypassVpnOnNetwork(boolean r1, int r2, int r3) throws RemoteException;

    boolean networkCanProtect(int r1) throws RemoteException;

    void networkClearDefault() throws RemoteException;

    void networkClearPermissionForUser(int[] r1) throws RemoteException;

    void networkCreate(NativeNetworkConfig r1) throws RemoteException;

    @Deprecated
    void networkCreatePhysical(int r1, int r2) throws RemoteException;

    @Deprecated
    void networkCreateVpn(int r1, boolean r2) throws RemoteException;

    void networkDestroy(int r1) throws RemoteException;

    int networkGetDefault() throws RemoteException;

    void networkRejectNonSecureVpn(boolean r1, UidRangeParcel[] r2) throws RemoteException;

    void networkRemoveInterface(int r1, String r2) throws RemoteException;

    void networkRemoveLegacyRoute(int r1, String r2, String r3, String r4, int r5) throws RemoteException;

    void networkRemoveRoute(int r1, String r2, String r3, String r4) throws RemoteException;

    void networkRemoveRouteParcel(int r1, RouteInfoParcel r2) throws RemoteException;

    void networkRemoveUidRanges(int r1, UidRangeParcel[] r2) throws RemoteException;

    void networkRemoveUidRangesParcel(NativeUidRangeConfig r1) throws RemoteException;

    void networkSetDefault(int r1) throws RemoteException;

    void networkSetPermissionForNetwork(int r1, int r2) throws RemoteException;

    void networkSetPermissionForUser(int r1, int[] r2) throws RemoteException;

    void networkSetProtectAllow(int r1) throws RemoteException;

    void networkSetProtectDeny(int r1) throws RemoteException;

    void networkUpdateRouteParcel(int r1, RouteInfoParcel r2) throws RemoteException;

    void registerUnsolicitedEventListener(INetdUnsolicitedEventListener r1) throws RemoteException;

    void setIPv6AddrGenMode(String r1, int r2) throws RemoteException;

    void setNetworkAllowlist(NativeUidRangeConfig[] r1) throws RemoteException;

    void setProcSysNet(int r1, int r2, String r3, String r4, String r5) throws RemoteException;

    void setTcpRWmemorySize(String r1, String r2) throws RemoteException;

    void socketDestroy(UidRangeParcel[] r1, int[] r2) throws RemoteException;

    void strictUidCleartextPenalty(int r1, int r2) throws RemoteException;

    void tetherAddForward(String r1, String r2) throws RemoteException;

    boolean tetherApplyDnsInterfaces() throws RemoteException;

    String[] tetherDnsList() throws RemoteException;

    void tetherDnsSet(int r1, String[] r2) throws RemoteException;

    TetherStatsParcel[] tetherGetStats() throws RemoteException;

    void tetherInterfaceAdd(String r1) throws RemoteException;

    String[] tetherInterfaceList() throws RemoteException;

    void tetherInterfaceRemove(String r1) throws RemoteException;

    boolean tetherIsEnabled() throws RemoteException;

    @Deprecated
    TetherStatsParcel tetherOffloadGetAndClearStats(int r1) throws RemoteException;

    @Deprecated
    TetherStatsParcel[] tetherOffloadGetStats() throws RemoteException;

    @Deprecated
    void tetherOffloadRuleAdd(TetherOffloadRuleParcel r1) throws RemoteException;

    @Deprecated
    void tetherOffloadRuleRemove(TetherOffloadRuleParcel r1) throws RemoteException;

    @Deprecated
    void tetherOffloadSetInterfaceQuota(int r1, long r2) throws RemoteException;

    void tetherRemoveForward(String r1, String r2) throws RemoteException;

    void tetherStart(String[] r1) throws RemoteException;

    void tetherStartWithConfiguration(TetherConfigParcel r1) throws RemoteException;

    void tetherStop() throws RemoteException;

    @Deprecated
    void trafficSetNetPermForUids(int r1, int[] r2) throws RemoteException;

    @Deprecated
    void trafficSwapActiveStatsMap() throws RemoteException;

    void wakeupAddInterface(String r1, String r2, int r3, int r4) throws RemoteException;

    void wakeupDelInterface(String r1, String r2, int r3, int r4) throws RemoteException;
}
