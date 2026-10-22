package B0;

import K.S;
import K.e0;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.room.A;
import androidx.room.E;
import androidx.work.impl.WorkDatabase;
import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import stepos.support.v7.app.AbstractC0880z;
import stepos.support.v7.app.InterfaceC0867l;
import t0.J;

/* loaded from: classes.dex */
public final class e implements G1.p, t3.d, K3.b {

    /* renamed from: d, reason: collision with root package name */
    public static e f140d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f141a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f142b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f143c;

    public /* synthetic */ e(Object obj, Object obj2, int i4) {
        this.f141a = i4;
        this.f143c = obj;
        this.f142b = obj2;
    }

    public final void a(Object obj, String str) {
        ((List) this.f142b).add(str + Consts.SPLITTER_EQUAL + String.valueOf(obj));
    }

    @Override // K3.b
    public final boolean b(K3.c cVar, L3.k kVar) {
        return ((K3.b) this.f142b).b(cVar, kVar);
    }

    @Override // t3.d
    public final void c(long j4) {
        if (((y3.l) this.f143c).f16384e == Thread.currentThread()) {
            ((t3.d) this.f142b).c(j4);
        } else {
            ((y3.l) this.f143c).f16385f.f16387b.b(new y3.k(this, j4));
        }
    }

    @Override // K3.b
    public final boolean d(K3.c cVar, MenuItem menuItem) {
        return ((K3.b) this.f142b).d(cVar, menuItem);
    }

    @Override // K3.b
    public final void e(K3.c cVar) {
        ((K3.b) this.f142b).e(cVar);
        AbstractC0880z abstractC0880z = (AbstractC0880z) this.f143c;
        if (abstractC0880z.f14633v != null) {
            abstractC0880z.f14510b.getDecorView().removeCallbacks(((AbstractC0880z) this.f143c).f14634w);
        }
        AbstractC0880z abstractC0880z2 = (AbstractC0880z) this.f143c;
        if (abstractC0880z2.f14632u != null) {
            abstractC0880z2.s();
            AbstractC0880z abstractC0880z3 = (AbstractC0880z) this.f143c;
            e0 e0VarA = S.a(abstractC0880z3.f14632u);
            e0VarA.a(Property.DEFAULT_FLOAT_VALUE);
            abstractC0880z3.f14635x = e0VarA;
            ((AbstractC0880z) this.f143c).f14635x.e(new androidx.appcompat.app.t(5, this));
        }
        AbstractC0880z abstractC0880z4 = (AbstractC0880z) this.f143c;
        InterfaceC0867l interfaceC0867l = abstractC0880z4.f14513e;
        if (interfaceC0867l != null) {
            interfaceC0867l.onSupportActionModeFinished(abstractC0880z4.f14631t);
        }
        ((AbstractC0880z) this.f143c).f14631t = null;
    }

    public final boolean f(k id) {
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f142b) {
            zContainsKey = ((Map) this.f143c).containsKey(id);
        }
        return zContainsKey;
    }

    public final Long g(String str) {
        E eD = E.d(1, "SELECT long_value FROM Preference where `key`=?");
        eD.bindString(1, str);
        ((A) this.f142b).assertNotSuspendingTransaction();
        Cursor cursorH = J.H((A) this.f142b, eD);
        try {
            Long lValueOf = null;
            if (cursorH.moveToFirst() && !cursorH.isNull(0)) {
                lValueOf = Long.valueOf(cursorH.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // K3.b
    public final boolean h(K3.c cVar, L3.k kVar) {
        return ((K3.b) this.f142b).h(cVar, kVar);
    }

    @Override // G1.p
    public final Object i() {
        throw new F1.q((String) this.f142b, 5);
    }

    public final void j(d dVar) {
        ((A) this.f142b).assertNotSuspendingTransaction();
        ((A) this.f142b).beginTransaction();
        try {
            ((androidx.room.k) this.f143c).insert(dVar);
            ((A) this.f142b).setTransactionSuccessful();
        } finally {
            ((A) this.f142b).endTransaction();
        }
    }

    public final void k(int i4) throws Resources.NotFoundException {
        ((Context) this.f143c).getResources().getResourceName(i4);
    }

    public final List l(String workSpecId) {
        List list;
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        synchronized (this.f142b) {
            try {
                Map map = (Map) this.f143c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (Intrinsics.areEqual(((k) entry.getKey()).f150a, workSpecId)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    ((Map) this.f143c).remove((k) it.next());
                }
                list = CollectionsKt.toList(linkedHashMap.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public final t0.x m(k id) {
        t0.x xVar;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f142b) {
            xVar = (t0.x) ((Map) this.f143c).remove(id);
        }
        return xVar;
    }

    public final t0.x n(k id) {
        t0.x xVar;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f142b) {
            try {
                Map map = (Map) this.f143c;
                Object xVar2 = map.get(id);
                if (xVar2 == null) {
                    xVar2 = new t0.x(id);
                    map.put(id, xVar2);
                }
                xVar = (t0.x) xVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public final String toString() {
        switch (this.f141a) {
            case 2:
                return "Bounds{lower=" + ((D.c) this.f142b) + " upper=" + ((D.c) this.f143c) + "}";
            case 6:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f143c.getClass().getSimpleName());
                sb.append('{');
                int size = ((List) this.f142b).size();
                for (int i4 = 0; i4 < size; i4++) {
                    sb.append((String) ((List) this.f142b).get(i4));
                    if (i4 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ e(Object obj) {
        this.f141a = 6;
        com.stepos.statsrpk.c.l(obj);
        this.f143c = obj;
        this.f142b = new ArrayList();
    }

    public e(WorkDatabase workDatabase) {
        this.f141a = 0;
        this.f142b = workDatabase;
        this.f143c = new b(this, workDatabase, 1);
    }

    public e(Application application) {
        this.f141a = 9;
        this.f142b = new Handler(Looper.getMainLooper());
        this.f143c = application;
    }

    public e() {
        this.f141a = 4;
        this.f142b = new Object();
        this.f143c = new LinkedHashMap();
    }

    public e(q1.h hVar, q1.h hVar2) {
        this.f141a = 7;
        hVar.getClass();
        hVar2.getClass();
        if (Property.DEFAULT_FLOAT_VALUE <= Property.DEFAULT_FLOAT_VALUE) {
            this.f142b = hVar;
            this.f143c = hVar2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
