package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v0 {
    public static final CancellationException a(String r10, Throwable r11) {
        CancellationException r12 = new CancellationException(r10);
        r12.initCause(r11);
        return r12;
    }
}
