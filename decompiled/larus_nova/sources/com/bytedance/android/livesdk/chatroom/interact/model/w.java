package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/w;", "Lvh7/c;", "", "getUserId", "()J", "userId", "", "getUserIdStr", "()Ljava/lang/String;", "userIdStr", "getNickName", "nickName", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "avatarThumb", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w extends vh7.c<w> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumb();

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = "user_id")
    @Deprecated(message = "这个方法仅作为兼容生成给前端json数据使用，不要在native代码使用此方法\n      使用 getUserIdStr 进行替代！！")
    long getUserId();

    @FieldName(name = "user_id_str")
    String getUserIdStr();
}
