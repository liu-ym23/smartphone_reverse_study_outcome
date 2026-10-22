package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j0.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p0.d;
import p0.e;
import r0.c;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends com.airbnb.lottie.model.layer.a {
    public Boolean A;
    public Boolean B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j0.a<Float, Float> f24911w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<com.airbnb.lottie.model.layer.a> f24912x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f24913y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f24914z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24915a = null;

        static {
            int[] r100 = new int[Layer.MatteType.values().length];
            f24915a = r100;
            r100[Layer.MatteType.Add.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f24915a[Layer.MatteType.Invert.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final boolean t() {
        if (this.B != null) goto L21;
        int r100 = ((ArrayList) this.f24912x).size() - 1;
    L5:
        if (r100 < 0) goto L19;
        com.airbnb.lottie.model.layer.a r101 = (com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r100);
        if ((r101 instanceof d) == false) goto L13;
        if (r101.m() == false) goto L18;
        this.B = Boolean.TRUE;
        return true;
    L18:
        r100 = r100 - 1;
        goto L5
    L13:
        if ((r101 instanceof b) == false) goto L18;
        if (((b) r101).t() == false) goto L18;
        this.B = Boolean.TRUE;
        return true;
    L19:
        this.B = Boolean.FALSE;
    L21:
        return this.B.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void r(float r100) {
        super.r(r100);
        if (c.a.f535397a == false) goto L18;
        if (this.f24911w == null) goto L8;
        r100 = ((this.f24911w.g().floatValue() * this.f24900n.f24865b.getFrameRate()) - this.f24900n.f24865b.getStartFrame()) / (this.f24899m.f24725b.getDurationFrames() + 0.01f);
    L8:
        if (this.f24911w != null) goto L10;
        Layer r101 = this.f24900n;
        r100 = r100 - (r101.f24877n / r101.f24865b.getDurationFrames());
    L10:
        float r102 = this.f24900n.f24876m;
        if (r102 == 0.0f) goto L13;
        r100 = r100 / r102;
    L13:
        int r103 = ((ArrayList) this.f24912x).size();
    L14:
        r103 = r103 - 1;
        if (r103 < 0) goto L27;
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r103)).r(r100);
        goto L14
    L27:
        return;
    L18:
        if (this.f24911w == null) goto L20;
        r100 = ((long) (this.f24911w.g().floatValue() * 1000.0f)) / this.f24899m.f24725b.getDuration();
    L20:
        Layer r104 = this.f24900n;
        float r105 = r104.f24876m;
        if (r105 == 0.0f) goto L23;
        r100 = r100 / r105;
    L23:
        float r106 = r100 - (r104.f24877n / r104.f24865b.getDurationFrames());
        int r107 = ((ArrayList) this.f24912x).size();
    L24:
        r107 = r107 - 1;
        if (r107 < 0) goto L30;
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r107)).r(r106);
        goto L24
    }

    public final void s(RectF r100) {
        if (c.a.f535397a == false) goto L8;
        int r101 = ((ArrayList) this.f24912x).size();
    L5:
        r101 = r101 - 1;
        if (r101 < 0) goto L16;
        this.f24913y.set(0.0f, 0.0f, 0.0f, 0.0f);
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r101)).l(this.f24913y, this.f24898l);
        r100.union(this.f24913y);
        goto L5
    L16:
        return;
    L8:
        this.f24913y.set(0.0f, 0.0f, 0.0f, 0.0f);
        int r102 = ((ArrayList) this.f24912x).size();
    L9:
        r102 = r102 - 1;
        if (r102 < 0) goto L24;
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r102)).c(this.f24913y, this.f24898l);
        if (r100.isEmpty() == true) goto L13;
        r100.set(Math.min(r100.left, this.f24913y.left), Math.min(r100.top, this.f24913y.top), Math.max(r100.right, this.f24913y.right), Math.max(r100.bottom, this.f24913y.bottom));
        goto L9
    L13:
        r100.set(this.f24913y);
        goto L9
    }

    @Override // com.airbnb.lottie.model.layer.a, i0.e
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        s(r100);
    }

    @Override // com.airbnb.lottie.model.layer.a, m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        super.g(r100, r101);
        if (r100 != k.A) goto L16;
        if (r101 == null) goto L6;
        p r102 = new p(r101);
        this.f24911w = r102;
        if (c.a.f535397a == false) goto L14;
        r102.a(this);
    L14:
        e(this.f24911w);
        return;
    L6:
        if (c.a.f535397a == false) goto L10;
        j0.a<Float, Float> r103 = this.f24911w;
        if (r103 == null) goto L17;
        r103.k(null);
        return;
    L17:
        return;
    L10:
        this.f24911w = null;
        return;
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void l(RectF r100, Matrix r101) {
        super.l(r100, r101);
        s(r100);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void k(Canvas r100, Matrix r101, int r102) {
        Set<String> r103 = f.f24776a;
        r100.save();
        RectF r104 = this.f24914z;
        Layer r105 = this.f24900n;
        r104.set(0.0f, 0.0f, r105.f24878o, r105.f24879p);
        r101.mapRect(this.f24914z);
        int r106 = ((ArrayList) this.f24912x).size() - 1;
    L3:
        if (r106 < 0) goto L11;
        if (this.f24914z.isEmpty() == true) goto L7;
        boolean r107 = r100.clipRect(this.f24914z);
    L8:
        if (r107 == false) goto L10;
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r106)).d(r100, r101, r102);
    L10:
        r106 = r106 - 1;
        goto L3
    L7:
        r107 = true;
        goto L8
    L11:
        r100.restore();
        f.a();
    }

    public b(LottieDrawable r110, Layer r111, List<Layer> r112, LottieComposition r113) {
        super(r110, r111);
        this.f24912x = new ArrayList();
        this.f24913y = new RectF();
        this.f24914z = new RectF();
        n0.b r114 = r111.f24882s;
        if (r114 == null) goto L5;
        j0.a<Float, Float> r115 = r114.a();
        this.f24911w = r115;
        e(r115);
        this.f24911w.a(this);
    L6:
        LongSparseArray r116 = new LongSparseArray(r113.getLayers().size());
        int r100 = r112.size() - 1;
        com.airbnb.lottie.model.layer.a r101 = null;
    L7:
        int r102 = 0;
        if (r100 < 0) goto L32;
        Layer r103 = (Layer) ListProtector.get(r112, r100);
        switch(com.airbnb.lottie.model.layer.a.C0475a.f24909a[r103.f24868e.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L11:
        StringBuilder r104 = new StringBuilder("Unknown layer type ");
        r104.append(r103.f24868e);
        f.b(r104.toString());
        com.airbnb.lottie.model.layer.a r105 = null;
    L19:
        if (r105 == null) goto L30;
        r116.put(r105.f24900n.f24867d, r105);
        if (r101 == null) goto L24;
        r101.f24903q = r105;
        r101 = null;
        goto L30
    L24:
        ListProtector.add(this.f24912x, 0, r105);
        int r106 = a.f24915a[r103.f24884u.ordinal()];
        if (r106 != 1) goto L27;
    L29:
        r101 = r105;
        goto L30
    L27:
        if (r106 == 2) goto L29;
    L30:
        r100 = r100 - 1;
        goto L7
    L12:
        r105 = new p0.f(r110, r103);
        goto L19
    L13:
        r105 = new p0.c(r110, r103);
        goto L19
    L14:
        r105 = new p0.b(r110, r103);
        goto L19
    L15:
        r105 = new e(r110, r103);
        goto L19
    L16:
        r105 = new b(r110, r103, r113.getPrecomps(r103.f24870g), r113);
        goto L19
    L17:
        r105 = new d(r110, r103);
    L32:
        if (r102 >= r116.size()) goto L40;
        com.airbnb.lottie.model.layer.a r117 = (com.airbnb.lottie.model.layer.a) r116.get(r116.keyAt(r102));
        if (r117 == null) goto L39;
        com.airbnb.lottie.model.layer.a r118 = (com.airbnb.lottie.model.layer.a) r116.get(r117.f24900n.f24869f);
        if (r118 == null) goto L39;
        r117.f24904r = r118;
    L39:
        r102 = r102 + 1;
        goto L32
    L40:
        return;
    L5:
        this.f24911w = null;
        goto L6
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void p(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        int r104 = 0;
    L4:
        if (r104 >= ((ArrayList) this.f24912x).size()) goto L6;
        ((com.airbnb.lottie.model.layer.a) ListProtector.get(this.f24912x, r104)).f(r100, r101, r102, r103);
        r104 = r104 + 1;
        goto L4
    }
}
