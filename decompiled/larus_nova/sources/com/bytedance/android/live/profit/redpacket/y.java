package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f88771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f88772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zy0.c f88773c;

    public y(JSONObject r100, Ref.IntRef r101, zy0.b r102) {
        this.f88771a = r100;
        this.f88772b = r101;
        this.f88773c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f88771a.put("heart_beat", this.f88772b.element);
        this.f88772b.element++;
        xy0.a<?> r102 = this.f88773c.g();
        if (r102 == null) goto L6;
        r102.sendJsEvent("H5_webcastNotification", this.f88771a);
        return;
    }
}
