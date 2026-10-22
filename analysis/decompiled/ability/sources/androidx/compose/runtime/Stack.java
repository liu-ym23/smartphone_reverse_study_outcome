package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b(\u0010)R$\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0011\u0010-\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b+\u0010,\u0088\u0001\u0005\u0092\u0001\u0012\u0012\u0004\u0012\u00028\u00000\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0004¨\u0006."}, d2 = {"Landroidx/compose/runtime/Stack;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "backing", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "value", "", "push-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "push", "pop-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "peek-impl", "peek", "", "index", "(Ljava/util/ArrayList;I)Ljava/lang/Object;", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isEmpty", "isNotEmpty-impl", "isNotEmpty", "LC7/r;", "clear-impl", "(Ljava/util/ArrayList;)V", "clear", "", "toArray-impl", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toArray", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getSize-impl", "(Ljava/util/ArrayList;)I", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Stack<T> {
    private final ArrayList<T> backing;

    private /* synthetic */ Stack(ArrayList arrayList) {
        this.backing = arrayList;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Stack m3456boximpl(ArrayList arrayList) {
        return new Stack(arrayList);
    }

    /* renamed from: clear-impl, reason: not valid java name */
    public static final void m3457clearimpl(ArrayList<T> arrayList) {
        arrayList.clear();
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> ArrayList<T> m3458constructorimpl(ArrayList<T> arrayList) {
        return arrayList;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ ArrayList m3459constructorimpl$default(ArrayList arrayList, int i, kotlin.jvm.internal.e eVar) {
        if ((i & 1) != 0) {
            arrayList = new ArrayList();
        }
        return m3458constructorimpl(arrayList);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3460equalsimpl(ArrayList<T> arrayList, Object obj) {
        return (obj instanceof Stack) && kotlin.jvm.internal.k.b(arrayList, ((Stack) obj).getBacking());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3461equalsimpl0(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        return kotlin.jvm.internal.k.b(arrayList, arrayList2);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final int m3462getSizeimpl(ArrayList<T> arrayList) {
        return arrayList.size();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3463hashCodeimpl(ArrayList<T> arrayList) {
        return arrayList.hashCode();
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m3464isEmptyimpl(ArrayList<T> arrayList) {
        return arrayList.isEmpty();
    }

    /* renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m3465isNotEmptyimpl(ArrayList<T> arrayList) {
        return !m3464isEmptyimpl(arrayList);
    }

    /* renamed from: peek-impl, reason: not valid java name */
    public static final T m3466peekimpl(ArrayList<T> arrayList) {
        return arrayList.get(m3462getSizeimpl(arrayList) - 1);
    }

    /* renamed from: pop-impl, reason: not valid java name */
    public static final T m3468popimpl(ArrayList<T> arrayList) {
        return arrayList.remove(m3462getSizeimpl(arrayList) - 1);
    }

    /* renamed from: push-impl, reason: not valid java name */
    public static final boolean m3469pushimpl(ArrayList<T> arrayList, T t9) {
        return arrayList.add(t9);
    }

    /* renamed from: toArray-impl, reason: not valid java name */
    public static final T[] m3470toArrayimpl(ArrayList<T> arrayList) {
        int size = arrayList.size();
        T[] tArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            tArr[i] = arrayList.get(i);
        }
        return tArr;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3471toStringimpl(ArrayList<T> arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object other) {
        return m3460equalsimpl(this.backing, other);
    }

    public int hashCode() {
        return m3463hashCodeimpl(this.backing);
    }

    public String toString() {
        return m3471toStringimpl(this.backing);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ ArrayList getBacking() {
        return this.backing;
    }

    /* renamed from: peek-impl, reason: not valid java name */
    public static final T m3467peekimpl(ArrayList<T> arrayList, int i) {
        return arrayList.get(i);
    }
}
