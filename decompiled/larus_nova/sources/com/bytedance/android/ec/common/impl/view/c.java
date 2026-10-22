package com.bytedance.android.ec.common.impl.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f43607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f43608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f43609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f43610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f43611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f43612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PorterDuffXfermode f43613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f43614j;

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f43614j = r100;
        this.f43609e = new RectF();
        this.f43610f = new float[8];
        this.f43611g = new Path();
        this.f43612h = new Paint(1);
        this.f43613i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
