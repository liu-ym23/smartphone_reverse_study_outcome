package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/y21;", "", "", "totalOptEnable", "Z", "ktvEnable", "resultOptEnable", "slideOptEnable", "shakeMatchEnable", "", "fastMatchLinkingAnimUrl", "Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y21 {

    @SerializedName("fast_match_linking_anim_url")
    private String fastMatchLinkingAnimUrl;

    @SerializedName("ktv_enable")
    private boolean ktvEnable;

    @SerializedName("result_opt_enable")
    private boolean resultOptEnable;

    @SerializedName("shake_match_enable")
    private boolean shakeMatchEnable;

    @SerializedName("slide_opt_enable")
    private boolean slideOptEnable;

    @SerializedName("total_opt_enable")
    private boolean totalOptEnable;

    public final boolean a() {
        if (this.totalOptEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.ktvEnable == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.totalOptEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.resultOptEnable == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (this.totalOptEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.shakeMatchEnable == false) goto L7;
        return true;
    }

    public final boolean d() {
        if (this.totalOptEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.slideOptEnable == false) goto L7;
        return true;
    }

    public y21() {
        this.ktvEnable = true;
        this.slideOptEnable = true;
        this.shakeMatchEnable = true;
        this.fastMatchLinkingAnimUrl = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_voice_linking_anim.webp";
    }

    public final boolean e() {
        return this.totalOptEnable;
    }
}
