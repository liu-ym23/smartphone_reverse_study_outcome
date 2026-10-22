package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\t\u0010\u0004R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "Lvh7/c;", "", "isLowClientVersion", "()Z", "isLowClientVersion$annotations", "()V", "isNotSupportApp", "isNotSupportApp$annotations", "isSelected", "isSelected$annotations", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "userId", "", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "getOpenId$annotations", "openId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkRoomFightReplyGuestInfo extends c<LinkRoomFightReplyGuestInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
        public static /* synthetic */ void getOpenId$annotations() {
        }

        @FieldName(name = "user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @FieldName(name = "is_low_client_version")
        public static /* synthetic */ void isLowClientVersion$annotations() {
        }

        @FieldName(name = "is_not_support_app")
        public static /* synthetic */ void isNotSupportApp$annotations() {
        }

        @FieldName(name = "is_selected")
        public static /* synthetic */ void isSelected$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getOpenId();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "is_low_client_version")
    boolean isLowClientVersion();

    @FieldName(name = "is_not_support_app")
    boolean isNotSupportApp();

    @FieldName(name = "is_selected")
    boolean isSelected();

    @FieldName(name = "open_id#setter")
    void setOpenId(String r100);

    @FieldName(name = "user_id#setter")
    void setUserId(long r100);
}
