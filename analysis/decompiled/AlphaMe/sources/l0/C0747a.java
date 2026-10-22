package l0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.room.v;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: l0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0747a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13421a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13422b;

    public /* synthetic */ C0747a(int i4, Object obj) {
        this.f13421a = i4;
        this.f13422b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i4 = this.f13421a;
        Object obj = this.f13422b;
        switch (i4) {
            case 0:
                k0.i query = (k0.i) obj;
                Intrinsics.checkNotNullParameter(query, "$query");
                Intrinsics.checkNotNull(sQLiteQuery);
                query.a(new v(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            default:
                Function4 tmp0 = (Function4) obj;
                Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                return (Cursor) tmp0.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
