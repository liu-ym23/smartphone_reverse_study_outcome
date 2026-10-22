package i9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5859c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f5860f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Context context, int i, nb.c cVar) {
        super(2, cVar);
        this.f5859c = i;
        this.f5860f = context;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5859c) {
            case 0:
                return new f(this.f5860f, 0, cVar);
            case 1:
                return new f(this.f5860f, 1, cVar);
            default:
                return new f(this.f5860f, 2, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f5859c) {
            case 0:
                return ((f) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
            case 1:
                return ((f) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
            default:
                f fVar = (f) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                fVar.invokeSuspend(vVar);
                return vVar;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        Object objL;
        int i = this.f5859c;
        Context context = this.f5860f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                PackageManager packageManager = context.getPackageManager();
                try {
                    objL = context.getPackageManager().getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                Throwable thB = jb.i.b(objL);
                if (thB != null) {
                    Log.w("InstalledAppsAccess", "queryInstalledApplications failed", thB);
                }
                boolean z10 = objL instanceof jb.h;
                kb.s sVar = kb.s.f7404c;
                if (z10) {
                    objL = sVar;
                }
                gc.n nVarR0 = kb.l.r0((List) objL);
                d dVar = new d(0);
                dVar.f5849f = packageManager;
                VarHandle.storeStoreFence();
                gc.h hVar = new gc.h(nVarR0, true, dVar);
                d dVar2 = new d(1);
                dVar2.f5849f = packageManager;
                VarHandle.storeStoreFence();
                gc.i iVar = new gc.i(2);
                iVar.f4694b = hVar;
                iVar.f4695c = dVar2;
                VarHandle.storeStoreFence();
                e eVar = new e(2, a.f5826a, a.class, "compareLabels", "compareLabels(Ljava/lang/String;Ljava/lang/String;)I", 0, 0, 0);
                a2.y yVar = new a2.y(1);
                yVar.f149f = eVar;
                VarHandle.storeStoreFence();
                a2.a0 a0Var = new a2.a0(1);
                a0Var.f32f = yVar;
                VarHandle.storeStoreFence();
                ArrayList arrayList = new ArrayList();
                Iterator it = iVar.iterator();
                gc.b bVar = new gc.b(0);
                bVar.f4679h = it;
                bVar.i = new HashSet();
                VarHandle.storeStoreFence();
                while (bVar.hasNext()) {
                    arrayList.add(bVar.next());
                }
                kb.p.o0(a0Var, arrayList);
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    return sVar;
                }
                Object next = it2.next();
                if (!it2.hasNext()) {
                    return ac.a.E(next);
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(next);
                while (it2.hasNext()) {
                    arrayList2.add(it2.next());
                }
                return arrayList2;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                t8.c cVarK = t8.c.f13221f.k(applicationContext);
                List listD = cVarK.d();
                if (!listD.isEmpty()) {
                    Iterator it3 = listD.iterator();
                    while (it3.hasNext()) {
                        cVarK.m(((t8.f) it3.next()).f13233a);
                    }
                    Log.i("PendingSync", "undo sync retired; cleared outbox size=" + listD.size());
                }
                k9.c cVar = new k9.c();
                VarHandle.storeStoreFence();
                return cVar;
            default:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                r8.a aVar4 = r8.a.f10474a;
                context.getClass();
                r8.a.a(context);
                return jb.v.f6774a;
        }
    }
}
