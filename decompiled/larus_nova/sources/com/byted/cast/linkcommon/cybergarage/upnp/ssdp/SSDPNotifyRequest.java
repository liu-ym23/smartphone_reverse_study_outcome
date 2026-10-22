package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPNotifyRequest extends SSDPRequest {
    public SSDPNotifyRequest(ContextManager.CastContext r100) {
        super(r100);
        setMethod(HTTP.NOTIFY);
        setURI("*");
    }
}
