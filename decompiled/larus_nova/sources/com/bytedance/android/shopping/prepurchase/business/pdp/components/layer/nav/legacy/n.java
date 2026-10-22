package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements com.bytedance.android.shopping.anchorv4.nav.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f181379a;

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final Boolean d() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final CommonMeta a() {
        return this.f181379a.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final LinkedTreeMap<String, Object> b() {
        return this.f181379a.b();
    }

    public n(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f181379a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final void f(final Map r110, final boolean r111, final boolean r112, final String r113, final PageFinder r114) {
        final String r100 = "share_product";
        Intrinsics.checkNotNullParameter("share_product", "eventName");
        Function1<vg3.z, Unit> r101 = new ShareDependImpl$track$1(this, r110, r113, r114, r100, r112, r111);
        this.f181379a.d(r101);
    }
}
