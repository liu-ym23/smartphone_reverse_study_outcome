package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bHÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBtnUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "enabled", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "disabled", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Ljava/util/List;)V", "getDisabled", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "getEnabled", "getRadius", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBtnUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("disabled")
    private final ECLiveSkinBaseViewUIConfig disabled;

    @SerializedName("enabled")
    private final ECLiveSkinBaseViewUIConfig enabled;

    @SerializedName("radius")
    private final List<Integer> radius;

    public ECLiveSkinBtnUIConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBtnUIConfig copy$default(ECLiveSkinBtnUIConfig r100, ECLiveSkinBaseViewUIConfig r101, ECLiveSkinBaseViewUIConfig r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.disabled;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.getRadius();
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ECLiveSkinBaseViewUIConfig component1() {
        return this.enabled;
    }

    public final ECLiveSkinBaseViewUIConfig component2() {
        return this.disabled;
    }

    public final List<Integer> component3() {
        return getRadius();
    }

    public final ECLiveSkinBtnUIConfig copy(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, List<Integer> r102) {
        return new ECLiveSkinBtnUIConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinBtnUIConfig) == false) goto L12;
        ECLiveSkinBtnUIConfig r101 = (ECLiveSkinBtnUIConfig) r100;
        if (Intrinsics.areEqual(this.enabled, r101.enabled) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getRadius(), r101.getRadius()) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        ECLiveSkinBaseViewUIConfig r100 = this.enabled;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECLiveSkinBaseViewUIConfig r104 = this.disabled;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = getRadius();
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
        return "ECLiveSkinBtnUIConfig(enabled=" + this.enabled + ", disabled=" + this.disabled + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBaseViewUIConfig getDisabled() {
        return this.disabled;
    }

    public final ECLiveSkinBaseViewUIConfig getEnabled() {
        return this.enabled;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public ECLiveSkinBtnUIConfig(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, List<Integer> r102) {
        this.enabled = r100;
        this.disabled = r101;
        this.radius = r102;
    }

    public /* synthetic */ ECLiveSkinBtnUIConfig(ECLiveSkinBaseViewUIConfig r100, ECLiveSkinBaseViewUIConfig r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
