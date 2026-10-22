package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements com.bytedance.android.shopping.utils.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f181375a;

    @Override // com.bytedance.android.shopping.utils.e
    public final boolean e() {
        return this.f181375a.e();
    }

    public i(d r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f181375a = r100;
    }

    @Override // com.bytedance.android.shopping.utils.e
    public final void g(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f181375a.g(r100);
    }

    @Override // com.bytedance.android.shopping.utils.e
    public final void f(final Map r110, final boolean r111, final boolean r112, final String r113, final PageFinder r114) {
        final String r100 = "add_cart_toast_show";
        Intrinsics.checkNotNullParameter("add_cart_toast_show", "eventName");
        this.f181375a.d(new CartDependencyAdapter$track$1(this, r110, r113, r114, r100, r112, r111));
    }
}
