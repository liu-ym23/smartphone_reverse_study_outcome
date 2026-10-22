package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends kotlin.collections.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean[] f21156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21157b;

    public a(boolean[] r10) {
        q.g(r10, "array");
        this.f21156a = r10;
    }

    @Override // kotlin.collections.p
    public boolean a() {
        boolean[] r10 = this.f21156a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21157b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21157b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21157b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21157b >= this.f21156a.length) goto L5;
        return true;
    L5:
        return false;
    }
}
