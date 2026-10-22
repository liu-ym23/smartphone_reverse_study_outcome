package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0003\"\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b \u0010\u001e\"\u0015\u0010!\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010#\"\u0015\u0010$\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b$\u0010#\"\u0015\u0010%\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0015\u0010&\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010#\"\u0015\u0010'\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b'\u0010#\"\u0015\u0010(\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010+\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b,\u0010*\"\u0015\u0010-\u001a\u00020\u0019*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b0\u0010#¨\u00065"}, d2 = {"RoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "left", "", "top", "right", "bottom", "radiusX", "radiusY", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "translate", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "boundingRect", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "safeInnerRect", "getSafeInnerRect", "isEmpty", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isFinite", "isRect", "isEllipse", "isCircle", "minDimension", "getMinDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "maxDimension", "getMaxDimension", "center", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isSimple", "lerp", "start", "stop", "fraction", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RoundRectKt {
    public static final Rect getBoundingRect(RoundRect r100) {
        return new Rect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    public static final long getCenter(RoundRect r100) {
        float r101 = r100.getLeft() + (r100.getWidth() / 2.0f);
        float r102 = r100.getTop() + (r100.getHeight() / 2.0f);
        long r103 = Float.floatToRawIntBits(r101);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final float getMaxDimension(RoundRect r100) {
        return Math.max(Math.abs(r100.getWidth()), Math.abs(r100.getHeight()));
    }

    public static final float getMinDimension(RoundRect r100) {
        return Math.min(Math.abs(r100.getWidth()), Math.abs(r100.getHeight()));
    }

    public static final Rect getSafeInnerRect(RoundRect r100) {
        float r101 = Math.max(Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() >> 32)));
        float r102 = Math.max(Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)));
        float r103 = Math.max(Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() >> 32)));
        float r104 = Math.max(Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)));
        return new Rect(r100.getLeft() + (r101 * 0.29289323f), r100.getTop() + (r102 * 0.29289323f), r100.getRight() - (r103 * 0.29289323f), r100.getBottom() - (r104 * 0.29289323f));
    }

    public static final boolean isCircle(RoundRect r100) {
        if (r100.getWidth() != r100.getHeight()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        return false;
    L8:
        if (isEllipse(r100) == false) goto L10;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public static final boolean isEllipse(RoundRect r100) {
        if (r100.m4632getTopLeftCornerRadiuskKHJgLs() == r100.m4633getTopRightCornerRadiuskKHJgLs()) goto L5;
    L13:
        return false;
    L5:
        if (r100.m4633getTopRightCornerRadiuskKHJgLs() != r100.m4631getBottomRightCornerRadiuskKHJgLs()) goto L13;
        if (r100.m4631getBottomRightCornerRadiuskKHJgLs() != r100.m4630getBottomLeftCornerRadiuskKHJgLs()) goto L13;
        if (r100.getWidth() > (((double) Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() >> 32))) * 2.0d)) goto L13;
        if (r100.getHeight() > (((double) Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax))) * 2.0d)) goto L13;
        return true;
    }

    public static final boolean isEmpty(RoundRect r100) {
        if (r100.getLeft() < r100.getRight()) goto L5;
    L8:
        return true;
    L5:
        if (r100.getTop() >= r100.getBottom()) goto L8;
        return false;
    }

    public static final boolean isFinite(RoundRect r100) {
        if ((Float.floatToRawIntBits(r100.getLeft()) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L23:
        return false;
    L8:
        if ((Float.floatToRawIntBits(r100.getTop()) & Integer.MAX_VALUE) >= 2139095040) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L23;
        if ((Float.floatToRawIntBits(r100.getRight()) & Integer.MAX_VALUE) >= 2139095040) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L23;
        if ((Float.floatToRawIntBits(r100.getBottom()) & Integer.MAX_VALUE) >= 2139095040) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == false) goto L23;
        return true;
    L20:
        r104 = false;
        goto L21
    L15:
        r103 = false;
        goto L16
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public static final boolean isRect(RoundRect r110) {
        long r100 = r110.m4632getTopLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        long r101 = r100 - InlineClassHelperKt.Uint64Low32;
        if ((((~r100) & r101) & (-9223372034707292160L)) == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L23;
        long r103 = r110.m4633getTopRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        long r111 = r103 - InlineClassHelperKt.Uint64Low32;
        if ((((~r103) & r111) & (-9223372034707292160L)) == 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L23;
        long r105 = r110.m4630getBottomLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        long r112 = r105 - InlineClassHelperKt.Uint64Low32;
        if ((((~r105) & r112) & (-9223372034707292160L)) == 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L23;
        long r107 = r110.m4631getBottomRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        long r108 = r107 - InlineClassHelperKt.Uint64Low32;
        if ((((~r107) & r108) & (-9223372034707292160L)) == 0) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
        return true;
    L20:
        r113 = false;
        goto L21
    L15:
        r106 = false;
        goto L16
    L10:
        r104 = false;
    L23:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static final boolean isSimple(RoundRect r100) {
        long r101 = r100.m4632getTopLeftCornerRadiuskKHJgLs();
        if ((r101 >>> 32) != (r101 & BodyPartID.bodyIdMax)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L14:
        return false;
    L8:
        if (r100.m4632getTopLeftCornerRadiuskKHJgLs() != r100.m4633getTopRightCornerRadiuskKHJgLs()) goto L14;
        if (r100.m4632getTopLeftCornerRadiuskKHJgLs() != r100.m4631getBottomRightCornerRadiuskKHJgLs()) goto L14;
        if (r100.m4632getTopLeftCornerRadiuskKHJgLs() != r100.m4630getBottomLeftCornerRadiuskKHJgLs()) goto L14;
        return true;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m4637RoundRectsniSvfs(Rect r100, long r101) {
        return RoundRect(r100, Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m4638translateUv8p0NA(RoundRect r110, long r111) {
        float r100 = r110.getLeft();
        int r101 = (int) (r111 >> 32);
        float r102 = Float.intBitsToFloat(r101) + r100;
        float r103 = r110.getTop();
        int r104 = (int) (r111 & BodyPartID.bodyIdMax);
        return new RoundRect(r102, Float.intBitsToFloat(r104) + r103, r110.getRight() + Float.intBitsToFloat(r101), r110.getBottom() + Float.intBitsToFloat(r104), r110.m4632getTopLeftCornerRadiuskKHJgLs(), r110.m4633getTopRightCornerRadiuskKHJgLs(), r110.m4631getBottomRightCornerRadiuskKHJgLs(), r110.m4630getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final RoundRect RoundRect(Rect r100, float r101, float r102) {
        return RoundRect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom(), r101, r102);
    }

    public static final RoundRect lerp(RoundRect r110, RoundRect r111, float r112) {
        return new RoundRect(MathHelpersKt.lerp(r110.getLeft(), r111.getLeft(), r112), MathHelpersKt.lerp(r110.getTop(), r111.getTop(), r112), MathHelpersKt.lerp(r110.getRight(), r111.getRight(), r112), MathHelpersKt.lerp(r110.getBottom(), r111.getBottom(), r112), CornerRadiusKt.m4555lerp3Ry4LBc(r110.m4632getTopLeftCornerRadiuskKHJgLs(), r111.m4632getTopLeftCornerRadiuskKHJgLs(), r112), CornerRadiusKt.m4555lerp3Ry4LBc(r110.m4633getTopRightCornerRadiuskKHJgLs(), r111.m4633getTopRightCornerRadiuskKHJgLs(), r112), CornerRadiusKt.m4555lerp3Ry4LBc(r110.m4631getBottomRightCornerRadiuskKHJgLs(), r111.m4631getBottomRightCornerRadiuskKHJgLs(), r112), CornerRadiusKt.m4555lerp3Ry4LBc(r110.m4630getBottomLeftCornerRadiuskKHJgLs(), r111.m4630getBottomLeftCornerRadiuskKHJgLs(), r112), null);
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m4634RoundRectZAM2FJo(Rect r110, long r111, long r112, long r210, long r211) {
        return new RoundRect(r110.getLeft(), r110.getTop(), r110.getRight(), r110.getBottom(), r111, r112, r210, r211, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m4636RoundRectgG7oq9Y(float r100, float r101, float r110, float r111, long r112) {
        return RoundRect(r100, r101, r110, r111, Float.intBitsToFloat((int) (r112 >> 32)), Float.intBitsToFloat((int) (r112 & BodyPartID.bodyIdMax)));
    }

    public static final RoundRect RoundRect(float r110, float r111, float r112, float r113, float r210, float r211) {
        long r114 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r210) << 32) | (((long) Float.floatToRawIntBits(r211)) & BodyPartID.bodyIdMax));
        return new RoundRect(r110, r111, r112, r113, r114, r114, r114, r114, null);
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo$default, reason: not valid java name */
    public static /* synthetic */ RoundRect m4635RoundRectZAM2FJo$default(Rect r100, long r101, long r110, long r111, long r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        long r102 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L7:
        if ((r113 & 4) == 0) goto L9;
        long r103 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L11:
        if ((r113 & 8) == 0) goto L13;
        long r104 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L15:
        if ((r113 & 16) == 0) goto L17;
        long r105 = CornerRadius.Companion.m4554getZerokKHJgLs();
    L19:
        return m4634RoundRectZAM2FJo(r100, r102, r103, r104, r105);
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
