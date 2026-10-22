package J6;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f3735a;

    public static boolean a(Context context) {
        if (f3735a == null) {
            try {
                String strA = f.a(context, "ro.build.characteristics");
                if (TextUtils.isEmpty(strA) || !"tablet".equals(strA)) {
                    f3735a = Boolean.FALSE;
                } else {
                    f3735a = Boolean.TRUE;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                f3735a = Boolean.FALSE;
            }
        }
        return f3735a.booleanValue();
    }

    public static synchronized boolean b() {
        "StepX".equalsIgnoreCase(Build.BRAND);
        return true;
    }
}
