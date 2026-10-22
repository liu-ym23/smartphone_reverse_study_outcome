package r6;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final long f5190a;

    /* renamed from: b, reason: collision with root package name */
    public final q6.c f5191b;

    /* renamed from: c, reason: collision with root package name */
    public final b7.g f5192c;
    public final ConcurrentLinkedQueue d;

    public q(q6.d taskRunner) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.e(timeUnit, "timeUnit");
        this.f5190a = timeUnit.toNanos(5L);
        this.f5191b = taskRunner.d();
        this.f5192c = new b7.g(this, m0.f.f(new StringBuilder(), o6.f.f4331b, " ConnectionPool connection closer"));
        this.d = new ConcurrentLinkedQueue();
    }

    public final int a(p pVar, long j4) {
        TimeZone timeZone = o6.f.f4330a;
        ArrayList arrayList = pVar.f5188q;
        int i8 = 0;
        while (i8 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i8);
            if (reference.get() != null) {
                i8++;
            } else {
                Platform.INSTANCE.get().logCloseableLeak("A connection to " + pVar.f5175c.f4163a.f3992h + " was leaked. Did you forget to close a response body?", ((m) reference).f5155a);
                arrayList.remove(i8);
                if (arrayList.isEmpty()) {
                    pVar.f5189r = j4 - this.f5190a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
