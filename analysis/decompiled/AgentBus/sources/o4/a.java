package o4;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.account.oauth.OAuthConstants;
import java.io.File;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7260a = {1, 2, 3};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v3, types: [p7.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [p7.a] */
    /* JADX WARN: Type inference failed for: r4v5, types: [p7.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0080 -> B:28:0x0084). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(j1.s r8, o4.e0 r9, long r10, long r12, a5.a r14, i7.c r15) {
        /*
            boolean r0 = r15 instanceof o4.u1
            if (r0 == 0) goto L13
            r0 = r15
            o4.u1 r0 = (o4.u1) r0
            int r1 = r0.f7655m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7655m = r1
            goto L18
        L13:
            o4.u1 r0 = new o4.u1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f7654l
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7655m
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            long r8 = r0.f7653k
            long r10 = r0.f7652j
            long r12 = r0.f7651i
            p7.k r14 = r0.f7650h
            p7.a r2 = r0.f7649g
            p7.a r4 = r0.f7648f
            w7.e0.N(r15)
            r6 = r12
            r12 = r10
            r10 = r6
            goto L84
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            w7.e0.N(r15)
            r4 = 0
        L43:
            java.lang.Object r15 = r8.c()
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L8a
            java.lang.Object r15 = r9.c()
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L5e
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        L5e:
            int r15 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r15 < 0) goto L6b
            java.lang.Long r8 = new java.lang.Long
            r8.<init>(r4)
            r14.invoke(r8)
            goto L8a
        L6b:
            r0.f7648f = r8
            r0.f7649g = r9
            r0.f7650h = r14
            r0.f7651i = r10
            r0.f7652j = r12
            r0.f7653k = r4
            r0.f7655m = r3
            java.lang.Object r15 = ia.d0.g(r12, r0)
            if (r15 != r1) goto L80
            return r1
        L80:
            r2 = r9
            r6 = r4
            r4 = r8
            r8 = r6
        L84:
            long r8 = r8 + r12
            r6 = r8
            r8 = r4
            r4 = r6
            r9 = r2
            goto L43
        L8a:
            java.lang.Object r8 = r9.c()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r8 = r8 ^ r3
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.a.a(j1.s, o4.e0, long, long, a5.a, i7.c):java.lang.Object");
    }

    public static String b(byte[] bArr) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        q7.k.b(bArrDigest);
        return d7.n.n0(bArrDigest, "", new b(5), 30);
    }

    public static String c(int i2, String str) {
        Object objN;
        try {
            objN = new JSONObject(str);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (objN instanceof c7.l) {
            objN = null;
        }
        JSONObject jSONObject = (JSONObject) objN;
        if (jSONObject != null) {
            Object objOpt = jSONObject.opt("error");
            if (objOpt instanceof String) {
                if (((CharSequence) objOpt).length() > 0) {
                    return (String) objOpt;
                }
            } else if (objOpt instanceof JSONObject) {
                String strOptString = ((JSONObject) objOpt).optString(OAuthConstants.FACTOR_RESULT_MESSAGE);
                q7.k.b(strOptString);
                if (strOptString.length() > 0) {
                    return strOptString;
                }
            }
        }
        return ga.k.t0(str) ? n.f.c(i2, "HTTP ") : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String d(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "deviceId"
            q7.k.e(r6, r0)
            if (r5 == 0) goto L2c
            r0 = 8
            java.lang.String r0 = ga.k.L0(r0, r5)
            int r5 = r5.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "…("
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = "B)"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            if (r5 != 0) goto L2e
        L2c:
            java.lang.String r5 = "null"
        L2e:
            java.lang.String r0 = "] connect token source="
            java.lang.String r1 = " tokenPreview="
            java.lang.String r2 = "["
            java.lang.StringBuilder r3 = a1.a.p(r2, r3, r0, r4, r1)
            java.lang.String r4 = " deviceId="
            java.lang.String r3 = m.x.n(r3, r5, r4, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.a.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean e(String str) {
        Object objN;
        try {
            objN = new JSONObject(str);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (objN instanceof c7.l) {
            objN = null;
        }
        JSONObject jSONObject = (JSONObject) objN;
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.has("ok");
    }

    public static Map f() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new h(OAuthConstants.RESPONSE_CODE_OK, 0.75f, true));
        q7.k.d(mapSynchronizedMap, "synchronizedMap(...)");
        return mapSynchronizedMap;
    }

    public static z1 g(String str, int i2, boolean z4) {
        q7.k.e(str, "host");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        return new z1("manual|" + lowerCase + "|" + i2, str + ":" + i2, str, i2, z4, null, null, 960);
    }

    public static l0 h(int i2, String str) {
        if ((200 <= i2 && i2 < 300) || e(str)) {
            return new l0(true, str, null);
        }
        if (i2 == 401) {
            String strC = c(i2, str);
            q7.k.e(strC, OAuthConstants.FACTOR_RESULT_MESSAGE);
            return new l0(false, null, new j0("UNAUTHORIZED", strC, null));
        }
        String strC2 = c(i2, str);
        q7.k.e(strC2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        return new l0(false, null, new j0("PLUGIN_REJECTED", strC2, null));
    }

    public static String i(String str) {
        String string = str != null ? ga.k.N0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(string.length());
        int length = string.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = string.charAt(i2);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = (char) (cCharAt + ' ');
            }
            sb2.append(cCharAt);
        }
        String string2 = sb2.toString();
        q7.k.d(string2, "toString(...)");
        return string2;
    }

    public static void j(c5.b bVar) {
        Object next;
        Iterator it = t2.f7599m.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (q7.k.a(((t2) next).f7608g, "openclaw-cloud")) {
                    break;
                }
            }
        }
        t2 t2Var = (t2) next;
        if (t2Var == null) {
            t2Var = (t2) d7.r.P0(t2.f7599m);
        }
        if (t2Var != null) {
            t2Var.l(bVar, false);
            return;
        }
        String strB = bVar.b();
        if (strB != null) {
            if (strB.length() <= 0) {
                strB = null;
            }
            if (strB == null) {
                return;
            }
            Map mapG = bVar.g();
            Object obj = mapG != null ? mapG.get("sessionId") : null;
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "agent:main:main";
            }
            b2.c(strB, str);
        }
    }

    public static boolean k(Context context) {
        Object objN;
        Object objN2;
        l3.b bVarI0;
        boolean zEquals;
        boolean z4;
        try {
            ab.x xVar = new ab.x(context, 0);
            xVar.j();
            l3.e eVarA = l3.e.a(context, "openclaw_keystore_probe_prefs", xVar.a());
            if (q7.k.a(eVarA.getString("ok", null), "v1")) {
                z4 = true;
                objN = Boolean.valueOf(z4);
            } else {
                l3.d dVar = (l3.d) eVarA.edit();
                dVar.putString("ok", "v1");
                if (dVar.commit() && q7.k.a(eVarA.getString("ok", null), "v1")) {
                    z4 = true;
                    objN = Boolean.valueOf(z4);
                } else {
                    z4 = false;
                    objN = Boolean.valueOf(z4);
                }
            }
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Object obj = Boolean.FALSE;
        if (objN instanceof c7.l) {
            objN = obj;
        }
        if (((Boolean) objN).booleanValue()) {
            try {
                File file = new File(context.getFilesDir(), "openclaw_keystore_probe_file.bin");
                boolean zExists = file.exists();
                byte[] bArr = f7260a;
                if (zExists) {
                    ab.x xVar2 = new ab.x(context, 0);
                    xVar2.j();
                    bVarI0 = new l3.a(context, file, xVar2.a()).a().I0();
                    try {
                        byte[] bArrW = n7.a.w(bVarI0);
                        bVarI0.close();
                        zEquals = Arrays.equals(bArrW, bArr);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } else {
                    ab.x xVar3 = new ab.x(context, 0);
                    xVar3.j();
                    l3.c cVarJ0 = new l3.a(context, file, xVar3.a()).a().J0();
                    try {
                        cVarJ0.write(bArr);
                        cVarJ0.close();
                        ab.x xVar4 = new ab.x(context, 0);
                        xVar4.j();
                        bVarI0 = new l3.a(context, file, xVar4.a()).a().I0();
                        try {
                            byte[] bArrW2 = n7.a.w(bVarI0);
                            bVarI0.close();
                            zEquals = Arrays.equals(bArrW2, bArr);
                        } finally {
                        }
                    } finally {
                    }
                }
                objN2 = Boolean.valueOf(zEquals);
            } catch (Throwable th2) {
                objN2 = w7.e0.n(th2);
            }
            Object obj2 = Boolean.FALSE;
            if (objN2 instanceof c7.l) {
                objN2 = obj2;
            }
            if (((Boolean) objN2).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(java.lang.String r4, la.f0 r5, k5.q r6, i7.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof o4.d3
            if (r0 == 0) goto L13
            r0 = r7
            o4.d3 r0 = (o4.d3) r0
            int r1 = r0.f7331g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7331g = r1
            goto L18
        L13:
            o4.d3 r0 = new o4.d3
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f7330f
            h7.a r1 = h7.a.f4212f
            int r1 = r0.f7331g
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            w7.e0.N(r7)
            a4.u r4 = new a4.u
            r4.<init>()
            throw r4
        L34:
            w7.e0.N(r7)
            q7.v r7 = new q7.v
            r7.<init>()
            la.u0 r1 = r5.f5918f
            java.lang.Object r1 = r1.getValue()
            d5.r r1 = (d5.r) r1
            d5.q r3 = d5.q.f2898a
            boolean r3 = q7.k.a(r1, r3)
            if (r3 == 0) goto L4f
            k5.j r1 = k5.j.ONLINE
            goto L5c
        L4f:
            d5.o r3 = d5.o.f2895a
            boolean r1 = q7.k.a(r1, r3)
            if (r1 == 0) goto L5a
            k5.j r1 = k5.j.DOWN
            goto L5c
        L5a:
            k5.j r1 = k5.j.OFFLINE
        L5c:
            r7.f8820f = r1
            d5.k r1 = new d5.k
            r3 = 4
            r1.<init>(r7, r6, r4, r3)
            r0.f7331g = r2
            r5.x(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.a.l(java.lang.String, la.f0, k5.q, i7.c):void");
    }

    public static void m(Context context, List list, List list2) {
        try {
            context.deleteSharedPreferences("openclaw_keystore_probe_prefs");
        } catch (Throwable th) {
            w7.e0.n(th);
        }
        try {
            new File(context.getFilesDir(), "openclaw_keystore_probe_file.bin").delete();
        } catch (Throwable th2) {
            w7.e0.n(th2);
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            try {
                context.deleteSharedPreferences((String) it.next());
            } catch (Throwable th3) {
                w7.e0.n(th3);
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                ((File) it2.next()).delete();
            } catch (Throwable th4) {
                w7.e0.n(th4);
            }
        }
        try {
            context.deleteSharedPreferences("__androidx_security_crypto_encrypted_file_pref__");
        } catch (Throwable th5) {
            w7.e0.n(th5);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias("_androidx_security_master_key_")) {
                keyStore.deleteEntry("_androidx_security_master_key_");
            }
        } catch (Throwable th6) {
            w7.e0.n(th6);
        }
    }

    public static void n(Context context, k5.g gVar, List list, List list2) {
        Object objN;
        q7.k.e(context, "context");
        q7.k.e(gVar, "logger");
        try {
            if (!k(context)) {
                k5.s.warn$default(gVar, "OpenClawKeystoreCheck", "androidx.security keystore mismatch detected (likely after reinstall); resetting master key + " + list.size() + " files + " + list2.size() + " prefs + EncryptedFile keyset prefs", null, 4, null);
                m(context, list, list2);
                if (!k(context)) {
                    throw new IllegalStateException("androidx.security keystore still failing after reset; device keystore may be unusable");
                }
                k5.s.info$default(gVar, "OpenClawKeystoreCheck", "androidx.security keystore reset successful", null, 4, null);
            }
            objN = c7.r.f1986a;
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            gVar.c("OpenClawKeystoreCheck", "androidx.security health check threw, swallowed to avoid crash: " + thA.getMessage(), thA);
        }
    }

    public static SharedPreferences o(Context context) {
        Object objN;
        try {
            ab.x xVar = new ab.x(context, 0);
            xVar.j();
            objN = l3.e.a(context, "openclaw_device_tokens", xVar.a());
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (objN instanceof c7.l) {
            objN = null;
        }
        return (SharedPreferences) objN;
    }

    public static SharedPreferences p(Context context) {
        Object objN;
        try {
            ab.x xVar = new ab.x(context, 0);
            xVar.j();
            objN = l3.e.a(context, "openclaw_tls_fingerprints", xVar.a());
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (objN instanceof c7.l) {
            objN = null;
        }
        return (SharedPreferences) objN;
    }
}
