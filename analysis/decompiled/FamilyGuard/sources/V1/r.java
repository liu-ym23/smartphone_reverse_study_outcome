package V1;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0702g;
import f2.C0711p;
import f2.C0712q;
import java.util.Arrays;

/* loaded from: classes.dex */
public class r extends i {

    /* renamed from: q, reason: collision with root package name */
    private int f5493q;

    public r(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_2x2_HISTOGRAM, componentName);
    }

    private int R() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iQ = C0711p.q(jCurrentTimeMillis - C0711p.y());
        int i5 = iQ + 1;
        int i6 = n() ? 8 : 12;
        if (i5 < i6) {
            this.f5493q = 0;
        } else {
            this.f5493q = i5 - i6;
        }
        C0702g.b("DigitalWellbeingWidget2x2", "now = " + C0711p.j(jCurrentTimeMillis) + " hours = " + iQ + " startIndex " + this.f5493q);
        return this.f5493q;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        remoteViewsI.setImageViewBitmap(S(), I(context));
        y.d(context, remoteViewsI, M());
        return remoteViewsI;
    }

    @Override // V1.z
    protected View H(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        HistogramView histogramViewK = K(context, R.layout.us_widget_2x2_histogram_legacy);
        int iR = R();
        String[] strArr = {C0711p.e(context, iR + 6, true), C0711p.e(context, iR + 12, true)};
        String[] strArr2 = {"60" + resources.getString(R.string.us_minute), "30" + resources.getString(R.string.us_minute), "0" + resources.getString(R.string.us_minute)};
        histogramViewK.setXDimensionStrings(strArr);
        histogramViewK.setYDimensionStrings(strArr2);
        histogramViewK.setXDimensionIndexArray(new int[]{1, 2});
        histogramViewK.setYDimensionIndexArray(new int[]{0, 1, 2});
        histogramViewK.setXSegmentDividerPathEffect(new DashPathEffect(HistogramView.f15231g0, 0.0f));
        histogramViewK.setLayoutParams(new FrameLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_2x2_widget_histogram_view_width), 1073741824), View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(R.dimen.us_2x2_widget_histogram_view_height), 1073741824)));
        return histogramViewK;
    }

    @Override // V1.i, V1.z
    protected void J() {
        UsingTimeStats[] usingTimeStatsArrN = N();
        C0702g.b("DigitalWellbeingWidget2x2", "prepareImageData");
        int iR = R();
        this.f5488p.setData((UsingTimeStats[]) Arrays.copyOfRange(usingTimeStatsArrN, iR, iR + 12));
    }

    protected int S() {
        return R.id.histogram_img;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        return new RemoteViews(context.getPackageName(), n() ? R.layout.us_digital_wellbeing_widget_2x2_histogram_small_grid_legacy : R.layout.us_digital_wellbeing_widget_2x2_histogram_legacy);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        if (zR) {
            UsingTimeStats[] usingTimeStatsArr = (UsingTimeStats[]) bundle.getParcelableArray("USING_TIME_STATS_ARRAY");
            Q(usingTimeStatsArr);
            P(C0711p.l(C0712q.b(usingTimeStatsArr)));
        }
        return zR;
    }
}
