package aa;

import ad.e0;
import ad.h0;
import ad.y;
import ad.z;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.lifecycle.l0;
import com.stepos.agentsafetycenter.MainActivity;
import d2.x;
import g9.b0;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jb.v;
import k0.c1;
import k8.d0;
import kc.w;
import m8.k0;
import org.json.JSONObject;
import p.f0;
import s8.b3;
import s8.g1;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f325c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f326f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f327g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f328h;

    public /* synthetic */ j(int i) {
        this.f325c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [nb.c] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.view.View, android.view.ViewGroup, cb.b, java.lang.Object] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        u8.j jVar;
        z8.g gVar;
        String str;
        u8.h hVar;
        List list;
        int i = this.f325c;
        String str2 = "";
        int i3 = 2;
        v vVar = v.f6774a;
        int i10 = 1;
        list = null;
        list = null;
        list = null;
        List list2 = null;
        switch (i) {
            case 0:
                n nVar = (n) this.f326f;
                Class cls = (Class) this.f327g;
                Object obj2 = this.f328h;
                obj.getClass();
                if (nVar.f338j) {
                    z9.f fVar = z9.f.f16523a;
                    z9.f.b(obj, "setPathProvider", new Class[]{cls}, null);
                }
                z9.f fVar2 = z9.f.f16523a;
                Class cls2 = z9.f.i;
                Class cls3 = z9.f.f16530h;
                z9.f.b(obj, "setGlassText", new Class[]{cls2, cls3, cls3}, Boolean.TRUE, Float.valueOf(96.0f), Float.valueOf(0.0f));
                z9.f.b(obj, "setPathProvider", new Class[]{cls}, obj2);
                return vVar;
            case 1:
                kc.t tVar = (kc.t) this.f326f;
                e9.h hVar2 = (e9.h) this.f327g;
                c1 c1Var = (c1) this.f328h;
                if (((Boolean) obj).booleanValue()) {
                    w.u(tVar, null, null, new e9.t(hVar2, I, i3), 3);
                } else {
                    c1Var.setValue(Boolean.TRUE);
                }
                return vVar;
            case 2:
                b0 b0Var = (b0) this.f326f;
                String str3 = (String) this.f327g;
                String str4 = (String) this.f328h;
                ad.n nVar2 = (ad.n) obj;
                Log.i("PermissionCloudApi", str3 + " url=" + b0Var.f4408a);
                Set set = p9.a.f9925a;
                Log.i("PermissionCloudApi", str3 + " " + p9.a.a(str4, "body"));
                l8.b bVar = l8.b.f7755a;
                boolean zC = l8.b.c();
                boolean zG0 = hc.h.g0(l8.b.b()) ^ true;
                String strA = nVar2.a("Authorization");
                if (strA == null) {
                    strA = "";
                }
                Log.i("PermissionCloudApi", str3 + " authReady=" + zC + " hasLocalAccount=" + zG0 + " auth=" + p9.a.c(strA));
                JSONObject jSONObjectB = p9.a.b(nVar2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(" headers=");
                sb2.append(jSONObjectB);
                Log.i("PermissionCloudApi", sb2.toString());
                y yVar = new y();
                yVar.o(b0Var.f4408a);
                yVar.f633c = nVar2.c();
                yVar.l("POST", td.h.l(str4, b0Var.f4410c));
                z zVarE = yVar.e();
                ad.w wVar = b0Var.f4409b;
                wVar.getClass();
                e0 e0VarE = new ed.j(wVar, zVarE).e();
                try {
                    int i11 = e0VarE.f471h;
                    h0 h0Var = e0VarE.f473k;
                    I = h0Var != null ? h0Var.i() : 0;
                    if (I != 0) {
                        str2 = I;
                    }
                    l8.a aVar = new l8.a(i11, str2, e0VarE.f472j);
                    e0VarE.close();
                    return aVar;
                } finally {
                }
            case 3:
                List list3 = (List) this.f326f;
                c1 c1Var2 = (c1) this.f327g;
                c1 c1Var3 = (c1) this.f328h;
                x.f fVar3 = (x.f) obj;
                fVar3.getClass();
                fVar3.b(list3.size(), new b0.n(i, new x(27), list3), new e9.x(1, list3), new s0.c(-1091073711, true, new j9.g(list3, c1Var2, c1Var3)));
                return vVar;
            case 4:
                kc.t tVar2 = (kc.t) this.f326f;
                k0 k0Var = (k0) this.f327g;
                c1 c1Var4 = (c1) this.f328h;
                k8.a aVar2 = (k8.a) obj;
                int i12 = MainActivity.f2491h;
                aVar2.getClass();
                w.u(tVar2, null, null, new l0(k0Var, aVar2, c1Var4, null, 10), 3);
                return vVar;
            case 5:
                MainActivity mainActivity = (MainActivity) this.f326f;
                xb.a aVar3 = (xb.a) this.f327g;
                c1 c1Var5 = (c1) this.f328h;
                d0 d0Var = (d0) obj;
                int i13 = MainActivity.f2491h;
                d0Var.getClass();
                if (((Boolean) mainActivity.f2493f.getValue()).booleanValue()) {
                    aVar3.invoke();
                } else {
                    c1Var5.setValue(d0Var);
                }
                return vVar;
            case 6:
                List<l9.f> list4 = (List) this.f326f;
                Context context = (Context) this.f327g;
                o2.c cVar = (o2.c) this.f328h;
                ?? r12 = (cb.b) obj;
                r12.getClass();
                r12.removeAllViews();
                for (l9.f fVar4 : list4) {
                    cb.i iVar = new cb.i(context, null, 0, 6, null);
                    iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    String str5 = fVar4.f7778b;
                    Integer num = fVar4.f7779c;
                    iVar.setTitle(str5);
                    iVar.setSubtitle((CharSequence) null);
                    if (num != null) {
                        iVar.setShowIcon(true);
                        iVar.setIconStyle(1);
                        iVar.setIconTint(null);
                        iVar.setIcon(context.getDrawable(num.intValue()));
                        if (fVar4.f7780d != null) {
                            iVar.setIconSize((int) (cVar.a() * r7.intValue()));
                        }
                    } else {
                        iVar.setShowIcon(false);
                    }
                    iVar.setShowAccessory(true);
                    iVar.setPressScaleEnabled(false);
                    xb.a aVar4 = fVar4.f7781e;
                    if (aVar4 != null) {
                        iVar.setClickable(true);
                        b.b bVar2 = new b.b(i3);
                        bVar2.f1685f = aVar4;
                        VarHandle.storeStoreFence();
                        iVar.setOnItemClickListener(bVar2);
                    } else {
                        iVar.setClickable(false);
                        iVar.setOnItemClickListener(null);
                    }
                    r12.addView(iVar);
                }
                r12.setVisibility(list4.isEmpty() ? 8 : 0);
                return vVar;
            case 7:
                b3 b3Var = (b3) this.f326f;
                Context context2 = (Context) this.f327g;
                c1 c1Var6 = (c1) this.f328h;
                ((Map) obj).getClass();
                c1Var6.setValue(Boolean.valueOf(g1.B(context2, b3Var)));
                return vVar;
            case 8:
                t0.e eVar = (t0.e) this.f326f;
                Object obj3 = this.f328h;
                t0.j jVar2 = (t0.j) this.f327g;
                f0 f0Var = eVar.f13114f;
                if (f0Var.b(obj3)) {
                    ad.o.l("Key ", obj3, " was used multiple times ");
                    return null;
                }
                eVar.f13113c.remove(obj3);
                f0Var.m(obj3, jVar2);
                r.f fVar5 = new r.f(i10);
                fVar5.f10275c = eVar;
                fVar5.f10274b = obj3;
                fVar5.f10276d = jVar2;
                VarHandle.storeStoreFence();
                return fVar5;
            case 9:
                Map map = (Map) this.f326f;
                Map map2 = (Map) this.f327g;
                Map map3 = (Map) this.f328h;
                p3 p3Var = (p3) obj;
                p3Var.getClass();
                u8.p pVarK = t0.a.k(p3Var.f11898y);
                u8.p pVar = u8.p.f14246h;
                if (pVarK == pVar) {
                    return p3.a(p3Var, null, null, null, null, null, null, null, 0L, pVar, null, null, null, 503316479);
                }
                String string = hc.h.w0(p3Var.f11886m).toString();
                int iOrdinal = pVarK.ordinal();
                if (iOrdinal == 0) {
                    jVar = (u8.j) map2.get(string);
                } else if (iOrdinal == 1) {
                    jVar = (u8.j) map.get(string);
                } else if (iOrdinal == 2) {
                    jVar = (u8.j) map3.get(string);
                } else {
                    if (iOrdinal != 3) {
                        g5.f.a();
                        return null;
                    }
                    jVar = null;
                }
                u8.i iVar2 = jVar != null ? jVar.f14215c : u8.i.f14209c;
                int iOrdinal2 = iVar2.ordinal();
                if (iOrdinal2 == 0) {
                    gVar = z8.g.f16510f;
                } else if (iOrdinal2 == 1) {
                    gVar = z8.g.f16511g;
                } else {
                    if (iOrdinal2 != 2) {
                        g5.f.a();
                        return null;
                    }
                    gVar = z8.g.i;
                }
                z8.g gVar2 = gVar;
                List list5 = jVar != null ? jVar.f14216d : null;
                kb.s sVar = kb.s.f7404c;
                List list6 = list5 == null ? sVar : list5;
                List list7 = jVar != null ? jVar.f14218f : null;
                List list8 = list7 == null ? sVar : list7;
                if (jVar != null && (hVar = jVar.f14217e) != null && (list = hVar.f14208a) != null && !list.isEmpty()) {
                    list2 = list;
                }
                boolean z10 = iVar2 == u8.i.f14210f;
                u8.a aVar5 = (u8.a) kb.l.x0(list6);
                List list9 = list2 == null ? p3Var.f11890q : list2;
                if (list2 == null || (str = (String) kb.l.x0(list2)) == null) {
                    str = p3Var.f11889p;
                }
                return p3.a(p3Var, gVar2, Boolean.valueOf(z10), null, null, null, str, list9, 0L, pVarK, aVar5, list6, list8, 33455743);
            default:
                b0 b0Var2 = (b0) this.f326f;
                String str6 = (String) this.f327g;
                String str7 = (String) this.f328h;
                ad.n nVar3 = (ad.n) obj;
                b0Var2.getClass();
                Log.i("LedgerCloudApi", "======== " + str6 + " REQUEST ========");
                Log.i("LedgerCloudApi", "method=POST");
                String str8 = b0Var2.f4408a;
                Log.i("LedgerCloudApi", "url=" + str8);
                Log.i("LedgerCloudApi", "path=/v1/tool_security/device/policy/snapshot");
                Log.i("LedgerCloudApi", "contentType=application/json; charset=utf-8");
                Log.i("LedgerCloudApi", "requestBody=" + str7);
                l8.b bVar3 = l8.b.f7755a;
                boolean zC2 = l8.b.c();
                boolean zG02 = true ^ hc.h.g0(l8.b.b());
                Set set2 = p9.a.f9925a;
                String strA2 = nVar3.a("Authorization");
                if (strA2 == null) {
                    strA2 = "";
                }
                Log.i("LedgerCloudApi", "authReady=" + zC2 + " hasLocalAccount=" + zG02 + " Authorization=" + p9.a.c(strA2));
                JSONObject jSONObjectB2 = p9.a.b(nVar3);
                StringBuilder sb3 = new StringBuilder("requestHeaders=");
                sb3.append(jSONObjectB2);
                Log.i("LedgerCloudApi", sb3.toString());
                Log.i("LedgerCloudApi", "======== " + str6 + " REQUEST END ========");
                y yVar2 = new y();
                yVar2.o(str8);
                yVar2.f633c = nVar3.c();
                yVar2.l("POST", td.h.l(str7, b0Var2.f4410c));
                z zVarE2 = yVar2.e();
                ad.w wVar2 = b0Var2.f4409b;
                wVar2.getClass();
                e0 e0VarE2 = new ed.j(wVar2, zVarE2).e();
                try {
                    int i14 = e0VarE2.f471h;
                    h0 h0Var2 = e0VarE2.f473k;
                    String strI = h0Var2 != null ? h0Var2.i() : null;
                    if (strI != null) {
                        str2 = strI;
                    }
                    l8.a aVar6 = new l8.a(i14, str2, e0VarE2.f472j);
                    e0VarE2.close();
                    return aVar6;
                } finally {
                }
        }
    }
}
