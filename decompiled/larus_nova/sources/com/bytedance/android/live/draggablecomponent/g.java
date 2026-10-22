package com.bytedance.android.live.draggablecomponent;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f66664a;

    public g(TextView r100) {
        this.f66664a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f66664a.setText((CharSequence) sh6.c.b((sh6.b) r100));
    }
}
