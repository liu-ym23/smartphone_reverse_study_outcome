package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappBanner")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/a;", "", "", "groupId", "J", "Lcom/bytedance/android/live/base/model/ImageModel;", "imageUrl", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "type", "I", "", "schema", "Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("image_url")
    public ImageModel imageUrl;

    @SerializedName("schema")
    public String schema;

    @SerializedName("type")
    public int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.groupId == r101.groupId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.groupId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        ImageModel r102 = this.imageUrl;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((r101 + r104) * 31) + this.type) * 31;
        String r106 = this.schema;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppBanner(groupId=" + this.groupId + ", imageUrl=" + this.imageUrl + ", type=" + this.type + ", schema=" + this.schema + ")";
    }

    public a() {
        this.groupId = 0;
        this.imageUrl = null;
        this.type = 0;
        this.schema = null;
    }

    public a(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.groupId = r100.i();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.imageUrl = x.a(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.type = (int) r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.schema = am3.h.c(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L21;
        this.groupId = 0;
    L21:
        if (this.imageUrl != null) goto L24;
        this.imageUrl = null;
    L24:
        if ((r102 & 2) != 0) goto L27;
        this.type = 0;
    L27:
        if (this.schema != null) goto L45;
        this.schema = null;
        return;
    }
}
