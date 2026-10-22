package q2;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends SharedSQLiteStatement {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11497d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(RoomDatabase roomDatabase, int i10) {
        super(roomDatabase);
        this.f11497d = i10;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        switch (this.f11497d) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            case 1:
                return "DELETE FROM WorkProgress";
            case 2:
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            case 3:
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            case 4:
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            case 5:
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            case 6:
                return "DELETE FROM workspec WHERE id=?";
            case 7:
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            case 8:
                return "UPDATE workspec SET output=? WHERE id=?";
            case 9:
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            default:
                return "DELETE FROM requests";
        }
    }
}
