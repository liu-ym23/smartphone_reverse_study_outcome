package com.bytedance.android.monitorV2.lynx.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f163176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f163177b;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        sz2.a r101 = sz2.a.f543906a;
        this.f163176a = sz2.a.a(r100);
        this.f163177b = sz2.a.c(r100);
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.f163177b.get(r100);
        if ((r101 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r101;
    }
}
