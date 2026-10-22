package com.baidu.b.b;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import com.baidu.b.h;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends com.baidu.b.b.a {

    /* renamed from: d, reason: collision with root package name */
    a.C0007a f4753d;

    /* renamed from: e, reason: collision with root package name */
    private a f4754e;

    public class a {

        /* renamed from: c, reason: collision with root package name */
        private long f4757c;

        /* renamed from: d, reason: collision with root package name */
        private h.a f4758d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f4759e;

        /* renamed from: g, reason: collision with root package name */
        private int f4761g;

        /* renamed from: b, reason: collision with root package name */
        private com.baidu.b.f.b f4756b = new com.baidu.b.f.b();

        /* renamed from: f, reason: collision with root package name */
        private boolean f4760f = true;

        public a() {
        }

        public long a() {
            return this.f4757c;
        }

        public h.a b() {
            return this.f4758d;
        }

        public boolean a(PackageInfo packageInfo) {
            String strA = d.this.f4753d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f4760f = false;
            return a(strA);
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f4757c = jSONObject.getLong("pub_lst_ts");
                    this.f4758d = h.a(jSONObject.getString("pub_info"));
                    this.f4761g = jSONObject.getInt("d_form_ver");
                    this.f4759e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public class b extends a.b {

        /* renamed from: b, reason: collision with root package name */
        private int f4763b;

        /* renamed from: c, reason: collision with root package name */
        private String f4764c;

        /* renamed from: d, reason: collision with root package name */
        private long f4765d;

        /* renamed from: e, reason: collision with root package name */
        private long f4766e;

        /* renamed from: f, reason: collision with root package name */
        private long f4767f;

        /* renamed from: g, reason: collision with root package name */
        private h.a f4768g;

        public b(String str) {
            super(d.this.f4753d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.b.b.a.b
        public void b(JSONObject jSONObject) throws JSONException {
            jSONObject.put("pkg", this.f4764c);
            jSONObject.put("last_fe_ts", this.f4765d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f4766e);
            jSONObject.put("info", this.f4768g.a());
            jSONObject.put("tar_pkg_lst_up_ts", this.f4767f);
            jSONObject.put("d_form_ver", 1);
        }

        public String c() {
            return this.f4764c;
        }

        public h.a d() {
            return this.f4768g;
        }

        public long e() {
            return this.f4767f;
        }

        @Override // com.baidu.b.b.a.b
        public void a(JSONObject jSONObject) throws JSONException {
            this.f4764c = jSONObject.getString("pkg");
            this.f4766e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f4765d = jSONObject.getLong("last_fe_ts");
            this.f4768g = h.a(jSONObject.getString("info"));
            this.f4767f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f4763b = jSONObject.getInt("d_form_ver");
        }

        public boolean b(long j4) {
            if (this.f4766e == j4) {
                return false;
            }
            this.f4766e = j4;
            a(true);
            return true;
        }

        public boolean c(long j4) {
            if (this.f4767f == j4) {
                return false;
            }
            this.f4767f = j4;
            a(true);
            return true;
        }

        public boolean a(long j4) {
            if (this.f4765d == j4) {
                return false;
            }
            this.f4765d = j4;
            a(true);
            return true;
        }

        public boolean a(h.a aVar) {
            if (aVar.equals(this.f4768g)) {
                return false;
            }
            this.f4768g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f4764c)) {
                return false;
            }
            this.f4764c = str;
            a(true);
            return true;
        }
    }

    public d() {
        super("isc", 8000000L);
        this.f4754e = new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[PHI: r2
      0x0041: PHI (r2v1 com.baidu.b.b.d$b) = (r2v0 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b) binds: [B:11:0x001a, B:13:0x002c, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.baidu.b.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.b.b.a.e a(java.lang.String r8, com.baidu.b.b.a.d r9) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r7 = this;
            com.baidu.b.b.a$a r0 = r7.f4737b
            android.content.Context r0 = r0.f4741a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = 0
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r8, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lf
            goto L10
        Lf:
            r0 = r2
        L10:
            r1 = -2
            if (r0 != 0) goto L18
            com.baidu.b.b.a$e r7 = com.baidu.b.b.a.e.a(r1)
            return r7
        L18:
            boolean r3 = r9.f4747a
            if (r3 == 0) goto L41
            com.baidu.b.b.d$b r2 = new com.baidu.b.b.d$b
            r2.<init>(r8)
            r2.a()
            java.lang.String r3 = r2.c()
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L41
            long r3 = r0.lastUpdateTime
            long r5 = r2.e()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L41
            com.baidu.b.h$a r7 = r2.d()
        L3c:
            com.baidu.b.b.a$e r7 = com.baidu.b.b.a.e.a(r7)
            return r7
        L41:
            com.baidu.b.b.d$a r3 = new com.baidu.b.b.d$a
            r3.<init>()
            boolean r7 = r3.a(r0)
            if (r7 != 0) goto L51
            com.baidu.b.b.a$e r7 = com.baidu.b.b.a.e.a(r1)
            return r7
        L51:
            boolean r7 = r9.f4747a
            if (r7 == 0) goto L6c
            if (r2 == 0) goto L6c
            r2.a(r3)
            long r4 = java.lang.System.currentTimeMillis()
            r2.a(r4)
            long r0 = r0.lastUpdateTime
            r2.c(r0)
            r2.a(r8)
            r2.b()
        L6c:
            com.baidu.b.h$a r7 = r3.b()
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.b.b.d.a(java.lang.String, com.baidu.b.b.a$d):com.baidu.b.b.a$e");
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.f4753d = this.f4738c.a("isc");
    }
}
