package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\r\u001a\u00060\bj\u0002`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0013\u001a\u00060\u000ej\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R2\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\"R\u001a\u0010*\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/o8;", "Lvh7/c;", "", "getReserveId", "()Ljava/lang/String;", "getReserveId$annotations", "()V", "reserveId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser$annotations", "user", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom$annotations", "room", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "getDescText", "getDescText$annotations", "descText", "Lcom/bytedance/android/livesdk/link/model/o3;", "getInviteBtn", "()Lcom/bytedance/android/livesdk/link/model/o3;", "getInviteBtn$annotations", "inviteBtn", "getReplyBtn", "getReplyBtn$annotations", "replyBtn", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o8 extends vh7.c<o8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "desc_text")
    String getDescText();

    @FieldName(name = "invite_button")
    o3 getInviteBtn();

    @FieldName(name = "reply_button")
    o3 getReplyBtn();

    @FieldName(name = AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID)
    String getReserveId();

    @FieldName(name = "room")
    IRoom getRoom();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getTags();

    @FieldName(name = "user")
    IBaseUser getUser();

    @FieldName(name = "tags#setter")
    void setTags(List<? extends IBattleRivalTag> r100);
}
