package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MiniAppDetailData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/fg;", "", "", "interactId", "I", "", "name", "Ljava/lang/String;", "", "iconUrl", "Ljava/util/List;", "", "rank", "J", "groupType", "supportiveEntrance", "extra", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fg implements vh7.h {

    @SerializedName("extra")
    public String extra;

    @SerializedName("group_type")
    public long groupType;

    @SerializedName("icon_url")
    public List<String> iconUrl;

    @SerializedName("interact_id")
    public int interactId;

    @SerializedName("name")
    public String name;

    @SerializedName("rank")
    public long rank;

    @SerializedName("support_live_entrance_list")
    public List<Long> supportiveEntrance;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof fg) == false) goto L20;
        fg r101 = (fg) r100;
        if (this.interactId == r101.interactId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L12;
        return false;
    L12:
        if (this.rank == r101.rank) goto L14;
        return false;
    L14:
        if (this.groupType == r101.groupType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.supportiveEntrance, r101.supportiveEntrance) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.interactId * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.iconUrl;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = this.rank;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.groupType;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        List<Long> r111 = this.supportiveEntrance;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        String r114 = this.extra;
        if (r114 == null) goto L18;
        r102 = r114.hashCode();
    L18:
        return r113 + r102;
    L13:
        r112 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppDetailData(interactId=" + this.interactId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", rank=" + this.rank + ", groupType=" + this.groupType + ", supportiveEntrance=" + this.supportiveEntrance + ", extra=" + this.extra + ")";
    }

    public fg() {
        this.interactId = 0;
        this.name = "";
        this.iconUrl = new ArrayList();
        this.rank = 0;
        this.groupType = 0;
        this.supportiveEntrance = new ArrayList();
        this.extra = "";
    }

    public fg(am3.g r100) {
        this.iconUrl = new ArrayList();
        this.supportiveEntrance = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        List r104 = this.supportiveEntrance;
        Comparable r105 = Long.valueOf(r100.j());
    L12:
        r104.add(r105);
        goto L3
    L8:
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        this.groupType = r100.j();
        r102 = r102 | 4;
        goto L3
    L10:
        this.rank = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        r104 = this.iconUrl;
        r105 = am3.h.c(r100);
        goto L12
    L13:
        this.name = am3.h.c(r100);
        goto L3
    L14:
        this.interactId = (int) r100.j();
        r102 = r102 | 1;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L19;
        this.interactId = 0;
    L19:
        if (this.name != null) goto L22;
        this.name = "";
    L22:
        if (this.iconUrl.isEmpty() == false) goto L25;
        this.iconUrl = new ArrayList();
    L25:
        if ((r102 & 2) != 0) goto L28;
        this.rank = 0;
    L28:
        if ((r102 & 4) != 0) goto L31;
        this.groupType = 0;
    L31:
        if (this.supportiveEntrance.isEmpty() == false) goto L34;
        this.supportiveEntrance = new ArrayList();
    L34:
        if (this.extra != null) goto L54;
        this.extra = "";
        return;
    }
}
