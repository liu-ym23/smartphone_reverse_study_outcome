package com.bytedance.frameworks.baselib.network.http;

import java.util.List;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseRequestContext.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public b A;
    public List<C0184c> B;
    public JSONObject C;
    public int D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8191e;
    public long f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public long s;
    public boolean t;
    public boolean u;

    @Deprecated
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public a z;

    /* JADX INFO: compiled from: BaseRequestContext.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8193b;

        public String toString() {
            return "AuthCredentials{username=" + this.f8192a + ", password=" + this.f8193b + '}';
        }
    }

    /* JADX INFO: compiled from: BaseRequestContext.java */
    public interface b {
        void a(z.a r1);
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseRequestContext.java */
    public static class C0184c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8195b;

        public /* synthetic */ Object clone() {
            return a();
        }

        public C0184c(String r1, String r2) {
            this.f8194a = r1;
            this.f8195b = r2;
        }

        public C0184c a() {
            return new C0184c(this.f8194a, this.f8195b);
        }
    }

    public c() {
        this.l = false;
        this.m = 0;
        this.n = true;
        this.t = true;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = false;
        this.C = new JSONObject();
        this.D = -999;
        this.E = -1;
    }
}
