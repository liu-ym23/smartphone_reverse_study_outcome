package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.live.datacontext.n;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridDialog f85002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenPlatformContext f85003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f85004c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        AudienceLaunchContextService.openMiniApp$default((AudienceLaunchContextService) this.f85003b.getService(AudienceLaunchContextService.class), MountedMiniAppSource.ToolbarDirectMicroApp, null, 2, null);
        AudienceShelfInfoService r100 = (AudienceShelfInfoService) this.f85003b.getService(AudienceShelfInfoService.class);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r101 = AudienceMiniAppDataContext.a.a();
        if (r101 == null) goto L13;
        n<ShelfInfo> r102 = r101.m8183getShelfInfo();
        if (r102 == null) goto L13;
        ShelfInfo r103 = r102.getValue();
        if (r103 == null) goto L13;
        List<ShelfCardInfo> r104 = r103.cardInfoList;
        if (r104 == null) goto L13;
        ShelfCardInfo r105 = (ShelfCardInfo) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L13;
        long r106 = r105.getCardId();
    L14:
        r100.m(2, r106);
        return;
    L13:
        r106 = 0;
        goto L14
    }

    public d(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        this.f85004c = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f85003b = r100;
    }
}
