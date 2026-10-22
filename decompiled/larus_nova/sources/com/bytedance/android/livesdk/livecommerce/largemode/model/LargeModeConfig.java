package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LargeModeConfig;", "Ljava/io/Serializable;", "configName", "", "componentName", "bigFontLevel", "bigFontScale", "data", "", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/ComponentLargeModeConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBigFontLevel", "()Ljava/lang/String;", "getBigFontScale", "getComponentName", "getConfigName", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LargeModeConfig implements Serializable {

    @SerializedName("big_font_level")
    private final String bigFontLevel;

    @SerializedName("big_font_scale")
    private final String bigFontScale;

    @SerializedName("component_name")
    private final String componentName;

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("data")
    private final List<ComponentLargeModeConfig> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LargeModeConfig copy$default(LargeModeConfig r100, String r101, String r102, String r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.configName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.componentName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bigFontLevel;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bigFontScale;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.data;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.configName;
    }

    public final String component2() {
        return this.componentName;
    }

    public final String component3() {
        return this.bigFontLevel;
    }

    public final String component4() {
        return this.bigFontScale;
    }

    public final List<ComponentLargeModeConfig> component5() {
        return this.data;
    }

    public final LargeModeConfig copy(String r100, String r101, String r110, String r111, List<ComponentLargeModeConfig> r112) {
        return new LargeModeConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LargeModeConfig) == false) goto L16;
        LargeModeConfig r101 = (LargeModeConfig) r100;
        if (Intrinsics.areEqual(this.configName, r101.configName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentName, r101.componentName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bigFontLevel, r101.bigFontLevel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bigFontScale, r101.bigFontScale) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.configName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bigFontLevel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bigFontScale;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ComponentLargeModeConfig> r113 = this.data;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "LargeModeConfig(configName=" + this.configName + ", componentName=" + this.componentName + ", bigFontLevel=" + this.bigFontLevel + ", bigFontScale=" + this.bigFontScale + ", data=" + this.data + ")";
    }

    public final String getBigFontLevel() {
        return this.bigFontLevel;
    }

    public final String getBigFontScale() {
        return this.bigFontScale;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final List<ComponentLargeModeConfig> getData() {
        return this.data;
    }

    public LargeModeConfig(String r100, String r101, String r102, String r103, List<ComponentLargeModeConfig> r104) {
        this.configName = r100;
        this.componentName = r101;
        this.bigFontLevel = r102;
        this.bigFontScale = r103;
        this.data = r104;
    }

    public /* synthetic */ LargeModeConfig(String r100, String r101, String r102, String r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
