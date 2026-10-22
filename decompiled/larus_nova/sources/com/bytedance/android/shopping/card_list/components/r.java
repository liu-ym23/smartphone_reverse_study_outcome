package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import com.bytedance.android.shopping.card_list.components.c;
import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r<VIEW_TYPE extends View, STATE extends c, ACTION extends q> extends SimpleScene<VIEW_TYPE, STATE, ACTION> {
    public r() {
    }

    public final void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ACTION r101 = (ACTION) r100.invoke();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f171452c = r101;
    }

    public final void b(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Function0<Unit> r101 = new SimpleSceneDsl$onCreate$1(this, r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f171453d = r101;
    }

    public final void c(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        STATE r101 = (STATE) r100.invoke();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f171451b = r101;
    }

    public final void d(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        STATE r101 = this.f171451b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        ACTION r102 = this.f171452c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L8:
        this.f171450a = (VIEW_TYPE) r100.invoke(r101, r102);
    }
}
