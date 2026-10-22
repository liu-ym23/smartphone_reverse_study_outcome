package e2;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import l2.InterfaceC4863c;

/* loaded from: classes2.dex */
public abstract class s implements Closeable {

    public interface a {
        a a(Context context);

        s build();
    }

    public abstract InterfaceC4863c b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b().close();
    }

    public abstract r e();
}
