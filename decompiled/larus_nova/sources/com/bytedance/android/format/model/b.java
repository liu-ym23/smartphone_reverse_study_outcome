package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/format/model/b;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "", "containerId", "Ljava/lang/String;", "getContainerId", "()Ljava/lang/String;", "setContainerId", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "Lcom/bytedance/android/format/model/b$a;", "content", "Lcom/bytedance/android/format/model/b$a;", "getContent", "()Lcom/bytedance/android/format/model/b$a;", "setContent", "(Lcom/bytedance/android/format/model/b$a;)V", "receivedAt", "getReceivedAt", "setReceivedAt", "dispatchedAt", "getDispatchedAt", "setDispatchedAt", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("channel")
    private String channel;

    @SerializedName("container_id")
    private String containerId;

    @SerializedName("content")
    private a content;

    @SerializedName("n_dispatched_at")
    private String dispatchedAt;

    @SerializedName("n_received_at")
    private String receivedAt;

    @SerializedName("org_type")
    private Integer type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/b$a;", "", "Lcom/bytedance/android/format/model/r0;", "motionFrame", "Lcom/bytedance/android/format/model/r0;", "getMotionFrame", "()Lcom/bytedance/android/format/model/r0;", "setMotionFrame", "(Lcom/bytedance/android/format/model/r0;)V", "Lcom/bytedance/android/format/model/l0;", "playAnimationCmd", "Lcom/bytedance/android/format/model/l0;", "getPlayAnimationCmd", "()Lcom/bytedance/android/format/model/l0;", "setPlayAnimationCmd", "(Lcom/bytedance/android/format/model/l0;)V", "Lcom/bytedance/android/format/model/n0;", "loadAvatarPayload", "Lcom/bytedance/android/format/model/n0;", "getLoadAvatarPayload", "()Lcom/bytedance/android/format/model/n0;", "setLoadAvatarPayload", "(Lcom/bytedance/android/format/model/n0;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("load_avatar_payload")
        private n0 loadAvatarPayload;

        @SerializedName("motion_frame")
        private r0 motionFrame;

        @SerializedName("play_animation")
        private l0 playAnimationCmd;

        public a() {
        }
    }

    public b() {
        this.channel = "sei";
        this.content = new a();
    }

    public final Integer getType() {
        return this.type;
    }
}
