package androidx.work;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public final class Configuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f5333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f5334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f5335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RunnableScheduler f5336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Consumer f5337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Consumer f5338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f5344m;

    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f5345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Configuration f5347c;

        public a(Configuration r10, boolean r11) {
            this.f5347c = r10;
            this.f5346b = r11;
            this.f5345a = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            if (this.f5346b == false) goto L5;
            String r11 = "WM.task-";
        L7:
            return new Thread(r10, r11 + this.f5345a.incrementAndGet());
        L5:
            r11 = "androidx.work-";
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f5348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m f5349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f5350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Executor f5351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public RunnableScheduler f5352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Consumer f5353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Consumer f5354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f5355h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f5356i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f5357j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5358k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f5359l;

        public b() {
            this.f5356i = 4;
            this.f5357j = 0;
            this.f5358k = Channel.UNLIMITED;
            this.f5359l = 20;
        }

        public Configuration a() {
            return new Configuration(this);
        }
    }

    public Configuration(b r10) {
        Executor r11 = r10.f5348a;
        if (r11 != null) goto L5;
        this.f5332a = a(false);
    L6:
        Executor r12 = r10.f5351d;
        if (r12 != null) goto L9;
        this.f5344m = true;
        this.f5333b = a(true);
    L10:
        m r13 = r10.f5349b;
        if (r13 != null) goto L13;
        this.f5334c = m.c();
    L14:
        f r14 = r10.f5350c;
        if (r14 != null) goto L17;
        this.f5335d = f.c();
    L18:
        RunnableScheduler r15 = r10.f5352e;
        if (r15 != null) goto L21;
        this.f5336e = new androidx.work.impl.d();
    L22:
        this.f5340i = r10.f5356i;
        this.f5341j = r10.f5357j;
        this.f5342k = r10.f5358k;
        this.f5343l = r10.f5359l;
        this.f5337f = r10.f5353f;
        this.f5338g = r10.f5354g;
        this.f5339h = r10.f5355h;
        return;
    L21:
        this.f5336e = r15;
        goto L22
    L17:
        this.f5335d = r14;
        goto L18
    L13:
        this.f5334c = r13;
        goto L14
    L9:
        this.f5344m = false;
        this.f5333b = r12;
        goto L10
    L5:
        this.f5332a = r11;
        goto L6
    }

    public final Executor a(boolean r10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(r10));
    }

    public final ThreadFactory b(boolean r10) {
        return new a(this, r10);
    }

    public String c() {
        return this.f5339h;
    }

    public Executor d() {
        return this.f5332a;
    }

    public Consumer e() {
        return this.f5337f;
    }

    public f f() {
        return this.f5335d;
    }

    public int g() {
        return this.f5342k;
    }

    public int h() {
        return this.f5343l;
    }

    public int i() {
        return this.f5341j;
    }

    public int j() {
        return this.f5340i;
    }

    public RunnableScheduler k() {
        return this.f5336e;
    }

    public Consumer l() {
        return this.f5338g;
    }

    public Executor m() {
        return this.f5333b;
    }

    public m n() {
        return this.f5334c;
    }
}
