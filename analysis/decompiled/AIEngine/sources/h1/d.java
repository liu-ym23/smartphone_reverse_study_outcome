package h1;

import android.view.View;
import h1.a;
import h1.d;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d<T extends d<T>> implements a.b {

    /* renamed from: l, reason: collision with root package name */
    public static final c f9220l = new c();

    /* renamed from: m, reason: collision with root package name */
    public static final C0088d f9221m = new C0088d();

    /* renamed from: n, reason: collision with root package name */
    public static final e f9222n = new e();

    /* renamed from: o, reason: collision with root package name */
    public static final f f9223o = new f();

    /* renamed from: p, reason: collision with root package name */
    public static final g f9224p = new g();

    /* renamed from: q, reason: collision with root package name */
    public static final h f9225q = new h();
    public static final i r = new i();

    /* renamed from: s, reason: collision with root package name */
    public static final a f9226s = new a();

    /* renamed from: a, reason: collision with root package name */
    public float f9227a;

    /* renamed from: b, reason: collision with root package name */
    public float f9228b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9229c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9230d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.datastore.preferences.protobuf.f f9231e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9232f;

    /* renamed from: g, reason: collision with root package name */
    public final float f9233g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public float f9234i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<k> f9235j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<l> f9236k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getAlpha();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setAlpha(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends androidx.datastore.preferences.protobuf.f {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h1.e f9237b;

        public b(h1.e eVar) {
            this.f9237b = eVar;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return this.f9237b.f9240a;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            this.f9237b.f9240a = f8;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getTranslationX();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setTranslationX(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: h1.d$d, reason: collision with other inner class name */
    public class C0088d extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getTranslationY();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setTranslationY(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getScaleX();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setScaleX(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getScaleY();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setScaleY(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getRotation();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setRotation(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getRotationX();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setRotationX(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i extends m {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((View) obj).getRotationY();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((View) obj).setRotationY(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public float f9238a;

        /* renamed from: b, reason: collision with root package name */
        public float f9239b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface k {
        void a(boolean z);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface l {
        void a(float f8);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class m extends androidx.datastore.preferences.protobuf.f {
    }

    public d(h1.e eVar) {
        this.f9227a = 0.0f;
        this.f9228b = Float.MAX_VALUE;
        this.f9229c = false;
        this.f9232f = false;
        this.f9233g = -3.4028235E38f;
        this.h = 0L;
        this.f9235j = new ArrayList<>();
        this.f9236k = new ArrayList<>();
        this.f9230d = null;
        this.f9231e = new b(eVar);
        this.f9234i = 1.0f;
    }

    public static h1.a d() {
        ThreadLocal<h1.a> threadLocal = h1.a.f9205i;
        if (threadLocal.get() == null) {
            threadLocal.set(new h1.a(new a.d()));
        }
        return threadLocal.get();
    }

    public final void a(k kVar) {
        ArrayList<k> arrayList = this.f9235j;
        if (arrayList.contains(kVar)) {
            return;
        }
        arrayList.add(kVar);
    }

    public final void b(l lVar) {
        if (this.f9232f) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        ArrayList<l> arrayList = this.f9236k;
        if (arrayList.contains(lVar)) {
            return;
        }
        arrayList.add(lVar);
    }

    public final void c(boolean z) {
        ArrayList<k> arrayList;
        int i10 = 0;
        this.f9232f = false;
        h1.a aVarD = d();
        aVarD.f9206a.remove(this);
        ArrayList<a.b> arrayList2 = aVarD.f9207b;
        int iIndexOf = arrayList2.indexOf(this);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
            aVarD.f9211f = true;
        }
        this.h = 0L;
        this.f9229c = false;
        while (true) {
            arrayList = this.f9235j;
            if (i10 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i10) != null) {
                arrayList.get(i10).a(z);
            }
            i10++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // h1.a.b
    public final boolean doAnimationFrame(long j10) {
        long j11 = this.h;
        if (j11 == 0) {
            this.h = j10;
            e(this.f9228b);
            return false;
        }
        long j12 = j10 - j11;
        this.h = j10;
        float f8 = d().f9212g;
        long j13 = f8 == 0.0f ? 2147483647L : (long) (j12 / f8);
        h1.f fVar = (h1.f) this;
        boolean z = true;
        if (fVar.f9243v) {
            float f9 = fVar.f9242u;
            if (f9 != Float.MAX_VALUE) {
                fVar.f9241t.f9251i = f9;
                fVar.f9242u = Float.MAX_VALUE;
            }
            fVar.f9228b = (float) fVar.f9241t.f9251i;
            fVar.f9227a = 0.0f;
            fVar.f9243v = false;
        } else {
            if (fVar.f9242u != Float.MAX_VALUE) {
                long j14 = j13 / 2;
                j jVarC = fVar.f9241t.c(fVar.f9228b, fVar.f9227a, j14);
                h1.g gVar = fVar.f9241t;
                gVar.f9251i = fVar.f9242u;
                fVar.f9242u = Float.MAX_VALUE;
                j jVarC2 = gVar.c(jVarC.f9238a, jVarC.f9239b, j14);
                fVar.f9228b = jVarC2.f9238a;
                fVar.f9227a = jVarC2.f9239b;
            } else {
                j jVarC3 = fVar.f9241t.c(fVar.f9228b, fVar.f9227a, j13);
                fVar.f9228b = jVarC3.f9238a;
                fVar.f9227a = jVarC3.f9239b;
            }
            float fMax = Math.max(fVar.f9228b, fVar.f9233g);
            fVar.f9228b = fMax;
            fVar.f9228b = Math.min(fMax, Float.MAX_VALUE);
            float f10 = fVar.f9227a;
            h1.g gVar2 = fVar.f9241t;
            gVar2.getClass();
            if (Math.abs(f10) >= gVar2.f9248e || Math.abs(r3 - ((float) gVar2.f9251i)) >= gVar2.f9247d) {
                z = false;
            } else {
                fVar.f9228b = (float) fVar.f9241t.f9251i;
                fVar.f9227a = 0.0f;
            }
        }
        float fMin = Math.min(this.f9228b, Float.MAX_VALUE);
        this.f9228b = fMin;
        float fMax2 = Math.max(fMin, this.f9233g);
        this.f9228b = fMax2;
        e(fMax2);
        if (z) {
            c(false);
        }
        return z;
    }

    public final void e(float f8) {
        ArrayList<l> arrayList;
        this.f9231e.i(this.f9230d, f8);
        int i10 = 0;
        while (true) {
            arrayList = this.f9236k;
            if (i10 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i10) != null) {
                arrayList.get(i10).a(this.f9228b);
            }
            i10++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public <K> d(K k9, androidx.datastore.preferences.protobuf.f fVar) {
        this.f9227a = 0.0f;
        this.f9228b = Float.MAX_VALUE;
        this.f9229c = false;
        this.f9232f = false;
        this.f9233g = -3.4028235E38f;
        this.h = 0L;
        this.f9235j = new ArrayList<>();
        this.f9236k = new ArrayList<>();
        this.f9230d = k9;
        this.f9231e = fVar;
        if (fVar != f9224p && fVar != f9225q && fVar != r) {
            if (fVar == f9226s) {
                this.f9234i = 0.00390625f;
                return;
            } else if (fVar != f9222n && fVar != f9223o) {
                this.f9234i = 1.0f;
                return;
            } else {
                this.f9234i = 0.002f;
                return;
            }
        }
        this.f9234i = 0.1f;
    }
}
