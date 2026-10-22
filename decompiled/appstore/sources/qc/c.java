package qc;

import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.format.DayFormatter;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class c implements DayFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f23631a;

    public c() {
        this(DateTimeFormatter.m("d", Locale.getDefault()));
    }

    @Override // com.obric.oui.calendar.format.DayFormatter
    public String format(CalendarDay r10) {
        return this.f23631a.d(r10.getDate());
    }

    public c(DateTimeFormatter r10) {
        this.f23631a = r10;
    }
}
