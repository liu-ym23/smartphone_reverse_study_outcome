package androidx.room.support;

import S7.k;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2001a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(int i, Object obj, Object obj2) {
        this.f2001a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f2001a) {
            case 0:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeWithRefCount$lambda$5((AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement) this.b, (k) this.c, (SupportSQLiteDatabase) obj);
            default:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$8((String) this.b, (Object[]) this.c, (SupportSQLiteDatabase) obj);
        }
    }
}
