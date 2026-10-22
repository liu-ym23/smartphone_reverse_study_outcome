package jf;

import android.security.NetworkSecurityPolicy;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static boolean a(String r10) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r10);
    }
}
