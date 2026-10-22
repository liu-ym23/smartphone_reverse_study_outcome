package Y7;

import D7.F;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class e extends F {

    /* renamed from: a, reason: collision with root package name */
    public final int f1570a;
    public final int b;
    public boolean c;
    public int d;

    public e(int i, int i6, int i10) {
        this.f1570a = i10;
        this.b = i6;
        boolean z10 = false;
        if (i10 <= 0 ? i >= i6 : i <= i6) {
            z10 = true;
        }
        this.c = z10;
        this.d = z10 ? i : i6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // D7.F
    public final int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f1570a + i;
            return i;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i;
    }
}
