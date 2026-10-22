package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/t0;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/u0;", "searchResult", "Ljava/util/List;", "getSearchResult", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t0 implements vh7.h {

    @SerializedName("search_result")
    protected List<u0> searchResult;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.searchResult, ((t0) r100).searchResult) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<u0> r100 = this.searchResult;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SearchFingerprintResponse(searchResult=" + this.searchResult + ")";
    }

    public t0() {
        this.searchResult = null;
    }

    public t0(am3.g r100) {
        this.searchResult = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.searchResult.add(new u0(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.searchResult.isEmpty() == false) goto L19;
        this.searchResult = null;
        return;
    }
}
