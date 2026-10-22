package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.android.ec.core.utils.b2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpSchemaSizeMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43776a = null;

    static {
        f43776a = LazyKt.lazy(PdpSchemaSizeMonitor$config$2.INSTANCE);
    }

    public static void a(final String r100, final String r101) {
        Lazy r102 = f43776a;
        if (((p) r102.getValue()).b() == true) goto L5;
        return;
    L5:
        final int r103 = r100.length();
        if (r103 >= ((p) r102.getValue()).c()) goto L8;
        return;
    L8:
        b2.b(new PdpSchemaSizeMonitor$monitor$1(r103, r100, r101));
    }
}
