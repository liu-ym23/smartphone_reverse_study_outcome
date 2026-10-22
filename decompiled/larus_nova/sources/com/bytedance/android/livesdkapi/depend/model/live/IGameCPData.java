package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "Lvh7/c;", "", "isAPromotedA", "()I", "isAPromotedA$annotations", "()V", "", "getGameId", "()Ljava/lang/String;", "getGameId$annotations", "gameId", "getGameName", "getGameName$annotations", "gameName", "", "getPromoteInstanceId", "()Ljava/lang/Long;", "getPromoteInstanceId$annotations", "promoteInstanceId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IGameCPData extends c<IGameCPData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "game_id")
        public static /* synthetic */ void getGameId$annotations() {
        }

        @FieldName(name = EventConstants.ExtraJson.GAME_NAME)
        public static /* synthetic */ void getGameName$annotations() {
        }

        @FieldName(name = AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
        public static /* synthetic */ void getPromoteInstanceId$annotations() {
        }

        @FieldName(name = "is_live_a_promoted_a")
        public static /* synthetic */ void isAPromotedA$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "game_id")
    String getGameId();

    @FieldName(name = EventConstants.ExtraJson.GAME_NAME)
    String getGameName();

    @FieldName(name = AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    Long getPromoteInstanceId();

    @FieldName(name = "is_live_a_promoted_a")
    int isAPromotedA();
}
