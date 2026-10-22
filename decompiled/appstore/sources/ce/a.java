package ce;

import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public class a implements WeekDayFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence[] f6138a;

    public a(CharSequence[] r10) {
        if (r10 == null) goto L11;
        if (r10.length != 7) goto L9;
        this.f6138a = r10;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // com.prolificinteractive.materialcalendarview.format.WeekDayFormatter
    public CharSequence format(DayOfWeek r10) {
        return this.f6138a[r10.getValue() - 1];
    }
}
