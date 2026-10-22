package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/d;", "", "Lcom/bytedance/android/shopping/api/mall/opt/f;", "topMall", "Lcom/bytedance/android/shopping/api/mall/opt/f;", "getTopMall", "()Lcom/bytedance/android/shopping/api/mall/opt/f;", "bottomMall", "getBottomMall", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "", "commonRequestPreload", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "", "preInflate", "e", "", "enableAnimaXPages", "Ljava/util/List;", "b", "()Ljava/util/List;", "enableAudioTT", "c", "inflateTiming", "Ljava/lang/Integer;", "getInflateTiming", "()Ljava/lang/Integer;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("bottom_mall")
    private final f bottomMall;

    @SerializedName("common_request_preload")
    private final Map<String, f> commonRequestPreload;

    @SerializedName("mall_enable_animax_pages")
    private final List<String> enableAnimaXPages;

    @SerializedName("audio_tt_inject_resource_loader")
    private final List<String> enableAudioTT;

    @SerializedName("async_inflate_native_view_timing")
    private final Integer inflateTiming;

    @SerializedName("page_name")
    private final ArrayList<String> pageName;

    @SerializedName("async_inflate_view")
    private final Map<String, Integer> preInflate;

    @SerializedName("top_mall")
    private final f topMall;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.topMall, r101.topMall) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomMall, r101.bottomMall) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonRequestPreload, r101.commonRequestPreload) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preInflate, r101.preInflate) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enableAnimaXPages, r101.enableAnimaXPages) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableAudioTT, r101.enableAudioTT) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.inflateTiming, r101.inflateTiming) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        f r100 = this.topMall;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f r104 = this.bottomMall;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.pageName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, f> r110 = this.commonRequestPreload;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Integer> r113 = this.preInflate;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.enableAnimaXPages;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.enableAudioTT;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.inflateTiming;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallListEngineOptConfig(topMall=" + this.topMall + ", bottomMall=" + this.bottomMall + ", pageName=" + this.pageName + ", commonRequestPreload=" + this.commonRequestPreload + ", preInflate=" + this.preInflate + ", enableAnimaXPages=" + this.enableAnimaXPages + ", enableAudioTT=" + this.enableAudioTT + ", inflateTiming=" + this.inflateTiming + ")";
    }

    public final Map<String, f> a() {
        return this.commonRequestPreload;
    }

    public final List<String> b() {
        return this.enableAnimaXPages;
    }

    public final List<String> c() {
        return this.enableAudioTT;
    }

    public final ArrayList<String> d() {
        return this.pageName;
    }

    public final Map<String, Integer> e() {
        return this.preInflate;
    }

    public d(Object r100) {
        this.topMall = null;
        this.bottomMall = null;
        this.pageName = null;
        this.commonRequestPreload = null;
        this.preInflate = null;
        this.enableAnimaXPages = null;
        this.enableAudioTT = null;
        this.inflateTiming = null;
    }
}
