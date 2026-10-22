package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.heytap.mcssdk.constant.b;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraMatchInfo;", "Lvh7/c;", "", "getMatchId", "()J", "setMatchId", "(J)V", "getMatchId$annotations", "()V", "matchId", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getEventId", "()Ljava/util/List;", "setEventId", "(Ljava/util/List;)V", "getEventId$annotations", b.f276361k, "getContentId", "setContentId", "getContentId$annotations", "contentId", "getHideTabIds", "setHideTabIds", "getHideTabIds$annotations", "hideTabIds", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ICameraMatchInfo extends c<ICameraMatchInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = a.KEY_CONTENT_ID)
        public static /* synthetic */ void getContentId$annotations() {
        }

        @FieldName(name = "event_ids")
        public static /* synthetic */ void getEventId$annotations() {
        }

        @FieldName(name = "hide_tab_ids")
        public static /* synthetic */ void getHideTabIds$annotations() {
        }

        @FieldName(name = VSConstants.VS_MATCH_ID)
        public static /* synthetic */ void getMatchId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = a.KEY_CONTENT_ID)
    long getContentId();

    @FieldName(name = "event_ids")
    List<Long> getEventId();

    @FieldName(name = "hide_tab_ids")
    List<Long> getHideTabIds();

    @FieldName(name = VSConstants.VS_MATCH_ID)
    long getMatchId();

    @FieldName(name = "content_id#setter")
    void setContentId(long r100);

    @FieldName(name = "event_ids#setter")
    void setEventId(List<Long> r100);

    @FieldName(name = "hide_tab_ids#setter")
    void setHideTabIds(List<Long> r100);

    @FieldName(name = "match_id#setter")
    void setMatchId(long r100);
}
