package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/sku/BlankObject;", "Ljava/io/Serializable;", "width", "", "(Ljava/lang/Integer;)V", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/sku/BlankObject;", "equals", "", "other", "", "hashCode", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BlankObject implements Serializable {

    @SerializedName("width")
    private final Integer width;

    /* JADX WARN: Multi-variable type inference failed */
    public BlankObject() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BlankObject copy$default(BlankObject r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.width;
    }

    public final BlankObject copy(Integer r100) {
        return new BlankObject(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BlankObject) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.width, ((BlankObject) r100).width) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.width;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "BlankObject(width=" + this.width + ")";
    }

    public final Integer getWidth() {
        return this.width;
    }

    public BlankObject(Integer r100) {
        this.width = r100;
    }

    public /* synthetic */ BlankObject(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
