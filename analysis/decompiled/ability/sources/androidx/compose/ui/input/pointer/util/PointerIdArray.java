package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.pointer.PointerId;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u0011J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\u001b\u0010\u0011J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\u001c¢\u0006\u0004\b \u0010\u0003J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0086\b¢\u0006\u0004\b!\u0010\u0011J\u0015\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010\u0011R$\u0010#\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0012\u0010*\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b)\u0010&¨\u0006+"}, d2 = {"Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "", AppAgent.CONSTRUCT, "()V", "", "minSize", "", "resizeStorage", "(I)[J", "index", "Landroidx/compose/ui/input/pointer/PointerId;", "get-_I2yYro", "(I)J", "get", "pointerId", "", "remove-0FcD4WY", "(J)Z", "remove", "", "pointerIdValue", "removeAt", "(I)Z", "isEmpty", "()Z", "value", "add", "add-0FcD4WY", "LC7/r;", "set", "(IJ)V", "set-DmW0f2w", "clear", "contains-0FcD4WY", "contains", "size", "I", "getSize", "()I", "internalArray", "[J", "getLastIndex", "lastIndex", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerIdArray {
    public static final int $stable = 8;
    private long[] internalArray = new long[2];
    private int size;

    private final long[] resizeStorage(int minSize) {
        long[] jArr = this.internalArray;
        long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(minSize, jArr.length * 2));
        k.e(jArrCopyOf, "copyOf(...)");
        this.internalArray = jArrCopyOf;
        return jArrCopyOf;
    }

    public final boolean add(long value) {
        if (contains(value)) {
            return false;
        }
        set(this.size, value);
        return true;
    }

    /* renamed from: add-0FcD4WY, reason: not valid java name */
    public final boolean m5513add0FcD4WY(long pointerId) {
        return add(pointerId);
    }

    public final void clear() {
        this.size = 0;
    }

    public final boolean contains(long pointerIdValue) {
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.internalArray[i6] == pointerIdValue) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: contains-0FcD4WY, reason: not valid java name */
    public final boolean m5514contains0FcD4WY(long pointerId) {
        return contains(pointerId);
    }

    /* renamed from: get-_I2yYro, reason: not valid java name */
    public final long m5515get_I2yYro(int index) {
        return PointerId.m5401constructorimpl(this.internalArray[index]);
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean remove(long pointerIdValue) {
        int i = this.size;
        int i6 = 0;
        while (i6 < i) {
            if (pointerIdValue == this.internalArray[i6]) {
                int i10 = this.size - 1;
                while (i6 < i10) {
                    long[] jArr = this.internalArray;
                    int i11 = i6 + 1;
                    jArr[i6] = jArr[i11];
                    i6 = i11;
                }
                this.size--;
                return true;
            }
            i6++;
        }
        return false;
    }

    /* renamed from: remove-0FcD4WY, reason: not valid java name */
    public final boolean m5516remove0FcD4WY(long pointerId) {
        return remove(pointerId);
    }

    public final boolean removeAt(int index) {
        int i = this.size;
        if (index >= i) {
            return false;
        }
        int i6 = i - 1;
        while (index < i6) {
            long[] jArr = this.internalArray;
            int i10 = index + 1;
            jArr[index] = jArr[i10];
            index = i10;
        }
        this.size--;
        return true;
    }

    public final void set(int index, long value) {
        long[] jArrResizeStorage = this.internalArray;
        if (index >= jArrResizeStorage.length) {
            jArrResizeStorage = resizeStorage(index + 1);
        }
        jArrResizeStorage[index] = value;
        if (index >= this.size) {
            this.size = index + 1;
        }
    }

    /* renamed from: set-DmW0f2w, reason: not valid java name */
    public final void m5517setDmW0f2w(int index, long pointerId) {
        set(index, pointerId);
    }
}
