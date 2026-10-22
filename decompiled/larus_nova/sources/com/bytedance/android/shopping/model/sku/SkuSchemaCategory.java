package com.bytedance.android.shopping.model.sku;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/model/sku/SkuSchemaCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "KEY_PRODUCT_INFO", "KEY_BIZ_CONTEXT", "KEY_CHAIN_INFO", "KEY_USER_INFO", "KEY_CUSTOM_PARAMS", "KEY_CLIENT_PARAMS", "KEY_PLATFORM_PARAMS", "KEY_PASS_THROUGH", "KEY_EXTRA_PARAMS", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SkuSchemaCategory extends Enum<SkuSchemaCategory> {
    public static final a Companion = null;
    public static final SkuSchemaCategory KEY_BIZ_CONTEXT = null;
    public static final SkuSchemaCategory KEY_CHAIN_INFO = null;
    public static final SkuSchemaCategory KEY_CLIENT_PARAMS = null;
    public static final SkuSchemaCategory KEY_CUSTOM_PARAMS = null;
    public static final SkuSchemaCategory KEY_EXTRA_PARAMS = null;
    public static final SkuSchemaCategory KEY_PASS_THROUGH = null;
    public static final SkuSchemaCategory KEY_PLATFORM_PARAMS = null;
    public static final SkuSchemaCategory KEY_PRODUCT_INFO = null;
    public static final SkuSchemaCategory KEY_USER_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuSchemaCategory[] f178656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f178657b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static SkuSchemaCategory valueOf(String r100) {
        return (SkuSchemaCategory) r27.a.a(SkuSchemaCategory.class, r100);
    }

    public static SkuSchemaCategory[] values() {
        return (SkuSchemaCategory[]) f178656a.clone();
    }

    static {
        int r100 = 0;
        SkuSchemaCategory r101 = new SkuSchemaCategory("KEY_PRODUCT_INFO", 0, "product_info");
        KEY_PRODUCT_INFO = r101;
        SkuSchemaCategory r102 = new SkuSchemaCategory("KEY_BIZ_CONTEXT", 1, "biz_context");
        KEY_BIZ_CONTEXT = r102;
        SkuSchemaCategory r103 = new SkuSchemaCategory("KEY_CHAIN_INFO", 2, "chain_info");
        KEY_CHAIN_INFO = r103;
        SkuSchemaCategory r104 = new SkuSchemaCategory("KEY_USER_INFO", 3, "user_info");
        KEY_USER_INFO = r104;
        SkuSchemaCategory r105 = new SkuSchemaCategory("KEY_CUSTOM_PARAMS", 4, "custom_params");
        KEY_CUSTOM_PARAMS = r105;
        SkuSchemaCategory r106 = new SkuSchemaCategory("KEY_CLIENT_PARAMS", 5, "client_params");
        KEY_CLIENT_PARAMS = r106;
        SkuSchemaCategory r107 = new SkuSchemaCategory("KEY_PLATFORM_PARAMS", 6, "platform_params");
        KEY_PLATFORM_PARAMS = r107;
        SkuSchemaCategory r108 = new SkuSchemaCategory("KEY_PASS_THROUGH", 7, "pass_through");
        KEY_PASS_THROUGH = r108;
        SkuSchemaCategory r109 = new SkuSchemaCategory("KEY_EXTRA_PARAMS", 8, "extra_params");
        KEY_EXTRA_PARAMS = r109;
        f178656a = new SkuSchemaCategory[]{r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
        SkuSchemaCategory[] r110 = values();
        ArrayList r111 = new ArrayList(r110.length);
        int r112 = r110.length;
    L3:
        if (r100 >= r112) goto L5;
        r111.add(r110[r100].value);
        r100 = r100 + 1;
        goto L3
    L5:
        f178657b = CollectionsKt.toHashSet(r111);
    }

    public static final /* synthetic */ HashSet access$getKeysSet$cp() {
        return f178657b;
    }

    public final String getValue() {
        return this.value;
    }

    public SkuSchemaCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
