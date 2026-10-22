package com.bytedance.android.shopping.card_list.widgets;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f171943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f171944b;

    public a(int r100) {
        CardListGULViewAction$1 r101 = CardListGULViewAction$1.INSTANCE;
        CardListGULViewAction$2 r102 = CardListGULViewAction$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "scrollByOuterView");
        Intrinsics.checkNotNullParameter(r102, "getPageName");
        this.f171943a = r101;
        this.f171944b = r102;
    }
}
