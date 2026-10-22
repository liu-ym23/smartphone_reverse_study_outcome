package d4;

import S7.k;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import com.stepos.ability.mcpserver.model.McpSession;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4290a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(Object obj, long j5, int i) {
        this.f4290a = i;
        this.c = obj;
        this.b = j5;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4290a) {
            case 0:
                com.stepos.ability.manager.sync.a aVar = (com.stepos.ability.manager.sync.a) this.c;
                SyncCacheMetaEntity meta = (SyncCacheMetaEntity) obj;
                kotlin.jvm.internal.k.f(meta, "meta");
                return SyncCacheMetaEntity.a(meta, meta.b + 1, 0L, this.b, 0L, 0L, aVar.n, 1);
            case 1:
                com.stepos.ability.mcpserver.endpoint.b bVar = (com.stepos.ability.mcpserver.endpoint.b) this.c;
                Map.Entry it = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(it, "it");
                Object value = it.getValue();
                kotlin.jvm.internal.k.e(value, "<get-value>(...)");
                bVar.getClass();
                return Boolean.valueOf(this.b - ((McpSession) value).getLastActiveAt() > bVar.f3179a.getSessionIdleTimeoutMs());
            default:
                return Integer.valueOf(TaskStepDao_Impl.updateDurationDataById$lambda$0("UPDATE task_step SET durationData = ? WHERE id = ?", (String) this.c, this.b, (SQLiteConnection) obj));
        }
    }
}
