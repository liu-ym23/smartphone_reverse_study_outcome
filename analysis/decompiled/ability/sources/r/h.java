package r;

import android.text.TextUtils;
import e2.C1404a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import v.j;

/* loaded from: classes2.dex */
public final class h {
    public static long l;
    public static g m;

    /* renamed from: a, reason: collision with root package name */
    public final C1871c f5668a;
    public final C1404a b;
    public j c;
    public j d;
    public String e;
    public long f = -1;
    public volatile boolean g;
    public long h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public String f5669j;
    public volatile String k;

    public h(C1871c c1871c) {
        this.f5668a = c1871c;
        this.b = C1404a.c(c1871c.f.a());
    }

    public final Map a() {
        try {
            C1404a c1404aC = C1404a.c(this.f5668a.c.b.f4335a);
            c1404aC.getClass();
            try {
                if (c1404aC.d == null) {
                    c1404aC.d = new ConcurrentHashMap();
                }
                if (D2.b.e()) {
                    c1404aC.d.put("is_harmony_os", "1");
                } else {
                    c1404aC.d.put("is_harmony_os", "0");
                }
            } catch (Throwable unused) {
            }
            return c1404aC.d;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final synchronized v.h b(v.b bVar, ArrayList arrayList, boolean z10) {
        v.h hVar;
        try {
            long j5 = bVar instanceof g ? -1L : bVar.b;
            this.e = UUID.randomUUID().toString();
            if (z10 && !this.f5668a.p && TextUtils.isEmpty(this.k)) {
                this.k = this.e;
            }
            l = 10000L;
            this.f = j5;
            this.g = z10;
            this.h = 0L;
            if (z10) {
                Calendar calendar = Calendar.getInstance();
                StringBuilder sbF = M.a.f("");
                sbF.append(calendar.get(1));
                sbF.append(calendar.get(2));
                sbF.append(calendar.get(5));
                String string = sbF.toString();
                s.g gVar = this.f5668a.c;
                if (TextUtils.isEmpty(this.f5669j)) {
                    this.f5669j = gVar.d.getString("session_last_day", "");
                    this.i = gVar.d.getInt("session_order", 0);
                }
                if (string.equals(this.f5669j)) {
                    this.i++;
                } else {
                    this.f5669j = string;
                    this.i = 1;
                }
                gVar.d.edit().putString("session_last_day", string).putInt("session_order", this.i).apply();
                long j6 = bVar.b;
            }
            if (j5 != -1) {
                hVar = new v.h();
                hVar.d = this.e;
                hVar.n = !this.g;
                long j10 = l + 1;
                l = j10;
                hVar.c = j10;
                hVar.c(this.f);
                hVar.m = this.f5668a.f.g();
                hVar.l = this.f5668a.f.f();
                hVar.e = 0L;
                C1404a c1404a = this.b;
                String string2 = "";
                if (c1404a.b != null) {
                    s.h hVar2 = c1404a.b;
                    if (hVar2.f5975a) {
                        string2 = hVar2.d.optString("user_unique_id", "");
                    } else {
                        s.g gVar2 = hVar2.c;
                        if (gVar2 != null) {
                            string2 = gVar2.c.getString("user_unique_id", null);
                        }
                    }
                }
                hVar.f = string2;
                C1404a c1404a2 = this.b;
                hVar.g = c1404a2.b != null ? c1404a2.b.d.optString("ssid", "") : "";
                hVar.h = this.b.a();
                if (z10) {
                    this.f5668a.c.getClass();
                }
                hVar.p = 0;
                arrayList.add(hVar);
            } else {
                hVar = null;
            }
            if (C1404a.e <= 0) {
                C1404a.e = 6;
            }
            StringBuilder sbF2 = M.a.f("startSession, ");
            sbF2.append(this.g ? "fg" : "bg");
            sbF2.append(", ");
            sbF2.append(this.e);
            w.h.a(sbF2.toString(), null);
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(v.b r6) {
        /*
            r5 = this;
            e2.a r0 = r5.b
            if (r6 == 0) goto L52
            r1 = 0
            r6.e = r1
            s.h r1 = r0.b
            java.lang.String r2 = ""
            if (r1 == 0) goto L29
            s.h r1 = r0.b
            boolean r3 = r1.f5975a
            java.lang.String r4 = "user_unique_id"
            if (r3 == 0) goto L1d
            org.json.JSONObject r1 = r1.d
            java.lang.String r1 = r1.optString(r4, r2)
            goto L2a
        L1d:
            s.g r1 = r1.c
            if (r1 == 0) goto L29
            android.content.SharedPreferences r1 = r1.c
            r3 = 0
            java.lang.String r1 = r1.getString(r4, r3)
            goto L2a
        L29:
            r1 = r2
        L2a:
            r6.f = r1
            s.h r1 = r0.b
            if (r1 == 0) goto L3a
            s.h r1 = r0.b
            org.json.JSONObject r1 = r1.d
            java.lang.String r3 = "ssid"
            java.lang.String r2 = r1.optString(r3, r2)
        L3a:
            r6.g = r2
            java.lang.String r5 = r5.e
            r6.d = r5
            long r1 = r.h.l
            r3 = 1
            long r1 = r1 + r3
            r.h.l = r1
            r6.c = r1
            java.lang.String r5 = r0.a()
            r6.h = r5
            r5 = -1
            r6.i = r5
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.h.c(v.b):void");
    }
}
