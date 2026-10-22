package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005JE\u0010\u001a\u001a\u00020\f*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010!\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH$¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010#JQ\u0010&\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u0016H$¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010.R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "", "Landroidx/compose/ui/graphics/Outline;", "outline", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Outline;)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/ColorFilter;", "obtainTint-8_81llA", "(J)Landroidx/compose/ui/graphics/ColorFilter;", "obtainTint", "LC7/r;", "updateParamsFromOutline", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "colorFilter", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Brush;", "brush", "", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "drawShadow-erFMhIw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/ColorFilter;JJLandroidx/compose/ui/graphics/Brush;FI)V", "drawShadow", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "buildShadow", "invalidateShadow", "()V", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "onDrawShadow", "Landroidx/compose/ui/graphics/Outline;", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "Landroidx/compose/ui/graphics/Path;", "shadowTint", "Landroidx/compose/ui/graphics/ColorFilter;", "shadowTintColor", "J", "generatedSize", "Landroidx/compose/ui/unit/LayoutDirection;", "generatedLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "generatedDensity", "F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShadowRenderer {
    private final Outline outline;
    private Path path;
    private ColorFilter shadowTint;
    private long shadowTintColor = Color.INSTANCE.m4175getUnspecified0d7_KjU();
    private long cornerRadius = CornerRadius.INSTANCE.m3867getZerokKHJgLs();
    private long generatedSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
    private LayoutDirection generatedLayoutDirection = LayoutDirection.Ltr;
    private float generatedDensity = 1.0f;

    public ShadowRenderer(Outline outline) {
        this.outline = outline;
    }

    /* renamed from: obtainTint-8_81llA, reason: not valid java name */
    private final ColorFilter m4855obtainTint8_81llA(long color) {
        ColorFilter colorFilter = this.shadowTint;
        if (colorFilter != null && Color.m4140equalsimpl0(this.shadowTintColor, color)) {
            return colorFilter;
        }
        ColorFilter colorFilterM4180tintxETnrds$default = ColorFilter.Companion.m4180tintxETnrds$default(ColorFilter.INSTANCE, color, 0, 2, null);
        this.shadowTintColor = color;
        this.shadowTint = colorFilterM4180tintxETnrds$default;
        return colorFilterM4180tintxETnrds$default;
    }

    private final void updateParamsFromOutline(Outline outline) {
        if (outline instanceof Outline.Generic) {
            this.path = ((Outline.Generic) outline).getPath();
            this.cornerRadius = CornerRadius.INSTANCE.m3867getZerokKHJgLs();
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Rectangle)) {
                throw new NoWhenBranchMatchedException();
            }
            this.path = null;
            this.cornerRadius = CornerRadius.INSTANCE.m3867getZerokKHJgLs();
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            this.path = null;
            this.cornerRadius = rounded.getRoundRect().m3945getTopLeftCornerRadiuskKHJgLs();
        } else {
            this.path = rounded.getRoundRectPath();
            this.cornerRadius = CornerRadius.INSTANCE.m3867getZerokKHJgLs();
        }
    }

    /* renamed from: buildShadow-_SMYjrA */
    public abstract void mo4845buildShadow_SMYjrA(DrawScope drawScope, long j5, long j6, Path path);

    /* renamed from: drawShadow-erFMhIw, reason: not valid java name */
    public final void m4856drawShadowerFMhIw(DrawScope drawScope, ColorFilter colorFilter, long j5, long j6, Brush brush, float f, int i) {
        updateParamsFromOutline(this.outline);
        if (colorFilter == null) {
            colorFilter = (brush != null || j6 == 16) ? null : m4855obtainTint8_81llA(j6);
        }
        ColorFilter colorFilter2 = colorFilter;
        long j10 = this.generatedSize;
        if (j10 == InlineClassHelperKt.UnspecifiedPackedFloats || !Size.m3960equalsimpl0(j10, j5) || this.generatedLayoutDirection != drawScope.getLayoutDirection() || this.generatedDensity != drawScope.getDensity()) {
            mo4845buildShadow_SMYjrA(drawScope, j5, this.cornerRadius, this.path);
            this.generatedSize = j5;
            this.generatedLayoutDirection = drawScope.getLayoutDirection();
            this.generatedDensity = drawScope.getDensity();
        }
        mo4846onDrawShadowMLmccfk(drawScope, j5, this.cornerRadius, this.path, f, colorFilter2, brush, i);
    }

    public final Outline getOutline() {
        return this.outline;
    }

    public void invalidateShadow() {
        this.generatedSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        this.generatedLayoutDirection = LayoutDirection.Ltr;
        this.generatedDensity = 1.0f;
    }

    /* renamed from: onDrawShadow-MLmccfk */
    public abstract void mo4846onDrawShadowMLmccfk(DrawScope drawScope, long j5, long j6, Path path, float f, ColorFilter colorFilter, Brush brush, int i);
}
