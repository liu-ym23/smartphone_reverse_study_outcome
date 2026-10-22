package fg;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends AsyncTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f19726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Socket f19727b;

    public r(Socket r10) {
        kotlin.jvm.internal.q.h(r10, "socket");
        this.f19727b = r10;
        this.f19726a = Logger.getLogger("okio.Okio");
    }

    @Override // okio.AsyncTimeout
    public IOException newTimeoutException(IOException r10) {
        SocketTimeoutException r11 = new SocketTimeoutException("timeout");
        if (r10 == null) goto L5;
        r11.initCause(r10);
    L5:
        return r11;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        this.f19727b.close();     // Catch: AssertionError -> L5 Exception -> L7
    L18:
        return;
    L5:
        e = move-exception;
        if (j.e(e) == false) goto L12;
        this.f19726a.log(Level.WARNING, "Failed to close timed out socket " + this.f19727b, e);
        return;
    L12:
        throw e;
    L7:
        e = move-exception;
        this.f19726a.log(Level.WARNING, "Failed to close timed out socket " + this.f19727b, e);
    }
}
