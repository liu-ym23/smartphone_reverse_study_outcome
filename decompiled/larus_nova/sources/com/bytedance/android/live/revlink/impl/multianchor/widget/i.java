package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements com.bytedance.android.live.revlink.link.domain.anchorimpl.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWidget f95182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f95183b;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.l
    public final void a() {
        com.bytedance.android.live.core.performance.a r100 = com.bytedance.android.live.core.performance.a.f65108a;
        TimeCostUtil.Tag r101 = TimeCostUtil.Tag.LivePk;
        r101.name();
        this.f95182a.getLifecycle();
        Context r102 = this.f95182a.context;
        r100.getClass();
        r101.name();
        this.f95182a.getLifecycle();
        Context r103 = this.f95182a.context;
        r100.getClass();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.l
    public final void b() {
        com.bytedance.android.live.core.performance.a r100 = com.bytedance.android.live.core.performance.a.f65108a;
        TimeCostUtil.Tag.LivePk.name();
        TimeCostUtil.a("isAnchor", String.valueOf(this.f95183b));
        r100.getClass();
    }

    public i(LiveWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f95182a = r100;
        this.f95183b = true;
    }
}
