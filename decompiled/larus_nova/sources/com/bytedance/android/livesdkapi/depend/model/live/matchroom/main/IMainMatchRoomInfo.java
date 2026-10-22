package com.bytedance.android.livesdkapi.depend.model.live.matchroom.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/main/IMainMatchRoomInfo;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "", "", "getMatchHostChannel", "()Ljava/util/Map;", "setMatchHostChannel", "(Ljava/util/Map;)V", "getMatchHostChannel$annotations", "()V", "matchHostChannel", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainMatchRoomInfo extends e<IMatchRoomInfo>, IMatchRoomInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "match_host_channel")
        public static /* synthetic */ void getMatchHostChannel$annotations() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "match_host_channel")
    Map<Long, Long> getMatchHostChannel();

    @FieldName(name = "match_host_channel#setter")
    void setMatchHostChannel(Map<Long, Long> r100);
}
