package com.bytedance.android.ecom.slice.ext.template.gecko;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R2\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ecom/slice/ext/template/gecko/g;", "", "", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/j;", "preloadList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "", "preRenderFieldsMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "", "enablePreRender", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "gecko_template_store_release"}, k = 1, mv = {1, 4, 0})
public final class g {

    @SerializedName("enable_pre_render")
    private final boolean enablePreRender;

    @SerializedName("pre_render_fields_info_list")
    private final Map<String, List<Object>> preRenderFieldsMap;

    @SerializedName("preload")
    private final List<j> preloadList;

    public g() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.preloadList, r101.preloadList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preRenderFieldsMap, r101.preRenderFieldsMap) == true) goto L10;
        return false;
    L10:
        if (this.enablePreRender == r101.enablePreRender) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        List<j> r100 = this.preloadList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<Object>> r104 = this.preRenderFieldsMap;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.enablePreRender;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcGeckoChannelPreloadInfo(preloadList=" + this.preloadList + ", preRenderFieldsMap=" + this.preRenderFieldsMap + ", enablePreRender=" + this.enablePreRender + ")";
    }

    public final boolean a() {
        return this.enablePreRender;
    }

    public final Map<String, List<Object>> b() {
        return this.preRenderFieldsMap;
    }

    public final List<j> c() {
        return this.preloadList;
    }

    public /* synthetic */ g(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<j> r100, Map<String, ? extends List<? extends Object>> r101, boolean r102) {
        this.preloadList = r100;
        this.preRenderFieldsMap = r101;
        this.enablePreRender = r102;
    }
}
