package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPRequest extends HTTPRequest {
    public int getBootId() {
        return getIntegerHeaderValue(HTTP.BOOTID_UPNP_ORG);
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getHeaderValue(HTTP.CACHE_CONTROL));
    }

    public String getLocation() {
        return getHeaderValue(HTTP.LOCATION);
    }

    public String getNT() {
        return getHeaderValue(HTTP.NT);
    }

    public String getNTS() {
        return getHeaderValue(HTTP.NTS);
    }

    public String getUSN() {
        return getHeaderValue(HTTP.USN);
    }

    public SSDPRequest(ContextManager.CastContext r100) {
        super(r100);
        setVersion("1.1");
    }

    public void setBootId(int r100) {
        setHeader(HTTP.BOOTID_UPNP_ORG, r100);
    }

    public void setLeaseTime(int r100) {
        setHeader(HTTP.CACHE_CONTROL, "max-age=" + Integer.toString(r100));
    }

    public void setLocation(String r100) {
        setHeader(HTTP.LOCATION, r100);
    }

    public void setNT(String r100) {
        setHeader(HTTP.NT, r100);
    }

    public void setNTS(String r100) {
        setHeader(HTTP.NTS, r100);
    }

    public void setPrivateService(int r100) {
        setHeader(HTTP.PRIVATE_SERVICE, r100);
    }

    public void setST(String r100) {
        setHeader("ST", r100);
    }

    public void setUSN(String r100) {
        setHeader(HTTP.USN, r100);
    }

    public SSDPRequest(ContextManager.CastContext r100, InputStream r101) {
        super(r100, r101);
    }
}
