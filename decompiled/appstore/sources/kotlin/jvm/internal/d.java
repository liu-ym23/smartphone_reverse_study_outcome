package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.c0;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f21162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21163b;

    public d(double[] r10) {
        q.g(r10, "array");
        this.f21162a = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21163b >= this.f21162a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.c0
    public double nextDouble() {
        double[] r10 = this.f21162a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21163b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21163b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21163b--;
        throw new NoSuchElementException(e.getMessage());
    }
}
