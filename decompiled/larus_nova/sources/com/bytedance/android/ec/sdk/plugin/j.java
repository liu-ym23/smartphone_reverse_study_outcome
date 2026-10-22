package com.bytedance.android.ec.sdk.plugin;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginLoader f48164a;

    public j(PluginLoader r100) {
        this.f48164a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f48164a.c();
        System.out.println("Django ==> plugin load success");
    }
}
