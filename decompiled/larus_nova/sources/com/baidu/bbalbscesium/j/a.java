package com.baidu.bbalbscesium.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f30181e = "cs";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f30182f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f30183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.baidu.bbalbscesium.n.a.C0628a f30184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30186d;

    /* JADX INFO: renamed from: com.baidu.bbalbscesium.j.a$a, reason: collision with other inner class name */
    class C0625a implements Comparator {
        public C0625a() {
        }

        public int a(a r100, a r101) {
            long r102 = r100.b() - r101.b();
            if (r102 == 0) goto L9;
            if (r102 <= 0) goto L6;
            return -1;
        L6:
            return 1;
        L9:
            return r100.a().compareTo(r101.a());
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Object r100, Object r101) {
            return a((a) r100, (a) r101);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f30187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.baidu.bbalbscesium.n.a f30188b;

        public b() {
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f30189e = "target-pkg-";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f30190f = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.baidu.bbalbscesium.n.a.C0628a f30191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f30194d;

        public c(com.baidu.bbalbscesium.n.a.C0628a r100, String r101) {
            this.f30194d = true;
            this.f30191a = r100;
            this.f30192b = r101;
            this.f30193c = f30189e + Base64.encodeToString(r101.getBytes(), 3);
        }

        public abstract void a(JSONObject r100) throws JSONException;

        public void a(boolean r100) {
            this.f30194d = r100;
        }

        public boolean a() {
            if (this.f30194d == true) goto L8;
        L6:
            return false;
        L8:
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L7
            b(r100);     // Catch: Exception -> L7
            this.f30191a.a(this.f30193c, r100.toString(), true);     // Catch: Exception -> L7
            a(false);     // Catch: Exception -> L7
            return true;
        }

        public abstract void b(JSONObject r100) throws JSONException;

        public boolean b() {
            String r100 = this.f30191a.a(this.f30193c, true);
            if (TextUtils.isEmpty(r100) == false) goto L8;
        L6:
            return false;
        L8:
            a(new JSONObject(r100));     // Catch: Exception -> L7
            a(false);     // Catch: Exception -> L7
            return true;
        }
    }

    public static class d {
        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f30195a;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f30196d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30197e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f30198f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f30199g = -100;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f30201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Exception f30202c;

        public f(int r100, int r101, Exception r102) {
            this.f30200a = r100;
            this.f30201b = r101;
            this.f30202c = r102;
        }

        public static f a() {
            return a(0);
        }

        public static f a(int r100) {
            return new f(-1, r100, null);
        }

        public static f a(Exception r100) {
            return new f(-1, 0, r100);
        }

        public static f d() {
            return new f(0, 0, null);
        }

        public int b() {
            return this.f30200a;
        }

        public int c() {
            return this.f30201b;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f30203a;

        public g() {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f30204d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30205e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f30206f = -2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f30207g = -100;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.baidu.bbalbscesium.h.a f30208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f30209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Exception f30210c;

        public h(int r100, com.baidu.bbalbscesium.h.a r101, Exception r102) {
            this.f30209b = r100;
            this.f30208a = r101;
            this.f30210c = r102;
        }

        public static h a() {
            return new h(-1, null, null);
        }

        public static h a(int r100) {
            return new h(r100, null, null);
        }

        public static h a(int r100, Exception r101) {
            return new h(r100, null, r101);
        }

        public static h a(com.baidu.bbalbscesium.h.a r100) {
            return new h(0, r100, null);
        }

        public static h a(Exception r100) {
            return new h(-1, null, r100);
        }

        public boolean b() {
            if (this.f30209b != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f30182f = new C0625a();
    }

    public a(String r100, long r101) {
        this.f30185c = r100;
        this.f30186d = r101;
    }

    public abstract f a(e r100, com.baidu.bbalbscesium.h.a r101);

    public abstract h a(String r100, g r101);

    public String a() {
        return this.f30185c;
    }

    public void a(long r100) {
        this.f30186d = r100;
    }

    public final void a(b r100) {
        this.f30183a = r100;
        this.f30184b = r100.f30188b.c().b("cs");
    }

    public abstract void a(d r100);

    public long b() {
        return this.f30186d;
    }
}
