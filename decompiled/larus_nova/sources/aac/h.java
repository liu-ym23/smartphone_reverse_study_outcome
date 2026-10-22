package aac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f2396a;

    public final void a() {
        if (this.f2396a.f2390b.get() == true) goto L10;
        Log.i("UserSettingService", "init user setting service");
        Object r100 = f.f2385c;
        f r101 = f.c.f2388a;
        g.a r102 = this.f2396a.f2391c;
        if (r102 != null) goto L7;
        r101.getClass();
    L8:
        this.f2396a.a();
        this.f2396a.b(null);
        this.f2396a.f2390b.compareAndSet(false, true);
        return;
    L7:
        Map<f.b, Object> r103 = r101.f2387b;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r102, f.f2385c);
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(g r100) {
        this.f2396a = r100;
    }
}
