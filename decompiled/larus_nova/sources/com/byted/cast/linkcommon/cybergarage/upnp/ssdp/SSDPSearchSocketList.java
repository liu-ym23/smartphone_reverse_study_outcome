package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchSocketList extends Vector {
    private static final String TAG = "SSDPSearchSocketList";
    private InetAddress[] binds;
    private CastLogger castLogger;
    protected ContextManager.CastContext mCastContext;
    private String multicastIPv4;
    private String multicastIPv6;
    private int port;

    public synchronized void close() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L13
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L10;
        SSDPSearchSocket r102 = getSSDPSearchSocket(r101);     // Catch: Throwable -> L13
        if (r102 == null) goto L9;
        r102.close();     // Catch: Throwable -> L13
    L9:
        r101 = r101 + 1;     // Catch: Throwable -> L13
        goto L4
    L10:
        clear();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized boolean open() {
        monitor-enter(this);
        InetAddress[] r100 = this.binds;     // Catch: Throwable -> L26
        int r101 = 0;
        if (r100 == null) goto L9;
        String[] r102 = new String[r100.length];     // Catch: Throwable -> L26
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L13;
        r102[r103] = r100[r103].getHostAddress();     // Catch: Throwable -> L26
        r103 = r103 + 1;     // Catch: Throwable -> L26
    L13:
        if (r101 >= r102.length) goto L23;
        String r104 = r102[r101];     // Catch: Throwable -> L26
        if (r104 == null) goto L22;
        if (HostInterface.isIPv6Address(r104) == false) goto L20;
        SSDPSearchSocket r105 = new SSDPSearchSocket(this.mCastContext, r102[r101], this.port, this.multicastIPv6);     // Catch: Throwable -> L26
    L21:
        add(r105);     // Catch: Throwable -> L26
        goto L22
    L20:
        r105 = new SSDPSearchSocket(this.mCastContext, r102[r101], this.port, this.multicastIPv4);     // Catch: Throwable -> L26
    L22:
        r101 = r101 + 1;
        goto L13
    L23:
        monitor-exit(this);
        return true;
    L9:
        ArrayList<String> r106 = HostInterface.getHostAddresses();     // Catch: Throwable -> L26
        int r107 = r106.size();     // Catch: Throwable -> L26
        String[] r108 = new String[r107];     // Catch: Throwable -> L26
        int r109 = 0;
    L10:
        if (r109 >= r107) goto L12;
        r108[r109] = (String) ListProtector.get(r106, r109);     // Catch: Throwable -> L26
        r109 = r109 + 1;     // Catch: Throwable -> L26
        goto L10
    L12:
        r102 = r108;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L12
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L10;
        SSDPSearchSocket r102 = getSSDPSearchSocket(r101);     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.start();     // Catch: Throwable -> L12
    L9:
        r101 = r101 + 1;
        goto L4
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L12
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L10;
        SSDPSearchSocket r102 = getSSDPSearchSocket(r101);     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.stop();     // Catch: Throwable -> L12
    L9:
        r101 = r101 + 1;
        goto L4
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private SSDPSearchSocketList() {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        this.multicastIPv6 = SSDP.getIPv6Address();
        this.port = 1900;
    }

    public void addSearchListener(SearchListener r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        SSDPSearchSocket r103 = getSSDPSearchSocket(r102);
        if (r103 == null) goto L8;
        r103.addSearchListener(r100);
    L8:
        r102 = r102 + 1;
        goto L3
    }

    public SSDPSearchSocket getSSDPSearchSocket(int r100) {
        return (SSDPSearchSocket) get(r100);
    L4:
        e = move-exception;
        this.castLogger.e(TAG, e.getMessage());
        return null;
    }

    public SSDPSearchSocketList(ContextManager.CastContext r100, InetAddress[] r101) {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        this.multicastIPv6 = SSDP.getIPv6Address();
        this.port = 1900;
        this.binds = r101;
        this.mCastContext = r100;
        this.castLogger = ContextManager.getLogger(r100);
    }

    public SSDPSearchSocketList(ContextManager.CastContext r100, InetAddress[] r101, int r102, String r103, String r104) {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        SSDP.getIPv6Address();
        this.binds = r101;
        this.port = r102;
        this.multicastIPv4 = r103;
        this.multicastIPv6 = r104;
        this.mCastContext = r100;
        this.castLogger = ContextManager.getLogger(r100);
    }
}
