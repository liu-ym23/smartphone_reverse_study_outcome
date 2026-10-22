package w3;

import r3.C5210d;
import r3.C5214h;
import t3.C5506b;
import z2.N8;

/* renamed from: w3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5729f {

    /* renamed from: a, reason: collision with root package name */
    public final C5731h f43063a;

    /* renamed from: b, reason: collision with root package name */
    public final C5210d f43064b;

    /* renamed from: c, reason: collision with root package name */
    public final C5214h f43065c;

    public C5729f(C5731h c5731h, C5210d c5210d, C5214h c5214h) {
        this.f43063a = c5731h;
        this.f43064b = c5210d;
        this.f43065c = c5214h;
    }

    public final C5730g a(C5506b c5506b) {
        return new C5730g(c5506b, (k) this.f43063a.b(c5506b), this.f43064b.a(c5506b.c()), N8.b(C5725b.d()), this.f43065c);
    }
}
