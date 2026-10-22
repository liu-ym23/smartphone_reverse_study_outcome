package m8;

import android.app.Application;
import android.content.Context;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.agentsafetycenter.data.local.AppDatabase;
import java.lang.invoke.VarHandle;
import s8.v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8302c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Application f8303f;

    public /* synthetic */ b(int i) {
        this.f8302c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        AppDatabase appDatabase;
        int i = this.f8302c;
        Application application = this.f8303f;
        switch (i) {
            case 0:
                Context applicationContext = application.getApplicationContext();
                AgentSafetyApplication agentSafetyApplication = applicationContext instanceof AgentSafetyApplication ? (AgentSafetyApplication) applicationContext : null;
                if (agentSafetyApplication == null || (appDatabase = (AppDatabase) agentSafetyApplication.f2488c.getValue()) == null) {
                    applicationContext.getClass();
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    applicationContext2.getClass();
                    androidx.room.r rVarB = q8.g.b(applicationContext2, AppDatabase.class, "agent_safety.db");
                    rVarB.f1619p = false;
                    rVarB.f1620q = true;
                    appDatabase = (AppDatabase) rVarB.b();
                }
                q8.v vVarY = appDatabase.y();
                vVarY.getClass();
                q8.y yVar = new q8.y();
                yVar.f10197a = vVarY;
                VarHandle.storeStoreFence();
                return yVar;
            case 1:
                v3 v3Var = new v3();
                v3Var.f12031a = application.getApplicationContext();
                VarHandle.storeStoreFence();
                return v3Var;
            default:
                x8.c cVar = new x8.c();
                cVar.f15595a = application.getApplicationContext();
                VarHandle.storeStoreFence();
                return cVar;
        }
    }
}
