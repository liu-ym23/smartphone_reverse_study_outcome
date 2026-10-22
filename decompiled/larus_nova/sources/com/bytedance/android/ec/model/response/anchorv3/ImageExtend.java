package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ImageExtend;", "Ljava/io/Serializable;", "type", "", "label", "images", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getImages", "()Ljava/util/List;", "getLabel", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ImageExtend implements Serializable {

    @SerializedName("images")
    private final List<ECUrlModel> images;

    @SerializedName("label")
    private final String label;

    @SerializedName("type")
    private final String type;

    public ImageExtend() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageExtend copy$default(ImageExtend r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.label;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.images;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.label;
    }

    public final List<ECUrlModel> component3() {
        return this.images;
    }

    public final ImageExtend copy(String r100, String r101, List<? extends ECUrlModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "images");
        return new ImageExtend(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageExtend) == false) goto L12;
        ImageExtend r101 = (ImageExtend) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.label;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ECUrlModel> r107 = this.images;
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
        return "ImageExtend(type=" + this.type + ", label=" + this.label + ", images=" + this.images + ")";
    }

    public final List<ECUrlModel> getImages() {
        return this.images;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageExtend(String r100, String r101, List<? extends ECUrlModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "images");
        this.type = r100;
        this.label = r101;
        this.images = r102;
    }

    public /* synthetic */ ImageExtend(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        this(r100, r101, r102);
    }
}
