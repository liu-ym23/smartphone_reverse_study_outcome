package k3;

import f1.AbstractC0557a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.A, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0679A extends C0690e {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f13337a;

    public C0679A(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.f13337a = socket;
    }

    @Override // k3.C0690e
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // k3.C0690e
    public final void timedOut() throws IOException {
        Socket socket = this.f13337a;
        try {
            socket.close();
        } catch (AssertionError e4) {
            if (!AbstractC0557a.G(e4)) {
                throw e4;
            }
            s.f13375a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e4);
        } catch (Exception e5) {
            s.f13375a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e5);
        }
    }
}
