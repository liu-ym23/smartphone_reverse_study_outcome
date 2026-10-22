package k2;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.graphics.Typeface;
import g2.p;
import g2.q;
import g2.s;
import java.lang.invoke.VarHandle;
import p5.m;
import xb.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7178c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7179f;

    public /* synthetic */ c(int i) {
        this.f7178c = i;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        int i = this.f7178c;
        Object obj5 = this.f7179f;
        switch (i) {
            case 0:
                d dVar = (d) obj5;
                q qVar = (q) obj;
                g2.d dVar2 = dVar.f7184e;
                int i3 = ((g2.i) obj3).f4249a;
                int i10 = ((g2.j) obj4).f4250a;
                g2.e eVar = (g2.e) dVar2;
                p pVar = eVar.f4243a;
                pVar.getClass();
                s sVarA = eVar.a(new g2.r(qVar, pVar.a((g2.k) obj2), i3, i10, null));
                if (sVarA instanceof s) {
                    Object obj6 = sVarA.f4266c;
                    obj6.getClass();
                    return (Typeface) obj6;
                }
                m mVar = dVar.f7188j;
                m mVar2 = new m(12);
                mVar2.f9741f = sVarA;
                mVar2.f9742g = mVar;
                Object obj7 = sVarA.f4266c;
                mVar2.f9743h = obj7;
                VarHandle.storeStoreFence();
                dVar.f7188j = mVar2;
                obj7.getClass();
                return (Typeface) obj7;
            default:
                SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
                sQLiteQuery.getClass();
                z4.i iVar = new z4.i();
                iVar.f16408c = sQLiteQuery;
                ((y4.e) obj5).g(iVar);
                return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
        }
    }
}
