package com.bytedance.android.ec.hybrid.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0005R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/ECHybridRequestTransformConfig;", "Ljava/io/Serializable;", "()V", "lookupMap", "", "", "getLookupMap", "()Ljava/util/Map;", "setLookupMap", "(Ljava/util/Map;)V", "strategyMap", "Lcom/bytedance/android/ec/hybrid/data/ECHybridRequestTransformConfig$TransformStrategy;", "getStrategyMap", "setStrategyMap", "transformStrategyOf", "url", "TransformStrategy", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridRequestTransformConfig implements Serializable {

    @SerializedName("lookup_map")
    private Map<String, String> lookupMap;

    @SerializedName("strategy_map")
    private Map<String, TransformStrategy> strategyMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R,\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/ECHybridRequestTransformConfig$TransformStrategy;", "Ljava/io/Serializable;", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", com.alipay.sdk.m.p.e.f25671s, "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "migrateToBodyParams", "", "getMigrateToBodyParams", "()Ljava/util/List;", "setMigrateToBodyParams", "(Ljava/util/List;)V", "params", "", "getParams", "setParams", "transferFormData", "", "getTransferFormData", "()Z", "setTransferFormData", "(Z)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TransformStrategy implements Serializable {

        @SerializedName("headers")
        private Map<String, String> headers;

        @SerializedName(com.alipay.sdk.m.p.e.f25671s)
        private String method;

        @SerializedName("migrate_to_body_params")
        private List<String> migrateToBodyParams;

        @SerializedName("params")
        private Map<String, ? extends Object> params;

        @SerializedName("transfer_form_data")
        private boolean transferFormData;

        public TransformStrategy() {
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getMethod() {
            return this.method;
        }

        public final List<String> getMigrateToBodyParams() {
            return this.migrateToBodyParams;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final boolean getTransferFormData() {
            return this.transferFormData;
        }

        public final void setHeaders(Map<String, String> r100) {
            this.headers = r100;
        }

        public final void setMethod(String r100) {
            this.method = r100;
        }

        public final void setMigrateToBodyParams(List<String> r100) {
            this.migrateToBodyParams = r100;
        }

        public final void setParams(Map<String, ? extends Object> r100) {
            this.params = r100;
        }

        public final void setTransferFormData(boolean r100) {
            this.transferFormData = r100;
        }
    }

    public ECHybridRequestTransformConfig() {
    }

    public final Map<String, String> getLookupMap() {
        return this.lookupMap;
    }

    public final Map<String, TransformStrategy> getStrategyMap() {
        return this.strategyMap;
    }

    public final void setLookupMap(Map<String, String> r100) {
        this.lookupMap = r100;
    }

    public final void setStrategyMap(Map<String, TransformStrategy> r100) {
        this.strategyMap = r100;
    }

    public final TransformStrategy transformStrategyOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Map<String, String> r101 = this.lookupMap;
        if (r101 == null) goto L19;
        String r102 = r101.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L22;
        Map<String, TransformStrategy> r104 = this.strategyMap;
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.get(r102);
    L22:
        return null;
    L9:
        r103 = false;
        goto L10
    L19:
        return null;
    }
}
