package i2;

import android.content.Context;
import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends u1.a {

    /* renamed from: c, reason: collision with root package name */
    public final Context f9464c;

    public g(Context context, int i10, int i11) {
        super(i10, i11);
        this.f9464c = context;
    }

    @Override // u1.a
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        if (this.f13142b >= 10) {
            frameworkSQLiteDatabase.z("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
        } else {
            this.f9464c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }
}
