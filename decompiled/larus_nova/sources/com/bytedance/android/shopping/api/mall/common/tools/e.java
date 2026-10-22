package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.services.apm.api.EnsureManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170433a = 0;

    static {
    }

    public static String a(String r100) {
        int r101 = 1;
        if (r100 != null) goto L30;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return r100;
    L13:
        boolean r103 = StringsKt.startsWith$default(r100, "#", false, 2, null);     // Catch: Exception -> L8
        if (r103 == false) goto L18;
        if (r100.length() > 7) goto L18;
    L19:
        return r100;
    L18:
        if (r100.length() <= 6) goto L19;
        if (r103 == true) goto L23;
        r101 = 0;
    L23:
        int r104 = r101 + 8;     // Catch: Exception -> L8
        if (r100.length() == r104) goto L26;
        return r100;
    L26:
        int r105 = r101 + 2;     // Catch: Exception -> L8
        String r106 = r100.substring(r101 + 0, r105);     // Catch: Exception -> L8
        int r107 = r101 + 4;     // Catch: Exception -> L8
        String r108 = r100.substring(r105, r107);     // Catch: Exception -> L8
        int r109 = r101 + 6;     // Catch: Exception -> L8
        String r110 = r100.substring(r107, r109);     // Catch: Exception -> L8
        return "#" + r100.substring(r109, r104) + r106 + r108 + r110;
    L8:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return r100;
    L30:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L11
    }
}
