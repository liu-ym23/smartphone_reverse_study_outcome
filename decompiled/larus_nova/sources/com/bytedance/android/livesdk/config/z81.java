package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/z81;", "", "", "alignNewPanelEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAlignNewPanelEnable", "(Z)V", "clickJumpLoginEnable", "e", "setClickJumpLoginEnable", "autoGuideLoginEnable", "getAutoGuideLoginEnable", "setAutoGuideLoginEnable", "", "autoGuideLoginCount", "I", "b", "()I", "setAutoGuideLoginCount", "(I)V", "autoGuideLoginPlayTime", "c", "setAutoGuideLoginPlayTime", "", "", "autoGuideLoginPlayTitle", "Ljava/util/List;", "d", "()Ljava/util/List;", "setAutoGuideLoginPlayTitle", "(Ljava/util/List;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z81 {

    @SerializedName("align_new_panel_enable")
    private boolean alignNewPanelEnable;

    @SerializedName("auto_guide_login_count")
    private int autoGuideLoginCount;

    @SerializedName("auto_guide_login_enable")
    private boolean autoGuideLoginEnable;

    @SerializedName("auto_guide_login_play_time")
    private int autoGuideLoginPlayTime;

    @SerializedName("auto_guide_login_title")
    private List<String> autoGuideLoginPlayTitle;

    @SerializedName("click_jump_login_enable")
    private boolean clickJumpLoginEnable;

    public z81() {
        this.autoGuideLoginCount = 3;
        this.autoGuideLoginPlayTime = 10;
        this.autoGuideLoginPlayTitle = CollectionsKt.listOf("登录后，优化你的直播推荐体验");
    }

    public final boolean a() {
        return this.alignNewPanelEnable;
    }

    public final int b() {
        return this.autoGuideLoginCount;
    }

    public final int c() {
        return this.autoGuideLoginPlayTime;
    }

    public final List<String> d() {
        return this.autoGuideLoginPlayTitle;
    }

    public final boolean e() {
        return this.clickJumpLoginEnable;
    }
}
