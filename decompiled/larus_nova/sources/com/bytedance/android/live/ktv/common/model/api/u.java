package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/u;", "", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "color", "getColor", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u implements vh7.h {

    @SerializedName("color")
    protected String color;

    @SerializedName("content")
    protected String content;

    public u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter("#80FFFFFF", "color");
        this.content = r100;
        this.color = "#80FFFFFF";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L10;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.color;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HotWord(content=" + this.content + ", color=" + this.color + ")";
    }

    public u() {
        this.content = "";
        this.color = "#161823";
    }

    public final String a() {
        return this.content;
    }

    public u(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.content = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.color = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.content != null) goto L16;
        this.content = "";
    L16:
        if (this.color != null) goto L28;
        this.color = "#161823";
        return;
    }
}
