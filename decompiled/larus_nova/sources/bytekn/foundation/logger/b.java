package bytekn.foundation.logger;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21804a;

    public b() {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logDebug(String r100, String r101) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logError(String r100, String r101) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logError(String r100, String r101, Throwable r102) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logWarn(String r100, String r101) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final boolean getEnabled() {
        return this.f21804a;
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void setEnabled(boolean r100) {
        this.f21804a = r100;
    }
}
