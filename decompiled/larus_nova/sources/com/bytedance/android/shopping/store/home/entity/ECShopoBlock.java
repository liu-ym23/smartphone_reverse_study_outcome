package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopoBlock;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "block", "Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "getBlock", "()Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "setBlock", "(Lcom/bytedance/android/shopping/store/home/entity/Blcok;)V", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "perfLogExtra", "getPerfLogExtra", "setPerfLogExtra", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopoBlock extends CommerceBaseResponse {

    @SerializedName("block")
    private Blcok block;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("perf_log_extra")
    private Map<String, String> perfLogExtra;

    public ECShopoBlock() {
    }

    public final Blcok getBlock() {
        return this.block;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
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

    public final void setPerfLogExtra(Map<String, String> r100) {
        this.perfLogExtra = r100;
    }
}
