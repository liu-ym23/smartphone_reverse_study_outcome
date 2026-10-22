package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class JissoAbilityImpl$jisooListener$1 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f181842a;

    public JissoAbilityImpl$jisooListener$1(a r100) {
        this.f181842a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.helper.f
    public final void a(PackResponseDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "dto");
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.b(this.f181842a.f181847c, new JissoAbilityImpl$jisooListener$1$onGetNewPackData$1(this, r100, null));
    }
}
