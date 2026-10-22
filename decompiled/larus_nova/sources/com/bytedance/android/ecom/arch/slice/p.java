package com.bytedance.android.ecom.arch.slice;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/p;", "Lcom/bytedance/android/ecom/arch/slice/BaseSlice;", "", "isSplit", "Z", "b", "()Z", "", "Lcom/bytedance/android/ecom/arch/slice/g;", "childSlices", "Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p extends BaseSlice {

    @SerializedName("slices")
    private List<g> childSlices;

    @SerializedName("is_split")
    private final boolean isSplit;

    public p() {
        Map r100 = null;
        super("", null, null, null, r100, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER, null);
        this.isSplit = true;
        this.childSlices = null;
    }

    public final List<g> a() {
        return this.childSlices;
    }

    public final boolean b() {
        return this.isSplit;
    }

    public final void d(List<? extends g> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L5;
        r101.addAll(r100);
    L5:
        this.childSlices = r101;
    }

    public final boolean c(boolean r100, Function1<? super g, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "filter");
        nq.a.a();
        List<g> r102 = this.childSlices;
        if (r102 != null) goto L6;
        return false;
    L6:
        int r103 = com.bytedance.android.ecom.arch.slice.adapter.e.f50008e;
        return com.bytedance.android.ecom.arch.slice.adapter.e.a.c(r102, r100, r101);
    }
}
