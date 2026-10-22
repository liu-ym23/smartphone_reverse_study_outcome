package ce;

import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements WeekDayFormatter {
    public b() {
    }

    @Override // com.prolificinteractive.materialcalendarview.format.WeekDayFormatter
    public CharSequence format(DayOfWeek r10) {
        return r10.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
