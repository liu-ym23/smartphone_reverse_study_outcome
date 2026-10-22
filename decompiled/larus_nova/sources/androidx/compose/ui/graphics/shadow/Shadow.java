package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BE\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010BA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0011BC\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0012J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u0006*"}, d2 = {"Landroidx/compose/ui/graphics/shadow/Shadow;", "", "radius", "Landroidx/compose/ui/unit/Dp;", "spread", "offset", "Landroidx/compose/ui/unit/DpOffset;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "<init>", "(FFJJLandroidx/compose/ui/graphics/Brush;FI)V", "(FLandroidx/compose/ui/graphics/Brush;FJFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(FJFJFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadius-D9Ej5fM", "()F", FaceService.girlLabel, "getSpread-D9Ej5fM", "getOffset-RKDOV3M", "()J", "J", "getBlendMode-0nO6VwU", "()I", "I", "getColor-0d7_KjU", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "equals", "", "other", "hashCode", "", "toString", "", "copyWithoutOffset", "copyWithoutOffset$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shadow {
    private final float alpha;
    private final int blendMode;
    private final Brush brush;
    private final long color;
    private final long offset;
    private final float radius;
    private final float spread;

    public /* synthetic */ Shadow(float r100, long r101, float r102, long r103, float r104, int r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    public /* synthetic */ Shadow(float r100, Brush r101, float r102, long r103, float r104, int r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    public final Shadow copyWithoutOffset$ui_graphics_release() {
        return new Shadow(this.radius, this.spread, DpOffset.Companion.m7615getZeroRKDOV3M(), this.color, this.brush, this.alpha, this.blendMode);
    }

    public int hashCode() {
        int r100 = ((((((((((Dp.m7550hashCodeimpl(this.radius) * 31) + Dp.m7550hashCodeimpl(this.spread)) * 31) + DpOffset.m7609hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + BlendMode.m4738hashCodeimpl(this.blendMode)) * 31) + Color.m4834hashCodeimpl(this.color)) * 31;
        Brush r101 = this.brush;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "ShadowParams(radius=" + Dp.m7555toStringimpl(this.radius) + ", spread=" + Dp.m7555toStringimpl(this.spread) + ", offset=" + DpOffset.m7612toStringimpl(this.offset) + ", alpha=" + this.alpha + ", blendMode=" + BlendMode.m4739toStringimpl(this.blendMode) + ", color=" + Color.m4835toStringimpl(this.color) + ", brush=" + this.brush + ')';
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m5553getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m5554getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getOffset-RKDOV3M, reason: not valid java name */
    public final long m5555getOffsetRKDOV3M() {
        return this.offset;
    }

    /* JADX INFO: renamed from: getRadius-D9Ej5fM, reason: not valid java name */
    public final float m5556getRadiusD9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: getSpread-D9Ej5fM, reason: not valid java name */
    public final float m5557getSpreadD9Ej5fM() {
        return this.spread;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Shadow) == true) goto L8;
        return false;
    L8:
        Shadow r101 = (Shadow) r100;
        if (Dp.m7549equalsimpl0(this.radius, r101.radius) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.spread, r101.spread) == true) goto L15;
        return false;
    L15:
        if (DpOffset.m7604equalsimpl0(this.offset, r101.offset) == true) goto L18;
        return false;
    L18:
        if (this.alpha != r101.alpha) goto L20;
        boolean r102 = true;
    L21:
        if (r102 == true) goto L24;
        return false;
    L24:
        if (BlendMode.m4737equalsimpl0(this.blendMode, r101.blendMode) == true) goto L27;
        return false;
    L27:
        if (Color.m4828equalsimpl0(this.color, r101.color) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.brush, r101.brush) == true) goto L32;
        return false;
    L32:
        return true;
    L20:
        r102 = false;
        goto L21
    }

    private Shadow(float r110, long r111, float r112, long r113, float r114, int r210) {
        if (r111 == 16) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        long r101 = r111;
    L9:
        this(r110, r112, r113, r101, null, r114, r210);
        return;
    L8:
        r101 = Color.Companion.m4853getBlack0d7_KjU();
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    private Shadow(float r110, Brush r111, float r112, long r113, float r114, int r115) {
        this(r110, r112, r113, Color.Companion.m4853getBlack0d7_KjU(), r111, r114, r115);
    }

    private Shadow(float r100, float r101, long r102, long r103, Brush r104, float r105, int r106) {
        this.radius = r100;
        this.spread = r101;
        this.offset = r102;
        this.blendMode = r106;
        if ((r104 instanceof SolidColor) == false) goto L5;
        this.color = ((SolidColor) r104).m5188getValue0d7_KjU();
        this.brush = null;
    L6:
        this.alpha = RangesKt.coerceIn(r105, 0.0f, 1.0f);
        return;
    L5:
        this.color = r103;
        this.brush = r104;
        goto L6
    }

    public /* synthetic */ Shadow(float r110, long r111, float r112, long r113, float r114, int r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 2) == 0) goto L5;
        long r100 = Color.Companion.m4853getBlack0d7_KjU();
    L7:
        if ((r211 & 4) == 0) goto L9;
        float r101 = Dp.m7544constructorimpl(0);
    L11:
        if ((r211 & 8) == 0) goto L13;
        long r102 = DpOffset.Companion.m7615getZeroRKDOV3M();
    L15:
        if ((r211 & 16) == 0) goto L17;
        float r103 = 1.0f;
    L19:
        if ((r211 & 32) == 0) goto L21;
        int r115 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
    L22:
        this(r110, r100, r101, r102, r103, r115, null);
        return;
    L21:
        r115 = r210;
        goto L22
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

    public /* synthetic */ Shadow(float r110, Brush r111, float r112, long r113, float r114, int r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        float r100 = Dp.m7544constructorimpl(0);
    L7:
        if ((r116 & 8) == 0) goto L9;
        long r101 = DpOffset.Companion.m7615getZeroRKDOV3M();
    L11:
        if ((r116 & 16) == 0) goto L13;
        float r102 = 1.0f;
    L15:
        if ((r116 & 32) == 0) goto L17;
        int r103 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
    L18:
        this(r110, r111, r100, r101, r102, r103, null);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
