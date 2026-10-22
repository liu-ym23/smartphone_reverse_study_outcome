package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f62146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f62147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f62148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Pair<? extends LittleWindowPos, Integer> f62150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f62151h;

    public final void a() {
        View r100 = this.f62148e;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L17;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        int r103 = this.f62145b;
        r102.leftMargin = r103;
        r102.rightMargin = r103;
        if (this.f62149f == false) goto L10;
        r102.topMargin = r103;
        r102.bottomMargin = r103;
    L14:
        r100.setLayoutParams(r102);
        return;
    L10:
        r102.bottomMargin = (this.f62151h + this.f62147d) + this.f62144a;
        if (this.f62150g.getFirst() != LittleWindowPos.TOP) goto L13;
        r102.topMargin = Math.max(this.f62146c, this.f62150g.getSecond().intValue()) + this.f62144a;
        goto L14
    L13:
        r102.topMargin = this.f62146c + this.f62144a;
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i16.c r101 = i16.c.f487996a;
        this.f62144a = MathKt.roundToInt(i16.c.e(r100, 8.0f));
        this.f62145b = MathKt.roundToInt(i16.c.e(r100, 12.0f));
        int r102 = MathKt.roundToInt(i16.c.e(r100, 22.0f));
        this.f62146c = MathKt.roundToInt(i16.c.e(r100, 124.0f));
        this.f62147d = r102;
        this.f62150g = TuplesKt.to(LittleWindowPos.TOP, 0);
    }
}
