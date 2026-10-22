package com.bytedance.android.shopping.card_list.widgets.nest;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.card_list.eventcenter.event.ScrollMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.android.shopping.card_list.components.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f172011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.card_list.widgets.b f172012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Unit> f172013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Integer> f172014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Integer, Boolean> f172015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Unit> f172016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Unit> f172017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Pair<Integer, ScrollMode>> f172018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Unit> f172019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Boolean> f172020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Boolean> f172021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Integer> f172022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Boolean> f172023n;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.f172011b;
    }

    public d(LifecycleOwner r110) {
        com.bytedance.android.shopping.card_list.widgets.b r100 = new com.bytedance.android.shopping.card_list.widgets.b(r110);
        MutableLiveData<Unit> r101 = new MutableLiveData();
        MutableLiveData<Integer> r102 = new MutableLiveData(0);
        CardListTwoRevViewState$1 r103 = CardListTwoRevViewState$1.INSTANCE;
        MutableLiveData<Unit> r104 = new MutableLiveData();
        MutableLiveData<Unit> r105 = new MutableLiveData();
        MutableLiveData<Pair<Integer, ScrollMode>> r106 = new MutableLiveData();
        MutableLiveData<Unit> r107 = new MutableLiveData();
        CardListTwoRevViewState$2 r108 = CardListTwoRevViewState$2.INSTANCE;
        MutableLiveData<Boolean> r111 = new MutableLiveData();
        MutableLiveData<Integer> r112 = new MutableLiveData(0);
        CardListTwoRevViewState$3 r109 = CardListTwoRevViewState$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r100, "gulState");
        Intrinsics.checkNotNullParameter(r101, "jumpToTop");
        Intrinsics.checkNotNullParameter(r102, "outerHeight");
        Intrinsics.checkNotNullParameter(r103, "canScrollVerticallyAsMultiList");
        Intrinsics.checkNotNullParameter(r104, "jumpToCardRevList");
        Intrinsics.checkNotNullParameter(r105, "justify");
        Intrinsics.checkNotNullParameter(r106, "scrollToPosition");
        Intrinsics.checkNotNullParameter(r107, "scrollToCardListForLoadMoreEnd");
        Intrinsics.checkNotNullParameter(r108, "canScrollDown");
        Intrinsics.checkNotNullParameter(r111, "setViewAccessibility");
        Intrinsics.checkNotNullParameter(r112, "setLoadMoreFooterViewHeight");
        Intrinsics.checkNotNullParameter(r109, "isFirstRevAtTop");
        super(r110);
        this.f172011b = r110;
        this.f172012c = r100;
        this.f172013d = r101;
        this.f172014e = r102;
        this.f172015f = r103;
        this.f172016g = r104;
        this.f172017h = r105;
        this.f172018i = r106;
        this.f172019j = r107;
        this.f172020k = r108;
        this.f172021l = r111;
        this.f172022m = r112;
        this.f172023n = r109;
    }
}
