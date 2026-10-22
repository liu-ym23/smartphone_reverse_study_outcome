package ob;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class j0 extends f {

    /* renamed from: m, reason: collision with root package name */
    public final Socket f7996m;

    public j0(Socket socket) {
        this.f7996m = socket;
    }

    @Override // ob.f
    public final void k() throws IOException {
        Socket socket = this.f7996m;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!b.f(e10)) {
                throw e10;
            }
            x.f8039a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        } catch (Exception e11) {
            x.f8039a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
        }
    }

    public final IOException l(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
