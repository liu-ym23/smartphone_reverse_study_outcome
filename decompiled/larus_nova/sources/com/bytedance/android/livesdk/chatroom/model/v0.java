package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001*R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0012R\u0016\u0010%\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0014\u0010'\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0016\u0010)\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v0;", "Lvh7/c;", "", "getId", "()J", "id", "getMsgId", RemoteMessageConst.MSGID, "", "getContent", "()Ljava/lang/String;", "content", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lpy/k;", "getBackground", "()Lpy/k;", "background", "getFullScreenTextColor", "fullScreenTextColor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/livesdk/chatroom/model/v0$a;", "getLandscapeAreaCommon", "()Lcom/bytedance/android/livesdk/chatroom/model/v0$a;", "landscapeAreaCommon", "", "getShowIdentity", "()I", "showIdentity", "getIdentityLabel", "identityLabel", "getRtfContentV2", "rtfContentV2", "getContentSelfSeeStatus", "contentSelfSeeStatus", "getExtra", "extra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v0 extends vh7.c<v0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v0$a;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/q1;", "toCommon", "", "getShowHead", "()Z", "showHead", "getShowNickName", "showNickName", "getShowFontColor", "showFontColor", "", "", "getColorList", "()Ljava/util/List;", "colorList", "", "getCommentTypeTag", "commentTypeTag", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        List<String> getColorList();

        List<Integer> getCommentTypeTag();

        boolean getShowFontColor();

        boolean getShowHead();

        boolean getShowNickName();

        com.bytedance.android.live.base.model.message.q1 toCommon();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    py.k getBackground();

    String getContent();

    int getContentSelfSeeStatus();

    a5 getDisplayText();

    String getExtra();

    String getFullScreenTextColor();

    long getId();

    py.k getIdentityLabel();

    a getLandscapeAreaCommon();

    long getMsgId();

    a5 getRtfContentV2();

    int getShowIdentity();

    IBaseUser getUser();
}
