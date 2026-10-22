package e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes4.dex */
final class z extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Socket f38767a;

    public z(Socket r2) {
        d.h.b.o.e(r2, "socket");
        this.f38767a = r2;
    }

    @Override // e.c
    public IOException a(IOException r3) {
        SocketTimeoutException r2 = new SocketTimeoutException("timeout");
        if (r3 == null) goto L6;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    L6:
        return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin");
    }

    @Override // e.c
    public void a() {
        this.f38767a.close();     // Catch: AssertionError -> L5 Exception -> L10
    L16:
        return;
    L5:
        e = move-exception;
        if (o.a(e) == false) goto L9;
        p.a().log(Level.WARNING, "Failed to close timed out socket " + this.f38767a, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        throw e;
    L10:
        e = move-exception;
        p.a().log(Level.WARNING, "Failed to close timed out socket " + this.f38767a, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
