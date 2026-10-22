package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: loaded from: classes28.dex */
public class SSDP {
    public static final String ADDRESS = "239.255.255.250";
    public static final String BDLINK_ADDRESS = "239.250.250.250";
    public static final String BROADCAST_ADDRESS = "255.255.255.255";
    public static final int DEFAULT_MSEARCH_MX = 3;
    private static String IPV6_ADDRESS = null;
    public static final String IPV6_ADMINISTRATIVE_ADDRESS = "FF04::C";
    public static final String IPV6_GLOBAL_ADDRESS = "FF0E::C";
    public static final String IPV6_LINK_LOCAL_ADDRESS = "FF02::C";
    public static final String IPV6_SITE_LOCAL_ADDRESS = "FF05::C";
    public static final String IPV6_SUBNET_ADDRESS = "FF03::C";
    public static final int PORT = 1900;
    public static final int RECV_MESSAGE_BUFSIZE = 1024;
    public static final int RECV_MESSAGE_BUFSIZE_LAGER = 2048;

    public SSDP() {
    }

    static {
        setIPv6Address(IPV6_LINK_LOCAL_ADDRESS);
    }

    public static final String getIPv6Address() {
        return IPV6_ADDRESS;
    }

    public static final int getLeaseTime(String r100) {
        int r101 = r100.indexOf(HTTP.MAX_AGE);
        if (r101 < 0) goto L11;
        int r102 = r100.indexOf(44, r101);
        if (r102 >= 0) goto L13;
        r102 = r100.length();
    L13:
        return CastIntegerProtector.parseInt(r100.substring(r100.indexOf(ContainerUtils.KEY_VALUE_DELIMITER, r101) + 1, r102).trim());
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    }

    public static final void setIPv6Address(String r100) {
        IPV6_ADDRESS = r100;
    }
}
