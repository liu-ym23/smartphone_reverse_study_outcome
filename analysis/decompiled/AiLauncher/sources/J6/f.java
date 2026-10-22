package J6;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class f {
    public static String a(Context context, String str) throws ClassNotFoundException, IllegalArgumentException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            Method methodC = d.a().c(clsLoadClass, "get", String.class);
            return methodC == null ? "" : (String) methodC.invoke(clsLoadClass, str);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return "";
        }
    }
}
