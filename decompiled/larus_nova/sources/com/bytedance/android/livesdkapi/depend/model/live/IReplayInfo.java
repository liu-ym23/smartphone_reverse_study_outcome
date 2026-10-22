package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;", "Lvh7/c;", "", "getReplayUrl", "()Ljava/lang/String;", "setReplayUrl", "(Ljava/lang/String;)V", "getReplayUrl$annotations", "()V", "replayUrl", "", "getReplayDuration", "()I", "setReplayDuration", "(I)V", "getReplayDuration$annotations", "replayDuration", "getContentUniqId", "setContentUniqId", "getContentUniqId$annotations", "contentUniqId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IReplayInfo extends c<IReplayInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "content_uniq_id")
        public static /* synthetic */ void getContentUniqId$annotations() {
        }

        @FieldName(name = "replay_duration")
        public static /* synthetic */ void getReplayDuration$annotations() {
        }

        @FieldName(name = "replay_url")
        public static /* synthetic */ void getReplayUrl$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "content_uniq_id")
    String getContentUniqId();

    @FieldName(name = "replay_duration")
    int getReplayDuration();

    @FieldName(name = "replay_url")
    String getReplayUrl();

    @FieldName(name = "content_uniq_id#setter")
    void setContentUniqId(String r100);

    @FieldName(name = "replay_duration#setter")
    void setReplayDuration(int r100);

    @FieldName(name = "replay_url#setter")
    void setReplayUrl(String r100);
}
