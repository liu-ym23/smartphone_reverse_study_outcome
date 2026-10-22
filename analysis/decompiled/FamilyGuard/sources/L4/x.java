package L4;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class x extends d {

    /* renamed from: m, reason: collision with root package name */
    private final Logger f3986m;

    /* renamed from: n, reason: collision with root package name */
    private final Socket f3987n;

    public x(Socket socket) {
        j4.k.h(socket, "socket");
        this.f3987n = socket;
        this.f3986m = Logger.getLogger("okio.Okio");
    }

    @Override // L4.d
    protected IOException u(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // L4.d
    protected void y() throws IOException {
        try {
            this.f3987n.close();
        } catch (AssertionError e6) {
            if (!o.c(e6)) {
                throw e6;
            }
            this.f3986m.log(Level.WARNING, "Failed to close timed out socket " + this.f3987n, (Throwable) e6);
        } catch (Exception e7) {
            this.f3986m.log(Level.WARNING, "Failed to close timed out socket " + this.f3987n, (Throwable) e7);
        }
    }
}
