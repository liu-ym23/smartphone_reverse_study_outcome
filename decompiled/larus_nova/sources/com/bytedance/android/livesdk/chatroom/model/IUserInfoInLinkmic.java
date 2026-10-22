package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R>\u0010\"\u001a\u001e\u0012\b\u0012\u00060\u001aj\u0002`\u001b\u0018\u00010\u0019j\u000e\u0012\b\u0012\u00060\u001aj\u0002`\u001b\u0018\u0001`\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010&\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u0006R$\u0010*\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u0010.\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010\u0006¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IUserInfoInLinkmic;", "Lvh7/c;", "", "getAddFollowersCount", "()Ljava/lang/Long;", "setAddFollowersCount", "(Ljava/lang/Long;)V", "getAddFollowersCount$annotations", "()V", "addFollowersCount", "", "getAddFanTicketStr", "()Ljava/lang/String;", "setAddFanTicketStr", "(Ljava/lang/String;)V", "getAddFanTicketStr$annotations", "addFanTicketStr", "getScoreMoreThan", "setScoreMoreThan", "getScoreMoreThan$annotations", "scoreMoreThan", "getContributorCount", "setContributorCount", "getContributorCount$annotations", "contributorCount", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getContributors", "()Ljava/util/List;", "setContributors", "(Ljava/util/List;)V", "getContributors$annotations", "contributors", "getLinkDuration", "setLinkDuration", "getLinkDuration$annotations", "linkDuration", "getTextInfo", "setTextInfo", "getTextInfo$annotations", "textInfo", "getFirstSendGiftContributorCount", "setFirstSendGiftContributorCount", "getFirstSendGiftContributorCount$annotations", "firstSendGiftContributorCount", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IUserInfoInLinkmic extends vh7.c<IUserInfoInLinkmic> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "add_fan_ticket_str")
    String getAddFanTicketStr();

    @FieldName(name = "add_followers_count")
    Long getAddFollowersCount();

    @FieldName(name = "contributor_count")
    Long getContributorCount();

    @FieldName(name = "contributors")
    List<IBaseUser> getContributors();

    @FieldName(name = "first_send_gift_contributor_count")
    Long getFirstSendGiftContributorCount();

    @FieldName(name = "link_duration")
    Long getLinkDuration();

    @FieldName(name = "score_more_than")
    Long getScoreMoreThan();

    @FieldName(name = "text_info")
    String getTextInfo();

    @FieldName(name = "add_fan_ticket_str#setter")
    void setAddFanTicketStr(String r100);

    @FieldName(name = "add_followers_count#setter")
    void setAddFollowersCount(Long r100);

    @FieldName(name = "contributor_count#setter")
    void setContributorCount(Long r100);

    @FieldName(name = "contributors#setter")
    void setContributors(List<? extends IBaseUser> r100);

    @FieldName(name = "first_send_gift_contributor_count#setter")
    void setFirstSendGiftContributorCount(Long r100);

    @FieldName(name = "link_duration#setter")
    void setLinkDuration(Long r100);

    @FieldName(name = "score_more_than#setter")
    void setScoreMoreThan(Long r100);

    @FieldName(name = "text_info#setter")
    void setTextInfo(String r100);
}
