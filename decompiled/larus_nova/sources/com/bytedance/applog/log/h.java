package com.bytedance.applog.log;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h extends n {
    public h() {
    }

    @Override // com.bytedance.applog.log.c
    public final void v(int r100, int r101, List<String> r102, Throwable r103, String r104, Object... r105) {
        if (l.f192477a.isEmpty() == true) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L10;
        return;
    L10:
        k r107 = new k();
        r107.f192475g = System.currentTimeMillis();
        r107.f192472d = r100;
        r107.f192471c = r101;
        r107.f192470b = ThreadMethodProxy.currentThread().getName();
        r107.f192476h = r103;
        if (r102 != null) goto L13;
    L15:
        List<String> r108 = this.f192458b;
    L16:
        r107.f192473e = r108;
        r107.f192474f = c.u(r104, r105);
        l.a(r107);
        Iterator r109 = ((ConcurrentHashMap) l.f192478b).values().iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        ((j) r109.next()).a(r107);
        goto L18
    L20:
        return;
    L13:
        if (r102.size() <= 0) goto L15;
        ArrayList r110 = new ArrayList();
        r110.addAll(this.f192458b);
        r110.addAll(r102);
        r108 = r110;
        goto L16
    L5:
        if (((ConcurrentHashMap) l.f192478b).isEmpty() == false) goto L7;
        r106 = true;
        goto L8
    }
}
