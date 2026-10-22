package V1;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import f2.C0711p;
import f2.C0712q;

/* loaded from: classes.dex */
public class t extends com.stepos.digitalwellbeing.appwidget.b {

    /* renamed from: k, reason: collision with root package name */
    private long f5499k;

    /* renamed from: l, reason: collision with root package name */
    private int f5500l;

    /* renamed from: m, reason: collision with root package name */
    private int f5501m;

    public t(Context context, ComponentName componentName) {
        super(context, A.DIGITAL_WELLBEING_2x2_TEXT, componentName);
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews G(Context context, AppWidgetManager appWidgetManager) throws Resources.NotFoundException {
        RemoteViews remoteViewsI = i(context);
        if (!m()) {
            return remoteViewsI;
        }
        y.d(context, remoteViewsI, J());
        y.c(context, remoteViewsI, I());
        y.b(context, remoteViewsI, H());
        return remoteViewsI;
    }

    public int H() {
        return this.f5501m;
    }

    public int I() {
        return this.f5500l;
    }

    public long J() {
        return this.f5499k;
    }

    public void K(int i5) {
        this.f5501m = i5;
    }

    public void L(int i5) {
        this.f5500l = i5;
    }

    public void M(long j5) {
        this.f5499k = j5;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public RemoteViews i(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), n() ? R.layout.us_digital_wellbeing_widget_2x2_text_small_grid : R.layout.us_digital_wellbeing_widget_2x2_text);
        Resources resources = context.getResources();
        if (n()) {
            T1.g.d(context, remoteViews, R.id.usage_title, resources.getDimensionPixelSize(R.dimen.us_widget_des_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.hour_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.minute_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.second_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.hour_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.minute_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.second_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.notify_times_digit, resources.getDimensionPixelSize(R.dimen.us_2x2_widget_text_small_digit_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.pickup_times_digit, resources.getDimensionPixelSize(R.dimen.us_2x2_widget_text_small_digit_text_size_small_grid));
            T1.g.d(context, remoteViews, R.id.notify_times_label, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
            T1.g.d(context, remoteViews, R.id.pickup_times_label, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
            T1.g.d(context, remoteViews, R.id.notify_times_des, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
            T1.g.d(context, remoteViews, R.id.pickup_times_des, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
            return remoteViews;
        }
        T1.g.d(context, remoteViews, R.id.usage_title, resources.getDimensionPixelSize(R.dimen.us_widget_des_text_size_small_grid));
        T1.g.d(context, remoteViews, R.id.hour_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size));
        T1.g.d(context, remoteViews, R.id.minute_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size));
        T1.g.d(context, remoteViews, R.id.second_digit, resources.getDimensionPixelSize(R.dimen.us_widget_digit_text_size));
        T1.g.d(context, remoteViews, R.id.hour_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size));
        T1.g.d(context, remoteViews, R.id.minute_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size));
        T1.g.d(context, remoteViews, R.id.second_label, resources.getDimensionPixelSize(R.dimen.us_widget_title_text_size));
        T1.g.d(context, remoteViews, R.id.notify_times_digit, resources.getDimensionPixelSize(R.dimen.us_2x2_widget_text_small_digit_text_size));
        T1.g.d(context, remoteViews, R.id.pickup_times_digit, resources.getDimensionPixelSize(R.dimen.us_2x2_widget_text_small_digit_text_size));
        T1.g.d(context, remoteViews, R.id.notify_times_label, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
        T1.g.d(context, remoteViews, R.id.pickup_times_label, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
        T1.g.d(context, remoteViews, R.id.notify_times_des, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
        T1.g.d(context, remoteViews, R.id.pickup_times_des, resources.getDimensionPixelSize(R.dimen.us_2x2_text_small_widget_label_text_size));
        return remoteViews;
    }

    @Override // com.stepos.digitalwellbeing.appwidget.b
    protected boolean r(Bundle bundle) {
        boolean zR = super.r(bundle);
        M(C0711p.l(C0712q.b((UsingTimeStats[]) bundle.getParcelableArray("USING_TIME_STATS_ARRAY"))));
        int i5 = bundle.getInt("NOTIFICATION_TIMES");
        int i6 = bundle.getInt("PICKUP_TIMES");
        R1.a.a("DigitalWellbeingWidget2x2Text", "onBindData notifyTotal = " + i5 + " pickupTotal = " + i6);
        K(i5);
        L(i6);
        return zR;
    }
}
