package A2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* loaded from: classes.dex */
public class s extends A<NotificationTimesStats> {
    public s(Context context, HistogramView histogramView) {
        super(context, histogramView);
    }

    @Override // A2.A, A2.AbstractC0262a
    protected View e(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.us_times_balloon_layout_legacy, (ViewGroup) null, false);
        this.f72d = (TextView) viewInflate.findViewById(R.id.text1);
        this.f73e = (TextView) viewInflate.findViewById(R.id.text2);
        this.f74f = (TextView) viewInflate.findViewById(R.id.times);
        this.f75g = (TextView) viewInflate.findViewById(R.id.times_label);
        T1.g.e(1.18f, (ViewGroup) viewInflate);
        return viewInflate;
    }

    @Override // A2.AbstractC0262a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(NotificationTimesStats notificationTimesStats) {
        long startTime = notificationTimesStats.getStartTime();
        int notificationTimes = notificationTimesStats.getNotificationTimes();
        if (notificationTimesStats.getInterval() == com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal()) {
            this.f72d.setText(C0711p.v(this.f92a, startTime));
            this.f73e.setText(C0711p.c(this.f92a, C0711p.p(startTime)));
        } else if (notificationTimesStats.getInterval() == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            TextView textView = this.f72d;
            Context context = this.f92a;
            textView.setText(context.getString(R.string.us_week_total, C0711p.C(context, startTime)));
            this.f73e.setText(C0711p.i(this.f92a, startTime));
        }
        this.f74f.setText(String.valueOf(notificationTimes));
        this.f75g.setText(R.string.us_widget_notification_label);
        this.f93b.requestLayout();
    }
}
