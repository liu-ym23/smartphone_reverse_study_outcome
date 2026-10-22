package com.bytedance.android.livesdk.livecommerce.oldflash;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f149738a;

    public t(s r100) {
        this.f149738a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
    public final String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        return th.a.g(this.f149738a.getContext(), R.string.ec_live_flash_max_limit);
    }
}
