package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\"\u0010\u0010\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t5;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "getNickName", "getNickName$annotations", "nickName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarThumb", "()Lpy/k;", "getAvatarThumb$annotations", "avatarThumb", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t5 extends vh7.c<t5> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumb();

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getUserId();
}
