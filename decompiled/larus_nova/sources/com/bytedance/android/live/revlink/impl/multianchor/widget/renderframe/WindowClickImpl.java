package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class WindowClickImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f95260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f95261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f95262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f95263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f95264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f95265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f95266g;

    public WindowClickImpl(FrameLayout r100, p r101, Context r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "renderState");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "selfLinkerID");
        this.f95264e = r100;
        this.f95265f = r101;
        this.f95266g = r102;
        this.f95261b = r101.f98444a;
        this.f95262c = LazyKt.lazy(WindowClickImpl$anchorRegionRect$2.INSTANCE);
        this.f95263d = LazyKt.lazy(new WindowClickImpl$anchorRegionGestureDetector$2(this));
    }
}
