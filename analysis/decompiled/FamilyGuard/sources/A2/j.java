package A2;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* loaded from: classes.dex */
public class j extends E {
    public j(Context context, HistogramView histogramView) {
        super(context, histogramView);
    }

    @Override // A2.E, A2.AbstractC0262a
    protected View e(Context context) {
        return super.e(context);
    }

    @Override // A2.E, A2.AbstractC0262a
    /* renamed from: g */
    public void a(StatsDataSet statsDataSet) throws Resources.NotFoundException {
        long startTime = statsDataSet.getStartTime();
        long usingTime = statsDataSet.getUsingTime();
        if (statsDataSet.getInterval() == com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal()) {
            this.f83d.setText(C0711p.v(this.f92a, startTime));
            this.f84e.setText(C0711p.c(this.f92a, C0711p.p(startTime)));
        } else if (statsDataSet.getInterval() == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            TextView textView = this.f83d;
            Context context = this.f92a;
            textView.setText(context.getString(R.string.us_week_total, C0711p.C(context, startTime)));
            this.f84e.setText(C0711p.i(this.f92a, startTime));
        }
        this.f85f.setTime(usingTime);
        this.f93b.requestLayout();
    }
}
