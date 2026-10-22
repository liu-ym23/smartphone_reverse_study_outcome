package com.bytedance.android.ec.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/ButtonTime;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "serverTime", "", "preBeginTime", "beginTime", "endTime", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getBeginTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getPreBeginTime", "getServerTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/ec/model/ButtonTime;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ButtonTime extends CommerceBaseResponse {

    @SerializedName("begin_time")
    private final Long beginTime;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("pre_begin_time")
    private final Long preBeginTime;

    @SerializedName("server_time")
    private final Long serverTime;

    public ButtonTime() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ButtonTime copy$default(ButtonTime r100, Long r101, Long r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.serverTime;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.preBeginTime;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.beginTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.endTime;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.serverTime;
    }

    public final Long component2() {
        return this.preBeginTime;
    }

    public final Long component3() {
        return this.beginTime;
    }

    public final Long component4() {
        return this.endTime;
    }

    public final ButtonTime copy(Long r100, Long r101, Long r102, Long r103) {
        return new ButtonTime(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ButtonTime) == false) goto L14;
        ButtonTime r101 = (ButtonTime) r100;
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preBeginTime, r101.preBeginTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.beginTime, r101.beginTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Long r100 = this.serverTime;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.preBeginTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.beginTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.endTime;
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
        return "ButtonTime(serverTime=" + this.serverTime + ", preBeginTime=" + this.preBeginTime + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ")";
    }

    public final Long getBeginTime() {
        return this.beginTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getPreBeginTime() {
        return this.preBeginTime;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public ButtonTime(Long r100, Long r101, Long r102, Long r103) {
        this.serverTime = r100;
        this.preBeginTime = r101;
        this.beginTime = r102;
        this.endTime = r103;
    }

    public /* synthetic */ ButtonTime(Long r100, Long r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
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
