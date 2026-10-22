package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u001d\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007\u0082\u0001\u0013\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "<init>", "(ZZ)V", "()Z", "Close", "RelativeMoveTo", "MoveTo", "RelativeLineTo", "LineTo", "RelativeHorizontalTo", "HorizontalTo", "RelativeVerticalTo", "VerticalTo", "RelativeCurveTo", "CurveTo", "RelativeReflectiveCurveTo", "ReflectiveCurveTo", "RelativeQuadTo", "QuadTo", "RelativeReflectiveQuadTo", "ReflectiveQuadTo", "RelativeArcTo", "ArcTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "<init>", "(FFFZZFF)V", "getHorizontalEllipseRadius", "()F", "getVerticalEllipseRadius", "getTheta", "()Z", "getArcStartX", "getArcStartY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ArcTo extends PathNode {
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        public static /* synthetic */ ArcTo copy$default(ArcTo r100, float r101, float r102, float r103, boolean r104, boolean r110, float r111, float r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.horizontalEllipseRadius;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.verticalEllipseRadius;
        L8:
            float r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.theta;
        L11:
            float r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.isMoreThanHalf;
        L14:
            boolean r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.isPositiveArc;
        L17:
            boolean r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.arcStartX;
        L20:
            float r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.arcStartY;
        L23:
            float r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartX;
        }

        public final float component7() {
            return this.arcStartY;
        }

        public final ArcTo copy(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r116) {
            return new ArcTo(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ArcTo) == true) goto L8;
            return false;
        L8:
            ArcTo r101 = (ArcTo) r100;
            if (Float.compare(this.horizontalEllipseRadius, r101.horizontalEllipseRadius) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.verticalEllipseRadius, r101.verticalEllipseRadius) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.theta, r101.theta) == 0) goto L18;
            return false;
        L18:
            if (this.isMoreThanHalf == r101.isMoreThanHalf) goto L21;
            return false;
        L21:
            if (this.isPositiveArc == r101.isPositiveArc) goto L24;
            return false;
        L24:
            if (Float.compare(this.arcStartX, r101.arcStartX) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.arcStartY, r101.arcStartY) == 0) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r100 = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            int r101 = 1231;
            if (this.isMoreThanHalf == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.isPositiveArc == true) goto L11;
            r101 = 1237;
        L11:
            return ((((r103 + r101) * 31) + Float.floatToIntBits(this.arcStartX)) * 31) + Float.floatToIntBits(this.arcStartY);
        L5:
            r102 = 1237;
            goto L6
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        public ArcTo(float r100, float r101, float r102, boolean r103, boolean r104, float r105, float r110) {
            boolean r106 = false;
            super(r106, r106, 3, null);
            this.horizontalEllipseRadius = r100;
            this.verticalEllipseRadius = r101;
            this.theta = r102;
            this.isMoreThanHalf = r103;
            this.isPositiveArc = r104;
            this.arcStartX = r105;
            this.arcStartY = r110;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "<init>", "()V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Close extends PathNode {
        public static final Close INSTANCE = null;

        static {
            INSTANCE = new Close();
        }

        private Close() {
            boolean r100 = false;
            super(r100, r100, 3, null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "<init>", "(FFFFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "getX3", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CurveTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f15211x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f15212x2;

        /* JADX INFO: renamed from: x3, reason: collision with root package name */
        private final float f15213x3;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f15214y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f15215y2;

        /* JADX INFO: renamed from: y3, reason: collision with root package name */
        private final float f15216y3;

        public static /* synthetic */ CurveTo copy$default(CurveTo r100, float r101, float r102, float r103, float r104, float r105, float r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.f15211x1;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.f15214y1;
        L8:
            float r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.f15212x2;
        L11:
            float r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.f15215y2;
        L14:
            float r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.f15213x3;
        L17:
            float r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.f15216y3;
        L20:
            float r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final float component1() {
            return this.f15211x1;
        }

        public final float component2() {
            return this.f15214y1;
        }

        public final float component3() {
            return this.f15212x2;
        }

        public final float component4() {
            return this.f15215y2;
        }

        public final float component5() {
            return this.f15213x3;
        }

        public final float component6() {
            return this.f15216y3;
        }

        public final CurveTo copy(float r100, float r110, float r111, float r112, float r113, float r114) {
            return new CurveTo(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CurveTo) == true) goto L8;
            return false;
        L8:
            CurveTo r101 = (CurveTo) r100;
            if (Float.compare(this.f15211x1, r101.f15211x1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15214y1, r101.f15214y1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15212x2, r101.f15212x2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15215y2, r101.f15215y2) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f15213x3, r101.f15213x3) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f15216y3, r101.f15216y3) == 0) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f15211x1) * 31) + Float.floatToIntBits(this.f15214y1)) * 31) + Float.floatToIntBits(this.f15212x2)) * 31) + Float.floatToIntBits(this.f15215y2)) * 31) + Float.floatToIntBits(this.f15213x3)) * 31) + Float.floatToIntBits(this.f15216y3);
        }

        public String toString() {
            return "CurveTo(x1=" + this.f15211x1 + ", y1=" + this.f15214y1 + ", x2=" + this.f15212x2 + ", y2=" + this.f15215y2 + ", x3=" + this.f15213x3 + ", y3=" + this.f15216y3 + ')';
        }

        public final float getX1() {
            return this.f15211x1;
        }

        public final float getX2() {
            return this.f15212x2;
        }

        public final float getX3() {
            return this.f15213x3;
        }

        public final float getY1() {
            return this.f15214y1;
        }

        public final float getY2() {
            return this.f15215y2;
        }

        public final float getY3() {
            return this.f15216y3;
        }

        public CurveTo(float r100, float r101, float r102, float r103, float r104, float r110) {
            boolean r105 = true;
            boolean r106 = false;
            super(r105, r106, 2, null);
            this.f15211x1 = r100;
            this.f15214y1 = r101;
            this.f15212x2 = r102;
            this.f15215y2 = r103;
            this.f15213x3 = r104;
            this.f15216y3 = r110;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "<init>", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HorizontalTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f15217x;

        public static /* synthetic */ HorizontalTo copy$default(HorizontalTo r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.f15217x;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.f15217x;
        }

        public final HorizontalTo copy(float r100) {
            return new HorizontalTo(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof HorizontalTo) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f15217x, ((HorizontalTo) r100).f15217x) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f15217x);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.f15217x + ')';
        }

        public final float getX() {
            return this.f15217x;
        }

        public HorizontalTo(float r100) {
            boolean r101 = false;
            super(r101, r101, 3, null);
            this.f15217x = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LineTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f15218x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f15219y;

        public static /* synthetic */ LineTo copy$default(LineTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15218x;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15219y;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15218x;
        }

        public final float component2() {
            return this.f15219y;
        }

        public final LineTo copy(float r100, float r101) {
            return new LineTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LineTo) == true) goto L8;
            return false;
        L8:
            LineTo r101 = (LineTo) r100;
            if (Float.compare(this.f15218x, r101.f15218x) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15219y, r101.f15219y) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15218x) * 31) + Float.floatToIntBits(this.f15219y);
        }

        public String toString() {
            return "LineTo(x=" + this.f15218x + ", y=" + this.f15219y + ')';
        }

        public final float getX() {
            return this.f15218x;
        }

        public final float getY() {
            return this.f15219y;
        }

        public LineTo(float r100, float r101) {
            boolean r102 = false;
            super(r102, r102, 3, null);
            this.f15218x = r100;
            this.f15219y = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f15220x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f15221y;

        public static /* synthetic */ MoveTo copy$default(MoveTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15220x;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15221y;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15220x;
        }

        public final float component2() {
            return this.f15221y;
        }

        public final MoveTo copy(float r100, float r101) {
            return new MoveTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MoveTo) == true) goto L8;
            return false;
        L8:
            MoveTo r101 = (MoveTo) r100;
            if (Float.compare(this.f15220x, r101.f15220x) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15221y, r101.f15221y) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15220x) * 31) + Float.floatToIntBits(this.f15221y);
        }

        public String toString() {
            return "MoveTo(x=" + this.f15220x + ", y=" + this.f15221y + ')';
        }

        public final float getX() {
            return this.f15220x;
        }

        public final float getY() {
            return this.f15221y;
        }

        public MoveTo(float r100, float r101) {
            boolean r102 = false;
            super(r102, r102, 3, null);
            this.f15220x = r100;
            this.f15221y = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class QuadTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f15222x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f15223x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f15224y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f15225y2;

        public static /* synthetic */ QuadTo copy$default(QuadTo r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f15222x1;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.f15224y1;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.f15223x2;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.f15225y2;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.f15222x1;
        }

        public final float component2() {
            return this.f15224y1;
        }

        public final float component3() {
            return this.f15223x2;
        }

        public final float component4() {
            return this.f15225y2;
        }

        public final QuadTo copy(float r100, float r101, float r102, float r103) {
            return new QuadTo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof QuadTo) == true) goto L8;
            return false;
        L8:
            QuadTo r101 = (QuadTo) r100;
            if (Float.compare(this.f15222x1, r101.f15222x1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15224y1, r101.f15224y1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15223x2, r101.f15223x2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15225y2, r101.f15225y2) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f15222x1) * 31) + Float.floatToIntBits(this.f15224y1)) * 31) + Float.floatToIntBits(this.f15223x2)) * 31) + Float.floatToIntBits(this.f15225y2);
        }

        public String toString() {
            return "QuadTo(x1=" + this.f15222x1 + ", y1=" + this.f15224y1 + ", x2=" + this.f15223x2 + ", y2=" + this.f15225y2 + ')';
        }

        public final float getX1() {
            return this.f15222x1;
        }

        public final float getX2() {
            return this.f15223x2;
        }

        public final float getY1() {
            return this.f15224y1;
        }

        public final float getY2() {
            return this.f15225y2;
        }

        public QuadTo(float r100, float r101, float r102, float r103) {
            boolean r104 = false;
            char r105 = 1 == true ? 1 : 0;
            super(r104, true, r105, null);
            this.f15222x1 = r100;
            this.f15224y1 = r101;
            this.f15223x2 = r102;
            this.f15225y2 = r103;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ReflectiveCurveTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f15226x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f15227x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f15228y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f15229y2;

        public static /* synthetic */ ReflectiveCurveTo copy$default(ReflectiveCurveTo r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f15226x1;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.f15228y1;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.f15227x2;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.f15229y2;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.f15226x1;
        }

        public final float component2() {
            return this.f15228y1;
        }

        public final float component3() {
            return this.f15227x2;
        }

        public final float component4() {
            return this.f15229y2;
        }

        public final ReflectiveCurveTo copy(float r100, float r101, float r102, float r103) {
            return new ReflectiveCurveTo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReflectiveCurveTo) == true) goto L8;
            return false;
        L8:
            ReflectiveCurveTo r101 = (ReflectiveCurveTo) r100;
            if (Float.compare(this.f15226x1, r101.f15226x1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15228y1, r101.f15228y1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15227x2, r101.f15227x2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15229y2, r101.f15229y2) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f15226x1) * 31) + Float.floatToIntBits(this.f15228y1)) * 31) + Float.floatToIntBits(this.f15227x2)) * 31) + Float.floatToIntBits(this.f15229y2);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f15226x1 + ", y1=" + this.f15228y1 + ", x2=" + this.f15227x2 + ", y2=" + this.f15229y2 + ')';
        }

        public final float getX1() {
            return this.f15226x1;
        }

        public final float getX2() {
            return this.f15227x2;
        }

        public final float getY1() {
            return this.f15228y1;
        }

        public final float getY2() {
            return this.f15229y2;
        }

        public ReflectiveCurveTo(float r100, float r101, float r102, float r103) {
            boolean r104 = true;
            boolean r105 = false;
            super(r104, r105, 2, null);
            this.f15226x1 = r100;
            this.f15228y1 = r101;
            this.f15227x2 = r102;
            this.f15229y2 = r103;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ReflectiveQuadTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f15230x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f15231y;

        public static /* synthetic */ ReflectiveQuadTo copy$default(ReflectiveQuadTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15230x;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15231y;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15230x;
        }

        public final float component2() {
            return this.f15231y;
        }

        public final ReflectiveQuadTo copy(float r100, float r101) {
            return new ReflectiveQuadTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReflectiveQuadTo) == true) goto L8;
            return false;
        L8:
            ReflectiveQuadTo r101 = (ReflectiveQuadTo) r100;
            if (Float.compare(this.f15230x, r101.f15230x) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15231y, r101.f15231y) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15230x) * 31) + Float.floatToIntBits(this.f15231y);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f15230x + ", y=" + this.f15231y + ')';
        }

        public final float getX() {
            return this.f15230x;
        }

        public final float getY() {
            return this.f15231y;
        }

        public ReflectiveQuadTo(float r100, float r101) {
            boolean r102 = false;
            char r103 = 1 == true ? 1 : 0;
            super(r102, true, r103, null);
            this.f15230x = r100;
            this.f15231y = r101;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "<init>", "(FFFZZFF)V", "getHorizontalEllipseRadius", "()F", "getVerticalEllipseRadius", "getTheta", "()Z", "getArcStartDx", "getArcStartDy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeArcTo extends PathNode {
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        public static /* synthetic */ RelativeArcTo copy$default(RelativeArcTo r100, float r101, float r102, float r103, boolean r104, boolean r110, float r111, float r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.horizontalEllipseRadius;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.verticalEllipseRadius;
        L8:
            float r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.theta;
        L11:
            float r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.isMoreThanHalf;
        L14:
            boolean r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.isPositiveArc;
        L17:
            boolean r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.arcStartDx;
        L20:
            float r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.arcStartDy;
        L23:
            float r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartDx;
        }

        public final float component7() {
            return this.arcStartDy;
        }

        public final RelativeArcTo copy(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r116) {
            return new RelativeArcTo(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeArcTo) == true) goto L8;
            return false;
        L8:
            RelativeArcTo r101 = (RelativeArcTo) r100;
            if (Float.compare(this.horizontalEllipseRadius, r101.horizontalEllipseRadius) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.verticalEllipseRadius, r101.verticalEllipseRadius) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.theta, r101.theta) == 0) goto L18;
            return false;
        L18:
            if (this.isMoreThanHalf == r101.isMoreThanHalf) goto L21;
            return false;
        L21:
            if (this.isPositiveArc == r101.isPositiveArc) goto L24;
            return false;
        L24:
            if (Float.compare(this.arcStartDx, r101.arcStartDx) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.arcStartDy, r101.arcStartDy) == 0) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r100 = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            int r101 = 1231;
            if (this.isMoreThanHalf == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.isPositiveArc == true) goto L11;
            r101 = 1237;
        L11:
            return ((((r103 + r101) * 31) + Float.floatToIntBits(this.arcStartDx)) * 31) + Float.floatToIntBits(this.arcStartDy);
        L5:
            r102 = 1237;
            goto L6
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        public RelativeArcTo(float r100, float r101, float r102, boolean r103, boolean r104, float r105, float r110) {
            boolean r106 = false;
            super(r106, r106, 3, null);
            this.horizontalEllipseRadius = r100;
            this.verticalEllipseRadius = r101;
            this.theta = r102;
            this.isMoreThanHalf = r103;
            this.isPositiveArc = r104;
            this.arcStartDx = r105;
            this.arcStartDy = r110;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "<init>", "(FFFFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "getDx3", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeCurveTo extends PathNode {

        /* JADX INFO: renamed from: dx1, reason: collision with root package name */
        private final float f15232dx1;

        /* JADX INFO: renamed from: dx2, reason: collision with root package name */
        private final float f15233dx2;

        /* JADX INFO: renamed from: dx3, reason: collision with root package name */
        private final float f15234dx3;

        /* JADX INFO: renamed from: dy1, reason: collision with root package name */
        private final float f15235dy1;

        /* JADX INFO: renamed from: dy2, reason: collision with root package name */
        private final float f15236dy2;

        /* JADX INFO: renamed from: dy3, reason: collision with root package name */
        private final float f15237dy3;

        public static /* synthetic */ RelativeCurveTo copy$default(RelativeCurveTo r100, float r101, float r102, float r103, float r104, float r105, float r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.f15232dx1;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.f15235dy1;
        L8:
            float r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.f15233dx2;
        L11:
            float r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.f15236dy2;
        L14:
            float r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.f15234dx3;
        L17:
            float r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.f15237dy3;
        L20:
            float r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final float component1() {
            return this.f15232dx1;
        }

        public final float component2() {
            return this.f15235dy1;
        }

        public final float component3() {
            return this.f15233dx2;
        }

        public final float component4() {
            return this.f15236dy2;
        }

        public final float component5() {
            return this.f15234dx3;
        }

        public final float component6() {
            return this.f15237dy3;
        }

        public final RelativeCurveTo copy(float r100, float r110, float r111, float r112, float r113, float r114) {
            return new RelativeCurveTo(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeCurveTo) == true) goto L8;
            return false;
        L8:
            RelativeCurveTo r101 = (RelativeCurveTo) r100;
            if (Float.compare(this.f15232dx1, r101.f15232dx1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15235dy1, r101.f15235dy1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15233dx2, r101.f15233dx2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15236dy2, r101.f15236dy2) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f15234dx3, r101.f15234dx3) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f15237dy3, r101.f15237dy3) == 0) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f15232dx1) * 31) + Float.floatToIntBits(this.f15235dy1)) * 31) + Float.floatToIntBits(this.f15233dx2)) * 31) + Float.floatToIntBits(this.f15236dy2)) * 31) + Float.floatToIntBits(this.f15234dx3)) * 31) + Float.floatToIntBits(this.f15237dy3);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.f15232dx1 + ", dy1=" + this.f15235dy1 + ", dx2=" + this.f15233dx2 + ", dy2=" + this.f15236dy2 + ", dx3=" + this.f15234dx3 + ", dy3=" + this.f15237dy3 + ')';
        }

        public final float getDx1() {
            return this.f15232dx1;
        }

        public final float getDx2() {
            return this.f15233dx2;
        }

        public final float getDx3() {
            return this.f15234dx3;
        }

        public final float getDy1() {
            return this.f15235dy1;
        }

        public final float getDy2() {
            return this.f15236dy2;
        }

        public final float getDy3() {
            return this.f15237dy3;
        }

        public RelativeCurveTo(float r100, float r101, float r102, float r103, float r104, float r110) {
            boolean r105 = true;
            boolean r106 = false;
            super(r105, r106, 2, null);
            this.f15232dx1 = r100;
            this.f15235dy1 = r101;
            this.f15233dx2 = r102;
            this.f15236dy2 = r103;
            this.f15234dx3 = r104;
            this.f15237dy3 = r110;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "<init>", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeHorizontalTo extends PathNode {

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        private final float f15238dx;

        public static /* synthetic */ RelativeHorizontalTo copy$default(RelativeHorizontalTo r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.f15238dx;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.f15238dx;
        }

        public final RelativeHorizontalTo copy(float r100) {
            return new RelativeHorizontalTo(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeHorizontalTo) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f15238dx, ((RelativeHorizontalTo) r100).f15238dx) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f15238dx);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f15238dx + ')';
        }

        public final float getDx() {
            return this.f15238dx;
        }

        public RelativeHorizontalTo(float r100) {
            boolean r101 = false;
            super(r101, r101, 3, null);
            this.f15238dx = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeLineTo extends PathNode {

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        private final float f15239dx;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        private final float f15240dy;

        public static /* synthetic */ RelativeLineTo copy$default(RelativeLineTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15239dx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15240dy;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15239dx;
        }

        public final float component2() {
            return this.f15240dy;
        }

        public final RelativeLineTo copy(float r100, float r101) {
            return new RelativeLineTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeLineTo) == true) goto L8;
            return false;
        L8:
            RelativeLineTo r101 = (RelativeLineTo) r100;
            if (Float.compare(this.f15239dx, r101.f15239dx) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15240dy, r101.f15240dy) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15239dx) * 31) + Float.floatToIntBits(this.f15240dy);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.f15239dx + ", dy=" + this.f15240dy + ')';
        }

        public final float getDx() {
            return this.f15239dx;
        }

        public final float getDy() {
            return this.f15240dy;
        }

        public RelativeLineTo(float r100, float r101) {
            boolean r102 = false;
            super(r102, r102, 3, null);
            this.f15239dx = r100;
            this.f15240dy = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeMoveTo extends PathNode {

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        private final float f15241dx;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        private final float f15242dy;

        public static /* synthetic */ RelativeMoveTo copy$default(RelativeMoveTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15241dx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15242dy;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15241dx;
        }

        public final float component2() {
            return this.f15242dy;
        }

        public final RelativeMoveTo copy(float r100, float r101) {
            return new RelativeMoveTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeMoveTo) == true) goto L8;
            return false;
        L8:
            RelativeMoveTo r101 = (RelativeMoveTo) r100;
            if (Float.compare(this.f15241dx, r101.f15241dx) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15242dy, r101.f15242dy) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15241dx) * 31) + Float.floatToIntBits(this.f15242dy);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.f15241dx + ", dy=" + this.f15242dy + ')';
        }

        public final float getDx() {
            return this.f15241dx;
        }

        public final float getDy() {
            return this.f15242dy;
        }

        public RelativeMoveTo(float r100, float r101) {
            boolean r102 = false;
            super(r102, r102, 3, null);
            this.f15241dx = r100;
            this.f15242dy = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "<init>", "(FFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeQuadTo extends PathNode {

        /* JADX INFO: renamed from: dx1, reason: collision with root package name */
        private final float f15243dx1;

        /* JADX INFO: renamed from: dx2, reason: collision with root package name */
        private final float f15244dx2;

        /* JADX INFO: renamed from: dy1, reason: collision with root package name */
        private final float f15245dy1;

        /* JADX INFO: renamed from: dy2, reason: collision with root package name */
        private final float f15246dy2;

        public static /* synthetic */ RelativeQuadTo copy$default(RelativeQuadTo r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f15243dx1;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.f15245dy1;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.f15244dx2;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.f15246dy2;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.f15243dx1;
        }

        public final float component2() {
            return this.f15245dy1;
        }

        public final float component3() {
            return this.f15244dx2;
        }

        public final float component4() {
            return this.f15246dy2;
        }

        public final RelativeQuadTo copy(float r100, float r101, float r102, float r103) {
            return new RelativeQuadTo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeQuadTo) == true) goto L8;
            return false;
        L8:
            RelativeQuadTo r101 = (RelativeQuadTo) r100;
            if (Float.compare(this.f15243dx1, r101.f15243dx1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15245dy1, r101.f15245dy1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15244dx2, r101.f15244dx2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15246dy2, r101.f15246dy2) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f15243dx1) * 31) + Float.floatToIntBits(this.f15245dy1)) * 31) + Float.floatToIntBits(this.f15244dx2)) * 31) + Float.floatToIntBits(this.f15246dy2);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.f15243dx1 + ", dy1=" + this.f15245dy1 + ", dx2=" + this.f15244dx2 + ", dy2=" + this.f15246dy2 + ')';
        }

        public final float getDx1() {
            return this.f15243dx1;
        }

        public final float getDx2() {
            return this.f15244dx2;
        }

        public final float getDy1() {
            return this.f15245dy1;
        }

        public final float getDy2() {
            return this.f15246dy2;
        }

        public RelativeQuadTo(float r100, float r101, float r102, float r103) {
            boolean r104 = false;
            char r105 = 1 == true ? 1 : 0;
            super(r104, true, r105, null);
            this.f15243dx1 = r100;
            this.f15245dy1 = r101;
            this.f15244dx2 = r102;
            this.f15246dy2 = r103;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "<init>", "(FFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeReflectiveCurveTo extends PathNode {

        /* JADX INFO: renamed from: dx1, reason: collision with root package name */
        private final float f15247dx1;

        /* JADX INFO: renamed from: dx2, reason: collision with root package name */
        private final float f15248dx2;

        /* JADX INFO: renamed from: dy1, reason: collision with root package name */
        private final float f15249dy1;

        /* JADX INFO: renamed from: dy2, reason: collision with root package name */
        private final float f15250dy2;

        public static /* synthetic */ RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f15247dx1;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.f15249dy1;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.f15248dx2;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.f15250dy2;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.f15247dx1;
        }

        public final float component2() {
            return this.f15249dy1;
        }

        public final float component3() {
            return this.f15248dx2;
        }

        public final float component4() {
            return this.f15250dy2;
        }

        public final RelativeReflectiveCurveTo copy(float r100, float r101, float r102, float r103) {
            return new RelativeReflectiveCurveTo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeReflectiveCurveTo) == true) goto L8;
            return false;
        L8:
            RelativeReflectiveCurveTo r101 = (RelativeReflectiveCurveTo) r100;
            if (Float.compare(this.f15247dx1, r101.f15247dx1) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15249dy1, r101.f15249dy1) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f15248dx2, r101.f15248dx2) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f15250dy2, r101.f15250dy2) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f15247dx1) * 31) + Float.floatToIntBits(this.f15249dy1)) * 31) + Float.floatToIntBits(this.f15248dx2)) * 31) + Float.floatToIntBits(this.f15250dy2);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.f15247dx1 + ", dy1=" + this.f15249dy1 + ", dx2=" + this.f15248dx2 + ", dy2=" + this.f15250dy2 + ')';
        }

        public final float getDx1() {
            return this.f15247dx1;
        }

        public final float getDx2() {
            return this.f15248dx2;
        }

        public final float getDy1() {
            return this.f15249dy1;
        }

        public final float getDy2() {
            return this.f15250dy2;
        }

        public RelativeReflectiveCurveTo(float r100, float r101, float r102, float r103) {
            boolean r104 = true;
            boolean r105 = false;
            super(r104, r105, 2, null);
            this.f15247dx1 = r100;
            this.f15249dy1 = r101;
            this.f15248dx2 = r102;
            this.f15250dy2 = r103;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeReflectiveQuadTo extends PathNode {

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        private final float f15251dx;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        private final float f15252dy;

        public static /* synthetic */ RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f15251dx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15252dy;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.f15251dx;
        }

        public final float component2() {
            return this.f15252dy;
        }

        public final RelativeReflectiveQuadTo copy(float r100, float r101) {
            return new RelativeReflectiveQuadTo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeReflectiveQuadTo) == true) goto L8;
            return false;
        L8:
            RelativeReflectiveQuadTo r101 = (RelativeReflectiveQuadTo) r100;
            if (Float.compare(this.f15251dx, r101.f15251dx) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f15252dy, r101.f15252dy) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f15251dx) * 31) + Float.floatToIntBits(this.f15252dy);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f15251dx + ", dy=" + this.f15252dy + ')';
        }

        public final float getDx() {
            return this.f15251dx;
        }

        public final float getDy() {
            return this.f15252dy;
        }

        public RelativeReflectiveQuadTo(float r100, float r101) {
            boolean r102 = false;
            char r103 = 1 == true ? 1 : 0;
            super(r102, true, r103, null);
            this.f15251dx = r100;
            this.f15252dy = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "<init>", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RelativeVerticalTo extends PathNode {

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        private final float f15253dy;

        public static /* synthetic */ RelativeVerticalTo copy$default(RelativeVerticalTo r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.f15253dy;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.f15253dy;
        }

        public final RelativeVerticalTo copy(float r100) {
            return new RelativeVerticalTo(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RelativeVerticalTo) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f15253dy, ((RelativeVerticalTo) r100).f15253dy) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f15253dy);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f15253dy + ')';
        }

        public final float getDy() {
            return this.f15253dy;
        }

        public RelativeVerticalTo(float r100) {
            boolean r101 = false;
            super(r101, r101, 3, null);
            this.f15253dy = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "<init>", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class VerticalTo extends PathNode {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f15254y;

        public static /* synthetic */ VerticalTo copy$default(VerticalTo r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.f15254y;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.f15254y;
        }

        public final VerticalTo copy(float r100) {
            return new VerticalTo(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof VerticalTo) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f15254y, ((VerticalTo) r100).f15254y) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f15254y);
        }

        public String toString() {
            return "VerticalTo(y=" + this.f15254y + ')';
        }

        public final float getY() {
            return this.f15254y;
        }

        public VerticalTo(float r100) {
            boolean r101 = false;
            super(r101, r101, 3, null);
            this.f15254y = r100;
        }
    }

    public /* synthetic */ PathNode(boolean r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }

    private PathNode(boolean r100, boolean r101) {
        this.isCurve = r100;
        this.isQuad = r101;
    }

    public /* synthetic */ PathNode(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101, null);
    }
}
