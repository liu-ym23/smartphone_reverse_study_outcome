package p3;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.status.StatusUtil;
import ch.qos.logback.core.util.StatusPrinter;
import com.stepos.statsrpk.c;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f13931d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f13932e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f13933a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LoggerContext f13934b;

    /* renamed from: c, reason: collision with root package name */
    public final ContextSelectorStaticBinder f13935c;

    static {
        a aVar = new a();
        f13931d = aVar;
        f13932e = new Object();
        LoggerContext loggerContext = aVar.f13934b;
        try {
            try {
                new ContextInitializer(loggerContext).autoConfig();
            } catch (JoranException e4) {
                c.K("Failed to auto configure default logger context", e4);
            }
            if (!StatusUtil.contextHasStatusListener(loggerContext)) {
                StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
            }
            aVar.f13935c.init(loggerContext, f13932e);
            aVar.f13933a = true;
        } catch (Throwable th) {
            c.K("Failed to instantiate [" + LoggerContext.class.getName() + "]", th);
        }
    }

    public a() throws IllegalStateException {
        LoggerContext loggerContext = new LoggerContext();
        this.f13934b = loggerContext;
        this.f13935c = ContextSelectorStaticBinder.getSingleton();
        loggerContext.setName("default");
    }
}
