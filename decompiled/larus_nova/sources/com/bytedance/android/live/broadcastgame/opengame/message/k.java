package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class k extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f60239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f60240e;

    public static final class a {
    }

    static {
    }

    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("app_id", this.f60248a);
        r100.put("room_id", this.f60249b);
        r100.put("conn_id", this.f60250c);
        r100.put(OnekeyLoginConstants.CU_KEY_SEQ, this.f60239d);
        r100.put("time_stamp", System.currentTimeMillis());
        return r100;
    }

    public /* synthetic */ k(String r110, long r111, long r112, long r113) {
        this(r110, r111, r112, r113, 1);
    }

    public k(String r100, long r101, long r110, long r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        super(r100, r101, r111);
        this.f60239d = r110;
        this.f60240e = r112;
    }
}
