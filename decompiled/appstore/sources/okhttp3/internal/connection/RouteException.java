package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class RouteException extends RuntimeException {
    private static final Method addSuppressedExceptionMethod = null;
    private IOException lastException;

    static {
        Method r10 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: Exception -> L5
    L6:
        addSuppressedExceptionMethod = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public RouteException(IOException r10) {
        super(r10);
        this.lastException = r10;
    }

    private void addSuppressedIfPossible(IOException r10, IOException r11) {
        Method r12 = addSuppressedExceptionMethod;
        if (r12 == null) goto L9;
        r12.invoke(r10, new Object[]{r11});     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public void addConnectException(IOException r10) {
        addSuppressedIfPossible(r10, this.lastException);
        this.lastException = r10;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }
}
