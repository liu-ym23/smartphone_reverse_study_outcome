package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerId;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0018J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u001c\u0010\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0018H\u0086\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0005H\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u001eJ\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b%\u0010\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "", "<init>", "()V", "value", "", "size", "getSize", "()I", "lastIndex", "getLastIndex", "internalArray", "", MonitorConstants.CONNECT_TYPE_GET, "Landroidx/compose/ui/input/pointer/PointerId;", "index", "get-_I2yYro", "(I)J", "remove", "", "pointerId", "remove-0FcD4WY", "(J)Z", "pointerIdValue", "", "removeAt", "isEmpty", "add", "add-0FcD4WY", "set", "", "resizeStorage", "minSize", "set-DmW0f2w", "(IJ)V", "clear", "contains", "contains-0FcD4WY", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerIdArray {
    public static final int $stable = 8;
    private long[] internalArray;
    private int size;

    public final void clear() {
        this.size = 0;
    }

    public final boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PointerIdArray() {
        this.internalArray = new long[2];
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    private final long[] resizeStorage(int r100) {
        long[] r101 = this.internalArray;
        long[] r102 = Arrays.copyOf(r101, Math.max(r100, r101.length * 2));
        this.internalArray = r102;
        return r102;
    }

    public final boolean add(long r100) {
        if (contains(r100) == true) goto L6;
        set(this.size, r100);
        return true;
    L6:
        return false;
    }

    /* JADX INFO: renamed from: add-0FcD4WY, reason: not valid java name */
    public final boolean m6219add0FcD4WY(long r100) {
        return add(r100);
    }

    public final boolean contains(long r100) {
        int r101 = this.size;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (this.internalArray[r102] == r100) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    /* JADX INFO: renamed from: contains-0FcD4WY, reason: not valid java name */
    public final boolean m6220contains0FcD4WY(long r100) {
        return contains(r100);
    }

    /* JADX INFO: renamed from: get-_I2yYro, reason: not valid java name */
    public final long m6221get_I2yYro(int r100) {
        return PointerId.m6106constructorimpl(this.internalArray[r100]);
    }

    public final boolean remove(long r100) {
        int r101 = this.size;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        if (r100 == this.internalArray[r102]) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        int r103 = this.size - 1;
    L7:
        if (r102 >= r103) goto L9;
        long[] r104 = this.internalArray;
        int r105 = r102 + 1;
        r104[r102] = r104[r105];
        r102 = r105;
        goto L7
    L9:
        this.size--;
        return true;
    L12:
        return false;
    }

    /* JADX INFO: renamed from: remove-0FcD4WY, reason: not valid java name */
    public final boolean m6222remove0FcD4WY(long r100) {
        return remove(r100);
    }

    public final boolean removeAt(int r100) {
        int r101 = this.size;
        if (r100 >= r101) goto L9;
        int r102 = r101 - 1;
    L5:
        if (r100 >= r102) goto L7;
        long[] r103 = this.internalArray;
        int r104 = r100 + 1;
        r103[r100] = r103[r104];
        r100 = r104;
        goto L5
    L7:
        this.size--;
        return true;
    L9:
        return false;
    }

    public final void set(int r100, long r101) {
        long[] r102 = this.internalArray;
        if (r100 < r102.length) goto L5;
        r102 = resizeStorage(r100 + 1);
    L5:
        r102[r100] = r101;
        if (r100 < this.size) goto L9;
        this.size = r100 + 1;
        return;
    }

    /* JADX INFO: renamed from: set-DmW0f2w, reason: not valid java name */
    public final void m6223setDmW0f2w(int r100, long r101) {
        set(r100, r101);
    }
}
