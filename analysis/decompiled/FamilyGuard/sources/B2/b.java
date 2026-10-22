package B2;

import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import f2.C0702g;
import f2.C0711p;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    public static void a() {
        e.e("digital_health_page_day_use", null, new Object[0]);
    }

    public static void b() {
        e.e("digital_health_page_week_use", null, new Object[0]);
    }

    private static int c(Map<String, Long> map, int i5) {
        Long l5;
        if (map == null || (l5 = map.get(W1.a.b(i5))) == null) {
            return 0;
        }
        return (int) C0711p.z(l5.longValue());
    }

    public static void d(int i5) {
        e.e("start_personal_health_management", new String[]{"status"}, Integer.valueOf(i5 - 1));
    }

    public static void e(int i5, int i6) {
        e.e("stop_personal_health_management", new String[]{"app_num", "type_num"}, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static void f(int i5) {
        e.e("click_personal_statistical", new String[]{"status"}, Integer.valueOf(i5));
    }

    public static void g(long j5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        e.e("system_use", new String[]{"date", "usage_time", "pickup_times", "notification_times", "social_media", "system_app", "shopping", "business", "financial", "tools", "life_services", "game", "news_reading", "others", "learning", "sports"}, Long.valueOf(j5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
    }

    public static void h(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            C0702g.p("HealthUsage", "reportSystemUsage statsDataSet = null");
            return;
        }
        Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
        int iC = c(categoryUsingTimeMap, 11);
        int iC2 = c(categoryUsingTimeMap, 1);
        int iC3 = c(categoryUsingTimeMap, 2);
        int iC4 = c(categoryUsingTimeMap, 3);
        int iC5 = c(categoryUsingTimeMap, 4);
        int iC6 = c(categoryUsingTimeMap, 5);
        int iC7 = c(categoryUsingTimeMap, 9);
        int iC8 = c(categoryUsingTimeMap, 7);
        int iC9 = c(categoryUsingTimeMap, 0);
        int iC10 = c(categoryUsingTimeMap, 6);
        int iC11 = c(categoryUsingTimeMap, 8);
        int iC12 = c(categoryUsingTimeMap, 10);
        g(statsDataSet.getStartTime(), (int) C0711p.z(statsDataSet.getUsingTime()), statsDataSet.getPickupTimes(), statsDataSet.getNotifyTimes(), iC5, iC, iC7, iC8, iC4, iC9, iC3, iC6, iC2, iC12, iC10, iC11);
    }

    public static void i(boolean z5, long j5, long j6, String str, boolean z6) {
        e.e("personal_app_set", new String[]{"enable", "workday_length", "offday_length", "app_name", "timeout_limit"}, Integer.valueOf(z5 ? 1 : 0), Long.valueOf(j5), Long.valueOf(j6), str, Integer.valueOf(z6 ? 1 : 0));
    }

    public static void j(boolean z5, long j5, long j6, int i5, boolean z6) {
        e.e("personal_apptype_set", new String[]{"enable", "workday_length", "offday_length", "type_name", "timeout_limit"}, Integer.valueOf(z5 ? 1 : 0), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i5), Integer.valueOf(z6 ? 1 : 0));
    }
}
