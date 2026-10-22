package com.bytedance.android.shopping.new_cart.widgets;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f179494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f179495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f179496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f179497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Integer> f179498e;

    public k() {
        this(null, null, null, null, null, 31);
    }

    public k(Function0 r100, Function0 r101, Function0 r102, Function0 r103, Function0 r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = LoadingViewAction$1.INSTANCE;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = LoadingViewAction$2.INSTANCE;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = LoadingViewAction$3.INSTANCE;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = LoadingViewAction$4.INSTANCE;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = LoadingViewAction$5.INSTANCE;
    L17:
        Intrinsics.checkNotNullParameter(r100, "showTitleBar");
        Intrinsics.checkNotNullParameter(r101, "onRLBarClick");
        Intrinsics.checkNotNullParameter(r102, "darkMode");
        Intrinsics.checkNotNullParameter(r103, "isHalfPanel");
        Intrinsics.checkNotNullParameter(r104, "getScreenOrSplitWidth");
        this.f179494a = r100;
        this.f179495b = r101;
        this.f179496c = r102;
        this.f179497d = r103;
        this.f179498e = r104;
    }
}
