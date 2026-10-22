package com.bytedance.android.shopping.anchorv4.containers.page;

import com.bytedance.android.shopping.anchorv4.ai.o0;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.PdpBottomOverlayPaddingDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpBottomOverlayPaddingDelegate f166286a;

    public b(PdpBottomOverlayPaddingDelegate r100) {
        this.f166286a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.o0
    public final void a(int r100) {
        Intrinsics.checkNotNullParameter("pdp_ai_chat", "source");
        this.f166286a.b("pdp_ai_chat", r100);
    }
}
