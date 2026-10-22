package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.h0;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f21170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21171b;

    public j(long[] r10) {
        q.g(r10, "array");
        this.f21170a = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21171b >= this.f21170a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.h0
    public long nextLong() {
        long[] r10 = this.f21170a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21171b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21171b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21171b--;
        throw new NoSuchElementException(e.getMessage());
    }
}
