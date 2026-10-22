package com.ttnet.org.chromium.base.compat;

import android.security.NetworkSecurityPolicy;

/* JADX INFO: compiled from: ApiHelperForN.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static boolean a(String r1) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r1);
    }
}
