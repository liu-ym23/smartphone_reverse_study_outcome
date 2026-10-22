package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "Landroidx/compose/ui/graphics/Color;", "selectedColor", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", AppAgent.CONSTRUCT, "(JJJJLkotlin/jvm/internal/e;)V", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "copy", "", "enabled", "selected", "Landroidx/compose/runtime/State;", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "radioColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getSelectedColor-0d7_KjU", "()J", "getUnselectedColor-0d7_KjU", "getDisabledSelectedColor-0d7_KjU", "getDisabledUnselectedColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonColors {
    public static final int $stable = 0;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ RadioButtonColors(long j5, long j6, long j10, long j11, e eVar) {
        this(j5, j6, j10, j11);
    }

    /* renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ RadioButtonColors m2153copyjRlVdoo$default(RadioButtonColors radioButtonColors, long j5, long j6, long j10, long j11, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = radioButtonColors.selectedColor;
        }
        long j12 = j5;
        if ((i & 2) != 0) {
            j6 = radioButtonColors.unselectedColor;
        }
        long j13 = j6;
        if ((i & 4) != 0) {
            j10 = radioButtonColors.disabledSelectedColor;
        }
        return radioButtonColors.m2154copyjRlVdoo(j12, j13, j10, (i & 8) != 0 ? radioButtonColors.disabledUnselectedColor : j11);
    }

    /* renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RadioButtonColors m2154copyjRlVdoo(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        return new RadioButtonColors(selectedColor != 16 ? selectedColor : this.selectedColor, unselectedColor != 16 ? unselectedColor : this.unselectedColor, disabledSelectedColor != 16 ? disabledSelectedColor : this.disabledSelectedColor, disabledUnselectedColor != 16 ? disabledUnselectedColor : this.disabledUnselectedColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) other;
        return Color.m4140equalsimpl0(this.selectedColor, radioButtonColors.selectedColor) && Color.m4140equalsimpl0(this.unselectedColor, radioButtonColors.unselectedColor) && Color.m4140equalsimpl0(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && Color.m4140equalsimpl0(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor);
    }

    /* renamed from: getDisabledSelectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedColor() {
        return this.disabledSelectedColor;
    }

    /* renamed from: getDisabledUnselectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledUnselectedColor() {
        return this.disabledUnselectedColor;
    }

    /* renamed from: getSelectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedColor() {
        return this.selectedColor;
    }

    /* renamed from: getUnselectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedColor() {
        return this.unselectedColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.disabledUnselectedColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.selectedColor) * 31, 31, this.unselectedColor), 31, this.disabledSelectedColor);
    }

    @Composable
    public final State<Color> radioColor$material3_release(boolean z10, boolean z11, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840145292, i, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:228)");
        }
        long j5 = (z10 && z11) ? this.selectedColor : (!z10 || z11) ? (z10 || !z11) ? this.disabledUnselectedColor : this.disabledSelectedColor : this.unselectedColor;
        if (z10) {
            composer.startReplaceGroup(350067971);
            stateRememberUpdatedState = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(j5, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(350170674);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(j5), composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    private RadioButtonColors(long j5, long j6, long j10, long j11) {
        this.selectedColor = j5;
        this.unselectedColor = j6;
        this.disabledSelectedColor = j10;
        this.disabledUnselectedColor = j11;
    }
}
