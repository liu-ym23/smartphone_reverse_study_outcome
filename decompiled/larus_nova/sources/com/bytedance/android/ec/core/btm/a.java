package com.bytedance.android.ec.core.btm;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/btm/a;", "", "", "btmCode", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "bcmContext", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("bcm_context")
    private final Map<String, Object> bcmContext;

    @SerializedName("btm_code")
    private final String btmCode;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.btmCode, r101.btmCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bcmContext, r101.bcmContext) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.btmCode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.bcmContext;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BTMFields(btmCode=" + this.btmCode + ", bcmContext=" + this.bcmContext + ")";
    }

    public final Map<String, Object> a() {
        return this.bcmContext;
    }

    public final String b() {
        return this.btmCode;
    }

    public a(String r100, Map<String, ? extends Object> r101) {
        this.btmCode = r100;
        this.bcmContext = r101;
    }
}
