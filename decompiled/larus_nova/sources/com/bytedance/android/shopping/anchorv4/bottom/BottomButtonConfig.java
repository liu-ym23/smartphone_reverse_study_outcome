package com.bytedance.android.shopping.anchorv4.bottom;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;", "Ljava/io/Serializable;", "needEnlarged", "", "clientScale", "fontScale", "fontScaleMaxRatio", "", "(Ljava/lang/Boolean;ZZF)V", "getClientScale", "()Z", "getFontScale", "getFontScaleMaxRatio", "()F", "getNeedEnlarged", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;ZZF)Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonConfig implements Serializable {

    @SerializedName("client_scale")
    private final boolean clientScale;

    @SerializedName("font_scale")
    private final boolean fontScale;

    @SerializedName("font_scale_max_ratio")
    private final float fontScaleMaxRatio;

    @SerializedName("need_enlarged")
    private final Boolean needEnlarged;

    public BottomButtonConfig() {
        this(null, false, false, 0.0f, 15, null);
    }

    public static /* synthetic */ BottomButtonConfig copy$default(BottomButtonConfig r100, Boolean r101, boolean r102, boolean r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.needEnlarged;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.clientScale;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.fontScale;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fontScaleMaxRatio;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Boolean component1() {
        return this.needEnlarged;
    }

    public final boolean component2() {
        return this.clientScale;
    }

    public final boolean component3() {
        return this.fontScale;
    }

    public final float component4() {
        return this.fontScaleMaxRatio;
    }

    public final BottomButtonConfig copy(Boolean r100, boolean r101, boolean r102, float r103) {
        return new BottomButtonConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomButtonConfig) == false) goto L14;
        BottomButtonConfig r101 = (BottomButtonConfig) r100;
        if (Intrinsics.areEqual(this.needEnlarged, r101.needEnlarged) == true) goto L8;
        return false;
    L8:
        if (this.clientScale == r101.clientScale) goto L10;
        return false;
    L10:
        if (this.fontScale == r101.fontScale) goto L12;
        return false;
    L12:
        if (Float.compare(this.fontScaleMaxRatio, r101.fontScaleMaxRatio) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Boolean r100 = this.needEnlarged;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.clientScale;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.fontScale;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return ((r106 + r104) * 31) + Float.floatToIntBits(this.fontScaleMaxRatio);
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "BottomButtonConfig(needEnlarged=" + this.needEnlarged + ", clientScale=" + this.clientScale + ", fontScale=" + this.fontScale + ", fontScaleMaxRatio=" + this.fontScaleMaxRatio + ")";
    }

    public final boolean getClientScale() {
        return this.clientScale;
    }

    public final boolean getFontScale() {
        return this.fontScale;
    }

    public final float getFontScaleMaxRatio() {
        return this.fontScaleMaxRatio;
    }

    public final Boolean getNeedEnlarged() {
        return this.needEnlarged;
    }

    public BottomButtonConfig(Boolean r100, boolean r101, boolean r102, float r103) {
        this.needEnlarged = r100;
        this.clientScale = r101;
        this.fontScale = r102;
        this.fontScaleMaxRatio = r103;
    }

    public /* synthetic */ BottomButtonConfig(Boolean r100, boolean r101, boolean r102, float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 1.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
