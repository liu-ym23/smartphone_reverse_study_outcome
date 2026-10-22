package com.bytedance.android.livesdk.revenue.message;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.f3;
import com.bytedance.android.livesdk.gift.model.o1;
import com.bytedance.android.livesdk.revenue.service.message.uplink.UplinkApi;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements IRevUplinkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.d f157198a;

    public m(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f157198a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.message.IRevUplinkClient
    public final Observable<ExtraResponse<f3, Extra>> syncPropList(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryMap");
        return ((UplinkApi) new ac2.i(this.f157198a).a(UplinkApi.class)).syncPropList(r100);
    }

    public final Observable<ExtraResponse<o1, Extra>> a(Map<String, String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "queryMap");
        Intrinsics.checkNotNullParameter(r101, "fieldMap");
        return ((UplinkApi) new ac2.i(this.f157198a).a(UplinkApi.class)).getGiftExtra(r100, r101);
    }
}
