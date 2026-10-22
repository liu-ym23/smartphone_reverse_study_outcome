package com.obric.oui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.oui.calendar.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public class v extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeekDayFormatter f12747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DayOfWeek f12748b;

    public v(Context r10, DayOfWeek r11) {
        super(r10);
        this.f12747a = WeekDayFormatter.DEFAULT;
        setGravity(17);
        setTextAlignment(4);
        setTextSize(12.0f);
        setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        b(r11);
    }

    public void b(DayOfWeek r10) {
        this.f12748b = r10;
        setText(this.f12747a.format(r10));
    }

    public void c(WeekDayFormatter r10) {
        if (r10 != null) goto L4;
        r10 = WeekDayFormatter.DEFAULT;
    L4:
        this.f12747a = r10;
        b(this.f12748b);
    }
}
