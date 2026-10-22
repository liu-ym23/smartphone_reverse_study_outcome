package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public class m extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeekDayFormatter f17822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DayOfWeek f17823b;

    public m(Context r10, DayOfWeek r11) {
        super(r10);
        this.f17822a = WeekDayFormatter.DEFAULT;
        setGravity(17);
        setTextAlignment(4);
        b(r11);
    }

    public void b(DayOfWeek r10) {
        this.f17823b = r10;
        setText(this.f17822a.format(r10));
    }

    public void c(WeekDayFormatter r10) {
        if (r10 != null) goto L4;
        r10 = WeekDayFormatter.DEFAULT;
    L4:
        this.f17822a = r10;
        b(this.f17823b);
    }
}
