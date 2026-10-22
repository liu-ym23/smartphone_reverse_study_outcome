package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/u;", "", "", "enableFetchMessage", "Z", "e", "()Z", "setEnableFetchMessage", "(Z)V", "enableEnterAnimation", "c", "setEnableEnterAnimation", "enableEnterMessageClear", "d", "setEnableEnterMessageClear", "enablePublicScreen", "f", "setEnablePublicScreen", "enablePublicScreenClear", ce.f26391f, "setEnablePublicScreenClear", "enableAudienceRank", "b", "setEnableAudienceRank", "enableAnchorInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableAnchorInfo", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("enable_anchor_info")
    private boolean enableAnchorInfo;

    @SerializedName("enable_audience_rank")
    private boolean enableAudienceRank;

    @SerializedName("enable_enter_animation")
    private boolean enableEnterAnimation;

    @SerializedName("enable_enter_message_clear")
    private boolean enableEnterMessageClear;

    @SerializedName("enable_fetch_message")
    private boolean enableFetchMessage;

    @SerializedName("enable_public_screen")
    private boolean enablePublicScreen;

    @SerializedName("enable_public_screen_clear")
    private boolean enablePublicScreenClear;

    public u() {
        this.enableFetchMessage = true;
        this.enableEnterAnimation = true;
        this.enableEnterMessageClear = true;
        this.enablePublicScreen = true;
        this.enablePublicScreenClear = true;
        this.enableAudienceRank = true;
        this.enableAnchorInfo = true;
    }

    public final boolean a() {
        return this.enableAnchorInfo;
    }

    public final boolean b() {
        return this.enableAudienceRank;
    }

    public final boolean c() {
        return this.enableEnterAnimation;
    }

    public final boolean d() {
        return this.enableEnterMessageClear;
    }

    public final boolean e() {
        return this.enableFetchMessage;
    }

    public final boolean f() {
        return this.enablePublicScreen;
    }

    public final boolean g() {
        return this.enablePublicScreenClear;
    }
}
