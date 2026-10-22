package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001d\u0010\u001a\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R&\u0010\u001c\u001a\u00020\u00068GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\u0013R&\u0010\u001f\u001a\u00020\u00068GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u0012\u0004\b!\u0010\u0003\u001a\u0004\b \u0010\u0013R&\u0010\"\u001a\u00020\u00068GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u0012\u0004\b$\u0010\u0003\u001a\u0004\b#\u0010\u0013R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R \u0010.\u001a\u00020\b8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b-\u0010\u0003\u001a\u0004\b+\u0010,R\u0017\u00100\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b/\u0010,R\u0017\u00102\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010,R\u0017\u00104\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b3\u0010,R\u0017\u00106\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u0010,R\u0017\u00108\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b7\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/material3/ProgressIndicatorDefaults;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawScope", "Landroidx/compose/ui/unit/Dp;", "stopSize", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "LC7/r;", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "drawStopIndicator", "CircularStrokeWidth", "F", "getCircularStrokeWidth-D9Ej5fM", "()F", "LinearStrokeCap", "I", "getLinearStrokeCap-KaPHkGw", "()I", "CircularDeterminateStrokeCap", "getCircularDeterminateStrokeCap-KaPHkGw", "CircularIndeterminateStrokeCap", "getCircularIndeterminateStrokeCap-KaPHkGw", "LinearTrackStopIndicatorSize", "getLinearTrackStopIndicatorSize-D9Ej5fM", "getLinearTrackStopIndicatorSize-D9Ej5fM$annotations", "LinearIndicatorTrackGapSize", "getLinearIndicatorTrackGapSize-D9Ej5fM", "getLinearIndicatorTrackGapSize-D9Ej5fM$annotations", "CircularIndicatorTrackGapSize", "getCircularIndicatorTrackGapSize-D9Ej5fM", "getCircularIndicatorTrackGapSize-D9Ej5fM$annotations", "Landroidx/compose/animation/core/SpringSpec;", "", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "getCircularTrackColor", "(Landroidx/compose/runtime/Composer;I)J", "getCircularTrackColor$annotations", "circularTrackColor", "getLinearColor", "linearColor", "getCircularColor", "circularColor", "getLinearTrackColor", "linearTrackColor", "getCircularDeterminateTrackColor", "circularDeterminateTrackColor", "getCircularIndeterminateTrackColor", "circularIndeterminateTrackColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorDefaults {
    public static final int $stable = 0;
    private static final int CircularDeterminateStrokeCap;
    private static final int CircularIndeterminateStrokeCap;
    private static final float CircularIndicatorTrackGapSize;
    private static final float CircularStrokeWidth;
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();
    private static final float LinearIndicatorTrackGapSize;
    private static final int LinearStrokeCap;
    private static final float LinearTrackStopIndicatorSize;
    private static final SpringSpec<Float> ProgressAnimationSpec;

    static {
        ProgressIndicatorTokens progressIndicatorTokens = ProgressIndicatorTokens.INSTANCE;
        CircularStrokeWidth = progressIndicatorTokens.m3245getTrackThicknessD9Ej5fM();
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        LinearStrokeCap = companion.m4509getRoundKaPHkGw();
        CircularDeterminateStrokeCap = companion.m4509getRoundKaPHkGw();
        CircularIndeterminateStrokeCap = companion.m4509getRoundKaPHkGw();
        LinearTrackStopIndicatorSize = progressIndicatorTokens.m3244getStopSizeD9Ej5fM();
        LinearIndicatorTrackGapSize = progressIndicatorTokens.m3241getActiveTrackSpaceD9Ej5fM();
        CircularIndicatorTrackGapSize = progressIndicatorTokens.m3241getActiveTrackSpaceD9Ej5fM();
        ProgressAnimationSpec = new SpringSpec<>(1.0f, 50.0f, Float.valueOf(0.001f));
    }

    private ProgressIndicatorDefaults() {
    }

    @ExperimentalMaterial3Api
    /* renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2118getCircularIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    @C7.c
    public static /* synthetic */ void getCircularTrackColor$annotations() {
    }

    @ExperimentalMaterial3Api
    /* renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2119getLinearIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    @ExperimentalMaterial3Api
    /* renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2120getLinearTrackStopIndicatorSizeD9Ej5fM$annotations() {
    }

    /* renamed from: drawStopIndicator-EgI2THU, reason: not valid java name */
    public final void m2121drawStopIndicatorEgI2THU(DrawScope drawScope, float stopSize, long color, int strokeCap) {
        float fMin = Math.min(drawScope.mo381toPx0680j_4(stopSize), Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc()));
        float fM3961getHeightimpl = (Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc()) - fMin) / 2;
        if (!StrokeCap.m4504equalsimpl0(strokeCap, StrokeCap.INSTANCE.m4509getRoundKaPHkGw())) {
            DrawScope.m4701drawRectnJ9OG0$default(drawScope, color, OffsetKt.Offset((Size.m3964getWidthimpl(drawScope.mo4707getSizeNHjbRc()) - fMin) - fM3961getHeightimpl, (Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc()) - fMin) / 2.0f), SizeKt.Size(fMin, fMin), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        } else {
            float f = fMin / 2.0f;
            DrawScope.m4688drawCircleVaOC9Bg$default(drawScope, color, f, OffsetKt.Offset((Size.m3964getWidthimpl(drawScope.mo4707getSizeNHjbRc()) - f) - fM3961getHeightimpl, Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc()) / 2.0f), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        }
    }

    @Composable
    public final long getCircularColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1803349725, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:847)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: getCircularDeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2122getCircularDeterminateStrokeCapKaPHkGw() {
        return CircularDeterminateStrokeCap;
    }

    @Composable
    public final long getCircularDeterminateTrackColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2143778381, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:864)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: getCircularIndeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2123getCircularIndeterminateStrokeCapKaPHkGw() {
        return CircularIndeterminateStrokeCap;
    }

    @Composable
    public final long getCircularIndeterminateTrackColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1947901123, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:868)");
        }
        long jM4174getTransparent0d7_KjU = Color.INSTANCE.m4174getTransparent0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM4174getTransparent0d7_KjU;
    }

    @ExperimentalMaterial3Api
    /* renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m2124getCircularIndicatorTrackGapSizeD9Ej5fM() {
        return CircularIndicatorTrackGapSize;
    }

    /* renamed from: getCircularStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m2125getCircularStrokeWidthD9Ej5fM() {
        return CircularStrokeWidth;
    }

    @Composable
    public final long getCircularTrackColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-404222247, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:860)");
        }
        long jM4174getTransparent0d7_KjU = Color.INSTANCE.m4174getTransparent0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM4174getTransparent0d7_KjU;
    }

    @Composable
    public final long getLinearColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-914312983, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:843)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    @ExperimentalMaterial3Api
    /* renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m2126getLinearIndicatorTrackGapSizeD9Ej5fM() {
        return LinearIndicatorTrackGapSize;
    }

    /* renamed from: getLinearStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2127getLinearStrokeCapKaPHkGw() {
        return LinearStrokeCap;
    }

    @Composable
    public final long getLinearTrackColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1677541593, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:851)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    @ExperimentalMaterial3Api
    /* renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m2128getLinearTrackStopIndicatorSizeD9Ej5fM() {
        return LinearTrackStopIndicatorSize;
    }

    public final SpringSpec<Float> getProgressAnimationSpec() {
        return ProgressAnimationSpec;
    }
}
