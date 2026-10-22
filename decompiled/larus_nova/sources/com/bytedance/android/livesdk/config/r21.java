package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/r21;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "loggerOpt", "b", "setLoggerOpt", "vsOpt", "c", "setVsOpt", "gameOpt", "getGameOpt", "setGameOpt", "anchorOpt", "getAnchorOpt", "setAnchorOpt", "desktopOpt", "getDesktopOpt", "setDesktopOpt", "viewOpt", "getViewOpt", "setViewOpt", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r21 {

    @SerializedName("anchor_opt")
    private boolean anchorOpt;

    @SerializedName("desktop_opt")
    private boolean desktopOpt;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("game_opt")
    private boolean gameOpt;

    @SerializedName("logger_opt")
    private boolean loggerOpt;

    @SerializedName("view_opt")
    private boolean viewOpt;

    @SerializedName("vs_opt")
    private boolean vsOpt;

    public r21() {
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.loggerOpt;
    }

    public final boolean c() {
        return this.vsOpt;
    }
}
