package com.stepos.common.widget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final o f7165c = new o(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f7166a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7167b;

    public o(int i10, int i11) {
        this.f7166a = i10;
        this.f7167b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f7166a == oVar.f7166a && this.f7167b == oVar.f7167b;
    }

    public final int hashCode() {
        return ((this.f7166a * 961) + this.f7167b) * 31;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f7166a);
        sb2.append(", top=0, right=");
        return ai.onnxruntime.a.j(", bottom=0}", this.f7167b, sb2);
    }
}
