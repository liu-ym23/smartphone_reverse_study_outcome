package b8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements z7.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f1009a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1010b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f1011c = new LinkedBlockingQueue();

    @Override // z7.a
    public final synchronized z7.b a(String str) {
        e eVar;
        eVar = (e) this.f1010b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.f1011c, this.f1009a);
            this.f1010b.put(str, eVar);
        }
        return eVar;
    }
}
