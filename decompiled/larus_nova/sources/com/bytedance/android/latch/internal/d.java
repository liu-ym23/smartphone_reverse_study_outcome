package com.bytedance.android.latch.internal;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58295a;

    public d(Function0<Unit> r100) {
        this.f58295a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        this.f58295a.invoke();
    }
}
