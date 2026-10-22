package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f63961a;

    public b(d r100) {
        this.f63961a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d r101 = this.f63961a;
        JsonObject r102 = new JsonObject();
        r102.add("matchInfo", (JsonElement) sh6.c.b((sh6.b) r100));
        Unit r103 = Unit.INSTANCE;
        r101.h(r102);
    }
}
