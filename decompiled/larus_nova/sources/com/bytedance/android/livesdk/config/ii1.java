package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/config/ii1;", "", "", "type", "I", "getType", "()I", "landscapeDefault", "getLandscapeDefault", "", "guideDelay", "J", "getGuideDelay", "()J", "", "Lcom/bytedance/android/livesdk/config/d3;", "durationConfig", "Ljava/util/List;", "getDurationConfig", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/config/u0;", "backgroundOpacityConfig", "Lcom/bytedance/android/livesdk/config/u0;", "getBackgroundOpacityConfig", "()Lcom/bytedance/android/livesdk/config/u0;", "Lcom/bytedance/android/livesdk/config/gh1;", "fullPanelSize", "Lcom/bytedance/android/livesdk/config/gh1;", "getFullPanelSize", "()Lcom/bytedance/android/livesdk/config/gh1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ii1 {

    @SerializedName("background_opacity")
    private final u0 backgroundOpacityConfig;

    @SerializedName("duration_configs")
    private final List<d3> durationConfig;

    @SerializedName("full_panel_size")
    private final gh1 fullPanelSize;

    @SerializedName("guide_delay")
    private final long guideDelay;

    @SerializedName("landscape_default")
    private final int landscapeDefault;

    @SerializedName("type")
    private final int type;

    public static final class a {
    }

    static {
    }

    public ii1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ii1) == false) goto L18;
        ii1 r101 = (ii1) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (this.landscapeDefault == r101.landscapeDefault) goto L10;
        return false;
    L10:
        if (this.guideDelay == r101.guideDelay) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.durationConfig, r101.durationConfig) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundOpacityConfig, r101.backgroundOpacityConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fullPanelSize, r101.fullPanelSize) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.type * 31) + this.landscapeDefault) * 31;
        long r101 = this.guideDelay;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        List<d3> r103 = this.durationConfig;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        u0 r107 = this.backgroundOpacityConfig;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        gh1 r110 = this.fullPanelSize;
        if (r110 == null) goto L14;
        r104 = r110.hashCode();
    L14:
        return r109 + r104;
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "UIStyle(type=" + this.type + ", landscapeDefault=" + this.landscapeDefault + ", guideDelay=" + this.guideDelay + ", durationConfig=" + this.durationConfig + ", backgroundOpacityConfig=" + this.backgroundOpacityConfig + ", fullPanelSize=" + this.fullPanelSize + ")";
    }

    public final int getType() {
        return this.type;
    }

    public ii1(Object r100) {
        ArrayList r101 = new ArrayList();
        u0 r102 = new u0(0);
        gh1 r103 = new gh1(0);
        Intrinsics.checkNotNullParameter(r101, "durationConfig");
        this.type = 3;
        this.landscapeDefault = 0;
        this.guideDelay = 0;
        this.durationConfig = r101;
        this.backgroundOpacityConfig = r102;
        this.fullPanelSize = r103;
    }
}
