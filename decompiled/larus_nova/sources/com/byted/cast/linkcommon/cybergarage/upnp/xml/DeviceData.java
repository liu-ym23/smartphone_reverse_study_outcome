package com.byted.cast.linkcommon.cybergarage.upnp.xml;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServerList;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServerType;
import com.byted.cast.linkcommon.cybergarage.upnp.device.Advertiser;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDP;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import java.io.File;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes28.dex */
public class DeviceData extends NodeData {
    private Advertiser advertiser;
    private ContextManager.CastContext castContext;
    private ListenerList controlActionListenerList;
    private File descriptionFile;
    private String descriptionURI;
    private InetAddress[] httpBinds;
    private int httpPort;
    private HTTPServerList httpServerList;
    private int leaseTime;
    private String location;
    private InetAddress[] ssdpBinds;
    private String ssdpMulticastIPv4;
    private String ssdpMulticastIPv6;
    private SSDPPacket ssdpPacket;
    private int ssdpPort;
    private SSDPSearchSocketList ssdpSearchSocketList;

    public HTTPServerList getHTTPServerList() {
        if (this.httpServerList != null) goto L6;
        this.httpServerList = new HTTPServerList(this.castContext, this.httpBinds, this.httpPort, HTTPServerType.DLNA_SINK);
    L6:
        return this.httpServerList;
    }

    public SSDPSearchSocketList getSSDPSearchSocketList() {
        if (this.ssdpSearchSocketList != null) goto L6;
        this.ssdpSearchSocketList = new SSDPSearchSocketList(this.castContext, this.ssdpBinds, this.ssdpPort, this.ssdpMulticastIPv4, this.ssdpMulticastIPv6);
    L6:
        return this.ssdpSearchSocketList;
    }

    public Advertiser getAdvertiser() {
        return this.advertiser;
    }

    public ListenerList getControlActionListenerList() {
        return this.controlActionListenerList;
    }

    public File getDescriptionFile() {
        return this.descriptionFile;
    }

    public String getDescriptionURI() {
        return this.descriptionURI;
    }

    public InetAddress[] getHTTPBindAddress() {
        return this.httpBinds;
    }

    public int getHTTPPort() {
        return this.httpPort;
    }

    public int getLeaseTime() {
        return this.leaseTime;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMulticastIPv4Address() {
        return this.ssdpMulticastIPv4;
    }

    public String getMulticastIPv6Address() {
        return this.ssdpMulticastIPv6;
    }

    public InetAddress[] getSSDPBindAddress() {
        return this.ssdpBinds;
    }

    public SSDPPacket getSSDPPacket() {
        return this.ssdpPacket;
    }

    public int getSSDPPort() {
        return this.ssdpPort;
    }

    public DeviceData(ContextManager.CastContext r100) {
        this.descriptionURI = null;
        this.descriptionFile = null;
        this.location = "";
        this.leaseTime = 1800;
        this.httpServerList = null;
        this.httpBinds = null;
        this.httpPort = 4004;
        this.controlActionListenerList = new ListenerList();
        this.ssdpSearchSocketList = null;
        this.ssdpMulticastIPv4 = SSDP.ADDRESS;
        this.ssdpMulticastIPv6 = SSDP.getIPv6Address();
        this.ssdpPort = 1900;
        this.ssdpBinds = null;
        this.ssdpPacket = null;
        this.advertiser = null;
        this.castContext = r100;
    }

    public void setAdvertiser(Advertiser r100) {
        this.advertiser = r100;
    }

    public void setDescriptionFile(File r100) {
        this.descriptionFile = r100;
    }

    public void setDescriptionURI(String r100) {
        this.descriptionURI = r100;
    }

    public void setHTTPBindAddress(InetAddress[] r100) {
        this.httpBinds = r100;
    }

    public void setHTTPPort(int r100) {
        this.httpPort = r100;
    }

    public void setLeaseTime(int r100) {
        this.leaseTime = r100;
    }

    public void setLocation(String r100) {
        this.location = r100;
    }

    public void setMulticastIPv4Address(String r100) {
        this.ssdpMulticastIPv4 = r100;
    }

    public void setMulticastIPv6Address(String r100) {
        this.ssdpMulticastIPv6 = r100;
    }

    public void setSSDPBindAddress(InetAddress[] r100) {
        this.ssdpBinds = r100;
    }

    public void setSSDPPacket(SSDPPacket r100) {
        this.ssdpPacket = r100;
    }

    public void setSSDPPort(int r100) {
        this.ssdpPort = r100;
    }
}
