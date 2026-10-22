package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Landroidx/compose/material3/internal/ElevationDefaults;", "", "<init>", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ElevationDefaults {
    public static final ElevationDefaults INSTANCE = null;

    static {
        INSTANCE = new ElevationDefaults();
    }

    private ElevationDefaults() {
    }

    public final AnimationSpec<Dp> incomingAnimationSpecForInteraction(Interaction r100) {
        if ((r100 instanceof PressInteraction.Press) == false) goto L6;
        return ElevationKt.access$getDefaultIncomingSpec$p();
    L6:
        if ((r100 instanceof DragInteraction.Start) == false) goto L9;
        return ElevationKt.access$getDefaultIncomingSpec$p();
    L9:
        if ((r100 instanceof HoverInteraction.Enter) == false) goto L12;
        return ElevationKt.access$getDefaultIncomingSpec$p();
    L12:
        if ((r100 instanceof FocusInteraction.Focus) == true) goto L19;
        return null;
    L19:
        return ElevationKt.access$getDefaultIncomingSpec$p();
    }

    public final AnimationSpec<Dp> outgoingAnimationSpecForInteraction(Interaction r100) {
        if ((r100 instanceof PressInteraction.Press) == false) goto L6;
        return ElevationKt.access$getDefaultOutgoingSpec$p();
    L6:
        if ((r100 instanceof DragInteraction.Start) == false) goto L9;
        return ElevationKt.access$getDefaultOutgoingSpec$p();
    L9:
        if ((r100 instanceof HoverInteraction.Enter) == false) goto L12;
        return ElevationKt.access$getHoveredOutgoingSpec$p();
    L12:
        if ((r100 instanceof FocusInteraction.Focus) == true) goto L19;
        return null;
    L19:
        return ElevationKt.access$getDefaultOutgoingSpec$p();
    }
}
