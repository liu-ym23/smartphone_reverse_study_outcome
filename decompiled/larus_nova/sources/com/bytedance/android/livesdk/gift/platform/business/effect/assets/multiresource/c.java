package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.live.core.resources.l;
import com.bytedance.android.live.core.resources.m;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends DefaultResourceSupport {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r100) {
        if (((h) this.f129118b.getValue()).Z6() == false) goto L20;
        c12.e r101 = g(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r102 = GiftResourceManagerFactory.a();
        if (r102 != null) goto L7;
    L9:
        n r103 = f(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r104 = GiftResourceManagerFactory.a();
        if (r104 != null) goto L12;
    L14:
        c12.e r105 = e(r100, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r106 = GiftResourceManagerFactory.a();
        if (r106 != null) goto L17;
    L19:
        return false;
    L17:
        if (r106.e(r105) != true) goto L19;
        return true;
    L12:
        if (r104.e(r103) != true) goto L14;
        return true;
    L7:
        if (r102.e(r101) != true) goto L9;
        return true;
    L20:
        Iterator r107 = ((ArrayList) b(r100, 0)).iterator();
    L22:
        if (r107.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r108 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r107.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r109 = GiftResourceManagerFactory.a();
        if (r109 == null) goto L22;
        if (r109.e(r108) != true) goto L22;
        return true;
    L28:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r100) {
        if (DefaultResourceSupport.h(r100) == false) goto L5;
        return true;
    L5:
        if (DefaultResourceSupport.i(r100) == false) goto L7;
        return true;
    L7:
        if (r100 != null) goto L10;
    L34:
        boolean r101 = false;
    L35:
        if (r101 == true) goto L41;
        return false;
    L41:
        return true;
    L10:
        if (r100.getH265SuperResourceModel() == null) goto L34;
        k r102 = r100.getH265SuperResourceModel();
        if (r102 == null) goto L15;
        String r103 = r102.getMd5();
    L16:
        if (r103 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == true) goto L34;
        k r105 = r100.getH265SuperResourceModel();
        if (r105 == null) goto L34;
        l r106 = r105.getResourceModel();
        if (r106 == null) goto L34;
        List<String> r107 = m.a(r106);
        if (r107 == null) goto L34;
        if (r107.isEmpty() == true) goto L34;
        r101 = true;
        goto L35
    L18:
        if (r103.length() == 0) goto L21;
        r104 = false;
        goto L22
    L15:
        r103 = null;
        goto L16
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
        c12.e r105 = g(r100, r101);
        if (r105 == null) goto L11;
        r102.add(r105);
    L11:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r100, int r101) {
        if (r100 != null) goto L5;
    L28:
        c12.e r102 = g(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r103 = GiftResourceManagerFactory.a();
        if (r103 != null) goto L31;
    L33:
        c12.e r104 = e(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r105 = GiftResourceManagerFactory.a();
        if (r105 != null) goto L36;
    L38:
        n r106 = f(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r107 = GiftResourceManagerFactory.a();
        if (r107 != null) goto L41;
    L43:
        if (r102 == null) goto L45;
        return r102;
    L45:
        if (r106 == null) goto L47;
        return r106;
    L47:
        return r104;
    L41:
        if (r107.e(r106) != true) goto L43;
        return r106;
    L36:
        if (r105.e(r104) != true) goto L38;
        return r104;
    L31:
        if (r103.e(r102) != true) goto L33;
        return r102;
    L5:
        if (r100.getResourceType() != 4) goto L28;
        if (((h) this.f129118b.getValue()).r7() == false) goto L28;
        c12.e r108 = g(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r109 = GiftResourceManagerFactory.a();
        if (r109 != null) goto L11;
    L13:
        n r110 = f(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r111 = GiftResourceManagerFactory.a();
        if (r111 != null) goto L16;
    L18:
        c12.e r112 = e(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r113 = GiftResourceManagerFactory.a();
        if (r113 != null) goto L21;
    L23:
        if (r108 == null) goto L25;
        return r108;
    L25:
        if (r110 == null) goto L27;
        return r110;
    L27:
        return r112;
    L21:
        if (r113.e(r112) != true) goto L23;
        return r112;
    L16:
        if (r111.e(r110) != true) goto L18;
        return r110;
    L11:
        if (r109.e(r108) != true) goto L13;
        return r108;
    }
}
