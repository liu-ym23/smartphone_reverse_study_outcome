package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0011\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0012R\u001a\u0010$\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/a0;", "Lvh7/c;", "", "getTargetLinkMicIdStr", "()Ljava/lang/String;", "getTargetLinkMicIdStr$annotations", "()V", "targetLinkMicIdStr", "", "getLinkType", "()I", "getLinkType$annotations", "linkType", "getSilenceStatus", "getSilenceStatus$annotations", "silenceStatus", "", "isKtv", "()Z", "isKtv$annotations", "getNeedAck", "getNeedAck$annotations", "needAck", "getAckMessage", "getAckMessage$annotations", "ackMessage", "getForceResumeVideoStream", "getForceResumeVideoStream$annotations", "forceResumeVideoStream", "getForceResumeAudioStream", "getForceResumeAudioStream$annotations", "forceResumeAudioStream", "", "getTargetAwemeUid", "()J", "getTargetAwemeUid$annotations", "targetAwemeUid", "getTargetOpenId", "getTargetOpenId$annotations", "targetOpenId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a0 extends vh7.c<a0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ack_message")
    String getAckMessage();

    @FieldName(name = "force_resume_audio_stream")
    boolean getForceResumeAudioStream();

    @FieldName(name = "force_resume_video_stream")
    boolean getForceResumeVideoStream();

    @FieldName(name = "link_type")
    int getLinkType();

    @FieldName(name = WsConstants.KEY_NEED_ACK)
    boolean getNeedAck();

    @FieldName(name = "silence_status")
    int getSilenceStatus();

    @FieldName(name = "target_user_id")
    long getTargetAwemeUid();

    @FieldName(name = "target_linkmic_id_str")
    String getTargetLinkMicIdStr();

    @FieldName(name = "target_open_id")
    String getTargetOpenId();

    @FieldName(name = "is_ktv")
    boolean isKtv();
}
