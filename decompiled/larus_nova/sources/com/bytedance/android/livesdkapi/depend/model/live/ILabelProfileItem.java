package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelProfileItem;", "Lvh7/c;", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "userId", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "getNickName$annotations", "nickName", "Lpy/k;", "getProfilePic", "()Lpy/k;", "setProfilePic", "(Lpy/k;)V", "getProfilePic$annotations", "profilePic", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ILabelProfileItem extends c<ILabelProfileItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "nick_name")
        public static /* synthetic */ void getNickName$annotations() {
        }

        @FieldName(name = "profile_pic")
        public static /* synthetic */ void getProfilePic$annotations() {
        }

        @FieldName(name = "user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = "profile_pic")
    k getProfilePic();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "nick_name#setter")
    void setNickName(String r100);

    @FieldName(name = "profile_pic#setter")
    void setProfilePic(k r100);

    @FieldName(name = "user_id#setter")
    void setUserId(long r100);
}
