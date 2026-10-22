package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f152761a;

    public a(b r100) {
        this.f152761a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        b r102 = this.f152761a;
        Function2<? super yk2.a, ? super Boolean, Unit> r103 = r102.f152763b;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(r102, Boolean.valueOf(r102.f152764c));
    L6:
        if (r102.f152764c == false) goto L9;
        r102.f152767f.playAnimation();
        return;
    }
}
