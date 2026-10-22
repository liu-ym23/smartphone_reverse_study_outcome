package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f63797a;

    public c(a.c r100) {
        this.f63797a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        JSONObject r102 = (JSONObject) r101.component1();
        Object r103 = r101.component2();
        a r104 = this.f63797a.f63792a;
        View r105 = r104.f63783b;
        if (r105 == null) goto L6;
        if (r103 == null) goto L6;
        r104.f63788g.updateData(r105, r103, true);
    L6:
        this.f63797a.f63792a.j(r102);
    }
}
