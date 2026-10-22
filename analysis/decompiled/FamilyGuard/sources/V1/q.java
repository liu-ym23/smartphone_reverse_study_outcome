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
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0702g;
import f2.C0711p;
import java.util.Arrays;

/* loaded from: classes.dex */
public class q extends i {

    /* renamed from: q, reason: collision with root package name */
    private int f5492q;

    public q(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_2x2_HISTOGRAM, componentName);
    }

    private int R() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iQ = C0711p.q(jCurrentTimeMillis - C0711p.y());
        if (iQ + 1 < 12) {
            this.f5492q = 0;
        } else {
            this.f5492q = iQ - 11;
        }
        C0702g.b("DigitalWellbeingWidget2x2", "now = " + C0711p.j(jCurrentTimeMillis) + " hours = " + iQ + " startIndex " + this.f5492q);
        return this.f5492q;
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
        HistogramView histogramViewK = K(context, R.layout.us_widget_2x2_histogram);
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
        StatsDataSet statsDataSetL = L();
        C0702g.b("DigitalWellbeingWidget2x2", "prepareImageData");
        if (statsDataSetL == null) {
            return;
        }
        StatsDataSet[] children = statsDataSetL.getChildren();
        if (children == null || children.length == 0) {
            C0702g.O("DigitalWellbeingWidget2x2", "prepareImageData skip: empty children");
            return;
        }
        int[] iArrFindTopCategories = statsDataSetL.findTopCategories();
        long[] topCategoriesUsage = statsDataSetL.getTopCategoriesUsage();
        int iR = R();
        int iMin = Math.min(iR + 12, children.length);
        if (iR < iMin) {
            z2.d dVar = new z2.d((StatsDataSet[]) Arrays.copyOfRange(children, iR, iMin));
            dVar.t(iArrFindTopCategories);
            dVar.u(topCategoriesUsage);
            this.f5488p.setData(dVar);
            return;
        }
        C0702g.O("DigitalWellbeingWidget2x2", "prepareImageData skip: invalid range start=" + iR + " children=" + children.length);
    }

    protected int S() {
        return R.id.histogram_img;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        return new RemoteViews(context.getPackageName(), T1.b.i(context) ? n() ? R.layout.us_digital_wellbeing_widget_2x2_histogram_small_grid_red_flag : R.layout.us_digital_wellbeing_widget_2x2_histogram_red_flag : n() ? R.layout.us_digital_wellbeing_widget_2x2_histogram_small_grid : R.layout.us_digital_wellbeing_widget_2x2_histogram);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        if (zR) {
            StatsDataSet statsDataSet = (StatsDataSet) bundle.getParcelable("STATS_DATA_SET");
            long usingTime = statsDataSet == null ? 0L : statsDataSet.getUsingTime();
            O(statsDataSet);
            P(C0711p.l(usingTime));
        }
        return zR;
    }
}
