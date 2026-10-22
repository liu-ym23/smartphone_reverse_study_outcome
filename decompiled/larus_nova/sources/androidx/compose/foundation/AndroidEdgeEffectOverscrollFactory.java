package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollFactory;", "Landroidx/compose/foundation/OverscrollFactory;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidEdgeEffectOverscrollFactory implements OverscrollFactory {
    private final Context context;
    private final Density density;
    private final long glowColor;
    private final PaddingValues glowDrawPadding;

    public /* synthetic */ AndroidEdgeEffectOverscrollFactory(Context r100, Density r101, long r102, PaddingValues r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public OverscrollEffect createOverscrollEffect() {
        return new AndroidEdgeEffectOverscrollEffect(this.context, this.density, this.glowColor, this.glowDrawPadding, null);
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public int hashCode() {
        return (((((this.context.hashCode() * 31) + this.density.hashCode()) * 31) + Color.m4834hashCodeimpl(this.glowColor)) * 31) + this.glowDrawPadding.hashCode();
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(AndroidEdgeEffectOverscrollFactory.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        AndroidEdgeEffectOverscrollFactory r102 = (AndroidEdgeEffectOverscrollFactory) r100;
        if (Intrinsics.areEqual(this.context, r102.context) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.density, r102.density) == true) goto L19;
        return false;
    L19:
        if (Color.m4828equalsimpl0(this.glowColor, r102.glowColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.glowDrawPadding, r102.glowDrawPadding) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    private AndroidEdgeEffectOverscrollFactory(Context r100, Density r101, long r102, PaddingValues r103) {
        this.context = r100;
        this.density = r101;
        this.glowColor = r102;
        this.glowDrawPadding = r103;
    }

    public /* synthetic */ AndroidEdgeEffectOverscrollFactory(Context r100, Density r101, long r110, PaddingValues r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r110 = AndroidOverscroll_androidKt.access$getDefaultGlowColor$p();
    L5:
        long r102 = r110;
        if ((r112 & 8) == 0) goto L8;
        r111 = AndroidOverscroll_androidKt.access$getDefaultGlowPaddingValues$p();
    L8:
        this(r100, r101, r102, r111, null);
    }
}
