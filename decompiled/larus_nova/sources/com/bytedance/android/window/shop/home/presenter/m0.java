package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class m0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter f188569a;

    public m0(ECWindowDialogStyledBackgroundPresenter r100) {
        this.f188569a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        Bitmap r102 = (Bitmap) r101.component1();
        uq3.a r103 = (uq3.a) r101.component2();
        ECWindowDialogStyledBackgroundPresenter r104 = this.f188569a;
        uq3.o r105 = r103.f551204c;
        if (r105 == null) goto L5;
        String r106 = r105.f551258i;
    L6:
        r104.getClass();
        Pair r107 = ECWindowDialogStyledBackgroundPresenter.b0(r106);
        ECWindowDialogStyledBackgroundPresenter.a0(this.f188569a, r107, r102);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
