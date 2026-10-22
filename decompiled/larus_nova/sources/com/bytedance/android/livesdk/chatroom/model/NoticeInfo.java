package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfo;", "Lvh7/c;", "", "getNeedPush", "()Z", "setNeedPush", "(Z)V", "getNeedPush$annotations", "()V", "needPush", "", "getAppId", "()J", "setAppId", "(J)V", "getAppId$annotations", "appId", "get_userId", "set_userId", "get_userId$annotations", "_userId", "", "get_openId", "()Ljava/lang/String;", "set_openId", "(Ljava/lang/String;)V", "get_openId$annotations", "_openId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface NoticeInfo extends vh7.c<NoticeInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "app_id")
    long getAppId();

    @FieldName(name = "need_push")
    boolean getNeedPush();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String get_openId();

    @FieldName(name = "user_id")
    long get_userId();

    @FieldName(name = "app_id#setter")
    void setAppId(long r100);

    @FieldName(name = "need_push#setter")
    void setNeedPush(boolean r100);

    @FieldName(name = "open_id#setter")
    void set_openId(String r100);

    @FieldName(name = "user_id#setter")
    void set_userId(long r100);
}
