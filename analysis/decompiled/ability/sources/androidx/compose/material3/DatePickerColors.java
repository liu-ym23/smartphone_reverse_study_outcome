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
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u008c\u0002\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J#\u0010&\u001a\u00020\u001b*\u0004\u0018\u00010\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\"H\u0000¢\u0006\u0004\b$\u0010%J5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0001¢\u0006\u0004\b-\u0010.J-\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0006\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020'2\u0006\u0010/\u001a\u00020'H\u0001¢\u0006\u0004\b0\u00101J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0006\u00103\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0001¢\u0006\u0004\b4\u00101J%\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0006\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020'2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010>\u001a\u0004\b?\u0010@R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010>\u001a\u0004\bA\u0010@R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010>\u001a\u0004\bB\u0010@R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010>\u001a\u0004\bC\u0010@R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010>\u001a\u0004\bD\u0010@R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010>\u001a\u0004\bE\u0010@R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010>\u001a\u0004\bF\u0010@R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\bG\u0010@R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010>\u001a\u0004\bH\u0010@R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010>\u001a\u0004\bI\u0010@R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\bJ\u0010@R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\bK\u0010@R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\bL\u0010@R\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010>\u001a\u0004\bM\u0010@R\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010>\u001a\u0004\bN\u0010@R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\bO\u0010@R\u001d\u0010\u0013\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010>\u001a\u0004\bP\u0010@R\u001d\u0010\u0014\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u0010>\u001a\u0004\bQ\u0010@R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010>\u001a\u0004\bR\u0010@R\u001d\u0010\u0016\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\bS\u0010@R\u001d\u0010\u0017\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010>\u001a\u0004\bT\u0010@R\u001d\u0010\u0018\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010>\u001a\u0004\bU\u0010@R\u001d\u0010\u0019\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010>\u001a\u0004\bV\u0010@R\u001d\u0010\u001a\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001a\u0010>\u001a\u0004\bW\u0010@R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010X\u001a\u0004\bY\u0010Z\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006["}, d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "Landroidx/compose/ui/graphics/Color;", "containerColor", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "Landroidx/compose/material3/TextFieldColors;", "dateTextFieldColors", AppAgent.CONSTRUCT, "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/e;)V", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "copy", "Lkotlin/Function0;", "block", "takeOrElse$material3_release", "(Landroidx/compose/material3/TextFieldColors;LS7/a;)Landroidx/compose/material3/TextFieldColors;", "takeOrElse", "", "isToday", "selected", "inRange", "enabled", "Landroidx/compose/runtime/State;", "dayContentColor$material3_release", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animate", "dayContainerColor$material3_release", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "dayContainerColor", "currentYear", "yearContentColor$material3_release", "yearContainerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "yearContainerColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getContainerColor-0d7_KjU", "()J", "getTitleContentColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getCurrentYearContentColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDayContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "Landroidx/compose/material3/TextFieldColors;", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, TextFieldColors textFieldColors, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, textFieldColors);
    }

    /* renamed from: copy-tNwlRmA, reason: not valid java name */
    public final DatePickerColors m1741copytNwlRmA(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContainerColor, long dayInSelectionRangeContentColor, long dividerColor, TextFieldColors dateTextFieldColors) {
        return new DatePickerColors(containerColor != 16 ? containerColor : this.containerColor, titleContentColor != 16 ? titleContentColor : this.titleContentColor, headlineContentColor != 16 ? headlineContentColor : this.headlineContentColor, weekdayContentColor != 16 ? weekdayContentColor : this.weekdayContentColor, subheadContentColor != 16 ? subheadContentColor : this.subheadContentColor, navigationContentColor != 16 ? navigationContentColor : this.navigationContentColor, yearContentColor != 16 ? yearContentColor : this.yearContentColor, disabledYearContentColor != 16 ? disabledYearContentColor : this.disabledYearContentColor, currentYearContentColor != 16 ? currentYearContentColor : this.currentYearContentColor, selectedYearContentColor != 16 ? selectedYearContentColor : this.selectedYearContentColor, disabledSelectedYearContentColor != 16 ? disabledSelectedYearContentColor : this.disabledSelectedYearContentColor, selectedYearContainerColor != 16 ? selectedYearContainerColor : this.selectedYearContainerColor, disabledSelectedYearContainerColor != 16 ? disabledSelectedYearContainerColor : this.disabledSelectedYearContainerColor, dayContentColor != 16 ? dayContentColor : this.dayContentColor, disabledDayContentColor != 16 ? disabledDayContentColor : this.disabledDayContentColor, selectedDayContentColor != 16 ? selectedDayContentColor : this.selectedDayContentColor, disabledSelectedDayContentColor != 16 ? disabledSelectedDayContentColor : this.disabledSelectedDayContentColor, selectedDayContainerColor != 16 ? selectedDayContainerColor : this.selectedDayContainerColor, disabledSelectedDayContainerColor != 16 ? disabledSelectedDayContainerColor : this.disabledSelectedDayContainerColor, todayContentColor != 16 ? todayContentColor : this.todayContentColor, todayDateBorderColor != 16 ? todayDateBorderColor : this.todayDateBorderColor, dayInSelectionRangeContainerColor != 16 ? dayInSelectionRangeContainerColor : this.dayInSelectionRangeContainerColor, dayInSelectionRangeContentColor != 16 ? dayInSelectionRangeContentColor : this.dayInSelectionRangeContentColor, dividerColor != 16 ? dividerColor : this.dividerColor, takeOrElse$material3_release(dateTextFieldColors, new S7.a() { // from class: androidx.compose.material3.DatePickerColors$copy$25
            {
                super(0);
            }

            @Override // S7.a
            public final TextFieldColors invoke() {
                return this.this$0.getDateTextFieldColors();
            }
        }), null);
    }

    @Composable
    public final State<Color> dayContainerColor$material3_release(boolean z10, boolean z11, boolean z12, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, i, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:929)");
        }
        long jM4174getTransparent0d7_KjU = z10 ? z11 ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor : Color.INSTANCE.m4174getTransparent0d7_KjU();
        if (z12) {
            composer.startReplaceGroup(-217548653);
            stateRememberUpdatedState = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(jM4174getTransparent0d7_KjU, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-217433457);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(jM4174getTransparent0d7_KjU), composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> dayContentColor$material3_release(boolean z10, boolean z11, boolean z12, boolean z13, Composer composer, int i) {
        State<Color> stateM113animateColorAsStateeuL9pac;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, i, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:897)");
        }
        long j5 = (z11 && z13) ? this.selectedDayContentColor : (!z11 || z13) ? (z12 && z13) ? this.dayInSelectionRangeContentColor : (!z12 || z13) ? z10 ? this.todayContentColor : z13 ? this.dayContentColor : this.disabledDayContentColor : this.disabledDayContentColor : this.disabledSelectedDayContentColor;
        if (z12) {
            composer.startReplaceGroup(-828488761);
            stateM113animateColorAsStateeuL9pac = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(j5), composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-828426947);
            stateM113animateColorAsStateeuL9pac = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(j5, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateM113animateColorAsStateeuL9pac;
    }

    public boolean equals(Object other) {
        if (!(other instanceof DatePickerColors)) {
            return false;
        }
        DatePickerColors datePickerColors = (DatePickerColors) other;
        return Color.m4140equalsimpl0(this.containerColor, datePickerColors.containerColor) && Color.m4140equalsimpl0(this.titleContentColor, datePickerColors.titleContentColor) && Color.m4140equalsimpl0(this.headlineContentColor, datePickerColors.headlineContentColor) && Color.m4140equalsimpl0(this.weekdayContentColor, datePickerColors.weekdayContentColor) && Color.m4140equalsimpl0(this.subheadContentColor, datePickerColors.subheadContentColor) && Color.m4140equalsimpl0(this.yearContentColor, datePickerColors.yearContentColor) && Color.m4140equalsimpl0(this.disabledYearContentColor, datePickerColors.disabledYearContentColor) && Color.m4140equalsimpl0(this.currentYearContentColor, datePickerColors.currentYearContentColor) && Color.m4140equalsimpl0(this.selectedYearContentColor, datePickerColors.selectedYearContentColor) && Color.m4140equalsimpl0(this.disabledSelectedYearContentColor, datePickerColors.disabledSelectedYearContentColor) && Color.m4140equalsimpl0(this.selectedYearContainerColor, datePickerColors.selectedYearContainerColor) && Color.m4140equalsimpl0(this.disabledSelectedYearContainerColor, datePickerColors.disabledSelectedYearContainerColor) && Color.m4140equalsimpl0(this.dayContentColor, datePickerColors.dayContentColor) && Color.m4140equalsimpl0(this.disabledDayContentColor, datePickerColors.disabledDayContentColor) && Color.m4140equalsimpl0(this.selectedDayContentColor, datePickerColors.selectedDayContentColor) && Color.m4140equalsimpl0(this.disabledSelectedDayContentColor, datePickerColors.disabledSelectedDayContentColor) && Color.m4140equalsimpl0(this.selectedDayContainerColor, datePickerColors.selectedDayContainerColor) && Color.m4140equalsimpl0(this.disabledSelectedDayContainerColor, datePickerColors.disabledSelectedDayContainerColor) && Color.m4140equalsimpl0(this.todayContentColor, datePickerColors.todayContentColor) && Color.m4140equalsimpl0(this.todayDateBorderColor, datePickerColors.todayDateBorderColor) && Color.m4140equalsimpl0(this.dayInSelectionRangeContainerColor, datePickerColors.dayInSelectionRangeContainerColor) && Color.m4140equalsimpl0(this.dayInSelectionRangeContentColor, datePickerColors.dayInSelectionRangeContentColor);
    }

    /* renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* renamed from: getCurrentYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCurrentYearContentColor() {
        return this.currentYearContentColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    /* renamed from: getDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayContentColor() {
        return this.dayContentColor;
    }

    /* renamed from: getDayInSelectionRangeContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayInSelectionRangeContainerColor() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* renamed from: getDayInSelectionRangeContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayInSelectionRangeContentColor() {
        return this.dayInSelectionRangeContentColor;
    }

    /* renamed from: getDisabledDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledDayContentColor() {
        return this.disabledDayContentColor;
    }

    /* renamed from: getDisabledSelectedDayContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedDayContainerColor() {
        return this.disabledSelectedDayContainerColor;
    }

    /* renamed from: getDisabledSelectedDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedDayContentColor() {
        return this.disabledSelectedDayContentColor;
    }

    /* renamed from: getDisabledSelectedYearContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedYearContainerColor() {
        return this.disabledSelectedYearContainerColor;
    }

    /* renamed from: getDisabledSelectedYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedYearContentColor() {
        return this.disabledSelectedYearContentColor;
    }

    /* renamed from: getDisabledYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledYearContentColor() {
        return this.disabledYearContentColor;
    }

    /* renamed from: getDividerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDividerColor() {
        return this.dividerColor;
    }

    /* renamed from: getHeadlineContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getHeadlineContentColor() {
        return this.headlineContentColor;
    }

    /* renamed from: getNavigationContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getNavigationContentColor() {
        return this.navigationContentColor;
    }

    /* renamed from: getSelectedDayContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedDayContainerColor() {
        return this.selectedDayContainerColor;
    }

    /* renamed from: getSelectedDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedDayContentColor() {
        return this.selectedDayContentColor;
    }

    /* renamed from: getSelectedYearContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedYearContainerColor() {
        return this.selectedYearContainerColor;
    }

    /* renamed from: getSelectedYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedYearContentColor() {
        return this.selectedYearContentColor;
    }

    /* renamed from: getSubheadContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSubheadContentColor() {
        return this.subheadContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleContentColor() {
        return this.titleContentColor;
    }

    /* renamed from: getTodayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTodayContentColor() {
        return this.todayContentColor;
    }

    /* renamed from: getTodayDateBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTodayDateBorderColor() {
        return this.todayDateBorderColor;
    }

    /* renamed from: getWeekdayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getWeekdayContentColor() {
        return this.weekdayContentColor;
    }

    /* renamed from: getYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getYearContentColor() {
        return this.yearContentColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.dayInSelectionRangeContentColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.containerColor) * 31, 31, this.titleContentColor), 31, this.headlineContentColor), 31, this.weekdayContentColor), 31, this.subheadContentColor), 31, this.yearContentColor), 31, this.disabledYearContentColor), 31, this.currentYearContentColor), 31, this.selectedYearContentColor), 31, this.disabledSelectedYearContentColor), 31, this.selectedYearContainerColor), 31, this.disabledSelectedYearContainerColor), 31, this.dayContentColor), 31, this.disabledDayContentColor), 31, this.selectedDayContentColor), 31, this.disabledSelectedDayContentColor), 31, this.selectedDayContainerColor), 31, this.disabledSelectedDayContainerColor), 31, this.todayContentColor), 31, this.todayDateBorderColor), 31, this.dayInSelectionRangeContainerColor);
    }

    public final TextFieldColors takeOrElse$material3_release(TextFieldColors textFieldColors, S7.a aVar) {
        return textFieldColors == null ? (TextFieldColors) aVar.invoke() : textFieldColors;
    }

    @Composable
    public final State<Color> yearContainerColor$material3_release(boolean z10, boolean z11, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1306331107, i, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:978)");
        }
        State<Color> stateM113animateColorAsStateeuL9pac = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(z10 ? z11 ? this.selectedYearContainerColor : this.disabledSelectedYearContainerColor : Color.INSTANCE.m4174getTransparent0d7_KjU(), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateM113animateColorAsStateeuL9pac;
    }

    @Composable
    public final State<Color> yearContentColor$material3_release(boolean z10, boolean z11, boolean z12, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(874111097, i, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:955)");
        }
        State<Color> stateM113animateColorAsStateeuL9pac = SingleValueAnimationKt.m113animateColorAsStateeuL9pac((z11 && z12) ? this.selectedYearContentColor : (!z11 || z12) ? z10 ? this.currentYearContentColor : z12 ? this.yearContentColor : this.disabledYearContentColor : this.disabledSelectedYearContentColor, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateM113animateColorAsStateeuL9pac;
    }

    private DatePickerColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, TextFieldColors textFieldColors) {
        this.containerColor = j5;
        this.titleContentColor = j6;
        this.headlineContentColor = j10;
        this.weekdayContentColor = j11;
        this.subheadContentColor = j12;
        this.navigationContentColor = j13;
        this.yearContentColor = j14;
        this.disabledYearContentColor = j15;
        this.currentYearContentColor = j16;
        this.selectedYearContentColor = j17;
        this.disabledSelectedYearContentColor = j18;
        this.selectedYearContainerColor = j19;
        this.disabledSelectedYearContainerColor = j20;
        this.dayContentColor = j21;
        this.disabledDayContentColor = j22;
        this.selectedDayContentColor = j23;
        this.disabledSelectedDayContentColor = j24;
        this.selectedDayContainerColor = j25;
        this.disabledSelectedDayContainerColor = j26;
        this.todayContentColor = j27;
        this.todayDateBorderColor = j28;
        this.dayInSelectionRangeContainerColor = j29;
        this.dayInSelectionRangeContentColor = j30;
        this.dividerColor = j31;
        this.dateTextFieldColors = textFieldColors;
    }
}
