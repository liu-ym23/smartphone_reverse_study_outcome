package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013JL\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "Ljava/io/Serializable;", "schema", "", "requestParams", "", "", "defaultImage", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "type", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;)V", "getDefaultImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getRequestParams", "()Ljava/util/Map;", "getSchema", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "equals", "", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonFindSameElement implements Serializable {

    @SerializedName("default_image")
    private final ImageModel defaultImage;

    @SerializedName("request_params")
    private final Map<String, Object> requestParams;
    private final String schema;

    @SerializedName("type")
    private final Integer type;

    public CommonFindSameElement() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFindSameElement copy$default(CommonFindSameElement r100, String r101, Map r102, ImageModel r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.schema;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.requestParams;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.defaultImage;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.type;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.schema;
    }

    public final Map<String, Object> component2() {
        return this.requestParams;
    }

    public final ImageModel component3() {
        return this.defaultImage;
    }

    public final Integer component4() {
        return this.type;
    }

    public final CommonFindSameElement copy(String r100, Map<String, ? extends Object> r101, ImageModel r102, Integer r103) {
        return new CommonFindSameElement(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonFindSameElement) == false) goto L14;
        CommonFindSameElement r101 = (CommonFindSameElement) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestParams, r101.requestParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultImage, r101.defaultImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.requestParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.defaultImage;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.type;
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

    public String toString() {
        return "CommonFindSameElement(schema=" + this.schema + ", requestParams=" + this.requestParams + ", defaultImage=" + this.defaultImage + ", type=" + this.type + ")";
    }

    public final ImageModel getDefaultImage() {
        return this.defaultImage;
    }

    public final Map<String, Object> getRequestParams() {
        return this.requestParams;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getType() {
        return this.type;
    }

    public CommonFindSameElement(String r100, Map<String, ? extends Object> r101, ImageModel r102, Integer r103) {
        this.schema = r100;
        this.requestParams = r101;
        this.defaultImage = r102;
        this.type = r103;
    }

    public /* synthetic */ CommonFindSameElement(String r100, Map r101, ImageModel r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
