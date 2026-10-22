package com.bytedance.android.shopping.slice.preload;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00124\b\u0002\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007HÆ\u0003JW\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u000524\b\u0002\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001RB\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/slice/preload/SlcWarmUpItem;", "Ljava/io/Serializable;", "templateName", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "dataList", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "getTemplate", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getTemplateName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcWarmUpItem implements Serializable {

    @SerializedName("data_list")
    private final List<HashMap<String, Object>> dataList;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private final SlcElement template;

    @SerializedName("template_name")
    private final String templateName;

    public SlcWarmUpItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlcWarmUpItem copy$default(SlcWarmUpItem r100, String r101, SlcElement r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.templateName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.template;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.dataList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.templateName;
    }

    public final SlcElement component2() {
        return this.template;
    }

    public final List<HashMap<String, Object>> component3() {
        return this.dataList;
    }

    public final SlcWarmUpItem copy(String r100, SlcElement r101, List<? extends HashMap<String, Object>> r102) {
        return new SlcWarmUpItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SlcWarmUpItem) == false) goto L12;
        SlcWarmUpItem r101 = (SlcWarmUpItem) r100;
        if (Intrinsics.areEqual(this.templateName, r101.templateName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dataList, r101.dataList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.templateName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SlcElement r104 = this.template;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<HashMap<String, Object>> r107 = this.dataList;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SlcWarmUpItem(templateName=" + this.templateName + ", template=" + this.template + ", dataList=" + this.dataList + ")";
    }

    public final List<HashMap<String, Object>> getDataList() {
        return this.dataList;
    }

    public final SlcElement getTemplate() {
        return this.template;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcWarmUpItem(String r100, SlcElement r101, List<? extends HashMap<String, Object>> r102) {
        this.templateName = r100;
        this.template = r101;
        this.dataList = r102;
    }

    public /* synthetic */ SlcWarmUpItem(String r100, SlcElement r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
