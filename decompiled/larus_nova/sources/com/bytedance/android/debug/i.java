package com.bytedance.android.debug;

import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.DefaultResourceSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class i extends DefaultResourceSupport {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(com.bytedance.android.live.core.resources.e r100) {
        Iterator r101 = ((ArrayList) b(r100, 0)).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r101.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r103 = GiftResourceManagerFactory.a();
        if (r103 == null) goto L4;
        if (r103.e(r102) != true) goto L4;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(com.bytedance.android.live.core.resources.e r100) {
        if (DefaultResourceSupport.h(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (DefaultResourceSupport.i(r100) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(com.bytedance.android.live.core.resources.e r100, int r101) {
        ArrayList r102 = new ArrayList();
        c12.e r103 = e(r100, r101);
        if (r103 == null) goto L5;
        r102.add(r103);
    L5:
        c12.n r104 = f(r100, r101);
        if (r104 == null) goto L8;
        r102.add(r104);
    L8:
        c12.e r105 = g(r100, r101);
        if (r105 == null) goto L11;
        r102.add(r105);
    L11:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(com.bytedance.android.live.core.resources.e r100, int r101) {
        if (r101 != 10) goto L7;
        return e(r100, 2);
    L7:
        if (r101 != 20) goto L11;
        return f(r100, 2);
    L11:
        if (r101 == 30) goto L13;
        return null;
    L13:
        return g(r100, 2);
    }
}
