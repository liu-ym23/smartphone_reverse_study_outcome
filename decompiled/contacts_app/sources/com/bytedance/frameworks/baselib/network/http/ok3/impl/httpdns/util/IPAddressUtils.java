package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class IPAddressUtils {
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = null;
    private static final Pattern IPV6_STD_PATTERN = null;
    private static Pattern ipv4Pattern;

    public IPAddressUtils() {
    }

    static {
        ipv4Pattern = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean isIpv6StdAddress(String r1) {
        return IPV6_STD_PATTERN.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean isIpv6HexCompressedAddress(String r1) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean isValidIpv6(String r1) {
        if (isIpv6StdAddress(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isIpv6HexCompressedAddress(r1) == true) goto L8;
        return false;
    }

    public static boolean isValidIpv4(String r9) {
        if (r9 != null) goto L46;
        return false;
    L46:
        if (r9.length() >= 7) goto L8;
        return false;
    L8:
        if (r9.length() <= 15) goto L10;
        return false;
    L10:
        if (r9.equals("") == true) goto L51;
        if (ipv4Pattern.matcher(r9).matches() == true) goto L53;
        return false;
    L53:
        return true;
    L51:
        return false;
    L44:
        int r3 = r9.indexOf(46);     // Catch: Exception -> L43
        if (r3 != (-1)) goto L18;
        return false;
    L18:
        if (r9.charAt(0) != '-') goto L20;
        return false;
    L20:
        if (Integer.parseInt(r9.substring(0, r3)) > 255) goto L56;
        int r4 = r3 + 1;     // Catch: Exception -> L43
        int r5 = r9.indexOf(46, r4);     // Catch: Exception -> L43
        if (r5 != (-1)) goto L25;
        return false;
    L25:
        if (r9.charAt(r4) != '-') goto L27;
        return false;
    L27:
        if (Integer.parseInt(r9.substring(r4, r5)) > 255) goto L59;
        int r6 = r5 + 1;     // Catch: Exception -> L43
        int r7 = r9.indexOf(46, r6);     // Catch: Exception -> L43
        if (r7 != (-1)) goto L32;
        return false;
    L32:
        if (r9.charAt(r6) != '-') goto L34;
        return false;
    L34:
        if (Integer.parseInt(r9.substring(r6, r7)) > 255) goto L62;
        int r8 = r7 + 1;     // Catch: Exception -> L43
        if (r9.charAt(r8) != '-') goto L38;
        return false;
    L38:
        if (Integer.parseInt(r9.substring(r8, r9.length())) > 255) goto L64;
        if (r9.charAt(r9.length() - 1) != '.') goto L42;
        return false;
    L42:
        return true;
    L64:
        return false;
    L62:
        return false;
    L59:
        return false;
    L56:
        return false;
    L66:
        return false;
    }
}
