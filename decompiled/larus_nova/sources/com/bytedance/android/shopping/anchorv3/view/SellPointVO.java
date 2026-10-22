package com.bytedance.android.shopping.anchorv3.view;

import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B3\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J7\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component2", "component3", "", "component4", "sellPoint", "icon", "linkUrl", "iconRightDistance", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getSellPoint", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getLinkUrl", "I", "getIconRightDistance", "()I", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SellPointVO implements Serializable {
    public static final a Companion = null;
    private final ECUrlModel icon;
    private final int iconRightDistance;
    private final String linkUrl;
    private final String sellPoint;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ SellPointVO copy$default(SellPointVO r100, String r101, ECUrlModel r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.sellPoint;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.icon;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.linkUrl;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.iconRightDistance;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.sellPoint;
    }

    public final ECUrlModel component2() {
        return this.icon;
    }

    public final String component3() {
        return this.linkUrl;
    }

    public final int component4() {
        return this.iconRightDistance;
    }

    public final SellPointVO copy(String r100, ECUrlModel r101, String r102, int r103) {
        return new SellPointVO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SellPointVO) == false) goto L14;
        SellPointVO r101 = (SellPointVO) r100;
        if (Intrinsics.areEqual(this.sellPoint, r101.sellPoint) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.linkUrl, r101.linkUrl) == true) goto L12;
        return false;
    L12:
        if (this.iconRightDistance == r101.iconRightDistance) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.sellPoint;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.icon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.linkUrl;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.iconRightDistance;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SellPointVO(sellPoint=" + this.sellPoint + ", icon=" + this.icon + ", linkUrl=" + this.linkUrl + ", iconRightDistance=" + this.iconRightDistance + ")";
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final int getIconRightDistance() {
        return this.iconRightDistance;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getSellPoint() {
        return this.sellPoint;
    }

    public SellPointVO(String r100, ECUrlModel r101, String r102, int r103) {
        this.sellPoint = r100;
        this.icon = r101;
        this.linkUrl = r102;
        this.iconRightDistance = r103;
    }

    public /* synthetic */ SellPointVO(String r100, ECUrlModel r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
