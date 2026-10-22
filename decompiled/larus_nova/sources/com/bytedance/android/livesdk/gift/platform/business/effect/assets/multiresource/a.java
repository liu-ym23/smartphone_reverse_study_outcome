package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends DefaultResourceSupport {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.a$a, reason: collision with other inner class name */
    public static final class C2062a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r100) {
        if (((h) this.f129118b.getValue()).Z6() == false) goto L15;
        n r101 = f(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r102 = GiftResourceManagerFactory.a();
        if (r102 != null) goto L7;
    L9:
        c12.e r103 = e(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r104 = GiftResourceManagerFactory.a();
        if (r104 != null) goto L12;
    L14:
        return false;
    L12:
        if (r104.e(r103) != true) goto L14;
        return true;
    L7:
        if (r102.e(r101) != true) goto L9;
        return true;
    L15:
        Iterator r105 = ((ArrayList) b(r100, 0)).iterator();
    L17:
        if (r105.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r106 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r105.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r107 = GiftResourceManagerFactory.a();
        if (r107 == null) goto L17;
        if (r107.e(r106) != true) goto L17;
        return true;
    L23:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r100) {
        if (DefaultResourceSupport.h(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (DefaultResourceSupport.i(r100) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(e r100, int r101) {
        ArrayList r102 = new ArrayList();
        c12.e r103 = e(r100, r101);
        if (r103 == null) goto L5;
        r102.add(r103);
    L5:
        n r104 = f(r100, r101);
        if (r104 == null) goto L8;
        r102.add(r104);
    L8:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r100, int r101) {
        if (r100 != null) goto L4;
    L14:
        c12.e r102 = e(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r103 = GiftResourceManagerFactory.a();
        if (r103 != null) goto L17;
    L19:
        n r104 = f(r100, r101);
        if (r104 == null) goto L22;
        return r104;
    L22:
        return r102;
    L17:
        if (r103.e(r102) != true) goto L19;
        return r102;
    L4:
        if (r100.getResourceType() != 4) goto L14;
        if (((h) this.f129118b.getValue()).r7() == false) goto L14;
        if (r100.getH265ResourceModel() == null) goto L13;
        n r105 = f(r100, r101);
        if (r105 == null) goto L13;
        return r105;
    L13:
        return e(r100, r101);
    }
}
