package R3;

import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.sdk.client.AgentServiceClient;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1150a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ l(int i, String str, String str2) {
        this.f1150a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1150a) {
            case 0:
                return AtomicAbilityDao_Impl.getByPackageAndFunction$lambda$0("SELECT * FROM t_atomic_ability WHERE packageName = ? AND functionName = ? LIMIT 1", this.b, this.c, (SQLiteConnection) obj);
            default:
                return AgentServiceClient.cancelUserInput$lambda$0(this.b, this.c, (IAgentServiceManager) obj);
        }
    }
}
