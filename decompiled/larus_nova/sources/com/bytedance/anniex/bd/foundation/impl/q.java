package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.salamander.anniex.AnnieXServiceUtilKt;
import com.bytedance.salamander.anniex.j3;
import com.bytedance.salamander.anniex.t1;
import com.bytedance.salamander.anniex.u1;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s<String, h> f190151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Function0<h>> f190152c;

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "storeId");
        this.f190150a = "";
        this.f190152c = com.bytedance.rts.foundation.q.b(new Function0[0]);
        this.f190150a = r100;
        this.f190151b = new s();
        new ConcurrentHashMap();
    }

    public final h a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceId");
        s<String, h> r101 = this.f190151b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceMap");
        r101 = null;
    L5:
        h r102 = r101.f190154a.get(r100);
        if (r102 == null) goto L8;
        return r102;
    L8:
        t1 r103 = (t1) this;
        Intrinsics.checkNotNullParameter(r100, "serviceId");
        String r104 = r103.f190150a;
        int r105 = u1.f268403a;
        if (Intrinsics.areEqual(r104, "AnnieXDefaultServiceStore") == false) goto L12;
        ((j3) AnnieXRuntime.f40276b.getValue()).b();
    L15:
        return null;
    L12:
        if (Intrinsics.areEqual(r103.f190150a, "AnnieXHostServiceStore") == false) goto L14;
        ((j3) AnnieXRuntime.f40276b.getValue()).c();
        goto L15
    L14:
        ((j3) AnnieXRuntime.f40276b.getValue()).a(AnnieXServiceUtilKt.f267860a.invoke(r103.f190150a));
        goto L15
    }
}
