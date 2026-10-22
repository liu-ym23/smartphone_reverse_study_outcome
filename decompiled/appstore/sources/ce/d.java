package ce;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class d implements TitleFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f6140a;

    public d() {
        this(DateTimeFormatter.l("LLLL yyyy"));
    }

    @Override // com.prolificinteractive.materialcalendarview.format.TitleFormatter
    public CharSequence format(CalendarDay r10) {
        return this.f6140a.d(r10.getDate());
    }

    public d(DateTimeFormatter r10) {
        this.f6140a = r10;
    }
}
