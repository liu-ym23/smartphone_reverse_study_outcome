package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/internal/IntRef;", "", "element", "", "<init>", "(I)V", "getElement", "()I", "setElement", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntRef {
    public static final int $stable = 8;
    private int element;

    public IntRef() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public String toString() {
        return "IntRef(element = " + this.element + ")@" + Integer.toString(hashCode(), CharsKt.checkRadix(16));
    }

    public final int getElement() {
        return this.element;
    }

    public IntRef(int r100) {
        this.element = r100;
    }

    public final void setElement(int r100) {
        this.element = r100;
    }

    public /* synthetic */ IntRef(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
