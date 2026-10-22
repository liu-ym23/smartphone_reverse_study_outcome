package stepai.android.logger;

import H4.o;
import Ka.a;
import Ka.b;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lstepai/android/logger/Logger;", "Lstepai/android/logger/ILogger;", AppAgent.CONSTRUCT, "()V", "logger", "LC7/r;", "addLogger", "(Lstepai/android/logger/ILogger;)V", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "i", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "e", "w", "v", "vendorDid", "()Ljava/lang/String;", "", "loggers", "Ljava/util/List;", "logger_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Logger implements ILogger {
    public static final Logger INSTANCE = new Logger();
    private static final List<ILogger> loggers = o.Q(a.f916a);

    private Logger() {
    }

    public final void addLogger(ILogger logger) {
        k.f(logger, "logger");
        loggers.add(logger);
    }

    @Override // stepai.android.logger.ILogger
    public void d(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Iterator<T> it = loggers.iterator();
        while (it.hasNext()) {
            ((ILogger) it.next()).d(tag, msg);
        }
    }

    @Override // stepai.android.logger.ILogger
    public void e(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Iterator<T> it = loggers.iterator();
        while (it.hasNext()) {
            ((ILogger) it.next()).e(tag, msg);
        }
    }

    @Override // stepai.android.logger.ILogger
    public void i(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Iterator<T> it = loggers.iterator();
        while (it.hasNext()) {
            ((ILogger) it.next()).i(tag, msg);
        }
    }

    @Override // stepai.android.logger.ILogger
    public void v(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Iterator<T> it = loggers.iterator();
        while (it.hasNext()) {
            ((ILogger) it.next()).v(tag, msg);
        }
    }

    @Override // stepai.android.logger.ILogger
    public String vendorDid() {
        int i = b.f917a;
        return "";
    }

    @Override // stepai.android.logger.ILogger
    public void w(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Iterator<T> it = loggers.iterator();
        while (it.hasNext()) {
            ((ILogger) it.next()).w(tag, msg);
        }
    }
}
