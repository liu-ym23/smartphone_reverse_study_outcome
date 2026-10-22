package E3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.function.Function;

/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC0315b f469a = AbstractC0317d.b(i.class);

    public static void a(String str, Function function) throws IOException {
        try {
            InputStream resourceAsStream = x3.g.class.getResourceAsStream(str);
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(resourceAsStream));
                try {
                    lineNumberReader.lines().forEach(new h(0, function, lineNumberReader));
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
        } catch (IOException | IllegalStateException e) {
            f469a.i("unable to load Unicode data from file '{}': {}", str, e.getMessage());
        }
    }
}
