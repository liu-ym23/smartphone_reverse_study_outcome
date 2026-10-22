package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b9;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b9 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g2>, com.bytedance.android.livesdk.link.model.bridge.g2 {
    @Override // com.bytedance.android.livesdk.link.model.bridge.g2, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.g2, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getAnchorIdString();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers();

    /* synthetic */ long getLiveRoomMode();

    /* synthetic */ long getMVersion();

    /* synthetic */ int getRoomLinkSilenceStatus();

    /* synthetic */ long getVersion();

    /* synthetic */ long isGuestAnchorBackground();
}
