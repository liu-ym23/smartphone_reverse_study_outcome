package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006RJ\u0010\u0014\u001a*\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0014\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "Lvh7/c;", "", "getUseMultiChannel", "()Z", "setUseMultiChannel", "(Z)V", "getUseMultiChannel$annotations", "()V", "useMultiChannel", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getChannelMap", "()Ljava/util/Map;", "setChannelMap", "(Ljava/util/Map;)V", "getChannelMap$annotations", "channelMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s1 extends vh7.c<s1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "linkmic_infos")
    Map<Long, String> getChannelMap();

    @FieldName(name = "use_multi_channel")
    boolean getUseMultiChannel();

    @FieldName(name = "linkmic_infos#setter")
    void setChannelMap(Map<Long, String> r100);

    @FieldName(name = "use_multi_channel#setter")
    void setUseMultiChannel(boolean r100);
}
