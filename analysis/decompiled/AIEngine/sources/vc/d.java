package vc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends hb.c {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13496c;

    public d(l5.a aVar, boolean z) {
        super(aVar);
        this.f13496c = z;
    }

    @Override // hb.c
    public final void k(String value) {
        kotlin.jvm.internal.g.f(value, "value");
        if (this.f13496c) {
            super.k(value);
        } else {
            i(value);
        }
    }
}
