package com.bytedance.android.live.core.tetris.layer.core.layout;

import j70.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65786a = 0;

    static {
    }

    public static boolean a(Map r100, f r101, f r102) {
        List r103 = (List) ((LinkedHashMap) r100).get(r101);
        if (r103 != null) goto L6;
        return false;
    L6:
        if (r103.contains(r102) == false) goto L8;
        return true;
    L8:
        Iterator r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        if (a(r100, (f) r104.next(), r102) == false) goto L10;
        return true;
    L14:
        return false;
    }

    public static void c(Map r100, Map r101, f r102) {
        LinkedHashMap r103 = (LinkedHashMap) r101;
        Integer r104 = (Integer) r103.get(r102);
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L7:
        if (r101.containsKey(r102) == true) goto L9;
        r101.put(r102, Integer.valueOf(r105));
    L9:
        List r106 = (List) ((LinkedHashMap) r100).get(r102);
        if (r106 == null) goto L20;
        Iterator r107 = r106.iterator();
    L13:
        if (r107.hasNext() == false) goto L29;
        f r108 = (f) r107.next();
        if (r101.containsKey(r108) == true) goto L16;
        r101.put(r108, Integer.valueOf(r105 + 1));
        c(r100, r101, r108);
        goto L13
    L16:
        Object r109 = r103.get(r108);
        Intrinsics.checkNotNull(r109);
        if (r105 < ((Number) r109).intValue()) goto L13;
        r101.put(r108, Integer.valueOf(r105 + 1));
        c(r100, r101, r108);
        goto L13
    L29:
        return;
    L20:
        return;
    L5:
        r105 = 0;
        goto L7
    }

    public static void b(Map r100, Map r101, f r102, f r103) throws CircleDependException {
        if (a(r100, r103, r102) == true) goto L16;
        if (a(r100, r102, r103) == false) goto L8;
        return;
    L8:
        if (r100.containsKey(r102) == true) goto L10;
        r100.put(r102, new ArrayList());
    L10:
        List r104 = (List) ((LinkedHashMap) r100).get(r102);
        if (r104 == null) goto L13;
        r104.add(r103);
    L13:
        c(r100, r101, r102);
        return;
    L16:
        throw new CircleDependException("发现了循环依赖");
    }
}
