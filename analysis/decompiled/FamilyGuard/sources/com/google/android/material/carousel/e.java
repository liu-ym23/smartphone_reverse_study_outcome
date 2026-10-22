package com.google.android.material.carousel;

import b1.C0553a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final float f12515a;

    /* renamed from: b, reason: collision with root package name */
    private int f12516b;

    /* renamed from: c, reason: collision with root package name */
    private final List<c> f12517c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12518d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12519e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12520f;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final float f12521a;

        /* renamed from: b, reason: collision with root package name */
        private final int f12522b;

        /* renamed from: d, reason: collision with root package name */
        private c f12524d;

        /* renamed from: e, reason: collision with root package name */
        private c f12525e;

        /* renamed from: c, reason: collision with root package name */
        private final List<c> f12523c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private int f12526f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f12527g = -1;

        /* renamed from: h, reason: collision with root package name */
        private float f12528h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        private int f12529i = -1;

        public b(float f5, int i5) {
            this.f12521a = f5;
            this.f12522b = i5;
        }

        private static float j(float f5, float f6, int i5, int i6) {
            return (f5 - (i5 * f6)) + (i6 * f6);
        }

        public b a(float f5, float f6, float f7) {
            return d(f5, f6, f7, false, true);
        }

        public b b(float f5, float f6, float f7) {
            return c(f5, f6, f7, false);
        }

        public b c(float f5, float f6, float f7, boolean z5) {
            return d(f5, f6, f7, z5, false);
        }

        public b d(float f5, float f6, float f7, boolean z5, boolean z6) {
            float fAbs;
            float f8 = f7 / 2.0f;
            float f9 = f5 - f8;
            float f10 = f8 + f5;
            int i5 = this.f12522b;
            if (f10 > i5) {
                fAbs = Math.abs(f10 - Math.max(f10 - f7, i5));
            } else {
                fAbs = 0.0f;
                if (f9 < 0.0f) {
                    fAbs = Math.abs(f9 - Math.min(f9 + f7, 0.0f));
                }
            }
            return e(f5, f6, f7, z5, z6, fAbs);
        }

        public b e(float f5, float f6, float f7, boolean z5, boolean z6, float f8) {
            return f(f5, f6, f7, z5, z6, f8, 0.0f, 0.0f);
        }

        public b f(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9, float f10) {
            if (f7 <= 0.0f) {
                return this;
            }
            if (z6) {
                if (z5) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i5 = this.f12529i;
                if (i5 != -1 && i5 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f12529i = this.f12523c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f5, f6, f7, z6, f8, f9, f10);
            if (z5) {
                if (this.f12524d == null) {
                    this.f12524d = cVar;
                    this.f12526f = this.f12523c.size();
                }
                if (this.f12527g != -1 && this.f12523c.size() - this.f12527g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f7 != this.f12524d.f12533d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f12525e = cVar;
                this.f12527g = this.f12523c.size();
            } else {
                if (this.f12524d == null && cVar.f12533d < this.f12528h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f12525e != null && cVar.f12533d > this.f12528h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f12528h = cVar.f12533d;
            this.f12523c.add(cVar);
            return this;
        }

        public b g(float f5, float f6, float f7, int i5) {
            return h(f5, f6, f7, i5, false);
        }

        public b h(float f5, float f6, float f7, int i5, boolean z5) {
            if (i5 > 0 && f7 > 0.0f) {
                for (int i6 = 0; i6 < i5; i6++) {
                    c((i6 * f7) + f5, f6, f7, z5);
                }
            }
            return this;
        }

        public e i() {
            if (this.f12524d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < this.f12523c.size(); i5++) {
                c cVar = this.f12523c.get(i5);
                arrayList.add(new c(j(this.f12524d.f12531b, this.f12521a, this.f12526f, i5), cVar.f12531b, cVar.f12532c, cVar.f12533d, cVar.f12534e, cVar.f12535f, cVar.f12536g, cVar.f12537h));
            }
            return new e(this.f12521a, arrayList, this.f12526f, this.f12527g, this.f12522b);
        }
    }

    static final class c {

        /* renamed from: a, reason: collision with root package name */
        final float f12530a;

        /* renamed from: b, reason: collision with root package name */
        final float f12531b;

        /* renamed from: c, reason: collision with root package name */
        final float f12532c;

        /* renamed from: d, reason: collision with root package name */
        final float f12533d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f12534e;

        /* renamed from: f, reason: collision with root package name */
        final float f12535f;

        /* renamed from: g, reason: collision with root package name */
        final float f12536g;

        /* renamed from: h, reason: collision with root package name */
        final float f12537h;

        c(float f5, float f6, float f7, float f8) {
            this(f5, f6, f7, f8, false, 0.0f, 0.0f, 0.0f);
        }

        static c a(c cVar, c cVar2, float f5) {
            return new c(C0553a.a(cVar.f12530a, cVar2.f12530a, f5), C0553a.a(cVar.f12531b, cVar2.f12531b, f5), C0553a.a(cVar.f12532c, cVar2.f12532c, f5), C0553a.a(cVar.f12533d, cVar2.f12533d, f5));
        }

        c(float f5, float f6, float f7, float f8, boolean z5, float f9, float f10, float f11) {
            this.f12530a = f5;
            this.f12531b = f6;
            this.f12532c = f7;
            this.f12533d = f8;
            this.f12534e = z5;
            this.f12535f = f9;
            this.f12536g = f10;
            this.f12537h = f11;
        }
    }

    static e o(e eVar, e eVar2, float f5) {
        if (eVar.g() != eVar2.g()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<c> listH = eVar.h();
        List<c> listH2 = eVar2.h();
        if (listH.size() != listH2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < eVar.h().size(); i5++) {
            arrayList.add(c.a(listH.get(i5), listH2.get(i5), f5));
        }
        return new e(eVar.g(), arrayList, C0553a.c(eVar.c(), eVar2.c(), f5), C0553a.c(eVar.j(), eVar2.j(), f5), eVar.f12520f);
    }

    static e p(e eVar, int i5) {
        b bVar = new b(eVar.g(), i5);
        float f5 = (i5 - eVar.k().f12531b) - (eVar.k().f12533d / 2.0f);
        int size = eVar.h().size() - 1;
        while (size >= 0) {
            c cVar = eVar.h().get(size);
            bVar.d((cVar.f12533d / 2.0f) + f5, cVar.f12532c, cVar.f12533d, size >= eVar.c() && size <= eVar.j(), cVar.f12534e);
            f5 += cVar.f12533d;
            size--;
        }
        return bVar.i();
    }

    int a() {
        return this.f12520f;
    }

    c b() {
        return this.f12517c.get(this.f12518d);
    }

    int c() {
        return this.f12518d;
    }

    c d() {
        return this.f12517c.get(0);
    }

    c e() {
        for (int i5 = 0; i5 < this.f12517c.size(); i5++) {
            c cVar = this.f12517c.get(i5);
            if (!cVar.f12534e) {
                return cVar;
            }
        }
        return null;
    }

    List<c> f() {
        return this.f12517c.subList(this.f12518d, this.f12519e + 1);
    }

    float g() {
        return this.f12515a;
    }

    List<c> h() {
        return this.f12517c;
    }

    c i() {
        return this.f12517c.get(this.f12519e);
    }

    int j() {
        return this.f12519e;
    }

    c k() {
        return this.f12517c.get(r1.size() - 1);
    }

    c l() {
        for (int size = this.f12517c.size() - 1; size >= 0; size--) {
            c cVar = this.f12517c.get(size);
            if (!cVar.f12534e) {
                return cVar;
            }
        }
        return null;
    }

    int m() {
        Iterator<c> it = this.f12517c.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().f12534e) {
                i5++;
            }
        }
        return this.f12517c.size() - i5;
    }

    int n() {
        return this.f12516b;
    }

    private e(float f5, List<c> list, int i5, int i6, int i7) {
        this.f12515a = f5;
        this.f12517c = Collections.unmodifiableList(list);
        this.f12518d = i5;
        this.f12519e = i6;
        while (i5 <= i6) {
            if (list.get(i5).f12535f == 0.0f) {
                this.f12516b++;
            }
            i5++;
        }
        this.f12520f = i7;
    }
}
