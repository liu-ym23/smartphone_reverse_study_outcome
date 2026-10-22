package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00148gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001d8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00178gX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0016\u0010$\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\fR\u0016\u0010&\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/k;", "Lvh7/c;", "", "getAwemeUserId", "()J", "awemeUserId", "", "getOpenUserId", "()Ljava/lang/String;", "openUserId", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "avatarThumb", "getNick_name", "nick_name", "getScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getRank", "rank", "", "isIsMvp", "()Z", "", "getUserStatus", "()I", "userStatus", "getInvitedCount", "invitedCount", "", "getInviteUsersString", "()Ljava/util/List;", "inviteUsersString", "getCallStatus", "callStatus", "getNewImIconWithLevel", "newImIconWithLevel", "getUserIdString", "userIdString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumb();

    @FieldName(name = "user_id")
    long getAwemeUserId();

    @FieldName(name = "call_status")
    int getCallStatus();

    @FieldName(name = "invite_users")
    List<String> getInviteUsersString();

    @FieldName(name = "invited_count")
    long getInvitedCount();

    @FieldName(name = "new_im_icon_with_level")
    py.k getNewImIconWithLevel();

    @FieldName(name = "nick_name")
    String getNick_name();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getOpenUserId();

    @FieldName(name = "rank")
    long getRank();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    String getUserIdString();

    @FieldName(name = "user_status")
    int getUserStatus();

    @FieldName(name = "is_mvp")
    boolean isIsMvp();
}
