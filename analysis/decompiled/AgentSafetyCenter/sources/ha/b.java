package ha;

import android.content.Context;
import androidx.room.a0;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import ma.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ c f5424c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Context f5425f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f5426g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f5427h;
    public /* synthetic */ HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ int f5428j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ HashMap f5429k;

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.f5424c;
        Context context = this.f5425f;
        String str = this.f5426g;
        String str2 = this.f5427h;
        HashMap map = this.i;
        int i = this.f5428j;
        HashMap map2 = this.f5429k;
        a aVar = new a(context, str, str2, map);
        pa.b bVar = new pa.b();
        bVar.f9930a = aVar;
        bVar.f9931b = i;
        bVar.f9932c = map2;
        e eVar = ma.d.f8538a;
        pa.c cVar2 = eVar.f8542d;
        if (cVar2 != null) {
            ua.c.a("EventController", "send success");
            a0 a0Var = new a0(7);
            a0Var.f1506f = cVar2;
            a0Var.f1507g = bVar;
            VarHandle.storeStoreFence();
            sa.c.f(a0Var);
            return;
        }
        ua.c.f("EventController", "send fail, tracker is null");
        synchronized (cVar) {
            if (cVar.f5430a.size() < 300) {
                cVar.f5430a.add(bVar);
            } else {
                ua.c.f("EventController", "fail event data list is already full");
            }
        }
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.a aVar2 = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(1);
        aVar2.f2822g = eVar;
        aVar2.f2821f = false;
        VarHandle.storeStoreFence();
        sa.c.f(aVar2);
    }
}
