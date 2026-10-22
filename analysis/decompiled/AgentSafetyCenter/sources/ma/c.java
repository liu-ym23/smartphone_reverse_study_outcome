package ma;

import com.stepos.agentsafetycenter.AgentSafetyApplication;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8536c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ e f8537f;

    public /* synthetic */ c(int i) {
        this.f8536c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8536c;
        e eVar = this.f8537f;
        switch (i) {
            case 0:
                if (eVar.a() != null) {
                    qa.c cVarA = eVar.a();
                    AgentSafetyApplication agentSafetyApplication = eVar.f8539a;
                    cVarA.getClass();
                    qa.b bVar = new qa.b();
                    bVar.f10210c = agentSafetyApplication;
                    cVarA.f10211a = bVar.b();
                    break;
                } else {
                    ua.c.b("SDKInstanceImpl", "refreshDeviceInfo fail, subject is null");
                    break;
                }
            default:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.a aVar = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(1);
                aVar.f2822g = eVar;
                aVar.f2821f = true;
                VarHandle.storeStoreFence();
                sa.c.f(aVar);
                break;
        }
    }
}
