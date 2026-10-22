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
import w2.C1257w;

/* loaded from: classes.dex */
public class x extends i {

    /* renamed from: q, reason: collision with root package name */
    private List<C1216d> f5510q;

    /* renamed from: r, reason: collision with root package name */
    private List<C1257w> f5511r;

    /* renamed from: s, reason: collision with root package name */
    private final k f5512s;

    /* renamed from: t, reason: collision with root package name */
    private final b f5513t;

    public x(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_4x4, componentName);
        this.f5512s = new k();
        this.f5513t = new b();
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        remoteViewsI.setImageViewBitmap(R(), I(context));
        y.d(context, remoteViewsI, M());
        this.f5512s.f(P1.a.a(), remoteViewsI, this.f5511r);
        this.f5513t.f(P1.a.a(), remoteViewsI, this.f5510q);
        return remoteViewsI;
    }

    @Override // V1.z
    protected View H(Context context) throws Resources.NotFoundException {
        HistogramView histogramViewK = K(context, R.layout.us_widget_4x4_histogram_legacy);
        new C0270i().a(histogramViewK);
        histogramViewK.setLayoutParams(new FrameLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x4_widget_histogram_view_width), 1073741824), View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_4x4_widget_histogram_view_height), 1073741824)));
        return histogramViewK;
    }

    protected int R() {
        return R.id.histogram_img;
    }

    public void S(List<C1257w> list) {
        this.f5511r = list;
    }

    public void T(List<C1216d> list) {
        this.f5510q = list;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        return new RemoteViews(context.getPackageName(), R.layout.us_digital_wellbeing_widget_4x4_legacy);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        UsingTimeStats[] usingTimeStatsArr = (UsingTimeStats[]) bundle.getParcelableArray("USING_TIME_STATS_ARRAY");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("APP_USAGE_LIMIT_DATA_LIST");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("CATEGORY_USAGE_LIMIT_DATA_LIST");
        Q(usingTimeStatsArr);
        T(parcelableArrayList);
        S(parcelableArrayList2);
        P(C0711p.l(C0712q.b(usingTimeStatsArr)));
        return zR;
    }

    @Override // V1.z, com.stepos.digitalwellbeing.appwidget.b
    public void s(Configuration configuration) {
        super.s(configuration);
        E(h(), g());
    }
}
