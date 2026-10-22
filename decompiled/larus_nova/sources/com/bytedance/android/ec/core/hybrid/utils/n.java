package com.bytedance.android.ec.core.hybrid.utils;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f44321a;

    public n(String r100) {
        this.f44321a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        JSONObject r102 = p.f44324a;
        p.e(new q("", 2), this.f44321a);
        p.a();
    }
}
