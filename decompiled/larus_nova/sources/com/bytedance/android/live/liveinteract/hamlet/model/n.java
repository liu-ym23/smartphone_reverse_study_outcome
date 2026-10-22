package com.bytedance.android.live.liveinteract.hamlet.model;

import com.bytedance.android.shopping.buynow.data.model.PageStartupStatus;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/n;", "", "", "timestamp", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", PageStartupStatus.RENDERING, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "chestPosition", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n {

    @SerializedName("chest_position")
    private final String chestPosition;

    @SerializedName(PageStartupStatus.RENDERING)
    private final Integer rendering;

    @SerializedName("timestamp")
    private final Long timestamp;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rendering, r101.rendering) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.chestPosition, r101.chestPosition) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.timestamp;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.rendering;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.chestPosition;
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
        return "HamletSeiModel(timestamp=" + this.timestamp + ", rendering=" + this.rendering + ", chestPosition=" + this.chestPosition + ")";
    }

    public n() {
        this.timestamp = null;
        this.rendering = null;
        this.chestPosition = null;
    }

    public final String a() {
        return this.chestPosition;
    }

    public final Integer b() {
        return this.rendering;
    }

    public final Long c() {
        return this.timestamp;
    }
}
