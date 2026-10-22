package com.bytedance.android.shopping.anchorv4.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JF\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "Ljava/io/Serializable;", "clientScale", "", "fontScale", "fontScaleMaxRatio", "", "anchorContainer", "", "showDependsOn", "(ZZLjava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorContainer", "()Ljava/lang/String;", "getClientScale", "()Z", "getFontScale", "getFontScaleMaxRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getShowDependsOn", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZLjava/lang/Float;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfigModel implements Serializable {

    @SerializedName("anchor_container")
    private final String anchorContainer;

    @SerializedName("client_scale")
    private final boolean clientScale;

    @SerializedName("font_scale")
    private final boolean fontScale;

    @SerializedName("font_scale_max_ratio")
    private final Float fontScaleMaxRatio;

    @SerializedName("show_depends_on")
    private final String showDependsOn;

    public ConfigModel() {
        this(false, false, null, null, null, 31, null);
    }

    public static /* synthetic */ ConfigModel copy$default(ConfigModel r100, boolean r101, boolean r102, Float r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.clientScale;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.fontScale;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.fontScaleMaxRatio;
    L11:
        Float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.anchorContainer;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.showDependsOn;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.clientScale;
    }

    public final boolean component2() {
        return this.fontScale;
    }

    public final Float component3() {
        return this.fontScaleMaxRatio;
    }

    public final String component4() {
        return this.anchorContainer;
    }

    public final String component5() {
        return this.showDependsOn;
    }

    public final ConfigModel copy(boolean r100, boolean r101, Float r110, String r111, String r112) {
        return new ConfigModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ConfigModel) == false) goto L16;
        ConfigModel r101 = (ConfigModel) r100;
        if (this.clientScale == r101.clientScale) goto L8;
        return false;
    L8:
        if (this.fontScale == r101.fontScale) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontScaleMaxRatio, r101.fontScaleMaxRatio) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorContainer, r101.anchorContainer) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showDependsOn, r101.showDependsOn) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public int hashCode() {
        boolean r100 = this.clientScale;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.fontScale;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        Float r106 = this.fontScaleMaxRatio;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        String r110 = this.anchorContainer;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.showDependsOn;
        if (r113 == null) goto L21;
        r107 = r113.hashCode();
    L21:
        return r112 + r107;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public String toString() {
        return "ConfigModel(clientScale=" + this.clientScale + ", fontScale=" + this.fontScale + ", fontScaleMaxRatio=" + this.fontScaleMaxRatio + ", anchorContainer=" + this.anchorContainer + ", showDependsOn=" + this.showDependsOn + ")";
    }

    public final String getAnchorContainer() {
        return this.anchorContainer;
    }

    public final boolean getClientScale() {
        return this.clientScale;
    }

    public final boolean getFontScale() {
        return this.fontScale;
    }

    public final Float getFontScaleMaxRatio() {
        return this.fontScaleMaxRatio;
    }

    public final String getShowDependsOn() {
        return this.showDependsOn;
    }

    public ConfigModel(boolean r100, boolean r101, Float r102, String r103, String r104) {
        this.clientScale = r100;
        this.fontScale = r101;
        this.fontScaleMaxRatio = r102;
        this.anchorContainer = r103;
        this.showDependsOn = r104;
    }

    public /* synthetic */ ConfigModel(boolean r100, boolean r101, Float r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        boolean r106 = false;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = false;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        Float r107 = null;
    L15:
        if ((r105 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        String r109 = null;
    L22:
        this(r111, r106, r107, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
