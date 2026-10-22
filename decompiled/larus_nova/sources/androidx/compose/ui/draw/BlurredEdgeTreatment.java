package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "constructor-impl", "(Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class BlurredEdgeTreatment {
    public static final Companion Companion = null;
    private static final Shape Rectangle = null;
    private static final Shape Unbounded = null;
    private final Shape shape;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment$Companion;", "", "<init>", "()V", "Rectangle", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "getRectangle---Goahg", "()Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Shape;", "Unbounded", "getUnbounded---Goahg", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getRectangle---Goahg, reason: not valid java name */
        public final Shape m4362getRectangleGoahg() {
            return BlurredEdgeTreatment.access$getRectangle$cp();
        }

        /* JADX INFO: renamed from: getUnbounded---Goahg, reason: not valid java name */
        public final Shape m4363getUnboundedGoahg() {
            return BlurredEdgeTreatment.access$getUnbounded$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m4355boximpl(Shape r100) {
        return new BlurredEdgeTreatment(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Shape m4356constructorimpl(Shape r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4357equalsimpl(Shape r100, Object r101) {
        if ((r101 instanceof BlurredEdgeTreatment) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((BlurredEdgeTreatment) r101).m4361unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4358equalsimpl0(Shape r100, Shape r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4359hashCodeimpl(Shape r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4360toStringimpl(Shape r100) {
        return "BlurredEdgeTreatment(shape=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4357equalsimpl(this.shape, r100);
    }

    public int hashCode() {
        return m4359hashCodeimpl(this.shape);
    }

    public String toString() {
        return m4360toStringimpl(this.shape);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Shape m4361unboximpl() {
        return this.shape;
    }

    static {
        Companion = new Companion(null);
        Rectangle = m4356constructorimpl(RectangleShapeKt.getRectangleShape());
        Unbounded = m4356constructorimpl(null);
    }

    public static final /* synthetic */ Shape access$getRectangle$cp() {
        return Rectangle;
    }

    public static final /* synthetic */ Shape access$getUnbounded$cp() {
        return Unbounded;
    }

    public final Shape getShape() {
        return this.shape;
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape r100) {
        this.shape = r100;
    }
}
