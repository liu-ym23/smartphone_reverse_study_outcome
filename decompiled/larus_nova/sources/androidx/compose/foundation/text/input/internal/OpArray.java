package androidx.compose.foundation.text.input.internal;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016Jo\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2K\u0010\u001b\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u001cH\u0086\b¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray;", "", "values", "", "constructor-impl", "([I)[I", "size", "", "(I)[I", "getSize-impl", "([I)I", "set", "", "index", "offset", "srcLen", "destLen", "set-impl", "([IIIII)V", "copyOf", "newSize", "copyOf-pSmdads", "([II)[I", "forEach", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "reversed", "", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "forEach-impl", "([IIZLkotlin/jvm/functions/Function3;)V", "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class OpArray {
    private final int[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OpArray m1271boximpl(int[] r100) {
        return new OpArray(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int[] m1273constructorimpl(int[] r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1275equalsimpl(int[] r100, Object r101) {
        if ((r101 instanceof OpArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((OpArray) r101).m1283unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1276equalsimpl0(int[] r100, int[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1280hashCodeimpl(int[] r100) {
        return Arrays.hashCode(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1282toStringimpl(int[] r100) {
        return "OpArray(values=" + Arrays.toString(r100) + ')';
    }

    public boolean equals(Object r100) {
        return m1275equalsimpl(this.values, r100);
    }

    public int hashCode() {
        return m1280hashCodeimpl(this.values);
    }

    public String toString() {
        return m1282toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m1283unboximpl() {
        return this.values;
    }

    private /* synthetic */ OpArray(int[] r100) {
        this.values = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1272constructorimpl(int r100) {
        return m1273constructorimpl(new int[r100 * 3]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m1279getSizeimpl(int[] r100) {
        return r100.length / 3;
    }

    /* JADX INFO: renamed from: copyOf-pSmdads, reason: not valid java name */
    public static final int[] m1274copyOfpSmdads(int[] r100, int r101) {
        return m1273constructorimpl(Arrays.copyOf(r100, r101 * 3));
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    public static final void m1277forEachimpl(int[] r100, int r101, boolean r102, Function3<? super Integer, ? super Integer, ? super Integer, Unit> r103) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        if (r102 == true) goto L6;
        int r104 = 0;
    L10:
        if (r104 >= r101) goto L12;
        int r105 = r104 * 3;
        r103.invoke(Integer.valueOf(r100[r105]), Integer.valueOf(r100[r105 + 1]), Integer.valueOf(r100[r105 + 2]));
        r104 = r104 + 1;
        goto L10
    L12:
        return;
    L6:
        r101 = r101 - 1;
        if ((-1) >= r101) goto L15;
        int r106 = r101 * 3;
        r103.invoke(Integer.valueOf(r100[r106]), Integer.valueOf(r100[r106 + 1]), Integer.valueOf(r100[r106 + 2]));
        goto L6
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1281setimpl(int[] r100, int r101, int r102, int r103, int r104) {
        int r105 = r101 * 3;
        r100[r105] = r102;
        r100[r105 + 1] = r103;
        r100[r105 + 2] = r104;
    }

    /* JADX INFO: renamed from: forEach-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1278forEachimpl$default(int[] r100, int r101, boolean r102, Function3 r103, int r104, Object r105) {
        int r106 = 0;
        if ((r104 & 2) == 0) goto L5;
        r102 = false;
    L5:
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r102 == true) goto L9;
    L12:
        if (r106 >= r101) goto L14;
        int r107 = r106 * 3;
        r103.invoke(Integer.valueOf(r100[r107]), Integer.valueOf(r100[r107 + 1]), Integer.valueOf(r100[r107 + 2]));
        r106 = r106 + 1;
        goto L12
    L14:
        return;
    L9:
        r101 = r101 - 1;
        if ((-1) >= r101) goto L17;
        int r108 = r101 * 3;
        r103.invoke(Integer.valueOf(r100[r108]), Integer.valueOf(r100[r108 + 1]), Integer.valueOf(r100[r108 + 2]));
        goto L9
    }
}
