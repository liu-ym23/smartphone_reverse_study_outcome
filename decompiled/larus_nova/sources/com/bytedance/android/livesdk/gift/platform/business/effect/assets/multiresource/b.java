package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends DefaultResourceSupport {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r100) {
        c12.e r101 = e(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r102 = GiftResourceManagerFactory.a();
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.e(r101));
    L6:
        if (r103 != null) goto L8;
        return false;
    L8:
        return r103.booleanValue();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r100) {
        return DefaultResourceSupport.h(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(e r100, int r101) {
        c12.e r102 = e(r100, r101);
        if (r102 == null) goto L7;
        return CollectionsKt.listOf(r102);
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r100, int r101) {
        return e(r100, r101);
    }
}
