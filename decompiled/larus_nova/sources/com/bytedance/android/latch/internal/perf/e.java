package com.bytedance.android.latch.internal.perf;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f58370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f58371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f58372c;

    public final String toString() {
        return "LatchPerfMetric(metrics=" + this.f58370a + ", category=" + this.f58371b + ", extra=" + this.f58372c + ')';
    }

    public e(JSONObject r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "metrics");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r103, "detailTimestamps");
        this.f58370a = r100;
        this.f58371b = r101;
        this.f58372c = r102;
    }
}
