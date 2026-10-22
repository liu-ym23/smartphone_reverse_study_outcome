package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface q5 extends t, h0 {
    VSShowChatMessageCommentRoleConfig G0();

    void K1(List<String> r100);

    void R0(r5 r100);

    boolean a();

    List<String> b();

    void c1(long r100);

    void f1(o1 r100);

    long getAgreeMsgId();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    OfficialCommentConfig getOfficialCommentConfig();

    IBaseUser getUserInfo();

    boolean isSelfSendFake();

    void setBackground(py.k r100);

    void setBaseMessage(m0 r100);

    void setContent(String r100);

    void setEpisodeId(long r100);

    void setMsgId(String r100);

    void setSelfSendFake(boolean r100);

    void setUserInfo(IBaseUser r100);

    void w1(long r100);
}
