package k8;

import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s8.a3;
import s8.g1;
import s8.y2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7299c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f7300f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f7299c = i;
        this.f7300f = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f7299c) {
            case 0:
                return new f((androidx.activity.p) this.f7300f, cVar, 0);
            case 1:
                return new f((s2.m) this.f7300f, cVar, 1);
            case 2:
                return new f((a3) this.f7300f, cVar, 2);
            default:
                return new f((w5.e) this.f7300f, cVar, 3);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f7299c) {
            case 0:
                return ((f) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
            case 1:
                f fVar = (f) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                fVar.invokeSuspend(vVar);
                return vVar;
            case 2:
                f fVar2 = (f) create(tVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                fVar2.invokeSuspend(vVar2);
                return vVar2;
            default:
                return ((f) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objL;
        switch (this.f7299c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                androidx.activity.p pVar = (androidx.activity.p) this.f7300f;
                pVar.getApplicationContext().getSharedPreferences("installed_apps_consent", 0).edit().putBoolean("user_granted", true).apply();
                try {
                    objL = pVar.getPackageManager().getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                Throwable thB = jb.i.b(objL);
                if (thB != null) {
                    Log.w("InstalledAppsAccess", "queryInstalledApplications failed", thB);
                }
                kb.s sVar = kb.s.f7404c;
                if (objL instanceof jb.h) {
                    objL = sVar;
                }
                boolean z10 = !((List) objL).isEmpty();
                Log.i("InstalledAppsAccess", "grantUserConsentAndProbe ok=" + z10);
                return Boolean.valueOf(z10);
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                ((s2.m) this.f7300f).show();
                return jb.v.f6774a;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                a3 a3Var = (a3) this.f7300f;
                if (a3Var != null) {
                    List list = a3Var.f11452b;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        kb.q.p0(g1.r((y2) it.next()), arrayList);
                    }
                    jb.g gVar = new jb.g("data_type", p5.f.G(arrayList));
                    int size = arrayList.size();
                    td.h.P("dialog_revoke_confirm_show", "revoke_confirm_dialog", kb.w.N(gVar, new jb.g("data_count", String.valueOf(size >= 0 ? size : 0))));
                }
                return jb.v.f6774a;
            default:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                w5.e eVar = (w5.e) this.f7300f;
                synchronized (eVar) {
                    if (!eVar.f15257p || eVar.f15258q) {
                        return jb.v.f6774a;
                    }
                    try {
                        eVar.H();
                    } catch (IOException unused) {
                        eVar.f15259r = true;
                    }
                    try {
                        if ((eVar.f15254m >= 2000 ? 1 : 0) != 0) {
                            eVar.N();
                        }
                    } catch (IOException unused2) {
                        eVar.f15260s = true;
                        eVar.f15255n = ac.a.j(new od.e());
                    }
                    return jb.v.f6774a;
                }
        }
    }
}
