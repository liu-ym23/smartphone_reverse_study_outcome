package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PathOperation {
    public static final Companion Companion = null;
    private static final int Difference = 0;
    private static final int Intersect = 0;
    private static final int ReverseDifference = 0;
    private static final int Union = 0;
    private static final int Xor = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation$Companion;", "", "<init>", "()V", "Difference", "Landroidx/compose/ui/graphics/PathOperation;", "getDifference-b3I0S0c", "()I", "I", "Intersect", "getIntersect-b3I0S0c", "Union", "getUnion-b3I0S0c", "Xor", "getXor-b3I0S0c", "ReverseDifference", "getReverseDifference-b3I0S0c", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getDifference-b3I0S0c, reason: not valid java name */
        public final int m5140getDifferenceb3I0S0c() {
            return PathOperation.access$getDifference$cp();
        }

        /* JADX INFO: renamed from: getIntersect-b3I0S0c, reason: not valid java name */
        public final int m5141getIntersectb3I0S0c() {
            return PathOperation.access$getIntersect$cp();
        }

        /* JADX INFO: renamed from: getReverseDifference-b3I0S0c, reason: not valid java name */
        public final int m5142getReverseDifferenceb3I0S0c() {
            return PathOperation.access$getReverseDifference$cp();
        }

        /* JADX INFO: renamed from: getUnion-b3I0S0c, reason: not valid java name */
        public final int m5143getUnionb3I0S0c() {
            return PathOperation.access$getUnion$cp();
        }

        /* JADX INFO: renamed from: getXor-b3I0S0c, reason: not valid java name */
        public final int m5144getXorb3I0S0c() {
            return PathOperation.access$getXor$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathOperation m5133boximpl(int r100) {
        return new PathOperation(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5134constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5135equalsimpl(int r100, Object r101) {
        if ((r101 instanceof PathOperation) == true) goto L6;
        return false;
    L6:
        if (r100 == ((PathOperation) r101).m5139unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5136equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5137hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5135equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5137hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5139unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Difference = m5134constructorimpl(0);
        Intersect = m5134constructorimpl(1);
        Union = m5134constructorimpl(2);
        Xor = m5134constructorimpl(3);
        ReverseDifference = m5134constructorimpl(4);
    }

    public String toString() {
        return m5138toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getDifference$cp() {
        return Difference;
    }

    public static final /* synthetic */ int access$getIntersect$cp() {
        return Intersect;
    }

    public static final /* synthetic */ int access$getReverseDifference$cp() {
        return ReverseDifference;
    }

    public static final /* synthetic */ int access$getUnion$cp() {
        return Union;
    }

    public static final /* synthetic */ int access$getXor$cp() {
        return Xor;
    }

    private /* synthetic */ PathOperation(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5138toStringimpl(int r100) {
        if (m5136equalsimpl0(r100, Difference) == false) goto L6;
        return "Difference";
    L6:
        if (m5136equalsimpl0(r100, Intersect) == false) goto L9;
        return "Intersect";
    L9:
        if (m5136equalsimpl0(r100, Union) == false) goto L12;
        return "Union";
    L12:
        if (m5136equalsimpl0(r100, Xor) == false) goto L15;
        return "Xor";
    L15:
        if (m5136equalsimpl0(r100, ReverseDifference) == false) goto L17;
        return "ReverseDifference";
    L17:
        return "Unknown";
    }
}
