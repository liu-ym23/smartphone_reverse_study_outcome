package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.FollowImpl;
import com.bytedance.android.live.revlink.impl.pk.ui.MultiOptFrameLayout;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.android.live.revlink.link.domain.anchorimpl.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BackgroundImpl f95128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f95129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FollowImpl f95130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f95131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f95132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f95133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f95134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f95135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f95136i;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.h
    public final void f() {
        View r100 = this.f95135h;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getWidth() > 0) goto L8;
        return;
    L8:
        if (r100.getHeight() <= 0) goto L12;
        int r101 = RevBitmapTranslateUtils.f90807a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.draw(r103);
        wq2.e.a().e(r102);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void g() {
        BackgroundImpl r100 = this.f95128a;
        r100.f95061f = null;
        r100.f95063h.removeAllViews();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final h h() {
        return this.f95131d;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void a(boolean r100) {
        BackgroundImpl r101 = this.f95128a;
        r101.f95062g = r100;
        r101.b();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void d(com.bytedance.android.live.revlink.link.domain.anchorimpl.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f95128a.c(r100);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void j(f31.f r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutStatus");
        BackgroundImpl r101 = this.f95128a;
        RectF r102 = r100.f475331b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "visibleArea");
        r101.f95060e = r102;
        r101.a();
        this.f95134g.d(r100);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable b(String r100, String r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        return this.f95130c.b(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable e(String r100, RevLiveFollowScene r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        return this.f95130c.a(r100, r101, r102, r103);
    }

    public c(Context r100, IRoom r101, DataCenter r102, FrameLayout r103, l r104, WidgetManager r105, View r106, MultiOptFrameLayout r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "containerView");
        Intrinsics.checkNotNullParameter(r104, "windowServiceImpl");
        Intrinsics.checkNotNullParameter(r105, "widgetManager");
        Intrinsics.checkNotNullParameter(r106, "widgetContainerView");
        Intrinsics.checkNotNullParameter(r107, "lynxCentralContainer");
        this.f95132e = r101;
        this.f95133f = r103;
        this.f95134g = r104;
        this.f95135h = r106;
        this.f95136i = r107;
        this.f95128a = new BackgroundImpl(r103, r100);
        this.f95129b = new ArrayList();
        this.f95130c = new FollowImpl(r100);
        this.f95131d = new h(r105);
    }
}
