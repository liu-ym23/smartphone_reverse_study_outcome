package z7;

import M0.k;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* renamed from: z7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC2181b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f6974a;
    public final Socket b;
    public final /* synthetic */ AbstractC2188i c;

    public RunnableC2181b(AbstractC2188i abstractC2188i, InputStream inputStream, Socket socket) {
        this.c = abstractC2188i;
        this.f6974a = inputStream;
        this.b = socket;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        OutputStream outputStream;
        InputStream inputStream = this.f6974a;
        AbstractC2188i abstractC2188i = this.c;
        Socket socket = this.b;
        OutputStream outputStream2 = null;
        try {
            try {
                outputStream = socket.getOutputStream();
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            C2185f c2185f = new C2185f(abstractC2188i, new k(), this.f6974a, outputStream, socket.getInetAddress());
            while (!socket.isClosed()) {
                c2185f.d();
            }
            AbstractC2188i.d(outputStream);
        } catch (Exception e6) {
            e = e6;
            outputStream2 = outputStream;
            if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                AbstractC2188i.i.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
            }
            AbstractC2188i.d(outputStream2);
            AbstractC2188i.d(inputStream);
            AbstractC2188i.d(socket);
            abstractC2188i.e.a(this);
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            AbstractC2188i.d(outputStream2);
            AbstractC2188i.d(inputStream);
            AbstractC2188i.d(socket);
            abstractC2188i.e.a(this);
            throw th;
        }
        AbstractC2188i.d(inputStream);
        AbstractC2188i.d(socket);
        abstractC2188i.e.a(this);
    }
}
