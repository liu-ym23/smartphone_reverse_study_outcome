package com.bytedance.android.bcm.impl.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/bcm/impl/config/a;", "", "", "", "bcmInChain", "Ljava/util/List;", "c", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "bcmAllowList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcmBizAllowList", "b", "bcmPassThroughList", "d", "<init>", "()V", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("bcm_allowlist")
    private final List<String> bcmAllowList;

    @SerializedName("bcm_biz_allowlist")
    private final List<String> bcmBizAllowList;

    @SerializedName("bcm_in_chain")
    private List<String> bcmInChain;

    @SerializedName("bcm_pass_through")
    private final List<String> bcmPassThroughList;

    public a() {
        this.bcmInChain = CollectionsKt.emptyList();
        this.bcmAllowList = CollectionsKt.emptyList();
        this.bcmBizAllowList = CollectionsKt.emptyList();
        this.bcmPassThroughList = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.bcmAllowList;
    }

    public final List<String> b() {
        return this.bcmBizAllowList;
    }

    public final List<String> c() {
        return this.bcmInChain;
    }

    public final List<String> d() {
        return this.bcmPassThroughList;
    }

    public final void e(List<String> r100) {
        this.bcmInChain = r100;
    }
}
