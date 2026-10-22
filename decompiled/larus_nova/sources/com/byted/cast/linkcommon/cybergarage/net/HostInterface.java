package com.byted.cast.linkcommon.cybergarage.net;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class HostInterface {
    private static final String DUMMY_NETWORK_INTERFACE = "dummy";
    private static final String FIRST_WLAN_NETWORK_INTERFACE = "wlan0";
    public static final int IPV4_BITMASK = 1;
    public static final int IPV6_BITMASK = 16;
    public static final int LOCAL_BITMASK = 256;
    private static final String LO_NETWORK_INTERFACE = "lo";
    private static final String REV_RMNET_NETWORK_INTERFACE = "rev_rmnet";
    private static final String RMNET_DATA_NETWORK_INTERFACE = "rmnet_data";
    private static final String RMNET_NETWORK_INTERFACE = "rmnet";
    private static final String RMNET_USB_NETWORK_INTERFACE = "rmnet_usb";
    private static final String SIT_NETWORK_INTERFACE = "sit";
    public static boolean USE_LOOPBACK_ADDR = false;
    public static boolean USE_ONLY_IPV4_ADDR = false;
    public static boolean USE_ONLY_IPV6_ADDR = false;
    private static final String WLAN_NETWORK_INTERFACE = "wlan";
    private static String ifAddress = "";

    public HostInterface() {
    }

    public static final InetAddress[] getHostAddress() {
        InetAddress[] r100 = new InetAddress[1];
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L23
    L5:
        if (r101.hasMoreElements() == false) goto L25;
        NetworkInterface r102 = r101.nextElement();     // Catch: Exception -> L23
        if (r102 == null) goto L5;
        String r103 = r102.getName();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r103) == true) goto L5;
        if (r103.startsWith(WLAN_NETWORK_INTERFACE) == false) goto L5;
        Enumeration<InetAddress> r104 = r102.getInetAddresses();     // Catch: Exception -> L23
    L17:
        if (r104.hasMoreElements() == false) goto L5;
        InetAddress r105 = r104.nextElement();     // Catch: Exception -> L23
        if (isUsableAddress(r105) == false) goto L17;
        r100[0] = r105;     // Catch: Exception -> L23
        return r100;
    L25:
        return r100;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static ArrayList<InetAddress> getInetAddress() {
        return getInetAddress(false);
    }

    public static final ArrayList<String> getHostAddresses() {
        ArrayList<String> r100 = new ArrayList();
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L17
    L5:
        if (r101.hasMoreElements() == false) goto L19;
        NetworkInterface r102 = r101.nextElement();     // Catch: Exception -> L17
        if (isUsableInterface(r102) == false) goto L5;
        Enumeration<InetAddress> r103 = r102.getInetAddresses();     // Catch: Exception -> L17
    L11:
        if (r103.hasMoreElements() == false) goto L5;
        InetAddress r104 = r103.nextElement();     // Catch: Exception -> L17
        if (isUsableAddress(r104) == false) goto L11;
        r100.add(r104.getHostAddress());     // Catch: Exception -> L17
    L19:
        return r100;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private static final boolean hasAssignedInterface() {
        if (ifAddress.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String getIPv4Address() {
        int r100 = getNHostAddresses();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        String r102 = getHostAddress(r101);
        if (isIPv4Address(r102) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return "";
    }

    public static final String getIPv6Address() {
        int r100 = getNHostAddresses();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        String r102 = getHostAddress(r101);
        if (isIPv6Address(r102) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return "";
    }

    public static final int getNHostAddresses() {
        if (hasAssignedInterface() != true) goto L5;
        return 1;
    L5:
        int r100 = 0;
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
    L8:
        if (r101.hasMoreElements() == false) goto L18;
        Enumeration<InetAddress> r102 = r101.nextElement().getInetAddresses();     // Catch: Exception -> L16
    L11:
        if (r102.hasMoreElements() == false) goto L8;
        if (isUsableAddress(r102.nextElement()) == false) goto L11;
        r100 = r100 + 1;
    L18:
        return r100;
    L16:
        e = move-exception;
        Debug.warning(e);
        goto L18
    }

    public static final boolean hasIPv4Addresses() {
        int r100 = getNHostAddresses();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (isIPv4Address(getHostAddress(r101)) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static final boolean hasIPv6Addresses() {
        int r100 = getNHostAddresses();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (isIPv6Address(getHostAddress(r101)) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static final String getInterface() {
        return ifAddress;
    }

    public static final String getHostAddress(int r100) {
        if (hasAssignedInterface() == true) goto L5;
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L21
        int r102 = 0;
    L8:
        if (r101.hasMoreElements() == false) goto L32;
        Enumeration<InetAddress> r103 = r101.nextElement().getInetAddresses();     // Catch: Exception -> L21
    L11:
        if (r103.hasMoreElements() == false) goto L8;
        InetAddress r104 = r103.nextElement();     // Catch: Exception -> L21
        if (isUsableAddress(r104) == false) goto L11;
        if (r102 >= r100) goto L17;
        r102 = r102 + 1;     // Catch: Exception -> L21
        goto L11
    L17:
        return r104.getHostAddress();
    L32:
        return "";
    L19:
        return "";
    L5:
        return getInterface();
    }

    public static ArrayList<InetAddress> getInetAddress(boolean r100) {
        ArrayList<InetAddress> r101 = new ArrayList();
        Enumeration<NetworkInterface> r102 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L17
    L5:
        if (r102.hasMoreElements() == false) goto L19;
        NetworkInterface r103 = r102.nextElement();     // Catch: Exception -> L17
        if (isUsableInterface(r103) == false) goto L5;
        Enumeration<InetAddress> r104 = r103.getInetAddresses();     // Catch: Exception -> L17
    L11:
        if (r104.hasMoreElements() == false) goto L5;
        InetAddress r105 = r104.nextElement();     // Catch: Exception -> L17
        if (isUsableAddress(r105, r100) == false) goto L11;
        r101.add(r105);     // Catch: Exception -> L17
    L19:
        return r101;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static final boolean isIPv4Address(String r100) {
        if ((InetAddress.getByName(r100) instanceof Inet4Address) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean isIPv6Address(String r100) {
        if ((InetAddress.getByName(r100) instanceof Inet6Address) == false) goto L7;
        return true;
    L7:
        return false;
    }

    private static final boolean isUsableAddress(InetAddress r100) {
        return isUsableAddress(r100, false);
    }

    private static boolean isUsableInterface(NetworkInterface r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getName();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return false;
    L9:
        if (r101.startsWith("dummy") == false) goto L12;
        return false;
    L12:
        if (r101.startsWith(LO_NETWORK_INTERFACE) == false) goto L15;
        return false;
    L15:
        if (r101.startsWith(RMNET_NETWORK_INTERFACE) == false) goto L18;
        return false;
    L18:
        if (r101.startsWith(REV_RMNET_NETWORK_INTERFACE) == false) goto L21;
        return false;
    L21:
        if (r101.startsWith(SIT_NETWORK_INTERFACE) == false) goto L23;
        return false;
    L23:
        return true;
    }

    public static final void setInterface(String r100) {
        ifAddress = r100;
    }

    public static final InetAddress[] getInetAddress(int r100, String[] r101) {
        if (r101 == null) goto L41;
        Vector r102 = new Vector();
        int r103 = 0;
    L6:
        if (r103 >= r101.length) goto L11;
        NetworkInterface r104 = NetworkInterface.getByName(r101[r103]);     // Catch: SocketException -> L38
        if (r104 == null) goto L10;
        r102.add(r104);
    L10:
        r103 = r103 + 1;
        goto L6
    L11:
        Enumeration<NetworkInterface> r105 = r102.elements();
    L13:
        ArrayList r106 = new ArrayList();
    L15:
        if (r105.hasMoreElements() == false) goto L35;
        Enumeration<InetAddress> r107 = r105.nextElement().getInetAddresses();
    L18:
        if (r107.hasMoreElements() == false) goto L15;
        InetAddress r108 = r107.nextElement();
        if ((r100 & 256) != 0) goto L25;
        if (r108.isLoopbackAddress() == true) goto L18;
    L25:
        if ((r100 & 1) == 0) goto L30;
        if ((r108 instanceof Inet4Address) == false) goto L30;
        r106.add(r108);
    L30:
        if ((r100 & 16) == 0) goto L18;
        if ((r108 instanceof InetAddress) == false) goto L18;
        r106.add(r108);
        goto L18
    L35:
        return (InetAddress[]) r106.toArray(new InetAddress[0]);
    L41:
        r105 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L36
    L36:
        return null;
    }

    private static final boolean isUsableAddress(InetAddress r100, boolean r101) {
        if (USE_LOOPBACK_ADDR == true) goto L8;
        if (r100.isLoopbackAddress() == false) goto L8;
        return false;
    L8:
        if (r101 == false) goto L19;
        if ((r100 instanceof Inet6Address) == false) goto L19;
        if (r100.isLinkLocalAddress() == false) goto L19;
        if (TextUtils.isEmpty(r100.getHostAddress()) == true) goto L19;
        if (r100.getHostAddress().contains(FIRST_WLAN_NETWORK_INTERFACE) == false) goto L19;
        return true;
    L19:
        if (USE_ONLY_IPV4_ADDR == false) goto L24;
        if ((r100 instanceof Inet6Address) == false) goto L24;
        return false;
    L24:
        if (USE_ONLY_IPV6_ADDR == true) goto L26;
    L28:
        if (r100 != null) goto L30;
    L33:
        return false;
    L30:
        if (r100.isLinkLocalAddress() == true) goto L33;
        return true;
    L26:
        if ((r100 instanceof Inet4Address) == false) goto L28;
        return false;
    }

    public static final String getHostURL(String r100, int r101, String r102) {
        if (isIPv6Address(r100) != true) goto L6;
        r100 = "[" + r100 + "]";
    L6:
        return "http://" + r100 + ":" + Integer.toString(r101) + r102;
    }
}
