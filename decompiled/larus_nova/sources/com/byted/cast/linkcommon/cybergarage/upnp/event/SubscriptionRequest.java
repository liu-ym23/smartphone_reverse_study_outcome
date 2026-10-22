package com.byted.cast.linkcommon.cybergarage.upnp.event;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.Device;
import com.byted.cast.linkcommon.cybergarage.upnp.Service;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NT;

/* JADX INFO: loaded from: classes28.dex */
public class SubscriptionRequest extends HTTPRequest {
    private static final String CALLBACK_END_WITH = ">";
    private static final String CALLBACK_START_WITH = "<";

    public String getCallback() {
        return getStringHeaderValue(HTTP.CALLBACK, CALLBACK_START_WITH, CALLBACK_END_WITH);
    }

    public String getNT() {
        return getHeaderValue(HTTP.NT);
    }

    public int getPrivateService() {
        return getIntegerHeaderValue(HTTP.PRIVATE_SERVICE);
    }

    public String getSID() {
        String r100 = Subscription.getSID(getHeaderValue(HTTP.SID));
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public long getTimeout() {
        return Subscription.getTimeout(getHeaderValue("TIMEOUT"));
    }

    public boolean hasCallback() {
        String r100 = getCallback();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        return true;
    }

    public boolean hasNT() {
        String r100 = getNT();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        return true;
    }

    public boolean hasSID() {
        String r100 = getSID();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        return true;
    }

    public SubscriptionResponse post() {
        HTTPResponse r100 = post(getRequestHost(), getRequestPort());
        return new SubscriptionResponse(this.mCastContext, r100);
    }

    public SubscriptionRequest(ContextManager.CastContext r100) {
        super(r100);
        setContentLength(0);
    }

    private void setService(Service r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getEventSubURL();
        setURI(r101, true);
        Device r102 = r100.getDevice();
        if (r102 == null) goto L7;
        String r103 = r102.getURLBase();
    L8:
        if (r103 != null) goto L10;
    L11:
        Device r104 = r100.getRootDevice();
        if (r104 == null) goto L14;
        r103 = r104.getURLBase();
    L14:
        if (r103 != null) goto L16;
    L17:
        Device r105 = r100.getRootDevice();
        if (r105 == null) goto L20;
        r103 = r105.getLocation();
    L20:
        if (r103 == null) goto L24;
        if (r103.length() <= 0) goto L24;
    L26:
        r101 = r103;
    L27:
        String r106 = HTTP.getHost(r101);
        int r107 = HTTP.getPort(r101);
        setHost(r106, r107);
        setRequestHost(r106);
        setRequestPort(r107);
        return;
    L24:
        if (HTTP.isAbsoluteURL(r101) == false) goto L26;
    L16:
        if (r103.length() > 0) goto L20;
    L10:
        if (r103.length() > 0) goto L14;
    L7:
        r103 = "";
        goto L8
    }

    public void post(SubscriptionResponse r100) {
        super.post(r100);
    }

    public void setCallback(String r100) {
        setStringHeader(HTTP.CALLBACK, r100, CALLBACK_START_WITH, CALLBACK_END_WITH);
    }

    public void setNT(String r100) {
        setHeader(HTTP.NT, r100);
    }

    public void setPrivateService(int r100) {
        setHeader(HTTP.PRIVATE_SERVICE, r100);
    }

    public void setSID(String r100) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(r100));
    }

    public final void setTimeout(long r100) {
        setHeader("TIMEOUT", Subscription.toTimeoutHeaderString(r100));
    }

    public void setUnsubscribeRequest(Service r100) {
        setMethod("UNSUBSCRIBE");
        setService(r100);
        setSID(r100.getSID());
    }

    public SubscriptionRequest(ContextManager.CastContext r100, HTTPRequest r101) {
        this(r100);
        set(r101);
    }

    public void setRenewRequest(Service r100, String r101, long r102) {
        setMethod("SUBSCRIBE");
        setService(r100);
        setSID(r101);
        setTimeout(r102);
    }

    public void setSubscribeRequest(Service r100, String r101, long r102) {
        setMethod("SUBSCRIBE");
        setService(r100);
        setCallback(r101);
        setNT(NT.EVENT);
        setTimeout(r102);
    }
}
