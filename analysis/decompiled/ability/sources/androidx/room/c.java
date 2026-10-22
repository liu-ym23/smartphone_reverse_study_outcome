package androidx.room;

import S7.k;
import androidx.sqlite.SQLiteConnection;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1996a;
    public final /* synthetic */ S7.a b;

    public /* synthetic */ c(int i, S7.a aVar) {
        this.f1996a = i;
        this.b = aVar;
    }

    @Override // S7.k
    public final Object invoke(Object it) {
        switch (this.f1996a) {
            case 0:
                return RoomDatabase.runInTransaction$lambda$12(this.b, (SQLiteConnection) it);
            default:
                kotlin.jvm.internal.k.f(it, "it");
                return this.b.invoke();
        }
    }
}
