package G0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0398c;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b implements H0.a, k, e {

    /* renamed from: e, reason: collision with root package name */
    public final v f473e;

    /* renamed from: f, reason: collision with root package name */
    public final M0.b f474f;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f476h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f477i;

    /* renamed from: j, reason: collision with root package name */
    public final H0.c f478j;

    /* renamed from: k, reason: collision with root package name */
    public final H0.b f479k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f480l;

    /* renamed from: m, reason: collision with root package name */
    public final H0.c f481m;

    /* renamed from: n, reason: collision with root package name */
    public H0.j f482n;

    /* renamed from: a, reason: collision with root package name */
    public final PathMeasure f469a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f470b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f471c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final RectF f472d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f475g = new ArrayList();

    public b(v vVar, M0.b bVar, Paint.Cap cap, Paint.Join join, float f4, K0.a aVar, K0.b bVar2, List list, K0.b bVar3) {
        Paint paint = new Paint(1);
        this.f477i = paint;
        this.f473e = vVar;
        this.f474f = bVar;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f4);
        this.f479k = aVar.c();
        this.f478j = (H0.c) bVar2.c();
        if (bVar3 == null) {
            this.f481m = null;
        } else {
            this.f481m = (H0.c) bVar3.c();
        }
        this.f480l = new ArrayList(list.size());
        this.f476h = new float[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f480l.add(((K0.b) list.get(i4)).c());
        }
        bVar.c(this.f479k);
        bVar.c(this.f478j);
        for (int i5 = 0; i5 < this.f480l.size(); i5++) {
            bVar.c((H0.b) this.f480l.get(i5));
        }
        H0.c cVar = this.f481m;
        if (cVar != null) {
            bVar.c(cVar);
        }
        this.f479k.a(this);
        this.f478j.a(this);
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((H0.b) this.f480l.get(i6)).a(this);
        }
        H0.c cVar2 = this.f481m;
        if (cVar2 != null) {
            cVar2.a(this);
        }
    }

    @Override // H0.a
    public final void a() {
        this.f473e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    @Override // G0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        La:
            r3 = 2
            if (r0 < 0) goto L21
            java.lang.Object r4 = r8.get(r0)
            G0.c r4 = (G0.c) r4
            boolean r5 = r4 instanceof G0.s
            if (r5 == 0) goto L1e
            G0.s r4 = (G0.s) r4
            int r5 = r4.f580b
            if (r5 != r3) goto L1e
            r2 = r4
        L1e:
            int r0 = r0 + (-1)
            goto La
        L21:
            if (r2 == 0) goto L26
            r2.c(r7)
        L26:
            int r8 = r9.size()
            int r8 = r8 + (-1)
        L2c:
            java.util.ArrayList r0 = r7.f475g
            if (r8 < 0) goto L65
            java.lang.Object r4 = r9.get(r8)
            G0.c r4 = (G0.c) r4
            boolean r5 = r4 instanceof G0.s
            if (r5 == 0) goto L50
            r5 = r4
            G0.s r5 = (G0.s) r5
            int r6 = r5.f580b
            if (r6 != r3) goto L50
            if (r1 == 0) goto L46
            r0.add(r1)
        L46:
            G0.a r0 = new G0.a
            r0.<init>(r5)
            r5.c(r7)
            r1 = r0
            goto L62
        L50:
            boolean r0 = r4 instanceof G0.m
            if (r0 == 0) goto L62
            if (r1 != 0) goto L5b
            G0.a r1 = new G0.a
            r1.<init>(r2)
        L5b:
            java.util.ArrayList r0 = r1.f467a
            G0.m r4 = (G0.m) r4
            r0.add(r4)
        L62:
            int r8 = r8 + (-1)
            goto L2c
        L65:
            if (r1 == 0) goto L6a
            r0.add(r1)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.b.b(java.util.List, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0189  */
    @Override // G0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.graphics.Canvas r19, android.graphics.Matrix r20, int r21) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.b.d(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // J0.f
    public void f(Object obj, Q0.b bVar) {
        PointF pointF = z.f4588a;
        if (obj == 4) {
            this.f479k.i(bVar);
            return;
        }
        if (obj == z.f4594g) {
            this.f478j.i(bVar);
            return;
        }
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f482n = null;
                return;
            }
            H0.j jVar = new H0.j(bVar);
            this.f482n = jVar;
            jVar.a(this);
            this.f474f.c(this.f482n);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.e
    public final void h(RectF rectF, Matrix matrix) {
        HashSet hashSet = AbstractC0398c.f4541a;
        Path path = this.f470b;
        path.reset();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f475g;
            if (i4 >= arrayList.size()) {
                RectF rectF2 = this.f472d;
                path.computeBounds(rectF2, false);
                float fFloatValue = ((Float) this.f478j.e()).floatValue() / 2.0f;
                rectF2.set(rectF2.left - fFloatValue, rectF2.top - fFloatValue, rectF2.right + fFloatValue, rectF2.bottom + fFloatValue);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                AbstractC0398c.a();
                return;
            }
            a aVar = (a) arrayList.get(i4);
            for (int i5 = 0; i5 < aVar.f467a.size(); i5++) {
                path.addPath(((m) aVar.f467a.get(i5)).e(), matrix);
            }
            i4++;
        }
    }
}
