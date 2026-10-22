package V9;

import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class v extends d {
    public final Socket m;

    public v(Socket socket) {
        this.m = socket;
    }

    @Override // V9.d
    public final void j() throws IOException {
        Socket socket = this.m;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!M0.i.y(e)) {
                throw e;
            }
            o.f1422a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e6) {
            o.f1422a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e6);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(InjectExperienceResult.REASON_TIMEOUT);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
