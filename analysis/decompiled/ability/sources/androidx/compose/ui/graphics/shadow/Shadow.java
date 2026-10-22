package androidx.compose.ui.graphics.shadow;

import androidx.annotation.FloatRange;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001BE\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010BA\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0011BC\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b)\u0010&R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b-\u0010\"¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/shadow/Shadow;", "", "Landroidx/compose/ui/unit/Dp;", "radius", "spread", "Landroidx/compose/ui/unit/DpOffset;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Brush;", "brush", "", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", AppAgent.CONSTRUCT, "(FFJJLandroidx/compose/ui/graphics/Brush;FI)V", "(FLandroidx/compose/ui/graphics/Brush;FJFILkotlin/jvm/internal/e;)V", "(FJFJFILkotlin/jvm/internal/e;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "copyWithoutOffset$ui_graphics_release", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "copyWithoutOffset", "F", "getRadius-D9Ej5fM", "()F", "getSpread-D9Ej5fM", "J", "getOffset-RKDOV3M", "()J", "I", "getBlendMode-0nO6VwU", "getColor-0d7_KjU", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Shadow {
    private final float alpha;
    private final int blendMode;
    private final Brush brush;
    private final long color;
    private final long offset;
    private final float radius;
    private final float spread;

    public /* synthetic */ Shadow(float f, long j5, float f7, long j6, @FloatRange(from = 0.0d, to = 1.0d) float f9, int i, e eVar) {
        this(f, j5, f7, j6, f9, i);
    }

    public final Shadow copyWithoutOffset$ui_graphics_release() {
        return new Shadow(this.radius, this.spread, DpOffset.INSTANCE.m6915getZeroRKDOV3M(), this.color, this.brush, this.alpha, this.blendMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) other;
        return Dp.m6849equalsimpl0(this.radius, shadow.radius) && Dp.m6849equalsimpl0(this.spread, shadow.spread) && DpOffset.m6904equalsimpl0(this.offset, shadow.offset) && this.alpha == shadow.alpha && BlendMode.m4049equalsimpl0(this.blendMode, shadow.blendMode) && Color.m4140equalsimpl0(this.color, shadow.color) && k.b(this.brush, shadow.brush);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* renamed from: getOffset-RKDOV3M, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* renamed from: getRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: getSpread-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpread() {
        return this.spread;
    }

    public int hashCode() {
        int iC = b.c((BlendMode.m4050hashCodeimpl(this.blendMode) + a.b(this.alpha, (DpOffset.m6909hashCodeimpl(this.offset) + b.b(this.spread, Dp.m6850hashCodeimpl(this.radius) * 31, 31)) * 31, 31)) * 31, 31, this.color);
        Brush brush = this.brush;
        return iC + (brush != null ? brush.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShadowParams(radius=");
        a.B(sb, ", spread=", this.radius);
        a.B(sb, ", offset=", this.spread);
        sb.append((Object) DpOffset.m6912toStringimpl(this.offset));
        sb.append(", alpha=");
        sb.append(this.alpha);
        sb.append(", blendMode=");
        sb.append((Object) BlendMode.m4051toStringimpl(this.blendMode));
        sb.append(", color=");
        b.z(this.color, ", brush=", sb);
        sb.append(this.brush);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ Shadow(float f, Brush brush, float f7, long j5, @FloatRange(from = 0.0d, to = 1.0d) float f9, int i, e eVar) {
        this(f, brush, f7, j5, f9, i);
    }

    private Shadow(float f, float f7, long j5, long j6, Brush brush, @FloatRange(from = 0.0d, to = 1.0d) float f9, int i) {
        this.radius = f;
        this.spread = f7;
        this.offset = j5;
        this.blendMode = i;
        if (brush instanceof SolidColor) {
            this.color = ((SolidColor) brush).getValue();
            this.brush = null;
        } else {
            this.color = j6;
            this.brush = brush;
        }
        this.alpha = AbstractC1451a.t(f9, 0.0f, 1.0f);
    }

    private Shadow(float f, Brush brush, float f7, long j5, float f9, int i) {
        this(f, f7, j5, Color.INSTANCE.m4165getBlack0d7_KjU(), brush, f9, i);
    }

    public /* synthetic */ Shadow(float f, long j5, float f7, long j6, float f9, int i, int i6, e eVar) {
        this(f, (i6 & 2) != 0 ? Color.INSTANCE.m4165getBlack0d7_KjU() : j5, (i6 & 4) != 0 ? Dp.m6844constructorimpl(0) : f7, (i6 & 8) != 0 ? DpOffset.INSTANCE.m6915getZeroRKDOV3M() : j6, (i6 & 16) != 0 ? 1.0f : f9, (i6 & 32) != 0 ? DrawScope.INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i, (e) null);
    }

    private Shadow(float f, long j5, float f7, long j6, float f9, int i) {
        this(f, f7, j6, j5 == 16 ? Color.INSTANCE.m4165getBlack0d7_KjU() : j5, (Brush) null, f9, i);
    }

    public /* synthetic */ Shadow(float f, Brush brush, float f7, long j5, float f9, int i, int i6, e eVar) {
        this(f, brush, (i6 & 4) != 0 ? Dp.m6844constructorimpl(0) : f7, (i6 & 8) != 0 ? DpOffset.INSTANCE.m6915getZeroRKDOV3M() : j5, (i6 & 16) != 0 ? 1.0f : f9, (i6 & 32) != 0 ? DrawScope.INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i, (e) null);
    }
}
