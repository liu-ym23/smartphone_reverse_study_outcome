package n7;

import android.os.Build;
import android.util.LongSparseArray;
import android.view.Display;
import android.view.DragEvent;
import android.view.RoundedCorner;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;
import b0.p;
import b0.z1;
import com.stepos.agentcache.core.ServiceContract;
import d7.i0;
import d7.r;
import g1.s;
import i1.l0;
import i1.m0;
import java.io.Closeable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m.x;
import o4.d0;
import org.json.JSONException;
import org.json.JSONObject;
import q7.w;
import r.e0;
import r.f0;
import w7.t;
import w7.u;
import w7.v;
import z7.m1;
import z7.n1;
import z7.q1;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(n0.m mVar, p7.k kVar, p pVar, int i2) {
        pVar.T(-932836462);
        if ((((pVar.f(mVar) ? 4 : 2) | i2 | (pVar.h(kVar) ? 32 : 16)) & 19) == 18 && pVar.z()) {
            pVar.O();
        } else {
            m.b(pVar, androidx.compose.ui.draw.a.a(mVar, kVar));
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new h9.b(mVar, kVar, i2, 3);
        }
    }

    public static final long b(float f10, float f11) {
        return (Float.floatToRawIntBits(f11) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32);
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static final void d(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ib.k.e(th, th2);
            }
        }
    }

    public static o9.n e(String str, List list) {
        o9.m mVar;
        q7.k.e(str, "debugName");
        ea.f fVar = new ea.f();
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            mVar = o9.m.f7933b;
            if (!zHasNext) {
                break;
            }
            o9.n nVar = (o9.n) it.next();
            if (nVar != mVar) {
                if (nVar instanceof o9.a) {
                    o9.n[] nVarArr = ((o9.a) nVar).f7894c;
                    q7.k.e(nVarArr, "elements");
                    fVar.addAll(d7.n.S(nVarArr));
                } else {
                    fVar.add(nVar);
                }
            }
        }
        int i2 = fVar.f3233f;
        return i2 != 0 ? i2 != 1 ? new o9.a(str, (o9.n[]) fVar.toArray(new o9.n[0])) : (o9.n) fVar.get(0) : mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x0067, TryCatch #1 {all -> 0x0067, blocks: (B:3:0x000a, B:10:0x002a, B:12:0x0043, B:13:0x0046, B:15:0x004c, B:17:0x0050, B:18:0x0061, B:20:0x0063, B:21:0x0066), top: B:37:0x000a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: all -> 0x0067, TryCatch #1 {all -> 0x0067, blocks: (B:3:0x000a, B:10:0x002a, B:12:0x0043, B:13:0x0046, B:15:0x004c, B:17:0x0050, B:18:0x0061, B:20:0x0063, B:21:0x0066), top: B:37:0x000a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s9.c f(e9.c r7, u9.k r8, f8.z r9, java.io.InputStream r10) throws java.io.IOException {
        /*
            java.lang.String r0 = "fqName"
            q7.k.e(r7, r0)
            java.lang.String r0 = "module"
            q7.k.e(r9, r0)
            a9.a r0 = a9.a.f467f     // Catch: java.lang.Throwable -> L67
            a9.a r6 = s7.a.S(r10)     // Catch: java.lang.Throwable -> L67
            a9.a r0 = a9.a.f467f     // Catch: java.lang.Throwable -> L67
            int r1 = r6.f1551c     // Catch: java.lang.Throwable -> L67
            java.lang.String r2 = "ourVersion"
            q7.k.e(r0, r2)     // Catch: java.lang.Throwable -> L67
            int r2 = r0.f1551c     // Catch: java.lang.Throwable -> L67
            int r3 = r0.f1550b     // Catch: java.lang.Throwable -> L67
            int r4 = r6.f1550b     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L26
            if (r3 != 0) goto L6a
            if (r1 != r2) goto L6a
            goto L2a
        L26:
            if (r4 != r3) goto L6a
            if (r1 > r2) goto L6a
        L2a:
            f9.h r1 = new f9.h     // Catch: java.lang.Throwable -> L67
            r1.<init>()     // Catch: java.lang.Throwable -> L67
            a9.b.a(r1)     // Catch: java.lang.Throwable -> L67
            c9.a r2 = z8.d0.f12094p     // Catch: java.lang.Throwable -> L67
            r2.getClass()     // Catch: java.lang.Throwable -> L67
            f9.e r3 = new f9.e     // Catch: java.lang.Throwable -> L67
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r1 = r2.a(r3, r1)     // Catch: java.lang.Throwable -> L67
            f9.a r1 = (f9.a) r1     // Catch: java.lang.Throwable -> L67
            r2 = 0
            r3.a(r2)     // Catch: f9.r -> L62 java.lang.Throwable -> L67
            boolean r2 = r1.isInitialized()     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L50
            z8.d0 r1 = (z8.d0) r1     // Catch: java.lang.Throwable -> L67
        L4e:
            r5 = r1
            goto L6c
        L50:
            a4.u r7 = new a4.u     // Catch: java.lang.Throwable -> L67
            r8 = 4
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L67
            f9.r r8 = new f9.r     // Catch: java.lang.Throwable -> L67
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L67
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L67
            r8.f3597f = r1     // Catch: java.lang.Throwable -> L67
            throw r8     // Catch: java.lang.Throwable -> L67
        L62:
            r0 = move-exception
            r7 = r0
            r7.f3597f = r1     // Catch: java.lang.Throwable -> L67
            throw r7     // Catch: java.lang.Throwable -> L67
        L67:
            r0 = move-exception
            r7 = r0
            goto L9b
        L6a:
            r1 = 0
            goto L4e
        L6c:
            r10.close()
            if (r5 == 0) goto L7a
            s9.c r1 = new s9.c
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L7a:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Kotlin built-in definition format version is not supported: expected "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = ", actual "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r9 = ". Please update Kotlin"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L9b:
            throw r7     // Catch: java.lang.Throwable -> L9c
        L9c:
            r0 = move-exception
            r8 = r0
            d(r10, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.b.f(e9.c, u9.k, f8.z, java.io.InputStream):s9.c");
    }

    public static void g(p0.c cVar, LongSparseArray longSparseArray) {
        TranslationResponseValue value;
        CharSequence text;
        p1.o oVar;
        p1.n nVar;
        p7.k kVar;
        int size = longSparseArray.size();
        int i2 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            long jKeyAt = longSparseArray.keyAt(i10);
            ViewTranslationResponse viewTranslationResponseO = j1.l.o(longSparseArray.get(jKeyAt));
            if (viewTranslationResponseO != null && (value = viewTranslationResponseO.getValue("android:text")) != null && (text = value.getText()) != null && (oVar = (p1.o) cVar.g().b((int) jKeyAt)) != null && (nVar = oVar.f8319a) != null) {
                Object objG = nVar.f8315d.f8304f.g(p1.h.f8287j);
                if (objG == null) {
                    objG = null;
                }
                p1.a aVar = (p1.a) objG;
                if (aVar != null && (kVar = (p7.k) aVar.f8267b) != null) {
                }
            }
        }
    }

    public static final k8.c h(k8.b bVar, e9.b bVar2, d9.f fVar) {
        q7.k.e(bVar, "<this>");
        q7.k.e(bVar2, "classId");
        q7.k.e(fVar, "jvmMetadataVersion");
        d0 d0VarA = bVar.a(bVar2, fVar);
        if (d0VarA != null) {
            return (k8.c) d0VarA.f7326g;
        }
        return null;
    }

    public static String i(String str, String str2, long j2, String str3, String str4, Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "agentbus_node");
        jSONObject.put("node", str);
        if (str2 != null) {
            jSONObject.put("session_id", str2);
        }
        jSONObject.put("event_time", j2);
        if (str3 != null) {
            jSONObject.put("trace_id", str3);
        }
        if (str4 != null) {
            jSONObject.put("status", str4);
        }
        for (Map.Entry entry : map.entrySet()) {
            String str5 = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                jSONObject.put(str5, value);
            }
        }
        String string = jSONObject.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z5.i j(java.util.Map r4) {
        /*
            java.lang.String r0 = u(r4)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.String r2 = "sessionId"
            java.lang.Object r2 = r4.get(r2)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L15
            java.lang.String r2 = (java.lang.String) r2
            goto L16
        L15:
            r2 = r1
        L16:
            if (r2 == 0) goto L22
            int r3 = r2.length()
            if (r3 <= 0) goto L1f
            goto L20
        L1f:
            r2 = r1
        L20:
            if (r2 != 0) goto L24
        L22:
            java.lang.String r2 = "main"
        L24:
            java.lang.String r3 = "agentId"
            java.lang.Object r4 = r4.get(r3)
            boolean r3 = r4 instanceof java.lang.String
            if (r3 == 0) goto L31
            java.lang.String r4 = (java.lang.String) r4
            goto L32
        L31:
            r4 = r1
        L32:
            if (r4 == 0) goto L3b
            int r3 = r4.length()
            if (r3 <= 0) goto L3b
            r1 = r4
        L3b:
            if (r1 != 0) goto L3f
            java.lang.String r1 = ""
        L3f:
            z5.i r4 = new z5.i
            r4.<init>(r0, r1, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.b.j(java.util.Map):z5.i");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z5.i k(java.util.Map r4) {
        /*
            java.lang.String r0 = "metadata"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.util.Map
            r2 = 0
            if (r1 == 0) goto Le
            java.util.Map r0 = (java.util.Map) r0
            goto Lf
        Le:
            r0 = r2
        Lf:
            if (r0 == 0) goto L17
            java.lang.String r1 = u(r0)
            if (r1 != 0) goto L32
        L17:
            java.lang.String r1 = "traceId"
            java.lang.Object r1 = r4.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            goto L25
        L24:
            r1 = r2
        L25:
            if (r1 == 0) goto L2e
            int r3 = r1.length()
            if (r3 <= 0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            if (r1 != 0) goto L32
            return r2
        L32:
            java.lang.String r3 = "sessionId"
            java.lang.Object r4 = r4.get(r3)
            boolean r3 = r4 instanceof java.lang.String
            if (r3 == 0) goto L3f
            java.lang.String r4 = (java.lang.String) r4
            goto L40
        L3f:
            r4 = r2
        L40:
            if (r4 == 0) goto L4c
            int r3 = r4.length()
            if (r3 <= 0) goto L49
            goto L4a
        L49:
            r4 = r2
        L4a:
            if (r4 != 0) goto L4e
        L4c:
            java.lang.String r4 = "main"
        L4e:
            if (r0 == 0) goto L57
            java.lang.String r3 = "agentId"
            java.lang.Object r0 = r0.get(r3)
            goto L58
        L57:
            r0 = r2
        L58:
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L5f
            java.lang.String r0 = (java.lang.String) r0
            goto L60
        L5f:
            r0 = r2
        L60:
            if (r0 == 0) goto L69
            int r3 = r0.length()
            if (r3 <= 0) goto L69
            r2 = r0
        L69:
            if (r2 != 0) goto L6d
            java.lang.String r2 = ""
        L6d:
            z5.i r0 = new z5.i
            r0.<init>(r1, r2, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.b.k(java.util.Map):z5.i");
    }

    public static Set l() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final w7.d m(w7.e eVar) {
        f8.e eVar2;
        if (eVar instanceof w7.d) {
            return (w7.d) eVar;
        }
        if (!(eVar instanceof v)) {
            throw new c7.i("Cannot calculate JVM erasure for type: " + eVar, 3);
        }
        q1 q1Var = ((n1) ((v) eVar)).f11922g;
        t tVar = n1.f11920i[0];
        Object objC = q1Var.c();
        q7.k.d(objC, "<get-upperBounds>(...)");
        List list = (List) objC;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            u uVar = (u) next;
            q7.k.c(uVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            f8.g gVarC = ((m1) uVar).f11908f.E0().c();
            eVar2 = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            if (eVar2 != null && eVar2.B() != 2 && eVar2.B() != 5) {
                eVar2 = next;
                break;
            }
        }
        u uVar2 = (u) eVar2;
        if (uVar2 == null) {
            uVar2 = (u) r.P0(list);
        }
        return uVar2 != null ? n(uVar2) : w.f8821a.b(Object.class);
    }

    public static final w7.d n(u uVar) {
        w7.e eVarQ = uVar.q();
        if (eVarQ != null) {
            return m(eVarQ);
        }
        throw new c7.i("Cannot calculate JVM erasure for type: " + uVar, 3);
    }

    public static final long o(d0 d0Var) {
        DragEvent dragEvent = (DragEvent) d0Var.f7326g;
        float x10 = dragEvent.getX();
        float y10 = dragEvent.getY();
        return (Float.floatToRawIntBits(x10) << 32) | (Float.floatToRawIntBits(y10) & 4294967295L);
    }

    public static o2.g p(Display display, int i2) {
        RoundedCorner roundedCorner;
        int i10;
        if (Build.VERSION.SDK_INT < 31 || (roundedCorner = display.getRoundedCorner(i2)) == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i10 = 1;
            if (position != 1) {
                i10 = 2;
                if (position != 2) {
                    i10 = 3;
                    if (position != 3) {
                        throw new IllegalArgumentException(n.f.c(position, "Invalid position: "));
                    }
                }
            }
        } else {
            i10 = 0;
        }
        return new o2.g(i10, roundedCorner.getRadius(), roundedCorner.getCenter());
    }

    public static final Object q(u9.l lVar, t tVar) {
        q7.k.e(lVar, "<this>");
        q7.k.e(tVar, "p");
        return lVar.c();
    }

    public static l0 r(e0 e0Var, int i2, int i10, int i11, int i12, int i13, m0 m0Var, List list, s[] sVarArr, int i14) throws Throwable {
        int[] iArr;
        String str;
        float f10;
        String str2;
        long j2;
        String str3;
        long j4;
        int i15;
        e0 e0Var2;
        int i16;
        int iK;
        int i17;
        String str4;
        int i18;
        String str5;
        int i19;
        float f11;
        boolean z4;
        float f12;
        int i20;
        List list2 = list;
        int i21 = i14;
        long j10 = i13;
        int[] iArr2 = new int[i21];
        float f13 = 0.0f;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int iMax = 0;
        while (true) {
            if (i22 >= i21) {
                break;
            }
            g1.o oVar = (g1.o) list2.get(i22);
            int i26 = i22;
            Object objG = oVar.g();
            int i27 = i25;
            f0 f0Var = objG instanceof f0 ? (f0) objG : null;
            float f14 = f0Var != null ? f0Var.f8858a : 0.0f;
            if (f14 > 0.0f) {
                f13 += f14;
                i23++;
                i25 = i27;
            } else {
                int i28 = i11 - i24;
                s sVarB = sVarArr[i26];
                if (sVarB == null) {
                    i20 = i28;
                    f12 = f13;
                    sVarB = oVar.b(e0Var.e(0, i11 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i20 < 0 ? 0 : i20, i12, false));
                } else {
                    f12 = f13;
                    i20 = i28;
                }
                int iD = e0Var.d(sVarB);
                int iA = e0Var.a(sVarB);
                iArr2[i26] = iD;
                int i29 = i20 - iD;
                if (i29 < 0) {
                    i29 = 0;
                }
                int iMin = Math.min(i13, i29);
                i24 += iD + iMin;
                iMax = Math.max(iMax, iA);
                sVarArr[i26] = sVarB;
                i25 = iMin;
                f13 = f12;
            }
            i22 = i26 + 1;
        }
        float f15 = f13;
        int i30 = i25;
        int i31 = iMax;
        if (i23 == 0) {
            i24 -= i30;
            e0Var2 = e0Var;
            iArr = iArr2;
            i15 = i31;
            iK = 0;
            i16 = 0;
        } else {
            int i32 = i11 != Integer.MAX_VALUE ? i11 : i2;
            long j11 = (i23 - 1) * j10;
            iArr = iArr2;
            long j12 = (i32 - i24) - j11;
            if (j12 < 0) {
                j12 = 0;
            }
            float f16 = j12 / f15;
            long jRound = j12;
            int i33 = 0;
            while (true) {
                str = "weightedSize ";
                f10 = f16;
                str2 = "arrangementSpacingTotal ";
                j2 = j12;
                str3 = "fixedSpace ";
                j4 = j11;
                if (i33 >= i21) {
                    break;
                }
                int i34 = i33;
                Object objG2 = ((g1.o) list2.get(i33)).g();
                f0 f0Var2 = objG2 instanceof f0 ? (f0) objG2 : null;
                float f17 = f0Var2 != null ? f0Var2.f8858a : 0.0f;
                float f18 = f10 * f17;
                try {
                    jRound -= Math.round(f18);
                    i33 = i34 + 1;
                    list2 = list;
                    i21 = i14;
                    f16 = f10;
                    j12 = j2;
                    j11 = j4;
                } catch (IllegalArgumentException e10) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i11 + "mainAxisMin " + i2 + "targetSpace " + i32 + "arrangementSpacingPx " + j10 + "weightChildrenCount " + i23 + "fixedSpace " + i24 + "arrangementSpacingTotal " + j4 + "remainingToTarget " + j2 + "totalWeight " + f15 + "weightUnitSpace " + f10 + "itemWeight " + f17 + str + f18).initCause(e10);
                }
            }
            i15 = i31;
            int i35 = 0;
            int i36 = 0;
            while (i35 < i14) {
                if (sVarArr[i35] == null) {
                    i17 = i35;
                    g1.o oVar2 = (g1.o) list.get(i35);
                    Object objG3 = oVar2.g();
                    str5 = str2;
                    f0 f0Var3 = objG3 instanceof f0 ? (f0) objG3 : null;
                    float f19 = f0Var3 != null ? f0Var3.f8858a : 0.0f;
                    if (f19 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    float f20 = f19;
                    int iSignum = Long.signum(jRound);
                    int i37 = i23;
                    i18 = i24;
                    jRound -= iSignum;
                    float f21 = f10 * f20;
                    int iMax2 = Math.max(0, Math.round(f21) + iSignum);
                    if (f0Var3 != null) {
                        try {
                            z4 = f0Var3.f8859b;
                        } catch (IllegalArgumentException e11) {
                            e = e11;
                            str4 = str3;
                            f11 = f21;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i11 + "mainAxisMin " + i2 + "targetSpace " + i32 + "arrangementSpacingPx " + j10 + "weightChildrenCount " + i37 + str4 + i18 + str5 + j4 + "remainingToTarget " + j2 + "totalWeight " + f15 + "weightUnitSpace " + f10 + "weight " + f20 + str + f11 + "crossAxisDesiredSize nullremainderUnit " + iSignum + "childMainAxisSize " + iMax2).initCause(e);
                        }
                    } else {
                        z4 = true;
                    }
                    str4 = str3;
                    f11 = f21;
                    try {
                        s sVarB2 = oVar2.b(e0Var.e((!z4 || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, iMax2, i12, true));
                        int iD2 = e0Var.d(sVarB2);
                        int iA2 = e0Var.a(sVarB2);
                        iArr[i17] = iD2;
                        i36 += iD2;
                        int iMax3 = Math.max(i15, iA2);
                        sVarArr[i17] = sVarB2;
                        i15 = iMax3;
                        i19 = i37;
                    } catch (IllegalArgumentException e12) {
                        e = e12;
                        throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i11 + "mainAxisMin " + i2 + "targetSpace " + i32 + "arrangementSpacingPx " + j10 + "weightChildrenCount " + i37 + str4 + i18 + str5 + j4 + "remainingToTarget " + j2 + "totalWeight " + f15 + "weightUnitSpace " + f10 + "weight " + f20 + str + f11 + "crossAxisDesiredSize nullremainderUnit " + iSignum + "childMainAxisSize " + iMax2).initCause(e);
                    }
                } else {
                    i17 = i35;
                    str4 = str3;
                    i18 = i24;
                    str5 = str2;
                    i19 = i23;
                }
                i35 = i17 + 1;
                str = str;
                i23 = i19;
                str2 = str5;
                i24 = i18;
                str3 = str4;
            }
            e0Var2 = e0Var;
            i16 = 0;
            iK = nb.i.k((int) (i36 + j4), 0, i11 - i24);
        }
        int i38 = iK + i24;
        if (i38 < 0) {
            i38 = i16;
        }
        int iMax4 = Math.max(i38, i2);
        int iMax5 = Math.max(i15, Math.max(i10, i16));
        int[] iArr3 = new int[i14];
        for (int i39 = i16; i39 < i14; i39++) {
            iArr3[i39] = i16;
        }
        e0Var2.f(iMax4, m0Var, iArr, iArr3);
        return e0Var2.c(sVarArr, m0Var, iArr3, iMax4, iMax5);
    }

    public static String s(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        if (jSONObject != null) {
            String strOptString3 = jSONObject.optString("sessionId");
            q7.k.b(strOptString3);
            if (strOptString3.length() <= 0) {
                strOptString3 = null;
            }
            if (strOptString3 != null) {
                return strOptString3;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("_stepclaw_");
            if (jSONObjectOptJSONObject != null && (strOptString2 = jSONObjectOptJSONObject.optString("sessionKey")) != null) {
                if (strOptString2.length() <= 0) {
                    strOptString2 = null;
                }
                if (strOptString2 != null) {
                    return strOptString2;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("stepclaw");
            if (jSONObjectOptJSONObject2 != null && (strOptString = jSONObjectOptJSONObject2.optString("session_id")) != null) {
                if (strOptString.length() <= 0) {
                    strOptString = null;
                }
                if (strOptString != null) {
                    return strOptString;
                }
            }
        }
        return null;
    }

    public static String t(JSONObject jSONObject) {
        String strOptString;
        if (jSONObject != null) {
            String strOptString2 = jSONObject.optString("toolCallId");
            q7.k.b(strOptString2);
            if (strOptString2.length() <= 0) {
                strOptString2 = null;
            }
            if (strOptString2 != null) {
                return strOptString2;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("_stepclaw_");
            if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("toolCallId")) != null && strOptString.length() > 0) {
                return strOptString;
            }
        }
        return null;
    }

    public static String u(Map map) {
        q7.k.e(map, "params");
        Object obj = map.get(ServiceContract.RequiredKeys.TRACE_ID);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        Object obj2 = map.get("_meta");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 != null) {
            Object obj3 = map2.get("trace");
            Map map3 = obj3 instanceof Map ? (Map) obj3 : null;
            Object obj4 = map3 != null ? map3.get(ServiceContract.RequiredKeys.TRACE_ID) : null;
            String str2 = obj4 instanceof String ? (String) obj4 : null;
            if (str2 != null) {
                if (str2.length() <= 0) {
                    str2 = null;
                }
                if (str2 != null) {
                    return str2;
                }
            }
        }
        Object obj5 = map.get("_stepclaw_");
        Map map4 = obj5 instanceof Map ? (Map) obj5 : null;
        Object obj6 = map4 != null ? map4.get(ServiceContract.RequiredKeys.TRACE_ID) : null;
        String str3 = obj6 instanceof String ? (String) obj6 : null;
        if (str3 == null || str3.length() <= 0) {
            return null;
        }
        return str3;
    }

    public static String v(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        String strV;
        String strOptString2;
        String strOptString3;
        if (jSONObject != null) {
            String strOptString4 = jSONObject.optString(ServiceContract.RequiredKeys.TRACE_ID);
            q7.k.b(strOptString4);
            if (strOptString4.length() <= 0) {
                strOptString4 = null;
            }
            if (strOptString4 != null) {
                return strOptString4;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("_stepclaw_");
            if (jSONObjectOptJSONObject2 != null && (strOptString3 = jSONObjectOptJSONObject2.optString(ServiceContract.RequiredKeys.TRACE_ID)) != null) {
                if (strOptString3.length() <= 0) {
                    strOptString3 = null;
                }
                if (strOptString3 != null) {
                    return strOptString3;
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("stepclaw");
            if (jSONObjectOptJSONObject3 != null && (strOptString2 = jSONObjectOptJSONObject3.optString("trace_id")) != null) {
                if (strOptString2.length() <= 0) {
                    strOptString2 = null;
                }
                if (strOptString2 != null) {
                    return strOptString2;
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("metadata");
            if (jSONObjectOptJSONObject4 != null && (strV = v(jSONObjectOptJSONObject4)) != null) {
                return strV;
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("_meta");
            if (jSONObjectOptJSONObject5 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject5.optJSONObject("trace")) != null && (strOptString = jSONObjectOptJSONObject.optString(ServiceContract.RequiredKeys.TRACE_ID)) != null) {
                if (strOptString.length() <= 0) {
                    strOptString = null;
                }
                if (strOptString != null) {
                    return strOptString;
                }
            }
        }
        return null;
    }

    public static final Object w(Set set, Enum r22, Enum r32, Enum r42, boolean z4) {
        if (!z4) {
            if (r42 != null) {
                set = r.q1(i0.Z(set, r42));
            }
            return r.g1(set);
        }
        Enum r12 = set.contains(r22) ? r22 : set.contains(r32) ? r32 : null;
        if (q7.k.a(r12, r22) && q7.k.a(r42, r32)) {
            return null;
        }
        return r42 == null ? r12 : r42;
    }

    public static t8.a x(int i2, boolean z4, s8.f0 f0Var, int i10) {
        boolean z10 = (i10 & 1) != 0 ? false : z4;
        boolean z11 = (i10 & 2) == 0;
        if ((i10 & 4) != 0) {
            f0Var = null;
        }
        x.t(i2, "<this>");
        return new t8.a(i2, z11, z10, f0Var != null ? ib.k.S(f0Var) : null, 34);
    }

    public static JSONObject y(JSONObject jSONObject) {
        Object objN;
        Object objN2;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("invokeParamsJson");
        q7.k.b(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        if (strOptString != null) {
            try {
                objN = new JSONObject(strOptString);
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            if (objN instanceof c7.l) {
                objN = null;
            }
            JSONObject jSONObject2 = (JSONObject) objN;
            if (jSONObject2 != null) {
                return jSONObject2;
            }
        }
        Object objOpt = jSONObject.opt("params");
        if ((objOpt instanceof String) && ((CharSequence) objOpt).length() > 0) {
            try {
                objN2 = new JSONObject((String) objOpt);
            } catch (Throwable th2) {
                objN2 = w7.e0.n(th2);
            }
            JSONObject jSONObject3 = (JSONObject) (objN2 instanceof c7.l ? null : objN2);
            if (jSONObject3 != null) {
                return jSONObject3;
            }
        }
        return jSONObject;
    }
}
