package com.bytedance.android.ec.hybrid.list;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/g;", "", "", "subscribedExtraLive", "Ljava/lang/Integer;", "getSubscribedExtraLive", "()Ljava/lang/Integer;", "", "subscribedOnlyExtra", "Ljava/lang/Boolean;", "getSubscribedOnlyExtra", "()Ljava/lang/Boolean;", "", "", "subscribedPageName", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "subscribedVisibleCardNotDisappear", "b", "unsubscribedPageName", "c", "subscribedStatusChangeRefreshStrategy", "getSubscribedStatusChangeRefreshStrategy", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("subscribed_extra_live")
    private final Integer subscribedExtraLive;

    @SerializedName("subscribed_only_extra")
    private final Boolean subscribedOnlyExtra;

    @SerializedName("subscribed_page_name")
    private final List<String> subscribedPageName;

    @SerializedName("subscribed_status_change_refresh_strategy")
    private final Integer subscribedStatusChangeRefreshStrategy;

    @SerializedName("subscribed_visible_card_not_disappear")
    private final Boolean subscribedVisibleCardNotDisappear;

    @SerializedName("unsubscribed_page_name")
    private final List<String> unsubscribedPageName;

    public static final class a {
    }

    static {
    }

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L18;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.subscribedExtraLive, r101.subscribedExtraLive) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subscribedOnlyExtra, r101.subscribedOnlyExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subscribedPageName, r101.subscribedPageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subscribedVisibleCardNotDisappear, r101.subscribedVisibleCardNotDisappear) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.unsubscribedPageName, r101.unsubscribedPageName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.subscribedStatusChangeRefreshStrategy, r101.subscribedStatusChangeRefreshStrategy) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.subscribedExtraLive;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.subscribedOnlyExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.subscribedPageName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.subscribedVisibleCardNotDisappear;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.unsubscribedPageName;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.subscribedStatusChangeRefreshStrategy;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "MallSubscribedLiveStatusConfig(subscribedExtraLive=" + this.subscribedExtraLive + ", subscribedOnlyExtra=" + this.subscribedOnlyExtra + ", subscribedPageName=" + this.subscribedPageName + ", subscribedVisibleCardNotDisappear=" + this.subscribedVisibleCardNotDisappear + ", unsubscribedPageName=" + this.unsubscribedPageName + ", subscribedStatusChangeRefreshStrategy=" + this.subscribedStatusChangeRefreshStrategy + ")";
    }

    public final List<String> a() {
        return this.subscribedPageName;
    }

    public final Boolean b() {
        return this.subscribedVisibleCardNotDisappear;
    }

    public final List<String> c() {
        return this.unsubscribedPageName;
    }

    public g(Object r100) {
        this.subscribedExtraLive = null;
        this.subscribedOnlyExtra = null;
        this.subscribedPageName = null;
        this.subscribedVisibleCardNotDisappear = null;
        this.unsubscribedPageName = null;
        this.subscribedStatusChangeRefreshStrategy = null;
    }
}
