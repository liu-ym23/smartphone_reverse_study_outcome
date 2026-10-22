package q2;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends SharedSQLiteStatement {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11496d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(RoomDatabase roomDatabase, int i10) {
        super(roomDatabase);
        this.f11496d = i10;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        switch (this.f11496d) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            case 1:
                return "DELETE from WorkProgress where work_spec_id=?";
            case 2:
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            case 3:
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            case 4:
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            case 5:
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            case 6:
                return "UPDATE workspec SET state=? WHERE id=?";
            case 7:
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            case 8:
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            default:
                return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }
}
