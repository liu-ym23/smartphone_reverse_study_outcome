package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001(R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0007\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0007\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/da;", "Lvh7/c;", "Ltlc/d;", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/livesdk/message/model/ia;", "getStartContent", "()Lcom/bytedance/android/livesdk/message/model/ia;", "getStartContent$annotations", "startContent", "Lcom/bytedance/android/livesdk/message/model/ca;", "getCloseContent", "()Lcom/bytedance/android/livesdk/message/model/ca;", "getCloseContent$annotations", "closeContent", "Lcom/bytedance/android/livesdk/message/model/fa;", "getScoreChangeContent", "()Lcom/bytedance/android/livesdk/message/model/fa;", "getScoreChangeContent$annotations", "scoreChangeContent", "Lcom/bytedance/android/livesdk/message/model/ea;", "getOnceMoreContent", "()Lcom/bytedance/android/livesdk/message/model/ea;", "getOnceMoreContent$annotations", "onceMoreContent", "Lcom/bytedance/android/livesdk/message/model/ha;", "getShowTimeStartContent", "()Lcom/bytedance/android/livesdk/message/model/ha;", "getShowTimeStartContent$annotations", "showTimeStartContent", "Lcom/bytedance/android/livesdk/message/model/ga;", "getShowTimeFinishContent", "()Lcom/bytedance/android/livesdk/message/model/ga;", "getShowTimeFinishContent$annotations", "showTimeFinishContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface da extends vh7.c<da>, tlc.d {
    public static final a Companion = null;
    public static final int MSG_TYPE_CLOSE = 2;
    public static final int MSG_TYPE_ONCE_MORE = 4;
    public static final int MSG_TYPE_SCORE_CHANGE = 3;
    public static final int MSG_TYPE_SHOW_TIME_FINISH = 6;
    public static final int MSG_TYPE_SHOW_TIME_START = 5;
    public static final int MSG_TYPE_START = 1;
    public static final int MSG_TYPE_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153634a = null;

        public a() {
        }

        static {
            f153634a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153634a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "close_content")
    ca getCloseContent();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    @FieldName(name = "once_more_content")
    ea getOnceMoreContent();

    /* synthetic */ int getPriority();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "score_change_content")
    fa getScoreChangeContent();

    @FieldName(name = "show_time_finish_content")
    ga getShowTimeFinishContent();

    @FieldName(name = "show_time_start_content")
    ha getShowTimeStartContent();

    @FieldName(name = "start_content")
    ia getStartContent();

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
