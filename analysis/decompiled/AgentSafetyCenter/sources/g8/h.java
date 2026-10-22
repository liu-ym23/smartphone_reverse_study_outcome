package g8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.invoke.VarHandle;
import java.util.function.Function;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final rd.b f4385a = rd.d.b(h.class);

    public static void a(String str, Function function) throws IOException {
        try {
            InputStream resourceAsStream = z7.h.class.getResourceAsStream(str);
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(resourceAsStream));
                try {
                    Stream<String> streamLines = lineNumberReader.lines();
                    g gVar = new g(0);
                    gVar.f4383f = function;
                    gVar.f4384g = lineNumberReader;
                    VarHandle.storeStoreFence();
                    streamLines.forEach(gVar);
                    lineNumberReader.close();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | IllegalStateException e10) {
            f4385a.e("unable to load Unicode data from file '{}': {}", str, e10.getMessage());
        }
    }
}
