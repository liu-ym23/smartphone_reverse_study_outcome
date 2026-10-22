package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveDanmakuHotRate extends DynamicFactor<Float> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f123092d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> f123093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f123094c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_danmaku_hot_rate";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Float b() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r100 = this.f123093b;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r101 = r100.getValue();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> r102 = r101.getWaitMessageState();
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a r103 = r102.getValue();
    L10:
        if (r103 != null) goto L12;
    L14:
        float r104 = 0.0f;
    L16:
        return Float.valueOf(r104);
    L12:
        if (r103.f133480a <= 0) goto L14;
        r104 = r103.f133481b;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r100 = this.f123093b;
        if (r100 == null) goto L6;
        r100.c(new LiveDanmakuHotRate$onBind$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r100 = this.f123094c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public LiveDanmakuHotRate(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        com.bytedance.android.livesdk.interactivity.api.h r101 = com.bytedance.android.livesdk.interactivity.api.i.b(r100, 1);
        if (r101 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r102 = r101.getBarrageContext();
    L6:
        this.f123093b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
