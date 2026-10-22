package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/p;", "", "", "tabId", "Ljava/lang/Long;", "getTabId", "()Ljava/lang/Long;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "url", "getUrl", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p implements vh7.h {

    @SerializedName("icon_url")
    protected String iconUrl;

    @SerializedName("name")
    protected String name;

    @SerializedName("tab_id")
    protected Long tabId;

    @SerializedName("url")
    protected String url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.tabId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
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
        return "TabInfo(tabId=" + this.tabId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", url=" + this.url + ")";
    }

    public p() {
        this.tabId = null;
        this.name = null;
        this.iconUrl = null;
        this.url = null;
    }

    public p(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.tabId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.iconUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.url = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.tabId != null) goto L22;
        this.tabId = null;
    L22:
        if (this.name != null) goto L25;
        this.name = null;
    L25:
        if (this.iconUrl != null) goto L28;
        this.iconUrl = null;
    L28:
        if (this.url != null) goto L46;
        this.url = null;
        return;
    }
}
