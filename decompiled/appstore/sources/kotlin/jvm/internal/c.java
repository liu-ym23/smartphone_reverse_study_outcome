package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends kotlin.collections.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f21160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21161b;

    public c(char[] r10) {
        q.g(r10, "array");
        this.f21160a = r10;
    }

    @Override // kotlin.collections.r
    public char a() {
        char[] r10 = this.f21160a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21161b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21161b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21161b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21161b >= this.f21160a.length) goto L5;
        return true;
    L5:
        return false;
    }
}
