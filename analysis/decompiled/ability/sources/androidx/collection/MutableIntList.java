package androidx.collection;

import D7.AbstractC0214f;
import D7.C0211c;
import D7.q;
import androidx.annotation.IntRange;
import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0011J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0012J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u0014\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0005J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u001d\u0010\u0005J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010\u0013J\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010 \u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010\"\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\fJ\u0015\u0010%\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b%\u0010\u0013J\u0015\u0010%\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b%\u0010\u0012J\"\u0010&\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u0018J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "element", "", "add", "(I)Z", "index", "LC7/r;", "(II)V", "", "elements", "addAll", "(I[I)Z", "(ILandroidx/collection/IntList;)Z", "(Landroidx/collection/IntList;)Z", "([I)Z", "plusAssign", "(Landroidx/collection/IntList;)V", "([I)V", "clear", "()V", "minCapacity", "trim", "capacity", "ensureCapacity", "minusAssign", "remove", "removeAll", "removeAt", "(I)I", "start", "end", "removeRange", "retainAll", "set", "(II)I", "sort", "sortDescending", "getCapacity", "()I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableIntList._size;
        }
        mutableIntList.trim(i);
    }

    public final boolean add(int element) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i = this._size;
        iArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, int[] elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(this._size + elements.length);
        int[] iArr = this.content;
        int i = this._size;
        if (index != i) {
            q.R(elements.length + index, index, iArr, iArr, i);
        }
        q.Y(index, 0, elements, iArr, 12);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        int[] iArr = this.content;
        if (iArr.length < capacity) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(capacity, (iArr.length * 3) / 2));
            k.e(iArrCopyOf, "copyOf(...)");
            this.content = iArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int element) {
        remove(element);
    }

    public final void plusAssign(IntList elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(int element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(int[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        for (int i6 : elements) {
            remove(i6);
        }
        return i != this._size;
    }

    public final int removeAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        int[] iArr = this.content;
        int i = iArr[index];
        int i6 = this._size;
        if (index != i6 - 1) {
            q.R(index, index + 1, iArr, iArr, i6);
        }
        this._size--;
        return i;
    }

    public final void removeRange(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int start, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int end) {
        int i;
        if (start < 0 || start > (i = this._size) || end < 0 || end > i) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        if (end < start) {
            RuntimeHelpersKt.throwIllegalArgumentException("The end index must be < start index");
        }
        if (end != start) {
            int i6 = this._size;
            if (end < i6) {
                int[] iArr = this.content;
                q.R(start, end, iArr, iArr, i6);
            }
            this._size -= end - start;
        }
    }

    public final boolean retainAll(int[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        int[] iArr = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            int i12 = iArr[i6];
            int length = elements.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (elements[i10] == i12) {
                    i11 = i10;
                    break;
                }
                i10++;
            }
            if (i11 < 0) {
                removeAt(i6);
            }
            i6--;
        }
        return i != this._size;
    }

    public final int set(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, int element) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        int[] iArr = this.content;
        int i = iArr[index];
        iArr[index] = element;
        return i;
    }

    public final void sort() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        int[] iArr = this.content;
        k.f(iArr, "<this>");
        Arrays.sort(iArr, 0, i);
    }

    public final void sortDescending() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        int[] iArr = this.content;
        k.f(iArr, "<this>");
        Arrays.sort(iArr, 0, i);
        C0211c c0211c = AbstractC0214f.Companion;
        int length = iArr.length;
        c0211c.getClass();
        C0211c.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            int i12 = iArr[i11];
            iArr[i11] = iArr[i10];
            iArr[i10] = i12;
            i10--;
        }
    }

    public final void trim(int minCapacity) {
        int iMax = Math.max(minCapacity, this._size);
        int[] iArr = this.content;
        if (iArr.length > iMax) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            k.e(iArrCopyOf, "copyOf(...)");
            this.content = iArrCopyOf;
        }
    }

    public MutableIntList(int i) {
        super(i, null);
    }

    public final void minusAssign(int[] elements) {
        k.f(elements, "elements");
        for (int i : elements) {
            remove(i);
        }
    }

    public final void plusAssign(int[] elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public /* synthetic */ MutableIntList(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public final void plusAssign(int element) {
        add(element);
    }

    public final void add(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, int element) {
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i = this._size;
        if (index != i) {
            q.R(index + 1, index, iArr, iArr, i);
        }
        iArr[index] = element;
        this._size++;
    }

    public final void minusAssign(IntList elements) {
        k.f(elements, "elements");
        int[] iArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(iArr[i6]);
        }
    }

    public final boolean removeAll(IntList elements) {
        k.f(elements, "elements");
        int i = this._size;
        int i6 = elements._size - 1;
        if (i6 >= 0) {
            int i10 = 0;
            while (true) {
                remove(elements.get(i10));
                if (i10 == i6) {
                    break;
                }
                i10++;
            }
        }
        return i != this._size;
    }

    public final boolean retainAll(IntList elements) {
        k.f(elements, "elements");
        int i = this._size;
        int[] iArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!elements.contains(iArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, IntList elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        int i = elements._size;
        if (i == 0) {
            return false;
        }
        ensureCapacity(this._size + i);
        int[] iArr = this.content;
        int i6 = this._size;
        if (index != i6) {
            q.R(elements._size + index, index, iArr, iArr, i6);
        }
        q.R(index, 0, elements.content, iArr, elements._size);
        this._size += elements._size;
        return true;
    }

    public final boolean addAll(IntList elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(int[] elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
