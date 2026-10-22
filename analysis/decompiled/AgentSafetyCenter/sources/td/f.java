package td;

import java.lang.invoke.VarHandle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements rd.a {

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f13304c;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f13305f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue f13306g;

    @Override // rd.a
    public final synchronized rd.b a(String str) {
        e eVar;
        eVar = (e) this.f13305f.get(str);
        if (eVar == null) {
            LinkedBlockingQueue linkedBlockingQueue = this.f13306g;
            boolean z10 = this.f13304c;
            eVar = new e();
            eVar.f13298c = str;
            eVar.f13302j = linkedBlockingQueue;
            eVar.f13303k = z10;
            VarHandle.storeStoreFence();
            this.f13305f.put(str, eVar);
        }
        return eVar;
    }
}
