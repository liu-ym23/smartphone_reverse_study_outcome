package Nb;

import Mb.C0964b;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LNb/m;", "LMb/b;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "Ljava/io/IOException;", "cause", "w", "(Ljava/io/IOException;)Ljava/io/IOException;", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "q", "Ljava/net/Socket;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class m extends C0964b {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Socket socket;

    public m(Socket socket) {
        kotlin.jvm.internal.p.i(socket, "socket");
        this.socket = socket;
    }

    @Override // Mb.C0964b
    public void A() throws IOException {
        try {
            this.socket.close();
        } catch (AssertionError e10) {
            if (!t.b(e10)) {
                throw e10;
            }
            t.f5098a.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e10);
        } catch (Exception e11) {
            t.f5098a.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e11);
        }
    }

    @Override // Mb.C0964b
    public IOException w(IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }
}
