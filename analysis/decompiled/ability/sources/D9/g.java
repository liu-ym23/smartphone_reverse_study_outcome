package D9;

/* loaded from: classes4.dex */
public final class g extends C4.a {
    public final boolean e;

    public g(B1.b bVar, boolean z10) {
        super(bVar);
        this.e = z10;
    }

    @Override // C4.a
    public final void k(byte b) {
        if (this.e) {
            r(String.valueOf(b & 255));
        } else {
            p(String.valueOf(b & 255));
        }
    }

    @Override // C4.a
    public final void m(int i) {
        boolean z10 = this.e;
        String unsignedString = Integer.toUnsignedString(i);
        if (z10) {
            r(unsignedString);
        } else {
            p(unsignedString);
        }
    }

    @Override // C4.a
    public final void o(long j5) {
        boolean z10 = this.e;
        String unsignedString = Long.toUnsignedString(j5);
        if (z10) {
            r(unsignedString);
        } else {
            p(unsignedString);
        }
    }

    @Override // C4.a
    public final void q(short s5) {
        if (this.e) {
            r(String.valueOf(s5 & 65535));
        } else {
            p(String.valueOf(s5 & 65535));
        }
    }
}
