package com.bytedance.android.live.core.utils;

import android.util.Base64;
import com.bytedance.android.livesdk.config.k7;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v1 {
    public static final com.bytedance.android.tools.superkv.e a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (k7.f120579a.getValue().booleanValue() == false) goto L7;
        return new u1(s1.getContext(), r100);
    L7:
        if (com.bytedance.android.tools.superkv.i.f187645b == false) goto L23;
        com.bytedance.android.tools.superkv.i.a r101 = com.bytedance.android.tools.superkv.i.f187644a;
        com.bytedance.android.tools.superkv.d r102 = r101.f187646a.get(r100);
        if (r102 != null) goto L11;
    L24:
        r102 = new com.bytedance.android.tools.superkv.d(r101.f187647b + File.separator + new String(Base64.encode(r100.getBytes(), 2)), r101.f187648c);     // Catch: IOException -> L16
    L18:
        if (r102 == null) goto L21;
        r101.f187646a.put(r100, r102);
        return r102;
    L21:
        return new com.bytedance.android.tools.superkv.d();
    L16:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.e(new IllegalStateException("Failed to create DataStore: " + r100, e));
        goto L18
    L11:
        if (r102.f187616a == false) goto L27;
        r102.f187617b.release();
        goto L24
    L27:
        return r102;
    L23:
        throw new IllegalStateException("SuperKV must be initialized before using.");
    }
}
