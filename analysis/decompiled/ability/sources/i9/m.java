package i9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class m implements i, InterfaceC1568c {

    /* renamed from: a, reason: collision with root package name */
    public final i f4625a;
    public final int b;
    public final int c;

    public m(i sequence, int i, int i6) {
        kotlin.jvm.internal.k.f(sequence, "sequence");
        this.f4625a = sequence;
        this.b = i;
        this.c = i6;
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "startIndex should be non-negative, but is ").toString());
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "endIndex should be non-negative, but is ").toString());
        }
        if (i6 < i) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(i6, i, "endIndex should be not less than startIndex, but was ", " < ").toString());
        }
    }

    @Override // i9.InterfaceC1568c
    public final i a(int i) {
        int i6 = this.c;
        int i10 = this.b;
        return i >= i6 - i10 ? C1569d.f4618a : new m(this.f4625a, i10 + i, i6);
    }

    @Override // i9.InterfaceC1568c
    public final i b(int i) {
        int i6 = this.c;
        int i10 = this.b;
        return i >= i6 - i10 ? this : new m(this.f4625a, i10, i + i10);
    }

    @Override // i9.i
    public final Iterator iterator() {
        return new h(this);
    }
}
