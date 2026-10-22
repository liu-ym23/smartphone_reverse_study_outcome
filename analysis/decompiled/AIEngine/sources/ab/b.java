package ab;

import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f71c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i10, int i11, int i12) {
        super(i10, i11);
        this.f71c = i12;
    }

    @Override // u1.a
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        switch (this.f71c) {
            case 0:
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_extras' TEXT NOT NULL DEFAULT '{}'");
                break;
            case 1:
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_tag' TEXT NULL DEFAULT NULL");
                break;
            default:
                frameworkSQLiteDatabase.n("ALTER TABLE 'requests' ADD COLUMN '_identifier' INTEGER NOT NULL DEFAULT 0");
                break;
        }
    }
}
