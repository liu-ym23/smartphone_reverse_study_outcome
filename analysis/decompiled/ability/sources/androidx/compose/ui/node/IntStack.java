package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\"\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J%\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u000fJ\r\u0010(\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0018¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\r¢\u0006\u0004\b,\u0010-R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010.R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0011\u0010&\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010)¨\u00062"}, d2 = {"Landroidx/compose/ui/node/IntStack;", "", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "", "stack", "resizeStack", "([I)[I", "start", "end", "elSize", "LC7/r;", "quickSort", "(III)V", "partition", "(III)I", "i", "j", "swapDiagonal", "(II)V", "a", "b", "", "compareDiagonal", "(II)Z", "index", "get", "(I)I", "oldStart", "oldEnd", "newStart", "newEnd", "pushRange", "(IIII)V", "x", "y", "size", "pushDiagonal", "pop", "()I", "isNotEmpty", "()Z", "sortDiagonals", "()V", "[I", "lastIndex", "I", "getSize", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class IntStack {
    private int lastIndex;
    private int[] stack;

    public IntStack(int i) {
        this.stack = new int[i];
    }

    private final boolean compareDiagonal(int a3, int b) {
        int[] iArr = this.stack;
        int i = iArr[a3];
        int i6 = iArr[b];
        return i < i6 || (i == i6 && iArr[a3 + 1] <= iArr[b + 1]);
    }

    private final int partition(int start, int end, int elSize) {
        int i = start - elSize;
        while (start < end) {
            if (compareDiagonal(start, end)) {
                i += elSize;
                swapDiagonal(i, start);
            }
            start += elSize;
        }
        int i6 = i + elSize;
        swapDiagonal(i6, end);
        return i6;
    }

    private final void quickSort(int start, int end, int elSize) {
        if (start < end) {
            int iPartition = partition(start, end, elSize);
            quickSort(start, iPartition - elSize, elSize);
            quickSort(iPartition + elSize, end, elSize);
        }
    }

    private final int[] resizeStack(int[] stack) {
        int[] iArrCopyOf = Arrays.copyOf(stack, stack.length * 2);
        k.e(iArrCopyOf, "copyOf(...)");
        this.stack = iArrCopyOf;
        return iArrCopyOf;
    }

    private final void swapDiagonal(int i, int j5) {
        int[] iArr = this.stack;
        MyersDiffKt.swap(iArr, i, j5);
        MyersDiffKt.swap(iArr, i + 1, j5 + 1);
        MyersDiffKt.swap(iArr, i + 2, j5 + 2);
    }

    public final int get(int index) {
        return this.stack[index];
    }

    /* renamed from: getSize, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final int pop() {
        int[] iArr = this.stack;
        int i = this.lastIndex - 1;
        this.lastIndex = i;
        return iArr[i];
    }

    public final void pushDiagonal(int x10, int y, int size) {
        int i = this.lastIndex;
        int[] iArrResizeStack = this.stack;
        int i6 = i + 3;
        if (i6 >= iArrResizeStack.length) {
            iArrResizeStack = resizeStack(iArrResizeStack);
        }
        iArrResizeStack[i] = x10 + size;
        iArrResizeStack[i + 1] = y + size;
        iArrResizeStack[i + 2] = size;
        this.lastIndex = i6;
    }

    public final void pushRange(int oldStart, int oldEnd, int newStart, int newEnd) {
        int i = this.lastIndex;
        int[] iArrResizeStack = this.stack;
        int i6 = i + 4;
        if (i6 >= iArrResizeStack.length) {
            iArrResizeStack = resizeStack(iArrResizeStack);
        }
        iArrResizeStack[i] = oldStart;
        iArrResizeStack[i + 1] = oldEnd;
        iArrResizeStack[i + 2] = newStart;
        iArrResizeStack[i + 3] = newEnd;
        this.lastIndex = i6;
    }

    public final void sortDiagonals() {
        int i = this.lastIndex;
        if (!(i % 3 == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }
        if (i > 3) {
            quickSort(0, i - 3, 3);
        }
    }
}
