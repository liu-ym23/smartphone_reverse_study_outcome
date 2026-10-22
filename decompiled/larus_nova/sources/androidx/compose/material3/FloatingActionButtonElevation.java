package androidx.compose.material3;

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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "shadowElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tonalElevation", "tonalElevation-D9Ej5fM$material3", "()F", "animateElevation", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.defaultElevation) * 31) + Dp.m7550hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7550hashCodeimpl(this.focusedElevation)) * 31) + Dp.m7550hashCodeimpl(this.hoveredElevation);
    }

    /* JADX INFO: renamed from: tonalElevation-D9Ej5fM$material3, reason: not valid java name */
    public final float m2247tonalElevationD9Ej5fM$material3() {
        return this.defaultElevation;
    }

    public static final /* synthetic */ float access$getDefaultElevation$p(FloatingActionButtonElevation r100) {
        return r100.defaultElevation;
    }

    public static final /* synthetic */ float access$getFocusedElevation$p(FloatingActionButtonElevation r100) {
        return r100.focusedElevation;
    }

    public static final /* synthetic */ float access$getHoveredElevation$p(FloatingActionButtonElevation r100) {
        return r100.hoveredElevation;
    }

    public static final /* synthetic */ float access$getPressedElevation$p(FloatingActionButtonElevation r100) {
        return r100.pressedElevation;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if ((r100 instanceof FloatingActionButtonElevation) == false) goto L21;
        FloatingActionButtonElevation r101 = (FloatingActionButtonElevation) r100;
        if (Dp.m7549equalsimpl0(this.defaultElevation, r101.defaultElevation) == true) goto L14;
        return false;
    L14:
        if (Dp.m7549equalsimpl0(this.pressedElevation, r101.pressedElevation) == true) goto L17;
        return false;
    L17:
        if (Dp.m7549equalsimpl0(this.focusedElevation, r101.focusedElevation) == true) goto L20;
        return false;
    L20:
        return Dp.m7549equalsimpl0(this.hoveredElevation, r101.hoveredElevation);
    }

    private final State<Dp> animateElevation(InteractionSource r110, Composer r111, int r210) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1845106002, r210, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:628)");
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
        r115 = new FloatingActionButtonElevation$animateElevation$1$1(r113, this, null);
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
        r107 = new FloatingActionButtonElevation$animateElevation$2$1(r110, r113, null);
        r111.updateRememberedValue(r107);
    L43:
        EffectsKt.LaunchedEffect(r110, (Function2) r107, r111, r100);
        State<Dp> r108 = r113.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
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

    public final State<Dp> shadowElevation$material3(InteractionSource r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-424810125, r102, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:619)");
    L5:
        int r103 = r102 & 14;
        State<Dp> r104 = animateElevation(r100, r101, (r102 & 112) | r103);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r104;
    }

    private FloatingActionButtonElevation(float r100, float r101, float r102, float r103) {
        this.defaultElevation = r100;
        this.pressedElevation = r101;
        this.focusedElevation = r102;
        this.hoveredElevation = r103;
    }
}
