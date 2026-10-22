package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/h;", "", "", "Lcom/bytedance/android/live/soloktv/model/p;", "tabList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("tab_list")
    protected List<p> tabList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.tabList, ((h) r100).tabList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<p> r100 = this.tabList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PersonalKaraokeTabListResponse(tabList=" + this.tabList + ")";
    }

    public h() {
        this.tabList = null;
    }

    public final List<p> a() {
        return this.tabList;
    }

    public h(am3.g r100) {
        this.tabList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.tabList.add(new p(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.tabList.isEmpty() == false) goto L19;
        this.tabList = null;
        return;
    }
}
