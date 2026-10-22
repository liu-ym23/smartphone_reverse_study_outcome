package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.UPnP;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchResponse extends SSDPResponse {
    public SSDPSearchResponse(ContextManager.CastContext r100) {
        super(r100);
        setStatusCode(200);
        setCacheControl(1800);
        setHeader(HTTP.SERVER, UPnP.getServerName());
        setHeader(HTTP.EXT, "");
    }
}
