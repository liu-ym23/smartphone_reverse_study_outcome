package ab;

import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.tonyodev.fetch2.EnqueueAction;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f72c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i10, int i11, int i12) {
        super(i10, i11);
        this.f72c = i12;
    }

    @Override // u1.a
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        switch (this.f72c) {
            case 0:
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_download_on_enqueue' INTEGER NOT NULL DEFAULT 1");
                break;
            case 1:
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_max_attempts' INTEGER NOT NULL DEFAULT '0'");
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_attempts' INTEGER NOT NULL DEFAULT '0'");
                break;
            default:
                EnqueueAction.a aVar = EnqueueAction.f8147b;
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_enqueue_action' INTEGER NOT NULL DEFAULT 0");
                break;
        }
    }
}
