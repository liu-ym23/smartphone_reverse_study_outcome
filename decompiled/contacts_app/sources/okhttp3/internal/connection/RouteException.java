package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public RouteException(IOException r1) {
        super(r1);
        this.firstException = r1;
        this.lastException = r1;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public void addConnectException(IOException r2) {
        Util.addSuppressedIfPossible(this.firstException, r2);
        this.lastException = r2;
    }
}
