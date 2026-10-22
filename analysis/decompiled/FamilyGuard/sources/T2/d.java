package T2;

import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import g3.C0742e;
import org.json.JSONException;

/* loaded from: classes.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    private static String f5409g = "EventBean";

    /* renamed from: a, reason: collision with root package name */
    long f5410a;

    /* renamed from: b, reason: collision with root package name */
    int f5411b;

    /* renamed from: c, reason: collision with root package name */
    String f5412c;

    /* renamed from: d, reason: collision with root package name */
    String f5413d;

    /* renamed from: e, reason: collision with root package name */
    String f5414e;

    /* renamed from: f, reason: collision with root package name */
    String f5415f;

    public static d a(int i5, TrackerPayload trackerPayload) throws JSONException {
        String string;
        d dVar = new d();
        dVar.h(i5);
        String str = (String) trackerPayload.D().get("sid");
        String str2 = (String) trackerPayload.D().get("source");
        dVar.l(str);
        dVar.j(str2);
        trackerPayload.D().remove("sid");
        trackerPayload.D().remove("source");
        int iB = dVar.b();
        if (iB != 0) {
            string = null;
            try {
                string = Z2.a.h().f("262t1#x23&^ya1bk", trackerPayload.toString(), iB);
                C0742e.c(f5409g, "SimpleCryptoAES encrypt[" + iB + "] done");
            } catch (Exception e6) {
                C0742e.l(f5409g, "SimpleCryptoAES encrypt[" + iB + "], Exception: " + e6.toString() + " - Cause: " + e6.getCause());
            }
        } else {
            string = trackerPayload.toString();
        }
        dVar.i(string);
        trackerPayload.a("sid", str);
        trackerPayload.a("source", str2);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload m(T2.d r7) {
        /*
            java.lang.String r0 = "SimpleCryptoAES decrypt["
            int r1 = r7.b()
            r2 = 0
            if (r1 == 0) goto L62
            Z2.a r3 = Z2.a.h()     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = "262t1#x23&^ya1bk"
            java.lang.String r5 = r7.c()     // Catch: java.lang.Exception -> L33
            java.lang.String r3 = r3.a(r4, r5, r1)     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = T2.d.f5409g     // Catch: java.lang.Exception -> L31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            r5.<init>()     // Catch: java.lang.Exception -> L31
            r5.append(r0)     // Catch: java.lang.Exception -> L31
            r5.append(r1)     // Catch: java.lang.Exception -> L31
            java.lang.String r6 = "] done"
            r5.append(r6)     // Catch: java.lang.Exception -> L31
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L31
            g3.C0742e.c(r4, r5)     // Catch: java.lang.Exception -> L31
            goto L66
        L31:
            r4 = move-exception
            goto L35
        L33:
            r4 = move-exception
            r3 = r2
        L35:
            java.lang.String r5 = T2.d.f5409g
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "], Exception: "
            r6.append(r0)
            java.lang.String r0 = r4.toString()
            r6.append(r0)
            java.lang.String r0 = " - Cause: "
            r6.append(r0)
            java.lang.Throwable r0 = r4.getCause()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            g3.C0742e.l(r5, r0)
            goto L66
        L62:
            java.lang.String r3 = r7.c()
        L66:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.B(r3)
            if (r0 == 0) goto L7f
            java.lang.String r1 = r7.f()
            java.lang.String r2 = "sid"
            r0.a(r2, r1)
            java.lang.String r7 = r7.d()
            java.lang.String r1 = "source"
            r0.a(r1, r7)
            return r0
        L7f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: T2.d.m(T2.d):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }

    public int b() {
        return this.f5411b;
    }

    public String c() {
        return this.f5414e;
    }

    public String d() {
        return this.f5413d;
    }

    public long e() {
        return this.f5410a;
    }

    public String f() {
        return this.f5412c;
    }

    public void g(String str) {
        this.f5415f = str;
    }

    public void h(int i5) {
        this.f5411b = i5;
    }

    public void i(String str) {
        this.f5414e = str;
    }

    public void j(String str) {
        this.f5413d = str;
    }

    public void k(long j5) {
        this.f5410a = j5;
    }

    public void l(String str) {
        this.f5412c = str;
    }
}
