package com.baidu.mapauto.auth.net;

import com.baidu.mapauto.auth.AuthCore;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f7678a;

    /* renamed from: b, reason: collision with root package name */
    public String f7679b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Object> f7680c;

    /* renamed from: d, reason: collision with root package name */
    public HostnameVerifier f7681d;

    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public String f7683b;

        /* renamed from: d, reason: collision with root package name */
        public HostnameVerifier f7685d;

        /* renamed from: a, reason: collision with root package name */
        public int f7682a = 5000;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f7684c = new HashMap();

        public final a a(AuthCore.a aVar) {
            this.f7685d = aVar;
            return this;
        }

        public final a b() {
            this.f7683b = "https://api.map.baidu.com";
            return this;
        }

        public final a c() {
            this.f7682a = 10000;
            return this;
        }

        public final a d() {
            return this;
        }

        public final a a(HashMap map) {
            this.f7684c.clear();
            this.f7684c.putAll(map);
            return this;
        }

        public final c a() {
            return new c(this.f7683b, this.f7682a, this.f7684c, this.f7685d);
        }
    }

    public c(String str, int i4, HashMap map, HostnameVerifier hostnameVerifier) {
        this.f7679b = str;
        this.f7678a = i4;
        this.f7680c = map;
        this.f7681d = hostnameVerifier;
    }
}
