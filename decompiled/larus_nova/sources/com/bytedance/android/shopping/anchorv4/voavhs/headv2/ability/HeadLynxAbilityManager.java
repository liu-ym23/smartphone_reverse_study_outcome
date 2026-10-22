package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HeadLynxAbilityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> f169042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Boolean> f169043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f169044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f169045d;

    public HeadLynxAbilityManager(s r100) {
        Intrinsics.checkNotNullParameter(r100, "headAbilityManager");
        this.f169045d = r100;
        this.f169044c = LazyKt.lazy(HeadLynxAbilityManager$itemViewLynxListener$2.INSTANCE);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> r101 = this.f169042a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c) ((LinkedHashMap) r101).get(r100);
    }

    public final boolean b(com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r100) {
        if (r100 == null) goto L5;
        String r101 = r100.a();
        if (r101 == null) goto L5;
    L6:
        Intrinsics.checkNotNullParameter(r101, "key");
        Map<String, Boolean> r102 = this.f169043b;
        Boolean r103 = null;
        if (r102 == null) goto L9;
        Boolean r104 = (Boolean) ((LinkedHashMap) r102).get(r101);
    L10:
        if (r104 != null) goto L13;
        if (r100 == null) goto L14;
        r103 = Boolean.valueOf(r100.f());
    L14:
        if (r103 != null) goto L18;
        return false;
    L18:
        return r103.booleanValue();
    L13:
        r103 = r104;
        goto L14
    L9:
        r104 = null;
    L5:
        r101 = "";
        goto L6
    }

    public final void c(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 != null) goto L5;
        return;
    L5:
        List r102 = (List) ((Map) this.f169044c.getValue()).get(r100);
        if (r102 != null) goto L8;
        r102 = new ArrayList();
        ((Map) this.f169044c.getValue()).put(r100, r102);
    L8:
        r102.add(r101);
        ECLiveHybridUtil.m(r100, r101);
    }

    public final void d(String r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f169042a != null) goto L5;
        this.f169042a = new LinkedHashMap();
    L5:
        if (r101 == null) goto L10;
        Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> r102 = this.f169042a;
        if (r102 == null) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r103 = r102.put(r100, r101);
        return;
    L11:
        return;
    }

    public final void e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f169043b != null) goto L5;
        this.f169043b = new LinkedHashMap();
    L5:
        Map<String, Boolean> r102 = this.f169043b;
        if (r102 == null) goto L9;
        Boolean r103 = r102.put(r100, Boolean.valueOf(r101));
        return;
    }

    public final void f(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ECLiveHybridUtil.p(r100, r101);
        List r102 = (List) ((Map) this.f169044c.getValue()).get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.remove(r101);
    }
}
