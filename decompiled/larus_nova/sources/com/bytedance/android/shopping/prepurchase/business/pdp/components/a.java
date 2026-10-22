package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;
import vg3.k0;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Function1<k0, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f181083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore> f181084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f181085c;

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(k0 r100) {
        k0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "options");
        boolean r102 = false;
        if (r101.f554686c == false) goto L60;
        Function1<String, Unit> r103 = new ClosePanelInterceptor$invoke$intercepted$1(this);
        Intrinsics.checkNotNullParameter(r103, "popAction");
        Control r104 = this.f181084b.getData().c();
        if (r104 == null) goto L56;
        e73.g r105 = r104.getPopupWithClose();
        if (r105 == null) goto L56;
        if (com.bytedance.android.shopping.anchorv3.a.b(r105.c()) == false) goto L12;
    L15:
        boolean r106 = true;
    L16:
        String r107 = r105.b();
        String r108 = "";
        if (com.bytedance.android.shopping.anchorv3.a.b(r107) == false) goto L25;
        com.bytedance.android.ec.sdk.helper.q r109 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        if (r107 != null) goto L21;
        String r110 = "";
    L23:
        if (r109.getInt(r110, 0) <= 0) goto L25;
        boolean r111 = false;
    L26:
        if (r111 == false) goto L56;
        if (r106 == false) goto L56;
        if (com.bytedance.android.shopping.anchorv3.a.b(r107) == false) goto L39;
        com.bytedance.android.ec.sdk.helper.q r112 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        if (r107 != null) goto L33;
        String r113 = "";
    L34:
        int r114 = r112.getInt(r113, 0) + 1;
        if (r107 != null) goto L37;
        r107 = "";
    L37:
        r112.d(r107, r114);
    L43:
        if (com.bytedance.android.shopping.anchorv3.a.b(r105.c()) == false) goto L50;
        String r115 = r105.c();
        if (r115 == null) goto L48;
        r108 = r115;
    L48:
        r103.invoke(r108);
        boolean r116 = true;
    L57:
        if (r116 == false) goto L60;
        r102 = true;
        goto L60
    L50:
        if (com.bytedance.android.shopping.anchorv3.a.b(r105.a()) == false) goto L56;
        String r117 = r105.a();
        if (r117 == null) goto L55;
        r108 = r117;
    L55:
        r103.invoke(r108);
        goto L56
    L33:
        r113 = r107;
        goto L34
    L39:
        if (this.f181083a == true) goto L56;
        this.f181083a = true;
        goto L43
    L21:
        r110 = r107;
    L25:
        r111 = true;
        goto L26
    L12:
        if (com.bytedance.android.shopping.anchorv3.a.b(r105.a()) == true) goto L15;
        r106 = false;
    L56:
        r116 = false;
    L60:
        return Boolean.valueOf(r102);
    }

    public a(com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore> r100, f0 r101) {
        Intrinsics.checkNotNullParameter(r100, "dataFetchAbility");
        this.f181084b = r100;
        this.f181085c = r101;
    }
}
