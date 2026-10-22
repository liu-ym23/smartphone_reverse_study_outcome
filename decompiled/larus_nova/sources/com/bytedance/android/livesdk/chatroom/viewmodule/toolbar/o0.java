package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes8.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.e f116614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.f f116615b;

    public o0(i0.e r100, i0.g r101) {
        this.f116614a = r100;
        this.f116615b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i0.e r101 = this.f116614a;
        r101.f116342c = (JSONArray) r100;
        r101.f116343d = true;
        this.f116615b.onFinish();
    }
}
