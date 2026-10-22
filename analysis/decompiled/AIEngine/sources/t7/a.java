package t7;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {
    public static void a(Context context, String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putInt(a0.a.j(str, ".push_id_expire_time"), i10).apply();
    }

    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putString(a0.a.j(str, ".push_id"), str2).apply();
    }
}
