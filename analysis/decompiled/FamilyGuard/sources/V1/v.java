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
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;
import f2.C0712q;
import java.util.ArrayList;
import java.util.List;
import w2.C1216d;

/* loaded from: classes.dex */
public class v extends i {

    /* renamed from: q, reason: collision with root package name */
    private final b f5504q;

    /* renamed from: r, reason: collision with root package name */
    private List<C1216d> f5505r;

    public v(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_4x2, componentName);
        this.f5504q = new b();
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        remoteViewsI.setImageViewBitmap(R(), I(context));
        y.d(context, remoteViewsI, M());
        List<C1216d> list = this.f5505r;
        if (list != null) {
            this.f5504q.f(context, remoteViewsI, list);
        }
        if (T1.b.g(this.f5514k.getContext())) {
            remoteViewsI.setViewLayoutMarginDimen(R.id.total_usage_label, 1, R.dimen.us_4x2_widget_title_margin_top_in_3x2);
            remoteViewsI.setViewLayoutMarginDimen(R.id.histogram_img, 3, R.dimen.us_4x2_widget_title_margin_top_in_3x2);
            remoteViewsI.setViewLayoutWidth(R.id.app_container, context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_app_usage_container_width_easy_mode), 0);
            return remoteViewsI;
        }
        remoteViewsI.setViewLayoutMarginDimen(R.id.total_usage_label, 1, R.dimen.us_4x2_widget_title_margin_top);
        remoteViewsI.setViewLayoutMarginDimen(R.id.histogram_img, 3, R.dimen.us_4x2_widget_histogram_margin_bottom);
        remoteViewsI.setViewLayoutWidth(R.id.app_container, context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_app_usage_container_width), 0);
        return remoteViewsI;
    }

    @Override // V1.z
    protected View H(Context context) throws Resources.NotFoundException {
        HistogramView histogramViewK = K(context, R.layout.us_widget_4x2_histogram_legacy);
        new C0270i().a(histogramViewK);
        histogramViewK.setLayoutParams(new FrameLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_histogram_view_width), 1073741824), View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_histogram_view_height), 1073741824)));
        return histogramViewK;
    }

    protected int R() {
        return R.id.histogram_img;
    }

    public void S(List<C1216d> list) {
        this.f5505r = list;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        return new RemoteViews(context.getPackageName(), R.layout.us_digital_wellbeing_widget_4x2_legacy);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        if (zR) {
            UsingTimeStats[] usingTimeStatsArr = (UsingTimeStats[]) bundle.getParcelableArray("USING_TIME_STATS_ARRAY");
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("APP_USAGE_LIMIT_DATA_LIST");
            Q(usingTimeStatsArr);
            S(parcelableArrayList);
            P(C0711p.l(C0712q.b(usingTimeStatsArr)));
        }
        return zR;
    }

    @Override // V1.z, com.stepos.digitalwellbeing.appwidget.b
    public void s(Configuration configuration) {
        super.s(configuration);
        E(h(), g());
    }
}
