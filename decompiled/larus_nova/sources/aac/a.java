package aac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f2376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2377b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((ConcurrentHashMap) this.f2377b.f2381c).keySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((b.a) r100.next()).a(this.f2376a, this.f2377b.f2379a);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public a(b r100, UserSetting r101) {
        this.f2377b = r100;
        this.f2376a = r101;
    }
}
