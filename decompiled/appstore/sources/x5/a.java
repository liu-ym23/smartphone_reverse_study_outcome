package x5;

import android.app.Instrumentation;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends Instrumentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f25430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25431b;

    static {
        f25430a = new ArrayList();
    }

    public a() {
    }

    public static void a(ExceptionCatcher r10) {
        if (Logger.b() == true) goto L5;
    L9:
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.registerCondition() == true) goto L14;
        return;
    L14:
        if (f25430a.contains(r10) == true) goto L18;
        f25430a.add(r10);
        return;
    L18:
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("register only in UI thread.");
    }

    public static void b() {
        if (f25431b == false) goto L13;
        return;
    L13:
        Object r10 = u5.a.c();     // Catch: Exception -> L10
        Field r11 = r10.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L10
        r11.setAccessible(true);     // Catch: Exception -> L10
        if ((r11.get(r10) instanceof a) == false) goto L8;
        return;
    L8:
        r11.set(r10, new a());     // Catch: Exception -> L10
        Logger.a("InstrumentationWrapper", "Fix success.");     // Catch: Exception -> L10
        f25431b = true;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.a("InstrumentationWrapper", e.getMessage());
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r10, Throwable r11) {
        Iterator r12 = f25430a.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        if (((ExceptionCatcher) r12.next()).analysis(r10, r11) == false) goto L4;
        return true;
    L10:
        return super.onException(r10, r11);
    }
}
