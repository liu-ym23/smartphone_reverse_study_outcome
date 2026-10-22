package com.bytedance.android.live.browser;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Class<? extends Object>> f62587a = null;

    static {
        f62587a = new ArrayList();
    }

    public static void a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        ArrayList<Class<? extends Object>> r101 = f62587a;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public static void b(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeList");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Class<? extends Object> r102 = (Class) r101.next();
        ArrayList<Class<? extends Object>> r103 = f62587a;
        if (r103.contains(r102) == true) goto L4;
        r103.add(r102);
        goto L4
    }
}
