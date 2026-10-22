package i5;

import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;

/* loaded from: classes.dex */
public final class d extends a4.e {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4648e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl, int i2) {
        super(offlineQueueDatabase_Impl);
        this.f4648e = i2;
    }

    @Override // a4.e
    public final String b() {
        switch (this.f4648e) {
            case 0:
                return "DELETE FROM offline_frame WHERE ttl_expires_at < ?";
            case 1:
                return "DELETE FROM offline_frame WHERE id = ?";
            case 2:
                return "DELETE FROM offline_frame";
            default:
                return "DELETE FROM offline_frame_tombstone WHERE expires_at < ?";
        }
    }
}
