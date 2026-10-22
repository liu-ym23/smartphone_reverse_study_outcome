package t;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k0.s1;
import k0.v1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i1 {
    public static final void a(s0.c cVar, k0.s sVar, int i) {
        k0.s sVar2;
        sVar.Z(674185128);
        if ((i & 3) == 2 && sVar.B()) {
            sVar.S();
            sVar2 = sVar;
        } else {
            s1 s1Var = t0.i.f13120a;
            t0.g gVar = (t0.g) sVar.j(s1Var);
            Object[] objArr = {gVar};
            p5.u uVarA = t0.l.a(y.k0.f15781c, new y.j0(gVar, 1));
            boolean zH = sVar.h(gVar);
            Object objM = sVar.M();
            if (zH || objM == k0.m.f6974a) {
                objM = new y3.d(gVar, 1);
                sVar.i0(objM);
            }
            xb.a aVar = (xb.a) objM;
            sVar2 = sVar;
            Object obj = (y.l0) t0.a.j(objArr, uVarA, aVar, sVar2, 0, 4);
            k0.z.a(s1Var.a(obj), s0.h.d(1863926504, new h0.k(12, obj, cVar), sVar2), sVar2, 56);
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new h0.g(cVar, i, 2);
        }
    }

    public static final t8.a d(String str) {
        str.getClass();
        return hc.h.X(str, "garbage_fallback", false) ? t8.a.f13208g : hc.h.X(str, "batch_trash", false) ? t8.a.f13207f : hc.h.X(str, "mediastore_trash", false) ? t8.a.f13206c : t8.a.f13209h;
    }

    public static final tc.a e(tc.a aVar) {
        if (aVar.getDescriptor().c()) {
            return aVar;
        }
        xc.y yVar = new xc.y();
        yVar.f15679a = aVar;
        vc.e descriptor = aVar.getDescriptor();
        descriptor.getClass();
        xc.h0 h0Var = new xc.h0();
        h0Var.f15632a = descriptor;
        h0Var.f15633b = descriptor.a() + '?';
        h0Var.f15634c = xc.a0.b(descriptor);
        VarHandle.storeStoreFence();
        yVar.f15680b = h0Var;
        VarHandle.storeStoreFence();
        return yVar;
    }

    public static z4.c h(stepos.support.v7.app.f fVar, SQLiteDatabase sQLiteDatabase) {
        fVar.getClass();
        z4.c cVar = (z4.c) fVar.f12315f;
        if (cVar != null && cVar.f16385c.equals(sQLiteDatabase)) {
            return cVar;
        }
        z4.c cVar2 = new z4.c();
        cVar2.f16385c = sQLiteDatabase;
        VarHandle.storeStoreFence();
        fVar.f12315f = cVar2;
        return cVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s1.g0 i(w.n0 r42, int r43, int r44, int r45, int r46, int r47, s1.h0 r48, java.util.List r49, s1.o0[] r50, int r51) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.i1.i(w.n0, int, int, int, int, int, s1.h0, java.util.List, s1.o0[], int):s1.g0");
    }

    public static final long n(String str, JSONObject jSONObject) throws JSONException {
        Long lW;
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return 0L;
        }
        Object obj = jSONObject.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (!(obj instanceof String) || (lW = hc.o.W(hc.h.w0((String) obj).toString())) == null) {
            return 0L;
        }
        return lW.longValue();
    }

    public static final void o(yb.s sVar, yb.q qVar, yb.q qVar2, ArrayList arrayList, ArrayList arrayList2, JSONObject jSONObject) {
        String str;
        yb.q qVar3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        yb.q qVar4;
        int iOptInt = jSONObject.optInt("state", -1);
        if (iOptInt != 0 && iOptInt != 1 && iOptInt != 2) {
            if (iOptInt == 3) {
                sVar.f16096c++;
                return;
            }
            if (iOptInt == 4) {
                qVar.f16094c = true;
                String strP = k0.a.p("name", jSONObject);
                str = strP.length() > 0 ? strP : null;
                if (str != null) {
                    arrayList2.add(str);
                    return;
                }
                return;
            }
            if (iOptInt == 5) {
                qVar2.f16094c = true;
                String strP2 = k0.a.p("name", jSONObject);
                str = strP2.length() > 0 ? strP2 : null;
                if (str != null) {
                    arrayList2.add(str);
                    return;
                }
                return;
            }
            if (iOptInt == 50 || iOptInt == 51) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    return;
                }
                int length = jSONArrayOptJSONArray.length();
                int i = 0;
                while (i < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null) {
                        qVar3 = qVar;
                        qVar4 = qVar2;
                        arrayList3 = arrayList;
                        arrayList4 = arrayList2;
                    } else {
                        qVar3 = qVar;
                        yb.q qVar5 = qVar2;
                        arrayList3 = arrayList;
                        arrayList4 = arrayList2;
                        o(sVar, qVar3, qVar5, arrayList3, arrayList4, jSONObjectOptJSONObject);
                        qVar4 = qVar5;
                    }
                    i++;
                    qVar2 = qVar4;
                    qVar = qVar3;
                    arrayList = arrayList3;
                    arrayList2 = arrayList4;
                }
                return;
            }
            if (iOptInt != 53 && iOptInt != 60) {
                return;
            }
        }
        String strP3 = k0.a.p("text", jSONObject);
        str = strP3.length() > 0 ? strP3 : null;
        if (str != null) {
            arrayList.add(str);
        }
    }

    public static final y8.m p(String str, y8.w wVar) throws JSONException {
        Object next;
        long jN;
        str.getClass();
        wVar.getClass();
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = (jSONObject.has("data") && (jSONObject.opt("data") instanceof JSONObject)) ? jSONObject.getJSONObject("data") : jSONObject;
        if (jSONObject.has("success") && !jSONObject.optBoolean("success", true)) {
            String strOptString = jSONObject.optString("message");
            if (hc.h.g0(strOptString)) {
                strOptString = jSONObject.optString("msg");
            }
            ad.o.e(strOptString, "API success=false ");
            return null;
        }
        String strOptString2 = jSONObject2.optString("scope");
        if (hc.h.g0(strOptString2)) {
            strOptString2 = wVar.f16016c;
        }
        y8.w.f16012f.getClass();
        Iterator it = y8.w.f16015j.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((y8.w) next).f16016c.equals(strOptString2)) {
                break;
            }
        }
        y8.w wVar2 = (y8.w) next;
        if (wVar2 != null) {
            wVar = wVar2;
        }
        if (jSONObject2.optInt("not_modified", 0) == 1) {
            y8.k kVar = new y8.k();
            kVar.f15977a = wVar;
            VarHandle.storeStoreFence();
            return kVar;
        }
        int iOrdinal = wVar.ordinal();
        if (iOrdinal == 0) {
            jN = n("rules_version", jSONObject2);
        } else {
            if (iOrdinal != 1) {
                g5.f.a();
                return null;
            }
            jN = n("grants_version", jSONObject2);
        }
        String string = new JSONObject(jSONObject2.toString()).put("not_modified", 0).put("scope", wVar.f16016c).toString();
        string.getClass();
        y8.y yVar = new y8.y(wVar, jN, string);
        y8.l lVar = new y8.l();
        lVar.f15978a = yVar;
        VarHandle.storeStoreFence();
        return lVar;
    }

    public static x3.b q(String str) {
        rc.e eVar = kc.e0.f7430a;
        pc.c cVarA = kc.w.a(rc.d.f10552f.plus(kc.w.c()));
        x3.b bVar = new x3.b();
        bVar.f15568a = str;
        bVar.f15569b = x3.a.f15567c;
        bVar.f15570c = cVarA;
        bVar.f15571d = new Object();
        VarHandle.storeStoreFence();
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final w0.m r(w0.m r11, u.u0 r12, u.f0 r13, boolean r14, u.k r15, v.k r16, k0.s r17) {
        /*
            r0 = r17
            k0.s2 r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.f982b
            java.lang.Object r1 = r0.j(r1)
            android.content.Context r1 = (android.content.Context) r1
            k0.e0 r3 = t.a1.f12937a
            java.lang.Object r3 = r0.j(r3)
            t.z0 r3 = (t.z0) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L88
            r6 = 1586021609(0x5e88c4e9, float:4.927629E18)
            r0.X(r6)
            boolean r6 = r0.f(r1)
            boolean r7 = r0.f(r3)
            r6 = r6 | r7
            java.lang.Object r7 = r0.M()
            if (r6 != 0) goto L2f
            k0.y0 r6 = k0.m.f6974a
            if (r7 != r6) goto L81
        L2f:
            t.f r7 = new t.f
            r7.<init>()
            t.z r6 = new t.z
            long r8 = r3.f13104a
            int r3 = d1.f0.r(r8)
            r6.<init>()
            r6.f13094a = r1
            r6.f13095b = r3
            r8 = 0
            r6.f13096c = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            r7.f12970f = r6
            k0.y0 r1 = k0.y0.f7137g
            k0.k1 r3 = new k0.k1
            jb.v r10 = jb.v.f6774a
            r3.<init>(r10, r1)
            r7.f12971g = r3
            r7.f12972h = r5
            r7.f12973j = r8
            androidx.lifecycle.h0 r1 = new androidx.lifecycle.h0
            r3 = 29
            r8 = 0
            r1.<init>(r7, r8, r3)
            w0.j r3 = w0.j.f15113c
            w0.m r1 = o1.d0.a(r3, r10, r1)
            t.y r3 = new t.y
            r3.<init>()
            r3.f13089f = r7
            r3.f13090g = r6
            java.lang.invoke.VarHandle.storeStoreFence()
            w0.m r1 = r1.d(r3)
            r7.f12975l = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            r0.i0(r7)
        L81:
            t.f r7 = (t.f) r7
            r0.q(r4)
        L86:
            r3 = r7
            goto L94
        L88:
            r1 = 1586120933(0x5e8a48e5, float:4.982233E18)
            r0.X(r1)
            r0.q(r4)
            t.y0 r7 = t.y0.f13093f
            goto L86
        L94:
            u.f0 r1 = u.f0.f13453c
            if (r13 != r1) goto L9b
            w0.m r6 = t.u.f13067c
            goto L9d
        L9b:
            w0.m r6 = t.u.f13066b
        L9d:
            w0.m r6 = r11.d(r6)
            w0.m r7 = r3.b()
            w0.m r6 = r6.d(r7)
            k0.s2 r7 = v1.a1.f14368n
            java.lang.Object r0 = r0.j(r7)
            o2.l r0 = (o2.l) r0
            o2.l r7 = o2.l.f9124f
            if (r0 != r7) goto Lc0
            if (r13 == r1) goto Lc0
            r1 = r12
            r2 = r13
            r7 = r16
            r5 = r4
            r0 = r6
            r4 = r14
        Lbe:
            r6 = r15
            goto Lc7
        Lc0:
            r1 = r12
            r2 = r13
            r4 = r14
            r7 = r16
            r0 = r6
            goto Lbe
        Lc7:
            w0.m r0 = androidx.compose.foundation.gestures.a.b(r0, r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t.i1.r(w0.m, u.u0, u.f0, boolean, u.k, v.k, k0.s):w0.m");
    }

    public static final String s(t8.a aVar, String str, String str2) {
        String str3;
        String string;
        str.getClass();
        str2.getClass();
        if (t8.d.f13225a[aVar.ordinal()] == 1) {
            String strH = s8.g1.H(str);
            if (strH != null) {
                str = strH;
            }
            return w2.c.b("/storage/emulated/0/Android/.com.stepos.filemanager/.garbage/", new File(str).getName());
        }
        Pattern patternCompile = Pattern.compile("路径=([^，,\\s]+)");
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str2);
        matcher.getClass();
        hc.f fVarH = h5.t.h(matcher, 0, str2);
        if (fVarH == null || (str3 = (String) kb.l.y0(1, fVarH.a())) == null || (string = hc.h.w0(str3).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public abstract int b(int i, View view);

    public abstract int c(int i, View view);

    public int f(View view) {
        return 0;
    }

    public int g() {
        return 0;
    }

    public abstract void k(int i);

    public abstract void l(View view, int i, int i3);

    public abstract void m(View view, float f5, float f10);

    public abstract boolean t(int i, View view);

    public void j(int i, View view) {
    }
}
