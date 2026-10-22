package V1;

import android.content.ComponentName;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import e2.C0684b;
import f2.C0702g;

/* loaded from: classes.dex */
public abstract class i extends z {

    /* renamed from: m, reason: collision with root package name */
    protected UsingTimeStats[] f5485m;

    /* renamed from: n, reason: collision with root package name */
    protected StatsDataSet f5486n;

    /* renamed from: o, reason: collision with root package name */
    protected long f5487o;

    /* renamed from: p, reason: collision with root package name */
    protected HistogramView f5488p;

    public i(Context context, A a6, ComponentName componentName) {
        super(context, a6, componentName);
    }

    @Override // V1.z
    protected void J() {
        if (!C0684b.A()) {
            this.f5488p.setData(N());
            return;
        }
        StatsDataSet statsDataSetL = L();
        C0702g.b("BaseWidgetHistogram", "prepareImageData");
        if (statsDataSetL == null) {
            return;
        }
        if (statsDataSetL.getChildren() == null) {
            C0702g.O("BaseWidgetHistogram", "prepareImageData skip: null children");
        } else {
            this.f5488p.setData(new z2.d(statsDataSetL));
        }
    }

    protected HistogramView K(Context context, int i5) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(context).inflate(i5, (ViewGroup) null, false);
        this.f5488p = histogramView;
        return histogramView;
    }

    public StatsDataSet L() {
        return this.f5486n;
    }

    public long M() {
        return this.f5487o;
    }

    public UsingTimeStats[] N() {
        return this.f5485m;
    }

    public void O(StatsDataSet statsDataSet) {
        C0702g.M("BaseWidgetHistogram", "setStatsDataSet statsDataSet = " + statsDataSet);
        this.f5486n = statsDataSet;
    }

    public void P(long j5) {
        this.f5487o = j5;
    }

    public void Q(UsingTimeStats[] usingTimeStatsArr) {
        this.f5485m = usingTimeStatsArr;
    }
}
