package com.bytedance.android.ec.core.cart;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/cart/d;", "", "", "", "gulReloadScene", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "loadMoreOffsetItem", "I", "c", "()I", "errorMsg", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("error_msg")
    private final String errorMsg;

    @SerializedName("gul_reload_scene")
    private final List<String> gulReloadScene;

    @SerializedName("load_more_offset_item")
    private final int loadMoreOffsetItem;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.gulReloadScene, r101.gulReloadScene) == true) goto L8;
        return false;
    L8:
        if (this.loadMoreOffsetItem == r101.loadMoreOffsetItem) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.gulReloadScene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.loadMoreOffsetItem) * 31;
        String r104 = this.errorMsg;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadMoreInfo(gulReloadScene=" + this.gulReloadScene + ", loadMoreOffsetItem=" + this.loadMoreOffsetItem + ", errorMsg=" + this.errorMsg + ")";
    }

    public final String a() {
        return this.errorMsg;
    }

    public final List<String> b() {
        return this.gulReloadScene;
    }

    public final int c() {
        return this.loadMoreOffsetItem;
    }

    public d(Object r100) {
        List<String> r101 = CollectionsKt.listOf("changeTabNew");
        Intrinsics.checkNotNullParameter("部分商品加载失败，请重试", "errorMsg");
        this.gulReloadScene = r101;
        this.loadMoreOffsetItem = 4;
        this.errorMsg = "部分商品加载失败，请重试";
    }
}
