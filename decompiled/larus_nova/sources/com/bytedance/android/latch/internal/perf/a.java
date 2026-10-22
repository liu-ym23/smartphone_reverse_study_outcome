package com.bytedance.android.latch.internal.perf;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f58348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f58349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f58350c;

    public a(JSONObject r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f58348a = r100;
        this.f58349b = r101;
        this.f58350c = r102;
    }
}
