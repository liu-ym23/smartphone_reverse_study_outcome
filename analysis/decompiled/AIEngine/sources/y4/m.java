package y4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f14096a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f14097b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f14098c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f14099d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f14100e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14101f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f14102g = new ArrayList();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends f {
        public a(c cVar) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final d f14103a;

        /* renamed from: b, reason: collision with root package name */
        public final float f14104b;

        /* renamed from: c, reason: collision with root package name */
        public final float f14105c;

        public b(d dVar, float f8, float f9) {
            this.f14103a = dVar;
            this.f14104b = f8;
            this.f14105c = f9;
        }

        public final float a() {
            d dVar = this.f14103a;
            return (float) Math.toDegrees(Math.atan((dVar.f14113c - this.f14105c) / (dVar.f14112b - this.f14104b)));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends e {
        public static final RectF h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public final float f14106b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public final float f14107c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public final float f14108d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public final float f14109e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f14110f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f14111g;

        public c(float f8, float f9, float f10, float f11) {
            this.f14106b = f8;
            this.f14107c = f9;
            this.f14108d = f10;
            this.f14109e = f11;
        }

        @Override // y4.m.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f14114a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            float f8 = this.f14108d;
            float f9 = this.f14109e;
            RectF rectF = h;
            rectF.set(this.f14106b, this.f14107c, f8, f9);
            path.arcTo(rectF, this.f14110f, this.f14111g, false);
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends e {

        /* renamed from: b, reason: collision with root package name */
        public float f14112b;

        /* renamed from: c, reason: collision with root package name */
        public float f14113c;

        @Override // y4.m.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f14114a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f14112b, this.f14113c);
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f14114a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class f {
        static {
            new Matrix();
        }

        public f() {
            new Matrix();
        }
    }

    public m() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f8) {
        float f9 = this.f14099d;
        if (f9 == f8) {
            return;
        }
        float f10 = ((f8 - f9) + 360.0f) % 360.0f;
        if (f10 > 180.0f) {
            return;
        }
        float f11 = this.f14097b;
        float f12 = this.f14098c;
        c cVar = new c(f11, f12, f11, f12);
        cVar.f14110f = this.f14099d;
        cVar.f14111g = f10;
        this.f14102g.add(new a(cVar));
        this.f14099d = f8;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f14101f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) arrayList.get(i10)).a(matrix, path);
        }
    }

    public final void c(float f8, float f9) {
        d dVar = new d();
        dVar.f14112b = f8;
        dVar.f14113c = f9;
        this.f14101f.add(dVar);
        b bVar = new b(dVar, this.f14097b, this.f14098c);
        float fA = bVar.a() + 270.0f;
        float fA2 = bVar.a() + 270.0f;
        a(fA);
        this.f14102g.add(bVar);
        this.f14099d = fA2;
        this.f14097b = f8;
        this.f14098c = f9;
    }

    public final void d(float f8, float f9, float f10) {
        this.f14096a = f8;
        this.f14097b = 0.0f;
        this.f14098c = f8;
        this.f14099d = f9;
        this.f14100e = (f9 + f10) % 360.0f;
        this.f14101f.clear();
        this.f14102g.clear();
    }
}
