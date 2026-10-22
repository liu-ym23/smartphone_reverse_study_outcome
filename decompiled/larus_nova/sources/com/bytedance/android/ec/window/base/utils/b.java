package com.bytedance.android.ec.window.base.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f49717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f49718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f49719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f49720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f49721e;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        float r101 = Math.min(Math.min(r100.getWidth(), r100.getHeight()) / 2, this.f49717a);
        float r102 = this.f49718b;
        float r103 = 0;
        if (r102 <= r103) goto L5;
    L8:
        int r104 = 0;
    L10:
        if (r102 <= r103) goto L12;
    L15:
        int r105 = 0;
    L17:
        if (this.f49720d <= r103) goto L19;
    L22:
        int r106 = r100.getWidth();
    L23:
        int r107 = r106;
        if (this.f49719c <= r103) goto L26;
    L29:
        int r108 = r100.getHeight();
    L30:
        r110.setRoundRect(r104, r105, r107, r108, r101);
        return;
    L26:
        if (this.f49721e > r103) goto L29;
        r108 = r100.getHeight() + ((int) r101);
        goto L30
    L19:
        if (this.f49721e > r103) goto L22;
        r106 = r100.getWidth() + ((int) r101);
        goto L23
    L12:
        if (this.f49720d > r103) goto L15;
        r105 = -((int) r101);
        goto L17
    L5:
        if (this.f49719c > r103) goto L8;
        r104 = -((int) r101);
        goto L10
    }

    public b(float r100, float r101, float r102, float r103, float r104) {
        this.f49717a = r100;
        this.f49718b = r101;
        this.f49719c = r102;
        this.f49720d = r103;
        this.f49721e = r104;
    }
}
