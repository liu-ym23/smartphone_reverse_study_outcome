package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.t0;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f21172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21173b;

    public k(short[] r10) {
        q.g(r10, "array");
        this.f21172a = r10;
    }

    @Override // kotlin.collections.t0
    public short a() {
        short[] r10 = this.f21172a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21173b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21173b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21173b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21173b >= this.f21172a.length) goto L5;
        return true;
    L5:
        return false;
    }
}
