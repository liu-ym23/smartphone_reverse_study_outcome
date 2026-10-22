package androidx.room.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: CopyLock.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f2617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f2618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lock f2619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FileChannel f2621e;

    static {
        f2617a = new HashMap();
    }

    public a(String r3, File r4, boolean r5) {
        File r0 = new File(r4, r3 + ".lck");
        this.f2618b = r0;
        this.f2619c = a(r0.getAbsolutePath());
        this.f2620d = r5;
    }

    public void a() {
        this.f2619c.lock();
        if (this.f2620d == true) goto L10;
        return;
    L10:
        FileChannel r0 = new FileOutputStream(this.f2618b).getChannel();     // Catch: IOException -> L6
        this.f2621e = r0;     // Catch: IOException -> L6
        r0.lock();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalStateException("Unable to grab copy lock.", e);
    }

    public void b() {
        FileChannel r0 = this.f2621e;
        if (r0 != null) goto L8;
    L5:
        this.f2619c.unlock();
        return;
    L8:
        r0.close();     // Catch: IOException -> L7
        goto L5
    }

    private static Lock a(String r4) {
        Map<String, Lock> r0 = f2617a;
        monitor-enter(r0);
        Lock r1 = (Lock) ZeusTransformUtils.preCheckCast(r0.get(r4), Lock.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new ReentrantLock();     // Catch: Throwable -> L9
        r0.put(r4, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }
}
