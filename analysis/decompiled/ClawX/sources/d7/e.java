package d7;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends c7.d {

    /* renamed from: n, reason: collision with root package name */
    public final Socket f1934n;

    public e(Socket socket) {
        this.f1934n = socket;
    }

    @Override // c7.d
    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // c7.d
    public final void l() throws IOException {
        Socket socket = this.f1934n;
        try {
            socket.close();
        } catch (AssertionError e9) {
            if (!f.a(e9)) {
                throw e9;
            }
            f.f1935a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e9);
        } catch (Exception e10) {
            f.f1935a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        }
    }
}
