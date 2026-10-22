package com.bytedance.android.live.profit.taskcenter.preload;

import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f89065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f89066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f89067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f89068d;

    public g(d r100, JSONObject r101, long r102, String r103) {
        this.f89065a = r100;
        this.f89066b = r101;
        this.f89067c = r102;
        this.f89068d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        wp2.g r102 = new wp2.g(this.f89066b, new d.b(new WeakReference(this.f89065a), this.f89067c, this.f89068d));
        ((rq2.a) vh6.c.b(rq2.a.class)).yc(r102);
    }
}
