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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b!\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0015\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0014J\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\u0013J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\f2\b\b\u0001\u0010$\u001a\u00020\u00022\b\b\u0001\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b(\u0010\u0014J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b(\u0010\u0013J\"\u0010)\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\f¢\u0006\u0004\b+\u0010\u0019J\r\u0010,\u001a\u00020\f¢\u0006\u0004\b,\u0010\u0019R\u0012\u0010\u001c\u001a\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/collection/MutableLongList;", "Landroidx/collection/LongList;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "", "element", "", "add", "(J)Z", "index", "LC7/r;", "(IJ)V", "", "elements", "addAll", "(I[J)Z", "(ILandroidx/collection/LongList;)Z", "(Landroidx/collection/LongList;)Z", "([J)Z", "plusAssign", "(Landroidx/collection/LongList;)V", "([J)V", "clear", "()V", "minCapacity", "trim", "capacity", "ensureCapacity", "(J)V", "minusAssign", "remove", "removeAll", "removeAt", "(I)J", "start", "end", "removeRange", "(II)V", "retainAll", "set", "(IJ)J", "sort", "sortDescending", "getCapacity", "()I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableLongList._size;
        }
        mutableLongList.trim(i);
    }

    public final boolean add(long element) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i = this._size;
        jArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, long[] elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(this._size + elements.length);
        long[] jArr = this.content;
        int i = this._size;
        if (index != i) {
            q.W(jArr, jArr, elements.length + index, index, i);
        }
        q.W(elements, jArr, index, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        long[] jArr = this.content;
        if (jArr.length < capacity) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(capacity, (jArr.length * 3) / 2));
            k.e(jArrCopyOf, "copyOf(...)");
            this.content = jArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(long element) {
        remove(element);
    }

    public final void plusAssign(LongList elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(long element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(long[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        for (long j5 : elements) {
            remove(j5);
        }
        return i != this._size;
    }

    public final long removeAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        long[] jArr = this.content;
        long j5 = jArr[index];
        int i = this._size;
        if (index != i - 1) {
            q.W(jArr, jArr, index, index + 1, i);
        }
        this._size--;
        return j5;
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
                long[] jArr = this.content;
                q.W(jArr, jArr, start, end, i6);
            }
            this._size -= end - start;
        }
    }

    public final boolean retainAll(long[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        long[] jArr = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            long j5 = jArr[i6];
            int length = elements.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (elements[i10] == j5) {
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

    public final long set(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, long element) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        long[] jArr = this.content;
        long j5 = jArr[index];
        jArr[index] = element;
        return j5;
    }

    public final void sort() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        long[] jArr = this.content;
        k.f(jArr, "<this>");
        Arrays.sort(jArr, 0, i);
    }

    public final void sortDescending() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        long[] jArr = this.content;
        k.f(jArr, "<this>");
        Arrays.sort(jArr, 0, i);
        C0211c c0211c = AbstractC0214f.Companion;
        int length = jArr.length;
        c0211c.getClass();
        C0211c.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            long j5 = jArr[i11];
            jArr[i11] = jArr[i10];
            jArr[i10] = j5;
            i10--;
        }
    }

    public final void trim(int minCapacity) {
        int iMax = Math.max(minCapacity, this._size);
        long[] jArr = this.content;
        if (jArr.length > iMax) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            k.e(jArrCopyOf, "copyOf(...)");
            this.content = jArrCopyOf;
        }
    }

    public MutableLongList(int i) {
        super(i, null);
    }

    public final void minusAssign(long[] elements) {
        k.f(elements, "elements");
        for (long j5 : elements) {
            remove(j5);
        }
    }

    public final void plusAssign(long[] elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public /* synthetic */ MutableLongList(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public final void plusAssign(long element) {
        add(element);
    }

    public final void add(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, long element) {
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i = this._size;
        if (index != i) {
            q.W(jArr, jArr, index + 1, index, i);
        }
        jArr[index] = element;
        this._size++;
    }

    public final void minusAssign(LongList elements) {
        k.f(elements, "elements");
        long[] jArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(jArr[i6]);
        }
    }

    public final boolean removeAll(LongList elements) {
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

    public final boolean retainAll(LongList elements) {
        k.f(elements, "elements");
        int i = this._size;
        long[] jArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!elements.contains(jArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, LongList elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        int i = elements._size;
        if (i == 0) {
            return false;
        }
        ensureCapacity(this._size + i);
        long[] jArr = this.content;
        int i6 = this._size;
        if (index != i6) {
            q.W(jArr, jArr, elements._size + index, index, i6);
        }
        q.W(elements.content, jArr, index, 0, elements._size);
        this._size += elements._size;
        return true;
    }

    public final boolean addAll(LongList elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(long[] elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
