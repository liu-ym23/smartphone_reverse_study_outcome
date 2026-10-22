package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssetsDownloadPolicyService f129157a;

    public g(AssetsDownloadPolicyService r100) {
        this.f129157a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        com.bytedance.android.live.core.resources.e r102 = (com.bytedance.android.live.core.resources.e) r101;
        Map<Long, Integer> r103 = this.f129157a.f129138h;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Integer r105 = (Integer) r104.get(Long.valueOf(((com.bytedance.android.live.core.resources.e) r100).getId()));
        int r106 = Integer.MAX_VALUE;
        if (r105 == null) goto L5;
        int r107 = r105.intValue();
    L6:
        Map<Long, Integer> r108 = this.f129157a.f129138h;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        Integer r110 = (Integer) r109.get(Long.valueOf(r102.getId()));
        if (r110 == null) goto L10;
        r106 = r110.intValue();
    L10:
        return r107 - r106;
    L5:
        r107 = Integer.MAX_VALUE;
        goto L6
    }
}
