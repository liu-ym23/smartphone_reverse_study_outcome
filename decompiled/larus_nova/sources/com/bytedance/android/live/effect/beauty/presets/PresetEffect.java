package com.bytedance.android.live.effect.beauty.presets;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/PresetEffect;", "", "effectId", "", "name", "panel", "parameters", "", "Lcom/bytedance/android/live/effect/beauty/presets/EffectParameter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEffectId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getPanel", "getParameters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PresetEffect {
    private final String effectId;
    private String name;
    private final String panel;
    private final List<EffectParameter> parameters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresetEffect copy$default(PresetEffect r100, String r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.effectId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.panel;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.parameters;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.effectId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.panel;
    }

    public final List<EffectParameter> component4() {
        return this.parameters;
    }

    public final PresetEffect copy(String r100, String r101, String r102, List<EffectParameter> r103) {
        Intrinsics.checkNotNullParameter(r100, "effectId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "panel");
        Intrinsics.checkNotNullParameter(r103, "parameters");
        return new PresetEffect(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PresetEffect) == false) goto L14;
        PresetEffect r101 = (PresetEffect) r100;
        if (Intrinsics.areEqual(this.effectId, r101.effectId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.panel, r101.panel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parameters, r101.parameters) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.effectId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.panel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<EffectParameter> r110 = this.parameters;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PresetEffect(effectId=" + this.effectId + ", name=" + this.name + ", panel=" + this.panel + ", parameters=" + this.parameters + ")";
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPanel() {
        return this.panel;
    }

    public final List<EffectParameter> getParameters() {
        return this.parameters;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public PresetEffect(String r100, String r101, String r102, List<EffectParameter> r103) {
        Intrinsics.checkNotNullParameter(r100, "effectId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "panel");
        Intrinsics.checkNotNullParameter(r103, "parameters");
        this.effectId = r100;
        this.name = r101;
        this.panel = r102;
        this.parameters = r103;
    }
}
