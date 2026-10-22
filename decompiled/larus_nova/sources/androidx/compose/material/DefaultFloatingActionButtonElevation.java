package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultFloatingActionButtonElevation(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.defaultElevation) * 31) + Dp.m7550hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7550hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m7550hashCodeimpl(this.focusedElevation);
    }

    public static final /* synthetic */ float access$getDefaultElevation$p(DefaultFloatingActionButtonElevation r100) {
        return r100.defaultElevation;
    }

    public static final /* synthetic */ float access$getFocusedElevation$p(DefaultFloatingActionButtonElevation r100) {
        return r100.focusedElevation;
    }

    public static final /* synthetic */ float access$getHoveredElevation$p(DefaultFloatingActionButtonElevation r100) {
        return r100.hoveredElevation;
    }

    public static final /* synthetic */ float access$getPressedElevation$p(DefaultFloatingActionButtonElevation r100) {
        return r100.pressedElevation;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultFloatingActionButtonElevation) == true) goto L8;
        return false;
    L8:
        DefaultFloatingActionButtonElevation r101 = (DefaultFloatingActionButtonElevation) r100;
        if (Dp.m7549equalsimpl0(this.defaultElevation, r101.defaultElevation) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.pressedElevation, r101.pressedElevation) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.hoveredElevation, r101.hoveredElevation) == true) goto L18;
        return false;
    L18:
        return Dp.m7549equalsimpl0(this.focusedElevation, r101.focusedElevation);
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public State<Dp> elevation(InteractionSource r110, Composer r111, int r210) {
        r111.startReplaceGroup(-478475335);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-478475335, r210, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:259)");
    L5:
        int r100 = r210 & 14;
        int r101 = r100 ^ 6;
        boolean r102 = false;
        if (r101 <= 4) goto L10;
        if (r111.changed(r110) == false) goto L10;
    L11:
        boolean r103 = true;
    L13:
        Object r112 = r111.rememberedValue();
        if (r103 == false) goto L16;
    L17:
        r112 = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
        r111.updateRememberedValue(r112);
    L18:
        FloatingActionButtonElevationAnimatable r113 = (FloatingActionButtonElevationAnimatable) r112;
        boolean r104 = r111.changedInstance(r113);
        if (((r210 & 112) ^ 48) <= 32) goto L23;
        if (r111.changed(this) == false) goto L23;
    L24:
        boolean r114 = true;
    L26:
        boolean r105 = r104 | r114;
        Object r115 = r111.rememberedValue();
        if (r105 == false) goto L29;
    L30:
        r115 = new DefaultFloatingActionButtonElevation$elevation$1$1(r113, this, null);
        r111.updateRememberedValue(r115);
    L31:
        EffectsKt.LaunchedEffect(this, (Function2) r115, r111, (r210 >> 3) & 14);
        if (r101 <= 4) goto L36;
        if (r111.changed(r110) == false) goto L36;
    L37:
        r102 = true;
    L38:
        boolean r106 = r111.changedInstance(r113) | r102;
        Object r107 = r111.rememberedValue();
        if (r106 == false) goto L41;
    L42:
        r107 = new DefaultFloatingActionButtonElevation$elevation$2$1(r110, r113, null);
        r111.updateRememberedValue(r107);
    L43:
        EffectsKt.LaunchedEffect(r110, (Function2) r107, r111, r100);
        State<Dp> r108 = r113.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
        r111.endReplaceGroup();
        return r108;
    L41:
        if (r107 != Composer.Companion.getEmpty()) goto L43;
    L36:
        if ((r210 & 6) != 4) goto L38;
    L29:
        if (r115 != Composer.Companion.getEmpty()) goto L31;
    L23:
        if ((r210 & 48) == 32) goto L24;
        r114 = false;
        goto L26
    L16:
        if (r112 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r210 & 6) == 4) goto L11;
        r103 = false;
        goto L13
    }

    private DefaultFloatingActionButtonElevation(float r100, float r101, float r102, float r103) {
        this.defaultElevation = r100;
        this.pressedElevation = r101;
        this.hoveredElevation = r102;
        this.focusedElevation = r103;
    }
}
