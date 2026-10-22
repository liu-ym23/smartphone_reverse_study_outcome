package androidx.compose.ui.node;

import androidx.appfunctions.metadata.a;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001c\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0012\u0010 \u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0012\u0010\"\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0012\u0010%\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010'\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u0014\u0010)\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010$\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006,"}, d2 = {"Landroidx/compose/ui/node/Snake;", "", "", SettingsConfig.KEY_DATA, "constructor-impl", "([I)[I", "Landroidx/compose/ui/node/IntStack;", "diagonals", "LC7/r;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "addDiagonalToStack", "", "toString-impl", "([I)Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[I", "getData", "()[I", "getStartX-impl", "([I)I", "startX", "getStartY-impl", "startY", "getEndX-impl", "endX", "getEndY-impl", "endY", "getReverse-impl", "([I)Z", "reverse", "getDiagonalSize-impl", "diagonalSize", "getHasAdditionOrRemoval-impl", "hasAdditionOrRemoval", "isAddition-impl", "isAddition", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class Snake {
    private final int[] data;

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m5927addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        int iMin;
        int i = iArr[0];
        int i6 = iArr[1];
        if (m5935getHasAdditionOrRemovalimpl(iArr)) {
            iMin = Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
            i += ((iArr[4] != 0 ? 1 : 0) | (m5940isAdditionimpl(iArr) ? 1 : 0)) ^ 1;
            i6 += ((!m5940isAdditionimpl(iArr) ? 1 : 0) | (iArr[4] != 0 ? 1 : 0)) ^ 1;
        } else {
            iMin = iArr[2] - iArr[0];
        }
        intStack.pushDiagonal(i, i6, iMin);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m5928boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m5929constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5930equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && k.b(iArr, ((Snake) obj).m5942unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5931equalsimpl0(int[] iArr, int[] iArr2) {
        return k.b(iArr, iArr2);
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m5932getDiagonalSizeimpl(int[] iArr) {
        return Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m5933getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m5934getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m5935getHasAdditionOrRemovalimpl(int[] iArr) {
        return iArr[3] - iArr[1] != iArr[2] - iArr[0];
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m5936getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m5937getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m5938getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5939hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m5940isAdditionimpl(int[] iArr) {
        return iArr[3] - iArr[1] > iArr[2] - iArr[0];
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5941toStringimpl(int[] iArr) {
        StringBuilder sb = new StringBuilder("Snake(");
        sb.append(iArr[0]);
        sb.append(',');
        sb.append(iArr[1]);
        sb.append(',');
        sb.append(iArr[2]);
        sb.append(',');
        sb.append(iArr[3]);
        sb.append(',');
        return a.r(sb, iArr[4] != 0, ')');
    }

    public boolean equals(Object other) {
        return m5930equalsimpl(this.data, other);
    }

    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return m5939hashCodeimpl(this.data);
    }

    public String toString() {
        return m5941toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m5942unboximpl() {
        return this.data;
    }
}
