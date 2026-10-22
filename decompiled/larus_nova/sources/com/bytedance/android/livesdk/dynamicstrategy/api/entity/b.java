package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ju1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f123027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f123028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f123029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f123030e;

    @Override // ju1.h
    public final String d() {
        return "ASTRuleStrategy";
    }

    @Override // ju1.h
    public final boolean f() {
        return true;
    }

    @Override // ju1.h
    public final Object a() {
        return this.f123027b;
    }

    @Override // ju1.h
    public final String b() {
        return this.f123026a;
    }

    @Override // ju1.h
    public final List<String> c() {
        return this.f123029d;
    }

    @Override // ju1.h
    public final List<String> e() {
        return this.f123028c;
    }

    public b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        this.f123030e = r100;
        String r101 = r100.strategyName;
        if (r101 != null) goto L5;
        r101 = "default_strategy_name";
    L5:
        this.f123026a = r101;
        i r102 = r100.defaultResult;
        if (r102 == null) goto L36;
        int r103 = r102.resultType;
        if (r103 != 1) goto L11;
        Object r104 = Long.valueOf(r102.defaultLongValue);
    L35:
        if (r104 == null) goto L36;
    L37:
        this.f123027b = r104;
        List<m> r105 = r100.features;
        if (r105 == null) goto L47;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L41:
        if (r107.hasNext() == false) goto L45;
        String r108 = ((m) r107.next()).name;
        if (r108 == null) goto L41;
        r106.add(r108);
        goto L41
    L45:
        List<String> r109 = CollectionsKt.toList(r106);
        if (r109 == null) goto L47;
    L48:
        this.f123028c = r109;
        this.f123029d = CollectionsKt.emptyList();
        return;
    L47:
        r109 = CollectionsKt.emptyList();
        goto L48
    L11:
        if (r103 != 2) goto L14;
        r104 = Double.valueOf(r102.defaultDoubleValue);
        goto L35
    L14:
        if (r103 != 3) goto L17;
        r104 = r102.defaultStringValue;
        goto L35
    L17:
        if (r103 != 4) goto L20;
        r104 = Boolean.valueOf(r102.defaultBooleanValue);
        goto L35
    L20:
        if (r103 != 5) goto L23;
        r104 = r102.defaultMapValue;
        goto L35
    L23:
        if (r103 != 6) goto L26;
        r104 = r102.defaultLongArrayValue;
        goto L35
    L26:
        if (r103 != 7) goto L29;
        r104 = r102.defaultStringArrayValue;
        goto L35
    L29:
        if (r103 != 8) goto L32;
        r104 = r102.defaultBooleanArrayValue;
        goto L35
    L32:
        if (r103 != 9) goto L34;
        r104 = r102.defaultDoubleArrayValue;
        goto L35
    L34:
        r104 = null;
    L36:
        r104 = 0;
        goto L37
    }
}
