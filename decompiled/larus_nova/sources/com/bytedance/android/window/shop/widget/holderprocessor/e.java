package com.bytedance.android.window.shop.widget.holderprocessor;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowGroupHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends gr3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<WindowLayoutType> f190039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Integer> f190040b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function0<? extends WindowLayoutType> r100, Function1<? super Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutTypeFetcher");
        Intrinsics.checkNotNullParameter(r101, "positionMapper");
        this.f190039a = r100;
        this.f190040b = r101;
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r100, com.bytedance.android.window.shop.repository.tab.entity.f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "vo");
        if ((r100 instanceof WindowLynxHolder) == false) goto L6;
        WindowLynxHolder r103 = (WindowLynxHolder) r100;
        WindowLayoutType r104 = this.f190039a.invoke();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f187877w = r104;
    L8:
        s.c(r101, this.f190040b.invoke(Integer.valueOf(r102)).intValue());
        return;
    L6:
        if ((r100 instanceof WindowGroupHolder) == false) goto L8;
        ((WindowGroupHolder) r100).u4(this.f190039a.invoke());
        goto L8
    }
}
