package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import lu1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements OnLiveWsMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f123266a = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101) {
    }

    static {
        f123266a = new c();
    }

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveMsg(LiveWsMessage r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = k.f510820a;
        k.g("DynamicStrategy_message", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "frontier_message")}));
        DynamicStrategyFetcher.updateStrategyWhenMessageNotify$default(DynamicStrategyFetcher.INSTANCE, null, 1, null);
    }
}
