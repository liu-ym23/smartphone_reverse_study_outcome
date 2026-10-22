package h0;

import com.bytedance.apm.core.ActivityLifeObserver;
import g0.AbstractC1450a;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4537a;
    public final /* synthetic */ f b;

    public e(f fVar, long j5) {
        this.b = fVar;
        this.f4537a = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.b;
        Iterator it = fVar.c.iterator();
        while (it.hasNext()) {
            ((AbstractC1450a) it.next()).a(fVar.n, this.f4537a, ActivityLifeObserver.getInstance().getTopActivityClassName());
        }
    }
}
