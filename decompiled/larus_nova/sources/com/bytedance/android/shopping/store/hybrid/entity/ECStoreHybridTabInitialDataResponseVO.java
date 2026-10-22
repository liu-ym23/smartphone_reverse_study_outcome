package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ECStoreHybridTabInitialDataResponseVO;", "Ljava/io/Serializable;", "", "hasComponents", "", "bundleUrl", "Ljava/lang/String;", "getBundleUrl", "()Ljava/lang/String;", "setBundleUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;", "componentsWrapper", "Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;", "getComponentsWrapper", "()Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;", "setComponentsWrapper", "(Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;)V", "passThrough2FE", "getPassThrough2FE", "setPassThrough2FE", TemplateNodeType.RAW, "getRaw", "setRaw", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabInitialDataResponseVO implements Serializable {
    public static final a Companion = null;
    private String bundleUrl;
    private ComponentsWrapper componentsWrapper;
    private String passThrough2FE;
    private String raw;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreHybridTabInitialDataResponseVO() {
    }

    public final boolean hasComponents() {
        ComponentsWrapper r100 = this.componentsWrapper;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasComponents() != true) goto L7;
        return true;
    }

    public final String getBundleUrl() {
        return this.bundleUrl;
    }

    public final ComponentsWrapper getComponentsWrapper() {
        return this.componentsWrapper;
    }

    public final String getPassThrough2FE() {
        return this.passThrough2FE;
    }

    public final String getRaw() {
        return this.raw;
    }

    public final void setBundleUrl(String r100) {
        this.bundleUrl = r100;
    }

    public final void setComponentsWrapper(ComponentsWrapper r100) {
        this.componentsWrapper = r100;
    }

    public final void setPassThrough2FE(String r100) {
        this.passThrough2FE = r100;
    }

    public final void setRaw(String r100) {
        this.raw = r100;
    }
}
