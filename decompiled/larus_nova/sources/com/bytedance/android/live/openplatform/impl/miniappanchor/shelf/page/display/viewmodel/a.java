package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements com.bytedance.android.live.openplatform.api.model.shelf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShelfCardInfo f84572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f84573b;

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final Pair<Integer, String> a(String r100) {
        return this.f84572a.a(r100);
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final String b() {
        return this.f84572a.b();
    }

    public final String c(String r100) {
        return this.f84572a.i(r100);
    }

    public final boolean d(int r100) {
        return this.f84572a.G0(r100);
    }

    public final boolean e(int r100) {
        return this.f84572a.H0(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f84572a, r101.f84572a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f84573b, r101.f84573b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getCardId() {
        return this.f84572a.getCardId();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final ProductInfo getProductInfo() {
        return this.f84572a.getProductInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getStatus() {
        return this.f84572a.getStatus();
    }

    public final int hashCode() {
        ShelfCardInfo r100 = this.f84572a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f84573b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorShelfDisplayCardInfo(shelfCardInfo=" + this.f84572a + ", tradeUnitList=" + this.f84573b + ")";
    }

    public a(ShelfCardInfo r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "shelfCardInfo");
        this.f84572a = r100;
        this.f84573b = r101;
    }
}
