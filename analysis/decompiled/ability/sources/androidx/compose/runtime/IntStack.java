package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\rJ\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0014H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\r¨\u0006 "}, d2 = {"Landroidx/compose/runtime/IntStack;", "", AppAgent.CONSTRUCT, "()V", "", "resize", "()[I", "", "value", "LC7/r;", "push", "(I)V", "pop", "()I", "default", "peekOr", "(I)I", "peek", "peek2", "index", "", "isEmpty", "()Z", "isNotEmpty", "clear", "indexOf", "slots", "[I", "tos", "I", "getSize", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntStack {
    public static final int $stable = 8;
    public int[] slots = new int[10];
    public int tos;

    private final int[] resize() {
        int[] iArr = this.slots;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
        kotlin.jvm.internal.k.e(iArrCopyOf, "copyOf(...)");
        this.slots = iArrCopyOf;
        return iArrCopyOf;
    }

    public final void clear() {
        this.tos = 0;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getTos() {
        return this.tos;
    }

    public final int indexOf(int value) {
        int[] iArr = this.slots;
        int iMin = Math.min(iArr.length, this.tos);
        for (int i = 0; i < iMin; i++) {
            if (iArr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.tos == 0;
    }

    public final boolean isNotEmpty() {
        return this.tos != 0;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peek2() {
        return this.slots[this.tos - 2];
    }

    public final int peekOr(int i) {
        int i6 = this.tos - 1;
        return i6 >= 0 ? this.slots[i6] : i;
    }

    public final int pop() {
        int[] iArr = this.slots;
        int i = this.tos - 1;
        this.tos = i;
        return iArr[i];
    }

    public final void push(int value) {
        int[] iArrResize = this.slots;
        if (this.tos >= iArrResize.length) {
            iArrResize = resize();
        }
        int i = this.tos;
        this.tos = i + 1;
        iArrResize[i] = value;
    }

    public final int peek(int index) {
        return this.slots[index];
    }
}
