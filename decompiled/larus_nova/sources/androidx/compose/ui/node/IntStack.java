package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J \u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "<init>", "(I)V", "stack", "", "lastIndex", MonitorConstants.CONNECT_TYPE_GET, "index", "size", "getSize", "()I", "resizeStack", "pushRange", "", "oldStart", "oldEnd", "newStart", "newEnd", "pushDiagonal", "x", "y", "pop", "isNotEmpty", "", "sortDiagonals", "quickSort", "start", "end", "elSize", "partition", "swapDiagonal", RXScreenCaptureService.KEY_INDEX, ce.f26395j, "compareDiagonal", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IntStack {
    private int lastIndex;
    private int[] stack;

    public final boolean isNotEmpty() {
        if (this.lastIndex == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int pop() {
        int[] r100 = this.stack;
        int r101 = this.lastIndex - 1;
        this.lastIndex = r101;
        return r100[r101];
    }

    public final void sortDiagonals() {
        int r100 = this.lastIndex;
        if ((r100 % 3) != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
    L9:
        if (r100 <= 3) goto L12;
        quickSort(0, r100 - 3, 3);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final int getSize() {
        return this.lastIndex;
    }

    public IntStack(int r100) {
        this.stack = new int[r100];
    }

    private final int[] resizeStack(int[] r100) {
        int[] r101 = Arrays.copyOf(r100, r100.length * 2);
        this.stack = r101;
        return r101;
    }

    public final int get(int r100) {
        return this.stack[r100];
    }

    private final boolean compareDiagonal(int r100, int r101) {
        int[] r102 = this.stack;
        int r103 = r102[r100];
        int r104 = r102[r101];
        if (r103 < r104) goto L10;
        if (r103 == r104) goto L6;
    L8:
        return false;
    L6:
        if (r102[r100 + 1] > r102[r101 + 1]) goto L8;
        return true;
    L10:
        return true;
    }

    private final void swapDiagonal(int r100, int r101) {
        int[] r102 = this.stack;
        MyersDiffKt.access$swap(r102, r100, r101);
        MyersDiffKt.access$swap(r102, r100 + 1, r101 + 1);
        MyersDiffKt.access$swap(r102, r100 + 2, r101 + 2);
    }

    private final int partition(int r100, int r101, int r102) {
        int r103 = r100 - r102;
    L3:
        if (r100 >= r101) goto L8;
        if (compareDiagonal(r100, r101) == false) goto L7;
        r103 = r103 + r102;
        swapDiagonal(r103, r100);
    L7:
        r100 = r100 + r102;
        goto L3
    L8:
        int r104 = r103 + r102;
        swapDiagonal(r104, r101);
        return r104;
    }

    private final void quickSort(int r100, int r101, int r102) {
        if (r100 >= r101) goto L5;
        int r103 = partition(r100, r101, r102);
        quickSort(r100, r103 - r102, r102);
        quickSort(r103 + r102, r101, r102);
        return;
    }

    public final void pushDiagonal(int r100, int r101, int r102) {
        int r103 = this.lastIndex;
        int[] r104 = this.stack;
        int r105 = r103 + 3;
        if (r105 < r104.length) goto L5;
        r104 = resizeStack(r104);
    L5:
        r104[r103 + 0] = r100 + r102;
        r104[r103 + 1] = r101 + r102;
        r104[r103 + 2] = r102;
        this.lastIndex = r105;
    }

    public final void pushRange(int r100, int r101, int r102, int r103) {
        int r104 = this.lastIndex;
        int[] r105 = this.stack;
        int r106 = r104 + 4;
        if (r106 < r105.length) goto L5;
        r105 = resizeStack(r105);
    L5:
        r105[r104 + 0] = r100;
        r105[r104 + 1] = r101;
        r105[r104 + 2] = r102;
        r105[r104 + 3] = r103;
        this.lastIndex = r106;
    }
}
