package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f144273a;

    public j(l r100) {
        this.f144273a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        this.f144273a.a();
    }
}
