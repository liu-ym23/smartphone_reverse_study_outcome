package x2;

import android.util.Pair;
import com.bytedance.apm6.service.perf.ICpuDataService;
import java.util.Collection;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a implements ICpuDataService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f25419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f25420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair f25421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Pair f25422d;

    /* JADX INFO: renamed from: x2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0404a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25423a = null;

        static {
            f25423a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f25423a;
        }
    }

    public /* synthetic */ a(C0404a r10) {
        this();
    }

    public static a a() {
        return b.a();
    }

    public void b(double r10, double r11) {
        this.f25419a = r10;
        this.f25420b = r11;
    }

    public synchronized void c(LinkedList r10) {
        monitor-enter(this);
        this.f25422d = new Pair(Long.valueOf(System.currentTimeMillis()), r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void d(LinkedList r10) {
        monitor-enter(this);
        this.f25421c = new Pair(Long.valueOf(System.currentTimeMillis()), r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuRate() {
        return this.f25419a;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuSpeed() {
        return this.f25420b;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair getExceptionThreadList() {
        if (((LinkedList) this.f25422d.second).isEmpty() == false) goto L7;
        return this.f25422d;
    L7:
        return new Pair(this.f25422d.first, new LinkedList((Collection) this.f25422d.second));
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair getThreadList() {
        if (((LinkedList) this.f25421c.second).isEmpty() == false) goto L7;
        return this.f25421c;
    L7:
        return new Pair(this.f25421c.first, new LinkedList((Collection) this.f25421c.second));
    }

    public a() {
        this.f25419a = -1.0d;
        this.f25420b = -1.0d;
        this.f25421c = new Pair(0L, new LinkedList());
        this.f25422d = new Pair(0L, new LinkedList());
    }
}
