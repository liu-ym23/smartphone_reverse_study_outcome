package com.bytedance.android.livesdk.utils.landscape;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import j40.i1;
import j40.z0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    @JvmStatic
    public static final boolean b() {
        return z0.f497330a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (i1.f497238a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    static {
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
