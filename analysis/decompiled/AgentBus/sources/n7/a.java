package n7;

import a4.u;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.provider.Settings;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import c1.v;
import c1.w;
import com.stepos.agentbus.R;
import com.stepos.cloud.securedata.SecureDataEnvironment;
import d7.a0;
import f8.e1;
import f8.n0;
import f8.t;
import fi.iki.elonen.NanoHTTPD;
import i1.d1;
import i1.r;
import i8.r0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p.d0;
import p1.q;
import p1.s;
import w6.p;
import z7.x1;
import z8.y;

/* loaded from: classes.dex */
public abstract class a {
    public static JSONObject A(c5.b bVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "request");
        String strB = bVar.b();
        if (strB == null) {
            strB = a1.a.h("zc-", System.nanoTime());
        }
        jSONObject.put("id", strB);
        jSONObject.put("method", str);
        Map mapG = bVar.g();
        if (mapG == null) {
            mapG = a0.f2944f;
        }
        jSONObject.put("params", new JSONObject(mapG));
        return jSONObject;
    }

    public static final f8.n B(e1 e1Var) {
        q7.k.e(e1Var, "<this>");
        f8.n nVar = (f8.n) o8.o.f7838d.get(e1Var);
        return nVar == null ? f8.o.f(e1Var) : nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[PHI: r4
      0x0066: PHI (r4v11 java.lang.String) = (r4v1 java.lang.String), (r4v3 java.lang.String), (r4v14 java.lang.String) binds: [B:26:0x007a, B:30:0x0084, B:17:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c5.b C(c5.b r11, com.stepos.zeroclaw.ipc.Reply r12) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.a.C(c5.b, com.stepos.zeroclaw.ipc.Reply):c5.b");
    }

    public static final String D(float f10) {
        if (Float.isNaN(f10)) {
            return "NaN";
        }
        if (Float.isInfinite(f10)) {
            return f10 < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(1, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f11 = f10 * fPow;
        int i2 = (int) f11;
        if (f11 - i2 >= 0.5f) {
            i2++;
        }
        float f12 = i2 / fPow;
        return iMax > 0 ? String.valueOf(f12) : String.valueOf((int) f12);
    }

    public static final void E(p1.n nVar, int i2, o1.i iVar) {
        p1.n nVar2;
        d0.e eVar = new d0.e(new p1.n[16]);
        List listI = nVar.i(false, false);
        while (true) {
            eVar.d(eVar.f2751h, listI);
            while (true) {
                int i10 = eVar.f2751h;
                if (i10 == 0) {
                    return;
                }
                nVar2 = (p1.n) eVar.j(i10 - 1);
                boolean zE = q.e(nVar2);
                p1.i iVar2 = nVar2.f8315d;
                k.a0 a0Var = iVar2.f8304f;
                if (!zE && !a0Var.c(s.f8352i)) {
                    d1 d1VarD = nVar2.d();
                    if (d1VarD == null) {
                        throw x.i("Expected semantics node to have a coordinator.");
                    }
                    d2.j jVarM = ib.c.M(ib.k.h(d1VarD));
                    if (jVarM.f2788a < jVarM.f2790c && jVarM.f2789b < jVarM.f2791d) {
                        Object objG = iVar2.f8304f.g(p1.h.f8282e);
                        if (objG == null) {
                            objG = null;
                        }
                        p7.n nVar3 = (p7.n) objG;
                        Object objG2 = a0Var.g(s.f8364u);
                        p1.g gVar = (p1.g) (objG2 != null ? objG2 : null);
                        if (nVar3 == null || gVar == null || ((Number) gVar.f8277b.c()).floatValue() <= 0.0f) {
                            break;
                        }
                        int i11 = i2 + 1;
                        iVar.invoke(new o1.j(nVar2, i11, jVarM, d1VarD));
                        E(nVar2, i11, iVar);
                    }
                }
            }
            listI = nVar2.i(false, false);
        }
    }

    public static final boolean a(q0.d dVar, long j2) {
        if (!dVar.f6797f.f6810s) {
            return false;
        }
        r rVar = (r) i1.l.u(dVar).H.f4401g;
        if (!rVar.S.f6810s) {
            return false;
        }
        long jJ0 = rVar.J0(0L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jJ0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jJ0 & 4294967295L));
        long j4 = dVar.f8624v;
        float f10 = ((int) (j4 >> 32)) + fIntBitsToFloat;
        float f11 = ((int) (j4 & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32));
        if (fIntBitsToFloat > fIntBitsToFloat3 || fIntBitsToFloat3 > f10) {
            return false;
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        return fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= f11;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0056 -> B:21:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(c1.v r7, i7.a r8) {
        /*
            boolean r0 = r8 instanceof p.c0
            if (r0 == 0) goto L13
            r0 = r8
            p.c0 r0 = (p.c0) r0
            int r1 = r0.f8067h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8067h = r1
            goto L18
        L13:
            p.c0 r0 = new p.c0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f8066g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8067h
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            c1.v r7 = r0.f8065f
            w7.e0.N(r8)
            goto L59
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            w7.e0.N(r8)
            c1.x r8 = r7.f1847k
            c1.f r8 = r8.f1855y
            java.lang.Object r8 = r8.f1795a
            int r2 = r8.size()
            r5 = r3
        L40:
            if (r5 >= r2) goto L75
            java.lang.Object r6 = r8.get(r5)
            c1.l r6 = (c1.l) r6
            boolean r6 = r6.f1807d
            if (r6 == 0) goto L72
        L4c:
            c1.g r8 = c1.g.f1799h
            r0.f8065f = r7
            r0.f8067h = r4
            java.lang.Object r8 = r7.b(r8, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            c1.f r8 = (c1.f) r8
            java.lang.Object r8 = r8.f1795a
            int r2 = r8.size()
            r5 = r3
        L62:
            if (r5 >= r2) goto L75
            java.lang.Object r6 = r8.get(r5)
            c1.l r6 = (c1.l) r6
            boolean r6 = r6.f1807d
            if (r6 == 0) goto L6f
            goto L4c
        L6f:
            int r5 = r5 + 1
            goto L62
        L72:
            int r5 = r5 + 1
            goto L40
        L75:
            c7.r r7 = c7.r.f1986a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.a.b(c1.v, i7.a):java.lang.Object");
    }

    public static final Object c(c1.q qVar, p7.n nVar, i7.i iVar) {
        h7.a aVar;
        c7.r rVar;
        d0 d0Var = new d0(iVar.getContext(), nVar, null);
        c1.x xVar = (c1.x) qVar;
        xVar.getClass();
        ia.m mVar = new ia.m(1, ib.k.C(iVar));
        mVar.s();
        v vVar = new v(xVar, mVar);
        synchronized (xVar.A) {
            xVar.f1856z.b(vVar);
            g7.d dVarC = ib.k.C(ib.k.r(vVar, vVar, d0Var));
            aVar = h7.a.f4212f;
            g7.n nVar2 = new g7.n(dVarC);
            rVar = c7.r.f1986a;
            nVar2.resumeWith(rVar);
        }
        mVar.u(new w(0, vVar));
        Object objR = mVar.r();
        return objR == aVar ? objR : rVar;
    }

    public static final Object d(Object obj, boolean z4) {
        m9.c cVar;
        q7.k.e(obj, "possiblyPrimitiveType");
        if (!z4) {
            return obj;
        }
        x8.j jVar = (x8.j) obj;
        if (!(jVar instanceof x8.i) || (cVar = ((x8.i) jVar).f11263i) == null) {
            return jVar;
        }
        String strE = m9.b.c(cVar.e()).e();
        q7.k.d(strE, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return x8.e.d(strE);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String e(f8.e r3, x8.e r4) {
        /*
            java.lang.String r0 = "klass"
            q7.k.e(r3, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            q7.k.e(r4, r0)
            f8.j r0 = r3.p()
            java.lang.String r1 = "klass.containingDeclaration"
            q7.k.d(r0, r1)
            e9.f r1 = r3.getName()
            if (r1 == 0) goto L20
            e9.f r2 = e9.h.f3200a
            boolean r2 = r1.f3198g
            if (r2 != 0) goto L20
            goto L22
        L20:
            e9.f r1 = e9.h.f3202c
        L22:
            java.lang.String r1 = r1.c()
            boolean r2 = r0 instanceof f8.e0
            if (r2 == 0) goto L56
            f8.e0 r0 = (f8.e0) r0
            i8.c0 r0 = (i8.c0) r0
            e9.c r3 = r0.f4758j
            boolean r4 = r3.d()
            if (r4 == 0) goto L37
            return r1
        L37:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r3 = r3.b()
            r0 = 46
            r2 = 47
            java.lang.String r3 = ga.r.d0(r3, r0, r2)
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L56:
            boolean r2 = r0 instanceof f8.e
            if (r2 == 0) goto L5e
            r2 = r0
            f8.e r2 = (f8.e) r2
            goto L5f
        L5e:
            r2 = 0
        L5f:
            if (r2 == 0) goto L7a
            java.lang.String r3 = e(r2, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r3 = 36
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L7a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected container: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = " for "
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.a.e(f8.e, x8.e):java.lang.String");
    }

    public static final long f(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[NanoHTTPD.HTTPSession.BUFSIZE];
        int i2 = inputStream.read(bArr);
        long j2 = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j2 += i2;
            i2 = inputStream.read(bArr);
        }
        return j2;
    }

    public static final ArrayList g(ArrayList arrayList, List list, t tVar) {
        q7.k.e(list, "oldValueParameters");
        arrayList.size();
        list.size();
        ArrayList arrayListS1 = d7.r.s1(arrayList, list);
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayListS1, 10));
        Iterator it = arrayListS1.iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            v9.v vVar = (v9.v) jVar.f1973f;
            r0 r0Var = (r0) jVar.f1974g;
            int i2 = r0Var.f4845k;
            g8.j annotations = r0Var.getAnnotations();
            e9.f name = r0Var.getName();
            q7.k.d(name, "oldParameter.name");
            boolean zH0 = r0Var.H0();
            boolean z4 = r0Var.f4847m;
            boolean z10 = r0Var.f4848n;
            v9.v vVarF = r0Var.f4849o != null ? l9.d.j(tVar).n().f(vVar) : null;
            n0 n0VarQ = r0Var.q();
            q7.k.d(n0VarQ, "oldParameter.source");
            arrayList2.add(new r0(tVar, null, i2, annotations, name, vVar, zH0, z4, z10, vVarF, n0VarQ));
        }
        return arrayList2;
    }

    public static final f8.n h(z8.d1 d1Var) {
        switch (d1Var == null ? -1 : r9.v.$EnumSwitchMapping$2[d1Var.ordinal()]) {
            case 1:
                f8.n nVar = f8.o.f3491d;
                q7.k.d(nVar, "INTERNAL");
                return nVar;
            case 2:
                f8.n nVar2 = f8.o.f3488a;
                q7.k.d(nVar2, "PRIVATE");
                return nVar2;
            case 3:
                f8.n nVar3 = f8.o.f3489b;
                q7.k.d(nVar3, "PRIVATE_TO_THIS");
                return nVar3;
            case 4:
                f8.n nVar4 = f8.o.f3490c;
                q7.k.d(nVar4, "PROTECTED");
                return nVar4;
            case 5:
                f8.n nVar5 = f8.o.f3492e;
                q7.k.d(nVar5, "PUBLIC");
                return nVar5;
            case 6:
                f8.n nVar6 = f8.o.f3493f;
                q7.k.d(nVar6, "LOCAL");
                return nVar6;
            default:
                f8.n nVar7 = f8.o.f3488a;
                q7.k.d(nVar7, "PRIVATE");
                return nVar7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z5.g i(o4.k0 r11, k5.t r12) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.a.i(o4.k0, k5.t):z5.g");
    }

    public static final float j(Layout layout, int i2, Paint paint) {
        float fAbs;
        float width;
        float lineLeft = layout.getLineLeft(i2);
        t1.g gVar = t1.i.f9703a;
        if (layout.getEllipsisCount(i2) <= 0 || layout.getParagraphDirection(i2) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float fMeasureText = paint.measureText("…") + (layout.getPrimaryHorizontal(layout.getEllipsisStart(i2) + layout.getLineStart(i2)) - lineLeft);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i2);
        if ((paragraphAlignment == null ? -1 : u1.d.$EnumSwitchMapping$0[paragraphAlignment.ordinal()]) == 1) {
            fAbs = Math.abs(lineLeft);
            width = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            fAbs = Math.abs(lineLeft);
            width = layout.getWidth() - fMeasureText;
        }
        return width + fAbs;
    }

    public static final float k(Layout layout, int i2, Paint paint) {
        float width;
        float width2;
        t1.g gVar = t1.i.f9703a;
        if (layout.getEllipsisCount(i2) <= 0) {
            return 0.0f;
        }
        if (layout.getParagraphDirection(i2) != -1 || layout.getWidth() >= layout.getLineRight(i2)) {
            return 0.0f;
        }
        float fMeasureText = paint.measureText("…") + (layout.getLineRight(i2) - layout.getPrimaryHorizontal(layout.getEllipsisStart(i2) + layout.getLineStart(i2)));
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i2);
        if ((paragraphAlignment != null ? u1.d.$EnumSwitchMapping$0[paragraphAlignment.ordinal()] : -1) == 1) {
            width = layout.getWidth() - layout.getLineRight(i2);
            width2 = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            width = layout.getWidth() - layout.getLineRight(i2);
            width2 = layout.getWidth() - fMeasureText;
        }
        return width - width2;
    }

    public static final s8.d0 l(f8.e eVar) {
        f8.e eVar2;
        f8.g gVarC;
        q7.k.e(eVar, "<this>");
        int i2 = l9.d.f5893a;
        Iterator it = eVar.k().E0().d().iterator();
        while (true) {
            if (!it.hasNext()) {
                eVar2 = null;
                break;
            }
            v9.v vVar = (v9.v) it.next();
            if (!c8.h.x(vVar)) {
                gVarC = vVar.E0().c();
                if (h9.f.n(gVarC, 1) || h9.f.n(gVarC, 3)) {
                    break;
                }
            }
        }
        q7.k.c(gVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        eVar2 = (f8.e) gVarC;
        if (eVar2 == null) {
            return null;
        }
        o9.n nVarL0 = eVar2.l0();
        s8.d0 d0Var = nVarL0 instanceof s8.d0 ? (s8.d0) nVarL0 : null;
        return d0Var == null ? l(eVar2) : d0Var;
    }

    public static final r2.a m(View view) {
        r2.a aVar = (r2.a) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (aVar != null) {
            return aVar;
        }
        r2.a aVar2 = new r2.a();
        view.setTag(R.id.pooling_container_listener_holder_tag, aVar2);
        return aVar2;
    }

    public static boolean n(f8.c cVar) {
        q7.k.e(cVar, "callableMemberDescriptor");
        if (!o8.g.f7828d.contains(cVar.getName())) {
            return false;
        }
        if (d7.r.I0(o8.g.f7827c, l9.d.c(cVar)) && cVar.x0().isEmpty()) {
            return true;
        }
        if (!c8.h.z(cVar)) {
            return false;
        }
        Collection collectionR = cVar.r();
        q7.k.d(collectionR, "overriddenDescriptors");
        Collection<f8.c> collection = collectionR;
        if (collection.isEmpty()) {
            return false;
        }
        for (f8.c cVar2 : collection) {
            q7.k.d(cVar2, "it");
            if (n(cVar2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean o(w7.c cVar) {
        a8.h hVarY;
        a8.h hVarA;
        if (cVar instanceof w7.k) {
            w7.t tVar = (w7.t) cVar;
            Field fieldT = m.t(tVar);
            if (!(fieldT != null ? fieldT.isAccessible() : true)) {
                return false;
            }
            Method methodU = m.u(tVar.b());
            if (!(methodU != null ? methodU.isAccessible() : true)) {
                return false;
            }
            Method methodU2 = m.u(((w7.k) cVar).g());
            if (!(methodU2 != null ? methodU2.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof w7.t) {
            w7.t tVar2 = (w7.t) cVar;
            Field fieldT2 = m.t(tVar2);
            if (!(fieldT2 != null ? fieldT2.isAccessible() : true)) {
                return false;
            }
            Method methodU3 = m.u(tVar2.b());
            if (!(methodU3 != null ? methodU3.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof w7.o) {
            Field fieldT3 = m.t(((w7.o) cVar).a());
            if (!(fieldT3 != null ? fieldT3.isAccessible() : true)) {
                return false;
            }
            Method methodU4 = m.u((w7.g) cVar);
            if (!(methodU4 != null ? methodU4.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof w7.h) {
            Field fieldT4 = m.t(((w7.h) cVar).a());
            if (!(fieldT4 != null ? fieldT4.isAccessible() : true)) {
                return false;
            }
            Method methodU5 = m.u((w7.g) cVar);
            if (!(methodU5 != null ? methodU5.isAccessible() : true)) {
                return false;
            }
        } else {
            if (!(cVar instanceof w7.g)) {
                throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
            }
            w7.g gVar = (w7.g) cVar;
            Method methodU6 = m.u(gVar);
            if (!(methodU6 != null ? methodU6.isAccessible() : true)) {
                return false;
            }
            z7.s sVarA = x1.a(cVar);
            Object objJ = (sVarA == null || (hVarA = sVarA.A()) == null) ? null : hVarA.j();
            AccessibleObject accessibleObject = objJ instanceof AccessibleObject ? (AccessibleObject) objJ : null;
            if (!(accessibleObject != null ? accessibleObject.isAccessible() : true)) {
                return false;
            }
            z7.s sVarA2 = x1.a(gVar);
            Object objJ2 = (sVarA2 == null || (hVarY = sVarA2.y()) == null) ? null : hVarY.j();
            Constructor constructor = objJ2 instanceof Constructor ? (Constructor) objJ2 : null;
            if (!(constructor != null ? constructor.isAccessible() : true)) {
                return false;
            }
        }
        return true;
    }

    public static LinkedHashMap p(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, q(jSONObject.opt(next)));
        }
        return linkedHashMap;
    }

    public static Object q(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return p((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(q(jSONArray.opt(i2)));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(v9.v r21, x8.q r22, p7.o r23) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.a.r(v9.v, x8.q, p7.o):java.lang.Object");
    }

    public static final int s(y yVar) {
        int i2 = yVar == null ? -1 : r9.v.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i2 != 1) {
            int i10 = 2;
            if (i2 != 2) {
                i10 = 3;
                if (i2 != 3) {
                    i10 = 4;
                    if (i2 != 4) {
                    }
                }
            }
            return i10;
        }
        return 1;
    }

    public static void v(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap(8);
        map.put("en", str);
        map.put("ti", str3);
        if (TextUtils.isEmpty(str5)) {
            str5 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        map.put("ts", str5);
        map.put("pn", str2);
        map.put("pv", "5.0.7");
        map.put("nm", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("si", str4);
        map.put("di", "");
        try {
            String string = new JSONObject(map).toString();
            Intent intent = new Intent();
            intent.setPackage("com.stepos.pushservice");
            intent.setAction("com.stepos.cloud.pushservice.action.PUSH_TRACKER_SERVICE");
            intent.putExtra("extra_push_tracker", string);
            context.startService(intent);
            j6.a.a("UsageStatsUtils", "startTrackerService success" + string);
        } catch (Exception e10) {
            j6.a.c("UsageStatsUtils", "startTrackerService error " + e10.getMessage());
        }
    }

    public static final byte[] w(l3.b bVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(NanoHTTPD.HTTPSession.BUFSIZE, bVar.f5830f.available()));
        f(bVar, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        q7.k.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static p x(Context context) {
        String string;
        String str;
        String str2;
        try {
            String string2 = Settings.Secure.getString(context.getContentResolver(), "net_env");
            string = string2 != null ? ga.k.N0(string2).toString() : null;
        } catch (Exception unused) {
        }
        if (string == null) {
            string = "";
        }
        SecureDataEnvironment secureDataEnvironment = string.equals("test") ? SecureDataEnvironment.TEST : SecureDataEnvironment.PROD;
        q7.k.e(secureDataEnvironment, "environment");
        int[] iArr = w6.n.$EnumSwitchMapping$0;
        int i2 = iArr[secureDataEnvironment.ordinal()];
        if (i2 == 1) {
            str = "t-stepos.com";
        } else {
            if (i2 != 2) {
                throw new u();
            }
            str = "stepos.com";
        }
        String strConcat = "https://biz-gw.".concat(str);
        String strI = a1.a.i(strConcat, "/key-center");
        int i10 = iArr[secureDataEnvironment.ordinal()];
        if (i10 == 1) {
            str2 = "9pv65zQUtnH2huYnRPCE";
        } else {
            if (i10 != 2) {
                throw new u();
            }
            str2 = "bt6bI9U7wKl8FwT6tJ3u";
        }
        return new p(secureDataEnvironment, strI, new y6.a(strConcat, "safe-key-center-sdk", str2, false, 8, null));
    }

    public static final void y(w7.c cVar) throws SecurityException {
        a8.h hVarY;
        a8.h hVarA;
        if (cVar instanceof w7.k) {
            w7.t tVar = (w7.t) cVar;
            Field fieldT = m.t(tVar);
            if (fieldT != null) {
                fieldT.setAccessible(true);
            }
            Method methodU = m.u(tVar.b());
            if (methodU != null) {
                methodU.setAccessible(true);
            }
            Method methodU2 = m.u(((w7.k) cVar).g());
            if (methodU2 == null) {
                return;
            }
            methodU2.setAccessible(true);
            return;
        }
        if (cVar instanceof w7.t) {
            w7.t tVar2 = (w7.t) cVar;
            Field fieldT2 = m.t(tVar2);
            if (fieldT2 != null) {
                fieldT2.setAccessible(true);
            }
            Method methodU3 = m.u(tVar2.b());
            if (methodU3 == null) {
                return;
            }
            methodU3.setAccessible(true);
            return;
        }
        if (cVar instanceof w7.o) {
            Field fieldT3 = m.t(((w7.o) cVar).a());
            if (fieldT3 != null) {
                fieldT3.setAccessible(true);
            }
            Method methodU4 = m.u((w7.g) cVar);
            if (methodU4 == null) {
                return;
            }
            methodU4.setAccessible(true);
            return;
        }
        if (cVar instanceof w7.h) {
            Field fieldT4 = m.t(((w7.h) cVar).a());
            if (fieldT4 != null) {
                fieldT4.setAccessible(true);
            }
            Method methodU5 = m.u((w7.g) cVar);
            if (methodU5 == null) {
                return;
            }
            methodU5.setAccessible(true);
            return;
        }
        if (!(cVar instanceof w7.g)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        w7.g gVar = (w7.g) cVar;
        Method methodU6 = m.u(gVar);
        if (methodU6 != null) {
            methodU6.setAccessible(true);
        }
        z7.s sVarA = x1.a(cVar);
        Object objJ = (sVarA == null || (hVarA = sVarA.A()) == null) ? null : hVarA.j();
        AccessibleObject accessibleObject = objJ instanceof AccessibleObject ? (AccessibleObject) objJ : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        z7.s sVarA2 = x1.a(gVar);
        Object objJ2 = (sVarA2 == null || (hVarY = sVarA2.y()) == null) ? null : hVarY.j();
        Constructor constructor = objJ2 instanceof Constructor ? (Constructor) objJ2 : null;
        if (constructor == null) {
            return;
        }
        constructor.setAccessible(true);
    }

    public static final long z(float f10, long j2) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j2 >> 32)) - f10);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j2 & 4294967295L)) - f10);
        return (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L);
    }

    public abstract void t(Throwable th);

    public abstract void u(i5.f fVar);
}
