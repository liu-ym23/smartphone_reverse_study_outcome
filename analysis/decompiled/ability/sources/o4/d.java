package o4;

import C7.f;
import D7.v;
import D7.w;
import android.content.Context;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.bean.SlaFunctionDetail;
import com.stepos.ability.bean.SlaPermissionResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import n5.C1741a;
import p4.C1791a;
import s4.g;
import s4.h;
import s9.C1923c;
import z2.l;

/* loaded from: classes3.dex */
public final class d implements ISlaPermissionManager {

    /* renamed from: a, reason: collision with root package name */
    public final C1923c f5430a;
    public final C1741a b;
    public volatile Context c;
    public final f d;
    public final f e;
    public final f f;
    public volatile boolean g;

    public d() {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.f5430a = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.b = new C1741a(3);
        final int i = 0;
        this.d = kotlin.a.a(new S7.a(this) { // from class: o4.b
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                switch (i) {
                    case 0:
                        d dVar2 = this.b;
                        return new com.stepos.ability.permission.cache.a(new c(dVar2, 0), dVar2.f5430a, dVar2.b);
                    case 1:
                        d dVar3 = this.b;
                        return new com.stepos.ability.permission.cache.b(new c(dVar3, 1), dVar3.f5430a, dVar3.b);
                    default:
                        d dVar4 = this.b;
                        return new com.stepos.ability.permission.cache.c((com.stepos.ability.permission.cache.a) dVar4.d.getF4884a(), (com.stepos.ability.permission.cache.b) dVar4.e.getF4884a(), dVar4.f5430a, dVar4.b);
                }
            }
        });
        final int i6 = 1;
        this.e = kotlin.a.a(new S7.a(this) { // from class: o4.b
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        d dVar2 = this.b;
                        return new com.stepos.ability.permission.cache.a(new c(dVar2, 0), dVar2.f5430a, dVar2.b);
                    case 1:
                        d dVar3 = this.b;
                        return new com.stepos.ability.permission.cache.b(new c(dVar3, 1), dVar3.f5430a, dVar3.b);
                    default:
                        d dVar4 = this.b;
                        return new com.stepos.ability.permission.cache.c((com.stepos.ability.permission.cache.a) dVar4.d.getF4884a(), (com.stepos.ability.permission.cache.b) dVar4.e.getF4884a(), dVar4.f5430a, dVar4.b);
                }
            }
        });
        final int i10 = 2;
        this.f = kotlin.a.a(new S7.a(this) { // from class: o4.b
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                switch (i10) {
                    case 0:
                        d dVar2 = this.b;
                        return new com.stepos.ability.permission.cache.a(new c(dVar2, 0), dVar2.f5430a, dVar2.b);
                    case 1:
                        d dVar3 = this.b;
                        return new com.stepos.ability.permission.cache.b(new c(dVar3, 1), dVar3.f5430a, dVar3.b);
                    default:
                        d dVar4 = this.b;
                        return new com.stepos.ability.permission.cache.c((com.stepos.ability.permission.cache.a) dVar4.d.getF4884a(), (com.stepos.ability.permission.cache.b) dVar4.e.getF4884a(), dVar4.f5430a, dVar4.b);
                }
            }
        });
    }

    public final com.stepos.ability.permission.cache.c a() {
        return (com.stepos.ability.permission.cache.c) this.f.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.Map] */
    @Override // com.stepos.ability.api.ability.permission.ISlaPermissionManager
    public final SlaPermissionResult checkSlaPermission(List functions) {
        k.f(functions, "functions");
        try {
            C1791a c1791a = ((com.stepos.ability.permission.cache.a) this.d.getF4884a()).d;
            s4.e eVar = c1791a != null ? c1791a.f5538a : null;
            p4.b bVar = ((com.stepos.ability.permission.cache.b) this.e.getF4884a()).d;
            s4.f fVar = bVar != null ? bVar.f5539a : null;
            P3.c.b("SlaPermPolicy", "cache mode(age=" + ((com.stepos.ability.permission.cache.b) this.e.getF4884a()).b() + "ms,groups=" + (fVar != null ? fVar.f5985a.size() : -1) + ") mapping(age=" + ((com.stepos.ability.permission.cache.a) this.d.getF4884a()).a() + "ms,funcs=" + (eVar != null ? eVar.f5984a.size() : -1) + ")");
            h hVarR = M.a.R(functions, eVar, fVar);
            a().b();
            if (hVarR.f5987a) {
                SlaPermissionResult.Companion companion = SlaPermissionResult.INSTANCE;
                List<g> list = hVarR.e;
                ArrayList arrayList = new ArrayList(w.c0(list, 10));
                for (g gVar : list) {
                    arrayList.add(new SlaFunctionDetail(gVar.f5986a, gVar.b, gVar.c, gVar.d, gVar.f, gVar.g));
                }
                return companion.allowed(arrayList);
            }
            a().e(hVarR.b);
            SlaPermissionResult.Companion companion2 = SlaPermissionResult.INSTANCE;
            int i = hVarR.b;
            String str = hVarR.c;
            String str2 = hVarR.d;
            List<g> list2 = hVarR.e;
            ArrayList arrayList2 = new ArrayList(w.c0(list2, 10));
            for (g gVar2 : list2) {
                arrayList2.add(new SlaFunctionDetail(gVar2.f5986a, gVar2.b, gVar2.c, gVar2.d, gVar2.f, gVar2.g));
            }
            return companion2.denied(i, str, str2, arrayList2);
        } catch (Throwable th) {
            P3.c.f1086a.invoke(6, "Ability_".concat("SlaPermPolicy"), "checkSlaPermission threw -> DENY(fail-closed)", th);
            return SlaPermissionResult.INSTANCE.denied(5, (String) v.C0(functions), B7.a.k("internal error: ", th.getMessage()), EmptyList.f4893a);
        }
    }

    @Override // com.stepos.ability.api.ability.permission.ISlaPermissionManager
    public final void onAccountLoginStateChanged(boolean z10) {
        if (z10) {
            a().c("login");
            return;
        }
        a().getClass();
        long[] jArr = a.f5427a;
        P3.c.f1086a.invoke(3, "Ability_".concat("SlaPermRefresh"), "onUserLoggedOut: masked (refreshOnLogout=false)", null);
    }

    @Override // com.stepos.ability.api.ability.permission.ISlaPermissionManager
    public final void onAuthCardDecided(String toolCallId) {
        k.f(toolCallId, "toolCallId");
        P3.c.b("SlaPermPolicy", "onAuthCardDecided toolCallId=" + toolCallId + " -> schedule post-card refresh");
        a().d(toolCallId);
    }

    @Override // com.stepos.ability.api.ability.permission.ISlaPermissionManager
    public final void onNetworkAvailable() {
        a().c("network");
    }

    @Override // com.stepos.ability.api.ability.permission.ISlaPermissionManager
    public final void warmUp(Context context) {
        k.f(context, "context");
        if (this.g) {
            P3.c.f1086a.invoke(3, "Ability_".concat("SlaPermPolicy"), "warmUp: already done", null);
            return;
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.c = context.getApplicationContext();
            com.stepos.ability.permission.cache.b bVar = (com.stepos.ability.permission.cache.b) this.e.getF4884a();
            Context applicationContext = context.getApplicationContext();
            k.e(applicationContext, "getApplicationContext(...)");
            bVar.d(applicationContext);
            a().g();
            this.g = true;
            P3.c.b("SlaPermPolicy", "warmUp done (observer registered, both channels fetched)");
        }
    }
}
