package com.bytedance.android.livesdkapi.depend.model.live.matchroom.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IEpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/main/IMainEpisodeBasicInfo;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IEpisodeBasicInfo;", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "getReplaysTabs", "()Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "setReplaysTabs", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;)V", "getReplaysTabs$annotations", "()V", "replaysTabs", "", "isUgc", "()Ljava/lang/Boolean;", "setUgc", "(Ljava/lang/Boolean;)V", "isUgc$annotations", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainEpisodeBasicInfo extends e<IEpisodeBasicInfo>, IEpisodeBasicInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "multi_tab")
        public static /* synthetic */ void getReplaysTabs$annotations() {
        }

        @FieldName(name = "is_ugc")
        public static /* synthetic */ void isUgc$annotations() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IEpisodeBasicInfo, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IEpisodeBasicInfo, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "multi_tab")
    MultiTab getReplaysTabs();

    @FieldName(name = "is_ugc")
    Boolean isUgc();

    @FieldName(name = "multi_tab#setter")
    void setReplaysTabs(MultiTab r100);

    @FieldName(name = "is_ugc#setter")
    void setUgc(Boolean r100);
}
