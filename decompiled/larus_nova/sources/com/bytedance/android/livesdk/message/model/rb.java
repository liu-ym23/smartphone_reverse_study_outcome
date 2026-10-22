package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dJ\b\u0010\u0003\u001a\u00020\u0002H&R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rb;", "Lvh7/c;", "", "messageId", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "getUserId", "()J", "getUserId$annotations", "userId", "getPunchStartTime", "getPunchStartTime$annotations", "punchStartTime", "getPunchDuration", "getPunchDuration$annotations", "punchDuration", "", "getToastString", "()Ljava/lang/String;", "getToastString$annotations", "toastString", "getPunchStatus", "getPunchStatus$annotations", "punchStatus", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface rb extends vh7.c<rb> {
    public static final a Companion = null;
    public static final int PUNCH_FINISH = 3;
    public static final int PUNCH_START = 1;
    public static final int PUNCH_SUCCESS = 2;
    public static final int STATUS_PUNCHED = 2;
    public static final int STATUS_PUNCHING = 1;
    public static final int STATUS_TIME_SETTLED = 3;
    public static final int UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153696a = null;

        public a() {
        }

        static {
            f153696a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153696a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    @FieldName(name = "punch_duration")
    long getPunchDuration();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getPunchStartTime();

    @FieldName(name = "punch_status")
    int getPunchStatus();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    String getToastString();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long getUserId();

    long messageId();
}
