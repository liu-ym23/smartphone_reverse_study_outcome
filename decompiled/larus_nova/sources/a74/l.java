package a74;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2001a;

    public l(m r100) {
        this.f2001a = r100;
    }

    @Override // a74.q
    public final void a(String r100) {
        this.f2001a.f2004c.a(r100);     // Catch: Throwable -> L6
        com.bytedance.badger.utils.m r101 = com.bytedance.badger.utils.m.a();
        Runnable r102 = new k();
    L5:
        r101.b(r102);
        return;
    L6:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "callback onError failed: " + th.getMessage());     // Catch: Throwable -> L11
        r101 = com.bytedance.badger.utils.m.a();
        r102 = new k();
    L11:
        th = move-exception;
        com.bytedance.badger.utils.m.a().b(new k());
        throw th;
    }

    @Override // a74.q
    public final void a(final JSONObject r100) {
        com.bytedance.badger.e.f("event_behavior# ", "collect complete... " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L5
        com.bytedance.badger.utils.m r101 = com.bytedance.badger.utils.m.a();     // Catch: Throwable -> L5
        final m r102 = this.f2001a;     // Catch: Throwable -> L5
        r101.b(new i(r102, r100));     // Catch: Throwable -> L5
        com.bytedance.badger.utils.m r103 = com.bytedance.badger.utils.m.a();
        Runnable r104 = new j();
    L8:
        r103.b(r104);
        return;
    L5:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "callback onCompleted failed: " + th.getMessage());     // Catch: Throwable -> L10
        r103 = com.bytedance.badger.utils.m.a();
        r104 = new j();
    L10:
        th = move-exception;
        com.bytedance.badger.utils.m.a().b(new j());
        throw th;
    }
}
