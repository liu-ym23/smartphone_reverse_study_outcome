package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/z;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/s;", "guessList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setGuessList", "(Ljava/util/List;)V", "", "imprId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setImprId", "(Ljava/lang/String;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z implements vh7.h {

    @SerializedName("sug_list")
    protected List<s> guessList;

    @SerializedName("impr_id")
    protected String imprId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L10;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.guessList, r101.guessList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.imprId, r101.imprId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<s> r100 = this.guessList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.imprId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSearchGuessResponse(guessList=" + this.guessList + ", imprId=" + this.imprId + ")";
    }

    public z() {
        this.guessList = new ArrayList();
        this.imprId = "";
    }

    public final List<s> a() {
        return this.guessList;
    }

    public final String b() {
        return this.imprId;
    }

    public z(am3.g r100) {
        this.guessList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.guessList.add(new s(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.imprId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.guessList.isEmpty() == false) goto L16;
        this.guessList = new ArrayList();
    L16:
        if (this.imprId != null) goto L28;
        this.imprId = "";
        return;
    }
}
