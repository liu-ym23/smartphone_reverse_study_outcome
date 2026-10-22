package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/d2;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "newWidgetEnable", "d", "setNewWidgetEnable", "guideShowTimingOpt", "c", "setGuideShowTimingOpt", "guideShowStyleOpt", "getGuideShowStyleOpt", "setGuideShowStyleOpt", "", "stay_time", "I", "e", "()I", "setStay_time", "(I)V", "access_tablive_interval", "getAccess_tablive_interval", "setAccess_tablive_interval", "finish_tablive_enable", "b", "setFinish_tablive_enable", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d2 {

    @SerializedName("access_tablive_interval")
    private int access_tablive_interval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("finish_tablive_enable")
    private boolean finish_tablive_enable;

    @SerializedName("guide_show_style_opt")
    private boolean guideShowStyleOpt;

    @SerializedName("guide_show_timing_opt")
    private boolean guideShowTimingOpt;

    @SerializedName("new_widget_enable")
    private boolean newWidgetEnable;

    @SerializedName("stay_time")
    private int stay_time;

    public d2() {
        this.stay_time = 10000;
        this.access_tablive_interval = 7;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.finish_tablive_enable;
    }

    public final boolean c() {
        return this.guideShowTimingOpt;
    }

    public final boolean d() {
        return this.newWidgetEnable;
    }

    public final int e() {
        return this.stay_time;
    }
}
