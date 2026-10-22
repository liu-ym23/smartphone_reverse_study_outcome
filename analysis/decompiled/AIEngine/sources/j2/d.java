package j2;

import androidx.appcompat.app.l;
import i2.k;
import i2.s;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.b f9679a;

    /* renamed from: b, reason: collision with root package name */
    public final s f9680b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9681c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9682d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f9683e;

    public d(androidx.lifecycle.b runnableScheduler, s sVar) {
        g.f(runnableScheduler, "runnableScheduler");
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.f9679a = runnableScheduler;
        this.f9680b = sVar;
        this.f9681c = millis;
        this.f9682d = new Object();
        this.f9683e = new LinkedHashMap();
    }

    public final void a(k token) {
        Runnable runnable;
        g.f(token, "token");
        synchronized (this.f9682d) {
            runnable = (Runnable) this.f9683e.remove(token);
        }
        if (runnable != null) {
            this.f9679a.a(runnable);
        }
    }

    public final void b(k token) {
        g.f(token, "token");
        l lVar = new l(18, this, token);
        synchronized (this.f9682d) {
        }
        this.f9679a.h(this.f9681c, lVar);
    }
}
