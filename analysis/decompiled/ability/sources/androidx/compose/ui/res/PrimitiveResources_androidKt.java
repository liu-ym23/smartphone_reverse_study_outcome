package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.annotation.ArrayRes;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"integerResource", "", "id", "(ILandroidx/compose/runtime/Composer;I)I", "integerArrayResource", "", "(ILandroidx/compose/runtime/Composer;I)[I", "booleanResource", "", "(ILandroidx/compose/runtime/Composer;I)Z", "dimensionResource", "Landroidx/compose/ui/unit/Dp;", "(ILandroidx/compose/runtime/Composer;I)F", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrimitiveResources_androidKt {
    @Composable
    @ReadOnlyComposable
    public static final boolean booleanResource(@BoolRes int i, Composer composer, int i6) throws Resources.NotFoundException {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-432394447, i6, -1, "androidx.compose.ui.res.booleanResource (PrimitiveResources.android.kt:60)");
        }
        boolean z10 = ((Resources) composer.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getBoolean(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return z10;
    }

    @Composable
    @ReadOnlyComposable
    public static final float dimensionResource(@DimenRes int i, Composer composer, int i6) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(804324951, i6, -1, "androidx.compose.ui.res.dimensionResource (PrimitiveResources.android.kt:72)");
        }
        float fM6844constructorimpl = Dp.m6844constructorimpl(((Resources) composer.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getDimension(i) / ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fM6844constructorimpl;
    }

    @Composable
    @ReadOnlyComposable
    public static final int[] integerArrayResource(@ArrayRes int i, Composer composer, int i6) throws Resources.NotFoundException {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-93991766, i6, -1, "androidx.compose.ui.res.integerArrayResource (PrimitiveResources.android.kt:48)");
        }
        int[] intArray = ((Resources) composer.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getIntArray(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return intArray;
    }

    @Composable
    @ReadOnlyComposable
    public static final int integerResource(@IntegerRes int i, Composer composer, int i6) throws Resources.NotFoundException {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(916701108, i6, -1, "androidx.compose.ui.res.integerResource (PrimitiveResources.android.kt:36)");
        }
        int integer = ((Resources) composer.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getInteger(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return integer;
    }
}
