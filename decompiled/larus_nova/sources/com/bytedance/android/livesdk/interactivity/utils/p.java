package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f141405q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f141406r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f141407s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f141408t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f141409u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f141410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f141411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f141412x;

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.f141405q = 0;
        this.f141406r = 0;
        this.f141407s = 0;
        this.f141408t = 0;
        this.f141409u = 0;
        this.f141410v = 0;
        this.f141411w = 0;
        this.f141412x = 0;
    }

    public p() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "statMap");
        r100.put("high_priority_action_number", String.valueOf(this.f141405q));
        r100.put("medium_priority_action_number", String.valueOf(this.f141406r));
        r100.put("low_priority_action_number", String.valueOf(this.f141407s));
        r100.put("base_action_number", String.valueOf(this.f141408t));
        r100.put("comment_action_number", String.valueOf(this.f141409u));
        r100.put("send_gift_action_number", String.valueOf(this.f141410v));
        r100.put("order_action_number", String.valueOf(this.f141411w));
        r100.put("other_action_number", String.valueOf(this.f141412x));
    }
}
