package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleOrientation f180002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f180003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f180004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f180005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f180006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f180007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BubbleOrientation f180008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f180009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f180010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f180011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f180012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f180013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f180014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f180015n;

    public final Point a() {
        int[] r100 = new int[2];
        this.f180007f.getLocationInWindow(r100);
        return new Point(r100[0] + (this.f180007f.getWidth() / 2), (r100[1] + this.f180007f.getHeight()) - this.f180014m);
    }

    public final Point b() {
        int[] r100 = new int[2];
        this.f180007f.getLocationInWindow(r100);
        return new Point(r100[0] + (this.f180007f.getWidth() / 2), r100[1] - this.f180014m);
    }

    public final Context getContext() {
        return this.f180005d;
    }

    public b(Context r100, View r101, View r102, BubbleOrientation r103, int r110, int r111, int r112, View r113, int r114) {
        if ((r114 & 64) == 0) goto L5;
        r112 = com.bytedance.android.shopping.extensions.b.b(8);
    L5:
        int r104 = 0;
        if ((r114 & 128) == 0) goto L8;
        int r105 = com.bytedance.android.shopping.extensions.b.b(12);
    L10:
        if ((r114 & 256) == 0) goto L12;
        int r106 = com.bytedance.android.shopping.extensions.b.b(8);
    L14:
        if ((r114 & 512) == 0) goto L17;
        r104 = com.bytedance.android.shopping.extensions.b.b(8);
    L17:
        if ((r114 & 1024) == 0) goto L19;
        r113 = null;
    L19:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        Intrinsics.checkNotNullParameter(r102, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "defaultOrientation");
        this.f180005d = r100;
        this.f180006e = r101;
        this.f180007f = r102;
        this.f180008g = r103;
        this.f180009h = r110;
        this.f180010i = r111;
        this.f180011j = r112;
        this.f180012k = r105;
        this.f180013l = r106;
        this.f180014m = r104;
        this.f180015n = r113;
        this.f180002a = r103;
        this.f180003b = new Rect();
        this.f180004c = new Point();
        return;
    L12:
        r106 = 0;
        goto L14
    L8:
        r105 = 0;
        goto L10
    }
}
