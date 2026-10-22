package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class q implements B.d {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f36931a;

    public q(SQLiteDatabase sQLiteDatabase) {
        this.f36931a = sQLiteDatabase;
    }

    public static B.d a(SQLiteDatabase sQLiteDatabase) {
        return new q(sQLiteDatabase);
    }

    @Override // l2.B.d
    public Object produce() {
        return B.V(this.f36931a);
    }
}
