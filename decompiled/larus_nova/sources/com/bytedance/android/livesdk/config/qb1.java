package com.bytedance.android.livesdk.config;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/qb1;", "", "", "isEnable", "Z", com.amap.api.col.s.ce.f26391f, "()Z", "setEnable", "(Z)V", "isMixConfigCanvas", "h", "setMixConfigCanvas", "isAudioBackgroundClip", "d", "setAudioBackgroundClip", "isClipByShowPlayer", "e", "setClipByShowPlayer", "isDisableMp4Background", "f", "setDisableMp4Background", "radioBgClipOpt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setRadioBgClipOpt", "uiLayoutSupportListOpt", "c", "setUiLayoutSupportListOpt", "", "", "uiLayoutSupportList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUiLayoutSupportList", "(Ljava/util/List;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class qb1 {

    @SerializedName("is_audio_background_clip")
    private boolean isAudioBackgroundClip;

    @SerializedName("is_clip_by_show_player")
    private boolean isClipByShowPlayer;

    @SerializedName("is_disable_mp4_background")
    private boolean isDisableMp4Background;

    @SerializedName(MapMonitorConst.IS_ENABLE)
    private boolean isEnable;

    @SerializedName("is_mix_config_canvas")
    private boolean isMixConfigCanvas;

    @SerializedName("radio_bg_clip_opt")
    private boolean radioBgClipOpt;

    @SerializedName("ui_layout_support_list")
    private List<String> uiLayoutSupportList;

    @SerializedName("ui_layout_support_list_opt")
    private boolean uiLayoutSupportListOpt;

    public qb1() {
        this.isEnable = true;
        this.isMixConfigCanvas = true;
        this.isAudioBackgroundClip = true;
        this.isClipByShowPlayer = true;
        this.isDisableMp4Background = true;
        this.radioBgClipOpt = true;
        this.uiLayoutSupportListOpt = true;
        this.uiLayoutSupportList = CollectionsKt.mutableListOf(new String[]{"27", BDLocationException.ERROR_SDK_NO_PERMISSION});
    }

    public final boolean a() {
        return this.radioBgClipOpt;
    }

    public final List<String> b() {
        return this.uiLayoutSupportList;
    }

    public final boolean c() {
        return this.uiLayoutSupportListOpt;
    }

    public final boolean d() {
        return this.isAudioBackgroundClip;
    }

    public final boolean e() {
        return this.isClipByShowPlayer;
    }

    public final boolean f() {
        return this.isDisableMp4Background;
    }

    public final boolean g() {
        return this.isEnable;
    }

    public final boolean h() {
        return this.isMixConfigCanvas;
    }
}
