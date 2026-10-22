package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.share.QQShare;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "Lvh7/c;", "", "isGame", "()I", "isGame$annotations", "()V", "", "getGameTagId", "()J", "getGameTagId$annotations", "gameTagId", "", "getGameTagName", "()Ljava/lang/String;", "getGameTagName$annotations", "gameTagName", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IGameTagInfo extends c<IGameTagInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "game_tag_id")
        public static /* synthetic */ void getGameTagId$annotations() {
        }

        @FieldName(name = QQShare.SHARE_TO_QQ_GAME_TAG_NAME)
        public static /* synthetic */ void getGameTagName$annotations() {
        }

        @FieldName(name = "is_game")
        public static /* synthetic */ void isGame$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "game_tag_id")
    long getGameTagId();

    @FieldName(name = QQShare.SHARE_TO_QQ_GAME_TAG_NAME)
    String getGameTagName();

    @FieldName(name = "is_game")
    int isGame();
}
