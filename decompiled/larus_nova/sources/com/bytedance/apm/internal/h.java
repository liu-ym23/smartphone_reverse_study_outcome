package com.bytedance.apm.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f190605a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f190606a = null;

        static {
            f190606a = new h();
        }
    }

    public h() {
        this.f190605a = gs3.e.b(com.bytedance.apm.d.getContext(), "monitor_config");
    }
}
