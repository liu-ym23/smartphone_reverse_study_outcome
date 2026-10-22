package g1;

import a1.g;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RenderNode;
import d1.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final g f4224a;

    /* renamed from: b, reason: collision with root package name */
    public final f1.b f4225b;

    /* renamed from: c, reason: collision with root package name */
    public final RenderNode f4226c;

    /* renamed from: d, reason: collision with root package name */
    public long f4227d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f4228e;

    /* renamed from: f, reason: collision with root package name */
    public Matrix f4229f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4230g;

    /* renamed from: h, reason: collision with root package name */
    public float f4231h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public float f4232j;

    /* renamed from: k, reason: collision with root package name */
    public float f4233k;

    /* renamed from: l, reason: collision with root package name */
    public float f4234l;

    /* renamed from: m, reason: collision with root package name */
    public long f4235m;

    /* renamed from: n, reason: collision with root package name */
    public long f4236n;

    /* renamed from: o, reason: collision with root package name */
    public float f4237o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4238p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4239q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4240r;

    /* renamed from: s, reason: collision with root package name */
    public int f4241s;

    public c() {
        g gVar = new g(6);
        f1.b bVar = new f1.b();
        this.f4224a = gVar;
        this.f4225b = bVar;
        RenderNode renderNode = new RenderNode("graphicsLayer");
        this.f4226c = renderNode;
        this.f4227d = 0L;
        renderNode.setClipToBounds(false);
        b(renderNode, 0);
        this.f4231h = 1.0f;
        this.i = 3;
        this.f4232j = 1.0f;
        this.f4233k = 1.0f;
        long j10 = p.f3019b;
        this.f4235m = j10;
        this.f4236n = j10;
        this.f4237o = 8.0f;
        this.f4241s = 0;
    }

    public final void a() {
        boolean z10 = this.f4238p;
        boolean z11 = false;
        boolean z12 = z10 && !this.f4230g;
        if (z10 && this.f4230g) {
            z11 = true;
        }
        boolean z13 = this.f4239q;
        RenderNode renderNode = this.f4226c;
        if (z12 != z13) {
            this.f4239q = z12;
            renderNode.setClipToBounds(z12);
        }
        if (z11 != this.f4240r) {
            this.f4240r = z11;
            renderNode.setClipToOutline(z11);
        }
    }

    public final void b(RenderNode renderNode, int i) {
        if (i == 1) {
            renderNode.setUseCompositingLayer(true, this.f4228e);
            renderNode.setHasOverlappingRendering(true);
            return;
        }
        Paint paint = this.f4228e;
        if (i == 2) {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public final void c() {
        int i = this.f4241s;
        RenderNode renderNode = this.f4226c;
        if (i != 1 && this.i == 3) {
            b(renderNode, i);
        } else {
            b(renderNode, 1);
        }
    }
}
