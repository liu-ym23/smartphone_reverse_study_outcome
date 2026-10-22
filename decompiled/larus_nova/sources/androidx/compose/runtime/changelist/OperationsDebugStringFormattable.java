package androidx.compose.runtime.changelist;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "", "<init>", "()V", "toDebugString", "", "linePrefix", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OperationsDebugStringFormattable {
    public static final int $stable = 0;

    public OperationsDebugStringFormattable() {
    }

    public abstract String toDebugString(String r100);

    public static /* synthetic */ String toDebugString$default(OperationsDebugStringFormattable r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = tb2.c.DEFAULT_TEXT;
    L7:
        return r100.toDebugString(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
    }
}
