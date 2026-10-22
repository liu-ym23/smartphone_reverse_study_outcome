package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/a;", "", "", "tabAPIUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tabAPIParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "appendAPIParamsKeys", "Ljava/util/List;", "getAppendAPIParamsKeys", "()Ljava/util/List;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("tab_append_api_params_keys")
    private final List<String> appendAPIParamsKeys;

    @SerializedName("tab_api_params")
    private final String tabAPIParams;

    @SerializedName("tab_api_url")
    private final String tabAPIUrl;

    public a() {
    }

    public final String a() {
        return this.tabAPIParams;
    }

    public final String b() {
        return this.tabAPIUrl;
    }
}
