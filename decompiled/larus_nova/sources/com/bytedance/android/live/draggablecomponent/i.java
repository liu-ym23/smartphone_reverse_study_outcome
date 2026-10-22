package com.bytedance.android.live.draggablecomponent;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f66666a;

    public i(TextView r100) {
        this.f66666a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f66666a.setText((CharSequence) sh6.c.b((sh6.b) r100));
    }
}
