package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0003J3\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSetting;", "Ljava/io/Serializable;", "scene", "", "", "category", "(Ljava/util/List;Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "getScene", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class WireFrameSetting implements Serializable {

    @SerializedName("category")
    private final List<List<Integer>> category;

    @SerializedName("scene")
    private final List<Integer> scene;

    /* JADX WARN: Multi-variable type inference failed */
    public WireFrameSetting() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WireFrameSetting copy$default(WireFrameSetting r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.category;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<Integer> component1() {
        return this.scene;
    }

    public final List<List<Integer>> component2() {
        return this.category;
    }

    public final WireFrameSetting copy(List<Integer> r100, List<? extends List<Integer>> r101) {
        return new WireFrameSetting(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WireFrameSetting) == false) goto L10;
        WireFrameSetting r101 = (WireFrameSetting) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<Integer> r100 = this.scene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<List<Integer>> r104 = this.category;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WireFrameSetting(scene=" + this.scene + ", category=" + this.category + ")";
    }

    public final List<List<Integer>> getCategory() {
        return this.category;
    }

    public final List<Integer> getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WireFrameSetting(List<Integer> r100, List<? extends List<Integer>> r101) {
        this.scene = r100;
        this.category = r101;
    }

    public /* synthetic */ WireFrameSetting(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
