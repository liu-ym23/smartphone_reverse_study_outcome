package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t implements com.bytedance.android.shopping.anchorv4.nav.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f166711a;

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final CommonMeta a() {
        return this.f166711a.f166716f.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final LinkedTreeMap<String, Object> b() {
        return this.f166711a.f166716f.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final Boolean d() {
        return this.f166711a.f166716f.d();
    }

    public t(u r100) {
        this.f166711a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.f
    public final void f(Map r100, boolean r101, boolean r110, String r111, PageFinder r112) {
        Intrinsics.checkNotNullParameter("share_product", "eventName");
        this.f166711a.f166716f.n("share_product", r100, r101, r110, r111, r112);
    }
}
