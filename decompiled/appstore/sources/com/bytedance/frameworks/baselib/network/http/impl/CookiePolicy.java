package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = null;
    public static final CookiePolicy ACCEPT_NONE = null;
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = null;

    public static class a implements CookiePolicy {
        public a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI r10, r4.c r11) {
            return true;
        }
    }

    public static class b implements CookiePolicy {
        public b() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI r10, r4.c r11) {
            return false;
        }
    }

    public static class c implements CookiePolicy {
        public c() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy
        public boolean shouldAccept(URI r10, r4.c r11) {
            return r4.c.s(r11.x(), r10.getHost());
        }
    }

    static {
        ACCEPT_ALL = new a();
        ACCEPT_NONE = new b();
        ACCEPT_ORIGINAL_SERVER = new c();
    }

    boolean shouldAccept(URI r10, r4.c r11);
}
