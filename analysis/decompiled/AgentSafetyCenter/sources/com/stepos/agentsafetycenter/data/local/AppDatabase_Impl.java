package com.stepos.agentsafetycenter.data.local;

import androidx.room.f;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jb.k;
import kb.s;
import q8.a;
import q8.b;
import q8.h;
import yb.e;
import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: l, reason: collision with root package name */
    public final k f2502l;

    /* renamed from: m, reason: collision with root package name */
    public final k f2503m;

    public AppDatabase_Impl() {
        a aVar = new a(0);
        aVar.f10107f = this;
        VarHandle.storeStoreFence();
        this.f2502l = new k(aVar);
        a aVar2 = new a(1);
        aVar2.f10107f = this;
        VarHandle.storeStoreFence();
        this.f2503m = new k(aVar2);
    }

    @Override // androidx.room.u
    public final List d(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // androidx.room.u
    public final f e() {
        return new f(this, new LinkedHashMap(), new LinkedHashMap(), "dashboard_days", "intercept_reads");
    }

    @Override // androidx.room.u
    public final a4.f f() {
        return new b(this);
    }

    @Override // androidx.room.u
    public final Set k() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.u
    public final LinkedHashMap m() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        e eVarA = v.a(h.class);
        s sVar = s.f7404c;
        linkedHashMap.put(eVarA, sVar);
        linkedHashMap.put(v.a(q8.v.class), sVar);
        return linkedHashMap;
    }

    @Override // com.stepos.agentsafetycenter.data.local.AppDatabase
    public final h x() {
        return (h) this.f2502l.getValue();
    }

    @Override // com.stepos.agentsafetycenter.data.local.AppDatabase
    public final q8.v y() {
        return (q8.v) this.f2503m.getValue();
    }
}
