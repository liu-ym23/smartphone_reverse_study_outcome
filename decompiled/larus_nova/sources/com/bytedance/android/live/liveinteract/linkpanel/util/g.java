package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractFrequencyConfig f75039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f75040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f75041c;

    public final boolean a() {
        if (this.f75039a == null) goto L17;
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f75041c) > (this.f75039a.cdTime * 1000)) goto L7;
        return false;
    L7:
        ((ArrayList) this.f75040b).add(Long.valueOf(r100));
        if (Lists.isEmpty(this.f75040b) == true) goto L17;
        if (((ArrayList) this.f75040b).size() <= this.f75039a.maxCount) goto L17;
        List<Long> r101 = this.f75040b;
        if ((r100 - ((Long) ListProtector.get(r101, ((ArrayList) r101).size() - this.f75039a.maxCount)).longValue()) >= (this.f75039a.gapTime * 1000)) goto L16;
        this.f75041c = r100;
        return false;
    L16:
        List<Long> r102 = this.f75040b;
        ((ArrayList) r102).subList(0, ((ArrayList) r102).size() - this.f75039a.maxCount).clear();
    L17:
        return true;
    }

    public g(InteractFrequencyConfig r100) {
        this.f75040b = new ArrayList();
        this.f75041c = 0;
        this.f75039a = r100;
    }
}
