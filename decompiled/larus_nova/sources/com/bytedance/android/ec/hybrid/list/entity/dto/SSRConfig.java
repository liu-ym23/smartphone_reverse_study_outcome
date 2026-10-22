package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRConfig;", "Ljava/io/Serializable;", "()V", "hydrateData", "", "getHydrateData", "()Ljava/lang/String;", "hydrateUrl", "getHydrateUrl", "ssrData", "getSsrData", "ssrDataDecodingFormat", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "getSsrDataDecodingFormat", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SSRConfig implements Serializable {

    @SerializedName("hydrate_data")
    private final String hydrateData;

    @SerializedName("hydrate_url")
    private final String hydrateUrl;

    @SerializedName("ssr_data")
    private final String ssrData;

    @SerializedName("ssr_data_decoding_format")
    private final SSRDataDecodingFormat ssrDataDecodingFormat;

    public SSRConfig() {
    }

    public final String getHydrateData() {
        return this.hydrateData;
    }

    public final String getHydrateUrl() {
        return this.hydrateUrl;
    }

    public final String getSsrData() {
        return this.ssrData;
    }

    public final SSRDataDecodingFormat getSsrDataDecodingFormat() {
        return this.ssrDataDecodingFormat;
    }
}
