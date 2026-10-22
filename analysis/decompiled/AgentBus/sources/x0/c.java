package x0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RenderNode;
import o4.d0;
import u0.m;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f11087a;

    /* renamed from: b, reason: collision with root package name */
    public final w0.b f11088b;

    /* renamed from: c, reason: collision with root package name */
    public final RenderNode f11089c;

    /* renamed from: d, reason: collision with root package name */
    public long f11090d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f11091e;

    /* renamed from: f, reason: collision with root package name */
    public Matrix f11092f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11093g;

    /* renamed from: h, reason: collision with root package name */
    public float f11094h;

    /* renamed from: i, reason: collision with root package name */
    public int f11095i;

    /* renamed from: j, reason: collision with root package name */
    public float f11096j;

    /* renamed from: k, reason: collision with root package name */
    public float f11097k;

    /* renamed from: l, reason: collision with root package name */
    public float f11098l;

    /* renamed from: m, reason: collision with root package name */
    public long f11099m;

    /* renamed from: n, reason: collision with root package name */
    public long f11100n;

    /* renamed from: o, reason: collision with root package name */
    public float f11101o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11102p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11103q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11104r;

    /* renamed from: s, reason: collision with root package name */
    public int f11105s;

    public c() {
        d0 d0Var = new d0(10);
        w0.b bVar = new w0.b();
        this.f11087a = d0Var;
        this.f11088b = bVar;
        RenderNode renderNode = new RenderNode("graphicsLayer");
        this.f11089c = renderNode;
        this.f11090d = 0L;
        renderNode.setClipToBounds(false);
        b(renderNode, 0);
        this.f11094h = 1.0f;
        this.f11095i = 3;
        this.f11096j = 1.0f;
        this.f11097k = 1.0f;
        long j2 = m.f9912b;
        this.f11099m = j2;
        this.f11100n = j2;
        this.f11101o = 8.0f;
        this.f11105s = 0;
    }

    public final void a() {
        boolean z4 = this.f11102p;
        boolean z10 = false;
        boolean z11 = z4 && !this.f11093g;
        if (z4 && this.f11093g) {
            z10 = true;
        }
        boolean z12 = this.f11103q;
        RenderNode renderNode = this.f11089c;
        if (z11 != z12) {
            this.f11103q = z11;
            renderNode.setClipToBounds(z11);
        }
        if (z10 != this.f11104r) {
            this.f11104r = z10;
            renderNode.setClipToOutline(z10);
        }
    }

    public final void b(RenderNode renderNode, int i2) {
        if (i2 == 1) {
            renderNode.setUseCompositingLayer(true, this.f11091e);
            renderNode.setHasOverlappingRendering(true);
        } else if (i2 == 2) {
            renderNode.setUseCompositingLayer(false, this.f11091e);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.f11091e);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public final void c(boolean z4) {
        this.f11102p = z4;
        a();
    }

    public final void d() {
        int i2 = this.f11105s;
        RenderNode renderNode = this.f11089c;
        if (i2 != 1 && this.f11095i == 3) {
            b(renderNode, i2);
        } else {
            b(renderNode, 1);
        }
    }
}
