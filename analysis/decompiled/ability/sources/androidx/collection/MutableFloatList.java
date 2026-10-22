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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b!\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0015\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0014J\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\u0013J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\f2\b\b\u0001\u0010$\u001a\u00020\u00022\b\b\u0001\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b(\u0010\u0014J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b(\u0010\u0013J\"\u0010)\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\f¢\u0006\u0004\b+\u0010\u0019J\r\u0010,\u001a\u00020\f¢\u0006\u0004\b,\u0010\u0019R\u0012\u0010\u001c\u001a\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/collection/MutableFloatList;", "Landroidx/collection/FloatList;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "", "element", "", "add", "(F)Z", "index", "LC7/r;", "(IF)V", "", "elements", "addAll", "(I[F)Z", "(ILandroidx/collection/FloatList;)Z", "(Landroidx/collection/FloatList;)Z", "([F)Z", "plusAssign", "(Landroidx/collection/FloatList;)V", "([F)V", "clear", "()V", "minCapacity", "trim", "capacity", "ensureCapacity", "(F)V", "minusAssign", "remove", "removeAll", "removeAt", "(I)F", "start", "end", "removeRange", "(II)V", "retainAll", "set", "(IF)F", "sort", "sortDescending", "getCapacity", "()I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableFloatList._size;
        }
        mutableFloatList.trim(i);
    }

    public final boolean add(float element) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i = this._size;
        fArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, float[] elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(this._size + elements.length);
        float[] fArr = this.content;
        int i = this._size;
        if (index != i) {
            q.V(fArr, elements.length + index, fArr, index, i);
        }
        q.Z(elements, index, fArr, 12);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        float[] fArr = this.content;
        if (fArr.length < capacity) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, Math.max(capacity, (fArr.length * 3) / 2));
            k.e(fArrCopyOf, "copyOf(...)");
            this.content = fArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float element) {
        remove(element);
    }

    public final void plusAssign(FloatList elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(float element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(float[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        for (float f : elements) {
            remove(f);
        }
        return i != this._size;
    }

    public final float removeAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        float[] fArr = this.content;
        float f = fArr[index];
        int i = this._size;
        if (index != i - 1) {
            q.V(fArr, index, fArr, index + 1, i);
        }
        this._size--;
        return f;
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
                float[] fArr = this.content;
                q.V(fArr, start, fArr, end, i6);
            }
            this._size -= end - start;
        }
    }

    public final boolean retainAll(float[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        float[] fArr = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            float f = fArr[i6];
            int length = elements.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (elements[i10] == f) {
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

    public final float set(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, float element) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        float[] fArr = this.content;
        float f = fArr[index];
        fArr[index] = element;
        return f;
    }

    public final void sort() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        float[] fArr = this.content;
        k.f(fArr, "<this>");
        Arrays.sort(fArr, 0, i);
    }

    public final void sortDescending() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        float[] fArr = this.content;
        k.f(fArr, "<this>");
        Arrays.sort(fArr, 0, i);
        C0211c c0211c = AbstractC0214f.Companion;
        int length = fArr.length;
        c0211c.getClass();
        C0211c.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            float f = fArr[i11];
            fArr[i11] = fArr[i10];
            fArr[i10] = f;
            i10--;
        }
    }

    public final void trim(int minCapacity) {
        int iMax = Math.max(minCapacity, this._size);
        float[] fArr = this.content;
        if (fArr.length > iMax) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, iMax);
            k.e(fArrCopyOf, "copyOf(...)");
            this.content = fArrCopyOf;
        }
    }

    public MutableFloatList(int i) {
        super(i, null);
    }

    public final void minusAssign(float[] elements) {
        k.f(elements, "elements");
        for (float f : elements) {
            remove(f);
        }
    }

    public final void plusAssign(float[] elements) {
        k.f(elements, "elements");
        addAll(this._size, elements);
    }

    public /* synthetic */ MutableFloatList(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public final void plusAssign(float element) {
        add(element);
    }

    public final void add(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, float element) {
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i = this._size;
        if (index != i) {
            q.V(fArr, index + 1, fArr, index, i);
        }
        fArr[index] = element;
        this._size++;
    }

    public final void minusAssign(FloatList elements) {
        k.f(elements, "elements");
        float[] fArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(fArr[i6]);
        }
    }

    public final boolean removeAll(FloatList elements) {
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

    public final boolean retainAll(FloatList elements) {
        k.f(elements, "elements");
        int i = this._size;
        float[] fArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!elements.contains(fArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, FloatList elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        int i = elements._size;
        if (i == 0) {
            return false;
        }
        ensureCapacity(this._size + i);
        float[] fArr = this.content;
        int i6 = this._size;
        if (index != i6) {
            q.V(fArr, elements._size + index, fArr, index, i6);
        }
        q.V(elements.content, index, fArr, 0, elements._size);
        this._size += elements._size;
        return true;
    }

    public final boolean addAll(FloatList elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(float[] elements) {
        k.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
