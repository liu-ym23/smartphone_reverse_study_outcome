package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f63929a;

    public d(e r100) {
        this.f63929a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e r101 = this.f63929a;
        JsonObject r102 = new JsonObject();
        r102.add("tabInfo", (JsonElement) sh6.c.b((sh6.b) r100));
        Unit r103 = Unit.INSTANCE;
        r101.i(r102);
    }
}
