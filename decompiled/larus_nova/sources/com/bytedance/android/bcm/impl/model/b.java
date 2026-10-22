package com.bytedance.android.bcm.impl.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/b;", "", "", "Lcom/bytedance/android/bcm/impl/model/e;", "btmCheckPoints", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "ignoreCheckBtm", "getIgnoreCheckBtm", "ignoreCheckParamsType", "getIgnoreCheckParamsType", "Lcom/bytedance/android/bcm/impl/model/d;", "shouldCheckBcm", "getShouldCheckBcm", "<init>", "()V", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("btm_bcm_summary_detail")
    private final List<e> btmCheckPoints;

    @SerializedName("ignore_check_btm")
    private final List<String> ignoreCheckBtm;

    @SerializedName("ignore_check_bcm_type_params")
    private final List<String> ignoreCheckParamsType;

    @SerializedName("should_check_bcm_params")
    private final List<d> shouldCheckBcm;

    public b() {
        this.ignoreCheckBtm = CollectionsKt.listOf("a6195");
        this.ignoreCheckParamsType = CollectionsKt.listOf("search_params");
    }

    public final List<e> a() {
        return this.btmCheckPoints;
    }
}
