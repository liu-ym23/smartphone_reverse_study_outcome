package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import S7.p;
import Y7.f;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001am\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aT\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a`\u0010#\u001a\u00020\u00002\n\u0010 \u001a\u00060\u001ej\u0002`\u001f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0090\u0001\u00100\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00172\u001c\u0010)\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070(2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070*2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0085\u0001\u00101\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u00112\u001c\u0010)\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070(2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070*2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b1\u00102\u001a\u0085\u0001\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u0002032\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00112\u001c\u0010)\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070(2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070*2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b5\u00106\u001aI\u0010:\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010\u00112\u001c\u0010)\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070(H\u0002¢\u0006\u0004\b:\u0010;\u001a&\u0010C\u001a\u00020\u0007*\u00020<2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a5\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I2\u0006\u0010\u0001\u001a\u0002032\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020FH\u0002¢\u0006\u0004\bK\u0010L\"\u001a\u0010N\u001a\u00020M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0014\u0010R\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010O\"\u0014\u0010S\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010O\"\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"Landroidx/compose/material3/DateRangePickerState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/DatePickerFormatter;", "dateFormatter", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "title", "headline", "", "showModeToggle", "Landroidx/compose/material3/DatePickerColors;", "colors", "DateRangePicker", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;LS7/n;LS7/n;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "LY7/f;", "yearRange", "Landroidx/compose/material3/DisplayMode;", "initialDisplayMode", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "rememberDateRangePickerState", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "selectedStartDateMillis", "selectedEndDateMillis", "displayedMonthMillis", "displayMode", "Lkotlin/Function2;", "onDatesSelectionChange", "Lkotlin/Function1;", "onDisplayedMonthChange", "Landroidx/compose/material3/internal/CalendarModel;", "calendarModel", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILS7/n;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "SwitchableDateEntryContent", "DateRangePickerContent", "(Ljava/lang/Long;Ljava/lang/Long;JLS7/n;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "VerticalMonthsList", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;LS7/n;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "updateDateSelection", "(JLjava/lang/Long;Ljava/lang/Long;LS7/n;)V", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/material3/SelectedRangeInfo;", "selectedRangeInfo", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "drawRangeBackground", "Lm9/z;", "coroutineScope", "", "scrollUpLabel", "scrollDownLabel", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customScrollActions", "(Landroidx/compose/foundation/lazy/LazyListState;Lm9/z;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Landroidx/compose/foundation/layout/PaddingValues;", "CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerTitlePadding", "DateRangePickerHeadlinePadding", "Landroidx/compose/ui/unit/Dp;", "HeaderHeightOffset", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangePickerKt {
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(24), Dp.m6844constructorimpl(20), 0.0f, Dp.m6844constructorimpl(8), 4, null);
    private static final float HeaderHeightOffset = Dp.m6844constructorimpl(60);

    static {
        float f = 64;
        float f7 = 12;
        DateRangePickerTitlePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(f), 0.0f, Dp.m6844constructorimpl(f7), 0.0f, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(f), 0.0f, Dp.m6844constructorimpl(f7), Dp.m6844constructorimpl(f7), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DateRangePicker(final androidx.compose.material3.DateRangePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, S7.n r28, S7.n r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.DateRangePicker(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, S7.n, S7.n, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cf  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DateRangePickerContent(final java.lang.Long r18, final java.lang.Long r19, final long r20, final S7.n r22, final S7.k r23, final androidx.compose.material3.internal.CalendarModel r24, final Y7.f r25, final androidx.compose.material3.DatePickerFormatter r26, final androidx.compose.material3.SelectableDates r27, final androidx.compose.material3.DatePickerColors r28, androidx.compose.runtime.Composer r29, final int r30) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.DateRangePickerContent(java.lang.Long, java.lang.Long, long, S7.n, S7.k, androidx.compose.material3.internal.CalendarModel, Y7.f, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    @ExperimentalMaterial3Api
    /* renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m1795DateRangePickerStateHVP43zI(Locale locale, Long l, Long l5, Long l9, f fVar, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l5, l9, fVar, i, selectableDates, locale, null);
    }

    /* renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m1796DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l5, Long l9, f fVar, int i, SelectableDates selectableDates, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            l = null;
        }
        if ((i6 & 4) != 0) {
            l5 = null;
        }
        if ((i6 & 8) != 0) {
            l9 = l;
        }
        if ((i6 & 16) != 0) {
            fVar = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i6 & 32) != 0) {
            i = DisplayMode.INSTANCE.m1823getPickerjFl4v0();
        }
        if ((i6 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m1795DateRangePickerStateHVP43zI(locale, l, l5, l9, fVar, i, selectableDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: SwitchableDateEntryContent-RN-2D1Q, reason: not valid java name */
    public static final void m1797SwitchableDateEntryContentRN2D1Q(final Long l, final Long l5, final long j5, final int i, final n nVar, final k kVar, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i6, final int i10) {
        int i11;
        Long l9;
        long j6;
        n nVar2;
        k kVar2;
        CalendarModel calendarModel2;
        f fVar2;
        int i12;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532789335);
        if ((i6 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i6;
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            l9 = l5;
            i11 |= composerStartRestartGroup.changed(l9) ? 32 : 16;
        } else {
            l9 = l5;
        }
        if ((i6 & 384) == 0) {
            j6 = j5;
            i11 |= composerStartRestartGroup.changed(j6) ? 256 : 128;
        } else {
            j6 = j5;
        }
        if ((i6 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            nVar2 = nVar;
            i11 |= composerStartRestartGroup.changedInstance(nVar2) ? 16384 : 8192;
        } else {
            nVar2 = nVar;
        }
        if ((196608 & i6) == 0) {
            kVar2 = kVar;
            i11 |= composerStartRestartGroup.changedInstance(kVar2) ? 131072 : 65536;
        } else {
            kVar2 = kVar;
        }
        if ((1572864 & i6) == 0) {
            calendarModel2 = calendarModel;
            i11 |= composerStartRestartGroup.changedInstance(calendarModel2) ? 1048576 : 524288;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((12582912 & i6) == 0) {
            fVar2 = fVar;
            i11 |= composerStartRestartGroup.changedInstance(fVar2) ? 8388608 : 4194304;
        } else {
            fVar2 = fVar;
        }
        if ((i6 & 100663296) == 0) {
            i11 |= (i6 & 134217728) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i11 |= composerStartRestartGroup.changed(selectableDates) ? 536870912 : 268435456;
        }
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i11 & 306783379) == 306783378 && (i12 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532789335, i11, i12, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:661)");
            }
            final Long l10 = l9;
            final n nVar3 = nVar2;
            final f fVar3 = fVar2;
            final long j10 = j6;
            final k kVar3 = kVar2;
            final CalendarModel calendarModel3 = calendarModel2;
            composer2 = composerStartRestartGroup;
            CrossfadeKt.Crossfade(DisplayMode.m1815boximpl(i), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new k() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return r.f317a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1026642619, true, new o() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m1802invokeQujVXRc(((DisplayMode) obj).getValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                /* renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m1802invokeQujVXRc(int i13, Composer composer3, int i14) {
                    int i15;
                    if ((i14 & 6) == 0) {
                        i15 = i14 | (composer3.changed(i13) ? 4 : 2);
                    } else {
                        i15 = i14;
                    }
                    if ((i15 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1026642619, i15, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:673)");
                    }
                    DisplayMode.Companion companion = DisplayMode.INSTANCE;
                    if (DisplayMode.m1818equalsimpl0(i13, companion.m1823getPickerjFl4v0())) {
                        composer3.startReplaceGroup(-1871305297);
                        DateRangePickerKt.DateRangePickerContent(l, l10, j10, nVar3, kVar3, calendarModel3, fVar3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (DisplayMode.m1818equalsimpl0(i13, companion.m1822getInputjFl4v0())) {
                        composer3.startReplaceGroup(-1871284056);
                        DateRangeInputKt.DateRangeInputContent(l, l10, nVar3, calendarModel3, fVar3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(2120210493);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i11 >> 9) & 14) | 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i13) {
                    DateRangePickerKt.m1797SwitchableDateEntryContentRN2D1Q(l, l5, j5, i, nVar, kVar, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i10));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalMonthsList(LazyListState lazyListState, final Long l, final Long l5, final n nVar, final k kVar, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i6;
        Long l9;
        Long l10;
        n nVar2;
        Object dateRangePickerKt$VerticalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(1257365001);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            l9 = l;
            i6 |= composerStartRestartGroup.changed(l9) ? 32 : 16;
        } else {
            l9 = l;
        }
        if ((i & 384) == 0) {
            l10 = l5;
            i6 |= composerStartRestartGroup.changed(l10) ? 256 : 128;
        } else {
            l10 = l5;
        }
        if ((i & 3072) == 0) {
            nVar2 = nVar;
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 2048 : 1024;
        } else {
            nVar2 = nVar;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(kVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(fVar) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= (16777216 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(selectableDates) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i6 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, i6, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:753)");
            }
            final CalendarDate today = calendarModel.getToday();
            boolean zChanged = composerStartRestartGroup.changed(fVar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = calendarModel.getMonth(fVar.f1569a, 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) objRememberedValue;
            final Long l11 = l9;
            final n nVar3 = nVar2;
            int i10 = i6;
            final Long l12 = l10;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new n() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i11) {
                    if ((i11 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1090773432, i11, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:763)");
                    }
                    Object objRememberedValue2 = composer2.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composer2), composer2);
                    }
                    InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    Strings.Companion companion2 = Strings.INSTANCE;
                    String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_scroll_to_previous_month), composer2, 0);
                    String strM2752getString2EP1pXo2 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_scroll_to_next_month), composer2, 0);
                    boolean zChanged2 = composer2.changed(l11) | composer2.changed(l12) | composer2.changed(nVar3);
                    final Long l13 = l11;
                    final Long l14 = l12;
                    final n nVar4 = nVar3;
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new k() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).longValue());
                                return r.f317a;
                            }

                            public final void invoke(long j5) {
                                DateRangePickerKt.updateDateSelection(j5, l13, l14, nVar4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    final k kVar2 = (k) objRememberedValue3;
                    final List listCustomScrollActions = DateRangePickerKt.customScrollActions(lazyListState2, coroutineScope, strM2752getString2EP1pXo, strM2752getString2EP1pXo2);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new k() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new S7.a() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new S7.a() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    LazyListState lazyListState3 = lazyListState2;
                    boolean zChangedInstance = composer2.changedInstance(fVar) | composer2.changedInstance(calendarModel) | composer2.changed(calendarMonth) | composer2.changedInstance(datePickerFormatter) | composer2.changedInstance(listCustomScrollActions) | composer2.changed(datePickerColors) | composer2.changed(l11) | composer2.changed(l12) | composer2.changed(kVar2) | composer2.changed(today) | composer2.changed(selectableDates);
                    final f fVar2 = fVar;
                    final CalendarModel calendarModel2 = calendarModel;
                    final CalendarMonth calendarMonth2 = calendarMonth;
                    final Long l15 = l11;
                    final Long l16 = l12;
                    final CalendarDate calendarDate = today;
                    final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    final SelectableDates selectableDates2 = selectableDates;
                    final DatePickerColors datePickerColors2 = datePickerColors;
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                        Object obj = new k() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((LazyListScope) obj2);
                                return r.f317a;
                            }

                            public final void invoke(LazyListScope lazyListScope) {
                                int iNumberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(fVar2);
                                final CalendarModel calendarModel3 = calendarModel2;
                                final CalendarMonth calendarMonth3 = calendarMonth2;
                                final Long l17 = l15;
                                final Long l18 = l16;
                                final k kVar3 = kVar2;
                                final CalendarDate calendarDate2 = calendarDate;
                                final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                final SelectableDates selectableDates3 = selectableDates2;
                                final DatePickerColors datePickerColors3 = datePickerColors2;
                                final List<CustomAccessibilityAction> list = listCustomScrollActions;
                                LazyListScope.items$default(lazyListScope, iNumberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(-1413501381, true, new p() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // S7.p
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        invoke((LazyItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                                        return r.f317a;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
                                    /* JADX WARN: Removed duplicated region for block: B:53:0x0159  */
                                    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
                                    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @androidx.compose.runtime.Composable
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct add '--show-bad-code' argument
                                    */
                                    public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r21, int r22, androidx.compose.runtime.Composer r23, int r24) {
                                        /*
                                            Method dump skipped, instructions count: 349
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.AnonymousClass1.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
                                    }
                                }), 6, null);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                        objRememberedValue4 = obj;
                    }
                    LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState3, null, false, null, null, null, false, (k) objRememberedValue4, composer2, 0, 252);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            int i11 = i10 & 14;
            boolean zChangedInstance = (i11 == 4) | ((57344 & i10) == 16384) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(fVar);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                dateRangePickerKt$VerticalMonthsList$2$1 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, kVar, calendarModel, fVar, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$VerticalMonthsList$2$1);
            } else {
                dateRangePickerKt$VerticalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            EffectsKt.LaunchedEffect(lazyListState2, (n) dateRangePickerKt$VerticalMonthsList$2$1, composerStartRestartGroup, i11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    DateRangePickerKt.VerticalMonthsList(lazyListState2, l, l5, nVar, kVar, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState lazyListState, final InterfaceC1733z interfaceC1733z, String str, String str2) {
        return H4.o.N(new CustomAccessibilityAction(str, new S7.a() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1

            @J7.c(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", f = "DateRangePicker.kt", l = {1032}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements n {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LazyListState lazyListState, H7.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass1(this.$state, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        LazyListState lazyListState = this.$state;
                        int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() - 1;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, firstVisibleItemIndex, 0, this, 2, null) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    return r.f317a;
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                boolean z10;
                if (lazyListState.getCanScrollBackward()) {
                    AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(lazyListState, null), 3);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }), new CustomAccessibilityAction(str2, new S7.a() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1

            @J7.c(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", f = "DateRangePicker.kt", l = {1040}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements n {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LazyListState lazyListState, H7.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass1(this.$state, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        LazyListState lazyListState = this.$state;
                        int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() + 1;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, firstVisibleItemIndex, 0, this, 2, null) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    return r.f317a;
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                boolean z10;
                if (lazyListState.getCanScrollForward()) {
                    AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(lazyListState, null), 3);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }));
    }

    /* renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m1799drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j5) {
        float fMo381toPx0680j_4 = contentDrawScope.mo381toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float fMo381toPx0680j_42 = contentDrawScope.mo381toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float fMo381toPx0680j_43 = contentDrawScope.mo381toPx0680j_4(DatePickerModalTokens.INSTANCE.m2921getDateStateLayerHeightD9Ej5fM());
        float f = 2;
        float f7 = (fMo381toPx0680j_42 - fMo381toPx0680j_43) / f;
        float f9 = 7;
        float fM3964getWidthimpl = (Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - (f9 * fMo381toPx0680j_4)) / f9;
        long gridStartCoordinates = selectedRangeInfo.getGridStartCoordinates();
        int iM6972getXimpl = IntOffset.m6972getXimpl(gridStartCoordinates);
        int iM6973getYimpl = IntOffset.m6973getYimpl(gridStartCoordinates);
        long gridEndCoordinates = selectedRangeInfo.getGridEndCoordinates();
        int iM6972getXimpl2 = IntOffset.m6972getXimpl(gridEndCoordinates);
        int iM6973getYimpl2 = IntOffset.m6973getYimpl(gridEndCoordinates);
        float f10 = iM6972getXimpl;
        float f11 = fMo381toPx0680j_4 + fM3964getWidthimpl;
        float f12 = fM3964getWidthimpl / f;
        float fM3964getWidthimpl2 = (f10 * f11) + (selectedRangeInfo.getFirstIsSelectionStart() ? fMo381toPx0680j_4 / f : 0.0f) + f12;
        float f13 = (iM6973getYimpl * fMo381toPx0680j_42) + f7;
        float f14 = iM6972getXimpl2 * f11;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            fMo381toPx0680j_4 /= f;
        }
        float fM3964getWidthimpl3 = f14 + fMo381toPx0680j_4 + f12;
        float f15 = (iM6973getYimpl2 * fMo381toPx0680j_42) + f7;
        boolean z10 = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z10) {
            fM3964getWidthimpl2 = Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - fM3964getWidthimpl2;
            fM3964getWidthimpl3 = Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - fM3964getWidthimpl3;
        }
        float fM3964getWidthimpl4 = fM3964getWidthimpl3;
        DrawScope.m4701drawRectnJ9OG0$default(contentDrawScope, j5, OffsetKt.Offset(fM3964getWidthimpl2, f13), SizeKt.Size(iM6973getYimpl == iM6973getYimpl2 ? fM3964getWidthimpl4 - fM3964getWidthimpl2 : z10 ? -fM3964getWidthimpl2 : Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - fM3964getWidthimpl2, fMo381toPx0680j_43), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        if (iM6973getYimpl != iM6973getYimpl2) {
            for (int i = (iM6973getYimpl2 - iM6973getYimpl) - 1; i > 0; i--) {
                DrawScope.m4701drawRectnJ9OG0$default(contentDrawScope, j5, OffsetKt.Offset(0.0f, (i * fMo381toPx0680j_42) + f13), SizeKt.Size(Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()), fMo381toPx0680j_43), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            }
            long jOffset = OffsetKt.Offset(contentDrawScope.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()), f15);
            if (z10) {
                fM3964getWidthimpl4 -= Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc());
            }
            DrawScope.m4701drawRectnJ9OG0$default(contentDrawScope, j5, jOffset, SizeKt.Size(fM3964getWidthimpl4, fMo381toPx0680j_43), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    @Composable
    @ExperimentalMaterial3Api
    /* renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m1800rememberDateRangePickerStateIlFM19s(Long l, Long l5, Long l9, f fVar, int i, SelectableDates selectableDates, Composer composer, int i6, int i10) {
        final Long l10 = (i10 & 1) != 0 ? null : l;
        final Long l11 = (i10 & 2) != 0 ? null : l5;
        final Long l12 = (i10 & 4) != 0 ? l10 : l9;
        final f yearRange = (i10 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : fVar;
        final int iM1823getPickerjFl4v0 = (i10 & 16) != 0 ? DisplayMode.INSTANCE.m1823getPickerjFl4v0() : i;
        final SelectableDates allDates = (i10 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, i6, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:261)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.INSTANCE.Saver(allDates, localeDefaultLocale);
        boolean zChangedInstance = ((((i6 & 112) ^ 48) > 32 && composer.changed(l11)) || (i6 & 48) == 32) | ((((i6 & 14) ^ 6) > 4 && composer.changed(l10)) || (i6 & 6) == 4) | ((((i6 & 896) ^ 384) > 256 && composer.changed(l12)) || (i6 & 384) == 256) | composer.changedInstance(yearRange) | ((((57344 & i6) ^ 24576) > 16384 && composer.changed(iM1823getPickerjFl4v0)) || (i6 & 24576) == 16384) | ((((458752 & i6) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(allDates)) || (i6 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new S7.a() { // from class: androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final DateRangePickerStateImpl invoke() {
                    return new DateRangePickerStateImpl(l10, l11, l12, yearRange, iM1823getPickerjFl4v0, allDates, localeDefaultLocale, null);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) Saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return dateRangePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(long j5, Long l, Long l5, n nVar) {
        if ((l == null && l5 == null) || (l != null && l5 != null)) {
            nVar.invoke(Long.valueOf(j5), null);
        } else if (l == null || j5 < l.longValue()) {
            nVar.invoke(Long.valueOf(j5), null);
        } else {
            nVar.invoke(l, Long.valueOf(j5));
        }
    }
}
