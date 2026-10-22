package com.obric.autoaction.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SurfaceCardActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f25104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<SurfaceCardActivity> f25105b;

    private j() {
    }

    static {
        f25104a = new j();
        f25105b = new WeakReference(null);
    }

    public final SurfaceCardActivity a() {
        return (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(f25105b.get(), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
    }

    public final void a(SurfaceCardActivity r2) {
        f25105b = new WeakReference((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin"));
    }
}
