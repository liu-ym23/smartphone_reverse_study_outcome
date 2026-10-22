package R3;

import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.database.dao.AbilityTaskDao_Impl;
import com.stepos.ability.sdk.client.AgentServiceClient;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1148a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ i(String str, String str2, String str3, int i) {
        this.f1148a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1148a) {
            case 0:
                return AbilityTaskDao_Impl.updateStatus$lambda$0("UPDATE t_ability_task SET status = ? WHERE taskCode = ? AND status=?", this.b, this.c, this.d, (SQLiteConnection) obj);
            default:
                return AgentServiceClient.submitUserInput$lambda$0(this.b, this.c, this.d, (IAgentServiceManager) obj);
        }
    }
}
