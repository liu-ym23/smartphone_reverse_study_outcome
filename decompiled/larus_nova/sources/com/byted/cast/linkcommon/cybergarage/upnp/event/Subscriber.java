package com.byted.cast.linkcommon.cybergarage.upnp.event;

import java.net.URL;

/* JADX INFO: loaded from: classes28.dex */
public class Subscriber {
    private String SID;
    private String deliveryHost;
    private String deliveryPath;
    private int deliveryPort;
    private String deliveryURL;
    private int dlnaCustomizeVersion;
    private String ifAddr;
    private long notifyCount;
    private long subscriptionTime;
    private long timeOut;

    public void incrementNotifyCount() {
        long r100 = this.notifyCount;
        if (r100 != Long.MAX_VALUE) goto L6;
        this.notifyCount = 1;
        return;
    L6:
        this.notifyCount = r100 + 1;
    }

    public boolean isSupportEncrypt() {
        if (this.dlnaCustomizeVersion < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public Subscriber() {
        this.SID = null;
        this.dlnaCustomizeVersion = 0;
        this.ifAddr = "";
        this.deliveryURL = "";
        this.deliveryHost = "";
        this.deliveryPath = "";
        this.deliveryPort = 0;
        this.timeOut = 0;
        this.subscriptionTime = 0;
        this.notifyCount = 0;
        renew();
    }

    public boolean isExpired() {
        long r100 = System.currentTimeMillis();
        if (this.timeOut != (-1)) goto L6;
        return false;
    L6:
        if ((getSubscriptionTime() + (getTimeOut() * 1000)) >= r100) goto L9;
        return true;
    L9:
        return false;
    }

    public void renew() {
        setSubscriptionTime(System.currentTimeMillis());
        setNotifyCount(0);
    }

    public String getDeliveryHost() {
        return this.deliveryHost;
    }

    public String getDeliveryPath() {
        return this.deliveryPath;
    }

    public int getDeliveryPort() {
        return this.deliveryPort;
    }

    public String getDeliveryURL() {
        return this.deliveryURL;
    }

    public int getDlnaCustomizeVersion() {
        return this.dlnaCustomizeVersion;
    }

    public String getInterfaceAddress() {
        return this.ifAddr;
    }

    public long getNotifyCount() {
        return this.notifyCount;
    }

    public String getSID() {
        return this.SID;
    }

    public long getSubscriptionTime() {
        return this.subscriptionTime;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public void setDeliveryURL(String r100) {
        this.deliveryURL = r100;
        URL r101 = new URL(r100);     // Catch: Exception -> L5
        this.deliveryHost = r101.getHost();     // Catch: Exception -> L5
        this.deliveryPath = r101.getPath();     // Catch: Exception -> L5
        this.deliveryPort = r101.getPort();     // Catch: Exception -> L5
        return;
    }

    public void setDlnaCustomizeVersion(int r100) {
        this.dlnaCustomizeVersion = r100;
    }

    public void setInterfaceAddress(String r100) {
        this.ifAddr = r100;
    }

    public void setNotifyCount(int r100) {
        this.notifyCount = r100;
    }

    public void setSID(String r100) {
        this.SID = r100;
    }

    public void setSubscriptionTime(long r100) {
        this.subscriptionTime = r100;
    }

    public void setTimeOut(long r100) {
        this.timeOut = r100;
    }
}
