package n3;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import h3.C0611u;

/* renamed from: n3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0783d {

    /* renamed from: a, reason: collision with root package name */
    public static final q3.a f13669a;

    static {
        try {
            f13669a = new LogbackMDCAdapter();
        } catch (Exception e4) {
            com.stepos.statsrpk.c.K("MDC binding unsuccessful.", e4);
        } catch (NoClassDefFoundError e5) {
            f13669a = new C0611u(19);
            String message = e5.getMessage();
            if (message == null || message.indexOf("StaticMDCBinder") == -1) {
                throw e5;
            }
            com.stepos.statsrpk.c.J("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            com.stepos.statsrpk.c.J("Defaulting to no-operation MDCAdapter implementation.");
            com.stepos.statsrpk.c.J("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        }
    }

    public static void a(String str, String str2) {
        q3.a aVar = f13669a;
        if (aVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        aVar.put(str, str2);
    }

    public static void b(String str) {
        q3.a aVar = f13669a;
        if (aVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        aVar.remove(str);
    }
}
