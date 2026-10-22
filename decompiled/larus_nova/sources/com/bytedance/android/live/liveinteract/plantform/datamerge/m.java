package com.bytedance.android.live.liveinteract.plantform.datamerge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f76597a;

    public m(String r100) {
        this.f76597a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        int r102 = cj0.e.f23907h;
        rj0.h r103 = cj0.e.a.a();
        if (r103 == null) goto L5;
        r103.d();
    L5:
        xs2.b.a().post(new dh0.b(this.f76597a));
    }
}
