package com.bytedance.android.shopping.card_list.widgets.nest;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListTwoRevViewAction implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f171999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f172000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f172001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Integer, Unit> f172002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Float, Float, Unit> f172003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.card_list.widgets.a f172004f;

    public /* synthetic */ CardListTwoRevViewAction(com.bytedance.android.shopping.card_list.widgets.a r100) {
        this(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE, AnonymousClass5.INSTANCE, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListTwoRevViewAction(Function1<? super Integer, Unit> r100, Function0<String> r101, Function0<String> r102, Function1<? super Integer, Unit> r103, Function2<? super Float, ? super Float, Unit> r104, com.bytedance.android.shopping.card_list.widgets.a r105) {
        Intrinsics.checkNotNullParameter(r100, "onNestedPreScroll");
        Intrinsics.checkNotNullParameter(r101, "getSessionId");
        Intrinsics.checkNotNullParameter(r102, "getMonitorId");
        Intrinsics.checkNotNullParameter(r103, "backToTop");
        Intrinsics.checkNotNullParameter(r104, "onScroll");
        Intrinsics.checkNotNullParameter(r105, "gulAction");
        this.f171999a = r100;
        this.f172000b = r101;
        this.f172001c = r102;
        this.f172002d = r103;
        this.f172003e = r104;
        this.f172004f = r105;
    }
}
