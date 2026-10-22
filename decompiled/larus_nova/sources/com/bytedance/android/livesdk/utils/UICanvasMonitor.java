package com.bytedance.android.livesdk.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class UICanvasMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f158805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f158806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f158807c;

    public final ca0.q a() {
        return (ca0.q) this.f158805a.getValue();
    }

    public UICanvasMonitor() {
        this.f158805a = LazyKt.lazy(UICanvasMonitor$monitor$2.INSTANCE);
        this.f158806b = System.currentTimeMillis();
        this.f158807c = "livesdk_rd_revenue_lynx_canvas_metrics";
    }
}
