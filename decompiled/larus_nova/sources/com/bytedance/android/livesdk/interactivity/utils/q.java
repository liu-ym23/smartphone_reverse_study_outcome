package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f141413q;

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        this.f141413q = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "statMap");
        r100.put(this.f141413q + this.f141359j, String.valueOf(this.f141352c));
        r100.put(this.f141413q + this.f141364o, String.valueOf(c(this.f141355f, this.f141352c)));
        r100.put(this.f141413q + this.f141360k, String.valueOf(c(this.f141356g, this.f141352c)));
        r100.put(this.f141413q + this.f141361l, String.valueOf(c(this.f141357h, this.f141352c)));
        r100.put(this.f141413q + this.f141362m, String.valueOf(this.f141353d));
        r100.put(this.f141413q + this.f141363n, String.valueOf(this.f141354e));
    }
}
