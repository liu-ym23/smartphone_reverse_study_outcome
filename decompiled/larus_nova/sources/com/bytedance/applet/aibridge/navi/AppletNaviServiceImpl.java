package com.bytedance.applet.aibridge.navi;

import com.bytedance.ai.api.navi.IAppletNaviService;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rv3.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016Jh\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\\\u0010\u0017\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\\\u0010\u001a\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u001c"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/AppletNaviServiceImpl;", "Lcom/bytedance/ai/api/navi/IAppletNaviService;", "<init>", "()V", "startThirdNaviOrPlan", "", "appName", "", "type", "olat", "", "olon", PlayerResolution.SDKKEY.ORIGIN, "dlat", "dlon", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "internalStartThirdNaviOrPlan", "getAppName", "startAmapNaviOrPlan", "latitude", "longitude", "startBaiduNaviOrPlan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletNaviServiceImpl implements IAppletNaviService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f191220a = 0;

    public static final class a {
    }

    static {
    }

    public AppletNaviServiceImpl() {
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService
    public final void a(final String r110, final String r111, final float r112, final float r113, final String r114, final float r210, final float r211, final String r212, final String r213, final boolean r214, final IAppletNaviService.a r215) {
        Intrinsics.checkNotNullParameter(r114, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r212, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        com.obric.assistant.spi.keyguard.a.a(new rv3.b(this, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215), new c(r215), null, false, 28);
    }
}
