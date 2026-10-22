package androidx.collection;

import B7.a;
import S7.k;
import S7.n;
import S7.o;
import Y7.f;
import androidx.annotation.IntRange;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ2\u0010\n\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\n\u0010\rJ2\u0010\u000e\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u001b\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u001b\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0014\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ2\u0010\u001b\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u001b\u0010\u001dJ\r\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ2\u0010\u001e\u001a\u00028\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u001e\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\b!\u0010\u001fJ4\u0010!\u001a\u0004\u0018\u00018\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b!\u0010 JF\u0010&\u001a\u00028\u0001\"\u0004\b\u0001\u0010\"2\u0006\u0010#\u001a\u00028\u00012\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b&\u0010'JL\u0010)\u001a\u00028\u0001\"\u0004\b\u0001\u0010\"2\u0006\u0010#\u001a\u00028\u00012\u001e\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b)\u0010*JF\u0010+\u001a\u00028\u0001\"\u0004\b\u0001\u0010\"2\u0006\u0010#\u001a\u00028\u00012\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010$H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b+\u0010'JL\u0010,\u001a\u00028\u0001\"\u0004\b\u0001\u0010\"2\u0006\u0010#\u001a\u00028\u00012\u001e\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010(H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b,\u0010*J2\u0010/\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b/\u00100J8\u00101\u001a\u00020-2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0$H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b1\u00102J2\u00103\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b3\u00100J8\u00104\u001a\u00020-2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0$H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b4\u00102J\u001a\u00106\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0003¢\u0006\u0004\b8\u00107J\u0017\u0010:\u001a\u00020-2\u0006\u00105\u001a\u00020\u0003H\u0000¢\u0006\u0004\b9\u0010\u0006J1\u0010<\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u00032\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b>\u0010?J2\u0010@\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b@\u0010\u001dJ2\u0010A\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bA\u0010\u001dJ\r\u0010B\u001a\u00020\u0007¢\u0006\u0004\bB\u0010\tJ\r\u0010C\u001a\u00020\u0007¢\u0006\u0004\bC\u0010\tJ\r\u0010D\u001a\u00028\u0000¢\u0006\u0004\bD\u0010\u001fJ2\u0010D\u001a\u00028\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bD\u0010 J\u0012\u0010E\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\bE\u0010\u001fJ4\u0010E\u001a\u0004\u0018\u00018\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bE\u0010 J\u0015\u0010F\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\bF\u0010?JY\u0010O\u001a\u00020N2\b\b\u0002\u0010H\u001a\u00020G2\b\b\u0002\u0010I\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020G2\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020G2\u0016\b\u0002\u0010M\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020G\u0018\u00010\u000bH\u0007¢\u0006\u0004\bO\u0010PJ\u0015\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0003H\u0016¢\u0006\u0004\bS\u0010\u001cJ\u001a\u0010U\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\bU\u0010\u0011J\u000f\u0010V\u001a\u00020NH\u0016¢\u0006\u0004\bV\u0010WR$\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bX\u0010Y\u0012\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\\\u0010]\u0012\u0004\b^\u0010[R\u0011\u0010`\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b_\u0010\u001cR\u0012\u0010b\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\ba\u0010\u001cR\u0012\u0010f\u001a\u00020c8Æ\u0002¢\u0006\u0006\u001a\u0004\bd\u0010e\u0082\u0001\u0001g\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006h"}, d2 = {"Landroidx/collection/ObjectList;", ExifInterface.LONGITUDE_EAST, "", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "", "none", "()Z", "any", "Lkotlin/Function1;", "predicate", "(LS7/k;)Z", "reversedAny", "element", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "([Ljava/lang/Object;)Z", "", "(Ljava/util/List;)Z", "", "(Ljava/lang/Iterable;)Z", "(Landroidx/collection/ObjectList;)Z", "count", "()I", "(LS7/k;)I", "first", "()Ljava/lang/Object;", "(LS7/k;)Ljava/lang/Object;", "firstOrNull", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;LS7/n;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/Object;LS7/o;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "LC7/r;", "block", "forEach", "(LS7/k;)V", "forEachIndexed", "(LS7/n;)V", "forEachReversed", "forEachReversedIndexed", "index", "get", "(I)Ljava/lang/Object;", "elementAt", "throwIndexOutOfBoundsExclusiveException$collection", "throwIndexOutOfBoundsExclusiveException", "defaultValue", "elementAtOrElse", "(ILS7/k;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastOrNull", "lastIndexOf", "", "separator", "prefix", "postfix", "limit", "truncated", "transform", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/String;", "asList", "()Ljava/util/List;", "hashCode", "other", "equals", "toString", "()Ljava/lang/String;", "content", "[Ljava/lang/Object;", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "getSize", "size", "getLastIndex", "lastIndex", "LY7/f;", "getIndices", "()LY7/f;", "indices", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int i, e eVar) {
        this(i);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, k kVar, int i6, Object obj) {
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
        if ((i6 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        k kVar2 = kVar;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i, charSequence5, kVar2);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public abstract List<E> asList();

    public final boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public final boolean containsAll(E[] elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        for (E e : elements) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final E elementAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            throwIndexOutOfBoundsExclusiveException$collection(index);
        }
        return (E) this.content[index];
    }

    public final E elementAtOrElse(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, k defaultValue) {
        kotlin.jvm.internal.k.f(defaultValue, "defaultValue");
        return (index < 0 || index >= this._size) ? (E) defaultValue.invoke(Integer.valueOf(index)) : (E) this.content[index];
    }

    public boolean equals(Object other) {
        if (other instanceof ObjectList) {
            ObjectList objectList = (ObjectList) other;
            int i = objectList._size;
            int i6 = this._size;
            if (i == i6) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                f fVarX = AbstractC1451a.X(0, i6);
                int i10 = fVarX.f1569a;
                int i11 = fVarX.b;
                if (i10 > i11) {
                    return true;
                }
                while (kotlin.jvm.internal.k.b(objArr[i10], objArr2[i10])) {
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

    public final E first() {
        if (isEmpty()) {
            RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[0];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final <R> R fold(R initial, n operation) {
        kotlin.jvm.internal.k.f(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            initial = (R) operation.invoke(initial, objArr[i6]);
        }
        return initial;
    }

    public final <R> R foldIndexed(R initial, o operation) {
        kotlin.jvm.internal.k.f(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            initial = (R) operation.invoke(Integer.valueOf(i6), initial, objArr[i6]);
        }
        return initial;
    }

    public final <R> R foldRight(R initial, n operation) {
        kotlin.jvm.internal.k.f(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = (R) operation.invoke(objArr[i], initial);
        }
    }

    public final <R> R foldRightIndexed(R initial, o operation) {
        kotlin.jvm.internal.k.f(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = (R) operation.invoke(Integer.valueOf(i), objArr[i], initial);
        }
    }

    public final void forEach(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            block.invoke(objArr[i6]);
        }
    }

    public final void forEachIndexed(n block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            block.invoke(Integer.valueOf(i6), objArr[i6]);
        }
    }

    public final void forEachReversed(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                block.invoke(objArr[i]);
            }
        }
    }

    public final void forEachReversedIndexed(n block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                block.invoke(Integer.valueOf(i), objArr[i]);
            }
        }
    }

    public final E get(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            throwIndexOutOfBoundsExclusiveException$collection(index);
        }
        return (E) this.content[index];
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
        Object[] objArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = objArr[i6];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(E element) {
        int i = 0;
        if (element == null) {
            Object[] objArr = this.content;
            int i6 = this._size;
            while (i < i6) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i10 = this._size;
        while (i < i10) {
            if (element.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int indexOfFirst(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) predicate.invoke(objArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(objArr[i])).booleanValue());
        return i;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final E last() {
        if (isEmpty()) {
            RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[this._size - 1];
    }

    public final int lastIndexOf(E element) {
        if (element == null) {
            Object[] objArr = this.content;
            for (int i = this._size - 1; -1 < i; i--) {
                if (objArr[i] == null) {
                    return i;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i6 = this._size - 1; -1 < i6; i6--) {
                if (element.equals(objArr2[i6])) {
                    return i6;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (((Boolean) predicate.invoke(objArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int index) {
        StringBuilder sbU = a.u(index, "Index ", " must be in 0..");
        sbU.append(this._size - 1);
        RuntimeHelpersKt.throwIndexOutOfBoundsException(sbU.toString());
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new k(this) { // from class: androidx.collection.ObjectList.toString.1
            final /* synthetic */ ObjectList<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AnonymousClass1) obj);
            }

            @Override // S7.k
            public final CharSequence invoke(E e) {
                return e == this.this$0 ? "(this)" : String.valueOf(e);
            }
        }, 25, null);
    }

    private ObjectList(int i) {
        this.content = i == 0 ? ObjectListKt.EmptyArray : new Object[i];
    }

    public final boolean any(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) predicate.invoke(objArr[i6])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            if (((Boolean) predicate.invoke(objArr[i10])).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final E firstOrNull(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            E e = (E) objArr[i6];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public final String joinToString(CharSequence separator) {
        kotlin.jvm.internal.k.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final boolean containsAll(List<? extends E> elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            if (!contains(elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    public final E lastOrNull(k predicate) {
        E e;
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return null;
            }
            e = (E) objArr[i];
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final E first(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            E e = (E) objArr[i6];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final boolean containsAll(Iterable<? extends E> elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    public final E last(k predicate) {
        E e;
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 < i) {
                e = (E) objArr[i];
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        kotlin.jvm.internal.k.f(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (!contains(objArr[i6])) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, k transform) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        StringBuilder sbW = androidx.appfunctions.metadata.a.w(postfix, "postfix", truncated, "truncated", prefix);
        Object[] objArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                Object obj = objArr[i6];
                if (i6 == limit) {
                    sbW.append(truncated);
                    break;
                }
                if (i6 != 0) {
                    sbW.append(separator);
                }
                if (transform == null) {
                    sbW.append(obj);
                } else {
                    sbW.append((CharSequence) transform.invoke(obj));
                }
                i6++;
            } else {
                sbW.append(postfix);
                break;
            }
        }
        String string = sbW.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }
}
