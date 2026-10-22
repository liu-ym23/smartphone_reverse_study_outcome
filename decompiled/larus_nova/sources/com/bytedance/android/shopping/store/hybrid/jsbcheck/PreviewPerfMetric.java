package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/PreviewPerfMetric;", "", "()V", "cpuUsage", "Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/CPUUsage;", "getCpuUsage", "()Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/CPUUsage;", "fps", "Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/FPS;", "getFps", "()Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/FPS;", PrefetchTiming.JSB, "Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/JSB;", "getJsb", "()Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/JSB;", "perfDuration", "", "getPerfDuration", "()Ljava/lang/Integer;", "setPerfDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPerfMetric {
    private final CPUUsage cpuUsage;
    private final FPS fps;

    /* JADX INFO: renamed from: jsb, reason: collision with root package name */
    private final JSB f184856jsb;
    private Integer perfDuration;

    public PreviewPerfMetric() {
        this.cpuUsage = new CPUUsage();
        this.fps = new FPS();
        this.f184856jsb = new JSB();
    }

    public final CPUUsage getCpuUsage() {
        return this.cpuUsage;
    }

    public final FPS getFps() {
        return this.fps;
    }

    public final JSB getJsb() {
        return this.f184856jsb;
    }

    public final Integer getPerfDuration() {
        return this.perfDuration;
    }

    public final void setPerfDuration(Integer r100) {
        this.perfDuration = r100;
    }
}
