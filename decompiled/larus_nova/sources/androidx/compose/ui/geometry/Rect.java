package androidx.compose.ui.geometry;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0007J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0003H\u0007J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0003H\u0007J\u0010\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0000H\u0007J(\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0007J\u000e\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0000J\u0018\u0010M\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0086\u0002¢\u0006\u0004\bN\u0010OJ\b\u0010P\u001a\u00020QH\u0016J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J1\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010W\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020YHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0013\u001a\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010!R\u001a\u0010\"\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\n\u001a\u0004\b\"\u0010!R\u001a\u0010$\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001a\u0004\b$\u0010!R\u0011\u00107\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b8\u0010\fR\u0011\u00109\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b:\u0010\fR\u0011\u0010;\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b<\u0010\u001dR\u0011\u0010=\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b>\u0010\u001dR\u0011\u0010?\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b@\u0010\u001dR\u0011\u0010A\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bB\u0010\u001dR\u0011\u0010C\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bD\u0010\u001dR\u0011\u0010E\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bF\u0010\u001dR\u0011\u0010G\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bH\u0010\u001dR\u0011\u0010I\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001dR\u0011\u0010K\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bL\u0010\u001d¨\u0006["}, d2 = {"Landroidx/compose/ui/geometry/Rect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft$annotations", "()V", "getLeft", "()F", "getTop$annotations", "getTop", "getRight$annotations", "getRight", "getBottom$annotations", "getBottom", "width", "getWidth$annotations", "getWidth", "height", "getHeight$annotations", "getHeight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc$annotations", "getSize-NH-jbRc", "()J", "isInfinite", "", "isInfinite$annotations", "()Z", "isFinite", "isFinite$annotations", "isEmpty", "isEmpty$annotations", "translate", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-k-4lQ0M", "(J)Landroidx/compose/ui/geometry/Rect;", "translateX", "translateY", WidgetCostModule.TYPE_INFLATE, "delta", "deflate", "intersect", "other", "otherLeft", "otherTop", "otherRight", "otherBottom", "overlaps", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-F1C5BW0", "topCenter", "getTopCenter-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "center", "getCenter-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomCenter", "getBottomCenter-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "contains", "contains-k-4lQ0M", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Rect {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Rect Zero = null;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/Rect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/Rect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/Rect;", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        public final Rect getZero() {
            return Rect.access$getZero$cp();
        }
    }

    public static /* synthetic */ Rect copy$default(Rect r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.top;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.right;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    public static /* synthetic */ void getLeft$annotations() {
    }

    public static /* synthetic */ void getRight$annotations() {
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc$annotations, reason: not valid java name */
    public static /* synthetic */ void m4607getSizeNHjbRc$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    public static /* synthetic */ void isFinite$annotations() {
    }

    public static /* synthetic */ void isInfinite$annotations() {
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    public final Rect copy(float r100, float r101, float r102, float r103) {
        return new Rect(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Rect) == true) goto L8;
        return false;
    L8:
        Rect r101 = (Rect) r100;
        if (Float.compare(this.left, r101.left) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.top, r101.top) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.right, r101.right) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.bottom, r101.bottom) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    static {
        Companion = new Companion(null);
        Zero = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: getBottomCenter-F1C5BW0, reason: not valid java name */
    public final long m4609getBottomCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getBottomLeft-F1C5BW0, reason: not valid java name */
    public final long m4610getBottomLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getBottomRight-F1C5BW0, reason: not valid java name */
    public final long m4611getBottomRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m4612getCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenterLeft-F1C5BW0, reason: not valid java name */
    public final long m4613getCenterLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenterRight-F1C5BW0, reason: not valid java name */
    public final long m4614getCenterRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopCenter-F1C5BW0, reason: not valid java name */
    public final long m4616getTopCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m4617getTopLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopRight-F1C5BW0, reason: not valid java name */
    public final long m4618getTopRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    public final boolean isEmpty() {
        boolean r100 = true;
        if (this.left < this.right) goto L5;
        boolean r101 = true;
    L7:
        if (this.top >= this.bottom) goto L11;
        r100 = false;
    L11:
        return r101 | r100;
    L5:
        r101 = false;
        goto L7
    }

    public final boolean isFinite() {
        boolean r100 = true;
        if ((Float.floatToRawIntBits(this.left) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        boolean r101 = true;
    L7:
        if ((Float.floatToRawIntBits(this.top) & Integer.MAX_VALUE) >= 2139095040) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r101 & r102;
        if ((Float.floatToRawIntBits(this.right) & Integer.MAX_VALUE) >= 2139095040) goto L13;
        boolean r104 = true;
    L14:
        boolean r105 = r103 & r104;
        if ((Integer.MAX_VALUE & Float.floatToRawIntBits(this.bottom)) < 2139095040) goto L19;
        r100 = false;
    L19:
        return r105 & r100;
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public final boolean isInfinite() {
        boolean r100 = true;
        if (this.left != Float.POSITIVE_INFINITY) goto L5;
        boolean r101 = true;
    L7:
        if (this.top != Float.POSITIVE_INFINITY) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r101 | r102;
        if (this.right != Float.POSITIVE_INFINITY) goto L13;
        boolean r104 = true;
    L14:
        boolean r105 = r103 | r104;
        if (this.bottom == Float.POSITIVE_INFINITY) goto L19;
        r100 = false;
    L19:
        return r105 | r100;
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final float getHeight() {
        return getBottom() - getTop();
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4615getSizeNHjbRc() {
        float r100 = getRight() - getLeft();
        float r101 = getBottom() - getTop();
        long r102 = Float.floatToRawIntBits(r100);
        return Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    public final float getWidth() {
        return getRight() - getLeft();
    }

    public static final /* synthetic */ Rect access$getZero$cp() {
        return Zero;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m4608containsk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        boolean r103 = true;
        if (r101 < this.left) goto L5;
        boolean r104 = true;
    L7:
        if (r101 >= this.right) goto L9;
        boolean r105 = true;
    L10:
        boolean r106 = r104 & r105;
        if (r102 < this.top) goto L13;
        boolean r107 = true;
    L14:
        boolean r108 = r106 & r107;
        if (r102 < this.bottom) goto L19;
        r103 = false;
    L19:
        return r108 & r103;
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public final Rect deflate(float r100) {
        return inflate(-r100);
    }

    public final Rect inflate(float r100) {
        return new Rect(this.left - r100, this.top - r100, this.right + r100, this.bottom + r100);
    }

    public final Rect intersect(Rect r100) {
        return new Rect(Math.max(this.left, r100.left), Math.max(this.top, r100.top), Math.min(this.right, r100.right), Math.min(this.bottom, r100.bottom));
    }

    public final boolean overlaps(Rect r100) {
        boolean r101 = true;
        if (this.left >= r100.right) goto L5;
        boolean r102 = true;
    L7:
        if (r100.left >= this.right) goto L9;
        boolean r103 = true;
    L10:
        boolean r104 = r102 & r103;
        if (this.top >= r100.bottom) goto L13;
        boolean r105 = true;
    L14:
        boolean r106 = r104 & r105;
        if (r100.top < this.bottom) goto L19;
        r101 = false;
    L19:
        return r106 & r101;
    L13:
        r105 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final Rect m4619translatek4lQ0M(long r100) {
        int r101 = (int) (r100 >> 32);
        float r102 = this.left + Float.intBitsToFloat(r101);
        float r103 = this.top;
        int r104 = (int) (r100 & BodyPartID.bodyIdMax);
        return new Rect(r102, r103 + Float.intBitsToFloat(r104), this.right + Float.intBitsToFloat(r101), this.bottom + Float.intBitsToFloat(r104));
    }

    public final Rect translate(float r100, float r101) {
        return new Rect(this.left + r100, this.top + r101, this.right + r100, this.bottom + r101);
    }

    public Rect(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }

    public final Rect intersect(float r100, float r101, float r102, float r103) {
        return new Rect(Math.max(this.left, r100), Math.max(this.top, r101), Math.min(this.right, r102), Math.min(this.bottom, r103));
    }
}
