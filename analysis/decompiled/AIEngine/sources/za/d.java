package za;

import com.tonyodev.fetch2.database.DownloadInfo;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends androidx.room.e {
    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        return "DELETE FROM `requests` WHERE `_id` = ?";
    }

    @Override // androidx.room.e
    public final void e(y1.f fVar, Object obj) {
        fVar.h0(1, ((DownloadInfo) obj).getId());
    }
}
