package i5;

import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;

/* loaded from: classes.dex */
public final class c extends a4.e {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4647e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl, int i2) {
        super(offlineQueueDatabase_Impl);
        this.f4647e = i2;
    }

    @Override // a4.e
    public final String b() {
        switch (this.f4647e) {
            case 0:
                return "INSERT OR ABORT INTO `offline_frame` (`id`,`frame_json`,`size_bytes`,`created_at`,`ttl_expires_at`,`target_kind`) VALUES (nullif(?, 0),?,?,?,?,?)";
            default:
                return "INSERT OR REPLACE INTO `offline_frame_tombstone` (`frame_id`,`reason`,`created_at`,`expires_at`) VALUES (?,?,?,?)";
        }
    }

    public final void l(n3.j jVar, Object obj) {
        switch (this.f4647e) {
            case 0:
                g gVar = (g) obj;
                jVar.G(1, gVar.f4657a);
                jVar.l(2, gVar.f4658b);
                jVar.G(3, gVar.f4659c);
                jVar.G(4, gVar.f4660d);
                jVar.G(5, gVar.f4661e);
                jVar.l(6, gVar.f4662f);
                break;
            default:
                m mVar = (m) obj;
                jVar.l(1, mVar.f4690a);
                jVar.l(2, mVar.f4691b);
                jVar.G(3, mVar.f4692c);
                jVar.G(4, mVar.f4693d);
                break;
        }
    }
}
