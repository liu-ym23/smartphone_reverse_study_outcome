package kotlin.jvm.internal;

import D7.G;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class b extends G {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f4922a;
    public int b;

    public b(long[] array) {
        k.f(array, "array");
        this.f4922a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f4922a.length;
    }

    @Override // D7.G
    public final long nextLong() {
        try {
            long[] jArr = this.f4922a;
            int i = this.b;
            this.b = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
