package com.bytedance.android.live.broadcastgame.opengame.auth;

import com.bytedance.android.live.broadcastgame.opengame.openapi.v;
import com.bytedance.android.live.broadcastgame.opengame.openapi.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.live.livecontainer.sonicgame.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y10.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenBaseAuthService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenBaseAuthService implements a {
    @Override // y10.a
    public final void g() {
    }

    public OpenBaseAuthService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
    }

    public void a(String r100, v.a r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter("feature not support", "errMsg");
    }

    public void b(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onFail("feature not support");
    }

    public void c(String r100, List r101, JSONObject r102, x r103) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "requestList");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r103.a();
    }
}
