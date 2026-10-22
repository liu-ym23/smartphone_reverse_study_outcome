package n2;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements WeedOutStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f22361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LimitedQueue f22362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile q2.c f22363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile u3.a f22364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f22365f;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f22366d;

        public a(c r10, long r11, long r12) {
            this.f22366d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f22366d);
        }
    }

    public class b extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f22367d;

        public b(c r10, long r11, long r12) {
            this.f22367d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f22367d);
        }
    }

    /* JADX INFO: renamed from: n2.c$c, reason: collision with other inner class name */
    public class C0321c extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f22368d;

        public C0321c(c r10, long r11) {
            this.f22368d = r10;
            super(r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b(this.f22368d);
        }
    }

    public class d implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22369a;

        public d(c r10) {
            this.f22369a = r10;
        }

        public int a(String r10, String r11) {
            return String.CASE_INSENSITIVE_ORDER.compare(r10, r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((String) r10, (String) r11);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22370a = null;

        static {
            f22370a = new c();
        }

        public static /* synthetic */ c a() {
            return f22370a;
        }
    }

    public c() {
        this.f22360a = 60000;
        this.f22361b = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.f22362c = new LimitedQueue(10);
        this.f22365f = false;
    }

    public static /* synthetic */ void a(c r10) {
        r10.i();
    }

    public static /* synthetic */ void b(c r10) {
        r10.g();
    }

    public static c e() {
        return e.a();
    }

    public final void c() {
    L6:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "flushBuffer", th);
        return;
    L3:
        if (this.f22363d == null) goto L11;
        this.f22363d.b();     // Catch: Throwable -> L6
        return;
    }

    public final long d(File r10) {
        String r11 = r10.getName();
        int r12 = r11.indexOf("_");
        if (r12 != (-1)) goto L9;
        return -1;
    L9:
        return Long.parseLong(r11.substring(0, r12));
    L8:
        return -1;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r10) {
        if (this.f22363d != null) goto L5;
        return;
    L5:
        String[] r11 = this.f22363d.h();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length == 0) goto L24;
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L25;
        String r14 = r11[r13];
        File r15 = new File(n2.b.b(), r14);
        long r16 = d(r15);
        if (r16 != (-1)) goto L16;
        r3.c.a(r15);
    L18:
        r13 = r13 + 1;
        goto L11
    L16:
        if (r16 > r10) goto L18;
        r3.c.a(r15);
        goto L18
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r11) {
        if (this.f22363d != null) goto L5;
        return;
    L5:
        String[] r10 = this.f22363d.h();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L41;
        Arrays.sort(r10);
        int r12 = r10.length;
        int r13 = 0;
        long r14 = 0;
        int r15 = 0;
        long r16 = 0;
    L11:
        if (r15 >= r12) goto L18;
        File r17 = new File(n2.b.b(), r10[r15]);
        if (r17.exists() == false) goto L17;
        if (r17.isFile() == false) goto L17;
        r16 = r16 + r17.length();
    L17:
        r15 = r15 + 1;
        goto L11
    L18:
        int r18 = r10.length;
    L19:
        if (r13 >= r18) goto L42;
        String r19 = r10[r13];
        if ((r16 - r14) <= r11) goto L43;
        File r20 = new File(n2.b.b(), r19);
        if (r20.exists() == false) goto L29;
        if (r20.isFile() == false) goto L29;
        long r21 = r20.length();
        if (r3.c.b(r20) == false) goto L29;
        r14 = r14 + r21;
    L29:
        r13 = r13 + 1;
        goto L19
    L43:
        return;
    L42:
        return;
    }

    public synchronized void f() {
        monitor-enter(this);
        this.f22364e = new b(this, 0, this.f22360a);     // Catch: Throwable -> L7
        AsyncTaskManagerType r10 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L7
        u3.b.a(r10).c(this.f22364e);     // Catch: Throwable -> L7
        if (d3.a.A() == false) goto L9;
        u3.b.a(r10).c(new C0321c(this, 10000));     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g() {
        File r13 = n2.b.e();
        if (r13.exists() == true) goto L5;
        return;
    L5:
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        int r10 = r14.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L43;
        File r12 = r14[r11];
        if (r12 == null) goto L42;
        if (r12.exists() == false) goto L42;
        if (r12.length() <= 0) goto L42;
        if (Long.parseLong(r12.getName().split("_")[0]) >= d3.a.o()) goto L42;
        FileChannel r15 = null;
        r15 = new RandomAccessFile(r12, "rw").getChannel();     // Catch: Throwable -> L28
        FileLock r16 = r15.tryLock(0, Long.MAX_VALUE, false);     // Catch: Throwable -> L28
        if (r16 == null) goto L32;
        if (r16.isValid() == false) goto L32;
        File r17 = new File(n2.b.b(), n2.b.a());     // Catch: Throwable -> L28
        boolean r18 = x3.a.b(r12.getAbsolutePath(), r17.getAbsolutePath());     // Catch: Throwable -> L28
        if (r3.a.c() == false) goto L30;
        s3.a.a(n2.a.f22354a, "moveInactiveSubProcessData: src:" + r12.getAbsolutePath() + " dst:" + r17.getAbsolutePath() + " isSuccess:" + r18);     // Catch: Throwable -> L28
    L30:
        r16.release();     // Catch: Throwable -> L28
    L34:
        r3.d.a(r15);
    L32:
        if (r3.a.c() == false) goto L34;
        s3.a.a(n2.a.f22354a, "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
    L39:
        th = move-exception;
        r3.d.a(r15);
        throw th;
    L36:
        if (r3.a.c() == false) goto L34;
        s3.a.g(n2.a.f22354a, "moveInactiveSubProcessData failed.", th);     // Catch: Throwable -> L39
    L42:
        r11 = r11 + 1;
        goto L9
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return "first_log_dir";
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        String[] r10 = this.f22363d.h();
        long r11 = 0;
        if (r10 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r10.length == 0) goto L10;
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        String r14 = r10[r13];
        r11 = r11 + new File(n2.b.b(), r14).length();
        r13 = r13 + 1;
        goto L8
    }

    public synchronized void h() {
        monitor-enter(this);
        this.f22365f = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void i() {
        long r10 = System.currentTimeMillis();
        c();
        k();
        if (d3.a.A() == false) goto L8;
        if (this.f22365f == true) goto L8;
        j();
    L8:
        if (r3.a.c() == false) goto L11;
        s3.a.a(n2.a.f22354a, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r10));
        return;
    }

    public final void j() {
        if (this.f22363d == null) goto L5;
        String[] r10 = this.f22363d.h();
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L48;
        List r11 = Arrays.asList(r10);
        Collections.sort(r11, new d(this));
        if (r3.a.c() == false) goto L13;
        s3.a.a(n2.a.f22354a, "reportFile: parsing " + r11.size() + " files. fileNameList" + r11);
    L13:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r13 >= r11.size()) goto L38;
        File r15 = new File(n2.b.b(), (String) r11.get(r13));
        if (r15.exists() == false) goto L36;
        q2.a r16 = q2.a.a(r15);
        if (r16 == null) goto L22;
        int r17 = r16.f();
        if (r14 != 0) goto L28;
    L35:
        r14 = r14 + r17;
        r12.add(r16);
        goto L36
    L28:
        if ((r14 + r17) < this.f22361b) goto L35;
        if (s1.a.c() == null) goto L33;
        s1.a.c().d(n2.a.f22354a, "sendList:" + r11.toString());
    L33:
        com.bytedance.apm6.consumer.slardar.send.c.g().n(r12, r11.size() - r12.size());
        return;
    L22:
        if (r3.a.c() == false) goto L24;
        s3.a.a(n2.a.f22354a, "logFile invalid. delete now.");
    L24:
        r15.delete();
    L36:
        r13 = r13 + 1;
        goto L15
    L38:
        if (s1.a.c() == null) goto L40;
        s1.a.c().d(n2.a.f22354a, "sendList:" + r11.toString());
    L40:
        com.bytedance.apm6.consumer.slardar.send.c.g().n(r12, 0);
        return;
    L48:
        return;
    L5:
        s3.a.b(n2.a.f22354a, "persistentBuffer is null");
        r10 = null;
        goto L6
    }

    public final void k() {
        if (this.f22362c.a() == false) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L7:
        if (this.f22362c.a() == true) goto L18;
        r10.add(this.f22362c.b());
        q2.a r12 = (q2.a) this.f22362c.b();
        if (r12 == null) goto L7;
        int r13 = r12.f();
        if (r11 == 0) goto L17;
        if ((r11 + r13) < this.f22361b) goto L17;
        com.bytedance.apm6.consumer.slardar.send.c.g().n(r10, 0);
        r10.clear();
        r10.add(r12);
        r11 = r13;
    L17:
        r11 = r11 + r13;
        r10.add(r12);
        goto L7
    L18:
        com.bytedance.apm6.consumer.slardar.send.c.g().n(r10, 0);
    }

    public synchronized void l() {
        monitor-enter(this);
        this.f22365f = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void m(q2.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f22362c.c(r10);
    }

    public synchronized void n(long r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (r3.a.c() == false) goto L9;
        s3.a.a(n2.a.f22354a, "setLoopInterval:" + this.f22360a);     // Catch: Throwable -> L6
    L9:
        if (r10 > 0) goto L11;
    L20:
        monitor-exit(this);
        return;
    L11:
        if (this.f22360a == r10) goto L20;
        this.f22360a = r10;     // Catch: Throwable -> L6
        if (this.f22364e != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        AsyncTaskManagerType r11 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L6
        u3.b.a(r11).b(this.f22364e);     // Catch: Throwable -> L6
        this.f22364e = new a(this, this.f22360a, this.f22360a);     // Catch: Throwable -> L6
        u3.b.a(r11).c(this.f22364e);     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public void o(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        this.f22361b = r10;
    }

    public void p(q2.c r10) {
        this.f22363d = r10;
    }
}
