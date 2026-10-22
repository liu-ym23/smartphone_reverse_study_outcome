package t5;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public a() {
    }

    public boolean a(Application r10) {
        Field r11 = Class.forName("android.app.ActivityThread").getDeclaredField("mInitialApplication");     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        r11.set(u5.a.c(), r10);     // Catch: Exception -> L4
        return true;
    L4:
        Logger.c("HookActivityThreadSetInitialApplication", "WebView hook fix ANR fail.");
        return false;
    }
}
