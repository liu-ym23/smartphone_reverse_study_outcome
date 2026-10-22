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
import androidx.compose.ui.state.ToggleableState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0088\u0001\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u001a\u0010\"\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b*\u0010)R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b+\u0010)R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b,\u0010)R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b-\u0010)R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b.\u0010)R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b/\u0010)R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b0\u0010)R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b1\u0010)R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b2\u0010)R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b3\u0010)R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b4\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "Landroidx/compose/ui/graphics/Color;", "checkedCheckmarkColor", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", AppAgent.CONSTRUCT, "(JJJJJJJJJJJJLkotlin/jvm/internal/e;)V", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "copy", "Landroidx/compose/ui/state/ToggleableState;", "state", "Landroidx/compose/runtime/State;", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "checkmarkColor", "", "enabled", "boxColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "borderColor$material3_release", "borderColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getCheckedCheckmarkColor-0d7_KjU", "()J", "getUncheckedCheckmarkColor-0d7_KjU", "getCheckedBoxColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CheckboxColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    /* renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ CheckboxColors m1578copy2qZNXz8$default(CheckboxColors checkboxColors, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, int i, Object obj) {
        long j20;
        long j21;
        long j22 = (i & 1) != 0 ? checkboxColors.checkedCheckmarkColor : j5;
        long j23 = (i & 2) != 0 ? checkboxColors.uncheckedCheckmarkColor : j6;
        long j24 = (i & 4) != 0 ? checkboxColors.checkedBoxColor : j10;
        long j25 = (i & 8) != 0 ? checkboxColors.uncheckedBoxColor : j11;
        long j26 = (i & 16) != 0 ? checkboxColors.disabledCheckedBoxColor : j12;
        long j27 = (i & 32) != 0 ? checkboxColors.disabledUncheckedBoxColor : j13;
        long j28 = (i & 64) != 0 ? checkboxColors.disabledIndeterminateBoxColor : j14;
        long j29 = j22;
        long j30 = (i & 128) != 0 ? checkboxColors.checkedBorderColor : j15;
        long j31 = (i & 256) != 0 ? checkboxColors.uncheckedBorderColor : j16;
        long j32 = (i & 512) != 0 ? checkboxColors.disabledBorderColor : j17;
        long j33 = (i & 1024) != 0 ? checkboxColors.disabledUncheckedBorderColor : j18;
        if ((i & 2048) != 0) {
            j21 = j33;
            j20 = checkboxColors.disabledIndeterminateBorderColor;
        } else {
            j20 = j19;
            j21 = j33;
        }
        return checkboxColors.m1579copy2qZNXz8(j29, j23, j24, j25, j26, j27, j28, j30, j31, j32, j21, j20);
    }

    @Composable
    public final State<Color> borderColor$material3_release(boolean z10, ToggleableState toggleableState, Composer composer, int i) {
        long j5;
        State<Color> stateRememberUpdatedState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:534)");
        }
        if (z10) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i6 == 1 || i6 == 2) {
                j5 = this.checkedBorderColor;
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j5 = this.uncheckedBorderColor;
            }
        } else {
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i10 == 1) {
                j5 = this.disabledBorderColor;
            } else if (i10 == 2) {
                j5 = this.disabledIndeterminateBorderColor;
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j5 = this.disabledUncheckedBorderColor;
            }
        }
        long j6 = j5;
        if (z10) {
            composer.startReplaceGroup(-1725816497);
            stateRememberUpdatedState = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(j6, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1725635953);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(j6), composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> boxColor$material3_release(boolean z10, ToggleableState toggleableState, Composer composer, int i) {
        long j5;
        State<Color> stateRememberUpdatedState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:501)");
        }
        if (z10) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i6 == 1 || i6 == 2) {
                j5 = this.checkedBoxColor;
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j5 = this.uncheckedBoxColor;
            }
        } else {
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i10 == 1) {
                j5 = this.disabledCheckedBoxColor;
            } else if (i10 == 2) {
                j5 = this.disabledIndeterminateBoxColor;
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j5 = this.disabledUncheckedBoxColor;
            }
        }
        long j6 = j5;
        if (z10) {
            composer.startReplaceGroup(-392211906);
            stateRememberUpdatedState = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(j6, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-392031362);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(j6), composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> checkmarkColor$material3_release(ToggleableState toggleableState, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:481)");
        }
        ToggleableState toggleableState2 = ToggleableState.Off;
        State<Color> stateM113animateColorAsStateeuL9pac = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(toggleableState == toggleableState2 ? this.uncheckedCheckmarkColor : this.checkedCheckmarkColor, AnimationSpecKt.tween$default(toggleableState == toggleableState2 ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateM113animateColorAsStateeuL9pac;
    }

    /* renamed from: copy-2qZNXz8, reason: not valid java name */
    public final CheckboxColors m1579copy2qZNXz8(long checkedCheckmarkColor, long uncheckedCheckmarkColor, long checkedBoxColor, long uncheckedBoxColor, long disabledCheckedBoxColor, long disabledUncheckedBoxColor, long disabledIndeterminateBoxColor, long checkedBorderColor, long uncheckedBorderColor, long disabledBorderColor, long disabledUncheckedBorderColor, long disabledIndeterminateBorderColor) {
        return new CheckboxColors(checkedCheckmarkColor != 16 ? checkedCheckmarkColor : this.checkedCheckmarkColor, uncheckedCheckmarkColor != 16 ? uncheckedCheckmarkColor : this.uncheckedCheckmarkColor, checkedBoxColor != 16 ? checkedBoxColor : this.checkedBoxColor, uncheckedBoxColor != 16 ? uncheckedBoxColor : this.uncheckedBoxColor, disabledCheckedBoxColor != 16 ? disabledCheckedBoxColor : this.disabledCheckedBoxColor, disabledUncheckedBoxColor != 16 ? disabledUncheckedBoxColor : this.disabledUncheckedBoxColor, disabledIndeterminateBoxColor != 16 ? disabledIndeterminateBoxColor : this.disabledIndeterminateBoxColor, checkedBorderColor != 16 ? checkedBorderColor : this.checkedBorderColor, uncheckedBorderColor != 16 ? uncheckedBorderColor : this.uncheckedBorderColor, disabledBorderColor != 16 ? disabledBorderColor : this.disabledBorderColor, disabledUncheckedBorderColor != 16 ? disabledUncheckedBorderColor : this.disabledUncheckedBorderColor, disabledIndeterminateBorderColor != 16 ? disabledIndeterminateBorderColor : this.disabledIndeterminateBorderColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) other;
        return Color.m4140equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m4140equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m4140equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m4140equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m4140equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m4140equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m4140equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m4140equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m4140equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m4140equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m4140equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && Color.m4140equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedBorderColor() {
        return this.checkedBorderColor;
    }

    /* renamed from: getCheckedBoxColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedBoxColor() {
        return this.checkedBoxColor;
    }

    /* renamed from: getCheckedCheckmarkColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedCheckmarkColor() {
        return this.checkedCheckmarkColor;
    }

    /* renamed from: getDisabledBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledBorderColor() {
        return this.disabledBorderColor;
    }

    /* renamed from: getDisabledCheckedBoxColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledCheckedBoxColor() {
        return this.disabledCheckedBoxColor;
    }

    /* renamed from: getDisabledIndeterminateBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledIndeterminateBorderColor() {
        return this.disabledIndeterminateBorderColor;
    }

    /* renamed from: getDisabledIndeterminateBoxColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledIndeterminateBoxColor() {
        return this.disabledIndeterminateBoxColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledUncheckedBorderColor() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledUncheckedBoxColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledUncheckedBoxColor() {
        return this.disabledUncheckedBoxColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUncheckedBorderColor() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getUncheckedBoxColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUncheckedBoxColor() {
        return this.uncheckedBoxColor;
    }

    /* renamed from: getUncheckedCheckmarkColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUncheckedCheckmarkColor() {
        return this.uncheckedCheckmarkColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.disabledIndeterminateBorderColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.checkedCheckmarkColor) * 31, 31, this.uncheckedCheckmarkColor), 31, this.checkedBoxColor), 31, this.uncheckedBoxColor), 31, this.disabledCheckedBoxColor), 31, this.disabledUncheckedBoxColor), 31, this.disabledIndeterminateBoxColor), 31, this.checkedBorderColor), 31, this.uncheckedBorderColor), 31, this.disabledBorderColor), 31, this.disabledUncheckedBorderColor);
    }

    private CheckboxColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.checkedCheckmarkColor = j5;
        this.uncheckedCheckmarkColor = j6;
        this.checkedBoxColor = j10;
        this.uncheckedBoxColor = j11;
        this.disabledCheckedBoxColor = j12;
        this.disabledUncheckedBoxColor = j13;
        this.disabledIndeterminateBoxColor = j14;
        this.checkedBorderColor = j15;
        this.uncheckedBorderColor = j16;
        this.disabledBorderColor = j17;
        this.disabledUncheckedBorderColor = j18;
        this.disabledIndeterminateBorderColor = j19;
    }
}
