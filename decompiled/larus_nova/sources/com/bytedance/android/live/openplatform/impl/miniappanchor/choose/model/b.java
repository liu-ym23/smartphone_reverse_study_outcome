package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import faceverify.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappInteractEntranceResponse.Data")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/b;", "", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/MiniAppEntranceCell;", "entranceList", "Ljava/util/List;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/a;", "bannerList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/c;", "groupPropertyList", "", "noUpdate", "Z", "", w.BLOB_ELEM_IMAGE_HASHCODE, "Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("banner")
    protected List<a> bannerList;

    @SerializedName("entrance_list")
    public List<MiniAppEntranceCell> entranceList;

    @SerializedName("group_properties")
    public List<c> groupPropertyList;

    @SerializedName(w.BLOB_ELEM_IMAGE_HASHCODE)
    public String hash;

    @SerializedName("no_update")
    public boolean noUpdate;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.entranceList, r101.entranceList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bannerList, r101.bannerList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.groupPropertyList, r101.groupPropertyList) == true) goto L12;
        return false;
    L12:
        if (this.noUpdate == r101.noUpdate) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hash, r101.hash) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        List<MiniAppEntranceCell> r100 = this.entranceList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<a> r104 = this.bannerList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<c> r107 = this.groupPropertyList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.noUpdate;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.hash;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
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
        return "MiniAppEntranceResponse(entranceList=" + this.entranceList + ", bannerList=" + this.bannerList + ", groupPropertyList=" + this.groupPropertyList + ", noUpdate=" + this.noUpdate + ", hash=" + this.hash + ")";
    }

    public b() {
        this.entranceList = null;
        this.bannerList = null;
        this.groupPropertyList = null;
        this.noUpdate = false;
        this.hash = null;
    }

    public final List<a> a() {
        return this.bannerList;
    }

    public b(g r100) {
        this.entranceList = new ArrayList();
        this.bannerList = new ArrayList();
        this.groupPropertyList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L11;
        this.noUpdate = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.hash = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 6) goto L14;
        List r104 = this.bannerList;
        h r105 = new a(r100);
    L20:
        r104.add(r105);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L18:
        r104 = this.groupPropertyList;
        r105 = new c(r100);
        goto L20
    L19:
        r104 = this.entranceList;
        r105 = new MiniAppEntranceCell(r100);
        goto L20
    L21:
        r100.d(r101);
        if (this.entranceList.isEmpty() == false) goto L25;
        this.entranceList = null;
    L25:
        if (this.bannerList.isEmpty() == false) goto L28;
        this.bannerList = null;
    L28:
        if (this.groupPropertyList.isEmpty() == false) goto L31;
        this.groupPropertyList = null;
    L31:
        if ((r102 & true) == true) goto L34;
        this.noUpdate = false;
    L34:
        if (this.hash != null) goto L51;
        this.hash = null;
        return;
    }
}
