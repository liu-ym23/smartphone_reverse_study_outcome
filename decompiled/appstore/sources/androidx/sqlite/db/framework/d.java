package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class d implements SupportSQLiteOpenHelper.Factory {
    public d() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.b r10) {
        q.g(r10, "configuration");
        return new FrameworkSQLiteOpenHelper(r10.f4782a, r10.f4783b, r10.f4784c, r10.f4785d, r10.f4786e);
    }
}
