package com.bytedance.android.live.revlink.impl.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, Integer> f97678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, Integer> f97679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, Integer> f97680c;

    public w() {
        this.f97678a = new HashMap();
        this.f97679b = new HashMap();
        this.f97680c = new HashMap();
    }

    public static int a(Map r100) {
        HashMap r101 = (HashMap) r100;
        Iterator r102 = r101.keySet().iterator();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L14;
        int r105 = ((Number) r102.next()).intValue();
        Integer r106 = (Integer) r101.get(Integer.valueOf(r105));
        if (r106 == null) goto L8;
        int r107 = r106.intValue();
    L9:
        r103 = r103 + r107;
        Integer r108 = (Integer) r101.get(Integer.valueOf(r105));
        if (r108 == null) goto L12;
        int r109 = r108.intValue();
    L13:
        r104 = r104 + (r105 * r109);
        goto L4
    L12:
        r109 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    L14:
        if (r103 != 0) goto L17;
        return 0;
    L17:
        return r104 / r103;
    }
}
