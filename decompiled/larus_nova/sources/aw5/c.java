package aw5;

import com.bytedance.flow.search.kmp.api.model.FlowFilterData;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.flow.search.kmp.api.store.SearchLoadingState;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchLoadingState f16541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<FlowSearchData>> f16542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f16543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowFilterData f16544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FlowQuery f16547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SearchCursor f16548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Throwable f16549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f16551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f16552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f16553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f16554n;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f16541a == r101.f16541a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16542b, r101.f16542b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16543c, r101.f16543c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16544d, r101.f16544d) == true) goto L21;
        return false;
    L21:
        if (this.f16545e == r101.f16545e) goto L24;
        return false;
    L24:
        if (this.f16546f == r101.f16546f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f16547g, r101.f16547g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f16548h, r101.f16548h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f16549i, r101.f16549i) == true) goto L36;
        return false;
    L36:
        if (this.f16550j == r101.f16550j) goto L39;
        return false;
    L39:
        if (this.f16551k == r101.f16551k) goto L42;
        return false;
    L42:
        if (this.f16552l == r101.f16552l) goto L45;
        return false;
    L45:
        if (this.f16553m == r101.f16553m) goto L48;
        return false;
    L48:
        if (this.f16554n == r101.f16554n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f16541a.hashCode() * 31) + this.f16542b.hashCode()) * 31) + this.f16543c.hashCode()) * 31;
        FlowFilterData r101 = this.f16544d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f16545e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f16546f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        FlowQuery r110 = this.f16547g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SearchCursor r113 = this.f16548h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Throwable r116 = this.f16549i;
        if (r116 == null) goto L26;
        r102 = r116.hashCode();
    L26:
        int r117 = (r115 + r102) * 31;
        if (this.f16550j == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f16551k == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.f16552l == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.f16553m == false) goto L41;
        int r124 = 1231;
    L42:
        int r125 = (r123 + r124) * 31;
        if (this.f16554n == true) goto L47;
        r105 = 1237;
    L47:
        return r125 + r105;
    L41:
        r124 = 1237;
        goto L42
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowSearchState(loadingState=" + this.f16541a + ", resultModules=" + this.f16542b + ", resultModuleOrder=" + this.f16543c + ", filterData=" + this.f16544d + ", isHistoryManaging=" + this.f16545e + ", isHistoryExpanded=" + this.f16546f + ", currentQuery=" + this.f16547g + ", loadMoreCursor=" + this.f16548h + ", error=" + this.f16549i + ", isEmpty=" + this.f16550j + ", downGradeSingle=" + this.f16551k + ", halfYearConsumed=" + this.f16552l + ", halfYearHitLocal=" + this.f16553m + ", halfYearHitRemote=" + this.f16554n + ')';
    }

    public /* synthetic */ c(int r110) {
        this(SearchLoadingState.Loading, MapsKt.emptyMap(), CollectionsKt.emptyList(), null, false, false, null, null, null, false, false, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(SearchLoadingState r100, Map<String, ? extends List<FlowSearchData>> r101, List<String> r102, FlowFilterData r103, boolean r104, boolean r105, FlowQuery r106, SearchCursor r107, Throwable r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "loadingState");
        Intrinsics.checkNotNullParameter(r101, "resultModules");
        Intrinsics.checkNotNullParameter(r102, "resultModuleOrder");
        this.f16541a = r100;
        this.f16542b = r101;
        this.f16543c = r102;
        this.f16544d = r103;
        this.f16545e = r104;
        this.f16546f = r105;
        this.f16547g = r106;
        this.f16548h = r107;
        this.f16549i = r110;
        this.f16550j = r111;
        this.f16551k = r112;
        this.f16552l = r113;
        this.f16553m = r114;
        this.f16554n = r115;
    }
}
