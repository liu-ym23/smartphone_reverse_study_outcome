package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPResponse extends HTTPResponse {
    public int getBootId() {
        return getIntegerHeaderValue(HTTP.BOOTID_UPNP_ORG);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPResponse
    public String getHeader() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getStatusLineString());
        r100.append(getHeaderString());
        r100.append("\r\n");
        return r100.toString();
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getHeaderValue(HTTP.CACHE_CONTROL));
    }

    public String getLocation() {
        return getHeaderValue(HTTP.LOCATION);
    }

    public String getMYNAME() {
        return getHeaderValue(HTTP.MYNAME);
    }

    public String getST() {
        return getHeaderValue("ST");
    }

    public String getUSN() {
        return getHeaderValue(HTTP.USN);
    }

    public SSDPResponse(ContextManager.CastContext r100) {
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

    public void setMYNAME(String r100) {
        setHeader(HTTP.MYNAME, r100);
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

    public SSDPResponse(ContextManager.CastContext r100, InputStream r101) {
        super(r100, r101);
    }
}
