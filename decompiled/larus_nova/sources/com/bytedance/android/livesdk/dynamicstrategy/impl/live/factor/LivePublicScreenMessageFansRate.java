package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LivePublicScreenMessageFansRate extends DynamicFactor<Float> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f123105d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> f123106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f123107c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_message_show_fans_rate";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Float b() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r100 = this.f123106b;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r101 = r100.getValue();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f> r102 = r101.getWaitMessageState();
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f r103 = r102.getValue();
    L10:
        if (r103 != null) goto L12;
    L14:
        float r104 = 0.0f;
    L16:
        return Float.valueOf(r104);
    L12:
        if (r103.f133489b <= 0) goto L14;
        r104 = r103.f133491d;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r100 = this.f123106b;
        if (r100 == null) goto L6;
        r100.c(new LivePublicScreenMessageFansRate$onBind$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r100 = this.f123107c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public LivePublicScreenMessageFansRate(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        com.bytedance.android.livesdk.interactivity.api.h r101 = com.bytedance.android.livesdk.interactivity.api.i.b(r100, 1);
        if (r101 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r102 = r101.getPublicScreenContext();
    L6:
        this.f123106b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
