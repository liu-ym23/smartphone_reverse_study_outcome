package vc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends hb.c {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13497c;

    public e(l5.a aVar, boolean z) {
        super(aVar);
        this.f13497c = z;
    }

    @Override // hb.c
    public final void e(byte b10) {
        if (this.f13497c) {
            k(String.valueOf(b10 & 255));
        } else {
            i(String.valueOf(b10 & 255));
        }
    }

    @Override // hb.c
    public final void g(int i10) {
        boolean z = this.f13497c;
        String unsignedString = Integer.toUnsignedString(i10);
        if (z) {
            k(unsignedString);
        } else {
            i(unsignedString);
        }
    }

    @Override // hb.c
    public final void h(long j10) {
        boolean z = this.f13497c;
        String unsignedString = Long.toUnsignedString(j10);
        if (z) {
            k(unsignedString);
        } else {
            i(unsignedString);
        }
    }

    @Override // hb.c
    public final void j(short s8) {
        if (this.f13497c) {
            k(String.valueOf(s8 & 65535));
        } else {
            i(String.valueOf(s8 & 65535));
        }
    }
}
