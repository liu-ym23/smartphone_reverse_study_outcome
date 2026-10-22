package com.bytedance.android.live.openplatform.impl.miniappanchor.launch;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import java.util.Map;
import ko0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/launch/AnchorLaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/LaunchContextService;", "", "schema", "Lko0/b;", "launchParams", "Lkotlin/Function0;", "", "onSuccess", "openMiniApp", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorLaunchContextService extends LaunchContextService {
    public AnchorLaunchContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService
    public void openMiniApp(String r100, b r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "launchParams");
        Map<String, String> r103 = r101.f504351g;
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r104 = "in_live";
    L6:
        r103.put("live_status", r104);
        if (r101.f504355k == true) goto L9;
        r101.f504354j.put("shelf_ability", "1");
    L9:
        Unit r105 = Unit.INSTANCE;
        super.openMiniApp(r100, r101, r102);
        return;
    L5:
        r104 = "before_live";
        goto L6
    }
}
