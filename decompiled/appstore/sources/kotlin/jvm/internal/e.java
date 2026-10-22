package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f21164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21165b;

    public e(float[] r10) {
        q.g(r10, "array");
        this.f21164a = r10;
    }

    @Override // kotlin.collections.e0
    public float a() {
        float[] r10 = this.f21164a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21165b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21165b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21165b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21165b >= this.f21164a.length) goto L5;
        return true;
    L5:
        return false;
    }
}
