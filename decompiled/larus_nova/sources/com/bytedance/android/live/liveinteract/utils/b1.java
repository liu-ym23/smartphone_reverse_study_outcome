package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f78736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f78737b;

    public final boolean a() {
        us1.c r100 = (us1.c) vm2.i.G.getValue(null, vm2.i.f556291a[31]);
        i97.a r101 = i97.a.f488802a;
        long r102 = System.currentTimeMillis();
        if ((r102 - this.f78737b) > (r100.p8() * 1000)) goto L5;
        return false;
    L5:
        ((ArrayList) this.f78736a).add(Long.valueOf(r102));
        if (((ArrayList) this.f78736a).isEmpty() == false) goto L8;
    L14:
        return true;
    L8:
        if (((ArrayList) this.f78736a).size() <= r100.getMaxCount()) goto L14;
        List<Long> r103 = this.f78736a;
        if ((r102 - ((Number) ListProtector.get(r103, ((ArrayList) r103).size() - r100.getMaxCount())).longValue()) >= (r100.z2() * 1000)) goto L14;
        this.f78737b = r102;
        return false;
    }

    public b1() {
        this.f78736a = new ArrayList();
    }
}
