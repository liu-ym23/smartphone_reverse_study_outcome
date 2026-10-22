package i2;

import com.apm.insight.g;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import z2.b;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f4605a = new AtomicBoolean(false);

    public static boolean a() {
        AtomicBoolean atomicBoolean = f4605a;
        synchronized (atomicBoolean) {
            try {
                if (atomicBoolean.get()) {
                    return false;
                }
                atomicBoolean.set(true);
                return b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        if (b.a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1) {
            try {
                File file = new File(g.b.getFilesDir(), "apminsight/crashCommand");
                file.mkdirs();
                new File(file, "0_" + System.currentTimeMillis()).createNewFile();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
