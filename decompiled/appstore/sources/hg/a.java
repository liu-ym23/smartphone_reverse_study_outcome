package hg;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f20469a;

    public a() {
    }

    public static a a() {
        if (f20469a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20469a != null) goto L11;
        f20469a = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f20469a;
    }

    public final void b(Map r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(String r10, long r11, long r12, boolean r13) {
        HashMap r14 = new HashMap();
        r14.put("url", r10);
        r14.put("sent_bytes", Long.valueOf(r11));
        r14.put("received_bytes", Long.valueOf(r12));
        r14.put("is_heartbeat_frame", Boolean.valueOf(r13));
        b(r14);
    }
}
