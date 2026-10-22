package V1;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import f2.C0702g;
import f2.C0711p;
import x2.C1284b;

/* loaded from: classes.dex */
public class s extends z {

    /* renamed from: m, reason: collision with root package name */
    private long f5494m;

    /* renamed from: n, reason: collision with root package name */
    private int f5495n;

    /* renamed from: o, reason: collision with root package name */
    private int f5496o;

    /* renamed from: p, reason: collision with root package name */
    private StatsDataSet f5497p;

    /* renamed from: q, reason: collision with root package name */
    private C1284b f5498q;

    public s(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_2x2_TEXT, componentName);
    }

    private void O(Context context, RemoteViews remoteViews, boolean z5, boolean z6) throws Resources.NotFoundException {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Resources resources = context.getResources();
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.us_widget_des_text_size_small_grid);
        if (z6) {
            dimensionPixelSize = z5 ? resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_digit_text_size_small_grid_compact) : resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_digit_text_size_compact);
            dimensionPixelSize2 = z5 ? resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_label_text_size_small_grid_compact) : resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_label_text_size_compact);
        } else {
            dimensionPixelSize = z5 ? resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_digit_text_size_small_grid) : resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_usage_digit_text_size);
            dimensionPixelSize2 = z5 ? resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size_small_grid) : resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size);
        }
        int dimensionPixelSize4 = z5 ? resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_stats_digit_text_size_small_grid) : resources.getDimensionPixelSize(R.dimen.us_2x2_text_widget_stats_digit_text_size);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size);
        T1.g.d(context, remoteViews, R.id.usage_title, dimensionPixelSize3);
        T1.g.d(context, remoteViews, R.id.hour_digit, dimensionPixelSize);
        T1.g.d(context, remoteViews, R.id.minute_digit, dimensionPixelSize);
        T1.g.d(context, remoteViews, R.id.second_digit, dimensionPixelSize);
        T1.g.d(context, remoteViews, R.id.hour_label, dimensionPixelSize2);
        T1.g.d(context, remoteViews, R.id.minute_label, dimensionPixelSize2);
        T1.g.d(context, remoteViews, R.id.second_label, dimensionPixelSize2);
        T1.g.d(context, remoteViews, R.id.notify_times_digit, dimensionPixelSize4);
        T1.g.d(context, remoteViews, R.id.pickup_times_digit, dimensionPixelSize4);
        T1.g.d(context, remoteViews, R.id.notify_times_label, dimensionPixelSize5);
        T1.g.d(context, remoteViews, R.id.pickup_times_label, dimensionPixelSize5);
        T1.g.d(context, remoteViews, R.id.notify_times_des, dimensionPixelSize6);
        T1.g.d(context, remoteViews, R.id.pickup_times_des, dimensionPixelSize6);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        remoteViewsI.setImageViewBitmap(K(), I(context));
        y.d(context, remoteViewsI, N());
        y.c(context, remoteViewsI, M());
        y.b(context, remoteViewsI, L());
        long jL = C0711p.l(N());
        O(context, remoteViewsI, n(), C0711p.q(jL) > 0 && C0711p.r(jL) > 0);
        return remoteViewsI;
    }

    @Override // V1.z
    protected View H(Context context) throws Resources.NotFoundException {
        this.f5498q = new C1284b(context);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.us_2x2_text_widget_categorical_bar_view_width);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.us_2x2_text_widget_categorical_bar_view_height);
        this.f5498q.setLayoutParams(new FrameLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824), View.MeasureSpec.makeMeasureSpec(dimensionPixelSize2, 1073741824)));
        return this.f5498q;
    }

    @Override // V1.z
    protected void J() {
        StatsDataSet statsDataSet = this.f5497p;
        if (statsDataSet == null) {
            return;
        }
        z2.d dVar = new z2.d(statsDataSet);
        C0702g.b("DigitalWellbeingWidget2x2Text", "prepareImageData categoricalUsingTimesDataSet = " + dVar);
        this.f5498q.setCategoricalStats(dVar);
    }

    protected int K() {
        return R.id.progress_img;
    }

    public int L() {
        return this.f5496o;
    }

    public int M() {
        return this.f5495n;
    }

    public long N() {
        return this.f5494m;
    }

    public void P(int i5) {
        this.f5496o = i5;
    }

    public void Q(int i5) {
        this.f5495n = i5;
    }

    public void R(StatsDataSet statsDataSet) {
        this.f5497p = statsDataSet;
    }

    public void S(long j5) {
        this.f5494m = j5;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) throws Resources.NotFoundException {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), T1.b.i(context) ? n() ? R.layout.us_digital_wellbeing_widget_2x2_text_small_grid_red_flag : R.layout.us_digital_wellbeing_widget_2x2_text_red_flag : n() ? R.layout.us_digital_wellbeing_widget_2x2_text_small_grid : R.layout.us_digital_wellbeing_widget_2x2_text);
        O(context, remoteViews, n(), false);
        return remoteViews;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        if (zR) {
            StatsDataSet statsDataSet = (StatsDataSet) bundle.getParcelable("STATS_DATA_SET");
            R(statsDataSet);
            S(C0711p.l(statsDataSet == null ? 0L : statsDataSet.getUsingTime()));
            Q(bundle.getInt("PICKUP_TIMES"));
            P(bundle.getInt("NOTIFICATION_TIMES"));
        }
        return zR;
    }
}
