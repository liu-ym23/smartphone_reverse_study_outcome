package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/g;", "", "", "Lcom/bytedance/android/live/soloktv/model/m;", "recommendItems", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g implements vh7.h {

    @SerializedName("room_list")
    protected List<m> recommendItems;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.recommendItems, ((g) r100).recommendItems) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<m> r100 = this.recommendItems;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PersonalKaraokeKtvLiveRoomRecommendResponse(recommendItems=" + this.recommendItems + ")";
    }

    public g() {
        this.recommendItems = null;
    }

    public final List<m> a() {
        return this.recommendItems;
    }

    public g(am3.g r100) {
        this.recommendItems = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.recommendItems.add(new m(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.recommendItems.isEmpty() == false) goto L19;
        this.recommendItems = null;
        return;
    }
}
