package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/config/r4;", "", "", "topDesc", "Ljava/lang/String;", com.amap.api.col.s.ce.f26395j, "()Ljava/lang/String;", "dragDown", "c", "bottomDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dragUp", "e", "", "singleRoom", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "enterFromMerge", "f", "enterMethod", com.amap.api.col.s.ce.f26391f, "", "dragStyle", "I", "d", "()I", "hasMoreFix", "h", "canNotContinueLoadmore", "b", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r4 {

    @SerializedName("bottom_desc")
    private final String bottomDesc;

    @SerializedName("can_not_loadmore_continue")
    private final boolean canNotContinueLoadmore;

    @SerializedName("drag_down")
    private final String dragDown;

    @SerializedName("drag_style")
    private final int dragStyle;

    @SerializedName("drag_up")
    private final String dragUp;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("has_more_fix")
    private final boolean hasMoreFix;

    @SerializedName("single_room")
    private final boolean singleRoom;

    @SerializedName("top_desc")
    private final String topDesc;

    public r4() {
        this.topDesc = "";
        this.dragDown = "";
        this.bottomDesc = "";
        this.dragUp = "";
        this.enterFromMerge = "";
        this.enterMethod = "";
        this.hasMoreFix = true;
    }

    public final String a() {
        return this.bottomDesc;
    }

    public final boolean b() {
        return this.canNotContinueLoadmore;
    }

    public final String c() {
        return this.dragDown;
    }

    public final int d() {
        return this.dragStyle;
    }

    public final String e() {
        return this.dragUp;
    }

    public final String f() {
        return this.enterFromMerge;
    }

    public final String g() {
        return this.enterMethod;
    }

    public final boolean h() {
        return this.hasMoreFix;
    }

    public final boolean i() {
        return this.singleRoom;
    }

    public final String j() {
        return this.topDesc;
    }
}
