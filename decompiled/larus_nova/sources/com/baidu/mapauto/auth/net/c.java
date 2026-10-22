package com.baidu.mapauto.auth.net;

import com.baidu.mapauto.auth.AuthCore;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f31800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HostnameVerifier f31801d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f31803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap f31804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HostnameVerifier f31805d;

        public a() {
            this.f31802a = 5000;
            this.f31804c = new HashMap();
        }

        public final a a(AuthCore.a r100) {
            this.f31805d = r100;
            return this;
        }

        public final a a(HashMap r100) {
            this.f31804c.clear();
            this.f31804c.putAll(r100);
            return this;
        }

        public final a b() {
            this.f31803b = "https://api.map.baidu.com";
            return this;
        }

        public final a c() {
            this.f31802a = 10000;
            return this;
        }

        public final a d() {
            return this;
        }

        public final c a() {
            return new c(this.f31803b, this.f31802a, this.f31804c, this.f31805d);
        }
    }

    public c(String r100, int r101, HashMap r102, HostnameVerifier r103) {
        this.f31799b = r100;
        this.f31798a = r101;
        this.f31800c = r102;
        this.f31801d = r103;
    }
}
