package q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class f extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f23538a;

    public f() {
    }

    public static f a() {
        if (f23538a != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23538a != null) goto L11;
        f23538a = new f();     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f23538a;
    }

    public final void b(Map r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(String r10, long r11, long r12, String r13, String r14) {
        HashMap r15 = new HashMap();
        r15.put("url", r10);
        r15.put("sent_bytes", Long.valueOf(r11));
        r15.put("received_bytes", Long.valueOf(r12));
        r15.put("content_type", r13);
        r15.put("request_log", r14);
        b(r15);
    }
}
