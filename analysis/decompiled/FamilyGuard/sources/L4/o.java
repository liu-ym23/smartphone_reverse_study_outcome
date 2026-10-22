package L4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import r4.C1031n;

/* loaded from: classes.dex */
public final class o {
    public static final f a(w wVar) {
        j4.k.h(wVar, "$receiver");
        return new r(wVar);
    }

    public static final g b(y yVar) {
        j4.k.h(yVar, "$receiver");
        return new s(yVar);
    }

    public static final boolean c(AssertionError assertionError) {
        j4.k.h(assertionError, "$receiver");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? C1031n.u(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final w d(Socket socket) throws IOException {
        j4.k.h(socket, "$receiver");
        x xVar = new x(socket);
        OutputStream outputStream = socket.getOutputStream();
        j4.k.c(outputStream, "getOutputStream()");
        return xVar.w(new q(outputStream, xVar));
    }

    public static final y e(InputStream inputStream) {
        j4.k.h(inputStream, "$receiver");
        return new n(inputStream, new z());
    }

    public static final y f(Socket socket) throws IOException {
        j4.k.h(socket, "$receiver");
        x xVar = new x(socket);
        InputStream inputStream = socket.getInputStream();
        j4.k.c(inputStream, "getInputStream()");
        return xVar.x(new n(inputStream, xVar));
    }
}
