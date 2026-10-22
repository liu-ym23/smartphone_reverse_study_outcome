package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0012\u0010\u0012\u001a\u00020\u00138Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\u0088\u0001\u0002¨\u0006)"}, d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "startX", "", "getStartX-impl", "([I)I", "startY", "getStartY-impl", "endX", "getEndX-impl", "endY", "getEndY-impl", "reverse", "", "getReverse-impl", "([I)Z", "diagonalSize", "getDiagonalSize-impl", "hasAdditionOrRemoval", "getHasAdditionOrRemoval-impl", "isAddition", "isAddition-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class Snake {
    private final int[] data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m6624boximpl(int[] r100) {
        return new Snake(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m6625constructorimpl(int[] r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6626equalsimpl(int[] r100, Object r101) {
        if ((r101 instanceof Snake) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((Snake) r101).m6638unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6627equalsimpl0(int[] r100, int[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6635hashCodeimpl(int[] r100) {
        return Arrays.hashCode(r100);
    }

    public boolean equals(Object r100) {
        return m6626equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m6635hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m6638unboximpl() {
        return this.data;
    }

    public String toString() {
        return m6637toStringimpl(this.data);
    }

    public final int[] getData() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m6628getDiagonalSizeimpl(int[] r100) {
        return Math.min(r100[2] - r100[0], r100[3] - r100[1]);
    }

    /* JADX INFO: renamed from: getEndX-impl, reason: not valid java name */
    public static final int m6629getEndXimpl(int[] r100) {
        return r100[2];
    }

    /* JADX INFO: renamed from: getEndY-impl, reason: not valid java name */
    public static final int m6630getEndYimpl(int[] r100) {
        return r100[3];
    }

    /* JADX INFO: renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m6631getHasAdditionOrRemovalimpl(int[] r100) {
        if ((r100[3] - r100[1]) != (r100[2] - r100[0])) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m6632getReverseimpl(int[] r100) {
        if (r100[4] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getStartX-impl, reason: not valid java name */
    public static final int m6633getStartXimpl(int[] r100) {
        return r100[0];
    }

    /* JADX INFO: renamed from: getStartY-impl, reason: not valid java name */
    public static final int m6634getStartYimpl(int[] r100) {
        return r100[1];
    }

    /* JADX INFO: renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m6636isAdditionimpl(int[] r100) {
        if ((r100[3] - r100[1]) > (r100[2] - r100[0])) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6637toStringimpl(int[] r100) {
        StringBuilder r101 = new StringBuilder("Snake(");
        boolean r102 = false;
        r101.append(r100[0]);
        r101.append(',');
        r101.append(r100[1]);
        r101.append(',');
        r101.append(r100[2]);
        r101.append(',');
        r101.append(r100[3]);
        r101.append(',');
        if (r100[4] == 0) goto L5;
        r102 = true;
    L5:
        r101.append(r102);
        r101.append(')');
        return r101.toString();
    }

    /* JADX INFO: renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m6623addDiagonalToStackimpl(int[] r100, IntStack r101) {
        int r102 = 0;
        int r103 = r100[0];
        int r104 = r100[1];
        if (m6631getHasAdditionOrRemovalimpl(r100) == false) goto L12;
        int r105 = Math.min(r100[2] - r100[0], r100[3] - r100[1]);
        if (r100[4] == 0) goto L7;
        int r106 = 1;
    L8:
        r103 = r103 + ((r106 | (m6636isAdditionimpl(r100) ? 1 : 0)) ^ 1);
        if (r100[4] == 0) goto L11;
        r102 = 1;
    L11:
        r104 = r104 + (((!m6636isAdditionimpl(r100) ? 1 : 0) | r102) ^ 1);
    L13:
        r101.pushDiagonal(r103, r104, r105);
        return;
    L7:
        r106 = 0;
        goto L8
    L12:
        r105 = r100[2] - r100[0];
        goto L13
    }
}
