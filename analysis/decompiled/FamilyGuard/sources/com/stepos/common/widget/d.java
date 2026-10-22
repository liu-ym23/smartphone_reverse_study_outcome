package com.stepos.common.widget;

/* loaded from: classes.dex */
class d {

    /* renamed from: e, reason: collision with root package name */
    public static final d f14394e = new d(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f14395a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14396b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14397c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14398d;

    private d(int i5, int i6, int i7, int i8) {
        this.f14395a = i5;
        this.f14396b = i6;
        this.f14397c = i7;
        this.f14398d = i8;
    }

    public static d a(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f14394e : new d(i5, i6, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f14398d == dVar.f14398d && this.f14395a == dVar.f14395a && this.f14397c == dVar.f14397c && this.f14396b == dVar.f14396b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f14395a * 31) + this.f14396b) * 31) + this.f14397c) * 31) + this.f14398d;
    }

    public String toString() {
        return "Insets{left=" + this.f14395a + ", top=" + this.f14396b + ", right=" + this.f14397c + ", bottom=" + this.f14398d + '}';
    }
}
