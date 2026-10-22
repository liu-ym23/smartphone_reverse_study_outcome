package au9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/bot/PresetBotTitleSegmentConfig;", "", "presetTitleSegmentEnable", "", "<init>", "(Z)V", "getPresetTitleSegmentEnable", "()Z", "setPresetTitleSegmentEnable", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    @SerializedName("preset_title_segment_enable")
    private boolean presetTitleSegmentEnable;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (this.presetTitleSegmentEnable == ((q) r100).presetTitleSegmentEnable) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.presetTitleSegmentEnable == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "PresetBotTitleSegmentConfig(presetTitleSegmentEnable=" + this.presetTitleSegmentEnable + ')';
    }

    public final boolean a() {
        return this.presetTitleSegmentEnable;
    }

    public q(int r100) {
        this.presetTitleSegmentEnable = false;
    }
}
