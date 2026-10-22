package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import v.c;

/* JADX INFO: loaded from: classes28.dex */
public class CancellationToken {
    private final CancellationTokenSource tokenSource;

    public boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())});
    }

    public CancellationToken(CancellationTokenSource r100) {
        this.tokenSource = r100;
    }

    public c register(Runnable r100) {
        return this.tokenSource.register(r100);
    }
}
