package bjb;

import android.app.Application;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile x18.b f19272a;

    public e() {
    }

    public static x18.b a() {
        if (f19272a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f19272a != null) goto L9;
        f19272a = b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f19272a;
    }

    public static x18.b b() {
        Application r100 = LarkContext.getApplication();
        ArrayList r101 = new ArrayList();
        r101.add(new d(r100));
        Log.i("LarkHttpClient", "init process:" + z.b(r100));
        x18.b.a r102 = new x18.b.a();
        r102.f562134a = r100;
        r102.f562136c = true;
        TimeUnit r103 = TimeUnit.MILLISECONDS;
        r102.f562137d = 15000;
        r102.f562138e = r103;
        r102.f562139f = 10000;
        r102.f562140g = r103;
        r102.f562141h = 30000;
        r102.f562142i = r103;
        ((ArrayList) r102.f562135b).addAll(r101);
        if (x18.a.f562132a == null) goto L5;
    L14:
        f19272a = x18.a.f562132a;
        return f19272a;
    L5:
        monitor-enter(x18.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (x18.a.f562132a != null) goto L9;
        x18.a.f562132a = new x18.d(r102);     // Catch: Throwable -> L11
        Log.i("DefaultClientContainer", "lark DefaultClientContainer do init!");     // Catch: Throwable -> L11
    L9:
        monitor-exit(x18.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
