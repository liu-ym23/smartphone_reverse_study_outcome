package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchRequest extends SSDPRequest {
    public SSDPSearchRequest(ContextManager.CastContext r100) {
        this(r100, "upnp:rootdevice");
    }

    public SSDPSearchRequest(ContextManager.CastContext r100, String r101) {
        this(r100, r101, 3);
    }

    public void setLocalAddress(String r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = SSDP.ADDRESS;
    L6:
        if (HostInterface.isIPv6Address(r100) != true) goto L8;
        r102 = SSDP.getIPv6Address();
    L8:
        setHost(r102, 1900);
        return;
    L4:
        r102 = SSDP.BROADCAST_ADDRESS;
        goto L6
    }

    public SSDPSearchRequest(ContextManager.CastContext r100, String r101, int r102) {
        super(r100);
        setMethod(HTTP.M_SEARCH);
        setURI("*");
        setHeader("ST", r101);
        setHeader(HTTP.MX, Integer.toString(r102));
        setHeader(HTTP.MAN, "\"ssdp:discover\"");
    }
}
