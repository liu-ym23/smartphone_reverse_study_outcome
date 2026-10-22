package l2;

import android.database.sqlite.SQLiteDatabase;
import e2.AbstractC3981h;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class w implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final B f36937a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f36938b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC3981h f36939c;

    public w(B b10, e2.m mVar, AbstractC3981h abstractC3981h) {
        this.f36937a = b10;
        this.f36938b = mVar;
        this.f36939c = abstractC3981h;
    }

    public static B.b a(B b10, e2.m mVar, AbstractC3981h abstractC3981h) {
        return new w(b10, mVar, abstractC3981h);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.Y0(this.f36937a, this.f36938b, this.f36939c, (SQLiteDatabase) obj);
    }
}
