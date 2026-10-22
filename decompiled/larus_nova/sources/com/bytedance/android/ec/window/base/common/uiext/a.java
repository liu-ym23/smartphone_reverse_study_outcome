package com.bytedance.android.ec.window.base.common.uiext;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f49218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f49219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f49220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f49221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f49222e;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        float r101 = Math.min(Math.min(r100.getWidth(), r100.getHeight()) / 2, this.f49218a);
        float r102 = this.f49219b;
        float r103 = 0;
        if (r102 <= r103) goto L5;
    L8:
        int r104 = 0;
    L10:
        if (r102 <= r103) goto L12;
    L15:
        int r105 = 0;
    L17:
        if (this.f49221d <= r103) goto L19;
    L22:
        int r106 = r100.getWidth();
    L23:
        int r107 = r106;
        if (this.f49220c <= r103) goto L26;
    L29:
        int r108 = r100.getHeight();
    L30:
        r110.setRoundRect(r104, r105, r107, r108, r101);
        return;
    L26:
        if (this.f49222e > r103) goto L29;
        r108 = r100.getHeight() + ((int) r101);
        goto L30
    L19:
        if (this.f49222e > r103) goto L22;
        r106 = r100.getWidth() + ((int) r101);
        goto L23
    L12:
        if (this.f49221d > r103) goto L15;
        r105 = -((int) r101);
        goto L17
    L5:
        if (this.f49220c > r103) goto L8;
        r104 = -((int) r101);
        goto L10
    }

    public a(float r100, float r101, float r102, float r103, float r104) {
        this.f49218a = r100;
        this.f49219b = r101;
        this.f49220c = r102;
        this.f49221d = r103;
        this.f49222e = r104;
    }
}
