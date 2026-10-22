package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f4813a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4814b;

    /* renamed from: c, reason: collision with root package name */
    public final List<C0035b> f4815c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4816d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4817e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4818f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final float f4819a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4820b;

        /* renamed from: d, reason: collision with root package name */
        public C0035b f4822d;

        /* renamed from: e, reason: collision with root package name */
        public C0035b f4823e;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f4821c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public int f4824f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f4825g = -1;
        public float h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public int f4826i = -1;

        public a(float f8, int i10) {
            this.f4819a = f8;
            this.f4820b = i10;
        }

        public final void a(float f8, float f9, float f10, boolean z, boolean z3) {
            float fAbs;
            float f11 = f10 / 2.0f;
            float f12 = f8 - f11;
            float f13 = f11 + f8;
            float f14 = this.f4820b;
            if (f13 > f14) {
                fAbs = Math.abs(f13 - Math.max(f13 - f10, f14));
            } else {
                fAbs = 0.0f;
                if (f12 < 0.0f) {
                    fAbs = Math.abs(f12 - Math.min(f12 + f10, 0.0f));
                }
            }
            b(f8, f9, f10, z, z3, fAbs, 0.0f, 0.0f);
        }

        public final void b(float f8, float f9, float f10, boolean z, boolean z3, float f11, float f12, float f13) {
            if (f10 <= 0.0f) {
                return;
            }
            ArrayList arrayList = this.f4821c;
            if (z3) {
                if (z) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i10 = this.f4826i;
                if (i10 != -1 && i10 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f4826i = arrayList.size();
            }
            C0035b c0035b = new C0035b(Float.MIN_VALUE, f8, f9, f10, z3, f11, f12, f13);
            if (z) {
                if (this.f4822d == null) {
                    this.f4822d = c0035b;
                    this.f4824f = arrayList.size();
                }
                if (this.f4825g != -1 && arrayList.size() - this.f4825g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f10 != this.f4822d.f4830d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f4823e = c0035b;
                this.f4825g = arrayList.size();
            } else {
                if (this.f4822d == null && f10 < this.h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f4823e != null && f10 > this.h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.h = f10;
            arrayList.add(c0035b);
        }

        public final void c(float f8, float f9, float f10, int i10, boolean z) {
            if (i10 <= 0 || f10 <= 0.0f) {
                return;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                a((i11 * f10) + f8, f9, f10, z, false);
            }
        }

        public final b d() {
            if (this.f4822d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (true) {
                ArrayList arrayList2 = this.f4821c;
                if (i10 >= arrayList2.size()) {
                    return new b(this.f4819a, arrayList, this.f4824f, this.f4825g, this.f4820b);
                }
                C0035b c0035b = (C0035b) arrayList2.get(i10);
                float f8 = this.f4822d.f4828b;
                float f9 = this.f4824f;
                float f10 = this.f4819a;
                arrayList.add(new C0035b((i10 * f10) + (f8 - (f9 * f10)), c0035b.f4828b, c0035b.f4829c, c0035b.f4830d, c0035b.f4831e, c0035b.f4832f, c0035b.f4833g, c0035b.h));
                i10++;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    public static final class C0035b {

        /* renamed from: a, reason: collision with root package name */
        public final float f4827a;

        /* renamed from: b, reason: collision with root package name */
        public final float f4828b;

        /* renamed from: c, reason: collision with root package name */
        public final float f4829c;

        /* renamed from: d, reason: collision with root package name */
        public final float f4830d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4831e;

        /* renamed from: f, reason: collision with root package name */
        public final float f4832f;

        /* renamed from: g, reason: collision with root package name */
        public final float f4833g;
        public final float h;

        public C0035b(float f8, float f9, float f10, float f11, boolean z, float f12, float f13, float f14) {
            this.f4827a = f8;
            this.f4828b = f9;
            this.f4829c = f10;
            this.f4830d = f11;
            this.f4831e = z;
            this.f4832f = f12;
            this.f4833g = f13;
            this.h = f14;
        }
    }

    public b(float f8, ArrayList arrayList, int i10, int i11, int i12) {
        this.f4813a = f8;
        this.f4815c = Collections.unmodifiableList(arrayList);
        this.f4816d = i10;
        this.f4817e = i11;
        while (i10 <= i11) {
            if (((C0035b) arrayList.get(i10)).f4832f == 0.0f) {
                this.f4814b++;
            }
            i10++;
        }
        this.f4818f = i12;
    }

    public final C0035b a() {
        return this.f4815c.get(this.f4816d);
    }

    public final C0035b b() {
        return this.f4815c.get(0);
    }

    public final C0035b c() {
        return this.f4815c.get(this.f4817e);
    }

    public final C0035b d() {
        return this.f4815c.get(r1.size() - 1);
    }
}
