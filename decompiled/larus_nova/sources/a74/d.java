package a74;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements q {
    public d() {
    }

    @Override // a74.q
    public final void a(JSONObject r100) {
        com.bytedance.badger.utils.m.a().b(new c(r100));
    }

    @Override // a74.q
    public final void a(String r100) {
        com.bytedance.badger.e.g("event_behavior# ", "collect error: " + r100);
        Object r101 = e.f1992b;
        monitor-enter(r101);
        e.f1994d = false;     // Catch: Throwable -> L11
        e.f1991a = 0;     // Catch: Throwable -> L11
        e.f1996f = false;     // Catch: Throwable -> L11
        e.f1995e = 0;     // Catch: Throwable -> L11
        e.f1997g.clear();     // Catch: Throwable -> L11
        e.f1998h.clear();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        e.f1993c.set(false);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
