package com.bytedance.android.live.recharge.utils;

import am2.x;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> f90457a = null;

    static {
        f90457a = new HashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        mz0.n r101 = new mz0.n();
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r103 = com.bytedance.android.scope.m.b(r102).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r103);
        ((mz0.i) ((f80.a) r103)).w3(r100, r101.f516447a, r101.f516448b);
    }

    public static void c(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        mz0.n r102 = new mz0.n();
        Map<String, String> r103 = r102.f516447a;
        Intrinsics.checkNotNullParameter(r103, "map");
        Intrinsics.checkNotNullParameter(r101, "map");
        r103.putAll(r101);
        cy0.e.f465759a.getClass();
        cy0.j r104 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r105 = com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r105);
        ((mz0.i) ((f80.a) r105)).w3(r100, r102.f516447a, r102.f516448b);
    }

    public static void a(Map r100, Set r101, Class r102) {
        com.bytedance.android.livesdk.revenue.log.d<?> r103 = f90457a.get(r102);
        if (r103 == null) goto L7;
        r103.a(r100);
        return;
    L7:
        if (Intrinsics.areEqual(r102, IRoom.class) == false) goto L10;
        LogCommon r104 = LogCommon.ROOM;
    L13:
        if (r104 == null) goto L17;
        r101.add(r104);
        return;
    L17:
        throw new IllegalArgumentException("Unidentified filter class " + r102);
    L10:
        if (Intrinsics.areEqual(r102, x.class) == false) goto L12;
        r104 = LogCommon.PAGE_SOURCE_LOG;
        goto L13
    L12:
        r104 = null;
        goto L13
    }

    public static void d(String r100, Map r101, Class... r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "logClasses");
        LinkedHashMap r103 = new LinkedHashMap();
        LinkedHashSet r104 = new LinkedHashSet();
        int r105 = r102.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        a(r103, r104, r102[r106]);
        r106 = r106 + 1;
        goto L3
    L5:
        if (r101 == null) goto L7;
        r103.putAll(r101);
    L7:
        mz0.n r107 = new mz0.n();
        Map<String, String> r108 = r107.f516447a;
        Intrinsics.checkNotNullParameter(r108, "map");
        Intrinsics.checkNotNullParameter(r103, "map");
        r108.putAll(r103);
        mz0.m r109 = new mz0.m();
        Iterator r110 = r104.iterator();
    L9:
        if (r110.hasNext() == false) goto L11;
        r109.b((LogCommon) r110.next());
        goto L9
    L11:
        List<Object> r111 = r107.f516448b;
        ArrayList r112 = (ArrayList) r111;
        r112.addAll(r109.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r113 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r114);
        ((mz0.i) ((f80.a) r114)).w3(r100, r107.f516447a, r107.f516448b);
    }
}
