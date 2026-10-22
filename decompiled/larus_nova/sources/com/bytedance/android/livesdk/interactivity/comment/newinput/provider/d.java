package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements js0.a {
    public d() {
    }

    @Override // js0.a
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
    }
}
