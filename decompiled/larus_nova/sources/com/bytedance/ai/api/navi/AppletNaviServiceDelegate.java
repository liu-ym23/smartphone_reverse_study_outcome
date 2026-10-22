package com.bytedance.ai.api.navi;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/api/navi/AppletNaviServiceDelegate;", "Lcom/bytedance/ai/api/navi/IAppletNaviService;", "<init>", "()V", "startThirdNaviOrPlan", "", "appName", "", "type", "olat", "", "olon", PlayerResolution.SDKKEY.ORIGIN, "dlat", "dlon", a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletNaviServiceDelegate implements IAppletNaviService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppletNaviServiceDelegate f34049b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAppletNaviService f34050a;

    static {
        f34049b = new AppletNaviServiceDelegate();
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService
    public final void a(String r110, String r111, float r112, float r113, String r114, float r115, float r210, String r211, String r212, boolean r213, IAppletNaviService.a r214) {
        Intrinsics.checkNotNullParameter(r114, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r211, a.KEY_DESTINATION);
        this.f34050a.a(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    private AppletNaviServiceDelegate() {
        IAppletNaviService r100 = (IAppletNaviService) ServiceManager.get().getService(IAppletNaviService.class);
        if (r100 != null) goto L5;
        r100 = NoopAppletNaviService.f34053a;
    L5:
        this.f34050a = r100;
    }
}
