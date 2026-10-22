package com.bytedance.android.ec.sdk.plugin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginLoader f48165a;

    public k(PluginLoader r100) {
        this.f48165a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PluginLoader.a(this.f48165a);
        System.out.println("Django ==> plugin load fail: " + ((Throwable) r100));
    }
}
