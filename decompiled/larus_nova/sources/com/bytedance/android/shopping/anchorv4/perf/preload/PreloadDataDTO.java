package com.bytedance.android.shopping.anchorv4.perf.preload;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/perf/preload/PreloadDataDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "data", "Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "getData", "()Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadDataDTO extends CommerceBaseResponse {

    @SerializedName("promotion_v3")
    private final PackParsedDTO data;

    public PreloadDataDTO() {
    }

    public final PackParsedDTO getData() {
        return this.data;
    }
}
