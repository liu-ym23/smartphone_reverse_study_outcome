package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class VertexMode {
    public static final Companion Companion = null;
    private static final int TriangleFan = 0;
    private static final int TriangleStrip = 0;
    private static final int Triangles = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode$Companion;", "", "<init>", "()V", "Triangles", "Landroidx/compose/ui/graphics/VertexMode;", "getTriangles-c2xauaI", "()I", "I", "TriangleStrip", "getTriangleStrip-c2xauaI", "TriangleFan", "getTriangleFan-c2xauaI", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getTriangleFan-c2xauaI, reason: not valid java name */
        public final int m5253getTriangleFanc2xauaI() {
            return VertexMode.access$getTriangleFan$cp();
        }

        /* JADX INFO: renamed from: getTriangleStrip-c2xauaI, reason: not valid java name */
        public final int m5254getTriangleStripc2xauaI() {
            return VertexMode.access$getTriangleStrip$cp();
        }

        /* JADX INFO: renamed from: getTriangles-c2xauaI, reason: not valid java name */
        public final int m5255getTrianglesc2xauaI() {
            return VertexMode.access$getTriangles$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VertexMode m5246boximpl(int r100) {
        return new VertexMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5247constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5248equalsimpl(int r100, Object r101) {
        if ((r101 instanceof VertexMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((VertexMode) r101).m5252unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5249equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5250hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5248equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5250hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5252unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Triangles = m5247constructorimpl(0);
        TriangleStrip = m5247constructorimpl(1);
        TriangleFan = m5247constructorimpl(2);
    }

    public String toString() {
        return m5251toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getTriangleFan$cp() {
        return TriangleFan;
    }

    public static final /* synthetic */ int access$getTriangleStrip$cp() {
        return TriangleStrip;
    }

    public static final /* synthetic */ int access$getTriangles$cp() {
        return Triangles;
    }

    private /* synthetic */ VertexMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5251toStringimpl(int r100) {
        if (m5249equalsimpl0(r100, Triangles) == false) goto L6;
        return "Triangles";
    L6:
        if (m5249equalsimpl0(r100, TriangleStrip) == false) goto L9;
        return "TriangleStrip";
    L9:
        if (m5249equalsimpl0(r100, TriangleFan) == false) goto L11;
        return "TriangleFan";
    L11:
        return "Unknown";
    }
}
