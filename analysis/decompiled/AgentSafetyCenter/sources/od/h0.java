package od;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends d {

    /* renamed from: m, reason: collision with root package name */
    public Socket f9452m;

    @Override // od.d
    public final void j() throws IOException {
        Socket socket = this.f9452m;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!ac.a.A(e10)) {
                throw e10;
            }
            x.f9494a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        } catch (Exception e11) {
            x.f9494a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
