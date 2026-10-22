package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f4532m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SupportSQLiteOpenHelper f4533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f4535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f4538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SupportSQLiteDatabase f4541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f4543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f4544l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f4532m = new a(null);
    }

    public e(long r10, TimeUnit r11, Executor r12) {
        kotlin.jvm.internal.q.g(r11, "autoCloseTimeUnit");
        kotlin.jvm.internal.q.g(r12, "autoCloseExecutor");
        this.f4534b = new Handler(Looper.getMainLooper());
        this.f4536d = new Object();
        this.f4537e = r11.toMillis(r10);
        this.f4538f = r12;
        this.f4540h = SystemClock.uptimeMillis();
        this.f4543k = new c(this);
        this.f4544l = new d(this);
    }

    public static /* synthetic */ void a(e r10) {
        f(r10);
    }

    public static /* synthetic */ void b(e r10) {
        c(r10);
    }

    public static final void c(e r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Object r11 = r10.f4536d;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.uptimeMillis() - r10.f4540h) >= r10.f4537e) goto L10;
        monitor-exit(r11);
        return;
    L10:
        if (r10.f4539g == 0) goto L13;
        monitor-exit(r11);
        return;
    L13:
        Runnable r12 = r10.f4535c;     // Catch: Throwable -> L16
        if (r12 == null) goto L18;
        r12.run();     // Catch: Throwable -> L16
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L16
    L19:
        if (r13 == null) goto L29;
        SupportSQLiteDatabase r14 = r10.f4541i;     // Catch: Throwable -> L16
        if (r14 != null) goto L23;
    L25:
        r10.f4541i = null;     // Catch: Throwable -> L16
        Unit r15 = Unit.f21064a;     // Catch: Throwable -> L16
        monitor-exit(r11);
        return;
    L23:
        if (r14.isOpen() == false) goto L25;
        r14.close();     // Catch: Throwable -> L16
        goto L25
    L29:
        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");     // Catch: Throwable -> L16
    L18:
        r13 = null;
        goto L19
    }

    public static final void f(e r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4538f.execute(r10.f4544l);
    }

    public final void d() {
        Object r10 = this.f4536d;
        monitor-enter(r10);
        this.f4542j = true;     // Catch: Throwable -> L8
        SupportSQLiteDatabase r11 = this.f4541i;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r11.close();     // Catch: Throwable -> L8
    L10:
        this.f4541i = null;     // Catch: Throwable -> L8
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L8
        monitor-exit(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void e() {
        Object r10 = this.f4536d;
        monitor-enter(r10);
        int r11 = this.f4539g;     // Catch: Throwable -> L13
        if (r11 <= 0) goto L19;
        int r12 = r11 - 1;     // Catch: Throwable -> L13
        this.f4539g = r12;     // Catch: Throwable -> L13
        if (r12 == 0) goto L9;
    L15:
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L13
        monitor-exit(r10);
        return;
    L9:
        if (this.f4541i != null) goto L12;
        monitor-exit(r10);
        return;
    L12:
        this.f4534b.postDelayed(this.f4543k, this.f4537e);     // Catch: Throwable -> L13
        goto L15
    L19:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final Object g(Function1 r10) {
        kotlin.jvm.internal.q.g(r10, "block");
        Object r11 = r10.invoke(j());     // Catch: Throwable -> L6
        e();
        return r11;
    L6:
        th = move-exception;
        e();
        throw th;
    }

    public final SupportSQLiteDatabase h() {
        return this.f4541i;
    }

    public final SupportSQLiteOpenHelper i() {
        SupportSQLiteOpenHelper r10 = this.f4533a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        kotlin.jvm.internal.q.y("delegateOpenHelper");
        return null;
    }

    public final SupportSQLiteDatabase j() {
        Object r10 = this.f4536d;
        monitor-enter(r10);
        this.f4534b.removeCallbacks(this.f4543k);     // Catch: Throwable -> L12
        this.f4539g++;     // Catch: Throwable -> L12
        if (this.f4542j == true) goto L18;
        SupportSQLiteDatabase r11 = this.f4541i;     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
    L14:
        SupportSQLiteDatabase r12 = i().getWritableDatabase();     // Catch: Throwable -> L12
        this.f4541i = r12;     // Catch: Throwable -> L12
        monitor-exit(r10);
        return r12;
    L9:
        if (r11.isOpen() == false) goto L14;
        monitor-exit(r10);
        return r11;
    L18:
        throw new IllegalStateException("Attempting to open already closed database.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void k(SupportSQLiteOpenHelper r10) {
        kotlin.jvm.internal.q.g(r10, "delegateOpenHelper");
        m(r10);
    }

    public final void l(Runnable r10) {
        kotlin.jvm.internal.q.g(r10, "onAutoClose");
        this.f4535c = r10;
    }

    public final void m(SupportSQLiteOpenHelper r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.f4533a = r10;
    }
}
