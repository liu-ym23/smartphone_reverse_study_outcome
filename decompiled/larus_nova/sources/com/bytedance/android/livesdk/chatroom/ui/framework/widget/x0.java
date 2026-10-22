package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenLinkTriggerWidget f113534a;

    public x0(ScreenLinkTriggerWidget r100) {
        this.f113534a = r100;
    }

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        this.f113534a.wq();
    }
}
