package i9;

import D7.E;
import java.util.Iterator;

/* renamed from: i9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1567b implements i, InterfaceC1568c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4617a;
    public final i b;
    public final int c;

    public C1567b(i sequence, int i, int i6) {
        this.f4617a = i6;
        switch (i6) {
            case 1:
                this.b = sequence;
                this.c = i;
                if (i < 0) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.k("count must be non-negative, but was ", i, '.').toString());
                }
                return;
            default:
                kotlin.jvm.internal.k.f(sequence, "sequence");
                this.b = sequence;
                this.c = i;
                if (i < 0) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.k("count must be non-negative, but was ", i, '.').toString());
                }
                return;
        }
    }

    @Override // i9.InterfaceC1568c
    public final i a(int i) {
        switch (this.f4617a) {
            case 0:
                int i6 = this.c + i;
                return i6 < 0 ? new C1567b(this, i, 0) : new C1567b(this.b, i6, 0);
            default:
                int i10 = this.c;
                return i >= i10 ? C1569d.f4618a : new m(this.b, i, i10);
        }
    }

    @Override // i9.InterfaceC1568c
    public final i b(int i) {
        switch (this.f4617a) {
            case 0:
                int i6 = this.c;
                int i10 = i6 + i;
                return i10 < 0 ? new C1567b(this, i, 1) : new m(this.b, i6, i10);
            default:
                return i >= this.c ? this : new C1567b(this.b, i, 1);
        }
    }

    @Override // i9.i
    public final Iterator iterator() {
        switch (this.f4617a) {
            case 0:
                return new E(this);
            default:
                return new E(this, (byte) 0);
        }
    }
}
