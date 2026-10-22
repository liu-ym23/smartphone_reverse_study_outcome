package ce;

import android.text.SpannableStringBuilder;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class e implements TitleFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence[] f6141a;

    public e(CharSequence[] r10) {
        if (r10 == null) goto L11;
        if (r10.length < 12) goto L9;
        this.f6141a = r10;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // com.prolificinteractive.materialcalendarview.format.TitleFormatter
    public CharSequence format(CalendarDay r10) {
        return new SpannableStringBuilder().append(this.f6141a[r10.getMonth() - 1]).append(" ").append(String.valueOf(r10.getYear()));
    }
}
