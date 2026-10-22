package androidx.compose.material3;

import H4.o;
import S7.k;
import S7.n;
import Y7.f;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Stable
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'BI\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR*\u0010\"\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DateRangePickerState;", "", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "LY7/f;", "yearRange", "Landroidx/compose/material3/DisplayMode;", "initialDisplayMode", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/e;)V", "startDateMillis", "endDateMillis", "LC7/r;", "setSelection", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "_selectedStartDate", "Landroidx/compose/runtime/MutableState;", "_selectedEndDate", "_displayMode", "getSelectedStartDateMillis", "()Ljava/lang/Long;", "selectedStartDateMillis", "getSelectedEndDateMillis", "selectedEndDateMillis", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DateRangePickerStateImpl extends BaseDatePickerStateImpl implements DateRangePickerState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MutableState<DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedEndDate;
    private MutableState<CalendarDate> _selectedStartDate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DateRangePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<DateRangePickerStateImpl, Object> Saver(final SelectableDates selectableDates, final Locale locale) {
            return ListSaverKt.listSaver(new n() { // from class: androidx.compose.material3.DateRangePickerStateImpl$Companion$Saver$1
                @Override // S7.n
                public final List<Object> invoke(SaverScope saverScope, DateRangePickerStateImpl dateRangePickerStateImpl) {
                    return o.N(dateRangePickerStateImpl.getSelectedStartDateMillis(), dateRangePickerStateImpl.getSelectedEndDateMillis(), Long.valueOf(dateRangePickerStateImpl.getDisplayedMonthMillis()), Integer.valueOf(dateRangePickerStateImpl.getYearRange().f1569a), Integer.valueOf(dateRangePickerStateImpl.getYearRange().b), Integer.valueOf(dateRangePickerStateImpl.mo1803getDisplayModejFl4v0()));
                }
            }, new k() { // from class: androidx.compose.material3.DateRangePickerStateImpl$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DateRangePickerStateImpl invoke(List<? extends Object> list) {
                    Long l = (Long) list.get(0);
                    Long l5 = (Long) list.get(1);
                    Long l9 = (Long) list.get(2);
                    Object obj = list.get(3);
                    kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(4);
                    kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                    f fVar = new f(iIntValue, ((Integer) obj2).intValue(), 1);
                    Object obj3 = list.get(5);
                    kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return new DateRangePickerStateImpl(l, l5, l9, fVar, DisplayMode.m1816constructorimpl(((Integer) obj3).intValue()), selectableDates, locale, null);
                }
            });
        }

        private Companion() {
        }
    }

    public /* synthetic */ DateRangePickerStateImpl(Long l, Long l5, Long l9, f fVar, int i, SelectableDates selectableDates, Locale locale, e eVar) {
        this(l, l5, l9, fVar, i, selectableDates, locale);
    }

    @Override // androidx.compose.material3.DateRangePickerState
    /* renamed from: getDisplayMode-jFl-4v0 */
    public int mo1803getDisplayModejFl4v0() {
        return this._displayMode.getValue().getValue();
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long getSelectedEndDateMillis() {
        CalendarDate value = this._selectedEndDate.getValue();
        if (value != null) {
            return Long.valueOf(value.getUtcTimeMillis());
        }
        return null;
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long getSelectedStartDateMillis() {
        CalendarDate value = this._selectedStartDate.getValue();
        if (value != null) {
            return Long.valueOf(value.getUtcTimeMillis());
        }
        return null;
    }

    @Override // androidx.compose.material3.DateRangePickerState
    /* renamed from: setDisplayMode-vCnGnXg */
    public void mo1804setDisplayModevCnGnXg(int i) {
        Long selectedStartDateMillis = getSelectedStartDateMillis();
        if (selectedStartDateMillis != null) {
            setDisplayedMonthMillis(getCalendarModel().getMonth(selectedStartDateMillis.longValue()).getStartUtcTimeMillis());
        }
        this._displayMode.setValue(DisplayMode.m1815boximpl(i));
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public void setSelection(Long startDateMillis, Long endDateMillis) {
        CalendarDate canonicalDate = startDateMillis != null ? getCalendarModel().getCanonicalDate(startDateMillis.longValue()) : null;
        CalendarDate canonicalDate2 = endDateMillis != null ? getCalendarModel().getCanonicalDate(endDateMillis.longValue()) : null;
        if (canonicalDate != null && !getYearRange().e(canonicalDate.getYear())) {
            throw new IllegalArgumentException(("The provided start date year (" + canonicalDate.getYear() + ") is out of the years range of " + getYearRange() + '.').toString());
        }
        if (canonicalDate2 != null && !getYearRange().e(canonicalDate2.getYear())) {
            throw new IllegalArgumentException(("The provided end date year (" + canonicalDate2.getYear() + ") is out of the years range of " + getYearRange() + '.').toString());
        }
        if (canonicalDate2 != null) {
            if (canonicalDate == null) {
                throw new IllegalArgumentException("An end date was provided without a start date.");
            }
            if (canonicalDate.getUtcTimeMillis() > canonicalDate2.getUtcTimeMillis()) {
                throw new IllegalArgumentException("The provided end date appears before the start date.");
            }
        }
        this._selectedStartDate.setValue(canonicalDate);
        this._selectedEndDate.setValue(canonicalDate2);
    }

    private DateRangePickerStateImpl(Long l, Long l5, Long l9, f fVar, int i, SelectableDates selectableDates, Locale locale) {
        super(l9, fVar, selectableDates, locale);
        this._selectedStartDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selectedEndDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        setSelection(l, l5);
        this._displayMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DisplayMode.m1815boximpl(i), null, 2, null);
    }
}
