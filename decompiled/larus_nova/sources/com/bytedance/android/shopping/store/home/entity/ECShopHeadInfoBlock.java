package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "block", "Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "getBlock", "()Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "setBlock", "(Lcom/bytedance/android/shopping/store/home/entity/Blcok;)V", "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "perfLogExtra", "getPerfLogExtra", "setPerfLogExtra", "Lcom/bytedance/android/shopping/store/home/entity/n;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/store/home/entity/n;", "getHeaderInfoBlockVO", "()Lcom/bytedance/android/shopping/store/home/entity/n;", "setHeaderInfoBlockVO", "(Lcom/bytedance/android/shopping/store/home/entity/n;)V", "headerInfoBlockVO", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHeadInfoBlock extends CommerceBaseResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient n f183630a;

    @SerializedName("block")
    private Blcok block;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("perf_log_extra")
    private Map<String, String> perfLogExtra;

    public ECShopHeadInfoBlock() {
    }

    public final Blcok getBlock() {
        return this.block;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final n getHeaderInfoBlockVO() {
        return this.f183630a;
    }

    public final Map<String, String> getPerfLogExtra() {
        return this.perfLogExtra;
    }

    public final void setBlock(Blcok r100) {
        this.block = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setHeaderInfoBlockVO(n r100) {
        this.f183630a = r100;
    }

    public final void setPerfLogExtra(Map<String, String> r100) {
        this.perfLogExtra = r100;
    }
}
