package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f20557a;

    /* renamed from: b, reason: collision with root package name */
    public int f20558b;

    /* renamed from: c, reason: collision with root package name */
    public final List<c> f20559c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20560d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20561e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20562f;

    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    public static final class C0231b {

        /* renamed from: a, reason: collision with root package name */
        public final float f20563a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20564b;

        /* renamed from: d, reason: collision with root package name */
        public c f20566d;

        /* renamed from: e, reason: collision with root package name */
        public c f20567e;

        /* renamed from: c, reason: collision with root package name */
        public final List<c> f20565c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public int f20568f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f20569g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f20570h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public int f20571i = -1;

        public C0231b(float f10, int i10) {
            this.f20563a = f10;
            this.f20564b = i10;
        }

        public static float j(float f10, float f11, int i10, int i11) {
            return (f10 - (i10 * f11)) + (i11 * f11);
        }

        public C0231b a(float f10, float f11, float f12) {
            return d(f10, f11, f12, false, true);
        }

        public C0231b b(float f10, float f11, float f12) {
            return c(f10, f11, f12, false);
        }

        public C0231b c(float f10, float f11, float f12, boolean z10) {
            return d(f10, f11, f12, z10, false);
        }

        public C0231b d(float f10, float f11, float f12, boolean z10, boolean z11) {
            float fAbs;
            float f13 = f12 / 2.0f;
            float f14 = f10 - f13;
            float f15 = f13 + f10;
            int i10 = this.f20564b;
            if (f15 > i10) {
                fAbs = Math.abs(f15 - Math.max(f15 - f12, i10));
            } else {
                fAbs = 0.0f;
                if (f14 < 0.0f) {
                    fAbs = Math.abs(f14 - Math.min(f14 + f12, 0.0f));
                }
            }
            return e(f10, f11, f12, z10, z11, fAbs);
        }

        public C0231b e(float f10, float f11, float f12, boolean z10, boolean z11, float f13) {
            return f(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
        }

        public C0231b f(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= 0.0f) {
                return this;
            }
            if (z11) {
                if (z10) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i10 = this.f20571i;
                if (i10 != -1 && i10 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f20571i = this.f20565c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.f20566d == null) {
                    this.f20566d = cVar;
                    this.f20568f = this.f20565c.size();
                }
                if (this.f20569g != -1 && this.f20565c.size() - this.f20569g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 != this.f20566d.f20575d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f20567e = cVar;
                this.f20569g = this.f20565c.size();
            } else {
                if (this.f20566d == null && cVar.f20575d < this.f20570h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f20567e != null && cVar.f20575d > this.f20570h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f20570h = cVar.f20575d;
            this.f20565c.add(cVar);
            return this;
        }

        public C0231b g(float f10, float f11, float f12, int i10) {
            return h(f10, f11, f12, i10, false);
        }

        public C0231b h(float f10, float f11, float f12, int i10, boolean z10) {
            if (i10 > 0 && f12 > 0.0f) {
                for (int i11 = 0; i11 < i10; i11++) {
                    c((i11 * f12) + f10, f11, f12, z10);
                }
            }
            return this;
        }

        public b i() {
            if (this.f20566d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.f20565c.size(); i10++) {
                c cVar = this.f20565c.get(i10);
                arrayList.add(new c(j(this.f20566d.f20573b, this.f20563a, this.f20568f, i10), cVar.f20573b, cVar.f20574c, cVar.f20575d, cVar.f20576e, cVar.f20577f, cVar.f20578g, cVar.f20579h));
            }
            return new b(this.f20563a, arrayList, this.f20568f, this.f20569g, this.f20564b);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final float f20572a;

        /* renamed from: b, reason: collision with root package name */
        public final float f20573b;

        /* renamed from: c, reason: collision with root package name */
        public final float f20574c;

        /* renamed from: d, reason: collision with root package name */
        public final float f20575d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20576e;

        /* renamed from: f, reason: collision with root package name */
        public final float f20577f;

        /* renamed from: g, reason: collision with root package name */
        public final float f20578g;

        /* renamed from: h, reason: collision with root package name */
        public final float f20579h;

        public c(float f10, float f11, float f12, float f13) {
            this(f10, f11, f12, f13, false, 0.0f, 0.0f, 0.0f);
        }

        public static c a(c cVar, c cVar2, float f10) {
            return new c(E2.a.a(cVar.f20572a, cVar2.f20572a, f10), E2.a.a(cVar.f20573b, cVar2.f20573b, f10), E2.a.a(cVar.f20574c, cVar2.f20574c, f10), E2.a.a(cVar.f20575d, cVar2.f20575d, f10));
        }

        public c(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.f20572a = f10;
            this.f20573b = f11;
            this.f20574c = f12;
            this.f20575d = f13;
            this.f20576e = z10;
            this.f20577f = f14;
            this.f20578g = f15;
            this.f20579h = f16;
        }
    }

    public static b o(b bVar, b bVar2, float f10) {
        if (bVar.g() != bVar2.g()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<c> listH = bVar.h();
        List<c> listH2 = bVar2.h();
        if (listH.size() != listH2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < bVar.h().size(); i10++) {
            arrayList.add(c.a(listH.get(i10), listH2.get(i10), f10));
        }
        return new b(bVar.g(), arrayList, E2.a.c(bVar.c(), bVar2.c(), f10), E2.a.c(bVar.j(), bVar2.j(), f10), bVar.f20562f);
    }

    public static b p(b bVar, int i10) {
        C0231b c0231b = new C0231b(bVar.g(), i10);
        float f10 = (i10 - bVar.k().f20573b) - (bVar.k().f20575d / 2.0f);
        int size = bVar.h().size() - 1;
        while (size >= 0) {
            c cVar = bVar.h().get(size);
            c0231b.d((cVar.f20575d / 2.0f) + f10, cVar.f20574c, cVar.f20575d, size >= bVar.c() && size <= bVar.j(), cVar.f20576e);
            f10 += cVar.f20575d;
            size--;
        }
        return c0231b.i();
    }

    public int a() {
        return this.f20562f;
    }

    public c b() {
        return this.f20559c.get(this.f20560d);
    }

    public int c() {
        return this.f20560d;
    }

    public c d() {
        return this.f20559c.get(0);
    }

    public c e() {
        for (int i10 = 0; i10 < this.f20559c.size(); i10++) {
            c cVar = this.f20559c.get(i10);
            if (!cVar.f20576e) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> f() {
        return this.f20559c.subList(this.f20560d, this.f20561e + 1);
    }

    public float g() {
        return this.f20557a;
    }

    public List<c> h() {
        return this.f20559c;
    }

    public c i() {
        return this.f20559c.get(this.f20561e);
    }

    public int j() {
        return this.f20561e;
    }

    public c k() {
        return this.f20559c.get(r1.size() - 1);
    }

    public c l() {
        for (int size = this.f20559c.size() - 1; size >= 0; size--) {
            c cVar = this.f20559c.get(size);
            if (!cVar.f20576e) {
                return cVar;
            }
        }
        return null;
    }

    public int m() {
        Iterator<c> it = this.f20559c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().f20576e) {
                i10++;
            }
        }
        return this.f20559c.size() - i10;
    }

    public int n() {
        return this.f20558b;
    }

    public b(float f10, List<c> list, int i10, int i11, int i12) {
        this.f20557a = f10;
        this.f20559c = Collections.unmodifiableList(list);
        this.f20560d = i10;
        this.f20561e = i11;
        while (i10 <= i11) {
            if (list.get(i10).f20577f == 0.0f) {
                this.f20558b++;
            }
            i10++;
        }
        this.f20562f = i12;
    }
}
