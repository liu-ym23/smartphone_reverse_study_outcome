package androidx.compose.ui.geometry;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0001?BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001e\u001a\u00020\u0000H\u0002J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b1\u0010\u0014J\u0010\u00102\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b3\u0010\u0014J\u0010\u00104\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b5\u0010\u0014J\u0010\u00106\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b7\u0010\u0014J`\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "<init>", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "getTopLeftCornerRadius-kKHJgLs", "()J", "J", "getTopRightCornerRadius-kKHJgLs", "getBottomRightCornerRadius-kKHJgLs", "getBottomLeftCornerRadius-kKHJgLs", "width", "getWidth", "height", "getHeight", "_scaledRadiiRect", "scaledRadiiRect", "minRadius", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "radius1", "radius2", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoundRect {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final RoundRect Zero = null;
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        public final RoundRect getZero() {
            return RoundRect.access$getZero$cp();
        }
    }

    public /* synthetic */ RoundRect(float r100, float r101, float r102, float r103, long r104, long r105, long r106, long r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r110);
    }

    /* JADX INFO: renamed from: copy-MDFrsts$default, reason: not valid java name */
    public static /* synthetic */ RoundRect m4623copyMDFrsts$default(RoundRect r110, float r111, float r112, float r113, float r114, long r115, long r210, long r211, long r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        float r100 = r110.left;
    L7:
        if ((r213 & 2) == 0) goto L9;
        float r101 = r110.top;
    L11:
        if ((r213 & 4) == 0) goto L13;
        float r102 = r110.right;
    L15:
        if ((r213 & 8) == 0) goto L17;
        float r103 = r110.bottom;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r104 = r110.topLeftCornerRadius;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r105 = r110.topRightCornerRadius;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r116 = r110.bottomRightCornerRadius;
    L31:
        if ((r213 & 128) == 0) goto L33;
        long r117 = r110.bottomLeftCornerRadius;
    L35:
        return r110.m4629copyMDFrsts(r100, r101, r102, r103, r104, r105, r116, r117);
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
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

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name */
    public final long m4624component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m4625component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m4626component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m4627component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m4629copyMDFrsts(float r110, float r111, float r112, float r113, long r210, long r211, long r212, long r213) {
        return new RoundRect(r110, r111, r112, r113, r210, r211, r212, r213, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RoundRect) == true) goto L8;
        return false;
    L8:
        RoundRect r101 = (RoundRect) r100;
        if (Float.compare(this.left, r101.left) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.top, r101.top) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.right, r101.right) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.bottom, r101.bottom) == 0) goto L21;
        return false;
    L21:
        if (CornerRadius.m4541equalsimpl0(this.topLeftCornerRadius, r101.topLeftCornerRadius) == true) goto L24;
        return false;
    L24:
        if (CornerRadius.m4541equalsimpl0(this.topRightCornerRadius, r101.topRightCornerRadius) == true) goto L27;
        return false;
    L27:
        if (CornerRadius.m4541equalsimpl0(this.bottomRightCornerRadius, r101.bottomRightCornerRadius) == true) goto L30;
        return false;
    L30:
        if (CornerRadius.m4541equalsimpl0(this.bottomLeftCornerRadius, r101.bottomLeftCornerRadius) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m4544hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m4544hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m4544hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m4544hashCodeimpl(this.bottomLeftCornerRadius);
    }

    static {
        Companion = new Companion(null);
        Zero = RoundRectKt.m4636RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m4554getZerokKHJgLs());
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect r100 = this._scaledRadiiRect;
        if (r100 != null) goto L6;
        float r101 = minRadius(minRadius(minRadius(minRadius(1.0f, Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (this.topLeftCornerRadius & BodyPartID.bodyIdMax)), getHeight()), Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)), Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)), getWidth()), Float.intBitsToFloat((int) (this.topRightCornerRadius & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (this.bottomRightCornerRadius & BodyPartID.bodyIdMax)), getHeight()), Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)), Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)), getWidth());
        float r102 = this.left * r101;
        float r103 = this.top * r101;
        float r104 = this.right * r101;
        float r105 = this.bottom * r101;
        float r106 = Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)) * r101;
        float r110 = Float.intBitsToFloat((int) (this.topLeftCornerRadius & BodyPartID.bodyIdMax)) * r101;
        long r111 = Float.floatToRawIntBits(r106);
        long r112 = CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r110)) & BodyPartID.bodyIdMax) | (r111 << 32));
        float r107 = Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)) * r101;
        float r108 = Float.intBitsToFloat((int) (this.topRightCornerRadius & BodyPartID.bodyIdMax)) * r101;
        long r109 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r107) << 32) | (((long) Float.floatToRawIntBits(r108)) & BodyPartID.bodyIdMax));
        float r113 = Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)) * r101;
        float r114 = Float.intBitsToFloat((int) (this.bottomRightCornerRadius & BodyPartID.bodyIdMax)) * r101;
        long r115 = Float.floatToRawIntBits(r113);
        long r116 = CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r114)) & BodyPartID.bodyIdMax) | (r115 << 32));
        float r117 = Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)) * r101;
        float r118 = Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & BodyPartID.bodyIdMax)) * r101;
        long r119 = Float.floatToRawIntBits(r117);
        RoundRect r120 = new RoundRect(r102, r103, r104, r105, r112, r109, r116, CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r118)) & BodyPartID.bodyIdMax) | (r119 << 32)), null);
        this._scaledRadiiRect = r120;
        return r120;
    L6:
        return r100;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public String toString() {
        long r100 = this.topLeftCornerRadius;
        long r101 = this.topRightCornerRadius;
        long r102 = this.bottomRightCornerRadius;
        long r103 = this.bottomLeftCornerRadius;
        String r104 = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (CornerRadius.m4541equalsimpl0(r100, r101) == false) goto L18;
        if (CornerRadius.m4541equalsimpl0(r101, r102) == false) goto L18;
        if (CornerRadius.m4541equalsimpl0(r102, r103) == false) goto L18;
        int r105 = (int) (r100 >> 32);
        float r106 = Float.intBitsToFloat(r105);
        int r107 = (int) (r100 & BodyPartID.bodyIdMax);
        if (r106 != Float.intBitsToFloat(r107)) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L16;
        return "RoundRect(rect=" + r104 + ", radius=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(r105), 1) + ')';
    L16:
        return "RoundRect(rect=" + r104 + ", x=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(r105), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(r107), 1) + ')';
    L11:
        r108 = false;
    L18:
        return "RoundRect(rect=" + r104 + ", topLeft=" + CornerRadius.m4550toStringimpl(r100) + ", topRight=" + CornerRadius.m4550toStringimpl(r101) + ", bottomRight=" + CornerRadius.m4550toStringimpl(r102) + ", bottomLeft=" + CornerRadius.m4550toStringimpl(r103) + ')';
    }

    public static final /* synthetic */ RoundRect access$getZero$cp() {
        return Zero;
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m4630getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m4631getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
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

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m4632getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m4633getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m4628containsk4lQ0M(long r110) {
        int r100 = (int) (r110 >> 32);
        if (Float.intBitsToFloat(r100) >= this.left) goto L5;
    L36:
        return false;
    L5:
        if (Float.intBitsToFloat(r100) >= this.right) goto L36;
        int r111 = (int) (r110 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r111) < this.top) goto L36;
        if (Float.intBitsToFloat(r111) >= this.bottom) goto L36;
        RoundRect r112 = scaledRadiiRect();
        if (Float.intBitsToFloat(r100) >= (this.left + Float.intBitsToFloat((int) (r112.topLeftCornerRadius >> 32)))) goto L17;
        if (Float.intBitsToFloat(r111) >= (this.top + Float.intBitsToFloat((int) (r112.topLeftCornerRadius & BodyPartID.bodyIdMax)))) goto L17;
        float r101 = (Float.intBitsToFloat(r100) - this.left) - Float.intBitsToFloat((int) (r112.topLeftCornerRadius >> 32));
        float r113 = (Float.intBitsToFloat(r111) - this.top) - Float.intBitsToFloat((int) (r112.topLeftCornerRadius & BodyPartID.bodyIdMax));
        float r102 = Float.intBitsToFloat((int) (r112.topLeftCornerRadius >> 32));
        float r114 = Float.intBitsToFloat((int) (r112.topLeftCornerRadius & BodyPartID.bodyIdMax));
    L31:
        float r103 = r101 / r102;
        float r115 = r113 / r114;
        if (((r103 * r103) + (r115 * r115)) > 1.0f) goto L37;
        return true;
    L37:
        return false;
    L17:
        if (Float.intBitsToFloat(r100) <= (this.right - Float.intBitsToFloat((int) (r112.topRightCornerRadius >> 32)))) goto L22;
        if (Float.intBitsToFloat(r111) >= (this.top + Float.intBitsToFloat((int) (r112.topRightCornerRadius & BodyPartID.bodyIdMax)))) goto L22;
        r101 = (Float.intBitsToFloat(r100) - this.right) + Float.intBitsToFloat((int) (r112.topRightCornerRadius >> 32));
        r113 = (Float.intBitsToFloat(r111) - this.top) - Float.intBitsToFloat((int) (r112.topRightCornerRadius & BodyPartID.bodyIdMax));
        r102 = Float.intBitsToFloat((int) (r112.topRightCornerRadius >> 32));
        r114 = Float.intBitsToFloat((int) (r112.topRightCornerRadius & BodyPartID.bodyIdMax));
    L22:
        if (Float.intBitsToFloat(r100) <= (this.right - Float.intBitsToFloat((int) (r112.bottomRightCornerRadius >> 32)))) goto L27;
        if (Float.intBitsToFloat(r111) <= (this.bottom - Float.intBitsToFloat((int) (r112.bottomRightCornerRadius & BodyPartID.bodyIdMax)))) goto L27;
        r101 = (Float.intBitsToFloat(r100) - this.right) + Float.intBitsToFloat((int) (r112.bottomRightCornerRadius >> 32));
        r113 = (Float.intBitsToFloat(r111) - this.bottom) + Float.intBitsToFloat((int) (r112.bottomRightCornerRadius & BodyPartID.bodyIdMax));
        r102 = Float.intBitsToFloat((int) (r112.bottomRightCornerRadius >> 32));
        r114 = Float.intBitsToFloat((int) (r112.bottomRightCornerRadius & BodyPartID.bodyIdMax));
    L27:
        if (Float.intBitsToFloat(r100) < (this.left + Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius >> 32)))) goto L29;
    L35:
        return true;
    L29:
        if (Float.intBitsToFloat(r111) <= (this.bottom - Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius & BodyPartID.bodyIdMax)))) goto L35;
        r101 = (Float.intBitsToFloat(r100) - this.left) - Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius >> 32));
        r113 = (Float.intBitsToFloat(r111) - this.bottom) + Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius & BodyPartID.bodyIdMax));
        r102 = Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius >> 32));
        r114 = Float.intBitsToFloat((int) (r112.bottomLeftCornerRadius & BodyPartID.bodyIdMax));
        goto L31
    }

    private final float minRadius(float r100, float r101, float r102, float r103) {
        float r104 = r101 + r102;
        if (r104 > r103) goto L5;
        return r100;
    L5:
        if (r104 != 0.0f) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        return r100;
    L10:
        return Math.min(r100, r103 / r104);
    L7:
        r105 = false;
        goto L8
    }

    private RoundRect(float r100, float r101, float r102, float r103, long r104, long r105, long r106, long r110) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
        this.topLeftCornerRadius = r104;
        this.topRightCornerRadius = r105;
        this.bottomRightCornerRadius = r106;
        this.bottomLeftCornerRadius = r110;
    }

    public /* synthetic */ RoundRect(float r110, float r111, float r210, float r211, long r212, long r213, long r214, long r215, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 16) == 0) goto L5;
        long r100 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L7:
        if ((r310 & 32) == 0) goto L9;
        long r112 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L11:
        if ((r310 & 64) == 0) goto L13;
        long r113 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L15:
        if ((r310 & 128) == 0) goto L17;
        long r114 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L18:
        this(r110, r111, r210, r211, r100, r112, r113, r114, null);
        return;
    L17:
        r114 = r215;
        goto L18
    L13:
        r113 = r214;
        goto L15
    L9:
        r112 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
