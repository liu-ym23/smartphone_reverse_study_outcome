package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R6\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/model/z0;", "", "", "", "", "", "hitRecord", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "b", "(Ljava/util/Map;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("hit_record")
    private Map<String, List<Long>> hitRecord;

    public z0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.hitRecord, ((z0) r100).hitRecord) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, List<Long>> r100 = this.hitRecord;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StrategyFrequencyInfo(hitRecord=" + this.hitRecord + ")";
    }

    public final Map<String, List<Long>> a() {
        return this.hitRecord;
    }

    public z0(Object r100) {
        this.hitRecord = new LinkedHashMap();
    }

    public final void b(Map<String, List<Long>> r100) {
        this.hitRecord = r100;
    }
}
