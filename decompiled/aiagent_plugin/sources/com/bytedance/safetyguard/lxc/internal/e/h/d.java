package com.bytedance.safetyguard.lxc.internal.e.h;

import com.bytedance.safetyguard.lxc.internal.e.a.m;
import com.bytedance.safetyguard.lxc.internal.e.c.g;

/* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final /* synthetic */ String a(m r0, String r1) {
        return b(r0, r1);
    }

    private static final String b(m r0, String r1) {
        g r2 = r0.c();
        if (r2 != null) goto L5;
        return r1;
    L5:
        String r3 = r2.d();
        if (r3 != null) goto L9;
        return "OAuth request failed";
    L9:
        return r3;
    }
}
