package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BootInfoService f60836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f60837b;

    public h(BootInfoService r100, String r101) {
        this.f60836a = r100;
        this.f60837b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        Response r111 = (Response) r110;
        Intrinsics.checkNotNullParameter(r111, "it");
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("BootInfoService", new Object[]{"on bootconfig response", ", appId: ", this.f60837b, ", logId: ", r111.logId});
        BootInfoService r101 = this.f60836a;
        String r102 = this.f60837b;
        com.bytedance.android.live.broadcastgame.opengame.network.a r112 = (com.bytedance.android.live.broadcastgame.opengame.network.a) r111.data;
        int r103 = BootInfoService.f60767c;
        r101.getClass();
        if (r112 == null) goto L6;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r104 = r112.g();
        if (r104 == null) goto L6;
    L7:
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r105 = r104;
        if (r112 == null) goto L11;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r106 = r112.d();
        if (r106 == null) goto L11;
    L12:
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r107 = r106;
        if (r112 == null) goto L15;
        boolean r108 = r112.c();
    L16:
        if (r112 == null) goto L18;
        boolean r109 = r112.a();
    L19:
        if (r112 == null) goto L21;
        List<Integer> r113 = r112.f();
    L22:
        List<Integer> r114 = r113;
        if (r112 == null) goto L26;
        String r115 = r112.e();
        if (r115 == null) goto L26;
    L27:
        j r116 = new j(r105, r107, r108, r109, r114, r115);
        com.bytedance.android.livesdk.sharedpref.e<HashMap<String, String>> r117 = com.bytedance.android.livesdk.sharedpref.b.f158240y2;
        HashMap<String, String> r118 = r117.getValue();
        r118.put(r102, JsonUtil.toJSONString(r116));
        com.bytedance.android.livesdk.sharedpref.f.d(r117, r118);
        if (r112 == null) goto L33;
        com.bytedance.android.live.broadcastgame.opengame.network.a.b r119 = r112.b();
        if (r119 == null) goto L33;
        String r120 = r119.a();
        if (r120 == null) goto L33;
    L35:
        return new g(r120, r116);
    L33:
        r120 = "";
    L26:
        r115 = "unknown";
        goto L27
    L21:
        r113 = null;
        goto L22
    L18:
        r109 = false;
        goto L19
    L15:
        r108 = false;
    L11:
        r106 = new ArrayList();
    L6:
        r104 = new ArrayList();
        goto L7
    }
}
