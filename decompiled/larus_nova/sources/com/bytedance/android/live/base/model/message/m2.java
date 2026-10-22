package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0014R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/m2;", "Lvh7/c;", "Ltlc/d;", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/live/base/model/message/k2;", "getConfigContent", "()Lcom/bytedance/android/live/base/model/message/k2;", "getConfigContent$annotations", "configContent", "Lcom/bytedance/android/live/base/model/message/l2;", "getLikeContent", "()Lcom/bytedance/android/live/base/model/message/l2;", "getLikeContent$annotations", "likeContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m2 extends vh7.c<m2>, tlc.d {
    public static final a Companion = null;
    public static final int MSG_TYPE_CONFIG = 1;
    public static final int MSG_TYPE_LIKE = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58892a = null;

        public a() {
        }

        static {
            f58892a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f58892a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "config_content")
    k2 getConfigContent();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    @FieldName(name = "like_content")
    l2 getLikeContent();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    /* synthetic */ int getPriority();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

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
