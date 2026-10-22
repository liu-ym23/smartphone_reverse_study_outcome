package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/base/model/message/i3;", "Lvh7/c;", "", "getStatus", "()J", "getStatus$annotations", "()V", "status", "", "getPrompt", "()Ljava/lang/String;", "getPrompt$annotations", EventConstant.Key.RETAIN_PROMPT, "getRtcRoomId", "getRtcRoomId$annotations", "rtcRoomId", "getRtcUserId", "getRtcUserId$annotations", "rtcUserId", "getMixStreamTaskId", "getMixStreamTaskId$annotations", "mixStreamTaskId", "getPublicStreamId", "getPublicStreamId$annotations", "publicStreamId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i3 extends vh7.c<i3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "mix_stream_task_id")
    String getMixStreamTaskId();

    @FieldName(name = EventConstant.Key.RETAIN_PROMPT)
    String getPrompt();

    @FieldName(name = "public_stream_id")
    String getPublicStreamId();

    @FieldName(name = "rtc_room_id")
    String getRtcRoomId();

    @FieldName(name = "rtc_user_id")
    String getRtcUserId();

    @FieldName(name = "status")
    long getStatus();
}
