package com.byted.cast.linkcommon.cybergarage.upnp.event;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.UPnP;

/* JADX INFO: loaded from: classes28.dex */
public class SubscriptionResponse extends HTTPResponse {
    public String getSID() {
        return Subscription.getSID(getHeaderValue(HTTP.SID));
    }

    public long getTimeout() {
        return Subscription.getTimeout(getHeaderValue("TIMEOUT"));
    }

    public SubscriptionResponse(ContextManager.CastContext r100) {
        super(r100);
        setServer(UPnP.getServerName());
    }

    public void setErrorResponse(int r100) {
        setStatusCode(r100);
        setContentLength(0);
    }

    public void setResponse(int r100) {
        setStatusCode(r100);
        setContentLength(0);
    }

    public void setSID(String r100) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(r100));
    }

    public void setTimeout(long r100) {
        setHeader("TIMEOUT", Subscription.toTimeoutHeaderString(r100));
    }

    public SubscriptionResponse(ContextManager.CastContext r100, HTTPResponse r101) {
        super(r100, r101);
    }
}
