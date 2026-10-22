package A2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.TimeDisplayView;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0702g;
import f2.C0711p;

/* loaded from: classes.dex */
public class E extends AbstractC0262a<StatsDataSet> {

    /* renamed from: d, reason: collision with root package name */
    protected TextView f83d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f84e;

    /* renamed from: f, reason: collision with root package name */
    protected TimeDisplayView f85f;

    public E(Context context, HistogramView histogramView) {
        super(context, histogramView);
    }

    @Override // A2.AbstractC0262a
    protected View e(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.us_usage_balloon_layout, (ViewGroup) null, false);
        this.f83d = (TextView) viewInflate.findViewById(R.id.text1);
        this.f84e = (TextView) viewInflate.findViewById(R.id.text2);
        this.f85f = (TimeDisplayView) viewInflate.findViewById(R.id.usage_time);
        return viewInflate;
    }

    @Override // A2.AbstractC0262a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(StatsDataSet statsDataSet) throws Resources.NotFoundException {
        C0702g.b("UsageBalloonContainer", "bind() called with: statsDataSet = [" + statsDataSet + "]");
        long startTime = statsDataSet.getStartTime();
        long usingTime = statsDataSet.getUsingTime();
        this.f83d.setText(C0711p.v(this.f92a, startTime));
        this.f84e.setText(C0711p.c(this.f92a, C0711p.p(startTime)));
        this.f85f.setTime(usingTime);
        this.f93b.requestLayout();
    }
}
