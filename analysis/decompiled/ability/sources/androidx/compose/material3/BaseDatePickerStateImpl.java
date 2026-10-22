package androidx.compose.material3;

import Y7.f;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Locale;
import kotlin.Metadata;

@Stable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "", "initialDisplayedMonthMillis", "LY7/f;", "yearRange", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", AppAgent.CONSTRUCT, "(Ljava/lang/Long;LY7/f;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "LY7/f;", "getYearRange", "()LY7/f;", "Landroidx/compose/material3/SelectableDates;", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "Landroidx/compose/material3/internal/CalendarModel;", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/internal/CalendarModel;", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarMonth;", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "monthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "displayedMonthMillis", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseDatePickerStateImpl {
    public static final int $stable = 0;
    private MutableState<CalendarMonth> _displayedMonth;
    private final CalendarModel calendarModel;
    private final SelectableDates selectableDates;
    private final f yearRange;

    public BaseDatePickerStateImpl(Long l, f fVar, SelectableDates selectableDates, Locale locale) {
        CalendarMonth month;
        this.yearRange = fVar;
        this.selectableDates = selectableDates;
        CalendarModel calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(locale);
        this.calendarModel = calendarModelCreateCalendarModel;
        if (l != null) {
            month = calendarModelCreateCalendarModel.getMonth(l.longValue());
            if (!fVar.e(month.getYear())) {
                throw new IllegalArgumentException(("The initial display month's year (" + month.getYear() + ") is out of the years range of " + fVar + '.').toString());
            }
        } else {
            month = calendarModelCreateCalendarModel.getMonth(calendarModelCreateCalendarModel.getToday());
        }
        this._displayedMonth = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(month, null, 2, null);
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final long getDisplayedMonthMillis() {
        return this._displayedMonth.getValue().getStartUtcTimeMillis();
    }

    public final SelectableDates getSelectableDates() {
        return this.selectableDates;
    }

    public final f getYearRange() {
        return this.yearRange;
    }

    public final void setDisplayedMonthMillis(long j5) {
        CalendarMonth month = this.calendarModel.getMonth(j5);
        if (this.yearRange.e(month.getYear())) {
            this._displayedMonth.setValue(month);
            return;
        }
        throw new IllegalArgumentException(("The display month's year (" + month.getYear() + ") is out of the years range of " + this.yearRange + '.').toString());
    }
}
