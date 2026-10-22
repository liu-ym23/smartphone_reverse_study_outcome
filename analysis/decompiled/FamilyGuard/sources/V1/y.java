package V1;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.stepos.familyguard.R;
import f2.C0702g;
import f2.C0711p;
import g2.C0736f;

/* loaded from: classes.dex */
public class y {
    private static String[] a(Context context, int i5) {
        return i5 < 1000 ? new String[]{String.valueOf(i5)} : i5 < 10000 ? new String[]{String.format("%.1f", Float.valueOf(i5 / 1000.0f)), context.getString(R.string.us_k)} : new String[]{String.format("%.1f", Float.valueOf(i5 / 10000.0f)), context.getString(R.string.us_w)};
    }

    public static void b(Context context, RemoteViews remoteViews, int i5) {
        if (C0736f.f17234e) {
            i5 = 25000;
        } else if (C0736f.f17233d) {
            i5 = 3100;
        }
        String[] strArrA = a(context, i5);
        C0702g.b("TotalUsageUpdater", "updateNotifyTimes() called with: context = [" + context + "], remoteViews = [" + remoteViews + "], notifyTimes = [" + i5 + "] strings = " + C0702g.h(strArrA));
        if (!TextUtils.equals("CN", context.getResources().getConfiguration().locale.getCountry())) {
            if (strArrA.length > 1) {
                remoteViews.setTextViewText(R.id.notify_times_label, strArrA[1]);
            } else {
                remoteViews.setTextViewText(R.id.notify_times_label, context.getString(R.string.us_widget_notification_label));
            }
            remoteViews.setTextViewText(R.id.notify_times_digit, strArrA[0]);
            return;
        }
        remoteViews.setTextViewText(R.id.notify_times_digit, strArrA[0]);
        if (strArrA.length > 1) {
            remoteViews.setTextViewText(R.id.notify_times_label, strArrA[1] + context.getString(R.string.us_widget_notification_label));
        } else {
            remoteViews.setTextViewText(R.id.notify_times_label, context.getString(R.string.us_widget_notification_label));
        }
        remoteViews.setTextViewText(R.id.notify_times_digit, strArrA[0]);
    }

    public static void c(Context context, RemoteViews remoteViews, int i5) {
        if (C0736f.f17234e) {
            i5 = 25000;
        } else if (C0736f.f17233d) {
            i5 = 3100;
        }
        String[] strArrA = a(context, i5);
        if (!TextUtils.equals("CN", context.getResources().getConfiguration().locale.getCountry())) {
            if (strArrA.length > 1) {
                remoteViews.setTextViewText(R.id.pickup_times_label, strArrA[1]);
            } else {
                remoteViews.setTextViewText(R.id.pickup_times_label, context.getString(R.string.us_widget_times));
            }
            remoteViews.setTextViewText(R.id.pickup_times_digit, strArrA[0]);
            return;
        }
        if (strArrA.length > 1) {
            remoteViews.setTextViewText(R.id.pickup_times_label, strArrA[1] + context.getString(R.string.us_widget_times));
        } else {
            remoteViews.setTextViewText(R.id.pickup_times_label, context.getString(R.string.us_widget_times));
        }
        remoteViews.setTextViewText(R.id.pickup_times_digit, strArrA[0]);
    }

    public static void d(Context context, RemoteViews remoteViews, long j5) throws Resources.NotFoundException {
        long jL = C0711p.l(j5);
        int iQ = C0711p.q(jL);
        int iR = C0711p.r(jL);
        int iW = C0711p.w(jL);
        String quantityString = context.getResources().getQuantityString(R.plurals.us_widget_hour, iQ);
        String quantityString2 = context.getResources().getQuantityString(R.plurals.us_widget_minute, iR);
        String quantityString3 = context.getResources().getQuantityString(R.plurals.us_widget_second, iW);
        if (iQ == 0) {
            remoteViews.setViewVisibility(R.id.hour_digit, 8);
            remoteViews.setViewVisibility(R.id.hour_label, 8);
        } else {
            remoteViews.setViewVisibility(R.id.hour_digit, 0);
            remoteViews.setViewVisibility(R.id.hour_label, 0);
            remoteViews.setTextViewText(R.id.hour_digit, String.valueOf(iQ));
            remoteViews.setTextViewText(R.id.hour_label, quantityString);
        }
        if (iR == 0 && iQ == 0) {
            remoteViews.setViewVisibility(R.id.minute_digit, 8);
            remoteViews.setViewVisibility(R.id.minute_label, 8);
        } else {
            remoteViews.setViewVisibility(R.id.minute_digit, 0);
            remoteViews.setViewVisibility(R.id.minute_label, 0);
            remoteViews.setTextViewText(R.id.minute_digit, String.valueOf(iR));
            remoteViews.setTextViewText(R.id.minute_label, quantityString2);
        }
        if (iQ > 0 || iR > 0) {
            remoteViews.setViewVisibility(R.id.second_digit, 8);
            remoteViews.setViewVisibility(R.id.second_label, 8);
        } else {
            remoteViews.setViewVisibility(R.id.second_digit, 0);
            remoteViews.setViewVisibility(R.id.second_label, 0);
            remoteViews.setTextViewText(R.id.second_digit, String.valueOf(iW));
            remoteViews.setTextViewText(R.id.second_label, quantityString3);
        }
    }
}
