package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/q11;", "", "", "enableBgPlayOpt", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableBgPlayOpt", "(Z)V", "fixPushUI", "f", "setFixPushUI", "enablePushOpt", "d", "setEnablePushOpt", "enablePlayStatusOpt", "c", "setEnablePlayStatusOpt", "fixPlayerLifecycle", "e", "setFixPlayerLifecycle", "enableObPlay", "b", "setEnableObPlay", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q11 {

    @SerializedName("enable_bg_play_opt")
    private boolean enableBgPlayOpt;

    @SerializedName("enable_ob_play")
    private boolean enableObPlay;

    @SerializedName("enable_play_status_opt")
    private boolean enablePlayStatusOpt;

    @SerializedName("enable_push_show_opt")
    private boolean enablePushOpt;

    @SerializedName("fix_player_lifecycle")
    private boolean fixPlayerLifecycle;

    @SerializedName("fix_push_ui")
    private boolean fixPushUI;

    public q11() {
    }

    public final boolean a() {
        return this.enableBgPlayOpt;
    }

    public final boolean b() {
        return this.enableObPlay;
    }

    public final boolean c() {
        return this.enablePlayStatusOpt;
    }

    public final boolean d() {
        return this.enablePushOpt;
    }

    public final boolean e() {
        return this.fixPlayerLifecycle;
    }

    public final boolean f() {
        return this.fixPushUI;
    }
}
