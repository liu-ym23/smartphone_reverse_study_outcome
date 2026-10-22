package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a0\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration$annotations", "()V", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalUseFallbackRippleImplementation", "", "getLocalUseFallbackRippleImplementation$annotations", "getLocalUseFallbackRippleImplementation", "ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/ColorProducer;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "rippleOrFallbackImplementation", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleKt {
    private static final RippleNodeFactory DefaultBoundedRipple;
    private static final RippleNodeFactory DefaultUnboundedRipple;
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.material3.RippleKt$LocalUseFallbackRippleImplementation$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new S7.a() { // from class: androidx.compose.material3.RippleKt$LocalRippleConfiguration$1
        @Override // S7.a
        public final RippleConfiguration invoke() {
            return new RippleConfiguration(0L, null, 3, null);
        }
    }, 1, null);

    static {
        Dp.Companion companion = Dp.INSTANCE;
        float fM6864getUnspecifiedD9Ej5fM = companion.m6864getUnspecifiedD9Ej5fM();
        Color.Companion companion2 = Color.INSTANCE;
        DefaultBoundedRipple = new RippleNodeFactory(true, fM6864getUnspecifiedD9Ej5fM, companion2.m4175getUnspecified0d7_KjU(), (e) null);
        DefaultUnboundedRipple = new RippleNodeFactory(false, companion.m6864getUnspecifiedD9Ej5fM(), companion2.m4175getUnspecified0d7_KjU(), (e) null);
    }

    @ExperimentalMaterial3Api
    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getLocalRippleConfiguration$annotations() {
    }

    @ExperimentalMaterial3Api
    public static final ProvidableCompositionLocal<Boolean> getLocalUseFallbackRippleImplementation() {
        return LocalUseFallbackRippleImplementation;
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getLocalUseFallbackRippleImplementation$annotations() {
    }

    @Stable
    /* renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m2168rippleH2RKhps(boolean z10, float f, long j5) {
        return (Dp.m6849equalsimpl0(f, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) && Color.m4140equalsimpl0(j5, Color.INSTANCE.m4175getUnspecified0d7_KjU())) ? z10 ? DefaultBoundedRipple : DefaultUnboundedRipple : new RippleNodeFactory(z10, f, j5, (e) null);
    }

    /* renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m2169rippleH2RKhps$default(boolean z10, float f, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            j5 = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        return m2168rippleH2RKhps(z10, f, j5);
    }

    @Stable
    /* renamed from: ripple-wH6b6FI, reason: not valid java name */
    public static final IndicationNodeFactory m2170ripplewH6b6FI(ColorProducer colorProducer, boolean z10, float f) {
        return new RippleNodeFactory(z10, f, colorProducer, (e) null);
    }

    /* renamed from: ripple-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m2171ripplewH6b6FI$default(ColorProducer colorProducer, boolean z10, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m2170ripplewH6b6FI(colorProducer, z10, f);
    }

    @Composable
    /* renamed from: rippleOrFallbackImplementation-9IZ8Weo, reason: not valid java name */
    public static final Indication m2172rippleOrFallbackImplementation9IZ8Weo(boolean z10, float f, long j5, Composer composer, int i, int i6) {
        Composer composer2;
        Indication indicationM2168rippleH2RKhps;
        if ((i6 & 1) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i6 & 2) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        float f7 = f;
        if ((i6 & 4) != 0) {
            j5 = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        long j6 = j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1315814667, i, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        composer.startReplaceGroup(-1280632857);
        if (((Boolean) composer.consume(LocalUseFallbackRippleImplementation)).booleanValue()) {
            composer2 = composer;
            indicationM2168rippleH2RKhps = androidx.compose.material.ripple.RippleKt.m1488rememberRipple9IZ8Weo(z11, f7, j6, composer2, i & 1022, 0);
        } else {
            composer2 = composer;
            indicationM2168rippleH2RKhps = m2168rippleH2RKhps(z11, f7, j6);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return indicationM2168rippleH2RKhps;
    }
}
