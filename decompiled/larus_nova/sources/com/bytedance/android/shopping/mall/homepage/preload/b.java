package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/preload/b;", "", "", "itemType", "Ljava/lang/Integer;", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "loadNum", "getLoadNum", "setLoadNum", "", "", "urlReplace", "Ljava/util/Map;", "getUrlReplace", "()Ljava/util/Map;", "setUrlReplace", "(Ljava/util/Map;)V", "schemaReplace", "getSchemaReplace", "setSchemaReplace", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("load_num")
    private Integer loadNum;

    @SerializedName("schema_replace")
    private Map<String, String> schemaReplace;

    @SerializedName("url_replace")
    private Map<String, String> urlReplace;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadNum, r101.loadNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.urlReplace, r101.urlReplace) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemaReplace, r101.schemaReplace) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.loadNum;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.urlReplace;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.schemaReplace;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "MallLynxCardPreCreateInnerConfig(itemType=" + this.itemType + ", loadNum=" + this.loadNum + ", urlReplace=" + this.urlReplace + ", schemaReplace=" + this.schemaReplace + ")";
    }

    public b() {
        this.itemType = null;
        this.loadNum = null;
        this.urlReplace = null;
        this.schemaReplace = null;
    }
}
