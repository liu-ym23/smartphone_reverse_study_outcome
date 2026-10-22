package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public final class i1 {
    public static final String a(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        boolean r101 = false;
        ProviderInfo[] r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r103 = r102.length;     // Catch: Exception -> L14
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L16;
        ProviderInfo r105 = r102[r104];     // Catch: Exception -> L14
        if (TextUtils.equals(r105.name, "com.bytedance.android.sdk.bdticketguard.TicketGuardProvider") == true) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        String r106 = r105.authority;     // Catch: Exception -> L14
    L17:
        if (r106 != null) goto L19;
    L20:
        r101 = true;
    L21:
        if (r101 == false) goto L23;
        r106 = r100.getPackageName() + ".TicketGuardProvider";
    L23:
        int r107 = r0.f163979a;
        r0.a("TicketGuardProvider", "getProviderAuthority, authority=" + r106);
        return r106;
    L19:
        if (r106.length() != 0) goto L21;
    L16:
        r106 = null;
    L14:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "get authority failed", e);
        goto L16
    }
}
