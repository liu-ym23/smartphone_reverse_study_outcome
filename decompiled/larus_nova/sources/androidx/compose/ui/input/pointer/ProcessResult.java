package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/ProcessResult;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "dispatchedToAPointerInputModifier", "", "getDispatchedToAPointerInputModifier-impl", "(I)Z", "anyMovementConsumed", "getAnyMovementConsumed-impl", "anyChangeConsumed", "getAnyChangeConsumed-impl", "equals", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ProcessResult {
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ProcessResult m6209boximpl(int r100) {
        return new ProcessResult(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6210constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6211equalsimpl(int r100, Object r101) {
        if ((r101 instanceof ProcessResult) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ProcessResult) r101).m6218unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6212equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: getAnyChangeConsumed-impl, reason: not valid java name */
    public static final boolean m6213getAnyChangeConsumedimpl(int r100) {
        if ((r100 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getAnyMovementConsumed-impl, reason: not valid java name */
    public static final boolean m6214getAnyMovementConsumedimpl(int r100) {
        if ((r100 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getDispatchedToAPointerInputModifier-impl, reason: not valid java name */
    public static final boolean m6215getDispatchedToAPointerInputModifierimpl(int r100) {
        if ((r100 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6216hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6217toStringimpl(int r100) {
        return "ProcessResult(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m6211equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6216hashCodeimpl(this.value);
    }

    public String toString() {
        return m6217toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6218unboximpl() {
        return this.value;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ ProcessResult(int r100) {
        this.value = r100;
    }
}
