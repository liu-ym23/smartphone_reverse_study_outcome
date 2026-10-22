package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.ModifyShelfResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/k;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName("shelf_info")
    protected ShelfInfo shelfInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.shelfInfo, ((k) r100).shelfInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ShelfInfo r100 = this.shelfInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ModifyShelfResponse(shelfInfo=" + this.shelfInfo + ")";
    }

    public k() {
        this.shelfInfo = null;
    }

    public final ShelfInfo a() {
        return this.shelfInfo;
    }

    public k(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.shelfInfo = new ShelfInfo(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.shelfInfo != null) goto L19;
        this.shelfInfo = null;
        return;
    }
}
