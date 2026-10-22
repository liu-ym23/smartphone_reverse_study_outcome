package com.android.net.module.util;

import android.net.INetd;
import android.net.InterfaceConfigurationParcel;
import android.net.IpPrefix;
import android.net.RouteInfo;
import android.net.RouteInfoParcel;
import android.net.TetherConfigParcel;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.os.SystemClock;
import android.system.OsConstants;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class NetdUtils {
    private static final String TAG = null;

    public static final enum ModifyOperation extends Enum<ModifyOperation> {
        private static final /* synthetic */ ModifyOperation[] $VALUES = null;
        public static final ModifyOperation ADD = null;
        public static final ModifyOperation REMOVE = null;

        private static /* synthetic */ ModifyOperation[] $values() {
            return new ModifyOperation[]{ADD, REMOVE};
        }

        private ModifyOperation(String r1, int r2) {
            super(r1, r2);
        }

        public static ModifyOperation valueOf(String name) {
            return (ModifyOperation) Enum.valueOf(ModifyOperation.class, name);
        }

        public static ModifyOperation[] values() {
            return (ModifyOperation[]) $VALUES.clone();
        }

        static {
            ADD = new ModifyOperation("ADD", 0);
            REMOVE = new ModifyOperation("REMOVE", 1);
            $VALUES = $values();
        }
    }

    public NetdUtils() {
    }

    static {
        TAG = NetdUtils.class.getSimpleName();
    }

    public static InterfaceConfigurationParcel getInterfaceConfigParcel(INetd netd, String iface) {
        return netd.interfaceGetCfg(iface);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static void validateFlag(String flag) {
        if (flag.indexOf(32) >= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("flag contains space: " + flag);
    }

    public static boolean hasFlag(InterfaceConfigurationParcel config, String flag) {
        validateFlag(flag);
        Set<String> flagList = new HashSet(Arrays.asList(config.flags));
        return flagList.contains(flag);
    }

    protected static String[] removeAndAddFlags(String[] flags, String remove, String add) {
        ArrayList<String> result = new ArrayList();
        validateFlag(add);     // Catch: IllegalArgumentException -> L11
        int r1 = flags.length;     // Catch: IllegalArgumentException -> L11
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L14;
        String flag = flags[r2];     // Catch: IllegalArgumentException -> L11
        if (remove.equals(flag) == true) goto L13;
        if (add.equals(flag) == true) goto L13;
        result.add(flag);     // Catch: IllegalArgumentException -> L11
    L13:
        r2 = r2 + 1;     // Catch: IllegalArgumentException -> L11
        goto L4
    L14:
        result.add(add);     // Catch: IllegalArgumentException -> L11
        return (String[]) result.toArray(new String[result.size()]);
    L11:
        iae = move-exception;
        throw new IllegalStateException("Invalid InterfaceConfigurationParcel", iae);
    }

    public static void setInterfaceConfig(INetd netd, InterfaceConfigurationParcel configParcel) {
        netd.interfaceSetCfg(configParcel);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void setInterfaceUp(INetd netd, String iface) {
        InterfaceConfigurationParcel configParcel = getInterfaceConfigParcel(netd, iface);
        configParcel.flags = removeAndAddFlags(configParcel.flags, INetd.IF_STATE_DOWN, INetd.IF_STATE_UP);
        setInterfaceConfig(netd, configParcel);
    }

    public static void setInterfaceDown(INetd netd, String iface) {
        InterfaceConfigurationParcel configParcel = getInterfaceConfigParcel(netd, iface);
        configParcel.flags = removeAndAddFlags(configParcel.flags, INetd.IF_STATE_UP, INetd.IF_STATE_DOWN);
        setInterfaceConfig(netd, configParcel);
    }

    public static void tetherStart(INetd netd, boolean usingLegacyDnsProxy, String[] dhcpRange) throws RemoteException, ServiceSpecificException {
        TetherConfigParcel config = new TetherConfigParcel();
        config.usingLegacyDnsProxy = usingLegacyDnsProxy;
        config.dhcpRanges = dhcpRange;
        netd.tetherStartWithConfiguration(config);
    }

    public static void networkAddInterface(INetd netd, int netId, String iface, int maxAttempts, int pollingIntervalMs) throws ServiceSpecificException, RemoteException {
        int i = 1;
    L3:
        if (i > maxAttempts) goto L14;
        netd.networkAddInterface(netId, iface);     // Catch: ServiceSpecificException -> L6
        return;
    L6:
        e = move-exception;
        if (e.errorCode != OsConstants.EBUSY) goto L11;
        if (i >= maxAttempts) goto L11;
        SystemClock.sleep(pollingIntervalMs);
        i = i + 1;
    L11:
        Log.e(TAG, "Retry Netd#networkAddInterface failure: " + e);
        throw e;
    }

    public static void addRoutesToNetwork(INetd netd, int netId, String iface, List<RouteInfo> routes) {
        Iterator<RouteInfo> r0 = routes.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        RouteInfo route = r0.next();
        if (route.isDefaultRoute() == true) goto L4;
        modifyRoute(netd, ModifyOperation.ADD, netId, route);
        goto L4
    L9:
        modifyRoute(netd, ModifyOperation.ADD, netId, new RouteInfo(new IpPrefix("fe80::/64"), null, iface, 1));
    }

    public static int removeRoutesFromNetwork(INetd netd, int netId, List<RouteInfo> routes) {
        int failures = 0;
        Iterator<RouteInfo> r1 = routes.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        RouteInfo route = r1.next();
        modifyRoute(netd, ModifyOperation.REMOVE, netId, route);     // Catch: IllegalStateException -> L8
    L9:
        failures = failures + 1;
        goto L4
    L11:
        return failures;
    }

    private static String findNextHop(RouteInfo route) {
        switch(route.getType()) {
            case 1: goto L8;
            case 7: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return INetd.NEXTHOP_THROW;
    L6:
        return INetd.NEXTHOP_UNREACHABLE;
    L8:
        if (route.hasGateway() == false) goto L10;
        String nextHop = route.getGateway().getHostAddress();
        return nextHop;
    L10:
        return "";
    }

    public static void modifyRoute(INetd netd, ModifyOperation op, int netId, RouteInfo route) {
        String ifName = route.getInterface();
        String dst = route.getDestination().toString();
        String nextHop = findNextHop(route);
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    L4:
        switch(op.ordinal()) {
            case 0: goto L10;
            case 1: goto L9;
            default: goto L6;
        };     // Catch: Throwable -> L7
    L9:
        netd.networkRemoveRoute(netId, ifName, dst, nextHop);     // Catch: Throwable -> L7
        return;
    L10:
        netd.networkAddRoute(netId, ifName, dst, nextHop);     // Catch: Throwable -> L7
        return;
    L6:
        throw new IllegalStateException("Unsupported modify operation:" + op);     // Catch: Throwable -> L7
    }

    public static RouteInfoParcel toRouteInfoParcel(RouteInfo route) {
        switch(route.getType()) {
            case 1: goto L8;
            case 7: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String nextHop = "";
    L11:
        RouteInfoParcel rip = new RouteInfoParcel();
        rip.ifName = route.getInterface();
        rip.destination = route.getDestination().toString();
        rip.nextHop = nextHop;
        rip.mtu = route.getMtu();
        return rip;
    L5:
        nextHop = INetd.NEXTHOP_THROW;
        goto L11
    L6:
        nextHop = INetd.NEXTHOP_UNREACHABLE;
        goto L11
    L8:
        if (route.hasGateway() == false) goto L10;
        nextHop = route.getGateway().getHostAddress();
        goto L11
    L10:
        nextHop = "";
        goto L11
    }
}
