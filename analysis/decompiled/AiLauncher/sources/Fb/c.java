package Fb;

import La.H;
import La.K;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.z;
import xb.C5873d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001a¨\u0006\u001c"}, d2 = {"LFb/c;", "", "<init>", "()V", "", "loggerName", "", "logLevel", "message", "", "t", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "logger", "tag", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "configuredLoggers", "", "Ljava/util/Map;", "knownLoggers", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2742a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Map<String, String> knownLoggers;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = z.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(z.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Bb.b.class.getName(), "okhttp.Http2");
        linkedHashMap.put(C5873d.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = kotlin.collections.a.A(linkedHashMap);
    }

    public final void a(String loggerName, int logLevel, String message, Throwable t10) {
        int iMin;
        p.i(loggerName, "loggerName");
        p.i(message, "message");
        String strD = d(loggerName);
        if (Log.isLoggable(strD, logLevel)) {
            if (t10 != null) {
                message = message + '\n' + Log.getStackTraceString(t10);
            }
            String str = message;
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int iT0 = H.t0(str, '\n', i10, false, 4, null);
                if (iT0 == -1) {
                    iT0 = length;
                }
                while (true) {
                    iMin = Math.min(iT0, i10 + 4000);
                    String strSubstring = str.substring(i10, iMin);
                    p.h(strSubstring, "substring(...)");
                    Log.println(logLevel, strD, strSubstring);
                    if (iMin >= iT0) {
                        break;
                    } else {
                        i10 = iMin;
                    }
                }
                i10 = iMin + 1;
            }
        }
    }

    public final void b() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                c(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e10) {
            System.err.println("Possibly running android unit test without robolectric");
            e10.printStackTrace();
        } catch (UnsatisfiedLinkError e11) {
            System.err.println("Possibly running android unit test without robolectric");
            e11.printStackTrace();
        }
    }

    public final void c(String logger, String tag) throws SecurityException {
        Logger logger2 = Logger.getLogger(logger);
        if (configuredLoggers.add(logger2)) {
            logger2.setUseParentHandlers(false);
            logger2.setLevel(Log.isLoggable(tag, 3) ? Level.FINE : Log.isLoggable(tag, 4) ? Level.INFO : Level.WARNING);
            logger2.addHandler(d.f2745a);
        }
    }

    public final String d(String loggerName) {
        String str = knownLoggers.get(loggerName);
        return str == null ? K.R1(loggerName, 23) : str;
    }
}
