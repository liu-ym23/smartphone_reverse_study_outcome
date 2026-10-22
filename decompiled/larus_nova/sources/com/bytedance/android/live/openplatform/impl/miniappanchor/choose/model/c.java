package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappGroupProperty")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/c;", "", "", "name", "Ljava/lang/String;", "", "capacity", "J", "groupId", "liveDesc", "liveDescLinkUrl", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("capacity")
    public long capacity;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("live_desc")
    public String liveDesc;

    @SerializedName("live_desc_link_url")
    public String liveDescLinkUrl;

    @SerializedName("name")
    public String name;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.capacity == r101.capacity) goto L10;
        return false;
    L10:
        if (this.groupId == r101.groupId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveDesc, r101.liveDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveDescLinkUrl, r101.liveDescLinkUrl) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.capacity;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.groupId;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.liveDesc;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.liveDescLinkUrl;
        if (r110 == null) goto L14;
        r101 = r110.hashCode();
    L14:
        return r109 + r101;
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppGroupProperty(name=" + this.name + ", capacity=" + this.capacity + ", groupId=" + this.groupId + ", liveDesc=" + this.liveDesc + ", liveDescLinkUrl=" + this.liveDescLinkUrl + ")";
    }

    public c() {
        this.name = null;
        this.capacity = 0;
        this.groupId = 0;
        this.liveDesc = null;
        this.liveDescLinkUrl = null;
    }

    public c(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.name = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.capacity = r100.j();
        r102 = r102 | 1;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.groupId = r100.i();
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.liveDescLinkUrl = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.liveDesc = am3.h.c(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this.name != null) goto L24;
        this.name = null;
    L24:
        if ((r102 & 1) != 0) goto L27;
        this.capacity = 0;
    L27:
        if ((r102 & 2) != 0) goto L30;
        this.groupId = 0;
    L30:
        if (this.liveDesc != null) goto L33;
        this.liveDesc = null;
    L33:
        if (this.liveDescLinkUrl != null) goto L54;
        this.liveDescLinkUrl = null;
        return;
    }
}
