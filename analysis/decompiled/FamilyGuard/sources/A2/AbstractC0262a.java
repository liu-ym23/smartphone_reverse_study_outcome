package A2;

import android.content.Context;
import android.view.View;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* renamed from: A2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0262a<Data> {

    /* renamed from: a, reason: collision with root package name */
    protected Context f92a;

    /* renamed from: b, reason: collision with root package name */
    protected View f93b;

    /* renamed from: c, reason: collision with root package name */
    protected HistogramView f94c;

    public AbstractC0262a(Context context, HistogramView histogramView) {
        this.f92a = context;
        this.f94c = histogramView;
    }

    public abstract void a(Data data);

    public int b(int i5) {
        int measuredWidth = this.f93b.getMeasuredWidth();
        int measuredWidth2 = this.f94c.getMeasuredWidth();
        int i6 = i5 - (measuredWidth / 2);
        if (i6 < 0) {
            return 0;
        }
        int i7 = measuredWidth2 - measuredWidth;
        return i6 > i7 ? i7 : i6;
    }

    public View c(Context context) {
        View viewE = e(context);
        this.f93b = viewE;
        return viewE;
    }

    public void d() {
        View view = this.f93b;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    protected abstract View e(Context context);

    public void f() {
        View view = this.f93b;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
