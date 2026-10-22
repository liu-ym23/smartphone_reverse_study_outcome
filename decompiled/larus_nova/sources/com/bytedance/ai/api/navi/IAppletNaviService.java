package com.bytedance.ai.api.navi;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0013Jn\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/api/navi/IAppletNaviService;", "", "startThirdNaviOrPlan", "", "appName", "", "type", "olat", "", "olon", PlayerResolution.SDKKEY.ORIGIN, "dlat", "dlon", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "IStartThirdNaviOrPlanCallback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppletNaviService {

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.ai.api.navi.IAppletNaviService$a$a, reason: collision with other inner class name */
        public static final class C0678a {
            public static /* synthetic */ void a(a r100) {
                r100.onResult(-1, null);
            }
        }

        void onResult(int r100, String r101);
    }

    void a(String r100, String r101, float r102, float r103, String r104, float r105, float r106, String r107, String r108, boolean r110, a r111);
}
