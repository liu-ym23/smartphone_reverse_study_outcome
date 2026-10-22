package com.bytedance.android.annie.service.prefetch;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f39964a;

    public f(d r100) {
        this.f39964a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        JSONObject r102 = (JSONObject) r101.component1();
        Object r103 = r101.component2();
        d r104 = this.f39964a;
        View r105 = r104.f39949c;
        if (r105 == null) goto L8;
        if (r103 == null) goto L8;
        r9.d r106 = r104.f39951e;
        if (r106 == null) goto L8;
        r106.updateData(r105, r103, false);
    L8:
        this.f39964a.j(r102);
    }
}
