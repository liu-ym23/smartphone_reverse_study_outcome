package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/sku/BackgroundInfo;", "Ljava/io/Serializable;", "backgroundColor", "", "cornerRadius", "", "height", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackgroundColor", "()Ljava/lang/String;", "getCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/sku/BackgroundInfo;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BackgroundInfo implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("corner_radius")
    private final Integer cornerRadius;

    @SerializedName("height")
    private final Integer height;

    public BackgroundInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BackgroundInfo copy$default(BackgroundInfo r100, String r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.cornerRadius;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final Integer component2() {
        return this.cornerRadius;
    }

    public final Integer component3() {
        return this.height;
    }

    public final BackgroundInfo copy(String r100, Integer r101, Integer r102) {
        return new BackgroundInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BackgroundInfo) == false) goto L12;
        BackgroundInfo r101 = (BackgroundInfo) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cornerRadius, r101.cornerRadius) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cornerRadius;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.height;
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
        return "BackgroundInfo(backgroundColor=" + this.backgroundColor + ", cornerRadius=" + this.cornerRadius + ", height=" + this.height + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public BackgroundInfo(String r100, Integer r101, Integer r102) {
        this.backgroundColor = r100;
        this.cornerRadius = r101;
        this.height = r102;
    }

    public /* synthetic */ BackgroundInfo(String r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
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
