package l2;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import l2.H;

/* loaded from: classes2.dex */
public final /* synthetic */ class F implements H.a {

    /* renamed from: a, reason: collision with root package name */
    public static final F f36890a = new F();

    public static H.a b() {
        return f36890a;
    }

    @Override // l2.H.a
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
