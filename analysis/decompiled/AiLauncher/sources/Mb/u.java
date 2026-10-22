package Mb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;

@Metadata(d1 = {"Mb/v", "Mb/w"}, d2 = {}, k = 4, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u {
    public static final G a() {
        return w.a();
    }

    public static final InterfaceC0967e b(G g10) {
        return w.b(g10);
    }

    public static final InterfaceC0968f c(I i10) {
        return w.c(i10);
    }

    public static final I d(I i10, long j10, boolean z10) {
        return w.d(i10, j10, z10);
    }

    public static final G f(File file) throws FileNotFoundException {
        return v.a(file);
    }

    public static final G g(File file, boolean z10) throws FileNotFoundException {
        return v.b(file, z10);
    }

    public static final G h(OutputStream outputStream) {
        return v.c(outputStream);
    }

    public static final H j(Socket socket) {
        return v.e(socket);
    }

    public static final I k(File file) throws FileNotFoundException {
        return v.f(file);
    }

    public static final I l(InputStream inputStream) {
        return v.g(inputStream);
    }
}
