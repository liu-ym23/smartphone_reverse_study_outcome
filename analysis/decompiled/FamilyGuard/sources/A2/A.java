package A2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* loaded from: classes.dex */
public abstract class A<Data> extends AbstractC0262a<Data> {

    /* renamed from: d, reason: collision with root package name */
    protected TextView f72d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f73e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f74f;

    /* renamed from: g, reason: collision with root package name */
    protected TextView f75g;

    public A(Context context, HistogramView histogramView) {
        super(context, histogramView);
    }

    @Override // A2.AbstractC0262a
    protected View e(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.us_times_balloon_layout, (ViewGroup) null, false);
        this.f72d = (TextView) viewInflate.findViewById(R.id.text1);
        this.f73e = (TextView) viewInflate.findViewById(R.id.text2);
        this.f74f = (TextView) viewInflate.findViewById(R.id.times);
        this.f75g = (TextView) viewInflate.findViewById(R.id.times_label);
        T1.g.e(1.18f, (ViewGroup) viewInflate);
        return viewInflate;
    }
}
