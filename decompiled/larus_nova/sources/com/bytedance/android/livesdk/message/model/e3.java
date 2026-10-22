package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/e3;", "", "", "areaType", "Ljava/lang/Integer;", "areaSubType", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e3 implements vh7.h {

    @SerializedName("area_sub_type")
    public Integer areaSubType;

    @SerializedName("area_type")
    public Integer areaType;

    public final int hashCode() {
        Integer r100 = this.areaType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.areaSubType;
        if (r104 == null) goto L10;
        r101 = r104.intValue();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public e3() {
        this.areaType = 0;
        this.areaSubType = 0;
    }

    public e3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.areaType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.areaSubType = Integer.valueOf(r100.i());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.areaType != null) goto L16;
        this.areaType = 0;
    L16:
        if (this.areaSubType != null) goto L28;
        this.areaSubType = 0;
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(e3.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        e3 r102 = (e3) r100;
        if ((!Intrinsics.areEqual(this.areaType, r102.areaType)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.areaSubType, r102.areaSubType)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.CombineType");
    L8:
        r101 = null;
        goto L10
    }
}
