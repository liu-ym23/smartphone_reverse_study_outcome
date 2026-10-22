package bytekn.foundation.logger;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lbytekn/foundation/logger/Logger;", "", "", "tag", "getTagWithSDK", "Lbytekn/foundation/logger/ILogger;", "logger", "", "setLogger", "message", "d", "w", "", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "e", "La0/b;", "platformLogger", "La0/b;", "SDK_TAG", "Ljava/lang/String;", "", "value", "getEnabled", "()Z", "setEnabled", "(Z)V", "enabled", "<init>", "()V", "kn_common_release"}, k = 1, mv = {1, 4, 0})
public final class Logger {
    public static final Logger INSTANCE = null;
    private static final String SDK_TAG = "EPKN.";
    private static a0.b<ILogger> platformLogger;

    private Logger() {
    }

    static {
        INSTANCE = new Logger();
        platformLogger = new a0.b(new b());
    }

    public final boolean getEnabled() {
        return platformLogger.f1239a.getEnabled();
    }

    private final String getTagWithSDK(String r100) {
        return "EPKN.-" + r100;
    }

    public final void setEnabled(final boolean r100) {
        a0.b<ILogger> r101 = platformLogger;
        new Logger$enabled$1(r100).invoke(r101.f1239a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLogger(ILogger r100) {
        platformLogger.f1239a = r100;
    }

    public final void d(String r100, String r101) {
        if (getEnabled() == false) goto L6;
        platformLogger.f1239a.logDebug(getTagWithSDK(r100), r101);
        return;
    }

    public final void w(String r100, String r101) {
        if (getEnabled() == false) goto L6;
        platformLogger.f1239a.logWarn(getTagWithSDK(r100), r101);
        return;
    }

    public final void e(String r100, String r101, Throwable r102) {
        if (r102 == null) goto L4;
        platformLogger.f1239a.logError(INSTANCE.getTagWithSDK(r100), r101, r102);
        return;
    L4:
        platformLogger.f1239a.logError(getTagWithSDK(r100), r101);
    }

    public static /* synthetic */ void e$default(Logger r100, String r101, String r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.e(r101, r102, r103);
    }
}
