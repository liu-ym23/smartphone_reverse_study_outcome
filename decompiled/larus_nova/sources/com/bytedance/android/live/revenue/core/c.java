package com.bytedance.android.live.revenue.core;

import com.bytedance.android.scope.l;
import e33.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.e f91022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rh6.b f91023b;

    public final void a() {
        if (l.b(this.f91023b) == false) goto L5;
        List<rh6.a> r100 = f.f91029a;
        ArrayList r101 = (ArrayList) r100;
        r101.remove(this.f91023b);
        l.c(this.f91023b);
    L5:
        ((LinkedHashMap) this.f91022a.f255140a).clear();
    }

    public c() {
        com.bytedance.live.kmp.core.e r100 = new com.bytedance.live.kmp.core.e();
        this.f91022a = r100;
        cy0.e.f465759a.getClass();
        rh6.b r101 = new rh6.b(cy0.e.a.f465760a);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f537788e = r100;
        if (r100 != k.f470908a) goto L5;
        String r102 = "previewDependencyResolver";
    L6:
        if (r102 != null) goto L10;
        this.f91023b = r101;
        return;
    L10:
        throw new UninitializedPropertyAccessException(r102);
    L5:
        r102 = null;
        goto L6
    }
}
