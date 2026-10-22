package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/format/model/h;", "", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "openMessage", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "getOpenMessage", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "setOpenMessage", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;)V", "Lcom/bytedance/android/format/model/z0;", "topicPlayData", "Lcom/bytedance/android/format/model/z0;", "b", "()Lcom/bytedance/android/format/model/z0;", "setTopicPlayData", "(Lcom/bytedance/android/format/model/z0;)V", "Lcom/bytedance/android/format/model/y0;", "scriptPlayData", "Lcom/bytedance/android/format/model/y0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/format/model/y0;", "setScriptPlayData", "(Lcom/bytedance/android/format/model/y0;)V", "Lcom/bytedance/android/format/model/o0;", "coverImage", "Lcom/bytedance/android/format/model/o0;", "getCoverImage", "()Lcom/bytedance/android/format/model/o0;", "setCoverImage", "(Lcom/bytedance/android/format/model/o0;)V", "Lcom/bytedance/android/format/model/m0;", "liveScriptPlayData", "Lcom/bytedance/android/format/model/m0;", "getLiveScriptPlayData", "()Lcom/bytedance/android/format/model/m0;", "setLiveScriptPlayData", "(Lcom/bytedance/android/format/model/m0;)V", "Lcom/bytedance/android/format/model/c1;", "videoInteractData", "Lcom/bytedance/android/format/model/c1;", "getVideoInteractData", "()Lcom/bytedance/android/format/model/c1;", "setVideoInteractData", "(Lcom/bytedance/android/format/model/c1;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("cover_image")
    private o0 coverImage;

    @SerializedName("live_script_play_data")
    private m0 liveScriptPlayData;

    @SerializedName("open_message")
    private FormatLivePlayInfo.TextData openMessage;

    @SerializedName("script_play_data")
    private y0 scriptPlayData;

    @SerializedName("topic_play_data")
    private z0 topicPlayData;

    @SerializedName("video_interact_data")
    private c1 videoInteractData;

    public h() {
    }

    public final y0 a() {
        return this.scriptPlayData;
    }

    public final z0 b() {
        return this.topicPlayData;
    }
}
