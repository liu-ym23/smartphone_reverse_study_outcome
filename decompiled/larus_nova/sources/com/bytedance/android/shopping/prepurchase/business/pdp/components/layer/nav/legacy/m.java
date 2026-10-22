package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.bottom.d0;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements com.bytedance.android.shopping.utils.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f181378a;

    @Override // com.bytedance.android.shopping.utils.e
    public final boolean e() {
        return this.f181378a.e();
    }

    public m(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f181378a = r100;
    }

    @Override // com.bytedance.android.shopping.utils.e
    public final void g(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f181378a.g(r100);
    }

    @Override // com.bytedance.android.shopping.utils.e
    public final void f(Map r100, boolean r101, boolean r110, String r111, PageFinder r112) {
        Intrinsics.checkNotNullParameter("add_cart_toast_show", "eventName");
        this.f181378a.n("add_cart_toast_show", r100, r101, r110, r111, r112);
    }
}
