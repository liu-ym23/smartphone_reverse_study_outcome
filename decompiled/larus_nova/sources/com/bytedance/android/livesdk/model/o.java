package com.bytedance.android.livesdk.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/model/o;", "", "", "panelResourceUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setPanelResourceUrl", "(Ljava/lang/String;)V", "imResourceUrl", "b", "setImResourceUrl", "", "showCountWholeLive", "I", ce.f26391f, "()I", "setShowCountWholeLive", "(I)V", "bubbleShowMaxCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBubbleShowMaxCount", "panelPlaceholderText", "c", "setPanelPlaceholderText", "panelTitleText", "e", "setPanelTitleText", "shareAnimationInterval", "f", "setShareAnimationInterval", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("bubble_show_max_count")
    private int bubbleShowMaxCount;

    @SerializedName("im_resource_url")
    private String imResourceUrl;

    @SerializedName("panel_placeholder_text")
    private String panelPlaceholderText;

    @SerializedName("panel_resource_url")
    private String panelResourceUrl;

    @SerializedName("panel_title_text")
    private String panelTitleText;

    @SerializedName("share_animation_interval")
    private int shareAnimationInterval;

    @SerializedName("show_count_whole_live")
    private int showCountWholeLive;

    public o() {
        this.panelResourceUrl = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fans_group_share_resource_panel.png";
        this.imResourceUrl = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fans_group_share_resource_im.png";
        this.showCountWholeLive = 2;
        this.bubbleShowMaxCount = 3;
        this.panelPlaceholderText = "快来直播间和pk主播一起玩耍吧";
        this.panelTitleText = "已为你选中粉丝群，一键召唤粉丝";
        this.shareAnimationInterval = 10;
    }

    public final int a() {
        return this.bubbleShowMaxCount;
    }

    public final String b() {
        return this.imResourceUrl;
    }

    public final String c() {
        return this.panelPlaceholderText;
    }

    public final String d() {
        return this.panelResourceUrl;
    }

    public final String e() {
        return this.panelTitleText;
    }

    public final int f() {
        return this.shareAnimationInterval;
    }

    public final int g() {
        return this.showCountWholeLive;
    }
}
