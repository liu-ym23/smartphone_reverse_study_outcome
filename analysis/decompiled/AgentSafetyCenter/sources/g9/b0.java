package g9;

import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public String f4408a;

    /* renamed from: b, reason: collision with root package name */
    public ad.w f4409b;

    /* renamed from: c, reason: collision with root package name */
    public ad.s f4410c;

    public b0(String str) {
        str.getClass();
        this.f4408a = k0.a.n(hc.h.x0(str, JsonPointer.SEPARATOR), "/v1/tool_security/device/policy/snapshot");
        ad.v vVar = new ad.v();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        vVar.a(30L, timeUnit);
        vVar.f601t = bd.b.b(30L, timeUnit);
        vVar.f602u = bd.b.b(30L, timeUnit);
        vVar.f588f = true;
        this.f4409b = new ad.w(vVar);
        Pattern pattern = ad.s.f568d;
        this.f4410c = id.k.t("application/json; charset=utf-8");
    }

    public static final void a(b0 b0Var, String str, String str2, int i, String str3, ad.n nVar) {
        Object objL;
        int i3 = 0;
        boolean z10 = 200 <= i && i < 300;
        Log.i("LedgerCloudApi", "======== " + str + " RESPONSE ========");
        Log.i("LedgerCloudApi", "http=" + i + " bodyBytes=" + str3.length());
        Set set = p9.a.f9925a;
        Log.i("LedgerCloudApi", "responseHeaders=" + p9.a.b(nVar));
        if (z10) {
            Log.i("LedgerCloudApi", p9.a.a(str3, "responseBody"));
        } else if (str3.length() == 0) {
            Log.i("LedgerCloudApi", "responseBody=(empty)");
        } else {
            try {
                objL = new JSONObject(str3).toString(2);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (jb.i.b(objL) != null) {
                objL = str3;
            }
            String str4 = (String) objL;
            if (str4.length() <= 3500) {
                Log.i("LedgerCloudApi", "responseBody=\n".concat(str4));
            } else {
                int length = (str4.length() + 3499) / 3500;
                int i10 = 1;
                while (i3 < str4.length()) {
                    int i11 = i3 + 3500;
                    int length2 = str4.length();
                    if (i11 > length2) {
                        i11 = length2;
                    }
                    String strSubstring = str4.substring(i3, i11);
                    StringBuilder sbU = k0.a.u("responseBody part=", i10, "/", "\n", length);
                    sbU.append(strSubstring);
                    Log.i("LedgerCloudApi", sbU.toString());
                    i10++;
                    i3 = i11;
                }
            }
        }
        String strReplace = str3.replace('\n', ' ');
        strReplace.getClass();
        String strT0 = hc.h.t0(500, strReplace);
        StringBuilder sbP = androidx.activity.b.p("SERVER_TRIAGE method=POST url=", b0Var.f4408a, " request=", str2, " http=");
        sbP.append(i);
        sbP.append(" response=");
        sbP.append(strT0);
        Log.i("LedgerCloudApi", sbP.toString());
        Log.i("LedgerCloudApi", "======== " + str + " RESPONSE END ========");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(g9.b0 r5, java.lang.String r6, java.lang.String r7, pb.c r8) {
        /*
            boolean r0 = r8 instanceof y8.j
            if (r0 == 0) goto L13
            r0 = r8
            y8.j r0 = (y8.j) r0
            int r1 = r0.f15976g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15976g = r1
            goto L18
        L13:
            y8.j r0 = new y8.j
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f15974c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f15976g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L28
            id.c.I(r8)
            goto L43
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r4
        L2e:
            id.c.I(r8)
            rc.e r8 = kc.e0.f7430a
            rc.d r8 = rc.d.f10552f
            g9.y r2 = new g9.y
            r2.<init>(r5, r7, r6, r4)
            r0.f15976g = r3
            java.lang.Object r8 = kc.w.E(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            jb.i r8 = (jb.i) r8
            java.lang.Object r5 = r8.f6762c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.b(g9.b0, java.lang.String, java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(g9.b0 r5, java.lang.String r6, java.lang.String r7, pb.c r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof g9.x
            if (r0 == 0) goto L13
            r0 = r8
            g9.x r0 = (g9.x) r0
            int r1 = r0.f4647g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4647g = r1
            goto L18
        L13:
            g9.x r0 = new g9.x
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f4645c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4647g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L28
            id.c.I(r8)
            goto L43
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r4
        L2e:
            id.c.I(r8)
            rc.e r8 = kc.e0.f7430a
            rc.d r8 = rc.d.f10552f
            g9.y r2 = new g9.y
            r2.<init>(r7, r5, r6, r4)
            r0.f4647g = r3
            java.lang.Object r8 = kc.w.E(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            jb.i r8 = (jb.i) r8
            java.lang.Object r5 = r8.f6762c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.c(g9.b0, java.lang.String, java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r6, boolean r7, pb.c r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof g9.v
            if (r0 == 0) goto L13
            r0 = r8
            g9.v r0 = (g9.v) r0
            int r1 = r0.f4630g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4630g = r1
            goto L18
        L13:
            g9.v r0 = new g9.v
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f4628c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4630g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2e
            if (r2 != r4) goto L28
            id.c.I(r8)
            goto L43
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r3
        L2e:
            id.c.I(r8)
            rc.e r8 = kc.e0.f7430a
            rc.d r8 = rc.d.f10552f
            g9.w r2 = new g9.w
            r2.<init>(r7, r5, r6, r3)
            r0.f4630g = r4
            java.lang.Object r8 = kc.w.E(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            jb.i r8 = (jb.i) r8
            java.lang.Object r5 = r8.f6762c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.d(java.lang.String, boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(y8.w r11, long r12, pb.c r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof y8.i
            if (r0 == 0) goto L13
            r0 = r14
            y8.i r0 = (y8.i) r0
            int r1 = r0.f15973g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15973g = r1
            goto L18
        L13:
            y8.i r0 = new y8.i
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f15971c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f15973g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r14)
            goto L47
        L27:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L2e:
            id.c.I(r14)
            rc.e r14 = kc.e0.f7430a
            rc.d r14 = rc.d.f10552f
            m8.y r4 = new m8.y
            r9 = 0
            r8 = r10
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r8, r9)
            r0.f15973g = r3
            java.lang.Object r14 = kc.w.E(r14, r4, r0)
            if (r14 != r1) goto L47
            return r1
        L47:
            jb.i r14 = (jb.i) r14
            java.lang.Object r10 = r14.f6762c
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.e(y8.w, long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.String r6, pb.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof g9.h1
            if (r0 == 0) goto L13
            r0 = r7
            g9.h1 r0 = (g9.h1) r0
            int r1 = r0.f4475g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4475g = r1
            goto L18
        L13:
            g9.h1 r0 = new g9.h1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4473c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4475g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2e
            if (r2 != r4) goto L28
            id.c.I(r7)
            goto L43
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r3
        L2e:
            id.c.I(r7)
            rc.e r7 = kc.e0.f7430a
            rc.d r7 = rc.d.f10552f
            g9.f0 r2 = new g9.f0
            r2.<init>(r5, r6, r3, r4)
            r0.f4475g = r4
            java.lang.Object r7 = kc.w.E(r7, r2, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            jb.i r7 = (jb.i) r7
            java.lang.Object r5 = r7.f6762c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.f(java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(java.lang.String r12, java.lang.String r13, long r14, pb.c r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof g9.z
            if (r1 == 0) goto L15
            r1 = r0
            g9.z r1 = (g9.z) r1
            int r2 = r1.f4659g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f4659g = r2
            goto L1a
        L15:
            g9.z r1 = new g9.z
            r1.<init>(r11, r0)
        L1a:
            java.lang.Object r0 = r1.f4657c
            ob.a r9 = ob.a.f9351c
            int r2 = r1.f4659g
            r10 = 1
            if (r2 == 0) goto L30
            if (r2 != r10) goto L29
            id.c.I(r0)
            goto L4a
        L29:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            return r0
        L30:
            id.c.I(r0)
            rc.e r0 = kc.e0.f7430a
            rc.d r0 = rc.d.f10552f
            g9.a0 r2 = new g9.a0
            r8 = 0
            r7 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r1.f4659g = r10
            java.lang.Object r0 = kc.w.E(r0, r2, r1)
            if (r0 != r9) goto L4a
            return r9
        L4a:
            jb.i r0 = (jb.i) r0
            java.lang.Object r0 = r0.f6762c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b0.g(java.lang.String, java.lang.String, long, pb.c):java.lang.Object");
    }
}
