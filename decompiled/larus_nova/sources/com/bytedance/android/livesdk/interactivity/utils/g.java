package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f141379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f141380r;

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.f141379q = 0;
        this.f141380r = 0;
    }

    public g() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "statMap");
        long r101 = this.f141380r;
        if (r101 <= 0) goto L6;
        r100.put("chat_align_delay_time", String.valueOf(this.f141379q / r101));
        return;
    }
}
