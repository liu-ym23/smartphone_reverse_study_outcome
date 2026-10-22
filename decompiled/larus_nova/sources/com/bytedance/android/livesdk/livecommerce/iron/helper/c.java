package com.bytedance.android.livesdk.livecommerce.iron.helper;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f148636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Pair<String, String>> f148637b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f148636a = new LinkedHashMap();
        this.f148637b = new LinkedHashMap();
    }

    public static void c(String r100, Pair r101) {
        sg2.v r102 = new sg2.v("schema_report", com.bytedance.android.ec.common.api.jump.model.b.f42853a);
        r102.c("location", (String) r101.getFirst());
        r102.c("business", "live_purchase_refactor");
        r102.c("in_schema", r100);
        r102.c("out_schema", (String) r101.getSecond());
        r102.i(null);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        if (this.f148637b.containsKey(r100) == false) goto L7;
        Pair<String, String> r102 = this.f148637b.remove(r100);
        if (r102 == null) goto L9;
        c(r101, r102);
        return;
    L9:
        return;
    L7:
        this.f148636a.put(r100, r101);
    }

    public final void b(String r100, Pair<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (this.f148636a.containsKey(r100) == false) goto L7;
        String r102 = this.f148636a.remove(r100);
        if (r102 == null) goto L9;
        c(r102, r101);
        return;
    L9:
        return;
    L7:
        this.f148637b.put(r100, r101);
    }
}
