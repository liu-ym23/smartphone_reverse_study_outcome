package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPNotifySocketList extends Vector {
    private InetAddress[] binds;
    protected ContextManager.CastContext mCastContext;

    public boolean open() {
        InetAddress[] r100 = this.binds;
        if (r100 == null) goto L8;
        String[] r101 = new String[r100.length];
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L12;
        r101[r102] = r100[r102].getHostAddress();
        r102 = r102 + 1;
    L12:
        int r103 = 0;
    L14:
        if (r103 >= r101.length) goto L22;
        if (r101[r103] == null) goto L20;
        SSDPNotifySocket r104 = new SSDPNotifySocket(this.mCastContext);
        if (r104.open(r101[r103]) == false) goto L20;
        add(r104);
    L20:
        r103 = r103 + 1;
        goto L14
    L22:
        if (size() == 0) goto L31;
        return true;
    L31:
        return false;
    L8:
        ArrayList<String> r105 = HostInterface.getHostAddresses();
        r101 = new String[r105.size()];
        int r106 = 0;
    L10:
        if (r106 >= r105.size()) goto L12;
        r101[r106] = (String) ListProtector.get(r105, r106);
        r106 = r106 + 1;
        goto L10
    }

    private SSDPNotifySocketList() {
        this.binds = null;
    }

    public void close() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPNotifySocket(r101).close();
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
        getSSDPNotifySocket(r101).start();
        r101 = r101 + 1;
        goto L3
    }

    public void stop() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPNotifySocket(r101).stop();
        r101 = r101 + 1;
        goto L3
    }

    public SSDPNotifySocket getSSDPNotifySocket(int r100) {
        return (SSDPNotifySocket) get(r100);
    }

    public void setControlPoint(ControlPoint r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getSSDPNotifySocket(r102).setControlPoint(r100);
        r102 = r102 + 1;
        goto L3
    }

    public SSDPNotifySocketList(ContextManager.CastContext r100, InetAddress[] r101) {
        this.mCastContext = r100;
        this.binds = r101;
    }
}
