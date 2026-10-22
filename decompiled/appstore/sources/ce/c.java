package ce;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class c implements DayFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f6139a;

    public c() {
        this(DateTimeFormatter.m("d", Locale.getDefault()));
    }

    @Override // com.prolificinteractive.materialcalendarview.format.DayFormatter
    public String format(CalendarDay r10) {
        return this.f6139a.d(r10.getDate());
    }

    public c(DateTimeFormatter r10) {
        this.f6139a = r10;
    }
}
