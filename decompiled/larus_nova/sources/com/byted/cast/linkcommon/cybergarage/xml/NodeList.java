package com.byted.cast.linkcommon.cybergarage.xml;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class NodeList extends Vector {
    public NodeList() {
    }

    public synchronized Node getEndsWith(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L23;
        monitor-exit(this);
        return null;
    L23:
        int r101 = size();     // Catch: Throwable -> L20
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L18;
        Node r103 = getNode(r102);     // Catch: Throwable -> L20
        String r104 = r103.getName();     // Catch: Throwable -> L20
        if (r104 == null) goto L17;
        if (r104.endsWith(r100) != true) goto L17;
        monitor-exit(this);
        return r103;
    L17:
        r102 = r102 + 1;
        goto L8
    L18:
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized Node getNode(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        int r101 = size();     // Catch: Throwable -> L16
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L14;
        Node r103 = getNode(r102);     // Catch: Throwable -> L16
        if (r100.compareTo(r103.getName()) == 0) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        monitor-exit(this);
        return r103;
    L14:
        monitor-exit(this);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public Node getNode(int r100) {
        if (r100 < size()) goto L5;
        return null;
    L5:
        return (Node) get(r100);
    }
}
