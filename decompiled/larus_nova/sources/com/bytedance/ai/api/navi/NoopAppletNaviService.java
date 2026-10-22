package com.bytedance.ai.api.navi;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/api/navi/NoopAppletNaviService;", "Lcom/bytedance/ai/api/navi/IAppletNaviService;", "<init>", "()V", "startThirdNaviOrPlan", "", "appName", "", "type", "olat", "", "olon", PlayerResolution.SDKKEY.ORIGIN, "dlat", "dlon", a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopAppletNaviService implements IAppletNaviService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoopAppletNaviService f34053a = null;

    static {
        f34053a = new NoopAppletNaviService();
    }

    private NoopAppletNaviService() {
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService
    public final void a(String r100, String r101, float r102, float r103, String r104, float r105, float r106, String r107, String r108, boolean r110, IAppletNaviService.a r111) {
        Intrinsics.checkNotNullParameter(r104, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r107, a.KEY_DESTINATION);
        if (r111 == null) goto L6;
        r111.onResult(-1, r100);
        return;
    }
}
