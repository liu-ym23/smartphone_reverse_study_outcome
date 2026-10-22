package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/live/g;", "", "Lcom/bytedance/android/ec/model/live/a;", "countDown", "Lcom/bytedance/android/ec/model/live/a;", "b", "()Lcom/bytedance/android/ec/model/live/a;", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "size", "I", "d", "()I", "", "Lcom/bytedance/android/ec/model/live/b;", "fallbackBlocks", "Ljava/util/List;", "c", "()Ljava/util/List;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("color")
    private final String color;

    @SerializedName("countdown")
    private final a countDown;

    @SerializedName("fallback")
    private final List<b> fallbackBlocks;

    @SerializedName("size")
    private final int size;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.countDown, r101.countDown) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L10;
        return false;
    L10:
        if (this.size == r101.size) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fallbackBlocks, r101.fallbackBlocks) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        a r100 = this.countDown;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.color;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.size) * 31;
        List<b> r107 = this.fallbackBlocks;
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

    public final String toString() {
        return "ECElementCountDown(countDown=" + this.countDown + ", color=" + this.color + ", size=" + this.size + ", fallbackBlocks=" + this.fallbackBlocks + ")";
    }

    public g() {
        this.countDown = null;
        this.color = null;
        this.size = 12;
        this.fallbackBlocks = null;
    }

    public final String a() {
        return this.color;
    }

    public final a b() {
        return this.countDown;
    }

    public final List<b> c() {
        return this.fallbackBlocks;
    }

    public final int d() {
        return this.size;
    }
}
