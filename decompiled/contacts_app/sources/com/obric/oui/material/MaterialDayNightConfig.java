package com.obric.oui.material;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialDayNightConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/material/MaterialDayNightConfig;", "", "lightMaterials", "", "Lcom/obric/oui/material/MaterialConfig;", "darkMaterials", "([Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;)V", "getDarkMaterials", "()[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "getLightMaterials", "component1", "component2", "copy", "([Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialDayNightConfig;", "equals", "", "other", "getCurrent", "isLight", "(Z)[Lcom/obric/oui/material/MaterialConfig;", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialDayNightConfig {
    private final MaterialConfig[] darkMaterials;
    private final MaterialConfig[] lightMaterials;

    public static /* synthetic */ MaterialDayNightConfig copy$default(MaterialDayNightConfig r0, MaterialConfig[] r1, MaterialConfig[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.lightMaterials;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.darkMaterials;
    L9:
        return r0.copy(r1, r2);
    }

    public final MaterialConfig[] component1() {
        return this.lightMaterials;
    }

    public final MaterialConfig[] component2() {
        return this.darkMaterials;
    }

    public final MaterialDayNightConfig copy(MaterialConfig[] r1, MaterialConfig[] r2) {
        Intrinsics.checkNotNullParameter(r1, "lightMaterials");
        Intrinsics.checkNotNullParameter(r2, "darkMaterials");
        return new MaterialDayNightConfig(r1, r2);
    }

    public String toString() {
        return "MaterialDayNightConfig(lightMaterials=" + Arrays.toString(this.lightMaterials) + ", darkMaterials=" + Arrays.toString(this.darkMaterials) + ')';
    }

    public MaterialDayNightConfig(MaterialConfig[] r2, MaterialConfig[] r3) {
        Intrinsics.checkNotNullParameter(r2, "lightMaterials");
        Intrinsics.checkNotNullParameter(r3, "darkMaterials");
        this.lightMaterials = r2;
        this.darkMaterials = r3;
    }

    public final MaterialConfig[] getDarkMaterials() {
        return this.darkMaterials;
    }

    public final MaterialConfig[] getLightMaterials() {
        return this.lightMaterials;
    }

    public final MaterialConfig[] getCurrent(boolean r1) {
        if (r1 == false) goto L5;
        return this.lightMaterials;
    L5:
        return this.darkMaterials;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L21;
        MaterialDayNightConfig r6 = (MaterialDayNightConfig) r5;
        if (Arrays.equals(this.lightMaterials, r6.lightMaterials) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.darkMaterials, r6.darkMaterials) == true) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialDayNightConfig");
    L8:
        r2 = r5.getClass();
        goto L10
    }

    public int hashCode() {
        return (Arrays.hashCode(this.lightMaterials) * 31) + Arrays.hashCode(this.darkMaterials);
    }
}
