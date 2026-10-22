package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final B f36922a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f36923b;

    public k(B b10, e2.m mVar) {
        this.f36922a = b10;
        this.f36923b = mVar;
    }

    public static B.b a(B b10, e2.m mVar) {
        return new k(b10, mVar);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.N0(this.f36922a, this.f36923b, (SQLiteDatabase) obj);
    }
}
