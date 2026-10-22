package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import c12.m;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.DefaultResourceSupport;

/* JADX INFO: loaded from: classes9.dex */
public class f implements i {
    public final DefaultResourceSupport c() {
        boolean r100 = com.bytedance.android.livesdk.gift.platform.business.effect.b.a();
        boolean r101 = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.b.f129189e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.f129185a[3])).booleanValue();
        if (r100 == false) goto L7;
        if (r101 == false) goto L7;
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.c();
    L7:
        if (r100 == false) goto L11;
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.a();
    L11:
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.b();
    }

    public f() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.i
    public fd6.b<String> a(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r100) {
        return new m(r100);
    }

    public final AssetsDefaultDownloadPolicy b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r100) {
        AssetsDefaultDownloadPolicy r101 = new AssetsDefaultDownloadPolicy(r100);
        int r102 = ((Number) com.bytedance.android.livesdk.gift.platform.business.effect.a.f129048e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a[3])).intValue();
        if ((r102 & 2) != 2) goto L5;
        boolean r103 = true;
    L6:
        r101.f129125c = r103;
        jy0.b.a("AssetsDownloadPolicyFactory", "[create]-policy need sort :" + r102);
        return r101;
    L5:
        r103 = false;
        goto L6
    }
}
