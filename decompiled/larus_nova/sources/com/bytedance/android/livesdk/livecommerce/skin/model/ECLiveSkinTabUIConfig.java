package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tHÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTabUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "selected", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "unselected", "disabled", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Ljava/util/List;)V", "getDisabled", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "getRadius", "()Ljava/util/List;", "getSelected", "getUnselected", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinTabUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("disabled")
    private final ECLiveSkinBaseViewUIConfig disabled;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("selected")
    private final ECLiveSkinBaseViewUIConfig selected;

    @SerializedName("unselected")
    private final ECLiveSkinBaseViewUIConfig unselected;

    public ECLiveSkinTabUIConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinTabUIConfig copy$default(ECLiveSkinTabUIConfig r100, ECLiveSkinBaseViewUIConfig r101, ECLiveSkinBaseViewUIConfig r102, ECLiveSkinBaseViewUIConfig r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.selected;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.unselected;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.disabled;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.getRadius();
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ECLiveSkinBaseViewUIConfig component1() {
        return this.selected;
    }

    public final ECLiveSkinBaseViewUIConfig component2() {
        return this.unselected;
    }

    public final ECLiveSkinBaseViewUIConfig component3() {
        return this.disabled;
    }

    public final List<Integer> component4() {
        return getRadius();
    }

    public final ECLiveSkinTabUIConfig copy(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, ECLiveSkinBaseViewUIConfig r102, List<Integer> r103) {
        return new ECLiveSkinTabUIConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinTabUIConfig) == false) goto L14;
        ECLiveSkinTabUIConfig r101 = (ECLiveSkinTabUIConfig) r100;
        if (Intrinsics.areEqual(this.selected, r101.selected) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unselected, r101.unselected) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getRadius(), r101.getRadius()) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        ECLiveSkinBaseViewUIConfig r100 = this.selected;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECLiveSkinBaseViewUIConfig r104 = this.unselected;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECLiveSkinBaseViewUIConfig r107 = this.disabled;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = getRadius();
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
        return "ECLiveSkinTabUIConfig(selected=" + this.selected + ", unselected=" + this.unselected + ", disabled=" + this.disabled + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBaseViewUIConfig getDisabled() {
        return this.disabled;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final ECLiveSkinBaseViewUIConfig getSelected() {
        return this.selected;
    }

    public final ECLiveSkinBaseViewUIConfig getUnselected() {
        return this.unselected;
    }

    public ECLiveSkinTabUIConfig(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, ECLiveSkinBaseViewUIConfig r102, List<Integer> r103) {
        this.selected = r100;
        this.unselected = r101;
        this.disabled = r102;
        this.radius = r103;
    }

    public /* synthetic */ ECLiveSkinTabUIConfig(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, ECLiveSkinBaseViewUIConfig r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
