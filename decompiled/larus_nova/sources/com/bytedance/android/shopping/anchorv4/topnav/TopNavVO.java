package com.bytedance.android.shopping.anchorv4.topnav;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/topnav/TopNavVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ecom/arch/slice/g;", "getTopSlice", "", "isDisplayShareTouchPoint", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/g;", "getTabList", "Lcom/bytedance/android/shopping/anchorv4/topnav/Config;", "config", "Lcom/bytedance/android/shopping/anchorv4/topnav/Config;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/topnav/Config;", "slices", "Ljava/util/List;", "getSlices", "()Ljava/util/List;", "setSlices", "(Ljava/util/List;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/topnav/Config;Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopNavVO implements Serializable {

    @SerializedName("config")
    private final Config config;

    @SerializedName("slices")
    private List<? extends com.bytedance.android.ecom.arch.slice.g> slices;

    /* JADX WARN: Multi-variable type inference failed */
    public TopNavVO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final com.bytedance.android.ecom.arch.slice.g getTopSlice() {
        List<? extends com.bytedance.android.ecom.arch.slice.g> r100 = this.slices;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.ecom.arch.slice.g) CollectionsKt.firstOrNull(r100);
    }

    public final List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> getTabList() {
        com.bytedance.android.ecom.arch.slice.g r100 = getTopSlice();
        if (r100 == null) goto L35;
        Map<String, Object> r101 = r100.getData();
        if (r101 == null) goto L36;
        Object r102 = r101.get("tab");
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r102 instanceof Map) == true) goto L11;
        r102 = null;
    L11:
        Map r103 = (Map) r102;
        if (r103 == null) goto L14;
        Object r104 = r103.get("tabs");
    L16:
        if ((r104 instanceof List) == true) goto L18;
        r104 = null;
    L18:
        List r105 = (List) r104;
        if (r105 == null) goto L38;
        List r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L22:
        if (r108.hasNext() == false) goto L31;
        Map r109 = (Map) r108.next();
        Object r110 = r109.get("group_id");
        if ((r110 instanceof String) == true) goto L26;
        r110 = null;
    L26:
        String r111 = (String) r110;
        Object r112 = r109.get("collapsed_display");
        if ((r112 instanceof Boolean) == true) goto L29;
        r112 = null;
    L29:
        r107.add(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g(r111, (Boolean) r112));
        goto L22
    L31:
        return r107;
    L38:
        return null;
    L14:
        r104 = null;
        goto L16
    L36:
        return null;
    L35:
        return null;
    }

    public final Boolean isDisplayShareTouchPoint() {
        com.bytedance.android.ecom.arch.slice.g r100 = getTopSlice();
        Object r101 = null;
        if (r100 == null) goto L7;
        Map<String, Object> r102 = r100.getData();
        if (r102 == null) goto L7;
        Object r103 = r102.get("display_share_touch_point");
    L9:
        if ((r103 instanceof Boolean) == false) goto L13;
        r101 = r103;
    L13:
        return (Boolean) r101;
    L7:
        r103 = null;
        goto L9
    }

    public final Config getConfig() {
        return this.config;
    }

    public final List<com.bytedance.android.ecom.arch.slice.g> getSlices() {
        return this.slices;
    }

    public final void setSlices(List<? extends com.bytedance.android.ecom.arch.slice.g> r100) {
        this.slices = r100;
    }

    public TopNavVO(Config r100, List<? extends com.bytedance.android.ecom.arch.slice.g> r101) {
        this.config = r100;
        this.slices = r101;
    }

    public /* synthetic */ TopNavVO(Config r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
