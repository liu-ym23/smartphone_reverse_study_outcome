package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0019\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0007¢\u0006\u0002\u0010\f\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u000bH\u0000\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a.\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u001a5\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u00162\b\b\u0002\u0010\u0014\u001a\u00020\u00162\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"union", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", SocialConstants.PARAM_EXCLUDE, "add", SocialConstants.PARAM_ONLY, "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "asPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "asInsets", "WindowInsets", "left", "", "top", "right", "bottom", "Landroidx/compose/ui/unit/Dp;", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "EmptyWindowInsets", "Landroidx/compose/foundation/layout/FixedIntInsets;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsKt {
    private static final FixedIntInsets EmptyWindowInsets = null;

    static {
        EmptyWindowInsets = new FixedIntInsets(0, 0, 0, 0);
    }

    public static final WindowInsets WindowInsets() {
        return EmptyWindowInsets;
    }

    public static final WindowInsets asInsets(PaddingValues r100) {
        return new PaddingValuesInsets(r100);
    }

    public static final WindowInsets add(WindowInsets r100, WindowInsets r101) {
        return new AddedInsets(r100, r101);
    }

    public static final PaddingValues asPaddingValues(WindowInsets r100, Density r101) {
        return new InsetsPaddingValues(r100, r101);
    }

    public static final WindowInsets exclude(WindowInsets r100, WindowInsets r101) {
        return new ExcludeInsets(r100, r101);
    }

    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m804onlybOOhFvg(WindowInsets r100, int r101) {
        return new LimitInsets(r100, r101, null);
    }

    public static final WindowInsets union(WindowInsets r100, WindowInsets r101) {
        return new UnionInsets(r100, r101);
    }

    public static final PaddingValues asPaddingValues(WindowInsets r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1485016250, r102, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:220)");
    L5:
        InsetsPaddingValues r103 = new InsetsPaddingValues(r100, (Density) r101.consume(CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r103;
    }

    public static final WindowInsets WindowInsets(int r100, int r101, int r102, int r103) {
        return new FixedIntInsets(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m802WindowInsetsa9UjIt4(float r100, float r101, float r102, float r110) {
        return new FixedDpInsets(r100, r101, r102, r110, null);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        return WindowInsets(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m803WindowInsetsa9UjIt4$default(float r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Dp.m7544constructorimpl(0);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Dp.m7544constructorimpl(0);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Dp.m7544constructorimpl(0);
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = Dp.m7544constructorimpl(0);
    L15:
        return m802WindowInsetsa9UjIt4(r100, r101, r102, r103);
    }
}
