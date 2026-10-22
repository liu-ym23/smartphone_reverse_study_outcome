package com.bytedance.android.btm.impl.page;

import android.app.Activity;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class PageWoods {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<f<Activity>, h> f42253a = null;

    static {
        f42253a = new ConcurrentHashMap();
    }

    public static h a(final Object r100) {
        if ((r100 instanceof Activity) == true) goto L5;
        Activity r101 = d.f42499a.getActivity(r100);
        if (r101 != null) goto L9;
        if (r100 == null) goto L14;
        ALogger.i(ALogger.f41996d, "1108", false, new PageWoods$getTree$$inlined$apply$lambda$1(r100), 6);
        return null;
    L14:
        return null;
    L9:
        return f42253a.get(new f(r101));
    L5:
        return f42253a.get(new f(r100));
    }

    public static void b(h r100) {
        Object r101 = r100.f42356c.a();
        if ((r101 instanceof Activity) == true) goto L5;
        r101 = null;
    L5:
        Activity r102 = (Activity) r101;
        if (r102 == null) goto L9;
        f42253a.put(new f(r102), r100);
        return;
    }
}
