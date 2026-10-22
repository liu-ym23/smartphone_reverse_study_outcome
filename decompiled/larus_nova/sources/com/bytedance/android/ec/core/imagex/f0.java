package com.bytedance.android.ec.core.imagex;

import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f44672a = null;

    static {
        f44672a = new f0();
    }

    public f0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IFeatureCore r100 = j0.f44683a;     // Catch: Throwable -> L18
        IKVStore r101 = j0.f44684b;     // Catch: Throwable -> L18
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getValueForKey("cache_key_scroll_mode");     // Catch: Throwable -> L18
    L6:
        if (r103 != null) goto L8;
    L16:
        j0.f44685c = System.currentTimeMillis();     // Catch: Throwable -> L18
        return;
    L8:
        if ((r103 instanceof Integer) == false) goto L11;
        r102 = r103;
    L11:
        Integer r104 = (Integer) r102;     // Catch: Throwable -> L18
        if (r104 == null) goto L14;
        int r105 = r104.intValue();     // Catch: Throwable -> L18
    L15:
        int r106 = g0.f44676a;     // Catch: Throwable -> L18
        g0.f44677b = r105;     // Catch: Throwable -> L18
        goto L16
    L14:
        r105 = 0;
        goto L15
    L5:
        r103 = null;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L22;
        return;
    L22:
        throw th;
    }
}
