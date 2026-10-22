package androidx.compose.foundation.text.input.internal;

import S7.o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0083@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ-\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0018H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010 \u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010'\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010\"\u0088\u0001\u0007\u0092\u0001\u00020\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray;", "", "", "size", "constructor-impl", "(I)[I", "", "values", "([I)[I", "index", TypedValues.CycleType.S_WAVE_OFFSET, "srcLen", "destLen", "LC7/r;", "set-impl", "([IIIII)V", "set", "newSize", "copyOf-pSmdads", "([II)[I", "copyOf", "max", "", "reversed", "Lkotlin/Function3;", "block", "forEach-impl", "([IIZLS7/o;)V", "forEach", "", "toString-impl", "([I)Ljava/lang/String;", "toString", "hashCode-impl", "([I)I", "hashCode", "other", "equals-impl", "([ILjava/lang/Object;)Z", "equals", "[I", "getSize-impl", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class OpArray {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int ElementSize = 3;
    private final int[] values;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray$Companion;", "", "()V", "ElementSize", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ OpArray(int[] iArr) {
        this.values = iArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OpArray m1211boximpl(int[] iArr) {
        return new OpArray(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int[] m1213constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: copyOf-pSmdads, reason: not valid java name */
    public static final int[] m1214copyOfpSmdads(int[] iArr, int i) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, i * 3);
        k.e(iArrCopyOf, "copyOf(this, newSize)");
        return m1213constructorimpl(iArrCopyOf);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1215equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof OpArray) && k.b(iArr, ((OpArray) obj).getValues());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1216equalsimpl0(int[] iArr, int[] iArr2) {
        return k.b(iArr, iArr2);
    }

    /* renamed from: forEach-impl, reason: not valid java name */
    public static final void m1217forEachimpl(int[] iArr, int i, boolean z10, o oVar) {
        if (i < 0) {
            return;
        }
        if (!z10) {
            for (int i6 = 0; i6 < i; i6++) {
                int i10 = i6 * 3;
                oVar.invoke(Integer.valueOf(iArr[i10]), Integer.valueOf(iArr[i10 + 1]), Integer.valueOf(iArr[i10 + 2]));
            }
            return;
        }
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            int i11 = i * 3;
            oVar.invoke(Integer.valueOf(iArr[i11]), Integer.valueOf(iArr[i11 + 1]), Integer.valueOf(iArr[i11 + 2]));
        }
    }

    /* renamed from: forEach-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1218forEachimpl$default(int[] iArr, int i, boolean z10, o oVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (i < 0) {
            return;
        }
        if (!z10) {
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 * 3;
                oVar.invoke(Integer.valueOf(iArr[i11]), Integer.valueOf(iArr[i11 + 1]), Integer.valueOf(iArr[i11 + 2]));
            }
            return;
        }
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            int i12 = i * 3;
            oVar.invoke(Integer.valueOf(iArr[i12]), Integer.valueOf(iArr[i12 + 1]), Integer.valueOf(iArr[i12 + 2]));
        }
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final int m1219getSizeimpl(int[] iArr) {
        return iArr.length / 3;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1220hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m1221setimpl(int[] iArr, int i, int i6, int i10, int i11) {
        int i12 = i * 3;
        iArr[i12] = i6;
        iArr[i12 + 1] = i10;
        iArr[i12 + 2] = i11;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1222toStringimpl(int[] iArr) {
        return "OpArray(values=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m1215equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m1220hashCodeimpl(this.values);
    }

    public String toString() {
        return m1222toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int[] getValues() {
        return this.values;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1212constructorimpl(int i) {
        return m1213constructorimpl(new int[i * 3]);
    }
}
