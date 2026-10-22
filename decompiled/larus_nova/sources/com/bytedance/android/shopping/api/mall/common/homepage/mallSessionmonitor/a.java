package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.ECPerfSessionStageHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> f170351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<c> f170352b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ECPerfSessionStageHandler f170353c = null;

    static {
        CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r100 = new CopyOnWriteArrayList();
        f170351a = r100;
        f170352b = new CopyOnWriteArrayList();
        f170353c = new ECPerfSessionStageHandler();
        WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c> r101 = new WeakReference(f170353c);
        Intrinsics.checkNotNullParameter(r101, "handler");
        r101.get();
        r100.add(r101);
    }

    public static void a(String r110, String r111, double r112, String r210, Map r211) {
        Intrinsics.checkNotNullParameter(r110, "stageName");
        Intrinsics.checkNotNullParameter(r111, "scheme");
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "triggerSource");
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r210.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        r100 = ECStageTriggerSource.GENERAL.getType();
    L14:
        String r113 = r100;
        if (r112 > 0) goto L17;
        double r114 = System.currentTimeMillis();
    L18:
        Intrinsics.checkNotNullParameter(r110, "stageName");
        Intrinsics.checkNotNullParameter(r111, "scheme");
        Intrinsics.checkNotNullParameter(r113, "triggerSource");
        f170352b.add(new c(r110, r111, r114, r113, r211));
        Iterator<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r115 = f170351a.iterator();
    L20:
        if (r115.hasNext() == false) goto L34;
        com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c r103 = r115.next().get();
        if (r103 == null) goto L20;
        String r104 = r103.a(r111, r211);
        if (r104 == null) goto L20;
        if (r104.length() <= 0) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == true) goto L32;
        r104 = null;
    L32:
        if (r104 == null) goto L20;
        r103.b(r110, r111, r114, r113, r211);
        goto L20
    L28:
        r105 = false;
        goto L29
    L34:
        return;
    L17:
        r114 = r112;
        goto L18
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }
}
