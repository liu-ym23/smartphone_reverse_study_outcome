package com.bytedance.android.marketing.sdk.impl.api;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse;", "", "data", "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse$Data;", "(Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse$Data;)V", "getData", "()Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Data", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingResourceResponse {

    @SerializedName("data")
    private final Data data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse$Data;", "", "bizParamsMap", "", "", "(Ljava/util/Map;)V", "getBizParamsMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Data {

        @SerializedName("biz_params_map")
        private final Map<String, String> bizParamsMap;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data r100, Map r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.bizParamsMap;
        L6:
            return r100.copy(r101);
        }

        public final Map<String, String> component1() {
            return this.bizParamsMap;
        }

        public final Data copy(Map<String, String> r100) {
            return new Data(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Data) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.bizParamsMap, ((Data) r100).bizParamsMap) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            Map<String, String> r100 = this.bizParamsMap;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "Data(bizParamsMap=" + this.bizParamsMap + ")";
        }

        public final Map<String, String> getBizParamsMap() {
            return this.bizParamsMap;
        }

        public Data(Map<String, String> r100) {
            this.bizParamsMap = r100;
        }
    }

    public static /* synthetic */ MarketingResourceResponse copy$default(MarketingResourceResponse r100, Data r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final Data component1() {
        return this.data;
    }

    public final MarketingResourceResponse copy(Data r100) {
        return new MarketingResourceResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MarketingResourceResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((MarketingResourceResponse) r100).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Data r100 = this.data;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "MarketingResourceResponse(data=" + this.data + ")";
    }

    public final Data getData() {
        return this.data;
    }

    public MarketingResourceResponse(Data r100) {
        this.data = r100;
    }
}
