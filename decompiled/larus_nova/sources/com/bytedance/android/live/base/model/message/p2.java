package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016J\b\u0010\u0004\u001a\u00020\u0003H&R\u0014\u0010\b\u001a\u00020\u00058gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/base/model/message/p2;", "Lvh7/c;", "Ltlc/d;", "", "getMessageId", "", "getMsgType", "()I", "msgType", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo", "Lcom/bytedance/android/live/base/model/message/o2;", "getFinishContent", "()Lcom/bytedance/android/live/base/model/message/o2;", "finishContent", "Lcom/bytedance/android/live/base/model/message/n2;", "getCreateContent", "()Lcom/bytedance/android/live/base/model/message/n2;", "createContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p2 extends vh7.c<p2>, tlc.d {
    public static final a Companion = null;
    public static final int TEAM_FIGHT_MESSAGE_CREATE = 1;
    public static final int TEAM_FIGHT_MESSAGE_FINISH = 5;
    public static final int TEAM_FIGHT_MESSAGE_NONE = 0;
    public static final int TEAM_FIGHT_MESSAGE_PUNISH = 4;
    public static final int TEAM_FIGHT_MESSAGE_SHOWING = 6;
    public static final int TEAM_FIGHT_MESSAGE_START = 2;
    public static final int TEAM_FIGHT_MESSAGE_UPDATE = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58896a = null;

        public a() {
        }

        static {
            f58896a = new a();
        }
    }

    static {
        Companion = a.f58896a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "create_content")
    n2 getCreateContent();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "finish_content")
    o2 getFinishContent();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    /* synthetic */ int getPriority();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "teamfight_info")
    com.bytedance.android.live.liveinteract.multiscene.a getTeamFightInfo();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);
}
