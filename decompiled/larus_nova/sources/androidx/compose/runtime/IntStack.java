package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\t\u0010\u0015\u001a\u00020\u0016H\u0086\bJ\t\u0010\u0017\u001a\u00020\u0016H\u0086\bJ\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/IntStack;", "", "<init>", "()V", "slots", "", "tos", "", "size", "getSize", "()I", "resize", "push", "", "value", "pop", "peekOr", "default", "peek", "peek2", "index", "isEmpty", "", "isNotEmpty", "clear", "indexOf", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntStack {
    public static final int $stable = 8;
    public int[] slots;
    public int tos;

    public final void clear() {
        this.tos = 0;
    }

    private final int[] resize() {
        int[] r100 = this.slots;
        int[] r101 = Arrays.copyOf(r100, r100.length * 2);
        this.slots = r101;
        return r101;
    }

    public final boolean isEmpty() {
        if (this.tos != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this.tos == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peek2() {
        return this.slots[this.tos - 2];
    }

    public final int pop() {
        int[] r100 = this.slots;
        int r101 = this.tos - 1;
        this.tos = r101;
        return r100[r101];
    }

    public IntStack() {
        this.slots = new int[10];
    }

    public final int getSize() {
        return this.tos;
    }

    public final int indexOf(int r100) {
        int[] r101 = this.slots;
        int r102 = Math.min(r101.length, this.tos);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101[r103] == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return -1;
    }

    public final int peek(int r100) {
        return this.slots[r100];
    }

    public final int peekOr(int r100) {
        int r101 = this.tos - 1;
        if (r101 >= 0) goto L5;
        return r100;
    L5:
        return this.slots[r101];
    }

    public final void push(int r100) {
        int[] r101 = this.slots;
        if (this.tos < r101.length) goto L5;
        r101 = resize();
    L5:
        int r102 = this.tos;
        this.tos = r102 + 1;
        r101[r102] = r100;
    }
}
