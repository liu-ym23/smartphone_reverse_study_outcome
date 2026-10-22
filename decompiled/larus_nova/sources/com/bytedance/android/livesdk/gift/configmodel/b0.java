package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/b0;", "", "", "disableProgressThread", "Z", "disableTextureRenderer", "disableSRInit", "requestRenderOpt", "", "playThreadPriority", "I", "glThreadPriority", "disableAudioHardDecode", "", "jankThreshold", "J", "bigJankThreshold", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("big_jank_threshold")
    public long bigJankThreshold;

    @SerializedName("disable_audio_hard_decode")
    public boolean disableAudioHardDecode;

    @SerializedName("disable_progress_thread")
    public boolean disableProgressThread;

    @SerializedName("disable_sr_init")
    public boolean disableSRInit;

    @SerializedName("disable_texture_renderer")
    public boolean disableTextureRenderer;

    @SerializedName("gl_thread_priority")
    public int glThreadPriority;

    @SerializedName("jank_threshold")
    public long jankThreshold;

    @SerializedName("play_thread_priority")
    public int playThreadPriority;

    @SerializedName("request_render_opt")
    public boolean requestRenderOpt;

    public b0() {
        this.playThreadPriority = 10;
        this.jankThreshold = 83;
        this.bigJankThreshold = 125;
    }
}
