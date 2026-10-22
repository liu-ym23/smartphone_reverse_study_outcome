package V1;

import A2.C0270i;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.U;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class w extends i {

    /* renamed from: q, reason: collision with root package name */
    private List<U.c> f5506q;

    /* renamed from: r, reason: collision with root package name */
    private List<U.a> f5507r;

    /* renamed from: s, reason: collision with root package name */
    private final j f5508s;

    /* renamed from: t, reason: collision with root package name */
    private final C0389a f5509t;

    public w(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_4x4, componentName);
        this.f5508s = new j();
        this.f5509t = new C0389a();
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        remoteViewsI.setImageViewBitmap(R(), I(context));
        y.d(context, remoteViewsI, M());
        this.f5508s.p(P1.a.a(), remoteViewsI, this.f5507r);
        this.f5509t.f(context, remoteViewsI, this.f5506q);
        return remoteViewsI;
    }

    @Override // V1.z
    protected View H(Context context) throws Resources.NotFoundException {
        HistogramView histogramViewK = K(context, R.layout.us_widget_4x4_histogram);
        new C0270i().a(histogramViewK);
        histogramViewK.setLayoutParams(new FrameLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x4_widget_histogram_view_width), 1073741824), View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x4_widget_histogram_view_height), 1073741824)));
        return histogramViewK;
    }

    protected int R() {
        return R.id.histogram_img;
    }

    public void S(List<U.a> list) {
        this.f5507r = list;
    }

    public void T(List<U.c> list) {
        this.f5506q = list;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        return new RemoteViews(context.getPackageName(), R.layout.us_digital_wellbeing_widget_4x4);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        if (zR) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("APP_USAGE_LIMIT_DATA_LIST");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("CATEGORY_USAGE_LIMIT_DATA_LIST");
            StatsDataSet statsDataSet = (StatsDataSet) bundle.getParcelable("STATS_DATA_SET");
            long usingTime = statsDataSet == null ? 0L : statsDataSet.getUsingTime();
            O(statsDataSet);
            T(parcelableArrayList);
            S(parcelableArrayList2);
            P(C0711p.l(usingTime));
        }
        return zR;
    }

    @Override // V1.z, com.stepos.digitalwellbeing.appwidget.b
    public void s(Configuration configuration) {
        super.s(configuration);
        E(h(), g());
    }
}
