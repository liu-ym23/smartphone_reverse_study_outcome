package sd;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d0 extends b {

    /* renamed from: m, reason: collision with root package name */
    public final Socket f11924m;

    public d0(Socket socket) {
        this.f11924m = socket;
    }

    @Override // sd.b
    public final void k() throws IOException {
        Socket socket = this.f11924m;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!jd.b.y(e10)) {
                throw e10;
            }
            v.f11978a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        } catch (Exception e11) {
            v.f11978a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
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
