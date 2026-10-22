package X;

import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ void a(Object obj) throws Exception {
        if (obj instanceof AutoCloseable) {
            ((AutoCloseable) obj).close();
        } else if (obj instanceof ExecutorService) {
            g.a((ExecutorService) obj);
        } else {
            h.a(obj);
        }
    }
}
