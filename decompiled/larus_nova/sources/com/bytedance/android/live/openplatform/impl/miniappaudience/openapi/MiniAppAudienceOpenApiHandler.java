package com.bytedance.android.live.openplatform.impl.miniappaudience.openapi;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.openapi.AbsOpenApiHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppAudienceOpenApiHandler extends AbsOpenApiHandler {
    public MiniAppAudienceOpenApiHandler(final OpenPlatformContext r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "appId");
        super(r100, r101);
        b("getSelfCommentCountDuringPluginRunning", new AnonymousClass1(r100, r101));
    }
}
