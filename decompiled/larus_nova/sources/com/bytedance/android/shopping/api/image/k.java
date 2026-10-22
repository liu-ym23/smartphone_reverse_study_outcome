package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/image/k;", "", "", "Lcom/bytedance/android/shopping/api/image/i;", "rules", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "signRules", "b", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("rules")
    private final List<i> rules;

    @SerializedName("sign_rules")
    private final List<i> signRules;

    public k() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.signRules, r101.signRules) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<i> r100 = this.rules;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<i> r104 = this.signRules;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HostReplaceModel(rules=" + this.rules + ", signRules=" + this.signRules + ")";
    }

    public final List<i> a() {
        return this.rules;
    }

    public final List<i> b() {
        return this.signRules;
    }

    public k(Object r100) {
        this.rules = null;
        this.signRules = null;
    }
}
