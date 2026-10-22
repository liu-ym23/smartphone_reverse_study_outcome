package m4;

import com.stepos.account.oauth.OAuthConstants;
import java.util.List;
import o4.t1;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f6364a = new x();

    public static String b(a6.c cVar) {
        switch (d.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                return "SOUL.md";
            case 2:
                return "AGENTS.md";
            case 3:
                return "USER.md";
            case 4:
                return "MEMORY.md";
            case 5:
                return "TOOLS.md";
            case 6:
                return "IDENTITY.md";
            default:
                throw new a4.u();
        }
    }

    public static a6.m j(JSONObject jSONObject, String str) {
        String str2;
        if (jSONObject.optBoolean("ok", false)) {
            String strOptString = jSONObject.optString("slug");
            if (strOptString.length() == 0) {
                String strOptString2 = jSONObject.optString("skillKey");
                if (strOptString2.length() != 0) {
                    str = strOptString2;
                }
                str2 = str;
            } else {
                str2 = strOptString;
            }
            return new a6.m(true, str2, null, null, null, 28);
        }
        String strOptString3 = jSONObject.optString("code");
        if (strOptString3.length() == 0) {
            strOptString3 = "CLOUD_REJECTED";
        }
        String str3 = strOptString3;
        String strOptString4 = jSONObject.optString(OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (strOptString4.length() == 0) {
            String strOptString5 = jSONObject.optString("stderr");
            if (strOptString5.length() == 0) {
                strOptString5 = null;
            }
            strOptString4 = strOptString5;
        }
        return new a6.m(false, null, str3, strOptString4, d7.a0.f2944f, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(m4.w0 r9, a6.d r10, i7.c r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.a(m4.w0, a6.d, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(m4.w0 r8, i7.c r9) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof m4.f
            if (r0 == 0) goto L14
            r0 = r9
            m4.f r0 = (m4.f) r0
            int r1 = r0.f6189h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6189h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.f r0 = new m4.f
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6187f
            h7.a r9 = h7.a.f4212f
            int r0 = r6.f6189h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            w7.e0.N(r7)
            r6.f6189h = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "health"
            java.lang.String r3 = "{}"
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r9) goto L45
            return r9
        L45:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r7)
            a6.g r0 = new a6.g
            java.lang.String r7 = "ok"
            r9 = 0
            boolean r1 = r8.optBoolean(r7, r9)
            boolean r2 = r8.optBoolean(r7, r9)
            java.lang.String r4 = "openclaw-cloud"
            r5 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.c(m4.w0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(m4.w0 r10, i7.c r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.d(m4.w0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(m4.w0 r8, a6.h r9, i7.c r10) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r10 instanceof m4.h
            if (r0 == 0) goto L14
            r0 = r10
            m4.h r0 = (m4.h) r0
            int r1 = r0.f6211j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6211j = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.h r0 = new m4.h
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.f6209h
            h7.a r0 = h7.a.f4212f
            int r1 = r6.f6211j
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            a6.h r9 = r6.f6208g
            m4.x r7 = r6.f6207f
            w7.e0.N(r10)
            goto L75
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            w7.e0.N(r10)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r1 = "source"
            java.lang.String r3 = "clawhub"
            r10.put(r1, r3)
            java.lang.String r1 = r9.f319a
            java.lang.String r3 = r9.f320b
            java.lang.String r4 = "slug"
            r10.put(r4, r1)
            boolean r1 = ga.k.t0(r3)
            if (r1 != 0) goto L58
            java.lang.String r1 = "version"
            r10.put(r1, r3)
        L58:
            java.lang.String r3 = r10.toString()
            java.lang.String r10 = "toString(...)"
            q7.k.d(r3, r10)
            r6.f6207f = r7
            r6.f6208g = r9
            r6.f6211j = r2
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "skills.install"
            r4 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r10 = r1.i(r2, r3, r4, r6)
            if (r10 != r0) goto L75
            return r0
        L75:
            java.lang.String r10 = (java.lang.String) r10
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r10)
            java.lang.String r9 = r9.f319a
            r7.getClass()
            a6.m r7 = j(r8, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.e(m4.w0, a6.h, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable f(m4.w0 r13, i7.c r14) throws org.json.JSONException {
        /*
            r12 = this;
            boolean r0 = r14 instanceof m4.i
            if (r0 == 0) goto L14
            r0 = r14
            m4.i r0 = (m4.i) r0
            int r1 = r0.f6225h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6225h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.i r0 = new m4.i
            r0.<init>(r12, r14)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f6223f
            h7.a r14 = h7.a.f4212f
            int r0 = r6.f6225h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r12)
            goto L45
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            w7.e0.N(r12)
            r6.f6225h = r1
            o4.t1 r1 = r13.f6363a
            java.lang.String r2 = "channels.status"
            java.lang.String r3 = "{}"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r12 = r1.i(r2, r3, r4, r6)
            if (r12 != r14) goto L45
            return r14
        L45:
            java.lang.String r12 = (java.lang.String) r12
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>(r12)
            java.lang.String r12 = "channelOrder"
            org.json.JSONArray r12 = r13.optJSONArray(r12)
            if (r12 != 0) goto L59
            org.json.JSONArray r12 = new org.json.JSONArray
            r12.<init>()
        L59:
            java.lang.String r14 = "channelLabels"
            org.json.JSONObject r13 = r13.optJSONObject(r14)
            if (r13 != 0) goto L66
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
        L66:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            int r0 = r12.length()
            r1 = 0
        L70:
            if (r1 >= r0) goto La0
            java.lang.String r3 = r12.optString(r1)
            q7.k.b(r3)
            int r2 = r3.length()
            if (r2 != 0) goto L80
            goto L9d
        L80:
            java.lang.String r2 = r13.optString(r3)
            int r4 = r2.length()
            if (r4 != 0) goto L8c
            r5 = r3
            goto L8d
        L8c:
            r5 = r2
        L8d:
            a6.b r2 = new a6.b
            r9 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 440(0x1b8, float:6.17E-43)
            r4 = r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.add(r2)
        L9d:
            int r1 = r1 + 1
            goto L70
        La0:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.f(m4.w0, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable g(m4.w0 r21, i7.c r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.g(m4.w0, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable h(m4.w0 r24, a6.y r25, i7.c r26) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.h(m4.w0, a6.y, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable i(m4.w0 r29, a6.a0 r30, i7.c r31) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.i(m4.w0, a6.a0, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(3:13|34|(2:36|43)(2:37|38))(2:14|15))(1:16))(3:17|(1:20)|32)|21|(1:23)|41|24|28|(3:30|(3:33|34|(0)(0))|32)(2:39|40)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(m4.w0 r19, java.lang.String r20, p7.k r21, i7.c r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.k(m4.w0, java.lang.String, p7.k, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(m4.w0 r8, a6.c r9, i7.c r10) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r10 instanceof m4.n
            if (r0 == 0) goto L14
            r0 = r10
            m4.n r0 = (m4.n) r0
            int r1 = r0.f6266h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6266h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.n r0 = new m4.n
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6264f
            h7.a r10 = h7.a.f4212f
            int r0 = r6.f6266h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r7)
            goto L63
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            w7.e0.N(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r0 = "agentId"
            java.lang.String r2 = "main"
            org.json.JSONObject r7 = r7.put(r0, r2)
            java.lang.String r0 = "name"
            java.lang.String r9 = b(r9)
            org.json.JSONObject r7 = r7.put(r0, r9)
            java.lang.String r3 = r7.toString()
            java.lang.String r7 = "toString(...)"
            q7.k.d(r3, r7)
            r6.f6266h = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "agents.files.get"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r10) goto L63
            return r10
        L63:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r7)
            java.lang.String r7 = "file"
            org.json.JSONObject r7 = r8.optJSONObject(r7)
            if (r7 != 0) goto L73
            goto L89
        L73:
            java.lang.String r8 = "missing"
            r9 = 0
            boolean r8 = r7.optBoolean(r8, r9)
            if (r8 == 0) goto L7d
            goto L89
        L7d:
            java.lang.String r8 = "content"
            java.lang.String r7 = r7.optString(r8)
            int r8 = r7.length()
            if (r8 != 0) goto L8b
        L89:
            java.lang.String r7 = ""
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.l(m4.w0, a6.c, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable m(m4.w0 r18, int r19, java.lang.String r20, i7.c r21) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.m(m4.w0, int, java.lang.String, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(m4.w0 r8, java.lang.String r9, i7.c r10) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r10 instanceof m4.p
            if (r0 == 0) goto L14
            r0 = r10
            m4.p r0 = (m4.p) r0
            int r1 = r0.f6295h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6295h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.p r0 = new m4.p
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6293f
            h7.a r10 = h7.a.f4212f
            int r0 = r6.f6295h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r7)
            goto L57
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            w7.e0.N(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r0 = "slug"
            org.json.JSONObject r7 = r7.put(r0, r9)
            java.lang.String r3 = r7.toString()
            java.lang.String r7 = "toString(...)"
            q7.k.d(r3, r7)
            r6.f6295h = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "skills.detail"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r10) goto L57
            return r10
        L57:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r7)
            java.lang.String r7 = "skill"
            org.json.JSONObject r7 = r8.optJSONObject(r7)
            if (r7 != 0) goto L67
            goto L73
        L67:
            java.lang.String r8 = "summary"
            java.lang.String r7 = r7.optString(r8)
            int r8 = r7.length()
            if (r8 != 0) goto L74
        L73:
            r7 = 0
        L74:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.n(m4.w0, java.lang.String, i7.c):java.lang.Object");
    }

    public final Object o(t1 t1Var, String str, k0 k0Var) {
        return k(new w0(t1Var), a1.a.j("removeChannelEntry[", str, "]"), new a(str, 0), k0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(m4.w0 r11, java.lang.String r12, i7.c r13) throws org.json.JSONException {
        /*
            r10 = this;
            boolean r0 = r13 instanceof m4.q
            if (r0 == 0) goto L14
            r0 = r13
            m4.q r0 = (m4.q) r0
            int r1 = r0.f6310i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6310i = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.q r0 = new m4.q
            r0.<init>(r10, r13)
            goto L12
        L1a:
            java.lang.Object r10 = r6.f6308g
            h7.a r13 = h7.a.f4212f
            int r0 = r6.f6310i
            r1 = 1
            if (r0 == 0) goto L34
            if (r0 != r1) goto L2c
            java.lang.String r12 = r6.f6307f
            w7.e0.N(r10)
        L2a:
            r2 = r12
            goto L5c
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            w7.e0.N(r10)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r0 = "id"
            org.json.JSONObject r10 = r10.put(r0, r12)
            java.lang.String r3 = r10.toString()
            java.lang.String r10 = "toString(...)"
            q7.k.d(r3, r10)
            r6.f6307f = r12
            r6.f6310i = r1
            o4.t1 r1 = r11.f6363a
            java.lang.String r2 = "cron.remove"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r10 = r1.i(r2, r3, r4, r6)
            if (r10 != r13) goto L2a
            return r13
        L5c:
            java.lang.String r10 = (java.lang.String) r10
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>(r10)
            java.lang.String r10 = "removed"
            r12 = 0
            boolean r10 = r11.optBoolean(r10, r12)
            if (r10 == 0) goto L78
            a6.m r0 = new a6.m
            r5 = 0
            r6 = 28
            r1 = 1
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        L78:
            c7.j r10 = new c7.j
            java.lang.String r11 = "jobId"
            r10.<init>(r11, r2)
            java.util.Map r8 = d7.e0.T(r10)
            a6.m r3 = new a6.m
            r5 = 0
            r9 = 2
            r4 = 0
            java.lang.String r6 = "NOT_FOUND"
            java.lang.String r7 = "cron.remove: not removed"
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.p(m4.w0, java.lang.String, i7.c):java.lang.Object");
    }

    public final Object q(t1 t1Var, String str, k0 k0Var) {
        return k(new w0(t1Var), a1.a.j("removeSkillEntry[", str, "]"), new a(str, 1), k0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(m4.w0 r8, i7.c r9) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof m4.r
            if (r0 == 0) goto L14
            r0 = r9
            m4.r r0 = (m4.r) r0
            int r1 = r0.f6325h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6325h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.r r0 = new m4.r
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6323f
            h7.a r9 = h7.a.f4212f
            int r0 = r6.f6325h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r7)
            goto L46
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            w7.e0.N(r7)
            r6.f6325h = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "update.run"
            java.lang.String r3 = "{}"
            r4 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r9) goto L46
            return r9
        L46:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r7)
            java.lang.String r7 = "ok"
            r9 = 0
            boolean r7 = r8.optBoolean(r7, r9)
            if (r7 == 0) goto L63
            a6.m r0 = new a6.m
            r5 = 0
            r6 = 28
            r1 = 1
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        L63:
            java.lang.String r7 = "result"
            org.json.JSONObject r7 = r8.optJSONObject(r7)
            if (r7 == 0) goto L72
            java.lang.String r8 = "reason"
            java.lang.String r7 = r7.optString(r8)
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 != 0) goto L77
            java.lang.String r7 = ""
        L77:
            java.lang.String r8 = "update.run failed: "
            java.lang.String r4 = r8.concat(r7)
            a6.m r0 = new a6.m
            r2 = 0
            r6 = 2
            r1 = 0
            java.lang.String r3 = "CLOUD_REJECTED"
            d7.a0 r5 = d7.a0.f2944f
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.r(m4.w0, i7.c):java.lang.Object");
    }

    public final Object s(t1 t1Var, String str, boolean z4, n0 n0Var) {
        w0 w0Var = new w0(t1Var);
        List listD0 = ga.k.D0(str, new String[]{":"}, 2);
        if (listD0.size() != 2) {
            return new a6.m(false, null, "INVALID_ARG", "channelId must be 'type:account'", d7.a0.f2944f, 2);
        }
        return k(w0Var, a1.a.j("setChannelEnabled[", str, "]"), new c((String) listD0.get(0), (String) listD0.get(1), z4), n0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(m4.w0 r8, java.lang.String r9, boolean r10, i7.c r11) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r11 instanceof m4.s
            if (r0 == 0) goto L14
            r0 = r11
            m4.s r0 = (m4.s) r0
            int r1 = r0.f6330i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6330i = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.s r0 = new m4.s
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6328g
            h7.a r11 = h7.a.f4212f
            int r0 = r6.f6330i
            r1 = 1
            if (r0 == 0) goto L34
            if (r0 != r1) goto L2c
            java.lang.String r9 = r6.f6327f
            w7.e0.N(r7)
        L2a:
            r2 = r9
            goto L60
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            w7.e0.N(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r0 = "id"
            r7.put(r0, r9)
            java.lang.String r0 = "enabled"
            r7.put(r0, r10)
            java.lang.String r3 = r7.toString()
            java.lang.String r7 = "toString(...)"
            q7.k.d(r3, r7)
            r6.f6327f = r9
            r6.f6330i = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "cron.update"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r11) goto L2a
            return r11
        L60:
            a6.m r0 = new a6.m
            r5 = 0
            r6 = 28
            r1 = 1
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.t(m4.w0, java.lang.String, boolean, i7.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(3:13|52|(2:54|61)(2:55|56))(2:14|15))(1:16))(3:17|(1:20)|51)|21|(1:23)|59|24|(1:26)|29|(1:31)|32|(1:34)|35|(1:37)|38|(1:40)|41|(1:43)|44|47|(1:49)(2:57|58)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        if (r1 == r3) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(m4.w0 r19, a6.l r20, i7.c r21) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.u(m4.w0, a6.l, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(m4.w0 r8, java.lang.String r9, boolean r10, i7.c r11) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r11 instanceof m4.u
            if (r0 == 0) goto L14
            r0 = r11
            m4.u r0 = (m4.u) r0
            int r1 = r0.f6340j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6340j = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.u r0 = new m4.u
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f6338h
            h7.a r0 = h7.a.f4212f
            int r1 = r6.f6340j
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.String r9 = r6.f6337g
            m4.x r7 = r6.f6336f
            w7.e0.N(r11)
            goto L63
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            w7.e0.N(r11)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            java.lang.String r1 = "skillKey"
            r11.put(r1, r9)
            java.lang.String r1 = "enabled"
            r11.put(r1, r10)
            java.lang.String r3 = r11.toString()
            java.lang.String r10 = "toString(...)"
            q7.k.d(r3, r10)
            r6.f6336f = r7
            r6.f6337g = r9
            r6.f6340j = r2
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "skills.update"
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r11 = r1.i(r2, r3, r4, r6)
            if (r11 != r0) goto L63
            return r0
        L63:
            java.lang.String r11 = (java.lang.String) r11
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r11)
            r7.getClass()
            a6.m r7 = j(r8, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.v(m4.w0, java.lang.String, boolean, i7.c):java.lang.Object");
    }

    public final Object w(t1 t1Var, String str, boolean z4, o0 o0Var) {
        return k(new w0(t1Var), a1.a.j("setToolEnabled[", str, "]"), new b(str, 0, z4), o0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(m4.w0 r8, a6.d0 r9, i7.c r10) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r10 instanceof m4.v
            if (r0 == 0) goto L14
            r0 = r10
            m4.v r0 = (m4.v) r0
            int r1 = r0.f6353j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6353j = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.v r0 = new m4.v
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.f6351h
            h7.a r0 = h7.a.f4212f
            int r1 = r6.f6353j
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            a6.d0 r9 = r6.f6350g
            m4.x r7 = r6.f6349f
            w7.e0.N(r10)
            goto L6f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            w7.e0.N(r10)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r1 = "skillKey"
            java.lang.String r3 = r9.f303a
            r10.put(r1, r3)
            java.lang.String r1 = "source"
            java.lang.String r3 = "clawhub"
            r10.put(r1, r3)
            java.lang.String r1 = "slug"
            java.lang.String r3 = r9.f303a
            r10.put(r1, r3)
            java.lang.String r3 = r10.toString()
            java.lang.String r10 = "toString(...)"
            q7.k.d(r3, r10)
            r6.f6349f = r7
            r6.f6350g = r9
            r6.f6353j = r2
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "skills.update"
            r4 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r10 = r1.i(r2, r3, r4, r6)
            if (r10 != r0) goto L6f
            return r0
        L6f:
            java.lang.String r10 = (java.lang.String) r10
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r10)
            java.lang.String r9 = r9.f303a
            r7.getClass()
            a6.m r7 = j(r8, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.x(m4.w0, a6.d0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(m4.w0 r8, a6.c r9, java.lang.String r10, i7.c r11) throws org.json.JSONException {
        /*
            r7 = this;
            boolean r0 = r11 instanceof m4.w
            if (r0 == 0) goto L14
            r0 = r11
            m4.w r0 = (m4.w) r0
            int r1 = r0.f6362i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6362i = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            m4.w r0 = new m4.w
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r7 = r6.f6360g
            h7.a r11 = h7.a.f4212f
            int r0 = r6.f6362i
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            a6.c r9 = r6.f6359f
            w7.e0.N(r7)
            goto L6d
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            w7.e0.N(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r0 = "agentId"
            java.lang.String r2 = "main"
            org.json.JSONObject r7 = r7.put(r0, r2)
            java.lang.String r0 = "name"
            java.lang.String r2 = b(r9)
            org.json.JSONObject r7 = r7.put(r0, r2)
            java.lang.String r0 = "content"
            org.json.JSONObject r7 = r7.put(r0, r10)
            java.lang.String r3 = r7.toString()
            java.lang.String r7 = "toString(...)"
            q7.k.d(r3, r7)
            r6.f6359f = r9
            r6.f6362i = r1
            o4.t1 r1 = r8.f6363a
            java.lang.String r2 = "agents.files.set"
            r4 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r7 = r1.i(r2, r3, r4, r6)
            if (r7 != r11) goto L6d
            return r11
        L6d:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r7)
            java.lang.String r7 = "ok"
            r10 = 0
            boolean r7 = r8.optBoolean(r7, r10)
            if (r7 == 0) goto L8d
            java.lang.String r2 = r9.name()
            a6.m r0 = new a6.m
            r5 = 0
            r6 = 28
            r1 = 1
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        L8d:
            java.lang.String r7 = "error"
            java.lang.String r7 = r8.optString(r7)
            int r8 = r7.length()
            if (r8 != 0) goto L9b
            java.lang.String r7 = "agents.files.set failed"
        L9b:
            r4 = r7
            a6.m r0 = new a6.m
            r2 = 0
            r6 = 2
            r1 = 0
            java.lang.String r3 = "CLOUD_REJECTED"
            d7.a0 r5 = d7.a0.f2944f
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x.y(m4.w0, a6.c, java.lang.String, i7.c):java.lang.Object");
    }
}
