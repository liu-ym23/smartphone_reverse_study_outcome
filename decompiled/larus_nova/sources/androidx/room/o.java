package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class o implements Function {
    public /* synthetic */ o() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object r100) {
        return Boolean.valueOf(((SupportSQLiteDatabase) r100).yieldIfContendedSafely());
    }
}
