package com.bytedance.android.shopping.sku.outer.business.anchor;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/anchor/a;", "", "", "detailUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/sku/outer/business/anchor/b;", "params", "Lcom/bytedance/android/shopping/sku/outer/business/anchor/b;", "b", "()Lcom/bytedance/android/shopping/sku/outer/business/anchor/b;", "", "updateParams", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183033a = 0;

    @SerializedName("schema")
    private final String detailUrl;

    @SerializedName("params")
    private final b params;

    @SerializedName("update_params")
    private final Map<String, String> updateParams;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sku.outer.business.anchor.a$a, reason: collision with other inner class name */
    public static final class C2718a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final String a() {
        return this.detailUrl;
    }

    public final b b() {
        return this.params;
    }

    public final Map<String, String> c() {
        return this.updateParams;
    }

    public a(Object r100) {
        this.detailUrl = null;
        this.params = null;
        this.updateParams = null;
    }
}
