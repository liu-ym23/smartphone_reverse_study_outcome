package t2;

import com.bytedance.apm6.cpu.collect.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f24718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f24719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f24720c;

    static {
        f24718a = new HashMap();
        f24719b = new LinkedList();
        f24720c = false;
    }

    public static synchronized void a() {
        monitor-enter(b.class);
        f24720c = true;     // Catch: Throwable -> L11
        if (f24719b.isEmpty() == true) goto L14;
        Iterator r10 = f24719b.iterator();     // Catch: Throwable -> L11
    L9:
        if (r10.hasNext() == false) goto L13;
        l3.a.d((c) r10.next());     // Catch: Throwable -> L11
        goto L9
    L13:
        f24719b.clear();     // Catch: Throwable -> L11
    L14:
        monitor-exit(b.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
