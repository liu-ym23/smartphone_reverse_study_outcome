package androidx.collection;

import S7.n;
import S7.o;
import Y7.f;
import androidx.annotation.IntRange;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\bJ2\u0010\t\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\t\u0010\fJ2\u0010\r\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u0014\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0014\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0015J2\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0017\u0010\u0016JF\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJL\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001f\u0010 JF\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b!\u0010\u001dJL\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\"\u0010 J2\u0010%\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b%\u0010&J8\u0010'\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\u001aH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b'\u0010(J2\u0010)\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b)\u0010&J8\u0010*\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\u001aH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b*\u0010(J\u001a\u0010,\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u0002¢\u0006\u0004\b.\u0010-J1\u00100\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b2\u0010-J2\u00103\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b3\u0010\u0016J2\u00104\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b4\u0010\u0016J\u0010\u00105\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b5\u0010\bJ\u0010\u00106\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b6\u0010\bJ\r\u00107\u001a\u00020\u0002¢\u0006\u0004\b7\u0010\u0015J2\u00107\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b7\u0010\u0016J\u0015\u00108\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b8\u0010-J+\u0010;\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u0002H\u0007¢\u0006\u0004\b;\u0010<JA\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00022\b\b\u0002\u0010B\u001a\u00020=H\u0007¢\u0006\u0004\bD\u0010EJ[\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00022\b\b\u0002\u0010B\u001a\u00020=2\u0014\b\u0004\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020=0\nH\u0087\bø\u0001\u0000¢\u0006\u0004\bD\u0010GJ\u000f\u0010H\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010\u0015J\u001a\u0010J\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020CH\u0016¢\u0006\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bO\u0010P\u0012\u0004\bQ\u0010RR\u001c\u0010S\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bS\u0010T\u0012\u0004\bU\u0010RR\u0012\u0010W\u001a\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u0012\u0010Y\u001a\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\bX\u0010\u0015R\u0012\u0010]\u001a\u00020Z8Æ\u0002¢\u0006\u0006\u001a\u0004\b[\u0010\\\u0082\u0001\u0001^\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, d2 = {"Landroidx/collection/IntList;", "", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "", "none", "()Z", "any", "Lkotlin/Function1;", "predicate", "(LS7/k;)Z", "reversedAny", "element", "contains", "(I)Z", "elements", "containsAll", "(Landroidx/collection/IntList;)Z", "count", "()I", "(LS7/k;)I", "first", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;LS7/n;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/Object;LS7/o;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "LC7/r;", "block", "forEach", "(LS7/k;)V", "forEachIndexed", "(LS7/n;)V", "forEachReversed", "forEachReversedIndexed", "index", "get", "(I)I", "elementAt", "defaultValue", "elementAtOrElse", "(ILS7/k;)I", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "fromIndex", "toIndex", "binarySearch", "(III)I", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", "content", "[I", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "getSize", "size", "getLastIndex", "lastIndex", "LY7/f;", "getIndices", "()LY7/f;", "indices", "Landroidx/collection/MutableIntList;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntList {
    public int _size;
    public int[] content;

    public /* synthetic */ IntList(int i, e eVar) {
        this(i);
    }

    public static /* synthetic */ int binarySearch$default(IntList intList, int i, int i6, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
        }
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = intList._size;
        }
        return intList.binarySearch(i, i6, i10);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intList.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int binarySearch(int i) {
        return binarySearch$default(this, i, 0, 0, 6, null);
    }

    public final boolean contains(int element) {
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (iArr[i6] == element) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(IntList elements) {
        k.f(elements, "elements");
        f fVarX = AbstractC1451a.X(0, elements._size);
        int i = fVarX.f1569a;
        int i6 = fVarX.b;
        if (i > i6) {
            return true;
        }
        while (contains(elements.get(i))) {
            if (i == i6) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final int elementAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        return this.content[index];
    }

    public final int elementAtOrElse(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, S7.k defaultValue) {
        k.f(defaultValue, "defaultValue");
        return (index < 0 || index >= this._size) ? ((Number) defaultValue.invoke(Integer.valueOf(index))).intValue() : this.content[index];
    }

    public boolean equals(Object other) {
        if (other instanceof IntList) {
            IntList intList = (IntList) other;
            int i = intList._size;
            int i6 = this._size;
            if (i == i6) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                f fVarX = AbstractC1451a.X(0, i6);
                int i10 = fVarX.f1569a;
                int i11 = fVarX.b;
                if (i10 > i11) {
                    return true;
                }
                while (iArr[i10] == iArr2[i10]) {
                    if (i10 == i11) {
                        return true;
                    }
                    i10++;
                }
                return false;
            }
        }
        return false;
    }

    public final int first() {
        if (this._size == 0) {
            RuntimeHelpersKt.throwNoSuchElementException("IntList is empty.");
        }
        return this.content[0];
    }

    public final <R> R fold(R initial, n operation) {
        k.f(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            initial = (R) operation.invoke(initial, Integer.valueOf(iArr[i6]));
        }
        return initial;
    }

    public final <R> R foldIndexed(R initial, o operation) {
        k.f(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            R r5 = initial;
            initial = (R) operation.invoke(Integer.valueOf(i6), r5, Integer.valueOf(iArr[i6]));
        }
        return initial;
    }

    public final <R> R foldRight(R initial, n operation) {
        k.f(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = (R) operation.invoke(Integer.valueOf(iArr[i]), initial);
        }
    }

    public final <R> R foldRightIndexed(R initial, o operation) {
        k.f(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = (R) operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]), initial);
        }
    }

    public final void forEach(S7.k block) {
        k.f(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            block.invoke(Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachIndexed(n block) {
        k.f(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            block.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachReversed(S7.k block) {
        k.f(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                block.invoke(Integer.valueOf(iArr[i]));
            }
        }
    }

    public final void forEachReversedIndexed(n block) {
        k.f(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                block.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]));
            }
        }
    }

    public final int get(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        return this.content[index];
    }

    public final f getIndices() {
        return AbstractC1451a.X(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i; i6++) {
            iHashCode += Integer.hashCode(iArr[i6]) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(int element) {
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (element == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfFirst(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(iArr[i]))).booleanValue());
        return i;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final int last() {
        if (this._size == 0) {
            RuntimeHelpersKt.throwNoSuchElementException("IntList is empty.");
        }
        return this.content[this._size - 1];
    }

    public final int lastIndexOf(int element) {
        int[] iArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (iArr[i] != element);
        return i;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean reversedAny(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntList(int i) {
        this.content = i == 0 ? IntSetKt.getEmptyIntArray() : new int[i];
    }

    public final boolean any(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int binarySearch(int i, int i6) {
        return binarySearch$default(this, i, i6, 0, 4, null);
    }

    public final int count(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i10]))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final String joinToString(CharSequence separator) {
        k.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final int binarySearch(int element, int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= toIndex || toIndex > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        int i = toIndex - 1;
        while (fromIndex <= i) {
            int i6 = (fromIndex + i) >>> 1;
            int i10 = this.content[i6];
            if (i10 < element) {
                fromIndex = i6 + 1;
            } else {
                if (i10 <= element) {
                    return i6;
                }
                i = i6 - 1;
            }
        }
        return -(fromIndex + 1);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final int first(S7.k predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            int i10 = iArr[i6];
            if (((Boolean) predicate.invoke(Integer.valueOf(i10))).booleanValue()) {
                return i10;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence charSequence, S7.k kVar) {
        k.f(separator, "separator");
        StringBuilder sbU = a.u(charSequence, "prefix", kVar, "transform", charSequence);
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sbU.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sbU.append(separator);
                }
                sbU.append((CharSequence) kVar.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sbU.append((CharSequence) "");
                break;
            }
        }
        String string = sbU.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence charSequence, S7.k kVar, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                separator = ", ";
            }
            if ((i6 & 2) != 0) {
                prefix = "";
            }
            if ((i6 & 4) != 0) {
                postfix = "";
            }
            if ((i6 & 8) != 0) {
                i = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence = "...";
            }
            k.f(separator, "separator");
            k.f(prefix, "prefix");
            k.f(postfix, "postfix");
            StringBuilder sbU = a.u(charSequence, "truncated", kVar, "transform", prefix);
            int[] iArr = intList.content;
            int i10 = intList._size;
            int i11 = 0;
            while (true) {
                if (i11 < i10) {
                    int i12 = iArr[i11];
                    if (i11 == i) {
                        sbU.append(charSequence);
                        break;
                    }
                    if (i11 != 0) {
                        sbU.append(separator);
                    }
                    sbU.append((CharSequence) kVar.invoke(Integer.valueOf(i12)));
                    i11++;
                } else {
                    sbU.append(postfix);
                    break;
                }
            }
            String string = sbU.toString();
            k.e(string, "toString(...)");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final int last(S7.k predicate) {
        int i;
        k.f(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 < i6) {
                i = iArr[i6];
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(i))).booleanValue());
        return i;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i, S7.k kVar) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbU = a.u(charSequence, "postfix", kVar, "transform", prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 < i6) {
                int i11 = iArr[i10];
                if (i10 == i) {
                    sbU.append((CharSequence) "...");
                    break;
                }
                if (i10 != 0) {
                    sbU.append(separator);
                }
                sbU.append((CharSequence) kVar.invoke(Integer.valueOf(i11)));
                i10++;
            } else {
                sbU.append(charSequence);
                break;
            }
        }
        String string = sbU.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbW = a.w(postfix, "postfix", truncated, "truncated", prefix);
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == limit) {
                    sbW.append(truncated);
                    break;
                }
                if (i6 != 0) {
                    sbW.append(separator);
                }
                sbW.append(i10);
                i6++;
            } else {
                sbW.append(postfix);
                break;
            }
        }
        String string = sbW.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, S7.k transform) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        StringBuilder sbU = a.u(truncated, "truncated", transform, "transform", prefix);
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == limit) {
                    sbU.append(truncated);
                    break;
                }
                if (i6 != 0) {
                    sbU.append(separator);
                }
                sbU.append((CharSequence) transform.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sbU.append(postfix);
                break;
            }
        }
        String string = sbU.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, S7.k kVar) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbU = a.u(charSequence, "postfix", kVar, "transform", prefix);
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sbU.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sbU.append(separator);
                }
                sbU.append((CharSequence) kVar.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sbU.append(charSequence);
                break;
            }
        }
        String string = sbU.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, S7.k transform) {
        k.f(separator, "separator");
        k.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(separator);
                }
                sb.append((CharSequence) transform.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(S7.k transform) {
        k.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) transform.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }
}
