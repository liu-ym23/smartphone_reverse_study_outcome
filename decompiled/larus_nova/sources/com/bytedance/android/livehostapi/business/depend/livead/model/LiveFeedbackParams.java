package com.bytedance.android.livehostapi.business.depend.livead.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveFeedbackParams;", "", "enterMethod", "", "creativeId", "adId", "logExtra", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdId", "()Ljava/lang/String;", "getCreativeId", "getEnterMethod", "getLogExtra", "getTag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedbackParams {
    private final String adId;
    private final String creativeId;
    private final String enterMethod;
    private final String logExtra;
    private final String tag;

    public static /* synthetic */ LiveFeedbackParams copy$default(LiveFeedbackParams r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enterMethod;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.creativeId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.adId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.logExtra;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tag;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.enterMethod;
    }

    public final String component2() {
        return this.creativeId;
    }

    public final String component3() {
        return this.adId;
    }

    public final String component4() {
        return this.logExtra;
    }

    public final String component5() {
        return this.tag;
    }

    public final LiveFeedbackParams copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r101, "creativeId");
        Intrinsics.checkNotNullParameter(r110, "adId");
        Intrinsics.checkNotNullParameter(r112, "tag");
        return new LiveFeedbackParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedbackParams) == false) goto L16;
        LiveFeedbackParams r101 = (LiveFeedbackParams) r100;
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.adId, r101.adId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.enterMethod;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.creativeId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.adId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.logExtra;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tag;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public String toString() {
        return "LiveFeedbackParams(enterMethod=" + this.enterMethod + ", creativeId=" + this.creativeId + ", adId=" + this.adId + ", logExtra=" + this.logExtra + ", tag=" + this.tag + ")";
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getTag() {
        return this.tag;
    }

    public LiveFeedbackParams(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r101, "creativeId");
        Intrinsics.checkNotNullParameter(r102, "adId");
        Intrinsics.checkNotNullParameter(r104, "tag");
        this.enterMethod = r100;
        this.creativeId = r101;
        this.adId = r102;
        this.logExtra = r103;
        this.tag = r104;
    }

    public /* synthetic */ LiveFeedbackParams(String r100, String r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = "draw_ad";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
