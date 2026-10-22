package n3;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.view.ViewStructure;
import c7.r;
import p7.p;
import q7.k;
import q7.m;

/* loaded from: classes.dex */
public final class b extends m implements p {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6814g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6815h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, Object obj) {
        super(4);
        this.f6814g = i2;
        this.f6815h = obj;
    }

    @Override // p7.p
    public final Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.f6814g) {
            case 0:
                SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
                m3.c cVar = (m3.c) this.f6815h;
                k.b(sQLiteQuery);
                cVar.b(new i(sQLiteQuery));
                return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
            default:
                int iIntValue = ((Number) obj).intValue();
                int iIntValue2 = ((Number) obj2).intValue();
                ((ViewStructure) this.f6815h).setDimens(iIntValue, iIntValue2, 0, 0, ((Number) obj3).intValue() - iIntValue, ((Number) obj4).intValue() - iIntValue2);
                return r.f1986a;
        }
    }
}
