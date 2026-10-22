package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.google.gson.annotations.SerializedName;
import hi2.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/ComponentLargeModeConfig;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "component2", "Lhi2/a;", "component3", "componentName", "layoutConfig", "textConfig", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getComponentName", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "getLayoutConfig", "()Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "Lhi2/a;", "getTextConfig", "()Lhi2/a;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;Lhi2/a;)V", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class ComponentLargeModeConfig implements Serializable {

    @SerializedName("component_name")
    private final String componentName;

    @SerializedName("layout")
    private final LayoutLargeModeConfig layoutConfig;

    @SerializedName("text")
    private final a textConfig;

    public static /* synthetic */ ComponentLargeModeConfig copy$default(ComponentLargeModeConfig r100, String r101, LayoutLargeModeConfig r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.componentName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.layoutConfig;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.componentName;
    }

    public final LayoutLargeModeConfig component2() {
        return this.layoutConfig;
    }

    public final a component3() {
        return this.textConfig;
    }

    public final ComponentLargeModeConfig copy(String r100, LayoutLargeModeConfig r101, a r102) {
        return new ComponentLargeModeConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ComponentLargeModeConfig) == false) goto L12;
        ComponentLargeModeConfig r101 = (ComponentLargeModeConfig) r100;
        if (Intrinsics.areEqual(this.componentName, r101.componentName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.layoutConfig, r101.layoutConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textConfig, r101.textConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.componentName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LayoutLargeModeConfig r104 = this.layoutConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.textConfig;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ComponentLargeModeConfig(componentName=" + this.componentName + ", layoutConfig=" + this.layoutConfig + ", textConfig=" + this.textConfig + ")";
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final LayoutLargeModeConfig getLayoutConfig() {
        return this.layoutConfig;
    }

    public final a getTextConfig() {
        return this.textConfig;
    }

    public ComponentLargeModeConfig(String r100, LayoutLargeModeConfig r101, a r102) {
        this.componentName = r100;
        this.layoutConfig = r101;
        this.textConfig = r102;
    }

    public /* synthetic */ ComponentLargeModeConfig(String r100, LayoutLargeModeConfig r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
