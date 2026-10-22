package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001aJ\r\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u0005¨\u0006*"}, d2 = {"Landroidx/compose/runtime/Stack;", ExifInterface.GPS_DIRECTION_TRUE, "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "push", "", "value", "push-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "pop", "pop-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "peek", "peek-impl", "index", "(Ljava/util/ArrayList;I)Ljava/lang/Object;", "isEmpty", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isNotEmpty", "isNotEmpty-impl", "clear", "", "clear-impl", "(Ljava/util/ArrayList;)V", "toArray", "", "toArray-impl", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Stack<T> {
    private final ArrayList<T> backing;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Stack m4148boximpl(ArrayList r100) {
        return new Stack(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> ArrayList<T> m4150constructorimpl(ArrayList<T> r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4152equalsimpl(ArrayList<T> r100, Object r101) {
        if ((r101 instanceof Stack) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((Stack) r101).m4164unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4153equalsimpl0(ArrayList<T> r100, ArrayList<T> r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4155hashCodeimpl(ArrayList<T> r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4163toStringimpl(ArrayList<T> r100) {
        return "Stack(backing=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4152equalsimpl(this.backing, r100);
    }

    public int hashCode() {
        return m4155hashCodeimpl(this.backing);
    }

    public String toString() {
        return m4163toStringimpl(this.backing);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ArrayList m4164unboximpl() {
        return this.backing;
    }

    private /* synthetic */ Stack(ArrayList r100) {
        this.backing = r100;
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m4149clearimpl(ArrayList<T> r100) {
        r100.clear();
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m4154getSizeimpl(ArrayList<T> r100) {
        return r100.size();
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m4156isEmptyimpl(ArrayList<T> r100) {
        return r100.isEmpty();
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m4157isNotEmptyimpl(ArrayList<T> r100) {
        return !m4156isEmptyimpl(r100);
    }

    /* JADX INFO: renamed from: peek-impl, reason: not valid java name */
    public static final T m4158peekimpl(ArrayList<T> r100) {
        return (T) ListProtector.get(r100, m4154getSizeimpl(r100) - 1);
    }

    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final T m4160popimpl(ArrayList<T> r100) {
        return (T) ListProtector.remove(r100, m4154getSizeimpl(r100) - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toArray-impl, reason: not valid java name */
    public static final T[] m4162toArrayimpl(ArrayList<T> r100) {
        int r101 = r100.size();
        T[] r102 = (T[]) new Object[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ListProtector.get(r100, r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    /* JADX INFO: renamed from: peek-impl, reason: not valid java name */
    public static final T m4159peekimpl(ArrayList<T> r100, int r101) {
        return (T) ListProtector.get(r100, r101);
    }

    /* JADX INFO: renamed from: push-impl, reason: not valid java name */
    public static final boolean m4161pushimpl(ArrayList<T> r100, T r101) {
        return r100.add(r101);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ ArrayList m4151constructorimpl$default(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        return m4150constructorimpl(r100);
    }
}
