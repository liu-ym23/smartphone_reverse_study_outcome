package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class w {

    @NotNull
    private volatile AtomicReferenceArray<Object> array;

    public w(int r10) {
        this.array = new AtomicReferenceArray(r10);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int r10) {
        AtomicReferenceArray<Object> r11 = this.array;
        if (r10 < r11.length()) goto L7;
        return null;
    L7:
        return r11.get(r10);
    }

    public final void c(int r10, Object r11) {
        AtomicReferenceArray<Object> r12 = this.array;
        int r13 = r12.length();
        if (r10 >= r13) goto L6;
        r12.set(r10, r11);
        return;
    L6:
        AtomicReferenceArray<Object> r14 = new AtomicReferenceArray(bg.h.d(r10 + 1, r13 * 2));
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        r14.set(r15, r12.get(r15));
        r15 = r15 + 1;
        goto L7
    L9:
        r14.set(r10, r11);
        this.array = r14;
    }
}
