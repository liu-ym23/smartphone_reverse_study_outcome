package a97;

import android.os.SystemClock;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.JavaLoadException;
import com.bytedance.reparo.core.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.GeckoConst;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WandTrick.a f2287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f2288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d97.c f2289c;

    public final void a() {
        int r100 = 0;
    L4:
        if (r100 >= 5) goto L15;
        if (this.f2287a.c() == true) goto L7;
        k.c(GeckoConst.HOTFIX, "doRetryTask times " + r100);
        SystemClock.sleep(5000);
        r100 = r100 + 1;
        goto L4
    L7:
        return;
    L12:
        e = move-exception;
        b97.a.c("reparo", e);
        this.f2288b.a(e);
        return;
    L9:
        th = move-exception;
        b97.a.c("reparo", th);
        this.f2288b.a(new JavaLoadException(String.format("load java patch %s failed.", new Object[]{this.f2289c.f467629b.getAbsolutePath()}), th, 103));
        return;
    L15:
        this.f2288b.a(new JavaLoadException(String.format("Retry load java patch \"%s\" failed, code =" + this.f2287a.f267325a, new Object[]{this.f2289c.f467629b.getAbsolutePath()}), 105));
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

    public d(c r100, f r101, d97.c r102) {
        this.f2287a = r100;
        this.f2288b = r101;
        this.f2289c = r102;
    }
}
