package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f99011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f99012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f99013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f99014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f99015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f99016f;

    public final void d() {
        if (this.f99012b >= 500) goto L6;
        this.f99012b = 500;
        return;
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        this.f99016f = r100;
        this.f99012b = 100;
        this.f99015e = new LinkedHashMap();
    }

    public final void a(Object r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        this.f99011a = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        this.f99014d = r100;
    }

    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f99015e.put(r100, r101);
    }
}
