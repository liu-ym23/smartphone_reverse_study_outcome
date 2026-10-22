package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/setting/j;", "", "", "Lcom/bytedance/android/ec/store/setting/k;", "preloadTemplates", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("preload_templates")
    private final List<k> preloadTemplates;

    public final List<k> a() {
        return this.preloadTemplates;
    }

    public j(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadTemplates");
        this.preloadTemplates = r100;
    }
}
