package g9;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import s8.b3;
import s8.v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4445c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4446f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4447g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4448h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(Object obj, Object obj2, Object obj3, nb.c cVar, int i) {
        super(2, cVar);
        this.f4445c = i;
        this.f4446f = obj;
        this.f4448h = obj2;
        this.f4447g = obj3;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4445c) {
            case 0:
                f0 f0Var = new f0((JSONObject) this.f4448h, (String) this.f4447g, cVar, 0);
                f0Var.f4446f = obj;
                return f0Var;
            case 1:
                f0 f0Var2 = new f0((b0) this.f4448h, (String) this.f4447g, cVar, 1);
                f0Var2.f4446f = obj;
                return f0Var2;
            case 2:
                return new f0((m8.a) this.f4446f, (Context) this.f4448h, (m8.k0) this.f4447g, cVar, 2);
            case 3:
                return new f0((m8.k0) this.f4446f, (Resources) this.f4448h, (String) this.f4447g, cVar, 3);
            case 4:
                return new f0((List) this.f4446f, (xb.p) this.f4448h, (m8.l0) this.f4447g, cVar, 4);
            case 5:
                return new f0((List) this.f4446f, (k0.c1) this.f4448h, (k0.c1) this.f4447g, cVar, 5);
            case 6:
                return new f0((b3) this.f4446f, (Context) this.f4448h, (b.m) this.f4447g, cVar, 6);
            default:
                f0 f0Var3 = new f0((v3) this.f4448h, (Set) this.f4447g, cVar, 7);
                f0Var3.f4446f = obj;
                return f0Var3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Exception {
        switch (this.f4445c) {
            case 0:
                f0 f0Var = (f0) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                f0Var.invokeSuspend(vVar);
                return vVar;
            case 1:
                return ((f0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 2:
                f0 f0Var2 = (f0) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                f0Var2.invokeSuspend(vVar2);
                return vVar2;
            case 3:
                return ((f0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 4:
                f0 f0Var3 = (f0) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar3 = jb.v.f6774a;
                f0Var3.invokeSuspend(vVar3);
                return vVar3;
            case 5:
                f0 f0Var4 = (f0) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar4 = jb.v.f6774a;
                f0Var4.invokeSuspend(vVar4);
                return vVar4;
            case 6:
                f0 f0Var5 = (f0) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar5 = jb.v.f6774a;
                f0Var5.invokeSuspend(vVar5);
                return vVar5;
            default:
                f0 f0Var6 = (f0) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar6 = jb.v.f6774a;
                f0Var6.invokeSuspend(vVar6);
                return vVar6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [java.lang.Cloneable, java.lang.String[]] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Exception {
        l8.a aVar;
        int iNextIndex;
        s8.m1 m1Var;
        Object objL;
        int i = this.f4445c;
        String str = "";
        Object obj2 = this.f4448h;
        Object objL2 = jb.v.f6774a;
        Object obj3 = this.f4447g;
        switch (i) {
            case 0:
                y3.b bVar = (y3.b) this.f4446f;
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                bVar.d(g0.f4459b, ((JSONObject) obj2).toString());
                bVar.d(g0.f4460c, new Long(System.currentTimeMillis()));
                bVar.d(g0.f4461d, (String) obj3);
                return objL2;
            case 1:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                b0 b0Var = (b0) obj2;
                String str2 = (String) obj3;
                try {
                    l8.b bVar2 = l8.b.f7755a;
                    aa.g gVar = new aa.g(3);
                    gVar.f319f = b0Var;
                    gVar.f320g = str2;
                    VarHandle.storeStoreFence();
                    ad.n nVarE = l8.b.e();
                    aVar = (l8.a) gVar.invoke(nVarE);
                    if (aVar.f7752a == 401) {
                        String strA = nVarE.a("Authorization");
                        if (strA != null) {
                            str = strA;
                        }
                        if (bVar2.d(str)) {
                            aVar = (l8.a) gVar.invoke(l8.b.e());
                        }
                    }
                } catch (Throwable th) {
                    objL2 = id.c.l(th);
                }
                if (!aVar.a()) {
                    throw new IOException("HTTP " + aVar.f7752a);
                }
                Throwable thB = jb.i.b(objL2);
                if (thB != null) {
                    Log.w("PermissionReport", "permission report post failed: " + thB.getMessage());
                }
                return jb.i.a(objL2);
            case 2:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                String str3 = ((m8.a) this.f4446f).f8290w;
                if (str3 != null) {
                    Toast.makeText((Context) obj2, str3, 0).show();
                    m8.k0 k0Var = (m8.k0) obj3;
                    if (k0Var.v().f8290w != null) {
                        k0Var.U(m8.a.a(k0Var.v(), false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1069547519));
                    }
                }
                return objL2;
            case 3:
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                m8.k0 k0Var2 = (m8.k0) this.f4446f;
                Map map = (Map) k0Var2.S().f6771g;
                r2.i iVar = t8.c.f13223h;
                Application application = k0Var2.f1355b;
                application.getClass();
                t8.c cVarL = iVar.l(application);
                return t0.a.h((String) obj3, kb.b0.R(cVarL.g().keySet(), cVarL.h()), map);
            case 4:
                ob.a aVar6 = ob.a.f9351c;
                id.c.I(obj);
                List list = (List) this.f4446f;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                    } else if (((s8.m1) listIterator.previous()).f11794c) {
                        iNextIndex = listIterator.nextIndex();
                    }
                }
                ((xb.p) obj2).invoke((m8.l0) obj3, new Integer(iNextIndex));
                return objL2;
            case 5:
                ob.a aVar7 = ob.a.f9351c;
                id.c.I(obj);
                k0.c1 c1Var = (k0.c1) obj2;
                float f5 = s8.w0.f12043g;
                Integer num = (Integer) c1Var.getValue();
                if (num != null && ((m1Var = (s8.m1) kb.l.y0(num.intValue(), (List) this.f4446f)) == null || (m1Var.f11796e <= 0 && m1Var.f11797f <= 0 && m1Var.f11798g <= 0))) {
                    c1Var.setValue(null);
                    ((k0.c1) obj3).setValue(null);
                }
                return objL2;
            case 6:
                ob.a aVar8 = ob.a.f9351c;
                id.c.I(obj);
                if (!s8.g1.B((Context) obj2, (b3) this.f4446f)) {
                    ((b.m) obj3).a(new String[]{PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO, PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO});
                }
                return objL2;
            default:
                y3.b bVar3 = (y3.b) this.f4446f;
                ob.a aVar9 = ob.a.f9351c;
                id.c.I(obj);
                try {
                    String str4 = (String) bVar3.c(v3.f12030b);
                    if (str4 != null) {
                        str = str4;
                    }
                    if (hc.h.g0(str)) {
                        str = "[]";
                    }
                    objL = new JSONArray(str);
                } catch (Throwable th2) {
                    objL = id.c.l(th2);
                }
                Object jSONArray = new JSONArray();
                if (objL instanceof jb.h) {
                    objL = jSONArray;
                }
                JSONArray jSONArray2 = (JSONArray) objL;
                Set set = (Set) obj3;
                lb.i iVar2 = new lb.i();
                int length = jSONArray2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String strOptString = jSONArray2.optString(i3);
                    strOptString.getClass();
                    String string = hc.h.w0(strOptString).toString();
                    if (string.length() > 0) {
                        iVar2.add(string);
                    }
                }
                iVar2.addAll(set);
                bVar3.d(v3.f12030b, new JSONArray((Collection) kb.l.L0(h5.t.n(iVar2))).toString());
                return objL2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(Object obj, Object obj2, nb.c cVar, int i) {
        super(2, cVar);
        this.f4445c = i;
        this.f4448h = obj;
        this.f4447g = obj2;
    }
}
