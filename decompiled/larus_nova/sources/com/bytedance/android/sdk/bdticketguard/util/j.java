package com.bytedance.android.sdk.bdticketguard.util;

import android.util.Base64;
import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public final class j {
    public static final boolean a(String r100, String r101) {
        byte[] r102 = Base64.decode(r100, 0);     // Catch: Exception -> L10
        byte[] r103 = Base64.decode(r101, 0);     // Catch: Exception -> L10
        if (r102 == null) goto L9;
        if (r103 == null) goto L9;
        return Arrays.equals(r102, r103);
    L9:
        return false;
    }
}
