package androidx.compose.runtime;

import android.content.ContentValues;
import androidx.collection.MutableObjectIntMap;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1754a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ h(int i, int i6, Object obj, Object obj2) {
        this.f1754a = i6;
        this.c = obj;
        this.b = i;
        this.d = obj2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1754a) {
            case 0:
                return RecomposeScopeImpl.end$lambda$9$lambda$8((RecomposeScopeImpl) this.c, this.b, (MutableObjectIntMap) this.d, (Composition) obj);
            default:
                return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.insert$lambda$4((String) this.c, this.b, (ContentValues) this.d, (SupportSQLiteDatabase) obj));
        }
    }
}
