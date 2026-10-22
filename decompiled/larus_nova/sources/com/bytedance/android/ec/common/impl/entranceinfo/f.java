package com.bytedance.android.ec.common.impl.entranceinfo;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/common/impl/entranceinfo/f;", "", "", "page", "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "scene", "getScene", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Integer;", "getActionType", "()Ljava/lang/Integer;", "", "keySet", "Ljava/util/List;", "getKeySet", "()Ljava/util/List;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("key_set")
    private final List<String> keySet;

    @SerializedName("page")
    private final String page;

    @SerializedName("scene")
    private final String scene;

    public f() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keySet, r101.keySet) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.page;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.scene;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.actionType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.keySet;
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

    public final String toString() {
        return "TraceItemInfo(page=" + this.page + ", scene=" + this.scene + ", actionType=" + this.actionType + ", keySet=" + this.keySet + ")";
    }

    public f(String r100, String r101, Integer r102, List<String> r103) {
        this.page = r100;
        this.scene = r101;
        this.actionType = r102;
        this.keySet = r103;
    }
}
