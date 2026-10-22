package Y1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.j;
import com.stepos.familyguard.R;
import f2.C0702g;
import f2.C0711p;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class n {
    private static int a(String str, String str2, long j5) {
        return (((str + "|" + str2 + "|" + j5).hashCode() & Integer.MAX_VALUE) % 900000) + 1000;
    }

    private static void b(Context context, NotificationManager notificationManager) {
        if (notificationManager.getNotificationChannel("digital_wellbeing_limit_alert") == null) {
            NotificationChannel notificationChannel = new NotificationChannel("digital_wellbeing_limit_alert", context.getString(R.string.fg_digital_health), 4);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setDescription(context.getString(R.string.us_usage_notify_message));
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static void c(Context context, long j5, PendingIntent pendingIntent, int i5) {
        String string;
        String string2;
        C0702g.b("NotifyHelper", "notifyGlobalPeriodApproach adminId=" + j5 + " type=" + i5);
        String string3 = context.getString(R.string.mm_system);
        if (i5 == 1) {
            string = context.getString(R.string.us_notify_title, string3, BuildConfig.FLAVOR, C0711p.n(context, 60000L, true));
            string2 = context.getString(R.string.us_period_notify_message);
        } else {
            string = context.getString(R.string.mm_global_overtime_limit_dialog_message);
            string2 = context.getString(R.string.us_notify_close_period_message, string3, BuildConfig.FLAVOR);
        }
        f(context, string, string2, pendingIntent, j5);
    }

    public static void d(Context context, int i5, String str, String str2, long j5, int i6, long j6, PendingIntent pendingIntent) {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyLimitApproach reason=");
        sb.append(i5);
        sb.append(" type=");
        sb.append(i6);
        sb.append(" label=");
        sb.append(i5 == 2 ? "phone" : str != null ? str : str2);
        sb.append(" limitTime=");
        sb.append(j5);
        sb.append(" adminId=");
        sb.append(j6);
        C0702g.b("NotifyHelper", sb.toString());
        boolean z5 = false;
        if (i5 == 2) {
            str = context.getString(R.string.mm_phone);
        } else if (i5 == 1) {
            z5 = true;
        } else {
            str = str2;
        }
        String strN = C0711p.n(context, 60000L, true);
        String string3 = BuildConfig.FLAVOR;
        if (i6 == 2) {
            if (z5) {
                string3 = context.getString(R.string.us_notify_category);
            }
            string = context.getString(R.string.us_usage_notify_only_title, str, string3);
            string2 = context.getString(R.string.us_notify_only_message);
        } else if (i6 == 1) {
            if (z5) {
                string3 = context.getString(R.string.us_notify_category);
            }
            string = context.getString(R.string.us_notify_title, str, string3, strN);
            string2 = context.getString(R.string.us_usage_notify_message);
        } else {
            string = context.getString(R.string.us_notify_close_title, z5 ? context.getString(R.string.us_most_frequently_used_category) : context.getString(R.string.us_most_frequently_used_app));
            if (z5) {
                string3 = context.getString(R.string.us_notify_category);
            }
            string2 = context.getString(R.string.us_notify_close_usage_message, str, string3);
        }
        f(context, string, string2, pendingIntent, j6);
    }

    public static void e(Context context, boolean z5, String str, String str2, int i5, long j5, PendingIntent pendingIntent) {
        Context context2;
        String str3;
        String str4;
        String string;
        String string2;
        C0702g.b("NotifyHelper", "notifyPeriodApproach isCategory=" + z5 + " categoryName=" + str + " appLabel=" + str2 + " type=" + i5 + " admin=" + j5);
        if (!z5) {
            str = str2;
        }
        String string3 = BuildConfig.FLAVOR;
        if (i5 == 2) {
            if (z5) {
                string3 = context.getString(R.string.us_notify_category);
            }
            string = context.getString(R.string.us_period_notify_only_title, str, string3);
            string2 = context.getString(R.string.us_notify_only_message);
        } else {
            if (i5 != 1) {
                String string4 = context.getString(R.string.us_notify_close_title, z5 ? context.getString(R.string.us_most_frequently_used_category) : context.getString(R.string.us_most_frequently_used_app));
                if (z5) {
                    string3 = context.getString(R.string.us_notify_category);
                }
                String string5 = context.getString(R.string.us_notify_close_period_message, str, string3);
                context2 = context;
                str3 = string5;
                str4 = string4;
                f(context2, str4, str3, pendingIntent, j5);
            }
            if (z5) {
                string3 = context.getString(R.string.us_notify_category);
            }
            string = context.getString(R.string.us_notify_title, str, string3, C0711p.n(context, 60000L, true));
            string2 = context.getString(R.string.us_period_notify_message);
        }
        context2 = context;
        str4 = string;
        str3 = string2;
        f(context2, str4, str3, pendingIntent, j5);
    }

    private static void f(Context context, String str, String str2, PendingIntent pendingIntent, long j5) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        if (!androidx.core.app.m.b(context).a()) {
            C0702g.O("NotifyHelper", "postLimitNotification notifications disabled for app");
            return;
        }
        b(context, notificationManager);
        j.d dVarQ = new j.d(context, "digital_wellbeing_limit_alert").o(R.drawable.fg_status_icon).i(str).h(str2).p(new j.b().h(str2)).g(pendingIntent).e(true).l(true).m(1).f("reminder").j(-1).r(1).s(System.currentTimeMillis()).n(true).q(str);
        if (j5 == -1) {
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", context.getText(R.string.us_usage_statistics).toString());
            dVarQ.a(bundle);
        }
        int iA = a(str, str2, j5);
        notificationManager.notify("dw_limit_approach", iA, dVarQ.b());
        C0702g.b("NotifyHelper", "postLimitNotification posted id=" + iA + " title=" + str);
    }
}
