package kotlin.ranges;

import W3.C;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g extends C {

    /* renamed from: a, reason: collision with root package name */
    private final int f17965a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17966b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17967c;

    /* renamed from: d, reason: collision with root package name */
    private int f17968d;

    public g(int i5, int i6, int i7) {
        this.f17965a = i7;
        this.f17966b = i6;
        boolean z5 = false;
        if (i7 <= 0 ? i5 >= i6 : i5 <= i6) {
            z5 = true;
        }
        this.f17967c = z5;
        this.f17968d = z5 ? i5 : i6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17967c;
    }

    @Override // W3.C
    public int nextInt() {
        int i5 = this.f17968d;
        if (i5 != this.f17966b) {
            this.f17968d = this.f17965a + i5;
            return i5;
        }
        if (!this.f17967c) {
            throw new NoSuchElementException();
        }
        this.f17967c = false;
        return i5;
    }
}
