package com.bytedance.android.live.effect.beauty.presets;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u001b\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/BeautifyPreset;", "", "presetId", "", "presetName", "beautyEnabled", "", "bodyEnabled", "effectsByPanel", "", "", "Lcom/bytedance/android/live/effect/beauty/presets/PresetEffect;", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "getBeautyEnabled", "()Z", "getBodyEnabled", "getEffectsByPanel", "()Ljava/util/Map;", "setEffectsByPanel", "(Ljava/util/Map;)V", "getPresetId", "()Ljava/lang/String;", "getPresetName", "setPresetName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyPreset {
    private final boolean beautyEnabled;
    private final boolean bodyEnabled;
    private Map<String, ? extends List<PresetEffect>> effectsByPanel;
    private final String presetId;
    private String presetName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeautifyPreset copy$default(BeautifyPreset r100, String r101, String r102, boolean r103, boolean r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.presetId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.presetName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.beautyEnabled;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bodyEnabled;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.effectsByPanel;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.presetId;
    }

    public final String component2() {
        return this.presetName;
    }

    public final boolean component3() {
        return this.beautyEnabled;
    }

    public final boolean component4() {
        return this.bodyEnabled;
    }

    public final Map<String, List<PresetEffect>> component5() {
        return this.effectsByPanel;
    }

    public final BeautifyPreset copy(String r100, String r101, boolean r110, boolean r111, Map<String, ? extends List<PresetEffect>> r112) {
        Intrinsics.checkNotNullParameter(r100, "presetId");
        Intrinsics.checkNotNullParameter(r101, "presetName");
        Intrinsics.checkNotNullParameter(r112, "effectsByPanel");
        return new BeautifyPreset(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BeautifyPreset) == false) goto L16;
        BeautifyPreset r101 = (BeautifyPreset) r100;
        if (Intrinsics.areEqual(this.presetId, r101.presetId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.presetName, r101.presetName) == true) goto L10;
        return false;
    L10:
        if (this.beautyEnabled == r101.beautyEnabled) goto L12;
        return false;
    L12:
        if (this.bodyEnabled == r101.bodyEnabled) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.effectsByPanel, r101.effectsByPanel) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.presetId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.presetName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.beautyEnabled;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.bodyEnabled;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (r110 + r108) * 31;
        Map<String, ? extends List<PresetEffect>> r113 = this.effectsByPanel;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BeautifyPreset(presetId=" + this.presetId + ", presetName=" + this.presetName + ", beautyEnabled=" + this.beautyEnabled + ", bodyEnabled=" + this.bodyEnabled + ", effectsByPanel=" + this.effectsByPanel + ")";
    }

    public final boolean getBeautyEnabled() {
        return this.beautyEnabled;
    }

    public final boolean getBodyEnabled() {
        return this.bodyEnabled;
    }

    public final Map<String, List<PresetEffect>> getEffectsByPanel() {
        return this.effectsByPanel;
    }

    public final String getPresetId() {
        return this.presetId;
    }

    public final String getPresetName() {
        return this.presetName;
    }

    public final void setEffectsByPanel(Map<String, ? extends List<PresetEffect>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.effectsByPanel = r100;
    }

    public final void setPresetName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.presetName = r100;
    }

    public BeautifyPreset(String r100, String r101, boolean r102, boolean r103, Map<String, ? extends List<PresetEffect>> r104) {
        Intrinsics.checkNotNullParameter(r100, "presetId");
        Intrinsics.checkNotNullParameter(r101, "presetName");
        Intrinsics.checkNotNullParameter(r104, "effectsByPanel");
        this.presetId = r100;
        this.presetName = r101;
        this.beautyEnabled = r102;
        this.bodyEnabled = r103;
        this.effectsByPanel = r104;
    }
}
