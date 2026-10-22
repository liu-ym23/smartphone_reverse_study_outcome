package ea;

import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f3744a = Boolean.FALSE;

    public static int a(ta.a aVar) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SharedPreferences sharedPreferences = aVar.f13291a;
        String string = sharedPreferences.getString("DAILY_ACTIVED_LAST", "");
        c.a("BootUpHelper", "beforeGetDailyActive ------------------ current states: today:" + str + ", last:" + string);
        if (str.equals(string)) {
            return 0;
        }
        c.d("BootUpHelper", "a new day");
        sharedPreferences.edit().putString("DAILY_ACTIVED_LAST", str).apply();
        return 1;
    }
}
