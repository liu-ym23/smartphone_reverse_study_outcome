package a5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f1869a;

    public final void a() {
        l r100 = this.f1869a.f1861b.f1858e.get();
        if (r100 != null) goto L5;
        return;
    L5:
        LogBoxLogLevel r101 = this.f1869a.f1861b.f1857d;
        l.a r102 = (l.a) ((HashMap) r100.f1885b).get(r101);
        if (r102 == null) goto L16;
        LogBoxProxy r103 = r102.a();
        if (r103 == null) goto L15;
        m r104 = r100.f1886c;
        if (r104 == null) goto L13;
        Map<LogBoxLogLevel, Boolean> r105 = r104.f1895d;
        HashMap r106 = (HashMap) r105;
        r106.put(r101, Boolean.TRUE);
    L13:
        r102.b(r103);
        r103.clearLogsWithLevel(r101);
        return;
    L15:
        return;
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

    public e(b.a r100) {
        this.f1869a = r100;
    }
}
