package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "Ljava/io/Serializable;", "hideFullMode", "", "hideHalfMode", "clientScale", "fontScale", "fontScaleMaxRatio", "", "disableLoad", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/Float;Z)V", "getClientScale", "()Z", "getDisableLoad", "getFontScale", "getFontScaleMaxRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHideFullMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideHalfMode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/Float;Z)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfigMode implements Serializable {

    @SerializedName("client_scale")
    private final boolean clientScale;

    @SerializedName("disable_load")
    private final boolean disableLoad;

    @SerializedName("font_scale")
    private final boolean fontScale;

    @SerializedName("font_scale_max_ratio")
    private final Float fontScaleMaxRatio;

    @SerializedName("hide_full_mode")
    private final Boolean hideFullMode;

    @SerializedName("hide_half_mode")
    private final Boolean hideHalfMode;

    public ConfigMode() {
        this(null, null, false, false, null, false, 63, null);
    }

    public static /* synthetic */ ConfigMode copy$default(ConfigMode r100, Boolean r101, Boolean r102, boolean r103, boolean r104, Float r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.hideFullMode;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.hideHalfMode;
    L8:
        Boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.clientScale;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.fontScale;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.fontScaleMaxRatio;
    L17:
        Float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.disableLoad;
    L20:
        Boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Boolean component1() {
        return this.hideFullMode;
    }

    public final Boolean component2() {
        return this.hideHalfMode;
    }

    public final boolean component3() {
        return this.clientScale;
    }

    public final boolean component4() {
        return this.fontScale;
    }

    public final Float component5() {
        return this.fontScaleMaxRatio;
    }

    public final boolean component6() {
        return this.disableLoad;
    }

    public final ConfigMode copy(Boolean r100, Boolean r110, boolean r111, boolean r112, Float r113, boolean r114) {
        return new ConfigMode(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ConfigMode) == false) goto L18;
        ConfigMode r101 = (ConfigMode) r100;
        if (Intrinsics.areEqual(this.hideFullMode, r101.hideFullMode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hideHalfMode, r101.hideHalfMode) == true) goto L10;
        return false;
    L10:
        if (this.clientScale == r101.clientScale) goto L12;
        return false;
    L12:
        if (this.fontScale == r101.fontScale) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontScaleMaxRatio, r101.fontScaleMaxRatio) == true) goto L16;
        return false;
    L16:
        if (this.disableLoad == r101.disableLoad) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Boolean r100 = this.hideFullMode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hideHalfMode;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.clientScale;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.fontScale;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        Float r114 = this.fontScaleMaxRatio;
        if (r114 == null) goto L19;
        r101 = r114.hashCode();
    L19:
        int r115 = (r113 + r101) * 31;
        boolean r116 = this.disableLoad;
        if (r116 == true) goto L24;
        r108 = r116;
    L24:
        return r115 + r108;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ConfigMode(hideFullMode=" + this.hideFullMode + ", hideHalfMode=" + this.hideHalfMode + ", clientScale=" + this.clientScale + ", fontScale=" + this.fontScale + ", fontScaleMaxRatio=" + this.fontScaleMaxRatio + ", disableLoad=" + this.disableLoad + ")";
    }

    public final boolean getClientScale() {
        return this.clientScale;
    }

    public final boolean getDisableLoad() {
        return this.disableLoad;
    }

    public final boolean getFontScale() {
        return this.fontScale;
    }

    public final Float getFontScaleMaxRatio() {
        return this.fontScaleMaxRatio;
    }

    public final Boolean getHideFullMode() {
        return this.hideFullMode;
    }

    public final Boolean getHideHalfMode() {
        return this.hideHalfMode;
    }

    public ConfigMode(Boolean r100, Boolean r101, boolean r102, boolean r103, Float r104, boolean r105) {
        this.hideFullMode = r100;
        this.hideHalfMode = r101;
        this.clientScale = r102;
        this.fontScale = r103;
        this.fontScaleMaxRatio = r104;
        this.disableLoad = r105;
    }

    public /* synthetic */ ConfigMode(Boolean r100, Boolean r101, boolean r102, boolean r103, Float r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        Boolean r113 = r101;
        boolean r105 = false;
        if ((r111 & 4) == 0) goto L11;
        boolean r106 = false;
    L13:
        if ((r111 & 8) == 0) goto L15;
        boolean r107 = false;
    L17:
        if ((r111 & 16) == 0) goto L19;
        r104 = null;
    L19:
        Float r108 = r104;
        if ((r111 & 32) != 0) goto L23;
        r105 = r110;
    L23:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L15:
        r107 = r103;
        goto L17
    L11:
        r106 = r102;
        goto L13
    }
}
