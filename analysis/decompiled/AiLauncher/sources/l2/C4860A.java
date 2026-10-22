package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* renamed from: l2.A, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C4860A implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final B f36875a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f36876b;

    public C4860A(B b10, e2.m mVar) {
        this.f36875a = b10;
        this.f36876b = mVar;
    }

    public static B.b a(B b10, e2.m mVar) {
        return new C4860A(b10, mVar);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.v0(this.f36875a, this.f36876b, (SQLiteDatabase) obj);
    }
}
