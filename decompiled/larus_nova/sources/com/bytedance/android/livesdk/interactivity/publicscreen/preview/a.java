package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements ba2.b<ba2.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ba2.e f139328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f139329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f139330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f139331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f139332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f139333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f139334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f139335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f139336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f139337j;

    public final void a() {
        this.f139335h.mapRect(this.f139334g, this.f139333f);
        f r100 = this.f139329b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f139330c == false) goto L9;
        r100.a();
        return;
    }

    public final void c() {
        RectF r100 = this.f139332e;
        RectF r101 = this.f139333f;
        if (r101.width() <= r100.width()) goto L5;
    L8:
        this.f139331d = Math.max(r101.width() / r100.width(), r101.height() / r100.height());
        return;
    L5:
        if (r101.height() > r100.height()) goto L8;
        this.f139331d = Math.max(r100.width() / r101.width(), r100.height() / r101.height());
    }

    public a(ba2.e r100) {
        this.f139329b = null;
        this.f139330c = false;
        this.f139331d = 0.0f;
        this.f139332e = new RectF();
        this.f139333f = new RectF();
        this.f139334g = new RectF();
        this.f139335h = new Matrix();
        this.f139336i = new Matrix();
        this.f139337j = new float[9];
        this.f139328a = r100;
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.f18398a.add(this);
    }

    public final void b(boolean r100) {
        this.f139330c = r100;
        if (r100 == true) goto L9;
        ZoomableControllerImp r101 = (ZoomableControllerImp) this;
        r101.j();
        if (r101.f139325t.computeScrollOffset() == false) goto L7;
        r101.f139325t.forceFinished(true);
    L7:
        r101.f139320o.reset();
        r101.f139319n.reset();
        r101.f139335h.reset();
        r101.a();
        return;
    }
}
