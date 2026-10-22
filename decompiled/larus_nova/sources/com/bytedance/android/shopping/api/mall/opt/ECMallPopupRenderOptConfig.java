package com.bytedance.android.shopping.api.mall.opt;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/ECMallPopupRenderOptConfig;", "Ljava/io/Serializable;", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "I", "getStrategy", "()I", "setStrategy", "(I)V", "pageCardStrategy", "getPageCardStrategy", "setPageCardStrategy", "", "", "enabledPages", "Ljava/util/List;", "getEnabledPages", "()Ljava/util/List;", "setEnabledPages", "(Ljava/util/List;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPopupRenderOptConfig implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f170584a = null;

    @SerializedName("enabled_pages")
    private List<String> enabledPages;

    @SerializedName("page_card_strategy")
    private int pageCardStrategy;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private int strategy;

    public static final class a {
        public a() {
        }

        public static ECMallPopupRenderOptConfig a() {
            return (ECMallPopupRenderOptConfig) ECMallPopupRenderOptConfig.access$getConfig$cp().getValue();
        }

        public static int b(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return 0;
        L11:
            List<String> r102 = a().getEnabledPages();
            if (r102 != null) goto L14;
        L17:
            boolean r103 = true;
        L18:
            if (r103 == true) goto L26;
            List<String> r104 = a().getEnabledPages();
            if (r104 != null) goto L22;
        L24:
            return 0;
        L22:
            if (r104.contains(r100) != true) goto L24;
        L26:
            return a().getStrategy();
        L14:
            if (r102.isEmpty() == true) goto L17;
            r103 = false;
            goto L18
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public ECMallPopupRenderOptConfig() {
    }

    static {
        Companion = new a();
        f170584a = LazyKt.lazy(ECMallPopupRenderOptConfig$Companion$config$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getConfig$cp() {
        return f170584a;
    }

    public final List<String> getEnabledPages() {
        return this.enabledPages;
    }

    public final int getPageCardStrategy() {
        return this.pageCardStrategy;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public final void setEnabledPages(List<String> r100) {
        this.enabledPages = r100;
    }

    public final void setPageCardStrategy(int r100) {
        this.pageCardStrategy = r100;
    }

    public final void setStrategy(int r100) {
        this.strategy = r100;
    }
}
