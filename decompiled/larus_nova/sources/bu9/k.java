package bu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/camera/CameraRecordFeatureConfig;", "", "enableTips", "", "recordMaxDuration", "", "enablePreviewRatio3to4", "longPressDurationMs", "<init>", "(ZIZI)V", "getEnableTips", "()Z", "getRecordMaxDuration", "()I", "getEnablePreviewRatio3to4", "getLongPressDurationMs", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("enable_preview_ratio_3_4")
    private final boolean enablePreviewRatio3to4;

    @SerializedName("enable_tips")
    private final boolean enableTips;

    @SerializedName("long_press_duration_ms")
    private final int longPressDurationMs;

    @SerializedName("record_max_duration")
    private final int recordMaxDuration;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.enableTips == r101.enableTips) goto L12;
        return false;
    L12:
        if (this.recordMaxDuration == r101.recordMaxDuration) goto L15;
        return false;
    L15:
        if (this.enablePreviewRatio3to4 == r101.enablePreviewRatio3to4) goto L18;
        return false;
    L18:
        if (this.longPressDurationMs == r101.longPressDurationMs) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableTips == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.recordMaxDuration) * 31;
        if (this.enablePreviewRatio3to4 == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.longPressDurationMs;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraRecordFeatureConfig(enableTips=" + this.enableTips + ", recordMaxDuration=" + this.recordMaxDuration + ", enablePreviewRatio3to4=" + this.enablePreviewRatio3to4 + ", longPressDurationMs=" + this.longPressDurationMs + ')';
    }

    public final boolean a() {
        return this.enablePreviewRatio3to4;
    }

    public final boolean b() {
        return this.enableTips;
    }

    public final int c() {
        return this.longPressDurationMs;
    }

    public final int d() {
        return this.recordMaxDuration;
    }

    public k(int r100) {
        this.enableTips = false;
        this.recordMaxDuration = 60;
        this.enablePreviewRatio3to4 = false;
        this.longPressDurationMs = 300;
    }
}
