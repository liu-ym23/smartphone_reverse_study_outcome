package L0;

import G0.s;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class p implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1212a;

    /* renamed from: b, reason: collision with root package name */
    public final K0.b f1213b;

    /* renamed from: c, reason: collision with root package name */
    public final K0.b f1214c;

    /* renamed from: d, reason: collision with root package name */
    public final K0.b f1215d;

    public p(String str, int i4, K0.b bVar, K0.b bVar2, K0.b bVar3) {
        this.f1212a = i4;
        this.f1213b = bVar;
        this.f1214c = bVar2;
        this.f1215d = bVar3;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new s(bVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f1213b + ", end: " + this.f1214c + ", offset: " + this.f1215d + "}";
    }
}
