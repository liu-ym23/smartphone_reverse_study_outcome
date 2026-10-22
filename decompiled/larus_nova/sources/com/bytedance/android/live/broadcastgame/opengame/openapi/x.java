package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.ExtraResponse;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w.b f60583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f60584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f60585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ExtraResponse f60586d;

    public final void a() {
        Intrinsics.checkNotNullParameter("feature not support", "errMsg");
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("GetUserInfoV2Method", new Object[]{"auth fail, msg: feature not support"});
        this.f60583a.f60576a.n(OpenApiErrorInfo.INTERNAL_ERROR, new Throwable("feature not support"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(List<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"auth success"});
        JSONObject r102 = new JSONObject().put("nickName", this.f60584b).put("avatarUrl", this.f60585c).put("role", ((com.bytedance.android.live.broadcastgame.opengame.network.d0) this.f60586d.data).a().d()).put("openUID", ((com.bytedance.android.live.broadcastgame.opengame.network.d0) this.f60586d.data).a().c());
        w r103 = this.f60583a.f60576a;
        JSONObject r104 = new JSONObject();
        r104.put("userInfo", r102);
        Unit r105 = Unit.INSTANCE;
        r103.r(r104);
    }

    public x(w.b r100, String r101, String r102, ExtraResponse r103) {
        this.f60583a = r100;
        this.f60584b = r101;
        this.f60585c = r102;
        this.f60586d = r103;
    }
}
