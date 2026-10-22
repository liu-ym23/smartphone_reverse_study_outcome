package f2;

import android.content.Context;
import android.provider.Settings;

/* renamed from: f2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0700e {
    public static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "stepos_device_name");
    }
}
