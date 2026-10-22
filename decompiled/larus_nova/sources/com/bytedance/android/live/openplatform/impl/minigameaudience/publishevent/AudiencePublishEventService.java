package com.bytedance.android.live.openplatform.impl.minigameaudience.publishevent;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/publishevent/AudiencePublishEventService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePublishEventService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85309a;

    public final void f() {
        int r100 = MiniGameLiveJsBridgeUtils.f85366a;
        autoDispose(MiniGameLiveJsBridgeUtils.a("preload_mg", new AudiencePublishEventService$initEventRegister$1(this)));
        autoDispose(MiniGameLiveJsBridgeUtils.a("live_open_mg", new AudiencePublishEventService$initEventRegister$2(this)));
    }

    public AudiencePublishEventService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85309a = "AudiencePublishEventService";
    }
}
