package com.bytedance.android.shopping.anchorv4.perf.preload;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/perf/preload/PreloadMultiDataDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/shopping/anchorv4/perf/preload/o;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadMultiDataDTO extends CommerceBaseResponse {

    @SerializedName("product_list")
    private final List<o> data;

    public PreloadMultiDataDTO() {
    }

    public final List<o> getData() {
        return this.data;
    }
}
