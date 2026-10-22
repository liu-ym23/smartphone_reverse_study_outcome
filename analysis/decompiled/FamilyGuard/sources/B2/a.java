package B2;

/* loaded from: classes.dex */
public class a {
    public static void a(int i5) {
        e.e("start_family_health_management", new String[]{"status"}, Integer.valueOf(i5 - 1));
    }

    public static void b(int i5, int i6) {
        e.e("stop_family_health_management", new String[]{"app_num", "type_num"}, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static void c(int i5) {
        e.e("click_family_statistical", new String[]{"status"}, Integer.valueOf(i5));
    }

    public static void d(boolean z5, long j5, long j6, String str, boolean z6, int i5) {
        e.e("family_app_set", new String[]{"enable", "workday_length", "offday_length", "app_name", "timeout_limit", "role"}, Integer.valueOf(z5 ? 1 : 0), Long.valueOf(j5), Long.valueOf(j6), str, Integer.valueOf(z6 ? 1 : 0), Integer.valueOf(i5));
    }

    public static void e(boolean z5, long j5, long j6, int i5, boolean z6, int i6) {
        e.e("family_apptype_set", new String[]{"enable", "workday_length", "offday_length", "type_name", "timeout_limit", "role"}, Integer.valueOf(z5 ? 1 : 0), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i5), Integer.valueOf(z6 ? 1 : 0), Integer.valueOf(i6));
    }
}
