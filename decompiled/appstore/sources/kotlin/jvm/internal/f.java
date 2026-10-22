package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.g0;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21167b;

    public f(int[] r10) {
        q.g(r10, "array");
        this.f21166a = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21167b >= this.f21166a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.g0
    public int nextInt() {
        int[] r10 = this.f21166a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21167b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21167b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21167b--;
        throw new NoSuchElementException(e.getMessage());
    }
}
