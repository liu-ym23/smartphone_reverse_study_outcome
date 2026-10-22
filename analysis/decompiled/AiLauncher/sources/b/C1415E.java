package b;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u000e\u0010#¨\u0006%"}, d2 = {"Lb/E;", "", "Ljava/util/concurrent/Executor;", "executor", "Lkotlin/Function0;", "LY8/t;", "reportFullyDrawn", "<init>", "(Ljava/util/concurrent/Executor;Lp9/a;)V", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/Executor;", "Lp9/a;", "c", "Ljava/lang/Object;", "lock", "", Const.INTENT_KEY_UMID, "I", "reporterCount", "", "e", "Z", "reportPosted", "f", "reportedFullyDrawn", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/List;", "onReportCallbacks", "Ljava/lang/Runnable;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Runnable;", "reportRunnable", "()Z", "isFullyDrawnReported", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: b.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1415E {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Executor executor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Y8.t> reportFullyDrawn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int reporterCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean reportPosted;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean reportedFullyDrawn;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List<InterfaceC5063a<Y8.t>> onReportCallbacks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Runnable reportRunnable;

    public C1415E(Executor executor, InterfaceC5063a<Y8.t> reportFullyDrawn) {
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(reportFullyDrawn, "reportFullyDrawn");
        this.executor = executor;
        this.reportFullyDrawn = reportFullyDrawn;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new Runnable() { // from class: b.D
            @Override // java.lang.Runnable
            public final void run() {
                C1415E.d(this.f15165a);
            }
        };
    }

    public static final void d(C1415E c1415e) {
        synchronized (c1415e.lock) {
            try {
                c1415e.reportPosted = false;
                if (c1415e.reporterCount == 0 && !c1415e.reportedFullyDrawn) {
                    c1415e.reportFullyDrawn.invoke();
                    c1415e.b();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                Iterator<T> it = this.onReportCallbacks.iterator();
                while (it.hasNext()) {
                    ((InterfaceC5063a) it.next()).invoke();
                }
                this.onReportCallbacks.clear();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.reportedFullyDrawn;
        }
        return z10;
    }
}
