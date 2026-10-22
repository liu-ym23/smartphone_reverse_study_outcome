package d0;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0228a f18986e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f18987f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f18989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f18990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f18991d;

    /* JADX INFO: renamed from: d0.a$a, reason: collision with other inner class name */
    public static final class C0228a {
        public /* synthetic */ C0228a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Lock a(C0228a r10, String r11) {
            return r10.b(r11);
        }

        public final Lock b(String r10) {
            Map r11 = a.a();
            monitor-enter(r11);
            Map r12 = a.a();     // Catch: Throwable -> L7
            Object r13 = r12.get(r10);     // Catch: Throwable -> L7
            if (r13 != null) goto L9;
            r13 = new ReentrantLock();     // Catch: Throwable -> L7
            r12.put(r10, r13);     // Catch: Throwable -> L7
        L9:
            Lock r14 = (Lock) r13;     // Catch: Throwable -> L7
            monitor-exit(r11);
            return r14;
        L7:
            th = move-exception;
            throw th;
        }

        public C0228a() {
        }
    }

    static {
        f18986e = new C0228a(null);
        f18987f = new HashMap();
    }

    public a(String r10, File r11, boolean r12) {
        q.g(r10, "name");
        this.f18988a = r12;
        if (r11 == null) goto L5;
        File r13 = new File(r11, r10 + ".lck");
    L6:
        this.f18989b = r13;
        this.f18990c = C0228a.a(f18986e, r10);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static final /* synthetic */ Map a() {
        return f18987f;
    }

    public static /* synthetic */ void c(a r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = r10.f18988a;
    L5:
        r10.b(r11);
    }

    public final void b(boolean r10) {
        this.f18990c.lock();
        if (r10 == false) goto L17;
        File r11 = this.f18989b;     // Catch: IOException -> L9
        if (r11 == null) goto L13;
        File r12 = r11.getParentFile();     // Catch: IOException -> L9
        if (r12 == null) goto L11;
        r12.mkdirs();     // Catch: IOException -> L9
    L11:
        FileChannel r13 = new FileOutputStream(this.f18989b).getChannel();     // Catch: IOException -> L9
        r13.lock();     // Catch: IOException -> L9
        this.f18991d = r13;     // Catch: IOException -> L9
        return;
    L13:
        throw new IOException("No lock directory was provided.");     // Catch: IOException -> L9
    L9:
        e = move-exception;
        this.f18991d = null;
        Log.w("SupportSQLiteLock", "Unable to grab file lock.", e);
        return;
    }

    public final void d() {
        FileChannel r10 = this.f18991d;     // Catch: IOException -> L7
        if (r10 == null) goto L5;
        r10.close();     // Catch: IOException -> L7
    L5:
        this.f18990c.unlock();
    }
}
