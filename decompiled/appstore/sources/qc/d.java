package qc;

import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.format.TitleFormatter;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class d implements TitleFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f23632a;

    public d() {
        this(DateTimeFormatter.l("LLLL yyyy"));
    }

    @Override // com.obric.oui.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay r10) {
        return this.f23632a.d(r10.getDate());
    }

    public d(DateTimeFormatter r10) {
        this.f23632a = r10;
    }
}
