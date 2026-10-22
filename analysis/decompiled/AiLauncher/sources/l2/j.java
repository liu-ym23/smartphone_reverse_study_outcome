package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f36920a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f36921b;

    public j(long j10, e2.m mVar) {
        this.f36920a = j10;
        this.f36921b = mVar;
    }

    public static B.b a(long j10, e2.m mVar) {
        return new j(j10, mVar);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.f1(this.f36920a, this.f36921b, (SQLiteDatabase) obj);
    }
}
