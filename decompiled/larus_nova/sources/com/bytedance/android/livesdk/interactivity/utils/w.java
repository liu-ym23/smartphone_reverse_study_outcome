package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f141423q;

    public w() {
        this.f141423q = "shopping_message";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "statMap");
        r100.put(this.f141423q + this.f141359j, String.valueOf(this.f141352c));
        r100.put(this.f141423q + this.f141360k, "0");
        r100.put(this.f141423q + this.f141361l, String.valueOf(c(this.f141357h, this.f141352c)));
    }
}
