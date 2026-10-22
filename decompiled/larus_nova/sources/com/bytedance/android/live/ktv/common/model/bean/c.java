package com.bytedance.android.live.ktv.common.model.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/c;", "", "", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "tuningEffectList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "defaultItemName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements vh7.h {

    @SerializedName("default_item_name")
    protected String defaultItemName;

    @SerializedName("effect_list")
    protected List<h> tuningEffectList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.tuningEffectList, r101.tuningEffectList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultItemName, r101.defaultItemName) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<h> r100 = this.tuningEffectList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.defaultItemName;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetTuningInfoResponse(tuningEffectList=" + this.tuningEffectList + ", defaultItemName=" + this.defaultItemName + ")";
    }

    public c() {
        this.tuningEffectList = new ArrayList();
        this.defaultItemName = "";
    }

    public final String a() {
        return this.defaultItemName;
    }

    public final List<h> b() {
        return this.tuningEffectList;
    }

    public c(am3.g r100) {
        this.tuningEffectList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.tuningEffectList.add(new h(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.defaultItemName = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.tuningEffectList.isEmpty() == false) goto L16;
        this.tuningEffectList = new ArrayList();
    L16:
        if (this.defaultItemName != null) goto L28;
        this.defaultItemName = "";
        return;
    }
}
