package com.bytedance.android.ec.model.promotion;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECUIActivity;", "Ljava/io/Serializable;", "activityIcon", "", "activityType", "", "activityId", "activityBanner", "activityBannerLandscape", "activityBannerSmall", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityBanner", "()Ljava/lang/String;", "getActivityBannerLandscape", "getActivityBannerSmall", "getActivityIcon", "getActivityId", "()J", "getActivityType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIActivity implements Serializable {
    private final String activityBanner;
    private final String activityBannerLandscape;
    private final String activityBannerSmall;
    private final String activityIcon;
    private final long activityId;
    private final long activityType;

    public ECUIActivity() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    public static /* synthetic */ ECUIActivity copy$default(ECUIActivity r100, String r110, long r111, long r112, String r113, String r114, String r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        String r101 = r100.activityIcon;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = r100.activityType;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.activityId;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.activityBanner;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.activityBannerLandscape;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r106 = r100.activityBannerSmall;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.activityIcon;
    }

    public final long component2() {
        return this.activityType;
    }

    public final long component3() {
        return this.activityId;
    }

    public final String component4() {
        return this.activityBanner;
    }

    public final String component5() {
        return this.activityBannerLandscape;
    }

    public final String component6() {
        return this.activityBannerSmall;
    }

    public final ECUIActivity copy(String r110, long r111, long r112, String r113, String r114, String r115) {
        return new ECUIActivity(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUIActivity) == false) goto L18;
        ECUIActivity r101 = (ECUIActivity) r100;
        if (Intrinsics.areEqual(this.activityIcon, r101.activityIcon) == true) goto L8;
        return false;
    L8:
        if (this.activityType == r101.activityType) goto L10;
        return false;
    L10:
        if (this.activityId == r101.activityId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activityBanner, r101.activityBanner) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activityBannerLandscape, r101.activityBannerLandscape) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityBannerSmall, r101.activityBannerSmall) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.activityIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.activityType;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.activityId;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.activityBanner;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.activityBannerLandscape;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.activityBannerSmall;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECUIActivity(activityIcon=" + this.activityIcon + ", activityType=" + this.activityType + ", activityId=" + this.activityId + ", activityBanner=" + this.activityBanner + ", activityBannerLandscape=" + this.activityBannerLandscape + ", activityBannerSmall=" + this.activityBannerSmall + ")";
    }

    public final String getActivityBanner() {
        return this.activityBanner;
    }

    public final String getActivityBannerLandscape() {
        return this.activityBannerLandscape;
    }

    public final String getActivityBannerSmall() {
        return this.activityBannerSmall;
    }

    public final String getActivityIcon() {
        return this.activityIcon;
    }

    public final long getActivityId() {
        return this.activityId;
    }

    public final long getActivityType() {
        return this.activityType;
    }

    public ECUIActivity(String r100, long r101, long r102, String r103, String r104, String r105) {
        this.activityIcon = r100;
        this.activityType = r101;
        this.activityId = r102;
        this.activityBanner = r103;
        this.activityBannerLandscape = r104;
        this.activityBannerSmall = r105;
    }

    public /* synthetic */ ECUIActivity(String r110, long r111, long r112, String r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
        String r100 = null;
        if ((r116 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        long r102 = 0;
        if ((r116 & 2) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r116 & 4) != 0) goto L15;
        r102 = r112;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r100 = r115;
    L26:
        this(r101, r103, r102, r104, r105, r100);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
