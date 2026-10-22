package A2;

import android.content.Context;
import android.widget.TextView;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* loaded from: classes.dex */
public class r extends A<StatsDataSet> {
    public r(Context context, HistogramView histogramView) {
        super(context, histogramView);
    }

    @Override // A2.AbstractC0262a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(StatsDataSet statsDataSet) {
        long startTime = statsDataSet.getStartTime();
        int notifyTimes = statsDataSet.getNotifyTimes();
        if (statsDataSet.getInterval() == com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal()) {
            this.f72d.setText(C0711p.v(this.f92a, startTime));
            this.f73e.setText(C0711p.c(this.f92a, C0711p.p(startTime)));
        } else if (statsDataSet.getInterval() == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            TextView textView = this.f72d;
            Context context = this.f92a;
            textView.setText(context.getString(R.string.us_week_total, C0711p.C(context, startTime)));
            this.f73e.setText(C0711p.i(this.f92a, startTime));
        }
        this.f74f.setText(String.valueOf(notifyTimes));
        this.f75g.setText(R.string.us_widget_notification_label);
        this.f93b.requestLayout();
    }
}
