package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J9\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/response/BannerInfo;", "Ljava/io/Serializable;", "", "component1", "", "Lcom/bytedance/android/ec/model/live/b;", "component2", "component3", "bgImageUrl", "leftContent", "rightContent", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getBgImageUrl", "()Ljava/lang/String;", "Ljava/util/List;", "getLeftContent", "()Ljava/util/List;", "getRightContent", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BannerInfo implements Serializable {

    @SerializedName("bg_image_url")
    private final String bgImageUrl;

    @SerializedName("left_content")
    private final List<com.bytedance.android.ec.model.live.b> leftContent;

    @SerializedName("right_content")
    private final List<com.bytedance.android.ec.model.live.b> rightContent;

    public BannerInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BannerInfo copy$default(BannerInfo r100, String r101, List r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bgImageUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.leftContent;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.rightContent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.bgImageUrl;
    }

    public final List<com.bytedance.android.ec.model.live.b> component2() {
        return this.leftContent;
    }

    public final List<com.bytedance.android.ec.model.live.b> component3() {
        return this.rightContent;
    }

    public final BannerInfo copy(String r100, List<com.bytedance.android.ec.model.live.b> r101, List<com.bytedance.android.ec.model.live.b> r102) {
        return new BannerInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BannerInfo) == false) goto L12;
        BannerInfo r101 = (BannerInfo) r100;
        if (Intrinsics.areEqual(this.bgImageUrl, r101.bgImageUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftContent, r101.leftContent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightContent, r101.rightContent) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.bgImageUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.ec.model.live.b> r104 = this.leftContent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.ec.model.live.b> r107 = this.rightContent;
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
        return "BannerInfo(bgImageUrl=" + this.bgImageUrl + ", leftContent=" + this.leftContent + ", rightContent=" + this.rightContent + ")";
    }

    public final String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public final List<com.bytedance.android.ec.model.live.b> getLeftContent() {
        return this.leftContent;
    }

    public final List<com.bytedance.android.ec.model.live.b> getRightContent() {
        return this.rightContent;
    }

    public BannerInfo(String r100, List<com.bytedance.android.ec.model.live.b> r101, List<com.bytedance.android.ec.model.live.b> r102) {
        this.bgImageUrl = r100;
        this.leftContent = r101;
        this.rightContent = r102;
    }

    public /* synthetic */ BannerInfo(String r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
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
