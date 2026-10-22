package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends kotlin.collections.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f21158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21159b;

    public b(byte[] r10) {
        q.g(r10, "array");
        this.f21158a = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21159b >= this.f21158a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.q
    public byte nextByte() {
        byte[] r10 = this.f21158a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21159b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21159b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21159b--;
        throw new NoSuchElementException(e.getMessage());
    }
}
