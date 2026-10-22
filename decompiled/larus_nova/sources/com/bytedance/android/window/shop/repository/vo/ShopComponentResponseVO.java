package com.bytedance.android.window.shop.repository.vo;

import com.bytedance.android.ec.window.base.repository.vo.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/ShopComponentResponseVO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/window/base/repository/vo/d;", "components", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "setComponents", "(Ljava/util/List;)V", "", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "extraSchema", "Ljava/lang/String;", "getExtraSchema", "()Ljava/lang/String;", "setExtraSchema", "(Ljava/lang/String;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopComponentResponseVO implements Serializable {
    private List<d> components;
    private String extraSchema;
    private Map<String, String> logExtra;

    public ShopComponentResponseVO() {
        this.components = new ArrayList();
    }

    public final List<d> getComponents() {
        return this.components;
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final void setComponents(List<d> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.components = r100;
    }

    public final void setExtraSchema(String r100) {
        this.extraSchema = r100;
    }

    public final void setLogExtra(Map<String, String> r100) {
        this.logExtra = r100;
    }
}
