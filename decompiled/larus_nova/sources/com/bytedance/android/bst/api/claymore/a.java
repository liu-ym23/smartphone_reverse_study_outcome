package com.bytedance.android.bst.api.claymore;

import com.bytedance.android.bst.api.ab.EmptyBstAbPageControlService;
import com.bytedance.android.bst.api.ab.IBstAbPageControl;
import com.bytedance.android.bst.api.inner.IBstMonitorService;
import com.bytedance.android.btm.api.bst.EmptyBstInnerService;
import com.bytedance.android.btm.api.bst.b;
import java.util.concurrent.CopyOnWriteArrayList;
import uc.c;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f41905a;

    public static void a() {
        if (f41905a == false) goto L5;
        return;
    L5:
        f41905a = true;
        CopyOnWriteArrayList<yc.a.C8324a> r100 = yc.a.f567111a;
        yc.a.b(c.class, uc.a.class);
        yc.a.c(c.class, "com.bytedance.android.bst.impl.BstServiceImpl");
        yc.a.b(com.bytedance.android.btm.api.bst.a.class, tc.a.class);
        yc.a.c(com.bytedance.android.btm.api.bst.a.class, "com.bytedance.android.bst.devtools.BstDebugService");
        yc.a.b(IBstAbPageControl.class, EmptyBstAbPageControlService.class);
        yc.a.c(IBstAbPageControl.class, "com.bytedance.android.bst.impl.ab.BstAbPageControlService");
        yc.a.b(b.class, EmptyBstInnerService.class);
        yc.a.c(b.class, "com.bytedance.android.bst.impl.inner.BstInnerService");
        yc.a.b(IBstMonitorService.class, uc.b.class);
        yc.a.c(IBstMonitorService.class, "com.bytedance.android.bst.devtools.monitor.BstMonitorService");
    }

    static {
    }
}
