package com.bytedance.android.live.core.paging.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModelV2;", "Lcom/bytedance/android/live/core/utils/rxutils/RxViewModel;", "networkState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/core/network/NetworkStat;", "refreshState", "empty", "", "hasMore", EventConstant.Value.RETRY, "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getEmpty", "()Landroidx/lifecycle/MutableLiveData;", "getHasMore", "getNetworkState", "getRefreshState", "getRetry", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagingViewModelV2 extends RxViewModel {
    private final MutableLiveData<Boolean> empty;
    private final MutableLiveData<Boolean> hasMore;
    private final MutableLiveData<NetworkStat> networkState;
    private final MutableLiveData<NetworkStat> refreshState;
    private final MutableLiveData<Boolean> retry;

    public PagingViewModelV2() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagingViewModelV2 copy$default(PagingViewModelV2 r100, MutableLiveData r101, MutableLiveData r102, MutableLiveData r103, MutableLiveData r104, MutableLiveData r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.networkState;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.refreshState;
    L8:
        MutableLiveData r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.empty;
    L11:
        MutableLiveData r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hasMore;
    L14:
        MutableLiveData r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.retry;
    L17:
        MutableLiveData r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final MutableLiveData<NetworkStat> component1() {
        return this.networkState;
    }

    public final MutableLiveData<NetworkStat> component2() {
        return this.refreshState;
    }

    public final MutableLiveData<Boolean> component3() {
        return this.empty;
    }

    public final MutableLiveData<Boolean> component4() {
        return this.hasMore;
    }

    public final MutableLiveData<Boolean> component5() {
        return this.retry;
    }

    public final PagingViewModelV2 copy(MutableLiveData<NetworkStat> r100, MutableLiveData<NetworkStat> r101, MutableLiveData<Boolean> r110, MutableLiveData<Boolean> r111, MutableLiveData<Boolean> r112) {
        Intrinsics.checkNotNullParameter(r100, "networkState");
        Intrinsics.checkNotNullParameter(r101, "refreshState");
        Intrinsics.checkNotNullParameter(r110, "empty");
        Intrinsics.checkNotNullParameter(r111, "hasMore");
        Intrinsics.checkNotNullParameter(r112, EventConstant.Value.RETRY);
        return new PagingViewModelV2(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PagingViewModelV2) == false) goto L16;
        PagingViewModelV2 r101 = (PagingViewModelV2) r100;
        if (Intrinsics.areEqual(this.networkState, r101.networkState) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.refreshState, r101.refreshState) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.empty, r101.empty) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.retry, r101.retry) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        MutableLiveData<NetworkStat> r100 = this.networkState;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        MutableLiveData<NetworkStat> r104 = this.refreshState;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MutableLiveData<Boolean> r107 = this.empty;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        MutableLiveData<Boolean> r110 = this.hasMore;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        MutableLiveData<Boolean> r113 = this.retry;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "PagingViewModelV2(networkState=" + this.networkState + ", refreshState=" + this.refreshState + ", empty=" + this.empty + ", hasMore=" + this.hasMore + ", retry=" + this.retry + ")";
    }

    public final MutableLiveData<Boolean> getEmpty() {
        return this.empty;
    }

    public final MutableLiveData<Boolean> getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<NetworkStat> getNetworkState() {
        return this.networkState;
    }

    public final MutableLiveData<NetworkStat> getRefreshState() {
        return this.refreshState;
    }

    public final MutableLiveData<Boolean> getRetry() {
        return this.retry;
    }

    public PagingViewModelV2(MutableLiveData<NetworkStat> r100, MutableLiveData<NetworkStat> r101, MutableLiveData<Boolean> r102, MutableLiveData<Boolean> r103, MutableLiveData<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, "networkState");
        Intrinsics.checkNotNullParameter(r101, "refreshState");
        Intrinsics.checkNotNullParameter(r102, "empty");
        Intrinsics.checkNotNullParameter(r103, "hasMore");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Value.RETRY);
        this.networkState = r100;
        this.refreshState = r101;
        this.empty = r102;
        this.hasMore = r103;
        this.retry = r104;
    }

    public /* synthetic */ PagingViewModelV2(MutableLiveData r100, MutableLiveData r101, MutableLiveData r102, MutableLiveData r103, MutableLiveData r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = new MutableLiveData();
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = new MutableLiveData();
    L8:
        MutableLiveData r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = new MutableLiveData();
    L11:
        MutableLiveData r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = new MutableLiveData();
    L14:
        MutableLiveData r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = new MutableLiveData();
    L17:
        MutableLiveData r108 = r100;
        this(r108, r111, r106, r107, r104);
    }
}
