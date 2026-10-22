package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchResponseSocketList extends Vector {
    private InetAddress[] binds;
    private final ContextManager.CastContext castContext;

    public boolean open() {
        return open(1900);
    }

    public void close() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).close();
        r101 = r101 + 1;
        goto L3
    L5:
        clear();
    }

    public void start() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).start();
        r101 = r101 + 1;
        goto L3
    }

    public void stop() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).stop();
        r101 = r101 + 1;
        goto L3
    }

    public SSDPSearchResponseSocketList(ContextManager.CastContext r100) {
        this.binds = null;
        this.castContext = r100;
    }

    public SSDPSearchResponseSocket getSSDPSearchResponseSocket(int r100) {
        return (SSDPSearchResponseSocket) get(r100);
    }

    public boolean open(int r100) {
        InetAddress[] r101 = this.binds;
        if (r101 == null) goto L8;
        String[] r102 = new String[r101.length];
        int r103 = 0;
    L6:
        if (r103 >= r101.length) goto L12;
        r102[r103] = r101[r103].getHostAddress();
        r103 = r103 + 1;
    L12:
        int r104 = 0;
    L25:
    L23:
        stop();
        close();
        clear();
        return false;
    L14:
        if (r104 >= r102.length) goto L20;
        SSDPSearchResponseSocket r105 = new SSDPSearchResponseSocket(this.castContext);     // Catch: Exception -> L23
        if (r105.open(r102[r104], r100) == false) goto L18;
        add(r105);     // Catch: Exception -> L23
    L18:
        r104 = r104 + 1;
        goto L25
    L20:
        if (size() == 0) goto L32;
        return true;
    L32:
        return false;
    L8:
        ArrayList<String> r106 = HostInterface.getHostAddresses();
        int r107 = r106.size();
        String[] r108 = new String[r107];
        int r109 = 0;
    L9:
        if (r109 >= r107) goto L11;
        r108[r109] = (String) ListProtector.get(r106, r109);
        r109 = r109 + 1;
        goto L9
    L11:
        r102 = r108;
        goto L12
    }

    public void setControlPoint(ControlPoint r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getSSDPSearchResponseSocket(r102).setControlPoint(r100);
        r102 = r102 + 1;
        goto L3
    }

    public SSDPSearchResponseSocketList(InetAddress[] r100, ContextManager.CastContext r101) {
        this.castContext = r101;
        this.binds = r100;
    }

    public boolean post(SSDPSearchRequest r100, boolean r110) {
        int r101 = size();
        int r102 = 0;
        boolean r103 = true;
    L3:
        if (r102 >= r101) goto L18;
        if (r102 >= size()) goto L17;
        SSDPSearchResponseSocket r104 = getSSDPSearchResponseSocket(r102);
        String r105 = r104.getLocalAddress();
        r100.setLocalAddress(r105, r110);
        if (r110 == false) goto L10;
        String r106 = SSDP.ADDRESS;
    L12:
        if (HostInterface.isIPv6Address(r105) != true) goto L15;
        r106 = SSDP.getIPv6Address();
    L15:
        if (r104.post(r106, 1900, r100) == true) goto L17;
        r103 = false;
        goto L17
    L10:
        r106 = SSDP.BROADCAST_ADDRESS;
    L17:
        r102 = r102 + 1;
        goto L3
    L18:
        return r103;
    }

    public void postIpv4(SSDPSearchRequest r100, boolean r101) {
        int r102 = size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        if (r103 >= size()) goto L15;
        SSDPSearchResponseSocket r104 = getSSDPSearchResponseSocket(r103);
        String r105 = r104.getLocalAddress();
        r100.setLocalAddress(r105, r101);
        if (r101 == false) goto L10;
        String r106 = SSDP.ADDRESS;
    L12:
        if (HostInterface.isIPv6Address(r105) == true) goto L15;
        r104.post(r106, 1900, r100);
        goto L15
    L10:
        r106 = SSDP.BROADCAST_ADDRESS;
    L15:
        r103 = r103 + 1;
        goto L3
    }
}
