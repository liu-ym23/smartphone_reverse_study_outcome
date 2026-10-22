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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DatePickerState;", "", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "LY7/f;", "yearRange", "Landroidx/compose/material3/DisplayMode;", "initialDisplayMode", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "_selectedDate", "Landroidx/compose/runtime/MutableState;", "_displayMode", "dateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "selectedDateMillis", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DatePickerStateImpl extends BaseDatePickerStateImpl implements DatePickerState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MutableState<DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedDate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DatePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<DatePickerStateImpl, Object> Saver(final SelectableDates selectableDates, final Locale locale) {
            return ListSaverKt.listSaver(new n() { // from class: androidx.compose.material3.DatePickerStateImpl$Companion$Saver$1
                @Override // S7.n
                public final List<Object> invoke(SaverScope saverScope, DatePickerStateImpl datePickerStateImpl) {
                    return o.N(datePickerStateImpl.getSelectedDateMillis(), Long.valueOf(datePickerStateImpl.getDisplayedMonthMillis()), Integer.valueOf(datePickerStateImpl.getYearRange().f1569a), Integer.valueOf(datePickerStateImpl.getYearRange().b), Integer.valueOf(datePickerStateImpl.mo1789getDisplayModejFl4v0()));
                }
            }, new k() { // from class: androidx.compose.material3.DatePickerStateImpl$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DatePickerStateImpl invoke(List<? extends Object> list) {
                    Long l = (Long) list.get(0);
                    Long l5 = (Long) list.get(1);
                    Object obj = list.get(2);
                    kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(3);
                    kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                    f fVar = new f(iIntValue, ((Integer) obj2).intValue(), 1);
                    Object obj3 = list.get(4);
                    kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return new DatePickerStateImpl(l, l5, fVar, DisplayMode.m1816constructorimpl(((Integer) obj3).intValue()), selectableDates, locale, null);
                }
            });
        }

        private Companion() {
        }
    }

    public /* synthetic */ DatePickerStateImpl(Long l, Long l5, f fVar, int i, SelectableDates selectableDates, Locale locale, e eVar) {
        this(l, l5, fVar, i, selectableDates, locale);
    }

    @Override // androidx.compose.material3.DatePickerState
    /* renamed from: getDisplayMode-jFl-4v0 */
    public int mo1789getDisplayModejFl4v0() {
        return this._displayMode.getValue().getValue();
    }

    @Override // androidx.compose.material3.DatePickerState
    public Long getSelectedDateMillis() {
        CalendarDate value = this._selectedDate.getValue();
        if (value != null) {
            return Long.valueOf(value.getUtcTimeMillis());
        }
        return null;
    }

    @Override // androidx.compose.material3.DatePickerState
    /* renamed from: setDisplayMode-vCnGnXg */
    public void mo1790setDisplayModevCnGnXg(int i) {
        Long selectedDateMillis = getSelectedDateMillis();
        if (selectedDateMillis != null) {
            setDisplayedMonthMillis(getCalendarModel().getMonth(selectedDateMillis.longValue()).getStartUtcTimeMillis());
        }
        this._displayMode.setValue(DisplayMode.m1815boximpl(i));
    }

    @Override // androidx.compose.material3.DatePickerState
    public void setSelectedDateMillis(Long l) {
        if (l == null) {
            this._selectedDate.setValue(null);
            return;
        }
        CalendarDate canonicalDate = getCalendarModel().getCanonicalDate(l.longValue());
        if (getYearRange().e(canonicalDate.getYear())) {
            this._selectedDate.setValue(canonicalDate);
            return;
        }
        throw new IllegalArgumentException(("The provided date's year (" + canonicalDate.getYear() + ") is out of the years range of " + getYearRange() + '.').toString());
    }

    private DatePickerStateImpl(Long l, Long l5, f fVar, int i, SelectableDates selectableDates, Locale locale) {
        CalendarDate canonicalDate;
        super(l5, fVar, selectableDates, locale);
        if (l != null) {
            canonicalDate = getCalendarModel().getCanonicalDate(l.longValue());
            if (!fVar.e(canonicalDate.getYear())) {
                throw new IllegalArgumentException(("The provided initial date's year (" + canonicalDate.getYear() + ") is out of the years range of " + fVar + '.').toString());
            }
        } else {
            canonicalDate = null;
        }
        this._selectedDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(canonicalDate, null, 2, null);
        this._displayMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DisplayMode.m1815boximpl(i), null, 2, null);
    }
}
