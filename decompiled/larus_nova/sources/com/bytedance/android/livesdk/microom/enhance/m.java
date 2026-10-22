package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f153873a;

    public m(o r100) {
        this.f153873a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l r101 = (l) r100;
        if (r101 != null) goto L5;
    L9:
        View r102 = this.f153873a.f153876b;
        if (r102 == null) goto L15;
        r102.setVisibility(8);
        return;
    L15:
        return;
    L5:
        if ((!r101.f153870a) != true) goto L9;
        View r103 = this.f153873a.f153876b;
        if (r103 == null) goto L13;
        r103.setVisibility(0);
        return;
    }
}
