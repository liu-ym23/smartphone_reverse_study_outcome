package s;

import java.util.concurrent.ExecutorService;

/* renamed from: s.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C5423E {
    public static /* synthetic */ void a(Object obj) throws Exception {
        if (obj instanceof AutoCloseable) {
            ((AutoCloseable) obj).close();
        } else if (obj instanceof ExecutorService) {
            C5424F.a((ExecutorService) obj);
        } else {
            I.a(obj);
        }
    }
}
